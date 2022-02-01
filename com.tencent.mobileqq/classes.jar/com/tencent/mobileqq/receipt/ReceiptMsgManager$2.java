package com.tencent.mobileqq.receipt;

import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class ReceiptMsgManager$2
  implements Runnable
{
  ReceiptMsgManager$2(ReceiptMsgManager paramReceiptMsgManager, ArrayList paramArrayList, Bundle paramBundle, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if ((localObject instanceof MessageForPic))
      {
        MessageForPic localMessageForPic = (MessageForPic)localObject;
        if (new File(localMessageForPic.path).exists())
        {
          int i = this.b.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
          ReceiptMsgManager.a(this.this$0, localMessageForPic, i);
          localMessageForPic.md5 = ReceiptMsgManager.a(this.this$0, localMessageForPic.path);
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localOptions.inSampleSize = 1;
          SafeBitmapFactory.decodeFile(localMessageForPic.path, localOptions);
          localMessageForPic.width = localOptions.outWidth;
          localMessageForPic.height = localOptions.outHeight;
          ReceiptMsgManager.b(this.c, (MessageRecord)localObject, Integer.toString(i));
          if (RichMediaUtil.isPicLandscape(localMessageForPic.path))
          {
            localMessageForPic.width = localOptions.outHeight;
            localMessageForPic.height = localOptions.outWidth;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(" pic is Landscape,swap w,h; options.outWidth = ");
              ((StringBuilder)localObject).append(localOptions.outWidth);
              ((StringBuilder)localObject).append(",options.outHeight = ");
              ((StringBuilder)localObject).append(localOptions.outHeight);
              ((StringBuilder)localObject).append(",mr.width = ");
              ((StringBuilder)localObject).append(localMessageForPic.width);
              ((StringBuilder)localObject).append(",mr.height = ");
              ((StringBuilder)localObject).append(localMessageForPic.height);
              QLog.d("ReceiptMsgManager", 2, new Object[] { "packMsg", ((StringBuilder)localObject).toString() });
            }
          }
        }
      }
    }
    ReceiptMsgManager.a(this.this$0, this.c, this.d.b, this.d.a, this.d.c, ReceiptMsgManager.a(this.this$0, 2), false, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMsgManager.2
 * JD-Core Version:    0.7.0.1
 */