package com.tencent.tkd.comment.publisher.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tkd.comment.util.CommonUtil;

class BasePublishFragment$1
  extends ReportDialog
{
  BasePublishFragment$1(BasePublishFragment paramBasePublishFragment, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void dismiss()
  {
    CommonUtil.hideInputMethod(this.this$0.getActivity(), getCurrentFocus());
    super.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.base.BasePublishFragment.1
 * JD-Core Version:    0.7.0.1
 */