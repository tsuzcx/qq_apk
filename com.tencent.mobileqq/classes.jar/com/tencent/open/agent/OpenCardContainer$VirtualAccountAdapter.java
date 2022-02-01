package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.util.Iterator;
import java.util.List;

class OpenCardContainer$VirtualAccountAdapter
  extends BaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  int jdField_a_of_type_Int = -1;
  SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
  String jdField_a_of_type_JavaLangString;
  private List<VirtualAccountInfo> jdField_a_of_type_JavaUtilList;
  
  OpenCardContainer$VirtualAccountAdapter(OpenCardContainer paramOpenCardContainer, Context paramContext) {}
  
  private void a(OpenCardContainer.VirtualAccountViewHolder paramVirtualAccountViewHolder, int paramInt, View paramView)
  {
    paramView = (VirtualAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setText(paramView.b);
    if (paramView.jdField_a_of_type_Boolean)
    {
      OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    }
    else
    {
      OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setVisibility(4);
    }
    if (paramView.jdField_a_of_type_JavaLangString != null) {
      OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder), paramView.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    paramContext = OpenCardContainer.a();
    int[] arrayOfInt1 = OpenCardContainer.b();
    int[] arrayOfInt2 = OpenCardContainer.c();
    return new OpenCardContainer.VirtualAccountAdapter.2(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VirtualAccountInfo)((Iterator)localObject).next()).jdField_a_of_type_Boolean = false;
      }
      notifyDataSetChanged();
    }
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VirtualAccountInfo localVirtualAccountInfo = (VirtualAccountInfo)localIterator.next();
      if (localVirtualAccountInfo.jdField_a_of_type_Long == paramLong) {
        localVirtualAccountInfo.jdField_a_of_type_Boolean = true;
      } else {
        localVirtualAccountInfo.jdField_a_of_type_Boolean = false;
      }
    }
    notifyDataSetChanged();
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = paramView.getScrollX();
    if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  void a(List<VirtualAccountInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Object localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      if (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
      }
      else if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          localObject = (VirtualAccountInfo)paramString.next();
          if (((VirtualAccountInfo)localObject).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a()) {
            ((VirtualAccountInfo)localObject).jdField_a_of_type_Boolean = true;
          } else {
            ((VirtualAccountInfo)localObject).jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new OpenCardContainer.VirtualAccountViewHolder(null);
      localView = OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer).inflate(2131559678, paramViewGroup, false);
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (URLImageView)localView.findViewById(2131380955));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (TextView)localView.findViewById(2131380958));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (ImageView)localView.findViewById(2131377166));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (Button)localView.findViewById(2131365509));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(DisplayUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, 66.0F)));
    }
    else
    {
      OpenCardContainer.VirtualAccountViewHolder localVirtualAccountViewHolder = (OpenCardContainer.VirtualAccountViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localVirtualAccountViewHolder;
    }
    a(paramView, paramInt, localView);
    OpenCardContainer.VirtualAccountViewHolder.a(paramView).setOnClickListener(new OpenCardContainer.VirtualAccountAdapter.1(this, paramInt));
    localView.setTag(-1, Integer.valueOf(paramInt));
    a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), paramView, this);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    OpenCardContainer.a((OpenCardContainer)localObject, i);
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      while (((Iterator)localObject).hasNext()) {
        if (((VirtualAccountInfo)((Iterator)localObject).next()).jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
          i = 1;
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    }
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.VirtualAccountAdapter
 * JD-Core Version:    0.7.0.1
 */