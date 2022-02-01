package com.tencent.timi.game.component.chat.message;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/image/URLDrawable;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class TeamMessageItemView$blueDrawable$2
  extends Lambda
  implements Function0<URLDrawable>
{
  TeamMessageItemView$blueDrawable$2(TeamMessageItemView paramTeamMessageItemView)
  {
    super(0);
  }
  
  public final URLDrawable invoke()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)TeamMessageItemView.a(this.this$0));
    localURLDrawableOptions.mFailedDrawable = ((Drawable)TeamMessageItemView.a(this.this$0));
    return ((IDrawableService)ServiceCenter.a(IDrawableService.class)).a("https://cdn.yes.qq.com/smoba/team/tg_team_msg_blue_bg1.png", localURLDrawableOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView.blueDrawable.2
 * JD-Core Version:    0.7.0.1
 */