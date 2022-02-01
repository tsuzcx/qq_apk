package com.tencent.timi.game.team.impl.chat;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

public class TeamAtListView
  extends BaseSlideUpDialog
{
  private TextView a;
  private TextView b;
  private TextView c;
  private RecyclerView d;
  private RelativeLayout i;
  private TeamAtListView.TeamAtListViewModel j = new TeamAtListView.TeamAtListViewModel(this, null);
  private TeamAtListView.TeamAtListViewPresenter k = new TeamAtListView.TeamAtListViewPresenter(this, null);
  private TeamAtListView.MemberAdapter l = new TeamAtListView.MemberAdapter(this, null);
  private TeamAtListView.AtStateChangeListener m;
  
  private TeamAtListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static TeamAtListView a(TeamAtListView.AtStateChangeListener paramAtStateChangeListener)
  {
    Logger.a("TeamAtListView", "showAtList");
    Object localObject = TimiGameActivityManager.a();
    if (localObject == null) {
      return null;
    }
    localObject = new TeamAtListView((Context)localObject);
    ((TeamAtListView)localObject).show();
    ((TeamAtListView)localObject).a(((IRoomService)ServiceCenter.a(IRoomService.class)).a(1).room_id.get(), paramAtStateChangeListener);
    return localObject;
  }
  
  public static boolean a()
  {
    long l1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1).room_id.get();
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(l1).h();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)localObject);
    l1 = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((Iterator)localObject).next();
      if ((localYoloRoomSpeakingPosInfo.uid.get() == 0L) || (localYoloRoomSpeakingPosInfo.uid.get() == l1)) {
        ((Iterator)localObject).remove();
      }
    }
    return localArrayList.size() != 0;
  }
  
  private void b()
  {
    this.a = ((TextView)findViewById(2131430836));
    this.a.setOnClickListener(new TeamAtListView.1(this));
    this.b = ((TextView)findViewById(2131447585));
    this.c = ((TextView)findViewById(2131431238));
    this.c.setOnClickListener(new TeamAtListView.2(this));
    this.d = ((RecyclerView)findViewById(2131428825));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getContext());
    localLinearLayoutManager.setOrientation(1);
    this.d.setLayoutManager(localLinearLayoutManager);
    this.d.setAdapter(this.l);
    this.i = ((RelativeLayout)findViewById(2131431280));
    b(this.i);
    s();
    a(new TeamAtListView.3(this));
  }
  
  public void a(long paramLong, TeamAtListView.AtStateChangeListener paramAtStateChangeListener)
  {
    Logger.a("TeamAtListView", "bindAtList");
    this.m = paramAtStateChangeListener;
    this.k.a(paramLong);
    if (TeamAtListView.TeamAtListViewModel.a(this.j).size() == 1)
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131629489);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView
 * JD-Core Version:    0.7.0.1
 */