import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class sva
  extends qeg
{
  sva(suw paramsuw) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!suw.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(suw.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(QQToast.a(2));
      paramString2.c(2131692127);
      paramString2.b(suw.a(this.a).getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(suw.a(this.a), 5.0F));
    }
    for (;;)
    {
      suw.a(this.a).remove(paramString1);
      return;
      paramString2.a(QQToast.a(1));
      paramString2.c(2131692128);
      paramString2.b(suw.a(this.a).getResources().getDimensionPixelSize(2131299080) - (int)bhdz.a(suw.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sva
 * JD-Core Version:    0.7.0.1
 */