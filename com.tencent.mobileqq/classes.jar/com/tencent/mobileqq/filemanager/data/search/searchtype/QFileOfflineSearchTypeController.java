package com.tencent.mobileqq.filemanager.data.search.searchtype;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.SearchTypeDetailActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QFileOfflineSearchTypeController
  implements IQFileSearchTypeController
{
  private QQAppInterface a;
  private Context b;
  private String c;
  private List<Integer> d;
  
  public QFileOfflineSearchTypeController(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, List<Integer> paramList)
  {
    this.b = paramContext;
    this.a = paramQQAppInterface;
    this.c = paramString;
    this.d = paramList;
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
              QLog.i("QFileOfflineSearchTypeController", 4, "unknown search type.");
              return;
            }
            ReportController.b(this.a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 5, 0, "", "", "", "");
            SearchTypeDetailActivity.a(this.b, paramInt, this.c, this.d);
            return;
          }
          ReportController.b(this.a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 1, 0, "", "", "", "");
          SearchTypeDetailActivity.a(this.b, paramInt, this.c, this.d);
          return;
        }
        ReportController.b(this.a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 2, 0, "", "", "", "");
        SearchTypeDetailActivity.a(this.b, paramInt, this.c, this.d);
        return;
      }
      ReportController.b(this.a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 4, 0, "", "", "", "");
      SearchTypeDetailActivity.a(this.b, paramInt, this.c, this.d);
      return;
    }
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B7", "0X800A0B7", 3, 0, "", "", "", "");
    SearchTypeDetailActivity.a(this.b, paramInt, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.searchtype.QFileOfflineSearchTypeController
 * JD-Core Version:    0.7.0.1
 */