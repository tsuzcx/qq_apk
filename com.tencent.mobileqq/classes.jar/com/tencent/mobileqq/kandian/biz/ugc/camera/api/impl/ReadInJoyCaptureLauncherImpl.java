package com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class ReadInJoyCaptureLauncherImpl
  implements IReadInJoyCaptureLauncher
{
  private static final String TAG = "Q.readinjoy.videoReadInJoyCaptureLauncher";
  
  private static boolean downloadFilterSo()
  {
    return PtvFilterSoLoad.a(getQQAppInterface(), BaseApplicationImpl.getContext());
  }
  
  private static Bundle generalBundle(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10013);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 12);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putInt("ability_flag", 3);
    localBundle.putInt("key_max_duration", ReadInJoyHelper.f(BaseApplicationImpl.getApplication().getRuntime()));
    return localBundle;
  }
  
  private static QQAppInterface getQQAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  private static void showTip(Context paramContext)
  {
    DialogUtil.a(paramContext, 230).setMessage(HardCodeUtil.a(2131712698)).setPositiveButton(2131694583, new ReadInJoyCaptureLauncherImpl.1()).show();
  }
  
  public void launchFromNative(Context paramContext, Bundle paramBundle)
  {
    if (getQQAppInterface().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131719097, 0).a();
      return;
    }
    boolean bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isResourceReady(getQQAppInterface());
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      showTip(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718345, 0).a();
      return;
    }
    downloadFilterSo();
    if (bool)
    {
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launch(paramContext, generalBundle(paramBundle));
      return;
    }
    ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launch(paramContext, ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).getAEPitUnitClass().getName(), generalBundle(paramBundle), true);
  }
  
  public void launchFromViolaForResult(Activity paramActivity, Bundle paramBundle, byte paramByte)
  {
    if (paramActivity == null) {
      return;
    }
    if (getQQAppInterface().isVideoChatting())
    {
      QQToast.a(paramActivity, 0, 2131719097, 0).a();
      return;
    }
    boolean bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isResourceReady(getQQAppInterface());
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      showTip(paramActivity);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramActivity)))
    {
      QQToast.a(paramActivity, 2131718345, 0).a();
      return;
    }
    downloadFilterSo();
    if (bool)
    {
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launchForResult(paramActivity, generalBundle(paramBundle), paramByte);
      return;
    }
    Intent localIntent = new Intent(paramActivity, ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).getQmcSoDownloadActivity());
    localIntent.putExtras(generalBundle(paramBundle));
    localIntent.putExtra("pendingIntentClass", ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).getAEPitUnitClass().getName());
    localIntent.putExtra("pendingIntentRequest", paramByte);
    localIntent.putExtra("pendingIntentAllWait", true);
    ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launchForResult(paramActivity, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getQIMWebEffectCameraCaptureUnitClass().getName(), localIntent.getExtras(), paramByte);
  }
  
  public void launchFromWebForResult(IPublicAccountH5AbilityPlugin paramIPublicAccountH5AbilityPlugin, Context paramContext, Bundle paramBundle, byte paramByte)
  {
    boolean bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isResourceReady(paramIPublicAccountH5AbilityPlugin.getRuntime().a());
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      showTip(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718345, 0).a();
      return;
    }
    paramIPublicAccountH5AbilityPlugin.downloadShortVideoFilterSo();
    if (bool)
    {
      paramContext = ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).getLaunchIntent(paramContext, generalBundle(paramBundle));
      paramIPublicAccountH5AbilityPlugin.getWebViewPlugin().startActivityForResult(paramContext, paramByte);
      return;
    }
    paramContext = new Intent(paramContext, ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).getQmcSoDownloadActivity());
    paramContext.putExtras(generalBundle(paramBundle));
    paramContext.putExtra("pendingIntentClass", ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).getAEPitUnitClass().getName());
    paramContext.putExtra("pendingIntentRequest", paramByte);
    paramContext.putExtra("pendingIntentAllWait", true);
    paramIPublicAccountH5AbilityPlugin.getWebViewPlugin().startActivityForResult(paramContext, paramByte);
  }
  
  public void launchPhotoCapture(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10017);
    localBundle.putInt("entrance_type", 106);
    localBundle.putInt("extra.busi_type", 8);
    localBundle.putInt("edit_video_way", 10);
    localBundle.putInt("ability_flag", 2);
    localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
    localBundle.putInt("key_camera_photo_edit_type", 1);
    localBundle.putInt("key_camera_video_edit_type", 5);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putInt("capture_intent_mode", 0);
    if (getQQAppInterface().isVideoChatting())
    {
      QQToast.a(paramContext, 0, 2131719097, 0).a();
      return;
    }
    boolean bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isResourceReady(getQQAppInterface());
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      showTip(paramContext);
      return;
    }
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramContext)))
    {
      QQToast.a(paramContext, 2131718345, 0).a();
      return;
    }
    downloadFilterSo();
    if (bool)
    {
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launch(paramContext, localBundle);
      return;
    }
    ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launch(paramContext, ((IAECameraUnit)QRoute.api(IAECameraUnit.class)).getAEPitUnitClass().getName(), localBundle, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCaptureLauncherImpl
 * JD-Core Version:    0.7.0.1
 */