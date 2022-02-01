package com.tencent.qav.controller.multi;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.qav.QavDef.MultiParams;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.QavCtrl;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qav.monitor.CallingStateMonitor.CallingStateListener;
import com.tencent.qav.observer.ObserverDispatcher;
import com.tencent.qav.thread.ThreadManager;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.avcore.jni.data.AVUserInfo;>;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MultiOperatorImpl
  extends MultiOperatorBase
  implements IMultiOperator, CallingStateMonitor.CallingStateListener
{
  private int jdField_a_of_type_Int;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected QavDef.MultiParams a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected Map<Long, QavDef.MultiUserInfo> a;
  protected boolean a;
  protected boolean b = false;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public MultiOperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface)
  {
    this(paramContext, paramLong, paramVideoChannelInterface, true);
  }
  
  public MultiOperatorImpl(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface, boolean paramBoolean)
  {
    super(paramContext, paramLong, paramVideoChannelInterface, paramBoolean);
    AVLog.c("MultiOperatorImpl", String.format("MultiOperatorImpl context=%s selfUin=%s videoChannel=%s", new Object[] { paramContext, Long.valueOf(paramLong), paramVideoChannelInterface }));
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    CallingStateMonitor.a().a(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.requestMemPosInfoList();
    }
  }
  
  private void e(boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImpl", String.format("setLocalAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioSend(true);
        return;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioSend(true);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    AVLog.c("MultiOperatorImpl", String.format("setRemoteAudioEnable enable=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startAudioRecv();
        return;
      }
      this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.stopAudioRecv();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(QavDef.MultiParams paramMultiParams)
  {
    for (;;)
    {
      try
      {
        AVLog.c("MultiOperatorImpl", String.format("enterRoom param=%s", new Object[] { paramMultiParams }));
        boolean bool1 = CallingStateMonitor.a().a();
        boolean bool2 = CallingStateMonitor.a().b();
        AVLog.c("MultiOperatorImpl", String.format("enterRoom isVideoChatting=%s isPhoneCalling=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        if ((!bool1) && (!bool2))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            AVLog.a("MultiOperatorImpl", "enterRoom duplicate call.");
            return -3;
          }
          QavCtrl.a(this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface);
          QavCtrl.a(this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long);
          QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl;
          int j = -1;
          if (localQQGAudioCtrl != null)
          {
            this.jdField_a_of_type_ComTencentQavQavDef$MultiParams = paramMultiParams;
            if (paramMultiParams.e == 1)
            {
              i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.startCommonGAudio(paramMultiParams.jdField_a_of_type_Int, paramMultiParams.b, paramMultiParams.c, paramMultiParams.d, this.jdField_a_of_type_Long, paramMultiParams.jdField_a_of_type_JavaLangString, paramMultiParams.e, paramMultiParams.jdField_a_of_type_ArrayOfByte, 0);
            }
            else
            {
              if (paramMultiParams.e != 2) {
                if (paramMultiParams.e != 4) {
                  break label327;
                }
              }
              i = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.commonRequest(paramMultiParams.jdField_a_of_type_Int, paramMultiParams.d, paramMultiParams.b, paramMultiParams.c, paramMultiParams.e, 0, 8, "", paramMultiParams.e, paramMultiParams.jdField_a_of_type_ArrayOfByte, paramMultiParams.f);
            }
            AVLog.c("MultiOperatorImpl", String.format("enterRoom result=%s", new Object[] { Integer.valueOf(i) }));
            if (i == 0) {
              h();
            }
            this.jdField_a_of_type_Boolean = true;
            this.b = false;
          }
          else
          {
            i = -1;
          }
          if (i == 0) {
            j = 0;
          }
          return j;
        }
        else
        {
          AVLog.a("MultiOperatorImpl", "enterRoom device take up.");
          return -2;
        }
      }
      finally {}
      label327:
      int i = -1;
    }
  }
  
  protected QavDef.MultiUserInfo a(long paramLong)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (QavDef.MultiUserInfo)localMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null) {
      try
      {
        String str = this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.getNetWorkQualityRTT();
        return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  protected List<QavDef.MultiUserInfo> a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).values();
      if (!((Collection)localObject).isEmpty()) {
        return new ArrayList((Collection)localObject);
      }
    }
    return null;
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AVLog.c("MultiOperatorImpl", String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
      if (this.jdField_a_of_type_Boolean)
      {
        e();
        c(4);
      }
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.put(Long.valueOf(paramMultiUserInfo.mUin), paramMultiUserInfo);
    }
  }
  
  protected void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 5, new Object[] { paramMultiUserInfo, Boolean.valueOf(paramBoolean) });
  }
  
  public void a(boolean paramBoolean)
  {
    e(paramBoolean);
    this.c = paramBoolean;
  }
  
  protected QavDef.MultiUserInfo b(long paramLong)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      return (QavDef.MultiUserInfo)localMap.remove(Long.valueOf(paramLong));
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      if (Build.VERSION.SDK_INT >= 21) {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(3);
      } else {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(2);
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    catch (Exception localException)
    {
      Throwable localThrowable;
      break label144;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(3);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(true);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(3);
      this.jdField_a_of_type_Int = paramInt;
      return;
      label144:
      AVLog.a("MultiOperatorImpl", "setAudioRoute fail.", localThrowable);
    }
  }
  
  public void b(long paramLong, ArrayList<AVUserInfo> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQavQavDef$MultiParams;
    if (localObject == null) {
      return;
    }
    if (((QavDef.MultiParams)localObject).jdField_a_of_type_Int == 11)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        AVUserInfo localAVUserInfo = (AVUserInfo)localIterator.next();
        localObject = a(localAVUserInfo.account);
        paramArrayList = (ArrayList<AVUserInfo>)localObject;
        if (localObject == null)
        {
          paramArrayList = new QavDef.MultiUserInfo();
          paramArrayList.mUin = localAVUserInfo.account;
          paramArrayList.mMicOn = true;
          a(paramArrayList);
        }
        int i;
        if (TextUtils.isEmpty(paramArrayList.mOpenId))
        {
          paramArrayList.mOpenId = localAVUserInfo.openId;
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (i != 0)
        {
          b(paramArrayList);
          if (!paramArrayList.mMicOn) {
            a(paramArrayList, false);
          }
        }
      }
    }
    if (this.e)
    {
      paramArrayList = a();
      AVLog.c("MultiOperatorImpl", String.format("onMemberPosChanged groupId=%s userInfos=%s", new Object[] { Long.valueOf(paramLong), paramArrayList }));
      ObserverDispatcher.a().a(QavMultiObserver.class, 7, new Object[] { paramArrayList });
      this.e = false;
    }
  }
  
  protected void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 3, new Object[] { paramMultiUserInfo });
  }
  
  public void b(boolean paramBoolean)
  {
    f(paramBoolean);
    this.d = paramBoolean;
  }
  
  public void c() {}
  
  protected void c(int paramInt)
  {
    AVLog.a("MultiOperatorImpl", String.format("notifyError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    ObserverDispatcher.a().a(QavMultiObserver.class, 2, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void c(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    ObserverDispatcher.a().a(QavMultiObserver.class, 4, new Object[] { paramMultiUserInfo });
  }
  
  public void c(boolean paramBoolean)
  {
    a(1, paramBoolean);
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    a(2, paramBoolean);
  }
  
  public void e()
  {
    try
    {
      AVLog.c("MultiOperatorImpl", "exitRoom");
      this.jdField_a_of_type_ComTencentQavQavDef$MultiParams = null;
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl != null)
      {
        this.jdField_a_of_type_ComTencentAvGaudioQQGAudioCtrl.quitRoom(0);
        i();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    try
    {
      AVLog.c("MultiOperatorImpl", "updateRoomInfo");
      a();
      this.e = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g()
  {
    try
    {
      CallingStateMonitor.a().a(null);
      if (this.jdField_a_of_type_JavaUtilMap != null)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_JavaUtilMap = null;
      }
      super.g();
      return;
    }
    finally {}
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new MultiOperatorImpl.1(this);
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    }
  }
  
  protected void i()
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      ThreadManager.b(localRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
  }
  
  public void onCreateRoomSuc(int paramInt1, long paramLong, int paramInt2)
  {
    AVLog.c("MultiOperatorImpl", String.format("onCreateRoomSuc relationType=%s groupId=%s multiAvType=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2) }));
  }
  
  public void onGAudioMemberMicChanged(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = paramBoolean ^ true;
    AVLog.c("MultiOperatorImpl", String.format("onMemberMicChanged uin=%s available=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
    QavDef.MultiUserInfo localMultiUserInfo = a(paramLong);
    if (localMultiUserInfo != null)
    {
      localMultiUserInfo.mMicOn = (paramBoolean ^ true);
      if ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_Int != 11)) {
        a(localMultiUserInfo, bool);
      }
    }
  }
  
  public void onGAudioSDKError(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.a("MultiOperatorImpl", String.format("onGAudioSDKError relationType=%s groupId=%s reason=%s detail=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    e();
    i();
    if (paramInt2 == 15)
    {
      c(3);
      return;
    }
    c(2);
  }
  
  public void onGroupVideoClosed(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AVLog.c("MultiOperatorImpl", String.format("onGroupVideoClosed relationType=%s groupId=%s reason=%s avtype=%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    e();
    i();
    c(2);
  }
  
  public void onMAVMemberInOrOut(AVUserInfo paramAVUserInfo, long paramLong1, int paramInt1, int paramInt2, long paramLong2, int... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams == null) {
      return;
    }
    if (paramInt1 == 70)
    {
      AVLog.c("MultiOperatorImpl", String.format("onMemberIn uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      if (paramAVUserInfo.account == this.jdField_a_of_type_Long) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        i();
        ObserverDispatcher.a().a(QavMultiObserver.class, 1, new Object[0]);
      }
      paramVarArgs = a(paramAVUserInfo.account);
      if ((paramVarArgs == null) && (paramInt1 == 0))
      {
        paramVarArgs = new QavDef.MultiUserInfo();
        paramVarArgs.mUin = paramAVUserInfo.account;
        paramVarArgs.mMicOn = true;
        a(paramVarArgs);
        if (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_Int == 11)
        {
          a();
          return;
        }
        b(paramVarArgs);
        return;
      }
      paramAVUserInfo = paramVarArgs;
      if (paramInt1 != 0)
      {
        paramAVUserInfo = new QavDef.MultiUserInfo();
        paramAVUserInfo.mUin = this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_Long;
        paramAVUserInfo.mOpenId = this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_JavaLangString;
        paramAVUserInfo.mMicOn = true;
        a(paramAVUserInfo);
      }
      b(paramAVUserInfo);
      return;
    }
    if (paramInt1 == 71)
    {
      AVLog.c("MultiOperatorImpl", String.format("onMemberOut uin=%s groupId=%s", new Object[] { Long.valueOf(paramAVUserInfo.account), Long.valueOf(paramLong1) }));
      paramAVUserInfo = b(paramAVUserInfo.account);
      if (paramAVUserInfo != null) {
        c(paramAVUserInfo);
      }
    }
  }
  
  public void onMultiVideoChatMembersInfoChange(long paramLong1, long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 42) || (paramInt1 == 43))
    {
      boolean bool;
      if (paramInt1 == 42) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt2 = paramArrayOfLong.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        QavDef.MultiUserInfo localMultiUserInfo = a(paramArrayOfLong[paramInt1]);
        if ((localMultiUserInfo != null) && ((!TextUtils.isEmpty(localMultiUserInfo.mOpenId)) || (this.jdField_a_of_type_ComTencentQavQavDef$MultiParams.jdField_a_of_type_Int != 11))) {
          ObserverDispatcher.a().a(QavMultiObserver.class, 6, new Object[] { localMultiUserInfo, Boolean.valueOf(bool), Integer.valueOf(paramInt4) });
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onSelfAudioVolumeChange(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.controller.multi.MultiOperatorImpl
 * JD-Core Version:    0.7.0.1
 */