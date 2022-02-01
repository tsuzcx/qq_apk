import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.avgame.qav.AVGameBusinessCtrl.2.1;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameSession.SessionStatus;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class nfo
  extends bkdo
{
  nfo(nfm paramnfm) {}
  
  public void onEnterRoom()
  {
    if (!nfm.a()) {}
    do
    {
      return;
      bkdp.d("AVGameBusinessCtrl", "onEnterRoom success.");
      ??? = nfm.a(this.a).a();
    } while (??? == null);
    nfm.a(this.a, true);
    nfm.b(this.a, false);
    nfm.c(this.a, true);
    ((AVGameSession)???).a(AVGameSession.SessionStatus.ENTERED);
    this.a.b(true);
    this.a.c(true);
    ngk.a().a().post(new AVGameBusinessCtrl.2.1(this));
    ??? = new IntentFilter();
    ((IntentFilter)???).addAction("android.intent.action.HEADSET_PLUG");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(nfm.a(this.a), (IntentFilter)???);
    if (nfm.a(this.a) != null) {
      nfm.a(this.a).a(0);
    }
    nfm.a(this.a, null);
    nfm.b(this.a);
    nhp.a().a("param_QAVEnterRoom", 0);
    synchronized (nfm.a(this.a))
    {
      Iterator localIterator = nfm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((mxw)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public void onError(int paramInt)
  {
    bkdp.d("AVGameBusinessCtrl", "onError, errorType[" + paramInt + "]");
    if ((paramInt == 2) || (paramInt == 1))
    {
      bkdp.d("AVGameBusinessCtrl", "onEnterRoom failed. errorType = " + paramInt);
      if (nfm.a(this.a).a() == null)
      {
        bkdp.a("AVGameBusinessCtrl", "onEnterRoom failed. session == null.");
        return;
      }
      nfm.a(this.a).b(nfm.a(this.a).a().a);
      bdll.b(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
      if (nfm.a(this.a) != null) {
        nfm.a(this.a).a(paramInt);
      }
      nfm.a(this.a, null);
    }
    for (;;)
    {
      nhp.a().a("param_QAVEnterRoom", paramInt);
      synchronized (nfm.a(this.a))
      {
        Iterator localIterator = nfm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((mxw)localWeakReference.get()).a(paramInt);
      }
      if ((paramInt == 4) || (paramInt != 3)) {}
    }
  }
  
  public void onGoOffStageRet(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = AVGameSession.a(paramInt, paramLong);
    localObject = nfm.a(this.a).a((String)localObject);
    if (localObject == null) {
      bkdp.a("AVGameBusinessCtrl", "onGoOffStageRet failed. session == null.");
    }
    AVGameCameraAssistant localAVGameCameraAssistant;
    do
    {
      return;
      bkdp.d("AVGameBusinessCtrl", "onGoOffStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
      if (!((AVGameSession)localObject).a(1)) {
        break;
      }
      localAVGameCameraAssistant = this.a.a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.b((AVGameSession)localObject);
    return;
    ((AVGameSession)localObject).a(0);
  }
  
  public void onGoOnStageRet(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = AVGameSession.a(paramInt, paramLong);
    localObject = nfm.a(this.a).a((String)localObject);
    if (localObject == null) {
      bkdp.a("AVGameBusinessCtrl", "onGoOnStageRet failed. session == null.");
    }
    do
    {
      AVGameCameraAssistant localAVGameCameraAssistant;
      do
      {
        do
        {
          do
          {
            return;
            bkdp.d("AVGameBusinessCtrl", "onGoOnStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
            if (!paramBoolean) {
              break;
            }
          } while (((AVGameSession)localObject).d != 1);
          localAVGameCameraAssistant = this.a.a();
        } while (localAVGameCameraAssistant == null);
        localAVGameCameraAssistant.a((AVGameSession)localObject);
        return;
        if (!((AVGameSession)localObject).a(1)) {
          break;
        }
        localAVGameCameraAssistant = this.a.a();
      } while (localAVGameCameraAssistant == null);
      localAVGameCameraAssistant.b((AVGameSession)localObject);
      return;
    } while (((AVGameSession)localObject).d != 1);
    ((AVGameSession)localObject).a(0);
  }
  
  public void onMemberVideoInOrOut(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 1;
    bkdp.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. videoIn = " + paramBoolean + ", userUin = " + paramLong1);
    ??? = AVGameSession.a(paramInt1, paramLong2);
    ??? = nfm.a(this.a).a((String)???);
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onMemberVideoInOrOut failed. session == null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((AVGameSession)???).a(paramLong1, paramBoolean, paramInt1);
      bkdp.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. updateUserCameraVideoStatus result = " + bool);
      synchronized (nfm.a(this.a))
      {
        Iterator localIterator = nfm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((mxw)localWeakReference.get()).a(paramBoolean, paramLong1, 1);
      }
    }
  }
  
  public void onSelfVolumeUpdate(int paramInt)
  {
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onSelfVolumeUpdate failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a();
    if (??? != null) {
      ((AVGameUserInfo)???).mVolumeValue = paramInt;
    }
    synchronized (nfm.a(this.a))
    {
      Iterator localIterator = nfm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((mxw)localWeakReference.get()).b(paramInt);
        }
      }
    }
  }
  
  public void onStartRemoteVideoRequestResult(int paramInt)
  {
    ??? = new StringBuilder().append("onStartRemoteVideoRequestResult. success = ");
    if (paramInt == 96) {}
    for (boolean bool = true;; bool = false)
    {
      bkdp.c("AVGameBusinessCtrl", bool);
      synchronized (nfm.a(this.a))
      {
        Iterator localIterator = nfm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((mxw)localWeakReference.get()).c(paramInt);
      }
    }
  }
  
  public void onSystemCallStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "onSystemCallStateChanged, isCalling[" + paramBoolean + "], enter[" + nfm.a(this.a) + "]");
    }
    if (paramBoolean) {
      this.a.d();
    }
    for (;;)
    {
      synchronized (nfm.a(this.a))
      {
        Iterator localIterator = nfm.a(this.a).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null)) {
          continue;
        }
        ((mxw)localWeakReference.get()).a(paramBoolean);
      }
      this.a.c();
    }
    if ((paramBoolean) && (nfm.a(this.a))) {
      bkds.a().c();
    }
  }
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bkdp.d("AVGameBusinessCtrl", "onUserAudioAvailable. uin = " + paramMultiUserInfo.mUin + ", available = " + paramBoolean);
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onUserAudioAvailable failed. session == null.");
      return;
    }
    ((AVGameSession)???).a(paramMultiUserInfo);
    synchronized (nfm.a(this.a))
    {
      Iterator localIterator = nfm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((mxw)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean);
        }
      }
    }
  }
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bkdp.d("AVGameBusinessCtrl", "onUserEnter. uin = " + paramMultiUserInfo.mUin + ", isMicOn = " + paramMultiUserInfo.mMicOn);
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onUserEnter failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a(paramMultiUserInfo);
    if (??? != null)
    {
      ((AVGameUserInfo)???).mEnterTime = System.currentTimeMillis();
      bkdp.d("AVGameBusinessCtrl", "onUserEnter time is " + ((AVGameUserInfo)???).mEnterTime);
    }
    synchronized (nfm.a(this.a))
    {
      Iterator localIterator = nfm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((mxw)localWeakReference.get()).a(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bkdp.d("AVGameBusinessCtrl", "onUserExit. uin = " + paramMultiUserInfo.mUin);
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onUserExit failed. session == null.");
      return;
    }
    ((AVGameSession)???).a(paramMultiUserInfo.mUin);
    synchronized (nfm.a(this.a))
    {
      Iterator localIterator = nfm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((mxw)localWeakReference.get()).b(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void onUserFirstVideoFrameIn(long paramLong, int paramInt)
  {
    bkdp.c("AVGameBusinessCtrl", "onUserFirstVideoFrameIn. userUin = " + paramLong + ", videoSrcType = " + paramInt);
  }
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onUserSpeaking failed. session == null.");
      return;
    }
    ??? = ((AVGameSession)???).a(paramMultiUserInfo);
    if (((AVGameUserInfo)???).mIsSpeaking != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((AVGameUserInfo)???).mIsSpeaking = paramBoolean;
      ((AVGameUserInfo)???).mAudioEnergy = paramInt;
      if ((QLog.isDevelopLevel()) || (i != 0)) {
        bkdp.d("AVGameBusinessCtrl", "onUserSpeaking. uin[ " + paramMultiUserInfo.mUin + "], isSpeaking[" + paramBoolean + "], audioEnergy[" + paramInt + "]");
      }
      if ((paramBoolean) && (paramInt < 10)) {
        break;
      }
      synchronized (nfm.a(this.a))
      {
        Iterator localIterator = nfm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((mxw)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean, paramInt);
      }
    }
  }
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList)
  {
    ??? = nfm.a(this.a).a();
    if (??? == null)
    {
      bkdp.a("AVGameBusinessCtrl", "onUserUpdate failed. session == null.");
      return;
    }
    Object localObject2 = new ArrayList(paramList.size());
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)((Iterator)localObject3).next();
      bkdp.d("AVGameBusinessCtrl", "onUserUpdate. uin = " + localMultiUserInfo.mUin + ", isMicOn = " + localMultiUserInfo.mMicOn);
      ((AVGameSession)???).a(localMultiUserInfo);
      ((List)localObject2).add(Long.valueOf(localMultiUserInfo.mUin));
    }
    ((AVGameSession)???).a((List)localObject2);
    synchronized (nfm.a(this.a))
    {
      localObject2 = nfm.a(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((WeakReference)localObject3).get() != null)) {
          ((mxw)((WeakReference)localObject3).get()).a(paramList);
        }
      }
    }
  }
  
  public void onUserVideoSrcChange(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfo
 * JD-Core Version:    0.7.0.1
 */