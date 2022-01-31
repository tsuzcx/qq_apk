import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class svo
  extends pen
{
  svo(svl paramsvl) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!svl.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new QQToast(svl.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(QQToast.a(2));
      paramString2.c(2131692402);
      paramString2.b(svl.a(this.a).getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(svl.a(this.a), 5.0F));
    }
    for (;;)
    {
      svl.a(this.a).remove(paramString1);
      return;
      paramString2.a(QQToast.a(1));
      paramString2.c(2131692403);
      paramString2.b(svl.a(this.a).getResources().getDimensionPixelSize(2131298914) - (int)bdgz.a(svl.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */