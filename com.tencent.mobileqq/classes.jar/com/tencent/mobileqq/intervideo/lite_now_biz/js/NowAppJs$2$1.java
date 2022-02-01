package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.UITools;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;

class NowAppJs$2$1
  implements DialogInterface.OnClickListener
{
  NowAppJs$2$1(NowAppJs.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UITools.a((AudienceRoomActivity)NowAppJs.access$100(this.a.b));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs.2.1
 * JD-Core Version:    0.7.0.1
 */