package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.qphone.base.util.QLog;

class EmojiUiPlugin$1
  extends OnRemoteRespObserver
{
  EmojiUiPlugin$1(EmojiUiPlugin paramEmojiUiPlugin) {}
  
  public void onBindedToClient()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.EmojiUiPlugin", 2, "onBindedToClient");
    }
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.key))
    {
      Object localObject = paramBundle.getString("cmd");
      Bundle localBundle = paramBundle.getBundle("response");
      int k = paramBundle.getInt("failcode");
      if ((localObject != null) && ("writeQFaceResult".equals(localObject)))
      {
        int i = -1;
        int j = localBundle.getInt("result", -1);
        paramBundle = localBundle.getString("messge");
        if (k != 1000) {
          paramBundle = "QFaceResult error";
        } else {
          i = j;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("write qface result, result:");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" msg:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.d("Q.emoji.EmoQFace", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */