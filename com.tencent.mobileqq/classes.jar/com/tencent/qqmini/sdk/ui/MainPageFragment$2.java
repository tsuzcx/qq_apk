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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppLoaderFactory.g().getContext().getFilesDir().getPath());
    ((StringBuilder)localObject).append("/mini/");
    ((StringBuilder)localObject).append(MainPageFragment.access$000(this.this$0).appId);
    ((StringBuilder)localObject).append("_debug");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      FileUtils.delete((String)localObject, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MainPageFragment.access$100());
    ((StringBuilder)localObject).append(MD5Utils.toMD5(MainPageFragment.access$000(this.this$0).appId));
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      FileUtils.delete((String)localObject, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramView.getContext().getCacheDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("mini");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.this$0.getUin());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(MainPageFragment.access$000(this.this$0).appId);
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      FileUtils.delete((String)localObject, false);
    }
    this.this$0.getActivity().finish();
    Process.killProcess(Process.myPid());
    QMLog.e("debug", "clear miniapp");
    Toast.makeText(paramView.getContext(), "清除游戏缓存数据成功!", 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment.2
 * JD-Core Version:    0.7.0.1
 */