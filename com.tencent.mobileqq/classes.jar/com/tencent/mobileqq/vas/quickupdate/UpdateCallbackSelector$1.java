package com.tencent.mobileqq.vas.quickupdate;

import bdrz;
import bdsc;
import bdsd;
import bdse;
import bdsf;
import bdsg;
import bdsh;
import bdsk;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bdrz>
{
  public UpdateCallbackSelector$1()
  {
    bdrz[] arrayOfbdrz = new bdrz[7];
    arrayOfbdrz[0] = bdsh.a;
    arrayOfbdrz[1] = bdsg.a;
    arrayOfbdrz[2] = bdse.a;
    arrayOfbdrz[3] = bdsc.a;
    arrayOfbdrz[4] = bdsd.a;
    arrayOfbdrz[5] = bdsf.a;
    arrayOfbdrz[6] = bdsk.a;
    int j = arrayOfbdrz.length;
    while (i < j)
    {
      bdrz localbdrz = arrayOfbdrz[i];
      put(Long.valueOf(localbdrz.getBID()), localbdrz);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */