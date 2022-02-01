package com.tencent.mobileqq.troop.troopcreate.ui;

import java.util.ArrayList;
import java.util.HashMap;

public class TroopCateListProvider$TroopCateInfo
{
  public String a;
  public String b;
  public String c;
  public int d = 0;
  public int e = 0;
  public String f;
  public ArrayList<TroopCateInfo> g;
  public boolean h;
  
  public TroopCateListProvider$TroopCateInfo() {}
  
  public TroopCateListProvider$TroopCateInfo(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
    this.d = ((Integer)TroopCateListProvider.b().get(paramString)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCateListProvider.TroopCateInfo
 * JD-Core Version:    0.7.0.1
 */