package rx.plugins;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins
{
  static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaPlugins.1();
  private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
  private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference();
  private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference();
  private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference();
  private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference();
  
  public static RxJavaPlugins getInstance()
  {
    return INSTANCE;
  }
  
  static Object getPluginImplementationViaProperty(Class<?> paramClass, Properties paramProperties)
  {
    String str2 = paramClass.getSimpleName();
    String str1 = paramProperties.getProperty("rxjava.plugin." + str2 + ".implementation");
    Object localObject = str1;
    if (str1 == null)
    {
      Iterator localIterator = paramProperties.entrySet().iterator();
      String str3;
      do
      {
        localObject = str1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        str3 = ((Map.Entry)localObject).getKey().toString();
      } while ((!str3.startsWith("rxjava.plugin.")) || (!str3.endsWith(".class")) || (!str2.equals(((Map.Entry)localObject).getValue().toString())));
      localObject = str3.substring(0, str3.length() - ".class".length()).substring("rxjava.plugin.".length());
      str1 = "rxjava.plugin." + (String)localObject + ".impl";
      localObject = paramProperties.getProperty(str1);
      if (localObject == null) {
        throw new RuntimeException("Implementing class declaration for " + str2 + " missing: " + str1);
      }
    }
    if (localObject != null) {
      try
      {
        paramClass = Class.forName((String)localObject).asSubclass(paramClass).newInstance();
        return paramClass;
      }
      catch (ClassCastException paramClass)
      {
        throw new RuntimeException(str2 + " implementation is not an instance of " + str2 + ": " + (String)localObject);
      }
      catch (ClassNotFoundException paramClass)
      {
        throw new RuntimeException(str2 + " implementation class not found: " + (String)localObject, paramClass);
      }
      catch (InstantiationException paramClass)
      {
        throw new RuntimeException(str2 + " implementation not able to be instantiated: " + (String)localObject, paramClass);
      }
      catch (IllegalAccessException paramClass)
      {
        throw new RuntimeException(str2 + " implementation not able to be accessed: " + (String)localObject, paramClass);
      }
    }
    return null;
  }
  
  public RxJavaErrorHandler getErrorHandler()
  {
    Object localObject;
    if (this.errorHandler.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
    }
    for (;;)
    {
      return (RxJavaErrorHandler)this.errorHandler.get();
      label46:
      this.errorHandler.compareAndSet(null, (RxJavaErrorHandler)localObject);
    }
  }
  
  public RxJavaObservableExecutionHook getObservableExecutionHook()
  {
    Object localObject;
    if (this.observableExecutionHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
    }
    for (;;)
    {
      return (RxJavaObservableExecutionHook)this.observableExecutionHook.get();
      label46:
      this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook)localObject);
    }
  }
  
  public RxJavaSchedulersHook getSchedulersHook()
  {
    Object localObject;
    if (this.schedulersHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
    }
    for (;;)
    {
      return (RxJavaSchedulersHook)this.schedulersHook.get();
      label46:
      this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook)localObject);
    }
  }
  
  public RxJavaSingleExecutionHook getSingleExecutionHook()
  {
    Object localObject;
    if (this.singleExecutionHook.get() == null)
    {
      localObject = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
      if (localObject != null) {
        break label46;
      }
      this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
    }
    for (;;)
    {
      return (RxJavaSingleExecutionHook)this.singleExecutionHook.get();
      label46:
      this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook)localObject);
    }
  }
  
  public void registerErrorHandler(RxJavaErrorHandler paramRxJavaErrorHandler)
  {
    if (!this.errorHandler.compareAndSet(null, paramRxJavaErrorHandler)) {
      throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
    }
  }
  
  public void registerObservableExecutionHook(RxJavaObservableExecutionHook paramRxJavaObservableExecutionHook)
  {
    if (!this.observableExecutionHook.compareAndSet(null, paramRxJavaObservableExecutionHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
    }
  }
  
  public void registerSchedulersHook(RxJavaSchedulersHook paramRxJavaSchedulersHook)
  {
    if (!this.schedulersHook.compareAndSet(null, paramRxJavaSchedulersHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
    }
  }
  
  public void registerSingleExecutionHook(RxJavaSingleExecutionHook paramRxJavaSingleExecutionHook)
  {
    if (!this.singleExecutionHook.compareAndSet(null, paramRxJavaSingleExecutionHook)) {
      throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
    }
  }
  
  void reset()
  {
    INSTANCE.errorHandler.set(null);
    INSTANCE.observableExecutionHook.set(null);
    INSTANCE.singleExecutionHook.set(null);
    INSTANCE.schedulersHook.set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.plugins.RxJavaPlugins
 * JD-Core Version:    0.7.0.1
 */