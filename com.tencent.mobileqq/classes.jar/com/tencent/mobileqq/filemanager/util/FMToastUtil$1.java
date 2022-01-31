package com.tencent.mobileqq.filemanager.util;

import aptx;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

public final class FMToastUtil$1
  implements Runnable
{
  public FMToastUtil$1(int paramInt) {}
  
  public void run()
  {
    bcql.a(BaseApplicationImpl.getContext(), 0, this.a, 0).b(aptx.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil.1
 * JD-Core Version:    0.7.0.1
 */