package com.tencent.mobileqq.multimsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

class MultiMsgManager$MsgForwardWXUploadCallback
  implements UpCallBack
{
  WeakReference<QQAppInterface> a;
  MessageRecord b;
  String c;
  int d;
  ArrayList<MessageRecord> e;
  HashMap<String, String> f;
  
  public MultiMsgManager$MsgForwardWXUploadCallback(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = paramMessageRecord;
    this.c = paramString;
    this.d = paramInt;
    this.e = paramArrayList;
    this.f = paramHashMap;
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(-1);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return localBitmap;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    Object localObject1;
    if (paramSendResult.a == 0) {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("send real struct msg for weixin done, cost : ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - MultiMsgManager.k());
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        if (this.d == 0) {
          localObject1 = String.format(((QQAppInterface)this.a.get()).getApplication().getString(2131891950), new Object[] { ContactUtils.a((QQAppInterface)this.a.get(), ((QQAppInterface)this.a.get()).getCurrentUin()), ContactUtils.a((QQAppInterface)this.a.get(), this.c) });
        } else {
          localObject1 = String.format(((QQAppInterface)this.a.get()).getApplication().getString(2131891951), new Object[] { ContactUtils.a((AppInterface)this.a.get(), this.c, this.d) });
        }
        String str2 = this.b.msg;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://mma.qq.com/jumpqq/forward2.html?rId=");
        ((StringBuilder)localObject2).append(paramSendResult.f);
        ((StringBuilder)localObject2).append("&fName=");
        ((StringBuilder)localObject2).append(paramSendResult.g);
        String str1 = ((StringBuilder)localObject2).toString();
        if (this.d == 1)
        {
          i = 4;
        }
        else
        {
          if (this.d != 3000) {
            break label642;
          }
          i = 101;
        }
        Object localObject3 = ((QQAppInterface)this.a.get()).getFaceBitmap(i, this.c, (byte)1, false, 0);
        if (localObject3 == null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "send to weixin icon != null  ");
        }
        localObject2 = localObject3;
        if (this.d == 3000) {
          localObject2 = a((Bitmap)localObject3);
        }
        localObject3 = String.valueOf(System.currentTimeMillis());
        WXShareHelper.a().d((String)localObject3, (String)localObject1, (Bitmap)localObject2, str2, str1);
        long l = paramSendResult.f.hashCode();
        paramSendResult = this.e.iterator();
        if (paramSendResult.hasNext())
        {
          ((MessageRecord)paramSendResult.next()).msgseq = l;
          continue;
        }
        ((QQAppInterface)this.a.get()).getProxyManager().b().a(this.e, null);
        MultiMsgManager.a().a(this.f, l, (QQAppInterface)this.a.get());
        ((MessageHandler)((QQAppInterface)this.a.get()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(8031, false, Integer.valueOf(0));
        if (QLog.isColorLevel())
        {
          paramSendResult = new StringBuilder();
          paramSendResult.append("shareToWXFriend.transaction: ");
          paramSendResult.append((String)localObject3);
          paramSendResult.append(", shareLink:");
          paramSendResult.append(str1);
          QLog.i("MultiMsg_TAG", 2, paramSendResult.toString());
          return;
        }
      }
      catch (Exception paramSendResult)
      {
        paramSendResult.printStackTrace();
      }
      return;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("upload multi msg pack failed, result.errStr=");
        ((StringBuilder)localObject1).append(paramSendResult.b);
        ((StringBuilder)localObject1).append(",result.errStr=");
        ((StringBuilder)localObject1).append(paramSendResult.c);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      ((MessageHandler)((QQAppInterface)this.a.get()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(8031, false, Integer.valueOf(5));
      return;
      label642:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.MultiMsgManager.MsgForwardWXUploadCallback
 * JD-Core Version:    0.7.0.1
 */