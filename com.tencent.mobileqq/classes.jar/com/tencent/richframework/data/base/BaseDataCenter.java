package com.tencent.richframework.data.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.richframework.data.idata.IDataCenter;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.data.idata.IDataWorker;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseDataCenter<T>
  implements IDataCenter<T>
{
  protected final Map<String, IDataStore<T>> a = new ConcurrentHashMap();
  protected final Set<IDataWorker> b = new HashSet();
  protected final Map<String, WeakReference<IDataDisplaySurface<T>>> c = new ConcurrentHashMap();
  protected final Map<String, IDataConverter> d = new ConcurrentHashMap();
  protected final Map<String, MutableLiveData> e = new ConcurrentHashMap();
  protected final Handler f = new Handler(Looper.getMainLooper());
  private final Map<String, DataObserverWrapper> g = new HashMap();
  private final Map<DataObserverWrapper, MutableLiveData> h = new HashMap();
  
  private <S> IDataConverter<S> a(Class<S> paramClass)
  {
    IDataConverter localIDataConverter = (IDataConverter)this.d.get(paramClass.getName());
    if (localIDataConverter == null)
    {
      a(String.format("can't not find Class implements IDataConverter<%s> register in data center", new Object[] { paramClass.getName() }));
      return null;
    }
    return localIDataConverter;
  }
  
  private static <S> String a(@NonNull IDataConverter<S> paramIDataConverter, @NonNull Observer<S> paramObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(paramIDataConverter));
    localStringBuilder.append(paramObserver.hashCode());
    return localStringBuilder.toString();
  }
  
  private <S> void a(MutableLiveData<S> paramMutableLiveData, S paramS)
  {
    this.f.post(new BaseDataCenter.2(this, paramMutableLiveData, paramS));
  }
  
  private <S> void a(IDataConverter<S> paramIDataConverter, MutableLiveData<S> paramMutableLiveData, S paramS, Observer<S> paramObserver)
  {
    if (!b(paramObserver)) {
      return;
    }
    if (paramIDataConverter != null)
    {
      if (paramMutableLiveData == null) {
        return;
      }
      DataObserverWrapper localDataObserverWrapper = (DataObserverWrapper)this.g.get(a(paramIDataConverter, paramObserver));
      if (localDataObserverWrapper != null)
      {
        MutableLiveData localMutableLiveData = (MutableLiveData)this.h.get(localDataObserverWrapper);
        if (localMutableLiveData == paramMutableLiveData) {
          return;
        }
        if (localMutableLiveData != null) {
          localMutableLiveData.removeObserver(localDataObserverWrapper);
        }
      }
      paramS = new BaseDataCenter.3(this, paramObserver, paramS, paramIDataConverter);
      this.g.put(a(paramIDataConverter, paramObserver), paramS);
      this.h.put(paramS, paramMutableLiveData);
      paramMutableLiveData.observeForever(paramS);
    }
  }
  
  private static void a(String paramString) {}
  
  protected static String b(@NonNull IDataConverter paramIDataConverter)
  {
    paramIDataConverter = paramIDataConverter.getClass().getGenericInterfaces();
    if (paramIDataConverter != null)
    {
      if (paramIDataConverter.length < 1) {
        return null;
      }
      if (!(paramIDataConverter[0] instanceof ParameterizedType)) {
        return null;
      }
      paramIDataConverter = ((ParameterizedType)paramIDataConverter[0]).getActualTypeArguments();
      if (paramIDataConverter.length != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fromAndToClass.length");
        localStringBuilder.append(paramIDataConverter.length);
        Log.d("BaseDataCenter", localStringBuilder.toString());
        return null;
      }
      return ((Class)paramIDataConverter[0]).getName();
    }
    return null;
  }
  
  private static String b(Class paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramClass.getName());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  protected static boolean b(Observer paramObserver)
  {
    if (!paramObserver.getClass().isAnonymousClass())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("observe feedStateData :");
      localStringBuilder.append(paramObserver.getClass().getName());
      Log.i("BaseDataCenter", localStringBuilder.toString());
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("observe not support anonymousClass :");
    localStringBuilder.append(paramObserver.getClass().getName());
    Log.e("BaseDataCenter", localStringBuilder.toString(), new RuntimeException());
    return false;
  }
  
  public <S> MutableLiveData<S> a(Class<S> paramClass, String paramString)
  {
    return (MutableLiveData)this.e.get(b(paramClass, paramString));
  }
  
  public T a(String paramString1, String paramString2)
  {
    paramString1 = (IDataStore)e().get(paramString1);
    if (paramString1 != null) {
      return paramString1.b().get(paramString2);
    }
    return null;
  }
  
  public void a(@NonNull IDataConverter paramIDataConverter)
  {
    String str = b(paramIDataConverter);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.d.put(str, paramIDataConverter);
  }
  
  public <S> void a(S paramS, Observer<S> paramObserver)
  {
    Object localObject = paramS.getClass();
    IDataConverter localIDataConverter = a((Class)localObject);
    if (TextUtils.isEmpty(localIDataConverter.a(paramS)))
    {
      a("must define observer key");
      return;
    }
    String str = b((Class)localObject, localIDataConverter.a(paramS));
    MutableLiveData localMutableLiveData = (MutableLiveData)this.e.get(str);
    localObject = localMutableLiveData;
    if (localMutableLiveData == null)
    {
      localObject = new MutableLiveData();
      a((MutableLiveData)localObject, paramS);
      this.e.put(str, localObject);
    }
    if (paramObserver == null) {
      return;
    }
    a(localIDataConverter, (MutableLiveData)localObject, paramS, paramObserver);
  }
  
  public <S> void a(S paramS, boolean paramBoolean)
  {
    Object localObject = paramS.getClass();
    IDataConverter localIDataConverter = a((Class)localObject);
    if (TextUtils.isEmpty(localIDataConverter.a(paramS)))
    {
      a("must define observer key");
      return;
    }
    localObject = b((Class)localObject, localIDataConverter.a(paramS));
    this.f.post(new BaseDataCenter.1(this, (String)localObject, paramS, paramBoolean, localIDataConverter));
  }
  
  public void a(String paramString, IDataDisplaySurface<T> paramIDataDisplaySurface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramIDataDisplaySurface != null))
    {
      paramIDataDisplaySurface = new WeakReference(paramIDataDisplaySurface);
      this.c.put(paramString, paramIDataDisplaySurface);
      return;
    }
    a("can't register displaySurface with empty key or null object");
  }
  
  public void a(String paramString, T paramT)
  {
    paramString = (IDataStore)this.a.get(paramString);
    if (paramString != null) {
      paramString.a(paramT);
    }
  }
  
  public <S> void a(List<S> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramList.next(), paramBoolean);
    }
  }
  
  public void b(String paramString, List<T> paramList)
  {
    paramString = (IDataStore)this.a.get(paramString);
    if (paramString != null) {
      paramString.a(paramList);
    }
  }
  
  public IDataDisplaySurface<T> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (WeakReference)this.c.get(paramString);
    if (paramString != null) {
      return (IDataDisplaySurface)paramString.get();
    }
    return null;
  }
  
  public void c(String paramString, List<T> paramList)
  {
    paramString = (IDataStore)this.a.get(paramString);
    if (paramString != null) {
      paramString.b(paramList);
    }
  }
  
  public Collection<IDataDisplaySurface<T>> d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
    {
      IDataDisplaySurface localIDataDisplaySurface = (IDataDisplaySurface)((WeakReference)localIterator.next()).get();
      if (localIDataDisplaySurface != null) {
        localArrayList.add(localIDataDisplaySurface);
      }
    }
    return localArrayList;
  }
  
  public Map<String, IDataStore<T>> e()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.BaseDataCenter
 * JD-Core Version:    0.7.0.1
 */