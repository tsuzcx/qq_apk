package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager.OnGetSoInfoListener;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import com.tencent.mobileqq.soload.util.SoLoadUtils;

class GetSoLoadInfoTaskAsync$2
  implements SoConfigManager.OnGetSoInfoListener
{
  GetSoLoadInfoTaskAsync$2(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync, String paramString, SoCrashInfo paramSoCrashInfo, LoadParam.LoadItem paramLoadItem) {}
  
  public void a(int paramInt, SoInfo paramSoInfo)
  {
    if (!this.d.a(paramSoInfo))
    {
      GetSoLoadInfoTaskAsync.a(this.d, 2);
      return;
    }
    if ((TextUtils.equals(this.d.h.ver, this.a)) && (this.b.c()))
    {
      paramSoInfo = this.d;
      paramSoInfo.i = "runcrash";
      GetSoLoadInfoTaskAsync.a(paramSoInfo, 8);
      return;
    }
    SoLoadUtils.f(this.c.name);
    GetSoLoadInfoTaskAsync.a(this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.2
 * JD-Core Version:    0.7.0.1
 */