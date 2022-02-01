package com.tencent.mobileqq.guild.mainframe.container.discover.tab;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Objects;

public class QQGuildDisSubTabInfo
{
  public int a;
  public String b;
  public int c;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof QQGuildDisSubTabInfo)) {
      return false;
    }
    paramObject = (QQGuildDisSubTabInfo)paramObject;
    return (this.a == paramObject.a) && (this.c == paramObject.c) && (TextUtils.equals(this.b, paramObject.b));
  }
  
  @RequiresApi(api=19)
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(this.a), this.b, Integer.valueOf(this.c) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.tab.QQGuildDisSubTabInfo
 * JD-Core Version:    0.7.0.1
 */