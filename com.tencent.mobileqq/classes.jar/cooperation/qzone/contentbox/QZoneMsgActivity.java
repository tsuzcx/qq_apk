package cooperation.qzone.contentbox;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import anzj;
import apbo;
import bjey;
import bmaa;
import bmwv;
import bmww;
import bngf;
import bngi;
import bngj;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import tzq;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements bjey, bngj
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  apbo jdField_a_of_type_Apbo;
  PlusMenuContainer jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer;
  
  public static void a(long paramLong, Context paramContext)
  {
    if (TextUtils.isEmpty(String.valueOf(paramLong)))
    {
      QZLog.e("QZoneMsgActivity", "empty mini prog appid");
      return;
    }
    MiniAppLauncher.launchMiniAppById(paramContext, String.valueOf(paramLong), null, null, null, null, 2009);
  }
  
  public static boolean a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (bmaa.a(paramQQAppInterface))
    {
      long l = bmaa.a();
      if (l != 0L) {
        a(l, paramContext);
      }
      for (;;)
      {
        return true;
        paramQQAppInterface = new Intent(paramContext, QZoneMsgActivity.class);
        paramQQAppInterface.addFlags(67108864);
        paramContext.startActivity(paramQQAppInterface);
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer != null) {
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.c();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer == null)
    {
      LayoutInflater.from(this);
      ViewGroup localViewGroup = (ViewGroup)findViewById(16908290);
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer = new PlusMenuContainer(this);
      localViewGroup.addView(this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer);
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.setActivity(this);
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.setOnClickListener(null);
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.a();
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer != null) && (!this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.isShown()))
    {
      d();
      LpReportInfo_pf00064.report(133, 1);
      return;
    }
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer != null) {
      this.jdField_a_of_type_CooperationQzoneContentboxPlusMenuContainer.b();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof QZoneMsgFragment))
      {
        bmwv localbmwv = ((QZoneMsgFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        if (localbmwv != null) {
          localbmwv.a(paramInt1, paramInt2, paramIntent);
        }
      }
      return;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
      if (bool1) {
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 2130850139;
    super.doOnCreate(paramBundle);
    setContentView(2131562470);
    setTitle(bmww.a(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131376731);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850140;
      }
      paramBundle = getDrawable(i);
      localNavBarCommon.setRightImage(paramBundle);
      localNavBarCommon.setRightImageDesc(getString(2131695763));
      localNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_AndroidSupportV4AppFragment = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
        break label233;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new QZoneMsgFragment();
      getSupportFragmentManager().beginTransaction().add(2131367118, this.jdField_a_of_type_AndroidSupportV4AppFragment, "QZoneMsgFragment").commit();
    }
    for (;;)
    {
      bngf.a().a(this);
      long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
      QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
      bngf.a().a().a(l);
      this.jdField_a_of_type_Apbo = new apbo();
      getWindow().setFlags(16777216, 16777216);
      return true;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850140;
      }
      paramBundle = paramBundle.getDrawable(i);
      break;
      label233:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bngf.a().b(this);
    this.jdField_a_of_type_Apbo.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Apbo.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Apbo.c();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 5: 
      paramView = new Intent();
      paramView.putExtra("need_finish", true);
      paramView.putExtra("uin", "2290230341");
      paramView.putExtra("uinname", anzj.a(2131718521));
      paramView.putExtra("uintype", 1008);
      tzq.a(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
      return;
    case 4: 
      a();
      b();
      return;
    }
    onBackEvent();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {
      QLog.e("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
    }
    for (;;)
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent getTravelGroup bundle is empty");
        return;
      }
      if ("cmd.getTravelGroup".equals(paramString))
      {
        QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent CMD_GET_TRAVEL_GROUP");
        paramString = (LocalPhotoGroupData)paramBundle.getSerializable("groupData");
        if (paramString == null) {
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData == null");
        }
        while ((this.jdField_a_of_type_AndroidSupportV4AppFragment instanceof QZoneMsgFragment))
        {
          ((QZoneMsgFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a(paramString);
          return;
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData:" + paramString.toString());
          LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME_READ", paramString.startTime);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */