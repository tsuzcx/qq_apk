import android.text.TextUtils;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSReportTo1160;
import com.tencent.qphone.base.util.QLog;

public class peh
  implements PTSNativeModuleRegistry.IPTSReportTo1160
{
  public final String a = "PTSReportTo1160Module";
  
  public void reportTo1160(String paramString1, String paramString2)
  {
    QLog.i("PTSReportTo1160Module", 1, "[reportTo1160], event = " + paramString1 + ", r5 = " + paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      pen.a(paramString1, "", "", "", new peo(paramString2).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peh
 * JD-Core Version:    0.7.0.1
 */