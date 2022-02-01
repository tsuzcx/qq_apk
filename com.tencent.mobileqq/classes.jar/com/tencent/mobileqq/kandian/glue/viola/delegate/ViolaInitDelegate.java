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
  private ViolaFragment a;
  private String b;
  private String c;
  private ViolaBaseView d;
  private ViewGroup e;
  private CommonSuspensionGestureLayout f;
  private ViolaInitDelegate.ViolaGestureLayoutStateChangeListener g;
  private ViewPagerCompat h;
  private PagerAdapter i;
  private ArrayList<ViolaBaseView> j = new ArrayList();
  private int k = 0;
  private String l;
  private int m = 0;
  
  public ViolaInitDelegate(ViolaFragment paramViolaFragment)
  {
    this.a = paramViolaFragment;
  }
  
  private ViolaBaseView.ViolaCreactPageObject b(JSONObject paramJSONObject)
  {
    String str = this.b;
    return new ViolaBaseView.ViolaCreactPageObject(str, paramJSONObject, b(str), this.c);
  }
  
  public static String b(String paramString)
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
    this.f = new CommonSuspensionGestureLayout(this.a.getQBaseActivity(), this.a.getArguments());
    HashMap localHashMap = this.a.getSusConfigMap();
    if (localHashMap.containsKey("title_border_radius")) {
      this.f.setBorderRadius(((Integer)localHashMap.get("title_border_radius")).intValue());
    }
    if (localHashMap.containsKey("title_margin_top")) {
      this.f.setContentMarginTop(((Integer)localHashMap.get("title_margin_top")).intValue());
    }
    if (localHashMap.containsKey("title_default_title_height")) {
      this.f.setTitleBarHeight(((Integer)localHashMap.get("title_default_title_height")).intValue());
    }
    if (localHashMap.containsKey("title_default_gray_bar")) {
      this.f.setIsShowGrayBar(((Boolean)localHashMap.get("title_default_gray_bar")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_back_bar")) {
      this.f.setIsNeedShowBackView(((Boolean)localHashMap.get("title_default_back_bar")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_pop_anim")) {
      this.f.setIsNeedPopAnim(((Boolean)localHashMap.get("title_default_pop_anim")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_auto_top")) {
      this.f.setIsAutoSuctionTop(((Boolean)localHashMap.get("title_default_auto_top")).booleanValue());
    }
    if (localHashMap.containsKey("title_content_color")) {
      this.f.setContainerColor(Color.parseColor((String)localHashMap.get("title_content_color")));
    }
    if (localHashMap.containsKey("title_status_immersive")) {
      this.f.setIsStatusImmersive(((Boolean)localHashMap.get("title_status_immersive")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_title_alpha")) {
      this.f.setIsNeedChangeTitleAlpha(((Boolean)localHashMap.get("title_default_title_alpha")).booleanValue());
    }
    if (localHashMap.containsKey("title_default_gray_float")) {
      this.f.setIsNeedGrayBarFloat(((Boolean)localHashMap.get("title_default_gray_float")).booleanValue());
    }
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131449906);
    this.f.setViolaGestureListener(new ViolaInitDelegate.5(this, paramViewGroup));
    this.f.setContentScrollListener(this.d);
    this.f.a(this.a.getQBaseActivity(), -1, -1, true);
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.b = paramBundle.getString("url");
      this.c = paramBundle.getString("colorBallData");
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
    this.e = ((ViewGroup)paramViewGroup.findViewById(2131449905));
    this.d = new ViolaBaseView(this.a.getQBaseActivity());
    if (!paramBoolean1) {
      this.e.addView(this.d);
    }
    this.d.setListener(paramViolaViewListener);
    this.d.setPageStartTime(System.currentTimeMillis());
    paramViewGroup = b(paramJSONObject);
    if (paramBoolean2) {
      paramViewGroup.a();
    }
    this.d.a(this.b, this.a, paramViewGroup);
    this.j.add(this.d);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((!this.f.b()) && (this.f.d()))
    {
      this.f.a(0, 4);
      return;
    }
    if (this.f.b())
    {
      this.f.f();
      this.a.getQBaseActivity().doOnBackPressed();
      if (paramBoolean) {
        this.a.getQBaseActivity().overridePendingTransition(2130772344, 2130772347);
      }
    }
    else
    {
      this.f.a(0, 4);
    }
  }
  
  public void a(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.d.a(paramViolaViewListener);
  }
  
  public void a(ViolaInitDelegate.ViolaGestureLayoutStateChangeListener paramViolaGestureLayoutStateChangeListener)
  {
    this.g = paramViolaGestureLayoutStateChangeListener;
  }
  
  public void a(String paramString)
  {
    int n = 0;
    while (n < this.j.size())
    {
      String str = ViolaUtils.getPageName(((ViolaBaseView)this.j.get(n)).a);
      if ((!TextUtils.isEmpty(str)) && (str.equals(ViolaUtils.getPageName(paramString))))
      {
        paramString = (ViolaBaseView)this.j.get(n);
        break label73;
      }
      n += 1;
    }
    paramString = null;
    label73:
    if (paramString != null) {
      paramString.a(ViolaBizUtils.d().toString());
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
      Object localObject1 = this.h;
      if (localObject1 != null) {
        ((ViewPagerCompat)localObject1).setScrollable(true);
      }
      Object localObject2 = null;
      String str = paramJSONObject.optString("url");
      int n = 0;
      int i1 = paramJSONObject.optInt("position", 0);
      for (;;)
      {
        localObject1 = localObject2;
        if (n >= this.j.size()) {
          break;
        }
        if (ViolaUtils.getPageName(str).equals(ViolaUtils.getPageName(((ViolaBaseView)this.j.get(n)).a)))
        {
          localObject1 = (ViolaBaseView)this.j.get(n);
          break;
        }
        n += 1;
      }
      if (localObject1 != null)
      {
        if (i1 != this.m)
        {
          ((ViolaBaseView)localObject1).a(ViolaBizUtils.a(paramJSONObject).toString());
          this.m = i1;
          this.l = str;
        }
      }
      else
      {
        paramJSONObject = this.a;
        if ((paramJSONObject != null) && (paramJSONObject.getQBaseActivity() != null))
        {
          paramJSONObject = new ViolaBaseView(this.a.getQBaseActivity(), Boolean.valueOf(true));
          paramJSONObject.setListener(new ViolaInitDelegate.4(this));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str);
          ((StringBuilder)localObject1).append("&firstCreated=1");
          localObject1 = ((StringBuilder)localObject1).toString();
          paramJSONObject.setPageStartTime(System.currentTimeMillis());
          paramJSONObject.a((String)localObject1, this.a, new ViolaBaseView.ViolaCreactPageObject((String)localObject1, new JSONObject(), b((String)localObject1), 0, null));
          this.j.add(paramJSONObject);
          paramJSONObject = this.i;
          if (paramJSONObject != null) {
            paramJSONObject.notifyDataSetChanged();
          }
          this.l = ((String)localObject1);
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
      c(localJSONObject.toString());
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
  
  public void b(boolean paramBoolean)
  {
    CommonSuspensionGestureLayout localCommonSuspensionGestureLayout = this.f;
    if (localCommonSuspensionGestureLayout != null) {
      localCommonSuspensionGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
  
  public void c()
  {
    ViewPagerCompat localViewPagerCompat = this.h;
    if (localViewPagerCompat != null) {
      localViewPagerCompat.setScrollable(false);
    }
  }
  
  public void c(String paramString)
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null) {
      localViolaBaseView.a(paramString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ViolaBaseView localViolaBaseView = this.d;
    if ((localViolaBaseView != null) && (localViolaBaseView.b())) {
      this.d.a(paramBoolean);
    }
  }
  
  public ViolaBaseView d()
  {
    return this.d;
  }
  
  public boolean e()
  {
    return this.h != null;
  }
  
  public void f()
  {
    if (e()) {
      return;
    }
    this.h = new ViewPagerCompat(this.a.getQBaseActivity());
    this.e.removeView(this.d);
    this.e.addView(this.h);
    this.i = new ViolaInitDelegate.2(this);
    this.h.setAdapter(this.i);
    this.h.addOnPageChangeListener(new ViolaInitDelegate.3(this));
  }
  
  public void g()
  {
    if (this.d != null)
    {
      if (e())
      {
        int n = 0;
        while (n < this.j.size())
        {
          if (ViolaUtils.getPageName(this.d.a).equals(ViolaUtils.getPageName(((ViolaBaseView)this.j.get(n)).a)))
          {
            if (this.h.getCurrentItem() != n) {
              break;
            }
            this.d.onActivityResume();
            c(true);
            return;
          }
          n += 1;
        }
      }
      this.d.onActivityResume();
      c(true);
    }
  }
  
  public void h()
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null)
    {
      localViolaBaseView.onActivityPause();
      c(false);
    }
  }
  
  public void i()
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null) {
      localViolaBaseView.onActivityDestroy();
    }
    int n = 0;
    while (n < this.j.size())
    {
      if ((this.j.get(n) instanceof ViolaBaseView)) {
        ((ViolaBaseView)this.j.get(n)).onActivityDestroy();
      }
      n += 1;
    }
    this.j.clear();
  }
  
  public boolean j()
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null) {
      return localViolaBaseView.e();
    }
    return false;
  }
  
  public void k()
  {
    ViolaBaseView localViolaBaseView = this.d;
    if (localViolaBaseView != null) {
      localViolaBaseView.d();
    }
  }
  
  public CommonSuspensionGestureLayout l()
  {
    return this.f;
  }
  
  public void m()
  {
    ViewPagerCompat localViewPagerCompat = this.h;
    if (localViewPagerCompat != null)
    {
      int n = localViewPagerCompat.getCurrentItem();
      if (n >= 1)
      {
        this.h.setCurrentItem(n - 1);
        return;
      }
    }
    if (this.a.getQBaseActivity() != null) {
      this.a.getQBaseActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaInitDelegate
 * JD-Core Version:    0.7.0.1
 */