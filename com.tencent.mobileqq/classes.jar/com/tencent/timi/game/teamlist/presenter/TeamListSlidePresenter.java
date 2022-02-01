package com.tencent.timi.game.teamlist.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.timi.game.teamlist.model.TeamListCache;
import com.tencent.timi.game.teamlist.model.TeamListFilterModel;
import com.tencent.timi.game.teamlist.model.TeamListSlideModel;
import com.tencent.timi.game.teamlist.model.TeamListSlideModel.INotifyData;
import com.tencent.timi.game.teamlist.view.TeamListFilterView;
import com.tencent.timi.game.teamlist.view.TeamListSlideView;
import com.tencent.timi.game.utils.Logger;
import java.util.List;

public class TeamListSlidePresenter
  implements TeamListSlideModel.INotifyData
{
  private TeamListSlideModel a;
  private TeamListFilterModel b;
  private String c = "";
  private int d = -1;
  private TeamListVerticalAdapter e = new TeamListVerticalAdapter();
  private TeamListSlideView f;
  private TeamListFilterView g;
  
  public TeamListSlidePresenter(TeamListFilterModel paramTeamListFilterModel)
  {
    this.b = paramTeamListFilterModel;
    this.a = new TeamListSlideModel(paramTeamListFilterModel);
  }
  
  private void b(String paramString)
  {
    this.a.a(paramString, this);
  }
  
  private void d()
  {
    Logger.b("TeamListSlidePresenter", "loadCacheData");
    this.a.a(TeamListCache.a, this);
  }
  
  public void a()
  {
    this.e.a(this.a.b);
    this.f.a(this.a.a, this.a.b.size());
    this.f.b();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.e.a(paramInt);
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.setAdapter(this.e);
    this.e.a(new TeamListSlidePresenter.1(this));
  }
  
  public void a(TeamListFilterView paramTeamListFilterView)
  {
    this.g = paramTeamListFilterView;
    paramTeamListFilterView.setData(this.b);
  }
  
  public void a(TeamListSlideView paramTeamListSlideView)
  {
    Logger.b("TeamListSlidePresenter", "bindTeamListSlideView");
    this.f = paramTeamListSlideView;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    this.e.a(paramString);
  }
  
  public void b()
  {
    this.g.a(true);
    d();
    c();
  }
  
  public void c()
  {
    Logger.b("TeamListSlidePresenter", "refresh");
    this.a.a();
    b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListSlidePresenter
 * JD-Core Version:    0.7.0.1
 */