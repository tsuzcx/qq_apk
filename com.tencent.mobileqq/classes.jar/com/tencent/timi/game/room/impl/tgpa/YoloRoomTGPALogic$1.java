package com.tencent.timi.game.room.impl.tgpa;

import android.text.TextUtils;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.tgpa.TGPAUtil.TGPAGameDataCallback;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.ThreadPool;

class YoloRoomTGPALogic$1
  implements TGPAUtil.TGPAGameDataCallback
{
  YoloRoomTGPALogic$1(YoloRoomTGPALogic paramYoloRoomTGPALogic) {}
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameSceneChanged ");
    localStringBuilder.append(paramInt);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
    if ((102 == paramInt) && (YoloRoomList.a().d())) {
      YoloRoomList.a().f();
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        bool = YoloRoomList.a().d();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResourceUpdateProgress ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append(", hasRoomExist = ");
        localStringBuilder.append(bool);
        Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
        return;
      }
      if (YoloRoomTGPALogic.e(this.a) != paramFloat)
      {
        YoloRoomTGPALogic.b(this.a, paramFloat);
        bool = YoloRoomList.a().d();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResourceUpdateProgress ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" - ");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append(", hasRoomExist = ");
        localStringBuilder.append(bool);
        Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
        if (bool) {
          ThreadPool.a(new YoloRoomTGPALogic.1.4(this, paramFloat));
        }
      }
    }
    else if (YoloRoomTGPALogic.d(this.a) != paramFloat)
    {
      YoloRoomTGPALogic.a(this.a, paramFloat);
      bool = YoloRoomList.a().d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResourceUpdateProgress ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" - ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", hasRoomExist = ");
      localStringBuilder.append(bool);
      Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
      if (bool) {
        ThreadPool.a(new YoloRoomTGPALogic.1.3(this, paramFloat));
      }
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveGameVersion - ");
    localStringBuilder.append(paramString);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(YoloRoomTGPALogic.a(this.a))))
    {
      YoloRoomTGPALogic.a(this.a, paramString);
      YoloRoomTGPALogic.b(this.a);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveCustomData ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramObject);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGameVoiceSwitch - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
    ThreadPool.a(new YoloRoomTGPALogic.1.5(this));
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveResourceVersion - ");
    localStringBuilder.append(paramString);
    Logger.a("YoloRoomTGPALogic", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(YoloRoomTGPALogic.c(this.a))))
    {
      YoloRoomTGPALogic.b(this.a, paramString);
      YoloRoomTGPALogic.b(this.a);
    }
    if (YoloRoomList.a().d()) {
      ThreadPool.a(new YoloRoomTGPALogic.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic.1
 * JD-Core Version:    0.7.0.1
 */