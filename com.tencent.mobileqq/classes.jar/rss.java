import Wallet.GoldMsgGetReq;
import Wallet.GoldMsgGetRsp;
import Wallet.GoldMsgSetReq;
import Wallet.GoldMsgSetRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet;
import java.util.List;

public class rss
  extends GoldConfigObserver
{
  public rss(BaseChatPie paramBaseChatPie) {}
  
  public void a()
  {
    if ((!this.a.I) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if ((!this.a.I) && (paramBundle != null))
    {
      paramBundle = paramBundle.getString("friendUin");
      if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.equals(this.a.a())))
      {
        paramBundle = GoldMsgChatHelper.GoldMsgFriendSet.a(paramBundle);
        if ((this.a instanceof FriendChatPie)) {
          ((FriendChatPie)this.a).a(paramBundle);
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (paramLong > 0L)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.c(this.a);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr == null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr = new GoldMsgAnimatorCtr(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector);
    }
    GoldMsgChatHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr, paramString1, paramString2, paramInt, paramLong1, paramLong2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, List paramList, boolean paramBoolean)
  {
    GoldMsgChatHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramString1, paramString2, paramInt, paramList, paramBoolean);
  }
  
  public void a(boolean paramBoolean, GoldMsgGetReq paramGoldMsgGetReq, GoldMsgGetRsp paramGoldMsgGetRsp)
  {
    if ((paramBoolean) && (!this.a.I) && (paramGoldMsgGetReq != null) && (paramGoldMsgGetReq.type == 3) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramGoldMsgGetReq.friendUin)))) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.d(this.a);
    }
  }
  
  public void a(boolean paramBoolean, GoldMsgSetReq paramGoldMsgSetReq, GoldMsgSetRsp paramGoldMsgSetRsp)
  {
    if ((paramGoldMsgSetReq != null) && (!this.a.I) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(paramGoldMsgSetReq.friendUin)))) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a(this.a, paramBoolean, paramGoldMsgSetReq, paramGoldMsgSetRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rss
 * JD-Core Version:    0.7.0.1
 */