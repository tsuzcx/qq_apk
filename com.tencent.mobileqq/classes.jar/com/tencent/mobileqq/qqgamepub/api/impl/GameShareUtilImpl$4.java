package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;

class GameShareUtilImpl$4
  implements BusinessObserver
{
  GameShareUtilImpl$4(GameShareUtilImpl paramGameShareUtilImpl, WeakReference paramWeakReference1, WeakReference paramWeakReference2, WeakReference paramWeakReference3, long paramLong1, long paramLong2, AIOImageData paramAIOImageData) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetArkTailRsp)paramBundle.getSerializable("rsp");
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetArkTailRspFromGallery:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("QQGamePub_GameShare.Util", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      localObject1 = (Context)this.a.get();
      Object localObject2 = (TextView)this.b.get();
      AIOGallerySceneWithBusiness localAIOGallerySceneWithBusiness = (AIOGallerySceneWithBusiness)this.c.get();
      if (((localObject1 instanceof Activity)) && (!((Activity)localObject1).isFinishing()) && (localObject2 != null) && (localAIOGallerySceneWithBusiness != null) && (localAIOGallerySceneWithBusiness.S() != null) && (localAIOGallerySceneWithBusiness.S().a != null) && (localAIOGallerySceneWithBusiness.S().a.L == this.d) && (localAIOGallerySceneWithBusiness.S().a.M == this.e))
      {
        ((TextView)localObject2).setText(paramBundle.desc);
        ((TextView)localObject2).setTag(-1, paramBundle.jumpUrl);
        ((TextView)localObject2).setTag(-2, Integer.valueOf(paramBundle.type));
        ((TextView)localObject2).setTag(-3, Integer.valueOf(paramBundle.subType));
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("game_source_pic_txt", paramBundle.desc);
      ((Bundle)localObject1).putString("game_source_pic_url", paramBundle.jumpUrl);
      ((Bundle)localObject1).putInt("game_source_type_pic", paramBundle.type);
      ((Bundle)localObject1).putInt("game_source_subtype_pic", paramBundle.subType);
      ((Bundle)localObject1).putLong("uniseq", this.f.L);
      ((Bundle)localObject1).putInt("is_troop", this.f.Q);
      ((Bundle)localObject1).putString("friend_uin", this.f.F);
      QIPCClientHelper.getInstance().callServer(((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getQQGameIPCModuleName(), "saveGalleryDataToMsg", (Bundle)localObject1, null);
      localObject1 = (StructMsgForImageShare)StructMsgFactory.a((byte[])this.f.s);
      this.g.setPicDataToImageData(this.f, localObject1, paramBundle.desc, paramBundle.jumpUrl, paramBundle.type, paramBundle.subType, true);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((StructMsgForImageShare)localObject1).mSourceAppid);
      ((StringBuilder)localObject2).append("");
      GameShareUtilImpl.reportSourceShowInGallery(((StringBuilder)localObject2).toString(), paramBundle.subType, this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.GameShareUtilImpl.4
 * JD-Core Version:    0.7.0.1
 */