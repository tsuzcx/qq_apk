package com.tencent.mobileqq.kandian.glue.viola;

import android.os.Handler;
import android.os.Looper;
import com.qq.ac.sdk.api.AcInterface;
import com.qq.ac.sdk.api.AcType.Gender;
import com.qq.ac.sdk.api.AcType.UidType;
import com.tencent.comic.api.IQQComicHippyUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageDomObject;
import com.tencent.mobileqq.kandian.biz.viola.barrage.VBarrage;
import com.tencent.mobileqq.kandian.biz.viola.module.CacheModule;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentHeader;
import com.tencent.mobileqq.kandian.glue.viola.comment.KdCommentList;
import com.tencent.mobileqq.kandian.glue.viola.components.VideoAnimationComponent;
import com.tencent.mobileqq.kandian.glue.viola.components.VideoDanmakuComponent;
import com.tencent.mobileqq.kandian.glue.viola.lottie.KdLottieViewCreater;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.DtReportModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.NavigationModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.NotifyModule;
import com.tencent.mobileqq.kandian.glue.viola.modules.QReportModule;
import com.tencent.mobileqq.kandian.glue.viola.reward.VKdRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideo;
import com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.VTopicVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaDomObjectManager;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKEngine.InitCallback;
import com.tencent.viola.ui.view.lottie.VLottieView.Factory;
import org.json.JSONObject;

final class ViolaAccessHelper$5
  implements ViolaSDKEngine.InitCallback
{
  ViolaAccessHelper$5(AppInterface paramAppInterface, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback, ViolaReportDelegate paramViolaReportDelegate, String paramString) {}
  
  public void onFinish(int paramInt, long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sdk initialize errCode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ViolaAccessHelper", 2, new Object[] { "QViolaSDKEngine", ((StringBuilder)localObject).toString() });
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (ViolaAccessHelper.a() < 3)
      {
        ViolaAccessHelper.b();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
        ((StringBuilder)localObject).append(ViolaBizUtils.b());
        ViolaAccessHelper.a(((StringBuilder)localObject).toString(), new ViolaAccessHelper.5.2(this));
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaAccessHelper$SDKInitCallback;
        if (localObject != null) {
          ((ViolaAccessHelper.SDKInitCallback)localObject).a();
        }
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("error_code", paramInt);
        ((JSONObject)localObject).put("error_msg", paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800AB6F", "0X800AB6F", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      return;
    }
    for (;;)
    {
      try
      {
        ViolaSDKEngine.registerModule("bridge", BridgeModule.class, false);
        ViolaSDKEngine.registerModule("navigation", NavigationModule.class, true);
        ViolaSDKEngine.registerModule("QReport", QReportModule.class, true);
        ViolaSDKEngine.registerModule("cache", CacheModule.class, true);
        ViolaSDKEngine.registerModule("comic", ((IQQComicHippyUtil)QRoute.api(IQQComicHippyUtil.class)).getComicModuleClass(), true);
        ViolaSDKEngine.registerModule("report", DtReportModule.class, true);
        ViolaSDKEngine.registerModule("notify", NotifyModule.class, false);
        ViolaSDKEngine.registerComponent(VVideo.class, false, new String[] { "video" });
        ViolaSDKEngine.registerComponent(VKdRewardTaskVideoTimer.class, false, new String[] { "kdredpacket-process" });
        ViolaSDKEngine.registerComponent(VTopicVideo.class, false, new String[] { "topic-video" });
        ViolaSDKEngine.registerComponent(KdCommentList.class, false, new String[] { "kdcomment" });
        ViolaSDKEngine.registerComponent(KdCommentHeader.class, false, new String[] { "kdcomment-header" });
        ViolaSDKEngine.registerComponent(VBarrage.class, false, new String[] { "barrage" });
        ViolaDomObjectManager.registerDomObj("barrage", BarrageDomObject.class);
        ViolaSDKEngine.registerComponent(VideoDanmakuComponent.class, false, new String[] { "video-danmaku" });
        ViolaSDKEngine.registerComponent(VideoAnimationComponent.class, false, new String[] { "video-animation" });
        VLottieView.Factory.setVLottieViewCreater(new KdLottieViewCreater());
        paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        localObject = null;
        if (paramString == null) {
          break label577;
        }
        paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication();
        AcInterface.init(paramString);
        AcInterface.setAppID("ac0632ab2c1e20593b52");
        AcInterface.setAppKey("zBWcxAx7HhqAj0pu2RaXm0T8QElpYiiLXMK4553L2uj");
        paramString = (String)localObject;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
          paramString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        }
        AcInterface.setUid(paramString, AcType.UidType.QQ, AcType.Gender.UNKNOWN);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViolaAccessHelper$SDKInitCallback != null)
        {
          new Handler(Looper.getMainLooper()).post(new ViolaAccessHelper.5.1(this, paramLong));
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SDKInitialize Exception e: ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
      label577:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.5
 * JD-Core Version:    0.7.0.1
 */