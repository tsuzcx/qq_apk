package com.tencent.mobileqq.kandian.biz.share.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/impl/ReadInJoyShareManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/share/api/IReadInJoyShareManager;", "()V", "KEY_SAHRE_DATA", "", "getKEY_SAHRE_DATA", "()Ljava/lang/String;", "jumpToReadInJoyShare", "", "context", "Landroid/content/Context;", "params", "Landroid/os/Bundle;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "requestCode", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyShareManagerImpl
  implements IReadInJoyShareManager
{
  @NotNull
  private final String KEY_SAHRE_DATA = "share_data";
  
  @NotNull
  public String getKEY_SAHRE_DATA()
  {
    return this.KEY_SAHRE_DATA;
  }
  
  public boolean jumpToReadInJoyShare(@Nullable Context paramContext, @Nullable Bundle paramBundle, @Nullable DialogInterface.OnDismissListener paramOnDismissListener, int paramInt)
  {
    if (paramBundle == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(getKEY_SAHRE_DATA(), paramBundle);
    localIntent.putExtra("readinjoy_launch_style", 2);
    localIntent.putExtra("readinjoy_launch_source", 11);
    localIntent.putExtra("channel_id", 9999);
    ReportController.b(null, "CliOper", "", "", "0X80059F4", "0X80059F4", 0, 0, "", "", "", "");
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).forwardToReadInJoyFeed((Activity)paramContext, localIntent, paramInt, paramOnDismissListener);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.impl.ReadInJoyShareManagerImpl
 * JD-Core Version:    0.7.0.1
 */