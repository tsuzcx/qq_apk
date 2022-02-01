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
import anmw;
import azrc;
import azrd;
import azrh;
import azrj;
import azrl;
import azrm;
import azrn;
import azro;
import azrp;
import azrq;
import azsj;
import azsm;
import azsn;
import bcst;
import bgnt;
import biab;
import bkho;
import bkif;
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
import ulo;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  private LinearLayoutManager jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager = new azrn(this, this);
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private azrh jdField_a_of_type_Azrh;
  private azrj jdField_a_of_type_Azrj = new azrl(this);
  private azrp jdField_a_of_type_Azrp;
  private azrq jdField_a_of_type_Azrq = new azrm(this);
  private biab jdField_a_of_type_Biab;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private ArrayList<azsj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private int a(azsj paramazsj)
  {
    if (paramazsj == null) {
      return -1;
    }
    switch (paramazsj.b())
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
    this.jdField_a_of_type_Azrp.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  private void a(int paramInt, azsj paramazsj)
  {
    int i = a(paramazsj);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", i, 0, "", "", "", "");
      return;
    case 1: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", i, 0, "", "", "", "");
      return;
    }
    bcst.b(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", i, 0, "", "", "", "");
  }
  
  private void a(azsj paramazsj)
  {
    QQAppInterface localQQAppInterface;
    int i;
    switch (paramazsj.b())
    {
    default: 
      return;
    case 42172: 
      if (paramazsj.b())
      {
        bcst.b(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
        return;
      }
      bcst.b(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
      return;
    case 42128: 
      localQQAppInterface = this.app;
      if (paramazsj.b()) {}
      for (i = 1;; i = 2)
      {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i, 0, "", "", "", "");
        return;
      }
    case 42340: 
      localQQAppInterface = this.app;
      if (paramazsj.b()) {}
      for (i = 1;; i = 2)
      {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X800A7DA", "qq_vip", i, 0, "", "", "", "");
        return;
      }
    case 42356: 
      bcst.b(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
      return;
    }
    ulo.b(paramazsj.b());
  }
  
  private void a(azsj paramazsj, int paramInt)
  {
    if ((paramazsj != null) && (paramazsj.b() != -1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new ReqSetSettingItem(paramazsj.b(), paramazsj.e(), paramInt));
      paramazsj.c(paramInt);
      paramazsj.a(true);
      this.jdField_a_of_type_Azrh.b(localArrayList);
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      azsj localazsj = (azsj)localIterator.next();
      if (localazsj.b() != -1) {
        localArrayList.add(Integer.valueOf(localazsj.b()));
      }
    }
    this.jdField_a_of_type_Azrh.a(localArrayList);
  }
  
  private void b(azsj paramazsj)
  {
    bkho localbkho = (bkho)bkif.a(this, null);
    RecyclerView localRecyclerView = (RecyclerView)View.inflate(this, 2131561389, null);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    azrc localazrc = new azrc(this, paramazsj);
    localazrc.a(new azro(this, paramazsj, localbkho));
    paramazsj = new ArrayList();
    paramazsj.add(new azrd(0, getString(2131694500)));
    paramazsj.add(new azrd(1, getString(2131694515)));
    paramazsj.add(new azrd(2, getString(2131694516)));
    localazrc.a(paramazsj);
    localRecyclerView.setAdapter(localazrc);
    localbkho.a(localRecyclerView);
    localbkho.c(2131690582);
    localbkho.b(true);
    if (!isFinishing()) {
      localbkho.show();
    }
  }
  
  private void c(azsj paramazsj)
  {
    switch (paramazsj.b())
    {
    default: 
      return;
    case 41611: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
      return;
    case 41610: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
      return;
    case 41607: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
      return;
    case 41609: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
      return;
    case 41618: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
      return;
    case 41619: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
      return;
    case 41614: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
      return;
    case 41613: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
      return;
    case 41622: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
      return;
    case 41623: 
      bcst.b(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
      return;
    }
    bcst.b(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
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
    super.setContentView(2131561388);
    this.app.addObserver(this.jdField_a_of_type_Azrj);
    setTitle(getString(2131694473));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)findViewById(2131363308));
    this.jdField_a_of_type_Azrp = new azrp(this, this.jdField_a_of_type_Azrq);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidxRecyclerviewWidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azrp);
    this.jdField_a_of_type_Biab = new biab(this.app, null);
    ulo.a(this.jdField_a_of_type_Biab.a(11));
    this.jdField_a_of_type_ComTencentMobileqqDataCard = ((anmw)this.app.getManager(51)).c(this.app.c());
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    azsm.a.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataCard, this.jdField_a_of_type_Biab, this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool = azsm.a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Azrh = ((azrh)this.app.a(182));
    if (bool)
    {
      if (bgnt.d(BaseApplication.getContext())) {
        break label272;
      }
      QQToast.a(BaseApplicationImpl.sApplication, 2131693946, 0).b(getTitleBarHeight());
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
    if (this.jdField_a_of_type_Biab != null)
    {
      this.jdField_a_of_type_Biab.a();
      this.jdField_a_of_type_Biab = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_Azrj);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ulo.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ulo.a();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_switches_changed", Boolean.valueOf(azsm.a.b(this.jdField_a_of_type_JavaUtilArrayList)));
    azsj localazsj = azsm.a.a(42377, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localazsj != null) && (localazsj.a()) && (localazsj.b())) {
      localIntent.putExtra("key_weishi_switch", true);
    }
    localazsj = azsm.a.a(42128, this.jdField_a_of_type_JavaUtilArrayList);
    if ((localazsj != null) && (localazsj.a())) {
      localIntent.putExtra("key_personality_label_switch", localazsj.b());
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