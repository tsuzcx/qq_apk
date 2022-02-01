package com.tencent.mobileqq.kandian.biz.ugc.camera.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCaptureLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "launchFromNative", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "launchFromViolaForResult", "act", "Landroid/app/Activity;", "requestCode", "", "launchFromWebForResult", "plugin", "Lcom/tencent/biz/pubaccount/util/api/IPublicAccountH5AbilityPlugin;", "launchPhotoCapture", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyCaptureLauncher
  extends QRouteApi
{
  public abstract void launchFromNative(@Nullable Context paramContext, @Nullable Bundle paramBundle);
  
  public abstract void launchFromViolaForResult(@Nullable Activity paramActivity, @Nullable Bundle paramBundle, byte paramByte);
  
  public abstract void launchFromWebForResult(@Nullable IPublicAccountH5AbilityPlugin paramIPublicAccountH5AbilityPlugin, @Nullable Context paramContext, @Nullable Bundle paramBundle, byte paramByte);
  
  public abstract void launchPhotoCapture(@Nullable Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher
 * JD-Core Version:    0.7.0.1
 */