package com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SDCardMountInforUtil$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.MEDIA_MOUNTED".equals(paramContext)) || ("android.intent.action.MEDIA_SCANNER_STARTED".equals(paramContext)) || ("android.intent.action.MEDIA_SCANNER_FINISHED".equals(paramContext)) || ("android.intent.action.MEDIA_REMOVED".equals(paramContext)) || ("android.intent.action.MEDIA_UNMOUNTED".equals(paramContext)) || ("android.intent.action.MEDIA_BAD_REMOVAL".equals(paramContext))) {
      SDCardMountInforUtil.a(this.a, SDCardMountInforUtil.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.sdcardmountinforutil.SDCardMountInforUtil.1
 * JD-Core Version:    0.7.0.1
 */