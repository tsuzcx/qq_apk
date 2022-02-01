package com.tencent.mobileqq.newnearby.hippy.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.profilecard.RealNearbyProfileCardUtils;
import com.tencent.mobileqq.newnearby.NearbyActivityController;
import com.tencent.mobileqq.newnearby.NearbyNewUserGuideView;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge;
import com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl;
import com.tencent.mobileqq.newnearby.util.NearbyLocationHelper;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

public class NearbyHippyBridgeImpl
  implements INearbyHippyBridge
{
  private static final String TAG = "NearbyHippyBridgeImpl";
  
  private void addArkMessage(String paramString, NearbyActivity paramNearbyActivity)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramNearbyActivity.app.getNearbyProcManager().a(l, paramString, 1001);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramNearbyActivity = new StringBuilder();
      paramNearbyActivity.append("addArkMessage error: ");
      paramNearbyActivity.append(paramString);
      QLog.e("NearbyHippyBridgeImpl", 1, paramNearbyActivity.toString());
    }
  }
  
  private void doCustomizeTitleBar(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Promise paramPromise)
  {
    paramActivity = (NearbyActivity)paramActivity;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramActivity.centerView.setBackgroundDrawable(null);
      ViewGroup.LayoutParams localLayoutParams = paramActivity.centerView.getLayoutParams();
      localLayoutParams.width = -2;
      paramActivity.centerView.setLayoutParams(localLayoutParams);
      paramActivity.centerView.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramActivity.rightViewText.setText(paramString2);
      paramActivity.rightViewText.setOnClickListener(new NearbyHippyBridgeImpl.12(this, paramPromise, paramInt4, paramActivity, paramInt3));
    }
    paramActivity.leftView.setOnClickListener(new NearbyHippyBridgeImpl.13(this, paramPromise, paramInt4, paramActivity, paramInt2));
    paramActivity.getTitleBarLeftBackIcon().setOnClickListener(new NearbyHippyBridgeImpl.14(this, paramPromise, paramInt4, paramActivity, paramInt2));
    if ((paramInt1 != 0) && (paramInt1 != 1))
    {
      if (paramInt1 == 2)
      {
        NearbyStatusBarHelper.b(paramActivity);
        paramActivity.getWindow().setBackgroundDrawable(paramActivity.getResources().getDrawable(1946353664));
        if (!TextUtils.isEmpty(paramString1)) {
          paramActivity.centerView.setTextColor(-1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          paramActivity.rightViewText.setTextColor(-1);
        }
        paramActivity.leftView.setBackgroundDrawable(null);
        paramActivity.getTitleBarLeftBackIcon().setVisibility(0);
        paramActivity.getTitleBarView().setBackgroundColor(paramActivity.getResources().getColor(1946288129));
      }
    }
    else
    {
      NearbyStatusBarHelper.c(paramActivity);
      paramActivity.getWindow().setBackgroundDrawable(paramActivity.getResources().getDrawable(1946288130));
      if (!TextUtils.isEmpty(paramString1)) {
        paramActivity.centerView.setTextColor(-16777216);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        paramActivity.rightViewText.setTextColor(-16777216);
      }
      paramActivity.getTitleBarLeftBackIcon().setVisibility(8);
      paramActivity.leftView.setBackgroundResource(2130841082);
    }
  }
  
  private void doNearbyTitleBarClick(NearbyActivity paramNearbyActivity, int paramInt)
  {
    if (paramInt == 1)
    {
      paramNearbyActivity.getController().d();
      return;
    }
    if (paramInt == 2)
    {
      paramNearbyActivity.finish();
      return;
    }
    if (paramInt == 3) {
      paramNearbyActivity.getController().e();
    }
  }
  
  public void customizeTitleBar(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Promise paramPromise)
  {
    if (paramInt4 < 0) {
      return;
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.10(this, localQBaseActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramPromise));
    }
  }
  
  public void exitNearby()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.finish();
    }
  }
  
  public void hideBottomMask()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.7(this, localQBaseActivity));
    }
  }
  
  public void hideNavigationBar()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.9(this, localQBaseActivity));
    }
  }
  
  public void hideTopMask()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.5(this, localQBaseActivity));
    }
  }
  
  public void nearbySafetyReport(String paramString, int paramInt)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      NewReportPlugin.a((QBaseActivity)localQBaseActivity, Long.valueOf(paramString).longValue(), "0", null, paramInt, "", new Bundle());
    }
  }
  
  public void onTabChanged(int paramInt, String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.1(this, localQBaseActivity, paramInt, paramString));
    }
  }
  
  public void openAio(String paramString1, String paramString2)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity))
    {
      addArkMessage(paramString1, (NearbyActivity)localQBaseActivity);
      Intent localIntent = new Intent(localQBaseActivity, ChatActivity.class);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uinname", paramString2);
      localIntent.putExtra("uintype", 1001);
      localIntent.putExtra("gender", 1);
      localIntent.putExtra("ProfileCard_flag", "interestMatch");
      localIntent.addFlags(67108864);
      localQBaseActivity.startActivity(localIntent);
    }
  }
  
  public void openAppSetting()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity))
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", localQBaseActivity.getPackageName(), null));
      localQBaseActivity.startActivity(localIntent);
    }
  }
  
  public void openBirthdayEditActivity(Promise paramPromise)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      ((NearbyActivity)localQBaseActivity).getController().a(paramPromise);
    }
  }
  
  public void openHippyByUrl(int paramInt, String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity))
    {
      OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
      localOpenHippyInfo.bundleName = "QQNearby";
      localOpenHippyInfo.processName = "tool";
      localOpenHippyInfo.isDisablePreload = true;
      localOpenHippyInfo.framework = "react";
      localOpenHippyInfo.isTransparent = true;
      localOpenHippyInfo.url = paramString;
      ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).openHippyPage(localQBaseActivity, localOpenHippyInfo);
    }
  }
  
  public void openMqqUrl(String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    localQBaseActivity.startActivity(new Intent(localQBaseActivity, JumpActivity.class).setData(Uri.parse(paramString)));
  }
  
  public void openProfileCard(String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      RealNearbyProfileCardUtils.a(localQBaseActivity, paramString);
    }
  }
  
  public void requestLBS(Promise paramPromise)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof QBaseActivity)) {
      NearbyLocationHelper.a((QBaseActivity)localQBaseActivity, paramPromise);
    }
  }
  
  public void resetTitleBar(int paramInt)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.11(this, localQBaseActivity, paramInt));
    }
  }
  
  public void selectAndUploadPicture(int paramInt, Promise paramPromise)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      NearbyAlbumHelperImpl.openAlbum(paramInt, (NearbyActivity)localQBaseActivity, paramPromise);
    }
  }
  
  public void setVideoEnterVisibility(boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.2(this, localQBaseActivity, paramBoolean));
    }
  }
  
  public void showBeginnerGuide(String paramString)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity))
    {
      paramString = NearbyNewUserGuideView.a(paramString);
      if (paramString == null) {
        return;
      }
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.3(this, localQBaseActivity, paramString));
    }
  }
  
  public void showBottomMask()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.6(this, localQBaseActivity));
    }
  }
  
  public void showNavigationBar()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.8(this, localQBaseActivity));
    }
  }
  
  public void showTopMask()
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      localQBaseActivity.runOnUiThread(new NearbyHippyBridgeImpl.4(this, localQBaseActivity));
    }
  }
  
  public void uploadProfilePicture(Promise paramPromise)
  {
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if ((localQBaseActivity instanceof NearbyActivity)) {
      NearbyAlbumHelperImpl.uploadPicture((NearbyActivity)localQBaseActivity, paramPromise);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyBridgeImpl
 * JD-Core Version:    0.7.0.1
 */