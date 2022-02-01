package com.tencent.mobileqq.troop.utils;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class GetOnlineMemberTipsRunnable
  implements Runnable
{
  protected WeakReference<TroopChatPie> a;
  
  public GetOnlineMemberTipsRunnable(TroopChatPie paramTroopChatPie)
  {
    this.a = new WeakReference(paramTroopChatPie);
  }
  
  public void run()
  {
    TroopChatPie localTroopChatPie = (TroopChatPie)this.a.get();
    if (localTroopChatPie == null) {}
    do
    {
      do
      {
        return;
      } while ((localTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (localTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (localTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localTroopChatPie.a() == null));
      TroopHandler localTroopHandler = (TroopHandler)localTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      String str = localTroopChatPie.a().a;
      if (!TextUtils.isEmpty(str))
      {
        localTroopHandler.r(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(localTroopChatPie.b, 2, "mGetOnlineMemberTipsRunnable, getSessionInfo().curFriendUin == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.GetOnlineMemberTipsRunnable
 * JD-Core Version:    0.7.0.1
 */