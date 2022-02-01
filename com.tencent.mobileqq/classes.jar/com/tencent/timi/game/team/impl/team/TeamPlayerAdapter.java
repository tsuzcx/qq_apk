package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarSpeakingMicImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamInfo;
import trpc.yes.common.SmobaDataOuterClass.YoloTeamMemberInfo;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema;
import trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaSchema;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaUserGameData;
import trpc.yes.common.YoloRoomOuterClass.YoloUserGameData;

public class TeamPlayerAdapter
  extends RecyclerView.Adapter<TeamPlayerViewHolder>
{
  protected List<SpeakingPosBean> a = new ArrayList();
  private Context b;
  private LayoutInflater c;
  private long d;
  private YoloRoomOuterClass.YoloGameRouteInfo e;
  private long f;
  private YoloRoomOuterClass.YoloRoomInfo g;
  private HashMap<Integer, MicWaveViewLottie> h = new HashMap();
  private boolean i;
  
  public TeamPlayerAdapter(Context paramContext, long paramLong1, List<SpeakingPosBean> paramList, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo, long paramLong2, boolean paramBoolean)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.i = paramBoolean;
    this.f = paramLong1;
    this.e = paramYoloGameRouteInfo;
    this.d = paramLong2;
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
    this.g = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong1).b();
  }
  
  private QBaseActivity a()
  {
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.b;
    if ((localObject instanceof QBaseActivity)) {
      return (QBaseActivity)localObject;
    }
    return null;
  }
  
  private void a(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo)
  {
    int j = paramInt + 1;
    if (paramYoloRoomSpeakingPosInfo.status.get() == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.f).a(true, j, new TeamPlayerAdapter.4(this));
      return;
    }
    paramYoloRoomSpeakingPosInfo = QBaseActivity.sTopActivity;
    if (paramYoloRoomSpeakingPosInfo != null)
    {
      paramYoloRoomSpeakingPosInfo = DialogUtil.a(paramYoloRoomSpeakingPosInfo, 230);
      paramYoloRoomSpeakingPosInfo.setMessage("确认关闭该座位吗？");
      paramYoloRoomSpeakingPosInfo.setPositiveButton("确认", new TeamPlayerAdapter.5(this, j));
      paramYoloRoomSpeakingPosInfo.setNegativeButton("取消", new TeamPlayerAdapter.6(this));
      paramYoloRoomSpeakingPosInfo.show();
    }
  }
  
  @NonNull
  public TeamPlayerViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new TeamPlayerViewHolder(this.c.inflate(2131629497, null, false), this.f);
  }
  
  public void a(long paramLong)
  {
    if (paramLong != this.d)
    {
      this.d = paramLong;
      notifyDataSetChanged();
    }
  }
  
  public void a(@NonNull TeamPlayerViewHolder paramTeamPlayerViewHolder, int paramInt)
  {
    Object localObject2 = (SpeakingPosBean)this.a.get(paramInt);
    YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = ((SpeakingPosBean)localObject2).a();
    long l1 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    int j;
    if (l1 == this.d) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1 = new CommonOuterClass.QQUserId();
    ((CommonOuterClass.QQUserId)localObject1).uid.set(localYoloRoomSpeakingPosInfo.uid.get());
    ((CommonOuterClass.QQUserId)localObject1).user_from.set(localYoloRoomSpeakingPosInfo.user_from.get());
    ((CommonOuterClass.QQUserId)localObject1).guild_id.set(localYoloRoomSpeakingPosInfo.guild_id.get());
    long l2 = localYoloRoomSpeakingPosInfo.uid.get();
    Object localObject4 = null;
    if (l2 != 0L)
    {
      if (localYoloRoomSpeakingPosInfo.uid.get() == l1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (localYoloRoomSpeakingPosInfo.uid.get() == this.d) {
        k = 1;
      } else {
        k = 0;
      }
      paramTeamPlayerViewHolder.i.setVisibility(8);
      paramTeamPlayerViewHolder.j.setVisibility(8);
      paramTeamPlayerViewHolder.k.setVisibility(0);
      if (!TextUtils.isEmpty(((SpeakingPosBean)localObject2).b()))
      {
        paramTeamPlayerViewHolder.l.setVisibility(0);
        localObject2 = URLDrawable.getFileDrawable(((SpeakingPosBean)localObject2).b(), URLDrawable.URLDrawableOptions.obtain());
        paramTeamPlayerViewHolder.k.setImageDrawable((Drawable)localObject2);
      }
      else
      {
        paramTeamPlayerViewHolder.l.setVisibility(8);
        paramTeamPlayerViewHolder.k.setImageDrawable(null);
      }
      localObject2 = paramTeamPlayerViewHolder.g;
      if (k != 0) {
        k = 0;
      } else {
        k = 8;
      }
      ((View)localObject2).setVisibility(k);
      if ((j != 0) && (paramInt == 0))
      {
        paramTeamPlayerViewHolder.h.setVisibility(0);
        paramTeamPlayerViewHolder.h.setImageResource(2130853104);
        paramTeamPlayerViewHolder.h.setOnClickListener(new TeamPlayerAdapter.1(this, (CommonOuterClass.QQUserId)localObject1, paramTeamPlayerViewHolder, localYoloRoomSpeakingPosInfo));
      }
      else
      {
        paramTeamPlayerViewHolder.h.setVisibility(8);
        paramTeamPlayerViewHolder.h.setOnClickListener(null);
      }
      paramTeamPlayerViewHolder.a.setVisibility(0);
      paramTeamPlayerViewHolder.b.setVisibility(0);
      paramTeamPlayerViewHolder.a.setUserId((CommonOuterClass.QQUserId)localObject1);
      paramTeamPlayerViewHolder.b.setUserId((CommonOuterClass.QQUserId)localObject1);
      paramTeamPlayerViewHolder.m.setState((CommonOuterClass.QQUserId)localObject1, localYoloRoomSpeakingPosInfo.user_game_data.user_smoba_game_data.hero_lane_type.get());
      if (this.i)
      {
        paramTeamPlayerViewHolder.e.setVisibility(0);
        localObject2 = paramTeamPlayerViewHolder.e;
        boolean bool;
        if (localYoloRoomSpeakingPosInfo.voice_switch.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((AvatarSpeakingMicImageView)localObject2).setData((CommonOuterClass.QQUserId)localObject1, bool);
        paramTeamPlayerViewHolder.f.setVisibility(0);
        paramTeamPlayerViewHolder.f.setUserId((CommonOuterClass.QQUserId)localObject1);
        localObject2 = paramTeamPlayerViewHolder.f;
        if (localYoloRoomSpeakingPosInfo.voice_switch.get() == 1) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        ((MicWaveViewLottie)localObject2).setVisibility(paramInt);
        paramTeamPlayerViewHolder.f.setTag(2131434054, ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a(localYoloRoomSpeakingPosInfo.uid.get()));
        this.h.put(Integer.valueOf(localYoloRoomSpeakingPosInfo.pos.get()), paramTeamPlayerViewHolder.f);
        paramTeamPlayerViewHolder.a.setNeedDrawSex(false);
      }
      else
      {
        paramTeamPlayerViewHolder.e.setVisibility(8);
        paramTeamPlayerViewHolder.f.setVisibility(8);
        paramTeamPlayerViewHolder.a.setNeedDrawSex(true);
      }
      paramTeamPlayerViewHolder.a.setOnClickListener(new TeamPlayerAdapter.2(this, (CommonOuterClass.QQUserId)localObject1, paramTeamPlayerViewHolder, localYoloRoomSpeakingPosInfo));
      int i1 = Color.parseColor("#999999");
      localObject1 = this.e;
      if ((localObject1 != null) && (((YoloRoomOuterClass.YoloGameRouteInfo)localObject1).smoba_game_route_info.has())) {
        localObject1 = (YoloBattleSmobaOuterClass.YoloSmobaSchema)((YoloRoomOuterClass.YoloSmobaGameRouteInfo)this.e.smoba_game_route_info.get()).smoba_schema.get();
      } else {
        localObject1 = null;
      }
      if ((localObject1 != null) && (((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject1).schemas.size() > 0))
      {
        paramInt = 0;
        while (paramInt < ((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject1).schemas.size())
        {
          localObject2 = (YoloBattleSmobaOuterClass.YoloSmobaOneSchema)((YoloBattleSmobaOuterClass.YoloSmobaSchema)localObject1).schemas.get(paramInt);
          if (((YoloBattleSmobaOuterClass.YoloSmobaOneSchema)localObject2).uid.get() == localYoloRoomSpeakingPosInfo.uid.get())
          {
            localObject1 = localObject2;
            break label767;
          }
          paramInt += 1;
        }
      }
      localObject1 = null;
      label767:
      localObject2 = this.e;
      Object localObject3;
      if ((localObject2 != null) && (((YoloRoomOuterClass.YoloGameRouteInfo)localObject2).smoba_game_route_info.has())) {
        localObject3 = (SmobaDataOuterClass.YoloTeamInfo)this.e.smoba_game_route_info.team_info.get();
      } else {
        localObject3 = null;
      }
      localObject2 = localObject4;
      if (localObject3 != null)
      {
        localObject2 = localObject4;
        if (((SmobaDataOuterClass.YoloTeamInfo)localObject3).memberlist.size() > 0)
        {
          localObject3 = ((SmobaDataOuterClass.YoloTeamInfo)localObject3).memberlist.get().iterator();
          do
          {
            localObject2 = localObject4;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (SmobaDataOuterClass.YoloTeamMemberInfo)((Iterator)localObject3).next();
          } while (((SmobaDataOuterClass.YoloTeamMemberInfo)localObject2).uid.get() != localYoloRoomSpeakingPosInfo.uid.get());
        }
      }
      if (localObject1 != null) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((paramInt != 0) && (localObject2 != null)) {
        k = 1;
      } else {
        k = 0;
      }
      if (((YoloRoomOuterClass.YoloSmobaUserGameData)((YoloRoomOuterClass.YoloUserGameData)localYoloRoomSpeakingPosInfo.user_game_data.get()).user_smoba_game_data.get()).update_status.get() == 1) {
        m = 1;
      } else {
        m = 0;
      }
      if (localYoloRoomSpeakingPosInfo.leave_status.get() == 1) {
        j = 1;
      } else {
        j = 0;
      }
      localObject1 = this.e;
      int n;
      if (localObject1 != null) {
        n = ((YoloRoomOuterClass.YoloGameRouteInfo)localObject1).game_status.get();
      } else {
        n = 0;
      }
      localObject1 = "";
      if (n == 3) {
        if (k != 0) {
          localObject1 = "游戏中";
        }
      }
      for (;;)
      {
        paramInt = 0;
        break;
        do
        {
          paramInt = 1;
          break label1149;
          if ((n == 2) && (k != 0))
          {
            localObject1 = "游戏队伍中";
            break;
          }
          if (m != 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("更新中 ");
            ((StringBuilder)localObject1).append(((YoloRoomOuterClass.YoloSmobaUserGameData)((YoloRoomOuterClass.YoloUserGameData)localYoloRoomSpeakingPosInfo.user_game_data.get()).user_smoba_game_data.get()).update_process.get());
            ((StringBuilder)localObject1).append("%");
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        } while (paramInt == 0);
        localObject1 = "启动游戏中";
      }
      label1149:
      int m = i1;
      int k = paramInt;
      localObject2 = localObject1;
      if (paramInt != 0)
      {
        m = i1;
        k = paramInt;
        localObject2 = localObject1;
        if (j != 0)
        {
          m = Color.parseColor("#999999");
          localObject2 = "离开";
          k = 0;
        }
      }
      if (k != 0)
      {
        if (localYoloRoomSpeakingPosInfo.ready_status.get() == 1)
        {
          paramTeamPlayerViewHolder.d.setVisibility(8);
          paramTeamPlayerViewHolder.c.setImageResource(2130853040);
          return;
        }
        paramTeamPlayerViewHolder.c.setVisibility(8);
        paramTeamPlayerViewHolder.d.setVisibility(0);
        paramInt = Color.parseColor("#999999");
        paramTeamPlayerViewHolder.d.setText("未准备");
        paramTeamPlayerViewHolder.d.setTextColor(paramInt);
        return;
      }
      paramTeamPlayerViewHolder.c.setVisibility(8);
      paramTeamPlayerViewHolder.d.setVisibility(0);
      paramTeamPlayerViewHolder.d.setText((CharSequence)localObject2);
      paramTeamPlayerViewHolder.d.setTextColor(m);
      return;
    }
    paramTeamPlayerViewHolder.k.setVisibility(8);
    paramTeamPlayerViewHolder.l.setVisibility(8);
    paramTeamPlayerViewHolder.k.setBackgroundDrawable(null);
    paramTeamPlayerViewHolder.a.e();
    paramTeamPlayerViewHolder.b.e();
    paramTeamPlayerViewHolder.a.setVisibility(8);
    paramTeamPlayerViewHolder.b.setVisibility(4);
    if (this.i)
    {
      paramTeamPlayerViewHolder.e.e();
      paramTeamPlayerViewHolder.e.setVisibility(8);
      paramTeamPlayerViewHolder.f.setVisibility(8);
      this.h.remove(Integer.valueOf(localYoloRoomSpeakingPosInfo.pos.get()));
    }
    paramTeamPlayerViewHolder.d.setVisibility(8);
    paramTeamPlayerViewHolder.c.setVisibility(8);
    paramTeamPlayerViewHolder.g.setVisibility(8);
    paramTeamPlayerViewHolder.i.setVisibility(0);
    paramTeamPlayerViewHolder.j.setVisibility(8);
    paramTeamPlayerViewHolder.a.setOnClickListener(null);
    paramTeamPlayerViewHolder.m.a();
    if ((localYoloRoomSpeakingPosInfo.status.get() != 1) && (localYoloRoomSpeakingPosInfo.status.get() != 2))
    {
      paramTeamPlayerViewHolder.i.setImageResource(2130853106);
      paramTeamPlayerViewHolder.j.setVisibility(8);
      if (j != 0)
      {
        paramTeamPlayerViewHolder.h.setVisibility(0);
        paramTeamPlayerViewHolder.h.setOnClickListener(null);
        paramTeamPlayerViewHolder.h.setImageResource(2130853108);
      }
    }
    else
    {
      paramTeamPlayerViewHolder.i.setImageResource(2130853105);
      paramTeamPlayerViewHolder.j.setVisibility(0);
      paramTeamPlayerViewHolder.j.setText("座位关闭");
      paramTeamPlayerViewHolder.i.setOnClickListener(null);
      if (j != 0)
      {
        paramTeamPlayerViewHolder.h.setVisibility(0);
        paramTeamPlayerViewHolder.h.setOnClickListener(null);
        paramTeamPlayerViewHolder.h.setImageResource(2130853107);
      }
    }
    if (j != 0)
    {
      localObject1 = new TeamPlayerAdapter.3(this, paramTeamPlayerViewHolder, paramInt, localYoloRoomSpeakingPosInfo);
      paramTeamPlayerViewHolder.i.setOnClickListener((View.OnClickListener)localObject1);
      paramTeamPlayerViewHolder.h.setOnClickListener((View.OnClickListener)localObject1);
      return;
    }
    paramTeamPlayerViewHolder.i.setOnClickListener(null);
    paramTeamPlayerViewHolder.h.setOnClickListener(null);
  }
  
  public void a(List<SpeakingPosBean> paramList, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo)
  {
    this.a.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.a.addAll(paramList);
    }
    this.e = paramYoloGameRouteInfo;
    notifyDataSetChanged();
  }
  
  public void a(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap != null) && (paramConcurrentHashMap.size() > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder("onAudioMemberMicLevelChanged - ");
      Iterator localIterator1 = paramConcurrentHashMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        paramConcurrentHashMap = (Map.Entry)localIterator1.next();
        boolean bool;
        if (((Integer)paramConcurrentHashMap.getValue()).intValue() > 10) {
          bool = true;
        } else {
          bool = false;
        }
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append((String)paramConcurrentHashMap.getKey());
        localStringBuilder1.append("_");
        localStringBuilder1.append(paramConcurrentHashMap.getValue());
        localStringBuilder1.append("_");
        localStringBuilder1.append(bool);
        localStringBuilder1.append(" --- ");
        localStringBuilder2.append(localStringBuilder1.toString());
        if (bool) {}
        try
        {
          String str = (String)paramConcurrentHashMap.getKey();
          if (!TextUtils.isEmpty(str))
          {
            localStringBuilder1 = null;
            Iterator localIterator2 = this.h.entrySet().iterator();
            Object localObject;
            do
            {
              do
              {
                paramConcurrentHashMap = localStringBuilder1;
                if (!localIterator2.hasNext()) {
                  break;
                }
                paramConcurrentHashMap = (Map.Entry)localIterator2.next();
              } while (paramConcurrentHashMap.getValue() == null);
              localObject = ((MicWaveViewLottie)paramConcurrentHashMap.getValue()).getTag(2131434054);
            } while ((localObject == null) || (!(localObject instanceof String)) || (!str.equals(localObject)));
            paramConcurrentHashMap = (MicWaveViewLottie)paramConcurrentHashMap.getValue();
            if (paramConcurrentHashMap == null) {
              continue;
            }
            paramConcurrentHashMap.e();
            continue;
          }
          localStringBuilder2.append("uid not valid");
        }
        catch (Exception paramConcurrentHashMap)
        {
          label296:
          break label296;
        }
        localStringBuilder2.append("parseLong exception");
      }
    }
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerAdapter
 * JD-Core Version:    0.7.0.1
 */