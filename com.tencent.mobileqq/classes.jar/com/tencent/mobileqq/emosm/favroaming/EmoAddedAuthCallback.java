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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  Object jdField_a_of_type_JavaLangObject;
  private WeakReference<EmoAddedAuthCallback.UploadListener> jdField_a_of_type_JavaLangRefWeakReference;
  
  public EmoAddedAuthCallback(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static void b(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramInt == 1)
    {
      paramBaseQQAppInterface = new EmoAddedAuthCallback.3(paramContext, paramBaseQQAppInterface);
      if ((paramContext instanceof Activity))
      {
        if (!((Activity)paramContext).isFinishing())
        {
          paramBaseQQAppInterface = DialogUtil.a(paramContext, 0, "温馨提示", paramContext.getString(2131689647), "取消", "立即开通", paramBaseQQAppInterface, paramBaseQQAppInterface);
          if (paramBaseQQAppInterface != null) {
            paramBaseQQAppInterface.show();
          }
        }
      }
      else {
        QQToast.a(paramContext, paramContext.getString(2131689648), 0).b(2131299168);
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
      return;
    }
    if (paramInt == 2)
    {
      QQToast.a(paramContext, paramContext.getString(2131689648), 0).b(2131299168);
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void a()
  {
    ReportDialog localReportDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131756189);
    localReportDialog.setContentView(2131561586);
    Button localButton1 = (Button)localReportDialog.findViewById(2131365605);
    Button localButton2 = (Button)localReportDialog.findViewById(2131365609);
    localButton1.setOnClickListener(new EmoAddedAuthCallback.1(this, localReportDialog));
    localButton2.setOnClickListener(new EmoAddedAuthCallback.2(this, localReportDialog));
    if (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())
    {
      EmotionSharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin(), false);
      localReportDialog.show();
    }
  }
  
  protected void a(int paramInt)
  {
    if (400010 == paramInt)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    if (400011 == paramInt) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, int paramInt)
  {
    b(paramBaseQQAppInterface, paramContext, paramInt);
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
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i == 0)
    {
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
      if (this.jdField_a_of_type_JavaLangObject != null) {
        ((IEmosmService)QRoute.api(IEmosmService.class)).handleComicStructMsg(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_JavaLangObject, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
      if (localObject != null) {
        ((MqqHandler)localObject).obtainMessage(10).sendToTarget();
      }
    }
    else
    {
      if (1 == i) {
        return;
      }
      if (2 == i)
      {
        ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        if (2 == this.jdField_a_of_type_Int)
        {
          localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
          if (localObject != null)
          {
            localObject = (EmoAddedAuthCallback.UploadListener)((WeakReference)localObject).get();
            if (localObject != null) {
              ((EmoAddedAuthCallback.UploadListener)localObject).a(0, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
            }
          }
        }
      }
      else if (3 == i)
      {
        ((IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
    }
  }
  
  protected void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (EmoAddedAuthCallback.UploadListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (400010 == paramInt)
        {
          ((EmoAddedAuthCallback.UploadListener)localObject).a(2, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        if (400011 == paramInt)
        {
          ((EmoAddedAuthCallback.UploadListener)localObject).a(3, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
          return;
        }
        ((EmoAddedAuthCallback.UploadListener)localObject).a(paramInt, this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.md5);
      }
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    if (i == 0)
    {
      b();
      return;
    }
    if (-1 == i)
    {
      i = paramSendResult.b;
      c(i);
      if (QLog.isColorLevel())
      {
        paramSendResult = new StringBuilder();
        paramSendResult.append("add custom emotion result errCode=");
        paramSendResult.append(i);
        QLog.e("EmoAddedAuthCallback", 2, paramSendResult.toString());
      }
      int j = this.jdField_a_of_type_Int;
      if (j == 0)
      {
        a(i);
        return;
      }
      if (2 == j)
      {
        b(i);
        return;
      }
      if (3 == j) {
        a(i);
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if ((400010 == paramInt) || (400011 == paramInt)) {
      ThreadManager.getFileThreadHandler().post(new EmoAddedAuthCallback.4(this));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2))
    {
      if (i != 3) {
        return true;
      }
      paramMessage = this.jdField_a_of_type_AndroidContentContext;
      if (paramMessage != null)
      {
        QQToast.a(paramMessage, 2, 2131689645, 0).b(2131299168);
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
        if ((paramMessage != null) && (paramMessage.isMarkFace)) {
          StickerRecManagerImpl.get(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface).updateKeywordForFavEmotion();
        }
        if ((EmotionSharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin())) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
          if ((paramMessage != null) && (!paramMessage.isMarkFace) && (this.jdField_a_of_type_Int == 0)) {
            a();
          }
        }
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
      return true;
    }
    a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback
 * JD-Core Version:    0.7.0.1
 */