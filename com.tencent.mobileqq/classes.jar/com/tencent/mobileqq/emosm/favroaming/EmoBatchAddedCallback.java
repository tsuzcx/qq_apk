package com.tencent.mobileqq.emosm.favroaming;

import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class EmoBatchAddedCallback
  implements IEmoBatchAddedCallback, UpCallBack
{
  BaseQQAppInterface a;
  CustomEmotionData b;
  EmoBatchAddedHandler c;
  public int d;
  
  public EmoBatchAddedCallback(BaseQQAppInterface paramBaseQQAppInterface, EmoBatchAddedHandler paramEmoBatchAddedHandler, int paramInt)
  {
    this.a = paramBaseQQAppInterface;
    this.c = paramEmoBatchAddedHandler;
    this.d = paramInt;
  }
  
  public static void a(EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    if (paramEmoBatchAddedCallback != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      paramEmoBatchAddedCallback.b(localSendResult);
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public IEmoBatchAddedHandler a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if ((400010 != paramInt) && (400011 != paramInt))
    {
      this.c.b(3);
      return;
    }
    this.c.b(1);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    this.b = paramCustomEmotionData;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "EmoBatchAddedCallback  handlePicResultOk()");
    }
    if ((!this.b.isMarkFace) && (TextUtils.isEmpty(this.b.md5)))
    {
      localObject = MD5.getFileMd5(this.b.emoPath);
      this.b.md5 = HexUtil.bytes2HexStr((byte[])localObject);
      localObject = this.a.getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        ((EntityManager)localObject).update(this.b);
        ((EntityManager)localObject).close();
      }
    }
    ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.b);
    this.c.b(4);
    Object localObject = this.a.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.a;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EmoBatchAddedCallback  onSend() res=");
      localStringBuilder.append(i);
      QLog.d("EmoBatchAdded", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      b();
      return;
    }
    if (-1 == i)
    {
      i = paramSendResult.b;
      if (QLog.isColorLevel())
      {
        paramSendResult = new StringBuilder();
        paramSendResult.append("add custom emotion result errCode=");
        paramSendResult.append(i);
        QLog.d("EmoBatchAdded", 2, paramSendResult.toString());
      }
      a(i);
    }
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback
 * JD-Core Version:    0.7.0.1
 */