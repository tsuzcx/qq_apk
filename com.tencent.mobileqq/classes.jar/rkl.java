import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class rkl
  extends pen
{
  rkl(rkd paramrkd) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!rkd.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(rkd.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(QQToast.a(2));
      paramString2.c(2131692401);
      paramString2.b(rkd.a(this.a).getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(rkd.a(this.a), 5.0F));
    }
    for (;;)
    {
      rkd.a(this.a).remove(paramString1);
      return;
      paramString2.a(QQToast.a(1));
      paramString2.c(2131692402);
      paramString2.b(rkd.a(this.a).getResources().getDimensionPixelSize(2131298914) - (int)bdcq.a(rkd.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rkl
 * JD-Core Version:    0.7.0.1
 */