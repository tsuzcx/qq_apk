package com.tencent.mobileqq.werewolves;

import aksj;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.biz.viewplugin.ViewPluginLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import java.util.HashMap;

public class WerewolvesPluginManager
  implements FaceDecoder.DecodeTaskCompletionListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new aksj(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ViewPluginLoader jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader = (ViewPluginLoader)ViewPluginLoader.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  GameRoomChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie;
  public FaceDecoder a;
  WerewolvesPluginInterface jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
  public String a;
  
  public WerewolvesPluginManager(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader == null) {
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader = new ViewPluginLoader("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public WerewolvesPluginInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface == null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface = new WerewolvesPluginInterface(this, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(paramViewGroup, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext);
  }
  
  public void a(GameRoomChatPie paramGameRoomChatPie)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != paramGameRoomChatPie) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public void a(BaseActivity paramBaseActivity, GameRoomChatPie paramGameRoomChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = paramGameRoomChatPie;
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(paramBaseActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface = new WerewolvesPluginInterface(this, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = null;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader != null) {
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginManager
 * JD-Core Version:    0.7.0.1
 */