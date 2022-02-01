package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.IQfileViewBinder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter.QfileGroupTag;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileLocalFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap<Integer, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener b;
  private View.OnClickListener c;
  private View.OnClickListener d = null;
  
  public QfileLocalFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
  {
    super(paramContext, paramLinkedHashMap);
    if (paramBaseFileAssistantActivity.g() != -1)
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.c = paramOnClickListener3;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(paramFileInfo.b()));
    localStringBuilder.append("  ");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.k())
    {
      localStringBuilder.append("来自微信");
      localStringBuilder.append("  ");
    }
    localStringBuilder.append(FileUtil.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    if (this.d == null) {
      this.d = new QfileLocalFileBaseExpandableListAdapter.1(this);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, QfileLocalFileBaseExpandableListAdapter.LocalItemHolder paramLocalItemHolder)
  {
    int i = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)) == true)
    {
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 5)
        {
          paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
          paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(QQFileManagerUtil.a(paramInt1));
          return;
        }
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844325);
        if (FileUtils.fileExistsAndNotEmpty(paramString)) {
          paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
        }
      }
      else
      {
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844438);
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
      }
    }
    else
    {
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(paramInt2, paramInt3);
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844363);
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
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
        localQfileGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramView.setEnabled(false);
        return;
      }
      paramView.setEnabled(true);
      localQfileGroupTag.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("groupPosition[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("],childPosition[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("]");
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {
      localObject1 = paramView;
    }
    try
    {
      localObject2 = new QfileLocalFileBaseExpandableListAdapter.LocalItemHolder(this);
      localObject1 = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.b);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366779));
      localObject1 = paramView;
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = paramView;
      ((QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(i, i);
      localObject1 = paramView;
      paramView.setTag(localObject2);
      paramViewGroup = (ViewGroup)localObject2;
    }
    catch (Exception paramView)
    {
      Object localObject2;
      paramView.printStackTrace();
      return localObject1;
    }
    Object localObject1 = paramView;
    paramViewGroup = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
    while (localFileInfo != null)
    {
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_Int = paramInt2;
      localObject1 = paramView;
      localFileInfo.a((String)getGroup(paramInt1));
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFileInfo;
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.c);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
      localObject1 = paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(paramViewGroup);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.d);
      }
      localObject1 = paramView;
      paramInt1 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
      localObject1 = paramView;
      paramInt2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
      localObject1 = paramView;
      localObject2 = localFileInfo.c();
      localObject1 = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder != null)
      {
        localObject1 = paramView;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileBaseExpandableListAdapter$IQfileViewBinder.a(localFileInfo);
      }
      localObject1 = paramView;
      a((String)localObject2, QQFileManagerUtil.b((String)localObject2), paramInt2, paramInt1, paramViewGroup);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = paramView;
      localObject2 = localFileInfo.d();
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(4);
      localObject1 = paramView;
      paramViewGroup.c = 0;
      localObject1 = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
      }
      else
      {
        localObject1 = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      localObject1 = paramView;
      localObject2 = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localObject1 = paramView;
      ((LinearLayout.LayoutParams)localObject2).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.jdField_a_of_type_AndroidContentContext.getResources());
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      localObject1 = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.25F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      return paramView;
    }
    return paramView;
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
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramViewGroup.setEnabled(false);
        onGroupExpanded(0);
        return paramViewGroup;
      }
      paramViewGroup.setEnabled(true);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */