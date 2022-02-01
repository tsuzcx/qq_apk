package com.tencent.mobileqq.teamworkforgroup;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class GroupTeamWorkAdapter
  extends BaseAdapter
  implements BaseMenuCloudFileItemBuilder.OnMenuItemClickListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Handler a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnItemLongClickListener jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener;
  private EmptyViewInfoForTroop jdField_a_of_type_ComTencentMobileqqTeamworkforgroupEmptyViewInfoForTroop = new EmptyViewInfoForTroop();
  private TeamWorkItemBuilder jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkItemBuilder;
  private TroopEmptyViewItemBuilder jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTroopEmptyViewItemBuilder;
  protected List<Object> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected boolean b;
  
  public GroupTeamWorkAdapter(QQAppInterface paramQQAppInterface, Activity paramActivity, OnItemLongClickListener paramOnItemLongClickListener, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new GroupTeamWorkAdapter.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener = paramOnItemLongClickListener;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Long = (MessageCache.a() * 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(int paramInt, ICloudFile paramICloudFile)
  {
    paramICloudFile = (PadInfo)paramICloudFile;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener == null);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener.b(paramICloudFile);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener == null);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkOnItemLongClickListener.a(paramICloudFile);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(CloudFileItemBuilder paramCloudFileItemBuilder)
  {
    if ((paramCloudFileItemBuilder instanceof BaseMenuCloudFileItemBuilder)) {
      ((BaseMenuCloudFileItemBuilder)paramCloudFileItemBuilder).a(this);
    }
  }
  
  public void a(List<? extends Object> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
      notifyDataSetChanged();
    }
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void b(List<? extends Object> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupEmptyViewInfoForTroop);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ICloudFile)this.jdField_a_of_type_JavaUtilList.get(paramInt)).getCloudFileType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ICloudFile localICloudFile = (ICloudFile)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localICloudFile.getCloudFileType() == 10)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTroopEmptyViewItemBuilder;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopEmptyViewItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTroopEmptyViewItemBuilder = ((TroopEmptyViewItemBuilder)localObject1);
      }
    }
    for (;;)
    {
      a((CloudFileItemBuilder)localObject1);
      paramView = ((CloudFileItemBuilder)localObject1).a(paramInt, localICloudFile, paramView, paramViewGroup, this.jdField_a_of_type_Boolean, false, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_Int);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkItemBuilder;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TeamWorkItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupTeamWorkItemBuilder = ((TeamWorkItemBuilder)localObject1);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkAdapter
 * JD-Core Version:    0.7.0.1
 */