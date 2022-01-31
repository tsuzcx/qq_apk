import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ogs
  implements URLDrawable.URLDrawableListener
{
  ogs(ogr paramogr, String paramString) {}
  
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
      ogr.a(this.jdField_a_of_type_Ogr, new ogp(paramURLDrawable.getCurrDrawable(), ogr.a(this.jdField_a_of_type_Ogr), ogr.b(this.jdField_a_of_type_Ogr) - (ogr.c(this.jdField_a_of_type_Ogr) + ogr.d(this.jdField_a_of_type_Ogr))));
      ogr.a(this.jdField_a_of_type_Ogr).setImageDrawable(ogr.a(this.jdField_a_of_type_Ogr));
      ogr.a(this.jdField_a_of_type_Ogr, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ogs
 * JD-Core Version:    0.7.0.1
 */