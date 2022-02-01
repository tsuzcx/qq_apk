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
    this.a.A();
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
          paramHashMap.append(ForwardShareCardOption.a(this.a));
          paramHashMap.append(" mTroopNotNeedVefifyLink=");
          paramHashMap.append(ForwardShareCardOption.b(this.a));
          QLog.d("ForwardOption.ForwardShareCardOption", 2, paramHashMap.toString());
        }
        if ((str != null) && (str.equals(ForwardShareCardOption.c(this.a)))) {
          ForwardShareCardOption.a(this.a);
        }
      }
      else
      {
        QQToast.a(this.a.a, 1, this.a.a.getString(2131692928), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
      ForwardShareCardOption.a(this.a, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.3
 * JD-Core Version:    0.7.0.1
 */