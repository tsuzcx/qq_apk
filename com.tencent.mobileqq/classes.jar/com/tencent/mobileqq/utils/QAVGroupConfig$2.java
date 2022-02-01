package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

final class QAVGroupConfig$2
  extends TroopObserver
{
  QAVGroupConfig$2(String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.equals(this.a, paramString)) {
      return;
    }
    this.b.removeObserver(this);
    paramString = new StringBuilder();
    paramString.append("onGetTroopInfoResult[");
    paramString.append(this.c);
    paramString.append("], troopuin[");
    paramString.append(this.a);
    paramString.append("], isSuc[");
    paramString.append(paramBoolean);
    paramString.append("]");
    QLog.w("QAVGroupConfig", 1, paramString.toString());
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append(this.c);
      paramString.append(".onGetTroopInfoResult");
      QAVGroupConfig.GroupInviteFlag.a(paramString.toString(), this.b, this.a);
    }
    this.b.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QAVGroupConfig.2
 * JD-Core Version:    0.7.0.1
 */