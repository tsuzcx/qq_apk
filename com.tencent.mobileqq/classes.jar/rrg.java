import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class rrg
  extends ont
{
  rrg(rrd paramrrd) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    while (!rrd.a(this.a).contains(paramString1)) {
      return;
    }
    paramString2 = new bbmy(rrd.a(this.a));
    paramString2.d(2000);
    if (paramBoolean)
    {
      paramString2.a(bbmy.a(2));
      paramString2.c(2131626723);
      paramString2.b(rrd.a(this.a).getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(rrd.a(this.a), 5.0F));
    }
    for (;;)
    {
      rrd.a(this.a).remove(paramString1);
      return;
      paramString2.a(bbmy.a(1));
      paramString2.c(2131626724);
      paramString2.b(rrd.a(this.a).getResources().getDimensionPixelSize(2131167766) - (int)bacc.a(rrd.a(this.a), 5.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrg
 * JD-Core Version:    0.7.0.1
 */