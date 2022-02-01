package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.BaseWebDialogFragment;
import com.tencent.smtt.sdk.WebView;

public class TransparentWebFragment
  extends BaseWebDialogFragment
{
  public static TransparentWebFragment a(FragmentManager paramFragmentManager, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    paramString = new TransparentWebFragment();
    paramString.setArguments(localBundle);
    paramFragmentManager.beginTransaction().add(paramString, "TransparentWebFragment").commitAllowingStateLoss();
    return paramString;
  }
  
  public int a()
  {
    return 2131625545;
  }
  
  public FrameLayout a(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131445137);
  }
  
  public void a(Dialog paramDialog)
  {
    paramDialog = paramDialog.getWindow();
    if (paramDialog != null) {
      paramDialog.setBackgroundDrawable(new ColorDrawable(0));
    }
  }
  
  public FrameLayout b(View paramView)
  {
    return (FrameLayout)paramView.findViewById(2131445137);
  }
  
  public void c(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(2, 16974120);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.e.setBackgroundColor(0);
    this.g.registerJsModule(new TransparentWebFragment.1(this, getContext(), this.j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.fragment.TransparentWebFragment
 * JD-Core Version:    0.7.0.1
 */