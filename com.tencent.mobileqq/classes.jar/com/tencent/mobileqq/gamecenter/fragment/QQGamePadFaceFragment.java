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
  private ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PadFaceAd jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
  private PadFaceManager jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceManager;
  private GameCenterManagerImp jdField_a_of_type_ComTencentMobileqqServletGameCenterManagerImp;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    PadFaceAd localPadFaceAd = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
    if (localPadFaceAd == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = new ArkAppContainer();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
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
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
    }
    else
    {
      j = -1;
      i = k;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setFixSize(i, j);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMaxSize(i, j);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setHintSize(i, j);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.setMinSize(i, j);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(i, j);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(new QQGamePadFaceFragment.2(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(0);
    ArkAppView localArkAppView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
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
    ArkAppContainer localArkAppContainer = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqServletGameCenterManagerImp = ((GameCenterManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceManager = this.jdField_a_of_type_ComTencentMobileqqServletGameCenterManagerImp.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = PadFaceManager.a(getBaseActivity().getIntent());
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
    if (paramBundle == null)
    {
      getBaseActivity().finish();
      return;
    }
    if (!paramBundle.isValid())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId > 0) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceManager.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId);
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
      if ((paramBundle == null) || (!paramBundle.isValid())) {
        getBaseActivity().finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(getBaseActivity(), null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(13);
    paramBundle = new RelativeLayout(paramViewGroup.getContext());
    paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, paramLayoutInflater);
    paramViewGroup.addView(paramBundle, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.addOnLayoutChangeListener(new QQGamePadFaceFragment.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */