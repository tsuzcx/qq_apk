package com.tencent.mobileqq.kandian.biz.fastweb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;

class FastWebActivity$17
  implements DialogInterface.OnDismissListener
{
  FastWebActivity$17(FastWebActivity paramFastWebActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!FastWebActivity.b(this.a))
    {
      Context localContext = this.a.getApplicationContext();
      if (FastWebActivity.c(this.a)) {
        paramDialogInterface = "0X8008994";
      } else {
        paramDialogInterface = "0X800898D";
      }
      FastWebShareUtils.a(localContext, paramDialogInterface, 11, this.a.a);
      paramDialogInterface = this.a;
      ReportUtil.a(paramDialogInterface, paramDialogInterface.getAppInterface(), this.a.a, -1, -1, true, false);
    }
    FastWebActivity.c(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.17
 * JD-Core Version:    0.7.0.1
 */