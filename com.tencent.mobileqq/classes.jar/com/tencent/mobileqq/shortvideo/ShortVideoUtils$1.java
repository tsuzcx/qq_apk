package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;

final class ShortVideoUtils$1
  implements Runnable
{
  public void run()
  {
    try
    {
      SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "GIFEngine");
      ShortVideoUtils.a(true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      ShortVideoUtils.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.1
 * JD-Core Version:    0.7.0.1
 */