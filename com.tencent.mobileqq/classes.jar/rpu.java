import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class rpu
  extends FriendListObserver
{
  public rpu(BaseChatPie paramBaseChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    int k = 0;
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    paramString = MsgProxyUtils.q;
    int m = paramString.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        j = paramString[i];
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == j) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break;
        }
        this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new rpv(this));
        return;
      }
      i += 1;
    }
  }
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.b)
      {
        paramString1 = this.a.d.getText().toString();
        this.a.d.setContentDescription(paramString1);
        this.a.a().setTitle(this.a.d.getText());
      }
    } while (!QLog.isDevelopLevel());
    DatingUtil.a("Q.aio.BaseChatPie", new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label313;
        }
        i = 1;
        break;
        if (MultiMsgManager.a().jdField_a_of_type_Int != 2) {
          this.a.c.dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          MultiMsgManager.a().b.putAll((Map)paramObject);
        }
        if (MultiMsgManager.a().b.size() == 0) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433407, 0).b(this.a.a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            this.a.a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
          }
        }
      }
      label313:
      i = 0;
    }
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.y();
    }
  }
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    if (this.a.g != 0) {}
    while ((RichStatItemBuilder.a == 0L) || (!(paramObject instanceof RichStatus.SigZanInfo))) {
      return;
    }
    ThreadManager.post(new rpx(this, (RichStatus.SigZanInfo)paramObject), 5, null, false);
  }
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    VasUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Set localSet = (Set)paramObject;
    int k = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label56:
    Object localObject1;
    ChatMessage localChatMessage;
    label114:
    int j;
    if (i < k)
    {
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramObject);
        localChatMessage = AIOUtils.a(paramObject);
        if (!localChatMessage.isSend()) {
          break label265;
        }
        paramObject = localChatMessage.selfuin;
        Object localObject2 = (FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          localObject2 = ((FriendsManager)localObject2).a(paramObject);
          if (localObject2 != null)
          {
            Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
            if (localObject3 != null)
            {
              if (((Long)localObject3).longValue() == 0L) {
                break label322;
              }
              localObject3 = ((AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a(((Long)localObject3).longValue());
              localObject1 = ((BaseBubbleBuilder.ViewHolder)localObject1).a;
              if (i == k) {
                break label316;
              }
              j = 1;
              label238:
              ((PendantInfo)localObject3).a((View)localObject1, j, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label56;
      break;
      label265:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label114;
      }
      paramObject = localChatMessage.senderuin;
      break label114;
      label316:
      j = 2;
      break label238;
      label322:
      if (((BaseBubbleBuilder.ViewHolder)localObject1).a.a != null)
      {
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.a.setImageDrawable(null);
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.a.setVisibility(8);
      }
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      UinFraudInfo.a().a(paramLong);
      return;
    }
    UinFraudInfo.a().a(paramLong, paramInt2);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new rpw(this, paramLong));
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "onSetComment curFriendNick" + Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d));
        }
        this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      } while (!AppSetting.b);
      paramString1 = this.a.d.getText().toString();
      this.a.d.setContentDescription(paramString1);
      this.a.a().setTitle(this.a.d.getText());
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.n(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.a(false, false);
      return;
    }
    this.a.a(false, false);
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap)
  {
    if ((!paramBoolean) && (this.a.q())) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2130838735, this.a.jdField_a_of_type_AndroidContentContext.getString(2131434497), 0).b(this.a.a());
    }
  }
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap paramHashMap)
  {
    if (!paramHashMap.containsKey(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i = 0;
    label20:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramHashMap);
        paramHashMap = AIOUtils.a(paramHashMap);
        if ((localViewHolder != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000)) {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001) && (paramHashMap.istroop != 10002)) {
            break label170;
          }
        }
      }
    }
    label170:
    for (paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramHashMap.senderuin, true);; paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin))
    {
      localViewHolder.a.setHeaderIcon(paramHashMap);
      i += 1;
      break label20;
      break;
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramString == null)) {
      return;
    }
    int i = 0;
    label17:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    ChatMessage localChatMessage;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        localChatMessage = AIOUtils.a((View)localObject);
        if ((localViewHolder != null) && (localChatMessage.senderuin != null) && (paramString.equals(localChatMessage.senderuin)))
        {
          if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
            break label207;
          }
          localObject = localChatMessage.frienduin;
          label139:
          if ((localChatMessage.istroop != 1010) && (localChatMessage.istroop != 1001) && (localChatMessage.istroop != 10002)) {
            break label217;
          }
        }
      }
    }
    label207:
    label217:
    for (Object localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, (String)localObject, true);; localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject))
    {
      localViewHolder.a.setHeaderIcon(localObject);
      i += 1;
      break label17;
      break;
      localObject = localChatMessage.senderuin;
      break label139;
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      this.a.b(1);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034) || (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    String str = null;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
      str = ContactUtils.l(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onUpdateFriendInfo title" + Utils.a(str));
      }
      this.a.d.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (!AppSetting.b) {
        break;
      }
      paramString = this.a.d.getText().toString();
      this.a.d.setContentDescription(paramString);
      this.a.a().setTitle(this.a.d.getText());
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
        str = CrmUtils.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      } else if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        str = ContactUtils.n(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.y();
  }
  
  protected void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpu
 * JD-Core Version:    0.7.0.1
 */