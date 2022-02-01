package com.tencent.mobileqq.troopgift;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.qphone.base.util.QLog;

public class TroopInteractGiftAnimationController
{
  protected TroopChatPie a;
  protected SpriteVideoView b;
  protected TroopGiftActionButton c;
  protected ViewGroup d;
  protected Handler e = new Handler(Looper.getMainLooper());
  protected int f = 0;
  protected boolean g = true;
  protected SoundPool h;
  protected int i;
  protected MessageForDeliverGiftTips j;
  
  public TroopInteractGiftAnimationController()
  {
    try
    {
      this.h = new SoundPool(5, 3, 0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localException));
        return;
      }
    }
    catch (ExceptionInInitializerError localExceptionInInitializerError)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localExceptionInInitializerError));
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localUnsatisfiedLinkError));
      }
    }
  }
  
  public void a()
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TroopInteractGiftAnimationController: dismissAnimation");
        ((StringBuilder)localObject).append(this.j.interactId);
        QLog.d("TroopInteractGiftAnimationController", 2, ((StringBuilder)localObject).toString());
      }
      this.b.o();
      this.a.f.runOnUiThread(new TroopInteractGiftAnimationController.5(this));
      Object localObject = this.h;
      if (localObject != null) {
        ((SoundPool)localObject).unload(this.i);
      }
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    this.a = paramTroopChatPie;
    this.d = ((ViewGroup)this.a.aZ.findViewById(2131430542));
  }
  
  protected void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    TroopChatPie localTroopChatPie = this.a;
    if (localTroopChatPie != null) {
      ((TroopGiftManager)localTroopChatPie.d.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.animationPackageId, new TroopInteractGiftAnimationController.4(this, paramMessageForDeliverGiftTips));
    }
  }
  
  protected void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.e.postDelayed(new TroopInteractGiftAnimationController.3(this, paramMessageForDeliverGiftTips), l);
  }
  
  protected void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TroopChatPie localTroopChatPie = this.a;
    if (localTroopChatPie != null) {
      ((TroopGiftManager)localTroopChatPie.d.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(paramString1, paramString2, paramInt1, paramInt2, new TroopInteractGiftAnimationController.2(this, paramInt2, paramString2, paramMessageForDeliverGiftTips, paramBoolean));
    }
    this.f = 0;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (this.a == null) {
      return;
    }
    this.j = paramMessageForDeliverGiftTips;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TroopInteractGiftAnimationController: showAnimation");
      ((StringBuilder)localObject).append(this.j.interactId);
      QLog.d("TroopInteractGiftAnimationController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TroopGiftUtil.a(paramString));
      localStringBuilder.append("sound.wav");
      this.i = ((SoundPool)localObject).load(localStringBuilder.toString(), 1);
    }
    ThreadManager.post(new TroopInteractGiftAnimationController.1(this, paramString, paramMessageForDeliverGiftTips, paramBoolean, paramOnFrameEndListener, (TroopGiftManager)this.a.d.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)), 8, null, true);
  }
  
  public boolean b()
  {
    return this.c != null;
  }
  
  public boolean c()
  {
    return this.b != null;
  }
  
  protected void d()
  {
    if (this.h != null)
    {
      AudioManager localAudioManager = (AudioManager)this.a.e.getSystemService("audio");
      float f1 = localAudioManager.getStreamMaxVolume(3);
      f1 = localAudioManager.getStreamVolume(3) / f1;
      this.h.play(this.i, f1, f1, 1, 0, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */