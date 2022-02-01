package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class TogetherBusinessForWebPlugin$2
  implements DialogInterface.OnClickListener
{
  TogetherBusinessForWebPlugin$2(TogetherBusinessForWebPlugin paramTogetherBusinessForWebPlugin, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin.2
 * JD-Core Version:    0.7.0.1
 */