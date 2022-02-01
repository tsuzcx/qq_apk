package com.tencent.timi.game.profile.api.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.timi.game.profile.impl.view.ProfileMessageViewImpl;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/api/ui/ProfileMessageView;", "Lcom/tencent/timi/game/profile/impl/view/ProfileMessageViewImpl;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class ProfileMessageView
  extends ProfileMessageViewImpl
{
  private HashMap a;
  
  public ProfileMessageView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileMessageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileMessageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(int paramInt)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    View localView2 = (View)this.a.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.a.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.api.ui.ProfileMessageView
 * JD-Core Version:    0.7.0.1
 */