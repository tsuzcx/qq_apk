package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class GameChatMessageHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private View.OnClickListener k()
  {
    if ((this.c instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.c).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if ((localObject instanceof GameMsgChatPie))
        {
          localObject = (GameMsgChatPie)localObject;
          if (this.a.isSend()) {
            return ((GameMsgChatPie)localObject).a();
          }
          return ((GameMsgChatPie)localObject).bz();
        }
      }
    }
    return null;
  }
  
  protected void b()
  {
    if (this.a.isSend()) {
      localObject = RoleIdUtil.a(this.a);
    } else {
      localObject = RoleIdUtil.b(this.a);
    }
    Object localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameUsrDrawable(this.c, this.b, (String)localObject);
    if (localObject == null)
    {
      b(this.c.getResources().getDrawable(2130841060));
      return;
    }
    b(localObject);
  }
  
  protected void c()
  {
    a(k());
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.a);
  }
  
  public boolean h()
  {
    return this.a.istroop == 10007;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameChatMessageHeadIconController
 * JD-Core Version:    0.7.0.1
 */