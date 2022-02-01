package com.tencent.mobileqq.emosm.favroaming;

import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class EmoBatchAddedCallback
  implements UpCallBack
{
  public int a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  EmoBatchAddedHandler jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler;
  
  public EmoBatchAddedCallback(QQAppInterface paramQQAppInterface, EmoBatchAddedHandler paramEmoBatchAddedHandler, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        ((EntityManager)localObject).update(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        ((EntityManager)localObject).close();
      }
    }
    ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(4);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
    }
  }
  
  public void a(int paramInt)
  {
    if ((400010 == paramInt) || (400011 == paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(3);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "EmoBatchAddedCallback  onSend() res=" + i);
    }
    if (i == 0) {
      a();
    }
    while (-1 != i) {
      return;
    }
    i = paramSendResult.b;
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 2, "add custom emotion result errCode=" + i);
    }
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback
 * JD-Core Version:    0.7.0.1
 */