import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class nrq
  implements URLDrawable.URLDrawableListener
{
  nrq(nrp paramnrp, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadCanceled:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadFialed:" + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadSuccessed:" + this.jdField_a_of_type_JavaLangString);
    }
    if (paramURLDrawable != null)
    {
      nrp.a(this.jdField_a_of_type_Nrp, new nrn(paramURLDrawable.getCurrDrawable(), nrp.a(this.jdField_a_of_type_Nrp), nrp.b(this.jdField_a_of_type_Nrp) - (nrp.c(this.jdField_a_of_type_Nrp) + nrp.d(this.jdField_a_of_type_Nrp))));
      nrp.a(this.jdField_a_of_type_Nrp).setImageDrawable(nrp.a(this.jdField_a_of_type_Nrp));
      nrp.a(this.jdField_a_of_type_Nrp, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrq
 * JD-Core Version:    0.7.0.1
 */