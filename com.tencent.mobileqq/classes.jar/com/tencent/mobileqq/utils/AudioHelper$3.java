package com.tencent.mobileqq.utils;

import bcql;
import com.tencent.common.app.BaseApplicationImpl;

final class AudioHelper$3
  implements Runnable
{
  AudioHelper$3(String paramString) {}
  
  public void run()
  {
    bcql localbcql = bcql.a(BaseApplicationImpl.getContext(), "de:" + this.a, 1);
    localbcql.a();
    localbcql.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioHelper.3
 * JD-Core Version:    0.7.0.1
 */