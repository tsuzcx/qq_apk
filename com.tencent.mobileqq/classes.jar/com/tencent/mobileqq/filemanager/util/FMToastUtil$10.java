package com.tencent.mobileqq.filemanager.util;

import aptx;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public final class FMToastUtil$10
  implements Runnable
{
  public void run()
  {
    bcql localbcql = new bcql(BaseApplicationImpl.getContext());
    localbcql.a(2130839277);
    localbcql.d(3000);
    localbcql.c(this.a);
    localbcql.b(aptx.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.10
 * JD-Core Version:    0.7.0.1
 */