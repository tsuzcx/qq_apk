package com.tencent.timi.game.room.impl;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class YoloRoomManager$52
  implements YoloRoomInterface.YoloRoomCommonListener
{
  YoloRoomManager$52(YoloRoomManager paramYoloRoomManager) {}
  
  public void a(int paramInt)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramInt, paramString);
    }
  }
  
  public void a(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramInt, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void a(long paramLong)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramLong);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramLong, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void a(String paramString, int paramInt, YoloRoomOuterClass.YoloBattleOBStatusChangeAction paramYoloBattleOBStatusChangeAction)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramString, paramInt, paramYoloBattleOBStatusChangeAction);
    }
  }
  
  public void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramList);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).a(paramBoolean, paramInt, paramYoloGameRouteInfo);
    }
  }
  
  public void b(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).b(paramInt, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void b(long paramLong)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).b(paramLong);
    }
  }
  
  public void b(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).b(paramLong, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void b(List<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).b(paramList);
    }
  }
  
  public void c(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).c(paramInt, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void c(long paramLong)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).c(paramLong);
    }
  }
  
  public void d(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).d(paramInt, paramYoloRoomSpeakingPosInfo, paramList);
    }
  }
  
  public void d(long paramLong)
  {
    Iterator localIterator = YoloRoomManager.r(this.a).iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomInterface.YoloRoomCommonListener)localIterator.next()).d(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.52
 * JD-Core Version:    0.7.0.1
 */