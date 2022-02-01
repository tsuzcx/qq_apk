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

public class nno
  extends bjub
{
  nno(nnm paramnnm) {}
  
  public void a()
  {
    if (!nnm.a()) {}
    do
    {
      return;
      bjuc.d("AVGameBusinessCtrl", "onEnterRoom success.");
      ??? = nnm.a(this.a).a();
    } while (??? == null);
    nnm.a(this.a, true);
    nnm.b(this.a, false);
    nnm.c(this.a, true);
    ((nof)???).a(2);
    this.a.b(true);
    this.a.c(true);
    nom.a().a().post(new AVGameBusinessCtrl.2.1(this));
    if (Build.VERSION.SDK_INT >= 16) {
      lfm.a(nnm.a(this.a).a(), nnm.a(this.a));
    }
    ??? = new IntentFilter();
    ((IntentFilter)???).addAction("android.intent.action.HEADSET_PLUG");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    ((IntentFilter)???).addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(nnm.a(this.a), (IntentFilter)???);
    if (nnm.a(this.a) != null) {
      nnm.a(this.a).a(0);
    }
    nnm.a(this.a, null);
    nnm.b(this.a);
    nqc.a().a("param_QAVEnterRoom", 0);
    synchronized (nnm.a(this.a))
    {
      Iterator localIterator = nnm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((ndt)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    bjuc.d("AVGameBusinessCtrl", "onError, errorType[" + paramInt + "]");
    if ((paramInt == 2) || (paramInt == 1))
    {
      bjuc.d("AVGameBusinessCtrl", "onEnterRoom failed. errorType = " + paramInt);
      if (nnm.a(this.a).a() == null)
      {
        bjuc.a("AVGameBusinessCtrl", "onEnterRoom failed. session == null.");
        return;
      }
      nnm.a(this.a).b(nnm.a(this.a).a().a);
      bdla.b(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
      if (nnm.a(this.a) != null) {
        nnm.a(this.a).a(paramInt);
      }
      nnm.a(this.a, null);
    }
    for (;;)
    {
      nqc.a().a("param_QAVEnterRoom", paramInt);
      synchronized (nnm.a(this.a))
      {
        Iterator localIterator = nnm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((ndt)localWeakReference.get()).a(paramInt);
      }
      if ((paramInt == 4) || (paramInt != 3)) {}
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    bjuc.c("AVGameBusinessCtrl", "onUserFirstVideoFrameIn. userUin = " + paramLong + ", videoSrcType = " + paramInt);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bjuc.d("AVGameBusinessCtrl", "onUserEnter. uin = " + paramMultiUserInfo.mUin + ", isMicOn = " + paramMultiUserInfo.mMicOn);
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onUserEnter failed. session == null.");
      return;
    }
    ??? = ((nof)???).a(paramMultiUserInfo);
    if (??? != null)
    {
      ((AVGameUserInfo)???).mEnterTime = System.currentTimeMillis();
      bjuc.d("AVGameBusinessCtrl", "onUserEnter time is " + ((AVGameUserInfo)???).mEnterTime);
    }
    synchronized (nnm.a(this.a))
    {
      Iterator localIterator = nnm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((ndt)localWeakReference.get()).a(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean)
  {
    bjuc.d("AVGameBusinessCtrl", "onUserAudioAvailable. uin = " + paramMultiUserInfo.mUin + ", available = " + paramBoolean);
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onUserAudioAvailable failed. session == null.");
      return;
    }
    ((nof)???).a(paramMultiUserInfo);
    synchronized (nnm.a(this.a))
    {
      Iterator localIterator = nnm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((ndt)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean);
        }
      }
    }
  }
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt)
  {
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onUserSpeaking failed. session == null.");
      return;
    }
    ??? = ((nof)???).a(paramMultiUserInfo);
    if (((AVGameUserInfo)???).mIsSpeaking != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((AVGameUserInfo)???).mIsSpeaking = paramBoolean;
      ((AVGameUserInfo)???).mAudioEnergy = paramInt;
      if ((QLog.isDevelopLevel()) || (i != 0)) {
        bjuc.d("AVGameBusinessCtrl", "onUserSpeaking. uin[ " + paramMultiUserInfo.mUin + "], isSpeaking[" + paramBoolean + "], audioEnergy[" + paramInt + "]");
      }
      if ((paramBoolean) && (paramInt < 10)) {
        break;
      }
      synchronized (nnm.a(this.a))
      {
        Iterator localIterator = nnm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((ndt)localWeakReference.get()).a(paramMultiUserInfo, paramBoolean, paramInt);
      }
    }
  }
  
  public void a(List<QavDef.MultiUserInfo> paramList)
  {
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onUserUpdate failed. session == null.");
      return;
    }
    Object localObject2 = new ArrayList(paramList.size());
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)((Iterator)localObject3).next();
      bjuc.d("AVGameBusinessCtrl", "onUserUpdate. uin = " + localMultiUserInfo.mUin + ", isMicOn = " + localMultiUserInfo.mMicOn);
      ((nof)???).a(localMultiUserInfo);
      ((List)localObject2).add(Long.valueOf(localMultiUserInfo.mUin));
    }
    ((nof)???).a((List)localObject2);
    synchronized (nnm.a(this.a))
    {
      localObject2 = nnm.a(this.a).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (WeakReference)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((WeakReference)localObject3).get() != null)) {
          ((ndt)((WeakReference)localObject3).get()).a(paramList);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameBusinessCtrl", 2, "onSystemCallStateChanged, isCalling[" + paramBoolean + "], enter[" + nnm.a(this.a) + "]");
    }
    if (paramBoolean) {
      this.a.d();
    }
    for (;;)
    {
      synchronized (nnm.a(this.a))
      {
        Iterator localIterator = nnm.a(this.a).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() == null)) {
          continue;
        }
        ((ndt)localWeakReference.get()).a(paramBoolean);
      }
      this.a.c();
    }
    if ((paramBoolean) && (nnm.a(this.a))) {
      bjuf.a().c();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = nof.a(paramInt, paramLong);
    localObject = nnm.a(this.a).a((String)localObject);
    if (localObject == null) {
      bjuc.a("AVGameBusinessCtrl", "onGoOnStageRet failed. session == null.");
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
            bjuc.d("AVGameBusinessCtrl", "onGoOnStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
            if (!paramBoolean) {
              break;
            }
          } while (((nof)localObject).d != 1);
          localAVGameCameraAssistant = this.a.a();
        } while (localAVGameCameraAssistant == null);
        localAVGameCameraAssistant.a((nof)localObject);
        return;
        if (!((nof)localObject).a(1)) {
          break;
        }
        localAVGameCameraAssistant = this.a.a();
      } while (localAVGameCameraAssistant == null);
      localAVGameCameraAssistant.b((nof)localObject);
      return;
    } while (((nof)localObject).d != 1);
    ((nof)localObject).b(0);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2)
  {
    paramInt2 = 1;
    bjuc.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. videoIn = " + paramBoolean + ", userUin = " + paramLong1);
    ??? = nof.a(paramInt1, paramLong2);
    ??? = nnm.a(this.a).a((String)???);
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onMemberVideoInOrOut failed. session == null.");
      return;
    }
    if (paramBoolean) {}
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      boolean bool = ((nof)???).a(paramLong1, paramBoolean, paramInt1);
      bjuc.c("AVGameBusinessCtrl", "onMemberVideoInOrOut. updateUserCameraVideoStatus result = " + bool);
      synchronized (nnm.a(this.a))
      {
        Iterator localIterator = nnm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((ndt)localWeakReference.get()).a(paramBoolean, paramLong1, 1);
      }
    }
  }
  
  public void b(int paramInt)
  {
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onSelfVolumeUpdate failed. session == null.");
      return;
    }
    ??? = ((nof)???).a();
    if (??? != null) {
      ((AVGameUserInfo)???).mVolumeValue = paramInt;
    }
    synchronized (nnm.a(this.a))
    {
      Iterator localIterator = nnm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((ndt)localWeakReference.get()).b(paramInt);
        }
      }
    }
  }
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo)
  {
    bjuc.d("AVGameBusinessCtrl", "onUserExit. uin = " + paramMultiUserInfo.mUin);
    ??? = nnm.a(this.a).a();
    if (??? == null)
    {
      bjuc.a("AVGameBusinessCtrl", "onUserExit failed. session == null.");
      return;
    }
    ((nof)???).a(paramMultiUserInfo.mUin);
    synchronized (nnm.a(this.a))
    {
      Iterator localIterator = nnm.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((ndt)localWeakReference.get()).b(paramMultiUserInfo);
        }
      }
    }
  }
  
  public void b(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = nof.a(paramInt, paramLong);
    localObject = nnm.a(this.a).a((String)localObject);
    if (localObject == null) {
      bjuc.a("AVGameBusinessCtrl", "onGoOffStageRet failed. session == null.");
    }
    AVGameCameraAssistant localAVGameCameraAssistant;
    do
    {
      return;
      bjuc.d("AVGameBusinessCtrl", "onGoOffStageRet, ret[" + paramBoolean + "], relationId[" + paramLong + "], relationType[" + paramInt + "]");
      if (!((nof)localObject).a(1)) {
        break;
      }
      localAVGameCameraAssistant = this.a.a();
    } while (localAVGameCameraAssistant == null);
    localAVGameCameraAssistant.b((nof)localObject);
    return;
    ((nof)localObject).b(0);
  }
  
  public void c(int paramInt)
  {
    ??? = new StringBuilder().append("onStartRemoteVideoRequestResult. success = ");
    if (paramInt == 96) {}
    for (boolean bool = true;; bool = false)
    {
      bjuc.c("AVGameBusinessCtrl", bool);
      synchronized (nnm.a(this.a))
      {
        Iterator localIterator = nnm.a(this.a).iterator();
        WeakReference localWeakReference;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localWeakReference = (WeakReference)localIterator.next();
        } while ((localWeakReference == null) || (localWeakReference.get() == null));
        ((ndt)localWeakReference.get()).c(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nno
 * JD-Core Version:    0.7.0.1
 */