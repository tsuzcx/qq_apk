package com.tencent.mobileqq.gamecenter.util;

import android.content.Intent;
import android.os.Handler;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.GroupMemberInfo;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupMemberInfoRsp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class QQGameTroopManager$3
  implements WadlTrpcListener
{
  QQGameTroopManager$3(QQGameTroopManager paramQQGameTroopManager) {}
  
  public HashSet<String> getFilterCmds()
  {
    return new QQGameTroopManager.3.1(this);
  }
  
  public void onTrpcRsp(Intent paramIntent, String paramString, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.get() != null)) {
      try
      {
        paramIntent = new sgame_qgroup_datacard.QueryGroupMemberInfoRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        paramIntent = paramIntent.memberList.get();
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramString = paramIntent.iterator();
          while (paramString.hasNext())
          {
            paramTrpcInovkeRsp = (sgame_qgroup_datacard.GroupMemberInfo)paramString.next();
            Map localMap = QQGameTroopManager.d;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramTrpcInovkeRsp.uin.get());
            localStringBuilder.append("");
            localMap.put(localStringBuilder.toString(), paramTrpcInovkeRsp);
          }
          ThreadManager.getUIHandlerV2().post(new QQGameTroopManager.3.2(this));
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("onTrpcRsp,:memberList size:");
          int i;
          if (paramIntent == null) {
            i = 0;
          } else {
            i = paramIntent.size();
          }
          paramString.append(i);
          QLog.i("QQGameTroopManager", 2, paramString.toString());
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQGameTroopManager", 2, paramIntent, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.3
 * JD-Core Version:    0.7.0.1
 */