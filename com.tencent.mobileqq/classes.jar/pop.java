import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class pop
  implements URLDrawable.DownloadListener
{
  int jdField_a_of_type_Int = 0;
  
  pop(pom parampom, String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (paramInt + 1);
    if (paramInt < 3) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    }
    for (;;)
    {
      QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadFailed :" + this.jdField_a_of_type_JavaLangString + "  reTry: " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(false, this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
  }
  
  public void onFileDownloadStarted()
  {
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadStarted :" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    QLog.i("Q.readinjoy.proteus", 1, "getDrawable: onFileDownloadSucceed :" + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pop
 * JD-Core Version:    0.7.0.1
 */