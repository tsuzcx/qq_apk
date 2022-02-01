package com.tencent.timi.game.component.chat.at;

import android.text.TextUtils;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/at/AtMsgManager;", "", "()V", "msgListenerMap", "", "", "Lcom/tencent/timi/game/tim/api/message/IMsgListener;", "msgManagerMap", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "endListener", "", "groupId", "hasRemindUser", "chatId", "msgId", "needNeedRemindUser", "", "startListener", "myUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "AtMsgListener", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AtMsgManager
{
  public static final AtMsgManager.Companion a = new AtMsgManager.Companion(null);
  @NotNull
  private static final AtMsgManager d = new AtMsgManager();
  @NotNull
  private static Map<String, List<String>> e = (Map)new HashMap();
  private Map<String, IMsgListener> b = (Map)new HashMap();
  private Map<String, IMsgManager> c = (Map)new HashMap();
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupId");
    Logger.b("AtMsgManager ", "endListener ");
    IMsgManager localIMsgManager = (IMsgManager)this.c.get(paramString);
    if (localIMsgManager != null) {
      localIMsgManager.b((IMsgListener)this.b.get(paramString));
    }
    this.c.remove(paramString);
    e.remove(paramString);
  }
  
  public final void a(@NotNull String paramString, @NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "groupId");
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "myUserId");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startListener ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(' ');
    Logger.b("AtMsgManager ", ((StringBuilder)localObject).toString());
    a(paramString);
    this.c.put(paramString, ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(Long.parseLong(paramString)));
    localObject = (List)new ArrayList();
    e.put(paramString, localObject);
    this.b.put(paramString, new AtMsgManager.AtMsgListener(paramQQUserId, (List)localObject));
    paramQQUserId = (IMsgManager)this.c.get(paramString);
    if (paramQQUserId != null) {
      paramQQUserId.a((IMsgListener)this.b.get(paramString));
    }
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "chatId");
    Intrinsics.checkParameterIsNotNull(paramString2, "msgId");
    boolean bool3 = TextUtils.isEmpty((CharSequence)paramString2);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString1 = (List)e.get(paramString1);
      bool1 = bool2;
      if (paramString1 != null) {
        bool1 = paramString1.contains(paramString2);
      }
    }
    return bool1;
  }
  
  public final void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "chatId");
    Intrinsics.checkParameterIsNotNull(paramString2, "msgId");
    if (!TextUtils.isEmpty((CharSequence)paramString2))
    {
      List localList = (List)e.get(paramString1);
      if ((localList != null) && (localList.contains(paramString2) == true))
      {
        paramString1 = (List)e.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.at.AtMsgManager
 * JD-Core Version:    0.7.0.1
 */