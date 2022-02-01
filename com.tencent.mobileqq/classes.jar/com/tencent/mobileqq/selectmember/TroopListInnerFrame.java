package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  SlideDetectListView a;
  ArrayList<Entity> b;
  TextView c = null;
  Context d;
  int e;
  private TroopListAdapter j;
  
  public TroopListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    this.e = paramContext.getResources().getDimensionPixelSize(2131299976);
  }
  
  private void getTroops()
  {
    this.b = ((ITroopInfoService)this.h.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    if (this.b == null) {
      this.b = new ArrayList();
    }
  }
  
  private void setFloatingView(int paramInt)
  {
    this.c.setVisibility(0);
    if ((paramInt == 0) && (this.a.getChildAt(0) != null) && (this.a.getChildAt(0).getBottom() == this.e))
    {
      this.c.setVisibility(4);
      return;
    }
    Object localObject1 = this.j.getItem(paramInt);
    if (!(localObject1 instanceof TroopListAdapter.TroopListItem)) {
      return;
    }
    Object localObject2 = (TroopListAdapter.TroopListItem)localObject1;
    localObject1 = null;
    switch (((TroopListAdapter.TroopListItem)localObject2).a)
    {
    default: 
      break;
    case 8: 
    case 9: 
      localObject1 = this.d.getString(2131894079, new Object[] { String.valueOf(this.j.f) });
      break;
    case 6: 
    case 7: 
      localObject1 = this.d.getString(2131893934, new Object[] { String.valueOf(this.j.c) });
      break;
    case 4: 
    case 5: 
      localObject1 = this.d.getString(2131893894, new Object[] { String.valueOf(this.j.b) });
      break;
    case 2: 
    case 3: 
      localObject1 = this.d.getString(2131893984, new Object[] { String.valueOf(this.j.d) });
      break;
    case 0: 
    case 1: 
      localObject1 = this.d.getString(2131893964, new Object[] { String.valueOf(this.j.e) });
    }
    paramInt += 1;
    if (paramInt < this.j.getCount())
    {
      localObject2 = (TroopListAdapter.TroopListItem)this.j.getItem(paramInt);
      if ((localObject2 != null) && ((((TroopListAdapter.TroopListItem)localObject2).a == 6) || (((TroopListAdapter.TroopListItem)localObject2).a == 4) || (((TroopListAdapter.TroopListItem)localObject2).a == 2) || (((TroopListAdapter.TroopListItem)localObject2).a == 8)))
      {
        localObject2 = this.a.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
          int i = this.e;
          if (paramInt < i) {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i);
          } else {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          }
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.c.requestLayout();
        }
      }
      else
      {
        localObject2 = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.c.requestLayout();
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.c.setVisibility(0);
      this.c.setText((CharSequence)localObject1);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131626506);
    this.a = ((SlideDetectListView)findViewById(2131450345));
    this.c = ((TextView)findViewById(2131448101));
    this.a.setSelector(2131168376);
    this.j = new TroopListAdapter(this.f, this.h, this.a, 4, false, this);
    this.a.setAdapter(this.j);
    getTroops();
    this.j.a(this.h, this.b);
    this.a.setOnScrollGroupFloatingListener(this);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.setupTitleBar(true, "", "");
  }
  
  public void d()
  {
    TroopListAdapter localTroopListAdapter = this.j;
    if (localTroopListAdapter != null) {
      localTroopListAdapter.a();
    }
    super.d();
  }
  
  public void f()
  {
    this.j.notifyDataSetChanged();
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return null;
  }
  
  public String getGroupUin()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (TroopListAdapter.TroopViewHolder)paramView.getTag();
    Object localObject1;
    if ((localObject2 != null) && (((TroopListAdapter.TroopViewHolder)localObject2).c != null))
    {
      localObject1 = ((TroopListAdapter.TroopViewHolder)localObject2).c;
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putString("group_uin", ((TroopInfo)localObject1).troopuin);
      ((Bundle)localObject3).putString("group_name", ((TroopInfo)localObject1).getTroopDisplayName());
      this.g.a(6, (Bundle)localObject3);
      int k = ((TroopListAdapter.TroopViewHolder)localObject2).e;
      int i = 3;
      if (k != 1)
      {
        if (k == 3) {
          break label125;
        }
        if (k == 5) {
          break label123;
        }
        if (k == 7) {
          break label118;
        }
        if (k == 9) {}
      }
      else
      {
        i = 0;
        break label125;
      }
      i = 4;
      break label125;
      label118:
      i = 2;
      break label125;
      label123:
      i = 1;
      label125:
      localObject2 = this.h;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((TroopInfo)localObject1).troopuin);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(i), "", "");
    }
    else if ((localObject2 != null) && (((TroopListAdapter.TroopViewHolder)localObject2).d != null))
    {
      localObject1 = ((TroopListAdapter.TroopViewHolder)localObject2).d;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
      ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
      this.g.a(7, (Bundle)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.j != null) {
      setFloatingView(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */