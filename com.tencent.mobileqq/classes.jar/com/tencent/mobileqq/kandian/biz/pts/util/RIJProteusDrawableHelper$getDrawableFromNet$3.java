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
  private int d;
  
  RIJProteusDrawableHelper$getDrawableFromNet$3(String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack, URLDrawable paramURLDrawable) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    paramInt = this.d;
    this.d = (paramInt + 1);
    if (paramInt < 3) {
      this.c.restartDownload();
    } else {
      this.b.onCallBack(false, (Drawable)this.c);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadFailed :");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  reTry: ");
    localStringBuilder.append(this.d);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadStarted()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadStarted :");
    localStringBuilder.append(this.a);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onFileDownloadSucceed :");
    localStringBuilder.append(this.a);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
    this.b.onCallBack(true, (Drawable)this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusDrawableHelper.getDrawableFromNet.3
 * JD-Core Version:    0.7.0.1
 */