package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Stack;

public class ContactSearchActivity
  extends BaseSearchActivity
{
  private int jdField_a_of_type_Int;
  private ContactSearchActivity.GroupFileSearchListener jdField_a_of_type_ComTencentMobileqqSearchActivityContactSearchActivity$GroupFileSearchListener;
  private boolean c;
  private int e;
  private int f;
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("ContactCombineType", paramInt3);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("isApproximate", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    Object localObject = getIntent();
    int i = ((Intent)localObject).getIntExtra("key_from_type", 0);
    int j = ((Intent)localObject).getIntExtra("watch_together_uinType", -1);
    localObject = ((Intent)localObject).getStringExtra("watch_together_uin");
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityContactSearchActivity$GroupFileSearchListener = new ContactSearchActivity.GroupFileSearchListener(this, i, j, (String)localObject);
      ReportController.b(null, "dc00898", "", "", "0X800B625", "0X800B625", 0, 0, "", "", "", "");
    }
  }
  
  protected BaseSearchFragment a()
  {
    return ContactSearchFragment.a(this.e, this.jdField_a_of_type_Int, null, null, this.jdField_a_of_type_ComTencentMobileqqSearchActivityContactSearchActivity$GroupFileSearchListener, this.c, this.f, -1L);
  }
  
  protected String a()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("key_from_type", 0) != 0)) {
      return HardCodeUtil.a(2131699551);
    }
    if (this.jdField_a_of_type_Int != 197437) {
      return HardCodeUtil.a(2131702727);
    }
    return HardCodeUtil.a(2131702709);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1300)
    {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          TroopUtils.a(this, paramIntent, true);
          ReportController.b(getAppRuntime(), "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
        }
      }
    }
    else if ((paramInt1 == 2020) && (-1 == paramInt2) && (paramIntent != null))
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    this.e = getIntent().getIntExtra("fromType", -1);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("contactSearchSource", 197437);
    this.c = getIntent().getBooleanExtra("isApproximate", false);
    this.f = getIntent().getIntExtra("ContactCombineType", 0);
    b();
    WTBusinessForWebPlugin.a.push(this);
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    WTBusinessForWebPlugin.a.pop();
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity
 * JD-Core Version:    0.7.0.1
 */