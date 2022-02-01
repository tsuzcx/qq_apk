package com.tencent.mobileqq.leba.controller.list;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class LebaListViewAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private LebaRedTouchBase jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
  AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  String jdField_a_of_type_JavaLangString = "";
  private HashSet<Long> jdField_a_of_type_JavaUtilHashSet = new HashSet(30);
  private List<LebaViewItem> jdField_a_of_type_JavaUtilList;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int b;
  private int c;
  
  public LebaListViewAdapter(Context paramContext, List<LebaViewItem> paramList, int paramInt1, int paramInt2, AppRuntime paramAppRuntime, AbsListView paramAbsListView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845494);
    this.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase != null)
    {
      UpdateRedTouchParam localUpdateRedTouchParam = new UpdateRedTouchParam();
      localUpdateRedTouchParam.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
      localUpdateRedTouchParam.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidContentContext;
      localUpdateRedTouchParam.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = paramRedTouch;
      localUpdateRedTouchParam.jdField_a_of_type_Long = paramLong;
      localUpdateRedTouchParam.jdField_a_of_type_JavaLangString = paramString;
      localUpdateRedTouchParam.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase.a(localUpdateRedTouchParam);
    }
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if (paramLong == null) {
      return;
    }
    if (paramLong.longValue() == 10000L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(paramInt1);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(paramInt2);
      return;
    }
    Object localObject2 = null;
    LebaRedTouchBase localLebaRedTouchBase = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    Object localObject1 = localObject2;
    if (localLebaRedTouchBase != null)
    {
      localObject1 = localObject2;
      if (localLebaRedTouchBase.a() != null)
      {
        paramLong = (LebaExposureInfo)this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase.a().get(paramLong);
        localObject1 = localObject2;
        if (paramLong != null) {
          localObject1 = Integer.valueOf(paramLong.jdField_a_of_type_Int);
        }
      }
    }
    paramStringBuilder.append("_");
    if (localObject1 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = ((Integer)localObject1).intValue();
    }
    paramStringBuilder.append(paramInt1);
  }
  
  private void a(Long paramLong, StringBuilder paramStringBuilder, Map<Long, Integer> paramMap)
  {
    if (paramLong == null) {
      return;
    }
    long l = paramLong.longValue();
    int i = 0;
    if (l == 10000L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(0);
      return;
    }
    if (paramLong.longValue() == 10004L)
    {
      paramStringBuilder.append("_");
      paramStringBuilder.append(0);
      return;
    }
    Integer localInteger = null;
    if (paramMap != null) {
      localInteger = (Integer)paramMap.get(paramLong);
    }
    paramStringBuilder.append("_");
    if (localInteger != null) {
      i = localInteger.intValue();
    }
    paramStringBuilder.append(i);
  }
  
  public Map<Long, Integer> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (!a(localLebaViewItem)))
        {
          ((Map)localObject).put(Long.valueOf(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), Integer.valueOf(i));
          i += 1;
        }
      }
      return localObject;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      Map localMap = a();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((localLong.longValue() != 10004L) || (paramBoolean))
        {
          localStringBuilder.append(localLong);
          a(localLong, localStringBuilder, localMap);
          a(localLong, localStringBuilder, paramInt1, paramInt2);
          if (localIterator.hasNext()) {
            localStringBuilder.append(";");
          }
        }
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "trends_plugin", "old_plugin_exp", 0, 0, "", "", "", localStringBuilder.toString());
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(LebaRedTouchBase paramLebaRedTouchBase)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = paramLebaRedTouchBase;
  }
  
  public void a(List<LebaViewItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i);
        if (localObject != null) {
          if ((((View)localObject).getTag(-1) != null) && ((((View)localObject).getTag(-1) instanceof Integer)))
          {
            if (((Integer)((View)localObject).getTag(-1)).intValue() == 0)
            {
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
              }
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
              }
            }
            else
            {
              int j = ((Integer)((View)localObject).getTag(-1)).intValue();
              if ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (j >= 0)) {
                localObject = (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(j);
              }
            }
          }
          else if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof LebaListViewAdapter.CornerListItemHolder)))
          {
            localObject = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
            if ((localObject != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null) && (((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
            {
              long l = ((LebaListViewAdapter.CornerListItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
              if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(l))) {
                this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void c()
  {
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size()) && (paramInt >= 0)) {
      return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    if (getItem(paramInt) == null)
    {
      localObject2 = paramView;
    }
    else
    {
      Object localObject3 = (LebaViewItem)getItem(paramInt);
      int i = getItemViewType(paramInt);
      Object localObject1;
      if (i == 0)
      {
        if (paramView == null)
        {
          localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.b, null);
          localObject2 = new LebaListViewAdapter.CornerListItemHolder(this);
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131369917));
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131369991));
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131369990));
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).b = ((ImageView)((View)localObject1).findViewById(2131362976));
          localObject1 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject1).d(36).a();
          ((View)localObject1).setTag(localObject2);
        }
        else
        {
          localObject2 = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
          localObject1 = paramView;
        }
        if ((localObject3 != null) && (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null)) {
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        }
        ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167063));
        Object localObject4 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if ((localObject3 != null) && (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
        {
          if (!TextUtils.isEmpty(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL))
          {
            localObject4 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ViewUtils.a(26.0F);
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth;
            Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = localDrawable;
            ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
            localObject4 = URLDrawable.getDrawable(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject4);
            ((URLDrawable)localObject4).setTargetDensity(this.jdField_a_of_type_Int);
            if (((URLDrawable)localObject4).getStatus() == 2) {
              ((URLDrawable)localObject4).restartDownload();
            }
            ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject4);
          }
          else
          {
            ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          }
        }
        else {
          ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        LebaConstant.a(((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_MqqAppAppRuntime);
        ((LebaListViewAdapter.CornerListItemHolder)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = ((LebaViewItem)localObject3);
        if ((localObject3 != null) && (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
        {
          a((RedTouch)localObject1, ((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, ((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName);
          if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId))) {
            this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId));
          }
        }
        if ((AppSetting.d) && (localObject3 != null) && (((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (!TextUtils.isEmpty(((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName))) {
          AccessibilityUtil.a((View)localObject1, ((LebaViewItem)localObject3).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName, Button.class.getName());
        }
      }
      else if (i == 1)
      {
        if (paramView == null) {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.c, null);
        } else {
          localObject2 = paramView;
        }
        boolean bool = SimpleUIUtil.a();
        localObject3 = ((View)localObject2).findViewById(2131365169);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          i = ViewUtils.a(12.0F);
          localObject1 = ((View)localObject3).getLayoutParams();
          if (bool) {
            i = 0;
          }
          ((ViewGroup.LayoutParams)localObject1).height = i;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((View)localObject1).setTag(-1, Integer.valueOf(paramInt));
      }
      localObject2 = localObject1;
      if (paramInt == 0)
      {
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10000L))) {
          this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10000L));
        }
        localObject2 = localObject1;
        if (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(10004L)))
        {
          this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(10004L));
          localObject2 = localObject1;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject2;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    return a((LebaViewItem)getItem(paramInt)) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListViewAdapter
 * JD-Core Version:    0.7.0.1
 */