import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class olh
  implements opx
{
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onDownloadStateChanged] url=" + paramString1 + " savedPath=" + paramString2 + " errorCode=" + paramInt2 + " errorMsg=" + paramString3);
    if (!TextUtils.equals(paramString1, olg.a(onh.a(), "sp_key_kb_download_url"))) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 4: 
      long l = System.currentTimeMillis() - olg.a();
      QLog.d("KBPreDownloadUtils", 2, "[onDownloadFinish] cost=" + l + "ms, info=" + paramString1);
      paramString3 = BaseApplicationImpl.getApplication();
      if (paramString3 != null)
      {
        olg.a(paramString3, paramString2);
        olg.a(true, l, 0);
        olg.a(paramString1, paramString2);
        opz.a().b(olg.a());
        return;
      }
      QLog.e("KBPreDownloadUtils", 1, "[onDownloadStateChanged] return since context is null");
      return;
    }
    QLog.e("KBPreDownloadUtils", 1, "[onDownloadError] errorCode=" + paramInt2 + ", errorMsg=" + paramString3);
    olg.a(false, System.currentTimeMillis() - olg.a(), paramInt2);
    opz.a().b(olg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     olh
 * JD-Core Version:    0.7.0.1
 */