package com.tencent.timi.game.teamlist.presenter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.teamlist.report.TeamListReport;
import com.tencent.timi.game.teamlist.view.TeamListItemHorizontalEndViewHolder;
import com.tencent.timi.game.teamlist.view.TeamListItemViewHolder;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public class TeamListVerticalAdapter
  extends RecyclerView.Adapter
{
  private int a = -1;
  private String b = "";
  private int c = -1;
  private List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> d = new ArrayList();
  private TeamListVerticalAdapter.OnTeamClickListener e;
  
  private int a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sourceID: ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" originID:");
    ((StringBuilder)localObject).append(this.b);
    Logger.a("TeamListVerticalAdapter", ((StringBuilder)localObject).toString());
    if (this.c == 1) {
      return -1;
    }
    localObject = this.d;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int i = 0;
      while (i < this.d.size())
      {
        if ((!TextUtils.isEmpty(this.b)) && (!((PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)this.d.get(i)).origin_id.get().equals(this.b)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("divider pos: ");
          ((StringBuilder)localObject).append(i);
          Logger.a("TeamListVerticalAdapter", ((StringBuilder)localObject).toString());
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(TeamListVerticalAdapter.OnTeamClickListener paramOnTeamClickListener)
  {
    this.e = paramOnTeamClickListener;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList)
  {
    this.d = paramList;
    this.a = a();
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.d.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == this.d.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof TeamListItemViewHolder))
    {
      TeamListItemViewHolder localTeamListItemViewHolder = (TeamListItemViewHolder)paramViewHolder;
      boolean bool;
      if (this.a == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localTeamListItemViewHolder.a(bool);
      Object localObject1 = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject1).setMargins(0, ViewUtils.dpToPx(12.0F), 0, 0);
      if (paramInt == 0) {
        ((RecyclerView.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      } else if (this.d.size() - 1 == paramInt) {
        ((RecyclerView.LayoutParams)localObject1).setMargins(0, ViewUtils.dpToPx(12.0F), 0, ViewUtils.dpToPx(90.0F));
      }
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      PremadesTeamServerOuterClass.SmobaPremadesTeamInfo localSmobaPremadesTeamInfo = (PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)this.d.get(paramInt);
      Iterator localIterator = localSmobaPremadesTeamInfo.icon_list.get().iterator();
      String str = "";
      localObject1 = str;
      Object localObject2 = localObject1;
      Object localObject3 = localObject2;
      while (localIterator.hasNext())
      {
        PremadesTeamServerOuterClass.SmobaPremadesTeamIcon localSmobaPremadesTeamIcon = (PremadesTeamServerOuterClass.SmobaPremadesTeamIcon)localIterator.next();
        if ("s_bg".equals(localSmobaPremadesTeamIcon.key.get())) {
          str = localSmobaPremadesTeamIcon.value.get();
        } else if ("tag_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          localObject1 = localSmobaPremadesTeamIcon.value.get();
        } else if ("add_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          localObject2 = localSmobaPremadesTeamIcon.value.get();
        } else if ("lock_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          localObject3 = localSmobaPremadesTeamIcon.value.get();
        }
      }
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.game_mode.get(), 287.0F, 125.0F, str, (String)localObject1, (String)localObject2);
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.grade_desc.get(), localSmobaPremadesTeamInfo.name.get(), localSmobaPremadesTeamInfo.lane_type_desc.get(), localSmobaPremadesTeamInfo.game_mode_name.get());
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.user_list.get(), (String)localObject2, (String)localObject3);
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.id.get(), localSmobaPremadesTeamInfo.type.get(), localSmobaPremadesTeamInfo.game_mode.get(), localSmobaPremadesTeamInfo.grade_list.get(), this.e);
      TeamListReport.b(paramViewHolder.itemView, String.valueOf(localSmobaPremadesTeamInfo.id.get()), localSmobaPremadesTeamInfo.name.get(), localSmobaPremadesTeamInfo.grade_list.get(), localSmobaPremadesTeamInfo.lane_type_list.get(), String.valueOf(localSmobaPremadesTeamInfo.game_mode.get()));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new TeamListItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629531, paramViewGroup, false));
    }
    if (paramInt == 1) {
      return new TeamListItemHorizontalEndViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629530, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListVerticalAdapter
 * JD-Core Version:    0.7.0.1
 */