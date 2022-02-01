package com.tencent.timi.game.teamlist.presenter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.timi.game.teamlist.model.TeamListFilterModel;
import com.tencent.timi.game.teamlist.view.TeamListFilterItemViewHolder;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;

public class TeamListFilterAdapter
  extends RecyclerView.Adapter
{
  private ArrayList<String> a = new ArrayList();
  private ArrayList<Boolean> b = new ArrayList();
  private TeamListFilterModel c;
  private int d;
  private boolean e = true;
  
  public TeamListFilterAdapter(int paramInt, TeamListFilterModel paramTeamListFilterModel)
  {
    this.c = paramTeamListFilterModel;
    this.d = paramInt;
    this.a.add("不限");
    if (paramInt == 0)
    {
      this.a.addAll(paramTeamListFilterModel.e());
      this.b.addAll(paramTeamListFilterModel.b());
    }
    else if (paramInt == 1)
    {
      this.a.addAll(paramTeamListFilterModel.f());
      this.b.addAll(paramTeamListFilterModel.c());
    }
    else if (paramInt == 2)
    {
      this.a.addAll(paramTeamListFilterModel.g());
      this.b.addAll(paramTeamListFilterModel.d());
    }
    paramTeamListFilterModel = this.a.iterator();
    while (paramTeamListFilterModel.hasNext()) {
      Logger.b("TeamListFilterAdapter", (String)paramTeamListFilterModel.next());
    }
  }
  
  private void c()
  {
    this.e = true;
    int i = 0;
    while (i < this.b.size())
    {
      this.b.set(i, Boolean.valueOf(false));
      i += 1;
    }
    d();
  }
  
  private void d()
  {
    new Handler().post(new TeamListFilterAdapter.2(this));
  }
  
  public void a()
  {
    int i = this.d;
    if (i == 0)
    {
      this.c.b().clear();
      this.c.b().addAll(this.b);
      return;
    }
    if (i == 1)
    {
      this.c.c().clear();
      this.c.c().addAll(this.b);
      return;
    }
    if (i == 2)
    {
      this.c.d().clear();
      this.c.d().addAll(this.b);
    }
  }
  
  public void b()
  {
    c();
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof TeamListFilterItemViewHolder))
    {
      if (paramInt == 0)
      {
        TeamListFilterItemViewHolder localTeamListFilterItemViewHolder = (TeamListFilterItemViewHolder)paramViewHolder;
        localTeamListFilterItemViewHolder.a.setEnabled(this.e ^ true);
        localTeamListFilterItemViewHolder.a.setChecked(this.e);
      }
      else
      {
        ((TeamListFilterItemViewHolder)paramViewHolder).a.setChecked(((Boolean)this.b.get(paramInt - 1)).booleanValue());
      }
      paramViewHolder = (TeamListFilterItemViewHolder)paramViewHolder;
      paramViewHolder.a.setText((CharSequence)this.a.get(paramInt));
      if (paramViewHolder.a.isChecked()) {
        paramViewHolder.a.setTypeface(null, 1);
      } else {
        paramViewHolder.a.setTypeface(null, 0);
      }
      paramViewHolder.a.setClickable(true);
      paramViewHolder.a.setOnClickListener(new TeamListFilterAdapter.1(this, paramInt));
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new TeamListFilterItemViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629527, paramViewGroup, false));
    paramViewGroup.setIsRecyclable(false);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListFilterAdapter
 * JD-Core Version:    0.7.0.1
 */