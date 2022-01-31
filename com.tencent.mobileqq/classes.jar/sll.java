import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class sll
  extends FriendListObserver
{
  public sll(Conversation paramConversation) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1 = (ProxyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
    if (localObject1 == null)
    {
      localObject1 = null;
      TroopAssistantManager.a().h(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject1 != null) {
        break label176;
      }
    }
    for (;;)
    {
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label186;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser.type == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin) == 3))
        {
          if (localObject1 != null) {
            ((RecentUserProxy)localObject1).b(localRecentUser);
          }
          RecentUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, 1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
        }
      }
      localObject1 = ((ProxyManager)localObject1).a();
      break;
      label176:
      localObject2 = ((RecentUserProxy)localObject1).a(false);
    }
    label186:
    this.a.a(9, AppConstants.B, 5000);
    this.a.a(9, AppConstants.aD, 5001);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onGetGenralSettings");
    }
  }
  
  protected void onGetStoreFace(boolean paramBoolean, String paramString)
  {
    onUpdateCustomHead(paramBoolean, paramString);
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.a(1009, 500L, true);
    }
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap != null) {
        break label64;
      }
    }
    label64:
    for (int i = 0;; i = paramMap.size())
    {
      QLog.d("Q.recent", 2, i);
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break;
      }
      return;
    }
    Object localObject = (ProxyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
    label111:
    String str;
    if (localObject == null)
    {
      localObject = null;
      paramMap = paramMap.entrySet().iterator();
      if (!paramMap.hasNext()) {
        break label330;
      }
      str = (String)((Map.Entry)paramMap.next()).getKey();
      i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
      if (i != 2) {
        break label312;
      }
      TroopAssistantManager.a().a(str, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      if ((i == 3) && (localObject != null)) {}
      try
      {
        RecentUser localRecentUser = ((RecentUserProxy)localObject).b(str, 1);
        if (localRecentUser != null)
        {
          ((RecentUserProxy)localObject).b(localRecentUser);
          RecentDataListManager.a().a(localRecentUser.uin + "-" + localRecentUser.type);
          ((RecentUserProxy)localObject).b(localRecentUser);
          RecentUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser.uin, 1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localRecentUser.uin, localRecentUser.type);
        }
      }
      catch (Exception localException)
      {
        label287:
        break label287;
      }
      this.a.a(9, str, 1);
      break label111;
      localObject = ((ProxyManager)localObject).a();
      break;
      label312:
      TroopAssistantManager.a().c(str, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    label330:
    this.a.a(9, AppConstants.B, 5000);
    this.a.a(9, AppConstants.aD, 5001);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      this.a.a(new sln(this, paramString));
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatedelfriend");
      }
      this.a.a(0L);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      return;
    }
    this.a.a(0L);
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onupdatefriendlist");
      }
      this.a.a(0L);
      this.a.a(new slm(this));
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if (paramBoolean) {
      this.a.a(new slp(this, paramArrayList));
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.recent", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if (paramBoolean) {
      this.a.a(0L);
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a(new slo(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sll
 * JD-Core Version:    0.7.0.1
 */