package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class EmoAddedAuthCallback
  implements Handler.Callback, UpCallBack
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  StructMsgForImageShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare;
  private WeakReference<EmoAddedAuthCallback.UploadListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public EmoAddedAuthCallback(QQAppInterface paramQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, StructMsgForImageShare paramStructMsgForImageShare, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = paramStructMsgForImageShare;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = new EmoAddedAuthCallback.3(paramQQAppInterface, paramContext);
      if ((paramContext instanceof BaseActivity))
      {
        if (!((BaseActivity)paramContext).isFinishing())
        {
          paramQQAppInterface = DialogUtil.a(paramContext, 0, "温馨提示", paramContext.getString(2131689615), "取消", "立即开通", paramQQAppInterface, paramQQAppInterface);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.show();
          }
        }
        EmoticonManager.c("2007", 1);
      }
    }
    while (paramInt != 2) {
      for (;;)
      {
        return;
        QQToast.a(paramContext, paramContext.getString(2131689616), 0).b(2131299166);
      }
    }
    QQToast.a(paramContext, paramContext.getString(2131689616), 0).b(2131299166);
    EmoticonManager.c("2007", 1);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void a()
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755842);
    localReportDialog.setContentView(2131559199);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365768);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365772);
    localButton1.setOnClickListener(new EmoAddedAuthCallback.1(this, localReportDialog));
    localButton2.setOnClickListener(new EmoAddedAuthCallback.2(this, localReportDialog));
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
    {
      SharedPreUtils.w(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
      localReportDialog.show();
    }
  }
  
  protected void a(int paramInt)
  {
    if (400010 == paramInt) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    while (400011 != paramInt) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    b(paramQQAppInterface, paramContext, paramInt);
  }
  
  public void a(EmoAddedAuthCallback.UploadListener paramUploadListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramUploadListener);
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
    }
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
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
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare != null) {
        AIOGalleryUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
    }
    label168:
    do
    {
      do
      {
        do
        {
          break label168;
          do
          {
            return;
          } while (1 == this.jdField_a_of_type_Int);
          if (2 != this.jdField_a_of_type_Int) {
            break;
          }
          ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        } while ((2 != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
        localObject = (EmoAddedAuthCallback.UploadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      ((EmoAddedAuthCallback.UploadListener)localObject).a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      return;
    } while (3 != this.jdField_a_of_type_Int);
    ((FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  protected void b(int paramInt)
  {
    EmoAddedAuthCallback.UploadListener localUploadListener;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localUploadListener = (EmoAddedAuthCallback.UploadListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localUploadListener != null)
      {
        if (400010 != paramInt) {
          break label43;
        }
        localUploadListener.a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      }
    }
    return;
    label43:
    if (400011 == paramInt)
    {
      localUploadListener.a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      return;
    }
    localUploadListener.a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    if (i == 0) {
      b();
    }
    do
    {
      do
      {
        return;
      } while (-1 != i);
      i = paramSendResult.b;
      c(i);
      if (QLog.isColorLevel()) {
        QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result errCode=" + i);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        a(i);
        return;
      }
      if (2 == this.jdField_a_of_type_Int)
      {
        b(i);
        return;
      }
    } while (3 != this.jdField_a_of_type_Int);
    a(i);
  }
  
  protected void c(int paramInt)
  {
    if ((400010 == paramInt) || (400011 == paramInt)) {
      ThreadManager.getFileThreadHandler().post(new EmoAddedAuthCallback.4(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessage.what);
      return true;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131689613, 0).b(2131299166);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace)) {
        StickerRecManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      }
      if ((SharedPreUtils.D(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.isMarkFace) && (this.jdField_a_of_type_Int == 0)) {
        a();
      }
    }
    EmoticonManager.c("0", 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback
 * JD-Core Version:    0.7.0.1
 */