package com.tencent.mobileqq.kandian.biz.publisher.ktx;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils;
import com.tencent.mobileqq.kandian.biz.publisher.report.PublisherReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PreUploadVideoInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "getFromForReport", "", "scene", "toUgcVideo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcVideo;", "Lcom/tencent/tkd/topicsdk/bean/PreUploadVideoInfo;", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class PublishArticleInfoExtKt
{
  private static final int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("key_from", 0);
      i = PublisherReportUtils.a.a(i);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("publishArticleInfoExt", 1, paramString.getMessage());
    }
    return -1;
  }
  
  @NotNull
  public static final UgcVideo a(@NotNull PreUploadVideoInfo paramPreUploadVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPreUploadVideoInfo, "$this$toUgcVideo");
    UgcVideo localUgcVideo = new UgcVideo();
    localUgcVideo.seqId = paramPreUploadVideoInfo.getPublishId();
    VideoInfo localVideoInfo = paramPreUploadVideoInfo.getVideoInfo();
    localUgcVideo.filePath = localVideoInfo.getFilePath();
    localUgcVideo.coverPath = localVideoInfo.getCoverPath();
    localUgcVideo.coverWidth = localVideoInfo.getCoverWidth();
    localUgcVideo.coverHeight = localVideoInfo.getCoverHeight();
    localUgcVideo.duration = ((int)localVideoInfo.getDuration() / 1000);
    localUgcVideo.width = localVideoInfo.getWidth();
    localUgcVideo.height = localVideoInfo.getHeight();
    localUgcVideo.fileSize = localVideoInfo.getFileSize();
    localUgcVideo.fileMd5 = localVideoInfo.getFileMd5();
    localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
    localUgcVideo.fromForReport = a(paramPreUploadVideoInfo.getScene());
    localUgcVideo.kdCommunityId = paramPreUploadVideoInfo.getCommunityId();
    return localUgcVideo;
  }
  
  @NotNull
  public static final UgcVideo a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramPublishArticleInfo, "$this$toUgcVideo");
    UgcVideo localUgcVideo = new UgcVideo();
    if (((CharSequence)paramPublishArticleInfo.getPublishId()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject1 = paramPublishArticleInfo.getPublishId();
    } else {
      localObject1 = UUID.randomUUID().toString();
    }
    localUgcVideo.seqId = ((String)localObject1);
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
    localUgcVideo.reprintDisable = (paramPublishArticleInfo.getAllowReprint() ^ true);
    int i = paramPublishArticleInfo.getPrivacySetting();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          i = UgcVideo.TYPE_PUBLIC;
        } else {
          i = UgcVideo.TYPE_NO_PUBLIC;
        }
      }
      else {
        i = UgcVideo.TYPE_PUBLIC;
      }
    }
    else {
      i = UgcVideo.TYPE_PUBLIC_AND_REMIND;
    }
    localUgcVideo.publicType = i;
    localUgcVideo.uploadType = 0;
    localUgcVideo.fromForReport = -1;
    if (((CharSequence)paramPublishArticleInfo.getScene()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
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
        QLog.e("PublishArticleInfoExt", 1, localException.getMessage());
      }
    }
    Object localObject3 = paramPublishArticleInfo.getLocationInfo();
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("latitude", ((LocationInfo)localObject3).getLatitude());
      ((JSONObject)localObject4).put("longitude", ((LocationInfo)localObject3).getLongitude());
      ((JSONObject)localObject4).put("is_user_selected", ((LocationInfo)localObject3).isUserSelect());
      if (TextUtils.isEmpty((CharSequence)((LocationInfo)localObject3).getName())) {
        localObject2 = ((LocationInfo)localObject3).getAddr();
      } else {
        localObject2 = ((LocationInfo)localObject3).getName();
      }
      ((JSONObject)localObject4).put("location_name", localObject2);
      ((JSONObject)localObject4).put("area_id", ((LocationInfo)localObject3).getUid());
      localObject2 = ((JSONObject)localObject4).toString();
    }
    else
    {
      localObject2 = null;
    }
    localUgcVideo.address = ((String)localObject2);
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
    if (localObject2 != null)
    {
      localObject3 = (QQAppInterface)localObject2;
      localObject2 = PublisherUtils.a;
      localObject3 = ((QQAppInterface)localObject3).getCurrentUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "app.currentUin");
      localObject3 = ((PublisherUtils)localObject2).a((String)localObject3, false, paramPublishArticleInfo.getContentList());
      localObject2 = (List)new ArrayList();
      ((List)localObject2).addAll((Collection)localObject3);
      try
      {
        localObject3 = new BiuCommentInfo();
        ((BiuCommentInfo)localObject3).mUin = Long.valueOf(0L);
        ((BiuCommentInfo)localObject3).mOpType = 4;
        ((BiuCommentInfo)localObject3).jumpInfo = new JumpInfo(Long.parseLong(paramPublishArticleInfo.getCommunityId()), paramPublishArticleInfo.getCommunityName(), "");
        ((List)localObject2).add(localObject3);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("add communityId:");
        ((StringBuilder)localObject4).append(paramPublishArticleInfo.getCommunityId());
        QLog.e("publishArticleInfoExt", 1, ((StringBuilder)localObject4).toString(), (Throwable)localNumberFormatException);
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((Collection)localObject2);
      localUgcVideo.setMultiTitleStruct(localArrayList);
      localUgcVideo.kdCommunityId = paramPublishArticleInfo.getCommunityId();
      localUgcVideo.needShowPublishToast = paramPublishArticleInfo.getShowPublishToast();
      localUgcVideo.videoPublishType = paramPublishArticleInfo.getPublishType();
      return localUgcVideo;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.ktx.PublishArticleInfoExtKt
 * JD-Core Version:    0.7.0.1
 */