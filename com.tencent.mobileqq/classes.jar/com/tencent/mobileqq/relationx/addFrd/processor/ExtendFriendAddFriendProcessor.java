package com.tencent.mobileqq.relationx.addFrd.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.processor.BaseAddFriendProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class ExtendFriendAddFriendProcessor
  extends BaseAddFriendProcessor
{
  public ExtendFriendAddFriendProcessor(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    paramIntent.putExtra("sub_source_id", paramActivity.getIntent().getIntExtra("sub_source_id", 8));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 3094)
    {
      if (paramInt2 == 1)
      {
        ReportController.a(this.a, "dc00898", "", paramString, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.d(), ExtendFriendReport.a((QQAppInterface)this.a), ExtendFriendReport.f());
        return;
      }
      if (paramInt2 == 2)
      {
        ReportController.a(this.a, "dc00898", "", paramString, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.a((QQAppInterface)this.a), "");
        return;
      }
      if (paramInt2 == 8)
      {
        ReportController.a(this.a, "dc00898", "", paramString, "0X800A69D", "0X800A69D", paramInt3, 0, "", "", "", "");
        return;
      }
      if (paramInt2 == 9) {
        ReportController.a(this.a, "dc00898", "", paramString, "0X800A69D", "0X800A69D", paramInt3, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.addFrd.processor.ExtendFriendAddFriendProcessor
 * JD-Core Version:    0.7.0.1
 */