package com.tencent.timi.game.room.impl;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.room.impl.tgpa.YoloRoomTGPALogic;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TimiGameQQTrtcUtil;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommunityConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloCommunityRoomConf;

public class YoloRoomList
{
  private static volatile YoloRoomList a;
  private HashMap<Long, YoloRoomManager> b = new HashMap();
  private YoloRoomTGPALogic c;
  private CopyOnWriteArrayList<YoloRoomInterface.YoloRoomLifecycleListener> d = new CopyOnWriteArrayList();
  private YoloRoomInterface.YoloRoomLifecycleListener e = new YoloRoomList.1(this);
  
  public static YoloRoomList a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new YoloRoomList();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateHasNeedResumeRoomExist ");
    localStringBuilder.append(paramBoolean);
    Logger.a("YoloRoomList", localStringBuilder.toString());
    TGSharedPreferenceUtil.a("tg_rooms_exist", paramBoolean);
  }
  
  public static void b()
  {
    try
    {
      if (a != null)
      {
        a.g();
        a = null;
      }
      return;
    }
    finally {}
  }
  
  private void g()
  {
    this.b.clear();
    this.d.clear();
  }
  
  private void h()
  {
    YoloRoomTGPALogic localYoloRoomTGPALogic = this.c;
    if (localYoloRoomTGPALogic != null)
    {
      localYoloRoomTGPALogic.b();
      this.c.c();
      this.c = null;
    }
    ((IniterService)ServiceCenter.a(IniterService.class)).a("YoloRoomList.clear");
  }
  
  public YoloRoomManager a(List<Integer> paramList)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      YoloRoomManager localYoloRoomManager = (YoloRoomManager)((Map.Entry)localIterator.next()).getValue();
      if (paramList.contains(Integer.valueOf(localYoloRoomManager.a()))) {
        return localYoloRoomManager;
      }
    }
    return null;
  }
  
  public YoloRoomOuterClass.YoloRoomInfo a(int paramInt)
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(paramInt));
    localObject = a((List)localObject);
    if (localObject != null) {
      return ((YoloRoomManager)localObject).b();
    }
    return null;
  }
  
  public void a(int paramInt1, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList, int paramInt2, long paramLong, YoloRoomOuterClass.YoloRoomConf paramYoloRoomConf, YoloRoomOuterClass.YoloRoomUserData paramYoloRoomUserData)
  {
    long l = paramYoloRoomInfo.room_id.get();
    YoloRoomManager localYoloRoomManager = b(l);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onJoinNewRoom - JoinRoomType.");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", roomId = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", latestActionId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", speakingPosListVersion = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramList);
    Logger.a("YoloRoomList", ((StringBuilder)localObject).toString());
    int i;
    if ((paramInt1 == 2) && (localYoloRoomManager != null)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = localYoloRoomManager;
    if (i == 0)
    {
      if (localYoloRoomManager != null) {
        a(l);
      }
      localObject = new YoloRoomManager(l);
      this.b.put(Long.valueOf(l), localObject);
    }
    ((YoloRoomManager)localObject).a(paramInt1, paramYoloRoomInfo, paramList, paramInt2, paramLong, paramYoloRoomConf, paramYoloRoomUserData);
    if (this.c == null)
    {
      this.c = new YoloRoomTGPALogic();
      this.c.a();
    }
    if (paramYoloRoomInfo.room_type.get() != 5) {
      a(true);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doWhenExitRoom - ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("YoloRoomList", ((StringBuilder)localObject).toString());
    localObject = (YoloRoomManager)this.b.remove(Long.valueOf(paramLong));
    if (localObject != null) {
      ((YoloRoomManager)localObject).s();
    }
    if (this.b.size() == 0) {
      h();
    }
    localObject = this.b.entrySet().iterator();
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1 = ((Iterator)localObject).hasNext();
      boolean bool5 = true;
      if (!bool1) {
        break;
      }
      YoloRoomManager localYoloRoomManager = (YoloRoomManager)((Map.Entry)((Iterator)localObject).next()).getValue();
      int i = localYoloRoomManager.a();
      if (i != 1)
      {
        if (i != 5) {
          continue;
        }
        bool1 = bool5;
        if (bool2) {}
      }
      try
      {
        bool1 = localYoloRoomManager.c().yolo_room_community_conf.wuji_yolo_room_community_conf.speaking_list_switch.get();
        if (bool1) {
          bool1 = bool5;
        } else {
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        label199:
        break label199;
      }
      Logger.d("YoloRoomList", "doWhenExitRoom getRoomConf failed");
      continue;
      bool2 = bool1;
      continue;
      bool3 = true;
      bool4 = true;
    }
    a(bool3);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doWhenExitRoom hasSmobaRoom:");
    ((StringBuilder)localObject).append(bool4);
    ((StringBuilder)localObject).append(", hasCommunityRoomWithMicCard:");
    ((StringBuilder)localObject).append(bool2);
    Logger.b("YoloRoomList", 1, ((StringBuilder)localObject).toString());
    if ((this.b.size() == 0) || ((!bool4) && (!bool2)))
    {
      Logger.c("YoloRoomList", "abandonQQAudioEnv");
      TimiGameQQTrtcUtil.a();
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.e.a(paramLong, paramInt);
  }
  
  public void a(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    if ((paramYoloRoomLifecycleListener != null) && (!this.d.contains(paramYoloRoomLifecycleListener))) {
      this.d.add(paramYoloRoomLifecycleListener);
    }
  }
  
  public void a(boolean paramBoolean, YoloRoomOuterClass.YoloUserGameData paramYoloUserGameData)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomManager)((Map.Entry)localIterator.next()).getValue()).a(paramBoolean, paramYoloUserGameData, null);
    }
  }
  
  public YoloRoomManager b(long paramLong)
  {
    return (YoloRoomManager)this.b.get(Long.valueOf(paramLong));
  }
  
  public void b(long paramLong, int paramInt)
  {
    this.e.b(paramLong, paramInt);
  }
  
  public void b(YoloRoomInterface.YoloRoomLifecycleListener paramYoloRoomLifecycleListener)
  {
    if ((paramYoloRoomLifecycleListener != null) && (this.d.contains(paramYoloRoomLifecycleListener))) {
      this.d.remove(paramYoloRoomLifecycleListener);
    }
  }
  
  public void c()
  {
    boolean bool = TGSharedPreferenceUtil.b("tg_rooms_exist", false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLogout - ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", localRoomCacheValue = ");
    ((StringBuilder)localObject).append(bool);
    Logger.a("YoloRoomList", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = new ArrayList();
      ((List)localObject).addAll(this.b.values());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((YoloRoomManager)((Iterator)localObject).next()).y();
      }
    }
    b();
    if (bool)
    {
      Logger.a("YoloRoomList", "resume updateHasNeedResumeRoomExist");
      a(bool);
    }
  }
  
  public boolean c(long paramLong)
  {
    return this.b.get(Long.valueOf(paramLong)) != null;
  }
  
  public boolean d()
  {
    return this.b.size() > 0;
  }
  
  public void e()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((YoloRoomManager)((Map.Entry)localIterator.next()).getValue()).E();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      YoloRoomManager localYoloRoomManager = (YoloRoomManager)((Map.Entry)localIterator.next()).getValue();
      YoloRoomOuterClass.YoloSmobaGameDataInfo localYoloSmobaGameDataInfo = localYoloRoomManager.g();
      int i;
      if (localYoloSmobaGameDataInfo != null) {
        i = localYoloSmobaGameDataInfo.voice_control.get();
      } else {
        i = 0;
      }
      if ((1 != i) && (localYoloRoomManager.a() != 2)) {
        Logger.a("YoloRoomList", "onGameSceneChanged#YOLO_SMOBA_ROOM_VOICE_CONTROL_DEFAULT   doNothing");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomList
 * JD-Core Version:    0.7.0.1
 */