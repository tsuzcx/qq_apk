package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.TeamWorkExportObserver;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.manager.TicketManager;

public class TeamWorkFileExportHandlerImpl
  extends BusinessHandler
  implements Handler.Callback, ITeamWorkFileExportHandler
{
  public static final String TAG = "TeamWorkFileExportHandlerImpl";
  private AppInterface app;
  private String[] domainArray = { "docs.qq.com" };
  
  public TeamWorkFileExportHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
  }
  
  private void doRequestAfterGetTicket(Runnable paramRunnable)
  {
    AppInterface localAppInterface = this.app;
    if (localAppInterface == null) {
      return;
    }
    if (((TicketManager)localAppInterface.getManager(2)).getPskey(this.app.getCurrentAccountUin(), 16L, this.domainArray, new TeamWorkFileExportHandlerImpl.2(this, paramRunnable)) != null) {
      ThreadManager.executeOnNetWorkThread(paramRunnable);
    }
  }
  
  public static String getClassName()
  {
    return TeamWorkFileExportHandlerImpl.class.getName();
  }
  
  public void fileExportDownloadRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    doRequestAfterGetTicket(new TeamWorkFileExportHandlerImpl.1(this, paramString1, paramString2, paramString3, paramString4));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TeamWorkExportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileExportHandlerImpl
 * JD-Core Version:    0.7.0.1
 */