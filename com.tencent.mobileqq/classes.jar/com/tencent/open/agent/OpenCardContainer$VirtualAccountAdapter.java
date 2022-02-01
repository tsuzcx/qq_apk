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
  private List<OpenCardContainer.VirtualAccountInfo> jdField_a_of_type_JavaUtilList;
  
  OpenCardContainer$VirtualAccountAdapter(OpenCardContainer paramOpenCardContainer, Context paramContext) {}
  
  private void a(OpenCardContainer.VirtualAccountViewHolder paramVirtualAccountViewHolder, int paramInt, View paramView)
  {
    paramView = (OpenCardContainer.VirtualAccountInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setText(paramView.b);
    if (paramView.jdField_a_of_type_Boolean)
    {
      OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setVisibility(0);
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    }
    for (;;)
    {
      if (paramView.jdField_a_of_type_JavaLangString != null) {
        OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder), paramView.jdField_a_of_type_JavaLangString);
      }
      return;
      OpenCardContainer.VirtualAccountViewHolder.a(paramVirtualAccountViewHolder).setVisibility(4);
    }
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298882);
    int j = paramContext.getResources().getDimensionPixelSize(2131298883);
    paramContext = OpenCardContainer.c;
    int[] arrayOfInt1 = OpenCardContainer.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = OpenCardContainer.b;
    return new OpenCardContainer.VirtualAccountAdapter.2(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((OpenCardContainer.VirtualAccountInfo)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      notifyDataSetChanged();
    }
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      OpenCardContainer.VirtualAccountInfo localVirtualAccountInfo = (OpenCardContainer.VirtualAccountInfo)localIterator.next();
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
    if (this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.a(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);; i = 0)
    {
      int j = paramView.getScrollX();
      if ((paramInt >= 0) && (this.jdField_a_of_type_Int == paramInt)) {
        paramView.scrollTo(i, 0);
      }
      while (j == 0) {
        return;
      }
      paramView.scrollTo(0, 0);
      return;
    }
  }
  
  void a(List<OpenCardContainer.VirtualAccountInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (paramString.equals(this.jdField_a_of_type_JavaLangString)) {
        break label33;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      notifyDataSetChanged();
      return;
      label33:
      if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          OpenCardContainer.VirtualAccountInfo localVirtualAccountInfo = (OpenCardContainer.VirtualAccountInfo)paramString.next();
          if (localVirtualAccountInfo.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a()) {
            localVirtualAccountInfo.jdField_a_of_type_Boolean = true;
          } else {
            localVirtualAccountInfo.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    OpenCardContainer.VirtualAccountViewHolder localVirtualAccountViewHolder;
    if (paramView == null)
    {
      localVirtualAccountViewHolder = new OpenCardContainer.VirtualAccountViewHolder(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer, null);
      paramView = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559801, paramViewGroup, false);
      OpenCardContainer.VirtualAccountViewHolder.a(localVirtualAccountViewHolder, (URLImageView)paramView.findViewById(2131381723));
      OpenCardContainer.VirtualAccountViewHolder.a(localVirtualAccountViewHolder, (TextView)paramView.findViewById(2131381726));
      OpenCardContainer.VirtualAccountViewHolder.a(localVirtualAccountViewHolder, (ImageView)paramView.findViewById(2131377739));
      OpenCardContainer.VirtualAccountViewHolder.a(localVirtualAccountViewHolder, (Button)paramView.findViewById(2131365666));
      paramView.setTag(localVirtualAccountViewHolder);
      paramView.setTag(-3, Integer.valueOf(DisplayUtil.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, 66.0F)));
    }
    for (;;)
    {
      a(localVirtualAccountViewHolder, paramInt, paramView);
      OpenCardContainer.VirtualAccountViewHolder.a(localVirtualAccountViewHolder).setOnClickListener(new OpenCardContainer.VirtualAccountAdapter.1(this, paramInt));
      paramView.setTag(-1, Integer.valueOf(paramInt));
      a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt), localVirtualAccountViewHolder, this);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localVirtualAccountViewHolder = (OpenCardContainer.VirtualAccountViewHolder)paramView.getTag();
    }
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer;
    int i;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      OpenCardContainer.a((OpenCardContainer)localObject, i);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break label67;
      }
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    }
    label137:
    label138:
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label67:
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      label79:
      if (((Iterator)localObject).hasNext())
      {
        if (!((OpenCardContainer.VirtualAccountInfo)((Iterator)localObject).next()).jdField_a_of_type_Boolean) {
          break label137;
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
        i = 1;
      }
      for (;;)
      {
        break label79;
        if (i != 0) {
          break label138;
        }
        this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
        break;
      }
    }
  }
  
  public void onClick(View paramView) {}
  
  public void updateCurShowRightView(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.VirtualAccountAdapter
 * JD-Core Version:    0.7.0.1
 */