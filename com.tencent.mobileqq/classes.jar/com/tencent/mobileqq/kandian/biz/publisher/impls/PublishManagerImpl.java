package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IReleaseCallback;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IVideoPublishCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils;
import com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/PublishManagerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/publishvideotask/RIJUgcVideoPublishManager$IReleaseCallback;", "()V", "articleInfoMap", "Ljava/util/HashMap;", "", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "Lkotlin/collections/HashMap;", "listenerMap", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/publishvideotask/RIJUgcVideoPublishManager$IVideoPublishCallback;", "manager", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/publishvideotask/RIJUgcVideoPublishManager;", "getManager", "()Lcom/tencent/biz/pubaccount/readinjoy/ugc/publishvideotask/RIJUgcVideoPublishManager;", "addPublishListener", "", "listener", "release", "removePublishListener", "startPublish", "globalPublisherConfig", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "publishArticleInfo", "toPublishArticleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/UgcVideo;", "toUgcVideo", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishManagerImpl
  implements RIJUgcVideoPublishManager.IReleaseCallback, IPublishManager
{
  public static final PublishManagerImpl.Companion a;
  private final HashMap<IPublishManager.IPublishListener, RIJUgcVideoPublishManager.IVideoPublishCallback> a;
  private final HashMap<String, PublishArticleInfo> b = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsPublishManagerImpl$Companion = new PublishManagerImpl.Companion(null);
  }
  
  public PublishManagerImpl()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    a().a((RIJUgcVideoPublishManager.IReleaseCallback)this);
  }
  
  private final UgcVideo a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.seqId = paramPublishArticleInfo.getPublishId();
    Object localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      localUgcVideo.filePath = ((VideoInfo)localObject1).getFilePath();
      localUgcVideo.coverPath = ((VideoInfo)localObject1).getCoverPath();
      localUgcVideo.coverWidth = ((VideoInfo)localObject1).getCoverWidth();
      localUgcVideo.coverHeight = ((VideoInfo)localObject1).getCoverHeight();
      localUgcVideo.duration = ((int)((VideoInfo)localObject1).getDuration() / 1000);
      localUgcVideo.width = ((VideoInfo)localObject1).getWidth();
      localUgcVideo.height = ((VideoInfo)localObject1).getHeight();
      localUgcVideo.fileSize = ((VideoInfo)localObject1).getFileSize();
      localUgcVideo.fileMd5 = ((VideoInfo)localObject1).getFileMd5();
    }
    localUgcVideo.insertTime = (System.currentTimeMillis() / 1000);
    localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
    localUgcVideo.title = paramPublishArticleInfo.getContent();
    localUgcVideo.columnId = paramPublishArticleInfo.getTopicId();
    boolean bool;
    if (!paramPublishArticleInfo.getAllowReprint())
    {
      bool = true;
      localUgcVideo.reprintDisable = bool;
      switch (paramPublishArticleInfo.getPrivacySetting())
      {
      default: 
        i = UgcVideo.TYPE_PUBLIC;
        label212:
        localUgcVideo.publicType = i;
        localUgcVideo.uploadType = 0;
        localUgcVideo.fromForReport = -1;
        if (((CharSequence)paramPublishArticleInfo.getScene()).length() <= 0) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        i = new JSONObject(paramPublishArticleInfo.getScene()).optInt("key_from", 0);
        if (i == 4) {
          localUgcVideo.uploadType = 1;
        }
        localUgcVideo.fromForReport = PublisherReportUtils.a.a(i);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          JSONObject localJSONObject;
          QLog.e("PublishManagerImpl", 1, localException.getMessage());
          continue;
          localObject2 = ((LocationInfo)localObject3).getName();
          continue;
          localObject2 = null;
        }
        Object localObject3 = (QQAppInterface)localObject2;
        Object localObject2 = PublisherUtils.a;
        localObject3 = ((QQAppInterface)localObject3).getCurrentUin();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.currentUin");
        localUgcVideo.setMultiTitleStruct(((PublisherUtils)localObject2).a((String)localObject3, false, paramPublishArticleInfo.getContentList()));
      }
      localObject3 = paramPublishArticleInfo.getLocationInfo();
      if (localObject3 == null) {
        break label506;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("latitude", ((LocationInfo)localObject3).getLatitude());
      localJSONObject.put("longitude", ((LocationInfo)localObject3).getLongitude());
      localJSONObject.put("is_user_selected", ((LocationInfo)localObject3).isUserSelect());
      if (!TextUtils.isEmpty((CharSequence)((LocationInfo)localObject3).getName())) {
        break label496;
      }
      localObject1 = ((LocationInfo)localObject3).getAddr();
      localJSONObject.put("location_name", localObject1);
      localJSONObject.put("area_id", ((LocationInfo)localObject3).getUid());
      localObject1 = localJSONObject.toString();
      localUgcVideo.address = ((String)localObject1);
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 != null) {
        break label512;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      bool = false;
      break;
      i = UgcVideo.TYPE_PUBLIC_AND_REMIND;
      break label212;
      i = UgcVideo.TYPE_PUBLIC;
      break label212;
      i = UgcVideo.TYPE_NO_PUBLIC;
      break label212;
    }
    label496:
    label506:
    return localUgcVideo;
  }
  
  private final RIJUgcVideoPublishManager a()
  {
    Manager localManager = RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager");
    }
    return (RIJUgcVideoPublishManager)localManager;
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
      if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
        break label169;
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      localPublishArticleInfo.setPublishing(bool);
      return localPublishArticleInfo;
      return null;
    }
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(@NotNull GlobalPublisherConfig paramGlobalPublisherConfig, @NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramGlobalPublisherConfig, "globalPublisherConfig");
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "publishArticleInfo");
    a().a(a(paramPublishArticleInfo), true);
    ((Map)this.b).put(paramPublishArticleInfo.getPublishId(), paramPublishArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishManagerImpl
 * JD-Core Version:    0.7.0.1
 */