package com.tencent.mobileqq.onlinestatus.olympic.helper;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class OlympicShareActionSheetHelper$7
  implements Runnable
{
  OlympicShareActionSheetHelper$7(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, int paramInt, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("temp_olympic_rank_share_");
    ((StringBuilder)localObject).append(this.this$0.b.getCurrentAccountUin());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    localObject = OlympicShareHelper.a(this.this$0.c, (String)localObject, this.this$0.d);
    ThreadManager.getUIHandler().post(new OlympicShareActionSheetHelper.7.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.7
 * JD-Core Version:    0.7.0.1
 */