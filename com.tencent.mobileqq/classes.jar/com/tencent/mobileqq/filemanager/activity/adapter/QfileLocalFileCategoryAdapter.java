package com.tencent.mobileqq.filemanager.activity.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class QfileLocalFileCategoryAdapter
  extends QfileBaseExpandableListAdapter
{
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  private BaseFileAssistantActivity a;
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (localFileInfo == null) {
      return null;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = QfileFileAdapterFacade.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, localFileInfo, paramViewGroup, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    }
    paramView = (QfileFileItemHolder)localView.getTag();
    paramView.jdField_a_of_type_JavaLangObject = localFileInfo;
    if (localFileInfo.a())
    {
      paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(2130841569);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
      return localView;
    }
    paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    QfileFileAdapterFacade.a(paramView.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), FileManagerUtil.a(localFileInfo.c()));
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
    {
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
      paramViewGroup = QfileTimeUtils.c(localFileInfo.b());
      paramView.b.setText(FileUtil.a(localFileInfo.a()));
      paramView.d.setText(paramViewGroup);
      return localView;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalFileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */