package com.tencent.mobileqq.kandian.biz.pts.util;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil.DrawableCallBack;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/pts/util/RIJProteusDrawableHelper$getDrawableFromNet$2", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "reTry", "", "getReTry", "()I", "setReTry", "(I)V", "onLoadCanceled", "", "drawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "cause", "", "onLoadProgressed", "progress", "onLoadSuccessed", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDrawableHelper$getDrawableFromNet$2
  implements URLDrawable.URLDrawableListener
{
  private int c;
  
  RIJProteusDrawableHelper$getDrawableFromNet$2(String paramString, DrawableUtil.DrawableCallBack paramDrawableCallBack) {}
  
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "cause");
    int i = this.c;
    this.c = (i + 1);
    if (i < 3) {
      paramURLDrawable.restartDownload();
    } else {
      this.b.onCallBack(false, (Drawable)paramURLDrawable);
    }
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("getDrawable: onFileDownloadFailed :");
    paramURLDrawable.append(this.a);
    paramURLDrawable.append("  reTry: ");
    paramURLDrawable.append(this.c);
    QLog.i("Q.readinjoy.proteus", 1, paramURLDrawable.toString());
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "drawable");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDrawable: onLoadSuccessed :");
    localStringBuilder.append(this.a);
    QLog.i("Q.readinjoy.proteus", 1, localStringBuilder.toString());
    this.b.onCallBack(true, (Drawable)paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusDrawableHelper.getDrawableFromNet.2
 * JD-Core Version:    0.7.0.1
 */