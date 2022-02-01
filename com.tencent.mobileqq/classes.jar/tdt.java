import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class tdt
  implements tdu
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  tds jdField_a_of_type_Tds;
  tdw jdField_a_of_type_Tdw;
  uwv jdField_a_of_type_Uwv;
  private boolean jdField_a_of_type_Boolean = true;
  
  public tdt(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  private void a(tds paramtds, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tds != null) {
      this.jdField_a_of_type_Tds.a();
    }
    this.jdField_a_of_type_Tds = paramtds;
    paramtds = new tee(this.jdField_a_of_type_Tds.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramtds, paramBoolean);
  }
  
  private boolean a(tds paramtds)
  {
    if ((this.jdField_a_of_type_Tds != null) && (paramtds != null) && (this.jdField_a_of_type_Tds.a() == paramtds.a())) {
      return (!(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof BitmapDrawable)) || (((BitmapDrawable)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable()).getBitmap() != this.jdField_a_of_type_Tds.a());
    }
    return true;
  }
  
  public tdw a()
  {
    return this.jdField_a_of_type_Tdw;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Tdw != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Tdw != null) {
      this.jdField_a_of_type_Tdw.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      ted.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Tdw + " " + this.jdField_a_of_type_Tds);
    }
    if (!a())
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof tee))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if (this.jdField_a_of_type_Tds != null)
      {
        this.jdField_a_of_type_Tds.a();
        this.jdField_a_of_type_Tds = null;
      }
    }
    if (this.jdField_a_of_type_Tdw != null)
    {
      tdv.a().a(this.jdField_a_of_type_Tdw, "reset");
      this.jdField_a_of_type_Tdw = null;
    }
  }
  
  public void a(tdw paramtdw)
  {
    bkpj.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.isRound()) {
      paramtdw.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    tds localtds = tdv.a().a(paramtdw);
    if (localtds == null)
    {
      this.jdField_a_of_type_Tdw = paramtdw;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      puv.a(this.jdField_a_of_type_Tdw);
      tdv.a().a(this.jdField_a_of_type_Tdw, this);
    }
    for (;;)
    {
      bkpj.a();
      return;
      b += 1;
      puw.b(1, paramtdw);
      a(paramtdw, localtds, false, "setImageRequest");
    }
  }
  
  public void a(tdw paramtdw, int paramInt)
  {
    if (this.jdField_a_of_type_Uwv != null) {
      this.jdField_a_of_type_Uwv.a(paramtdw.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(tdw paramtdw, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Uwv != null) {
      this.jdField_a_of_type_Uwv.a(paramtdw.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(tdw paramtdw, tds paramtds)
  {
    if ((paramtdw.equals(this.jdField_a_of_type_Tdw)) && (paramtds.a() != null))
    {
      a(paramtdw, paramtds, true, "onSuccess");
      return;
    }
    paramtds.a();
  }
  
  void a(tdw paramtdw, tds paramtds, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Tdw = paramtdw;
    if (QLog.isColorLevel()) {
      ted.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Tdw + " " + paramtds + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if ((!a()) || (a(paramtds))) {
      a(paramtds, paramBoolean);
    }
    this.jdField_a_of_type_Tdw.e = 0;
    puw.a(this.jdField_a_of_type_Tdw, true, "attached");
    if (this.jdField_a_of_type_Uwv != null) {
      this.jdField_a_of_type_Uwv.a(paramtdw.jdField_a_of_type_JavaNetURL, paramtds);
    }
  }
  
  public void a(uwv paramuwv)
  {
    this.jdField_a_of_type_Uwv = paramuwv;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return (puu.a.e()) && (ted.a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      ted.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Tdw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdt
 * JD-Core Version:    0.7.0.1
 */