package com.tencent.mobileqq.filemanager.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.utils.QQUtils;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List jdField_a_of_type_JavaUtilList;
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List paramList, View.OnClickListener paramOnClickListener)
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
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localFileCategoryEntity == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramView == null)
    {
      localObject = new FileCategoryAdapter.ItemHolder(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.jdField_b_of_type_Int, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).c(30).a();
      paramView.setTag(localObject);
      if ((localFileCategoryEntity.jdField_a_of_type_Int == 0) || (localFileCategoryEntity.jdField_a_of_type_Int == 3))
      {
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131365560));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368777));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368779));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365561));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368778));
        ((FileCategoryAdapter.ItemHolder)localObject).c = ((TextView)paramView.findViewById(2131363484));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      label198:
      paramViewGroup.jdField_a_of_type_Int = localFileCategoryEntity.e;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFileCategoryEntity.jdField_c_of_type_JavaLangString;
      if (localFileCategoryEntity.jdField_a_of_type_Int == 0)
      {
        if (localFileCategoryEntity.jdField_c_of_type_Boolean)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label240:
          if (!localFileCategoryEntity.jdField_b_of_type_Boolean) {
            break label550;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.jdField_c_of_type_Int);
          label268:
          if (localFileCategoryEntity.jdField_b_of_type_JavaLangString == null) {
            break label562;
          }
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
          label296:
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
          if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localFileCategoryEntity.d + ")");
          }
          switch (localFileCategoryEntity.f)
          {
          default: 
            paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838629);
          }
        }
        for (;;)
        {
          localObject = paramView;
          if (16 == localFileCategoryEntity.e) {
            break;
          }
          localObject = paramView;
          if (17 == localFileCategoryEntity.e) {
            break;
          }
          if (22 != localFileCategoryEntity.e) {
            break label622;
          }
          paramViewGroup = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(35)).a(String.valueOf("100160.100163"));
          ((RedTouch)paramView).a(paramViewGroup);
          return paramView;
          if ((localFileCategoryEntity.jdField_a_of_type_Int != 1) && (localFileCategoryEntity.jdField_a_of_type_Int != 4)) {
            break label794;
          }
          ((FileCategoryAdapter.ItemHolder)localObject).d = ((TextView)paramView.findViewById(2131365247));
          ((FileCategoryAdapter.ItemHolder)localObject).e = ((TextView)paramView.findViewById(2131365558));
          paramViewGroup = (ViewGroup)localObject;
          break label198;
          paramViewGroup = (FileCategoryAdapter.ItemHolder)paramView.getTag();
          break label198;
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label240;
          label550:
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label268;
          label562:
          paramViewGroup.c.setVisibility(8);
          break label296;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838629);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838641);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838636);
          continue;
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838639);
        }
        label622:
        ((RedTouch)paramView).b();
        return paramView;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Int == 1)
      {
        if (localFileCategoryEntity.jdField_a_of_type_Boolean)
        {
          paramViewGroup.e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
          return paramView;
        }
        paramViewGroup.e.setVisibility(4);
        return paramView;
      }
      localObject = paramView;
      if (localFileCategoryEntity.jdField_a_of_type_Int != 4) {
        break;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setGravity(17);
        localObject = paramView;
        if (QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428093) })) {
          break;
        }
        localObject = FileManagerUtil.a(localFileCategoryEntity.jdField_a_of_type_JavaLangString, localFileCategoryEntity.jdField_a_of_type_JavaLangString, null);
        paramViewGroup.e.setClickable(true);
        paramViewGroup.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.e.setText((CharSequence)localObject);
        paramViewGroup.e.setTag(paramViewGroup);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label794:
      paramViewGroup = (ViewGroup)localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */