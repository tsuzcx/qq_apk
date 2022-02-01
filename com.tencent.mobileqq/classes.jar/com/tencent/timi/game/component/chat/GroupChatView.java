package com.tencent.timi.game.component.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/GroupChatView;", "Lcom/tencent/timi/game/component/chat/ChatView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMessageManager", "Lcom/tencent/timi/game/tim/api/message/IMsgManager;", "chatId", "", "init", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GroupChatView
  extends ChatView
{
  private HashMap b;
  
  public GroupChatView(@NotNull Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public GroupChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public GroupChatView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private final void e() {}
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public IMsgManager a(long paramLong)
  {
    return ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.GroupChatView
 * JD-Core Version:    0.7.0.1
 */