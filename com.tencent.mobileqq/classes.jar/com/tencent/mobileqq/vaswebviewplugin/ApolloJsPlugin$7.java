package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.DefaultGameCheckListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class ApolloJsPlugin$7
  extends CmGameStartChecker.DefaultGameCheckListener
{
  ApolloJsPlugin$7(ApolloJsPlugin paramApolloJsPlugin, AppInterface paramAppInterface, String paramString, Activity paramActivity)
  {
    super(paramAppInterface);
  }
  
  public void onDownloadConfirm(CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameStartChecker.ICmGameConfirmListener paramICmGameConfirmListener, long paramLong)
  {
    String str = String.format("当前需要更新%.1fM，马上开始?", new Object[] { Float.valueOf((float)paramLong * 1.0F / 1024.0F / 1024.0F) });
    DialogUtil.b(this.val$activity, 0, null, str, 2131433030, 2131433029, new ApolloJsPlugin.7.1(this), new ApolloJsPlugin.7.2(this, paramICmGameConfirmListener, paramStartCheckParam)).show();
    VipUtils.a(null, "cmshow", "Apollo", "download_confirm_toast", 0, 3, new String[] { String.valueOf(paramStartCheckParam.game.gameId) });
  }
  
  public void onDownloadGameResFail(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super.onDownloadGameResFail(paramStartCheckParam);
    this.this$0.callbackError(this.val$callbackId, "下载失败");
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
  
  public void onGameCheckFinish(int paramInt, CmGameStartChecker.StartCheckParam paramStartCheckParam, CmGameInitParams paramCmGameInitParams)
  {
    if (paramInt == 0)
    {
      this.this$0.callbackOk(this.val$callbackId);
      ApolloJsPlugin.access$500(this.this$0, 100);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "IPC_APOLLO_DOWNLOAD_GAME onGameCheckFinish resultCode:", Integer.valueOf(paramInt) });
      }
      return;
      this.this$0.callbackError(this.val$callbackId, "下载失败");
      ApolloJsPlugin.access$500(this.this$0, -1);
    }
  }
  
  public void onGameLifeTipShow(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.this$0.callbackError(this.val$callbackId, "下载失败");
    ApolloJsPlugin.access$500(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */