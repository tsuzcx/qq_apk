package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import QQService.RespHead;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.LBSInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyCmdHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.LbsUtils;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LikeResultItem;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager.LimitInfo;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.nowsummarycard.NowSummaryCard.ClientInfo;
import com.tencent.nowsummarycard.NowSummaryCard.LocationInfo;
import com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardReq;
import com.tencent.nowsummarycard.NowSummaryCard.ReqNearbySummaryCard;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.ReqBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.LoginSig;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.LoginSig;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.nearby.nearby_ice_break.IceReq;

public class NearbyCardHandler
  extends BusinessHandler
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Set<String> a;
  
  public NearbyCardHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
  }
  
  private long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private NowSummaryCard.ClientInfo a()
  {
    NowSummaryCard.ClientInfo localClientInfo = new NowSummaryCard.ClientInfo();
    localClientInfo.client_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
    localClientInfo.platform.set(2);
    localClientInfo.imei.set(ByteStringMicro.copyFrom(MobileInfoUtil.c().getBytes()));
    return localClientInfo;
  }
  
  private NowSummaryCard.LocationInfo a()
  {
    NowSummaryCard.LocationInfo localLocationInfo = new NowSummaryCard.LocationInfo();
    Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoLbsInfo)localObject).mLocation;
      long l1 = Double.valueOf(((SosoLocation)localObject).mLat02 * 1000000.0D).longValue();
      long l2 = Double.valueOf(((SosoLocation)localObject).mLon02 * 1000000.0D).longValue();
      localLocationInfo.latitude.set(Long.valueOf(l1).longValue());
      localLocationInfo.longitude.set(Long.valueOf(l2).longValue());
    }
    return localLocationInfo;
  }
  
  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString, byte paramByte, ToServiceMsg paramToServiceMsg)
  {
    NowSummaryCard.ReqNearbySummaryCard localReqNearbySummaryCard = new NowSummaryCard.ReqNearbySummaryCard();
    localReqNearbySummaryCard.tiny_id.set(paramLong2);
    try
    {
      localReqNearbySummaryCard.uin.set(Long.valueOf(paramString).longValue());
      localReqNearbySummaryCard.location.set(a());
      localReqNearbySummaryCard.client_info.set(a());
      localReqNearbySummaryCard.come_from.set(paramInt2);
      NowSummaryCard.NearbySummaryCardReq localNearbySummaryCardReq = new NowSummaryCard.NearbySummaryCardReq();
      localNearbySummaryCardReq.id.set(paramLong1);
      localNearbySummaryCardReq.id_type.set(paramInt1);
      localNearbySummaryCardReq.gender.set(1L);
      localNearbySummaryCardReq.pb_data.set(ByteStringMicro.copyFrom(localReqNearbySummaryCard.toByteArray()));
      QLog.e("NearbyCardHandler", 1, "start uin:" + paramString + ", tinyId:" + paramLong2 + ", nowId:" + paramLong1 + ", from:" + paramInt2);
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new NearbyCardHandler.2(this, false, paramToServiceMsg), localNearbySummaryCardReq.toByteArray(), "NowSummaryCard.NearbySummaryCardReq");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("NearbyCardHandler", 1, "getNearbySummaryCard, illegal uin: " + paramString);
      }
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard paramRespNearbySummaryCard, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 251
    //   3: invokevirtual 257	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 7
    //   8: aload_3
    //   9: ldc_w 259
    //   12: invokevirtual 263	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   15: istore 5
    //   17: iload_1
    //   18: ifeq +7 -> 25
    //   21: aload_2
    //   22: ifnonnull +14 -> 36
    //   25: aload_0
    //   26: bipush 51
    //   28: iconst_0
    //   29: aconst_null
    //   30: iload 7
    //   32: invokevirtual 267	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   35: return
    //   36: ldc 198
    //   38: iconst_1
    //   39: new 200	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 269
    //   49: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: getfield 272	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   56: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   59: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 209
    //   64: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_2
    //   68: getfield 276	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   71: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   74: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: ldc_w 278
    //   80: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: getfield 282	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   87: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   90: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: invokevirtual 290	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   106: invokevirtual 296	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   109: astore 15
    //   111: aload 15
    //   113: invokevirtual 302	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   116: astore 16
    //   118: aload 16
    //   120: invokevirtual 307	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   123: aload_3
    //   124: ldc_w 309
    //   127: lconst_0
    //   128: invokevirtual 313	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   131: lstore 8
    //   133: aload_3
    //   134: ldc_w 315
    //   137: invokevirtual 317	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   140: lstore 10
    //   142: aload_3
    //   143: ldc_w 319
    //   146: invokevirtual 263	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   149: istore 4
    //   151: iload 4
    //   153: ifne +669 -> 822
    //   156: aload 15
    //   158: ldc_w 321
    //   161: ldc_w 323
    //   164: iconst_1
    //   165: anewarray 46	java/lang/String
    //   168: dup
    //   169: iconst_0
    //   170: lload 8
    //   172: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   175: aastore
    //   176: invokevirtual 330	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   179: checkcast 321	com/tencent/mobileqq/data/NearbyPeopleCard
    //   182: astore_3
    //   183: aload_3
    //   184: ifnonnull +675 -> 859
    //   187: new 321	com/tencent/mobileqq/data/NearbyPeopleCard
    //   190: dup
    //   191: invokespecial 331	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   194: astore 14
    //   196: iload 5
    //   198: ifne +852 -> 1050
    //   201: iconst_1
    //   202: istore_1
    //   203: aload 14
    //   205: iload_1
    //   206: putfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   209: aload 14
    //   211: getfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   214: ifeq +841 -> 1055
    //   217: aload 14
    //   219: aload_0
    //   220: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   223: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   226: putfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   229: lload 8
    //   231: lconst_0
    //   232: lcmp
    //   233: ifle +862 -> 1095
    //   236: aload 14
    //   238: lload 8
    //   240: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   243: aload 14
    //   245: lload 10
    //   247: putfield 346	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   250: aload 14
    //   252: iload 4
    //   254: putfield 349	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   257: aload 14
    //   259: aload_2
    //   260: getfield 282	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   263: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   266: putfield 352	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   269: aload 14
    //   271: aload_2
    //   272: getfield 355	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:rich_sign	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   275: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   278: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   281: putfield 363	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   284: aload 14
    //   286: aload_2
    //   287: getfield 364	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gender	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   290: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   293: l2i
    //   294: i2b
    //   295: putfield 367	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   298: aload 14
    //   300: aload_2
    //   301: getfield 371	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:age	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   304: invokevirtual 376	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   307: putfield 378	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   310: aload 14
    //   312: aload_2
    //   313: getfield 381	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:birthday	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   316: invokevirtual 382	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   319: l2i
    //   320: putfield 384	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   323: aload 14
    //   325: aload_2
    //   326: getfield 387	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:profession	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   329: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   332: putfield 391	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   335: aload 14
    //   337: aload_2
    //   338: getfield 394	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:constellation	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   341: invokevirtual 376	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   344: i2b
    //   345: putfield 396	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   348: aload 14
    //   350: aload_2
    //   351: getfield 399	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:distance	Lcom/tencent/mobileqq/pb/PBStringField;
    //   354: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   357: putfield 401	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   360: aload 14
    //   362: aload_2
    //   363: getfield 404	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:elapse	Lcom/tencent/mobileqq/pb/PBStringField;
    //   366: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   369: putfield 407	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   372: aload 14
    //   374: aload_2
    //   375: getfield 410	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:company	Lcom/tencent/mobileqq/pb/PBStringField;
    //   378: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   381: putfield 412	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   384: aload 14
    //   386: aload_2
    //   387: getfield 415	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school	Lcom/tencent/mobileqq/pb/PBStringField;
    //   390: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   393: putfield 418	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   396: aload 14
    //   398: aload_2
    //   399: getfield 421	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:marriage	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   402: invokevirtual 376	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   405: i2b
    //   406: putfield 424	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   409: aload 14
    //   411: aload_2
    //   412: getfield 427	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   415: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   418: putfield 430	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   421: aload 14
    //   423: aload_2
    //   424: getfield 433	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:nearby_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   427: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   430: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   433: putfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   436: aload 14
    //   438: aload_2
    //   439: getfield 439	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_country	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   442: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   445: i2l
    //   446: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   449: putfield 446	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   452: aload 14
    //   454: aload_2
    //   455: getfield 449	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_province	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   458: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   461: i2l
    //   462: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   465: putfield 452	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   468: aload 14
    //   470: aload_2
    //   471: getfield 455	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_city	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   474: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   477: i2l
    //   478: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   481: putfield 458	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   484: aload 14
    //   486: aload_2
    //   487: getfield 461	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:home_zone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   490: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   493: i2l
    //   494: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   497: putfield 464	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   500: aload 14
    //   502: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   505: putfield 472	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   508: aload 14
    //   510: aload_2
    //   511: getfield 475	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:temp_chat_sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   514: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   517: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   520: putfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   523: aload_2
    //   524: getfield 481	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:is_friend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   527: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   530: iconst_1
    //   531: if_icmpne +595 -> 1126
    //   534: iconst_1
    //   535: istore_1
    //   536: aload 14
    //   538: iload_1
    //   539: putfield 484	com/tencent/mobileqq/data/NearbyPeopleCard:isFriend	Z
    //   542: aload 14
    //   544: aload_2
    //   545: getfield 487	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:chat_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   548: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   551: putfield 490	com/tencent/mobileqq/data/NearbyPeopleCard:chatId	J
    //   554: aload 14
    //   556: iload 5
    //   558: putfield 493	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   561: aload 14
    //   563: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   566: ifnull +565 -> 1131
    //   569: aload 14
    //   571: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   574: arraylength
    //   575: ifne +56 -> 631
    //   578: aload 14
    //   580: getfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   583: ifne +48 -> 631
    //   586: aload_0
    //   587: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   590: ldc_w 495
    //   593: ldc_w 497
    //   596: ldc_w 499
    //   599: ldc_w 501
    //   602: ldc_w 503
    //   605: iconst_0
    //   606: iconst_0
    //   607: aload_0
    //   608: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   611: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   614: aload 14
    //   616: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   619: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   622: ldc_w 499
    //   625: ldc_w 499
    //   628: invokestatic 509	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   631: aload_0
    //   632: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   635: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   638: aload 14
    //   640: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   643: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   646: invokevirtual 519	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;)[B
    //   649: ifnonnull +26 -> 675
    //   652: aload_0
    //   653: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   656: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   659: aload 14
    //   661: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   664: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   667: aload 14
    //   669: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   672: invokevirtual 523	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   675: aload_2
    //   676: getfield 526	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:common_label	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   679: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   682: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   685: astore_3
    //   686: aload_3
    //   687: ifnull +502 -> 1189
    //   690: aload 14
    //   692: new 528	java/util/ArrayList
    //   695: dup
    //   696: invokespecial 529	java/util/ArrayList:<init>	()V
    //   699: putfield 533	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   702: new 535	appoint/define/appoint_define$CommonLabel
    //   705: dup
    //   706: invokespecial 536	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   709: astore 17
    //   711: aload 17
    //   713: aload_3
    //   714: invokevirtual 540	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   717: pop
    //   718: aload 17
    //   720: getfield 544	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   723: invokevirtual 549	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   726: astore_3
    //   727: aload 17
    //   729: getfield 552	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   732: invokevirtual 549	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   735: astore 18
    //   737: new 554	org/json/JSONArray
    //   740: dup
    //   741: invokespecial 555	org/json/JSONArray:<init>	()V
    //   744: astore 17
    //   746: aload_3
    //   747: invokeinterface 560 1 0
    //   752: aload 18
    //   754: invokeinterface 560 1 0
    //   759: if_icmpne +420 -> 1179
    //   762: iconst_0
    //   763: istore 4
    //   765: iload 4
    //   767: aload_3
    //   768: invokeinterface 560 1 0
    //   773: if_icmpge +406 -> 1179
    //   776: aload_3
    //   777: iload 4
    //   779: invokeinterface 563 2 0
    //   784: checkcast 52	com/tencent/mobileqq/pb/ByteStringMicro
    //   787: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   790: astore 18
    //   792: aload 14
    //   794: getfield 533	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   797: aload 18
    //   799: invokeinterface 570 2 0
    //   804: pop
    //   805: aload 17
    //   807: aload 18
    //   809: invokevirtual 574	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   812: pop
    //   813: iload 4
    //   815: iconst_1
    //   816: iadd
    //   817: istore 4
    //   819: goto -54 -> 765
    //   822: lload 10
    //   824: lconst_0
    //   825: lcmp
    //   826: ifle +2611 -> 3437
    //   829: aload 15
    //   831: ldc_w 321
    //   834: ldc_w 576
    //   837: iconst_1
    //   838: anewarray 46	java/lang/String
    //   841: dup
    //   842: iconst_0
    //   843: lload 10
    //   845: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   848: aastore
    //   849: invokevirtual 330	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   852: checkcast 321	com/tencent/mobileqq/data/NearbyPeopleCard
    //   855: astore_3
    //   856: goto -673 -> 183
    //   859: aload_3
    //   860: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   863: istore 6
    //   865: aload_3
    //   866: invokevirtual 582	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   869: lstore 12
    //   871: new 321	com/tencent/mobileqq/data/NearbyPeopleCard
    //   874: dup
    //   875: invokespecial 331	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   878: astore 14
    //   880: aload 14
    //   882: aload_3
    //   883: getfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   886: putfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   889: aload 14
    //   891: aload_3
    //   892: getfield 588	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   895: putfield 588	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   898: aload 14
    //   900: aload_3
    //   901: getfield 591	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   904: putfield 591	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   907: aload 14
    //   909: aload_3
    //   910: getfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   913: putfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   916: aload 14
    //   918: aload_3
    //   919: getfield 597	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   922: putfield 597	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   925: aload 14
    //   927: aload_3
    //   928: getfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   931: putfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   934: aload 14
    //   936: aload_3
    //   937: getfield 603	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   940: putfield 603	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   943: aload 14
    //   945: aload_3
    //   946: getfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   949: putfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   952: aload 14
    //   954: aload_3
    //   955: getfield 609	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   958: putfield 609	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   961: aload 14
    //   963: aload_3
    //   964: getfield 612	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   967: putfield 612	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   970: aload 14
    //   972: aload_3
    //   973: getfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   976: putfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   979: aload 14
    //   981: aload_3
    //   982: getfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   985: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   988: aload 14
    //   990: aload_3
    //   991: getfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   994: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   997: aload 14
    //   999: aload_3
    //   1000: getfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1003: putfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1006: aload 14
    //   1008: aload_3
    //   1009: getfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1012: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1015: aload 14
    //   1017: aload_3
    //   1018: getfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1021: putfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1024: aload 14
    //   1026: aload_3
    //   1027: getfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1030: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1033: aload 14
    //   1035: iload 6
    //   1037: invokevirtual 633	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1040: aload 14
    //   1042: lload 12
    //   1044: invokevirtual 636	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1047: goto -851 -> 196
    //   1050: iconst_0
    //   1051: istore_1
    //   1052: goto -849 -> 203
    //   1055: aload_2
    //   1056: getfield 481	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:is_friend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1059: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1062: iconst_1
    //   1063: if_icmpne +21 -> 1084
    //   1066: aload 14
    //   1068: aload_2
    //   1069: getfield 272	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1072: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1075: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1078: putfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1081: goto -852 -> 229
    //   1084: aload 14
    //   1086: ldc_w 638
    //   1089: putfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1092: goto -863 -> 229
    //   1095: aload 14
    //   1097: aload_2
    //   1098: getfield 276	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1101: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1104: invokestatic 131	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1107: invokevirtual 132	java/lang/Long:longValue	()J
    //   1110: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1113: goto -870 -> 243
    //   1116: astore_3
    //   1117: aload 14
    //   1119: lconst_0
    //   1120: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1123: goto -880 -> 243
    //   1126: iconst_0
    //   1127: istore_1
    //   1128: goto -592 -> 536
    //   1131: aload_0
    //   1132: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1135: ldc_w 495
    //   1138: ldc_w 497
    //   1141: ldc_w 499
    //   1144: ldc_w 501
    //   1147: ldc_w 640
    //   1150: iconst_0
    //   1151: iconst_0
    //   1152: aload_0
    //   1153: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1156: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1159: aload 14
    //   1161: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1164: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1167: ldc_w 499
    //   1170: ldc_w 499
    //   1173: invokestatic 509	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1176: goto -501 -> 675
    //   1179: aload 14
    //   1181: aload 17
    //   1183: invokevirtual 641	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1186: putfield 644	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1189: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1192: ifeq +36 -> 1228
    //   1195: ldc_w 650
    //   1198: iconst_4
    //   1199: new 200	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1206: ldc_w 652
    //   1209: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload_2
    //   1213: getfield 427	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:school_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1216: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1219: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1228: aload 14
    //   1230: aload_2
    //   1231: getfield 658	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:date_face	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1234: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1237: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1240: aconst_null
    //   1241: aload 14
    //   1243: getfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   1246: invokevirtual 662	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1249: pop
    //   1250: aload 14
    //   1252: getfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1255: ldc2_w 666
    //   1258: land
    //   1259: lconst_0
    //   1260: lcmp
    //   1261: ifeq +1532 -> 2793
    //   1264: aload 14
    //   1266: iconst_1
    //   1267: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1270: aload 14
    //   1272: getfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1275: ldc2_w 671
    //   1278: land
    //   1279: lconst_0
    //   1280: lcmp
    //   1281: ifeq +1521 -> 2802
    //   1284: aload 14
    //   1286: iconst_1
    //   1287: putfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1290: aload 14
    //   1292: invokevirtual 678	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1295: ifne +27 -> 1322
    //   1298: aload 14
    //   1300: ldc_w 499
    //   1303: putfield 681	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1306: aload 14
    //   1308: ldc_w 499
    //   1311: putfield 684	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1314: aload 14
    //   1316: ldc_w 499
    //   1319: putfield 687	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1322: aload_2
    //   1323: getfield 691	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1326: invokevirtual 696	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:has	()Z
    //   1329: ifeq +1503 -> 2832
    //   1332: aload_2
    //   1333: getfield 691	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1336: getfield 699	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1339: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1342: i2l
    //   1343: lstore 8
    //   1345: new 701	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   1348: dup
    //   1349: invokespecial 702	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   1352: astore_3
    //   1353: aload_3
    //   1354: aload_2
    //   1355: getfield 691	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:interest_tag	Lcom/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo;
    //   1358: getfield 705	com/tencent/nowsummarycard/NowSummaryCard$InterestTagInfo:tag_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1361: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1364: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1367: invokevirtual 706	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1370: pop
    //   1371: aload 14
    //   1373: lload 8
    //   1375: aload_3
    //   1376: getfield 710	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1379: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1382: invokevirtual 717	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   1385: aload_2
    //   1386: getfield 721	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1389: invokevirtual 724	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:has	()Z
    //   1392: ifeq +43 -> 1435
    //   1395: aload 14
    //   1397: aload_2
    //   1398: getfield 721	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1401: invokevirtual 727	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1404: checkcast 723	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo
    //   1407: getfield 730	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:open_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1410: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1413: i2l
    //   1414: putfield 733	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   1417: aload 14
    //   1419: aload_2
    //   1420: getfield 721	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:gift_info	Lcom/tencent/nowsummarycard/NowSummaryCard$GiftInfo;
    //   1423: invokevirtual 727	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1426: checkcast 723	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo
    //   1429: invokevirtual 734	com/tencent/nowsummarycard/NowSummaryCard$GiftInfo:toByteArray	()[B
    //   1432: putfield 737	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   1435: aload_2
    //   1436: getfield 741	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:vote_info	Lcom/tencent/nowsummarycard/NowSummaryCard$VoteInfo;
    //   1439: invokevirtual 744	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:has	()Z
    //   1442: ifeq +89 -> 1531
    //   1445: aload_2
    //   1446: getfield 741	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:vote_info	Lcom/tencent/nowsummarycard/NowSummaryCard$VoteInfo;
    //   1449: invokevirtual 745	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1452: checkcast 743	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo
    //   1455: astore_3
    //   1456: aload 14
    //   1458: aload_3
    //   1459: getfield 748	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:vote_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1462: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1465: putfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1468: aload 14
    //   1470: aload_3
    //   1471: getfield 754	com/tencent/nowsummarycard/NowSummaryCard$VoteInfo:latest_vote_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1474: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1477: putfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1480: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1483: ifeq +48 -> 1531
    //   1486: ldc_w 650
    //   1489: iconst_2
    //   1490: new 200	java/lang/StringBuilder
    //   1493: dup
    //   1494: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1497: ldc_w 762
    //   1500: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: aload 14
    //   1505: getfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1508: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1511: ldc_w 764
    //   1514: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1517: aload 14
    //   1519: getfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1522: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1525: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: aload 14
    //   1533: getfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   1536: ifnull +787 -> 2323
    //   1539: new 766	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   1542: dup
    //   1543: invokespecial 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   1546: astore_3
    //   1547: aload_3
    //   1548: aload 14
    //   1550: getfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   1553: invokevirtual 768	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1556: pop
    //   1557: iload 5
    //   1559: bipush 51
    //   1561: if_icmpne +1300 -> 2861
    //   1564: aload_3
    //   1565: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1568: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1571: iconst_1
    //   1572: if_icmpne +1279 -> 2851
    //   1575: iconst_1
    //   1576: istore_1
    //   1577: aload 14
    //   1579: iload_1
    //   1580: putfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1583: aload_3
    //   1584: getfield 774	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1587: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1590: iconst_1
    //   1591: if_icmpne +1265 -> 2856
    //   1594: iconst_1
    //   1595: istore_1
    //   1596: aload 14
    //   1598: iload_1
    //   1599: putfield 588	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1602: aload 14
    //   1604: aload_3
    //   1605: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1608: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1611: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1614: putfield 612	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1617: aload 14
    //   1619: aload_3
    //   1620: getfield 780	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1623: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1626: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1629: putfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1632: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1635: ifeq +1336 -> 2971
    //   1638: ldc_w 782
    //   1641: iconst_2
    //   1642: new 200	java/lang/StringBuilder
    //   1645: dup
    //   1646: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1649: ldc_w 784
    //   1652: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: iload 5
    //   1657: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1660: ldc_w 786
    //   1663: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: aload_3
    //   1667: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1670: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1673: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: ldc_w 788
    //   1679: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload_3
    //   1683: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1686: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1689: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1692: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: ldc_w 790
    //   1698: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: aload_0
    //   1702: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1705: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1708: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1714: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1717: aload 14
    //   1719: aload_3
    //   1720: getfield 796	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1723: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1726: putfield 597	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1729: aload_3
    //   1730: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1733: invokevirtual 803	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   1736: ifeq +1342 -> 3078
    //   1739: aload 14
    //   1741: aload_3
    //   1742: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1745: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1748: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1751: getfield 807	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1754: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1757: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1760: putfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1763: aload 14
    //   1765: aload_3
    //   1766: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1769: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1772: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1775: getfield 810	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1778: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1781: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1784: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1787: aload 14
    //   1789: aload_3
    //   1790: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1793: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1796: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1799: getfield 813	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1802: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1805: putfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1808: aload 14
    //   1810: aload_3
    //   1811: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1814: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1817: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1820: getfield 816	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1823: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1826: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1829: putfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1832: aload 14
    //   1834: aload_3
    //   1835: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1838: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1841: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1844: getfield 819	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1847: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1850: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1853: aload 14
    //   1855: aload_3
    //   1856: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   1859: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1862: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   1865: getfield 822	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1868: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1871: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1874: aload_3
    //   1875: getfield 825	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1878: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1881: iconst_1
    //   1882: if_icmpne +1560 -> 3442
    //   1885: iconst_1
    //   1886: istore_1
    //   1887: aload 14
    //   1889: iload_1
    //   1890: putfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   1893: aload 14
    //   1895: aload_3
    //   1896: getfield 831	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1899: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1902: putfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   1905: aload 14
    //   1907: aload_3
    //   1908: getfield 837	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1911: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1914: putfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   1917: aload 14
    //   1919: aload_3
    //   1920: getfield 843	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1923: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1926: putfield 846	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   1929: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1932: ifeq +104 -> 2036
    //   1935: ldc_w 848
    //   1938: iconst_2
    //   1939: new 200	java/lang/StringBuilder
    //   1942: dup
    //   1943: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1946: ldc_w 850
    //   1949: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: aload 14
    //   1954: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1957: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1960: ldc_w 852
    //   1963: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: aload 14
    //   1968: getfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   1971: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1974: ldc_w 857
    //   1977: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: aload 14
    //   1982: invokevirtual 860	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   1985: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1988: ldc_w 862
    //   1991: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: aload 14
    //   1996: getfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   1999: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: ldc_w 864
    //   2005: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: aload 14
    //   2010: getfield 846	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   2013: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2016: ldc_w 866
    //   2019: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: aload 14
    //   2024: getfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   2027: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2030: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2033: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2036: aload_3
    //   2037: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2040: invokevirtual 873	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   2043: ifeq +1080 -> 3123
    //   2046: aload 14
    //   2048: aload_3
    //   2049: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2052: getfield 876	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2055: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2058: putfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   2061: aload 14
    //   2063: aload_3
    //   2064: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2067: getfield 882	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2070: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2073: putfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   2076: aload 14
    //   2078: aload_3
    //   2079: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2082: getfield 888	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2085: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2088: putfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   2091: aload 14
    //   2093: aload_3
    //   2094: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2097: getfield 894	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2100: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2103: putfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   2106: aload 14
    //   2108: aload_3
    //   2109: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2112: getfield 900	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2115: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2118: putfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   2121: aload 14
    //   2123: aload_3
    //   2124: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2127: getfield 906	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2130: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2133: putfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   2136: aload 14
    //   2138: aload_3
    //   2139: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   2142: getfield 912	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2145: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2148: putfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   2151: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2154: ifeq +169 -> 2323
    //   2157: new 200	java/lang/StringBuilder
    //   2160: dup
    //   2161: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2164: astore_3
    //   2165: aload_3
    //   2166: ldc_w 917
    //   2169: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: ldc_w 919
    //   2175: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2178: aload 14
    //   2180: getfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   2183: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: ldc_w 921
    //   2189: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: ldc_w 923
    //   2195: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2198: aload 14
    //   2200: getfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   2203: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: ldc_w 921
    //   2209: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2212: ldc_w 925
    //   2215: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2218: aload 14
    //   2220: getfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   2223: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2226: ldc_w 921
    //   2229: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2232: ldc_w 927
    //   2235: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: aload 14
    //   2240: getfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   2243: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: ldc_w 921
    //   2249: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2252: ldc_w 929
    //   2255: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: aload 14
    //   2260: getfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   2263: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: ldc_w 921
    //   2269: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: ldc_w 931
    //   2275: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2278: aload 14
    //   2280: getfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   2283: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2286: ldc_w 921
    //   2289: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2292: ldc_w 933
    //   2295: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2298: aload 14
    //   2300: getfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   2303: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: ldc_w 921
    //   2309: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2312: pop
    //   2313: ldc 198
    //   2315: iconst_2
    //   2316: aload_3
    //   2317: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2320: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2323: aload 14
    //   2325: aload_2
    //   2326: getfield 936	com/tencent/nowsummarycard/NowSummaryCard$RespNearbySummaryCard:now_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2329: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2332: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2335: putfield 939	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   2338: new 941	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   2341: dup
    //   2342: invokespecial 942	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   2345: astore_3
    //   2346: aload_3
    //   2347: aload 14
    //   2349: getfield 939	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   2352: invokevirtual 943	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2355: pop
    //   2356: aload_3
    //   2357: astore_2
    //   2358: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2361: ifeq +69 -> 2430
    //   2364: ldc 198
    //   2366: iconst_2
    //   2367: new 200	java/lang/StringBuilder
    //   2370: dup
    //   2371: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2374: ldc_w 945
    //   2377: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: aload_3
    //   2381: getfield 948	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2384: invokevirtual 949	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2387: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2390: ldc_w 951
    //   2393: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2396: aload_3
    //   2397: getfield 954	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2400: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2403: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2406: ldc_w 957
    //   2409: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2412: aload_3
    //   2413: getfield 960	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2416: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2419: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2422: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2425: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2428: aload_3
    //   2429: astore_2
    //   2430: aload 14
    //   2432: aload_2
    //   2433: putfield 964	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   2436: aload_0
    //   2437: bipush 51
    //   2439: iconst_1
    //   2440: aload 14
    //   2442: iload 7
    //   2444: invokevirtual 267	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   2447: aload_0
    //   2448: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2451: getstatic 969	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   2454: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2457: checkcast 975	com/tencent/mobileqq/nearby/NearbyCardManager
    //   2460: astore_2
    //   2461: iload 5
    //   2463: bipush 51
    //   2465: if_icmpne +723 -> 3188
    //   2468: aload_2
    //   2469: aload 14
    //   2471: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2474: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   2477: invokevirtual 983	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   2480: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2483: ifeq +46 -> 2529
    //   2486: ldc_w 985
    //   2489: iconst_4
    //   2490: new 200	java/lang/StringBuilder
    //   2493: dup
    //   2494: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2497: ldc_w 987
    //   2500: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: aload 14
    //   2505: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   2508: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2511: ldc_w 989
    //   2514: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   2520: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2523: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2526: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2529: aload_0
    //   2530: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2533: getstatic 992	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   2536: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2539: checkcast 994	com/tencent/mobileqq/app/FriendsManager
    //   2542: astore_2
    //   2543: aload 14
    //   2545: getfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   2548: ifeq +76 -> 2624
    //   2551: aload_2
    //   2552: aload 14
    //   2554: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   2557: invokevirtual 997	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2560: astore_3
    //   2561: aload_3
    //   2562: aload 14
    //   2564: getfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   2567: putfield 1002	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2570: aload_3
    //   2571: aload 14
    //   2573: getfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   2576: i2l
    //   2577: putfield 1005	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2580: aload_0
    //   2581: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2584: invokevirtual 1008	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2587: aload_3
    //   2588: getfield 1005	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2591: aload_3
    //   2592: getfield 1002	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2595: invokestatic 1013	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   2598: pop
    //   2599: aload_2
    //   2600: aload_3
    //   2601: invokevirtual 1016	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   2604: pop
    //   2605: aload_0
    //   2606: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2609: invokevirtual 1008	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2612: ldc_w 1018
    //   2615: aload 14
    //   2617: getfield 418	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   2620: invokestatic 1021	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   2623: pop
    //   2624: aload 14
    //   2626: getfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:isHostSelf	Z
    //   2629: ifeq +32 -> 2661
    //   2632: aload 14
    //   2634: getfield 1024	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2637: ifle +24 -> 2661
    //   2640: aload_0
    //   2641: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2644: getstatic 1027	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   2647: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2650: checkcast 1029	com/tencent/mobileqq/app/HotChatManager
    //   2653: aload 14
    //   2655: getfield 1024	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   2658: invokevirtual 1031	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   2661: aload_2
    //   2662: aload 14
    //   2664: invokevirtual 1034	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   2667: aload 14
    //   2669: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2672: sipush 1000
    //   2675: if_icmpne +698 -> 3373
    //   2678: aload 15
    //   2680: iconst_0
    //   2681: ldc_w 321
    //   2684: invokevirtual 1039	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   2687: aconst_null
    //   2688: aconst_null
    //   2689: aconst_null
    //   2690: aconst_null
    //   2691: aconst_null
    //   2692: aconst_null
    //   2693: aconst_null
    //   2694: invokevirtual 1043	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   2697: astore_3
    //   2698: aload_3
    //   2699: ifnull +637 -> 3336
    //   2702: aload_3
    //   2703: astore_2
    //   2704: aload_3
    //   2705: invokeinterface 1048 1 0
    //   2710: istore 4
    //   2712: aload_3
    //   2713: astore_2
    //   2714: aload_3
    //   2715: invokeinterface 1051 1 0
    //   2720: pop
    //   2721: iload 4
    //   2723: sipush 200
    //   2726: if_icmple +610 -> 3336
    //   2729: iload 4
    //   2731: bipush 100
    //   2733: if_icmple +481 -> 3214
    //   2736: aload_3
    //   2737: astore_2
    //   2738: aload_3
    //   2739: invokeinterface 1054 1 0
    //   2744: pop
    //   2745: iload 4
    //   2747: iconst_1
    //   2748: isub
    //   2749: istore 4
    //   2751: goto -22 -> 2729
    //   2754: astore_3
    //   2755: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2758: ifeq -1569 -> 1189
    //   2761: ldc 198
    //   2763: iconst_2
    //   2764: new 200	java/lang/StringBuilder
    //   2767: dup
    //   2768: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2771: ldc_w 1056
    //   2774: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2777: aload_3
    //   2778: invokevirtual 1059	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2781: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2787: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2790: goto -1601 -> 1189
    //   2793: aload 14
    //   2795: iconst_0
    //   2796: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   2799: goto -1529 -> 1270
    //   2802: aload 14
    //   2804: iconst_0
    //   2805: putfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   2808: goto -1518 -> 1290
    //   2811: astore_3
    //   2812: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2815: ifeq -1430 -> 1385
    //   2818: ldc_w 1061
    //   2821: iconst_2
    //   2822: aload_3
    //   2823: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   2826: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2829: goto -1444 -> 1385
    //   2832: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2835: ifeq -1450 -> 1385
    //   2838: ldc_w 650
    //   2841: iconst_2
    //   2842: ldc_w 1064
    //   2845: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2848: goto -1463 -> 1385
    //   2851: iconst_0
    //   2852: istore_1
    //   2853: goto -1276 -> 1577
    //   2856: iconst_0
    //   2857: istore_1
    //   2858: goto -1262 -> 1596
    //   2861: aload 14
    //   2863: aload_3
    //   2864: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2867: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2870: putfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   2873: aload 14
    //   2875: getfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   2878: iconst_1
    //   2879: if_icmpne +82 -> 2961
    //   2882: iconst_1
    //   2883: istore_1
    //   2884: aload 14
    //   2886: iload_1
    //   2887: putfield 591	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   2890: aload_3
    //   2891: getfield 774	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2894: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2897: iconst_1
    //   2898: if_icmpne +68 -> 2966
    //   2901: iconst_1
    //   2902: istore_1
    //   2903: aload 14
    //   2905: iload_1
    //   2906: putfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   2909: aload 14
    //   2911: aload_3
    //   2912: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2915: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2918: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2921: putfield 609	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   2924: aload 14
    //   2926: aload_3
    //   2927: getfield 780	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2930: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2933: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2936: putfield 603	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   2939: goto -1307 -> 1632
    //   2942: astore_3
    //   2943: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2946: ifeq -623 -> 2323
    //   2949: ldc 198
    //   2951: iconst_2
    //   2952: ldc_w 1066
    //   2955: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2958: goto -635 -> 2323
    //   2961: iconst_0
    //   2962: istore_1
    //   2963: goto -79 -> 2884
    //   2966: iconst_0
    //   2967: istore_1
    //   2968: goto -65 -> 2903
    //   2971: ldc_w 782
    //   2974: iconst_1
    //   2975: new 200	java/lang/StringBuilder
    //   2978: dup
    //   2979: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2982: ldc_w 784
    //   2985: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2988: iload 5
    //   2990: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2993: ldc_w 786
    //   2996: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2999: aload_3
    //   3000: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3003: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3006: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3009: ldc_w 788
    //   3012: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: aload_3
    //   3016: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3019: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3022: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3025: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3028: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3031: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3034: goto -1317 -> 1717
    //   3037: astore 17
    //   3039: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3042: ifeq -1325 -> 1717
    //   3045: ldc 198
    //   3047: iconst_2
    //   3048: new 200	java/lang/StringBuilder
    //   3051: dup
    //   3052: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3055: ldc_w 1068
    //   3058: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: aload 17
    //   3063: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   3066: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3072: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3075: goto -1358 -> 1717
    //   3078: aload 14
    //   3080: ldc_w 499
    //   3083: putfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3086: aload 14
    //   3088: ldc_w 499
    //   3091: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3094: aload 14
    //   3096: iconst_0
    //   3097: putfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3100: aload 14
    //   3102: ldc_w 499
    //   3105: putfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3108: aload 14
    //   3110: iconst_0
    //   3111: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3114: aload 14
    //   3116: iconst_0
    //   3117: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3120: goto -1246 -> 1874
    //   3123: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3126: ifeq -803 -> 2323
    //   3129: ldc 198
    //   3131: iconst_2
    //   3132: ldc_w 1070
    //   3135: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3138: goto -815 -> 2323
    //   3141: astore 17
    //   3143: aconst_null
    //   3144: astore_3
    //   3145: aload_3
    //   3146: astore_2
    //   3147: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3150: ifeq -720 -> 2430
    //   3153: ldc 198
    //   3155: iconst_2
    //   3156: new 200	java/lang/StringBuilder
    //   3159: dup
    //   3160: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3163: ldc_w 1072
    //   3166: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3169: aload 17
    //   3171: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   3174: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3180: invokestatic 1075	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3183: aload_3
    //   3184: astore_2
    //   3185: goto -755 -> 2430
    //   3188: aload_2
    //   3189: aload 14
    //   3191: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   3194: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3197: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   3200: invokevirtual 1077	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   3203: goto -723 -> 2480
    //   3206: astore_3
    //   3207: aload_3
    //   3208: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   3211: goto -587 -> 2624
    //   3214: aload_3
    //   3215: astore_2
    //   3216: aload_3
    //   3217: aload_3
    //   3218: ldc_w 1082
    //   3221: invokeinterface 1085 2 0
    //   3226: invokeinterface 1088 2 0
    //   3231: istore 4
    //   3233: aload_3
    //   3234: astore_2
    //   3235: new 200	java/lang/StringBuilder
    //   3238: dup
    //   3239: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3242: astore 17
    //   3244: aload_3
    //   3245: astore_2
    //   3246: aload 17
    //   3248: ldc_w 1090
    //   3251: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3254: pop
    //   3255: aload_3
    //   3256: astore_2
    //   3257: aload 17
    //   3259: ldc_w 321
    //   3262: invokevirtual 1039	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   3265: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: pop
    //   3269: aload_3
    //   3270: astore_2
    //   3271: aload 17
    //   3273: ldc_w 1092
    //   3276: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3279: pop
    //   3280: aload_3
    //   3281: astore_2
    //   3282: aload 17
    //   3284: ldc_w 1082
    //   3287: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: pop
    //   3291: aload_3
    //   3292: astore_2
    //   3293: aload 17
    //   3295: ldc_w 1094
    //   3298: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3301: pop
    //   3302: aload_3
    //   3303: astore_2
    //   3304: aload 17
    //   3306: iload 4
    //   3308: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3311: pop
    //   3312: aload_3
    //   3313: astore_2
    //   3314: aload 17
    //   3316: ldc_w 1096
    //   3319: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: pop
    //   3323: aload_3
    //   3324: astore_2
    //   3325: aload 15
    //   3327: aload 17
    //   3329: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3332: invokevirtual 1099	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   3335: pop
    //   3336: aload_3
    //   3337: astore_2
    //   3338: aload 15
    //   3340: aload 14
    //   3342: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   3345: aload_3
    //   3346: astore_2
    //   3347: aload 16
    //   3349: invokevirtual 1106	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   3352: aload_3
    //   3353: ifnull +9 -> 3362
    //   3356: aload_3
    //   3357: invokeinterface 1109 1 0
    //   3362: aload 16
    //   3364: invokevirtual 1112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   3367: aload 15
    //   3369: invokevirtual 1113	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   3372: return
    //   3373: aload 14
    //   3375: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3378: sipush 1001
    //   3381: if_icmpeq +14 -> 3395
    //   3384: aload 14
    //   3386: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   3389: sipush 1002
    //   3392: if_icmpne +11 -> 3403
    //   3395: aload 15
    //   3397: aload 14
    //   3399: invokevirtual 1117	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   3402: pop
    //   3403: aconst_null
    //   3404: astore_3
    //   3405: goto -60 -> 3345
    //   3408: astore_3
    //   3409: aconst_null
    //   3410: astore_2
    //   3411: aload_2
    //   3412: ifnull +9 -> 3421
    //   3415: aload_2
    //   3416: invokeinterface 1109 1 0
    //   3421: aload 16
    //   3423: invokevirtual 1112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   3426: aload 15
    //   3428: invokevirtual 1113	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   3431: aload_3
    //   3432: athrow
    //   3433: astore_3
    //   3434: goto -23 -> 3411
    //   3437: aconst_null
    //   3438: astore_3
    //   3439: goto -3256 -> 183
    //   3442: iconst_0
    //   3443: istore_1
    //   3444: goto -1557 -> 1887
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3447	0	this	NearbyCardHandler
    //   0	3447	1	paramBoolean	boolean
    //   0	3447	2	paramRespNearbySummaryCard	com.tencent.nowsummarycard.NowSummaryCard.RespNearbySummaryCard
    //   0	3447	3	paramBundle	Bundle
    //   149	3158	4	i	int
    //   15	2974	5	j	int
    //   863	173	6	k	int
    //   6	2437	7	bool	boolean
    //   131	1243	8	l1	long
    //   140	704	10	l2	long
    //   869	174	12	l3	long
    //   194	3204	14	localNearbyPeopleCard	NearbyPeopleCard
    //   109	3318	15	localEntityManager	EntityManager
    //   116	3306	16	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   709	473	17	localObject1	Object
    //   3037	25	17	localException1	Exception
    //   3141	29	17	localException2	Exception
    //   3242	86	17	localStringBuilder	StringBuilder
    //   735	73	18	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1095	1113	1116	java/lang/Exception
    //   711	762	2754	java/lang/Exception
    //   765	813	2754	java/lang/Exception
    //   1179	1189	2754	java/lang/Exception
    //   1345	1385	2811	java/lang/Exception
    //   1547	1557	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1564	1575	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1577	1594	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1596	1632	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1632	1717	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1717	1874	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1874	1885	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1887	2036	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2036	2323	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2861	2882	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2884	2901	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2903	2939	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2971	3034	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3039	3075	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3078	3120	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3123	3138	2942	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1632	1717	3037	java/lang/Exception
    //   2971	3034	3037	java/lang/Exception
    //   2338	2356	3141	java/lang/Exception
    //   2358	2428	3141	java/lang/Exception
    //   2599	2624	3206	java/lang/Exception
    //   2667	2698	3408	finally
    //   3373	3395	3408	finally
    //   3395	3403	3408	finally
    //   2704	2712	3433	finally
    //   2714	2721	3433	finally
    //   2738	2745	3433	finally
    //   3216	3233	3433	finally
    //   3235	3244	3433	finally
    //   3246	3255	3433	finally
    //   3257	3269	3433	finally
    //   3271	3280	3433	finally
    //   3282	3291	3433	finally
    //   3293	3302	3433	finally
    //   3304	3312	3433	finally
    //   3314	3323	3433	finally
    //   3325	3336	3433	finally
    //   3338	3345	3433	finally
    //   3347	3352	3433	finally
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      notifyUI(57, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            notifyUI(57, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        notifyUI(57, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          notifyUI(57, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
            i += 1;
          }
          notifyUI(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          notifyUI(57, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean, Object paramObject, Bundle paramBundle, SummaryCard.RespHead paramRespHead)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 251
    //   3: invokevirtual 257	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 10
    //   8: aload_3
    //   9: ldc_w 259
    //   12: invokevirtual 263	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   15: istore 8
    //   17: iload_1
    //   18: ifeq +5696 -> 5714
    //   21: aload_2
    //   22: checkcast 1225	SummaryCard/RespSummaryCard
    //   25: astore 16
    //   27: aload_0
    //   28: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   31: invokevirtual 290	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   34: invokevirtual 296	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: astore 14
    //   39: aload 14
    //   41: invokevirtual 302	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   44: astore 13
    //   46: aload 13
    //   48: invokevirtual 307	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   51: aload_3
    //   52: ldc_w 309
    //   55: lconst_0
    //   56: invokevirtual 313	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   59: lstore 11
    //   61: aload_3
    //   62: ldc_w 315
    //   65: invokevirtual 317	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   68: pop2
    //   69: aload_3
    //   70: ldc_w 319
    //   73: invokevirtual 263	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   76: pop
    //   77: iconst_0
    //   78: ifne +807 -> 885
    //   81: new 321	com/tencent/mobileqq/data/NearbyPeopleCard
    //   84: dup
    //   85: invokespecial 331	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   88: astore 15
    //   90: aload 16
    //   92: getfield 1229	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   95: astore_2
    //   96: aload 15
    //   98: aload 16
    //   100: getfield 1232	SummaryCard/RespSummaryCard:lUIN	J
    //   103: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: putfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   109: lload 11
    //   111: lconst_0
    //   112: lcmp
    //   113: ifle +780 -> 893
    //   116: aload 15
    //   118: lload 11
    //   120: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   123: aload 15
    //   125: aload_3
    //   126: ldc_w 315
    //   129: invokevirtual 317	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   132: putfield 346	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   135: aload 15
    //   137: aload_3
    //   138: ldc_w 319
    //   141: invokevirtual 263	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   144: putfield 349	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   147: iload 8
    //   149: ifeq +21 -> 170
    //   152: aload 15
    //   154: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   157: aload_0
    //   158: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   161: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   164: invokevirtual 1235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +738 -> 905
    //   170: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +48 -> 221
    //   176: ldc_w 650
    //   179: iconst_2
    //   180: new 200	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 1237
    //   190: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 16
    //   195: getfield 1240	SummaryCard/RespSummaryCard:iVoteCount	I
    //   198: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: ldc_w 764
    //   204: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload 16
    //   209: getfield 1243	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   212: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload 15
    //   223: aload 16
    //   225: getfield 1240	SummaryCard/RespSummaryCard:iVoteCount	I
    //   228: putfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   231: aload 15
    //   233: aload 16
    //   235: getfield 1243	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   238: putfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   241: aload 15
    //   243: aload 16
    //   245: getfield 1247	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   248: putfield 1250	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   251: aload 15
    //   253: aload 16
    //   255: getfield 1253	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   258: putfield 352	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   261: aload 15
    //   263: aload 16
    //   265: getfield 1256	SummaryCard/RespSummaryCard:vRichSign	[B
    //   268: putfield 363	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   271: aload 15
    //   273: aload_2
    //   274: getfield 1261	SummaryCard/DateCard:bMarriage	B
    //   277: putfield 424	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   280: aload 15
    //   282: aload 16
    //   284: getfield 1264	SummaryCard/RespSummaryCard:bSex	B
    //   287: putfield 367	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   290: aload 15
    //   292: aload 16
    //   294: getfield 1267	SummaryCard/RespSummaryCard:bAge	B
    //   297: putfield 378	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   300: aload 15
    //   302: aload 16
    //   304: getfield 1270	SummaryCard/RespSummaryCard:iBirthday	I
    //   307: putfield 384	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   310: aload 15
    //   312: aload_2
    //   313: getfield 1273	SummaryCard/DateCard:uProfession	J
    //   316: l2i
    //   317: putfield 391	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   320: aload 15
    //   322: aload_2
    //   323: getfield 1276	SummaryCard/DateCard:bConstellation	B
    //   326: putfield 396	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   329: aload 15
    //   331: aload_2
    //   332: getfield 1279	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   335: putfield 401	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   338: aload 15
    //   340: aload_2
    //   341: getfield 1282	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   344: putfield 407	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   347: aload 15
    //   349: aload 16
    //   351: getfield 1285	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   354: putfield 1288	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   357: aload 15
    //   359: aload_2
    //   360: getfield 1291	SummaryCard/DateCard:vDateInfo	[B
    //   363: putfield 1294	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   366: aload 15
    //   368: aload_2
    //   369: getfield 1297	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   372: putfield 412	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   375: aload 15
    //   377: aload_2
    //   378: getfield 1300	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   381: putfield 418	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   384: aload 15
    //   386: aload_2
    //   387: getfield 1303	SummaryCard/DateCard:uHomeCountry	J
    //   390: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   393: putfield 446	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   396: aload 15
    //   398: aload_2
    //   399: getfield 1306	SummaryCard/DateCard:uHomeProvince	J
    //   402: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   405: putfield 452	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   408: aload 15
    //   410: aload_2
    //   411: getfield 1309	SummaryCard/DateCard:uHomeCity	J
    //   414: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   417: putfield 458	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   420: aload 15
    //   422: aload_2
    //   423: getfield 1312	SummaryCard/DateCard:uHomeZone	J
    //   426: invokestatic 443	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   429: putfield 464	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   432: aload 15
    //   434: aload 16
    //   436: getfield 1315	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   439: putfield 1318	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   442: aload 15
    //   444: aload 16
    //   446: getfield 1321	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   449: putfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   452: aload 15
    //   454: aload 16
    //   456: getfield 1327	SummaryCard/RespSummaryCard:ulShowControl	J
    //   459: putfield 1330	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   462: aload 15
    //   464: aload 16
    //   466: getfield 1333	SummaryCard/RespSummaryCard:lUserFlag	J
    //   469: putfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   472: aload 15
    //   474: aload 16
    //   476: getfield 1336	SummaryCard/RespSummaryCard:vSeed	[B
    //   479: putfield 1337	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   482: aload 15
    //   484: aload 16
    //   486: getfield 1340	SummaryCard/RespSummaryCard:lCacheControl	J
    //   489: invokevirtual 1343	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   492: aload 15
    //   494: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   497: putfield 472	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   500: aload 15
    //   502: iload 8
    //   504: putfield 493	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   507: aload 15
    //   509: aload 16
    //   511: getfield 1344	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   514: putfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   517: aload 15
    //   519: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   522: ifnull +406 -> 928
    //   525: aload 15
    //   527: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   530: arraylength
    //   531: ifne +63 -> 594
    //   534: aload_0
    //   535: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   538: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   541: aload 15
    //   543: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   546: invokestatic 1349	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   549: ifne +45 -> 594
    //   552: aload_0
    //   553: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   556: ldc_w 495
    //   559: ldc_w 497
    //   562: ldc_w 499
    //   565: ldc_w 501
    //   568: ldc_w 503
    //   571: iconst_0
    //   572: iconst_0
    //   573: aload_0
    //   574: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   577: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   580: aload 15
    //   582: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   585: ldc_w 499
    //   588: ldc_w 499
    //   591: invokestatic 509	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload_0
    //   595: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   598: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   601: aload 15
    //   603: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   606: invokevirtual 519	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;)[B
    //   609: ifnonnull +23 -> 632
    //   612: aload_0
    //   613: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   616: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   619: aload 15
    //   621: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   624: aload 15
    //   626: getfield 478	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   629: invokevirtual 523	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   632: aload 15
    //   634: aload_2
    //   635: getfield 1352	SummaryCard/DateCard:uSchoolId	J
    //   638: putfield 430	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   641: aload 15
    //   643: aload_2
    //   644: getfield 1355	SummaryCard/DateCard:vGroupList	[B
    //   647: putfield 1356	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   650: aload 15
    //   652: aload_2
    //   653: getfield 1359	SummaryCard/DateCard:vNearbyInfo	[B
    //   656: putfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   659: aload 15
    //   661: aload_2
    //   662: getfield 1362	SummaryCard/DateCard:vActivityList	[B
    //   665: putfield 1363	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   668: aload 15
    //   670: aload 16
    //   672: getfield 1333	SummaryCard/RespSummaryCard:lUserFlag	J
    //   675: putfield 1364	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   678: aload 15
    //   680: aload 16
    //   682: getfield 1367	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   685: putfield 1368	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   688: aload 16
    //   690: getfield 1372	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   693: ifnull +16 -> 709
    //   696: aload 15
    //   698: aload 16
    //   700: getfield 1372	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   703: getfield 1377	SummaryCard/HeartInfo:iHeartCount	I
    //   706: putfield 1380	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   709: aload 16
    //   711: getfield 1384	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   714: ifnull +259 -> 973
    //   717: aload 15
    //   719: aload 16
    //   721: getfield 1384	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   724: getfield 1389	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   727: putfield 1392	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   730: aload 15
    //   732: aload 16
    //   734: getfield 1384	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   737: getfield 1395	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   740: putfield 1396	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   743: aload 16
    //   745: getfield 1399	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   748: astore_3
    //   749: aload_3
    //   750: ifnull +269 -> 1019
    //   753: aload 15
    //   755: new 528	java/util/ArrayList
    //   758: dup
    //   759: invokespecial 529	java/util/ArrayList:<init>	()V
    //   762: putfield 533	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   765: new 535	appoint/define/appoint_define$CommonLabel
    //   768: dup
    //   769: invokespecial 536	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   772: astore 17
    //   774: aload 17
    //   776: aload_3
    //   777: invokevirtual 540	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   780: pop
    //   781: aload 17
    //   783: getfield 544	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   786: invokevirtual 549	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   789: astore_3
    //   790: aload 17
    //   792: getfield 552	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   795: invokevirtual 549	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   798: astore 18
    //   800: new 554	org/json/JSONArray
    //   803: dup
    //   804: invokespecial 555	org/json/JSONArray:<init>	()V
    //   807: astore 17
    //   809: aload_3
    //   810: invokeinterface 560 1 0
    //   815: aload 18
    //   817: invokeinterface 560 1 0
    //   822: if_icmpne +187 -> 1009
    //   825: iconst_0
    //   826: istore 5
    //   828: iload 5
    //   830: aload_3
    //   831: invokeinterface 560 1 0
    //   836: if_icmpge +173 -> 1009
    //   839: aload_3
    //   840: iload 5
    //   842: invokeinterface 563 2 0
    //   847: checkcast 52	com/tencent/mobileqq/pb/ByteStringMicro
    //   850: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   853: astore 18
    //   855: aload 15
    //   857: getfield 533	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   860: aload 18
    //   862: invokeinterface 570 2 0
    //   867: pop
    //   868: aload 17
    //   870: aload 18
    //   872: invokevirtual 574	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   875: pop
    //   876: iload 5
    //   878: iconst_1
    //   879: iadd
    //   880: istore 5
    //   882: goto -54 -> 828
    //   885: new 1120	java/lang/NullPointerException
    //   888: dup
    //   889: invokespecial 1400	java/lang/NullPointerException:<init>	()V
    //   892: athrow
    //   893: aload 15
    //   895: aload_2
    //   896: getfield 1403	SummaryCard/DateCard:lTinyId	J
    //   899: putfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   902: goto -779 -> 123
    //   905: aload 15
    //   907: aload 16
    //   909: getfield 1240	SummaryCard/RespSummaryCard:iVoteCount	I
    //   912: putfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   915: aload 15
    //   917: aload 16
    //   919: getfield 1243	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   922: putfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   925: goto -674 -> 251
    //   928: aload_0
    //   929: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   932: ldc_w 495
    //   935: ldc_w 497
    //   938: ldc_w 499
    //   941: ldc_w 501
    //   944: ldc_w 640
    //   947: iconst_0
    //   948: iconst_0
    //   949: aload_0
    //   950: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   953: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   956: aload 15
    //   958: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   961: ldc_w 499
    //   964: ldc_w 499
    //   967: invokestatic 509	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   970: goto -338 -> 632
    //   973: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   976: ifeq -233 -> 743
    //   979: ldc_w 650
    //   982: iconst_2
    //   983: new 200	java/lang/StringBuilder
    //   986: dup
    //   987: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   990: ldc_w 1405
    //   993: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: aconst_null
    //   997: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1000: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1003: invokestatic 1075	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1006: goto -263 -> 743
    //   1009: aload 15
    //   1011: aload 17
    //   1013: invokevirtual 641	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1016: putfield 644	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1019: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1022: ifeq +33 -> 1055
    //   1025: ldc_w 650
    //   1028: iconst_4
    //   1029: new 200	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 652
    //   1039: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: aload_2
    //   1043: getfield 1352	SummaryCard/DateCard:uSchoolId	J
    //   1046: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1049: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1052: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1055: aload 15
    //   1057: aload 16
    //   1059: getfield 1411	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1062: putfield 1412	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1065: aload 15
    //   1067: aload 16
    //   1069: getfield 1416	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1072: putfield 1417	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1075: aload 15
    //   1077: aload 16
    //   1079: getfield 1420	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1082: putfield 1421	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1085: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1088: ifeq +61 -> 1149
    //   1091: ldc 198
    //   1093: iconst_2
    //   1094: new 200	java/lang/StringBuilder
    //   1097: dup
    //   1098: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1101: ldc_w 1423
    //   1104: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: aload 16
    //   1109: getfield 1411	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1112: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: ldc_w 1425
    //   1118: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload 16
    //   1123: getfield 1416	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1126: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1129: ldc_w 1427
    //   1132: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: aload 16
    //   1137: getfield 1420	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1140: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: aload 16
    //   1151: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1154: ifnull +58 -> 1212
    //   1157: aload 15
    //   1159: aload 16
    //   1161: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1164: getfield 1436	SummaryCard/PanSocialInfo:uCharm	J
    //   1167: putfield 1439	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1170: aload 15
    //   1172: aload 16
    //   1174: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1177: getfield 1442	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1180: l2i
    //   1181: putfield 1024	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1184: aload 15
    //   1186: aload 16
    //   1188: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1191: getfield 1445	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1194: l2i
    //   1195: putfield 1448	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1198: aload 15
    //   1200: aload 16
    //   1202: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1205: getfield 1451	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1208: l2i
    //   1209: putfield 1454	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1212: iload 8
    //   1214: ifeq +21 -> 1235
    //   1217: aload 15
    //   1219: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1222: aload_0
    //   1223: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1226: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1229: invokevirtual 1235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1232: ifeq +250 -> 1482
    //   1235: iconst_1
    //   1236: istore_1
    //   1237: aload 15
    //   1239: aload_2
    //   1240: getfield 1457	SummaryCard/DateCard:vFaces	[B
    //   1243: aload 16
    //   1245: getfield 1461	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1248: iload_1
    //   1249: invokevirtual 662	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1252: pop
    //   1253: aload 15
    //   1255: aload 16
    //   1257: getfield 1465	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1260: getfield 1470	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1263: putfield 1471	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1266: aload 16
    //   1268: getfield 1474	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1271: ifne +216 -> 1487
    //   1274: aload 15
    //   1276: iconst_1
    //   1277: putfield 1477	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1280: aload 4
    //   1282: ifnull +13 -> 1295
    //   1285: aload 15
    //   1287: aload 4
    //   1289: getfield 1482	SummaryCard/RespHead:vCookies	[B
    //   1292: putfield 1483	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1295: aload 15
    //   1297: getfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1300: ldc2_w 666
    //   1303: land
    //   1304: lconst_0
    //   1305: lcmp
    //   1306: ifeq +190 -> 1496
    //   1309: aload 15
    //   1311: iconst_1
    //   1312: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1315: aload 15
    //   1317: getfield 665	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1320: ldc2_w 671
    //   1323: land
    //   1324: lconst_0
    //   1325: lcmp
    //   1326: ifeq +179 -> 1505
    //   1329: aload 15
    //   1331: iconst_1
    //   1332: putfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1335: aload 15
    //   1337: invokevirtual 678	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1340: ifne +232 -> 1572
    //   1343: aload 15
    //   1345: ldc_w 499
    //   1348: putfield 681	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1351: aload 15
    //   1353: ldc_w 499
    //   1356: putfield 684	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1359: aload 15
    //   1361: ldc_w 499
    //   1364: putfield 687	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1367: aload 16
    //   1369: getfield 1487	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1372: astore_2
    //   1373: aload_2
    //   1374: ifnull +198 -> 1572
    //   1377: aload_2
    //   1378: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1381: ifnull +191 -> 1572
    //   1384: aload_2
    //   1385: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1388: invokevirtual 1493	java/util/ArrayList:size	()I
    //   1391: ifle +181 -> 1572
    //   1394: iconst_0
    //   1395: istore 5
    //   1397: iload 5
    //   1399: aload_2
    //   1400: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1403: invokevirtual 1493	java/util/ArrayList:size	()I
    //   1406: if_icmpge +166 -> 1572
    //   1409: iload 5
    //   1411: ifne +103 -> 1514
    //   1414: aload 15
    //   1416: aload_2
    //   1417: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1420: iload 5
    //   1422: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1425: checkcast 1496	SummaryCard/PhotoInfo
    //   1428: getfield 1499	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1431: putfield 681	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1434: iload 5
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore 5
    //   1440: goto -43 -> 1397
    //   1443: astore_3
    //   1444: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1447: ifeq -428 -> 1019
    //   1450: ldc 198
    //   1452: iconst_2
    //   1453: new 200	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1460: ldc_w 1056
    //   1463: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: aload_3
    //   1467: invokevirtual 1059	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1470: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1479: goto -460 -> 1019
    //   1482: iconst_0
    //   1483: istore_1
    //   1484: goto -247 -> 1237
    //   1487: aload 15
    //   1489: iconst_0
    //   1490: putfield 1477	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1493: goto -213 -> 1280
    //   1496: aload 15
    //   1498: iconst_0
    //   1499: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1502: goto -187 -> 1315
    //   1505: aload 15
    //   1507: iconst_0
    //   1508: putfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1511: goto -176 -> 1335
    //   1514: iload 5
    //   1516: iconst_1
    //   1517: if_icmpne +26 -> 1543
    //   1520: aload 15
    //   1522: aload_2
    //   1523: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1526: iload 5
    //   1528: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1531: checkcast 1496	SummaryCard/PhotoInfo
    //   1534: getfield 1499	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1537: putfield 684	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1540: goto -106 -> 1434
    //   1543: iload 5
    //   1545: iconst_2
    //   1546: if_icmpne -112 -> 1434
    //   1549: aload 15
    //   1551: aload_2
    //   1552: getfield 1492	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1555: iload 5
    //   1557: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1560: checkcast 1496	SummaryCard/PhotoInfo
    //   1563: getfield 1499	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1566: putfield 687	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1569: goto -135 -> 1434
    //   1572: aload 16
    //   1574: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1577: astore_2
    //   1578: aload_2
    //   1579: ifnull +27 -> 1606
    //   1582: aload_2
    //   1583: getfield 1502	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1586: lconst_1
    //   1587: lcmp
    //   1588: ifne +153 -> 1741
    //   1591: aload 15
    //   1593: iconst_1
    //   1594: putfield 1505	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1597: aload 15
    //   1599: aload_2
    //   1600: getfield 1508	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1603: putfield 1509	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1606: aload 16
    //   1608: getfield 1512	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1611: ifnull +30 -> 1641
    //   1614: aload 15
    //   1616: aload_0
    //   1617: aload 16
    //   1619: getfield 1512	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1622: ldc_w 1514
    //   1625: new 1516	GameCenter/RespLastGameInfo
    //   1628: dup
    //   1629: invokespecial 1517	GameCenter/RespLastGameInfo:<init>	()V
    //   1632: invokevirtual 1521	com/tencent/mobileqq/nearby/business/NearbyCardHandler:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1635: checkcast 1516	GameCenter/RespLastGameInfo
    //   1638: invokevirtual 1525	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1641: aload 16
    //   1643: getfield 1431	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1646: astore_2
    //   1647: aload_2
    //   1648: ifnull +13 -> 1661
    //   1651: aload 15
    //   1653: aload_2
    //   1654: getfield 1528	SummaryCard/PanSocialInfo:uChatflag	J
    //   1657: l2i
    //   1658: putfield 1531	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1661: new 528	java/util/ArrayList
    //   1664: dup
    //   1665: invokespecial 529	java/util/ArrayList:<init>	()V
    //   1668: astore_2
    //   1669: aload 16
    //   1671: getfield 1534	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1674: ifnull +747 -> 2421
    //   1677: aload 16
    //   1679: getfield 1534	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1682: invokevirtual 1493	java/util/ArrayList:size	()I
    //   1685: ifle +736 -> 2421
    //   1688: iconst_0
    //   1689: istore 5
    //   1691: iload 5
    //   1693: aload 16
    //   1695: getfield 1534	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1698: invokevirtual 1493	java/util/ArrayList:size	()I
    //   1701: if_icmpge +720 -> 2421
    //   1704: aload 16
    //   1706: getfield 1534	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1709: iload 5
    //   1711: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1714: checkcast 1535	[B
    //   1717: astore_3
    //   1718: aload_3
    //   1719: ifnonnull +31 -> 1750
    //   1722: iconst_0
    //   1723: istore 6
    //   1725: iload 6
    //   1727: bipush 10
    //   1729: if_icmpgt +28 -> 1757
    //   1732: iload 5
    //   1734: iconst_1
    //   1735: iadd
    //   1736: istore 5
    //   1738: goto -47 -> 1691
    //   1741: aload 15
    //   1743: iconst_0
    //   1744: putfield 1505	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1747: goto -150 -> 1597
    //   1750: aload_3
    //   1751: arraylength
    //   1752: istore 6
    //   1754: goto -29 -> 1725
    //   1757: aload_3
    //   1758: iconst_1
    //   1759: invokestatic 1541	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1762: l2i
    //   1763: istore 7
    //   1765: aload_3
    //   1766: iconst_5
    //   1767: invokestatic 1541	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   1770: l2i
    //   1771: istore 9
    //   1773: iload 7
    //   1775: ifle -43 -> 1732
    //   1778: iload 7
    //   1780: bipush 9
    //   1782: iadd
    //   1783: iload 6
    //   1785: if_icmpge -53 -> 1732
    //   1788: iload 7
    //   1790: newarray byte
    //   1792: astore 4
    //   1794: aload 4
    //   1796: iconst_0
    //   1797: aload_3
    //   1798: bipush 9
    //   1800: iload 7
    //   1802: invokestatic 1545	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   1805: new 1547	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   1808: dup
    //   1809: invokespecial 1548	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   1812: astore_3
    //   1813: aload_3
    //   1814: aload 4
    //   1816: invokevirtual 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1819: pop
    //   1820: aload_3
    //   1821: getfield 1552	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1824: invokevirtual 376	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1827: istore 9
    //   1829: new 1554	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry
    //   1832: dup
    //   1833: invokespecial 1555	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:<init>	()V
    //   1836: astore 22
    //   1838: iload 9
    //   1840: ifne +485 -> 2325
    //   1843: aload 22
    //   1845: aload_3
    //   1846: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1849: getfield 1564	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1852: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1855: putfield 1566	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strName	Ljava/lang/String;
    //   1858: aload 22
    //   1860: aload_3
    //   1861: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1864: getfield 1569	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1867: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1870: putfield 1571	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:strServiceUrl	Ljava/lang/String;
    //   1873: aload 22
    //   1875: aload_3
    //   1876: getfield 1574	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1879: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1882: putfield 1577	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   1885: new 528	java/util/ArrayList
    //   1888: dup
    //   1889: invokespecial 529	java/util/ArrayList:<init>	()V
    //   1892: astore 4
    //   1894: iconst_0
    //   1895: istore 6
    //   1897: iload 6
    //   1899: aload_3
    //   1900: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1903: getfield 1580	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1906: invokevirtual 1581	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   1909: if_icmpge +409 -> 2318
    //   1912: aload_3
    //   1913: getfield 1559	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   1916: getfield 1580	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1919: iload 6
    //   1921: invokevirtual 1584	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1924: checkcast 1586	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   1927: astore 18
    //   1929: new 1588	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem
    //   1932: dup
    //   1933: invokespecial 1589	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:<init>	()V
    //   1936: astore 17
    //   1938: aload 17
    //   1940: aload 18
    //   1942: getfield 1592	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1945: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1948: putfield 1594	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitle	Ljava/lang/String;
    //   1951: aload 17
    //   1953: aload 18
    //   1955: getfield 1597	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1958: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1961: putfield 1599	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strCoverUrl	Ljava/lang/String;
    //   1964: aload 17
    //   1966: aload 18
    //   1968: getfield 1602	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1971: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1974: putfield 1604	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strJmpUrl	Ljava/lang/String;
    //   1977: aload 17
    //   1979: aload 18
    //   1981: getfield 1607	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1984: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1987: putfield 1609	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strSubInfo	Ljava/lang/String;
    //   1990: aload 17
    //   1992: aload 18
    //   1994: getfield 1612	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1997: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2000: putfield 1614	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strDesc	Ljava/lang/String;
    //   2003: aload 17
    //   2005: aload 18
    //   2007: getfield 1617	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2010: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2013: putfield 1619	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:strTitleIconUrl	Ljava/lang/String;
    //   2016: aload 17
    //   2018: aload 18
    //   2020: getfield 1622	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2023: invokevirtual 275	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2026: putfield 1625	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:groupCode	J
    //   2029: aload 17
    //   2031: aload 22
    //   2033: getfield 1577	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:serviceType	I
    //   2036: putfield 1626	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:serviceType	I
    //   2039: aload 18
    //   2041: getfield 1629	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2044: invokevirtual 1581	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2047: ifle +254 -> 2301
    //   2050: new 528	java/util/ArrayList
    //   2053: dup
    //   2054: invokespecial 529	java/util/ArrayList:<init>	()V
    //   2057: astore 19
    //   2059: iconst_0
    //   2060: istore 7
    //   2062: iload 7
    //   2064: aload 18
    //   2066: getfield 1629	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2069: invokevirtual 1581	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2072: if_icmpge +222 -> 2294
    //   2075: aload 18
    //   2077: getfield 1629	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2080: iload 7
    //   2082: invokevirtual 1584	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2085: checkcast 1631	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2088: astore 20
    //   2090: new 1633	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel
    //   2093: dup
    //   2094: invokespecial 1634	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:<init>	()V
    //   2097: astore 21
    //   2099: aload 21
    //   2101: aload 20
    //   2103: getfield 1637	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2106: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2109: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2112: putfield 1640	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:strWording	Ljava/lang/String;
    //   2115: aload 21
    //   2117: aload 20
    //   2119: getfield 1643	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2122: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2125: i2l
    //   2126: putfield 1646	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:type	J
    //   2129: aload 21
    //   2131: aload 20
    //   2133: getfield 1649	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2136: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2139: i2l
    //   2140: putfield 1652	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:attr	J
    //   2143: new 1654	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2146: dup
    //   2147: invokespecial 1655	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2150: astore 23
    //   2152: aload 23
    //   2154: aload 20
    //   2156: getfield 1659	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2159: getfield 1664	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2162: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2165: i2l
    //   2166: putfield 1667	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2169: aload 23
    //   2171: aload 20
    //   2173: getfield 1659	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2176: getfield 1670	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2179: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2182: i2l
    //   2183: putfield 1673	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2186: aload 23
    //   2188: aload 20
    //   2190: getfield 1659	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2193: getfield 1676	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2196: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2199: i2l
    //   2200: putfield 1679	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2203: aload 21
    //   2205: aload 23
    //   2207: putfield 1683	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:edgingColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2210: new 1654	com/tencent/mobileqq/profilecard/entity/ProfileColor
    //   2213: dup
    //   2214: invokespecial 1655	com/tencent/mobileqq/profilecard/entity/ProfileColor:<init>	()V
    //   2217: astore 23
    //   2219: aload 23
    //   2221: aload 20
    //   2223: getfield 1686	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2226: getfield 1664	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2229: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2232: i2l
    //   2233: putfield 1667	com/tencent/mobileqq/profilecard/entity/ProfileColor:red	J
    //   2236: aload 23
    //   2238: aload 20
    //   2240: getfield 1686	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2243: getfield 1670	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2246: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2249: i2l
    //   2250: putfield 1673	com/tencent/mobileqq/profilecard/entity/ProfileColor:green	J
    //   2253: aload 23
    //   2255: aload 20
    //   2257: getfield 1686	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2260: getfield 1676	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2263: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2266: i2l
    //   2267: putfield 1679	com/tencent/mobileqq/profilecard/entity/ProfileColor:blue	J
    //   2270: aload 21
    //   2272: aload 23
    //   2274: putfield 1689	com/tencent/mobileqq/profilecard/entity/ProfileGroupLabel:textColor	Lcom/tencent/mobileqq/profilecard/entity/ProfileColor;
    //   2277: aload 19
    //   2279: aload 21
    //   2281: invokevirtual 1690	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2284: pop
    //   2285: iload 7
    //   2287: iconst_1
    //   2288: iadd
    //   2289: istore 7
    //   2291: goto -229 -> 2062
    //   2294: aload 17
    //   2296: aload 19
    //   2298: putfield 1693	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesItem:labels	Ljava/util/ArrayList;
    //   2301: aload 4
    //   2303: aload 17
    //   2305: invokevirtual 1690	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2308: pop
    //   2309: iload 6
    //   2311: iconst_1
    //   2312: iadd
    //   2313: istore 6
    //   2315: goto -418 -> 1897
    //   2318: aload 22
    //   2320: aload 4
    //   2322: putfield 1696	com/tencent/mobileqq/profilecard/entity/ProfileSummaryHobbiesEntry:sProfileSummaryHobbiesItem	Ljava/util/ArrayList;
    //   2325: aload_2
    //   2326: aload 22
    //   2328: invokeinterface 570 2 0
    //   2333: pop
    //   2334: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2337: ifeq -605 -> 1732
    //   2340: ldc_w 650
    //   2343: iconst_2
    //   2344: new 200	java/lang/StringBuilder
    //   2347: dup
    //   2348: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2351: ldc_w 1698
    //   2354: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: aload_3
    //   2358: getfield 1574	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2361: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2364: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2367: ldc_w 1700
    //   2370: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2373: iload 9
    //   2375: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2378: ldc_w 1702
    //   2381: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2384: aload_3
    //   2385: getfield 1705	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2388: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2391: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2394: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2397: goto -665 -> 1732
    //   2400: astore_3
    //   2401: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2404: ifeq -672 -> 1732
    //   2407: ldc_w 650
    //   2410: iconst_2
    //   2411: aload_3
    //   2412: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   2415: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2418: goto -686 -> 1732
    //   2421: new 528	java/util/ArrayList
    //   2424: dup
    //   2425: invokespecial 529	java/util/ArrayList:<init>	()V
    //   2428: astore_2
    //   2429: aload 16
    //   2431: getfield 1708	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2434: ifnull +383 -> 2817
    //   2437: aload 16
    //   2439: getfield 1708	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2442: invokevirtual 1493	java/util/ArrayList:size	()I
    //   2445: ifle +372 -> 2817
    //   2448: iconst_0
    //   2449: istore 5
    //   2451: iload 5
    //   2453: aload 16
    //   2455: getfield 1708	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2458: invokevirtual 1493	java/util/ArrayList:size	()I
    //   2461: if_icmpge +356 -> 2817
    //   2464: aload 16
    //   2466: getfield 1708	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2469: iload 5
    //   2471: invokevirtual 1494	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2474: checkcast 1535	[B
    //   2477: astore 4
    //   2479: aload 4
    //   2481: ifnonnull +22 -> 2503
    //   2484: iconst_0
    //   2485: istore 6
    //   2487: iload 6
    //   2489: bipush 10
    //   2491: if_icmpgt +20 -> 2511
    //   2494: iload 5
    //   2496: iconst_1
    //   2497: iadd
    //   2498: istore 5
    //   2500: goto -49 -> 2451
    //   2503: aload 4
    //   2505: arraylength
    //   2506: istore 6
    //   2508: goto -21 -> 2487
    //   2511: aload 4
    //   2513: iconst_1
    //   2514: invokestatic 1541	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   2517: l2i
    //   2518: istore 9
    //   2520: aload 4
    //   2522: iconst_5
    //   2523: invokestatic 1541	com/tencent/mobileqq/utils/httputils/PkgTools:getLongData	([BI)J
    //   2526: l2i
    //   2527: istore 7
    //   2529: iload 9
    //   2531: ifle -37 -> 2494
    //   2534: iload 9
    //   2536: bipush 9
    //   2538: iadd
    //   2539: iload 6
    //   2541: if_icmpge -47 -> 2494
    //   2544: iload 9
    //   2546: newarray byte
    //   2548: astore_3
    //   2549: aload_3
    //   2550: iconst_0
    //   2551: aload 4
    //   2553: bipush 9
    //   2555: iload 9
    //   2557: invokestatic 1545	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BII)V
    //   2560: new 1547	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2563: dup
    //   2564: invokespecial 1548	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2567: astore 4
    //   2569: aload 4
    //   2571: aload_3
    //   2572: invokevirtual 1549	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2575: pop
    //   2576: aload 4
    //   2578: getfield 1552	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2581: invokevirtual 376	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2584: istore 6
    //   2586: iload 6
    //   2588: ifne +161 -> 2749
    //   2591: new 1710	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry
    //   2594: dup
    //   2595: invokespecial 1711	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:<init>	()V
    //   2598: astore_3
    //   2599: aload_3
    //   2600: aload 4
    //   2602: getfield 1574	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2605: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2608: putfield 1714	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:nBusiEntryType	I
    //   2611: aload 4
    //   2613: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2616: ifnull +102 -> 2718
    //   2619: aload_3
    //   2620: aload 4
    //   2622: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2625: getfield 1723	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2628: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2631: putfield 1726	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   2634: aload_3
    //   2635: aload 4
    //   2637: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2640: getfield 1729	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2643: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2646: putfield 1730	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   2649: aload_3
    //   2650: aload 4
    //   2652: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2655: getfield 1733	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2658: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2661: putfield 1736	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   2664: aload_3
    //   2665: aload 4
    //   2667: getfield 1718	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2670: getfield 1739	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2673: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2676: putfield 1740	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   2679: aload_3
    //   2680: invokevirtual 1743	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:isEmpty	()Z
    //   2683: ifne -189 -> 2494
    //   2686: aload_2
    //   2687: aload_3
    //   2688: invokeinterface 570 2 0
    //   2693: pop
    //   2694: goto -200 -> 2494
    //   2697: astore_3
    //   2698: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2701: ifeq -207 -> 2494
    //   2704: ldc_w 650
    //   2707: iconst_2
    //   2708: aload_3
    //   2709: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   2712: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2715: goto -221 -> 2494
    //   2718: aload_3
    //   2719: ldc_w 499
    //   2722: putfield 1726	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strLogoUrl	Ljava/lang/String;
    //   2725: aload_3
    //   2726: ldc_w 499
    //   2729: putfield 1730	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strTitle	Ljava/lang/String;
    //   2732: aload_3
    //   2733: ldc_w 499
    //   2736: putfield 1736	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strContent	Ljava/lang/String;
    //   2739: aload_3
    //   2740: ldc_w 499
    //   2743: putfield 1740	com/tencent/mobileqq/profilecard/entity/ProfileBusiEntry:strJumpUrl	Ljava/lang/String;
    //   2746: goto -67 -> 2679
    //   2749: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2752: ifeq -258 -> 2494
    //   2755: ldc_w 650
    //   2758: iconst_4
    //   2759: new 200	java/lang/StringBuilder
    //   2762: dup
    //   2763: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   2766: ldc_w 1745
    //   2769: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2772: aload 4
    //   2774: getfield 1574	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2777: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2780: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2783: ldc_w 1747
    //   2786: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2789: iload 6
    //   2791: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2794: ldc_w 1747
    //   2797: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2800: aload 4
    //   2802: getfield 1705	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2805: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2808: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2811: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2814: goto -320 -> 2494
    //   2817: aload 15
    //   2819: aload_2
    //   2820: invokevirtual 1751	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   2823: aload 16
    //   2825: getfield 1755	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2828: ifnonnull +126 -> 2954
    //   2831: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2834: ifeq +13 -> 2847
    //   2837: ldc_w 650
    //   2840: iconst_2
    //   2841: ldc_w 1064
    //   2844: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2847: aload 16
    //   2849: getfield 1758	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   2852: ifnull +1656 -> 4508
    //   2855: new 1760	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   2858: dup
    //   2859: invokespecial 1761	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   2862: astore_3
    //   2863: aload_3
    //   2864: aload 16
    //   2866: getfield 1758	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   2869: invokevirtual 1762	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2872: pop
    //   2873: aload_3
    //   2874: ifnull +2859 -> 5733
    //   2877: aload_3
    //   2878: getfield 1765	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2881: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2884: astore_2
    //   2885: new 528	java/util/ArrayList
    //   2888: dup
    //   2889: invokespecial 529	java/util/ArrayList:<init>	()V
    //   2892: astore_3
    //   2893: aload_2
    //   2894: ifnull +155 -> 3049
    //   2897: aload_2
    //   2898: invokeinterface 1191 1 0
    //   2903: astore_2
    //   2904: aload_2
    //   2905: invokeinterface 1196 1 0
    //   2910: ifeq +139 -> 3049
    //   2913: aload_2
    //   2914: invokeinterface 1200 1 0
    //   2919: checkcast 1767	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   2922: astore 4
    //   2924: aload 4
    //   2926: getfield 1770	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2929: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2932: iconst_1
    //   2933: if_icmpne +111 -> 3044
    //   2936: iconst_1
    //   2937: istore_1
    //   2938: aload_3
    //   2939: aload 4
    //   2941: iload_1
    //   2942: invokestatic 1776	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   2945: invokeinterface 570 2 0
    //   2950: pop
    //   2951: goto -47 -> 2904
    //   2954: aload 16
    //   2956: getfield 1755	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2959: getfield 1781	SummaryCard/InterestTagInfo:uFlag	J
    //   2962: lstore 11
    //   2964: new 701	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   2967: dup
    //   2968: invokespecial 702	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   2971: astore_2
    //   2972: aload_2
    //   2973: aload 16
    //   2975: getfield 1755	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   2978: getfield 1782	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   2981: invokevirtual 706	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2984: pop
    //   2985: aload 15
    //   2987: lload 11
    //   2989: aload_2
    //   2990: getfield 710	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2993: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2996: invokevirtual 717	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   2999: goto -152 -> 2847
    //   3002: astore_2
    //   3003: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3006: ifeq -159 -> 2847
    //   3009: ldc_w 1061
    //   3012: iconst_2
    //   3013: aload_2
    //   3014: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   3017: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3020: goto -173 -> 2847
    //   3023: astore_2
    //   3024: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3027: ifeq -154 -> 2873
    //   3030: ldc_w 650
    //   3033: iconst_2
    //   3034: aload_2
    //   3035: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   3038: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3041: goto -168 -> 2873
    //   3044: iconst_0
    //   3045: istore_1
    //   3046: goto -108 -> 2938
    //   3049: aload_3
    //   3050: invokeinterface 560 1 0
    //   3055: ifle +2678 -> 5733
    //   3058: iconst_0
    //   3059: istore 5
    //   3061: iload 5
    //   3063: aload_3
    //   3064: invokeinterface 560 1 0
    //   3069: if_icmpge +2664 -> 5733
    //   3072: aload_3
    //   3073: iload 5
    //   3075: invokeinterface 563 2 0
    //   3080: checkcast 1772	com/tencent/mobileqq/data/HotChatInfo
    //   3083: astore_2
    //   3084: aload_2
    //   3085: ifnull +1414 -> 4499
    //   3088: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3091: ifeq +30 -> 3121
    //   3094: ldc_w 650
    //   3097: iconst_2
    //   3098: new 200	java/lang/StringBuilder
    //   3101: dup
    //   3102: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3105: ldc_w 1784
    //   3108: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: aload_2
    //   3112: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3115: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3118: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3121: aload_2
    //   3122: ifnull +9 -> 3131
    //   3125: aload 15
    //   3127: aload_2
    //   3128: invokevirtual 1788	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3131: aload 15
    //   3133: getfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3136: ifnull +787 -> 3923
    //   3139: new 766	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3142: dup
    //   3143: invokespecial 767	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3146: astore_2
    //   3147: aload_2
    //   3148: aload 15
    //   3150: getfield 436	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3153: invokevirtual 768	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3156: pop
    //   3157: iload 8
    //   3159: bipush 51
    //   3161: if_icmpne +1376 -> 4537
    //   3164: aload_2
    //   3165: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3168: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3171: iconst_1
    //   3172: if_icmpne +1355 -> 4527
    //   3175: iconst_1
    //   3176: istore_1
    //   3177: aload 15
    //   3179: iload_1
    //   3180: putfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3183: aload_2
    //   3184: getfield 774	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3187: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3190: iconst_1
    //   3191: if_icmpne +1341 -> 4532
    //   3194: iconst_1
    //   3195: istore_1
    //   3196: aload 15
    //   3198: iload_1
    //   3199: putfield 588	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3202: aload 15
    //   3204: aload_2
    //   3205: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3208: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3211: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3214: putfield 612	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3217: aload 15
    //   3219: aload_2
    //   3220: getfield 780	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3223: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3226: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3229: putfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3232: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3235: ifeq +1412 -> 4647
    //   3238: ldc_w 782
    //   3241: iconst_2
    //   3242: new 200	java/lang/StringBuilder
    //   3245: dup
    //   3246: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3249: ldc_w 784
    //   3252: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3255: iload 8
    //   3257: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3260: ldc_w 786
    //   3263: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3266: aload_2
    //   3267: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3270: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3273: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3276: ldc_w 788
    //   3279: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: aload_2
    //   3283: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3286: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3289: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3292: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3295: ldc_w 790
    //   3298: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3301: aload_0
    //   3302: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3305: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3308: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3314: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3317: aload 15
    //   3319: aload_2
    //   3320: getfield 796	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3323: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3326: putfield 597	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3329: aload_2
    //   3330: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3333: invokevirtual 803	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3336: ifeq +1416 -> 4752
    //   3339: aload 15
    //   3341: aload_2
    //   3342: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3345: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3348: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3351: getfield 807	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3354: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3357: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3360: putfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3363: aload 15
    //   3365: aload_2
    //   3366: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3369: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3372: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3375: getfield 810	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3378: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3381: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3384: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3387: aload 15
    //   3389: aload_2
    //   3390: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3393: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3396: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3399: getfield 813	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3402: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3405: putfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3408: aload 15
    //   3410: aload_2
    //   3411: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3414: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3417: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3420: getfield 816	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3423: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3426: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3429: putfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3432: aload 15
    //   3434: aload_2
    //   3435: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3438: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3441: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3444: getfield 819	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3447: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3450: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3453: aload 15
    //   3455: aload_2
    //   3456: getfield 800	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3459: invokevirtual 804	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3462: checkcast 802	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3465: getfield 822	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3468: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3471: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3474: aload_2
    //   3475: getfield 825	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3478: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3481: iconst_1
    //   3482: if_icmpne +2256 -> 5738
    //   3485: iconst_1
    //   3486: istore_1
    //   3487: aload 15
    //   3489: iload_1
    //   3490: putfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3493: aload 15
    //   3495: aload_2
    //   3496: getfield 831	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3499: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3502: putfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3505: aload 15
    //   3507: aload_2
    //   3508: getfield 837	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3511: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3514: putfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3517: aload 15
    //   3519: aload_2
    //   3520: getfield 843	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3523: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3526: putfield 846	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3529: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3532: ifeq +104 -> 3636
    //   3535: ldc_w 848
    //   3538: iconst_2
    //   3539: new 200	java/lang/StringBuilder
    //   3542: dup
    //   3543: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3546: ldc_w 850
    //   3549: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3552: aload 15
    //   3554: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3557: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: ldc_w 852
    //   3563: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3566: aload 15
    //   3568: getfield 828	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3571: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3574: ldc_w 857
    //   3577: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3580: aload 15
    //   3582: invokevirtual 860	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3585: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3588: ldc_w 862
    //   3591: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3594: aload 15
    //   3596: getfield 834	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3599: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: ldc_w 864
    //   3605: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3608: aload 15
    //   3610: getfield 846	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3613: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: ldc_w 866
    //   3619: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3622: aload 15
    //   3624: getfield 840	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3627: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3630: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3633: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3636: aload_2
    //   3637: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3640: invokevirtual 873	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   3643: ifeq +1154 -> 4797
    //   3646: aload 15
    //   3648: aload_2
    //   3649: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3652: getfield 876	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3655: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3658: putfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3661: aload 15
    //   3663: aload_2
    //   3664: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3667: getfield 882	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3670: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3673: putfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3676: aload 15
    //   3678: aload_2
    //   3679: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3682: getfield 888	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3685: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3688: putfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3691: aload 15
    //   3693: aload_2
    //   3694: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3697: getfield 894	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3700: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3703: putfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   3706: aload 15
    //   3708: aload_2
    //   3709: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3712: getfield 900	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3715: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3718: putfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   3721: aload 15
    //   3723: aload_2
    //   3724: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3727: getfield 906	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3730: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3733: putfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   3736: aload 15
    //   3738: aload_2
    //   3739: getfield 870	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3742: getfield 912	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3745: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3748: putfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   3751: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3754: ifeq +169 -> 3923
    //   3757: new 200	java/lang/StringBuilder
    //   3760: dup
    //   3761: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   3764: astore_2
    //   3765: aload_2
    //   3766: ldc_w 917
    //   3769: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3772: ldc_w 919
    //   3775: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3778: aload 15
    //   3780: getfield 879	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3783: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3786: ldc_w 921
    //   3789: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3792: ldc_w 923
    //   3795: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3798: aload 15
    //   3800: getfield 885	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3803: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3806: ldc_w 921
    //   3809: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3812: ldc_w 925
    //   3815: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3818: aload 15
    //   3820: getfield 891	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3823: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: ldc_w 921
    //   3829: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3832: ldc_w 927
    //   3835: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3838: aload 15
    //   3840: getfield 897	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   3843: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3846: ldc_w 921
    //   3849: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3852: ldc_w 929
    //   3855: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3858: aload 15
    //   3860: getfield 903	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   3863: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: ldc_w 921
    //   3869: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3872: ldc_w 931
    //   3875: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3878: aload 15
    //   3880: getfield 909	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   3883: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3886: ldc_w 921
    //   3889: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3892: ldc_w 933
    //   3895: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3898: aload 15
    //   3900: getfield 915	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   3903: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3906: ldc_w 921
    //   3909: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3912: pop
    //   3913: ldc 198
    //   3915: iconst_2
    //   3916: aload_2
    //   3917: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3920: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3923: aload 16
    //   3925: getfield 1792	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3928: ifnull +29 -> 3957
    //   3931: aload 15
    //   3933: aload 16
    //   3935: getfield 1792	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3938: getfield 1797	SummaryCard/GiftInfo:uOpenFlag	J
    //   3941: putfield 733	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   3944: aload 15
    //   3946: aload 16
    //   3948: getfield 1792	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   3951: getfield 1798	SummaryCard/GiftInfo:vGiftInfo	[B
    //   3954: putfield 737	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   3957: aload 16
    //   3959: getfield 1801	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3962: ifnull +162 -> 4124
    //   3965: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3968: ifeq +12 -> 3980
    //   3971: ldc 198
    //   3973: iconst_2
    //   3974: ldc_w 1803
    //   3977: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3980: new 1805	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   3983: dup
    //   3984: invokespecial 1806	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   3987: astore_2
    //   3988: aload_2
    //   3989: aload 16
    //   3991: getfield 1801	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   3994: invokevirtual 1807	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3997: pop
    //   3998: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4001: ifeq +82 -> 4083
    //   4004: ldc 198
    //   4006: iconst_2
    //   4007: new 200	java/lang/StringBuilder
    //   4010: dup
    //   4011: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4014: ldc_w 1809
    //   4017: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4020: aload_2
    //   4021: getfield 1810	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4024: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4027: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4030: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4033: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4036: aload_2
    //   4037: getfield 1813	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4040: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4043: ifeq +40 -> 4083
    //   4046: ldc 198
    //   4048: iconst_2
    //   4049: new 200	java/lang/StringBuilder
    //   4052: dup
    //   4053: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4056: ldc_w 1815
    //   4059: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4062: aload_2
    //   4063: getfield 1813	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4066: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4069: invokeinterface 560 1 0
    //   4074: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4077: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4080: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4083: aload_2
    //   4084: getfield 1810	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4087: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4090: iconst_1
    //   4091: if_icmpne +724 -> 4815
    //   4094: iconst_1
    //   4095: istore_1
    //   4096: aload 15
    //   4098: iload_1
    //   4099: putfield 1818	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4102: aload_2
    //   4103: getfield 1813	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4106: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4109: ifeq +15 -> 4124
    //   4112: aload 15
    //   4114: aload_2
    //   4115: getfield 1813	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4118: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4121: invokevirtual 1821	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4124: aload 16
    //   4126: getfield 1824	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4129: astore_3
    //   4130: aload_3
    //   4131: ifnull +41 -> 4172
    //   4134: new 1826	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4137: dup
    //   4138: invokespecial 1827	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4141: astore_2
    //   4142: aload_2
    //   4143: aload_3
    //   4144: invokevirtual 1828	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4147: pop
    //   4148: aload 15
    //   4150: aload_2
    //   4151: getfield 1831	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4154: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4157: putfield 1834	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4160: aload 15
    //   4162: aload_2
    //   4163: getfield 1837	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4166: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4169: putfield 1840	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4172: aload 16
    //   4174: getfield 1843	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4177: astore_3
    //   4178: aload_3
    //   4179: ifnull +695 -> 4874
    //   4182: aload 15
    //   4184: new 528	java/util/ArrayList
    //   4187: dup
    //   4188: invokespecial 529	java/util/ArrayList:<init>	()V
    //   4191: putfield 1846	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4194: new 1848	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4197: dup
    //   4198: invokespecial 1849	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4201: astore_2
    //   4202: aload_2
    //   4203: aload_3
    //   4204: invokevirtual 1850	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4207: pop
    //   4208: aload_2
    //   4209: getfield 1853	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4212: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4215: astore 17
    //   4217: aload 17
    //   4219: ifnull +655 -> 4874
    //   4222: new 554	org/json/JSONArray
    //   4225: dup
    //   4226: invokespecial 555	org/json/JSONArray:<init>	()V
    //   4229: astore 4
    //   4231: iconst_0
    //   4232: istore 5
    //   4234: iload 5
    //   4236: aload 17
    //   4238: invokeinterface 560 1 0
    //   4243: if_icmpge +616 -> 4859
    //   4246: new 1855	org/json/JSONObject
    //   4249: dup
    //   4250: invokespecial 1856	org/json/JSONObject:<init>	()V
    //   4253: astore_3
    //   4254: new 1858	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4257: dup
    //   4258: invokespecial 1859	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4261: astore_2
    //   4262: aload_2
    //   4263: aload 17
    //   4265: iload 5
    //   4267: invokeinterface 563 2 0
    //   4272: checkcast 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4275: getfield 1864	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4278: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4281: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4284: putfield 1866	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4287: aload_2
    //   4288: getfield 1866	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4291: invokestatic 1869	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4294: ifne +15 -> 4309
    //   4297: aload_3
    //   4298: ldc_w 1870
    //   4301: aload_2
    //   4302: getfield 1866	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4305: invokevirtual 1873	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4308: pop
    //   4309: aload_2
    //   4310: aload 17
    //   4312: iload 5
    //   4314: invokeinterface 563 2 0
    //   4319: checkcast 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4322: getfield 1876	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4325: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4328: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4331: putfield 1879	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4334: aload_2
    //   4335: getfield 1879	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4338: invokestatic 1869	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4341: ifne +15 -> 4356
    //   4344: aload_3
    //   4345: ldc_w 1880
    //   4348: aload_2
    //   4349: getfield 1879	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4352: invokevirtual 1873	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4355: pop
    //   4356: aload_2
    //   4357: aload 17
    //   4359: iload 5
    //   4361: invokeinterface 563 2 0
    //   4366: checkcast 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4369: getfield 1883	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4372: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4375: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4378: putfield 1885	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4381: aload_2
    //   4382: getfield 1885	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4385: invokestatic 1869	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4388: ifne +15 -> 4403
    //   4391: aload_3
    //   4392: ldc_w 1886
    //   4395: aload_2
    //   4396: getfield 1885	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4399: invokevirtual 1873	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4402: pop
    //   4403: aload_2
    //   4404: aload 17
    //   4406: iload 5
    //   4408: invokeinterface 563 2 0
    //   4413: checkcast 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4416: getfield 1889	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4419: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4422: putfield 1892	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4425: aload_3
    //   4426: ldc_w 1893
    //   4429: aload_2
    //   4430: getfield 1892	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4433: invokevirtual 1896	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4436: pop
    //   4437: aload_2
    //   4438: aload 17
    //   4440: iload 5
    //   4442: invokeinterface 563 2 0
    //   4447: checkcast 1861	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4450: getfield 1899	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4453: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4456: putfield 1901	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4459: aload_3
    //   4460: ldc_w 1902
    //   4463: aload_2
    //   4464: getfield 1901	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4467: invokevirtual 1896	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4470: pop
    //   4471: aload 15
    //   4473: getfield 1846	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4476: aload_2
    //   4477: invokeinterface 570 2 0
    //   4482: pop
    //   4483: aload 4
    //   4485: aload_3
    //   4486: invokevirtual 574	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4489: pop
    //   4490: iload 5
    //   4492: iconst_1
    //   4493: iadd
    //   4494: istore 5
    //   4496: goto -262 -> 4234
    //   4499: iload 5
    //   4501: iconst_1
    //   4502: iadd
    //   4503: istore 5
    //   4505: goto -1444 -> 3061
    //   4508: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4511: ifeq -1380 -> 3131
    //   4514: ldc_w 650
    //   4517: iconst_2
    //   4518: ldc_w 1904
    //   4521: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4524: goto -1393 -> 3131
    //   4527: iconst_0
    //   4528: istore_1
    //   4529: goto -1352 -> 3177
    //   4532: iconst_0
    //   4533: istore_1
    //   4534: goto -1338 -> 3196
    //   4537: aload 15
    //   4539: aload_2
    //   4540: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4543: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4546: putfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4549: aload 15
    //   4551: getfield 594	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4554: iconst_1
    //   4555: if_icmpne +82 -> 4637
    //   4558: iconst_1
    //   4559: istore_1
    //   4560: aload 15
    //   4562: iload_1
    //   4563: putfield 591	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4566: aload_2
    //   4567: getfield 774	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4570: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4573: iconst_1
    //   4574: if_icmpne +68 -> 4642
    //   4577: iconst_1
    //   4578: istore_1
    //   4579: aload 15
    //   4581: iload_1
    //   4582: putfield 585	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4585: aload 15
    //   4587: aload_2
    //   4588: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4591: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4594: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4597: putfield 609	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4600: aload 15
    //   4602: aload_2
    //   4603: getfield 780	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4606: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4609: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4612: putfield 603	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4615: goto -1383 -> 3232
    //   4618: astore_2
    //   4619: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4622: ifeq -699 -> 3923
    //   4625: ldc 198
    //   4627: iconst_2
    //   4628: ldc_w 1066
    //   4631: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4634: goto -711 -> 3923
    //   4637: iconst_0
    //   4638: istore_1
    //   4639: goto -79 -> 4560
    //   4642: iconst_0
    //   4643: istore_1
    //   4644: goto -65 -> 4579
    //   4647: ldc_w 782
    //   4650: iconst_1
    //   4651: new 200	java/lang/StringBuilder
    //   4654: dup
    //   4655: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4658: ldc_w 784
    //   4661: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4664: iload 8
    //   4666: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4669: ldc_w 786
    //   4672: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4675: aload_2
    //   4676: getfield 771	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4679: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4682: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4685: ldc_w 788
    //   4688: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4691: aload_2
    //   4692: getfield 777	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4695: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4698: invokevirtual 566	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4701: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4704: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4707: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4710: goto -1393 -> 3317
    //   4713: astore_3
    //   4714: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4717: ifeq -1400 -> 3317
    //   4720: ldc 198
    //   4722: iconst_2
    //   4723: new 200	java/lang/StringBuilder
    //   4726: dup
    //   4727: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4730: ldc_w 1068
    //   4733: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4736: aload_3
    //   4737: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   4740: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4743: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4746: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4749: goto -1432 -> 3317
    //   4752: aload 15
    //   4754: ldc_w 499
    //   4757: putfield 630	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   4760: aload 15
    //   4762: ldc_w 499
    //   4765: putfield 627	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   4768: aload 15
    //   4770: iconst_0
    //   4771: putfield 624	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   4774: aload 15
    //   4776: ldc_w 499
    //   4779: putfield 615	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   4782: aload 15
    //   4784: iconst_0
    //   4785: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   4788: aload 15
    //   4790: iconst_0
    //   4791: putfield 621	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   4794: goto -1320 -> 3474
    //   4797: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4800: ifeq -877 -> 3923
    //   4803: ldc 198
    //   4805: iconst_2
    //   4806: ldc_w 1070
    //   4809: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4812: goto -889 -> 3923
    //   4815: iconst_0
    //   4816: istore_1
    //   4817: goto -721 -> 4096
    //   4820: astore_2
    //   4821: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4824: ifeq -700 -> 4124
    //   4827: ldc 198
    //   4829: iconst_2
    //   4830: new 200	java/lang/StringBuilder
    //   4833: dup
    //   4834: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4837: ldc_w 1906
    //   4840: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4843: aload_2
    //   4844: invokevirtual 1907	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4847: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4850: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4853: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4856: goto -732 -> 4124
    //   4859: aload 4
    //   4861: ifnull +13 -> 4874
    //   4864: aload 15
    //   4866: aload 4
    //   4868: invokevirtual 641	org/json/JSONArray:toString	()Ljava/lang/String;
    //   4871: putfield 1910	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   4874: aload 15
    //   4876: aload 16
    //   4878: getfield 1843	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4881: putfield 939	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   4884: new 941	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   4887: dup
    //   4888: invokespecial 942	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   4891: astore_3
    //   4892: aload_3
    //   4893: aload 16
    //   4895: getfield 1843	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4898: invokevirtual 943	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4901: pop
    //   4902: aload_3
    //   4903: astore_2
    //   4904: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4907: ifeq +69 -> 4976
    //   4910: ldc 198
    //   4912: iconst_2
    //   4913: new 200	java/lang/StringBuilder
    //   4916: dup
    //   4917: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   4920: ldc_w 945
    //   4923: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4926: aload_3
    //   4927: getfield 948	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4930: invokevirtual 949	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   4933: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4936: ldc_w 951
    //   4939: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4942: aload_3
    //   4943: getfield 954	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4946: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4949: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4952: ldc_w 957
    //   4955: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4958: aload_3
    //   4959: getfield 960	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4962: invokevirtual 955	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4965: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4968: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4971: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4974: aload_3
    //   4975: astore_2
    //   4976: aload 15
    //   4978: aload_2
    //   4979: putfield 964	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   4982: aload_0
    //   4983: bipush 51
    //   4985: iconst_1
    //   4986: aload 15
    //   4988: iload 10
    //   4990: invokevirtual 267	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   4993: aload_0
    //   4994: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4997: getstatic 969	com/tencent/mobileqq/app/QQManagerFactory:NEARBY_CARD_MANAGER	I
    //   5000: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5003: checkcast 975	com/tencent/mobileqq/nearby/NearbyCardManager
    //   5006: astore_2
    //   5007: iload 8
    //   5009: bipush 51
    //   5011: if_icmpne +458 -> 5469
    //   5014: aload_2
    //   5015: aload 15
    //   5017: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5020: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   5023: invokevirtual 983	com/tencent/mobileqq/nearby/NearbyCardManager:b	(Ljava/lang/String;J)V
    //   5026: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5029: ifeq +46 -> 5075
    //   5032: ldc_w 985
    //   5035: iconst_4
    //   5036: new 200	java/lang/StringBuilder
    //   5039: dup
    //   5040: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   5043: ldc_w 987
    //   5046: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5049: aload 15
    //   5051: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5054: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5057: ldc_w 989
    //   5060: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5063: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   5066: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5069: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5072: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5075: aload_0
    //   5076: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5079: getstatic 992	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   5082: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5085: checkcast 994	com/tencent/mobileqq/app/FriendsManager
    //   5088: astore_2
    //   5089: invokestatic 1914	com/tencent/mobileqq/nearby/NearbyUtils:b	()Z
    //   5092: ifeq +55 -> 5147
    //   5095: ldc 198
    //   5097: iconst_5
    //   5098: anewarray 1148	java/lang/Object
    //   5101: dup
    //   5102: iconst_0
    //   5103: ldc_w 1916
    //   5106: aastore
    //   5107: dup
    //   5108: iconst_1
    //   5109: iload 8
    //   5111: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5114: aastore
    //   5115: dup
    //   5116: iconst_2
    //   5117: aload 15
    //   5119: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5122: aastore
    //   5123: dup
    //   5124: iconst_3
    //   5125: aload_0
    //   5126: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5129: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5132: aastore
    //   5133: dup
    //   5134: iconst_4
    //   5135: aload 16
    //   5137: getfield 1232	SummaryCard/RespSummaryCard:lUIN	J
    //   5140: invokestatic 131	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5143: aastore
    //   5144: invokestatic 1919	com/tencent/mobileqq/nearby/NearbyUtils:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   5147: iload 8
    //   5149: ifeq +21 -> 5170
    //   5152: aload 15
    //   5154: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5157: aload_0
    //   5158: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5161: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5164: invokevirtual 1235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5167: ifeq +76 -> 5243
    //   5170: aload_2
    //   5171: aload 15
    //   5173: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5176: invokevirtual 997	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5179: astore_3
    //   5180: aload_3
    //   5181: aload 15
    //   5183: getfield 757	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5186: putfield 1002	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5189: aload_3
    //   5190: aload 15
    //   5192: getfield 751	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5195: i2l
    //   5196: putfield 1005	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5199: aload_0
    //   5200: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5203: invokevirtual 1008	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5206: aload_3
    //   5207: getfield 1005	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5210: aload_3
    //   5211: getfield 1002	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5214: invokestatic 1013	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   5217: pop
    //   5218: aload_2
    //   5219: aload_3
    //   5220: invokevirtual 1016	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5223: pop
    //   5224: aload_0
    //   5225: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5228: invokevirtual 1008	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5231: ldc_w 1018
    //   5234: aload 15
    //   5236: getfield 418	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5239: invokestatic 1021	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5242: pop
    //   5243: aload_0
    //   5244: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5247: invokevirtual 338	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5250: aload 15
    //   5252: getfield 341	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5255: invokevirtual 1235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5258: ifeq +32 -> 5290
    //   5261: aload 15
    //   5263: getfield 1024	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5266: ifle +24 -> 5290
    //   5269: aload_0
    //   5270: getfield 19	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5273: getstatic 1027	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   5276: invokevirtual 973	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5279: checkcast 1029	com/tencent/mobileqq/app/HotChatManager
    //   5282: aload 15
    //   5284: getfield 1024	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5287: invokevirtual 1031	com/tencent/mobileqq/app/HotChatManager:a	(I)V
    //   5290: aload_2
    //   5291: aload 15
    //   5293: invokevirtual 1034	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5296: aload 15
    //   5298: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5301: sipush 1000
    //   5304: if_icmpne +350 -> 5654
    //   5307: aload 14
    //   5309: iconst_0
    //   5310: ldc_w 321
    //   5313: invokevirtual 1039	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5316: aconst_null
    //   5317: aconst_null
    //   5318: aconst_null
    //   5319: aconst_null
    //   5320: aconst_null
    //   5321: aconst_null
    //   5322: aconst_null
    //   5323: invokevirtual 1043	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5326: astore_3
    //   5327: aload_3
    //   5328: ifnull +289 -> 5617
    //   5331: aload_3
    //   5332: astore_2
    //   5333: aload_3
    //   5334: invokeinterface 1048 1 0
    //   5339: istore 5
    //   5341: aload_3
    //   5342: astore_2
    //   5343: aload_3
    //   5344: invokeinterface 1051 1 0
    //   5349: pop
    //   5350: iload 5
    //   5352: sipush 200
    //   5355: if_icmple +262 -> 5617
    //   5358: iload 5
    //   5360: bipush 100
    //   5362: if_icmple +133 -> 5495
    //   5365: aload_3
    //   5366: astore_2
    //   5367: aload_3
    //   5368: invokeinterface 1054 1 0
    //   5373: pop
    //   5374: iload 5
    //   5376: iconst_1
    //   5377: isub
    //   5378: istore 5
    //   5380: goto -22 -> 5358
    //   5383: astore_2
    //   5384: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5387: ifeq -513 -> 4874
    //   5390: ldc 198
    //   5392: iconst_2
    //   5393: new 200	java/lang/StringBuilder
    //   5396: dup
    //   5397: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   5400: ldc_w 1921
    //   5403: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5406: aload_2
    //   5407: invokevirtual 1059	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5410: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5413: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5416: invokestatic 228	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5419: goto -545 -> 4874
    //   5422: astore 4
    //   5424: aconst_null
    //   5425: astore_3
    //   5426: aload_3
    //   5427: astore_2
    //   5428: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5431: ifeq -455 -> 4976
    //   5434: ldc 198
    //   5436: iconst_2
    //   5437: new 200	java/lang/StringBuilder
    //   5440: dup
    //   5441: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   5444: ldc_w 1072
    //   5447: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5450: aload 4
    //   5452: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   5455: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5458: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5461: invokestatic 1075	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5464: aload_3
    //   5465: astore_2
    //   5466: goto -490 -> 4976
    //   5469: aload_2
    //   5470: aload 15
    //   5472: getfield 344	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5475: invokestatic 326	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5478: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   5481: invokevirtual 1077	com/tencent/mobileqq/nearby/NearbyCardManager:a	(Ljava/lang/String;J)V
    //   5484: goto -458 -> 5026
    //   5487: astore_3
    //   5488: aload_3
    //   5489: invokevirtual 1080	java/lang/Exception:printStackTrace	()V
    //   5492: goto -249 -> 5243
    //   5495: aload_3
    //   5496: astore_2
    //   5497: aload_3
    //   5498: aload_3
    //   5499: ldc_w 1082
    //   5502: invokeinterface 1085 2 0
    //   5507: invokeinterface 1088 2 0
    //   5512: istore 5
    //   5514: aload_3
    //   5515: astore_2
    //   5516: new 200	java/lang/StringBuilder
    //   5519: dup
    //   5520: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   5523: astore 4
    //   5525: aload_3
    //   5526: astore_2
    //   5527: aload 4
    //   5529: ldc_w 1090
    //   5532: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5535: pop
    //   5536: aload_3
    //   5537: astore_2
    //   5538: aload 4
    //   5540: ldc_w 321
    //   5543: invokevirtual 1039	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5546: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5549: pop
    //   5550: aload_3
    //   5551: astore_2
    //   5552: aload 4
    //   5554: ldc_w 1092
    //   5557: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5560: pop
    //   5561: aload_3
    //   5562: astore_2
    //   5563: aload 4
    //   5565: ldc_w 1082
    //   5568: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5571: pop
    //   5572: aload_3
    //   5573: astore_2
    //   5574: aload 4
    //   5576: ldc_w 1094
    //   5579: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5582: pop
    //   5583: aload_3
    //   5584: astore_2
    //   5585: aload 4
    //   5587: iload 5
    //   5589: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5592: pop
    //   5593: aload_3
    //   5594: astore_2
    //   5595: aload 4
    //   5597: ldc_w 1096
    //   5600: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5603: pop
    //   5604: aload_3
    //   5605: astore_2
    //   5606: aload 14
    //   5608: aload 4
    //   5610: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5613: invokevirtual 1099	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   5616: pop
    //   5617: aload_3
    //   5618: astore_2
    //   5619: aload 14
    //   5621: aload 15
    //   5623: invokevirtual 1103	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   5626: aload_3
    //   5627: astore_2
    //   5628: aload 13
    //   5630: invokevirtual 1106	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   5633: aload_3
    //   5634: ifnull +9 -> 5643
    //   5637: aload_3
    //   5638: invokeinterface 1109 1 0
    //   5643: aload 13
    //   5645: invokevirtual 1112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   5648: aload 14
    //   5650: invokevirtual 1113	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   5653: return
    //   5654: aload 15
    //   5656: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5659: sipush 1001
    //   5662: if_icmpeq +14 -> 5676
    //   5665: aload 15
    //   5667: invokevirtual 579	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5670: sipush 1002
    //   5673: if_icmpne +11 -> 5684
    //   5676: aload 14
    //   5678: aload 15
    //   5680: invokevirtual 1117	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   5683: pop
    //   5684: aconst_null
    //   5685: astore_3
    //   5686: goto -60 -> 5626
    //   5689: astore_3
    //   5690: aconst_null
    //   5691: astore_2
    //   5692: aload_2
    //   5693: ifnull +9 -> 5702
    //   5696: aload_2
    //   5697: invokeinterface 1109 1 0
    //   5702: aload 13
    //   5704: invokevirtual 1112	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   5707: aload 14
    //   5709: invokevirtual 1113	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   5712: aload_3
    //   5713: athrow
    //   5714: aload_0
    //   5715: bipush 51
    //   5717: iconst_0
    //   5718: aconst_null
    //   5719: iload 10
    //   5721: invokevirtual 267	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;Z)V
    //   5724: return
    //   5725: astore_3
    //   5726: goto -34 -> 5692
    //   5729: astore_2
    //   5730: goto -1558 -> 4172
    //   5733: aconst_null
    //   5734: astore_2
    //   5735: goto -2647 -> 3088
    //   5738: iconst_0
    //   5739: istore_1
    //   5740: goto -2253 -> 3487
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5743	0	this	NearbyCardHandler
    //   0	5743	1	paramBoolean	boolean
    //   0	5743	2	paramObject	Object
    //   0	5743	3	paramBundle	Bundle
    //   0	5743	4	paramRespHead	SummaryCard.RespHead
    //   826	4762	5	i	int
    //   1723	1067	6	j	int
    //   1763	765	7	k	int
    //   15	5133	8	m	int
    //   1771	785	9	n	int
    //   6	5714	10	bool	boolean
    //   59	2929	11	l	long
    //   44	5659	13	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   37	5671	14	localEntityManager	EntityManager
    //   88	5591	15	localNearbyPeopleCard	NearbyPeopleCard
    //   25	5111	16	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   772	3667	17	localObject1	Object
    //   798	1278	18	localObject2	Object
    //   2057	240	19	localArrayList	ArrayList
    //   2088	168	20	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2097	183	21	localProfileGroupLabel	com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel
    //   1836	491	22	localProfileSummaryHobbiesEntry	com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry
    //   2150	123	23	localProfileColor	com.tencent.mobileqq.profilecard.entity.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   774	825	1443	java/lang/Exception
    //   828	876	1443	java/lang/Exception
    //   1009	1019	1443	java/lang/Exception
    //   1813	1838	2400	java/lang/Exception
    //   1843	1894	2400	java/lang/Exception
    //   1897	2059	2400	java/lang/Exception
    //   2062	2285	2400	java/lang/Exception
    //   2294	2301	2400	java/lang/Exception
    //   2301	2309	2400	java/lang/Exception
    //   2318	2325	2400	java/lang/Exception
    //   2325	2397	2400	java/lang/Exception
    //   2569	2586	2697	java/lang/Exception
    //   2591	2679	2697	java/lang/Exception
    //   2679	2694	2697	java/lang/Exception
    //   2718	2746	2697	java/lang/Exception
    //   2749	2814	2697	java/lang/Exception
    //   2964	2999	3002	java/lang/Exception
    //   2863	2873	3023	java/lang/Exception
    //   3147	3157	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3164	3175	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3177	3194	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3196	3232	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3232	3317	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3317	3474	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3474	3485	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3487	3636	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3636	3923	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4537	4558	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4560	4577	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4579	4615	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4647	4710	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4714	4749	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4752	4794	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4797	4812	4618	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3232	3317	4713	java/lang/Exception
    //   4647	4710	4713	java/lang/Exception
    //   3965	3980	4820	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3980	4083	4820	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4083	4094	4820	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4096	4124	4820	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4202	4217	5383	java/lang/Exception
    //   4222	4231	5383	java/lang/Exception
    //   4234	4309	5383	java/lang/Exception
    //   4309	4356	5383	java/lang/Exception
    //   4356	4403	5383	java/lang/Exception
    //   4403	4490	5383	java/lang/Exception
    //   4864	4874	5383	java/lang/Exception
    //   4884	4902	5422	java/lang/Exception
    //   4904	4974	5422	java/lang/Exception
    //   5224	5243	5487	java/lang/Exception
    //   5296	5327	5689	finally
    //   5654	5676	5689	finally
    //   5676	5684	5689	finally
    //   5333	5341	5725	finally
    //   5343	5350	5725	finally
    //   5367	5374	5725	finally
    //   5497	5514	5725	finally
    //   5516	5525	5725	finally
    //   5527	5536	5725	finally
    //   5538	5550	5725	finally
    //   5552	5561	5725	finally
    //   5563	5572	5725	finally
    //   5574	5583	5725	finally
    //   5585	5593	5725	finally
    //   5595	5604	5725	finally
    //   5606	5617	5725	finally
    //   5619	5626	5725	finally
    //   5628	5633	5725	finally
    //   4142	4172	5729	java/lang/Exception
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), HardCodeUtil.a(2131707126) });
      return;
    }
    String str;
    label92:
    int i;
    label102:
    int j;
    label112:
    int i2;
    int k;
    label152:
    int m;
    label171:
    label189:
    label207:
    Object localObject;
    if (paramToServiceMsg.extraData == null)
    {
      str = "";
      if (paramToServiceMsg.extraData != null) {
        break label547;
      }
      if (paramToServiceMsg.extraData != null) {
        break label561;
      }
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label576;
      }
      j = -1;
      paramToServiceMsg = new cmd0x9c8.RspBody();
      i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i2 != 0) {
        break label849;
      }
      if (!paramToServiceMsg.uint32_tag_type.has()) {
        break label591;
      }
      k = paramToServiceMsg.uint32_tag_type.get();
      if (!paramToServiceMsg.uint32_next_pos.has()) {
        break label597;
      }
      m = paramToServiceMsg.uint32_next_pos.get();
      if (!paramToServiceMsg.rpt_msg_tag_list.has()) {
        break label603;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_tag_list.get();
      if (!paramToServiceMsg.rpt_msg_sel_list.has()) {
        break label608;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_sel_list.get();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      if ((i != 0) || (!TextUtils.isEmpty(str)) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label613;
      }
    }
    label547:
    label561:
    label576:
    label591:
    label597:
    label603:
    label608:
    label613:
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        paramObject = new StringBuilder();
        paramObject.append("DELETE FROM ");
        paramObject.append(InterestTagInfo.class.getSimpleName());
        paramObject.append(" WHERE ");
        paramObject.append("tagType = ");
        paramObject.append(k);
        paramObject.append(";");
        ((EntityManager)localObject).execSQL(paramObject.toString());
        paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
        paramObject.putLong("list_last_update_time_" + k, NetConnInfoCenter.getServerTimeMillis());
        paramObject.putInt("list_fetch_pos_" + k, m);
        paramObject.commit();
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label967;
      }
      paramObject = new ArrayList();
      int i1 = 0;
      while (i1 < paramFromServiceMsg.size())
      {
        InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramFromServiceMsg.get(i1));
        if (localInterestTagInfo != null)
        {
          localInterestTagInfo.tagType = k;
          paramObject.add(localInterestTagInfo);
          if (n != 0) {
            ((EntityManager)localObject).persist(localInterestTagInfo);
          }
        }
        i1 += 1;
      }
      str = paramToServiceMsg.extraData.getString("key_word");
      break;
      paramToServiceMsg.extraData.getInt("tag_type");
      break label92;
      i = paramToServiceMsg.extraData.getInt("fetch_start");
      break label102;
      j = paramToServiceMsg.extraData.getInt("person_flag");
      break label112;
      k = -1;
      break label152;
      m = -1;
      break label171;
      paramFromServiceMsg = null;
      break label189;
      paramToServiceMsg = null;
      break label207;
    }
    label967:
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      ((EntityManager)localObject).close();
      localObject = null;
      paramObject = localObject;
      if (paramToServiceMsg != null)
      {
        paramObject = localObject;
        if (!paramToServiceMsg.isEmpty())
        {
          paramObject = new ArrayList();
          n = 0;
          while (n < paramToServiceMsg.size())
          {
            localObject = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramToServiceMsg.get(n));
            if (localObject != null) {
              paramObject.add(localObject);
            }
            n += 1;
          }
        }
      }
      notifyUI(1, true, new Object[] { Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j), null });
      NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      label849:
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
        NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(3, false, null);
      return;
    }
    Object localObject = new cmd0x9c9.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
    boolean bool1;
    EntityManager localEntityManager;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (i != 0) {
        break label1060;
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      if (paramFromServiceMsg != null) {
        break label1099;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label1024:
    label1030:
    label1060:
    label1099:
    for (;;)
    {
      for (;;)
      {
        if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
          paramFromServiceMsg.godFlag = false;
        }
        if (((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.has())
        {
          paramObject = ((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.get().toByteArray();
          label231:
          paramObject = paramFromServiceMsg.updateEditPicInfos(paramObject, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
          if ((paramObject != null) && (!paramObject.isEmpty())) {
            NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
          }
          paramObject = paramToServiceMsg.extraData.getByteArray("9c7_body");
          if ((paramObject == null) || (paramObject.length <= 0)) {}
        }
        try
        {
          localObject = new cmd0x9c7.ReqBody();
          ((cmd0x9c7.ReqBody)localObject).mergeFrom(paramObject);
          paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject).rpt_msg_tags.get());
          if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
            paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
          }
          if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
            paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
          }
          if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
            paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
          }
          if (paramToServiceMsg.extraData.containsKey("sex"))
          {
            paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
            paramObject = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            if (paramObject != null) {
              paramObject.b(paramFromServiceMsg.gender);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("birthday"))
          {
            paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
            paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
            paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
            paramObject = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            if (paramObject != null) {
              paramObject.a(paramFromServiceMsg.age);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("profession")) {
            paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
          }
          if (paramToServiceMsg.extraData.containsKey("company")) {
            paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
          }
          if (paramToServiceMsg.extraData.containsKey("college")) {
            paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
          }
        }
        catch (Exception paramObject)
        {
          try
          {
            do
            {
              NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                paramFromServiceMsg.hometownCountry = paramObject[0];
                paramFromServiceMsg.hometownProvice = paramObject[1];
                paramFromServiceMsg.hometownCity = paramObject[2];
                paramFromServiceMsg.hometownDistrict = paramObject[3];
              }
              if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_qzone_switch") != 0) {
                  break label1012;
                }
                bool2 = true;
                paramFromServiceMsg.switchQzone = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                  break label1018;
                }
                bool2 = true;
                paramFromServiceMsg.switchHobby = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                  break label1024;
                }
                l1 = 0L;
                paramFromServiceMsg.switchGiftVisible = l1;
              }
              if (paramFromServiceMsg.getStatus() != 1000) {
                break label1030;
              }
              localEntityManager.persistOrReplace(paramFromServiceMsg);
              bool2 = true;
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = "";
              notifyUI(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), paramFromServiceMsg });
              paramObject = new HashMap();
              paramObject.put("errorCode", String.valueOf(i));
              StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramObject, "");
              NearbyUtils.a("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
              return;
              bool1 = false;
              break;
              paramObject = null;
              break label231;
              paramObject = paramObject;
            } while ((!NearbyCardConstants.a) || (!QLog.isColorLevel()));
            QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + paramObject.getMessage());
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              paramObject.printStackTrace();
              continue;
              label1012:
              bool2 = false;
              continue;
              label1018:
              bool2 = false;
              continue;
              long l1 = 1L;
              continue;
              if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                localEntityManager.update(paramFromServiceMsg);
              }
            }
          }
        }
      }
      boolean bool2 = false;
      if (((cmd0x9c9.RspBody)localObject).str_errorinfo.has()) {}
      for (paramToServiceMsg = ((cmd0x9c9.RspBody)localObject).str_errorinfo.get();; paramToServiceMsg = "")
      {
        paramObject = null;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
        break;
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    NearbyCmdHelper.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i == 1)
          {
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (localRspBody.msg_notify_event.has())
            {
              localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
              localObject1 = localObject3;
            }
          }
        }
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(61, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          AppIntefaceReportWrap.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyCardHandler", 2, paramToServiceMsg, new Object[0]);
      }
    }
  }
  
  /* Error */
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1131	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2306
    //   7: invokevirtual 257	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 1131	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc_w 2308
    //   21: invokevirtual 317	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   24: lstore 8
    //   26: invokestatic 980	android/os/SystemClock:elapsedRealtime	()J
    //   29: lstore 10
    //   31: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc_w 650
    //   40: iconst_2
    //   41: new 200	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 2310
    //   51: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 2313	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   58: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   70: ifeq +311 -> 381
    //   73: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   76: lstore 6
    //   78: aload_2
    //   79: invokevirtual 2313	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   82: istore 4
    //   84: aload_2
    //   85: invokevirtual 1161	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   88: ifeq +220 -> 308
    //   91: aload_3
    //   92: instanceof 1225
    //   95: ifeq +213 -> 308
    //   98: iconst_1
    //   99: istore 13
    //   101: iload 13
    //   103: ifeq +273 -> 376
    //   106: aload_0
    //   107: aload_2
    //   108: invokevirtual 2316	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   111: ldc_w 2318
    //   114: new 1479	SummaryCard/RespHead
    //   117: dup
    //   118: invokespecial 2319	SummaryCard/RespHead:<init>	()V
    //   121: invokevirtual 1521	com/tencent/mobileqq/nearby/business/NearbyCardHandler:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 1479	SummaryCard/RespHead
    //   127: astore 14
    //   129: aload 14
    //   131: ifnull +183 -> 314
    //   134: aload 14
    //   136: getfield 2322	SummaryCard/RespHead:iResult	I
    //   139: ifne +175 -> 314
    //   142: iconst_1
    //   143: istore 12
    //   145: aload 14
    //   147: astore_2
    //   148: iload 12
    //   150: istore 13
    //   152: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +50 -> 205
    //   158: new 200	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 2324
    //   168: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: astore 15
    //   173: aload 14
    //   175: ifnonnull +145 -> 320
    //   178: ldc_w 2326
    //   181: astore_2
    //   182: ldc_w 650
    //   185: iconst_2
    //   186: aload 15
    //   188: aload_2
    //   189: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: iload 12
    //   200: istore 13
    //   202: aload 14
    //   204: astore_2
    //   205: aload_0
    //   206: iload 13
    //   208: aload_3
    //   209: aload_1
    //   210: getfield 1131	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   213: aload_2
    //   214: invokespecial 2328	com/tencent/mobileqq/nearby/business/NearbyCardHandler:a	(ZLjava/lang/Object;Landroid/os/Bundle;LSummaryCard/RespHead;)V
    //   217: new 2129	java/util/HashMap
    //   220: dup
    //   221: invokespecial 2130	java/util/HashMap:<init>	()V
    //   224: astore_1
    //   225: aload_1
    //   226: ldc_w 2132
    //   229: iload 4
    //   231: invokestatic 2134	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   234: invokevirtual 2137	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: invokestatic 2143	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   241: invokestatic 2149	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   244: aload_0
    //   245: getfield 15	com/tencent/mobileqq/nearby/business/NearbyCardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   248: invokevirtual 2152	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   251: ldc_w 2330
    //   254: iload 13
    //   256: lload 10
    //   258: lload 8
    //   260: lsub
    //   261: lconst_0
    //   262: aload_1
    //   263: ldc_w 499
    //   266: invokevirtual 2158	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   269: invokestatic 648	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   272: ifeq -259 -> 13
    //   275: ldc_w 650
    //   278: iconst_4
    //   279: new 200	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 2332
    //   289: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   295: lload 6
    //   297: lsub
    //   298: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   301: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: iconst_0
    //   309: istore 13
    //   311: goto -210 -> 101
    //   314: iconst_0
    //   315: istore 12
    //   317: goto -172 -> 145
    //   320: aload 14
    //   322: getfield 2322	SummaryCard/RespHead:iResult	I
    //   325: istore 5
    //   327: iload 5
    //   329: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: astore_2
    //   333: goto -151 -> 182
    //   336: astore 14
    //   338: aconst_null
    //   339: astore_2
    //   340: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +15 -> 358
    //   346: ldc_w 650
    //   349: iconst_2
    //   350: aload 14
    //   352: invokevirtual 1062	java/lang/Exception:toString	()Ljava/lang/String;
    //   355: invokestatic 655	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: iconst_0
    //   359: istore 13
    //   361: goto -156 -> 205
    //   364: astore 15
    //   366: aload 14
    //   368: astore_2
    //   369: aload 15
    //   371: astore 14
    //   373: goto -33 -> 340
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -173 -> 205
    //   381: lconst_0
    //   382: lstore 6
    //   384: goto -306 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	this	NearbyCardHandler
    //   0	387	1	paramToServiceMsg	ToServiceMsg
    //   0	387	2	paramFromServiceMsg	FromServiceMsg
    //   0	387	3	paramObject	Object
    //   82	148	4	i	int
    //   325	3	5	j	int
    //   76	307	6	l1	long
    //   24	235	8	l2	long
    //   29	228	10	l3	long
    //   143	173	12	bool1	boolean
    //   99	261	13	bool2	boolean
    //   127	194	14	localRespHead	SummaryCard.RespHead
    //   336	31	14	localException1	Exception
    //   371	1	14	localObject	Object
    //   171	16	15	localStringBuilder	StringBuilder
    //   364	6	15	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   106	129	336	java/lang/Exception
    //   134	142	364	java/lang/Exception
    //   152	173	364	java/lang/Exception
    //   182	198	364	java/lang/Exception
    //   320	327	364	java/lang/Exception
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool1 = bool4;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool1 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool3 = true;
          }
          bool2 = bool3;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            bool1 = bool3;
            QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool2 = bool3;
          }
        }
        if (!bool2) {
          break label254;
        }
        bool1 = bool2;
        paramToServiceMsg = ((UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray())).msg_verify_video_info.get();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          bool2 = bool1;
          bool1 = bool2;
          paramToServiceMsg = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_auth_video", 2, paramFromServiceMsg.toString());
            bool1 = bool2;
            paramToServiceMsg = localObject;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      bool1 = bool2;
    }
    for (;;)
    {
      notifyUI(47, bool1, paramToServiceMsg);
      return;
      label254:
      bool1 = false;
      paramToServiceMsg = localObject;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    notifyUI(49, bool1, null);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool2 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool1 = true;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool3 = bool1;
          }
        }
        bool1 = bool3;
        if (bool3) {}
        bool1 = bool3;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        try
        {
          NearbyCardManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          bool1 = bool3;
          notifyUI(46, bool1, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          break label194;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool3 = bool2;
      }
      label194:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
        bool1 = bool3;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    notifyUI(48, bool1, localToServiceMsg);
  }
  
  /* Error */
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 2390
    //   21: iconst_2
    //   22: new 200	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2392
    //   32: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 1161	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 855	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 1161	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 1142	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 2173	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 1535	[B
    //   92: checkcast 1535	[B
    //   95: invokevirtual 2174	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1142	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 2175	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 1939	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 2175	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 2390
    //   139: iconst_2
    //   140: new 200	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 2394
    //   150: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 2175	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 2341	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 2342	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 1145	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 358	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 359	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 2343	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 2341	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 1148	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 2375	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 713	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 2378	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 2381	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 2384	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 2387	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 1156	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 200	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 2396
    //   283: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 557	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 560 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 563 2 0
    //   319: checkcast 2349	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 2398
    //   328: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 2401	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 2403
    //   345: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 2406	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 286	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 2408
    //   362: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 2411	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 388	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 2413
    //   379: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 2415
    //   396: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 2417
    //   408: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 2419
    //   420: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 2421
    //   432: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 1408	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 2390
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 1125	com/tencent/mobileqq/nearby/business/NearbyCardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 760	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 2390
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 2351	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 793	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	NearbyCardHandler
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i	int
    //   123	3	5	j	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp))) {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    paramFromServiceMsg = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramFromServiceMsg.putString("targetUin", Long.toString(l1));
    paramFromServiceMsg.putString("selfUin", Long.toString(l2));
    paramFromServiceMsg.putInt("favoriteSource", i);
    paramFromServiceMsg.putInt("iCount", j);
    paramFromServiceMsg.putInt("from", k);
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
      }
      for (;;)
      {
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            paramObject.likeCount += j;
            paramObject.bVoted = 1;
            paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
            if (paramObject.bAvailVoteCnt < 0) {
              paramObject.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.update(paramObject);
          }
          VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, j);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + j);
        }
        notifyUI(32, bool1, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramObject.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (localObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label537:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (localObject == null) {
        break label614;
      }
    }
    label614:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramObject.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label537;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() != 4) {
        break;
      }
      a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = LbsUtils.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.f());
    localObject1 = createToServiceMsg("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "reqCharmEvent() uin=" + ((ToServiceMsg)localObject1).getUin() + ", type=" + paramInt + ", seqNum=" + i);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    NearbyCmdHelper.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, uin=" + paramLong1 + ", tinyId=" + paramLong2 + ", from=" + paramInt);
    }
    Object localObject2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, skey==null, return");
      }
      return;
    }
    Object localObject1 = new oidb_0x8e7.ReqBody();
    ((oidb_0x8e7.ReqBody)localObject1).bool_stock.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_is_first.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_warn.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_update_url.set(true);
    if (paramLong1 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_uin.set(paramLong1);
    }
    for (;;)
    {
      oidb_0x8e7.LoginSig localLoginSig = new oidb_0x8e7.LoginSig();
      localLoginSig.uint32_type.set(1);
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      localObject2 = new oidb_0x8e7.ExtParam();
      ((oidb_0x8e7.ExtParam)localObject2).uint32_client.set(1);
      ((oidb_0x8e7.ExtParam)localObject2).uint32_portal.set(paramInt);
      ((oidb_0x8e7.ExtParam)localObject2).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
      ((oidb_0x8e7.ExtParam)localObject2).msg_login_sig.set(localLoginSig);
      ((oidb_0x8e7.ReqBody)localObject1).msg_ext_parm.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x8e7_1", 2279, 1, ((oidb_0x8e7.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("uin", paramLong1 + "");
      ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      if (paramLong2 > 0L) {
        ((oidb_0x8e7.ReqBody)localObject1).uint64_tinyid.set(paramLong2);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("nearbyPeopleLike|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void a(Bundle paramBundle, ArrayList<PicInfo> paramArrayList, InterestTag[] paramArrayOfInterestTag, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject2;
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject2 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      for (paramBoolean3 = false; localIterator.hasNext(); paramBoolean3 = true)
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.jdField_a_of_type_Int < 0) {
          break label2404;
        }
        localObject1 = new UpdatePhotoList.RichHead();
        ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(localPicInfo.f)) {
          ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.f);
        }
        if (localObject1 == null) {
          break label2401;
        }
        ((UpdatePhotoList.ReqBody)localObject2).rpt_msg_rich_headids.add((MessageMicro)localObject1);
      }
      label154:
      if (paramBoolean3)
      {
        localObject1 = LbsUtils.a(getClass().getSimpleName());
        if (localObject1 != null) {
          ((UpdatePhotoList.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editProfileCard, photoList = " + paramArrayList + ", isHasNearbyAvatar = " + paramBoolean3);
      }
    }
    for (;;)
    {
      int j;
      int i;
      if ((paramArrayOfInterestTag != null) && (paramArrayOfInterestTag.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        j = paramArrayOfInterestTag.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfInterestTag[i];
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((InterestTag)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < paramArrayOfInterestTag.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfInterestTag[i].toString()).append(",");
            i += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfInterestTag = (InterestTag[])localObject1;; paramArrayOfInterestTag = null)
      {
        i = 0;
        j = 0;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("nick"))
          {
            i = 1;
            localObject1 = paramBundle.getString("nick");
            localReqBody.str_nick.set((String)localObject1);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_nick|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("sex"))
          {
            j += 1;
            k = paramBundle.getByte("sex") + 1;
            localReqBody.uint32_gender.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gender|" + k);
                i = j;
              }
            }
          }
          int k = i;
          if (paramBundle.containsKey("college"))
          {
            i += 1;
            localObject1 = paramBundle.getString("college");
            localReqBody.str_college.set((String)localObject1);
            k = i;
            if (NearbyCardConstants.a)
            {
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_college|" + (String)localObject1);
                k = i;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_constellation"))
          {
            i = k + 1;
            k = paramBundle.getInt("key_constellation");
            localReqBody.uint32_constellation.set(k);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_constellation|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("birthday"))
          {
            j += 1;
            k = paramBundle.getInt("birthday");
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(k)));
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "bytes_birthday|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("hometown"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("hometown");
            j = 0;
            while (j < 3)
            {
              PkgTools.copyData((byte[])localObject2, j * 4, PkgTools.intToBytes2(ConditionSearchManager.a(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(j)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              j = 0;
              while (j < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[j]).append(", ");
                j += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_city_id|" + ((StringBuilder)localObject2).toString());
            }
            j = i + 2;
          }
          k = j;
          if (paramBundle.containsKey("location"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("location");
            i = 0;
            while (i < 3)
            {
              PkgTools.copyData((byte[])localObject2, i * 4, PkgTools.intToBytes2(ConditionSearchManager.a(localObject1[i])), 4);
              i += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            i = ConditionSearchManager.a(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(i)));
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[i]).append(", ");
                i += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_location|" + ((StringBuilder)localObject2).toString());
            }
            k = j + 2;
          }
          i = k;
          if (paramBundle.containsKey("age"))
          {
            j = k + 1;
            i = paramBundle.getInt("age");
            localReqBody.uint32_age.set(i);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "set birthday|age = " + paramBundle.getInt("age"));
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("company"))
          {
            i += 1;
            localObject1 = paramBundle.getString("company");
            localReqBody.str_company.set((String)localObject1);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_company|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_new_nickname"))
          {
            j += 1;
            localObject1 = paramBundle.getString("key_new_nickname");
            localReqBody.str_stranger_nick.set((String)localObject1);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_stranger_nick|" + (String)localObject1);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_xuan_yan"))
          {
            localObject1 = paramBundle.getByteArray("key_xuan_yan");
            if (localObject1 != null) {
              localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
            }
            if ((NearbyCardConstants.a) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder().append("str_stranger_declare|");
              if (localObject1 != null) {
                break label2356;
              }
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
            j = i + 1;
          }
          i = j;
          if (paramBundle.containsKey("key_marital_status"))
          {
            j += 1;
            k = paramBundle.getByte("key_marital_status");
            localReqBody.uint32_love_status.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_love_status|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("profession"))
          {
            int m = paramBundle.getInt("profession");
            k = i;
            if (NearbyProfileUtil.a(m))
            {
              k = i + 1;
              localReqBody.uint32_profession.set(m);
            }
            j = k;
            if (NearbyCardConstants.a)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_profession|" + m);
                j = k;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_qzone_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_qzone_switch");
            localReqBody.uint32_qzone_visible.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_qzone_visible|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_hobby_switch"))
          {
            i += 1;
            k = paramBundle.getShort("key_hobby_switch");
            localReqBody.uint32_interest_visible.set(k);
            j = i;
            if (NearbyCardConstants.a)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_interest_visible|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_flower_visible_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_flower_visible_switch");
            localReqBody.uint32_gift_visible.set(k);
            i = j;
            if (NearbyCardConstants.a)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gift_visible|" + k);
                i = j;
              }
            }
          }
        }
        localReqBody.uint32_stranger_profile_flag.set(1);
        if (paramBoolean3) {
          localReqBody.uint32_face_flag.set(1);
        }
        localReqBody.uint32_guide_flag.set(0);
        if ((NearbyCardConstants.a) && (QLog.isColorLevel())) {
          QLog.d("Q.nearby_people_card.", 2, "fieldCount|" + (i + 1));
        }
        if (paramBoolean4)
        {
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_1", 2505, 1, localReqBody.toByteArray());
          label2246:
          if (paramBundle != null) {
            ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
          }
          if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
            ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
          }
          paramArrayList = ((ToServiceMsg)localObject1).extraData;
          if (paramArrayOfInterestTag != null) {
            break label2388;
          }
        }
        label2356:
        label2388:
        for (paramBundle = null;; paramBundle = paramArrayOfInterestTag.toByteArray())
        {
          paramArrayList.putByteArray("9c7_body", paramBundle);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
          ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
          sendPbReq((ToServiceMsg)localObject1);
          return;
          localObject1 = Integer.valueOf(localObject1.length);
          break;
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
          break label2246;
        }
      }
      label2401:
      break label154;
      label2404:
      localObject1 = null;
      break;
      paramBoolean3 = false;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.now", 2, "handleNotifyFaceChange req == null || res == null");
      }
      return;
    }
    paramToServiceMsg = new cmd0xb5b.RspBody();
    parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.i("Q.nearby.now", 1, "handleNotifyFaceChange code:" + paramToServiceMsg.result.get() + "   " + paramToServiceMsg.err_msg.get());
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getRandomUserInfo| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    notifyUI(10, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = createToServiceMsg("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            sendPbReq((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyCardHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = makeOIDBPkg("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.updateNearbyPeopleAuthVideo(), videoId = " + paramString + ",photoId =" + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    if (paramBoolean)
    {
      localOIDBSSOPkg.uint32_service_type.set(6);
      localOIDBSSOPkg.uint32_result.set(0);
      UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
      UpdatePhotoList.RichHead localRichHead = new UpdatePhotoList.RichHead();
      localRichHead.uint32_headid.set(paramInt);
      localRichHead.str_video_id.set(paramString);
      localReqBody.msg_verify_video_info.set(localRichHead);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (paramString = createToServiceMsg("OidbSvc.0x5ea_6");; paramString = createToServiceMsg("OidbSvc.0x5ea_7"))
    {
      paramString.setTimeout(30000L);
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      sendPbReq(paramString);
      return;
      localOIDBSSOPkg.uint32_service_type.set(7);
      break;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    nearby_ice_break.IceReq localIceReq = new nearby_ice_break.IceReq();
    try
    {
      localIceReq.uin.set(Long.parseLong(paramString));
      localIceReq.tinyid.set(String.valueOf(paramLong));
      new CsTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(13569).b(1).a(new NearbyCardHandler.4(this)).a(new NearbyCardHandler.3(this)).a(localIceReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("NearbyCardHandler", 1, "sendPoBingMsg. error=" + QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6, boolean paramBoolean3, long paramLong7, int paramInt3)
  {
    long l1 = a(paramString1);
    long l2 = a(paramString2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean1).append(",uLikeSource = ").append(paramLong6);
      QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
    }
    paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
    paramString1.extraData.putLong("selfUin", l1);
    paramString1.extraData.putLong("targetUin", l2);
    paramString1.extraData.putInt("comeFromType", paramInt1);
    paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
    paramString1.extraData.putByte("isFriend", paramByte);
    paramString1.extraData.putLong("troopCode", paramLong2);
    paramString1.extraData.putLong("troopUin", paramLong3);
    paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
    paramString1.extraData.putString("strSearchName", paramString3);
    paramString1.extraData.putLong("lGetControl", paramLong4);
    paramString1.extraData.putInt("bReqCommLabel", 1);
    paramString1.extraData.putInt("EAddFriendSource", paramInt2);
    paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
    paramString1.extraData.putLong("tinyId", paramLong5);
    paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
    paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
    paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
    paramString1.extraData.putLong("likeSource", paramLong6);
    paramString1.extraData.putLong("nowId", paramLong7);
    paramString1.extraData.putInt("nowUserType", paramInt3);
    if (paramBoolean3)
    {
      send(paramString1);
      return;
    }
    a(paramLong7, paramInt3, paramInt1, paramLong5, paramString2, paramByte, paramString1);
  }
  
  public void a(ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = createToServiceMsg("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    sendPbReq(paramArrayList);
  }
  
  public void a(ArrayList<NearbyLikeLimitManager.LikeItem> paramArrayList, int paramInt)
  {
    int j = 0;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("nearbyPeopleLikeNew, reqList.size=");
      if (paramArrayList == null)
      {
        i = 0;
        QLog.d("NearbyLikeLimitManager", 2, i + ", from=" + paramInt);
      }
    }
    else
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList is empty, return");
      }
    }
    label92:
    Object localObject2;
    label142:
    do
    {
      do
      {
        return;
        i = paramArrayList.size();
        break;
        localObject2 = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label142;
        }
      } while (!QLog.isColorLevel());
      QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, skey is empty, return");
      return;
      localObject1 = new oidb_0x8e6.ReqBody();
      ((oidb_0x8e6.ReqBody)localObject1).uint32_portal.set(paramInt);
      ((oidb_0x8e6.ReqBody)localObject1).uint32_client.set(1);
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.f().getBytes()));
      Object localObject3 = new oidb_0x8e6.LoginSig();
      ((oidb_0x8e6.LoginSig)localObject3).uint32_type.set(1);
      ((oidb_0x8e6.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      ((oidb_0x8e6.ReqBody)localObject1).msg_login_sig.set((MessageMicro)localObject3);
      localObject3 = new ArrayList();
      int k = paramArrayList.size();
      localObject2 = new StringBuilder();
      i = j;
      while (i < k)
      {
        NearbyLikeLimitManager.LikeItem localLikeItem = (NearbyLikeLimitManager.LikeItem)paramArrayList.get(i);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(localLikeItem).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(localLikeItem.jdField_a_of_type_Long);
        localVoteInfo.uint32_free_vote_count.set(localLikeItem.jdField_a_of_type_Int);
        localVoteInfo.uint32_pay_vote_count.set(localLikeItem.jdField_b_of_type_Int);
        localVoteInfo.uint32_source.set(localLikeItem.d);
        ((ArrayList)localObject3).add(localVoteInfo);
        i += 1;
      }
      ((oidb_0x8e6.ReqBody)localObject1).rpt_vote_info.set((List)localObject3);
      paramArrayList = makeOIDBPkg("OidbSvc.0x8e6_1", 2278, 1, ((oidb_0x8e6.ReqBody)localObject1).toByteArray());
      paramArrayList.extraData.putInt("from", paramInt);
      sendPbReq(paramArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList=[" + ((StringBuilder)localObject2).toString() + "]");
  }
  
  public void a(List<InterestTag> paramList, int paramInt1, int paramInt2)
  {
    NearbyCmdHelper.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean)
  {
    cmd0xb5b.ReqBody localReqBody = new cmd0xb5b.ReqBody();
    PBUInt32Field localPBUInt32Field = localReqBody.is_review;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      sendPbReq(makeOIDBPkg("OidbSvc.0xb5b", 2907, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    oidb_0x5eb.RspBody localRspBody;
    String str;
    int k;
    int m;
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      localRspBody = new oidb_0x5eb.RspBody();
      paramObject = null;
      str = "";
      k = -1;
      m = 0;
      if (paramToServiceMsg.bytes_rspbody_5eb.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg);
      int j = m;
      int i = k;
      paramFromServiceMsg = str;
      paramToServiceMsg = paramObject;
      if (localRspBody.rpt_msg_uin_data.has())
      {
        j = m;
        i = k;
        paramFromServiceMsg = str;
        paramToServiceMsg = paramObject;
        if (localRspBody.rpt_msg_uin_data.size() > 0)
        {
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0);
          paramToServiceMsg = Long.valueOf(paramObject.uint64_uin.get());
          paramFromServiceMsg = paramObject.bytes_stranger_nick.get().toStringUtf8();
          i = paramObject.uint32_gender.get();
          j = paramObject.uint32_age.get();
        }
      }
      notifyUI(13, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      if (QLog.isDevelopLevel()) {
        QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo---->uin =" + paramToServiceMsg + "nickName = " + paramFromServiceMsg + " gender = " + i + "age =" + j);
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
        }
      }
    }
    notifyUI(13, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x8e7.RspBody localRspBody = new oidb_0x8e7.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin", "");
    int j = paramToServiceMsg.extraData.getInt("from", 509);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, uin=" + paramFromServiceMsg + ", ret=" + i);
    }
    if (i == 0)
    {
      for (;;)
      {
        oidb_0x8e7.UserZanInfo localUserZanInfo;
        long l;
        try
        {
          paramToServiceMsg = new NearbyLikeLimitManager.LimitInfo();
          paramToServiceMsg.jdField_a_of_type_JavaLangString = localRspBody.bytes_recharge_url.get().toStringUtf8();
          paramToServiceMsg.jdField_b_of_type_JavaLangString = localRspBody.bytes_update_url.get().toStringUtf8();
          if (localRspBody.msg_zan_limit.has())
          {
            Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
            paramToServiceMsg.jdField_a_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
            paramToServiceMsg.c = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
            paramToServiceMsg.d = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
            paramToServiceMsg.jdField_b_of_type_Int = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
            paramToServiceMsg.f = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
            paramObject = new ArrayList();
            if (!((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.has()) {
              break;
            }
            localObject = ((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localUserZanInfo = (oidb_0x8e7.UserZanInfo)((Iterator)localObject).next();
            NearbyLikeLimitManager.LikeItem localLikeItem = new NearbyLikeLimitManager.LikeItem();
            l = 0L;
            if (localUserZanInfo.uint64_uin.has())
            {
              l = localUserZanInfo.uint64_uin.get();
              localLikeItem.jdField_a_of_type_Long = l;
              localLikeItem.jdField_a_of_type_Int = ((int)localUserZanInfo.uint64_free_zan.get());
              localLikeItem.jdField_b_of_type_Int = ((int)localUserZanInfo.uint64_pay_zan.get());
              localLikeItem.c = ((int)localUserZanInfo.uint64_pay_stock.get());
              if (l <= 0L) {
                continue;
              }
              paramObject.add(localLikeItem);
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(16, false, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, " + paramToServiceMsg.toString());
          }
        }
        if (localUserZanInfo.uint64_tinyid.has()) {
          l = localUserZanInfo.uint64_tinyid.get();
        }
      }
      if (localRspBody.msg_warn.has()) {
        paramToServiceMsg.jdField_a_of_type_TencentImOidbOidb_0x8e7Oidb_0x8e7$WarnMsg = ((oidb_0x8e7.WarnMsg)localRspBody.msg_warn.get());
      }
      if (localRspBody.msg_stock_rsp.has()) {
        paramToServiceMsg.e = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
      }
      ((NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(paramToServiceMsg, paramObject, j);
      notifyUI(16, true, paramFromServiceMsg);
      return;
    }
    notifyUI(16, false, paramFromServiceMsg);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("from", 0);
    Object localObject1 = new oidb_0x8e6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew, ret=" + i + ", from=" + j);
    }
    paramToServiceMsg = new ArrayList();
    if (i == 0)
    {
      int k = ((oidb_0x8e6.RspBody)localObject1).uint32_level.get();
      int m = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_user_count.get();
      int n = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_count.get();
      ((oidb_0x8e6.RspBody)localObject1).uint32_remain_total.get();
      paramFromServiceMsg = (NearbyLikeLimitManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
      paramObject = ((oidb_0x8e6.RspBody)localObject1).rpt_vote_result.get();
      int i1 = paramObject.size();
      i = 0;
      while (i < i1)
      {
        Object localObject2 = (oidb_0x8e6.VoteResult)paramObject.get(i);
        localObject1 = new NearbyLikeLimitManager.LikeResultItem();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_ret.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_JavaLangString = ((oidb_0x8e6.VoteResult)localObject2).bytes_err_msg.get().toStringUtf8();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long = ((oidb_0x8e6.VoteResult)localObject2).uint64_uin.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_b_of_type_Int = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_free_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).c = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_pay_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).d = ((oidb_0x8e6.VoteResult)localObject2).uint32_vote_count.get();
        ((NearbyLikeLimitManager.LikeResultItem)localObject1).e = ((int)((oidb_0x8e6.VoteResult)localObject2).uint64_pay_stock.get());
        paramToServiceMsg.add(localObject1);
        int i2 = ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_b_of_type_Int;
        i2 = ((NearbyLikeLimitManager.LikeResultItem)localObject1).c + i2;
        if ((((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Int == 0) && (((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long > 0L) && (i2 > 0))
        {
          VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long, i2);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long) });
          if (localNearbyPeopleCard != null)
          {
            localNearbyPeopleCard.likeCount += i2;
            localNearbyPeopleCard.bVoted = 1;
            localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
            if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
              localNearbyPeopleCard.bAvailVoteCnt = 0;
            }
            ((EntityManager)localObject2).update(localNearbyPeopleCard);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + localObject1);
        }
        paramFromServiceMsg.a(((NearbyLikeLimitManager.LikeResultItem)localObject1).jdField_a_of_type_Long + "", true);
        i += 1;
      }
      paramFromServiceMsg.a(k, m, n);
      notifyUI(17, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    notifyUI(17, false, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
  }
  
  public Set<String> getCommandList()
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c8_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c5_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c9_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9c7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x682");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x686");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_a_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ea_7");
      this.jdField_a_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e6_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8e7_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xb5b");
    }
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return NearbyCardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (msgCmdFilter(paramFromServiceMsg.getServiceCmd()));
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x9c9_0".equals(str)) || ("OidbSvc.0x9c9_1".equals(str)))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c7_0".equals(str))
      {
        NearbyCmdHelper.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e7_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e6_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb5b".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler
 * JD-Core Version:    0.7.0.1
 */