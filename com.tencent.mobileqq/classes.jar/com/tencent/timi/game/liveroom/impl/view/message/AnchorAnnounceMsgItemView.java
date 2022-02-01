package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.ILiveReportService.DefaultImpls;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorAnnounceMsgItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "render", "", "announce", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "roomId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class AnchorAnnounceMsgItemView
  extends LinearLayout
{
  private HashMap a;
  
  @JvmOverloads
  public AnchorAnnounceMsgItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorAnnounceMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorAnnounceMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
    View.inflate(paramContext, 2131629401, (ViewGroup)this);
    setPadding(LayoutExKt.b(10), LayoutExKt.b(8), LayoutExKt.b(10), LayoutExKt.b(8));
    ViewExKt.a(this, LayoutExKt.b(15), new int[] { ResUtils.b(2131165574) });
    ((ImageView)a(2131428373)).setImageResource(2130853127);
    ((ImageView)a(2131428373)).setColorFilter(Color.parseColor("#8A8AFF"));
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
  
  public final void a(@NotNull AnnouncePushMessage paramAnnouncePushMessage, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnouncePushMessage, "announce");
    Object localObject1 = (TextView)a(2131428376);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "announceTv");
    ((TextView)localObject1).setText((CharSequence)paramAnnouncePushMessage.announce);
    localObject1 = (LinearLayout)a(2131428374);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "announceSettingLl");
    localObject1 = (View)localObject1;
    Object localObject2 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…eRoomService::class.java)");
    localObject2 = ((ITgLiveRoomService)localObject2).f();
    boolean bool;
    if ((localObject2 != null) && (((LiveUserInfo)localObject2).uid == paramAnnouncePushMessage.uid)) {
      bool = true;
    } else {
      bool = false;
    }
    ViewExKt.a((View)localObject1, bool);
    ((LinearLayout)a(2131428374)).setOnClickListener((View.OnClickListener)new AnchorAnnounceMsgItemView.render.1(paramLong));
    localObject1 = ServiceCenter.a(ITgLiveRoomService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ServiceCenter.getService…eRoomService::class.java)");
    localObject1 = ((ITgLiveRoomService)localObject1).f();
    if ((localObject1 != null) && (((LiveUserInfo)localObject1).uid == paramAnnouncePushMessage.uid))
    {
      paramAnnouncePushMessage = (ILiveReportService)ServiceCenter.a(ILiveReportService.class);
      localObject1 = (LinearLayout)a(2131428374);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "announceSettingLl");
      ILiveReportService.DefaultImpls.a(paramAnnouncePushMessage, (View)localObject1, true, null, "em_qqlive_set_announce", null, 16, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorAnnounceMsgItemView
 * JD-Core Version:    0.7.0.1
 */