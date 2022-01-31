package com.tencent.mobileqq.vas.quickupdate;

import bbso;
import bbsr;
import bbss;
import bbst;
import bbsu;
import bbsv;
import bbsw;
import bbsz;
import java.util.HashMap;

public final class UpdateCallbackSelector$1
  extends HashMap<Long, bbso>
{
  public UpdateCallbackSelector$1()
  {
    bbso[] arrayOfbbso = new bbso[7];
    arrayOfbbso[0] = bbsw.a;
    arrayOfbbso[1] = bbsv.a;
    arrayOfbbso[2] = bbst.a;
    arrayOfbbso[3] = bbsr.a;
    arrayOfbbso[4] = bbss.a;
    arrayOfbbso[5] = bbsu.a;
    arrayOfbbso[6] = bbsz.a;
    int j = arrayOfbbso.length;
    while (i < j)
    {
      bbso localbbso = arrayOfbbso[i];
      put(Long.valueOf(localbbso.getBID()), localbbso);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector.1
 * JD-Core Version:    0.7.0.1
 */