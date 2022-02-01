package com.tencent.mobileqq.guild.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ShareActionSheetBuilder
{
  private final ShareActionSheet a;
  private final List<ShareActionSheetBuilder.ActionSheetItem> b = new ArrayList();
  private final List<ShareActionSheetBuilder.ActionSheetItem> c = new ArrayList();
  
  public ShareActionSheetBuilder(Context paramContext)
  {
    ShareActionSheetV2.Param localParam = new ShareActionSheetV2.Param();
    localParam.context = paramContext;
    this.a = ShareActionSheetFactory.create(localParam);
    this.a.setRowVisibility(0, 0, 0);
    this.a.setActionSheetTitle(paramContext.getString(2131916565));
    b();
    c();
    d();
  }
  
  private void b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appName", "com.tencent.qun.pro");
    localBundle.putString("appMinVersion", "1.0.0.0");
    localBundle.putString("appView", "contact");
    localBundle.putString("metaData", "{}");
    localBundle.putFloat("scale", ViewUtils.getDensity());
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 27).putExtra("is_ark_display_share", true).putExtra("forward_ark_app_name", "com.tencent.qun.pro").putExtra("forward_ark_app_view", "contact").putExtra("forward_ark_app_ver", "1.0.0.0").putExtra("forward_ark_app_prompt", "QQ小站").putExtra("selection_mode", 2).putExtra("guild_share_label", true).putExtra("forward_ark_app_meta", "{}").putExtras(localBundle);
    this.a.setIntentForStartForwardRecentActivity(localIntent);
  }
  
  private void c()
  {
    Iterator localIterator = Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(9), Integer.valueOf(10) }).iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      this.b.add(ShareActionSheetBuilder.ActionSheetItem.build(i));
    }
  }
  
  private void d()
  {
    this.c.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
  }
  
  public ShareActionSheet a()
  {
    this.a.setActionSheetItems(this.b, this.c);
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.ShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */