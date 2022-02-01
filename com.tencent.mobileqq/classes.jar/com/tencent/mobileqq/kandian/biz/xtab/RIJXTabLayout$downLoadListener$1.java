package com.tencent.mobileqq.kandian.biz.xtab;

import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/xtab/RIJXTabLayout$downLoadListener$1", "Lcom/tencent/image/URLDrawable$DownloadListener;", "onFileDownloadFailed", "", "i", "", "onFileDownloadStarted", "onFileDownloadSucceed", "l", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabLayout$downLoadListener$1
  implements URLDrawable.DownloadListener
{
  public void onFileDownloadFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFileDownloadFailed!  i=");
    localStringBuilder.append(paramInt);
    QLog.d("RIJXTabLayout", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("downLoadListener success!  l=");
    localStringBuilder.append(paramLong);
    QLog.d("RIJXTabLayout", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabLayout.downLoadListener.1
 * JD-Core Version:    0.7.0.1
 */