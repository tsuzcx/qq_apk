package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class FTSMessageSearchEngine$3
  implements Runnable
{
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), "Error:fts search exists repeated results", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */