package com.tencent.mobileqq.gamecenter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGamePadFaceFragment
  extends PublicBaseFragment
  implements ArkAppContainer.ArkAppModuleCallback
{
  private PadFaceAd a;
  private ArkAppView b;
  private ArkAppContainer c;
  private QQAppInterface d;
  private PadFaceManager e;
  private GameCenterManagerImp f;
  private boolean g;
  
  private void a()
  {
    PadFaceAd localPadFaceAd = this.a;
    if (localPadFaceAd == null) {
      return;
    }
    this.c = new ArkAppContainer();
    this.c.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
    int i = 1;
    int j;
    try
    {
      j = new JSONObject(localPadFaceAd.arkMeta).optInt("fullScreen", 1);
      if (j == 0) {
        i = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.d("QQGamePadFaceFragment", 2, localJSONException, new Object[0]);
    }
    int k = -1;
    if (i != 0)
    {
      i = this.b.getWidth();
      j = this.b.getHeight();
    }
    else
    {
      j = -1;
      i = k;
    }
    this.c.setFixSize(i, j);
    this.c.setMaxSize(i, j);
    this.c.setHintSize(i, j);
    this.c.setMinSize(i, j);
    this.c.a(i, j);
    this.c.a(this);
    this.b.setLoadCallback(new QQGamePadFaceFragment.2(this));
    this.b.a(this.c, null);
    this.b.setVisibility(0);
    ArkAppView localArkAppView = this.b;
    localArkAppView.setOnTouchListener(localArkAppView);
  }
  
  public static void a(Activity paramActivity, PadFaceAd paramPadFaceAd)
  {
    paramPadFaceAd = PadFaceManager.a(paramPadFaceAd, null);
    paramPadFaceAd.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramPadFaceAd, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
  }
  
  private void b()
  {
    getBaseActivity().finish();
    getBaseActivity().overridePendingTransition(0, 0);
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    b();
    return true;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    ArkAppContainer localArkAppContainer = this.c;
    if (localArkAppContainer != null) {
      localArkAppContainer.doOnEvent(2);
    }
  }
  
  public boolean onBackEvent()
  {
    b();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.f = ((GameCenterManagerImp)this.d.getManager(QQManagerFactory.GAMECENTER_MANAGER));
    this.e = this.f.b();
    this.a = PadFaceManager.a(getBaseActivity().getIntent());
    paramBundle = this.a;
    if (paramBundle == null)
    {
      getBaseActivity().finish();
      return;
    }
    if (!paramBundle.isValid())
    {
      if (this.a.redPointId > 0) {
        this.a = this.e.c(this.a.redPointId);
      }
      paramBundle = this.a;
      if ((paramBundle == null) || (!paramBundle.isValid())) {
        getBaseActivity().finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = new ArkAppView(getBaseActivity(), null);
    this.b.setBorderType(0);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(13);
    paramBundle = new RelativeLayout(paramViewGroup.getContext());
    paramBundle.addView(this.b, paramLayoutInflater);
    paramViewGroup.addView(paramBundle, -1, -1);
    this.b.addOnLayoutChangeListener(new QQGamePadFaceFragment.1(this));
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, null);
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      Object localObject = getBaseActivity().getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        int i = 0;
        while (i < ((ViewGroup)localObject).getChildCount())
        {
          View localView = ((ViewGroup)localObject).getChildAt(i);
          if ((localView.getClass() == View.class) && (localView.getVisibility() == 0))
          {
            ((ViewGroup)localObject).removeViewAt(i);
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */