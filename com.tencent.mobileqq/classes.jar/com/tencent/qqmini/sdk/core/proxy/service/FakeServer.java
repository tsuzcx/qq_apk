package com.tencent.qqmini.sdk.core.proxy.service;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiRightController;
import NS_MINI_INTERFACE.INTERFACE.StApiRightItem;
import NS_MINI_INTERFACE.INTERFACE.StApiUserInfo;
import NS_MINI_INTERFACE.INTERFACE.StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE.StCheckSessionRsp;
import NS_MINI_INTERFACE.INTERFACE.StDeveloperInfo;
import NS_MINI_INTERFACE.INTERFACE.StDomainConfig;
import NS_MINI_INTERFACE.INTERFACE.StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp;
import NS_MINI_INTERFACE.INTERFACE.StGetCodeRsp;
import NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp;
import NS_MINI_INTERFACE.INTERFACE.StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE.StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE.StSubPkgInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;

public class FakeServer
{
  private static byte[] build1107953026()
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    Object localObject1 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
    ((INTERFACE.StApiRightItem)localObject1).right.set(1);
    ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
    Object localObject2 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
    ((INTERFACE.StApiRightItem)localObject2).right.set(1);
    ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
    localStGetAppInfoByIdRsp.appInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.domain.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.extInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mDebug.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mainExt.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("reportSubmitForm");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestMidasPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("joinVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("exitVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
    localStGetAppInfoByIdRsp.appInfo.appId.set("1107953026");
    localStGetAppInfoByIdRsp.appInfo.appName.set("斗罗大陆");
    localStGetAppInfoByIdRsp.appInfo.appType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.operationTags.set("正版授权;玄幻");
    localStGetAppInfoByIdRsp.appInfo.basicInfo.pkgType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.versionUpdateTime.set(1576147298);
    localStGetAppInfoByIdRsp.appInfo.desc.set("正版授权巨作，送千年魂环，小说高还原，一人控制五大魂师，万千魂环搭配！");
    localStGetAppInfoByIdRsp.appInfo.devInfo.name.set("第三方");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("res.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("res.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("app.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("click.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("error.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("m-api.37.com.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("pvt-api.37.com.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("mpay-api.37.com.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("report-api.37.com.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("report-api.39ej7e.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("upload.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("37wans99995.xxh5.z7xz.com:20102");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("37wans99998.xxh5.z7xz.com:20102");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("37wans99999.xxh5.z7xz.com:20102");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("gamewx.xxh5.z7xz.com");
    localStGetAppInfoByIdRsp.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/a939c4ccee774155286e21718504085f.tqapkg");
    localObject1 = new INTERFACE.StExtConfigInfo();
    ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
    ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
    localStGetAppInfoByIdRsp.appInfo.extConfig.add((MessageMicro)localObject1);
    localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("race_state");
    ((COMM.Entry)localObject1).value.set("2");
    localStGetAppInfoByIdRsp.extInfo.mapInfo.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.icon.set("https://miniapp.gtimg.cn/public/appicon/3a11a6ebe37ca1f12ddb6da9d191cc12_200.jpg");
    localStGetAppInfoByIdRsp.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
    localStGetAppInfoByIdRsp.appInfo.mainExt.file_size.set(4187784);
    localStGetAppInfoByIdRsp.appInfo.serviceCategory.add("游戏_角色扮演类");
    localObject1 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject1).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/4829db20470a5f195e9366f7f3cd6fbb.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject1).file_size.set(4183236);
    ((INTERFACE.StSubPkgInfo)localObject1).subPkgName.set("subpack");
    localObject2 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject2).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/a939c4ccee774155286e21718504085f.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject2).file_size.set(4187784);
    ((INTERFACE.StSubPkgInfo)localObject2).subPkgName.set("main");
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.type.set(3);
    localStGetAppInfoByIdRsp.appInfo.version.set("beta1.25.02");
    localStGetAppInfoByIdRsp.appInfo.versionId.set("04f6cc40aae3e914951063974608b710");
    return localStGetAppInfoByIdRsp.toByteArray();
  }
  
  private static byte[] build1107958655()
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    Object localObject1 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
    ((INTERFACE.StApiRightItem)localObject1).right.set(1);
    ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
    Object localObject2 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
    ((INTERFACE.StApiRightItem)localObject2).right.set(1);
    ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
    localStGetAppInfoByIdRsp.appInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.domain.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.extInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mDebug.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mainExt.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("reportSubmitForm");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestMidasPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("joinVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("exitVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
    localStGetAppInfoByIdRsp.appInfo.appId.set("1107958655");
    localStGetAppInfoByIdRsp.appInfo.appName.set("超级精灵球");
    localStGetAppInfoByIdRsp.appInfo.appType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.operationTags.set("精灵收集;进化");
    localStGetAppInfoByIdRsp.appInfo.basicInfo.pkgType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.versionUpdateTime.set(1575998639);
    localStGetAppInfoByIdRsp.appInfo.desc.set("小精灵，进化吧！");
    localStGetAppInfoByIdRsp.appInfo.devInfo.name.set("第三方");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("cgiwxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("distribute-stats.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("jhbjl-static.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("mprogram.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("res.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("www.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("wx.qlogo.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("wxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("proxy.gtimg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("res.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("wxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("jhbjl-static.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cgiwxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("distribute-stats.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("mprogram.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("www.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("wx.qlogo.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cgiqzonemini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cgiqqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("proxy.gtimg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connwxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqzonemini1.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqzonemini2.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqzonemini3.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqzonemini4.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqzonemini5.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("connqqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn1qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn2qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn3qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn4qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn5qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn6qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn7qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn8qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn9qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("conn10qqmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("cgiwxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("distribute-stats.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("jhbjl-static.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("mprogram.boomegg.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("res.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("www.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("wx.qlogo.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("wxmini.88duomi.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("proxy.gtimg.cn");
    localStGetAppInfoByIdRsp.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/8a5eef70c93b871bae3bdbc771f2feeb.tqapkg");
    localObject1 = new INTERFACE.StExtConfigInfo();
    ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
    ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
    localStGetAppInfoByIdRsp.appInfo.extConfig.add((MessageMicro)localObject1);
    localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("race_state");
    ((COMM.Entry)localObject1).value.set("2");
    localStGetAppInfoByIdRsp.extInfo.mapInfo.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.icon.set("https://miniapp.gtimg.cn/public/appicon/0080139e6384aa54c67f0bf16c97a125_200.jpg");
    localStGetAppInfoByIdRsp.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
    localStGetAppInfoByIdRsp.appInfo.mainExt.file_size.set(4140178);
    localStGetAppInfoByIdRsp.appInfo.serviceCategory.add("游戏_角色扮演类");
    localObject1 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject1).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/caad32e3cfa2fea9ce5f48a21ba4c68b.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject1).file_size.set(3367965);
    ((INTERFACE.StSubPkgInfo)localObject1).subPkgName.set("subpack");
    localObject2 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject2).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/8a5eef70c93b871bae3bdbc771f2feeb.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject2).file_size.set(4140178);
    ((INTERFACE.StSubPkgInfo)localObject2).subPkgName.set("main");
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.type.set(3);
    localStGetAppInfoByIdRsp.appInfo.version.set("1.1.2426");
    localStGetAppInfoByIdRsp.appInfo.versionId.set("e1cc4d631dcfaa681a1200fc78f93dad");
    return localStGetAppInfoByIdRsp.toByteArray();
  }
  
  private static byte[] build1109298876()
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    Object localObject1 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
    ((INTERFACE.StApiRightItem)localObject1).right.set(1);
    ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
    Object localObject2 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
    ((INTERFACE.StApiRightItem)localObject2).right.set(1);
    ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
    localStGetAppInfoByIdRsp.appInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.domain.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.extInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mDebug.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mainExt.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("reportSubmitForm");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestMidasPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("joinVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("exitVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
    localStGetAppInfoByIdRsp.appInfo.appId.set("1109298876");
    localStGetAppInfoByIdRsp.appInfo.appName.set("奇迹-神魔战记h5");
    localStGetAppInfoByIdRsp.appInfo.appType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.operationTags.set("经典版本;全新回归");
    localStGetAppInfoByIdRsp.appInfo.basicInfo.pkgType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.versionUpdateTime.set(1575627582);
    localStGetAppInfoByIdRsp.appInfo.desc.set("正版奇迹授权，魔界等你来战！");
    localStGetAppInfoByIdRsp.appInfo.devInfo.name.set("第三方");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs1.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs23.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("resh5qj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("reportqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("logpyqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("test-logpyqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs25.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs26.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs27.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs28.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs29.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs30.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs31.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs32.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs33.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs34.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("qijigs35.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs1.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs23.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("resh5qj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("reportqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("logpyqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("test-logpyqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs25.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs26.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs27.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs28.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs29.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs30.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs31.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs32.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("api.urlshare.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs33.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs34.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qijigs35.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs23.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs25.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs26.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs27.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs28.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs29.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs30.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs31.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs32.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs33.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs34.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs35.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs36.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs37.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs38.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs39.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs40.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qijigs41.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qjproxy1.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("qjproxy2.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs1.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs23.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("resh5qj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("reportqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("test-logpyqj.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs25.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs26.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs27.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs28.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs29.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs30.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs31.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs32.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs33.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs34.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.domain.uploadFileDomain.add("qijigs35.rydth5.com");
    localStGetAppInfoByIdRsp.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/f2bb0c243dfbe4ed8edf3d097b146d5e.tqapkg");
    localObject1 = new INTERFACE.StExtConfigInfo();
    ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
    ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
    localStGetAppInfoByIdRsp.appInfo.extConfig.add((MessageMicro)localObject1);
    localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("race_state");
    ((COMM.Entry)localObject1).value.set("2");
    localStGetAppInfoByIdRsp.extInfo.mapInfo.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.icon.set("https://miniapp.gtimg.cn/public/appicon/ec685dba9c3e58db04f76dcfb96d5387_200.jpg");
    localStGetAppInfoByIdRsp.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
    localStGetAppInfoByIdRsp.appInfo.mainExt.file_size.set(4219516);
    localStGetAppInfoByIdRsp.appInfo.serviceCategory.add("游戏_角色扮演类");
    localObject1 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject1).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/555963ddf4aeea878f9dc3590f19d769.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject1).file_size.set(3326949);
    ((INTERFACE.StSubPkgInfo)localObject1).subPkgName.set("defres");
    localObject2 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject2).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/2822f8d4ea77c046d5c5bbca8220fbd2.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject2).file_size.set(1951051);
    ((INTERFACE.StSubPkgInfo)localObject2).subPkgName.set("main");
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.type.set(3);
    localStGetAppInfoByIdRsp.appInfo.version.set("2.7.115");
    localStGetAppInfoByIdRsp.appInfo.versionId.set("4f43f402a7757e5b63874defeb9486e8");
    return localStGetAppInfoByIdRsp.toByteArray();
  }
  
  private static byte[] build1109508198()
  {
    INTERFACE.StGetAppInfoByIdRsp localStGetAppInfoByIdRsp = new INTERFACE.StGetAppInfoByIdRsp();
    Object localObject1 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
    ((INTERFACE.StApiRightItem)localObject1).right.set(1);
    ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
    Object localObject2 = new INTERFACE.StApiRightItem();
    ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
    ((INTERFACE.StApiRightItem)localObject2).right.set(1);
    ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
    localStGetAppInfoByIdRsp.appInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.domain.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.extInfo.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mDebug.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.mainExt.setHasFlag(true);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("reportSubmitForm");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestMidasPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("joinVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("exitVoIPChat");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("requestPayment");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
    localStGetAppInfoByIdRsp.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
    localStGetAppInfoByIdRsp.appInfo.appId.set("1109508198");
    localStGetAppInfoByIdRsp.appInfo.appName.set("胡莱三国");
    localStGetAppInfoByIdRsp.appInfo.appType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.operationTags.set("放置养成;武将收集");
    localStGetAppInfoByIdRsp.appInfo.basicInfo.pkgType.set(1);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
    localStGetAppInfoByIdRsp.appInfo.basicInfo.versionUpdateTime.set(1576186896);
    localStGetAppInfoByIdRsp.appInfo.desc.set("经典归来！4亿玩家的选择");
    localStGetAppInfoByIdRsp.appInfo.devInfo.name.set("第三方");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("hlsghw.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("hlsgqn.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("thirdqq.qlogo.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("tablerecord.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.downloadFileDomain.add("hlsghttp2.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("qqmarket.touch4.me");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cbi.touch4.me");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("clienterr.touch4.me");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("iploc.ywdier.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("hlsghw.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("storage.ywdier.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("market.touch4.me");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("sgfz.tuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("sq-fz.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("hlsgtest.nalrer.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cbidf.nalrer.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("thirdqq.qlogo.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("sq-hlsg.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("oapi.dingtalk.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("tablerecord.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("analy.ywdier.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("cdnmgr.tuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("gdss.touch4.me");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("hlsgqn.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("open-hlsg.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("tbr.tablerecord.com");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("xyxsf.nalrer.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.requestDomain.add("hlsghttp2.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("sq-fz.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("hlsgtest.nalrer.cn");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("sgfz.tuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("sq-hlsg.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wss-sq.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wss-bjsq.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wss-shsq.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wss-szsq.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.domain.socketDomain.add("wss-gzsq.tytuyoo.com");
    localStGetAppInfoByIdRsp.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/7308d6c0763b6e321c084828ecfcc1ec.tqapkg");
    localObject1 = new INTERFACE.StExtConfigInfo();
    ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
    ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
    localStGetAppInfoByIdRsp.appInfo.extConfig.add((MessageMicro)localObject1);
    localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("race_state");
    ((COMM.Entry)localObject1).value.set("2");
    localStGetAppInfoByIdRsp.extInfo.mapInfo.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.icon.set("https://miniapp.gtimg.cn/public/appicon/91628b538edf7291c30c2d81814a9e79_200.jpg");
    localStGetAppInfoByIdRsp.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
    localStGetAppInfoByIdRsp.appInfo.mainExt.file_size.set(4219516);
    localStGetAppInfoByIdRsp.appInfo.serviceCategory.add("游戏_策略类");
    localObject1 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject1).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/56f9ee41892c4c12fd3a8fcf44345a25.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject1).file_size.set(3475605);
    ((INTERFACE.StSubPkgInfo)localObject1).subPkgName.set("sub1");
    localObject2 = new INTERFACE.StSubPkgInfo();
    ((INTERFACE.StSubPkgInfo)localObject2).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/7308d6c0763b6e321c084828ecfcc1ec.tqapkg");
    ((INTERFACE.StSubPkgInfo)localObject2).file_size.set(4219516);
    ((INTERFACE.StSubPkgInfo)localObject2).subPkgName.set("main");
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject1);
    localStGetAppInfoByIdRsp.appInfo.subPkgs.add((MessageMicro)localObject2);
    localStGetAppInfoByIdRsp.appInfo.type.set(3);
    localStGetAppInfoByIdRsp.appInfo.version.set("v4.0.2");
    localStGetAppInfoByIdRsp.appInfo.versionId.set("55247772fb5ce0ba9ccb92158a9ea28a");
    return localStGetAppInfoByIdRsp.toByteArray();
  }
  
  public static void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener)
  {
    if (paramArrayOfByte == null)
    {
      Log.e("FakeServer", "no request data");
      paramSenderListener.onReply(-1, null, "no request data");
      return;
    }
    Object localObject1 = new PROTOCAL.StQWebReq();
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.retCode.set(0L);
    for (;;)
    {
      try
      {
        ((PROTOCAL.StQWebReq)localObject1).mergeFrom(paramArrayOfByte);
        if (((PROTOCAL.StQWebReq)localObject1).Cmdname.get().equals("GetCode"))
        {
          paramArrayOfByte = new INTERFACE.StGetCodeRsp();
          paramArrayOfByte.code.set("abc123456");
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(paramArrayOfByte.toByteArray()));
          if (paramSenderListener == null) {
            break;
          }
          paramSenderListener.onReply(0, localStQWebRsp.toByteArray(), null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      if (((PROTOCAL.StQWebReq)localObject1).Cmdname.get().equals("CheckSession"))
      {
        paramArrayOfByte = new INTERFACE.StCheckSessionRsp();
        localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(paramArrayOfByte.toByteArray()));
      }
      else if (((PROTOCAL.StQWebReq)localObject1).Cmdname.get().equals("GetProfile"))
      {
        paramArrayOfByte = new INTERFACE.StGetProfileRsp();
        paramArrayOfByte.user = new INTERFACE.StApiUserInfo();
        paramArrayOfByte.user.nick.set("SDK测试");
        localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(paramArrayOfByte.toByteArray()));
      }
      else if (((PROTOCAL.StQWebReq)localObject1).Cmdname.get().equals("GetAppInfoById"))
      {
        paramArrayOfByte = new INTERFACE.StGetAppInfoByIdReq();
        paramArrayOfByte.mergeFrom(((PROTOCAL.StQWebReq)localObject1).busiBuff.get().toByteArray());
        Object localObject2;
        if (paramArrayOfByte.appid.get().equals("1108197111"))
        {
          paramArrayOfByte = new INTERFACE.StGetAppInfoByIdRsp();
          localObject1 = new INTERFACE.StApiRightItem();
          ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
          ((INTERFACE.StApiRightItem)localObject1).right.set(1);
          ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
          localObject2 = new INTERFACE.StApiRightItem();
          ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
          ((INTERFACE.StApiRightItem)localObject2).right.set(1);
          ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
          paramArrayOfByte.appInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.apiRight.setHasFlag(true);
          paramArrayOfByte.appInfo.basicInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.domain.setHasFlag(true);
          paramArrayOfByte.appInfo.extInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.mDebug.setHasFlag(true);
          paramArrayOfByte.appInfo.mainExt.setHasFlag(true);
          paramArrayOfByte.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
          paramArrayOfByte.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("reportSubmitForm");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestMidasPayment");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("joinVoIPChat");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("exitVoIPChat");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestPayment");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
          paramArrayOfByte.appInfo.appId.set("1108197111");
          paramArrayOfByte.appInfo.appName.set("消灭方块");
          paramArrayOfByte.appInfo.appType.set(1);
          paramArrayOfByte.appInfo.baselibMiniVersion.set("1.0.14.10008");
          paramArrayOfByte.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
          paramArrayOfByte.appInfo.basicInfo.versionUpdateTime.set(1575337021);
          paramArrayOfByte.appInfo.desc.set("《消灭方块》是一款休闲益智的方块消除游戏。只需拖动方块，让它们在行列填满即可消除得分！");
          paramArrayOfByte.appInfo.devInfo.name.set("第三方");
          paramArrayOfByte.appInfo.domain.downloadFileDomain.add("yxweb.bangduonet.com");
          paramArrayOfByte.appInfo.domain.downloadFileDomain.add("yxs.bangduonet.com");
          paramArrayOfByte.appInfo.domain.downloadFileDomain.add("yxweb.bangduonet.com:10801");
          paramArrayOfByte.appInfo.domain.requestDomain.add("yxweb.bangduonet.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("yxs.bangduonet.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("yxweb.bangduonet.com:10801");
          paramArrayOfByte.appInfo.domain.requestDomain.add("pingtas.qq.com");
          paramArrayOfByte.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/4587105293d57ad69123fb1d4e874957.tqapkg");
          localObject1 = new INTERFACE.StExtConfigInfo();
          ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
          ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
          paramArrayOfByte.appInfo.extConfig.add((MessageMicro)localObject1);
          localObject1 = new COMM.Entry();
          ((COMM.Entry)localObject1).key.set("race_state");
          ((COMM.Entry)localObject1).value.set("2");
          paramArrayOfByte.appInfo.extInfo.mapInfo.add((MessageMicro)localObject1);
          paramArrayOfByte.appInfo.icon.set("https://miniapp.gtimg.cn/public/appicon/ead43727a1189670a873bf74d1bb6a91_200.jpg");
          paramArrayOfByte.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
          paramArrayOfByte.appInfo.mainExt.file_size.set(2102726);
          paramArrayOfByte.appInfo.serviceCategory.add("游戏_消除类");
          paramArrayOfByte.appInfo.type.set(3);
          paramArrayOfByte.appInfo.version.set("v3.0.20");
          paramArrayOfByte.appInfo.versionId.set("b7e6afafb0ef788a03202c10258ff8a3");
          paramArrayOfByte.getSerializedSize();
          paramArrayOfByte.toByteArray();
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(paramArrayOfByte.toByteArray()));
        }
        else if (paramArrayOfByte.appid.get().equals("1108196450"))
        {
          paramArrayOfByte = new INTERFACE.StGetAppInfoByIdRsp();
          localObject1 = new INTERFACE.StApiRightItem();
          ((INTERFACE.StApiRightItem)localObject1).apiName.set("invokeNativePlugin");
          ((INTERFACE.StApiRightItem)localObject1).right.set(1);
          ((INTERFACE.StApiRightItem)localObject1).secondName.set("uploadAvatar");
          localObject2 = new INTERFACE.StApiRightItem();
          ((INTERFACE.StApiRightItem)localObject2).apiName.set("openScheme");
          ((INTERFACE.StApiRightItem)localObject2).right.set(1);
          ((INTERFACE.StApiRightItem)localObject2).secondName.set("mqqapi://card/show_pslcard");
          paramArrayOfByte.appInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.apiRight.setHasFlag(true);
          paramArrayOfByte.appInfo.basicInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.domain.setHasFlag(true);
          paramArrayOfByte.appInfo.extInfo.setHasFlag(true);
          paramArrayOfByte.appInfo.mDebug.setHasFlag(true);
          paramArrayOfByte.appInfo.mainExt.setHasFlag(true);
          paramArrayOfByte.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject1);
          paramArrayOfByte.appInfo.apiRight.secondApiRights.add((MessageMicro)localObject2);
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("reportSubmitForm");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("updateVoIPChatMuteConfig");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatMembersChanged");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("updateHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestMidasPayment");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("insertHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("joinVoIPChat");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestPaymentToBank");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("exitVoIPChat");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("removeHTMLWebView");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onWebInvokeAppService");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("requestPayment");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatInterrupted");
          paramArrayOfByte.appInfo.apiRight.whiteLst.add("onVoIPChatSpeakersChanged");
          paramArrayOfByte.appInfo.appId.set("1108196450");
          paramArrayOfByte.appInfo.appName.set("六界飞仙");
          paramArrayOfByte.appInfo.appType.set(1);
          paramArrayOfByte.appInfo.basicInfo.operationTags.set("Q萌二次元;恋爱仙侠");
          paramArrayOfByte.appInfo.basicInfo.pkgType.set(1);
          paramArrayOfByte.appInfo.basicInfo.usrFileSizeLimit.set(52428800L);
          paramArrayOfByte.appInfo.basicInfo.versionUpdateTime.set(1574993620);
          paramArrayOfByte.appInfo.desc.set("仙界问情，修仙路上遇到心动的Ta");
          paramArrayOfByte.appInfo.devInfo.name.set("第三方");
          paramArrayOfByte.appInfo.domain.downloadFileDomain.add("static-qccdn-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("web-reviews-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("web-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("cdh-log.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("static-qccdn-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("game-ljpvp-tx.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("cdh-log.mingchao.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("web-reviews-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.requestDomain.add("web-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.socketDomain.add("tx9991-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.socketDomain.add("tx9992-ljpvp.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.socketDomain.add("bgp2-uc-ljh5.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.domain.socketDomain.add("game-ljpvp-tx.mingchaoyouxi.com");
          paramArrayOfByte.appInfo.donwLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/40e34b458f9e236f0cf154549e1219c9.tqapkg");
          localObject1 = new INTERFACE.StExtConfigInfo();
          ((INTERFACE.StExtConfigInfo)localObject1).configKey.set("apiscopeconfig");
          ((INTERFACE.StExtConfigInfo)localObject1).configVersion.set("0.0.7");
          paramArrayOfByte.appInfo.extConfig.add((MessageMicro)localObject1);
          localObject1 = new COMM.Entry();
          ((COMM.Entry)localObject1).key.set("race_state");
          ((COMM.Entry)localObject1).value.set("2");
          paramArrayOfByte.extInfo.mapInfo.add((MessageMicro)localObject1);
          paramArrayOfByte.appInfo.icon.set("https://r.photo.store.qq.com/psb?/V1193gcM2HJKFW/GDdkiftF0eUGSyJo0IrF3jjwuUZKwKiKDlVRLMLWois!/o/dE4BAAAAAAAA&bo=yADIAMgAyAADEDU!");
          paramArrayOfByte.appInfo.mDebug.wsUrl.set("wss://q.qq.com/ws/terminal");
          paramArrayOfByte.appInfo.mainExt.file_size.set(733762);
          paramArrayOfByte.appInfo.serviceCategory.add("游戏_角色扮演类");
          localObject1 = new INTERFACE.StSubPkgInfo();
          ((INTERFACE.StSubPkgInfo)localObject1).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/40e34b458f9e236f0cf154549e1219c9.tqapkg");
          ((INTERFACE.StSubPkgInfo)localObject1).file_size.set(733762);
          ((INTERFACE.StSubPkgInfo)localObject1).subPkgName.set("main");
          localObject2 = new INTERFACE.StSubPkgInfo();
          ((INTERFACE.StSubPkgInfo)localObject2).dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/bded5e1866a3b2de9566031ce262d684.tqapkg");
          ((INTERFACE.StSubPkgInfo)localObject2).file_size.set(4075376);
          ((INTERFACE.StSubPkgInfo)localObject2).subPkgName.set("subPack");
          INTERFACE.StSubPkgInfo localStSubPkgInfo = new INTERFACE.StSubPkgInfo();
          localStSubPkgInfo.dowLoadUrl.set("https://miniapp.gtimg.cn/public/pkg/554a28a6ffa433c1527c533a42230d48.tqapkg");
          localStSubPkgInfo.file_size.set(571984);
          localStSubPkgInfo.subPkgName.set("viewPart");
          paramArrayOfByte.appInfo.subPkgs.add((MessageMicro)localObject1);
          paramArrayOfByte.appInfo.subPkgs.add((MessageMicro)localObject2);
          paramArrayOfByte.appInfo.subPkgs.add(localStSubPkgInfo);
          paramArrayOfByte.appInfo.tags.set("a1_a1-3,a2_a2-4,a2_a2-1,a3_a3-5,a3_a3-4");
          paramArrayOfByte.appInfo.type.set(3);
          paramArrayOfByte.appInfo.version.set("23514");
          paramArrayOfByte.appInfo.versionId.set("8be599a43182d2b7babc862b12bebde7");
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(paramArrayOfByte.toByteArray()));
        }
        else if (paramArrayOfByte.appid.get().equals("1107953026"))
        {
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(build1107953026()));
        }
        else if (paramArrayOfByte.appid.get().equals("1107958655"))
        {
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(build1107958655()));
        }
        else if (paramArrayOfByte.appid.get().equals("1109508198"))
        {
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(build1109508198()));
        }
        else if (paramArrayOfByte.appid.get().equals("1109298876"))
        {
          localStQWebRsp.busiBuff.set(ByteStringMicro.copyFrom(build1109298876()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.FakeServer
 * JD-Core Version:    0.7.0.1
 */