package com.tencent.mobileqq.guild.share;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharehelper.IShareActionHelper;
import com.tencent.mobileqq.sharehelper.QzoneLinkShareInfo;
import com.tencent.mobileqq.widget.QQToast;

public class ShareActionExecutor
{
  private final ShareInfoProvider a;
  private final Activity b;
  private final IShareActionHelper c = (IShareActionHelper)QRoute.api(IShareActionHelper.class);
  
  public ShareActionExecutor(@NonNull Activity paramActivity, @NonNull ShareInfoProvider paramShareInfoProvider)
  {
    this.a = paramShareInfoProvider;
    this.b = paramActivity;
  }
  
  private void a(int paramInt)
  {
    this.c.doShareLinkToWeChat("guildShare", paramInt, this.a.h(), this.b, String.valueOf(System.currentTimeMillis()), this.a.g(), this.a.f(), this.a.b());
  }
  
  public void a()
  {
    this.c.doShareArkBySelect("guildShare", this.b, this.a.a());
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c.doShareArkDirectly("guildShare", this.b, this.a.a(), paramInt, paramString);
  }
  
  public void b()
  {
    QzoneLinkShareInfo localQzoneLinkShareInfo = this.a.c();
    this.c.doShareToQZoneWithLink("guildShare", this.b, localQzoneLinkShareInfo);
  }
  
  public void c()
  {
    a(9);
  }
  
  public void d()
  {
    a(10);
  }
  
  public void e()
  {
    Object localObject = this.a.i();
    ClipboardManager localClipboardManager = (ClipboardManager)this.b.getSystemService("clipboard");
    localObject = ClipData.newPlainText("group_pro_url", (CharSequence)localObject);
    ClipboardMonitor.setPrimaryClip(localClipboardManager, (ClipData)localObject);
    localClipboardManager.setPrimaryClip((ClipData)localObject);
    QQToast.makeText(this.b, 2, this.a.j(), 0).show(2131299920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.ShareActionExecutor
 * JD-Core Version:    0.7.0.1
 */