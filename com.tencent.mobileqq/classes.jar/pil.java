import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class pil
  implements psw
{
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onDownloadStateChanged] url=" + paramString1 + " savedPath=" + paramString2 + " errorCode=" + paramInt2 + " errorMsg=" + paramString3);
    if (!TextUtils.equals(paramString1, pik.a(pkh.a(), "sp_key_kb_download_url"))) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 4: 
      long l = System.currentTimeMillis() - pik.a();
      QLog.d("KBPreDownloadUtils", 2, "[onDownloadFinish] cost=" + l + "ms, info=" + paramString1);
      paramString3 = BaseApplicationImpl.getApplication();
      if (paramString3 != null)
      {
        pik.a(paramString3, paramString2);
        pik.a(true, l, 0);
        pik.a(paramString1, paramString2);
        psy.a().b(pik.a());
        return;
      }
      QLog.e("KBPreDownloadUtils", 1, "[onDownloadStateChanged] return since context is null");
      return;
    }
    QLog.e("KBPreDownloadUtils", 1, "[onDownloadError] errorCode=" + paramInt2 + ", errorMsg=" + paramString3);
    pik.a(false, System.currentTimeMillis() - pik.a(), paramInt2);
    psy.a().b(pik.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pil
 * JD-Core Version:    0.7.0.1
 */