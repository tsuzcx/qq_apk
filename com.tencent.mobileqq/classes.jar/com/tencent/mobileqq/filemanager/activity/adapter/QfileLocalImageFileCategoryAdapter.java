package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.List;

public class QfileLocalImageFileCategoryAdapter
  extends GridListView.GridListAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public FileInfo a(int paramInt)
  {
    return (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int b(int paramInt)
  {
    return 1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970009, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = new QfileLocalImageFileCategoryAdapter.LocalImageHolder(this);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131361846));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368739));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131368738));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      FileInfo localFileInfo = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844380);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.b, this.b);
      if ((localFileInfo.c() != null) && (localFileInfo.c().length() > 0)) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(localFileInfo.c());
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) || (!FMDataCache.a(localFileInfo))) {
        break;
      }
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131492968));
      return paramView;
      paramViewGroup = (QfileLocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag();
    }
    paramViewGroup.b.setVisibility(4);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */