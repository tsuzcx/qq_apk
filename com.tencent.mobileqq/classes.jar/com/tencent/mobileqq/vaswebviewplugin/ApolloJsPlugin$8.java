package com.tencent.mobileqq.vaswebviewplugin;

import aksi;
import aksj;
import alud;
import android.app.Activity;
import bdgm;
import bdjz;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPlugin$8
  extends aksi
{
  ApolloJsPlugin$8(ApolloJsPlugin paramApolloJsPlugin, AppInterface paramAppInterface, boolean paramBoolean, String paramString, Activity paramActivity)
  {
    super(paramAppInterface, paramBoolean);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, aksj paramaksj, long paramLong)
  {
    String str = String.format(alud.a(2131700840), new Object[] { Float.valueOf((float)paramLong * 1.0F / 1024.0F / 1024.0F) });
    bdgm.a(this.val$activity, 0, null, str, 2131694953, 2131690648, new ApolloJsPlugin.8.1(this), new ApolloJsPlugin.8.2(this, paramaksj, paramStartCheckParam)).show();
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", 0, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onDownloadGameResFail(paramStartCheckParam);
    this.this$0.callbackError(this.val$callbackId, alud.a(2131700837));
    ApolloJsPlugin.access$500(this.this$0, -1);
  }
  
  public void onDownloadGameResProgress(CmGameStartChecker.StartCheckParam paramStartCheckParam, int paramInt)
  {
    super.onDownloadGameResProgress(paramStartCheckParam, paramInt);
    int i = paramInt;
    if (paramInt >= 99) {
      i = 99;
    }
    ApolloJsPlugin.access$500(this.this$0, i);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onDownloadGameResProgress percent:", Integer.valueOf(i) });
    }
  }
  
  public void onGameCheckFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams) {}
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.this$0.callbackError(this.val$callbackId, alud.a(2131700806));
    ApolloJsPlugin.access$500(this.this$0, -1);
  }
  
  public void onVerifyGameFinish(long paramLong, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (paramLong == 0L)
    {
      this.this$0.callbackOk(this.val$callbackId);
      ApolloJsPlugin.access$500(this.this$0, 100);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onVerifyGameFinish resultCode:", Long.valueOf(paramLong) });
      }
      return;
      this.this$0.callbackError(this.val$callbackId, alud.a(2131700802));
      ApolloJsPlugin.access$500(this.this$0, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */