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
    QzoneHuangzuanVipIconShow.access$000(this.jdField_a_of_type_CooperationVipVipcomponentUiQzoneHuangzuanVipIconShow, paramInt, paramDrawable, this.jdField_a_of_type_Int, this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable, this.jdField_b_of_type_Int);
    if (this.mCount <= 0)
    {
      QzoneHuangzuanVipIconShow.access$100(this.jdField_a_of_type_CooperationVipVipcomponentUiQzoneHuangzuanVipIconShow, this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.d, this.jdField_b_of_type_Boolean, this.e);
      paramString1 = this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener;
      if (paramString1 != null) {
        paramString1.onLoaded(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable);
      }
    }
  }
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_CooperationVipVipcomponentUtilVipResourcesListener;
    if (paramString1 != null) {
      paramString1.onFailed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow.2
 * JD-Core Version:    0.7.0.1
 */