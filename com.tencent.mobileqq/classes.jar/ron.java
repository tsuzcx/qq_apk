import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class ron
  implements Runnable
{
  public ron(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject1;
    StringBuilder localStringBuilder;
    Object localObject2;
    label703:
    label710:
    String str1;
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) && (!this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g == null)
      {
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, new View(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext));
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setId(2131361889);
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494143));
        localObject1 = new RelativeLayout.LayoutParams(-1, 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie), (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setId(2131361888);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setSingleLine();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838369));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setGravity(17);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setTextSize(2, 14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setBackgroundResource(2130838369);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494253));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.getPaddingTop(), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Float * 10.0F), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.getPaddingBottom());
        localObject1 = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131558669));
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131361889);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if ((ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)))
      {
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype != -2016) {
          break label710;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg.split("\\|");
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          break label703;
        }
        localObject1 = localObject1[0].trim();
      }
      for (;;)
      {
        localStringBuilder = new StringBuilder();
        localObject2 = TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message);
        if (localObject2 != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).c;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName == null) {
          break label1111;
        }
        localObject2 = localObject1;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131427486))) {
          break label947;
        }
        localObject1 = ((CharSequence)localObject1).toString();
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= EmotcationConstants.a.length) {
            break;
          }
          localObject2 = localObject1;
          if (((String)localObject1).indexOf('\024' + EmotcationConstants.a[i]) != -1) {
            localObject2 = ((String)localObject1).replace('\024' + EmotcationConstants.a[i], "\024" + (char)i);
          }
          i += 1;
          localObject1 = localObject2;
        }
        BaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).setVisibility(8);
        break;
        localObject1 = "";
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2011) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2059))
        {
          localObject1 = StructMsgFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgData);
          if (localObject1 != null) {}
          for (localObject1 = ((AbsStructMsg)localObject1).mMsgBrief;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msg) {
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2000)
        {
          if ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin)) || (FlashPicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message))) {}
          for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131435551);; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText()) {
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -7001)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131439041);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.getMessageText();
          localObject1 = localObject2;
          if (TroopRobotManager.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message))
          {
            if (!TroopRobotManager.d(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message)) {
              TroopRobotManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message);
            }
            str1 = TroopRobotManager.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message);
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(str1)) {
              localObject1 = str1;
            }
          }
        }
      }
      label947:
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.nickName);
      localObject1 = localObject2;
      localStringBuilder.append(":");
      if (!(localObject1 instanceof QQText)) {
        break label1707;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setText(((QQText)localObject1).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.requestLayout();
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setTag(this.jdField_a_of_type_AndroidContentIntent);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.getHandler();
        if (localObject1 != null)
        {
          ((Handler)localObject1).removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_b_of_type_JavaLangRunnable);
          ((Handler)localObject1).postDelayed(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_b_of_type_JavaLangRunnable, 10000L);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aC();
        return;
        label1111:
        String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
        if ((str2 == null) || (str2.length() == 0))
        {
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          break;
        }
        if (7000 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("subAccountLatestNick");
          if (str1 != null)
          {
            localObject2 = str1;
            if (str1.length() != 0) {}
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
          }
          localStringBuilder.append(str2);
          localStringBuilder.append("-");
          localStringBuilder.append((String)localObject2);
          break;
        }
        if ((1010 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) || (1001 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop))
        {
          if (String.valueOf(AppConstants.G).equals(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin))
          {
            str1 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin);
            localObject2 = str1;
            if (TextUtils.isEmpty(str1)) {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin;
            }
            localStringBuilder.append(str2);
            localStringBuilder.append("-");
            localStringBuilder.append((String)localObject2);
            if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -1024) {
              localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131437649), new Object[] { localObject2 });
            }
            break;
          }
          str1 = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          localObject2 = str1;
          if (!TextUtils.isEmpty(str1)) {
            continue;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin;
          continue;
        }
        if (1024 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          localObject2 = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localStringBuilder.append(str2);
            break;
          }
          localStringBuilder.append((String)localObject2);
          continue;
        }
        if (1029 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop)
        {
          localObject2 = ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "messageTips CampusCirCleRealName = " + Utils.b((String)localObject2));
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localStringBuilder.append(str2);
            break;
          }
          localStringBuilder.append((String)localObject2);
          continue;
        }
        if ((7220 == this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.extInt == 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin)))
        {
          localObject2 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.senderuin);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((PublicAccountInfo)localObject2).name)))
          {
            localStringBuilder.append(((PublicAccountInfo)localObject2).name);
            break;
          }
          localStringBuilder.append(str2);
          continue;
        }
        localStringBuilder.append(str2);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.aio.BaseChatPie", 2, localException.toString());
        continue;
      }
      label1707:
      localStringBuilder.append(localException);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ron
 * JD-Core Version:    0.7.0.1
 */