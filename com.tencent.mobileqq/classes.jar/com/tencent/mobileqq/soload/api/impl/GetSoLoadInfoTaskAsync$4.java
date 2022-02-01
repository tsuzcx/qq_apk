package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.qphone.base.util.QLog;

class GetSoLoadInfoTaskAsync$4
  implements OnSoGetPathListener
{
  GetSoLoadInfoTaskAsync$4(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync, String paramString, long paramLong, int paramInt) {}
  
  public void onResult(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downRFiles] download resCode=");
      paramString1.append(paramInt1);
      paramString1.append(",loadItemName:");
      paramString1.append(this.d.b.name);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramString1.toString());
    }
    this.d.c = paramInt2;
    if ((paramInt1 == 0) && (!TextUtils.isEmpty(paramString2)))
    {
      GetSoLoadInfoTaskAsync.a(this.d, paramString2, this.a, this.b, this.c);
      return;
    }
    GetSoLoadInfoTaskAsync.a(this.d, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.4
 * JD-Core Version:    0.7.0.1
 */