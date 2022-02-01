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
import bmul;
import bogh;
import bogi;
import boil;
import boim;
import boio;
import bptp;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import ykv;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, bogi
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public ViewGroup a;
  public bmul a;
  private boil jdField_a_of_type_Boil;
  private CaptureModeAdapter jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
  private HashMap<Integer, boil> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bogh> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private boolean b;
  
  public CaptureModeController(bmul parambmul)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bmul = parambmul;
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Bmul.a();
  }
  
  public boio a()
  {
    boio localboio2 = (boio)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
    boio localboio1 = localboio2;
    if (localboio2 == null) {
      localboio1 = new boio(this);
    }
    return localboio1;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_Bmul.a();
    if ((localObject1 == null) || (((Activity)localObject1).isFinishing())) {
      return;
    }
    Object localObject2 = ((Activity)localObject1).getIntent().getIntegerArrayListExtra("support_intent_mode");
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(boim.a(((Integer)((Iterator)localObject2).next()).intValue())));
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
        boil localboil = boim.a(((Integer)localObject2).intValue(), this);
        if (localboil.a())
        {
          this.jdField_a_of_type_JavaUtilList.add(new bogh(((Integer)localObject2).intValue()));
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localboil);
        }
      }
      localObject1 = this.jdField_a_of_type_Bmul.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Bmul.b();
    this.jdField_a_of_type_Bmul.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Boil = ((boil)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int)));
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(7));
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(paramInt);
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364292));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      localLayoutParams.topMargin = ViewUtils.dip2px(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376983);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131376981);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)paramView.findViewById(2131364287));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bptp.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - ViewUtils.dip2px(53.0F)) / 2;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((boil)((Map.Entry)paramRelativeLayout.next()).getValue()).a(paramView);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && ((((bogh)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0) || (((bogh)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 10)))
    {
      ((ImageView)paramView.findViewById(2131364288)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bmul.m();
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131364292));
    if (paramBoolean)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout2.topMargin = ViewUtils.dip2px(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376983);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376981);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (((bogh)this.jdField_a_of_type_JavaUtilList.get(0)).a() == 0))
    {
      ((ImageView)paramView.findViewById(2131364288)).setVisibility(4);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(4);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_a_of_type_Bmul.m();
      return;
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramRelativeLayout1.topMargin = ViewUtils.dip2px(0.0F);
      paramRelativeLayout1.bottomMargin = ViewUtils.dip2px(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.jdField_a_of_type_AndroidViewViewGroup, paramRelativeLayout1);
      this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376983);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131376981);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131364288)).setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
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
        break label103;
      }
      i = j;
    }
    label103:
    for (;;)
    {
      ((ViewPager)localObject).setCurrentItem(i, false);
      return;
      bool = false;
      break;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boil.a();
  }
  
  public void c()
  {
    this.b = false;
    this.jdField_a_of_type_Boil.b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boil.c();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boil.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this.jdField_a_of_type_Int));
    if ((this.b) && (this.jdField_a_of_type_Int == 7)) {}
    bogh localbogh;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilList.size() <= 0);
      localbogh = (bogh)this.jdField_a_of_type_JavaUtilList.get(0);
    } while (this.jdField_a_of_type_Int != localbogh.a());
    onPageSelected(0);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.b(paramInt);
    bogh localbogh = (bogh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localbogh.a();
    if ((i == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.jdField_a_of_type_Int), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Boil.a(false);
    switch (this.jdField_a_of_type_Int)
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Boil = ((boil)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      int j = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Bmul.b = i;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Bmul.a(j, this.jdField_a_of_type_Boil);
      this.jdField_a_of_type_Boil.a(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      ykv.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(localbogh.a()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_a_of_type_Bmul.b(false);
      break label160;
      this.jdField_a_of_type_Bmul.f(false);
      break label160;
      this.jdField_a_of_type_Bmul.e(false);
      break label160;
      this.jdField_a_of_type_Bmul.g(false);
      break label160;
      this.jdField_a_of_type_Bmul.d(false);
      break label160;
      this.jdField_a_of_type_Bmul.b(false);
      break label160;
      this.jdField_a_of_type_Bmul.b(true);
      continue;
      this.jdField_a_of_type_Bmul.d(true);
      continue;
      this.jdField_a_of_type_Bmul.f(true);
      continue;
      this.jdField_a_of_type_Bmul.e(true);
      continue;
      this.jdField_a_of_type_Bmul.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */