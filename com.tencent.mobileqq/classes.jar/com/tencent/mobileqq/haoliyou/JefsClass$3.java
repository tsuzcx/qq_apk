package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class JefsClass$3
  implements JefsClass.Interceptor
{
  JefsClass$3(JefsClass paramJefsClass, Context paramContext, Intent paramIntent, String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3, List<ResolveInfo> paramList, JefsClass.CancelableRunnable paramCancelableRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeleScreen|JefsClass", 2, "checkAndDo() ]");
    }
    JefsClass.a(this.e, this.a, this.b, this.c, paramString1, paramString2, paramString3, paramList, paramCancelableRunnable, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.3
 * JD-Core Version:    0.7.0.1
 */