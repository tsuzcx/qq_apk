package com.tencent.mobileqq.flashshow.personal.viewmodel;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSUserStateData;
import com.tencent.mobileqq.flashshow.data.call.FSRequestCall;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalInfo;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalTab;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSGetFeedListUIStateManager;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSGetMainUIStateManager;
import com.tencent.mobileqq.flashshow.personal.interceptor.FSUserInfoRspInterceptor;
import com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest;
import com.tencent.mobileqq.flashshow.personal.request.FSGetFeedListLikeRequest.Builder;
import com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest;
import com.tencent.mobileqq.flashshow.personal.request.FSGetMainPageRequest.Builder;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.flashshow.sender.FSRequestSender;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;
import com.tencent.mobileqq.flashshow.utils.FSTextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.BaseCall;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSPersonalViewModel
  extends BaseViewModel
  implements IDataDisplaySurface<FSFeedData>, Call.OnRspCallBack<FSBaseRequest>
{
  private FeedCloudMeta.StUser a = null;
  private final FSGetMainUIStateManager b = new FSGetMainUIStateManager();
  private final FSGetFeedListUIStateManager c = new FSGetFeedListUIStateManager();
  private final MutableLiveData<FSPersonalInfo> d = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FSFeedData>>> e = new MutableLiveData();
  private final MutableLiveData<UIStateData<List<FSFeedData>>> f = new MutableLiveData();
  private final MutableLiveData<ArrayList<FSPersonalTab>> g = new MutableLiveData();
  private volatile boolean h = false;
  private volatile boolean i = false;
  
  private void a(int paramInt)
  {
    FSPersonalInfo localFSPersonalInfo = (FSPersonalInfo)this.d.getValue();
    if (localFSPersonalInfo == null)
    {
      QLog.e("FSPersonalViewModel", 1, "fsPersonalInfo is null");
      return;
    }
    if (paramInt == 1) {
      localFSPersonalInfo.h += 1;
    } else {
      localFSPersonalInfo.h -= 1;
    }
    this.d.setValue(localFSPersonalInfo);
  }
  
  private void a(FSGetFeedListLikeRequest paramFSGetFeedListLikeRequest, boolean paramBoolean)
  {
    FSRequestCall localFSRequestCall = FSRequestSender.a().b();
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("3004");
      localStringBuilder.append(h());
      localFSRequestCall.a(localStringBuilder.toString());
    }
    localFSRequestCall.a(this.c).a(paramFSGetFeedListLikeRequest).a(this).a();
  }
  
  private void a(FSGetMainPageRequest paramFSGetMainPageRequest, boolean paramBoolean)
  {
    FSRequestCall localFSRequestCall = FSRequestSender.a().b();
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("3003");
      localStringBuilder.append(h());
      localFSRequestCall.a(localStringBuilder.toString());
    }
    localFSRequestCall.a(this.b).a(paramFSGetMainPageRequest).a(new FSUserInfoRspInterceptor()).a(this).a();
  }
  
  private void a(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    if (!paramUIStateData.m()) {
      return;
    }
    Object localObject1 = (List)paramUIStateData.e();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      FSFeedData localFSFeedData = (FSFeedData)((Iterator)localObject1).next();
      Object localObject2 = localFSFeedData.b().id.get();
      localObject2 = (FeedCloudMeta.StFeed)FSDataCenter.a().a(FeedCloudMeta.StFeed.class, (String)localObject2).getValue();
      if (localObject2 == null) {
        localArrayList.add(localFSFeedData);
      } else if (((FeedCloudMeta.StFeed)localObject2).likeInfo.status.get() == 1) {
        localArrayList.add(localFSFeedData);
      }
    }
    paramUIStateData.a(paramUIStateData.i(), localArrayList);
  }
  
  private void a(Object paramObject)
  {
    if (b(paramObject)) {
      return;
    }
    c(paramObject);
  }
  
  private MutableLiveData<UIStateData<List<FSFeedData>>> b(String paramString)
  {
    if ("fs_feed_type_personal_production".equals(paramString)) {
      return this.e;
    }
    if ("fs_feed_type_personal_praised".equals(paramString)) {
      return this.f;
    }
    return null;
  }
  
  private FSGetMainPageRequest b(boolean paramBoolean)
  {
    FSGetMainPageRequest.Builder localBuilder = new FSGetMainPageRequest.Builder(h());
    if (paramBoolean) {
      localBuilder.openCache();
    }
    return (FSGetMainPageRequest)localBuilder.build();
  }
  
  private boolean b(Object paramObject)
  {
    if (!(paramObject instanceof FSPersonalInfo))
    {
      QLog.e("FSPersonalViewModel", 1, "rspObj is not FSPersonalInfo");
      return false;
    }
    Object localObject = (FSPersonalInfo)paramObject;
    this.d.setValue(localObject);
    n();
    if (!((FSPersonalInfo)localObject).k)
    {
      paramObject = ((FSPersonalInfo)localObject).c;
      int j = ((FSPersonalInfo)localObject).g;
      int k = ((FSPersonalInfo)localObject).d;
      int m = ((FSPersonalInfo)localObject).e;
      localObject = new FSUserStateData(paramObject, j, k, ((FSPersonalInfo)localObject).f, m);
      FSDataCenter.a().a(paramObject, (FSUserStateData)localObject).setValue(localObject);
    }
    return true;
  }
  
  private FSGetFeedListLikeRequest c(boolean paramBoolean)
  {
    FSGetFeedListLikeRequest.Builder localBuilder = new FSGetFeedListLikeRequest.Builder(h());
    if (paramBoolean) {
      localBuilder.openCache();
    }
    return (FSGetFeedListLikeRequest)localBuilder.build();
  }
  
  private void c(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("FSPersonalViewModel", 1, "handleProductsFeedList rspObj is null");
      return;
    }
    try
    {
      paramObject = (UIStateData)paramObject;
      this.e.setValue(paramObject);
      if (!paramObject.l())
      {
        if (paramObject.i()) {
          return;
        }
        this.h = true;
        n();
        return;
      }
      return;
    }
    catch (ClassCastException paramObject)
    {
      QLog.e("FSPersonalViewModel", 1, paramObject.getMessage());
    }
  }
  
  private void d(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("FSPersonalViewModel", 1, "handlePraisesFeedFeedList rspObj is null");
      return;
    }
    try
    {
      paramObject = (UIStateData)paramObject;
      a(paramObject);
      this.f.setValue(paramObject);
      if (!paramObject.l())
      {
        if (paramObject.i()) {
          return;
        }
        this.i = true;
        n();
        return;
      }
      return;
    }
    catch (ClassCastException paramObject)
    {
      QLog.e("FSPersonalViewModel", 1, paramObject.getMessage());
    }
  }
  
  private boolean j()
  {
    Object localObject = this.e.getValue();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if ((((UIStateData)this.e.getValue()).l()) || (((UIStateData)this.e.getValue()).m())) {
      bool = true;
    }
    return bool;
  }
  
  private boolean k()
  {
    Object localObject = this.f.getValue();
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if ((((UIStateData)this.f.getValue()).l()) || (((UIStateData)this.f.getValue()).m())) {
      bool = true;
    }
    return bool;
  }
  
  private void l()
  {
    if (j()) {
      return;
    }
    FSRequestSender.a().b().a(this.b).a(true).a(b(false)).a(this).a();
  }
  
  private void m()
  {
    if (k()) {
      return;
    }
    FSRequestSender.a().b().a(this.c).a(true).a(c(false)).a(this).a();
  }
  
  private void n()
  {
    if ((this.h) && (this.i) && (this.d.getValue() != null))
    {
      Object localObject1 = (UIStateData)this.e.getValue();
      Object localObject2 = (UIStateData)this.f.getValue();
      int k = 1;
      int j;
      if ((localObject1 != null) && (((UIStateData)localObject1).e() != null) && (!((List)((UIStateData)localObject1).e()).isEmpty())) {
        j = 1;
      } else {
        j = 0;
      }
      if ((localObject2 == null) || (((UIStateData)localObject2).e() == null) || (((List)((UIStateData)localObject2).e()).isEmpty())) {
        k = 0;
      }
      localObject1 = new ArrayList();
      int m = ((FSPersonalInfo)this.d.getValue()).h;
      int n = ((FSPersonalInfo)this.d.getValue()).g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(FSTextUtils.a(m));
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(FSTextUtils.a(n));
      localObject3 = ((StringBuilder)localObject3).toString();
      if ((j != 0) && (k != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(FSHardCodeUtil.a(2131889739));
        localStringBuilder.append((String)localObject3);
        ((ArrayList)localObject1).add(new FSPersonalTab(localStringBuilder.toString(), "fs_feed_type_personal_production"));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(FSHardCodeUtil.a(2131889738));
        ((StringBuilder)localObject3).append((String)localObject2);
        ((ArrayList)localObject1).add(new FSPersonalTab(((StringBuilder)localObject3).toString(), "fs_feed_type_personal_praised"));
      }
      else if ((k == 0) && ((j != 0) || (!FSCommonUtil.a(h()))))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(FSHardCodeUtil.a(2131889734));
        ((StringBuilder)localObject2).append((String)localObject3);
        ((ArrayList)localObject1).add(new FSPersonalTab(((StringBuilder)localObject2).toString(), "fs_feed_type_personal_production"));
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(FSHardCodeUtil.a(2131889735));
        ((StringBuilder)localObject3).append((String)localObject2);
        ((ArrayList)localObject1).add(new FSPersonalTab(((StringBuilder)localObject3).toString(), "fs_feed_type_personal_praised"));
      }
      this.g.setValue(localObject1);
    }
  }
  
  public MutableLiveData<UIStateData<List<FSFeedData>>> a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0) && ((paramVarArgs[0] instanceof String))) {
      return b((String)paramVarArgs[0]);
    }
    return null;
  }
  
  public String a()
  {
    return "FSPersonalViewModel";
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null)
    {
      QLog.d("FSPersonalViewModel", 1, "mStUser can not be set null");
      return;
    }
    this.a = paramStUser;
    paramStUser = FSDataCenter.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(2001);
    localStringBuilder.append(this.a.id.get());
    paramStUser.a(localStringBuilder.toString(), this);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.equals("fs_feed_type_personal_production", paramString))
    {
      l();
      return;
    }
    if (TextUtils.equals("fs_feed_type_personal_praised", paramString)) {
      m();
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    List localList = this.c.b();
    if (localList == null) {
      return;
    }
    Iterator localIterator = localList.iterator();
    if (paramInt == 1)
    {
      paramString = (FSFeedData)FSDataCenter.a().a("FSFeedDataStore", paramString);
      if (paramString != null) {
        localList.add(0, paramString);
      }
    }
    else
    {
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((FSFeedData)localIterator.next()).b().id.get(), paramString)) {
          localIterator.remove();
        }
      }
    }
    a(paramInt);
    n();
  }
  
  public void a(String paramString, long paramLong)
  {
    paramString = (FSGetMainPageRequest)new FSGetMainPageRequest.Builder(h()).a(4, h(), paramString, paramLong).build();
    FSRequestSender.a().b().a(this.b).a(true).a(paramString).a(this).a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = false;
    this.i = false;
    a(b(paramBoolean), paramBoolean);
    a(c(paramBoolean), paramBoolean);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FSBaseRequest paramFSBaseRequest, Object paramObject, Bundle paramBundle)
  {
    if ((paramFSBaseRequest instanceof FSGetMainPageRequest))
    {
      a(paramObject);
      return;
    }
    if ((paramFSBaseRequest instanceof FSGetFeedListLikeRequest)) {
      d(paramObject);
    }
  }
  
  public MutableLiveData<ArrayList<FSPersonalTab>> b()
  {
    return this.g;
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof String)) {
        return;
      }
      MutableLiveData localMutableLiveData = b((String)paramVarArgs[0]);
      if (localMutableLiveData != null)
      {
        if (((UIStateData)localMutableLiveData.getValue()).h()) {
          return;
        }
        a((String)paramVarArgs[0]);
      }
    }
  }
  
  public int c()
  {
    return 2001;
  }
  
  public MutableLiveData<FSPersonalInfo> d()
  {
    return this.d;
  }
  
  public MutableLiveData<UIStateData<List<FSFeedData>>> e()
  {
    return this.e;
  }
  
  public MutableLiveData<UIStateData<List<FSFeedData>>> f()
  {
    return this.f;
  }
  
  public FeedCloudMeta.StUser g()
  {
    return this.a;
  }
  
  public String h()
  {
    FeedCloudMeta.StUser localStUser = this.a;
    if (localStUser != null) {
      return localStUser.id.get();
    }
    return "";
  }
  
  public void i()
  {
    UIStateData localUIStateData2 = (UIStateData)this.f.getValue();
    List localList = this.c.b();
    UIStateData localUIStateData1 = localUIStateData2;
    if (localUIStateData2 == null) {
      localUIStateData1 = UIStateData.a(false).a(false, localList);
    }
    if ((localList != null) && (localList.size() != 0)) {
      localUIStateData1.c(2);
    } else {
      localUIStateData1.c(0);
    }
    this.f.setValue(localUIStateData1);
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel
 * JD-Core Version:    0.7.0.1
 */