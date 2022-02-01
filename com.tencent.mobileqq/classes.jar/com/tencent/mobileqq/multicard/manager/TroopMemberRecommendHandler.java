package com.tencent.mobileqq.multicard.manager;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.EntryDelay;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendCard;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendPerson;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.ReqBody;
import tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RspBody;

public class TroopMemberRecommendHandler
  extends BusinessHandler
{
  private TroopMemberRecommendManager a;
  private QQAppInterface b;
  
  public TroopMemberRecommendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.b = paramQQAppInterface;
    this.a = ((TroopMemberRecommendManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MEMBER_RECOMMEND_MANAGER));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg = new oidb_cmd0xdcc.RspBody();
    int i = -1;
    boolean bool2 = bool1;
    int j;
    if (bool1)
    {
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      bool2 = bool1;
      i = j;
      if (j != 0)
      {
        bool2 = false;
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetTroopMemRecommendCards, isSuc=");
      paramFromServiceMsg.append(bool2);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      QLog.i("TroopMemberRecommend.Handler", 2, paramFromServiceMsg.toString());
    }
    paramObject = new ArrayList();
    long l2;
    if (bool2) {
      l2 = 0L;
    }
    for (;;)
    {
      long l1;
      try
      {
        paramFromServiceMsg = paramToServiceMsg.rpt_msg_recommend_card.get();
        Object localObject2 = paramToServiceMsg.rpt_msg_entry_delay.get();
        if (paramToServiceMsg.uint64_group_id.has()) {
          l1 = paramToServiceMsg.uint64_group_id.get();
        } else {
          l1 = 0L;
        }
        j = i;
        try
        {
          if (paramToServiceMsg.uint32_timestamp.has())
          {
            j = i;
            l2 = paramToServiceMsg.uint32_timestamp.get();
          }
          j = i;
          Object localObject1 = this.a.a();
          k = i;
          long l3;
          if (localObject2 != null)
          {
            k = i;
            j = i;
            if (((List)localObject2).size() > 0)
            {
              j = i;
              paramToServiceMsg = ((List)localObject2).iterator();
              k = i;
              j = i;
              if (paramToServiceMsg.hasNext())
              {
                j = i;
                localObject2 = (oidb_cmd0xdcc.EntryDelay)paramToServiceMsg.next();
                j = i;
                if (!((oidb_cmd0xdcc.EntryDelay)localObject2).em_entry.has()) {
                  break label1312;
                }
                j = i;
                k = ((oidb_cmd0xdcc.EntryDelay)localObject2).em_entry.get();
                j = i;
                if (((oidb_cmd0xdcc.EntryDelay)localObject2).uint32_delay.has())
                {
                  j = i;
                  m = ((oidb_cmd0xdcc.EntryDelay)localObject2).uint32_delay.get();
                }
                else
                {
                  m = 86400;
                }
                j = i;
                l3 = m + l2;
                i = j;
              }
            }
          }
          try
          {
            if (!QLog.isColorLevel()) {
              break label1318;
            }
            i = j;
            localObject2 = new StringBuilder();
            i = j;
            ((StringBuilder)localObject2).append("handleGetTroopMemRecommendCards, nextFetchTS =");
            i = j;
            ((StringBuilder)localObject2).append(l3);
            i = j;
            QLog.i("TroopMemberRecommend.Handler", 2, ((StringBuilder)localObject2).toString());
            if (k == 11)
            {
              i = j;
              localObject2 = ((SharedPreferences)localObject1).edit();
              i = j;
              localObject3 = new StringBuilder();
              i = j;
              ((StringBuilder)localObject3).append("key_LeftSlide_fetch_ts");
              i = j;
              ((StringBuilder)localObject3).append(String.valueOf(l1));
              i = j;
              ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), l3).commit();
            }
            else if (k == 12)
            {
              i = j;
              localObject2 = ((SharedPreferences)localObject1).edit();
              i = j;
              localObject3 = new StringBuilder();
              i = j;
              ((StringBuilder)localObject3).append("key_AIO_fetch_ts");
              i = j;
              ((StringBuilder)localObject3).append(String.valueOf(l1));
              i = j;
              ((SharedPreferences.Editor)localObject2).putLong(((StringBuilder)localObject3).toString(), l3).commit();
            }
          }
          catch (Exception paramToServiceMsg)
          {
            Object localObject3;
            oidb_cmd0xdcc.RecommendPerson localRecommendPerson1;
            RecommendPerson localRecommendPerson;
            break label1242;
          }
          if (paramFromServiceMsg != null)
          {
            i = k;
            if (paramFromServiceMsg.size() > 0)
            {
              i = k;
              localObject1 = paramFromServiceMsg.iterator();
              i = k;
              if (((Iterator)localObject1).hasNext())
              {
                i = k;
                localObject2 = (oidb_cmd0xdcc.RecommendCard)((Iterator)localObject1).next();
                i = k;
                paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject2).rpt_msg_person.get();
                if (paramToServiceMsg == null) {
                  continue;
                }
                i = k;
                if (paramToServiceMsg.size() <= 0) {
                  continue;
                }
                i = k;
                localObject3 = paramToServiceMsg.iterator();
                j = 0;
                i = k;
                if (!((Iterator)localObject3).hasNext()) {
                  continue;
                }
                i = k;
                localRecommendPerson1 = (oidb_cmd0xdcc.RecommendPerson)((Iterator)localObject3).next();
                i = k;
                localRecommendPerson = new RecommendPerson();
                i = k;
                localRecommendPerson.troopUin = String.valueOf(l1);
                i = k;
                if (!((oidb_cmd0xdcc.RecommendCard)localObject2).enum_card_id.has()) {
                  break label1328;
                }
                i = k;
                m = ((oidb_cmd0xdcc.RecommendCard)localObject2).enum_card_id.get();
                i = k;
                localRecommendPerson.cardTypeID = m;
                i = k;
                bool1 = ((oidb_cmd0xdcc.RecommendCard)localObject2).bytes_main_title.has();
                paramFromServiceMsg = "";
                if (!bool1) {
                  break label1334;
                }
                i = k;
                paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject2).bytes_main_title.get().toStringUtf8();
                i = k;
                localRecommendPerson.cardMainTitle = paramToServiceMsg;
                i = k;
                if (!((oidb_cmd0xdcc.RecommendCard)localObject2).bytes_sub_title.has()) {
                  break label1340;
                }
                i = k;
                paramToServiceMsg = ((oidb_cmd0xdcc.RecommendCard)localObject2).bytes_sub_title.get().toStringUtf8();
                i = k;
                localRecommendPerson.cardSubTitle = paramToServiceMsg;
                i = k;
                if (!((oidb_cmd0xdcc.RecommendCard)localObject2).uint32_show_max.has()) {
                  break label1346;
                }
                i = k;
                m = ((oidb_cmd0xdcc.RecommendCard)localObject2).uint32_show_max.get();
                i = k;
                localRecommendPerson.cardMaxDisplayPersonNum = m;
                i = k;
                if (!localRecommendPerson1.uint64_uin.has()) {
                  break label1352;
                }
                i = k;
                paramToServiceMsg = String.valueOf(localRecommendPerson1.uint64_uin.get());
                i = k;
                localRecommendPerson.uin = paramToServiceMsg;
                i = k;
                if (!localRecommendPerson1.bytes_reason.has()) {
                  break label1358;
                }
                i = k;
                paramToServiceMsg = localRecommendPerson1.bytes_reason.get().toStringUtf8();
                i = k;
                localRecommendPerson.recommendReason = paramToServiceMsg;
                i = k;
                if (!localRecommendPerson1.bytes_keyword.has()) {
                  break label1364;
                }
                i = k;
                paramToServiceMsg = localRecommendPerson1.bytes_keyword.get().toStringUtf8();
                i = k;
                localRecommendPerson.recommendKeyword = paramToServiceMsg;
                i = k;
                if (!localRecommendPerson1.bytes_alghrithm.has()) {
                  break label1370;
                }
                i = k;
                paramToServiceMsg = localRecommendPerson1.bytes_alghrithm.get().toStringUtf8();
                i = k;
                localRecommendPerson.recommendALghrithm = paramToServiceMsg;
                paramToServiceMsg = paramFromServiceMsg;
                i = k;
                if (localRecommendPerson1.bytes_recall.has())
                {
                  i = k;
                  paramToServiceMsg = localRecommendPerson1.bytes_recall.get().toStringUtf8();
                }
                i = k;
                localRecommendPerson.recommendRecall = paramToServiceMsg;
                i = k;
                localRecommendPerson.addedIndex = j;
                j += 1;
                i = k;
                paramObject.add(localRecommendPerson);
                continue;
              }
            }
          }
          i = k;
          ThreadManager.excute(new TroopMemberRecommendHandler.1(this, l1, paramObject), 32, null, true);
        }
        catch (Exception paramToServiceMsg)
        {
          i = j;
        }
        paramFromServiceMsg = new StringBuilder();
      }
      catch (Exception paramToServiceMsg)
      {
        l1 = 0L;
      }
      label1242:
      paramFromServiceMsg.append("handleGetTroopMemRecommendCards exception, isSuc=");
      paramFromServiceMsg.append(bool2);
      paramFromServiceMsg.append(",oidbesult=");
      paramFromServiceMsg.append(i);
      QLog.i("TroopMemberRecommend.Handler", 1, paramFromServiceMsg.toString(), paramToServiceMsg);
      paramToServiceMsg = this.a;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool2, paramObject, String.valueOf(l1));
      }
      return;
      label1312:
      int k = 0;
      continue;
      label1318:
      continue;
      i = j;
      continue;
      label1328:
      int m = 0;
      continue;
      label1334:
      paramToServiceMsg = "";
      continue;
      label1340:
      paramToServiceMsg = "";
      continue;
      label1346:
      m = 0;
      continue;
      label1352:
      paramToServiceMsg = "";
      continue;
      label1358:
      paramToServiceMsg = "";
      continue;
      label1364:
      paramToServiceMsg = "";
      continue;
      label1370:
      paramToServiceMsg = "";
    }
  }
  
  public void a(String paramString, int paramInt, List<Long> paramList)
  {
    try
    {
      oidb_cmd0xdcc.ReqBody localReqBody = new oidb_cmd0xdcc.ReqBody();
      localReqBody.uint64_group_id.set(Long.parseLong(paramString));
      localReqBody.em_entry.set(paramInt);
      ArrayList localArrayList = new ArrayList();
      if (paramList != null) {
        localArrayList.addAll(localArrayList);
      }
      localReqBody.rpt_uint64_filter_uin.set(localArrayList);
      paramList = makeOIDBPkg("OidbSvc.oidb_0xdcc", 3532, 1, localReqBody.toByteArray());
      paramList.extraData.putString("troop_uin", paramString);
      sendPbReq(paramList);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getTroopMemRecommendCards, request =");
        paramString.append(paramList);
        QLog.i("TroopMemberRecommend.Handler", 2, paramString.toString());
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
      }
      else if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002))
      {
        bool1 = paramEntityManager.update(paramEntity);
      }
      paramEntityManager.close();
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramEntityManager = new StringBuilder();
      paramEntityManager.append("updateEntity em closed e=");
      paramEntityManager.append(paramEntity.getTableName());
      QLog.d("TroopMemberRecommend.Handler", 2, paramEntityManager.toString());
    }
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopMemberRecommendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onReceive() res =");
      localStringBuilder.append(paramFromServiceMsg.getServiceCmd());
      QLog.d("TroopMemberRecommend.Handler", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.oidb_0xdcc".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.manager.TroopMemberRecommendHandler
 * JD-Core Version:    0.7.0.1
 */