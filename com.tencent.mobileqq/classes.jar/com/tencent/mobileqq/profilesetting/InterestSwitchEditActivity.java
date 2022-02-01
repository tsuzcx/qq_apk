package com.tencent.mobileqq.profilesetting;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import anyw;
import bajs;
import bajt;
import bajx;
import bajz;
import bakb;
import bakc;
import bakd;
import bake;
import bakf;
import bakg;
import bakz;
import balc;
import bald;
import bdll;
import bhnv;
import bjaz;
import blir;
import blji;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import umm;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private LinearLayoutManager jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager = new bakd(this, this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private bajx jdField_a_of_type_Bajx;
  private bajz jdField_a_of_type_Bajz = new bakb(this);
  private bakf jdField_a_of_type_Bakf;
  private bakg jdField_a_of_type_Bakg = new bakc(this);
  private bjaz jdField_a_of_type_Bjaz;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ArrayList<bakz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private int a(bakz parambakz)
  {
    if (parambakz == null) {
      return -1;
    }
    switch (parambakz.b())
    {
    default: 
      return -1;
    case 40272: 
      return 6;
    case 41611: 
      return 1;
    case 41610: 
      return 2;
    case 41609: 
      return 3;
    case 41619: 
      return 4;
    case 41618: 
      return 5;
    case 41614: 
      return 7;
    case 41613: 
      return 8;
    case 41622: 
      return 9;
    case 41623: 
      return 10;
    }
    return 11;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, InterestSwitchEditActivity.class);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bakf.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void a(int paramInt, bakz parambakz)
  {
    int i = a(parambakz);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", i, 0, "", "", "", "");
      return;
    case 1: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", i, 0, "", "", "", "");
      return;
    }
    bdll.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", i, 0, "", "", "", "");
  }
  
  private void a(bakz parambakz)
  {
    QQAppInterface localQQAppInterface;
    int i;
    switch (parambakz.b())
    {
    default: 
      return;
    case 42172: 
      if (parambakz.b())
      {
        bdll.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
        return;
      }
      bdll.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
    case 42128: 
      localQQAppInterface = this.app;
      if (parambakz.b()) {}
      for (i = 1;; i = 2)
      {
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
        return;
      }
    case 42340: 
      localQQAppInterface = this.app;
      if (parambakz.b()) {}
      for (i = 1;; i = 2)
      {
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
        return;
      }
    case 42356: 
      bdll.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    }
    umm.b(parambakz.b());
  }
  
  private void a(bakz parambakz, int paramInt)
  {
    if ((parambakz != null) && (parambakz.b() != -1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ReqSetSettingItem(parambakz.b(), parambakz.e(), paramInt));
      parambakz.c(paramInt);
      parambakz.a(true);
      this.jdField_a_of_type_Bajx.b(localArrayList);
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bakz localbakz = (bakz)localIterator.next();
      if (localbakz.b() != -1) {
        localArrayList.add(Integer.valueOf(localbakz.b()));
      }
    }
    this.jdField_a_of_type_Bajx.a(localArrayList);
  }
  
  private void b(bakz parambakz)
  {
    blir localblir = (blir)blji.a(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131561430, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    bajs localbajs = new bajs(this, parambakz);
    localbajs.a(new bake(this, parambakz, localblir));
    parambakz = new ArrayList();
    parambakz.add(new bajt(0, getString(2131694542)));
    parambakz.add(new bajt(1, getString(2131694557)));
    parambakz.add(new bajt(2, getString(2131694558)));
    localbajs.a(parambakz);
    localRecyclerView.setAdapter(localbajs);
    localblir.a(localRecyclerView);
    localblir.c(2131690580);
    localblir.b(true);
    if (!isFinishing()) {
      localblir.show();
    }
  }
  
  private void c(bakz parambakz)
  {
    switch (parambakz.b())
    {
    default: 
      return;
    case 41611: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
      return;
    case 41610: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
      return;
    case 41607: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
      return;
    case 41609: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
      return;
    case 41618: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
      return;
    case 41619: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
      return;
    case 41614: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
      return;
    case 41613: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
      return;
    case 41622: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
      return;
    case 41623: 
      bdll.b(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561429);
    this.app.addObserver(this.jdField_a_of_type_Bajz);
    setTitle(getString(2131694515));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)findViewById(2131363332));
    this.jdField_a_of_type_Bakf = new bakf(this, this.jdField_a_of_type_Bakg);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bakf);
    this.jdField_a_of_type_Bjaz = new bjaz(this.app, null);
    umm.a(this.jdField_a_of_type_Bjaz.a(11));
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((anyw)this.app.getManager(51)).c(this.app.c());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    balc.a.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_Bjaz, this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool = balc.a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bajx = ((bajx)this.app.a(182));
    if (bool)
    {
      if (bhnv.d(BaseApplication.getContext())) {
        break label272;
      }
      QQToast.a(BaseApplicationImpl.sApplication, 2131693963, 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate needReq=%s items=%s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_JavaUtilArrayList }));
      }
      return true;
      label272:
      b();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Bjaz != null)
    {
      this.jdField_a_of_type_Bjaz.a();
      this.jdField_a_of_type_Bjaz = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Bajz);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    umm.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    umm.a();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(balc.a.b(this.jdField_a_of_type_JavaUtilArrayList)));
    bakz localbakz = balc.a.a(42377, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localbakz != null) && (localbakz.a()) && (localbakz.b())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localbakz = balc.a.a(42128, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localbakz != null) && (localbakz.a())) {
      localIntent.putExtra("key_personality_label_switch", localbakz.b());
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */