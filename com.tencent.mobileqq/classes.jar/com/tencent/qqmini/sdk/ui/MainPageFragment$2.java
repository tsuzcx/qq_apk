package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;

class MainPageFragment$2
  implements View.OnLongClickListener
{
  MainPageFragment$2(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    String str = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/" + MainPageFragment.access$000(this.this$0).appId + "_debug";
    if (new File(str).exists()) {
      FileUtils.delete(str, false);
    }
    str = MainPageFragment.access$100() + MD5Utils.toMD5(MainPageFragment.access$000(this.this$0).appId);
    if (new File(str).exists()) {
      FileUtils.delete(str, false);
    }
    str = paramView.getContext().getCacheDir() + File.separator + "mini" + File.separator + this.this$0.getUin() + File.separator + MainPageFragment.access$000(this.this$0).appId;
    if (new File(str).exists()) {
      FileUtils.delete(str, false);
    }
    this.this$0.getActivity().finish();
    Process.killProcess(Process.myPid());
    QMLog.e("debug", "clear miniapp");
    Toast.makeText(paramView.getContext(), "清除游戏缓存数据成功!", 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.2
 * JD-Core Version:    0.7.0.1
 */