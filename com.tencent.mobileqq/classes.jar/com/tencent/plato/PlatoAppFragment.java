package com.tencent.plato;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mqq.MqqImageLoader;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.sdk.PlatoManagerBuilder;
import com.tencent.plato.sdk.PlatoSDKManager;
import com.tencent.plato.sdk.render.PlatoRootView;
import com.tencent.plato.sdk.utils.fps.BlockDetectByChoreographer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class PlatoAppFragment
  extends IphoneTitleBarFragment
  implements IPlatoExceptionHandler, IEventReceiver
{
  private static final String FPS_LOG_SWITCH = "fps_switch";
  public static final int LOAD_RESULT_ERROR = 1;
  public static final int LOAD_RESULT_SUCCESS = 0;
  public static final int LOAD_RESULT_WAIT = -1;
  public static final String TAG = "PlatoAppActivity";
  private long mAllStartTime;
  public PlatoAppJson mAppJSON;
  private AppRuntime mAppRuntime;
  private JSONWritableMap mArgs;
  public String mBid;
  public String mBundlerPath;
  private boolean mIsDestory;
  public int mJsLoadResult = -1;
  protected TextView mLeftBackBtn;
  private ImageView mLoadingImage;
  private View mLoadingView;
  private FrameLayout mMenuView;
  private NavBarCommon mNavBarCommon;
  private int mPageId;
  private IPlatoManager mPlatoAppManager;
  private PlatoAppFragment.PlatoLoadReceiver mPlatoLoadReceiver;
  private PlatoRootView mPlatoRootView;
  public int mSoLoadResult = -1;
  protected TextView mTitle;
  protected View mTitleBar;
  public Handler mUIHander = new Handler(new PlatoAppFragment.3(this));
  private int renderCount;
  private boolean reportParam_isSoLoad;
  private SharedPreferences sp;
  
  private void updateTitleBar()
  {
    setTitle(this.mAppJSON.getNavigationBarTitleText());
  }
  
  public void demotion()
  {
    String str = this.mArgs.getString("backupUrl", "");
    if (!TextUtils.isEmpty(str))
    {
      demotionToWebView(str);
      TroopTechReportUtils.a("plato_v1", "exp", "2", "1", "", "");
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, "启动失败，稍后再试", 0).a();
    this.mLoadingView.setVisibility(8);
    TroopTechReportUtils.a("plato_v1", "exp", "2", "0", "", "");
  }
  
  public void demotionToWebView(String paramString)
  {
    setTitle("");
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localFragmentActivity.startActivity(localIntent);
    localFragmentActivity.finish();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mPlatoRootView = ((PlatoRootView)this.mContentView.findViewById(2131362864));
    this.mLoadingView = this.mContentView.findViewById(2131362862);
    this.mLoadingImage = ((ImageView)this.mContentView.findViewById(2131362863));
    this.mMenuView = ((FrameLayout)this.mContentView.findViewById(2131362865));
    this.mNavBarCommon = ((NavBarCommon)this.mContentView.findViewById(2131363261));
    updateTitleBar();
    this.mLoadingImage.setImageResource(2131034388);
    paramLayoutInflater = (AnimationDrawable)this.mLoadingImage.getDrawable();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.start();
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2130968610;
  }
  
  protected void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    this.mAppRuntime = localFragmentActivity.getAppRuntime();
    this.mBid = paramBundle.getString("bid");
    this.mAppJSON = new PlatoAppJson(this.mBid);
    this.mArgs = new JSONWritableMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.mArgs.put(str, paramBundle.get(str));
    }
    this.mAllStartTime = System.currentTimeMillis();
    if (PlatoAppManager.loadV8So(localFragmentActivity.getApplicationContext()))
    {
      this.mSoLoadResult = 0;
      this.reportParam_isSoLoad = true;
      this.mPlatoLoadReceiver = new PlatoAppFragment.PlatoLoadReceiver(this);
      Dispatchers.get().registerSubscriber(this.mPlatoLoadReceiver);
      if (!paramBundle.getBoolean("singledog", false)) {
        break label216;
      }
      if (!PlatoAppManager.mIsInit) {
        PlatoAppManager.init(localFragmentActivity.getApplicationContext(), this.mAppRuntime);
      }
      PlatoAppManager.loadPlatoAppByBid(this.mAppRuntime, this.mBid);
      if (PlatoAppManager.sV8LibLoaded.get()) {
        break label216;
      }
      demotion();
    }
    label216:
    do
    {
      return;
      this.reportParam_isSoLoad = false;
      break;
      this.sp = localFragmentActivity.getSharedPreferences("config", 0);
    } while (!this.sp.getBoolean("fps_switch", false));
    BlockDetectByChoreographer.start();
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestory;
  }
  
  public void loadApp(String paramString1, String paramString2)
  {
    if ((this.mBid == null) || (!this.mBid.equals(paramString1))) {
      return;
    }
    long l = System.currentTimeMillis();
    this.mAppJSON = new PlatoAppJson(this.mBid);
    updateTitleBar();
    this.mLoadingView.setVisibility(8);
    paramString1 = PlatoAppManager.getSoPath(getActivity(), "natives_blob.bin");
    String str = PlatoAppManager.getSoPath(getActivity(), "snapshot_blob.bin");
    if (QLog.isColorLevel()) {
      QLog.d("PlatoAppActivity", 2, "native bin is exists ? " + FileUtils.e(paramString1) + ", snapshot bin is exists ? " + FileUtils.e(str));
    }
    this.mPlatoAppManager = new PlatoManagerBuilder().setApplication(getActivity()).setExceptionHandler(this).setNativesBlobPath(paramString1).setSnapshotBlobPath(str).setBundlePath(paramString2).build();
    this.mPlatoAppManager.init();
    TroopTechReportUtils.a("plato_v1", "bundle_init", String.valueOf(System.currentTimeMillis() - l), "", "", "");
    this.mPageId = this.mPlatoAppManager.loadPage(this.mPlatoRootView, this.mAppJSON.getPageMain(), this.mArgs, new PlatoAppFragment.1(this));
    this.mAppJSON.addPageId(this.mPageId);
    PlatoAppManager.setAppModule(this.mBid, this.mAppJSON);
    PlatoAppManager.setRunningAppModule(String.valueOf(this.mPageId), this);
    PlatoSDKManager.setImageLoader(new MqqImageLoader());
    TroopTechReportUtils.a("plato_v1", "loadpage", String.valueOf(System.currentTimeMillis() - l), "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsDestory = true;
    if (this.mPlatoAppManager != null) {
      this.mPlatoAppManager.destroyInstance();
    }
    if (BlockDetectByChoreographer.isDetecting()) {
      BlockDetectByChoreographer.stop();
    }
    if (this.mPlatoLoadReceiver != null) {
      Dispatchers.get().unRegisterSubscriber(this.mPlatoLoadReceiver);
    }
  }
  
  public void onPlatoException(String paramString)
  {
    QLog.e("PlatoAppActivity", 2, "onPlatoException:" + paramString);
  }
  
  public void preload()
  {
    if ((this.mJsLoadResult == -1) || (this.mSoLoadResult == -1)) {
      return;
    }
    if (this.mPlatoLoadReceiver != null)
    {
      Dispatchers.get().unRegisterSubscriber(this.mPlatoLoadReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("PlatoAppActivity", 2, "preload done: js_result=" + this.mJsLoadResult + ", so_result=" + this.mSoLoadResult);
      }
    }
    if (this.mSoLoadResult == 0)
    {
      if (this.mJsLoadResult == 0)
      {
        loadApp(this.mBid, this.mBundlerPath);
        TroopTechReportUtils.a("plato_v1", "exp", "0", "", "", "");
        return;
      }
      if (new File(this.mBundlerPath).exists())
      {
        loadApp(this.mBid, this.mBundlerPath);
        TroopTechReportUtils.a("plato_v1", "exp", "1", "", "", "");
        return;
      }
      demotion();
      return;
    }
    demotion();
  }
  
  public void setRightButton(String paramString, IFunction paramIFunction)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramIFunction != null) {
      this.rightViewText.setOnClickListener(new PlatoAppFragment.2(this, paramIFunction));
    }
    if (AppSetting.b) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + "按钮");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppFragment
 * JD-Core Version:    0.7.0.1
 */