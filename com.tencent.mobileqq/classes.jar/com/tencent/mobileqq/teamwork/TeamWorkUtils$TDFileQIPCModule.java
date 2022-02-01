package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResult;

public class TeamWorkUtils$TDFileQIPCModule
  extends QIPCModule
{
  public TeamWorkUtils$TDFileQIPCModule()
  {
    super("Module_TDFileChangeNameQIPCModule");
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    LogUtility.c(TeamWorkUtils.a(), "onCall action|" + paramString + " params|" + paramBundle + " callbackId|" + paramInt);
    if (paramString.equals("Action_url_2_fmdb")) {
      ThreadManager.postImmediately(new TeamWorkUtils.TDFileQIPCModule.1(this, paramBundle.getString("url")), null, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkUtils.TDFileQIPCModule
 * JD-Core Version:    0.7.0.1
 */