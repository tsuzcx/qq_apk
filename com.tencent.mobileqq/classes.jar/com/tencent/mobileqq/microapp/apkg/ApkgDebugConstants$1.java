package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import java.util.Map.Entry;

final class ApkgDebugConstants$1
  implements View.OnClickListener
{
  ApkgDebugConstants$1(LinearLayout paramLinearLayout, Map.Entry paramEntry) {}
  
  public void onClick(View paramView)
  {
    MiniAppLauncher.launchMiniApp(this.val$parentView.getContext(), ((ApkgConfig)this.val$entry.getValue()).mini_appid, 1201);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.ApkgDebugConstants.1
 * JD-Core Version:    0.7.0.1
 */