package com.tencent.mobileqq.leba.mgr.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.leba.business.LebaListMgrItemBizProxy;
import com.tencent.mobileqq.leba.core.LebaSettingHandlerApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaListMgrAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new LebaListMgrAdapter.3(this);
  LebaListMgrItemBizProxy jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  protected AppRuntime a;
  
  public LebaListMgrAdapter(AppRuntime paramAppRuntime, Context paramContext, List<LebaViewItem> paramList, LebaListMgrItemBizProxy paramLebaListMgrItemBizProxy)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy = paramLebaListMgrItemBizProxy;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845494);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onReportRedPointExposure(paramAppInfo);
  }
  
  private void a(RedTouch paramRedTouch, LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    int i = 1;
    if ((paramLebaViewItem != null) && (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
    {
      paramLebaViewItem.jdField_a_of_type_Byte = (paramBoolean ^ true);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("name: ");
        ((StringBuilder)localObject).append(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        ((StringBuilder)localObject).append("  cCurFlag:");
        ((StringBuilder)localObject).append(paramLebaViewItem.jdField_a_of_type_Byte);
        QLog.i("LebaListMgrAdapter", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy;
      if ((localObject == null) || (!((LebaListMgrItemBizProxy)localObject).a(paramRedTouch, paramLebaViewItem, paramBoolean))) {
        i = 0;
      }
      if (i == 0)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
        LebaSettingHandlerApi.a(this.jdField_a_of_type_MqqAppAppRuntime, String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), paramBoolean, l);
        if (paramBoolean)
        {
          localObject = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
          l = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
          paramLebaViewItem = new StringBuilder();
          paramLebaViewItem.append("100600.");
          paramLebaViewItem.append(l + 100000000L);
          paramLebaViewItem.append("");
          ((IRedTouchManager)localObject).onRedTouchItemClick(paramLebaViewItem.toString());
          if (paramRedTouch != null) {
            paramRedTouch.d();
          }
        }
      }
      b();
      notifyDataSetChanged();
      return;
    }
    QLog.i("LebaListMgrAdapter", 1, "item == null || item.info == null");
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof LebaViewItem))
      {
        localObject2 = (LebaViewItem)localObject2;
        if ((((LebaViewItem)localObject2).jdField_a_of_type_Boolean) && (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.cCanChangeState != 0)) {
          localArrayList.add(localObject2);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localArrayList.size() > 0)
    {
      Collections.sort(localArrayList, new LebaUtil.LebaItemComparator());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy;
      if (localObject1 != null) {
        ((LebaListMgrItemBizProxy)localObject1).a(localArrayList);
      }
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    }
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(List<LebaViewItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    Object localObject1 = paramView;
    if (localLebaViewItem != null) {
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null)
      {
        localObject1 = paramView;
      }
      else
      {
        if (paramView == null)
        {
          localObject1 = new LebaListMgrAdapter.ViewHolder();
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559066, paramViewGroup, false);
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369917));
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369991));
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369990));
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131364078));
          paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).d(100).a();
          paramView.setTag(localObject1);
        }
        else
        {
          localObject1 = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
        }
        if (ThemeUtil.isDefaultTheme())
        {
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850581);
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167063));
        }
        else
        {
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850578);
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167056));
        }
        RedTouch localRedTouch = (RedTouch)paramView;
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localLebaViewItem.jdField_a_of_type_Byte == 0)
        {
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        }
        else
        {
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        }
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new LebaListMgrAdapter.1(this, localRedTouch, localLebaViewItem));
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getview name: ");
          ((StringBuilder)localObject2).append(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
          ((StringBuilder)localObject2).append("  cCurFlag:");
          ((StringBuilder)localObject2).append(localLebaViewItem.jdField_a_of_type_Byte);
          QLog.i("LebaListMgrAdapter", 2, ((StringBuilder)localObject2).toString());
        }
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = localLebaViewItem;
        Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        String str = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL;
        int i = ViewUtils.a(26.0F);
        Object localObject2 = (RelativeLayout.LayoutParams)((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = i;
        ((RelativeLayout.LayoutParams)localObject2).height = i;
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = localDrawable;
        if (localLebaViewItem != null)
        {
          localObject2 = localDrawable;
          if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null)
          {
            localObject2 = localDrawable;
            if (!TextUtils.isEmpty(str))
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth;
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = localDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = localDrawable;
              localObject2 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject2).setTargetDensity(this.jdField_a_of_type_Int);
              if (((URLDrawable)localObject2).getStatus() == 2) {
                ((URLDrawable)localObject2).restartDownload();
              }
              ((Drawable)localObject2).setColorFilter(-1, PorterDuff.Mode.DST_IN);
            }
          }
        }
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        if (localObject2 != null) {
          ThemeUtil.setThemeFilter((Drawable)localObject2, ThemeUtil.curThemeId);
        }
        if (localLebaViewItem.jdField_a_of_type_Byte == 1)
        {
          long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("100600.");
          ((StringBuilder)localObject2).append(l + 100000000L);
          ((StringBuilder)localObject2).append("");
          a(localRedTouch, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localRedTouch.d();
        }
        if (AppSetting.d)
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            AccessibilityUtil.a(((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView, false);
            AccessibilityUtil.a(((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch, false);
            AccessibilityUtil.a(((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView, false);
            ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.getText());
          }
          if (Build.VERSION.SDK_INT >= 14) {
            ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
          }
          ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new LebaListMgrAdapter.2(this, localRedTouch, localLebaViewItem));
        }
        localObject1 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrAdapter
 * JD-Core Version:    0.7.0.1
 */