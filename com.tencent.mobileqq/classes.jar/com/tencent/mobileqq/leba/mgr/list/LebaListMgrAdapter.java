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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845621);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onReportRedPointExposure(paramAppInfo);
  }
  
  private void a(RedTouch paramRedTouch, LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    int i = 1;
    if ((paramLebaViewItem == null) || (paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      QLog.i("LebaListMgrAdapter", 1, "item == null || item.info == null");
      return;
    }
    byte b;
    if (paramBoolean)
    {
      b = 0;
      paramLebaViewItem.jdField_a_of_type_Byte = b;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName + "  cCurFlag:" + paramLebaViewItem.jdField_a_of_type_Byte);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy == null) || (!this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy.a(paramRedTouch, paramLebaViewItem, paramBoolean))) {
        break label247;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        LebaShowListManager.a().a(this.jdField_a_of_type_MqqAppAppRuntime, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
        LebaSettingHandlerApi.a(this.jdField_a_of_type_MqqAppAppRuntime, String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId), paramBoolean, l);
        if (paramBoolean)
        {
          IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
          l = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
          localIRedTouchManager.onRedTouchItemClick("100600." + (100000000L + l) + "");
          if (paramRedTouch != null) {
            paramRedTouch.d();
          }
        }
      }
      b();
      notifyDataSetChanged();
      return;
      b = 1;
      break;
      label247:
      i = 0;
    }
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof LebaViewItem))
      {
        localObject = (LebaViewItem)localObject;
        if ((((LebaViewItem)localObject).jdField_a_of_type_Boolean) && (((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.cCanChangeState != 0)) {
          localArrayList.add(localObject);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (localArrayList.size() > 0)
    {
      Collections.sort(localArrayList, new LebaUtil.LebaItemComparator());
      if (this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaListMgrItemBizProxy.a(localArrayList);
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
    Object localObject1;
    Object localObject2;
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    label162:
    label200:
    RedTouch localRedTouch;
    if (paramView == null)
    {
      localObject1 = new LebaListMgrAdapter.ViewHolder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559172, paramViewGroup, false);
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370249));
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370323));
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370322));
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131364157));
      paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).d(100).a();
      paramView.setTag(localObject1);
      if (!ThemeUtil.a()) {
        break label696;
      }
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850655);
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167040));
      localRedTouch = (RedTouch)paramView;
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      if (localLebaViewItem.jdField_a_of_type_Byte != 0) {
        break label731;
      }
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
      label248:
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new LebaListMgrAdapter.1(this, localRedTouch, localLebaViewItem));
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "getview name: " + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName + "  cCurFlag:" + localLebaViewItem.jdField_a_of_type_Byte);
      }
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = localLebaViewItem;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      String str = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL;
      int i = ViewUtils.a(26.0F);
      Object localObject3 = (RelativeLayout.LayoutParams)((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = i;
      ((RelativeLayout.LayoutParams)localObject3).height = i;
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
      if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (TextUtils.isEmpty(str))) {
        break label769;
      }
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
      localObject2 = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject3);
      ((URLDrawable)localObject2).setTargetDensity(this.jdField_a_of_type_Int);
      if (((URLDrawable)localObject2).getStatus() == 2) {
        ((URLDrawable)localObject2).restartDownload();
      }
      ((Drawable)localObject2).setColorFilter(-1, PorterDuff.Mode.DST_IN);
    }
    label769:
    for (;;)
    {
      ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      if (localObject2 != null) {
        ThemeUtil.a((Drawable)localObject2, ThemeUtil.a);
      }
      if (localLebaViewItem.jdField_a_of_type_Byte == 1)
      {
        long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
      for (;;)
      {
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
        localObject2 = paramView;
        break;
        localObject1 = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
        break label162;
        label696:
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850652);
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
        break label200;
        label731:
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        ((LebaListMgrAdapter.ViewHolder)localObject1).jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        break label248;
        ((RedTouch)paramView).d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrAdapter
 * JD-Core Version:    0.7.0.1
 */