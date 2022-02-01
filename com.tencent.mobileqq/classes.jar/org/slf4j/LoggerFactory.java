package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

public final class LoggerFactory
{
  private static final String[] API_COMPATIBILITY_LIST = { "1.6", "1.7" };
  static final String CODES_PREFIX = "http://www.slf4j.org/codes.html";
  static boolean DETECT_LOGGER_NAME_MISMATCH = false;
  static final String DETECT_LOGGER_NAME_MISMATCH_PROPERTY = "slf4j.detectLoggerNameMismatch";
  static final int FAILED_INITIALIZATION = 2;
  static volatile int INITIALIZATION_STATE = 0;
  static final String JAVA_VENDOR_PROPERTY = "java.vendor.url";
  static final String LOGGER_NAME_MISMATCH_URL = "http://www.slf4j.org/codes.html#loggerNameMismatch";
  static final String MULTIPLE_BINDINGS_URL = "http://www.slf4j.org/codes.html#multiple_bindings";
  static final NOPLoggerFactory NOP_FALLBACK_FACTORY;
  static final int NOP_FALLBACK_INITIALIZATION = 4;
  static final String NO_STATICLOGGERBINDER_URL = "http://www.slf4j.org/codes.html#StaticLoggerBinder";
  static final String NULL_LF_URL = "http://www.slf4j.org/codes.html#null_LF";
  static final int ONGOING_INITIALIZATION = 1;
  static final String REPLAY_URL = "http://www.slf4j.org/codes.html#replay";
  private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
  static final String SUBSTITUTE_LOGGER_URL = "http://www.slf4j.org/codes.html#substituteLogger";
  static final SubstituteLoggerFactory SUBST_FACTORY = new SubstituteLoggerFactory();
  static final int SUCCESSFUL_INITIALIZATION = 3;
  static final int UNINITIALIZED = 0;
  static final String UNSUCCESSFUL_INIT_MSG = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";
  static final String UNSUCCESSFUL_INIT_URL = "http://www.slf4j.org/codes.html#unsuccessfulInit";
  static final String VERSION_MISMATCH = "http://www.slf4j.org/codes.html#version_mismatch";
  
  static
  {
    NOP_FALLBACK_FACTORY = new NOPLoggerFactory();
    DETECT_LOGGER_NAME_MISMATCH = Util.safeGetBooleanSystemProperty("slf4j.detectLoggerNameMismatch");
  }
  
