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
    String str1 = paramClass.getSimpleName();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("rxjava.plugin.");
    ((StringBuilder)localObject1).append(str1);
    ((StringBuilder)localObject1).append(".implementation");
    localObject1 = paramProperties.getProperty(((StringBuilder)localObject1).toString());
    if (localObject1 == null)
    {
      Object localObject2 = paramProperties.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        String str2 = localEntry.getKey().toString();
        if ((str2.startsWith("rxjava.plugin.")) && (str2.endsWith(".class")) && (str1.equals(localEntry.getValue().toString())))
        {
          localObject1 = str2.substring(0, str2.length() - 6).substring(14);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("rxjava.plugin.");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(".impl");
          localObject1 = ((StringBuilder)localObject2).toString();
          paramProperties = paramProperties.getProperty((String)localObject1);
          if (paramProperties != null) {
            break label247;
          }
          paramClass = new StringBuilder();
          paramClass.append("Implementing class declaration for ");
          paramClass.append(str1);
          paramClass.append(" missing: ");
          paramClass.append((String)localObject1);
          throw new RuntimeException(paramClass.toString());
        }
      }
    }
    paramProperties = (Properties)localObject1;
    label247:
    if (paramProperties != null) {}
    try
    {
      paramClass = Class.forName(paramProperties).asSubclass(paramClass).newInstance();
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" implementation not able to be accessed: ");
      ((StringBuilder)localObject1).append(paramProperties);
      throw new RuntimeException(((StringBuilder)localObject1).toString(), paramClass);
    }
    catch (InstantiationException paramClass)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" implementation not able to be instantiated: ");
      ((StringBuilder)localObject1).append(paramProperties);
      throw new RuntimeException(((StringBuilder)localObject1).toString(), paramClass);
    }
    catch (ClassNotFoundException paramClass)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" implementation class not found: ");
      ((StringBuilder)localObject1).append(paramProperties);
      throw new RuntimeException(((StringBuilder)localObject1).toString(), paramClass);
      paramClass = new StringBuilder();
      paramClass.append(str1);
      paramClass.append(" implementation is not an instance of ");
      paramClass.append(str1);
      paramClass.append(": ");
      paramClass.append(paramProperties);
      throw new RuntimeException(paramClass.toString());
      return null;
    }
    catch (ClassCastException paramClass)
    {
      label388:
      break label388;
    }
  }
  
  public RxJavaErrorHandler getErrorHandler()
  {
    if (this.errorHandler.get() == null)
    {
      Object localObject = getPluginImplementationViaProperty(RxJavaErrorHandler.class, System.getProperties());
      if (localObject == null) {
        this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
      } else {
        this.errorHandler.compareAndSet(null, (RxJavaErrorHandler)localObject);
      }
    }
    return (RxJavaErrorHandler)this.errorHandler.get();
  }
  
  public RxJavaObservableExecutionHook getObservableExecutionHook()
  {
    if (this.observableExecutionHook.get() == null)
    {
      Object localObject = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, System.getProperties());
      if (localObject == null) {
        this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
      } else {
        this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook)localObject);
      }
    }
    return (RxJavaObservableExecutionHook)this.observableExecutionHook.get();
  }
  
  public RxJavaSchedulersHook getSchedulersHook()
  {
    if (this.schedulersHook.get() == null)
    {
      Object localObject = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, System.getProperties());
      if (localObject == null) {
        this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
      } else {
        this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook)localObject);
      }
    }
    return (RxJavaSchedulersHook)this.schedulersHook.get();
  }
  
  public RxJavaSingleExecutionHook getSingleExecutionHook()
  {
    if (this.singleExecutionHook.get() == null)
    {
      Object localObject = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, System.getProperties());
      if (localObject == null) {
        this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
      } else {
        this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook)localObject);
      }
    }
    return (RxJavaSingleExecutionHook)this.singleExecutionHook.get();
  }
  
  public void registerErrorHandler(RxJavaErrorHandler paramRxJavaErrorHandler)
  {
    if (this.errorHandler.compareAndSet(null, paramRxJavaErrorHandler)) {
      return;
    }
    paramRxJavaErrorHandler = new StringBuilder();
    paramRxJavaErrorHandler.append("Another strategy was already registered: ");
    paramRxJavaErrorHandler.append(this.errorHandler.get());
    throw new IllegalStateException(paramRxJavaErrorHandler.toString());
  }
  
  public void registerObservableExecutionHook(RxJavaObservableExecutionHook paramRxJavaObservableExecutionHook)
  {
    if (this.observableExecutionHook.compareAndSet(null, paramRxJavaObservableExecutionHook)) {
      return;
    }
    paramRxJavaObservableExecutionHook = new StringBuilder();
    paramRxJavaObservableExecutionHook.append("Another strategy was already registered: ");
    paramRxJavaObservableExecutionHook.append(this.observableExecutionHook.get());
    throw new IllegalStateException(paramRxJavaObservableExecutionHook.toString());
  }
  
  public void registerSchedulersHook(RxJavaSchedulersHook paramRxJavaSchedulersHook)
  {
    if (this.schedulersHook.compareAndSet(null, paramRxJavaSchedulersHook)) {
      return;
    }
    paramRxJavaSchedulersHook = new StringBuilder();
    paramRxJavaSchedulersHook.append("Another strategy was already registered: ");
    paramRxJavaSchedulersHook.append(this.schedulersHook.get());
    throw new IllegalStateException(paramRxJavaSchedulersHook.toString());
  }
  
  public void registerSingleExecutionHook(RxJavaSingleExecutionHook paramRxJavaSingleExecutionHook)
  {
    if (this.singleExecutionHook.compareAndSet(null, paramRxJavaSingleExecutionHook)) {
      return;
    }
    paramRxJavaSingleExecutionHook = new StringBuilder();
    paramRxJavaSingleExecutionHook.append("Another strategy was already registered: ");
    paramRxJavaSingleExecutionHook.append(this.singleExecutionHook.get());
    throw new IllegalStateException(paramRxJavaSingleExecutionHook.toString());
  }
  
  void reset()
  {
    INSTANCE.errorHandler.set(null);
    INSTANCE.observableExecutionHook.set(null);
    INSTANCE.singleExecutionHook.set(null);
    INSTANCE.schedulersHook.set(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.plugins.RxJavaPlugins
 * JD-Core Version:    0.7.0.1
 */