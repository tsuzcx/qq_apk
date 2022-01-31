package com.tencent.plato;

import aljv;
import aljw;
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
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mqq.MqqImageLoader;
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
  public int a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private IPlatoManager jdField_a_of_type_ComTencentPlatoIPlatoManager;
  private JSONWritableMap jdField_a_of_type_ComTencentPlatoJSONWritableMap;
  private PlatoAppFragment.PlatoLoadReceiver jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver;
  public PlatoAppJson a;
  private PlatoRootView jdField_a_of_type_ComTencentPlatoSdkRenderPlatoRootView;
  public String a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private NavBarCommon jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private int d;
  
  public PlatoAppFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new aljw(this));
  }
  
  private void d()
  {
    a(this.jdField_a_of_type_ComTencentPlatoPlatoAppJson.b());
  }
  
  protected int a()
  {
    return 2130968610;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_MqqAppAppRuntime = localFragmentActivity.getAppRuntime();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("bid");
    this.jdField_a_of_type_ComTencentPlatoPlatoAppJson = new PlatoAppJson(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentPlatoJSONWritableMap = new JSONWritableMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_ComTencentPlatoJSONWritableMap.put(str, paramBundle.get(str));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (PlatoAppManager.a(localFragmentActivity.getApplicationContext()))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver = new PlatoAppFragment.PlatoLoadReceiver(this);
      Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver);
      if (!paramBundle.getBoolean("singledog", false)) {
        break label214;
      }
      if (!PlatoAppManager.jdField_a_of_type_Boolean) {
        PlatoAppManager.a(localFragmentActivity.getApplicationContext(), this.jdField_a_of_type_MqqAppAppRuntime);
      }
      PlatoAppManager.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString);
      if (PlatoAppManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label214;
      }
      c();
    }
    label214:
    do
    {
      return;
      this.jdField_b_of_type_Boolean = false;
      break;
      this.jdField_a_of_type_AndroidContentSharedPreferences = localFragmentActivity.getSharedPreferences("config", 0);
    } while (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("fps_switch", false));
    BlockDetectByChoreographer.start();
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentPlatoSdkRenderPlatoRootView = ((PlatoRootView)this.e.findViewById(2131362859));
    this.jdField_a_of_type_AndroidViewView = this.e.findViewById(2131362857);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.e.findViewById(2131362858));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.e.findViewById(2131362860));
    this.jdField_b_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.e.findViewById(2131363244));
    d();
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2131034388);
    paramLayoutInflater = (AnimationDrawable)this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
    if (paramLayoutInflater != null) {
      paramLayoutInflater.start();
    }
  }
  
  public void a(String paramString)
  {
    a("");
    FragmentActivity localFragmentActivity = getActivity();
    Intent localIntent = new Intent(localFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localFragmentActivity.startActivity(localIntent);
    localFragmentActivity.finish();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString1))) {
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentPlatoPlatoAppJson = new PlatoAppJson(this.jdField_a_of_type_JavaLangString);
    d();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramString1 = PlatoAppManager.a(getActivity(), "natives_blob.bin");
    String str = PlatoAppManager.a(getActivity(), "snapshot_blob.bin");
    if (QLog.isColorLevel()) {
      QLog.d("PlatoAppActivity", 2, "native bin is exists ? " + FileUtils.e(paramString1) + ", snapshot bin is exists ? " + FileUtils.e(str));
    }
    this.jdField_a_of_type_ComTencentPlatoIPlatoManager = new PlatoManagerBuilder().setApplication(getActivity()).setExceptionHandler(this).setNativesBlobPath(paramString1).setSnapshotBlobPath(str).setBundlePath(paramString2).build();
    this.jdField_a_of_type_ComTencentPlatoIPlatoManager.init();
    TroopTechReportUtils.a("plato_v1", "bundle_init", String.valueOf(System.currentTimeMillis() - l), "", "", "");
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentPlatoIPlatoManager.loadPage(this.jdField_a_of_type_ComTencentPlatoSdkRenderPlatoRootView, this.jdField_a_of_type_ComTencentPlatoPlatoAppJson.a(), this.jdField_a_of_type_ComTencentPlatoJSONWritableMap, new aljv(this));
    this.jdField_a_of_type_ComTencentPlatoPlatoAppJson.a(this.jdField_c_of_type_Int);
    PlatoAppManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentPlatoPlatoAppJson);
    PlatoAppManager.a(String.valueOf(this.jdField_c_of_type_Int), this);
    PlatoSDKManager.setImageLoader(new MqqImageLoader());
    TroopTechReportUtils.a("plato_v1", "loadpage", String.valueOf(System.currentTimeMillis() - l), "", "", "");
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_Int == -1) || (this.jdField_a_of_type_Int == -1)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver != null)
    {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("PlatoAppActivity", 2, "preload done: js_result=" + this.jdField_b_of_type_Int + ", so_result=" + this.jdField_a_of_type_Int);
      }
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_b_of_type_Int == 0)
      {
        a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        TroopTechReportUtils.a("plato_v1", "exp", "0", "", "", "");
        return;
      }
      if (new File(this.jdField_b_of_type_JavaLangString).exists())
      {
        a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        TroopTechReportUtils.a("plato_v1", "exp", "1", "", "", "");
        return;
      }
      c();
      return;
    }
    c();
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentPlatoJSONWritableMap.getString("backupUrl", "");
    if (!TextUtils.isEmpty(str))
    {
      a(str);
      TroopTechReportUtils.a("plato_v1", "exp", "2", "1", "", "");
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, "启动失败，稍后再试", 0).a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    TroopTechReportUtils.a("plato_v1", "exp", "2", "0", "", "");
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentPlatoIPlatoManager != null) {
      this.jdField_a_of_type_ComTencentPlatoIPlatoManager.destroyInstance();
    }
    if (BlockDetectByChoreographer.isDetecting()) {
      BlockDetectByChoreographer.stop();
    }
    if (this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentPlatoPlatoAppFragment$PlatoLoadReceiver);
    }
  }
  
  public void onPlatoException(String paramString)
  {
    QLog.e("PlatoAppActivity", 2, "onPlatoException:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppFragment
 * JD-Core Version:    0.7.0.1
 */