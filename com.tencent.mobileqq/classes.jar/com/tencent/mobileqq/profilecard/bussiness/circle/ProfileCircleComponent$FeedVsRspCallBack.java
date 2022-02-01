package com.tencent.mobileqq.profilecard.bussiness.circle;

import android.util.LruCache;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import feedcloud.FeedCloudRead.StGetMainPageRsp;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileCircleComponent$FeedVsRspCallBack
  implements VSDispatchObserver.onVSRspCallBack<FeedCloudRead.StGetMainPageRsp>
{
  private WeakReference<ProfileCircleComponent> mWRFProfileCircleComponent;
  
  ProfileCircleComponent$FeedVsRspCallBack(ProfileCircleComponent paramProfileCircleComponent)
  {
    this.mWRFProfileCircleComponent = new WeakReference(paramProfileCircleComponent);
  }
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    paramBaseRequest = (ProfileCircleComponent)this.mWRFProfileCircleComponent.get();
    if (paramBaseRequest == null) {}
    do
    {
      do
      {
        return;
        ProfileCircleComponent.access$000(paramBaseRequest).set(false);
      } while (paramStGetMainPageRsp == null);
      paramString = paramStGetMainPageRsp.vecFeed.get();
      ProfileCircleComponent.access$100(paramBaseRequest, paramStGetMainPageRsp, paramString);
      if (((ProfileCardInfo)ProfileCircleComponent.access$200(paramBaseRequest)).a != null) {
        ProfileCircleComponent.access$400().put(((ProfileCardInfo)ProfileCircleComponent.access$300(paramBaseRequest)).a.uin, new ProfileCircleComponent.ProfileCircleCacheBean(paramStGetMainPageRsp, System.currentTimeMillis()));
      }
    } while ((paramString == null) || (paramString.size() <= 0));
    ProfileCircleComponent.access$502(paramBaseRequest, paramString);
    ProfileCircleComponent.access$700(paramBaseRequest).post(new ProfileCircleComponent.FeedVsRspCallBack.1(this, paramBaseRequest));
    QLog.d("ProfileCircleComponent", 4, "makeOrRefreshQQCircle onResponse success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.ProfileCircleComponent.FeedVsRspCallBack
 * JD-Core Version:    0.7.0.1
 */