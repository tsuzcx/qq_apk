package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ThemeDIYActivity$10
  implements ThemeDiyStyleLogic.StyleCallBack
{
  ThemeDIYActivity$10(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "saveStyleCallback: operateType:" + paramInt1 + ", stateCode:" + paramInt2);
    }
    if (paramInt2 == 8) {}
    try
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).put("param_vipType", String.valueOf(this.this$0.isVip));
      ((HashMap)localObject).put("param_opType", String.valueOf(paramInt1));
      ((HashMap)localObject).put("param_isDiy", String.valueOf(this.this$0.isDIYThemeBefore));
      StatisticCollector.a(this.this$0.mContext).a(this.this$0.app.getAccount(), "ThemeDiyStyleLogicCallback", false, 1L, 0L, (HashMap)localObject, "", false);
      label136:
      if ((13 == paramInt1) && (paramBundle != null))
      {
        paramInt1 = paramBundle.getInt("index");
        paramResData = this.this$0.showData[paramInt1];
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "saveStyleCallback: callback, pageIndex:" + paramInt1);
        }
        if (paramInt2 == 4) {
          this.this$0.dealBgRes(paramResData, paramResData.tryOnBgBigOrgRD, 115, true);
        }
      }
      for (;;)
      {
        if ((paramBundle != null) && (paramBundle.getInt("nextOperate") == 10))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "StyleCallBack next task: save.");
          }
          this.this$0.mHandler.removeMessages(22);
          this.this$0.mHandler.sendMessageDelayed(Message.obtain(this.this$0.mHandler, 22, null), 50L);
        }
        return 1;
        if (paramInt2 == 8)
        {
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景加载错误 " + paramInt1));
          QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DOWN_BG Error, pageIndex:" + paramInt1);
          return 0;
          if ((14 == paramInt1) && (paramBundle != null))
          {
            paramInt1 = paramBundle.getInt("index");
            paramResData = this.this$0.showData[paramInt1];
            if (paramInt2 == 4)
            {
              paramResData.mSaveStatus = 6;
              paramResData.tryOnBgBigOrgRD.state = 5;
              paramResData.tryOnBgBigRD.state = 5;
              if ((this.this$0.mIsSaving.get()) && (paramBundle.getInt("nextOperate") != 10)) {
                paramBundle.putInt("nextOperate", 10);
              }
              if (this.this$0.mUpdateUIPicAfterSaved)
              {
                paramResData = new Intent("com.tencent.qplus.THEME_INVALIDATE");
                paramResData.putExtra("pid", Process.myPid());
                this.this$0.mContext.sendBroadcast(paramResData, "com.tencent.msg.permission.pushnotify");
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "pic Save, isSaved = true, change pic.");
                }
              }
            }
            else if (paramInt2 == 8)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景压黑压白错误103"));
              QLog.e("ThemeDIYActivity", 2, "saveStyleCallback, OPERATE_KEY_DEAL_BG deal error." + paramResData.position);
              return 0;
            }
          }
          else if (16 == paramInt1)
          {
            if (paramInt2 == 4)
            {
              this.this$0.mSaveToServerStatus = 6;
            }
            else
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 28, 1, 1, paramBundle));
              localObject = new StringBuilder().append("StyleCallBack:SAVE_SERVER false, error ret=");
              if (paramBundle != null) {}
              for (paramResData = paramBundle.getInt("result_int") + "_" + paramBundle.getString("message");; paramResData = "null Param")
              {
                QLog.e("ThemeDIYActivity", 1, paramResData);
                break;
              }
            }
          }
          else if (15 == paramInt1)
          {
            if (paramInt2 == 4)
            {
              this.this$0.mUpdateUIPicAfterSaved = true;
              if (QLog.isColorLevel()) {
                QLog.d("ThemeDIYActivity", 2, "StyleCallBack:save theme ok!!");
              }
            }
            else if (paramInt2 == 8)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 26, "设置风格失败"));
              QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme false, error type == " + paramInt2);
            }
          }
          else if (18 == paramInt1)
          {
            if (paramInt2 == 4)
            {
              if ((paramBundle != null) && (paramResData != null) && (117 == paramResData.type))
              {
                paramInt1 = paramBundle.getInt("page_index", -1);
                if (this.this$0.mPageView.pageIndex == paramInt1) {
                  this.this$0.blurBg(paramResData, null, 0, true);
                }
              }
            }
            else if (paramInt2 == 8) {
              QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme false, error type == " + paramInt2);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.10
 * JD-Core Version:    0.7.0.1
 */