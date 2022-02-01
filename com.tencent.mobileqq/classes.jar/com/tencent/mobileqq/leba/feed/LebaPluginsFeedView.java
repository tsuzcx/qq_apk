package com.tencent.mobileqq.leba.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaPluginsFeedView
  extends LinearLayout
  implements View.OnClickListener
{
  public AppRuntime a;
  public List<LebaViewItem> b;
  public List<LebaPluginsFeedViewHolder> c;
  public LayoutInflater d;
  public LebaRedTouchBase e;
  private LebaItemListener f;
  
  public LebaPluginsFeedView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LebaPluginsFeedView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LebaPluginsFeedView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LebaDaTong.a(null, this, "pg_discover_feeds_page");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new LebaPluginsFeedViewHolder(getContext(), this.d, this, paramInt2);
      this.c.add(localObject);
      localObject = ((LebaPluginsFeedViewHolder)localObject).b;
      ((View)localObject).setTag(Integer.valueOf(paramInt1));
      ((View)localObject).setOnClickListener(this);
      LinearLayout localLinearLayout = new LinearLayout(((View)localObject).getContext());
      localLinearLayout.setOrientation(0);
      localLinearLayout.setGravity(17);
      localLinearLayout.addView((View)localObject);
      addView(localLinearLayout, new LinearLayout.LayoutParams(0, -2, 1.0F));
      return;
    }
    catch (Exception localException)
    {
      QLog.i("LebaPluginsFeedView", 1, "addTableItem", localException);
    }
  }
  
  private void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshFeedView mDataList=");
    ((StringBuilder)localObject).append(this.b.size());
    ((StringBuilder)localObject).append(",childCount=");
    ((StringBuilder)localObject).append(getChildCount());
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    QLog.i("LebaPluginsFeedView", 1, (String)localObject);
    if (this.b.size() != getChildCount())
    {
      removeAllViews();
      this.c.clear();
      if (this.b.size() < 4) {
        i = 2;
      }
      int j = 0;
      while (j < this.b.size())
      {
        a(j, i);
        j += 1;
      }
    }
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.b.size())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)this.b.get(i);
      if (i >= this.c.size())
      {
        QLog.e("LebaPluginsFeedView", 1, "bindDataToItem size not equal!");
        return;
      }
      LebaPluginsFeedViewHolder localLebaPluginsFeedViewHolder = (LebaPluginsFeedViewHolder)this.c.get(i);
      LebaPluginsFeedViewHolder.BindDataParam localBindDataParam = new LebaPluginsFeedViewHolder.BindDataParam();
      localBindDataParam.a = localLebaViewItem;
      localBindDataParam.b = this.a;
      localBindDataParam.c = getContext();
      localBindDataParam.d = this.e;
      localLebaPluginsFeedViewHolder.a(localBindDataParam);
      i += 1;
    }
  }
  
  void a()
  {
    if (this.b != null)
    {
      if (this.c == null) {
        return;
      }
      int i = 0;
      while (i < this.b.size())
      {
        if (i >= this.c.size())
        {
          QLog.e("LebaPluginsFeedView", 1, "bindDataToItem size not equal!");
          return;
        }
        LebaDaTong.a(((LebaPluginsFeedViewHolder)this.c.get(i)).b);
        i += 1;
      }
    }
  }
  
  public void a(Context paramContext, AppRuntime paramAppRuntime, LebaRedTouchBase paramLebaRedTouchBase, LebaItemListener paramLebaItemListener)
  {
    this.a = paramAppRuntime;
    this.e = paramLebaRedTouchBase;
    this.f = paramLebaItemListener;
    setGravity(0);
    this.d = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.c = new ArrayList();
  }
  
  void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      LebaPluginsFeedViewHolder localLebaPluginsFeedViewHolder = (LebaPluginsFeedViewHolder)this.c.get(paramInt);
      if (localLebaPluginsFeedViewHolder == null) {
        return;
      }
      LebaDaTong.a(paramView, LebaConstant.a(localLebaPluginsFeedViewHolder.a));
    }
  }
  
  public void b()
  {
    QLog.i("LebaPluginsFeedView", 1, "notifyDataSetChanged");
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty()))
    {
      c();
      d();
      return;
    }
    removeAllViews();
    this.c.clear();
  }
  
  public List<LebaViewItem> getData()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    if (this.b == null)
    {
      QLog.i("LebaPluginsFeedView", 1, "onClick mDataList == null");
    }
    else
    {
      Object localObject = null;
      int i = 0;
      try
      {
        int j = ((Integer)paramView.getTag()).intValue();
        i = j;
        LebaViewItem localLebaViewItem = (LebaViewItem)this.b.get(j);
        localObject = localLebaViewItem;
        i = j;
      }
      catch (Exception localException)
      {
        QLog.i("LebaPluginsFeedView", 1, "onClick", localException);
      }
      if (localObject == null)
      {
        QLog.i("LebaPluginsFeedView", 1, "onClick item == null");
      }
      else
      {
        a(paramView, i);
        if (this.f != null) {
          if (localObject.h == 2) {
            this.f.a(paramView, localObject);
          } else {
            this.f.a(paramView, localObject, i);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setData(List<LebaViewItem> paramList, boolean paramBoolean)
  {
    this.b = paramList;
    b();
    if (paramBoolean) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.feed.LebaPluginsFeedView
 * JD-Core Version:    0.7.0.1
 */