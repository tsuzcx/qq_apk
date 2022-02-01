package com.tencent.mobileqq.filemanager.activity.favfile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.ImageHolder;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileBaseExpandableListAdapter;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class QfileFavImageExpandableListAdapter
  extends QfileBaseExpandableListAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private QfileFavImageExpandableListAdapter.IAdapterCallBack jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private LinkedHashMap<String, List<FavFileInfo>> jdField_b_of_type_JavaUtilLinkedHashMap;
  
  QfileFavImageExpandableListAdapter(QfileFavImageExpandableListAdapter.IAdapterCallBack paramIAdapterCallBack, BaseFileAssistantActivity paramBaseFileAssistantActivity, Object paramObject, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, View.OnLongClickListener paramOnLongClickListener)
  {
    super(paramBaseFileAssistantActivity, paramObject);
    this.jdField_a_of_type_AndroidContentContext = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramBaseFileAssistantActivity);
    this.jdField_b_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)paramObject);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack = paramIAdapterCallBack;
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 2.0F));
    this.jdField_a_of_type_Int = b();
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + 1 < this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size()) {
      return 1;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(getGroup(paramInt1));
    if (((localList == null) && (paramInt2 == 0)) || ((localList != null) && (paramInt2 == localList.size()))) {
      return 2;
    }
    return 1;
  }
  
  @SuppressLint({"InflateParams"})
  private View a(int paramInt1, int paramInt2, View paramView)
  {
    Object localObject1 = getChild(paramInt1, paramInt2);
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = (FavFileInfo)localObject1;
    } else {
      localObject2 = null;
    }
    this.jdField_a_of_type_Boolean = false;
    if (localObject2 == null)
    {
      if (a(paramInt1, paramInt2) == 1) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack.b()) {
        return null;
      }
      paramView = new ImageHolder();
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560784, null);
      ((View)localObject1).setClickable(true);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131380895));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131376345));
      paramView.c = ((ImageView)((View)localObject1).findViewById(2131370354));
      paramView.jdField_a_of_type_Boolean = true;
      paramView.jdField_b_of_type_Int = paramInt1;
      paramView.jdField_a_of_type_Int = paramInt2;
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack.a(paramView.jdField_a_of_type_AndroidWidgetTextView));
      ((View)localObject1).setTag(paramView);
      if (this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0)
      {
        ((View)localObject1).setVisibility(8);
      }
      else
      {
        ((View)localObject1).setVisibility(0);
        this.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack.a())
      {
        paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramView.c.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692602);
        return localObject1;
      }
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.c.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131692369);
      return localObject1;
    }
    if (paramView == null) {
      localObject1 = paramView;
    }
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560794, null);
        localObject1 = paramView;
        ImageHolder localImageHolder = new ImageHolder();
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368480));
        localObject1 = paramView;
        localImageHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localImageHolder);
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localImageHolder);
        localObject1 = paramView;
        localImageHolder.jdField_a_of_type_Boolean = false;
        localObject1 = paramView;
        paramView.setTag(localImageHolder);
        continue;
        localObject1 = paramView;
        localImageHolder = (ImageHolder)paramView.getTag();
        localObject1 = paramView;
        if (localImageHolder.jdField_a_of_type_Boolean)
        {
          localObject1 = paramView;
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560794, null);
          localObject1 = paramView;
          localImageHolder = new ImageHolder();
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131368461));
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368480));
          localObject1 = paramView;
          localImageHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368477));
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setTag(localImageHolder);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localImageHolder);
          localObject1 = paramView;
          paramView.setTag(localImageHolder);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_JavaLangObject = localObject2;
          localObject1 = paramView;
          localImageHolder.jdField_b_of_type_Int = paramInt1;
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_Int = paramInt2;
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAdjustViewBounds(false);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130848074);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setAsyncClipSize(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_Boolean = false;
          localObject1 = paramView;
          a((FavFileInfo)localObject2, localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView);
          localObject1 = paramView;
          Object localObject3 = new StringBuilder();
          localObject1 = paramView;
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692371));
          localObject1 = paramView;
          ((StringBuilder)localObject3).append(((FavFileInfo)localObject2).c);
          localObject1 = paramView;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject1 = paramView;
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.f())
          {
            localObject1 = paramView;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            localObject1 = paramView;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
            localObject1 = paramView;
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack.a((FavFileInfo)localObject2))
            {
              localObject1 = paramView;
              localObject2 = new StringBuilder();
              localObject1 = paramView;
              ((StringBuilder)localObject2).append((String)localObject3);
              localObject1 = paramView;
              ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692370));
              localObject1 = paramView;
              localObject2 = ((StringBuilder)localObject2).toString();
              localObject1 = paramView;
              localImageHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
              localObject1 = paramView;
              localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845864);
              localObject1 = paramView;
              localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
            }
            else
            {
              localObject1 = paramView;
              if (FMDataCache.a((FavFileInfo)localObject2))
              {
                localObject1 = paramView;
                localObject2 = new StringBuilder();
                localObject1 = paramView;
                ((StringBuilder)localObject2).append((String)localObject3);
                localObject1 = paramView;
                ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getString(2131692372));
                localObject1 = paramView;
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject1 = paramView;
                localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840575);
                localObject1 = paramView;
                paramView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getColor(2131167394));
                localObject1 = paramView;
                paramView.setOnLongClickListener(null);
              }
              else
              {
                localObject1 = paramView;
                localObject2 = new StringBuilder();
                localObject1 = paramView;
                ((StringBuilder)localObject2).append((String)localObject3);
                localObject1 = paramView;
                ((StringBuilder)localObject2).append(HardCodeUtil.a(2131692373));
                localObject1 = paramView;
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject1 = paramView;
                localImageHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
                localObject1 = paramView;
                localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845862);
                localObject1 = paramView;
                paramView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              }
            }
          }
          else
          {
            localObject1 = paramView;
            localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject1 = paramView;
            localImageHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            localObject2 = localObject3;
          }
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject2);
          localObject1 = paramView;
          localImageHolder.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription((CharSequence)localObject2);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        QLog.e("#######", 1, paramView.toString());
        return localObject1;
      }
    }
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setClickable(false);
    localLinearLayout.setLongClickable(false);
    localLinearLayout.setTag(new QfileFavImageExpandableListAdapter.GridGroupHolder(null));
    return localLinearLayout;
  }
  
  private void a(FavFileInfo paramFavFileInfo, AsyncImageView paramAsyncImageView)
  {
    if ((!TextUtils.isEmpty(paramFavFileInfo.e)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.e)))
    {
      paramAsyncImageView.setAsyncImage(paramFavFileInfo.e);
      return;
    }
    int i = 0;
    String str;
    if ((!TextUtils.isEmpty(paramFavFileInfo.k)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.k)))
    {
      str = paramFavFileInfo.k;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.j)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.j)))
    {
      str = paramFavFileInfo.j;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.i)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.i)))
    {
      str = paramFavFileInfo.i;
    }
    else if ((!TextUtils.isEmpty(paramFavFileInfo.h)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.h)))
    {
      str = paramFavFileInfo.h;
    }
    else
    {
      if ((!TextUtils.isEmpty(paramFavFileInfo.g)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.g))) {
        str = paramFavFileInfo.g;
      } else if ((!TextUtils.isEmpty(paramFavFileInfo.f)) && (FileUtils.fileExistsAndNotEmpty(paramFavFileInfo.f))) {
        str = paramFavFileInfo.f;
      } else {
        str = "";
      }
      i = 1;
    }
    if (!TextUtils.isEmpty(str))
    {
      paramAsyncImageView.setAsyncImage(str);
      if (i == 0) {
        return;
      }
    }
    long l = System.currentTimeMillis();
    if (l - paramFavFileInfo.a(2) > 30000L)
    {
      ((IQQFileEngine)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a.getRuntimeService(IQQFileEngine.class)).favProxydownloadThumb(paramFavFileInfo, 2);
      paramFavFileInfo.a(2, l);
    }
  }
  
  private int b()
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * 6.0F) / 4;
  }
  
  private View b(int paramInt1, int paramInt2, View paramView)
  {
    Object localObject = (LinearLayout)paramView;
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = a();
    }
    paramView.removeAllViews();
    QfileFavImageExpandableListAdapter.GridGroupHolder localGridGroupHolder = (QfileFavImageExpandableListAdapter.GridGroupHolder)paramView.getTag();
    int i = 0;
    while (i < 4)
    {
      View localView = a(paramInt1, paramInt2 * 4 + i, localGridGroupHolder.a[i]);
      if (localView == null) {
        return paramView;
      }
      localGridGroupHolder.a[i] = localView;
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        j = this.jdField_a_of_type_Int;
        localObject = new LinearLayout.LayoutParams(j, j);
      }
      int j = this.jdField_a_of_type_Int;
      ((LinearLayout.LayoutParams)localObject).width = j;
      ((LinearLayout.LayoutParams)localObject).height = j;
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).leftMargin = this.jdField_b_of_type_Int;
      }
      ((LinearLayout.LayoutParams)localObject).topMargin = this.jdField_b_of_type_Int;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramView.addView(localView);
      i += 1;
    }
    return paramView;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int + this.jdField_b_of_type_Int;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (i == paramInt1)
      {
        localObject = (List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str);
        if (localObject == null) {
          return null;
        }
        if (paramInt2 >= ((List)localObject).size()) {
          return null;
        }
        return ((List)localObject).get(paramInt2);
      }
      i += 1;
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    return b(paramInt1, paramInt2, paramView);
  }
  
  public int getChildrenCount(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt)
      {
        paramInt = ((List)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(str)).size();
        if (paramInt < 4) {
          return 1;
        }
        return paramInt / 4 + 1;
      }
      i += 1;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFavfileQfileFavImageExpandableListAdapter$IAdapterCallBack.b()) {
      return 1;
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i == paramInt) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupCount()
  {
    if (this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size() > 0) {
      return this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().size();
    }
    return 0;
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.favfile.QfileFavImageExpandableListAdapter
 * JD-Core Version:    0.7.0.1
 */