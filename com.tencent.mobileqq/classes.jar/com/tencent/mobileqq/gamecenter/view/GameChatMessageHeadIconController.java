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
import com.tencent.mobileqq.gamecenter.message.RoleIdUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class GameChatMessageHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private View.OnClickListener a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      Object localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof GameMsgChatPie))
        {
          localObject = (GameMsgChatPie)localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            return ((GameMsgChatPie)localObject).a();
          }
          return ((GameMsgChatPie)localObject).b();
        }
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 10007;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
      localObject = RoleIdUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    } else {
      localObject = RoleIdUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    Object localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameUsrDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
    if (localObject == null)
    {
      b(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840321));
      return;
    }
    b(localObject);
  }
  
  protected void c()
  {
    a(a());
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameChatMessageHeadIconController
 * JD-Core Version:    0.7.0.1
 */