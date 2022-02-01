package com.tencent.mobileqq.filemanager.data;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List<FileCategoryEntity> jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<FileCategoryEntity> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new FileCategoryAdapter.ItemHolder(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(((FileCategoryEntity)localObject2).jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).d(30).a();
      paramView.setTag(localObject1);
      if ((((FileCategoryEntity)localObject2).jdField_a_of_type_Int == 0) || (((FileCategoryEntity)localObject2).jdField_a_of_type_Int == 3))
      {
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364471);
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364470));
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376825));
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364472));
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372460));
        ((FileCategoryAdapter.ItemHolder)localObject1).c = ((TextView)paramView.findViewById(2131378427));
      }
    }
    label206:
    label864:
    for (;;)
    {
      ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_Int = ((FileCategoryEntity)localObject2).e;
      ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_JavaLangString = ((FileCategoryEntity)localObject2).jdField_c_of_type_JavaLangString;
      if (((FileCategoryEntity)localObject2).jdField_a_of_type_Int == 0) {
        if (((FileCategoryEntity)localObject2).jdField_c_of_type_Boolean)
        {
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label251:
          if (!((FileCategoryEntity)localObject2).jdField_b_of_type_Boolean) {
            break label516;
          }
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(((FileCategoryEntity)localObject2).jdField_c_of_type_Int);
          if (TextUtils.isEmpty(((FileCategoryEntity)localObject2).jdField_b_of_type_JavaLangString)) {
            break label529;
          }
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setText(((FileCategoryEntity)localObject2).jdField_b_of_type_JavaLangString);
          ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(0);
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(((FileCategoryEntity)localObject2).jdField_a_of_type_JavaLangString);
          ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setTag(localObject1);
          if (((FileCategoryEntity)localObject2).jdField_a_of_type_Boolean) {
            ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText("(" + ((FileCategoryEntity)localObject2).d + ")");
          }
          switch (((FileCategoryEntity)localObject2).f)
          {
          default: 
            ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839575);
            if (16 != ((FileCategoryEntity)localObject2).e) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((FileCategoryEntity)localObject2).jdField_a_of_type_Int != 1) && (((FileCategoryEntity)localObject2).jdField_a_of_type_Int != 4)) {
          break label864;
        }
        ((FileCategoryAdapter.ItemHolder)localObject1).d = ((TextView)paramView.findViewById(2131365917));
        ((FileCategoryAdapter.ItemHolder)localObject1).e = ((TextView)paramView.findViewById(2131379105));
        break label206;
        localObject1 = (FileCategoryAdapter.ItemHolder)paramView.getTag();
        break label206;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label251;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label281;
        ((FileCategoryAdapter.ItemHolder)localObject1).c.setVisibility(8);
        break label314;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839575);
        break label426;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839591);
        break label426;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839582);
        break label426;
        ((FileCategoryAdapter.ItemHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839585);
        break label426;
        if (17 != ((FileCategoryEntity)localObject2).e) {
          if (22 == ((FileCategoryEntity)localObject2).e)
          {
            localObject2 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(String.valueOf("100160.100163"));
            ((RedTouch)paramView).a((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).c()) {
              ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            } else {
              ((FileCategoryAdapter.ItemHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).d();
            continue;
            if (((FileCategoryEntity)localObject2).jdField_a_of_type_Int == 1)
            {
              if (((FileCategoryEntity)localObject2).jdField_a_of_type_Boolean) {
                ((FileCategoryAdapter.ItemHolder)localObject1).e.setText(((FileCategoryEntity)localObject2).jdField_a_of_type_JavaLangString);
              } else {
                ((FileCategoryAdapter.ItemHolder)localObject1).e.setVisibility(4);
              }
            }
            else if (((FileCategoryEntity)localObject2).jdField_a_of_type_Int == 4) {
              if (((FileCategoryEntity)localObject2).jdField_a_of_type_Boolean)
              {
                ((FileCategoryAdapter.ItemHolder)localObject1).e.setGravity(17);
                if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692365) }))
                {
                  localObject2 = FileManagerUtil.a(((FileCategoryEntity)localObject2).jdField_a_of_type_JavaLangString, ((FileCategoryEntity)localObject2).jdField_a_of_type_JavaLangString, null);
                  ((FileCategoryAdapter.ItemHolder)localObject1).e.setClickable(true);
                  ((FileCategoryAdapter.ItemHolder)localObject1).e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
                  ((FileCategoryAdapter.ItemHolder)localObject1).e.setText((CharSequence)localObject2);
                  ((FileCategoryAdapter.ItemHolder)localObject1).e.setTag(localObject1);
                }
              }
              else
              {
                ((FileCategoryAdapter.ItemHolder)localObject1).e.setVisibility(4);
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */