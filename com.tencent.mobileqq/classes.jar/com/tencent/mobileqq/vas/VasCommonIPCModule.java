package com.tencent.mobileqq.vas;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.mutualmark.alienation.RelationVipHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.config.business.qvip.QQFriendRelation2Config;
import com.tencent.mobileqq.vas.config.business.qvip.QQFriendRelation2Processor;
import eipc.EIPCResult;

public class VasCommonIPCModule
  extends QIPCModule
{
  private static VasCommonIPCModule a;
  
  private VasCommonIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static VasCommonIPCModule a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new VasCommonIPCModule("VasCommonIPCModule");
          }
        }
        finally {}
      }
      VasCommonIPCModule localVasCommonIPCModule = a;
      return localVasCommonIPCModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("is_white_name".equals(paramString))
    {
      int i = paramBundle.getInt("managerId", -1);
      boolean bool;
      if (i == 490)
      {
        bool = RelationVipHelper.a().a();
        paramString = new Bundle();
        paramString.putBoolean("isWhiteName", bool);
        paramString = EIPCResult.createSuccessResult(paramString);
      }
      else if (i == 491)
      {
        bool = QQFriendRelation2Processor.c().mIsEnable;
        paramString = new Bundle();
        paramString.putBoolean("isWhiteName", bool);
        paramString = EIPCResult.createSuccessResult(paramString);
      }
      else
      {
        paramString = EIPCResult.createResult(-1, new Bundle());
      }
    }
    else if ("paySuccess".equals(paramString))
    {
      ((VipInfoHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).notifyUI(5, true, paramBundle);
      paramString = EIPCResult.createResult(0, null);
    }
    else
    {
      paramString = null;
    }
    callbackResult(paramInt, paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasCommonIPCModule
 * JD-Core Version:    0.7.0.1
 */