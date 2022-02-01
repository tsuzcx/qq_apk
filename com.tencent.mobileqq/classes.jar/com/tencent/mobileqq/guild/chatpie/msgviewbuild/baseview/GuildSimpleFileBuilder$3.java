package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class GuildSimpleFileBuilder$3
  implements View.OnLayoutChangeListener
{
  GuildSimpleFileBuilder$3(GuildSimpleFileBuilder paramGuildSimpleFileBuilder, Resources paramResources, Drawable paramDrawable) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getWidth();
    paramInt1 = (int)(AIOUtils.b(3.0F, this.a) / paramInt1 * 10000.0F);
    this.b.setLevel(paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildSimpleFileBuilder.3
 * JD-Core Version:    0.7.0.1
 */