package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.IResultListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.YoloRoomActionMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutRoomAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomLeaveAction;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/TeamActionMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionTv", "Landroid/widget/TextView;", "teamLeaderColorSpan", "Landroid/text/style/ForegroundColorSpan;", "getShortNick", "", "nick", "handleActionMsg", "", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "renderUI", "showNickActionDesc", "userId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "suffix", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamActionMessageItemView
  extends CenterMessageView
{
  private final TextView a;
  private final ForegroundColorSpan b = new ForegroundColorSpan(Color.parseColor("#4D94FF"));
  private HashMap c;
  
  @JvmOverloads
  public TeamActionMessageItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TeamActionMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TeamActionMessageItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2131629486);
    paramContext = findViewById(2131427506);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.actionTv)");
    this.a = ((TextView)paramContext);
  }
  
  private final String a(String paramString)
  {
    if (paramString.length() > 8)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString != null)
      {
        paramString = paramString.substring(0, 6);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString);
        localStringBuilder.append("...");
        return localStringBuilder.toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return paramString;
  }
  
  private final void a(CommonOuterClass.QQUserId paramQQUserId, String paramString)
  {
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(paramQQUserId.uid.get(), (IResultListener)new TeamActionMessageItemView.showNickActionDesc.1(this, paramQQUserId, paramString));
  }
  
  private final void b(IMsg paramIMsg)
  {
    Object localObject = paramIMsg.g().yolo_room_action_msg.yolo_room_action;
    int i = ((YoloRoomOuterClass.YoloRoomAction)localObject).action_type.get();
    if (i != 19)
    {
      if (i != 108)
      {
        if (i != 251)
        {
          if (i != 101)
          {
            if (i != 102)
            {
              this.a.setText((CharSequence)"[收到一条消息，当前版本不支持查看，请更新至新版本]");
              return;
            }
            paramIMsg = ((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_room_leave_action.user_id;
            Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "action.yolo_room_leave_action.user_id");
            a(paramIMsg, "离开了车队");
            return;
          }
          paramIMsg = ((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_room_enter_action.user_id;
          Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "action.yolo_room_enter_action.user_id");
          a(paramIMsg, "加入了车队");
          return;
        }
        paramIMsg = ((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_smoba_room_owner_change_action.from_user_id;
        localObject = ((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_smoba_room_owner_change_action.to_user_id;
        ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).b(paramIMsg.uid.get(), (IResultListener)new TeamActionMessageItemView.handleActionMsg.1(this, paramIMsg, (CommonOuterClass.QQUserId)localObject));
        return;
      }
      this.a.setText((CharSequence)((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_room_update_game_route_info_action.status_change_text.get());
      return;
    }
    paramIMsg = ((YoloRoomOuterClass.YoloRoomAction)localObject).yolo_room_kick_out_room_action.user_id;
    Intrinsics.checkExpressionValueIsNotNull(paramIMsg, "action.yolo_room_kick_out_room_action.user_id");
    a(paramIMsg, "离开了车队");
  }
  
  public View a(int paramInt)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    View localView2 = (View)this.c.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.c.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void a(@NotNull IMsg paramIMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramIMsg, "msg");
    super.a(paramIMsg);
    b(paramIMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamActionMessageItemView
 * JD-Core Version:    0.7.0.1
 */