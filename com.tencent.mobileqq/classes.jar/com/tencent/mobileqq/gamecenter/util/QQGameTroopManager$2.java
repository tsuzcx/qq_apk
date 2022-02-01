package com.tencent.mobileqq.gamecenter.util;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import tencent.im.qqgame.QQGameMemberSelectInfo.QueryOldFriendsRsp;

class QQGameTroopManager$2
  implements WadlTrpcListener
{
  QQGameTroopManager$2(QQGameTroopManager paramQQGameTroopManager) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new QQGameTroopManager.2.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    QQGameTroopManager.b.clear();
    int i = 0;
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null)) {
      try
      {
        paramIntent = new QQGameMemberSelectInfo.QueryOldFriendsRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        if (paramIntent.uinList.get() != null) {
          QQGameTroopManager.b.addAll(paramIntent.uinList.get());
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e("QQGameTroopManager", 1, paramIntent, new Object[0]);
      }
    }
    this.a.b();
    this.a.a("friends");
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onTrpcRsp,:gameFriendList size:");
      if (QQGameTroopManager.b != null) {
        i = QQGameTroopManager.b.size();
      }
      paramIntent.append(i);
      paramIntent.append(",cost:");
      paramIntent.append(System.currentTimeMillis() - QQGameTroopManager.a(this.a));
      QLog.i("QQGameTroopManager", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.2
 * JD-Core Version:    0.7.0.1
 */