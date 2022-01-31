package com.tencent.mobileqq.emosm.favroaming;

import acha;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class EmoAddedAuthCallback
  implements Handler.Callback, UpCallBack
{
  int jdField_a_of_type_Int;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler;
  public QQAppInterface a;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  
  public EmoAddedAuthCallback(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramStructMsgForImageShare;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    if (i == 0) {
      if (this.jdField_a_of_type_Int == 0)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5)))
        {
          paramSendResult = MD5.getFileMd5(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.emoPath);
          this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5 = HexUtil.bytes2HexStr(paramSendResult);
          paramSendResult = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramSendResult != null)
          {
            paramSendResult.a(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
            paramSendResult.a();
          }
        }
        ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(148)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
          AIOGalleryUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        paramSendResult = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramSendResult != null) {
          paramSendResult.obtainMessage(10).sendToTarget();
        }
      }
    }
    label163:
    do
    {
      do
      {
        do
        {
          break label163;
          do
          {
            return;
          } while (1 != this.jdField_a_of_type_Int);
          return;
        } while (-1 != i);
        i = paramSendResult.b;
      } while (this.jdField_a_of_type_Int != 0);
      if (400010 == i)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return;
      }
    } while (400011 != i);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = new acha(this);
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (!((BaseActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
      {
        paramMessage = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, "温馨提示", this.jdField_a_of_type_AndroidContentContext.getString(2131434513), "取消", "立即开通", paramMessage, paramMessage);
        if (paramMessage != null)
        {
          paramMessage.show();
          continue;
          if (this.jdField_a_of_type_AndroidContentContext != null)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131434512, 0).b(2131558448);
            continue;
            if (this.jdField_a_of_type_AndroidContentContext != null) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131434511, 0).b(2131558448);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback
 * JD-Core Version:    0.7.0.1
 */