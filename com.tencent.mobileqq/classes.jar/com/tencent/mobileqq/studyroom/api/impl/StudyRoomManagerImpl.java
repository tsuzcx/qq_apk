package com.tencent.mobileqq.studyroom.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.UserInfo;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager.TroopStudyMemberChangeObserver;
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
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
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
  private volatile long jdField_a_of_type_Long = 0L;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new StudyRoomManagerImpl.2(this);
  private final GuardProcessExitListener jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener = new StudyRoomManagerImpl.1(this);
  private volatile QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final StudyRoomObserver jdField_a_of_type_ComTencentMobileqqStudyroomChannelStudyRoomObserver;
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private final HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final List<StudyRoomManager.TroopStudyMemberChangeObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public StudyRoomManagerImpl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqStudyroomChannelStudyRoomObserver = new StudyRoomManagerImpl.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqStudyroomChannelStudyRoomObserver);
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener, localIntentFilter);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMemberChangedEvent troopUin ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" newMemberCount:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
    b(paramString, paramInt);
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((StudyRoomManager.TroopStudyMemberChangeObserver)((Iterator)localObject).next()).a(paramString, paramInt);
    }
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b(String paramString, int paramInt)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject).a(paramString);
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.getStudyRoomOpen()) && (paramInt <= 0))
      {
        localTroopInfo.setStudyRoomOpen(false);
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        ((QQMessageFacade)localObject).a(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
        return;
      }
      if ((!localTroopInfo.getStudyRoomOpen()) && (paramInt > 0))
      {
        localTroopInfo.setStudyRoomOpen(true);
        ((TroopManager)localObject).b(localTroopInfo);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        ((QQMessageFacade)localObject).a(((QQMessageFacade)localObject).getLastMessage(paramString, 1));
      }
    }
    else
    {
      QLog.i("studyroom.StudyRoomManager", 1, "can't find troopinfo");
    }
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void a(Context paramContext)
  {
    StudyRoomConfBean localStudyRoomConfBean = StudyRoomConfProcessor.a();
    if ((localStudyRoomConfBean != null) && (localStudyRoomConfBean.a()) && (NetworkUtil.isWifiEnabled(paramContext)))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Long > 1800000L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "preDownload");
        this.jdField_a_of_type_Long = l;
        PluginUtils.a(paramContext, new Bundle(), true, new PluginUtils.SimplePluginCallback());
        return;
      }
      QLog.w("studyroom.StudyRoomManager", 4, "preDownload too fast");
    }
  }
  
  public void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if ("preload".equals(paramString))
    {
      b(paramContext);
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b() > 0L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because getChatingRelationId()>0");
        QQToast.a(paramContext, 2131695889, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      int j = 0;
      int i = 0;
      Object localObject1 = (HashMap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a();
      if (localObject1 != null)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break label330;
          }
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if ((localObject2 != null) && (((Map.Entry)localObject2).getKey() != null) && (((Map.Entry)localObject2).getValue() != null))
          {
            long l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
            j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
            if ((j == 2) || (j == 12))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l, j);
              if ((localObject2 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject2).a > 0))
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(l);
                if (localObject2 != null)
                {
                  localObject2 = ((Vector)localObject2).iterator();
                  if (((Iterator)localObject2).hasNext())
                  {
                    AVNotifyCenter.UserInfo localUserInfo = (AVNotifyCenter.UserInfo)((Iterator)localObject2).next();
                    if ((localUserInfo == null) || (!TextUtils.equals(String.valueOf(localUserInfo.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
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
      label330:
      if (j != 0)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because group video");
        QQToast.a(paramContext, 2131695890, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        return;
      }
      StudyRoomLoadingFragment.a(paramString, paramHashMap);
      return;
    }
    QLog.d("studyroom.StudyRoomManager", 4, "block because isVideoChatting() && isAvChating()");
    QQToast.a(paramContext, 2131695889, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  public void a(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramTroopStudyMemberChangeObserver);
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getStudyMemberCountFromServer ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if ((localObject != null) && (((TroopInfo)localObject).getStudyRoomOpen()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start getStudyMember ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("studyroom.StudyRoomManager", 1, ((StringBuilder)localObject).toString());
      ((StudyRoomHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(StudyRoomHandler.class.getName())).a(paramString);
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
  
  public void b(Context paramContext)
  {
    StudyRoomConfProcessor.a();
    QLog.i("studyroom.StudyRoomManager", 1, "StudyRoomManager openPluginPage preload");
    PluginUtils.a(paramContext, new Bundle(), true, new PluginUtils.SimplePluginCallback());
  }
  
  public void b(StudyRoomManager.TroopStudyMemberChangeObserver paramTroopStudyMemberChangeObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramTroopStudyMemberChangeObserver);
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          label20:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqStudyroomChannelStudyRoomObserver);
          return;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomManagerImpl
 * JD-Core Version:    0.7.0.1
 */