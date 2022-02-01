package com.tencent.mobileqq.studyroom.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager.TroopStudyMemberChangeObserver;
import com.tencent.mobileqq.studyroom.channel.StudyRoomAVBizHandler;
import com.tencent.mobileqq.studyroom.channel.StudyRoomHandler;
import com.tencent.mobileqq.studyroom.channel.StudyRoomObserver;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfBean;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;
import com.tencent.mobileqq.studyroom.utils.PluginUtils;
import com.tencent.mobileqq.studyroom.utils.PluginUtils.SimplePluginCallback;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import tencent.im.oidb.cmd0x857.TroopTips0x857.StudyRoomMemberChangePush;

public class StudyRoomManagerImpl
  extends StudyRoomManager
{
  private volatile QQAppInterface a;
  private volatile long b = 0L;
  private final StudyRoomObserver c;
  private final HashMap<String, Integer> d = new HashMap();
  private final List<StudyRoomManager.TroopStudyMemberChangeObserver> e = new ArrayList();
  
  public StudyRoomManagerImpl(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.c = new StudyRoomManagerImpl.1(this);
    this.a.addObserver(this.c);
  }
  
  private void a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAVUnableToast res = ");
    localStringBuilder.append(paramString);
    QLog.i("studyroom.StudyRoomManager", 1, localStringBuilder.toString());
    if ((!"未知的业务".equals(paramString)) && (!"IPC调用出错，返回数据为空".equals(paramString))) {
      paramString = String.format(paramContext.getResources().getString(2131887170), new Object[] { paramString });
    } else {
      paramString = paramContext.getResources().getString(2131893649);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAVUnableToast msg = ");
    localStringBuilder.append(paramString);
    QLog.i("studyroom.StudyRoomManager", 1, localStringBuilder.toString());
    QQToast.makeText(paramContext, paramString, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMemberChangedEvent troopUin ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" newMemberCount:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
    this.d.remove(paramString);
    this.d.put(paramString, Integer.valueOf(paramInt));
    b(paramString, paramInt);
    localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((StudyRoomManager.TroopStudyMemberChangeObserver)((Iterator)localObject).next()).a(paramString, paramInt);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    Object localObject = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).e(paramString);
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.getStudyRoomOpen()) && (paramInt <= 0))
      {
        localTroopInfo.setStudyRoomOpen(false);
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = this.a.getMessageFacade();
        ((QQMessageFacade)localObject).a(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
        return;
      }
      if ((!localTroopInfo.getStudyRoomOpen()) && (paramInt > 0))
      {
        localTroopInfo.setStudyRoomOpen(true);
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = this.a.getMessageFacade();
        ((QQMessageFacade)localObject).a(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
      }
    }
    else
    {
      QLog.i("studyroom.StudyRoomManager", 1, "can't find troopinfo");
    }
  }
  
  private boolean c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAVEnable res = ");
    localStringBuilder.append(paramString);
    QLog.i("studyroom.StudyRoomManager", 1, localStringBuilder.toString());
    return "true".equals(paramString);
  }
  
  public void a(Context paramContext)
  {
    StudyRoomConfBean localStudyRoomConfBean = StudyRoomConfProcessor.b();
    if ((localStudyRoomConfBean != null) && (localStudyRoomConfBean.a()) && (NetworkUtil.isWifiEnabled(paramContext)))
    {
      long l = System.currentTimeMillis();
      if (l - this.b > 1800000L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "preDownload");
        this.b = l;
        PluginUtils.a(paramContext, new Bundle(), true, new PluginUtils.SimplePluginCallback());
        return;
      }
      QLog.w("studyroom.StudyRoomManager", 4, "preDownload too fast");
    }
  }
  
  public void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    QLog.i("studyroom.StudyRoomManager", 1, "openPluginPage.");
    if ("preload".equals(paramString))
    {
      b(paramContext);
      QLog.i("studyroom.StudyRoomManager", 1, "openPluginPage  ACTION_PRELOAD");
      return;
    }
    QLog.i("studyroom.StudyRoomManager", 1, "openPluginPage state check.");
    Object localObject1 = StudyRoomAVBizHandler.a().a(paramContext);
    if (!c((String)localObject1))
    {
      QLog.e("studyroom.StudyRoomManager", 4, "block because AV is not enable.");
      a(paramContext, (String)localObject1);
      return;
    }
    if ((!this.a.isVideoChatting()) && (!this.a.getAVNotifyCenter().d()))
    {
      if (this.a.getAVNotifyCenter().g() > 0L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because getChatingRelationId()>0");
        QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      int j = 0;
      int i = 0;
      localObject1 = (HashMap)this.a.getAVNotifyCenter().s();
      if (localObject1 != null)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break label391;
          }
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((Map.Entry)localObject2).getKey() != null) && (((Map.Entry)localObject2).getValue() != null))
          {
            long l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
            j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
            if ((j == 2) || (j == 12))
            {
              localObject2 = this.a.getAVNotifyCenter().a(l, j);
              if ((localObject2 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject2).c > 0))
              {
                localObject2 = this.a.getAVNotifyCenter().h(l);
                if (localObject2 != null)
                {
                  localObject2 = ((Vector)localObject2).iterator();
                  if (((Iterator)localObject2).hasNext())
                  {
                    AVNotifyCenter.UserInfo localUserInfo = (AVNotifyCenter.UserInfo)((Iterator)localObject2).next();
                    if ((localUserInfo == null) || (!TextUtils.equals(String.valueOf(localUserInfo.a), this.a.getCurrentUin()))) {
                      break;
                    }
                    i = 1;
                  }
                }
              }
            }
          }
        }
      }
      label391:
      if (j != 0)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because group video");
        QQToast.makeText(paramContext, 2131893651, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
        return;
      }
      StudyRoomLoadingFragment.a(paramString, paramHashMap);
      return;
    }
    QLog.d("studyroom.StudyRoomManager", 4, "block because isVideoChatting() && isAvChating()");
    QQToast.makeText(paramContext, 2131893650, 1).show(paramContext.getResources().getDimensionPixelSize(2131299920));
  }
  
  public void a(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver)
  {
    this.e.add(paramTroopStudyMemberChangeObserver);
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getStudyMemberCountFromServer ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
    localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramString);
    if ((localObject != null) && (((TroopInfo)localObject).getStudyRoomOpen()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start getStudyMember ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
      ((StudyRoomHandler)this.a.getBusinessHandler(StudyRoomHandler.class.getName())).a(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte, String paramString)
  {
    TroopTips0x857.StudyRoomMemberChangePush localStudyRoomMemberChangePush = new TroopTips0x857.StudyRoomMemberChangePush();
    try
    {
      localStudyRoomMemberChangePush.mergeFrom(paramArrayOfByte);
      a(paramString, localStudyRoomMemberChangePush.member_count.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramString = new StringBuilder();
      paramString.append("handleRoomMemberChangePush decode error, e=");
      paramString.append(paramArrayOfByte.toString());
      QLog.i("studyroom.StudyRoomManager", 1, paramString.toString());
    }
  }
  
  public int b(String paramString)
  {
    paramString = (Integer)this.d.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void b(Context paramContext)
  {
    StudyRoomConfProcessor.b();
    QLog.i("studyroom.StudyRoomManager", 1, "StudyRoomManager openPluginPage preload");
    PluginUtils.a(paramContext, new Bundle(), true, new PluginUtils.SimplePluginCallback());
  }
  
  public void b(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver)
  {
    this.e.remove(paramTroopStudyMemberChangeObserver);
  }
  
  public void onDestroy()
  {
    this.a.removeObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomManagerImpl
 * JD-Core Version:    0.7.0.1
 */