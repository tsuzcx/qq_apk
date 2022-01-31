import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class opr
  implements oup
{
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    QLog.d("KBPreDownloadUtils", 2, "[onDownloadStateChanged] url=" + paramString1 + " savedPath=" + paramString2 + " errorCode=" + paramInt2 + " errorMsg=" + paramString3);
    if (!TextUtils.equals(paramString1, opq.a(ors.a(), "sp_key_kb_download_url"))) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 4: 
      long l = System.currentTimeMillis() - opq.a();
      QLog.d("KBPreDownloadUtils", 2, "[onDownloadFinish] cost=" + l + "ms, info=" + paramString1);
      paramString3 = BaseApplicationImpl.getApplication();
      if (paramString3 != null)
      {
        opq.a(paramString3, paramString2);
        opq.a(true, l, 0);
        opq.a(paramString1, paramString2);
        our.a().b(opq.a());
        return;
      }
      QLog.e("KBPreDownloadUtils", 1, "[onDownloadStateChanged] return since context is null");
      return;
    }
    QLog.e("KBPreDownloadUtils", 1, "[onDownloadError] errorCode=" + paramInt2 + ", errorMsg=" + paramString3);
    opq.a(false, System.currentTimeMillis() - opq.a(), paramInt2);
    our.a().b(opq.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opr
 * JD-Core Version:    0.7.0.1
 */