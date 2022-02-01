package com.tencent.mobileqq.winkpublish.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.flashshow.api.IFSQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkpublish.fs.activity.FSUploadActivityFragment;
import com.tencent.mobileqq.winkpublish.model.QCircleResultData;
import com.tencent.mobileqq.winkpublish.qcircle.activity.QCircleUploadActivityFragment;
import com.tencent.qphone.base.util.QLog;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

public class PublishLauncherImpl
  implements IPublishLauncher
{
  private static final String TAG = "PublishLauncher";
  
  public static void launchQPublicActivity(Context paramContext) {}
  
  private static void startActivityWithExtra(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      QLog.e("PublishLauncher", 1, "context is null,cannot start activity");
      return;
    }
    paramIntent.putExtra("key_bundle_open_page_time", System.currentTimeMillis());
    paramContext.startActivity(paramIntent);
  }
  
  public boolean checkIsValidUrl(String paramString)
  {
    boolean bool2 = false;
    try
    {
      URI localURI = new URI(paramString);
      String str = localURI.getHost();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" domain:");
      localStringBuilder.append(str);
      QLog.d("PublishLauncher", 1, localStringBuilder.toString());
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.endsWith(".qq.com"))
        {
          boolean bool3 = localURI.getScheme().equals("https");
          bool1 = bool2;
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    QCircleHostLauncher.forwardToMoodSelectLocation(paramContext, paramString, paramInt, paramBundle);
  }
  
  public Context getHostContext(Context paramContext)
  {
    Context localContext = paramContext;
    if ((paramContext instanceof Activity))
    {
      Activity localActivity = (Activity)paramContext;
      localContext = paramContext;
      if ((localActivity.getBaseContext() instanceof ContextWrapper)) {
        localContext = localActivity.getBaseContext();
      }
    }
    return localContext;
  }
  
  public ArrayList<QCircleResultData> getResultList(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("result_set");
    if (paramIntent != null)
    {
      ArrayList localArrayList = new ArrayList(paramIntent.size());
      Iterator localIterator = paramIntent.iterator();
      for (;;)
      {
        paramIntent = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramIntent = (ResultRecord)localIterator.next();
        QCircleResultData localQCircleResultData = new QCircleResultData();
        localQCircleResultData.uin = paramIntent.uin;
        localQCircleResultData.name = paramIntent.name;
        localArrayList.add(localQCircleResultData);
      }
    }
    paramIntent = null;
    return paramIntent;
  }
  
  public void jumpForAECircle(Context paramContext, Intent paramIntent)
  {
    QCircleHostLauncher.jumpForAECircle(getHostContext(paramContext), paramIntent);
  }
  
  public void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    QCircleHostLauncher.launchAECameraFromCircle(getHostContext(paramContext), paramBundle);
  }
  
  public void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    QCircleHostLauncher.launchAEMutiCameraFromCircle(getHostContext(paramContext), paramBundle);
  }
  
  public void launchAEMutiCameraFromFS(Context paramContext, Bundle paramBundle)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).launchAEMutiCameraFromFS(getHostContext(paramContext), paramBundle);
  }
  
  public void launchFSHybirdActivity(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    if (paramContext == null)
    {
      QLog.i("PublishLauncher", 1, "launchFSHybirdActivity context == null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("PublishLauncher", 1, "launchFSHybirdActivity url isEmpty");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchFSHybirdActivity url:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("PublishLauncher", 1, ((StringBuilder)localObject).toString());
    if (!checkIsValidUrl(paramString))
    {
      QLog.i("PublishLauncher", 1, "launchFSHybirdActivity url is Invalid");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchFSHybirdActivity:");
    ((StringBuilder)localObject).append(paramString);
    if (FastClickUtils.a(((StringBuilder)localObject).toString(), 1500L))
    {
      QLog.i("PublishLauncher", 1, "launchFSHybirdActivity is fast double click");
      return;
    }
    localObject = paramIntent;
    if (paramIntent == null) {
      localObject = new Intent();
    }
    paramString = ((IFSQQBaseService)QRoute.api(IFSQQBaseService.class)).handleFSPublishHybirdActivityIntent(paramContext, paramString, (Intent)localObject, paramInt);
    paramString.putExtra("web_color_note_type", 3);
    if ((paramContext instanceof FragmentActivity))
    {
      ((FragmentActivity)paramContext).startActivityForResult(paramString, paramInt);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public void launchPublishPage(Context paramContext, Intent paramIntent)
  {
    if (FastClickUtils.a("PublishLauncher_launchPublishPage", 500L)) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, CompatPublicActivity.class);
    localIntent.putExtra("public_fragment_class", FSUploadActivityFragment.class.getName());
    startActivityWithExtra(paramContext, localIntent);
  }
  
  public void launchQCPublishPage(Context paramContext, Intent paramIntent)
  {
    if (FastClickUtils.a("PublishLauncher_launchPublishPage", 500L)) {
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.addFlags(268435456);
    localIntent.setClass(paramContext, CompatPublicActivity.class);
    localIntent.putExtra("public_fragment_class", QCircleUploadActivityFragment.class.getName());
    startActivityWithExtra(paramContext, localIntent);
  }
  
  public void onAtClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_only_friends", paramBoolean);
    localBundle.putInt("param_min", paramInt1);
    localBundle.putInt("param_max", paramInt2);
    localBundle.putInt("param_entrance", 42);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)getHostContext(paramContext), localBundle, paramInt3);
  }
  
  public void onPublishClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("param_only_friends", paramBoolean);
    localBundle.putInt("param_min", paramInt1);
    localBundle.putInt("param_max", paramInt2);
    localBundle.putInt("param_entrance", 41);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult((Activity)getHostContext(paramContext), localBundle, paramInt3);
  }
  
  public void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent)
  {
    paramContext = getHostContext(paramContext);
    paramIntent.setAction("com.tencent.mobileqq.wink.action.MAIN");
    paramIntent.putExtra("public_fragment_class", "com.tencent.mobileqq.wink.preview.WinkPreviewFragment");
    ((Activity)paramContext).startActivity(paramIntent);
  }
  
  public void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, int paramInt)
  {
    paramContext = getHostContext(paramContext);
    paramIntent.setAction("com.tencent.mobileqq.wink.action.MAIN");
    paramIntent.putExtra("public_fragment_class", "com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment");
    ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
  }
  
  public void startWithPublicFragmentActivityForPicPreview(Context paramContext, Intent paramIntent)
  {
    paramContext = getHostContext(paramContext);
    paramIntent.setClass(paramContext, CompatPublicActivity.class);
    paramIntent.putExtra("public_fragment_class", "com.tencent.mobileqq.winkpublish.fragment.PublishPicPreviewFragment");
    ((Activity)paramContext).startActivity(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.impl.PublishLauncherImpl
 * JD-Core Version:    0.7.0.1
 */