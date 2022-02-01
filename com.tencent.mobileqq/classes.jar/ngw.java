import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.avgame.qav.AVGameBusinessCtrl.2.1;
import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.QavDef.MultiUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

public class ngw
  extends biiz
{
  ngw(ngu paramngu) {}
  
  public void onEnterRoom()
  {
    if (!ngu.a()) {}
    do
    {
      return;
      bija.d("AVGameBusinessCtrl", "onEnterRoom success.");
      ??? = ngu.a(this.a).a();
    } while (??? == null);
    ngu.a(this.a, true);
    ngu.b(this.a, false);
    ngu.c(this.a, true);
    ((nhn)???).a(2);
    this.a.b(true);
    this.a.c(true);
    nht.a().a().post(new AVGameBusinessCtrl.2.1(this));
    if (Build.VERSION.SDK_INT >= 16) {
      mxh.a(biin.a().a());
    }
    ??? = new IntentFilter();
    ((IntentFilter)???).addAction("android.intent.action.HEADSET_PLUG");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(ngu.a(this.a), (IntentFilter)???);
    if (ngu.a(this.a) != null) {
      ngu.a(this.a).a(0);
    }
    ngu.a(this.a, null);
    ngu.b(this.a);
    nje.a().a("param_QAVEnterRoom", 0);
    synchronized (ngu.a(this.a))
    {
      Iterator localIterator = ngu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public void onError(int paramInt)
  {
    bija.d("AVGameBusinessCtrl", "onError, errorType[" + paramInt + "]");
    if ((paramInt == 2) || (paramInt == 1))
    {
      bija.d("AVGameBusinessCtrl", "onEnterRoom failed. errorType = " + paramInt);
      if (ngu.a(this.a).a() == null)
      {
        bija.a("AVGameBusinessCtrl", "onEnterRoom failed. session == null.");
        return;
      }
      ngu.a(this.a).b(ngu.a(this.a).a().a);
      bcef.b(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
      if (ngu.a(this.a) != null) {
        ngu.a(this.a).a(paramInt);
      }
      ngu.a(this.a, null);
    }
    for (;;)
    {
      nje.a().a("param_QAVEnterRoom", paramInt);
      synchronized (ngu.a(this.a))
      {
        Iterator localIterator = ngu.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((myh)localWeakReference.get()).a(paramInt);
      }
      if ((paramInt == 4) || (paramInt != 3)) {}
    }
  }
  
  public void onGoOffStageRet(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = nhn.a(paramInt, paramLong);
    localObject = ngu.a(this.a).a((String)localObject);
    if (localObject == null) {
      bija.a("AVGameBusinessCtrl", "onGoOffStageRet failed. session == null.");
    }
    AVGameCameraAssistant localAVGameCameraAssistant;
    do
    {
      return;
      bija.d("AVGameBusinessCtrl", "onGoOffStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
      if (!((nhn)localObject).a(1)) {
        break;
      }
      localAVGameCameraAssistant = this.a.a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.b((nhn)localObject);
    return;
    ((nhn)localObject).b(0);
  }
  
  public void onGoOnStageRet(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = nhn.a(paramInt, paramLong);
    localObject = ngu.a(this.a).a((String)localObject);
    if (localObject == null) {
      bija.a("AVGameBusinessCtrl", "onGoOnStageRet failed. session == null.");
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
            bija.d("AVGameBusinessCtrl", "onGoOnStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
            if (!paramBoolean) {
              break;
            }
          } while (((nhn)localObject).d != 1);
          localAVGameCameraAssistant = this.a.a();
        } while (localAVGameCameraAssistant == null);
        localAVGameCameraAssistant.a((nhn)localObject);
        return;
        if (!((nhn)localObject).a(1)) {
          break;
        }
        localAVGameCameraAssistant = this.a.a();
      } while (localAVGameCameraAssistant == null);
      localAVGameCameraAssistant.b((nhn)localObject);
      return;
    } while (((nhn)localObject).d != 1);
    ((nhn)localObject).b(0);
  }
  
  public void onMemberVideoInOrOut(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 1;
    bija.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. videoIn = " + paramBoolean + ", userUin = " + paramLong1);
    ??? = nhn.a(paramInt1, paramLong2);
    ??? = ngu.a(this.a).a((String)???);
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onMemberVideoInOrOut failed. session == null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((nhn)???).a(paramLong1, paramBoolean, paramInt1);
      bija.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. updateUserCameraVideoStatus result = " + bool);
      synchronized (ngu.a(this.a))
      {
        Iterator localIterator = ngu.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((myh)localWeakReference.get()).a(paramBoolean, paramLong1, 1);
      }
    }
  }
  
  public void onSelfVolumeUpdate(int paramInt)
  {
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onSelfVolumeUpdate failed. session == null.");
      return;
    }
    ??? = ((nhn)???).a();
    if (??? != null) {
      ((AVGameUserInfo)???).mVolumeValue = paramInt;
    }
    synchronized (ngu.a(this.a))
    {
      Iterator localIterator = ngu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).b(paramInt);
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
      bija.c("AVGameBusinessCtrl", bool);
      synchronized (ngu.a(this.a))
      {
        Iterator localIterator = ngu.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((myh)localWeakReference.get()).c(paramInt);
      }
    }
  }
  
  public void onSystemCallStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "onSystemCallStateChanged, isCalling[" + paramBoolean + "], enter[" + ngu.a(this.a) + "]");
    }
    if (paramBoolean) {
      this.a.d();
    }
    for (;;)
    {
      synchronized (ngu.a(this.a))
      {
        Iterator localIterator = ngu.a(this.a).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null)) {
          continue;
        }
        ((myh)localWeakReference.get()).a(paramBoolean);
      }
      this.a.c();
    }
    if ((paramBoolean) && (ngu.a(this.a))) {
      bijd.a().c();
    }
  }
  
  public void onUserAudioAvailable(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bija.d("AVGameBusinessCtrl", "onUserAudioAvailable. uin = " + paramMultiUserInfo.mUin + ", available = " + paramBoolean);
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onUserAudioAvailable failed. session == null.");
      return;
    }
    ((nhn)???).a(paramMultiUserInfo);
    synchronized (ngu.a(this.a))
    {
      Iterator localIterator = ngu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean);
        }
      }
    }
  }
  
  public void onUserEnter(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bija.d("AVGameBusinessCtrl", "onUserEnter. uin = " + paramMultiUserInfo.mUin + ", isMicOn = " + paramMultiUserInfo.mMicOn);
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onUserEnter failed. session == null.");
      return;
    }
    ??? = ((nhn)???).a(paramMultiUserInfo);
    if (??? != null)
    {
      ((AVGameUserInfo)???).mEnterTime = System.currentTimeMillis();
      bija.d("AVGameBusinessCtrl", "onUserEnter time is " + ((AVGameUserInfo)???).mEnterTime);
    }
    synchronized (ngu.a(this.a))
    {
      Iterator localIterator = ngu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).a(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void onUserExit(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bija.d("AVGameBusinessCtrl", "onUserExit. uin = " + paramMultiUserInfo.mUin);
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onUserExit failed. session == null.");
      return;
    }
    ((nhn)???).a(paramMultiUserInfo.mUin);
    synchronized (ngu.a(this.a))
    {
      Iterator localIterator = ngu.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).b(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void onUserFirstVideoFrameIn(long paramLong, int paramInt)
  {
    bija.c("AVGameBusinessCtrl", "onUserFirstVideoFrameIn. userUin = " + paramLong + ", videoSrcType = " + paramInt);
  }
  
  public void onUserSpeaking(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onUserSpeaking failed. session == null.");
      return;
    }
    ??? = ((nhn)???).a(paramMultiUserInfo);
    if (((AVGameUserInfo)???).mIsSpeaking != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((AVGameUserInfo)???).mIsSpeaking = paramBoolean;
      ((AVGameUserInfo)???).mAudioEnergy = paramInt;
      if ((QLog.isDevelopLevel()) || (i != 0)) {
        bija.d("AVGameBusinessCtrl", "onUserSpeaking. uin[ " + paramMultiUserInfo.mUin + "], isSpeaking[" + paramBoolean + "], audioEnergy[" + paramInt + "]");
      }
      if ((paramBoolean) && (paramInt < 10)) {
        break;
      }
      synchronized (ngu.a(this.a))
      {
        Iterator localIterator = ngu.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((myh)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean, paramInt);
      }
    }
  }
  
  public void onUserUpdate(List<QavDef.MultiUserInfo> paramList)
  {
    ??? = ngu.a(this.a).a();
    if (??? == null)
    {
      bija.a("AVGameBusinessCtrl", "onUserUpdate failed. session == null.");
      return;
    }
    Object localObject2 = new ArrayList(paramList.size());
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)((Iterator)localObject3).next();
      bija.d("AVGameBusinessCtrl", "onUserUpdate. uin = " + localMultiUserInfo.mUin + ", isMicOn = " + localMultiUserInfo.mMicOn);
      ((nhn)???).a(localMultiUserInfo);
      ((List)localObject2).add(Long.valueOf(localMultiUserInfo.mUin));
    }
    ((nhn)???).a((List)localObject2);
    synchronized (ngu.a(this.a))
    {
      localObject2 = ngu.a(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((WeakReference)localObject3).get() != null)) {
          ((myh)((WeakReference)localObject3).get()).a(paramList);
        }
      }
    }
  }
  
  public void onUserVideoSrcChange(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngw
 * JD-Core Version:    0.7.0.1
 */