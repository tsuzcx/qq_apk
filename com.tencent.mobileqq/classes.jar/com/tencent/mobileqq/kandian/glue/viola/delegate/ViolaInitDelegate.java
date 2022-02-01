package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaInitDelegate;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ViolaInitDelegate
  implements IViolaInitDelegate
{
  private int jdField_a_of_type_Int = 0;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  private ViolaFragment jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
  private ViolaInitDelegate.ViolaGestureLayoutStateChangeListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate$ViolaGestureLayoutStateChangeListener;
  private ViolaBaseView jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
  private ViewPagerCompat jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ViolaBaseView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public ViolaInitDelegate(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = paramViolaFragment;
  }
  
  private ViolaBaseView.ViolaCreactPageObject a(JSONObject paramJSONObject)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    return new ViolaBaseView.ViolaCreactPageObject(str, paramJSONObject, a(str), this.jdField_b_of_type_JavaLangString);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viola_cache_file_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(localAppRuntime.getAccount());
      paramString = FileUtils.readObject(localStringBuilder.toString());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
    }
    return null;
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getArguments());
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getSusConfigMap();
    if (localHashMap.containsKey("title_border_radius")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setBorderRadius(((Integer)localHashMap.get("title_border_radius")).intValue());
    }
    if (localHashMap.containsKey("title_margin_top")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setContentMarginTop(((Integer)localHashMap.get("title_margin_top")).intValue());
    }
    if (localHashMap.containsKey("title_default_title_height")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setTitleBarHeight(((Integer)localHashMap.get("title_default_title_height")).intValue());
    }
    if (localHashMap.containsKey("title_default_gray_bar")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsShowGrayBar(((Boolean)localHashMap.get("title_default_gray_bar")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_back_bar")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsNeedShowBackView(((Boolean)localHashMap.get("title_default_back_bar")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_pop_anim")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(((Boolean)localHashMap.get("title_default_pop_anim")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_auto_top")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(((Boolean)localHashMap.get("title_default_auto_top")).booleanValue());
    }
    if (localHashMap.containsKey("title_content_color")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setContainerColor(Color.parseColor((String)localHashMap.get("title_content_color")));
    }
    if (localHashMap.containsKey("title_status_immersive")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsStatusImmersive(((Boolean)localHashMap.get("title_status_immersive")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_title_alpha")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsNeedChangeTitleAlpha(((Boolean)localHashMap.get("title_default_title_alpha")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_gray_float")) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setIsNeedGrayBarFloat(((Boolean)localHashMap.get("title_default_gray_float")).booleanValue());
    }
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131380916);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setViolaGestureListener(new ViolaInitDelegate.5(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.setContentScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity(), -1, -1, true);
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
  }
  
  public ViolaBaseView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    ViewPagerCompat localViewPagerCompat = this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
    if (localViewPagerCompat != null) {
      localViewPagerCompat.setScrollable(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("url");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("colorBallData");
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setLayerType(2, null);
    b(paramViewGroup);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInitDelegate.1(this), 150L);
  }
  
  public void a(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131380915));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView = new ViolaBaseView(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity());
    if (!paramBoolean1) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.setListener(paramViolaViewListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    paramViewGroup = a(paramJSONObject);
    if (paramBoolean2) {
      paramViewGroup.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment, paramViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a(0, 4);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.d();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity().doOnBackPressed();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity().overridePendingTransition(2130772265, 2130772268);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout.a(0, 4);
    }
  }
  
  public void a(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(paramViolaViewListener);
  }
  
  public void a(ViolaInitDelegate.ViolaGestureLayoutStateChangeListener paramViolaGestureLayoutStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaDelegateViolaInitDelegate$ViolaGestureLayoutStateChangeListener = paramViolaGestureLayoutStateChangeListener;
  }
  
  public void a(String paramString)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(str)) && (str.equals(ViolaUtils.getPageName(paramString))))
      {
        paramString = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        break label73;
      }
      i += 1;
    }
    paramString = null;
    label73:
    if (paramString != null) {
      paramString.a(ViolaBizUtils.c().toString());
    }
  }
  
  public void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("url"))))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
      if (localObject1 != null) {
        ((ViewPagerCompat)localObject1).setScrollable(true);
      }
      Object localObject2 = null;
      String str = paramJSONObject.optString("url");
      int i = 0;
      int j = paramJSONObject.optInt("position", 0);
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        if (ViolaUtils.getPageName(str).equals(ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
        {
          localObject1 = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          break;
        }
        i += 1;
      }
      if (localObject1 != null)
      {
        if (j != this.jdField_b_of_type_Int)
        {
          ((ViolaBaseView)localObject1).a(ViolaBizUtils.a(paramJSONObject).toString());
          this.jdField_b_of_type_Int = j;
          this.c = str;
        }
      }
      else
      {
        paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
        if ((paramJSONObject != null) && (paramJSONObject.getQBaseActivity() != null))
        {
          paramJSONObject = new ViolaBaseView(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity(), Boolean.valueOf(true));
          paramJSONObject.setListener(new ViolaInitDelegate.4(this));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("&firstCreated=1");
          localObject1 = ((StringBuilder)localObject1).toString();
          paramJSONObject.setPageStartTime(System.currentTimeMillis());
          paramJSONObject.a((String)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment, new ViolaBaseView.ViolaCreactPageObject((String)localObject1, new JSONObject(), a((String)localObject1), 0, null));
          this.jdField_a_of_type_JavaUtilArrayList.add(paramJSONObject);
          paramJSONObject = this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
          if (paramJSONObject != null) {
            paramJSONObject.notifyDataSetChanged();
          }
          this.c = ((String)localObject1);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      c(true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startSession", 1);
      b(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUserVisibleHint Exception ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ViolaInitDelegate", 1, localStringBuilder.toString());
    }
    c(false);
    return;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat != null;
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat = new ViewPagerCompat(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity());
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat);
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = new ViolaInitDelegate.2(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.addOnPageChangeListener(new ViolaInitDelegate.3(this));
  }
  
  public void b(String paramString)
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      localViolaBaseView.a(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    CommonSuspensionGestureLayout localCommonSuspensionGestureLayout = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaCommonSuspensionGestureLayout;
    if (localCommonSuspensionGestureLayout != null) {
      localCommonSuspensionGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
  
  public boolean b()
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      return localViolaBaseView.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView != null)
    {
      if (a())
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (ViolaUtils.getPageName(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.jdField_a_of_type_JavaLangString).equals(ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.getCurrentItem() != i) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityResume();
            c(true);
            return;
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.onActivityResume();
      c(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if ((localViolaBaseView != null) && (localViolaBaseView.b())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView.a(paramBoolean);
    }
  }
  
  public void d()
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null)
    {
      localViolaBaseView.onActivityPause();
      c(false);
    }
  }
  
  public void e()
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityDestroy();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) instanceof ViolaBaseView)) {
        ((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroy();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void f()
  {
    ViolaBaseView localViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView;
    if (localViolaBaseView != null) {
      localViolaBaseView.a();
    }
  }
  
  public void g()
  {
    ViewPagerCompat localViewPagerCompat = this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat;
    if (localViewPagerCompat != null)
    {
      int i = localViewPagerCompat.getCurrentItem();
      if (i >= 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetViewPagerCompat.setCurrentItem(i - 1);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity() != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.getQBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate
 * JD-Core Version:    0.7.0.1
 */