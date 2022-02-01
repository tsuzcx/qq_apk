package cooperation.vip.vipcomponent.ui;

import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import cooperation.vip.vipcomponent.util.ZipResLoadListener;

class QzoneHuangzuanVipIconShow$2
  extends ZipResLoadListener
{
  QzoneHuangzuanVipIconShow$2(QzoneHuangzuanVipIconShow paramQzoneHuangzuanVipIconShow, VipResourcesListener paramVipResourcesListener, int paramInt1, DiamondIconDrawable paramDiamondIconDrawable, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5) {}
  
  public void onDownloaded(String paramString1, int paramInt, String paramString2, Drawable paramDrawable)
  {
    QzoneHuangzuanVipIconShow.access$000(this.k, paramInt, paramDrawable, this.b, this.c, this.d);
    if (this.mCount <= 0)
    {
      QzoneHuangzuanVipIconShow.access$100(this.k, this.c, this.e, this.b, this.d, this.f, this.g, this.h, this.i, this.j);
      paramString1 = this.a;
      if (paramString1 != null) {
        paramString1.onLoaded(this.c);
      }
    }
  }
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.onFailed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow.2
 * JD-Core Version:    0.7.0.1
 */