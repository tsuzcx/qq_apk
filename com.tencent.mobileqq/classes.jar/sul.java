import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class sul
  implements sum
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  public suk a;
  suo jdField_a_of_type_Suo;
  uyg jdField_a_of_type_Uyg;
  private boolean jdField_a_of_type_Boolean = true;
  
  public sul(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  private void a(suk paramsuk, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Suk != null) {
      this.jdField_a_of_type_Suk.a();
    }
    this.jdField_a_of_type_Suk = paramsuk;
    paramsuk = new suw(this.jdField_a_of_type_Suk.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramsuk, paramBoolean);
  }
  
  private boolean a(suk paramsuk)
  {
    if ((this.jdField_a_of_type_Suk != null) && (paramsuk != null) && (this.jdField_a_of_type_Suk.a() == paramsuk.a())) {
      return (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_Suk.a());
    }
    return true;
  }
  
  public suo a()
  {
    return this.jdField_a_of_type_Suo;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Suo != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Suo != null) {
      this.jdField_a_of_type_Suo.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      suv.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Suo + " " + this.jdField_a_of_type_Suk);
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof suw))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (this.jdField_a_of_type_Suk != null)
      {
        this.jdField_a_of_type_Suk.a();
        this.jdField_a_of_type_Suk = null;
      }
    }
    if (this.jdField_a_of_type_Suo != null)
    {
      sun.a().a(this.jdField_a_of_type_Suo, "reset");
      this.jdField_a_of_type_Suo = null;
    }
  }
  
  public void a(suo paramsuo)
  {
    blqm.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.isRound()) {
      paramsuo.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    suk localsuk = sun.a().a(paramsuo);
    if (localsuk == null)
    {
      this.jdField_a_of_type_Suo = paramsuo;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      pni.a(this.jdField_a_of_type_Suo);
      sun.a().a(this.jdField_a_of_type_Suo, this);
    }
    for (;;)
    {
      blqm.a();
      return;
      b += 1;
      pnj.b(1, paramsuo);
      a(paramsuo, localsuk, false, "setImageRequest");
    }
  }
  
  public void a(suo paramsuo, int paramInt)
  {
    if (this.jdField_a_of_type_Uyg != null) {
      this.jdField_a_of_type_Uyg.a(paramsuo.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(suo paramsuo, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Uyg != null) {
      this.jdField_a_of_type_Uyg.a(paramsuo.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(suo paramsuo, suk paramsuk)
  {
    if ((paramsuo.equals(this.jdField_a_of_type_Suo)) && (paramsuk.a() != null))
    {
      a(paramsuo, paramsuk, true, "onSuccess");
      return;
    }
    paramsuk.a();
  }
  
  void a(suo paramsuo, suk paramsuk, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Suo = paramsuo;
    if (QLog.isColorLevel()) {
      suv.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Suo + " " + paramsuk + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if ((!a()) || (a(paramsuk))) {
      a(paramsuk, paramBoolean);
    }
    this.jdField_a_of_type_Suo.e = 0;
    pnj.a(this.jdField_a_of_type_Suo, true, "attached");
    if (this.jdField_a_of_type_Uyg != null) {
      this.jdField_a_of_type_Uyg.a(paramsuo.jdField_a_of_type_JavaNetURL, paramsuk);
    }
  }
  
  public void a(uyg paramuyg)
  {
    this.jdField_a_of_type_Uyg = paramuyg;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (pnh.a.e()) && (suv.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      suv.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Suo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sul
 * JD-Core Version:    0.7.0.1
 */