package com.tencent.timi.game.liveroom.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.timi.game.room.api.SimpleYoloRoomCommonListener;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/AnchorOnlineUserView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "getListener", "()Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;", "setListener", "(Lcom/tencent/timi/game/room/api/SimpleYoloRoomCommonListener;)V", "intChange2Str", "", "number", "onAttachedToWindow", "", "onDetachedFromWindow", "refresh", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorOnlineUserView
  extends FrameLayout
{
  public static final AnchorOnlineUserView.Companion a = new AnchorOnlineUserView.Companion(null);
  @NotNull
  private static final String c = "AnchorOnlineUserView";
  @NotNull
  private SimpleYoloRoomCommonListener b;
  private HashMap d;
  
  @JvmOverloads
  public AnchorOnlineUserView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorOnlineUserView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorOnlineUserView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(2131629411, (ViewGroup)this);
    setOnClickListener((View.OnClickListener)AnchorOnlineUserView.1.a);
    ((AvatarRoundImageView)a(2131428998)).setOnClickListener((View.OnClickListener)AnchorOnlineUserView.2.a);
    ((AvatarRoundImageView)a(2131429001)).setOnClickListener((View.OnClickListener)AnchorOnlineUserView.3.a);
    ((AvatarRoundImageView)a(2131429003)).setOnClickListener((View.OnClickListener)AnchorOnlineUserView.4.a);
    this.b = ((SimpleYoloRoomCommonListener)new AnchorOnlineUserView.listener.1(this));
  }
  
  public View a(int paramInt)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    View localView2 = (View)this.d.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.d.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public final SimpleYoloRoomCommonListener getListener()
  {
    return this.b;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public final void setListener(@NotNull SimpleYoloRoomCommonListener paramSimpleYoloRoomCommonListener)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleYoloRoomCommonListener, "<set-?>");
    this.b = paramSimpleYoloRoomCommonListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorOnlineUserView
 * JD-Core Version:    0.7.0.1
 */