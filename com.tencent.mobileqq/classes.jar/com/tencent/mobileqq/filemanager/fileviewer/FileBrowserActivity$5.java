package com.tencent.mobileqq.filemanager.fileviewer;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

class FileBrowserActivity$5
  implements IFileViewListener
{
  FileBrowserActivity$5(FileBrowserActivity paramFileBrowserActivity) {}
  
  @TargetApi(14)
  public void a()
  {
    Object localObject = this.a.getResources().getConfiguration().toString();
    int i;
    if ((!((String)localObject).contains("hwMultiwindow-magic")) && (!((String)localObject).contains("hw-magic-windows"))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (i == 0))
    {
      localObject = (RelativeLayout)this.a.findViewById(2131445139);
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this.a), 0, 0);
    }
  }
  
  public void a(int paramInt)
  {
    FileBrowserActivity localFileBrowserActivity = this.a;
    FileBrowserActivity.a(localFileBrowserActivity, (TextView)localFileBrowserActivity.findViewById(2131436227));
    FileBrowserActivity.d(this.a).setTextSize(1, 19.0F);
    FileBrowserActivity.d(this.a).setText(this.a.d.b());
  }
  
  public void a(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.a, paramBoolean);
    Object localObject = this.a.findViewById(2131444900);
    if (!FileBrowserActivity.e(this.a))
    {
      ((View)localObject).setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
      {
        int i = this.a.getResources().getColor(2131168092);
        this.a.mSystemBarComp.setStatusColor(i);
        this.a.mSystemBarComp.setStatusBarColor(i);
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.a.mSystemBarComp.setStatusBarDrawable(this.a.getResources().getDrawable(2130847834));
        }
      }
      LiuHaiUtils.g(this.a);
      this.a.getWindow().setFlags(0, 1024);
      return;
    }
    ((View)localObject).setVisibility(4);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.mSystemBarComp != null))
    {
      this.a.mSystemBarComp.setStatusColor(0);
      this.a.mSystemBarComp.setStatusBarColor(0);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.a.mSystemBarComp.setStatusBarDrawable(null);
      }
    }
    localObject = this.a;
    FileBrowserActivity.a((FileBrowserActivity)localObject, ((FileBrowserActivity)localObject).d.f());
    if ((FileBrowserActivity.f(this.a) != 2) && (FileBrowserActivity.f(this.a) != 0)) {
      LiuHaiUtils.h(this.a);
    }
    this.a.getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.5
 * JD-Core Version:    0.7.0.1
 */