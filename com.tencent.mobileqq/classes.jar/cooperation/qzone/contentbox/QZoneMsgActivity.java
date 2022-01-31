package cooperation.qzone.contentbox;

import ajjy;
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
import bbpw;
import bexy;
import bgbz;
import bgcb;
import bgcc;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import rtr;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements bbpw, bgcc
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
    if (bexy.a(paramQQAppInterface))
    {
      long l = bexy.a();
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
      paramView.putExtra("uinname", ajjy.a(2131654130));
      paramView.putExtra("uintype", 1008);
      rtr.a(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
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
    boolean bool1;
    do
    {
      return;
      boolean bool2 = false;
      bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getExtras() != null) {
          bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
        }
      }
    } while (!bool1);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 2130848842;
    super.doOnCreate(paramBundle);
    setContentView(2131496386);
    setTitle(ajjy.a(2131654130));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131309578);
    if (Build.VERSION.SDK_INT >= 21) {
      if (ThemeUtil.isDefaultOrDIYTheme(false))
      {
        paramBundle = getDrawable(i);
        localNavBarCommon.setRightImage(paramBundle);
        localNavBarCommon.setRightImageDesc(getString(2131631008));
        localNavBarCommon.setOnItemSelectListener(this);
        this.jdField_a_of_type_AndroidSupportV4AppFragment = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
        if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null) {
          break label182;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragment = new QZoneMsgFragment();
        getSupportFragmentManager().beginTransaction().add(2131301060, this.jdField_a_of_type_AndroidSupportV4AppFragment, "QZoneMsgFragment").commit();
      }
    }
    for (;;)
    {
      bgbz.a().a(this);
      bgbz.a().a().x();
      return true;
      i = 2130848841;
      break;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {}
      for (;;)
      {
        paramBundle = paramBundle.getDrawable(i);
        break;
        i = 2130848841;
      }
      label182:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bgbz.a().b(this);
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
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */