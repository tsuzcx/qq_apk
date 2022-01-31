package com.tencent.mobileqq.vas.quickupdate;

import baqp;
import baqs;
import baqt;
import baqu;
import baqv;
import baqw;
import baqx;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, baqp>
{
  public UpdateCallbackSelector$1()
  {
    baqp[] arrayOfbaqp = new baqp[6];
    arrayOfbaqp[0] = baqx.a;
    arrayOfbaqp[1] = baqw.a;
    arrayOfbaqp[2] = baqu.a;
    arrayOfbaqp[3] = baqs.a;
    arrayOfbaqp[4] = baqt.a;
    arrayOfbaqp[5] = baqv.a;
    int j = arrayOfbaqp.length;
    while (i < j)
    {
      baqp localbaqp = arrayOfbaqp[i];
      put(Long.valueOf(localbaqp.getBID()), localbaqp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */