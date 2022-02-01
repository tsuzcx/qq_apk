package com.tencent.mobileqq.filemanager.data.search.searchtype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;

public class QFileTroopSearchTypeController
  implements IQFileSearchTypeController
{
  private QQAppInterface a;
  private Context b;
  private long c;
  
  public QFileTroopSearchTypeController(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = Long.parseLong(paramString);
  }
  
  private void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", String.valueOf(this.c));
    localIntent.putExtra("param_from", 18);
    localIntent.putExtra("uin", this.c);
    localIntent.putExtra("param_from", 23);
    localIntent.putExtra("uintype", 1);
    RouteUtils.a(this.b, localIntent, "/troop/memberlist/TroopMemberList");
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title_type", paramInt);
    localIntent.putExtra("troop_uin", this.c);
    TroopFileProxyActivity.c((Activity)this.b, localIntent, this.a.getCurrentAccountUin());
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 11)
            {
              if (paramInt != 13)
              {
                QLog.i("QFileTroopSearchTypeController", 4, "unknown search type.");
                return;
              }
              a();
              return;
            }
            b(10000);
            ReportController.b(this.a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 5, 0, "", "", "", "");
            return;
          }
          b(1);
          ReportController.b(this.a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 1, 0, "", "", "", "");
          return;
        }
        b(2);
        ReportController.b(this.a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 2, 0, "", "", "", "");
        return;
      }
      b(3);
      ReportController.b(this.a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 4, 0, "", "", "", "");
      return;
    }
    b(4);
    ReportController.b(this.a, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.searchtype.QFileTroopSearchTypeController
 * JD-Core Version:    0.7.0.1
 */