package com.tencent.mobileqq.richstatus;

import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import mqq.os.MqqHandler;

class StatusManager$3$2
  implements Runnable
{
  StatusManager$3$2(StatusManager.3 param3, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a, null);
    FriendsManager localFriendsManager = (FriendsManager)StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      Object localObject2 = localFriendsManager.a(StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3.a).getAccount();
      }
      localObject2 = ExtensionRichStatus.a((ExtensionInfo)localObject1);
      if ((localObject2 != null) && ((!TextUtils.isEmpty(((RichStatus)localObject2).actionText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).dataText)) || (!TextUtils.isEmpty(((RichStatus)localObject2).toSpannableStringWithoutAction())))) {
        break label219;
      }
      i = 1;
      if ((this.jdField_a_of_type_Boolean) && (i == 0))
      {
        long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
        ExtensionRichStatus.a((ExtensionInfo)localObject1, new byte[0], l);
        localFriendsManager.a((ExtensionInfo)localObject1);
      }
    }
    ThreadManager.getUIHandler().post(new StatusManager.3.2.1(this));
    Object localObject1 = VasFontIPCModule.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = j;; i = -1)
    {
      ((VasFontIPCModule)localObject1).a(i, RichStatus.getEmptyStatus(), null, 1);
      return;
      label219:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.2
 * JD-Core Version:    0.7.0.1
 */