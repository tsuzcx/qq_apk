package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GroupTeamWorkAdapter
  extends IGroupTeamWorkAdapter
  implements BaseMenuCloudFileItemBuilder.OnMenuItemClickListener
{
  protected Handler a;
  protected List<Object> b = new ArrayList();
  protected int c;
  protected View.OnClickListener d;
  protected View.OnLongClickListener e;
  protected boolean f = false;
  protected boolean g = false;
  public int h = -1;
  protected View.OnClickListener i = new GroupTeamWorkAdapter.1(this);
  private Activity j;
  private long k;
  private OnItemLongClickListener l;
  private EmptyViewInfoForTroop m = new EmptyViewInfoForTroop();
  private AppInterface n;
  private Context o;
  private TroopEmptyViewItemBuilder p;
  private TeamWorkItemBuilder q;
  
  public GroupTeamWorkAdapter(AppInterface paramAppInterface, Activity paramActivity, OnItemLongClickListener paramOnItemLongClickListener, Handler paramHandler)
  {
    this.n = paramAppInterface;
    this.o = paramActivity;
    this.c = 1;
    this.j = paramActivity;
    this.l = paramOnItemLongClickListener;
    this.a = paramHandler;
    this.k = (MessageCache.c() * 1000L);
  }
  
  public void a()
  {
    List localList = this.b;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(int paramInt, ICloudFile paramICloudFile)
  {
    paramICloudFile = (PadInfo)paramICloudFile;
    OnItemLongClickListener localOnItemLongClickListener;
    if (paramInt == 2131430855)
    {
      localOnItemLongClickListener = this.l;
      if (localOnItemLongClickListener != null) {
        localOnItemLongClickListener.b(paramICloudFile);
      }
    }
    if (paramInt == 2131430853)
    {
      localOnItemLongClickListener = this.l;
      if (localOnItemLongClickListener != null) {
        localOnItemLongClickListener.a(paramICloudFile);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
  }
  
  protected void a(CloudFileItemBuilder paramCloudFileItemBuilder)
  {
    if ((paramCloudFileItemBuilder instanceof BaseMenuCloudFileItemBuilder)) {
      ((BaseMenuCloudFileItemBuilder)paramCloudFileItemBuilder).a(this);
    }
  }
  
  public void a(List<? extends Object> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.b.addAll(paramList);
    } else {
      this.b.add(this.m);
    }
    notifyDataSetChanged();
  }
  
  public void b(List<? extends Object> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.addAll(paramList);
      paramList = this.a;
      if (paramList != null) {
        paramList.sendEmptyMessage(4);
      }
      notifyDataSetChanged();
      return;
    }
    a();
    paramList = this.a;
    if (paramList != null) {
      paramList.sendEmptyMessage(3);
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ICloudFile)this.b.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ICloudFile localICloudFile = (ICloudFile)this.b.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localICloudFile.getCloudFileType() == 10)
    {
      localObject2 = this.p;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopEmptyViewItemBuilder(this.n, this.o, this, this.c);
        this.p = ((TroopEmptyViewItemBuilder)localObject1);
      }
    }
    else
    {
      localObject2 = this.q;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TeamWorkItemBuilder(this.n, this.o, this, this.c);
        this.q = ((TeamWorkItemBuilder)localObject1);
      }
    }
    a((CloudFileItemBuilder)localObject1);
    paramView = ((CloudFileItemBuilder)localObject1).a(paramInt, localICloudFile, paramView, paramViewGroup, this.f, false, this.i, this.e, this.g, this.h);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkAdapter
 * JD-Core Version:    0.7.0.1
 */