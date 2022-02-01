import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class mzv
  implements ardd
{
  mzv(mzu parammzu) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = ardc.a().a();
      String str2 = ardc.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        mzu.a(this.a).b(110);
        return;
      }
      this.a.a(new mzx(str1, str2));
      return;
    }
    mzu.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mzv
 * JD-Core Version:    0.7.0.1
 */