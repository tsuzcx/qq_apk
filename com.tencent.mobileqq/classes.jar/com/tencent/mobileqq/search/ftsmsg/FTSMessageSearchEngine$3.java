package com.tencent.mobileqq.search.ftsmsg;

import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public class FTSMessageSearchEngine$3
  implements Runnable
{
  public void run()
  {
    bcql.a(BaseApplicationImpl.getContext(), "Error:fts search exists repeated results", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */