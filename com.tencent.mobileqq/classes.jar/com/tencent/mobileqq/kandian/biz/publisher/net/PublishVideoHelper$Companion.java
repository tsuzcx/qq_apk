package com.tencent.mobileqq.kandian.biz.publisher.net;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.bean.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.UgcVideoInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$Companion;", "", "()V", "TAG", "", "TIMEOUT", "", "biuCommentInfoToBiuMultiLevel", "Ltencent/im/oidb/articlesummary/articlesummary$BiuMultiLevel;", "infoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "convertJumpInfo", "Ltencent/im/oidb/articlesummary/articlesummary$JumpInfo;", "jumpInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/JumpInfo;", "publishVideo", "", "hasColumnID", "", "videos", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$IPublishVideoCallback;", "parseUgcVideo", "Ltencent/im/oidb/cmd0xe2a/oidb_0xe2a$UgcVideoInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishVideoHelper$Companion
{
  private final articlesummary.BiuMultiLevel a(List<? extends BiuCommentInfo> paramList)
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (paramList == null) {
      return localBiuMultiLevel;
    }
    ArrayList localArrayList = new ArrayList();
    int i = ((Collection)paramList).size();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      Object localObject2 = (BiuCommentInfo)paramList.get(i);
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
      PBBytesField localPBBytesField = localBiuOneLevelItem.bytes_biu_comments;
      if (((BiuCommentInfo)localObject2).mBiuComment != null) {
        localObject1 = ((BiuCommentInfo)localObject2).mBiuComment;
      } else {
        localObject1 = "";
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      Object localObject1 = ((Companion)this).a(((BiuCommentInfo)localObject2).jumpInfo);
      if (localObject1 != null) {
        localBiuOneLevelItem.msg_jump_info.set((MessageMicro)localObject1);
      }
      localBiuOneLevelItem.op_type.set(((BiuCommentInfo)localObject2).mOpType);
      localObject1 = localBiuOneLevelItem.uint64_uin;
      localObject2 = ((BiuCommentInfo)localObject2).mUin;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.mUin");
      ((PBUInt64Field)localObject1).set(((Long)localObject2).longValue());
      localArrayList.add(localBiuOneLevelItem);
    }
    localBiuMultiLevel.rpt_biu_mutli_level.set((List)localArrayList);
    return localBiuMultiLevel;
  }
  
  private final articlesummary.JumpInfo a(JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    articlesummary.JumpInfo localJumpInfo = new articlesummary.JumpInfo();
    PBBytesField localPBBytesField = localJumpInfo.bytes_jump_url;
    Object localObject = paramJumpInfo.getJumpUrl();
    String str = "";
    if (localObject != null) {
      localObject = paramJumpInfo.getJumpUrl();
    } else {
      localObject = "";
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localPBBytesField = localJumpInfo.bytes_wording;
    localObject = str;
    if (paramJumpInfo.getWording() != null) {
      localObject = paramJumpInfo.getWording();
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    localJumpInfo.uint64_id.set(paramJumpInfo.getId());
    return localJumpInfo;
  }
  
  private final oidb_0xe2a.UgcVideoInfo a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    oidb_0xe2a.UgcVideoInfo localUgcVideoInfo = new oidb_0xe2a.UgcVideoInfo();
    localUgcVideoInfo.bytes_title.set(ByteStringMicro.copyFromUtf8(paramPublishArticleInfo.getContent()));
    Object localObject3 = localUgcVideoInfo.bytes_url;
    Object localObject1 = paramPublishArticleInfo.getVideoInfo();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((VideoInfo)localObject1).getUrl();
    } else {
      localObject1 = null;
    }
    ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localObject3 = localUgcVideoInfo.bytes_cover_url;
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null) {
      localObject1 = ((VideoInfo)localObject1).getCoverUrl();
    } else {
      localObject1 = null;
    }
    ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localUgcVideoInfo.bytes_brief.set(ByteStringMicro.copyFromUtf8(""));
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      i = ((VideoInfo)localObject1).getCoverWidth();
      localUgcVideoInfo.uint32_cover_width.set(i);
    }
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      i = ((VideoInfo)localObject1).getCoverHeight();
      localUgcVideoInfo.uint32_cover_height.set(i);
    }
    localUgcVideoInfo.uint64_column_id.set(paramPublishArticleInfo.getTopicId());
    localObject1 = localUgcVideoInfo.uint32_duration;
    localObject3 = paramPublishArticleInfo.getVideoInfo();
    if (localObject3 != null) {
      i = (int)((VideoInfo)localObject3).getDuration();
    } else {
      i = 0;
    }
    ((PBUInt32Field)localObject1).set(i / 1000);
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      i = ((VideoInfo)localObject1).getWidth();
      localUgcVideoInfo.uint32_width.set(i);
    }
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      i = ((VideoInfo)localObject1).getHeight();
      localUgcVideoInfo.uint32_height.set(i);
    }
    localObject1 = paramPublishArticleInfo.getVideoInfo();
    if (localObject1 != null)
    {
      long l = ((VideoInfo)localObject1).getFileSize();
      localUgcVideoInfo.uint64_file_size.set(l);
    }
    localObject3 = localUgcVideoInfo.bytes_file_md5;
    Object localObject4 = paramPublishArticleInfo.getVideoInfo();
    localObject1 = localObject2;
    if (localObject4 != null) {
      localObject1 = ((VideoInfo)localObject4).getFileMd5();
    }
    ((PBBytesField)localObject3).set(ByteStringMicro.copyFromUtf8((String)localObject1));
    localObject1 = localUgcVideoInfo.uint32_reprint_disable;
    boolean bool = paramPublishArticleInfo.getAllowReprint();
    int j = 1;
    ((PBUInt32Field)localObject1).set(bool ^ true);
    localUgcVideoInfo.uint32_remind_friends.set(paramPublishArticleInfo.getPrivacySetting());
    if (((CharSequence)paramPublishArticleInfo.getScene()).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      i = new JSONObject(paramPublishArticleInfo.getScene()).optInt("key_from");
      if (i == 4) {
        i = j;
      }
    }
    catch (Exception localException)
    {
      label435:
      break label435;
    }
    int i = 0;
    localUgcVideoInfo.uint32_upload_type.set(i);
    localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 != null)
    {
      localObject4 = (QQAppInterface)localObject1;
      localObject1 = localUgcVideoInfo.biu_multi_level;
      localObject2 = (Companion)this;
      localObject3 = PublisherUtils.a;
      localObject4 = ((QQAppInterface)localObject4).getCurrentUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "app.currentUin");
      ((articlesummary.BiuMultiLevel)localObject1).set((MessageMicro)((Companion)localObject2).a(((PublisherUtils)localObject3).a((String)localObject4, false, paramPublishArticleInfo.getContentList())));
      localObject1 = paramPublishArticleInfo.getLocationInfo();
      if (localObject1 != null)
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("latitude", ((LocationInfo)localObject1).getLatitude());
        ((JSONObject)localObject2).put("longitude", ((LocationInfo)localObject1).getLongitude());
        ((JSONObject)localObject2).put("is_user_selected", ((LocationInfo)localObject1).isUserSelect());
        if (TextUtils.isEmpty((CharSequence)((LocationInfo)localObject1).getName())) {
          paramPublishArticleInfo = ((LocationInfo)localObject1).getAddr();
        } else {
          paramPublishArticleInfo = ((LocationInfo)localObject1).getName();
        }
        ((JSONObject)localObject2).put("location_name", paramPublishArticleInfo);
        paramPublishArticleInfo = ((JSONObject)localObject2).put("area_id", ((LocationInfo)localObject1).getUid());
        localUgcVideoInfo.bytes_position.set(ByteStringMicro.copyFromUtf8(paramPublishArticleInfo.toString()));
      }
      return localUgcVideoInfo;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public final void a(boolean paramBoolean, @NotNull List<PublishArticleInfo> paramList, @Nullable PublishVideoHelper.IPublishVideoCallback paramIPublishVideoCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    List localList = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (PublishArticleInfo)paramList.next();
      localList.add(((Companion)this).a((PublishArticleInfo)localObject));
    }
    paramList = new oidb_0xe2a.ReqBody();
    Object localObject = new oidb_0xe2a.AddVideoReq();
    ((oidb_0xe2a.AddVideoReq)localObject).rpt_video_list.set(localList);
    ((oidb_0xe2a.AddVideoReq)localObject).uint32_add_video_type.set(paramBoolean ^ true);
    paramList.msg_add_video_req.set((MessageMicro)localObject);
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new PublishVideoHelper.Companion.publishVideo.1(paramIPublishVideoCallback), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 1, null, 120000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.Companion
 * JD-Core Version:    0.7.0.1
 */