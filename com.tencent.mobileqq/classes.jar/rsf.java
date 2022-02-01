import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.tmediacodec.reuse.ReusePolicy.EraseType;
import com.tencent.tmediacodec.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/CodecReuseHelper$Companion;", "", "()V", "DEFAULT_CONFIG_URL", "", "DEFAULT_DEVICE_SUPPORT", "", "DEFAULT_MODE", "", "DEFAULT_VIDEO_CODEC_REUSE_ENABLE", "FETCH_CONFIG_LIMIT", "KEY_BLACK_BRAND_LIST", "KEY_BLACK_MODEL_LIST", "KEY_WHITE_BRAND_LIST", "KEY_WHITE_MODEL_LIST", "MODE_BLACK_LIST", "SEPARATOR", "SP_KEY_REUSE_CONFIG", "TAG", "TRUE", "UNKOWN", "VIDEO_CODEC_REUSE_ENABLE", "configUrl", "configVersion", "getConfigVersion", "()I", "setConfigVersion", "(I)V", "deviceSupport", "getDeviceSupport", "()Z", "setDeviceSupport", "(Z)V", "fetchConfigRetryCount", "hasReadLocalConfig", "getHasReadLocalConfig", "setHasReadLocalConfig", "lastFetchTime", "", "appendBySeparator", "originStr", "appendStr", "separator", "fetchConfig", "", "getConfigCodecEraseType", "Lcom/tencent/tmediacodec/reuse/ReusePolicy$EraseType;", "getTargetList", "", "jsonObject", "Lorg/json/JSONObject;", "listKey", "isCodecReuseEnable", "parseJsonConfig", "configJson", "pullConfigFromServer", "readConfigFromLocal", "saveConfigToLocal", "configStr", "setToReportData", "mediaCodecInfo", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPMediaCodecInfo;", "reportData", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;", "setToReportDataByExtraObject", "extraObject", "Ljava/lang/Object;", "videoFrameCheckEnable", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rsf
{
  private final String a()
  {
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("SP_KEY_SUPERPLAYER_REUSE_CONFIG", 0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getC…IG, Context.MODE_PRIVATE)");
    localObject = ((SharedPreferences)localObject).getString("SP_KEY_SUPERPLAYER_REUSE_CONFIG", "");
    if (localObject != null) {
      return localObject;
    }
    return "";
  }
  
  private final String a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty((CharSequence)paramString1)) {
      return paramString2;
    }
    return paramString1 + paramString3 + paramString2;
  }
  
  private final void a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("SP_KEY_SUPERPLAYER_REUSE_CONFIG", 0);
    Intrinsics.checkExpressionValueIsNotNull(localSharedPreferences, "BaseApplicationImpl.getC…IG, Context.MODE_PRIVATE)");
    localSharedPreferences.edit().putString("SP_KEY_SUPERPLAYER_REUSE_CONFIG", paramString).apply();
  }
  
  private final void b()
  {
    if (rse.b() > 3) {
      return;
    }
    String str = Aladdin.getConfig(309).getString("config_file_url", "https://sqimg.qq.com/qq_product_operations/kan/superplayer_codecreuse_config.json");
    Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…url\", DEFAULT_CONFIG_URL)");
    rse.b(str);
    rse.a(System.currentTimeMillis());
    rse.b(rse.b() + 1);
    tgc.a(rse.b(), (tox)new rsh());
  }
  
  public final int a()
  {
    return rse.a();
  }
  
  @NotNull
  public final ReusePolicy.EraseType a()
  {
    int i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(Aladdin.getConfig(309).getIntegerFromString("codec_erase_policy", ReusePolicy.EraseType.First.ordinal()), ReusePolicy.EraseType.values().length), 0);
    return ReusePolicy.EraseType.values()[i];
  }
  
  @NotNull
  public final List<String> a(@NotNull JSONObject paramJSONObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    Intrinsics.checkParameterIsNotNull(paramString, "listKey");
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.getJSONArray(paramString);
    if (paramJSONObject != null) {
      try
      {
        paramJSONObject = new Gson().fromJson(paramJSONObject.toString(), new rsg().getType());
        Intrinsics.checkExpressionValueIsNotNull(paramJSONObject, "Gson().fromJson(it.toStr…<List<String>>() {}.type)");
        paramJSONObject = (List)paramJSONObject;
        return paramJSONObject;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("CodecReuseHelper", 1, "getTargetList failed for ...", paramJSONObject);
      }
    }
    return (List)localArrayList;
  }
  
  public final void a()
  {
    if (!((rsf)this).b())
    {
      ((rsf)this).b(true);
      String str = ((rsf)this).a();
      ((rsf)this).a(((rsf)this).a(str));
    }
    if (((rsf)this).a() == Aladdin.getConfig(309).getIntegerFromString("config_version", -1)) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    rse.b(0);
    ((rsf)this).b();
  }
  
  public final void a(int paramInt)
  {
    rse.a(paramInt);
  }
  
  public final void a(@NotNull TPPlayerMsg.TPMediaCodecInfo paramTPMediaCodecInfo, @NotNull rdt paramrdt)
  {
    Intrinsics.checkParameterIsNotNull(paramTPMediaCodecInfo, "mediaCodecInfo");
    Intrinsics.checkParameterIsNotNull(paramrdt, "reportData");
    if (paramTPMediaCodecInfo.mediaType == TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO)
    {
      if (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY) {
        break label119;
      }
      paramTPMediaCodecInfo = paramTPMediaCodecInfo.msg;
      paramrdt.n = paramTPMediaCodecInfo;
    }
    label119:
    while (paramTPMediaCodecInfo.infoType != TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION) {
      try
      {
        paramTPMediaCodecInfo = new JSONObject(paramTPMediaCodecInfo);
        paramrdt.j = paramTPMediaCodecInfo.optBoolean("reuseEnable");
        paramrdt.k = paramTPMediaCodecInfo.optBoolean("isReuse");
        paramrdt.u = paramTPMediaCodecInfo.optInt("totalCodec");
        return;
      }
      catch (Throwable paramTPMediaCodecInfo)
      {
        LogUtil.e("CodecReuseHelper", "onCodecReuseInfo error:" + paramTPMediaCodecInfo.getMessage());
        return;
      }
    }
    try
    {
      String str = new JSONObject(paramTPMediaCodecInfo.msg).optString("errorCode");
      paramrdt.o = ((rsf)this).a(paramrdt.o, str, ";");
      paramrdt.p = ((rsf)this).a(paramrdt.p, paramTPMediaCodecInfo.msg, ";");
      return;
    }
    catch (Throwable paramrdt)
    {
      LogUtils.e("CodecReuseHelper", "onCodecReuseInfo error for jsonObject:" + paramTPMediaCodecInfo.msg);
    }
  }
  
  public final void a(@NotNull Object paramObject, @NotNull rdt paramrdt)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "extraObject");
    Intrinsics.checkParameterIsNotNull(paramrdt, "reportData");
    if ((paramObject instanceof TPPlayerMsg.TPMediaCodecInfo))
    {
      paramObject = (TPPlayerMsg.TPMediaCodecInfo)paramObject;
      ((rsf)this).a(paramObject, paramrdt);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    rse.a(paramBoolean);
  }
  
  public final boolean a()
  {
    return rse.a();
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "configJson");
    if (TextUtils.isEmpty((CharSequence)paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("mode", 0);
        ((rsf)this).a(paramString.optInt("version", -1));
        List localList;
        if (i == 0)
        {
          localList = ((rsf)this).a(paramString, "black_brand_list");
          paramString = ((rsf)this).a(paramString, "black_model_list");
          if (!localList.contains(Build.BRAND)) {
            if (!paramString.contains(Build.MODEL)) {
              break label186;
            }
          }
        }
        else
        {
          localList = ((rsf)this).a(paramString, "white_brand_list");
          paramString = ((rsf)this).a(paramString, "white_model_list");
          if (!localList.contains(Build.BRAND))
          {
            bool = paramString.contains(Build.MODEL);
            if (!bool) {
              continue;
            }
          }
          return true;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CodecReuseHelper", 1, "error for parseJsonConfig return true");
        return false;
      }
    }
    int i = 1;
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      label186:
      i = 0;
      break;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    rse.b(paramBoolean);
  }
  
  public final boolean b()
  {
    return rse.b();
  }
  
  public final boolean c()
  {
    boolean bool = true;
    if (!((rsf)this).a())
    {
      QLog.w("CodecReuseHelper", 1, "isCodecReuseEnable return false because not support, model:" + Build.MODEL + "   brand:" + Build.BOARD);
      return false;
    }
    if (1 == Aladdin.getConfig(309).getIntegerFromString("video_codec_reuse_enable", 0)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final boolean d()
  {
    return Aladdin.getConfig(309).getIntegerFromString("video_frame_check_enable", -1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsf
 * JD-Core Version:    0.7.0.1
 */