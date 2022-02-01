package cooperation.qzone.contentbox;

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
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.qqdaily.ArkCollector;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.FeedViewHolderInterface;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements OnItemSelectListener, WebEventListener
{
  public static final String SP_LAST_UPDATE_TIME_READ = "SP_LAST_UPDATE_TIME_READ";
  private static final String TAG = "QZoneMsgActivity";
  private static final String TAG2 = "[PhotoAlbum]QZoneMsgActivity";
  ArkCollector arkCollector;
  private ClassLoader mClassLoader = null;
  private Fragment mCurFragment;
  PlusMenuContainer plusMenuContainer;
  
  public static void launchContentBoxMiniProgram(long paramLong, Context paramContext)
  {
    if (TextUtils.isEmpty(String.valueOf(paramLong)))
    {
      QZLog.e("QZoneMsgActivity", "empty mini prog appid");
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, String.valueOf(paramLong), null, null, null, null, 2009, null);
  }
  
  public static boolean open(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QZoneHelper.enableQZoneContextBox(paramQQAppInterface))
    {
      long l = QZoneHelper.enableQZoneContentBoxMiniProgram();
      if (l != 0L) {
        launchContentBoxMiniProgram(l, paramContext);
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
  
  private void showMoreOperation()
  {
    if (this.plusMenuContainer != null) {
      this.plusMenuContainer.show();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
      if ((this.mCurFragment instanceof QZoneMsgFragment))
      {
        FeedViewHolderInterface localFeedViewHolderInterface = ((QZoneMsgFragment)this.mCurFragment).getFeedHolder();
        if (localFeedViewHolderInterface != null) {
          localFeedViewHolderInterface.doActivityResult(paramInt1, paramInt2, paramIntent);
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
    int i = 2130850547;
    super.doOnCreate(paramBundle);
    setContentView(2131562552);
    setTitle(QZoneApiProxy.getSubFeedTitle(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131377159);
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850548;
      }
      paramBundle = getDrawable(i);
      localNavBarCommon.setRightImage(paramBundle);
      localNavBarCommon.setRightImageDesc(getString(2131696406));
      localNavBarCommon.setOnItemSelectListener(this);
      this.mCurFragment = getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment");
      if (this.mCurFragment != null) {
        break label231;
      }
      this.mCurFragment = new QZoneMsgFragment();
      getSupportFragmentManager().beginTransaction().add(2131367438, this.mCurFragment, "QZoneMsgFragment").commit();
    }
    for (;;)
    {
      RemoteHandleManager.getInstance().addWebEventListener(this);
      long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
      QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
      RemoteHandleManager.getInstance().getSender().getTravelGroup(l);
      this.arkCollector = new ArkCollector();
      getWindow().setFlags(16777216, 16777216);
      return true;
      paramBundle = getResources();
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850548;
      }
      paramBundle = paramBundle.getDrawable(i);
      break;
      label231:
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    this.arkCollector.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.arkCollector.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.arkCollector.c();
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader3 = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      return localClassLoader1;
    }
    return localClassLoader3;
  }
  
  public void hideMoreOperation()
  {
    if (this.plusMenuContainer != null) {
      this.plusMenuContainer.hide();
    }
  }
  
  public void initMoreOperation()
  {
    if (this.plusMenuContainer == null)
    {
      LayoutInflater.from(this);
      ViewGroup localViewGroup = (ViewGroup)findViewById(16908290);
      this.plusMenuContainer = new PlusMenuContainer(this);
      localViewGroup.addView(this.plusMenuContainer);
      this.plusMenuContainer.setActivity(this);
      this.plusMenuContainer.setOnClickListener(null);
      this.plusMenuContainer.initView();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemLonClick(View paramView, int paramInt) {}
  
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
      paramView.putExtra("uinname", HardCodeUtil.a(2131719716));
      paramView.putExtra("uintype", 1008);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
      return;
    case 4: 
      initMoreOperation();
      togglePlus();
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
        while ((this.mCurFragment instanceof QZoneMsgFragment))
        {
          ((QZoneMsgFragment)this.mCurFragment).setLocalPhotoGroupData(paramString);
          return;
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData:" + paramString.toString());
          LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME_READ", paramString.startTime);
        }
      }
    }
  }
  
  public void togglePlus()
  {
    if ((this.plusMenuContainer != null) && (!this.plusMenuContainer.isShown()))
    {
      showMoreOperation();
      LpReportInfo_pf00064.report(133, 1);
      return;
    }
    hideMoreOperation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */