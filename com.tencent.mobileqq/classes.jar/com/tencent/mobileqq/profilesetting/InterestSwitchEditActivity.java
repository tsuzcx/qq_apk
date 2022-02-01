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
import anvk;
import bafg;
import bafh;
import bafl;
import bafn;
import bafp;
import bafq;
import bafr;
import bafs;
import baft;
import bafu;
import bagn;
import bagq;
import bagr;
import bdla;
import birs;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vit;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private LinearLayoutManager jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager = new bafr(this, this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private bafl jdField_a_of_type_Bafl;
  private bafn jdField_a_of_type_Bafn = new bafp(this);
  private baft jdField_a_of_type_Baft;
  private bafu jdField_a_of_type_Bafu = new bafq(this);
  private birs jdField_a_of_type_Birs;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ArrayList<bagn> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private int a(bagn parambagn)
  {
    if (parambagn == null) {
      return -1;
    }
    switch (parambagn.b())
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
    int i = 1;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = bagq.a.a(42505, this.jdField_a_of_type_JavaUtilArrayList);
      int j = bagq.a.a(42505, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.app);
      if (localObject != null)
      {
        localObject = this.app;
        if (j != 1) {
          break label78;
        }
      }
    }
    for (;;)
    {
      bdla.b((QQAppInterface)localObject, "dc00898", "", "", "0X800B5F0", "0X800B5F0", i, 0, "", "", "", "");
      return;
      label78:
      i = 2;
    }
  }
  
  private void a(int paramInt, bagn parambagn)
  {
    int i = a(parambagn);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", i, 0, "", "", "", "");
      return;
    case 1: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", i, 0, "", "", "", "");
      return;
    }
    bdla.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", i, 0, "", "", "", "");
  }
  
  private void a(bagn parambagn)
  {
    QQAppInterface localQQAppInterface;
    int i;
    switch (parambagn.b())
    {
    default: 
    case 42172: 
    case 42128: 
    case 42425: 
      do
      {
        return;
        if (parambagn.b())
        {
          bdla.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
          return;
        }
        bdla.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
        return;
        localQQAppInterface = this.app;
        if (parambagn.b()) {}
        for (i = 1;; i = 2)
        {
          bdla.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
          return;
        }
      } while (parambagn.b());
      bdla.b(this.app, "dc00898", "", "", "0X800B479", "0X800B479", 0, 0, "", "", "", "");
      return;
    case 42340: 
      localQQAppInterface = this.app;
      if (parambagn.b()) {}
      for (i = 1;; i = 2)
      {
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
        return;
      }
    case 42356: 
      bdla.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    }
    vit.b(parambagn.b());
  }
  
  private void a(bagn parambagn, int paramInt)
  {
    if ((parambagn != null) && (parambagn.b() != -1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ReqSetSettingItem(parambagn.b(), parambagn.e(), paramInt));
      parambagn.c(paramInt);
      parambagn.a(true);
      this.jdField_a_of_type_Bafl.b(localArrayList);
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Baft.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void b(bagn parambagn)
  {
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131561375, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    bafg localbafg = new bafg(this, parambagn);
    localbafg.a(new bafs(this, parambagn, localbkzi));
    parambagn = new ArrayList();
    parambagn.add(new bafh(0, getString(2131694858)));
    parambagn.add(new bafh(1, getString(2131694875)));
    parambagn.add(new bafh(2, getString(2131694876)));
    localbafg.a(parambagn);
    localRecyclerView.setAdapter(localbafg);
    localbkzi.a(localRecyclerView);
    localbkzi.c(2131690697);
    localbkzi.b(true);
    if (!isFinishing()) {
      localbkzi.show();
    }
  }
  
  private void c()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bagn localbagn = (bagn)localIterator.next();
      if (localbagn.b() != -1) {
        localArrayList.add(Integer.valueOf(localbagn.b()));
      }
    }
    this.jdField_a_of_type_Bafl.a(localArrayList);
  }
  
  private void c(bagn parambagn)
  {
    switch (parambagn.b())
    {
    default: 
      return;
    case 41611: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
      return;
    case 41610: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
      return;
    case 41607: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
      return;
    case 41609: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
      return;
    case 41618: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
      return;
    case 41619: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
      return;
    case 41614: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
      return;
    case 41613: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
      return;
    case 41622: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
      return;
    case 41623: 
      bdla.b(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
      return;
    }
    bdla.b(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561374);
    this.app.addObserver(this.jdField_a_of_type_Bafn);
    setTitle(getString(2131694831));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)findViewById(2131363431));
    this.jdField_a_of_type_Baft = new baft(this, this.jdField_a_of_type_Bafu);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Baft);
    this.jdField_a_of_type_Birs = new birs(this.app, null);
    vit.a(this.jdField_a_of_type_Birs.a(11));
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.app.getCurrentUin());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    bagq.a.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_Birs, this.jdField_a_of_type_JavaUtilArrayList);
    a();
    boolean bool = bagq.a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bafl = ((bafl)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER));
    if (bool)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        break label277;
      }
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      b();
      if (QLog.isColorLevel()) {
        QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate needReq=%s items=%s", new Object[] { Boolean.valueOf(bool), this.jdField_a_of_type_JavaUtilArrayList }));
      }
      return true;
      label277:
      c();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Birs != null)
    {
      this.jdField_a_of_type_Birs.a();
      this.jdField_a_of_type_Birs = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Bafn);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    vit.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    vit.a();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(bagq.a.b(this.jdField_a_of_type_JavaUtilArrayList)));
    bagn localbagn = bagq.a.a(42377, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localbagn != null) && (localbagn.a()) && (localbagn.b())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localbagn = bagq.a.a(42128, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localbagn != null) && (localbagn.a())) {
      localIntent.putExtra("key_personality_label_switch", localbagn.b());
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