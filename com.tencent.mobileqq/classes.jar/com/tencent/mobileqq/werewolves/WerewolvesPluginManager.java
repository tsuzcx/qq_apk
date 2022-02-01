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
  ViewPluginLoader a = (ViewPluginLoader)ViewPluginLoader.a.get("Werewolves.apk");
  ViewGroup b;
  WerewolvesPluginInterface c;
  public String d;
  GameRoomChatPie e;
  public IFaceDecoder f;
  Handler g = new WerewolvesPluginManager.1(this, Looper.getMainLooper());
  
  public WerewolvesPluginManager(String paramString)
  {
    if (this.a == null) {
      this.a = new ViewPluginLoader("2584", "Werewolves.apk");
    }
    this.d = paramString;
  }
  
  public String a(String paramString)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.c;
    if (localWerewolvesPluginInterface != null) {
      return localWerewolvesPluginInterface.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.a.i)
    {
      this.a.a(false);
      return;
    }
    if (this.c == null) {
      this.c = new WerewolvesPluginInterface(this, this.a.c);
    }
    Message localMessage = this.g.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
    this.b.removeAllViews();
    this.c.a(paramViewGroup, this.a.b);
  }
  
  public void a(GameRoomChatPie paramGameRoomChatPie)
  {
    if (this.e != paramGameRoomChatPie) {
      return;
    }
    paramGameRoomChatPie = this.c;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.b();
    }
    paramGameRoomChatPie = this.b;
    if (paramGameRoomChatPie != null)
    {
      paramGameRoomChatPie.removeAllViews();
      this.b = null;
    }
    paramGameRoomChatPie = this.f;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.destory();
    }
    paramGameRoomChatPie = this.a;
    if (paramGameRoomChatPie != null) {
      paramGameRoomChatPie.b = null;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, GameRoomChatPie paramGameRoomChatPie)
  {
    this.e = paramGameRoomChatPie;
    this.a.a(paramBaseActivity);
    paramBaseActivity = this.c;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.a();
      this.c.a(this.a.b);
    }
    else
    {
      this.c = new WerewolvesPluginInterface(this, this.a.c);
    }
    paramBaseActivity = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.f = ((IQQAvatarService)paramBaseActivity.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramBaseActivity);
    this.f.setDecodeTaskCompletionListener(this);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.c;
    if (localWerewolvesPluginInterface == null) {
      return;
    }
    localWerewolvesPluginInterface.a(paramString, paramArrayOfByte);
  }
  
  public boolean b()
  {
    return this.a.i;
  }
  
  public WerewolvesPluginInterface c()
  {
    return this.c;
  }
  
  public void d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((WerewolvesPluginInterface)localObject).a();
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
      this.b = null;
    }
    this.e = null;
    localObject = this.f;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    localObject = this.a;
    if (localObject != null) {
      ((ViewPluginLoader)localObject).d();
    }
  }
  
  public boolean e()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.c;
    if (localWerewolvesPluginInterface == null) {
      return true;
    }
    return (localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.c());
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.c != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.c.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesPluginManager
 * JD-Core Version:    0.7.0.1
 */