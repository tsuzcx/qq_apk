package com.tencent.mobileqq.data;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.util.WeakReference;

class MessageForGrayTips$HightlightClickableSpan$4
  implements DialogInterface.OnClickListener
{
  MessageForGrayTips$HightlightClickableSpan$4(MessageForGrayTips.HightlightClickableSpan paramHightlightClickableSpan) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.isNetSupport(MessageForGrayTips.HightlightClickableSpan.access$100(this.a)))
    {
      paramDialogInterface.dismiss();
      paramDialogInterface = this.a;
      MessageForGrayTips.HightlightClickableSpan.access$300(paramDialogInterface, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(paramDialogInterface).get(), MessageForGrayTips.HightlightClickableSpan.access$200(this.a).mMsgActionData);
      paramDialogInterface = this.a;
      MessageForGrayTips.HightlightClickableSpan.access$300(paramDialogInterface, (QQAppInterface)MessageForGrayTips.HightlightClickableSpan.access$000(paramDialogInterface).get(), this.a.frienduin);
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, 2131888422, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan.4
 * JD-Core Version:    0.7.0.1
 */