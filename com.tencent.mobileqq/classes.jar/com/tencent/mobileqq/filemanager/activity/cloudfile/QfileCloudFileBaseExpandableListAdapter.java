package com.tencent.mobileqq.filemanager.activity.cloudfile;

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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.LinkedHashMap;

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
  
  public QfileCloudFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
    if ((paramString2 == null) || (paramString2.equalsIgnoreCase(""))) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  private void a(AsyncImageView paramAsyncImageView, String paramString)
  {
    paramAsyncImageView.setDefaultImage(2130841666);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)getChild(paramInt1, paramInt2);
    if (localWeiYunFileInfo == null) {
      return paramView;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        localObject2 = new QfileCloudFileBaseExpandableListAdapter.CloudItemHolder(this);
        localObject1 = paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970021, paramViewGroup, false);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368769));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368774));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131368770));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368772));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368773));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368732));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364142));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368776));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363205));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131362747));
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        ((QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localObject1 = paramView;
        paramView.setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
      }
      catch (Exception paramViewGroup)
      {
        Object localObject2;
        int i;
        paramView = (View)localObject1;
        continue;
        continue;
      }
      try
      {
        i = FileManagerUtil.a(localWeiYunFileInfo.c);
        FileManagerUtil.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h, i);
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.jdField_a_of_type_Int = paramInt2;
        paramViewGroup.jdField_a_of_type_JavaLangObject = localWeiYunFileInfo;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.c);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewGroup);
        paramViewGroup.jdField_c_of_type_Int = 1;
        if ((FileManagerUtil.a(localWeiYunFileInfo.c) == 0) && (FileUtils.b(localWeiYunFileInfo.h))) {
          a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, localWeiYunFileInfo.h);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(FileManagerUtil.d(localWeiYunFileInfo.c));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localWeiYunFileInfo));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428101);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131428143);
        localObject1 = QfileTimeUtils.c(localWeiYunFileInfo.b) + a((String)localObject2, (String)localObject1);
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().a(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
        if ((localObject1 == null) || (((FileManagerEntity)localObject1).status != 2)) {
          continue;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(((FileManagerEntity)localObject1).fProgress * 100.0F));
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428318);
        paramViewGroup.jdField_c_of_type_Int = 2;
        if (localObject1 == null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.a().c(localWeiYunFileInfo.jdField_a_of_type_JavaLangString);
          if ((localObject1 != null) && (!FileUtil.b(((FileManagerEntity)localObject1).getFilePath())))
          {
            ((FileManagerEntity)localObject1).setCloudType(2);
            if (((FileManagerEntity)localObject1).getId() > 0L) {
              ((FileManagerEntity)localObject1).nOpType = 5;
            }
            if (((FileManagerEntity)localObject1).status == 1) {
              ((FileManagerEntity)localObject1).status = -1;
            }
          }
          if (localObject1 != null) {
            switch (((FileManagerEntity)localObject1).status)
            {
            }
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        paramViewGroup.printStackTrace();
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428319);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_c_of_type_Int = 3;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramViewGroup.jdField_c_of_type_Int = 0;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setText(2131428320);
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_c_of_type_Int = 1;
        continue;
        paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        continue;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f()) {
        continue;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838591);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localWeiYunFileInfo));
      return paramView;
      localObject1 = paramView;
      paramViewGroup = (QfileCloudFileBaseExpandableListAdapter.CloudItemHolder)paramView.getTag();
      continue;
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */