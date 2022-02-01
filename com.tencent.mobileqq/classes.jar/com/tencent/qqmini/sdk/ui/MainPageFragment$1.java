package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

class MainPageFragment$1
  implements View.OnLongClickListener
{
  MainPageFragment$1(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView.getId() == R.id.miniapp_logo) && (GameWnsUtils.enablePersistentDebugVersion()) && (MainPageFragment.access$000(this.this$0) != null))
    {
      paramView = AppLoaderFactory.g().getContext().getApplicationContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("persistent_debug_version_");
      localStringBuilder.append(this.this$0.getUin());
      paramView = paramView.getSharedPreferences(localStringBuilder.toString(), 4);
      if (paramView.getBoolean("persistent", false))
      {
        paramView.edit().remove("persistent").apply();
        QMLog.e("MainPageFragment", "close persistent debug version");
        Toast.makeText(this.this$0.getActivity(), this.this$0.getResources().getString(R.string.mini_sdk_game_close_persistent_debug_version), 1).show();
        return false;
      }
      paramView.edit().putBoolean("persistent", true).apply();
      QMLog.e("MainPageFragment", "open persistent debug version");
      Toast.makeText(this.this$0.getActivity(), this.this$0.getResources().getString(R.string.mini_sdk_game_open_persistent_debug_version), 1).show();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.1
 * JD-Core Version:    0.7.0.1
 */