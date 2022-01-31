import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class rct
  implements rcu
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  rcs jdField_a_of_type_Rcs;
  rcw jdField_a_of_type_Rcw;
  sch jdField_a_of_type_Sch;
  private boolean jdField_a_of_type_Boolean = true;
  
  public rct(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  public rcw a()
  {
    return this.jdField_a_of_type_Rcw;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Rcw != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Rcw != null) {
      this.jdField_a_of_type_Rcw.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      rdc.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Rcw + " " + this.jdField_a_of_type_Rcs);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof rdd))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_a_of_type_Rcs != null)
    {
      this.jdField_a_of_type_Rcs.a();
      this.jdField_a_of_type_Rcs = null;
    }
    if (this.jdField_a_of_type_Rcw != null)
    {
      rcv.a().a(this.jdField_a_of_type_Rcw, "reset");
      this.jdField_a_of_type_Rcw = null;
    }
  }
  
  public void a(rcw paramrcw)
  {
    beoj.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a()) {
      paramrcw.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    rcs localrcs = rcv.a().a(paramrcw);
    if (localrcs == null)
    {
      this.jdField_a_of_type_Rcw = paramrcw;
      rcv.a().a(this.jdField_a_of_type_Rcw, this);
    }
    for (;;)
    {
      beoj.a();
      return;
      b += 1;
      a(paramrcw, localrcs, false, "setImageRequest");
    }
  }
  
  public void a(rcw paramrcw, int paramInt)
  {
    if (this.jdField_a_of_type_Sch != null) {
      this.jdField_a_of_type_Sch.a(paramrcw.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(rcw paramrcw, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Sch != null) {
      this.jdField_a_of_type_Sch.a(paramrcw.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(rcw paramrcw, rcs paramrcs)
  {
    if ((paramrcw.equals(this.jdField_a_of_type_Rcw)) && (paramrcs.a() != null))
    {
      a(paramrcw, paramrcs, true, "onSuccess");
      return;
    }
    paramrcs.a();
  }
  
  void a(rcw paramrcw, rcs paramrcs, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Rcw = paramrcw;
    if (QLog.isColorLevel()) {
      rdc.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Rcw + " " + paramrcs + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if (this.jdField_a_of_type_Rcs != null) {
      this.jdField_a_of_type_Rcs.a();
    }
    this.jdField_a_of_type_Rcs = paramrcs;
    paramString = new rdd(this.jdField_a_of_type_Rcs.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramString, paramBoolean);
    if (this.jdField_a_of_type_Sch != null) {
      this.jdField_a_of_type_Sch.a(paramrcw.jdField_a_of_type_JavaNetURL, paramrcs);
    }
  }
  
  public void a(sch paramsch)
  {
    this.jdField_a_of_type_Sch = paramsch;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      rdc.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Rcw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rct
 * JD-Core Version:    0.7.0.1
 */