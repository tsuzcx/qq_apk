package com.tencent.timi.game.teamlist.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.timi.game.teamlist.view.TeamListItemHorizontalCreateTeamViewHolder;
import com.tencent.timi.game.teamlist.view.TeamListItemHorizontalEndViewHolder;
import com.tencent.timi.game.teamlist.view.TeamListItemViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamIcon;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public class TeamListHorizontalAdapter
  extends RecyclerView.Adapter
{
  private List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> a = new ArrayList();
  private int b;
  private View.OnClickListener c;
  private boolean d = false;
  private TeamListVerticalAdapter.OnTeamClickListener e;
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void a(List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList, int paramInt, boolean paramBoolean)
  {
    this.a = paramList;
    this.b = paramInt;
    this.d = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public int getItemCount()
  {
    if (this.a.size() == 1) {
      return this.a.size() + 1;
    }
    if (this.a.size() < 2) {
      this.d = false;
    }
    if (this.d) {
      return this.a.size() + 1;
    }
    return this.a.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == this.a.size())
    {
      if (this.a.size() == 1) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1;
    if ((paramViewHolder instanceof TeamListItemViewHolder))
    {
      TeamListItemViewHolder localTeamListItemViewHolder = (TeamListItemViewHolder)paramViewHolder;
      localTeamListItemViewHolder.a(false);
      localObject1 = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      if (paramInt == 0) {
        ((RecyclerView.LayoutParams)localObject1).setMargins(ViewUtils.dpToPx(16.0F), 0, 0, 0);
      } else if ((getItemCount() == this.b) && (paramInt == this.a.size() - 1)) {
        ((RecyclerView.LayoutParams)localObject1).setMargins(ViewUtils.dpToPx(12.0F), 0, ViewUtils.dpToPx(16.0F), 0);
      } else {
        ((RecyclerView.LayoutParams)localObject1).setMargins(ViewUtils.dpToPx(12.0F), 0, 0, 0);
      }
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      PremadesTeamServerOuterClass.SmobaPremadesTeamInfo localSmobaPremadesTeamInfo = (PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)this.a.get(paramInt);
      Iterator localIterator = localSmobaPremadesTeamInfo.icon_list.get().iterator();
      String str2 = "";
      String str1 = "";
      localObject1 = str1;
      Object localObject2 = localObject1;
      while (localIterator.hasNext())
      {
        PremadesTeamServerOuterClass.SmobaPremadesTeamIcon localSmobaPremadesTeamIcon = (PremadesTeamServerOuterClass.SmobaPremadesTeamIcon)localIterator.next();
        if ("f_bg".equals(localSmobaPremadesTeamIcon.key.get())) {
          localObject1 = localSmobaPremadesTeamIcon.value.get();
        } else if ("tag_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          localObject2 = localSmobaPremadesTeamIcon.value.get();
        } else if ("add_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          str2 = localSmobaPremadesTeamIcon.value.get();
        } else if ("lock_icon".equals(localSmobaPremadesTeamIcon.key.get())) {
          str1 = localSmobaPremadesTeamIcon.value.get();
        }
      }
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.game_mode.get(), 200.0F, 125.0F, (String)localObject1, (String)localObject2, str2);
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.grade_desc.get(), localSmobaPremadesTeamInfo.name.get(), localSmobaPremadesTeamInfo.lane_type_desc.get(), localSmobaPremadesTeamInfo.game_mode_name.get());
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.user_list.get(), str2, str1);
      localTeamListItemViewHolder.a(localSmobaPremadesTeamInfo.id.get(), localSmobaPremadesTeamInfo.type.get(), localSmobaPremadesTeamInfo.game_mode.get(), localSmobaPremadesTeamInfo.grade_list.get(), this.e);
      TeamListReport.a(paramViewHolder.itemView, String.valueOf(localSmobaPremadesTeamInfo.id.get()), localSmobaPremadesTeamInfo.name.get(), localSmobaPremadesTeamInfo.grade_list.get(), localSmobaPremadesTeamInfo.lane_type_list.get(), String.valueOf(localSmobaPremadesTeamInfo.game_mode.get()));
      return;
    }
    if ((paramViewHolder instanceof TeamListItemHorizontalCreateTeamViewHolder))
    {
      localObject1 = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject1).setMargins(ViewUtils.dpToPx(12.0F), 0, ViewUtils.dpToPx(16.0F), 0);
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewHolder.itemView.setOnClickListener(new TeamListHorizontalAdapter.1(this));
      TeamListReport.a(paramViewHolder.itemView);
      return;
    }
    if ((paramViewHolder instanceof TeamListItemHorizontalEndViewHolder))
    {
      paramViewHolder.itemView.setOnClickListener(this.c);
      TeamListReport.c(paramViewHolder.itemView);
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
    if (paramInt == 2) {
      return new TeamListItemHorizontalCreateTeamViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629529, paramViewGroup, false));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListHorizontalAdapter
 * JD-Core Version:    0.7.0.1
 */