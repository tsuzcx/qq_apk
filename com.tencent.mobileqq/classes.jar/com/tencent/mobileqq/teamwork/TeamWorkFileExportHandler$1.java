package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import ayej;
import ayfh;
import com.tencent.mobileqq.app.QQAppInterface;

public class TeamWorkFileExportHandler$1
  implements Runnable
{
  public TeamWorkFileExportHandler$1(ayej paramayej, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    if ((this.this$0.app == null) || (TextUtils.isEmpty(this.a))) {
      return;
    }
    ayfh.a(this.this$0.app, this.a, this.b, this.c, this.d, this.this$0.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileExportHandler.1
 * JD-Core Version:    0.7.0.1
 */