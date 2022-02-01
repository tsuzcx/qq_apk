package com.tencent.mobileqq.qwallet.hb.aio.elem.impl;

import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import org.json.JSONObject;

class CustomizeStrategyFactory$SkinRedPacketStrategy
  implements CustomizeStrategyFactory.HBCustomizeStrategy
{
  IPreloadService a = null;
  IQWalletConfigService b = null;
  
  CustomizeStrategyFactory$SkinRedPacketStrategy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (paramBaseQQAppInterface != null)
    {
      this.a = ((IPreloadService)paramBaseQQAppInterface.getRuntimeService(IPreloadService.class, ""));
      this.b = ((IQWalletConfigService)paramBaseQQAppInterface.getRuntimeService(IQWalletConfigService.class, ""));
    }
  }
  
  private void a(@NonNull IPreloadService paramIPreloadService, @NonNull IQWalletConfigService paramIQWalletConfigService, @NonNull RedPacketInfo paramRedPacketInfo)
  {
    String str = paramIQWalletConfigService.getString("redPack", "https://imgcache.qq.com/channel/static/socialpay/skin/", new String[] { "prefix" });
    int i = paramRedPacketInfo.skinType;
    Object localObject1 = null;
    if ((i != 1) && (i != 2))
    {
      if (i != 3)
      {
        if (i != 4) {
          return;
        }
        paramIQWalletConfigService = paramIQWalletConfigService.getString("redPack", null, new String[] { "popAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("pop_anim_");
        ((StringBuilder)localObject1).append(paramRedPacketInfo.bigAnimId);
        ((StringBuilder)localObject1).append(".png");
        paramIPreloadService.getUnzipFolderPath(((StringBuilder)localObject1).toString(), paramIQWalletConfigService, new CustomizeStrategyFactory.SkinRedPacketStrategy.4(this, paramRedPacketInfo));
        return;
      }
      paramIQWalletConfigService = paramIQWalletConfigService.getString("redPack", null, new String[] { "bigAnimMap", String.valueOf(paramRedPacketInfo.bigAnimId), "zipMd5" });
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("aio_special_");
      ((StringBuilder)localObject1).append(paramRedPacketInfo.bigAnimId);
      ((StringBuilder)localObject1).append(".zip");
      paramIPreloadService.getUnzipFolderPath(((StringBuilder)localObject1).toString(), paramIQWalletConfigService, new CustomizeStrategyFactory.SkinRedPacketStrategy.3(this, paramRedPacketInfo));
      return;
    }
    Object localObject2 = paramIQWalletConfigService.getObj("redPack", new String[] { "skinMap" });
    paramIQWalletConfigService = (IQWalletConfigService)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((JSONObject)localObject2).optJSONObject(String.valueOf(paramRedPacketInfo.skinId));
      paramIQWalletConfigService = (IQWalletConfigService)localObject1;
      if (localObject2 != null)
      {
        paramIQWalletConfigService = ((JSONObject)localObject2).optString("aioZipMd5", "");
        localObject1 = ((JSONObject)localObject2).optString("popZipMd5", "");
        if (paramRedPacketInfo.skinType != 1) {
          paramIQWalletConfigService = (IQWalletConfigService)localObject1;
        }
        paramRedPacketInfo.title = ((JSONObject)localObject2).optString("title", "");
        paramRedPacketInfo.isHideTitle = ((JSONObject)localObject2).optInt("isHideTitle", a(paramRedPacketInfo.a));
      }
    }
    if (paramRedPacketInfo.skinType == 1) {
      localObject1 = "aio_";
    } else {
      localObject1 = "pop_";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramRedPacketInfo.skinId);
    ((StringBuilder)localObject2).append(".zip");
    paramIPreloadService.getUnzipFolderPath(((StringBuilder)localObject2).toString(), paramIQWalletConfigService, new CustomizeStrategyFactory.SkinRedPacketStrategy.2(this, paramRedPacketInfo));
  }
  
  public int a(MessageRecord paramMessageRecord)
  {
    return ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).MessageForQQWalletMsg$getIsHideTitleDefault(paramMessageRecord);
  }
  
  public void a() {}
  
  public void a(RedPacketInfo paramRedPacketInfo)
  {
    ThreadManager.post(new CustomizeStrategyFactory.SkinRedPacketStrategy.1(this, paramRedPacketInfo), 5, null, true);
  }
  
  public void a(RedPacketInfo paramRedPacketInfo, InterfaceRedPkgElem paramInterfaceRedPkgElem)
  {
    if (paramRedPacketInfo != null)
    {
      if ((paramInterfaceRedPkgElem instanceof SkinRedPkgElem))
      {
        paramInterfaceRedPkgElem = (SkinRedPkgElem)paramInterfaceRedPkgElem;
        paramRedPacketInfo.background = paramInterfaceRedPkgElem.c;
        paramRedPacketInfo.corner = paramInterfaceRedPkgElem.d;
        paramRedPacketInfo.animInfo = paramInterfaceRedPkgElem.i;
        paramRedPacketInfo.title = paramInterfaceRedPkgElem.e;
        paramRedPacketInfo.icon = paramInterfaceRedPkgElem.b(paramRedPacketInfo);
        paramRedPacketInfo.isHideTitle = paramInterfaceRedPkgElem.f;
        paramRedPacketInfo.resPath = paramInterfaceRedPkgElem.g;
        return;
      }
      if ((paramInterfaceRedPkgElem instanceof BigAnimRedPkgElem))
      {
        paramInterfaceRedPkgElem = (BigAnimRedPkgElem)paramInterfaceRedPkgElem;
        paramRedPacketInfo.specailBackgroundAnimInfo = paramInterfaceRedPkgElem.c;
        paramRedPacketInfo.specialBackground = paramInterfaceRedPkgElem.b;
        return;
      }
      if ((paramInterfaceRedPkgElem instanceof ResPathRedPkgElem)) {
        paramRedPacketInfo.resPath = ((ResPathRedPkgElem)paramInterfaceRedPkgElem).b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.elem.impl.CustomizeStrategyFactory.SkinRedPacketStrategy
 * JD-Core Version:    0.7.0.1
 */