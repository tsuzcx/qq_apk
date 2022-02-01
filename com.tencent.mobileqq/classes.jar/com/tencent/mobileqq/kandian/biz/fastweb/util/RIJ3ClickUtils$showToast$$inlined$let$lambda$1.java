package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/fastweb/util/RIJ3ClickUtils$showToast$1$1"}, k=3, mv={1, 1, 16})
final class RIJ3ClickUtils$showToast$$inlined$let$lambda$1
  implements Runnable
{
  RIJ3ClickUtils$showToast$$inlined$let$lambda$1(String paramString, BaseApplication paramBaseApplication, boolean paramBoolean) {}
  
  public final void run()
  {
    Context localContext = (Context)this.b;
    int i;
    if (this.c) {
      i = 2;
    } else {
      i = 1;
    }
    QQToast.makeText(localContext, i, (CharSequence)this.a, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJ3ClickUtils.showToast..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */