import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class rpe
  implements rpf
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  rpd jdField_a_of_type_Rpd;
  rph jdField_a_of_type_Rph;
  spa jdField_a_of_type_Spa;
  private boolean jdField_a_of_type_Boolean = true;
  
  public rpe(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  public rph a()
  {
    return this.jdField_a_of_type_Rph;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Rph != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Rph != null) {
      this.jdField_a_of_type_Rph.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Rph + " " + this.jdField_a_of_type_Rpd);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof rpo))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_a_of_type_Rpd != null)
    {
      this.jdField_a_of_type_Rpd.a();
      this.jdField_a_of_type_Rpd = null;
    }
    if (this.jdField_a_of_type_Rph != null)
    {
      rpg.a().a(this.jdField_a_of_type_Rph, "reset");
      this.jdField_a_of_type_Rph = null;
    }
  }
  
  public void a(rph paramrph)
  {
    bfwu.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a()) {
      paramrph.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    rpd localrpd = rpg.a().a(paramrph);
    if (localrpd == null)
    {
      this.jdField_a_of_type_Rph = paramrph;
      rpg.a().a(this.jdField_a_of_type_Rph, this);
    }
    for (;;)
    {
      bfwu.a();
      return;
      b += 1;
      a(paramrph, localrpd, false, "setImageRequest");
    }
  }
  
  public void a(rph paramrph, int paramInt)
  {
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.a(paramrph.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(rph paramrph, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.a(paramrph.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(rph paramrph, rpd paramrpd)
  {
    if ((paramrph.equals(this.jdField_a_of_type_Rph)) && (paramrpd.a() != null))
    {
      a(paramrph, paramrpd, true, "onSuccess");
      return;
    }
    paramrpd.a();
  }
  
  void a(rph paramrph, rpd paramrpd, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Rph = paramrph;
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Rph + " " + paramrpd + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if (this.jdField_a_of_type_Rpd != null) {
      this.jdField_a_of_type_Rpd.a();
    }
    this.jdField_a_of_type_Rpd = paramrpd;
    paramString = new rpo(this.jdField_a_of_type_Rpd.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramString, paramBoolean);
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.a(paramrph.jdField_a_of_type_JavaNetURL, paramrpd);
    }
  }
  
  public void a(spa paramspa)
  {
    this.jdField_a_of_type_Spa = paramspa;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      rpn.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Rph);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpe
 * JD-Core Version:    0.7.0.1
 */