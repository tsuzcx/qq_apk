package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.content.Intent;
import com.tencent.timi.game.liveroom.impl.share.TgLiveShareParam;

public class TgShareParam
{
  public TgLiveShareParam a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public boolean i = true;
  
  public Intent a()
  {
    TgLiveShareParam localTgLiveShareParam = this.a;
    if (localTgLiveShareParam != null) {
      return localTgLiveShareParam.a();
    }
    return null;
  }
  
  public TgShareParam.ShareBody a(int paramInt)
  {
    TgShareParam.ShareBody localShareBody = new TgShareParam.ShareBody();
    localShareBody.c = this.f;
    TgLiveShareParam localTgLiveShareParam = this.a;
    if (localTgLiveShareParam != null) {
      localShareBody.d = localTgLiveShareParam.a(paramInt);
    } else {
      localShareBody.d = this.g;
    }
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return localShareBody;
          }
        }
        else
        {
          localShareBody.a = this.e;
          localShareBody.b = this.c;
          return localShareBody;
        }
      }
      else
      {
        localShareBody.a = this.b;
        localShareBody.b = this.c;
        return localShareBody;
      }
    }
    localShareBody.a = this.d;
    localShareBody.b = this.c;
    return localShareBody;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TgShareParam
 * JD-Core Version:    0.7.0.1
 */