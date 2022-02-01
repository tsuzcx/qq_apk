package com.tencent.mobileqq.search.ftsmsg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class FTSMessageSearchEngine$3
  implements Runnable
{
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getContext(), "Error:fts search exists repeated results", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */