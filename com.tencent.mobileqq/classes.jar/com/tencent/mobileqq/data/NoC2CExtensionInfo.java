package com.tencent.mobileqq.data;

import auko;
import aulv;
import aulz;

public class NoC2CExtensionInfo
  extends auko
{
  public static final int TYPE_EXT_C2C = 0;
  public static final int TYPE_EXT_COUNT = 3;
  public static final int TYPE_EXT_DISCUSSION = 2;
  public static final int TYPE_EXT_GROUP = 1;
  @aulv(a=-1)
  public int audioPanelType = -1;
  public int chatInputType = 0;
  @aulz
  public boolean isDataChanged;
  public int pttChangeVoiceType = 0;
  public int showC2CPanel = 1;
  public int type;
  public String uin;
  
  public static String getNoC2Ckey(int paramInt, String paramString)
  {
    return paramInt + "_" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.NoC2CExtensionInfo
 * JD-Core Version:    0.7.0.1
 */