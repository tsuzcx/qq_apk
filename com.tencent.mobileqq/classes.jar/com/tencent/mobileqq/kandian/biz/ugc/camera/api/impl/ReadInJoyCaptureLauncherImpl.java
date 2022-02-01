package com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCaptureLauncher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/impl/ReadInJoyCaptureLauncherImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCaptureLauncher;", "()V", "launchFromNative", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "launchFromViolaForResult", "act", "Landroid/app/Activity;", "requestCode", "", "launchFromWebForResult", "plugin", "Lcom/tencent/biz/pubaccount/util/api/IPublicAccountH5AbilityPlugin;", "launchPhotoCapture", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyCaptureLauncherImpl
  implements IReadInJoyCaptureLauncher
{
  public ReadInJoyCaptureLauncherImpl()
  {
    ReadInJoyCaptureLauncher localReadInJoyCaptureLauncher = ReadInJoyCaptureLauncher.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyCaptureLauncher, "ReadInJoyCaptureLauncher.getInstance()");
    this.$$delegate_0 = localReadInJoyCaptureLauncher;
  }
  
  public void launchFromNative(@Nullable Context paramContext, @Nullable Bundle paramBundle)
  {
    this.$$delegate_0.launchFromNative(paramContext, paramBundle);
  }
  
  public void launchFromViolaForResult(@Nullable Activity paramActivity, @Nullable Bundle paramBundle, byte paramByte)
  {
    this.$$delegate_0.launchFromViolaForResult(paramActivity, paramBundle, paramByte);
  }
  
  public void launchFromWebForResult(@Nullable IPublicAccountH5AbilityPlugin paramIPublicAccountH5AbilityPlugin, @Nullable Context paramContext, @Nullable Bundle paramBundle, byte paramByte)
  {
    this.$$delegate_0.launchFromWebForResult(paramIPublicAccountH5AbilityPlugin, paramContext, paramBundle, paramByte);
  }
  
  public void launchPhotoCapture(@Nullable Context paramContext)
  {
    this.$$delegate_0.launchPhotoCapture(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCaptureLauncherImpl
 * JD-Core Version:    0.7.0.1
 */