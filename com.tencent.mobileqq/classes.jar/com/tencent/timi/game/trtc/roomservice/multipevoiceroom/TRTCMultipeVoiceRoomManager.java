package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager.AudioMusicParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class TRTCMultipeVoiceRoomManager
  implements TRTCInterface
{
  private static volatile TRTCMultipeVoiceRoomManager d;
  public final MutableLiveData<ConcurrentHashMap<String, TRTCMultipeVoiceRoom>> a = new MutableLiveData();
  public final MutableLiveData<ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>> b = new MutableLiveData();
  public final MutableLiveData<Boolean> c = new MutableLiveData();
  private volatile TRTCCloud e;
  private volatile int f = 100;
  private volatile boolean g = false;
  private volatile ConcurrentHashMap<String, TRTCMultipeVoiceRoom> h = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> i = new ConcurrentHashMap();
  private ConcurrentHashMap<String, TRTCMultipeVoiceRoomManager.VolumeObserve> j = new ConcurrentHashMap();
  private ConcurrentHashMap<String, View> k = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> l = new ConcurrentHashMap();
  private ConcurrentHashMap<String, TRTCCustomCmdHandlerListener> m = new ConcurrentHashMap();
  private List<String> n = new ArrayList();
  
  public static TRTCMultipeVoiceRoomManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new TRTCMultipeVoiceRoomManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(@NonNull String paramString1, @Nullable String paramString2, @Nullable View paramView)
  {
    paramString1 = a(paramString1);
    if ((paramString1 != null) && ((paramView instanceof TXCloudVideoView)))
    {
      paramString1.e().setRemoteViewFillMode(paramString2, 1);
      paramString1.e().startRemoteView(paramString2, (TXCloudVideoView)paramView);
    }
  }
  
  private boolean c()
  {
    label57:
    try
    {
      QLog.i("TRTCMultipeVoiceRoomManager", 4, "initTrtc");
    }
    finally {}
    try
    {
      this.e = TRTCCloud.sharedInstance(BaseApplication.getContext());
      this.e.switchRole(20);
      this.e.muteLocalAudio(true);
      this.e.muteLocalVideo(true);
      this.e.setSystemVolumeType(1);
      return true;
    }
    catch (Exception localException)
    {
      break label57;
    }
    return false;
  }
  
  private void d()
  {
    try
    {
      if (this.h.size() == 0)
      {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:当前已经不存在房间实例，释放Trtc资源");
        TRTCCloud.destroySharedInstance();
        this.e = null;
      }
      else
      {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "checkAndDestoryTrtc:当前存在房间实例，保留Trtc资源");
      }
      return;
    }
    finally {}
  }
  
  private void e()
  {
    Iterator localIterator = this.h.values().iterator();
    while (localIterator.hasNext()) {
      if (!((TRTCMultipeVoiceRoom)localIterator.next()).h())
      {
        i1 = 0;
        break label44;
      }
    }
    int i1 = 1;
    label44:
    if (i1 != 0) {
      this.e.stopLocalAudio();
    }
    if (this.g == i1)
    {
      this.g = (i1 ^ 0x1);
      this.c.setValue(Boolean.valueOf(this.g));
    }
  }
  
  private boolean f()
  {
    if (TimiGameQQTrtcUtil.b()) {
      return true;
    }
    if (!TimiGameQQTrtcUtil.b) {
      QLog.e("TRTCMultipeVoiceRoomManager", 2, "Trtc So加载验证失败，业务需先通过TimiGameQQTrtcUtil#checkTrtcEnv校验");
    }
    if (!TimiGameQQTrtcUtil.a) {
      QLog.e("TRTCMultipeVoiceRoomManager", 2, "QQ Trtc业务授权验证失败，业务需先通过TimiGameQQTrtcUtil#requestQQAudioEnv校验");
    }
    if (TextUtils.isEmpty(TimiGameQQTrtcUtil.c)) {
      QLog.e("TRTCMultipeVoiceRoomManager", 2, "Trtc用户签名验证失败，业务需先通过TimiGameQQTrtcUtil#checkTrtcUserSig校验");
    }
    return false;
  }
  
  private void k(String paramString)
  {
    l(paramString);
    TRTCMultipeVoiceRoomManager.VolumeObserve localVolumeObserve = new TRTCMultipeVoiceRoomManager.VolumeObserve(this);
    this.j.put(paramString, localVolumeObserve);
    a(paramString).a.observeForever(localVolumeObserve);
  }
  
  private void l(String paramString)
  {
    TRTCMultipeVoiceRoomManager.VolumeObserve localVolumeObserve = (TRTCMultipeVoiceRoomManager.VolumeObserve)this.j.get(paramString);
    if (localVolumeObserve != null)
    {
      a(paramString).a.removeObserver(localVolumeObserve);
      this.i.remove(paramString);
      this.b.setValue(this.i);
    }
  }
  
  public TRTCMultipeVoiceRoom a(String paramString)
  {
    try
    {
      boolean bool = f();
      if (!bool) {
        return null;
      }
      paramString = (TRTCMultipeVoiceRoom)this.h.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMicVolume:");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      if ((paramInt >= 0) && (paramInt <= 100))
      {
        this.f = paramInt;
        this.e.setAudioCaptureVolume(this.f);
        b();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMicVolume:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" not validate!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVoiceRoomVolume:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" volume:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject = a(paramString);
      if ((localObject != null) && (paramInt >= 0) && (paramInt <= 100))
      {
        ((TRTCMultipeVoiceRoom)localObject).a(paramInt);
        b();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setVoiceRoomVolume:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, TRTCCloudListener paramTRTCCloudListener)
  {
    if (!f()) {
      return;
    }
    paramString = a(paramString);
    if (paramString != null) {
      paramString.a(paramTRTCCloudListener);
    }
  }
  
  public void a(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      View localView = (View)this.k.get(paramString2);
      if (localView != null) {
        a(paramString1, paramString2, localView);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, TRTCCustomCmdHandlerListener paramTRTCCustomCmdHandlerListener)
  {
    for (;;)
    {
      Object localObject;
      int i1;
      try
      {
        boolean bool = f();
        if (!bool) {
          return;
        }
        if (paramInt == 1)
        {
          localObject = "车队";
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("enterVoiceRoom:");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" userID:");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" roomBizSimpleName:");
          localStringBuilder.append((String)localObject);
          QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
          this.l.put(paramString1, localObject);
          this.m.put(paramString1, paramTRTCCustomCmdHandlerListener);
          if (this.e == null)
          {
            paramTRTCCustomCmdHandlerListener = new StringBuilder();
            paramTRTCCustomCmdHandlerListener.append("enterVoiceRoom Trtc已释放，重新创建 trigger by Room:");
            paramTRTCCustomCmdHandlerListener.append(paramString1);
            QLog.i("TRTCMultipeVoiceRoomManager", 4, paramTRTCCustomCmdHandlerListener.toString());
            c();
          }
          if (a(paramString1) == null)
          {
            paramTRTCCustomCmdHandlerListener = new TRTCMultipeVoiceRoom(this.e.createSubCloud(), paramString1, paramString2);
            this.h.put(paramString1, paramTRTCCustomCmdHandlerListener);
            paramTRTCCustomCmdHandlerListener = paramTRTCCustomCmdHandlerListener.e();
            if (!ServerEnv.b()) {
              break label419;
            }
            i1 = 1400468649;
            localObject = new TRTCCloudDef.TRTCParams();
            ((TRTCCloudDef.TRTCParams)localObject).sdkAppId = i1;
            ((TRTCCloudDef.TRTCParams)localObject).userId = paramString2;
            ((TRTCCloudDef.TRTCParams)localObject).roomId = -1;
            paramString2 = new JSONObject();
            try
            {
              paramString2.put("strGroupId", paramString1);
            }
            catch (JSONException localJSONException)
            {
              QLog.e("TRTCMultipeVoiceRoomManager", 4, localJSONException.toString(), localJSONException);
            }
            ((TRTCCloudDef.TRTCParams)localObject).businessInfo = paramString2.toString();
            ((TRTCCloudDef.TRTCParams)localObject).userSig = TimiGameQQTrtcUtil.c;
            ((TRTCCloudDef.TRTCParams)localObject).role = 20;
            paramTRTCCustomCmdHandlerListener.enableAudioVolumeEvaluation(300);
            paramTRTCCustomCmdHandlerListener.enterRoom((TRTCCloudDef.TRTCParams)localObject, 1);
            paramTRTCCustomCmdHandlerListener.muteLocalAudio(true);
            if (paramInt == 3) {
              paramTRTCCustomCmdHandlerListener.muteLocalVideo(false);
            }
            k(paramString1);
            b();
            return;
          }
          paramString2 = new StringBuilder();
          paramString2.append("enterVoiceRoom！！已经在房间内:");
          paramString2.append(paramString1);
          QLog.e("TRTCMultipeVoiceRoomManager", 4, paramString2.toString());
          return;
        }
      }
      finally {}
      if (paramInt == 5)
      {
        localObject = "大厅";
      }
      else
      {
        localObject = "房间";
        continue;
        label419:
        i1 = 1400467382;
      }
    }
  }
  
  void b()
  {
    if (this.a.hasObservers()) {
      this.a.setValue(this.h);
    }
  }
  
  public void b(int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBgmVolumn:");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      if ((paramInt >= 0) && (paramInt <= 100))
      {
        this.e.getAudioEffectManager().setMusicPlayoutVolume(1, paramInt);
        this.e.getAudioEffectManager().setMusicPublishVolume(1, paramInt);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBgmVolumn:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" not validate!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOnMicPosition:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject = a(paramString);
      if (localObject != null)
      {
        ((TRTCMultipeVoiceRoom)localObject).c(true);
        b();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setOnMicPosition:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString, TRTCCloudListener paramTRTCCloudListener)
  {
    if (!f()) {
      return;
    }
    paramString = a(paramString);
    if (paramString != null) {
      paramString.b(paramTRTCCloudListener);
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOffMicPosition:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject = a(paramString);
      if (localObject != null)
      {
        ((TRTCMultipeVoiceRoom)localObject).c(false);
        e(paramString);
        b();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setOffMicPosition:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void d(String paramString)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openMicForVoiceRoom:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject1).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject1 = a(paramString);
      if (localObject1 != null)
      {
        this.n.clear();
        Object localObject2 = this.h.values().iterator();
        Object localObject3;
        Object localObject4;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (TRTCMultipeVoiceRoom)((Iterator)localObject2).next();
          if ((!((TRTCMultipeVoiceRoom)localObject3).h()) && (!((TRTCMultipeVoiceRoom)localObject3).f().equals(paramString)))
          {
            e(((TRTCMultipeVoiceRoom)localObject3).f());
            g(((TRTCMultipeVoiceRoom)localObject3).f());
            localObject4 = (TRTCCustomCmdHandlerListener)this.m.get(((TRTCMultipeVoiceRoom)localObject3).f());
            if (localObject4 != null) {
              ((TRTCCustomCmdHandlerListener)localObject4).a(((TRTCMultipeVoiceRoom)localObject3).f(), false);
            }
            this.n.add(((TRTCMultipeVoiceRoom)localObject3).f());
          }
        }
        if (this.n.size() > 0)
        {
          localObject4 = (String)this.n.get(0);
          localObject2 = (String)this.l.get(paramString);
          localObject3 = (String)this.l.get(localObject4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openMicForVoiceRoom ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" - ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(", closed room first = ");
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(" - ");
          localStringBuilder.append((String)localObject3);
          QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
          paramString = new StringBuilder();
          paramString.append("已切换为");
          paramString.append((String)localObject2);
          paramString.append("语音，");
          paramString.append((String)localObject3);
          paramString.append("声音已关闭");
          CustomToastView.a(paramString.toString());
        }
        this.e.startLocalAudio();
        ((TRTCMultipeVoiceRoom)localObject1).e().muteLocalAudio(false);
        ((TRTCMultipeVoiceRoom)localObject1).b(false);
        e();
        b();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openMicForVoiceRoom:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("muteMicForVoiceRoom:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject = a(paramString);
      if (localObject != null)
      {
        ((TRTCMultipeVoiceRoom)localObject).e().muteLocalAudio(true);
        ((TRTCMultipeVoiceRoom)localObject).b(true);
        e();
        b();
        this.n.clear();
        if (this.n.size() > 0)
        {
          localObject = (String)this.n.get(0);
          String str = (String)this.l.get(localObject);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("muteMicForVoiceRoom ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", resume closed room first = ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" - ");
          localStringBuilder.append(str);
          QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
          this.n.clear();
          paramString = new StringBuilder();
          paramString.append("已为你自动恢复");
          paramString.append(str);
          paramString.append("麦克风");
          CustomToastView.a(paramString.toString());
          paramString = (TRTCCustomCmdHandlerListener)this.m.get(localObject);
          if (paramString != null) {
            paramString.a((String)localObject, true);
          } else {
            d((String)localObject);
          }
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("muteMicForVoiceRoom:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void f(String paramString)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("openSpeakerForVoiceRoom:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject1).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject1 = a(paramString);
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        Object localObject3 = this.h.values().iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TRTCMultipeVoiceRoom)((Iterator)localObject3).next();
          if ((!((TRTCMultipeVoiceRoom)localObject4).g()) && (!((TRTCMultipeVoiceRoom)localObject4).f().equals(paramString)))
          {
            g(((TRTCMultipeVoiceRoom)localObject4).f());
            ((List)localObject2).add(((TRTCMultipeVoiceRoom)localObject4).f());
          }
        }
        if (((List)localObject2).size() > 0)
        {
          localObject4 = (String)((List)localObject2).get(0);
          localObject2 = (String)this.l.get(paramString);
          localObject3 = (String)this.l.get(localObject4);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openSpeakerForVoiceRoom ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" - ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(", closed room first = ");
          localStringBuilder.append((String)localObject4);
          localStringBuilder.append(" - ");
          localStringBuilder.append((String)localObject3);
          QLog.i("TRTCMultipeVoiceRoomManager", 4, localStringBuilder.toString());
          paramString = new StringBuilder();
          paramString.append("已切换为");
          paramString.append((String)localObject2);
          paramString.append("语音，");
          paramString.append((String)localObject3);
          paramString.append("声音已关闭");
          CustomToastView.a(paramString.toString());
        }
        ((TRTCMultipeVoiceRoom)localObject1).e().muteAllRemoteAudio(false);
        ((TRTCMultipeVoiceRoom)localObject1).a(false);
        b();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openSpeakerForVoiceRoom:");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void g(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("muteSpeakerForVoiceRoom:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      localObject = a(paramString);
      if (localObject != null)
      {
        ((TRTCMultipeVoiceRoom)localObject).e().muteAllRemoteAudio(true);
        ((TRTCMultipeVoiceRoom)localObject).a(true);
        b();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("muteSpeakerForVoiceRoom:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public boolean h(String paramString)
  {
    boolean bool1 = f();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramString = a(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.h()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void i(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBgmPath:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setBgmPath&startPlay:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
        localObject = this.e.getAudioEffectManager();
        paramString = new TXAudioEffectManager.AudioMusicParam(1, paramString);
        paramString.publish = true;
        ((TXAudioEffectManager)localObject).startPlayMusic(paramString);
      }
      else if (paramString == null)
      {
        QLog.i("TRTCMultipeVoiceRoomManager", 4, "setBgmPath&stopPlay!");
        this.e.getAudioEffectManager().stopPlayMusic(1);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setBgmPath:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" not validate!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
  
  public void j(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exitVoiceRoom:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      boolean bool = f();
      if (!bool) {
        return;
      }
      this.l.remove(paramString);
      this.m.remove(paramString);
      this.n.remove(paramString);
      localObject = a(paramString);
      if (localObject != null)
      {
        e(paramString);
        g(paramString);
        ((TRTCMultipeVoiceRoom)localObject).e().exitRoom();
        this.e.destroySubCloud(((TRTCMultipeVoiceRoom)localObject).e());
        e();
        l(paramString);
        this.h.remove(paramString);
        b();
        d();
        this.k.clear();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exitVoiceRoom:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("Not Found!");
        QLog.e("TRTCMultipeVoiceRoomManager", 4, ((StringBuilder)localObject).toString());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoomManager
 * JD-Core Version:    0.7.0.1
 */