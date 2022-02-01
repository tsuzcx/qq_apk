package com.tencent.mobileqq.troop.createtroopblacklist.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;

public class CreateTroopBlackListUtilApiImpl
  implements ICreateTroopBlackListUtilApi
{
  private static final String TAG = "CreateTroopBlackListUtilApiImpl";
  
  public boolean checkAndHandleCreateGroupBlackListResult(Context paramContext, AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (paramAppInterface != null) && (paramString != null))
    {
      if (paramInt != 255) {
        return false;
      }
      FunctionLockMsg.FunctionLockBeatRsp localFunctionLockBeatRsp = new FunctionLockMsg.FunctionLockBeatRsp();
      try
      {
        localFunctionLockBeatRsp.mergeFrom(paramString.getBytes("ISO-8859-1"));
        QLog.i("CreateTroopBlackListUtilApiImpl", 1, "Create group blacklist going to show handle dialog");
        TemporaryBanJoinTroopAbilityHelper.a().a(paramAppInterface, paramContext, localFunctionLockBeatRsp, "");
        return true;
      }
      catch (UnsupportedEncodingException paramContext) {}catch (InvalidProtocolBufferMicroException paramContext) {}
      QLog.e("CreateTroopBlackListUtilApiImpl", 1, "Create group blacklist safety buffer parse error");
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createtroopblacklist.api.impl.CreateTroopBlackListUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */