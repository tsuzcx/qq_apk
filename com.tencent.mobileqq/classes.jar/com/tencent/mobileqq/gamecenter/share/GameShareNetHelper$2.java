package com.tencent.mobileqq.gamecenter.share;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetArkTailRsp reportObserver:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramBundle);
      ((StringBuilder)localObject1).append("|msghashcode:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.hashCode());
      QLog.d("GameShare.NetHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).saveValueToMsg("game_source_aio_txt", paramBundle.desc, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      ((IGameShareUtil)QRoute.api(IGameShareUtil.class)).saveValueToMsg("game_source_aio_url", paramBundle.jump_url, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject1 = (IGameShareUtil)QRoute.api(IGameShareUtil.class);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundle.type);
      ((StringBuilder)localObject2).append("");
      ((IGameShareUtil)localObject1).saveValueToMsg("game_source_type_aio", ((StringBuilder)localObject2).toString(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      localObject1 = (IGameShareUtil)QRoute.api(IGameShareUtil.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundle.sub_type);
      ((StringBuilder)localObject2).append("");
      ((IGameShareUtil)localObject1).saveValueToMsg("game_source_subtype_aio", ((StringBuilder)localObject2).toString(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramBundle = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          localObject2 = new Message();
          ((Message)localObject2).what = 78;
          ((Message)localObject2).arg1 = 891;
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
          ((Message)localObject2).setData(localBundle);
          ((MqqHandler)localObject1).sendMessage((Message)localObject2);
        }
        ThreadManager.excute(new GameShareNetHelper.2.1(this, paramBundle), 32, null, false);
      }
    }
    GameShareNetHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterShareGameShareNetHelper).remove(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2
 * JD-Core Version:    0.7.0.1
 */