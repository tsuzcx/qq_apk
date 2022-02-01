package com.tencent.mobileqq.teamwork;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class TenDocOCRExportHandler
  extends BusinessHandler
  implements Handler.Callback
{
  public static final String a = "com.tencent.mobileqq.teamwork.TenDocOCRExportHandler";
  private String[] b = { "docs.qq.com" };
  private AppInterface c;
  
  public TenDocOCRExportHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.c = paramAppInterface;
  }
  
  private void a(Runnable paramRunnable)
  {
    AppInterface localAppInterface = this.c;
    if (localAppInterface == null) {
      return;
    }
    if (((TicketManager)localAppInterface.getManager(2)).getPskey(this.c.getCurrentAccountUin(), 16L, this.b, new TenDocOCRExportHandler.2(this, paramRunnable)) != null) {
      ThreadManager.executeOnNetWorkThread(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    a(new TenDocOCRExportHandler.1(this, paramString));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TenDocOCRExportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocOCRExportHandler
 * JD-Core Version:    0.7.0.1
 */