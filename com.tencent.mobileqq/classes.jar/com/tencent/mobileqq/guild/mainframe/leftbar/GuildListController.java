package com.tencent.mobileqq.guild.mainframe.leftbar;

import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper;
import com.tencent.mobileqq.guild.mainframe.helper.GuildLeftItemViewExtHelper;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildMFData;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.mobileqq.guild.util.QQGuildTabStateUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GuildListController
  extends GuildMainViewLifeCycle
{
  public AbsListView.RecyclerListener b = new GuildListController.2(this);
  private XListView c;
  private final GuildListItemAdapter d = new GuildListItemAdapter(this);
  private final GuildLeftBarController.OnLeftBarItemCountUpdateListener e;
  private QQGuildGrayUserTypeConfig f = QQGuildGrayUserTypeConfig.a();
  private final QQGuildObserver g = new GuildListController.3(this);
  private GPServiceObserver h = new GuildListController.4(this);
  
  public GuildListController(GuildMainViewContext paramGuildMainViewContext, GuildLeftBarController.OnLeftBarItemCountUpdateListener paramOnLeftBarItemCountUpdateListener)
  {
    super(paramGuildMainViewContext);
    this.e = paramOnLeftBarItemCountUpdateListener;
  }
  
  private void a(ArrayList<GuildListItemBaseBuilder> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Collections.sort(paramArrayList, GuildListItemBaseBuilder.e);
  }
  
  private void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((GuildLeftItemViewExtHelper)this.a.a(GuildMainFrameConstants.d)).l());
    Object localObject1 = new ArrayList();
    Object localObject2 = ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).getGuildList();
    ((ArrayList)localObject1).addAll(((GuildLeftItemViewExtHelper)this.a.a(GuildMainFrameConstants.d)).k());
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        GuildMFData localGuildMFData = new GuildMFData(((IGProGuildInfo)((Iterator)localObject2).next()).getGuildID());
        ((ArrayList)localObject1).add(new GuildListItemBuilder(this.a, localGuildMFData));
      }
    }
    a((ArrayList)localObject1);
    boolean bool2 = this.f.e();
    boolean bool1 = true;
    localArrayList.addAll((Collection)localObject1);
    this.d.a(localArrayList, bool2 ^ true);
    localArrayList = this.d.b();
    localObject1 = (GuildLeftBarSelHelper)this.a.a(GuildMainFrameConstants.b);
    if (paramInt != 1) {
      bool1 = false;
    }
    ((GuildLeftBarSelHelper)localObject1).a(localArrayList, bool1);
  }
  
  private void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (GuildDragTextView)paramView.findViewById(2131449126);
    if (paramView == null) {
      return;
    }
    a().f().b(paramView.getGestureListener());
  }
  
  public void a(int paramInt)
  {
    boolean bool = QQGuildTabStateUtils.a();
    if (QLog.isColorLevel()) {
      QLog.d("GuildListController", 2, new Object[] { "refreshData from: ", Integer.valueOf(paramInt), " userType = ", QQGuildGrayUserTypeConfig.a(), " tabShow = ", Boolean.valueOf(bool) });
    }
    if (!bool) {
      return;
    }
    this.f = QQGuildGrayUserTypeConfig.a();
    b(paramInt);
    GuildLeftBarController.OnLeftBarItemCountUpdateListener localOnLeftBarItemCountUpdateListener = this.e;
    if (localOnLeftBarItemCountUpdateListener != null) {
      localOnLeftBarItemCountUpdateListener.a(this.d.d());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.d.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.d.a(paramInt, paramString, paramBundle);
  }
  
  public void a(View paramView)
  {
    this.c = ((XListView)paramView.findViewById(2131434771));
    this.c.setAdapter(this.d);
    this.c.setClipToPadding(false);
    this.c.setRecyclerListener(this.b);
    this.d.c();
    paramView = this.c;
    paramView.setPadding(paramView.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), ScreenUtil.dip2px(60.0F));
  }
  
  public void b(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new GuildListController.1(this));
  }
  
  public void e()
  {
    QQGuildUtil.g().removeObserver(this.g);
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).deleteObserver(this.h);
  }
  
  public void f()
  {
    QQGuildUtil.g().addObserver(this.g);
    ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).addObserver(this.h);
    a(1);
  }
  
  public void g() {}
  
  public XListView i()
  {
    return this.c;
  }
  
  public void j()
  {
    this.d.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildListController
 * JD-Core Version:    0.7.0.1
 */