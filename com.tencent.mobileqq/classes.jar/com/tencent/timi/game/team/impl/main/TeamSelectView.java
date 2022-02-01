package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TeamSelectView
  extends HorizontalScrollView
  implements View.OnClickListener
{
  private int a = 0;
  private LinearLayout b;
  private int c = 12;
  private TeamSelectView.OnSingleSelectedListener d;
  
  public TeamSelectView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TeamSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TeamSelectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setFillViewport(true);
    setOverScrollMode(2);
    setHorizontalScrollBarEnabled(false);
    this.b = new LinearLayout(getContext());
    this.b.setOrientation(0);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  private void a(TextView paramTextView)
  {
    TeamSelectView.Item localItem = (TeamSelectView.Item)paramTextView.getTag();
    if (paramTextView.isSelected())
    {
      if (!localItem.e) {
        setItemUnselected(paramTextView);
      }
    }
    else
    {
      if (localItem.e) {
        c();
      } else {
        b();
      }
      setItemSelected(paramTextView);
    }
    if (d()) {
      e();
    }
  }
  
  private void b()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      TextView localTextView = (TextView)this.b.getChildAt(i);
      if (((TeamSelectView.Item)localTextView.getTag()).e)
      {
        setItemUnselected(localTextView);
        return;
      }
      i += 1;
    }
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      setItemUnselected((TextView)this.b.getChildAt(i));
      i += 1;
    }
  }
  
  private boolean d()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      if (((TextView)this.b.getChildAt(i)).isSelected()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void e()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      TextView localTextView = (TextView)this.b.getChildAt(i);
      if (((TeamSelectView.Item)localTextView.getTag()).e)
      {
        setItemSelected(localTextView);
        return;
      }
      i += 1;
    }
  }
  
  private void setItemSelected(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130853080);
    paramTextView.setTextColor(-679168);
    paramTextView.setTypeface(Typeface.DEFAULT_BOLD);
    paramTextView.setSelected(true);
  }
  
  private void setItemUnselected(TextView paramTextView)
  {
    paramTextView.setBackgroundResource(2130853081);
    paramTextView.setTextColor(-6710887);
    paramTextView.setTypeface(Typeface.DEFAULT);
    paramTextView.setSelected(false);
  }
  
  public void a(List<TeamSelectView.Item> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        TeamSelectView.Item localItem = (TeamSelectView.Item)paramList.get(i);
        TextView localTextView = new TextView(getContext());
        LinearLayout.LayoutParams localLayoutParams;
        if (localItem.a == 0)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams.weight = 1.0F;
        }
        else
        {
          localLayoutParams = new LinearLayout.LayoutParams(localItem.a, -1);
        }
        if (localItem.d) {
          setItemSelected(localTextView);
        } else {
          setItemUnselected(localTextView);
        }
        if (i != 0) {
          localLayoutParams.leftMargin = ((int)UITools.a(getContext(), this.c));
        }
        localTextView.setGravity(17);
        localTextView.setLayoutParams(localLayoutParams);
        localTextView.setTag(localItem);
        localTextView.setOnClickListener(this);
        localTextView.setText(localItem.c);
        localTextView.setTextSize(14.0F);
        this.b.addView(localTextView);
        i += 1;
      }
    }
  }
  
  public TeamSelectView.Item getSelectedItem()
  {
    int i = 0;
    while (i < this.b.getChildCount())
    {
      TextView localTextView = (TextView)this.b.getChildAt(i);
      if (localTextView.isSelected()) {
        return (TeamSelectView.Item)localTextView.getTag();
      }
      i += 1;
    }
    return null;
  }
  
  public List<Integer> getSelectedItemIdList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.b.getChildCount())
    {
      TextView localTextView = (TextView)this.b.getChildAt(i);
      if (localTextView.isSelected()) {
        localArrayList.add(Integer.valueOf(((TeamSelectView.Item)localTextView.getTag()).b));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public List<TeamSelectView.Item> getSelectedItemList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.b.getChildCount())
    {
      TextView localTextView = (TextView)this.b.getChildAt(i);
      if (localTextView.isSelected()) {
        localArrayList.add((TeamSelectView.Item)localTextView.getTag());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView;
    int i = this.a;
    if (i == 0)
    {
      c();
      setItemSelected((TextView)localObject);
      localObject = this.d;
      if (localObject != null) {
        ((TeamSelectView.OnSingleSelectedListener)localObject).a(paramView);
      }
    }
    else if (i == 1)
    {
      a((TextView)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setItemSpacing(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMode(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setOnSingleSelectedListener(TeamSelectView.OnSingleSelectedListener paramOnSingleSelectedListener)
  {
    this.d = paramOnSingleSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamSelectView
 * JD-Core Version:    0.7.0.1
 */