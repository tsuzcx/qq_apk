import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.qphone.base.util.QLog;

public class rph
  implements rpi
{
  static int jdField_a_of_type_Int;
  static int b;
  public Drawable a;
  ZImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView;
  private String jdField_a_of_type_JavaLangString = "zimage.DrawableController";
  rpg jdField_a_of_type_Rpg;
  rpk jdField_a_of_type_Rpk;
  spd jdField_a_of_type_Spd;
  private boolean jdField_a_of_type_Boolean = true;
  
  public rph(Drawable paramDrawable, ZImageView paramZImageView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView = paramZImageView;
    this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + ".v" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.hashCode());
  }
  
  public rpk a()
  {
    return this.jdField_a_of_type_Rpk;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_Rpk != null) {
      a("setPlaceHolder");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Rpk != null) {
      this.jdField_a_of_type_Rpk.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      rpq.a(this.jdField_a_of_type_JavaLangString, "detachFromWindow " + paramString + " " + this.jdField_a_of_type_Rpk + " " + this.jdField_a_of_type_Rpg);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.getDrawable() instanceof rpr))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    if (this.jdField_a_of_type_Rpg != null)
    {
      this.jdField_a_of_type_Rpg.a();
      this.jdField_a_of_type_Rpg = null;
    }
    if (this.jdField_a_of_type_Rpk != null)
    {
      rpj.a().a(this.jdField_a_of_type_Rpk, "reset");
      this.jdField_a_of_type_Rpk = null;
    }
  }
  
  public void a(rpk paramrpk)
  {
    bfwd.a("DrawableController.setImageRequest");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.a()) {
      paramrpk.c = 1;
    }
    jdField_a_of_type_Int += 1;
    a("resetUrl");
    rpg localrpg = rpj.a().a(paramrpk);
    if (localrpg == null)
    {
      this.jdField_a_of_type_Rpk = paramrpk;
      rpj.a().a(this.jdField_a_of_type_Rpk, this);
    }
    for (;;)
    {
      bfwd.a();
      return;
      b += 1;
      a(paramrpk, localrpg, false, "setImageRequest");
    }
  }
  
  public void a(rpk paramrpk, int paramInt)
  {
    if (this.jdField_a_of_type_Spd != null) {
      this.jdField_a_of_type_Spd.a(paramrpk.jdField_a_of_type_JavaNetURL, paramInt);
    }
  }
  
  public void a(rpk paramrpk, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Spd != null) {
      this.jdField_a_of_type_Spd.a(paramrpk.jdField_a_of_type_JavaNetURL, paramThrowable);
    }
  }
  
  public void a(rpk paramrpk, rpg paramrpg)
  {
    if ((paramrpk.equals(this.jdField_a_of_type_Rpk)) && (paramrpg.a() != null))
    {
      a(paramrpk, paramrpg, true, "onSuccess");
      return;
    }
    paramrpg.a();
  }
  
  void a(rpk paramrpk, rpg paramrpg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Rpk = paramrpk;
    if (QLog.isColorLevel()) {
      rpq.a(this.jdField_a_of_type_JavaLangString, "attachImage " + paramString + " " + this.jdField_a_of_type_Rpk + " " + paramrpg + " total:" + jdField_a_of_type_Int + " cache:" + b);
    }
    if (this.jdField_a_of_type_Rpg != null) {
      this.jdField_a_of_type_Rpg.a();
    }
    this.jdField_a_of_type_Rpg = paramrpg;
    paramString = new rpr(this.jdField_a_of_type_Rpg.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderZImageView.setImageDrawable(paramString, paramBoolean);
    if (this.jdField_a_of_type_Spd != null) {
      this.jdField_a_of_type_Spd.a(paramrpk.jdField_a_of_type_JavaNetURL, paramrpg);
    }
  }
  
  public void a(spd paramspd)
  {
    this.jdField_a_of_type_Spd = paramspd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      rpq.a(this.jdField_a_of_type_JavaLangString, "attachToWindow " + paramString + " " + this.jdField_a_of_type_Rpk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rph
 * JD-Core Version:    0.7.0.1
 */