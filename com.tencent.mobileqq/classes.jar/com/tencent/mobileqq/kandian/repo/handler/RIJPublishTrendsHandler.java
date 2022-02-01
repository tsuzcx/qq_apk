package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.ugc.DeliverData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.BiuMultiLevel;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.BiuOneLevelItem;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.JumpInfo;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.Picture;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.ReqBody;
import tencent.im.oidb.cmd0xf8b.oidb_cmd0xf8b.TweetInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/handler/RIJPublishTrendsHandler;", "", "()V", "createBiuOneLevelItem", "Ltencent/im/oidb/cmd0xf8b/oidb_cmd0xf8b$BiuOneLevelItem;", "biuCommentInfo", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "publishTrends", "", "comment", "", "biuCommentInfoList", "", "size", "", "deliverData", "Lcom/tencent/mobileqq/kandian/repo/ugc/DeliverData;", "type", "Ljava/lang/Integer;", "troopBarPOI", "Lcom/tencent/mobileqq/tribe/data/TroopBarPOI;", "observer", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPublishTrendsHandler
{
  public static final RIJPublishTrendsHandler.Companion a = new RIJPublishTrendsHandler.Companion(null);
  
  private final oidb_cmd0xf8b.BiuOneLevelItem a(BiuCommentInfo paramBiuCommentInfo)
  {
    oidb_cmd0xf8b.BiuOneLevelItem localBiuOneLevelItem = new oidb_cmd0xf8b.BiuOneLevelItem();
    Object localObject1 = localBiuOneLevelItem.uint64_uin;
    Object localObject2 = paramBiuCommentInfo.mUin;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "biuCommentInfo.mUin");
    ((PBUInt64Field)localObject1).set(((Long)localObject2).longValue());
    if (paramBiuCommentInfo.mBiuComment != null) {
      localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramBiuCommentInfo.mBiuComment));
    }
    localBiuOneLevelItem.op_type.set(paramBiuCommentInfo.mOpType);
    if (paramBiuCommentInfo.jumpInfo != null)
    {
      localBiuOneLevelItem.msg_jump_info.set((MessageMicro)new oidb_cmd0xf8b.JumpInfo());
      localObject1 = localBiuOneLevelItem.msg_jump_info.uint64_id;
      localObject2 = paramBiuCommentInfo.jumpInfo;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "biuCommentInfo.jumpInfo");
      ((PBUInt64Field)localObject1).set(((JumpInfo)localObject2).getId());
      localObject1 = localBiuOneLevelItem.msg_jump_info.bytes_wording;
      localObject2 = paramBiuCommentInfo.jumpInfo;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "biuCommentInfo.jumpInfo");
      ((PBBytesField)localObject1).set(ByteStringMicro.copyFromUtf8(((JumpInfo)localObject2).getWording()));
      localObject1 = localBiuOneLevelItem.msg_jump_info.bytes_jump_url;
      paramBiuCommentInfo = paramBiuCommentInfo.jumpInfo;
      Intrinsics.checkExpressionValueIsNotNull(paramBiuCommentInfo, "biuCommentInfo.jumpInfo");
      ((PBBytesField)localObject1).set(ByteStringMicro.copyFromUtf8(paramBiuCommentInfo.getJumpUrl()));
    }
    return localBiuOneLevelItem;
  }
  
  public final void a(@NotNull String paramString, @NotNull List<? extends BiuCommentInfo> paramList, int paramInt, @NotNull DeliverData paramDeliverData, @NotNull List<Integer> paramList1, @Nullable TroopBarPOI paramTroopBarPOI, @Nullable ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "comment");
    Intrinsics.checkParameterIsNotNull(paramList, "biuCommentInfoList");
    Intrinsics.checkParameterIsNotNull(paramDeliverData, "deliverData");
    Intrinsics.checkParameterIsNotNull(paramList1, "type");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("type=");
      ((StringBuilder)localObject2).append(paramList1);
      ((StringBuilder)localObject2).append(", pic=");
      ((StringBuilder)localObject2).append(paramDeliverData.d());
      ((StringBuilder)localObject2).append(", width=");
      ((StringBuilder)localObject2).append(paramDeliverData.b());
      ((StringBuilder)localObject2).append(", height=");
      ((StringBuilder)localObject2).append(paramDeliverData.c());
      ((StringBuilder)localObject2).append(", location=");
      if (paramTroopBarPOI != null) {
        localObject1 = paramTroopBarPOI.a();
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("RIJPublishTrendsHandler", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new oidb_cmd0xf8b.BiuMultiLevel();
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      localObject2 = a((BiuCommentInfo)paramList.get(i));
      ((oidb_cmd0xf8b.BiuMultiLevel)localObject1).rpt_biu_mutli_level.add((MessageMicro)localObject2);
      i -= 1;
    }
    paramList = (List)new ArrayList();
    if (paramInt > 0)
    {
      i = 0;
      while (i < paramInt)
      {
        localObject2 = new oidb_cmd0xf8b.Picture();
        int j = paramDeliverData.b()[i];
        ((oidb_cmd0xf8b.Picture)localObject2).width.set(j);
        j = paramDeliverData.c()[i];
        ((oidb_cmd0xf8b.Picture)localObject2).height.set(j);
        Object localObject3 = paramDeliverData.d();
        if (localObject3 != null)
        {
          localObject3 = localObject3[i];
          if (localObject3 != null)
          {
            ((oidb_cmd0xf8b.Picture)localObject2).url.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            Integer localInteger = (Integer)paramList1.get(i);
            if ((localInteger != null) && (localInteger.intValue() == 2)) {
              ((oidb_cmd0xf8b.Picture)localObject2).thumbnail.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            }
          }
        }
        paramList.add(localObject2);
        i += 1;
      }
    }
    paramDeliverData = new oidb_cmd0xf8b.TweetInfo();
    paramDeliverData.biu_multi_level.set((MessageMicro)localObject1);
    paramDeliverData.pictures.set(paramList);
    if (paramTroopBarPOI != null) {
      paramDeliverData.bytes_position.set(ByteStringMicro.copyFromUtf8(paramTroopBarPOI.a().toString()));
    }
    paramDeliverData.text.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new oidb_cmd0xf8b.ReqBody();
    paramString.tweet.set((MessageMicro)paramDeliverData);
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), paramTroopProtocolObserver, paramString.toByteArray(), "OidbSvc.0xf8b", 3979, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJPublishTrendsHandler
 * JD-Core Version:    0.7.0.1
 */