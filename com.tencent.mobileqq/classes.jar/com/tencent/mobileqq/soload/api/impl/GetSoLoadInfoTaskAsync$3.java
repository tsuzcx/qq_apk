package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class GetSoLoadInfoTaskAsync$3
  implements OnSoGetPathListener
{
  GetSoLoadInfoTaskAsync$3(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync, LoadParam.LoadItem paramLoadItem, boolean paramBoolean1, boolean paramBoolean2, SoLocalInfo paramSoLocalInfo) {}
  
  public void onResult(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downloadSo] resCode=");
      paramString1.append(paramInt1);
      paramString1.append(",loadItemName:");
      paramString1.append(this.a.name);
      paramString1.append(",folderPath:");
      paramString1.append(paramString2);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramString1.toString());
    }
    paramString1 = this.e.a;
    long l = this.e.a.mReportSeq;
    paramString3 = new StringBuilder();
    paramString3.append("sc=");
    paramString3.append(paramInt2);
    SoReportUtil.a(paramString1, l, null, "load.item.download.end", paramString3.toString(), paramInt1, null);
    this.e.c = paramInt2;
    if ((paramInt1 == 0) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = this.e;
      paramString1.d = true;
      paramString1 = new File(paramString2, paramString1.b.soFileName).getAbsolutePath();
      paramString2 = this.e;
      GetSoLoadInfoTaskAsync.a(paramString2, this.b, this.c, this.d, paramString1, paramString2.h.crc, 2);
      return;
    }
    if (paramInt1 == 2)
    {
      GetSoLoadInfoTaskAsync.a(this.e, 4);
      return;
    }
    if (paramInt2 == 404)
    {
      GetSoLoadInfoTaskAsync.a(this.e, 9);
      return;
    }
    GetSoLoadInfoTaskAsync.a(this.e, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.3
 * JD-Core Version:    0.7.0.1
 */