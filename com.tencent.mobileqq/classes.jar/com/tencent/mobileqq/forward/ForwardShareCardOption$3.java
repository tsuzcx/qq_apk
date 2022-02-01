package com.tencent.mobileqq.forward;

import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ForwardShareCardOption$3
  extends QidianBusinessObserver
{
  ForwardShareCardOption$3(ForwardShareCardOption paramForwardShareCardOption) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.ae();
    if (ForwardShareCardOption.a(this.a) != -1)
    {
      if ((paramBoolean) && (paramHashMap != null))
      {
        String str = (String)paramHashMap.get("uin");
        paramHashMap = (String)paramHashMap.get("url");
        ForwardShareCardOption.a(this.a, paramHashMap);
        ForwardShareCardOption.b(this.a, paramHashMap);
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("mTroopVerifyLink=");
          paramHashMap.append(ForwardShareCardOption.b(this.a));
          paramHashMap.append(" mTroopNotNeedVefifyLink=");
          paramHashMap.append(ForwardShareCardOption.c(this.a));
          QLog.d("ForwardOption.ForwardShareCardOption", 2, paramHashMap.toString());
        }
        if ((str != null) && (str.equals(ForwardShareCardOption.d(this.a)))) {
          ForwardShareCardOption.e(this.a);
        }
      }
      else
      {
        QQToast.makeText(this.a.s, 1, this.a.s.getString(2131890039), 0).show(((BaseActivity)this.a.s).getTitleBarHeight());
      }
      ForwardShareCardOption.a(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.3
 * JD-Core Version:    0.7.0.1
 */