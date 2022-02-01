import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class naw
  implements apwt
{
  naw(nav paramnav) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = apws.a().a();
      String str2 = apws.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        nav.a(this.a).b(110);
        return;
      }
      this.a.a(new nay(str1, str2));
      return;
    }
    nav.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naw
 * JD-Core Version:    0.7.0.1
 */