package com.tencent.mobileqq.qqlive.prepare;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.widget.FastResumeDialog.OnDialogClickListener;
import com.tencent.qphone.base.util.QLog;

class QQLivePrepareFragment$13
  implements FastResumeDialog.OnDialogClickListener
{
  QQLivePrepareFragment$13(QQLivePrepareFragment paramQQLivePrepareFragment, String paramString, QQLiveAnchorRecord paramQQLiveAnchorRecord) {}
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancel the anchor record uin ");
    localStringBuilder.append(this.a);
    QLog.d("QQLivePrepareFragment", 1, localStringBuilder.toString());
    QQLivePrepareFragment.q(this.c).getAnchorModule().removeAnchorRecord(this.a);
    QQLivePrepareFragment.r(this.c);
  }
  
  public void b()
  {
    QQLivePrepareFragment.a(this.c, this.b.roomId, this.b.programId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.13
 * JD-Core Version:    0.7.0.1
 */