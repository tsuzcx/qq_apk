package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.util.AttributeSet;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.OnSelectGiftToUserListener;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.team.impl.main.IWidgetListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameMode;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

public class TeamPlayerListView
  extends RecyclerView
  implements IWidgetListener
{
  private static final String a = "TeamPlayerListView";
  private TeamPlayerAdapter b;
  private long c;
  private int d;
  private String e;
  private boolean f;
  private final Set<Long> g = new ArraySet();
  private final List<SpeakingPosBean> h = new ArrayList();
  private final OnSelectGiftToUserListener i = new TeamPlayerListView.1(this);
  
  public TeamPlayerListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TeamPlayerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    b();
  }
  
  private void a(int paramInt)
  {
    if (this.d != paramInt)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTotalMemberCount newCount= ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", curCount= ");
      localStringBuilder.append(this.d);
      Logger.a((String)localObject, localStringBuilder.toString());
      this.d = paramInt;
      int m = this.d;
      if (m <= 3)
      {
        localObject = getContext();
        f1 = 40.0F;
      }
      else
      {
        localObject = getContext();
        f1 = 12.0F;
      }
      int j = (int)UITools.a((Context)localObject, f1);
      float f2 = UITools.a(getContext(), 69.0F);
      float f1 = UITools.a(getContext()) - j * 2;
      f2 = m * f2;
      int n = m - 1;
      int k = (int)((f1 - f2) / n);
      paramInt = k;
      if (k < UITools.a(getContext(), 1.0F))
      {
        paramInt = (int)UITools.a(getContext(), 1.0F);
        j = (int)((UITools.a(getContext()) - f2 - n * paramInt) / 2.0F);
      }
      if (getItemDecorationCount() > 0)
      {
        k = getItemDecorationCount() - 1;
        while (k >= 0)
        {
          removeItemDecorationAt(k);
          k -= 1;
        }
      }
      addItemDecoration(new TeamPlayerListView.2(this, j, m, paramInt));
    }
  }
  
  private void b()
  {
    setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    setHasFixedSize(true);
  }
  
  public void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  public void a(TimiGiftController paramTimiGiftController)
  {
    paramTimiGiftController.a(this.i);
  }
  
  public void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    Object localObject = new ArrayList();
    paramList = paramList.iterator();
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo;
    while (paramList.hasNext())
    {
      localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)paramList.next();
      if (localYoloRoomSpeakingPosInfo.status.get() != 2) {
        ((List)localObject).add(localYoloRoomSpeakingPosInfo);
      }
    }
    a(((List)localObject).size());
    this.h.clear();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((Iterator)localObject).next();
      boolean bool = this.g.contains(Long.valueOf(localYoloRoomSpeakingPosInfo.user_id.uid.get()));
      List localList = this.h;
      if (bool) {
        paramList = this.e;
      } else {
        paramList = null;
      }
      localList.add(new SpeakingPosBean(localYoloRoomSpeakingPosInfo, paramList));
    }
    this.b.a(this.h, ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c).j());
  }
  
  public void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    this.b.a(paramConcurrentHashMap);
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    this.c = paramYoloRoomInfo.room_id.get();
    paramYoloRoomInfo = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c).g();
    if (paramYoloRoomInfo != null)
    {
      int j = paramYoloRoomInfo.game_mode.get();
      paramYoloRoomInfo = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).e(j);
      if (paramYoloRoomInfo != null) {
        j = paramYoloRoomInfo.max_player.get();
      } else {
        j = 5;
      }
      a(Math.min(5, j));
      this.h.clear();
      Iterator localIterator = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c).h().iterator();
      while (localIterator.hasNext())
      {
        YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localIterator.next();
        boolean bool = this.g.contains(Long.valueOf(localYoloRoomSpeakingPosInfo.user_id.uid.get()));
        List localList = this.h;
        if (bool) {
          paramYoloRoomInfo = this.e;
        } else {
          paramYoloRoomInfo = null;
        }
        localList.add(new SpeakingPosBean(localYoloRoomSpeakingPosInfo, paramYoloRoomInfo));
      }
      this.b = new TeamPlayerAdapter(getContext(), this.c, this.h, ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c).j(), ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c).f(), this.f);
      setAdapter(this.b);
    }
  }
  
  public TeamLaneStateView getHostLaneView()
  {
    return (TeamLaneStateView)findViewWithTag("TeamLaneStateView");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setVoiceEnable(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerListView
 * JD-Core Version:    0.7.0.1
 */