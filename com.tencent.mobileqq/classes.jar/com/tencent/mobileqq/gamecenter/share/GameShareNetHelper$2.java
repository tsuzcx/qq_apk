package com.tencent.mobileqq.gamecenter.share;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class GameShareNetHelper$2
  implements BusinessObserver
{
  GameShareNetHelper$2(GameShareNetHelper paramGameShareNetHelper, MessageRecord paramMessageRecord, WeakReference paramWeakReference) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetArkTailRsp)paramBundle.getSerializable("rsp");
    if (QLog.isColorLevel()) {
      QLog.d("GameShare.NetHelper", 2, "GetArkTailRsp reportObserver:" + paramBoolean + "|" + paramBundle + "|msghashcode:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.hashCode());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      GameShareUtil.a("game_source_aio_txt", paramBundle.desc, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      GameShareUtil.a("game_source_aio_url", paramBundle.jump_url, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      GameShareUtil.a("game_source_type_aio", paramBundle.type + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      GameShareUtil.a("game_source_subtype_aio", paramBundle.sub_type + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramBundle = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null)
      {
        MqqHandler localMqqHandler = paramBundle.getHandler(ChatActivity.class);
        if (localMqqHandler != null)
        {
          Message localMessage = new Message();
          localMessage.what = 78;
          localMessage.arg1 = 891;
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
          localMessage.setData(localBundle);
          localMqqHandler.sendMessage(localMessage);
        }
        ThreadManager.excute(new GameShareNetHelper.2.1(this, paramBundle), 32, null, false);
      }
    }
    GameShareNetHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper).remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2
 * JD-Core Version:    0.7.0.1
 */