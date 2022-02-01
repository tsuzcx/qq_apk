package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LocalFileAdapter
  extends BaseFileAdapter
{
  private final int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = null;
  private List<FileInfo> jdField_a_of_type_JavaUtilList;
  private final int b = 1;
  
  public LocalFileAdapter(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext, paramLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = new LocalFileAdapter.LocalFileItemHolder(this);
    if (!paramFileInfo.c())
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560904, paramViewGroup, false);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131366932));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366919));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131377060));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131366930));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localLocalFileItemHolder.b = ((TextView)paramFileInfo.findViewById(2131366933));
      localLocalFileItemHolder.c = ((TextView)paramFileInfo.findViewById(2131366917));
      localLocalFileItemHolder.d = ((TextView)paramFileInfo.findViewById(2131370043));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramFileInfo.findViewById(2131361943));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
    }
    for (;;)
    {
      paramFileInfo.setTag(localLocalFileItemHolder);
      return paramFileInfo;
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560912, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366945));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131377070));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramFileInfo.findViewById(2131366949));
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
    if (((FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).c()) {
      return -1;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localFileInfo == null) {}
    View localView;
    for (Object localObject = null;; localView = paramView)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (paramView == null) {}
      for (;;)
      {
        try
        {
          localObject = a(localFileInfo, paramViewGroup);
          paramView = (View)localObject;
        }
        catch (Exception localException2)
        {
          continue;
        }
        try
        {
          localObject = (LocalFileAdapter.LocalFileItemHolder)paramView.getTag();
          ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
          if (localFileInfo.c())
          {
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844434);
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_Int = paramInt;
          }
          else
          {
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            FileManagerUtil.a(((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), FileManagerUtil.a(localFileInfo.c()));
            ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f())
            {
              ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
              ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
              String str1 = QfileTimeUtils.b(localFileInfo.b());
              String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131692414);
              ((LocalFileAdapter.LocalFileItemHolder)localObject).c.setText(str1 + str2 + FileUtil.a(localFileInfo.a()));
              ((LocalFileAdapter.LocalFileItemHolder)localObject).jdField_a_of_type_Int = paramInt;
            }
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
        }
        localException1.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */