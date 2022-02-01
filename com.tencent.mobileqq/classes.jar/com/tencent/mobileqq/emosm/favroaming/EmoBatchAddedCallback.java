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
  public int a;
  BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  EmoBatchAddedHandler jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler;
  
  public EmoBatchAddedCallback(BaseQQAppInterface paramBaseQQAppInterface, EmoBatchAddedHandler paramEmoBatchAddedHandler, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler = paramEmoBatchAddedHandler;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(EmoBatchAddedCallback paramEmoBatchAddedCallback)
  {
    if (paramEmoBatchAddedCallback != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      paramEmoBatchAddedCallback.b(localSendResult);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public IEmoBatchAddedHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "EmoBatchAddedCallback  handlePicResultOk()");
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
    {
      localObject = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr((byte[])localObject);
      localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        ((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        ((EntityManager)localObject).close();
      }
    }
    ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(4);
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if ((400010 != paramInt) && (400011 != paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(3);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(1);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EmoBatchAddedCallback  onSend() res=");
      localStringBuilder.append(i);
      QLog.d("EmoBatchAdded", 2, localStringBuilder.toString());
    }
    if (i == 0)
    {
      a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback
 * JD-Core Version:    0.7.0.1
 */