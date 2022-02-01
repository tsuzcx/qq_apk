package com.tencent.mobileqq.kandian.biz.publisher.net;

import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.publisher.common.PublisherUtils;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$Companion;", "", "()V", "TAG", "", "TIMEOUT", "", "biuCommentInfoToBiuMultiLevel", "Ltencent/im/oidb/articlesummary/articlesummary$BiuMultiLevel;", "infoList", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo;", "convertJumpInfo", "Ltencent/im/oidb/articlesummary/articlesummary$JumpInfo;", "jumpInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;", "publishVideo", "", "hasColumnID", "", "videos", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "callback", "Lcom/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$IPublishVideoCallback;", "parseUgcVideo", "Ltencent/im/oidb/cmd0xe2a/oidb_0xe2a$UgcVideoInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishVideoHelper$Companion
{
  private final articlesummary.BiuMultiLevel a(List<? extends SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
    if (paramList == null) {
      return localBiuMultiLevel;
    }
    ArrayList localArrayList = new ArrayList();
    int i = ((Collection)paramList).size() - 1;
    if (i >= 0)
    {
      Object localObject2 = (SocializeFeedsInfo.BiuCommentInfo)paramList.get(i);
      articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
      PBBytesField localPBBytesField = localBiuOneLevelItem.bytes_biu_comments;
      if (((SocializeFeedsInfo.BiuCommentInfo)localObject2).mBiuComment != null) {}
      for (Object localObject1 = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mBiuComment;; localObject1 = "")
      {
        localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localObject1 = ((Companion)this).a(((SocializeFeedsInfo.BiuCommentInfo)localObject2).jumpInfo);
        if (localObject1 != null) {
          localBiuOneLevelItem.msg_jump_info.set((MessageMicro)localObject1);
        }
        localBiuOneLevelItem.op_type.set(((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOpType);
        localObject1 = localBiuOneLevelItem.uint64_uin;
        localObject2 = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mUin;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "info.mUin");
        ((PBUInt64Field)localObject1).set(((Long)localObject2).longValue());
        localArrayList.add(localBiuOneLevelItem);
        i -= 1;
        break;
      }
    }
    localBiuMultiLevel.rpt_biu_mutli_level.set((List)localArrayList);
    return localBiuMultiLevel;
  }
  
  private final articlesummary.JumpInfo a(SocializeFeedsInfo.JumpInfo paramJumpInfo)
  {
    if (paramJumpInfo == null) {
      return null;
    }
    articlesummary.JumpInfo localJumpInfo = new articlesummary.JumpInfo();
    PBBytesField localPBBytesField = localJumpInfo.bytes_jump_url;
    if (paramJumpInfo.getJumpUrl() != null)
    {
      str = paramJumpInfo.getJumpUrl();
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localPBBytesField = localJumpInfo.bytes_wording;
      if (paramJumpInfo.getWording() == null) {
        break label87;
      }
    }
    label87:
    for (String str = paramJumpInfo.getWording();; str = "")
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
      localJumpInfo.uint64_id.set(paramJumpInfo.getId());
      return localJumpInfo;
      str = "";
      break;
    }
  }
  
  private final oidb_0xe2a.UgcVideoInfo a(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    Object localObject3 = null;
    int j = 1;
    oidb_0xe2a.UgcVideoInfo localUgcVideoInfo = new oidb_0xe2a.UgcVideoInfo();
    localUgcVideoInfo.bytes_title.set(ByteStringMicro.copyFromUtf8(paramPublishArticleInfo.getContent()));
    Object localObject4 = localUgcVideoInfo.bytes_url;
    Object localObject1 = paramPublishArticleInfo.getVideoInfo();
    label89:
    int i;
    label201:
    Object localObject5;
    if (localObject1 != null)
    {
      localObject1 = ((VideoInfo)localObject1).getUrl();
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localObject4 = localUgcVideoInfo.bytes_cover_url;
      localObject1 = paramPublishArticleInfo.getVideoInfo();
      if (localObject1 == null) {
        break label461;
      }
      localObject1 = ((VideoInfo)localObject1).getCoverUrl();
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject1));
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
      localObject4 = paramPublishArticleInfo.getVideoInfo();
      if (localObject4 == null) {
        break label467;
      }
      i = (int)((VideoInfo)localObject4).getDuration();
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
      localObject4 = localUgcVideoInfo.bytes_file_md5;
      localObject5 = paramPublishArticleInfo.getVideoInfo();
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = ((VideoInfo)localObject5).getFileMd5();
      }
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localObject1 = localUgcVideoInfo.uint32_reprint_disable;
      if (!paramPublishArticleInfo.getAllowReprint()) {
        break label472;
      }
      i = 0;
      label346:
      ((PBUInt32Field)localObject1).set(i);
      localUgcVideoInfo.uint32_remind_friends.set(paramPublishArticleInfo.getPrivacySetting());
      if (((CharSequence)paramPublishArticleInfo.getScene()).length() <= 0) {
        break label477;
      }
      i = 1;
      label381:
      if (i == 0) {
        break label687;
      }
    }
    for (;;)
    {
      label461:
      label467:
      label472:
      label477:
      Object localObject2;
      try
      {
        i = new JSONObject(paramPublishArticleInfo.getScene()).optInt("key_from");
        if (i != 4) {
          break label687;
        }
        i = j;
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
        localObject5 = (QQAppInterface)localException;
        localObject2 = localUgcVideoInfo.biu_multi_level;
        localObject3 = (Companion)this;
        localObject4 = PublisherUtils.a;
        localObject5 = ((QQAppInterface)localObject5).getCurrentUin();
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "app.currentUin");
        ((articlesummary.BiuMultiLevel)localObject2).set((MessageMicro)((Companion)localObject3).a(((PublisherUtils)localObject4).a((String)localObject5, false, paramPublishArticleInfo.getContentList())));
        localObject2 = paramPublishArticleInfo.getLocationInfo();
        if (localObject2 == null) {
          break label675;
        }
      }
      localUgcVideoInfo.uint32_upload_type.set(i);
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
      if (localObject1 == null)
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        localObject1 = null;
        break;
        localObject1 = null;
        break label89;
        i = 0;
        break label201;
        i = 1;
        break label346;
        i = 0;
        break label381;
      }
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("latitude", ((LocationInfo)localObject2).getLatitude());
      ((JSONObject)localObject3).put("longitude", ((LocationInfo)localObject2).getLongitude());
      ((JSONObject)localObject3).put("is_user_selected", ((LocationInfo)localObject2).isUserSelect());
      if (TextUtils.isEmpty((CharSequence)((LocationInfo)localObject2).getName())) {}
      for (paramPublishArticleInfo = ((LocationInfo)localObject2).getAddr();; paramPublishArticleInfo = ((LocationInfo)localObject2).getName())
      {
        ((JSONObject)localObject3).put("location_name", paramPublishArticleInfo);
        paramPublishArticleInfo = ((JSONObject)localObject3).put("area_id", ((LocationInfo)localObject2).getUid());
        localUgcVideoInfo.bytes_position.set(ByteStringMicro.copyFromUtf8(paramPublishArticleInfo.toString()));
        label675:
        return localUgcVideoInfo;
      }
      label687:
      i = 0;
    }
  }
  
  public final void a(boolean paramBoolean, @NotNull List<PublishArticleInfo> paramList, @Nullable PublishVideoHelper.IPublishVideoCallback paramIPublishVideoCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    Object localObject1 = (List)new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (PublishArticleInfo)paramList.next();
      ((List)localObject1).add(((Companion)this).a((PublishArticleInfo)localObject2));
    }
    paramList = new oidb_0xe2a.ReqBody();
    Object localObject2 = new oidb_0xe2a.AddVideoReq();
    ((oidb_0xe2a.AddVideoReq)localObject2).rpt_video_list.set((List)localObject1);
    localObject1 = ((oidb_0xe2a.AddVideoReq)localObject2).uint32_add_video_type;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      ((PBUInt32Field)localObject1).set(i);
      paramList.msg_add_video_req.set((MessageMicro)localObject2);
      ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new PublishVideoHelper.Companion.publishVideo.1(paramIPublishVideoCallback), paramList.toByteArray(), "OidbSvc.0xe2a", 3626, 1, null, 120000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.Companion
 * JD-Core Version:    0.7.0.1
 */