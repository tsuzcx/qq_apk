package com.tencent.mobileqq.kandian.biz.comment.msgboard;

import android.content.Context;
import com.dataline.util.DBNetworkUtil;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.utils.RIJDeviceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams;
import com.tencent.mobileqq.kandian.biz.comment.msgboard.data.RIJMessageBoardEditorParams.SourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.KVInfo;
import tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.ReqBody;
import tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.RspBody;
import tencent.im.oidb.oidb_0xfa3.oidb_0xfa3.TerminalInfo;
import tencent.im.oidb.oidb_comment.oidb_comment.AtData;
import tencent.im.oidb.oidb_comment.oidb_comment.HerfData;
import tencent.im.oidb.oidb_comment.oidb_comment.RptData;
import tencent.im.oidb.oidb_comment.oidb_comment.TextData;
import tencent.im.oidb.oidb_msgboard.oidb_msgboard.SourceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/msgboard/RIJMessageBoardNetHandler;", "", "()V", "KEY_ANDROID_ID", "", "KEY_GUID", "KEY_MAC", "KEY_QIMEI", "KEY_QUA", "TAG", "reportData", "", "genResponse", "Ltencent/im/oidb/oidb_0xfa3/oidb_0xfa3$RspBody;", "data", "", "genRptData", "Ltencent/im/oidb/oidb_comment/oidb_comment$RptData;", "commentRptData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "getRequestBody", "Ltencent/im/oidb/oidb_0xfa3/oidb_0xfa3$ReqBody;", "rptDataList", "", "editorParam", "Lcom/tencent/mobileqq/kandian/biz/comment/msgboard/data/RIJMessageBoardEditorParams;", "sendRequest", "", "callback", "Lkotlin/Function3;", "", "genAtData", "genExtData", "genTextData", "genTopicData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMessageBoardNetHandler
{
  public static final RIJMessageBoardNetHandler a = new RIJMessageBoardNetHandler();
  private static final Map<String, String> b;
  
  static
  {
    byte[] arrayOfByte = NetConnInfoCenter.GUID;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "NetConnInfoCenter.GUID");
    b = MapsKt.mapOf(new Pair[] { TuplesKt.to("guid", new String(arrayOfByte, Charsets.UTF_8)), TuplesKt.to("qua", AppSetting.g()), TuplesKt.to("qimei", UserAction.getQIMEI()), TuplesKt.to("android_id", DeviceInfoUtil.j()), TuplesKt.to("mac_addr", DeviceInfoUtil.e((Context)BaseApplication.getContext())) });
  }
  
  private final oidb_0xfa3.ReqBody a(List<? extends BaseCommentData.CommentRptData> paramList, RIJMessageBoardEditorParams paramRIJMessageBoardEditorParams)
  {
    oidb_0xfa3.ReqBody localReqBody = new oidb_0xfa3.ReqBody();
    if (paramRIJMessageBoardEditorParams.b != null) {
      localReqBody.business_info.set(ByteStringMicro.copyFromUtf8(paramRIJMessageBoardEditorParams.b));
    }
    localReqBody.message_type.set(paramRIJMessageBoardEditorParams.c);
    Object localObject2 = localReqBody.source_message_id;
    Object localObject1 = paramRIJMessageBoardEditorParams.d;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localReqBody.replied_puin.set(paramRIJMessageBoardEditorParams.e);
    localObject2 = localReqBody.replied_message_id;
    localObject1 = paramRIJMessageBoardEditorParams.f;
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((PBStringField)localObject2).set((String)localObject1);
    if (paramRIJMessageBoardEditorParams.a != null)
    {
      localObject1 = localReqBody.source;
      localObject2 = new oidb_msgboard.SourceInfo();
      ((oidb_msgboard.SourceInfo)localObject2).type.set(paramRIJMessageBoardEditorParams.a.a);
      PBStringField localPBStringField = ((oidb_msgboard.SourceInfo)localObject2).key;
      paramRIJMessageBoardEditorParams = paramRIJMessageBoardEditorParams.a.b;
      if (paramRIJMessageBoardEditorParams == null) {
        paramRIJMessageBoardEditorParams = "";
      }
      localPBStringField.set(paramRIJMessageBoardEditorParams);
      ((oidb_msgboard.SourceInfo)localObject1).set((MessageMicro)localObject2);
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramRIJMessageBoardEditorParams = (BaseCommentData.CommentRptData)paramList.next();
      localReqBody.rpt_data.add((MessageMicro)a.a(paramRIJMessageBoardEditorParams));
    }
    a.a(localReqBody);
    return localReqBody;
  }
  
  private final oidb_0xfa3.RspBody a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new oidb_0xfa3.RspBody();
    }
    oidb_0xfa3.RspBody localRspBody = new oidb_0xfa3.RspBody();
    localRspBody.mergeFrom(paramArrayOfByte);
    return localRspBody;
  }
  
  private final oidb_comment.RptData a(BaseCommentData.CommentRptData paramCommentRptData)
  {
    oidb_comment.RptData localRptData = new oidb_comment.RptData();
    int i = paramCommentRptData.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          return localRptData;
        }
        a.b(localRptData, paramCommentRptData);
        return localRptData;
      }
      a.c(localRptData, paramCommentRptData);
      return localRptData;
    }
    a.a(localRptData, paramCommentRptData);
    return localRptData;
  }
  
  private final void a(@NotNull oidb_0xfa3.ReqBody paramReqBody)
  {
    oidb_0xfa3.TerminalInfo localTerminalInfo1 = paramReqBody.terminal;
    oidb_0xfa3.TerminalInfo localTerminalInfo2 = new oidb_0xfa3.TerminalInfo();
    localTerminalInfo2.id.set(RIJDeviceUtil.a());
    localTerminalInfo2.type.set(2);
    Object localObject1 = localTerminalInfo2.ip;
    paramReqBody = DBNetworkUtil.a(false);
    if (paramReqBody == null) {
      paramReqBody = "";
    }
    ((PBStringField)localObject1).set(paramReqBody);
    localObject1 = b;
    paramReqBody = new LinkedHashMap();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (CharSequence)((Map.Entry)localObject2).getValue();
      int i;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i ^ 0x1) != 0) {
        paramReqBody.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
    }
    paramReqBody = ((Iterable)((Map)paramReqBody).entrySet()).iterator();
    while (paramReqBody.hasNext())
    {
      localObject1 = (Map.Entry)paramReqBody.next();
      localObject2 = localTerminalInfo2.ext;
      localObject3 = new oidb_0xfa3.KVInfo();
      ((oidb_0xfa3.KVInfo)localObject3).key.set((String)((Map.Entry)localObject1).getKey());
      ((oidb_0xfa3.KVInfo)localObject3).value.set((String)((Map.Entry)localObject1).getValue());
      ((PBRepeatMessageField)localObject2).add((MessageMicro)localObject3);
    }
    localTerminalInfo1.set((MessageMicro)localTerminalInfo2);
  }
  
  private final void a(@NotNull oidb_comment.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(0);
    paramRptData = paramRptData.text_data;
    oidb_comment.TextData localTextData = new oidb_comment.TextData();
    localTextData.content.set(paramCommentRptData.b);
    paramRptData.set((MessageMicro)localTextData);
  }
  
  private final void b(@NotNull oidb_comment.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(3);
    paramRptData = paramRptData.herf_data;
    oidb_comment.HerfData localHerfData = new oidb_comment.HerfData();
    localHerfData.content.set(paramCommentRptData.b);
    paramRptData.set((MessageMicro)localHerfData);
  }
  
  private final void c(@NotNull oidb_comment.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(1);
    paramRptData = paramRptData.at_data;
    oidb_comment.AtData localAtData = new oidb_comment.AtData();
    localAtData.content.set(paramCommentRptData.b);
    localAtData.uid.set(paramCommentRptData.c);
    paramRptData.set((MessageMicro)localAtData);
  }
  
  public final void a(@NotNull List<? extends BaseCommentData.CommentRptData> paramList, @NotNull RIJMessageBoardEditorParams paramRIJMessageBoardEditorParams, @Nullable Function3<? super Integer, ? super String, ? super oidb_0xfa3.RspBody, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rptDataList");
    Intrinsics.checkParameterIsNotNull(paramRIJMessageBoardEditorParams, "editorParam");
    paramList = a(paramList, paramRIJMessageBoardEditorParams);
    ProtoUtils.a((AppRuntime)RIJQQAppInterfaceUtil.a(), (ProtoUtils.TroopProtocolObserver)new RIJMessageBoardNetHandler.sendRequest.1(paramFunction3), paramList.toByteArray(), "OidbSvc.0xfa3", 4003, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.msgboard.RIJMessageBoardNetHandler
 * JD-Core Version:    0.7.0.1
 */