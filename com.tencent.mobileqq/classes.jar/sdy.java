import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class sdy
  extends ozi
{
  sdy(sdv paramsdv) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!sdv.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new bcpw(sdv.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(bcpw.a(2));
      paramString2.c(2131692325);
      paramString2.b(sdv.a(this.a).getResources().getDimensionPixelSize(2131298865) - (int)bbdh.a(sdv.a(this.a), 5.0F));
    }
    for (;;)
    {
      sdv.a(this.a).remove(paramString1);
      return;
      paramString2.a(bcpw.a(1));
      paramString2.c(2131692326);
      paramString2.b(sdv.a(this.a).getResources().getDimensionPixelSize(2131298865) - (int)bbdh.a(sdv.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdy
 * JD-Core Version:    0.7.0.1
 */