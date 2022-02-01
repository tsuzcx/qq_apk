import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class ngm
  implements aqzw
{
  ngm(ngl paramngl) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = aqzv.a().a();
      String str2 = aqzv.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        ngl.a(this.a).b(110);
        return;
      }
      this.a.a(new ngo(str1, str2));
      return;
    }
    ngl.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngm
 * JD-Core Version:    0.7.0.1
 */