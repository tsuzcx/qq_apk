package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import java.io.Serializable;
import java.util.List;

final class PicEmoticonInfoSender$4
  implements Runnable
{
  PicEmoticonInfoSender$4(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.val$app != null) && (this.val$context != null))
    {
      Intent localIntent = new Intent(this.val$context, H5MagicPlayerActivity.class);
      localIntent.putExtra("clickTime", System.currentTimeMillis());
      localIntent.putExtra("autoPlay", "1");
      localIntent.putExtra("senderUin", this.val$app.getCurrentAccountUin());
      localIntent.putExtra("selfUin", this.val$app.getCurrentAccountUin());
      localIntent.putExtra("sessionInfo", this.val$sessionInfo);
      localIntent.putExtra("emoticon", this.val$emoticon);
      Object localObject = (EmoticonManager)this.val$app.getManager(QQManagerFactory.EMOTICON_MANAGER);
      EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject).a(this.val$emoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject = ((EmoticonManager)localObject).a(localEmoticonPackage.childEpId);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
        }
      }
      this.val$context.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender.4
 * JD-Core Version:    0.7.0.1
 */