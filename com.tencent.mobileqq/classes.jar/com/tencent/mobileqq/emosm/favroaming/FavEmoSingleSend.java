package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.IFavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

public class FavEmoSingleSend
  extends EmoAsyncStep
  implements UpCallBack
{
  public boolean a;
  private final Object b = new Object();
  private boolean k;
  private CustomEmotionData l;
  private IFavroamingManagerService m;
  private IFavroamingDBManagerService n;
  private IFavEmoRoamingHandler o;
  private TransferRequest p;
  private Timer q;
  
  public FavEmoSingleSend(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.l = paramCustomEmotionData;
    c();
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramString == "isUpdate") {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
    CustomEmotionData localCustomEmotionData = this.l;
    localCustomEmotionData.RomaingType = paramString;
    this.n.updateCustomEmotion(localCustomEmotionData);
    this.n.trimCache();
    this.o.notifyUI(2, true, Integer.valueOf(paramInt1));
    FavEmoSendControlConstant.a(this.a, paramInt2, paramInt3);
  }
  
  protected int b()
  {
    QLog.d("FavEmoSingleSend", 1, new Object[] { "doStep, isResend: ", Boolean.valueOf(this.k), " ", this.l });
    this.p = this.m.syncUpload(this.l, this);
    if (this.p == null)
    {
      QLog.d("FavEmoSingleSend", 1, "doStep, network not support");
      a("failed", 0, 3, 0);
      return 7;
    }
    this.q = new Timer();
    this.q.schedule(new FavEmoSingleSend.1(this), 30000L);
    try
    {
      synchronized (this.b)
      {
        this.b.wait(40000L);
      }
    }
    catch (Exception localException)
    {
      label135:
      break label135;
    }
    this.q.cancel();
    return 7;
    throw localObject2;
  }
  
  public void b(UpCallBack.SendResult arg1)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.d("FavEmoSingleSend", 2, new Object[] { "uploadCameraEmoList, ", ??? });
    }
    if (???.a == 0)
    {
      QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
      a("isUpdate", 0, 0, 0);
      EmoticonOperateReport.reportFavAddEmotionEvent(null, 3, ???.g, null);
    }
    else if (-1 == ???.a)
    {
      QLog.e("FavEmoSingleSend", 1, new Object[] { "uploadCameraEmoList fail,  ret:", Integer.valueOf(???.b) });
      int i = 5;
      if (400010 == ???.b)
      {
        i = 6;
        j = 7;
      }
      else if (400011 == ???.b)
      {
        j = 8;
        i = 7;
      }
      a("failed", j, i, ???.b);
    }
    synchronized (this.b)
    {
      this.b.notify();
      return;
    }
  }
  
  public void c()
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.m = ((IFavroamingManagerService)localBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class));
    this.n = ((IFavroamingDBManagerService)localBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class));
    this.o = ((IFavEmoRoamingHandler)localBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */