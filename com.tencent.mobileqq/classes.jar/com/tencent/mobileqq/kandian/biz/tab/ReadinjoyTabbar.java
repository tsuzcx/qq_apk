package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar;
import com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.TabHolder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.skin.BaseSkinRes;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyFragmentFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoyTabbar
  extends BaseTabbar
{
  protected QQAppInterface a;
  private ReadInJoyNewFeedsActivity jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity = null;
  protected KandianMergeManager a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  private ConcurrentHashMap<Integer, ReadinjoyTabbar.Tab> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private BubblePopupWindow b = null;
  
  public ReadinjoyTabbar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadinjoyTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static BubblePopupWindow a(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      int[] arrayOfInt = new int[2];
      paramView1.getLocationOnScreen(arrayOfInt);
      return a(paramView1, paramView2, arrayOfInt[0] + paramView1.getMeasuredWidth() / 2, arrayOfInt[1]);
    }
    return null;
  }
  
  private static BubblePopupWindow a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    try
    {
      BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
      localBubblePopupWindow.setContentView(paramView2);
      localBubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      localBubblePopupWindow.setTouchable(false);
      localBubblePopupWindow.setFocusable(false);
      localBubblePopupWindow.setSoftInputMode(1);
      localBubblePopupWindow.setInputMethodMode(2);
      localBubblePopupWindow.showAtLocation(paramView1, paramInt1, paramInt2);
      return localBubblePopupWindow;
    }
    catch (Exception paramView1)
    {
      QLog.d("TabBarView", 1, "showAtLocation", paramView1);
    }
    return null;
  }
  
  private void a()
  {
    setUnselectColor(-8947849);
    setTabTextSize(17);
    setBackgroundDrawable(new ColorDrawable(0));
    setTabHeight(AIOUtils.b(65.0F, getResources()));
    setUnderLineHeight(AIOUtils.b(6.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    setSelectColor(((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8).a());
  }
  
  private void a(int paramInt, Object paramObject, View paramView)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return;
      }
      b(paramView);
      return;
    }
    a(paramView);
  }
  
  private void a(View paramView)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "showVideoBubbleTips()");
    }
    localObject = paramView.getContext();
    RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject);
    TextView localTextView = new TextView((Context)localObject);
    localTextView.setText(HardCodeUtil.a(2131712703));
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 16.0F);
    localTextView.setGravity(17);
    int i = DisplayUtil.a((Context)localObject, 10.0F);
    localTextView.setPadding(i, 0, i, 0);
    localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = a(paramView, localRelativeLayout);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissVideoBubbleTips()");
    }
    BubblePopupWindow localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      return;
    }
    localObject = this.b;
    if ((localObject != null) && (((BubblePopupWindow)localObject).isShowing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "showSelfBubbleTips()");
    }
    Context localContext = paramView.getContext();
    RelativeLayout localRelativeLayout = new RelativeLayout(localContext);
    TextView localTextView = new TextView(localContext);
    localTextView.setId(2131376053);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(1, 16.0F);
    localTextView.setGravity(17);
    int i = DisplayUtil.a(localContext, 10.0F);
    localTextView.setPadding(i, 0, i, 0);
    long l = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.c();
    i = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.b(3);
    if (i <= 0) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131712808));
    localTextView.setText(((StringBuilder)localObject).toString());
    localObject = ImageUtil.f();
    if (l != -1L) {
      localObject = FaceDrawable.getFaceDrawable((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 1, Long.toString(l), 3, (Drawable)localObject, (Drawable)localObject);
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.getApplicationContext().getResources().getDrawable(2130843112);
    }
    ((Drawable)localObject).setBounds(0, 0, DisplayUtil.a(localContext, 25.0F), DisplayUtil.a(localContext, 25.0F));
    localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    localRelativeLayout.addView(localTextView, new RelativeLayout.LayoutParams(-2, -2));
    localRelativeLayout.setOnClickListener(new ReadinjoyTabbar.3(this));
    this.b = a(paramView, localRelativeLayout);
    paramView = this.b;
    if (paramView != null)
    {
      paramView.setTouchable(true);
      this.b.setOutsideTouchable(true);
      this.b.update();
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabBarView", 2, "dimissSelfBubbleTips()");
    }
    BubblePopupWindow localBubblePopupWindow = this.b;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {}
    try
    {
      this.b.dismiss();
      this.b = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public BaseTabbar.TabHolder a(int paramInt, String paramString)
  {
    paramString = super.a(paramInt, paramString);
    ReadinjoyTabbar.Tab localTab = new ReadinjoyTabbar.Tab();
    localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment = null;
    localTab.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localTab);
    return paramString;
  }
  
  public ReadInJoyBaseFragment a(ReadinjoyTabbar.Tab paramTab)
  {
    if (paramTab == null) {
      return null;
    }
    return paramTab.a();
  }
  
  public ReadinjoyTabbar.Tab a(int paramInt)
  {
    return (ReadinjoyTabbar.Tab)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, View paramView)
  {
    if (paramInt != 1)
    {
      if (paramInt != 3) {
        return;
      }
      c();
      return;
    }
    b();
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt != 2;
  }
  
  public int b()
  {
    BubblePopupWindow localBubblePopupWindow = this.b;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      return 3;
    }
    localBubblePopupWindow = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if ((localBubblePopupWindow != null) && (localBubblePopupWindow.isShowing())) {
      return 1;
    }
    return -1;
  }
  
  public void b(int paramInt)
  {
    ReadinjoyTabbar.Tab localTab = (ReadinjoyTabbar.Tab)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    localTab.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.a.post(new ReadinjoyTabbar.2(this, paramInt, localTab));
  }
  
  public void setCurrentActivity(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity = paramReadInJoyNewFeedsActivity;
  }
  
  public void setSelection(int paramInt1, int paramInt2, FragmentManager paramFragmentManager, Intent paramIntent, int paramInt3, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        paramIntent = a(paramInt2);
        ReadinjoyTabbar.Tab localTab = a(paramInt1);
        if ((paramInt1 == paramInt2) && (a(localTab) != null) && (paramInt3 == 256))
        {
          localTab.a().f();
          setTabState(paramInt1, false);
          return;
        }
        if (paramInt3 != 256) {
          setSelectedTab(paramInt1, true, true);
        }
        paramFragmentManager = paramFragmentManager.beginTransaction();
        if (paramInt1 < paramInt2) {
          paramFragmentManager.setCustomAnimations(2130772357, 2130772360);
        } else if (paramInt1 > paramInt2) {
          if ((paramBundle != null) && (paramBundle.getBoolean("READINJOY_VIDEO_FORCE_INSERT_SET_SELECTION", false))) {
            paramFragmentManager.setCustomAnimations(2130772367, 2130772368);
          } else {
            paramFragmentManager.setCustomAnimations(2130772359, 2130772361);
          }
        }
        if ((paramIntent != null) && (paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment != null) && (paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment == this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.a()))
        {
          paramFragmentManager.hide(paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment);
          paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment.e();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.a() != localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment)) {
          paramFragmentManager.hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.a());
        }
        if (localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment == null)
        {
          localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment = ReadInJoyFragmentFactory.a(paramInt1);
          ReadInJoyBaseFragment localReadInJoyBaseFragment = localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
          if (localReadInJoyBaseFragment == null) {
            return;
          }
        }
        if (!localTab.jdField_a_of_type_Boolean) {
          paramFragmentManager.add(2131365178, localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment, String.valueOf(paramInt1));
        }
        paramFragmentManager.show(localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment);
        paramFragmentManager.commitAllowingStateLoss();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity.a(localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment);
        if (paramInt3 == 258) {
          localTab.a().a(paramBundle);
        }
        if (paramInt3 == 257)
        {
          paramFragmentManager = localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
          if (localTab.jdField_a_of_type_Boolean) {
            break label492;
          }
          bool = true;
          paramFragmentManager.a(bool, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity, paramBundle);
        }
        else
        {
          paramFragmentManager = localTab.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment;
          if (localTab.jdField_a_of_type_Boolean) {
            break label498;
          }
          bool = true;
          paramFragmentManager.a(bool, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsActivityReadInJoyNewFeedsActivity, null);
        }
        if (!localTab.jdField_a_of_type_Boolean) {
          localTab.jdField_a_of_type_Boolean = true;
        }
        a(paramInt2, paramInt1);
        if (((ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() == 0)
        {
          if (!paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.a()) {
            paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.a(true, false);
          }
          if (localTab.b) {
            localTab.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.a(false, false);
          }
        }
        else
        {
          AbstractGifImage.resumeAll();
        }
        return;
      }
      finally {}
      label492:
      boolean bool = false;
      continue;
      label498:
      bool = false;
    }
  }
  
  public void setTabState(int paramInt, boolean paramBoolean)
  {
    Object localObject = (ReadInJoySkinManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if ((paramBoolean) && (((ReadInJoySkinManager)localObject).a() != 0)) {
      return;
    }
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTabState type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" isRefreshState:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TabBarView", 4, ((StringBuilder)localObject).toString());
    }
    localObject = a(paramInt);
    ((ReadinjoyTabbar.Tab)localObject).b = paramBoolean;
    ((ReadinjoyTabbar.Tab)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetBaseTabbar$TabHolder.a(((ReadinjoyTabbar.Tab)localObject).b ^ true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar
 * JD-Core Version:    0.7.0.1
 */