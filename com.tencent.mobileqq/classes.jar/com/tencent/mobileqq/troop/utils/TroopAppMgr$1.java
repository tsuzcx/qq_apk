package com.tencent.mobileqq.troop.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

class TroopAppMgr$1
  extends ThreadLocal<SimpleDateFormat>
{
  TroopAppMgr$1(TroopAppMgr paramTroopAppMgr) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAppMgr.1
 * JD-Core Version:    0.7.0.1
 */