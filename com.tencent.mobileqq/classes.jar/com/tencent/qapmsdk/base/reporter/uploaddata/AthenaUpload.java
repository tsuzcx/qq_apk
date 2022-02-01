package com.tencent.qapmsdk.base.reporter.uploaddata;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/AthenaUpload;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "athenaUrl", "Ljava/net/URL;", "(Ljava/net/URL;)V", "getAthenaUrl", "()Ljava/net/URL;", "setAthenaUrl", "isSucceeded", "", "resp", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class AthenaUpload
  extends QAPMUpload
{
  @NotNull
  private URL athenaUrl;
  
  public AthenaUpload(@NotNull URL paramURL)
  {
    super(paramURL);
    this.athenaUrl = paramURL;
  }
  
  @NotNull
  public final URL getAthenaUrl()
  {
    return this.athenaUrl;
  }
  
  public boolean isSucceeded(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "resp");
    boolean bool = true;
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return false;
      }
      int i = new JSONObject(paramString).getInt("code");
      if (i != 1000)
      {
        if (i == 1495) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      Logger localLogger = Logger.INSTANCE;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": response parameter json error");
      localLogger.e(new String[] { "QAPM_base_AthenaJsonUploadRunnable", localStringBuilder.toString() });
    }
    return false;
  }
  
  public final void setAthenaUrl(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "<set-?>");
    this.athenaUrl = paramURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.AthenaUpload
 * JD-Core Version:    0.7.0.1
 */