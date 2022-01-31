package com.tencent.mobileqq.mini.mainpage;

import ajjy;
import android.content.Context;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import bace;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class MainPageFragment$1
  implements View.OnLongClickListener
{
  MainPageFragment$1(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    String str = AppLoaderFactory.PATH_WXAPKG_ROOT + MainPageFragment.access$000(this.this$0).appId + "_debug";
    if (new File(str).exists()) {
      bace.a(str, false);
    }
    str = MiniAppGlobal.MINI_LOG_PATH + MD5.toMD5(MainPageFragment.access$000(this.this$0).appId);
    if (new File(str).exists()) {
      bace.a(str, false);
    }
    str = paramView.getContext().getCacheDir() + File.separator + "mini" + File.separator + MainPageFragment.getUin() + File.separator + MainPageFragment.access$000(this.this$0).appId;
    if (new File(str).exists()) {
      bace.a(str, false);
    }
    this.this$0.getActivity().finish();
    Process.killProcess(Process.myPid());
    QLog.e("debug", 1, "clear miniapp");
    Toast.makeText(paramView.getContext(), ajjy.a(2131640637), 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.1
 * JD-Core Version:    0.7.0.1
 */