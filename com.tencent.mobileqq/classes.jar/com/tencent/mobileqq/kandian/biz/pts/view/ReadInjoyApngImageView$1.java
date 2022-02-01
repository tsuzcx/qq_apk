package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import mqq.app.AppRuntime;

class ReadInjoyApngImageView$1
  implements Runnable
{
  ReadInjoyApngImageView$1(ReadInjoyApngImageView paramReadInjoyApngImageView, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.a.startsWith("http")))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getFilesDir());
      ((StringBuilder)localObject1).append("/shortvideo_opt_png/");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      int i = this.a.lastIndexOf("/");
      int j = this.a.lastIndexOf(".");
      localObject2 = this.a.substring(i + 1, j);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 1);
      localBundle.putBoolean("key_once_clear", true);
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localObject1 = VasApngUtil.getApngDrawable(localAppRuntime, localStringBuilder.toString(), this.a, ReadInjoyApngImageView.a(), new int[] { 31 }, "-kandianopt-", localBundle);
      if (localObject1 != null)
      {
        this.this$0.a.setImageDrawable((Drawable)localObject1);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInjoyApngImageView.1
 * JD-Core Version:    0.7.0.1
 */