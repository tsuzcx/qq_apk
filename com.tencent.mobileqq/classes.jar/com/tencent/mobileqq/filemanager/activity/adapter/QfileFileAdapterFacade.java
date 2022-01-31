package com.tencent.mobileqq.filemanager.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;

public class QfileFileAdapterFacade
{
  public static View a(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    QfileFileItemHolder localQfileFileItemHolder = new QfileFileItemHolder();
    paramContext = LayoutInflater.from(paramContext).inflate(2130970031, paramViewGroup, false);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramContext.findViewById(2131368801));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localQfileFileItemHolder);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramContext.findViewById(2131368770));
    localQfileFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramContext.findViewById(2131368772));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368802));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131368732));
    localQfileFileItemHolder.b = ((TextView)paramContext.findViewById(2131368804));
    localQfileFileItemHolder.c = ((TextView)paramContext.findViewById(2131368776));
    localQfileFileItemHolder.d = ((TextView)paramContext.findViewById(2131363205));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131363010));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramContext.findViewById(2131368774));
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    localQfileFileItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localQfileFileItemHolder);
    paramContext.setTag(localQfileFileItemHolder);
    return paramContext;
  }
  
  public static View a(Context paramContext, FileInfo paramFileInfo, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    if (!paramFileInfo.a()) {
      return a(paramContext, paramViewGroup, paramOnClickListener, paramOnLongClickListener);
    }
    paramContext = new QfileFileItemHolder();
    paramFileInfo = localLayoutInflater.inflate(2130970028, paramViewGroup, false);
    paramFileInfo.setOnClickListener(paramOnClickListener);
    paramContext.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131368794));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131365691));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131368795));
    paramFileInfo.setTag(paramContext);
    return paramFileInfo;
  }
  
  public static void a(AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    if (paramInt == 5)
    {
      FileManagerUtil.a(paramAsyncImageView, paramString, 5);
      return;
    }
    FileManagerUtil.a(paramAsyncImageView, paramString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.adapter.QfileFileAdapterFacade
 * JD-Core Version:    0.7.0.1
 */