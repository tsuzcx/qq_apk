package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.view.widget.TwoLineContentDialog;

public class ReadInJoyDialogUtil
{
  public static TwoLineContentDialog a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new TwoLineContentDialog(paramContext, 2131953338);
    paramContext.setContentView(2131629146);
    paramContext.setTitle(null);
    paramContext.setMessage(paramString1);
    paramContext.a(paramString2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyDialogUtil
 * JD-Core Version:    0.7.0.1
 */