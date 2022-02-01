package com.tencent.timi.game.teamlist.presenter;

import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.app.event.AppBecomeBackgroundEvent;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import com.tencent.timi.game.teamlist.model.TeamListModel;
import com.tencent.timi.game.teamlist.model.TeamListModel.INotifyData;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener;
import com.tencent.timi.game.teamlist.util.TeamListUtil;
import com.tencent.timi.game.teamlist.view.TeamListView;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public class TeamListPresenter
  implements SimpleEventReceiver, TeamListModel.INotifyData, TeamInfoAutoUpdateService.AutoUpdateServiceListener
{
  private TeamListModel a = new TeamListModel();
  private TeamListHorizontalAdapter b = new TeamListHorizontalAdapter();
  private TeamListPresenter.TimerHelper c = new TeamListPresenter.TimerHelper(this);
  private TeamListView d;
  private boolean e = true;
  private boolean f = false;
  private String g = "";
  
  public List<Long> a()
  {
    localArrayList = new ArrayList();
    try
    {
      int k = this.d.getVisibleTeamListPosStart();
      int m = this.d.getVisibleTeamListPosEnd();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onGetTeamIds start");
      localStringBuilder1.append(k);
      Logger.a("TeamListPresenter", localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onGetTeamIds end");
      localStringBuilder1.append(m);
      Logger.a("TeamListPresenter", localStringBuilder1.toString());
      if ((k != -1) && (m != -1) && (this.a.c.size() != 0))
      {
        int j = k;
        int i = m;
        if (m != 0)
        {
          j = k;
          i = m;
          if (m >= this.a.c.size())
          {
            i = this.a.c.size() - 1;
            j = k;
          }
        }
        while (j < i + 1)
        {
          localArrayList.add(Long.valueOf(((PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)this.a.c.get(j)).id.get()));
          j += 1;
        }
      }
      StringBuilder localStringBuilder2;
      return localArrayList;
    }
    catch (Exception localException)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("onGetTeamIds err");
      localStringBuilder2.append(localException);
      Logger.c("TeamListPresenter", localStringBuilder2.toString());
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.b.a(paramOnClickListener);
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.setAdapter(this.b);
  }
  
  public void a(TeamListView paramTeamListView)
  {
    this.d = paramTeamListView;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Set originID:");
    localStringBuilder.append(paramString);
    Logger.a("TeamListPresenter", localStringBuilder.toString());
    this.g = paramString;
  }
  
  public void a(String paramString, List<MessageOuterClass.ShareYoloRoomMsg> paramList, List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList1, List<Long> paramList2)
  {
    this.a.a(paramList1, this);
  }
  
  public List<Long> b()
  {
    return new ArrayList();
  }
  
  public void c() {}
  
  public void d()
  {
    this.d.a(this.a.a, this.a.c.size());
    this.b.a(this.a.c, this.a.a, this.a.d);
    com.tencent.timi.game.teamlist.model.TeamListCache.a = this.a.c;
    this.c.a(this.a.b * 1000);
  }
  
  public void e()
  {
    this.a.a(this.g, this);
  }
  
  public void f()
  {
    Logger.a("TeamListPresenter", "openTeamCreatePage");
    TeamListUtil.a();
  }
  
  public void g()
  {
    Logger.a("TeamListPresenter", "startAutoUpdate");
    if (this.f)
    {
      Logger.a("TeamListPresenter", "AutoUpdate already start");
      return;
    }
    this.f = true;
    this.c.a();
    TeamInfoAutoUpdateService.a().a("frontpage", this);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AppBecomeForegroundEvent.class);
    localArrayList.add(AppBecomeBackgroundEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    Logger.a("TeamListPresenter", "stopAutoUpdate");
    this.f = false;
    this.c.b();
    com.tencent.timi.game.teamlist.model.TeamListCache.a = null;
    TeamInfoAutoUpdateService.a().a("frontpage");
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AppBecomeForegroundEvent))
    {
      Logger.a("TeamListPresenter", "AppBecomeForegroundEvent called");
      this.e = true;
      this.c.a();
      return;
    }
    if ((paramSimpleBaseEvent instanceof AppBecomeBackgroundEvent))
    {
      Logger.a("TeamListPresenter", "AppBecomeBackgroundEvent called");
      this.e = false;
      this.c.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListPresenter
 * JD-Core Version:    0.7.0.1
 */