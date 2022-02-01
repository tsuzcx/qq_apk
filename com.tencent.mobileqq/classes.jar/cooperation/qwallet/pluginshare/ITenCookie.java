package cooperation.qwallet.pluginshare;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface ITenCookie
  extends QRouteApi
{
  public static final String QB_TENPAY_HB_SP_NAME = "qb_tenpay_h5_common_hb_";
  
  public abstract boolean clearTempArgs(String paramString);
  
  public abstract String getEncryptValue(String paramString1, String paramString2, SharedPreferences paramSharedPreferences);
  
  public abstract String getMsgNo(String paramString);
  
  public abstract String getTempArgs(String paramString);
  
  public abstract String putEncryptValue(String paramString1, String paramString2, SharedPreferences paramSharedPreferences, String paramString3);
  
  public abstract String readTagCookie(Context paramContext, String paramString1, String paramString2);
  
  public abstract String setTempArgs(String paramString1, String paramString2);
  
  public abstract boolean setUin(String paramString);
  
  public abstract void writeTagCookie(Context paramContext, String paramString, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.pluginshare.ITenCookie
 * JD-Core Version:    0.7.0.1
 */