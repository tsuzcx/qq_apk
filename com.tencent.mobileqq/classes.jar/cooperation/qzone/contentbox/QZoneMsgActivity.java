package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.qqdaily.ArkCollector;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import com.tencent.qzonehub.api.impl.QZoneApiProxyImpl;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import mqq.app.AppRuntime;

public class QZoneMsgActivity
  extends IphoneTitleBarActivity
  implements OnItemSelectListener, WebEventListener
{
  public static final String SP_LAST_UPDATE_TIME_READ = "SP_LAST_UPDATE_TIME_READ";
  private static final String TAG = "QZoneMsgActivity";
  private static final String TAG2 = "[PhotoAlbum]QZoneMsgActivity";
  ArkCollector arkCollector;
  private ClassLoader mClassLoader = null;
  private BaseFragment mCurFragment;
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
  
  public static boolean open(Context paramContext, AppRuntime paramAppRuntime)
  {
    if (QZoneHelper.enableQZoneContextBox(paramAppRuntime))
    {
      long l = QZoneHelper.enableQZoneContentBoxMiniProgram();
      if (l != 0L)
      {
        launchContentBoxMiniProgram(l, paramContext);
      }
      else
      {
        paramAppRuntime = new Intent(paramContext, QZoneMsgActivity.class);
        paramAppRuntime.addFlags(67108864);
        paramContext.startActivity(paramAppRuntime);
      }
      return true;
    }
    return false;
  }
  
  private void showMoreOperation()
  {
    PlusMenuContainer localPlusMenuContainer = this.plusMenuContainer;
    if (localPlusMenuContainer != null) {
      localPlusMenuContainer.show();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2000)
    {
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
    Object localObject = this.mCurFragment;
    if ((localObject instanceof QZoneMsgFragment))
    {
      localObject = ((QZoneMsgFragment)localObject).getFeedHolder();
      if (localObject != null) {
        ((IFeedViewHolderInterface)localObject).doActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2080636928);
    setTitle(QZoneApiProxyImpl.getSubFeedTitle(this));
    NavBarCommon localNavBarCommon = (NavBarCommon)findViewById(2131376636);
    int j = Build.VERSION.SDK_INT;
    int i = 2130850474;
    if (j >= 21)
    {
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850473;
      }
      paramBundle = getDrawable(i);
    }
    else
    {
      paramBundle = getResources();
      if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
        i = 2130850473;
      }
      paramBundle = paramBundle.getDrawable(i);
    }
    localNavBarCommon.setRightImage(paramBundle);
    localNavBarCommon.setRightImageDesc(getString(2131696425));
    localNavBarCommon.setOnItemSelectListener(this);
    this.mCurFragment = ((BaseFragment)getSupportFragmentManager().findFragmentByTag("QZoneMsgFragment"));
    if (this.mCurFragment == null)
    {
      this.mCurFragment = new QZoneMsgFragment();
      getSupportFragmentManager().beginTransaction().add(2080571454, this.mCurFragment, "QZoneMsgFragment").commitAllowingStateLoss();
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("QZoneMsgActivity", 2, "QZoneMsgFragment added");
    }
    RemoteHandleManager.getInstance().addWebEventListener(this);
    long l = LocalMultiProcConfig.getLong("SP_LAST_UPDATE_TIME_READ", 0L);
    QLog.d("[PhotoAlbum]QZoneMsgActivity", 1, new Object[] { "getTravelGroup SP_LAST_UPDATE_TIME_READ lastUpdateTime:", Long.valueOf(l) });
    RemoteHandleManager.getInstance().getSender().getTravelGroup(l);
    this.arkCollector = new ArkCollector();
    getWindow().setFlags(16777216, 16777216);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    this.arkCollector.a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.arkCollector.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.arkCollector.c();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.mClassLoader;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.mClassLoader = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
  }
  
  public void hideMoreOperation()
  {
    PlusMenuContainer localPlusMenuContainer = this.plusMenuContainer;
    if (localPlusMenuContainer != null) {
      localPlusMenuContainer.hide();
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
  
  public void onItemLonClick(View paramView, int paramInt) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 5) {
          return;
        }
        paramView = new Intent();
        paramView.putExtra("need_finish", true);
        paramView.putExtra("uin", "2290230341");
        paramView.putExtra("uinname", HardCodeUtil.a(2131719439));
        paramView.putExtra("uintype", 1008);
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfileForResult(paramView, this.app, this, "2290230341", -1, 2000, 1, false);
        return;
      }
      initMoreOperation();
      togglePlus();
      return;
    }
    onBackEvent();
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
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
        if (paramString == null)
        {
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent localPhotoGroupData == null");
        }
        else
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onWebEvent localPhotoGroupData:");
          paramBundle.append(paramString.toString());
          QLog.i("[PhotoAlbum]QZoneMsgActivity", 1, paramBundle.toString());
          LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME_READ", paramString.startTime);
        }
        paramBundle = this.mCurFragment;
        if ((paramBundle instanceof QZoneMsgFragment)) {
          ((QZoneMsgFragment)paramBundle).setLocalPhotoGroupData(paramString);
        }
      }
      return;
    }
    QLog.e("[PhotoAlbum]QZoneMsgActivity", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
  }
  
  public void togglePlus()
  {
    PlusMenuContainer localPlusMenuContainer = this.plusMenuContainer;
    if ((localPlusMenuContainer != null) && (!localPlusMenuContainer.isShown()))
    {
      showMoreOperation();
      LpReportInfo_pf00064.report(133, 1);
      return;
    }
    hideMoreOperation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgActivity
 * JD-Core Version:    0.7.0.1
 */