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
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        return false;
      }
      int i = new JSONObject(paramString).getInt("code");
      if ((i == 1000) || (i == 1495)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_base_AthenaJsonUploadRunnable", paramString + ": response parameter json error" });
    }
  }
  
  public final void setAthenaUrl(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "<set-?>");
    this.athenaUrl = paramURL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.AthenaUpload
 * JD-Core Version:    0.7.0.1
 */