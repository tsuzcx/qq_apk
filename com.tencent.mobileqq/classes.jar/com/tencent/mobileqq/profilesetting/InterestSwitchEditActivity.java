package com.tencent.mobileqq.profilesetting;

import Override;
import amsw;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ayzs;
import ayzt;
import ayzx;
import ayzz;
import azab;
import azac;
import azad;
import azae;
import azaf;
import azag;
import azaz;
import azbc;
import azbd;
import bcef;
import bhha;
import bjnw;
import bjon;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import uug;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private LinearLayoutManager jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager = new azad(this, this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private ayzx jdField_a_of_type_Ayzx;
  private ayzz jdField_a_of_type_Ayzz = new azab(this);
  private azaf jdField_a_of_type_Azaf;
  private azag jdField_a_of_type_Azag = new azac(this);
  private bhha jdField_a_of_type_Bhha;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ArrayList<azaz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private int a(azaz paramazaz)
  {
    if (paramazaz == null) {
      return -1;
    }
    switch (paramazaz.b())
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
    this.jdField_a_of_type_Azaf.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void a(int paramInt, azaz paramazaz)
  {
    int i = a(paramazaz);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", i, 0, "", "", "", "");
      return;
    case 1: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", i, 0, "", "", "", "");
      return;
    }
    bcef.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", i, 0, "", "", "", "");
  }
  
  private void a(azaz paramazaz)
  {
    QQAppInterface localQQAppInterface;
    int i;
    switch (paramazaz.b())
    {
    default: 
    case 42172: 
    case 42128: 
    case 42425: 
      do
      {
        return;
        if (paramazaz.b())
        {
          bcef.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
          return;
        }
        bcef.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
        return;
        localQQAppInterface = this.app;
        if (paramazaz.b()) {}
        for (i = 1;; i = 2)
        {
          bcef.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
          return;
        }
      } while (paramazaz.b());
      bcef.b(this.app, "dc00898", "", "", "0X800B479", "0X800B479", 0, 0, "", "", "", "");
      return;
    case 42340: 
      localQQAppInterface = this.app;
      if (paramazaz.b()) {}
      for (i = 1;; i = 2)
      {
        bcef.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
        return;
      }
    case 42356: 
      bcef.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    }
    uug.b(paramazaz.b());
  }
  
  private void a(azaz paramazaz, int paramInt)
  {
    if ((paramazaz != null) && (paramazaz.b() != -1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ReqSetSettingItem(paramazaz.b(), paramazaz.e(), paramInt));
      paramazaz.c(paramInt);
      paramazaz.a(true);
      this.jdField_a_of_type_Ayzx.b(localArrayList);
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azaz localazaz = (azaz)localIterator.next();
      if (localazaz.b() != -1) {
        localArrayList.add(Integer.valueOf(localazaz.b()));
      }
    }
    this.jdField_a_of_type_Ayzx.a(localArrayList);
  }
  
  private void b(azaz paramazaz)
  {
    bjnw localbjnw = (bjnw)bjon.a(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131561314, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    ayzs localayzs = new ayzs(this, paramazaz);
    localayzs.a(new azae(this, paramazaz, localbjnw));
    paramazaz = new ArrayList();
    paramazaz.add(new ayzt(0, getString(2131694657)));
    paramazaz.add(new ayzt(1, getString(2131694673)));
    paramazaz.add(new ayzt(2, getString(2131694674)));
    localayzs.a(paramazaz);
    localRecyclerView.setAdapter(localayzs);
    localbjnw.a(localRecyclerView);
    localbjnw.c(2131690620);
    localbjnw.b(true);
    if (!isFinishing()) {
      localbjnw.show();
    }
  }
  
  private void c(azaz paramazaz)
  {
    switch (paramazaz.b())
    {
    default: 
      return;
    case 41611: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
      return;
    case 41610: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
      return;
    case 41607: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
      return;
    case 41609: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
      return;
    case 41618: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
      return;
    case 41619: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
      return;
    case 41614: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
      return;
    case 41613: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
      return;
    case 41622: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
      return;
    case 41623: 
      bcef.b(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
      return;
    }
    bcef.b(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
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
    super.setContentView(2131561313);
    this.app.addObserver(this.jdField_a_of_type_Ayzz);
    setTitle(getString(2131694630));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)findViewById(2131363362));
    this.jdField_a_of_type_Azaf = new azaf(this, this.jdField_a_of_type_Azag);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azaf);
    this.jdField_a_of_type_Bhha = new bhha(this.app, null);
    uug.a(this.jdField_a_of_type_Bhha.a(11));
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((amsw)this.app.getManager(51)).c(this.app.getCurrentUin());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    azbc.a.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_Bhha, this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool = azbc.a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ayzx = ((ayzx)this.app.getBusinessHandler(182));
    if (bool)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        break label272;
      }
      QQToast.a(BaseApplicationImpl.sApplication, 2131694062, 0).b(getTitleBarHeight());
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
    if (this.jdField_a_of_type_Bhha != null)
    {
      this.jdField_a_of_type_Bhha.a();
      this.jdField_a_of_type_Bhha = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Ayzz);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    uug.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    uug.a();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(azbc.a.b(this.jdField_a_of_type_JavaUtilArrayList)));
    azaz localazaz = azbc.a.a(42377, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localazaz != null) && (localazaz.a()) && (localazaz.b())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localazaz = azbc.a.a(42128, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localazaz != null) && (localazaz.a())) {
      localIntent.putExtra("key_personality_label_switch", localazaz.b());
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