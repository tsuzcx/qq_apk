package com.tencent.timi.game.userinfo.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;
import com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/view/TimiAvatarRoundImageUrlViewImpl;", "Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarSize", "defaultResId", "setAvatarUrl", "", "url", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class TimiAvatarRoundImageUrlViewImpl
  extends TimiRoundImageView
{
  private int b = 2130853132;
  private final int c = 128;
  
  public TimiAvatarRoundImageUrlViewImpl(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public TimiAvatarRoundImageUrlViewImpl(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TimiAvatarRoundImageUrlViewImpl(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void setAvatarUrl(@Nullable String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      setImageResource(this.b);
      return;
    }
    TimiGameAvatarUtil.a.a(paramString, (ImageView)this, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageUrlViewImpl
 * JD-Core Version:    0.7.0.1
 */