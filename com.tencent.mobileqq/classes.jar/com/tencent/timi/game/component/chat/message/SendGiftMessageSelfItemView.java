package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.timi.game.userinfo.api.view.AvatarTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/SendGiftMessageSelfItemView;", "Lcom/tencent/timi/game/component/chat/message/SendGiftMessageBaseItemView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "giftIv", "Lcom/tencent/image/URLImageView;", "sendGiftDetailTv", "Landroid/widget/TextView;", "usrNameClickView", "Landroid/view/View;", "usrNameTv", "Lcom/tencent/timi/game/userinfo/api/view/AvatarTextView;", "getGiftImageView", "getSendGiftDetailTextView", "getUsrNameClickView", "getUsrNameTextView", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SendGiftMessageSelfItemView
  extends SendGiftMessageBaseItemView
{
  private URLImageView b;
  private AvatarTextView c;
  private TextView d;
  private View e;
  private HashMap f;
  
  @JvmOverloads
  public SendGiftMessageSelfItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public SendGiftMessageSelfItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public SendGiftMessageSelfItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629481);
    paramContext = findViewById(2131434237);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.giftIv)");
    this.b = ((URLImageView)paramContext);
    paramContext = findViewById(2131449290);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.usrNameTv)");
    this.c = ((AvatarTextView)paramContext);
    paramContext = findViewById(2131445574);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.sendGiftDetailTv)");
    this.d = ((TextView)paramContext);
    paramContext = findViewById(2131430774);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.clickView)");
    this.e = paramContext;
  }
  
  public View a(int paramInt)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    View localView2 = (View)this.f.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.f.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public URLImageView getGiftImageView()
  {
    return this.b;
  }
  
  @NotNull
  public TextView getSendGiftDetailTextView()
  {
    return this.d;
  }
  
  @NotNull
  public View getUsrNameClickView()
  {
    return this.e;
  }
  
  @NotNull
  public AvatarTextView getUsrNameTextView()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.SendGiftMessageSelfItemView
 * JD-Core Version:    0.7.0.1
 */