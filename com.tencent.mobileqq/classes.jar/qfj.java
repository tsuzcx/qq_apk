import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class qfj
  implements URLDrawable.URLDrawableListener
{
  int jdField_a_of_type_Int = 0;
  
  qfj(qfh paramqfh, String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    if (i < 3) {
      paramURLDrawable.restartDownload();
    }
    for (;;)
    {
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadFailed :" + this.jdField_a_of_type_JavaLangString + "  reTry: " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(false, paramURLDrawable);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onLoadSuccessed :" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfj
 * JD-Core Version:    0.7.0.1
 */