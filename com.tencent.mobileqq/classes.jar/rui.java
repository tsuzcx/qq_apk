import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/CodecReuseHelper;", "", "()V", "cacheDebugText", "", "codecJson", "getDebugText", "setCodecJson", "", "setMediaCodecInfo", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "Companion", "OnCodecReuseInfoUpdateCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rui
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  public static final ruj a;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int = -1;
  private static boolean jdField_b_of_type_Boolean;
  private static String c = "https://sqimg.qq.com/qq_product_operations/kan/superplayer_codecreuse_config.json";
  private String jdField_a_of_type_JavaLangString = "";
  private String jdField_b_of_type_JavaLangString = "";
  
  static
  {
    jdField_a_of_type_Ruj = new ruj(null);
  }
  
  @NotNull
  public final String a()
  {
    if (TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaLangString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaLangString);
      if (localJSONObject.optBoolean("isVideo", false))
      {
        boolean bool1 = localJSONObject.optBoolean("isReuse", false);
        boolean bool2 = localJSONObject.optBoolean("reuseEnable", false);
        int i = localJSONObject.optInt("totalCodec", -1);
        this.jdField_b_of_type_JavaLangString = ("isReuse:" + bool1 + " reuseEnable:" + bool2 + "\ntotalCodec:" + i);
      }
      return this.jdField_b_of_type_JavaLangString;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.w("CodecReuseHelper", 1, "getDebugText error for parse Json:" + this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public final void a(@Nullable TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo)
  {
    if (paramTPMediaCodecInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("CodecReuseHelper", 2, "parseAndSetMediaCodecInfo failed for mediaCodecInfo is null.");
      }
    }
    while ((paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) || (paramTPMediaCodecInfo.mediaType != TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)) {
      return;
    }
    paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
    Intrinsics.checkExpressionValueIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo.msg");
    a(paramTPMediaCodecInfo);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "codecJson");
    if (TextUtils.equals((CharSequence)this.jdField_a_of_type_JavaLangString, (CharSequence)paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rui
 * JD-Core Version:    0.7.0.1
 */