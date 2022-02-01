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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.DelDownloadHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.QfileGroupTag;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
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
  
  protected int a()
  {
    return 4;
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = getChild(paramInt1, paramInt2);
    Object localObject1;
    if (paramViewGroup != null) {
      localObject1 = (FileInfo)paramViewGroup;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return null;
    }
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    try
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560795, null);
      paramViewGroup = paramView;
      DelDownloadHolder localDelDownloadHolder = new DelDownloadHolder();
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368480));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramView.findViewById(2131366792));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366795));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131364692));
      paramViewGroup = paramView;
      paramView.setTag(localDelDownloadHolder);
      break label209;
      paramViewGroup = paramView;
      localDelDownloadHolder = (DelDownloadHolder)paramView.getTag();
      label209:
      paramViewGroup = paramView;
      ((FileInfo)localObject1).a((String)getGroup(paramInt1));
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = ((FileInfo)localObject1);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_Int = paramInt2;
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_b_of_type_Int = paramInt1;
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130848074);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      paramViewGroup = paramView;
      if (!((FileInfo)localObject1).b())
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(((FileInfo)localObject1).d());
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
      }
      else
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(null);
      }
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetTextView.setText(FileUtil.a(((FileInfo)localObject1).a()));
      paramViewGroup = paramView;
      paramView.setOnClickListener(this);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(localDelDownloadHolder);
      paramViewGroup = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null)
      {
        paramViewGroup = paramView;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a((FileInfo)localObject1);
        paramViewGroup = paramView;
        if (FileUtils.fileExistsAndNotEmpty((String)localObject2))
        {
          paramViewGroup = paramView;
          localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage((String)localObject2);
        }
      }
      paramViewGroup = paramView;
      Object localObject2 = new StringBuilder();
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692371));
      paramViewGroup = paramView;
      ((StringBuilder)localObject2).append(((FileInfo)localObject1).d());
      paramViewGroup = paramView;
      localObject2 = ((StringBuilder)localObject2).toString();
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup = paramView;
      if (FMDataCache.a((FileInfo)localObject1))
      {
        paramViewGroup = paramView;
        localObject1 = new StringBuilder();
        paramViewGroup = paramView;
        ((StringBuilder)localObject1).append((String)localObject2);
        paramViewGroup = paramView;
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692372));
        paramViewGroup = paramView;
        localObject1 = ((StringBuilder)localObject1).toString();
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840575);
        paramViewGroup = paramView;
        paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167394));
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup = paramView;
        paramView.setOnLongClickListener(null);
      }
      else
      {
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramViewGroup = paramView;
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845862);
        localObject1 = localObject2;
      }
      paramViewGroup = paramView;
      localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject1);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      QLog.e("#######", 1, paramView.toString());
    }
    return paramViewGroup;
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
        return;
      }
      paramView.setEnabled(true);
      localQfileGroupTag.a.setVisibility(0);
    }
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = super.getGroupView(paramInt, paramBoolean, paramView, paramViewGroup);
    if (paramViewGroup != null) {
      paramView = (QfileBaseExpandableListAdapter.QfileGroupTag)paramViewGroup.getTag();
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.g() == 1)
      {
        paramView.a.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
        return paramViewGroup;
      }
      paramViewGroup.setEnabled(true);
      paramView.a.setVisibility(0);
    }
    return paramViewGroup;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    DelDownloadHolder localDelDownloadHolder = (DelDownloadHolder)paramView.getTag();
    if (i == 2131364692)
    {
      if (FMDataCache.a(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo))
      {
        FMDataCache.b(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setSelected(false);
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845862);
        localDelDownloadHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, false);
        }
      }
      else
      {
        FMDataCache.a(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setSelected(true);
        localDelDownloadHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840575);
        localDelDownloadHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.l();
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openFileBrowserByFileInfo(this.jdField_a_of_type_AndroidContentContext, localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(localDelDownloadHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QFileDelDownloadAdapter
 * JD-Core Version:    0.7.0.1
 */