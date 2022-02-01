package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class OlympicShareActionSheetHelper$4
  implements Runnable
{
  OlympicShareActionSheetHelper$4(OlympicShareActionSheetHelper paramOlympicShareActionSheetHelper, OlympicShareHelper.IShareFinishCallback paramIShareFinishCallback) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("temp_olympic_rank_share_");
    ((StringBuilder)localObject).append(this.this$0.b.getCurrentAccountUin());
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = OlympicShareHelper.a(BaseApplication.getContext(), (String)localObject, this.this$0.d);
      this.this$0.c.runOnUiThread(new OlympicShareActionSheetHelper.4.2(this, (String)localObject));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label77:
      break label77;
    }
    this.this$0.c.runOnUiThread(new OlympicShareActionSheetHelper.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.4
 * JD-Core Version:    0.7.0.1
 */