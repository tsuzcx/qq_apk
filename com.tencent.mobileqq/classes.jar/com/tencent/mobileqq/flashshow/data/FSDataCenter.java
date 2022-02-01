package com.tencent.mobileqq.flashshow.data;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.data.update.FSFeedConverter;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.BaseDataCenter;
import com.tencent.richframework.data.base.DataObserverWrapper;
import com.tencent.richframework.data.idata.IDataWorker;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FSDataCenter
  extends BaseDataCenter<FSFeedData>
{
  private static volatile FSDataCenter g;
  private final Map<String, MutableLiveData<FSUserStateData>> h = new ConcurrentHashMap();
  private final Map<String, Set<Integer>> i = new ConcurrentHashMap();
  private final MutableLiveData<FSRecentlyFeedStateData> j = new MutableLiveData();
  private final Set<Integer> k = new HashSet();
  private final Set<IDataWorker> l = new HashSet();
  
  private FSDataCenter()
  {
    f();
    this.a.put("FSFeedDataStore", new FSFeedDataStore(this));
    a(new FSFeedConverter());
  }
  
  public static FSDataCenter a()
  {
    if (g == null) {
      try
      {
        if (g == null) {
          g = new FSDataCenter();
        }
      }
      finally {}
    }
    return g;
  }
  
  private void a(int paramInt)
  {
    MutableLiveData localMutableLiveData = a(FSTransUtils.a());
    if (localMutableLiveData != null)
    {
      if (localMutableLiveData.getValue() == null) {
        return;
      }
      FSUserStateData localFSUserStateData = (FSUserStateData)localMutableLiveData.getValue();
      boolean bool = FSCommonUtil.a(paramInt);
      paramInt = localFSUserStateData.d();
      if (bool) {
        paramInt += 1;
      } else {
        paramInt -= 1;
      }
      localFSUserStateData.b(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateLoginUserFollowState followNum = ");
      localStringBuilder.append(localFSUserStateData.d());
      QLog.d("FSDataCenter", 4, localStringBuilder.toString());
      localMutableLiveData.setValue(localFSUserStateData);
    }
  }
  
  public static void c()
  {
    g = null;
  }
  
  private void f() {}
  
  private void g()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      return;
    }
    throw new RuntimeException("Current Thread is not MainThread");
  }
  
  public MutableLiveData<FSUserStateData> a(String paramString)
  {
    return (MutableLiveData)this.h.get(paramString);
  }
  
  public MutableLiveData<FSUserStateData> a(String paramString, FSUserStateData paramFSUserStateData)
  {
    g();
    MutableLiveData localMutableLiveData2 = a(paramString);
    MutableLiveData localMutableLiveData1 = localMutableLiveData2;
    if (localMutableLiveData2 == null)
    {
      localMutableLiveData1 = new MutableLiveData();
      localMutableLiveData1.setValue(paramFSUserStateData);
      this.h.put(paramString, localMutableLiveData1);
    }
    return localMutableLiveData1;
  }
  
  public String a(FSFeedData paramFSFeedData)
  {
    if ((paramFSFeedData != null) && (paramFSFeedData.b() != null)) {
      return paramFSFeedData.b().id.get();
    }
    return "";
  }
  
  public void a(Observer<FSRecentlyFeedStateData> paramObserver)
  {
    if (!this.k.contains(Integer.valueOf(paramObserver.hashCode())))
    {
      this.k.add(Integer.valueOf(paramObserver.hashCode()));
      this.j.observeForever(new DataObserverWrapper(paramObserver));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    FSUserStateData localFSUserStateData = new FSUserStateData(paramString);
    localFSUserStateData.a(paramInt);
    MutableLiveData localMutableLiveData = a(paramString);
    if (localMutableLiveData == null)
    {
      a(paramString, localFSUserStateData);
      a(paramInt);
      return;
    }
    paramString = (FSUserStateData)localMutableLiveData.getValue();
    if (paramString != null)
    {
      if (paramString.c() == paramInt) {
        return;
      }
      paramString.a(paramInt);
      boolean bool = FSCommonUtil.a(paramInt);
      int m = paramString.e();
      if (bool) {
        m += 1;
      } else {
        m -= 1;
      }
      paramString.c(m);
      localMutableLiveData.setValue(paramString);
      a(paramInt);
    }
  }
  
  public void a(String paramString, Observer<? super FSUserStateData> paramObserver)
  {
    paramString = a(paramString);
    if (b(paramObserver)) {
      paramString.observeForever(paramObserver);
    }
  }
  
  public MutableLiveData<FSRecentlyFeedStateData> b()
  {
    return this.j;
  }
  
  public void b(String paramString, Observer<FSUserStateData> paramObserver)
  {
    if (c(paramString, paramObserver)) {
      a(paramString).observeForever(new DataObserverWrapper(paramObserver));
    }
  }
  
  public boolean c(String paramString, Observer paramObserver)
  {
    Set localSet = (Set)this.i.get(paramString);
    Object localObject;
    if (localSet == null)
    {
      localObject = new HashSet();
    }
    else
    {
      localObject = localSet;
      if (localSet.contains(Integer.valueOf(paramObserver.hashCode())))
      {
        QLog.d("FSDataCenter", 1, "allReady observer");
        return false;
      }
    }
    ((Set)localObject).add(Integer.valueOf(paramObserver.hashCode()));
    this.i.put(paramString, localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.FSDataCenter
 * JD-Core Version:    0.7.0.1
 */