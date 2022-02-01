package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.ReportController;

class EmoticonPanelCameraHelper$4
  implements DialogInterface.OnClickListener
{
  EmoticonPanelCameraHelper$4(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.val$context, FavEmosmManageActivity.class);
    paramDialogInterface.putExtra("camera_emo_mode", 1);
    this.val$context.startActivity(paramDialogInterface);
    ReportController.b(this.this$0.app.getAppRuntime(), "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.4
 * JD-Core Version:    0.7.0.1
 */