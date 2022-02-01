package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.publisher.ktx.PublishArticleInfoExtKt;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.IUploadActionCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IReleaseCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IUploadVideoStatusCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.ICheckResultCallBack;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishStatusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PublishManagerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IReleaseCallback;", "()V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Lkotlin/collections/HashMap;", "listenerMap", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IVideoPublishCallback;", "manager", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService;", "getManager", "()Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService;", "publishStatusListeners", "", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishStatusListener;", "ugcVideo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcVideo;", "uploadVideoStatusCallback", "com/tencent/mobileqq/kandian/biz/publisher/impls/PublishManagerImpl$uploadVideoStatusCallback$2$1", "getUploadVideoStatusCallback", "()Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PublishManagerImpl$uploadVideoStatusCallback$2$1;", "uploadVideoStatusCallback$delegate", "Lkotlin/Lazy;", "addPublishListener", "", "listener", "pauseUploadVideo", "publishId", "preUploadVideo", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "preUploadVideoInfo", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "isStart", "", "publishStatusListener", "release", "removePublishListener", "removePublishStatusListener", "resumeUploadVideo", "showMobileNetworkDialog", "context", "Landroid/content/Context;", "fileSize", "", "callback", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$ICheckResultCallBack;", "startPublish", "publishArticleInfo", "updateUgcVideo", "toPublishArticleInfo", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishManagerImpl
  implements IRIJUgcVideoPublishService.IReleaseCallback, IPublishManager
{
  private final HashMap<IPublishManager.IPublishListener, IRIJUgcVideoPublishService.IVideoPublishCallback> a = new HashMap();
  private final HashMap<String, PublishArticleInfo> b = new HashMap();
  private UgcVideo c;
  private final List<IPublishManager.IPublishStatusListener> d = (List)new ArrayList();
  private final Lazy e = LazyKt.lazy((Function0)new PublishManagerImpl.uploadVideoStatusCallback.2(this));
  
  public PublishManagerImpl()
  {
    b().addReleaseCallback((IRIJUgcVideoPublishService.IReleaseCallback)this);
  }
  
  private final UgcVideo a(PreUploadVideoInfo paramPreUploadVideoInfo)
  {
    UgcVideo localUgcVideo = this.c;
    if (localUgcVideo != null)
    {
      if (localUgcVideo == null) {
        Intrinsics.throwNpe();
      }
      if (!(Intrinsics.areEqual(localUgcVideo.seqId, paramPreUploadVideoInfo.getPublishId()) ^ true))
      {
        localUgcVideo = this.c;
        if (localUgcVideo == null) {
          Intrinsics.throwNpe();
        }
        localUgcVideo.coverPath = paramPreUploadVideoInfo.getVideoInfo().getCoverPath();
        localUgcVideo.coverWidth = paramPreUploadVideoInfo.getVideoInfo().getCoverWidth();
        localUgcVideo.coverHeight = paramPreUploadVideoInfo.getVideoInfo().getCoverHeight();
        return localUgcVideo;
      }
    }
    this.c = PublishArticleInfoExtKt.a(paramPreUploadVideoInfo);
    paramPreUploadVideoInfo = this.c;
    if (paramPreUploadVideoInfo == null) {
      Intrinsics.throwNpe();
    }
    return paramPreUploadVideoInfo;
  }
  
  private final UgcVideo a(PublishArticleInfo paramPublishArticleInfo)
  {
    UgcVideo localUgcVideo1 = PublishArticleInfoExtKt.a(paramPublishArticleInfo);
    UgcVideo localUgcVideo2 = this.c;
    paramPublishArticleInfo = localUgcVideo1;
    if (localUgcVideo2 != null)
    {
      if (localUgcVideo2 == null) {
        Intrinsics.throwNpe();
      }
      paramPublishArticleInfo = localUgcVideo1;
      if (Intrinsics.areEqual(localUgcVideo2.seqId, localUgcVideo1.seqId))
      {
        paramPublishArticleInfo = this.c;
        if (paramPublishArticleInfo == null) {
          Intrinsics.throwNpe();
        }
        paramPublishArticleInfo.insertTime = localUgcVideo1.insertTime;
        paramPublishArticleInfo.title = localUgcVideo1.title;
        paramPublishArticleInfo.columnId = localUgcVideo1.columnId;
        paramPublishArticleInfo.reprintDisable = localUgcVideo1.reprintDisable;
        paramPublishArticleInfo.publicType = localUgcVideo1.publicType;
        paramPublishArticleInfo.uploadType = localUgcVideo1.uploadType;
        paramPublishArticleInfo.address = localUgcVideo1.address;
        paramPublishArticleInfo.setMultiTitleStruct(localUgcVideo1.getMultiTitleStruct());
        paramPublishArticleInfo.kdCommunityId = localUgcVideo1.kdCommunityId;
        paramPublishArticleInfo.needShowPublishToast = localUgcVideo1.needShowPublishToast;
        paramPublishArticleInfo.videoPublishType = localUgcVideo1.videoPublishType;
        localUgcVideo1 = this.c;
        paramPublishArticleInfo = localUgcVideo1;
        if (localUgcVideo1 == null)
        {
          Intrinsics.throwNpe();
          paramPublishArticleInfo = localUgcVideo1;
        }
      }
    }
    return paramPublishArticleInfo;
  }
  
  private final PublishArticleInfo a(@NotNull UgcVideo paramUgcVideo)
  {
    PublishArticleInfo localPublishArticleInfo = (PublishArticleInfo)this.b.remove(paramUgcVideo.seqId);
    if (localPublishArticleInfo != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localPublishArticleInfo, "articleInfoMap.remove(ug…deo.seqId) ?: return null");
      Object localObject = localPublishArticleInfo.getVideoInfo();
      if (localObject != null)
      {
        String str = paramUgcVideo.coverUrl;
        Intrinsics.checkExpressionValueIsNotNull(str, "ugcVideo.coverUrl");
        ((VideoInfo)localObject).setCoverUrl(str);
        str = paramUgcVideo.url;
        Intrinsics.checkExpressionValueIsNotNull(str, "ugcVideo.url");
        ((VideoInfo)localObject).setUrl(str);
        str = paramUgcVideo.compressPath;
        Intrinsics.checkExpressionValueIsNotNull(str, "ugcVideo.compressPath");
        ((VideoInfo)localObject).setCompressPath(str);
        ((VideoInfo)localObject).setCompressProgress(paramUgcVideo.compressProgress);
        ((VideoInfo)localObject).setCoverProgress(paramUgcVideo.coverProgress);
        ((VideoInfo)localObject).setVideoProgress(paramUgcVideo.videoProgress);
      }
      localObject = paramUgcVideo.rowkey;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ugcVideo.rowkey");
      localPublishArticleInfo.setContentId((String)localObject);
      boolean bool;
      if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
        bool = true;
      } else {
        bool = false;
      }
      localPublishArticleInfo.setPublishing(bool);
      return localPublishArticleInfo;
    }
    return null;
  }
  
  private final IRIJUgcVideoPublishService b()
  {
    IRuntimeService localIRuntimeService = RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJUgcVideoPublishService.class);
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "RIJQQAppInterfaceUtil.ge…blishService::class.java)");
    return (IRIJUgcVideoPublishService)localIRuntimeService;
  }
  
  private final PublishManagerImpl.uploadVideoStatusCallback.2.1 c()
  {
    return (PublishManagerImpl.uploadVideoStatusCallback.2.1)this.e.getValue();
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(@NotNull Context paramContext, long paramLong, @NotNull IPublishManager.ICheckResultCallBack paramICheckResultCallBack)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramICheckResultCallBack, "callback");
    if (CUKingCardUtils.a() == 1)
    {
      paramICheckResultCallBack.a(true);
      return;
    }
    RIJUgcUtils.a(paramContext, paramLong, (RIJUgcUtils.IUploadActionCallback)new PublishManagerImpl.showMobileNetworkDialog.1(paramICheckResultCallBack), null);
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PreUploadVideoInfo paramPreUploadVideoInfo, boolean paramBoolean, @NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPreUploadVideoInfo, "preUploadVideoInfo");
    Intrinsics.checkParameterIsNotNull(paramIPublishStatusListener, "publishStatusListener");
    if (!this.d.contains(paramIPublishStatusListener)) {
      this.d.add(paramIPublishStatusListener);
    }
    b().preUploadVideoTask(a(paramPreUploadVideoInfo), paramBoolean, (IRIJUgcVideoPublishService.IUploadVideoStatusCallback)c());
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    this.d.clear();
    b().addVideoTask(a(paramPublishArticleInfo), true);
    ((Map)this.b).put(paramPublishArticleInfo.getPublishId(), paramPublishArticleInfo);
  }
  
  public void a(@NotNull IPublishManager.IPublishStatusListener paramIPublishStatusListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublishStatusListener, "publishStatusListener");
    if (this.d.contains(paramIPublishStatusListener)) {
      this.d.remove(paramIPublishStatusListener);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "publishId");
    UgcVideo localUgcVideo = this.c;
    if (localUgcVideo != null)
    {
      if (localUgcVideo == null) {
        Intrinsics.throwNpe();
      }
      if (Intrinsics.areEqual(localUgcVideo.seqId, paramString))
      {
        b().pauseVideoTask(this.c);
        paramString = this.c;
        if (paramString == null) {
          Intrinsics.throwNpe();
        }
        paramString.pauseBySwitchNet = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishManagerImpl
 * JD-Core Version:    0.7.0.1
 */