package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.util.Log;

class CKeyFacade$1
  implements Runnable
{
  CKeyFacade$1(CKeyFacade paramCKeyFacade) {}
  
  public void run()
  {
    try
    {
      if (CKeyFacade.access$000() != null) {
        CKeyFacade.access$400(this.this$0, CKeyFacade.access$100(), CKeyFacade.access$200(), CKeyFacade.access$300(), CKeyFacade.access$000());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      CKeyFacade.bLoadSucc = false;
      Log.i("CKeyFacade|ckeygeneratorV2.so", "init err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade.1
 * JD-Core Version:    0.7.0.1
 */