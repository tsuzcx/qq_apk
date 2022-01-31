package com.tencent.mobileqq.vas.quickupdate;

import bbtc;
import bbtf;
import bbtg;
import bbth;
import bbti;
import bbtj;
import bbtk;
import bbtn;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bbtc>
{
  public UpdateCallbackSelector$1()
  {
    bbtc[] arrayOfbbtc = new bbtc[7];
    arrayOfbbtc[0] = bbtk.a;
    arrayOfbbtc[1] = bbtj.a;
    arrayOfbbtc[2] = bbth.a;
    arrayOfbbtc[3] = bbtf.a;
    arrayOfbbtc[4] = bbtg.a;
    arrayOfbbtc[5] = bbti.a;
    arrayOfbbtc[6] = bbtn.a;
    int j = arrayOfbbtc.length;
    while (i < j)
    {
      bbtc localbbtc = arrayOfbbtc[i];
      put(Long.valueOf(localbbtc.getBID()), localbbtc);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */