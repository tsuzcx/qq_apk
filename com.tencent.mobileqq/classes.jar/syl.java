import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class syl
  implements sym
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  public syk a;
  syo jdField_a_of_type_Syo;
  vgd jdField_a_of_type_Vgd;
  private boolean jdField_a_of_type_Boolean = true;
  
  public syl(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  private void a(syk paramsyk, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Syk != null) {
      this.jdField_a_of_type_Syk.a();
    }
    this.jdField_a_of_type_Syk = paramsyk;
    paramsyk = new syw(this.jdField_a_of_type_Syk.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramsyk, paramBoolean);
  }
  
  private boolean a(syk paramsyk)
  {
    if ((this.jdField_a_of_type_Syk != null) && (paramsyk != null) && (this.jdField_a_of_type_Syk.a() == paramsyk.a())) {
      return (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_Syk.a());
    }
    return true;
  }
  
  public syo a()
  {
    return this.jdField_a_of_type_Syo;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Syo != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Syo != null) {
      this.jdField_a_of_type_Syo.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      syv.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Syo + " " + this.jdField_a_of_type_Syk);
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof syw))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (this.jdField_a_of_type_Syk != null)
      {
        this.jdField_a_of_type_Syk.a();
        this.jdField_a_of_type_Syk = null;
      }
    }
    if (this.jdField_a_of_type_Syo != null)
    {
      syn.a().a(this.jdField_a_of_type_Syo, "reset");
      this.jdField_a_of_type_Syo = null;
    }
  }
  
  public void a(syo paramsyo)
  {
    bjun.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.isRound()) {
      paramsyo.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    syk localsyk = syn.a().a(paramsyo);
    if (localsyk == null)
    {
      this.jdField_a_of_type_Syo = paramsyo;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      pso.a(this.jdField_a_of_type_Syo);
      syn.a().a(this.jdField_a_of_type_Syo, this);
    }
    for (;;)
    {
      bjun.a();
      return;
      b += 1;
      psp.b(1, paramsyo);
      a(paramsyo, localsyk, false, "setImageRequest");
    }
  }
  
  public void a(syo paramsyo, int paramInt)
  {
    if (this.jdField_a_of_type_Vgd != null) {
      this.jdField_a_of_type_Vgd.a(paramsyo.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(syo paramsyo, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Vgd != null) {
      this.jdField_a_of_type_Vgd.a(paramsyo.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(syo paramsyo, syk paramsyk)
  {
    if ((paramsyo.equals(this.jdField_a_of_type_Syo)) && (paramsyk.a() != null))
    {
      a(paramsyo, paramsyk, true, "onSuccess");
      return;
    }
    paramsyk.a();
  }
  
  void a(syo paramsyo, syk paramsyk, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Syo = paramsyo;
    if (QLog.isColorLevel()) {
      syv.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Syo + " " + paramsyk + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if ((!a()) || (a(paramsyk))) {
      a(paramsyk, paramBoolean);
    }
    if (this.jdField_a_of_type_Syo != null)
    {
      this.jdField_a_of_type_Syo.e = 0;
      psp.a(this.jdField_a_of_type_Syo, true, "attached");
    }
    if (this.jdField_a_of_type_Vgd != null) {
      this.jdField_a_of_type_Vgd.a(paramsyo.jdField_a_of_type_JavaNetURL, paramsyk);
    }
  }
  
  public void a(vgd paramvgd)
  {
    this.jdField_a_of_type_Vgd = paramvgd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (psn.a.e()) && (syv.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      syv.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Syo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syl
 * JD-Core Version:    0.7.0.1
 */