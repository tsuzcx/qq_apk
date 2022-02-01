package com.tencent.mobileqq.troop.troopgame;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopMemGradeLevelBuilder
{
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemGradeLevelBuilder.1(this, Looper.getMainLooper());
  private BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  
  public TroopMemGradeLevelBuilder(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) {
        return;
      }
      localObject = ((BaseChatItemLayout)localObject).a(NickNameChatItemLayoutProcessor.e);
      if (localObject == null) {
        return;
      }
      if (!((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()) {
        return;
      }
      if ((!AnonymousChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!"1000000".equals(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (!(localObject instanceof MessageForTroopConfess))
        {
          if (((ChatMessage)localObject).istroop != 1) {
            return;
          }
          ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).ansyCheckShowMsgGameGradeLevel(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, new TroopMemGradeLevelBuilder.3(this));
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemGradeLevelBuilder", 2, "handleMemberGradeLevel not need show");
      }
      a(false);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.getSubThreadHandler().post(new TroopMemGradeLevelBuilder.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder
 * JD-Core Version:    0.7.0.1
 */