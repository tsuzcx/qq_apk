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
  BaseQQAppInterface a;
  Context b;
  CustomEmotionData c;
  Object d;
  int e;
  Handler f;
  private WeakReference<EmoAddedAuthCallback.UploadListener> g;
  
  public EmoAddedAuthCallback(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, CustomEmotionData paramCustomEmotionData, Object paramObject, int paramInt)
  {
    this.a = paramBaseQQAppInterface;
    this.b = paramContext;
    this.c = paramCustomEmotionData;
    this.d = paramObject;
    this.e = paramInt;
    this.f = new Handler(Looper.getMainLooper(), this);
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
          paramBaseQQAppInterface = DialogUtil.a(paramContext, 0, "温馨提示", paramContext.getString(2131886258), "取消", "立即开通", paramBaseQQAppInterface, paramBaseQQAppInterface);
          if (paramBaseQQAppInterface != null) {
            paramBaseQQAppInterface.show();
          }
        }
      }
      else {
        QQToast.makeText(paramContext, paramContext.getString(2131886259), 0).show(2131299920);
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
      return;
    }
    if (paramInt == 2)
    {
      QQToast.makeText(paramContext, paramContext.getString(2131886259), 0).show(2131299920);
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2007", 1);
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void a()
  {
    ReportDialog localReportDialog = new ReportDialog(this.b, 2131953338);
    localReportDialog.setContentView(2131627949);
    Button localButton1 = (Button)localReportDialog.findViewById(2131431836);
    Button localButton2 = (Button)localReportDialog.findViewById(2131431840);
    localButton1.setOnClickListener(new EmoAddedAuthCallback.1(this, localReportDialog));
    localButton2.setOnClickListener(new EmoAddedAuthCallback.2(this, localReportDialog));
    if (!((Activity)this.b).isFinishing())
    {
      EmotionSharedPreUtils.a(this.b, this.a.getCurrentUin(), false);
      localReportDialog.show();
    }
  }
  
  protected void a(int paramInt)
  {
    if (400010 == paramInt)
    {
      this.f.sendEmptyMessage(1);
      return;
    }
    if (400011 == paramInt) {
      this.f.sendEmptyMessage(2);
    }
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, int paramInt)
  {
    b(paramBaseQQAppInterface, paramContext, paramInt);
  }
  
  public void a(EmoAddedAuthCallback.UploadListener paramUploadListener)
  {
    this.g = new WeakReference(paramUploadListener);
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.e("EmoAddedAuthCallback", 2, "add custom emotion result success");
    }
    int i = this.e;
    Object localObject;
    if (i == 0)
    {
      if ((!this.c.isMarkFace) && (TextUtils.isEmpty(this.c.md5)))
      {
        localObject = MD5.getFileMd5(this.c.emoPath);
        this.c.md5 = HexUtil.bytes2HexStr((byte[])localObject);
        localObject = this.a.getEntityManagerFactory().createEntityManager();
        if (localObject != null)
        {
          ((EntityManager)localObject).update(this.c);
          ((EntityManager)localObject).close();
        }
      }
      ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.c);
      if (this.d != null) {
        ((IEmosmService)QRoute.api(IEmosmService.class)).handleComicStructMsg(this.a, this.d, this.c);
      }
      this.f.sendEmptyMessage(3);
      localObject = this.a.getHandler(((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityClass());
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
        ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.c);
        if (2 == this.e)
        {
          localObject = this.g;
          if (localObject != null)
          {
            localObject = (EmoAddedAuthCallback.UploadListener)((WeakReference)localObject).get();
            if (localObject != null) {
              ((EmoAddedAuthCallback.UploadListener)localObject).a(0, this.c.md5);
            }
          }
        }
      }
      else if (3 == i)
      {
        ((IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.c);
        this.f.sendEmptyMessage(3);
      }
    }
  }
  
  protected void b(int paramInt)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (EmoAddedAuthCallback.UploadListener)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (400010 == paramInt)
        {
          ((EmoAddedAuthCallback.UploadListener)localObject).a(2, this.c.md5);
          return;
        }
        if (400011 == paramInt)
        {
          ((EmoAddedAuthCallback.UploadListener)localObject).a(3, this.c.md5);
          return;
        }
        ((EmoAddedAuthCallback.UploadListener)localObject).a(paramInt, this.c.md5);
      }
    }
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.a;
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
      int j = this.e;
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
      paramMessage = this.b;
      if (paramMessage != null)
      {
        QQToast.makeText(paramMessage, 2, 2131886256, 0).show(2131299920);
        paramMessage = this.c;
        if ((paramMessage != null) && (paramMessage.isMarkFace)) {
          StickerRecManagerImpl.get(this.a).updateKeywordForFavEmotion();
        }
        if ((EmotionSharedPreUtils.a(this.b, this.a.getCurrentUin())) && ((this.b instanceof Activity)))
        {
          paramMessage = this.c;
          if ((paramMessage != null) && (!paramMessage.isMarkFace) && (this.e == 0)) {
            a();
          }
        }
      }
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("0", 1);
      return true;
    }
    a(this.a, this.b, paramMessage.what);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback
 * JD-Core Version:    0.7.0.1
 */