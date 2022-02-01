package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import avsq;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.io.Serializable;
import java.util.List;

final class PicEmoticonInfo$5
  implements Runnable
{
  PicEmoticonInfo$5(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon) {}
  
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
      Object localObject = (avsq)this.val$app.getManager(14);
      EmoticonPackage localEmoticonPackage = ((avsq)localObject).a(this.val$emoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject = ((avsq)localObject).a(localEmoticonPackage.childEpId);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
        }
      }
      this.val$context.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo.5
 * JD-Core Version:    0.7.0.1
 */