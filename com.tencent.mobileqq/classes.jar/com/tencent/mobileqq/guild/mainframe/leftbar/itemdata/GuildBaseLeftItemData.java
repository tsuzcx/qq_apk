package com.tencent.mobileqq.guild.mainframe.leftbar.itemdata;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class GuildBaseLeftItemData
{
  public int a;
  public String b;
  public Drawable c;
  public boolean d;
  public Bundle e;
  
  public GuildBaseLeftItemData(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = null;
    this.d = false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof GuildBaseLeftItemData)) {
        return false;
      }
      int i = this.a;
      paramObject = (GuildBaseLeftItemData)paramObject;
      bool1 = bool2;
      if (i == paramObject.a)
      {
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData
 * JD-Core Version:    0.7.0.1
 */