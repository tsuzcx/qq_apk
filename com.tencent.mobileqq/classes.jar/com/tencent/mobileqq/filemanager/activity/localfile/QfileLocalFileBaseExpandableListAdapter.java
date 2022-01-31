package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class QfileLocalFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private View.OnClickListener b;
  private View.OnClickListener c;
  
  public QfileLocalFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener3)
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
  
  private String a(FileInfo paramFileInfo)
  {
    return FileUtil.a(paramFileInfo.a());
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, QfileLocalFileBaseExpandableListAdapter.LocalItemHolder paramLocalItemHolder)
  {
    paramInt2 = paramString.hashCode();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt2)) == true) {
      paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt2)));
    }
    do
    {
      return;
      switch (paramInt1)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(FileManagerUtil.a(paramInt1));
        return;
      case 0: 
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841666);
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
        return;
      case 5: 
        paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841628);
      }
    } while (!FileUtil.b(paramString));
    paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
    return;
    paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130841698);
    paramLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncImage(paramString);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "groupPosition[" + paramInt1 + "],childPosition[" + paramInt2 + "]");
    }
    if ((paramInt1 == 5) && (paramInt2 == 0) && (QLog.isDevelopLevel())) {
      QLog.d("QfileLocalFileBaseExpandableListAdapter", 4, "ready crash!");
    }
    FileInfo localFileInfo = (FileInfo)getChild(paramInt1, paramInt2);
    if (paramView == null) {}
    try
    {
      QfileLocalFileBaseExpandableListAdapter.LocalItemHolder localLocalItemHolder = new QfileLocalFileBaseExpandableListAdapter.LocalItemHolder(this);
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970021, paramViewGroup, false);
      paramView = paramViewGroup;
      try
      {
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131368769));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.b);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131368774));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramViewGroup.findViewById(2131368770));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramViewGroup.findViewById(2131368772));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131368773));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368732));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131364142));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368776));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363205));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131362747));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        paramView = paramViewGroup;
        paramViewGroup.setTag(localLocalItemHolder);
        while (localFileInfo == null)
        {
          return paramViewGroup;
          localLocalItemHolder = (QfileLocalFileBaseExpandableListAdapter.LocalItemHolder)paramView.getTag();
          paramViewGroup = paramView;
        }
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_Int = paramInt1;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_Int = paramInt2;
        paramView = paramViewGroup;
        localFileInfo.a((String)getGroup(paramInt1));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_JavaLangObject = localFileInfo;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.c);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localLocalItemHolder);
        paramView = paramViewGroup;
        paramInt1 = localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getHeight();
        paramView = paramViewGroup;
        paramInt2 = localLocalItemHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.getWidth();
        paramView = paramViewGroup;
        a(localFileInfo.c(), FileManagerUtil.a(localFileInfo.c()), paramInt2, paramInt1, localLocalItemHolder);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localFileInfo.d());
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFileInfo));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(QfileTimeUtils.c(localFileInfo.b()));
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(2131428316);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_c_of_type_Int = 0;
        paramView = paramViewGroup;
        localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramView = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
        {
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838591);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFileInfo));
        }
        else
        {
          paramView = paramViewGroup;
          localLocalItemHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      catch (Exception paramViewGroup) {}
    }
    catch (Exception paramViewGroup)
    {
      label821:
      break label821;
    }
    paramViewGroup.printStackTrace();
    return paramView;
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */