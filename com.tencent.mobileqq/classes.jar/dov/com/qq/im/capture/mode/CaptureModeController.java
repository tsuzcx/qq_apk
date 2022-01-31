package dov.com.qq.im.capture.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import auvk;
import bajq;
import bcom;
import bhdi;
import bheq;
import bhes;
import bhfq;
import bhfr;
import bhht;
import bhhu;
import bhhv;
import bhhx;
import bhib;
import bhif;
import bhqy;
import bhzf;
import bhzh;
import bhzq;
import bjlo;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sgi;
import urp;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, auvk, bhfr
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bhdi a;
  private bhht jdField_a_of_type_Bhht;
  private bhzf jdField_a_of_type_Bhzf;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, bhht> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bhfq> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bhdi parambhdi)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bhdi = parambhdi;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bhdi.a();
  }
  
  public bhht a()
  {
    return this.jdField_a_of_type_Bhht;
  }
  
  public bhhx a()
  {
    if ((this.jdField_a_of_type_Bhdi instanceof bheq)) {}
    for (bhhx localbhhx1 = (bhhx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));; localbhhx1 = (bhhx)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1)))
    {
      bhhx localbhhx2 = localbhhx1;
      if (localbhhx1 == null) {
        localbhhx2 = new bhhx(this);
      }
      return localbhhx2;
    }
  }
  
  public bhib a()
  {
    bhib localbhib2 = (bhib)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    bhib localbhib1 = localbhib2;
    if (localbhib2 == null) {
      localbhib1 = new bhib(this);
    }
    return localbhib1;
  }
  
  public bhif a()
  {
    bhif localbhif2 = (bhif)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(4));
    bhif localbhif1 = localbhif2;
    if (localbhif2 == null) {
      localbhif1 = new bhif(this);
    }
    return localbhif1;
  }
  
  public bhzf a()
  {
    return this.jdField_a_of_type_Bhzf;
  }
  
  public bhzq a()
  {
    bhzq localbhzq2 = (bhzq)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(5));
    bhzq localbhzq1 = localbhzq2;
    if (localbhzq2 == null) {
      localbhzq1 = new bhzq(this);
    }
    return localbhzq1;
  }
  
  public void a()
  {
    Object localObject2 = this.jdField_a_of_type_Bhdi.a().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(bhhv.a(((Integer)((Iterator)localObject2).next()).intValue())));
      }
    }
    long l;
    for (;;)
    {
      l = System.currentTimeMillis();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        bhht localbhht = bhhv.a(((Integer)localObject2).intValue(), this);
        if (localbhht.b())
        {
          this.jdField_a_of_type_JavaUtilList.add(new bhfq(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localbhht);
        }
      }
      localObject1 = this.jdField_a_of_type_Bhdi.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bhdi.d();
    if ((this.jdField_a_of_type_Int == 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5)))) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Bhdi.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bhht = ((bhht)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131298335));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = bajq.a(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131309768);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131309766);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131298330));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bjlo.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bajq.a(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((bhht)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    paramBoolean = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(5));
    boolean bool = this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Bhzf = new bhzf();
      this.jdField_a_of_type_Bhzf.a();
      if ((this.jdField_a_of_type_Bhdi.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_a_of_type_Bhdi.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.a == null) {
          break label527;
        }
        sgi.a().dispatch(new bhzh(2, true));
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((bhfq)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((bhfq)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
      {
        ((ImageView)paramView.findViewById(2131298331)).setVisibility(4);
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        this.jdField_a_of_type_Bhdi.x();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new bhhu(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131298335));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = bajq.a(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131309768);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131309766);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((bhfq)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131298331)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bhdi.x();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = bajq.a(0.0F);
      paramRelativeLayout1.bottomMargin = bajq.a(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131309768);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131309766);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131298331)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    if (bcom.b.get()) {
      sgi.a().dispatch(new bhzh(1, paramBoolean));
    }
    sgi.a().dispatch(new bhzh(3, true));
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bhht.c();
  }
  
  public void b(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_a_of_type_Bhdi instanceof bheq))
    {
      if ((this.jdField_a_of_type_Bhdi instanceof bhes)) {
        paramBoolean = false;
      }
      ((bheq)this.jdField_a_of_type_Bhdi).a.setEnableSegment(paramBoolean);
      return;
    }
    int i = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(0);
    int j = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(1);
    Object localObject = this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
    if (!paramBoolean)
    {
      ((CaptureModeAdapter)localObject).a(i, bool);
      this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(j, paramBoolean);
      localObject = this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
      if (!paramBoolean) {
        break label140;
      }
      i = j;
    }
    label140:
    for (;;)
    {
      ((ViewPager)localObject).setCurrentItem(i, false);
      return;
      bool = false;
      break;
    }
  }
  
  public void c()
  {
    this.b = false;
    this.jdField_a_of_type_Bhht.d();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.getTranslationY() != 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.a(this.jdField_a_of_type_AndroidViewViewGroup, null);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationY(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(1.0F);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bhht.e();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.getTranslationY() == 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.b(this.jdField_a_of_type_AndroidViewViewGroup, null);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setTranslationY(this.jdField_a_of_type_AndroidViewViewGroup.getHeight());
    this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Bhht.f();
    if (this.jdField_a_of_type_Bhzf != null)
    {
      this.jdField_a_of_type_Bhzf.b();
      this.jdField_a_of_type_Bhzf = null;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    bhfq localbhfq;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localbhfq = (bhfq)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localbhfq.a());
    onPageSelected(0);
  }
  
  public void g()
  {
    Object localObject = a();
    if ((localObject != null) && (((bhib)localObject).b != null)) {
      ((bhib)localObject).b.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((bhif)localObject).a != null)) {
      ((bhif)localObject).a.a().bringToFront();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt);
  }
  
  @Deprecated
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.b(paramInt);
    bhfq localbhfq = (bhfq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localbhfq.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Bhht.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Bhht = ((bhht)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bhdi.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bhdi.a(j, this.jdField_a_of_type_Bhht);
      this.jdField_a_of_type_Bhht.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      urp.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localbhfq.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bhdi.a(false, true);
      break label160;
      this.jdField_a_of_type_Bhdi.d(false);
      break label160;
      this.jdField_a_of_type_Bhdi.h(false);
      break label160;
      this.jdField_a_of_type_Bhdi.g(false);
      break label160;
      this.jdField_a_of_type_Bhdi.i(false);
      break label160;
      this.jdField_a_of_type_Bhdi.f(false);
      break label160;
      this.jdField_a_of_type_Bhdi.d(false);
      break label160;
      this.jdField_a_of_type_Bhdi.a(true, true);
      continue;
      this.jdField_a_of_type_Bhdi.d(true);
      continue;
      this.jdField_a_of_type_Bhdi.f(true);
      continue;
      this.jdField_a_of_type_Bhdi.h(true);
      continue;
      this.jdField_a_of_type_Bhdi.g(true);
      continue;
      this.jdField_a_of_type_Bhdi.i(true);
      continue;
      this.jdField_a_of_type_Bhdi.d(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */