package com.tencent.mobileqq.gamecenter.fragment;

import adpn;
import afii;
import afil;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aslq;
import asme;
import asmf;
import azbi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGamePadFaceFragment
  extends PublicBaseFragment
  implements afil
{
  private afii jdField_a_of_type_Afii;
  private aslq jdField_a_of_type_Aslq;
  private azbi jdField_a_of_type_Azbi;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PadFaceAd jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    int j = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      return;
    }
    PadFaceAd localPadFaceAd = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
    this.jdField_a_of_type_Afii = new afii();
    this.jdField_a_of_type_Afii.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
    for (;;)
    {
      try
      {
        i = new JSONObject(localPadFaceAd.arkMeta).optInt("fullScreen", 1);
        if (i != 0) {
          continue;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("QQGamePadFaceFragment", 2, localJSONException, new Object[0]);
        int i = 1;
        continue;
        i = -1;
        continue;
      }
      if (i == 0) {
        continue;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
      this.jdField_a_of_type_Afii.setFixSize(j, i);
      this.jdField_a_of_type_Afii.setMaxSize(j, i);
      this.jdField_a_of_type_Afii.setHintSize(j, i);
      this.jdField_a_of_type_Afii.setMinSize(j, i);
      this.jdField_a_of_type_Afii.a(j, i);
      this.jdField_a_of_type_Afii.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(new asmf(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_Afii, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      return;
      i = 1;
    }
  }
  
  public static void a(Activity paramActivity, PadFaceAd paramPadFaceAd)
  {
    paramPadFaceAd = aslq.a(paramPadFaceAd, null);
    paramPadFaceAd.putExtra("public_fragment_window_feature", 1);
    adpn.a(paramActivity, paramPadFaceAd, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
  }
  
  private void b()
  {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  public boolean a(afii paramafii)
  {
    b();
    return true;
  }
  
  public boolean a(afii paramafii, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if (this.jdField_a_of_type_Afii != null) {
      this.jdField_a_of_type_Afii.doOnEvent(2);
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
    this.jdField_a_of_type_Azbi = ((azbi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12));
    this.jdField_a_of_type_Aslq = this.jdField_a_of_type_Azbi.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = aslq.a(getActivity().getIntent());
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      getActivity().finish();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid());
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId > 0) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = this.jdField_a_of_type_Aslq.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid()));
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(getActivity(), null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(13);
    paramBundle = new RelativeLayout(paramViewGroup.getContext());
    paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, paramLayoutInflater);
    paramViewGroup.addView(paramBundle, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.addOnLayoutChangeListener(new asme(this));
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localObject = getActivity().getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < ((ViewGroup)localObject).getChildCount())
      {
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView.getClass() == View.class) && (localView.getVisibility() == 0)) {
          ((ViewGroup)localObject).removeViewAt(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */