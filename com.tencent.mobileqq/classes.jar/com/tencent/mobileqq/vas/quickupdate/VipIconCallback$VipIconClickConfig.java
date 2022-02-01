package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import androidx.annotation.Nullable;

public class VipIconCallback$VipIconClickConfig
{
  String a;
  String b;
  String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof VipIconClickConfig))
    {
      paramObject = (VipIconClickConfig)paramObject;
      return (TextUtils.equals(paramObject.a, this.a)) && (TextUtils.equals(paramObject.b, this.b)) && (TextUtils.equals(paramObject.c, this.c));
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.quickupdate.VipIconCallback.VipIconClickConfig
 * JD-Core Version:    0.7.0.1
 */