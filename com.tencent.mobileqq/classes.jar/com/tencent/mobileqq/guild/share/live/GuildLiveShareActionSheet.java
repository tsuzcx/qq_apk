package com.tencent.mobileqq.guild.share.live;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class GuildLiveShareActionSheet
{
  private final WeakReference<Activity> b;
  private final GuildLiveShareActionSheet.ShareItemClickListener c = new GuildLiveShareActionSheet.ShareItemClickListener(this, null);
  private final String d;
  private ShareActionSheetBuilder.ActionSheetItem e;
  private ShareActionSheet f = null;
  
  public GuildLiveShareActionSheet(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    this.b = new WeakReference(paramActivity);
    this.d = paramString;
  }
  
  private static void a(Activity paramActivity)
  {
    if (paramActivity.getIntent() != null) {
      paramActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_qqstation");
    }
  }
  
  private void b(int paramInt)
  {
    Activity localActivity = (Activity)this.b.get();
    if (localActivity == null)
    {
      QLog.e("GuildShareAction", 1, "handleShare activity null");
      QQToast.makeText(localActivity, "分享失败，请重试~", 0).show();
      return;
    }
    GuildLiveShareActionRunnable localGuildLiveShareActionRunnable = new GuildLiveShareActionRunnable(localActivity, this.d);
    if (paramInt != 2) {
      if (paramInt != 9)
      {
        if (paramInt != 26)
        {
          if (paramInt != 72)
          {
            if (paramInt != 73)
            {
              QLog.e("GuildShareAction", 1, "handleShare activity null");
              QQToast.makeText(localActivity, "分享类型异常，请重试~", 0).show();
            }
          }
          else
          {
            if ((!a) && (this.e == null)) {
              throw new AssertionError();
            }
            localGuildLiveShareActionRunnable.a(this.e.uin, this.e.uinType);
          }
        }
        else {
          localGuildLiveShareActionRunnable.a(AppConstants.DATALINE_PC_UIN, 6000);
        }
      }
      else
      {
        localGuildLiveShareActionRunnable.b();
        return;
      }
    }
    localGuildLiveShareActionRunnable.a();
  }
  
  public void a()
  {
    Activity localActivity = (Activity)this.b.get();
    if (localActivity == null)
    {
      QLog.e("GuildShareAction", 1, "showActionSheet(), context null");
      return;
    }
    a(localActivity);
    this.f = new GuildLiveShareActionSheetBuilder(localActivity).a();
    this.f.setItemClickListenerV2(this.c);
    this.f.show();
  }
  
  public void a(int paramInt)
  {
    if ((Context)this.b.get() == null)
    {
      QLog.e("GuildShareAction", 1, "share(), context is null");
      QQToast.makeText(QQGuildUtil.h(), "分享失败，请重试~", 0).show();
      return;
    }
    b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.live.GuildLiveShareActionSheet
 * JD-Core Version:    0.7.0.1
 */