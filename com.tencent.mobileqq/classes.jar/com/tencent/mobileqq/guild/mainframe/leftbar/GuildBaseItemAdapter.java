package com.tencent.mobileqq.guild.mainframe.leftbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildBaseListItemLayout;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class GuildBaseItemAdapter
  extends BaseAdapter
  implements DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener
{
  protected GuildListController a;
  protected ArrayList<GuildListItemBaseBuilder> b = new ArrayList();
  
  public GuildBaseItemAdapter(GuildListController paramGuildListController)
  {
    this.a = paramGuildListController;
  }
  
  private void a(String paramString)
  {
    if (!paramString.equals(FrameControllerUtil.s)) {
      return;
    }
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      paramString = a(i);
      if (paramString != null) {
        paramString.c();
      }
      i += 1;
    }
  }
  
  public GuildListItemBaseBuilder a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (GuildListItemBaseBuilder)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    XListView localXListView = this.a.i();
    int j = localXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = localXListView.getChildAt(i);
      if ((localObject instanceof GuildBaseListItemLayout)) {
        localObject = ((GuildBaseListItemLayout)localObject).getHolder();
      } else {
        localObject = (GuildBaseItemViewHolder)((View)localObject).getTag();
      }
      if ((localObject != null) && (((GuildBaseItemViewHolder)localObject).i != null)) {
        ((GuildBaseItemViewHolder)localObject).h.a((GuildBaseItemViewHolder)localObject);
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = new GuildBaseLeftItemData(paramInt, paramString);
    int j = getCount();
    int i = 0;
    paramInt = 0;
    Object localObject;
    while (paramInt < j)
    {
      localObject = a(paramInt);
      if ((localObject != null) && (paramString.equals(((GuildListItemBaseBuilder)localObject).d)))
      {
        ((GuildListItemBaseBuilder)localObject).b();
        paramString = ((GuildListItemBaseBuilder)localObject).d;
        paramInt = 1;
        break label75;
      }
      paramInt += 1;
    }
    paramInt = 0;
    label75:
    if (paramInt == 0) {
      return;
    }
    XListView localXListView = this.a.i();
    j = localXListView.getChildCount();
    paramInt = i;
    while (paramInt < j)
    {
      View localView = localXListView.getChildAt(paramInt);
      if ((localView instanceof GuildBaseListItemLayout)) {
        localObject = ((GuildBaseListItemLayout)localView).getHolder();
      } else {
        localObject = (GuildBaseItemViewHolder)localView.getTag();
      }
      if ((localObject != null) && (paramString.equals(((GuildBaseItemViewHolder)localObject).h.d)))
      {
        ((GuildBaseItemViewHolder)localObject).h.d = paramString;
        ((GuildBaseItemViewHolder)localObject).h.b(localView);
        return;
      }
      paramInt += 1;
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    GuildBaseLeftItemData localGuildBaseLeftItemData = new GuildBaseLeftItemData(paramInt, paramString);
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      GuildListItemBaseBuilder localGuildListItemBaseBuilder = a(i);
      if ((localGuildListItemBaseBuilder != null) && (localGuildBaseLeftItemData.equals(localGuildListItemBaseBuilder.d)))
      {
        localGuildListItemBaseBuilder.a(null, paramBundle);
        a(paramInt, paramString);
        break label81;
      }
      i += 1;
    }
    i = -1;
    label81:
    if (i != -1)
    {
      paramString = this.a.i();
      paramInt = paramString.getFirstVisiblePosition();
      j = paramString.getLastVisiblePosition();
      if ((i <= paramInt) || (i >= j)) {
        this.a.i().postDelayed(new GuildBaseItemAdapter.1(this, i), 200L);
      }
    }
  }
  
  public void a(ArrayList<GuildListItemBaseBuilder> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.b = paramArrayList;
      notifyDataSetChanged();
    }
  }
  
  public ArrayList<GuildListItemBaseBuilder> b()
  {
    return this.b;
  }
  
  public void c()
  {
    DragFrameLayout localDragFrameLayout = this.a.a().h();
    if (localDragFrameLayout != null)
    {
      localDragFrameLayout.a(this);
      localDragFrameLayout.a(this, true);
    }
    localDragFrameLayout = (DragFrameLayout)this.a.a().b().findViewById(2131431325);
    if (localDragFrameLayout != null)
    {
      localDragFrameLayout.a(FrameControllerUtil.s, this);
      localDragFrameLayout.a(FrameControllerUtil.s, this, true);
      localDragFrameLayout.setDragViewProviderByGroup(FrameControllerUtil.s, this);
    }
  }
  
  public List<View> g()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.a.i().getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.a.i().getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131449126);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.getDragViewType() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    GuildListItemBaseBuilder localGuildListItemBaseBuilder = a(paramInt);
    if (localGuildListItemBaseBuilder != null) {
      return localGuildListItemBaseBuilder.d();
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    if (localObject != null) {
      localObject = ((GuildListItemBaseBuilder)localObject).a(paramView, paramViewGroup);
    } else {
      localObject = null;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramDragFrameLayout != null)
    {
      if (paramDragFrameLayout.getDragView() == null) {
        return;
      }
      paramDragFrameLayout = paramDragFrameLayout.getDragView().getTag();
      if ((paramDragFrameLayout instanceof GuildListItemBaseBuilder))
      {
        ((GuildListItemBaseBuilder)paramDragFrameLayout).c();
        return;
      }
      if ((paramDragFrameLayout instanceof String)) {
        a((String)paramDragFrameLayout);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemAdapter
 * JD-Core Version:    0.7.0.1
 */