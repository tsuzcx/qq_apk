package com.tencent.mobileqq.guild.chatpie.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;

public class GuildVasAvatar
  extends VasAvatar
{
  private QQAppInterface f;
  private String g;
  private GPServiceObserver h = new GuildVasAvatar.1(this);
  private final AvatarObserver i = new GuildVasAvatar.2(this);
  private CardObserver j = new GuildVasAvatar.3(this);
  
  public GuildVasAvatar(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildVasAvatar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildVasAvatar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Drawable a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestAvatarDrawable： ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("GuildVasAvatar", 2, ((StringBuilder)localObject1).toString());
    Object localObject2 = this.f;
    localObject1 = "";
    if ((localObject2 != null) && (TextUtils.equals(paramString, ((IGPSService)((QQAppInterface)localObject2).getRuntimeService(IGPSService.class)).getSelfTinyId())))
    {
      paramString = ImageUtil.a(true);
      localObject2 = this.f;
      localObject2 = FaceDrawable.getFaceDrawable((AppInterface)localObject2, 1, ((QQAppInterface)localObject2).getCurrentUin(), 4, paramString, paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestAvatarDrawable, Drawable:");
        paramString = (String)localObject1;
        if (localObject2 != null) {
          paramString = ((FaceDrawable)localObject2).getLoadedBitmap();
        }
        localStringBuilder.append(paramString);
        QLog.i("GuildVasAvatar", 1, localStringBuilder.toString());
      }
      return localObject2;
    }
    paramString = ((IGPSService)this.f.getRuntimeService(IGPSService.class, "")).getGuildUsersAvatarUrl(paramString);
    return ((IQQGuildAvatarApi)this.f.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.f, paramString, 0);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface == null)
    {
      QLog.d("GuildVasAvatar", 2, "onAttachedToWindow：app is null");
      return;
    }
    ((IGPSService)localQQAppInterface.getRuntimeService(IGPSService.class, "")).addObserver(this.h);
    this.f.addObserver(this.i);
    this.f.addObserver(this.j);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface == null)
    {
      QLog.d("GuildVasAvatar", 2, "onDetachedFromWindow：app is null");
      return;
    }
    ((IGPSService)localQQAppInterface.getRuntimeService(IGPSService.class, "")).deleteObserver(this.h);
    this.f.removeObserver(this.i);
    this.f.removeObserver(this.j);
  }
  
  public void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
  }
  
  public void setAvatarTinyId(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAvatarTinyId： ");
    localStringBuilder.append(paramString);
    QLog.d("GuildVasAvatar", 2, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      setImageDrawable(BaseImageUtil.j());
      return;
    }
    if (paramString.equals(this.g))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildVasAvatar", 2, "setAvatarTinyId same tid, reuse avatar");
      }
      return;
    }
    this.g = paramString;
    setImageDrawable(a(paramString));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.view.GuildVasAvatar
 * JD-Core Version:    0.7.0.1
 */