package com.tencent.mobileqq.kandian.biz.push.component;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.kandian.im.apn.PushComponentExtPB.MsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/push/component/RIJPushComponentExtDataProcessor;", "", "()V", "convertAdditionalField", "Lorg/json/JSONObject;", "pushExtraData", "", "brief", "convertPacket", "Lcom/tencent/mobileqq/kandian/biz/push/component/RIJPushComponentExtData;", "msgBody", "Ltencent/kandian/im/apn/PushComponentExtPB$MsgBody;", "generateActionData", "process0X135PBBuffer", "base64PbBuffer", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushComponentExtDataProcessor
{
  public static final RIJPushComponentExtDataProcessor.Companion a = new RIJPushComponentExtDataProcessor.Companion(null);
  
  @NonNull
  private final RIJPushComponentExtData a(PushComponentExtPB.MsgBody paramMsgBody)
  {
    RIJPushComponentExtData localRIJPushComponentExtData = new RIJPushComponentExtData(null, null, null, null, null, null, 63, null);
    String str;
    if (paramMsgBody.articleIds.has())
    {
      str = paramMsgBody.articleIds.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.articleIds.get()");
      localRIJPushComponentExtData.a = str;
    }
    if (paramMsgBody.foldStatus.has())
    {
      str = paramMsgBody.foldStatus.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.foldStatus.get()");
      localRIJPushComponentExtData.b = str;
    }
    if (paramMsgBody.algoId.has())
    {
      str = paramMsgBody.algoId.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.algoId.get()");
      localRIJPushComponentExtData.c = str;
    }
    if (paramMsgBody.strategyId.has())
    {
      str = paramMsgBody.strategyId.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.strategyId.get()");
      localRIJPushComponentExtData.d = str;
    }
    if (paramMsgBody.subscripts.has())
    {
      str = paramMsgBody.subscripts.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.subscripts.get()");
      localRIJPushComponentExtData.e = str;
    }
    if (paramMsgBody.pushExtData.has())
    {
      paramMsgBody = paramMsgBody.pushExtData.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.pushExtData.get().toByteArray()");
      localRIJPushComponentExtData.f = paramMsgBody;
    }
    return localRIJPushComponentExtData;
  }
  
  @NonNull
  @NotNull
  public final RIJPushComponentExtData a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "base64PbBuffer");
    byte[] arrayOfByte = Base64Util.decode(paramString, 0);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "Base64Util.decode(base64…ffer, Base64Util.DEFAULT)");
    paramString = new PushComponentExtPB.MsgBody();
    try
    {
      paramString.mergeFrom(arrayOfByte);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJPushComponentExtDataProcessor", 2, "process0X135PBBuffer: failed. ", (Throwable)localException);
      }
    }
    return a(paramString);
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "pushExtraData");
    Intrinsics.checkParameterIsNotNull(paramString2, "brief");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("brief", paramString2);
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return localJSONObject;
    }
    localJSONObject.put("orangeWord", new JSONObject(paramString1).optString("orangeWord", ""));
    return localJSONObject;
  }
  
  @NotNull
  public final JSONObject b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pushExtraData");
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return localJSONObject;
    }
    paramString = new JSONObject(paramString);
    localJSONObject.put("id", paramString.optString("id", ""));
    localJSONObject.put("push_ext_data", paramString);
    localJSONObject.put("push_rowkey", paramString.optString("push_rowkey", ""));
    localJSONObject.put("subscripts", paramString.optString("subscripts", ""));
    localJSONObject.put("article_id", paramString.optString("article_id", ""));
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.component.RIJPushComponentExtDataProcessor
 * JD-Core Version:    0.7.0.1
 */