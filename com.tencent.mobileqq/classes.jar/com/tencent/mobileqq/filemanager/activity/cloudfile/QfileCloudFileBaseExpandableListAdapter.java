package com.tencent.mobileqq.filemanager.activity.cloudfile;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileCloudFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public QfileCloudFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<WeiYunFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    return FileUtil.a(paramWeiYunFileInfo.jdField_a_of_type_Long);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      if (paramString2.equalsIgnoreCase("")) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130844363);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    View localView;
    if (paramView == null) {
      localView = paramView;
    }
    try
    {
      Object localObject1 = new QfileCloudFileBaseExpandableListAdapter.CloudItemHolder(this);
      localView = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject1);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366779));
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369727));
      localView = paramView;
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.jdField_a_of_type_AndroidContentContext.getResources());
      localView = paramView;
      ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(i, i);
      localView = paramView;
      paramView.setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      break label368;
      localView = paramView;
      paramViewGroup = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      label368:
      localView = paramView;
      i = QQFileManagerUtil.b(localWeiYunFileInfo.c);
      localView = paramView;
      QQFileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h, i);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_Int = paramInt2;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localWeiYunFileInfo;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
      localView = paramView;
      paramViewGroup.jdField_c_of_type_Int = 1;
      localView = paramView;
      if (QQFileManagerUtil.b(localWeiYunFileInfo.c) == 0)
      {
        localView = paramView;
        if (FileUtils.fileExistsAndNotEmpty(localWeiYunFileInfo.h))
        {
          localView = paramView;
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h);
        }
      }
      localView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localWeiYunFileInfo.c);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localWeiYunFileInfo));
      localView = paramView;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692375);
      localView = paramView;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692346);
      localView = paramView;
      Object localObject3 = new StringBuilder();
      localView = paramView;
      ((StringBuilder)localObject3).append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localWeiYunFileInfo.b));
      localView = paramView;
      ((StringBuilder)localObject3).append(a((String)localObject2, (String)localObject1));
      localView = paramView;
      localObject1 = ((StringBuilder)localObject3).toString();
      localView = paramView;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localView = paramView;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a();
      localView = paramView;
      localObject2 = ((IQQFileEngine)((BaseQQAppInterface)localObject3).getRuntimeService(IQQFileEngine.class)).queryFileEntityByFileId(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
      if (localObject2 != null)
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(1);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
        localView = paramView;
        paramViewGroup.jdField_c_of_type_Int = 2;
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(true);
      }
      else
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(false);
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localView = paramView;
        localObject2 = ((IQQFileDataCenter)((BaseQQAppInterface)localObject3).getRuntimeService(IQQFileDataCenter.class)).queryByFileIdForMemory(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          localView = paramView;
          if (!FileUtils.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath()))
          {
            localView = paramView;
            ((FileManagerEntity)localObject2).setCloudType(2);
            localView = paramView;
            if (((FileManagerEntity)localObject2).getId() > 0L)
            {
              localView = paramView;
              ((FileManagerEntity)localObject2).nOpType = 5;
            }
            localObject1 = localObject2;
            localView = paramView;
            if (((FileManagerEntity)localObject2).status != 1)
            {
              localView = paramView;
              paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress((int)(((FileManagerEntity)localObject2).fProgress * 100.0F));
              localView = paramView;
              paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.a(true);
              localObject1 = localObject2;
            }
          }
        }
      }
      if (localObject1 != null)
      {
        localView = paramView;
        paramInt1 = ((FileManagerEntity)localObject1).status;
        if (paramInt1 != -1)
        {
          if (paramInt1 != 0) {
            if (paramInt1 != 1)
            {
              if (paramInt1 != 3) {
                break label1118;
              }
            }
            else
            {
              localView = paramView;
              paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
              localView = paramView;
              paramViewGroup.jdField_c_of_type_Int = 0;
              break label1118;
            }
          }
          localView = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localView = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localView = paramView;
          paramViewGroup.jdField_c_of_type_Int = 3;
        }
        else
        {
          localView = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
          localView = paramView;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
          localView = paramView;
          paramViewGroup.jdField_c_of_type_Int = 1;
        }
      }
      label1118:
      localView = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localWeiYunFileInfo));
      }
      else
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      localView = paramView;
      localObject1 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localView = paramView;
      ((LinearLayout.LayoutParams)localObject1).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.jdField_a_of_type_AndroidContentContext.getResources());
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */