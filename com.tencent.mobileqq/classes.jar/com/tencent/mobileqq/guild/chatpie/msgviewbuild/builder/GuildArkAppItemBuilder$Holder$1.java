package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class GuildArkAppItemBuilder$Holder$1
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.b.d.setVisibility(0);
      this.a.e.setVisibility(0);
      this.a.e.setImageBitmap(paramBitmap);
      return;
    }
    this.a.e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildArkAppItemBuilder.Holder.1
 * JD-Core Version:    0.7.0.1
 */