package com.tencent.mobileqq.olympic.activity;

import azri;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

class OlympicToolBaseActivity$1
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(-1003));
    azri.a(BaseApplicationImpl.getContext()).a("", "ocr_entrance", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */