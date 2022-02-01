package com.tencent.mobileqq.kandian.biz.comment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.util.NetworkState;

class ReadinjoyCommentListBaseAdapter$4$1
  implements DialogInterface.OnClickListener
{
  ReadinjoyCommentListBaseAdapter$4$1(ReadinjoyCommentListBaseAdapter.4 param4, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkState.isNetSupport())
    {
      if (this.c.d != null) {
        this.c.d.a(this.a, this.b, paramInt);
      }
    }
    else {
      QQToast.makeText(this.c.e.c, 1, HardCodeUtil.a(2131897902), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter.4.1
 * JD-Core Version:    0.7.0.1
 */