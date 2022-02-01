package com.tencent.mobileqq.werewolves;

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
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import java.util.HashMap;

public class WerewolvesPluginManager
  implements DecodeTaskCompletionListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new WerewolvesPluginManager.1(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ViewPluginLoader jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader = (ViewPluginLoader)ViewPluginLoader.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  GameRoomChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie;
  public IFaceDecoder a;
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
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (localWerewolvesPluginInterface != null) {
      return localWerewolvesPluginInterface.a(paramString);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie != paramGameRoomChatPie) {
      return;
    }
    paramGameRoomChatPie = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.b();
    }
    paramGameRoomChatPie = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramGameRoomChatPie != null)
    {
      paramGameRoomChatPie.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    paramGameRoomChatPie = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.destory();
    }
    paramGameRoomChatPie = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = null;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, GameRoomChatPie paramGameRoomChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = paramGameRoomChatPie;
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.a(paramBaseActivity);
    paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.a();
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface = new WerewolvesPluginInterface(this, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_JavaLangClassLoader);
    }
    paramBaseActivity = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramBaseActivity.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (localWerewolvesPluginInterface == null) {
      return;
    }
    localWerewolvesPluginInterface.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (localObject != null) {
      ((WerewolvesPluginInterface)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginLoader;
    if (localObject != null) {
      ((ViewPluginLoader)localObject).c();
    }
  }
  
  public boolean b()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface;
    if (localWerewolvesPluginInterface == null) {
      return true;
    }
    return (localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.a());
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginInterface.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginManager
 * JD-Core Version:    0.7.0.1
 */