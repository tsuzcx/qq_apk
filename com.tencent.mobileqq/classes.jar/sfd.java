import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class sfd
  implements sfe
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  sfc jdField_a_of_type_Sfc;
  sfg jdField_a_of_type_Sfg;
  tpv jdField_a_of_type_Tpv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public sfd(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  public sfg a()
  {
    return this.jdField_a_of_type_Sfg;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Sfg != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Sfg != null) {
      this.jdField_a_of_type_Sfg.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Sfg + " " + this.jdField_a_of_type_Sfc);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof sfn))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_a_of_type_Sfc != null)
    {
      this.jdField_a_of_type_Sfc.a();
      this.jdField_a_of_type_Sfc = null;
    }
    if (this.jdField_a_of_type_Sfg != null)
    {
      sff.a().a(this.jdField_a_of_type_Sfg, "reset");
      this.jdField_a_of_type_Sfg = null;
    }
  }
  
  public void a(sfg paramsfg)
  {
    biby.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a()) {
      paramsfg.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    sfc localsfc = sff.a().a(paramsfg);
    if (localsfc == null)
    {
      this.jdField_a_of_type_Sfg = paramsfg;
      sff.a().a(this.jdField_a_of_type_Sfg, this);
    }
    for (;;)
    {
      biby.a();
      return;
      b += 1;
      pdz.b(1, paramsfg);
      a(paramsfg, localsfc, false, "setImageRequest");
    }
  }
  
  public void a(sfg paramsfg, int paramInt)
  {
    if (this.jdField_a_of_type_Tpv != null) {
      this.jdField_a_of_type_Tpv.a(paramsfg.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(sfg paramsfg, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Tpv != null) {
      this.jdField_a_of_type_Tpv.a(paramsfg.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(sfg paramsfg, sfc paramsfc)
  {
    if ((paramsfg.equals(this.jdField_a_of_type_Sfg)) && (paramsfc.a() != null))
    {
      a(paramsfg, paramsfc, true, "onSuccess");
      return;
    }
    paramsfc.a();
  }
  
  void a(sfg paramsfg, sfc paramsfc, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Sfg = paramsfg;
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Sfg + " " + paramsfc + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if (this.jdField_a_of_type_Sfc != null) {
      this.jdField_a_of_type_Sfc.a();
    }
    this.jdField_a_of_type_Sfc = paramsfc;
    paramString = new sfn(this.jdField_a_of_type_Sfc.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramString, paramBoolean);
    pdz.a(this.jdField_a_of_type_Sfg, true, "attached");
    if (this.jdField_a_of_type_Tpv != null) {
      this.jdField_a_of_type_Tpv.a(paramsfg.jdField_a_of_type_JavaNetURL, paramsfc);
    }
  }
  
  public void a(tpv paramtpv)
  {
    this.jdField_a_of_type_Tpv = paramtpv;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      sfm.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Sfg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sfd
 * JD-Core Version:    0.7.0.1
 */