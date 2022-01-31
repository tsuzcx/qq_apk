package cooperation.qzone.contentbox;

import ajya;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bctk;
import bggg;
import bhbx;
import bhby;
import bhlc;
import bhle;
import bhlf;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import sgg;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements bctk, bhlf
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
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
    if (bggg.a(paramQQAppInterface))
    {
      long l = bggg.a();
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
  
  public void a(View paramView, int paramInt)
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
      paramView.putExtra("uinname", ajya.a(2131720031));
      paramView.putExtra("uintype", 1008);
      sgg.a(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
      return;
    case 4: 
      a();
      b();
      return;
    }
    onBackEvent();
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
        bhbx localbhbx = ((QZoneMsgFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        if (localbhbx != null) {
          localbhbx.a(paramInt1, paramInt2, paramIntent);
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
    int i = 2130849073;
    super.doOnCreate(paramBundle);
    setContentView(2131561984);
    setTitle(bhby.a(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131375329);
    if (Build.VERSION.SDK_INT >= 21) {
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        paramBundle = getDrawable(i);
        localNavBarCommon.setRightImage(paramBundle);
        localNavBarCommon.setRightImageDesc(getString(2131696721));
        localNavBarCommon.setOnItemSelectListener(this);
        this.jdField_a_of_type_AndroidSupportV4AppFragment = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
        if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
          break label220;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragment = new QZoneMsgFragment();
        getSupportFragmentManager().beginTransaction().add(2131366671, this.jdField_a_of_type_AndroidSupportV4AppFragment, "QZoneMsgFragment").commit();
      }
    }
    for (;;)
    {
      bhlc.a().a(this);
      long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
      QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
      bhlc.a().a().a(l);
      return true;
      i = 2130849072;
      break;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {}
      for (;;)
      {
        paramBundle = paramBundle.getDrawable(i);
        break;
        i = 2130849072;
      }
      label220:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bhlc.a().b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */