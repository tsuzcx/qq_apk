package cooperation.vip.vipcomponent;

import android.graphics.drawable.Drawable;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class VipModule
{
  public static VipModule a;
  
  public static VipModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VipModule();
        }
      }
      finally {}
    }
    return a;
  }
  
  public Drawable a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, VipResourcesListener paramVipResourcesListener)
  {
    return QzoneHuangzuanVipIconShow.getInstance().getLayers(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramVipResourcesListener, 0);
  }
  
  public Drawable a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt3, VipResourcesListener paramVipResourcesListener)
  {
    return a(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString, paramInt3, 100, null, paramVipResourcesListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.VipModule
 * JD-Core Version:    0.7.0.1
 */