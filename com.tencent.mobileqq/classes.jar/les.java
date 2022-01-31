import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class les
{
  HashMap<String, String> a = new HashMap();
  HashMap<String, Long> b = new HashMap();
  
  void a(String paramString, boolean paramBoolean)
  {
    QLog.w("DeviceCapabilityExamination", 1, "setDownloadFinish, md5[" + paramString + "], suc[" + paramBoolean + "], time[" + this.b.get(paramString) + "]");
    AudioHelper.c(ajya.a(2131703176) + paramBoolean);
    this.a.remove(paramString);
    this.b.remove(paramString);
  }
  
  boolean a()
  {
    return this.a.isEmpty();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.a.get(paramString1) != null)
    {
      QLog.w("DeviceCapabilityExamination", 1, "isDownloading, md5[" + paramString1 + "], time[" + this.b.get(paramString1) + "]");
      return true;
    }
    this.a.put(paramString1, paramString2);
    this.b.put(paramString1, Long.valueOf(System.currentTimeMillis()));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     les
 * JD-Core Version:    0.7.0.1
 */