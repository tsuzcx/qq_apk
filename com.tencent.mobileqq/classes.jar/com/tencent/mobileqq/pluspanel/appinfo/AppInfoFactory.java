package com.tencent.mobileqq.pluspanel.appinfo;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo.Factory;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;

public class AppInfoFactory
  implements PlusPanelAppInfo.Factory
{
  public final SparseArray<PlusPanelAppInfo> a = new SparseArray();
  
  public AppInfoFactory()
  {
    a();
  }
  
  private void a()
  {
    this.a.put(1200000010, new AAShouKuanAppInfo());
    this.a.put(1101487426, new AnonymousChatAppInfo());
    this.a.put(1200000005, new AnonymousChatSettingAppInfo());
    this.a.put(1200000006, new AnonymousGiftAppInfo());
    Object localObject = new ArkAppManagerAppInfo();
    this.a.put(1000000001, localObject);
    this.a.put(1200000009, localObject);
    this.a.put(1000000000, new ArkSampleAppInfo());
    localObject = new AudioCallAppInfo();
    this.a.put(1104651886, localObject);
    this.a.put(201, localObject);
    this.a.put(1200000007, localObject);
    localObject = new AVGameAppInfo();
    this.a.put(101872203, localObject);
    this.a.put(222, localObject);
    localObject = new BusinessCardAppInfo();
    this.a.put(1104788679, localObject);
    this.a.put(212, localObject);
    localObject = new CMShowAppInfo();
    this.a.put(1200000008, localObject);
    this.a.put(215, localObject);
    this.a.put(1106865772, new ConfessTalkAppInfo());
    this.a.put(1200000000, new DemoAppInfo());
    localObject = new DoodleAppInfo();
    this.a.put(1106114157, localObject);
    this.a.put(210, localObject);
    this.a.put(1200000004, new ExitAnonymousChatAppInfo());
    localObject = new FavoriteAppInfo();
    this.a.put(1104639410, localObject);
    this.a.put(208, localObject);
    localObject = new FileAppInfo();
    this.a.put(1104864066, localObject);
    this.a.put(206, localObject);
    localObject = new GiftAppInfo();
    this.a.put(1104874204, localObject);
    this.a.put(213, localObject);
    this.a.put(101847385, new GroupPublicClassChatAppInfo());
    this.a.put(100719166, new GroupVideoChatAppInfo());
    this.a.put(1104445552, new HomeWorkAppInfo());
    localObject = new HotPicAppInfo();
    this.a.put(1107930043, localObject);
    this.a.put(204, localObject);
    localObject = new ListenTogetherAppInfo();
    this.a.put(101761547, localObject);
    this.a.put(207, localObject);
    localObject = new LocationAppInfo();
    this.a.put(1104864068, localObject);
    this.a.put(205, localObject);
    this.a.put(209, new MiniAppInfo());
    this.a.put(1104864070, new MusicShareAppInfo());
    localObject = new PicAppInfo();
    this.a.put(1104864054, localObject);
    this.a.put(217, localObject);
    this.a.put(203, new PokeAppInfo());
    this.a.put(1200000011, new PublicAccountVoiceAppInfo());
    localObject = new ReceiptMsgAppInfo();
    this.a.put(1106189400, localObject);
    this.a.put(216, localObject);
    localObject = new RedPacketAppInfo();
    this.a.put(1104864062, localObject);
    this.a.put(219, localObject);
    localObject = new ShareScreenAppInfo();
    this.a.put(101850591, localObject);
    this.a.put(221, localObject);
    localObject = new ShootAppInfo();
    this.a.put(1200000003, localObject);
    this.a.put(218, localObject);
    this.a.put(1104788673, new ShortVideoAppInfo());
    localObject = new SingTogetherAppInfo();
    this.a.put(101817424, localObject);
    this.a.put(220, localObject);
    localObject = new TencentDocsAppInfo();
    this.a.put(1200000002, localObject);
    this.a.put(214, localObject);
    this.a.put(211, new TransferAppInfo());
    this.a.put(1101678813, new TroopActivityAppInfo());
    this.a.put(1104864064, new MoreTroopAppInfo());
    this.a.put(1108961705, new TroopCollectFormAppInfo());
    localObject = new TroopDingYueAppInfo();
    this.a.put(1200000001, localObject);
    this.a.put(1000000003, localObject);
    this.a.put(1106194086, new TroopEffectPicAppInfo());
    this.a.put(1105981808, new TroopStoryAppInfo());
    this.a.put(1104536706, new TroopTouPiaoAppInfo());
    localObject = new VideoCallAppInfo();
    this.a.put(1106658188, localObject);
    this.a.put(202, localObject);
    localObject = new QavWTAppInfo();
    this.a.put(223, localObject);
    this.a.put(101793773, new WatchTogetherAppInfo());
    this.a.put(1106729451, new BulkSendMsgAppInfo());
    localObject = new AskAnonymouslyAppInfo();
    this.a.put(101912132, localObject);
  }
  
  private void a(PlusPanelAppInfo paramPlusPanelAppInfo, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    paramPlusPanelAppInfo.appid = paramTroopAIOAppInfo.appid;
    paramPlusPanelAppInfo.name = paramTroopAIOAppInfo.name;
    paramPlusPanelAppInfo.url = paramTroopAIOAppInfo.url;
    paramPlusPanelAppInfo.iconUrl = paramTroopAIOAppInfo.iconUrl;
    paramPlusPanelAppInfo.isGray = paramTroopAIOAppInfo.isGray;
    paramPlusPanelAppInfo.simpleDayUrl = paramTroopAIOAppInfo.simpleDayUrl;
    paramPlusPanelAppInfo.simpleNightUrl = paramTroopAIOAppInfo.simpleNightUrl;
    paramPlusPanelAppInfo.iconYouth = paramTroopAIOAppInfo.iconYouth;
  }
  
  public PlusPanelAppInfo a(int paramInt1, int paramInt2)
  {
    PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)this.a.get(paramInt2);
    if (localPlusPanelAppInfo != null)
    {
      localPlusPanelAppInfo.init();
      localPlusPanelAppInfo.uinType = paramInt1;
      localPlusPanelAppInfo.appid = paramInt2;
    }
    return localPlusPanelAppInfo;
  }
  
  public PlusPanelAppInfo a(TroopAIOAppInfo paramTroopAIOAppInfo, int paramInt)
  {
    CommonWebAppInfo localCommonWebAppInfo = new CommonWebAppInfo(paramInt);
    a(localCommonWebAppInfo, paramTroopAIOAppInfo);
    return localCommonWebAppInfo;
  }
  
  public PlusPanelAppInfo b(TroopAIOAppInfo paramTroopAIOAppInfo, int paramInt)
  {
    PlusPanelAppInfo localPlusPanelAppInfo = a(paramInt, paramTroopAIOAppInfo.appid);
    if (localPlusPanelAppInfo != null) {
      a(localPlusPanelAppInfo, paramTroopAIOAppInfo);
    }
    return localPlusPanelAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AppInfoFactory
 * JD-Core Version:    0.7.0.1
 */