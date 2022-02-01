package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;

class EmojiJsPlugin$5
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$5(EmojiJsPlugin paramEmojiJsPlugin, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Bundle();
    paramDialogInterface.putInt("id", this.val$emoPackId);
    paramDialogInterface.putInt("businessType", this.val$businessType);
    paramDialogInterface.putInt("sceneType", this.val$sceneType);
    paramDialogInterface = DataFactory.a("startDownloadEmoji", this.val$callbackid, this.this$0.mOnRemoteResp.key, paramDialogInterface);
    this.this$0.addDownloadingStateObserver(new Pair(Integer.valueOf(this.val$emoPackId), this.val$callbackid));
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */