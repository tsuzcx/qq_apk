package com.tencent.timi.game.tgpa.service;

import android.content.Context;
import android.content.pm.PackageManager;
import com.ihoc.mgpa.dataforwardsdk.ICallBack;
import com.ihoc.mgpa.dataforwardsdk.IDataForward.Stub;
import com.tencent.timi.game.tgpa.helper.TGPAInnerHelper;
import com.tencent.timi.game.utils.Logger;

class TgpaInterProcessService$1
  extends IDataForward.Stub
{
  TgpaInterProcessService$1(TgpaInterProcessService paramTgpaInterProcessService) {}
  
  private String a()
  {
    Object localObject = this.a.getApplicationContext();
    if (localObject != null) {
      localObject = ((Context)localObject).getPackageManager();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return ((PackageManager)localObject).getNameForUid(getCallingUid());
    }
    return "";
  }
  
  public void a(ICallBack paramICallBack)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("## registerGameCallback-");
    localStringBuilder.append(paramICallBack);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    TGPAInnerHelper.a().a(paramICallBack);
  }
  
  public void a(String paramString)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("## updateGameInfo-");
    localStringBuilder.append(paramString);
    Logger.a("TgpaInterProcessService", localStringBuilder.toString());
    TGPAInnerHelper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.service.TgpaInterProcessService.1
 * JD-Core Version:    0.7.0.1
 */