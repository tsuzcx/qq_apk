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
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private TroopListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList;
  
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
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131299223);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.getItem(paramInt);
    if (!(localObject1 instanceof TroopListAdapter.TroopListItem)) {
      return;
    }
    Object localObject2 = (TroopListAdapter.TroopListItem)localObject1;
    localObject1 = null;
    switch (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int)
    {
    default: 
      break;
    case 8: 
    case 9: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696313, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.e) });
      break;
    case 6: 
    case 7: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696168, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.b) });
      break;
    case 4: 
    case 5: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696129, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.jdField_a_of_type_Int) });
      break;
    case 2: 
    case 3: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696218, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.c) });
      break;
    case 0: 
    case 1: 
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131696198, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.d) });
    }
    paramInt += 1;
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.getCount())
    {
      localObject2 = (TroopListAdapter.TroopListItem)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.getItem(paramInt);
      if ((localObject2 != null) && ((((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int == 6) || (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int == 4) || (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int == 2) || (((TroopListAdapter.TroopListItem)localObject2).jdField_a_of_type_Int == 8)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          int i = this.jdField_a_of_type_Int;
          if (paramInt < i) {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i);
          } else {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      else
      {
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131560461);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131381293));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379364));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter = new TroopListAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 4, false, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, "", "");
  }
  
  public void d()
  {
    TroopListAdapter localTroopListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter;
    if (localTroopListAdapter != null) {
      localTroopListAdapter.a();
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (TroopListAdapter.TroopViewHolder)paramView.getTag();
    Object localObject1;
    if ((localObject2 != null) && (((TroopListAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      localObject1 = ((TroopListAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putString("group_uin", ((TroopInfo)localObject1).troopuin);
      ((Bundle)localObject3).putString("group_name", ((TroopInfo)localObject1).getTroopDisplayName());
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject3);
      int j = ((TroopListAdapter.TroopViewHolder)localObject2).jdField_a_of_type_Int;
      int i = 3;
      if (j != 1)
      {
        if (j == 3) {
          break label125;
        }
        if (j == 5) {
          break label123;
        }
        if (j == 7) {
          break label118;
        }
        if (j == 9) {}
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
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((TroopInfo)localObject1).troopuin);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(i), "", "");
    }
    else if ((localObject2 != null) && (((TroopListAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null))
    {
      localObject1 = ((TroopListAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
      ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopListAdapter != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListInnerFrame
 * JD-Core Version:    0.7.0.1
 */