  private static final void bind()
  {
    Set localSet = null;
    try
    {
      if (!isAndroid())
      {
        localSet = findPossibleStaticLoggerBinderPathSet();
        reportMultipleBindingAmbiguity(localSet);
      }
      StaticLoggerBinder.getSingleton();
      INITIALIZATION_STATE = 3;
      reportActualBinding(localSet);
      fixSubstituteLoggers();
      replayEvents();
      SUBST_FACTORY.clear();
      return;
    }
    catch (Exception localException)
    {
      failedBinding(localException);
      throw new IllegalStateException("Unexpected initialization failure", localException);
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      String str = localNoSuchMethodError.getMessage();
      if ((str != null) && (str.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")))
      {
        INITIALIZATION_STATE = 2;
        Util.report("slf4j-api 1.6.x (or later) is incompatible with this binding.");
        Util.report("Your binding is version 1.5.5 or earlier.");
        Util.report("Upgrade your binding to version 1.6.x.");
      }
      throw localNoSuchMethodError;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      if (messageContainsOrgSlf4jImplStaticLoggerBinder(localNoClassDefFoundError.getMessage()))
      {
        INITIALIZATION_STATE = 4;
        Util.report("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
        Util.report("Defaulting to no-operation (NOP) logger implementation");
        Util.report("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        return;
      }
      failedBinding(localNoClassDefFoundError);
      throw localNoClassDefFoundError;
    }
  }
  
  private static void emitReplayOrSubstituionWarning(SubstituteLoggingEvent paramSubstituteLoggingEvent, int paramInt)
  {
    if (paramSubstituteLoggingEvent.getLogger().isDelegateEventAware())
    {
      emitReplayWarning(paramInt);
      return;
    }
    if (paramSubstituteLoggingEvent.getLogger().isDelegateNOP()) {
      return;
    }
    emitSubstitutionWarning();
  }
  
  private static void emitReplayWarning(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("A number (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(") of logging calls during the initialization phase have been intercepted and are");
    Util.report(localStringBuilder.toString());
    Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
    Util.report("See also http://www.slf4j.org/codes.html#replay");
  }
  
  private static void emitSubstitutionWarning()
  {
    Util.report("The following set of substitute loggers may have been accessed");
    Util.report("during the initialization phase. Logging calls during this");
    Util.report("phase were not honored. However, subsequent logging calls to these");
    Util.report("loggers will work as normally expected.");
    Util.report("See also http://www.slf4j.org/codes.html#substituteLogger");
  }
  
  static void failedBinding(Throwable paramThrowable)
  {
    INITIALIZATION_STATE = 2;
    Util.report("Failed to instantiate SLF4J LoggerFactory", paramThrowable);
  }
  
  static Set<URL> findPossibleStaticLoggerBinderPathSet()
  {
    localLinkedHashSet = new LinkedHashSet();
    try
    {
      Object localObject = LoggerFactory.class.getClassLoader();
      if (localObject == null) {
        localObject = ClassLoader.getSystemResources(STATIC_LOGGER_BINDER_PATH);
      } else {
        localObject = ((ClassLoader)localObject).getResources(STATIC_LOGGER_BINDER_PATH);
      }
      while (((Enumeration)localObject).hasMoreElements()) {
        localLinkedHashSet.add((URL)((Enumeration)localObject).nextElement());
      }
      return localLinkedHashSet;
    }
    catch (IOException localIOException)
    {
      Util.report("Error getting resources from path", localIOException);
    }
  }
  
  private static void fixSubstituteLoggers()
  {
    synchronized (SUBST_FACTORY)
    {
      SUBST_FACTORY.postInitialization();
      Iterator localIterator = SUBST_FACTORY.getLoggers().iterator();
      while (localIterator.hasNext())
      {
        SubstituteLogger localSubstituteLogger = (SubstituteLogger)localIterator.next();
        localSubstituteLogger.setDelegate(getLogger(localSubstituteLogger.getName()));
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static ILoggerFactory getILoggerFactory()
  {
    if (INITIALIZATION_STATE == 0) {
      try
      {
        if (INITIALIZATION_STATE == 0)
        {
          INITIALIZATION_STATE = 1;
          performInitialization();
        }
      }
      finally {}
    }
    int i = INITIALIZATION_STATE;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return NOP_FALLBACK_FACTORY;
          }
          throw new IllegalStateException("Unreachable code");
        }
        return StaticLoggerBinder.getSingleton().getLoggerFactory();
      }
      throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
    }
    return SUBST_FACTORY;
  }
  
  public static Logger getLogger(Class<?> paramClass)
  {
    Logger localLogger = getLogger(paramClass.getName());
    if (DETECT_LOGGER_NAME_MISMATCH)
    {
      Class localClass = Util.getCallingClass();
      if ((localClass != null) && (nonMatchingClasses(paramClass, localClass)))
      {
        Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[] { localLogger.getName(), localClass.getName() }));
        Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
      }
    }
    return localLogger;
  }
  
  public static Logger getLogger(String paramString)
  {
    return getILoggerFactory().getLogger(paramString);
  }
  
  private static boolean isAmbiguousStaticLoggerBinderPathSet(Set<URL> paramSet)
  {
    return paramSet.size() > 1;
  }
  
  private static boolean isAndroid()
  {
    String str = Util.safeGetSystemProperty("java.vendor.url");
    if (str == null) {
      return false;
    }
    return str.toLowerCase().contains("android");
  }
  
  private static boolean messageContainsOrgSlf4jImplStaticLoggerBinder(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    if (paramString.contains("org/slf4j/impl/StaticLoggerBinder")) {
      return true;
    }
    return paramString.contains("org.slf4j.impl.StaticLoggerBinder");
  }
  
  private static boolean nonMatchingClasses(Class<?> paramClass1, Class<?> paramClass2)
  {
    return paramClass2.isAssignableFrom(paramClass1) ^ true;
  }
  
  private static final void performInitialization()
  {
    
    if (INITIALIZATION_STATE == 3) {
      versionSanityCheck();
    }
  }
  
  private static void replayEvents()
  {
    LinkedBlockingQueue localLinkedBlockingQueue = SUBST_FACTORY.getEventQueue();
    int j = localLinkedBlockingQueue.size();
    ArrayList localArrayList = new ArrayList(128);
    int i = 0;
    for (;;)
    {
      if (localLinkedBlockingQueue.drainTo(localArrayList, 128) == 0) {
        return;
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        SubstituteLoggingEvent localSubstituteLoggingEvent = (SubstituteLoggingEvent)localIterator.next();
        replaySingleEvent(localSubstituteLoggingEvent);
        if (i == 0) {
          emitReplayOrSubstituionWarning(localSubstituteLoggingEvent, j);
        }
        i += 1;
      }
      localArrayList.clear();
    }
  }
  
  private static void replaySingleEvent(SubstituteLoggingEvent paramSubstituteLoggingEvent)
  {
    if (paramSubstituteLoggingEvent == null) {
      return;
    }
    SubstituteLogger localSubstituteLogger = paramSubstituteLoggingEvent.getLogger();
    String str = localSubstituteLogger.getName();
    if (!localSubstituteLogger.isDelegateNull())
    {
      if (localSubstituteLogger.isDelegateNOP()) {
        return;
      }
      if (localSubstituteLogger.isDelegateEventAware())
      {
        localSubstituteLogger.log(paramSubstituteLoggingEvent);
        return;
      }
      Util.report(str);
      return;
    }
    throw new IllegalStateException("Delegate logger cannot be null at this state.");
  }
  
  private static void reportActualBinding(Set<URL> paramSet)
  {
    if ((paramSet != null) && (isAmbiguousStaticLoggerBinderPathSet(paramSet)))
    {
      paramSet = new StringBuilder();
      paramSet.append("Actual binding is of type [");
      paramSet.append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr());
      paramSet.append("]");
      Util.report(paramSet.toString());
    }
  }
  
