package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class TeamWorkForceShare$ImageRequestTask$2
  implements Runnable
{
  TeamWorkForceShare$ImageRequestTask$2(TeamWorkForceShare.ImageRequestTask paramImageRequestTask) {}
  
  public void run()
  {
    TeamWorkForceShare.a(this.a.this$0).dismiss();
    QQToast.makeText(TeamWorkForceShare.c(this.a.this$0), HardCodeUtil.a(2131912121), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask.2
 * JD-Core Version:    0.7.0.1
 */