package com.tencent.mobileqq.theme.diy;

public class ThemeDIYData
{
  public static final int ITEM_SAVE_ERR = -1;
  public static final int ITEM_SAVE_ING = 4;
  public static final int ITEM_SAVE_INIT = 3;
  public static final int ITEM_SAVE_OK = 6;
  public static final int ITEM_SET_CHANGE = 2;
  public static final int ITEM_SET_INIT = 0;
  public int dealInt;
  public String dealSpkey;
  ResSuitData defaultBgRSD;
  public String defaultButtonText;
  ResSuitData initBgRSD;
  public int mSaveStatus;
  public int mSetStatus;
  public int orgMarkColor;
  public String orgSpKey;
  public String pageName;
  public int position;
  public int themeBgID;
  public String themeShot;
  ResData tryOnBgBigOrgRD;
  ResData tryOnBgBigRD;
  ResSuitData tryOnBgRSD;
  ResSuitData usedBgRSD;
  
  public ThemeDIYData(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4)
  {
    this.themeBgID = paramInt1;
    this.orgSpKey = paramString1;
    this.orgMarkColor = paramInt2;
    this.dealSpkey = paramString2;
    this.dealInt = paramInt3;
    this.position = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYData
 * JD-Core Version:    0.7.0.1
 */