package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.guild.util.livedata.GulidLiveDataUtils;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftServiceModule;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

public class QQGuildLiveRoomVmData
{
  private static long c;
  private final HashMap<GiftAnimData, BetterLiveData<QQGuildLiveGiftMsgModel>> a = new HashMap();
  private AppRuntime b;
  
  private QQGuildLiveRoomVmData() {}
  
  public QQGuildLiveRoomVmData(@NonNull AppRuntime paramAppRuntime)
  {
    this.b = paramAppRuntime;
  }
  
  private LiveData<Boolean> a(long paramLong, @NonNull QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel)
  {
    BetterLiveData localBetterLiveData = new BetterLiveData();
    IGPSService localIGPSService = (IGPSService)this.b.getRuntimeService(IGPSService.class, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(String.valueOf(paramLong));
    localIGPSService.queryTinyIdByLiveUID(localArrayList, new QQGuildLiveRoomVmData.3(this, localBetterLiveData, paramLong, paramQQGuildLiveGiftMsgModel, localIGPSService));
    return localBetterLiveData;
  }
  
  private LiveData<Boolean> a(@NonNull IQQGiftSDK paramIQQGiftSDK, int paramInt, QQGuildLiveGiftMsgModel paramQQGuildLiveGiftMsgModel)
  {
    BetterLiveData localBetterLiveData = new BetterLiveData();
    paramIQQGiftSDK.g().a(paramInt, new QQGuildLiveRoomVmData.WeakResCallback(new WeakReference(localBetterLiveData), new WeakReference(paramQQGuildLiveGiftMsgModel)));
    return localBetterLiveData;
  }
  
  private AppRuntime a()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    if (paramIQQGiftSDK == null) {
      return;
    }
    if (System.currentTimeMillis() - c > 300000L)
    {
      c = System.currentTimeMillis();
      paramIQQGiftSDK.d().a(new QQGuildLiveRoomVmData.4(this, paramIQQGiftSDK));
    }
  }
  
  public void a(@NonNull IQQGiftSDK paramIQQGiftSDK, @NonNull GiftAnimData paramGiftAnimData)
  {
    QQGuildLiveGiftMsgModel localQQGuildLiveGiftMsgModel = new QQGuildLiveGiftMsgModel();
    localQQGuildLiveGiftMsgModel.b(paramGiftAnimData.c);
    GulidLiveDataUtils.a(a(paramGiftAnimData.g, localQQGuildLiveGiftMsgModel), a(paramIQQGiftSDK, paramGiftAnimData.d, localQQGuildLiveGiftMsgModel)).observeForever(new QQGuildLiveRoomVmData.2(this, paramGiftAnimData, localQQGuildLiveGiftMsgModel));
    this.a.put(paramGiftAnimData, new BetterLiveData());
  }
  
  public void a(@NonNull GiftAnimData paramGiftAnimData, @NonNull BetterLiveData<QQGuildLiveGiftMsgModel> paramBetterLiveData)
  {
    paramGiftAnimData = (BetterLiveData)this.a.remove(paramGiftAnimData);
    if (paramGiftAnimData == null) {
      return;
    }
    paramGiftAnimData.observeForever(new QQGuildLiveRoomVmData.1(this, paramBetterLiveData, paramGiftAnimData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData
 * JD-Core Version:    0.7.0.1
 */