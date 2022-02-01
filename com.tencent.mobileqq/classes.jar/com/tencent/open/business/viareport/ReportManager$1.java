package com.tencent.open.business.viareport;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;

class ReportManager$1
  implements Runnable
{
  ReportManager$1(ReportManager paramReportManager, boolean paramBoolean1, BatchReportInfo paramBatchReportInfo, Bundle paramBundle, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    boolean bool2 = this.a;
    boolean bool1 = false;
    if ((bool2) && (this.b == null))
    {
      localObject = this.c;
      if ((localObject != null) && (this.this$0.b(((Bundle)localObject).getString("appid_for_getting_config")))) {
        this.this$0.a(this.d, this.c, false, this.e);
      }
      return;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((BatchReportInfo)localObject).b()) && (this.this$0.b(null))) {
      ReportDbHelper.a().a("table_new_data", this.b);
    }
    if (this.this$0.e)
    {
      LogUtility.b("viareport", "isUploading ---return");
      return;
    }
    if ((!this.a) && (!this.this$0.a(this.d)) && (!this.this$0.c())) {
      return;
    }
    localObject = this.this$0;
    String str = this.d;
    Bundle localBundle = this.c;
    if (this.b != null) {
      bool1 = true;
    }
    ((ReportManager)localObject).a(str, localBundle, bool1, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */