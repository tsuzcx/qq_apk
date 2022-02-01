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
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class LocalFileAdapter
  extends BaseLocalFileAdapter
{
  private final int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LocalFileBrowserActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = null;
  private List<FileInfo> jdField_a_of_type_JavaUtilList;
  private final int b = 1;
  
  public LocalFileAdapter(Context paramContext, List<FileInfo> paramList, LocalFileBrowserActivity paramLocalFileBrowserActivity)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity = paramLocalFileBrowserActivity;
  }
  
  private View a(FileInfo paramFileInfo, ViewGroup paramViewGroup)
  {
    LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = new LocalFileAdapter.LocalFileItemHolder(this);
    if (!paramFileInfo.d())
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramFileInfo);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramFileInfo.findViewById(2131366794));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366781));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localLocalFileItemHolder);
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131376538));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramFileInfo.findViewById(2131366792));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localLocalFileItemHolder.b = ((TextView)paramFileInfo.findViewById(2131366795));
      localLocalFileItemHolder.c = ((TextView)paramFileInfo.findViewById(2131366779));
      localLocalFileItemHolder.d = ((TextView)paramFileInfo.findViewById(2131369727));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramFileInfo.findViewById(2131361949));
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      paramFileInfo = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560786, paramViewGroup, false);
      paramFileInfo.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramFileInfo.findViewById(2131366807));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramFileInfo.findViewById(2131376548));
      localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((EllipsizingTextView)paramFileInfo.findViewById(2131366811));
    }
    paramFileInfo.setTag(localLocalFileItemHolder);
    return paramFileInfo;
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
    if (((FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).d()) {
      return -1;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView1;
    View localView2;
    if (localFileInfo == null)
    {
      localView1 = null;
    }
    else
    {
      localView1 = paramView;
      if (paramView == null) {}
      try
      {
        localView1 = a(localFileInfo, paramViewGroup);
        paramView = localView1;
        LocalFileAdapter.LocalFileItemHolder localLocalFileItemHolder = (LocalFileAdapter.LocalFileItemHolder)localView1.getTag();
        paramView = localView1;
        localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo = localFileInfo;
        paramView = localView1;
        if (localFileInfo.d())
        {
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844339);
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_Int = paramInt;
        }
        else
        {
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView = localView1;
          QQFileManagerUtil.a(localLocalFileItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localFileInfo.c(), QQFileManagerUtil.b(localFileInfo.c()));
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
          paramView = localView1;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f())
          {
            paramView = localView1;
            localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            paramView = localView1;
            localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
          }
          else
          {
            paramView = localView1;
            localLocalFileItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          }
          paramView = localView1;
          String str1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localFileInfo.b());
          paramView = localView1;
          String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getString(2131692346);
          paramView = localView1;
          TextView localTextView = localLocalFileItemHolder.c;
          paramView = localView1;
          StringBuilder localStringBuilder = new StringBuilder();
          paramView = localView1;
          localStringBuilder.append(str1);
          paramView = localView1;
          localStringBuilder.append(str2);
          paramView = localView1;
          localStringBuilder.append(FileUtil.a(localFileInfo.a()));
          paramView = localView1;
          localTextView.setText(localStringBuilder.toString());
          paramView = localView1;
          localLocalFileItemHolder.jdField_a_of_type_Int = paramInt;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localView2 = paramView;
      }
      paramView = localView2;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView2;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.LocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */