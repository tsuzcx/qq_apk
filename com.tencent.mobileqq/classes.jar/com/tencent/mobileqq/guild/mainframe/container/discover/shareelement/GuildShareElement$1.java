package com.tencent.mobileqq.guild.mainframe.container.discover.shareelement;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;

class GuildShareElement$1
  implements ViewTreeObserver.OnPreDrawListener
{
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    GuildShareElement.b(this.b).a(this.a, GuildShareElement.a(this.b));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mInfo == ");
      localStringBuilder.append(GuildShareElement.b(this.b));
      QLog.i("GuildDiscover.GuildShareElement", 2, localStringBuilder.toString());
    }
    if (GuildShareElement.c(this.b))
    {
      this.a.setPivotX(GuildShareElement.b(this.b).e());
      this.a.setPivotY(GuildShareElement.b(this.b).f());
      this.a.setTranslationX(GuildShareElement.b(this.b).a());
      this.a.setTranslationY(GuildShareElement.b(this.b).b());
      this.a.setScaleX(GuildShareElement.b(this.b).c());
      this.a.setScaleY(GuildShareElement.b(this.b).d());
      this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      GuildShareElement.a(this.b, this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.shareelement.GuildShareElement.1
 * JD-Core Version:    0.7.0.1
 */