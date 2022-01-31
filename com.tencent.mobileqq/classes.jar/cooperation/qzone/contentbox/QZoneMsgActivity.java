package cooperation.qzone.contentbox;

import alpo;
import amkc;
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
import android.view.Window;
import best;
import bihe;
import bjdg;
import bjdh;
import bjmn;
import bjmp;
import bjmq;
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
import syb;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements best, bjmq
{
  amkc jdField_a_of_type_Amkc;
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
    if (bihe.a(paramQQAppInterface))
    {
      long l = bihe.a();
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
      paramView.putExtra("uinname", alpo.a(2131720567));
      paramView.putExtra("uintype", 1008);
      syb.a(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
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
        bjdg localbjdg = ((QZoneMsgFragment)this.jdField_a_of_type_AndroidSupportV4AppFragment).a();
        if (localbjdg != null) {
          localbjdg.a(paramInt1, paramInt2, paramIntent);
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
    int i = 2130849503;
    super.doOnCreate(paramBundle);
    setContentView(2131562176);
    setTitle(bjdh.a(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131375812);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130849504;
      }
      paramBundle = getDrawable(i);
      localNavBarCommon.setRightImage(paramBundle);
      localNavBarCommon.setRightImageDesc(getString(2131696896));
      localNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_AndroidSupportV4AppFragment = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
        break label236;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragment = new QZoneMsgFragment();
      getSupportFragmentManager().beginTransaction().add(2131366789, this.jdField_a_of_type_AndroidSupportV4AppFragment, "QZoneMsgFragment").commit();
    }
    for (;;)
    {
      bjmn.a().a(this);
      long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
      QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
      bjmn.a().a().a(l);
      this.jdField_a_of_type_Amkc = new amkc();
      getWindow().setFlags(16777216, 16777216);
      return true;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130849504;
      }
      paramBundle = paramBundle.getDrawable(i);
      break;
      label236:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bjmn.a().b(this);
    this.jdField_a_of_type_Amkc.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Amkc.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Amkc.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */