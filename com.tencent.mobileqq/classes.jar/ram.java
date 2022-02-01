import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.kandian.im.apn.PushComponentExtPB.MsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushComponentExtDataProcessor;", "", "()V", "convertAdditionalField", "Lorg/json/JSONObject;", "pushExtraData", "", "brief", "convertPacket", "Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushComponentExtData;", "msgBody", "Ltencent/kandian/im/apn/PushComponentExtPB$MsgBody;", "generateActionData", "process0X135PBBuffer", "base64PbBuffer", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ram
{
  public static final ran a = new ran(null);
  
  @NonNull
  private final ral a(PushComponentExtPB.MsgBody paramMsgBody)
  {
    ral localral = new ral(null, null, null, null, null, null, 63, null);
    String str;
    if (paramMsgBody.articleIds.has())
    {
      str = paramMsgBody.articleIds.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.articleIds.get()");
      localral.jdField_a_of_type_JavaLangString = str;
    }
    if (paramMsgBody.foldStatus.has())
    {
      str = paramMsgBody.foldStatus.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.foldStatus.get()");
      localral.b = str;
    }
    if (paramMsgBody.algoId.has())
    {
      str = paramMsgBody.algoId.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.algoId.get()");
      localral.c = str;
    }
    if (paramMsgBody.strategyId.has())
    {
      str = paramMsgBody.strategyId.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.strategyId.get()");
      localral.d = str;
    }
    if (paramMsgBody.subscripts.has())
    {
      str = paramMsgBody.subscripts.get();
      Intrinsics.checkExpressionValueIsNotNull(str, "msgBody.subscripts.get()");
      localral.e = str;
    }
    if (paramMsgBody.pushExtData.has())
    {
      paramMsgBody = paramMsgBody.pushExtData.get().toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramMsgBody, "msgBody.pushExtData.get().toByteArray()");
      localral.jdField_a_of_type_ArrayOfByte = paramMsgBody;
    }
    return localral;
  }
  
  @NotNull
  public final JSONObject a(@NotNull String paramString)
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
  
  @NonNull
  @NotNull
  public final ral a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "base64PbBuffer");
    byte[] arrayOfByte = bhcu.decode(paramString, 0);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "Base64Util.decode(base64…ffer, Base64Util.DEFAULT)");
    paramString = new PushComponentExtPB.MsgBody();
    try
    {
      paramString.mergeFrom(arrayOfByte);
      return a(paramString);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RIJPushComponentExtDataProcessor", 2, "process0X135PBBuffer: failed. ", (Throwable)localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ram
 * JD-Core Version:    0.7.0.1
 */