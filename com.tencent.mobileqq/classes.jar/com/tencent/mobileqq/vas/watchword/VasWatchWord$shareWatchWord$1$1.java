package com.tencent.mobileqq.vas.watchword;

import com.tencent.biz.qrcode.util.QRUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasWatchWord$shareWatchWord$1$1
  implements Runnable
{
  VasWatchWord$shareWatchWord$1$1(String paramString) {}
  
  public final void run()
  {
    VasWatchWord localVasWatchWord = VasWatchWord.a;
    String str = this.a;
    Intrinsics.checkExpressionValueIsNotNull(str, "sharemsg");
    localVasWatchWord.a(str);
    QRUtils.a(2, 2131720637);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.watchword.VasWatchWord.shareWatchWord.1.1
 * JD-Core Version:    0.7.0.1
 */