package com.tencent.mobileqq.troopgift;

import ajvv;
import ajwj;
import ajwk;
import ajwl;
import ajwm;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.OnFrameEndListener;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.qphone.base.util.QLog;

public class TroopInteractGiftAnimationController
{
  public int a;
  protected SoundPool a;
  public Handler a;
  public ViewGroup a;
  public TroopChatPie a;
  protected MessageForDeliverGiftTips a;
  public SpriteVideoView a;
  public TroopGiftActionButton a;
  public boolean a;
  protected int b;
  
  public TroopInteractGiftAnimationController()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_AndroidMediaSoundPool = new SoundPool(5, 3, 0);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localUnsatisfiedLinkError));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopInteractGiftAnimationController", 2, QLog.getStackTraceString(localException));
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: dismissAnimation" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.n();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ajwm(this));
    } while (this.jdField_a_of_type_AndroidMediaSoundPool == null);
    this.jdField_a_of_type_AndroidMediaSoundPool.unload(this.b);
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.c.findViewById(2131363492));
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a(paramMessageForDeliverGiftTips.frienduin, paramMessageForDeliverGiftTips.interactId, paramMessageForDeliverGiftTips.animationPackageId, new ajwl(this, paramMessageForDeliverGiftTips));
    }
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajwk(this, paramMessageForDeliverGiftTips), l);
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
      ((TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)).a(paramString1, paramString2, paramInt1, paramInt2, new ajwj(this, paramInt2, paramString2, paramMessageForDeliverGiftTips, paramBoolean));
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips, String paramString, boolean paramBoolean, FrameSprite.OnFrameEndListener paramOnFrameEndListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
    if (QLog.isColorLevel()) {
      QLog.d("TroopInteractGiftAnimationController", 2, "TroopInteractGiftAnimationController: showAnimation" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.interactId);
    }
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null) {
      this.b = this.jdField_a_of_type_AndroidMediaSoundPool.load(TroopGiftUtil.a(paramString) + "sound.wav", 1);
    }
    ThreadManager.post(new ajvv(this, paramString, paramMessageForDeliverGiftTips, paramBoolean, paramOnFrameEndListener, (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112)), 8, null, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaSoundPool != null)
    {
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidContentContext.getSystemService("audio");
      float f = localAudioManager.getStreamMaxVolume(3);
      f = localAudioManager.getStreamVolume(3) / f;
      this.jdField_a_of_type_AndroidMediaSoundPool.play(this.b, f, f, 1, 0, 1.0F);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController
 * JD-Core Version:    0.7.0.1
 */