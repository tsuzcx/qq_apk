package com.tencent.timi.game.liveroom.impl.share;

import android.content.Intent;
import com.tencent.timi.game.liveroom.impl.share.iliveshare.ILiveShareHelper;

public class TgLiveShareParam
{
  public long a;
  public String b;
  public String c;
  public long d;
  public String e;
  public String f;
  public String g;
  public String h = "1";
  public String i = "1037";
  public String j = "1";
  public String k = "1";
  
  public Intent a()
  {
    return ILiveShareHelper.a(this);
  }
  
  public String a(int paramInt)
  {
    return ILiveShareHelper.a(this, paramInt);
  }
  
  public String b()
  {
    return ILiveShareHelper.a(this.g);
  }
  
  public String c()
  {
    return ILiveShareHelper.b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.TgLiveShareParam
 * JD-Core Version:    0.7.0.1
 */