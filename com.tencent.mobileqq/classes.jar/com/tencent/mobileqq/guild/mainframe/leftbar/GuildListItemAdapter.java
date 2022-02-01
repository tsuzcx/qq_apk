package com.tencent.mobileqq.guild.mainframe.leftbar;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildListItemAdapter
  extends GuildBaseItemAdapter
  implements DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener
{
  protected ArrayList<GuildListItemBaseBuilder> c = new ArrayList();
  private int d = 0;
  private int[] e = new int[5];
  
  public GuildListItemAdapter(GuildListController paramGuildListController)
  {
    super(paramGuildListController);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (GuildDragTextView)paramView.findViewById(2131449126);
    if (paramView == null) {
      return;
    }
    if (this.a != null) {
      this.a.a().f().a(paramView.getGestureListener());
    }
  }
  
  public static ArrayList<GuildListItemBaseBuilder> b(ArrayList<GuildListItemBaseBuilder> paramArrayList, int paramInt)
  {
    if (paramInt == 0) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      GuildListItemBaseBuilder localGuildListItemBaseBuilder = (GuildListItemBaseBuilder)paramArrayList.next();
      if (localGuildListItemBaseBuilder.d() == 3) {
        QLog.d("GuildListItemAdapter", 4, new Object[] { "filter: item: ", Integer.valueOf(localGuildListItemBaseBuilder.d()), " filtered" });
      } else {
        localArrayList.add(localGuildListItemBaseBuilder);
      }
    }
    return localArrayList;
  }
  
  public void a(ArrayList<GuildListItemBaseBuilder> paramArrayList)
  {
    if (paramArrayList == null)
    {
      this.c = new ArrayList();
      super.a(this.c);
      return;
    }
    this.c = paramArrayList;
    super.a(b(this.c, this.d));
  }
  
  public void a(ArrayList<GuildListItemBaseBuilder> paramArrayList, int paramInt)
  {
    this.d = paramInt;
    a(paramArrayList);
  }
  
  public GuildListItemAdapter.ItemCountInfo d()
  {
    return GuildListItemAdapter.ItemCountInfo.a(this.b);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    a(localView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildListItemAdapter
 * JD-Core Version:    0.7.0.1
 */