package dov.com.qq.im.capture.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.qq.im.capture.data.TemplateGroupItem;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class QIMPtvTemplateProviderView
  extends ProviderView
  implements ViewPager.OnPageChangeListener, ViewTreeObserver.OnScrollChangedListener, Observer, QIMSlidingTabView.IOnTabCheckListener
{
  int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  QIMPtvTemplateViewPagerAdapter jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter;
  private TemplateGroupItem jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem = null;
  public CaptureConfigUpdateObserver a;
  QIMPtvTemplateManager jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager;
  List<TemplateGroupItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  private boolean jdField_b_of_type_Boolean = true;
  private View c = null;
  private boolean e;
  private boolean f = false;
  private boolean g;
  
  public QIMPtvTemplateProviderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver = new QIMPtvTemplateProviderView.1(this);
    this.jdField_g_of_type_Boolean = false;
  }
  
  private ArrayList<QIMSlidingTabView.TabIcon> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {}
    for (int i = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a();; i = -1)
    {
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        TemplateGroupItem localTemplateGroupItem = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(j);
        if ((i != -1) && (i == localTemplateGroupItem.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Int = j;
        }
        QIMSlidingTabView.TabIcon localTabIcon = new QIMSlidingTabView.TabIcon();
        localTabIcon.jdField_a_of_type_JavaLangString = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
        localArrayList.add(localTabIcon);
        j += 1;
      }
      return localArrayList;
    }
  }
  
  protected int a()
  {
    return 2131561019;
  }
  
  public String a()
  {
    return "PtvTemplateProviderView";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a("0", 0, "");
      QIMPtvTemplateAdapter.c = 0;
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(null);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(111);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(113);
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(112);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    }
    super.a();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("selectCategoryAndItem");
      ((StringBuilder)localObject).append("  category=").append(paramInt);
      ((StringBuilder)localObject).append(", categoryName=").append(paramString1);
      ((StringBuilder)localObject).append(", itemId=").append(paramString2);
      ((StringBuilder)localObject).append(", mTabListSize=").append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("PtvTemplateProviderView", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if ((paramInt != -1) && (((TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramInt)) {
        paramInt = i;
      }
    }
    for (;;)
    {
      label130:
      a().onTabChecked(paramInt);
      localObject = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
      i = 0;
      label162:
      if (i < ((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.size())
      {
        paramString1 = (PtvTemplateManager.PtvTemplateInfo)((TemplateGroupItem)localObject).jdField_a_of_type_JavaUtilList.get(i);
        if (!paramString1.id.equals(paramString2)) {}
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, "itemInfo= " + paramString1 + ",index=" + paramInt + ",pos=" + i);
        }
        if (paramString1 != null)
        {
          if (paramString1.isWsBanner()) {
            WeishiGuideUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString1);
          }
        }
        else
        {
          return;
          if ((paramString1 != null) && (paramString1.equals(((TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString)))
          {
            paramInt = i;
            break label130;
          }
          i += 1;
          break;
          i += 1;
          break label162;
        }
        postDelayed(new QIMPtvTemplateProviderView.2(this, paramString1), 200L);
        return;
        i = 0;
        paramString1 = null;
      }
      paramInt = 0;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561019, this, false);
    }
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131381588));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter = new QIMPtvTemplateViewPagerAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener, this.jdField_g_of_type_Int);
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager = ((QIMPtvTemplateManager)QIMManager.a(3));
    this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getViewTreeObserver().addOnScrollChangedListener(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_DovComQqImCaptureMusicCaptureConfigUpdateObserver);
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.d) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(paramBoolean);
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null)
        {
          if (this.jdField_b_of_type_Boolean) {
            break label362;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          TemplateGroupItem localTemplateGroupItem1 = this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(i);
          if (localTemplateGroupItem1 == null) {
            break label362;
          }
          i = 0;
          label81:
          if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
            break label362;
          }
          TemplateGroupItem localTemplateGroupItem2 = (TemplateGroupItem)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localTemplateGroupItem2 == null) || (TextUtils.isEmpty(localTemplateGroupItem2.jdField_a_of_type_JavaLangString)) || (!localTemplateGroupItem2.jdField_a_of_type_JavaLangString.equals(localTemplateGroupItem1.jdField_a_of_type_JavaLangString))) {
            break label346;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter != null) {
        this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null)
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.initTabItemsWithRedDot(a());
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.setTabCheckListener(this);
      }
      j = i;
      if (i >= this.jdField_a_of_type_JavaUtilList.size())
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("PtvTemplateProviderView", 2, "resetPos " + i + " not exist, mTabList size = " + this.jdField_a_of_type_JavaUtilList.size());
          j = 0;
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(j);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(j);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView == null) {
        break;
      }
      i = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
      if (this.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        i();
        return;
        label346:
        i += 1;
        break label81;
      }
      if (i == 0) {
        break;
      }
      h();
      return;
      label362:
      i = j;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      localObject = getContext().getSharedPreferences(RedBagVideoManager.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4);
      if (!((SharedPreferences)localObject).getBoolean(paramInt1 + "&" + paramInt2, false)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, already shown, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
      }
      return true;
    }
    if (((SharedPreferences)localObject).contains(String.valueOf(paramInt1)))
    {
      if (((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), 0) > paramInt2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, exist high version, id:", Integer.valueOf(paramInt1), " tipver:", Integer.valueOf(paramInt2) });
        }
        return true;
      }
      ((SharedPreferences)localObject).edit().remove(String.valueOf(paramInt1)).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, checkTipsLayoutShown, not shown, id: ", Integer.valueOf(paramInt1), " tipver: ", Integer.valueOf(paramInt2) });
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener != null)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null, "");
      this.jdField_a_of_type_DovComQqImCaptureViewProviderView$ProviderViewListener.a(null);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a("0", 0, "");
      QIMPtvTemplateAdapter.c = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onClear");
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateProviderView", 2, "onProviderShow isAccountChange=" + this.jdField_a_of_type_Boolean + " isInit=" + d());
    }
    if ((d()) && (this.jdField_a_of_type_Boolean))
    {
      g();
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    a(false);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.removeAllViews();
    }
    if (this.jdField_g_of_type_Boolean) {
      h();
    }
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "random tab template onResume");
    }
    if ((QIMPtvTemplateAdapter.jdField_b_of_type_Int == 0) && (QIMPtvTemplateAdapter.jdField_b_of_type_JavaLangString.equals("0"))) {}
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.c();
    }
  }
  
  public void g()
  {
    a(true);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.c = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem != null) {
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
          break label192;
        }
      }
    }
    label192:
    for (Object localObject = BaseApplicationImpl.sApplication.getRuntime();; localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface)
    {
      String str = this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Int + "&" + this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_b_of_type_Int;
      localObject = getContext().getSharedPreferences(RedBagVideoManager.jdField_b_of_type_JavaLangString + ((AppRuntime)localObject).getAccount(), 4).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str, true);
      ((SharedPreferences.Editor)localObject).putInt(String.valueOf(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Int), this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_b_of_type_Int);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public void i()
  {
    int i;
    label35:
    int j;
    int m;
    int i2;
    int k;
    label238:
    RelativeLayout.LayoutParams localLayoutParams;
    label340:
    int n;
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i1;
        QIMSlidingTabView localQIMSlidingTabView;
        Context localContext;
        label541:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PtvTemplateProviderView", 2, new Object[] { "VideoRedbag, showTipsLayout ", localException.getMessage() });
        continue;
      }
      finally {}
      return;
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(false);
        i = 0;
        if (i < ((ArrayList)localObject1).size())
        {
          this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem = ((TemplateGroupItem)((ArrayList)localObject1).get(i));
          if ((this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_b_of_type_JavaLangString == null) || (a(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_b_of_type_Int))) {
            break label955;
          }
          this.jdField_b_of_type_Int = i;
        }
        if ((this.jdField_b_of_type_Int != -1) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getmTabItemList().size() > this.jdField_b_of_type_Int)) {
          this.c = ((View)this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getmTabItemList().get(this.jdField_b_of_type_Int));
        }
      }
      if ((this.c != null) && (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem != null))
      {
        i = this.c.getLeft();
        j = this.c.getRight();
        m = this.c.getWidth();
        if ((i != 0) || (j != 0))
        {
          i2 = ViewUtils.a();
          i1 = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
          j = m / 2 + i - i1;
          k = AIOUtils.a(30.0F, getContext().getResources());
          if ((j <= 0) || (j + k >= i2)) {
            break label962;
          }
          j = 1;
          this.jdField_g_of_type_Boolean = true;
          if ((this.jdField_a_of_type_AndroidWidgetTextView == null) && (j != 0) && (this.jdField_e_of_type_Int == 2))
          {
            if ((this.jdField_b_of_type_AndroidViewView == null) || (!(this.jdField_b_of_type_AndroidViewView instanceof RelativeLayout))) {
              continue;
            }
            localObject1 = this.jdField_b_of_type_AndroidViewView;
            localQIMSlidingTabView = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView;
            localContext = getContext();
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localContext);
            this.jdField_a_of_type_AndroidWidgetImageView.setId(2131378051);
            if (!this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Boolean) {
              break label967;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850139);
            localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(20.0F, localContext.getResources()), AIOUtils.a(10.0F, localContext.getResources()));
            localLayoutParams.addRule(2, localQIMSlidingTabView.getId());
            localLayoutParams.addRule(9);
            localLayoutParams.leftMargin = (m / 2 + i - AIOUtils.a(20.0F, localContext.getResources()) / 2);
            localLayoutParams.bottomMargin = 5;
            ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(localContext);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_b_of_type_JavaLangString);
            k = AIOUtils.a(5.0F, localContext.getResources());
            n = AIOUtils.a(5.0F, localContext.getResources());
            if (!this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Boolean) {
              break label980;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FBD49D"));
            this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850141);
            this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(30.0F, localContext.getResources()), k, n, k);
            this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
            this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
            this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
            this.jdField_a_of_type_AndroidWidgetTextView.measure(-2, -2);
            k = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
            if (!this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Boolean) {
              break label1028;
            }
            k += AIOUtils.a(17.0F, localContext.getResources());
          }
        }
      }
    }
    label1028:
    for (;;)
    {
      m = m / 2 + i - k / 2;
      n = i2 - m - k;
      i = 16;
      if ((n >= 16) || (k + 32 >= i2)) {
        break label1047;
      }
      if (n >= 16) {
        break label1041;
      }
      break label1031;
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131378051);
      localLayoutParams.addRule(9);
      if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Boolean) {
        localLayoutParams.setMargins(AIOUtils.a(17.0F, localContext.getResources()) + k, 0, i, 0);
      }
      for (;;)
      {
        ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
        if (this.jdField_a_of_type_DovComQqImCaptureDataTemplateGroupItem.jdField_a_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(localContext);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850142);
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, localQIMSlidingTabView.getId());
          localLayoutParams.addRule(9);
          localLayoutParams.leftMargin = k;
          localLayoutParams.bottomMargin = AIOUtils.a(3.0F, localContext.getResources());
          ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidWidgetImageView, localLayoutParams);
        }
        if ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (j == 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTranslationX(-i1);
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(-i1);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageView == null) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setTranslationX(-i1);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        label955:
        i += 1;
        break label35;
        label962:
        j = 0;
        break label238;
        label967:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850138);
        break label340;
        label980:
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850140);
        this.jdField_a_of_type_AndroidWidgetTextView.setPadding(n, k, n, k);
        break label541;
        localLayoutParams.setMargins(k, 0, i, 0);
      }
    }
    for (;;)
    {
      label1031:
      k = i2 - i - k;
      break;
      label1041:
      i = n;
    }
    label1047:
    if (m < 16) {}
    for (;;)
    {
      m = i2 - i - k;
      k = i;
      i = m;
      break;
      i = m;
    }
  }
  
  public void notify(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 114) || (paramVarArgs == null) || (paramVarArgs.length != 1)) {
      return;
    }
    h();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.onTabChecked(paramInt);
    h();
  }
  
  public void onScrollChanged()
  {
    int i = this.jdField_a_of_type_DovComQqImCaptureViewQIMSlidingTabView.getScrollX();
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      i();
    }
    while (i == 0) {
      return;
    }
    h();
  }
  
  @TargetApi(9)
  public void onTabChecked(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    i();
  }
  
  public void setGIFMode(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView
 * JD-Core Version:    0.7.0.1
 */