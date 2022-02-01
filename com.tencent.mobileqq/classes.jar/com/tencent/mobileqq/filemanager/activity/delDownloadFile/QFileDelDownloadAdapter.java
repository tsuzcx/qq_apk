package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.QfileGroupTag;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;

public class QFileDelDownloadAdapter
  extends QfileLocalImageExpandableListAdapter
  implements View.OnClickListener
{
  int jdField_b_of_type_Int = -1;
  LinkedHashMap<String, List<FileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = null;
  
  public QFileDelDownloadAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, int paramInt)
  {
    super(paramBaseFileAssistantActivity, paramObject, null, null, null, null, null);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    if (paramViewGroup != null) {}
    for (Object localObject = (FileInfo)paramViewGroup;; localObject = null)
    {
      if (localObject == null) {
        return null;
      }
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560921, null);
          paramView = paramViewGroup;
          try
          {
            localHolder = new QFileDelDownloadAdapter.Holder(this);
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368729));
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368748));
            paramView = paramViewGroup;
            localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368745));
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramViewGroup.findViewById(2131366930));
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131366933));
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131364804));
            paramView = paramViewGroup;
            paramViewGroup.setTag(localHolder);
            paramView = paramViewGroup;
            ((FileInfo)localObject).a((String)getGroup(paramInt1));
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject);
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_Int = paramInt2;
            paramView = paramViewGroup;
            localHolder.jdField_b_of_type_Int = paramInt1;
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130848203);
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            paramView = paramViewGroup;
            if (!((FileInfo)localObject).a())
            {
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject).d());
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileUtil.a(((FileInfo)localObject).a()));
              paramView = paramViewGroup;
              paramViewGroup.setOnClickListener(this);
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localHolder);
              paramView = paramViewGroup;
              if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null)
              {
                paramView = paramViewGroup;
                str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a((FileInfo)localObject);
                paramView = paramViewGroup;
                if (FileUtil.b(str))
                {
                  paramView = paramViewGroup;
                  localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(str);
                }
              }
              paramView = paramViewGroup;
              str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692436) + ((FileInfo)localObject).d();
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              if (!FMDataCache.a((FileInfo)localObject)) {
                continue;
              }
              paramView = paramViewGroup;
              localObject = str + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692437);
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840700);
              paramView = paramViewGroup;
              paramViewGroup.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167374));
              paramView = paramViewGroup;
              localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              paramView = paramViewGroup;
              paramViewGroup.setOnLongClickListener(null);
              paramView = paramViewGroup;
              localHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject);
              return paramViewGroup;
              localHolder = (QFileDelDownloadAdapter.Holder)paramView.getTag();
              paramViewGroup = paramView;
              continue;
            }
            paramView = paramViewGroup;
            localHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
            continue;
            paramViewGroup.printStackTrace();
          }
          catch (Exception paramViewGroup) {}
        }
        catch (Exception paramViewGroup)
        {
          QFileDelDownloadAdapter.Holder localHolder;
          String str;
          continue;
        }
        QLog.e("#######", 1, paramViewGroup.toString());
        return paramView;
        paramView = paramViewGroup;
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView = paramViewGroup;
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845987);
        localObject = str;
      }
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    super.configHeaderView(paramView, paramInt);
    QfileBaseExpandableListAdapter.QfileGroupTag localQfileGroupTag = (QfileBaseExpandableListAdapter.QfileGroupTag)paramView.getTag();
    if (localQfileGroupTag != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        localQfileGroupTag.a.setVisibility(8);
        paramView.setEnabled(false);
      }
    }
    else {
      return;
    }
    paramView.setEnabled(true);
    localQfileGroupTag.a.setVisibility(0);
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    paramView = null;
    if (paramViewGroup != null) {
      paramView = (QfileBaseExpandableListAdapter.QfileGroupTag)paramViewGroup.getTag();
    }
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        paramView.a.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
      }
    }
    else {
      return paramViewGroup;
    }
    paramViewGroup.setEnabled(true);
    paramView.a.setVisibility(0);
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject = (QFileDelDownloadAdapter.Holder)paramView.getTag();
    switch (i)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
        break;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (FMDataCache.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        FMDataCache.b(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845987);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
        break;
        FMDataCache.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840700);
        ((QFileDelDownloadAdapter.Holder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      localFileManagerEntity.nFileType = this.jdField_b_of_type_Int;
      localFileManagerEntity.setFilePath(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(((QFileDelDownloadAdapter.Holder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo));
      localObject = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app, this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, 10000);
      localObject = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject);
      ((FileBrowserCreator)localObject).a(8);
      ((FileBrowserCreator)localObject).a(AnimationUtils.a(paramView));
      ((FileBrowserCreator)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */