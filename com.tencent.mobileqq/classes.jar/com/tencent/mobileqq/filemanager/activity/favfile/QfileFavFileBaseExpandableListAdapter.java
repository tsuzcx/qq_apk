package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import java.util.LinkedHashMap;
import java.util.List;

public class QfileFavFileBaseExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  protected BaseFileAssistantActivity a;
  private QfileFavFileBaseExpandableListAdapter.IAdapterCallBack jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileBaseExpandableListAdapter$IAdapterCallBack;
  private View.OnClickListener b;
  
  public QfileFavFileBaseExpandableListAdapter(Context paramContext, LinkedHashMap<String, List<FavFileInfo>> paramLinkedHashMap, BaseFileAssistantActivity paramBaseFileAssistantActivity, View.OnClickListener paramOnClickListener1, View.OnLongClickListener paramOnLongClickListener, View.OnClickListener paramOnClickListener2, QfileFavFileBaseExpandableListAdapter.IAdapterCallBack paramIAdapterCallBack)
  {
    super(paramContext, paramLinkedHashMap);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.b = paramOnClickListener2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavFileBaseExpandableListAdapter$IAdapterCallBack = paramIAdapterCallBack;
  }
  
  private String a(FavFileInfo paramFavFileInfo)
  {
    String str1 = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(paramFavFileInfo.jdField_c_of_type_Long);
    String str2 = FileUtil.a(paramFavFileInfo.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramFavFileInfo.m);
    localStringBuilder.append(" ");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
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
  
  protected void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    int i = QQFileManagerUtil.b(paramFavFileInfo.jdField_c_of_type_JavaLangString);
    if ((i == 0) || (i == 2))
    {
      String str;
      if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.k)) {
        str = paramFavFileInfo.k;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.j)) {
        str = paramFavFileInfo.j;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.i)) {
        str = paramFavFileInfo.i;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.h)) {
        str = paramFavFileInfo.h;
      } else if (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.g)) {
        str = paramFavFileInfo.g;
      } else {
        str = "";
      }
      if (!TextUtils.isEmpty(str))
      {
        paramAsyncImageView.setAsyncImage(str);
        return;
      }
    }
    QQFileManagerUtil.a(paramAsyncImageView, paramFavFileInfo.e, i);
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FavFileInfo localFavFileInfo = (FavFileInfo)getChild(paramInt1, paramInt2);
    if (localFavFileInfo == null) {
      return paramView;
    }
    View localView;
    if (paramView == null) {
      localView = paramView;
    }
    try
    {
      Object localObject = new QfileFavFileBaseExpandableListAdapter.FavFileItemHolder(this);
      localView = paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560778, paramViewGroup, false);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376167));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)paramView.findViewById(2131361949));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366794));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366781));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localObject);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366792));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setGravity(48);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366779));
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369727));
      localView = paramView;
      int i = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(70, this.jdField_a_of_type_AndroidContentContext.getResources());
      localView = paramView;
      ((QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(i, i);
      localView = paramView;
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      break label368;
      localView = paramView;
      paramViewGroup = (QfileFavFileBaseExpandableListAdapter.FavFileItemHolder)paramView.getTag();
      label368:
      localView = paramView;
      a(localFavFileInfo, paramViewGroup.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_Int = paramInt1;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_Int = paramInt2;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localFavFileInfo;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.b);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(2);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(paramViewGroup);
      localView = paramView;
      paramViewGroup.jdField_c_of_type_Int = 1;
      localView = paramView;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      localView = paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFavFileInfo.jdField_c_of_type_JavaLangString);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(a(localFavFileInfo));
      localView = paramView;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692375);
      localView = paramView;
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692346);
      localView = paramView;
      StringBuilder localStringBuilder = new StringBuilder();
      localView = paramView;
      localStringBuilder.append(((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).formatNewRefreshTime(localFavFileInfo.jdField_c_of_type_Long));
      localView = paramView;
      localStringBuilder.append(a(str, (String)localObject));
      localView = paramView;
      localObject = localStringBuilder.toString();
      localView = paramView;
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localView = paramView;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(FMDataCache.a(localFavFileInfo));
      }
      else
      {
        localView = paramView;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
      localView = paramView;
      localObject = (LinearLayout.LayoutParams)paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      localView = paramView;
      ((LinearLayout.LayoutParams)localObject).topMargin = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).dp2px(3, this.jdField_a_of_type_AndroidContentContext.getResources());
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(TypedValue.applyDimension(1, 0.8F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()), 1.0F);
      localView = paramView;
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileBaseExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */