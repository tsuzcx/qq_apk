package com.tencent.mobileqq.kandian.biz.pts.util;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/pts/util/RIJProteusDrawableHelper$getDrawableFromNet$3", "Lcom/tencent/image/URLDrawable$DownloadListener;", "reTry", "", "getReTry", "()I", "setReTry", "(I)V", "onFileDownloadFailed", "", "errorCode", "onFileDownloadStarted", "onFileDownloadSucceed", "l", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDrawableHelper$getDrawableFromNet$3
  implements URLDrawable.DownloadListener
{
  private int jdField_a_of_type_Int;
  
  RIJProteusDrawableHelper$getDrawableFromNet$3(String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    paramInt = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (paramInt + 1);
    if (paramInt < 3) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    } else {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(false, (Drawable)this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadFailed :");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("  reTry: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadStarted()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadStarted :");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadSucceed :");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewUtilsDrawableUtil$DrawableCallBack.onCallBack(true, (Drawable)this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusDrawableHelper.getDrawableFromNet.3
 * JD-Core Version:    0.7.0.1
 */