  private static void reportMultipleBindingAmbiguity(Set<URL> paramSet)
  {
    if (isAmbiguousStaticLoggerBinderPathSet(paramSet))
    {
      Util.report("Class path contains multiple SLF4J bindings.");
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        URL localURL = (URL)paramSet.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Found binding in [");
        localStringBuilder.append(localURL);
        localStringBuilder.append("]");
        Util.report(localStringBuilder.toString());
      }
      Util.report("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
    }
  }
  
  static void reset()
  {
    INITIALIZATION_STATE = 0;
  }
  
  private static final void versionSanityCheck()
  {
    for (;;)
    {
      int i;
      try
      {
        String str = StaticLoggerBinder.REQUESTED_API_VERSION;
        Object localObject = API_COMPATIBILITY_LIST;
        int k = localObject.length;
        i = 0;
        int j = 0;
        if (i < k)
        {
          if (str.startsWith(localObject[i])) {
            j = 1;
          }
        }
        else if (j == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("The requested version ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" by your slf4j binding is not compatible with ");
          ((StringBuilder)localObject).append(Arrays.asList(API_COMPATIBILITY_LIST).toString());
          Util.report(((StringBuilder)localObject).toString());
          Util.report("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Util.report("Unexpected problem occured during version sanity check", localThrowable);
        return;
      }
      catch (NoSuchFieldError localNoSuchFieldError)
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.slf4j.LoggerFactory
 * JD-Core Version:    0.7.0.1
 */