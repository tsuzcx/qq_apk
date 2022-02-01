package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicPreDownload.ConfigInfo;
import com.tencent.mobileqq.pic.api.impl.PicHelperImpl;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PreDownloadStrategyBeta
  extends BaseStrategy
{
  public static String a = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
  public long A;
  public long B = -1L;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N = 0L;
  public long O = 2147483647L;
  public long P = 2147483647L;
  public long Q = 2147483647L;
  public long R = 2147483647L;
  public long S;
  public TroopStatisticsCache a;
  private GIFPreDownloadLimit a;
  public PicStatisticsManager a;
  public Long a;
  public AtomicBoolean a;
  public long[] a;
  private AppInterface b;
  public boolean b;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  public PreDownloadStrategyBeta()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(100L);
  }
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.l;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l2;
    long l1;
    long l3;
    long l4;
    if (paramInt == 1)
    {
      l2 = this.z;
      l1 = this.A;
      this.z = (paramLong1 + l2);
      this.A = (paramLong2 + l1);
      paramLong2 = this.z;
      l3 = this.r;
      paramLong1 = paramLong2;
      if (paramLong2 > l3) {
        paramLong1 = l3;
      }
      this.z = paramLong1;
      paramLong2 = this.z;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.z = paramLong1;
      paramLong2 = this.A;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.A = paramLong1;
      l4 = this.z;
      l3 = this.A;
      PicPreDownloadUtils.a("4gFlowPre", l4, false);
      PicPreDownloadUtils.a("4gFlowWaste", this.A, paramBoolean);
      paramLong1 = l2;
      paramLong2 = l1;
      l1 = l4;
      l2 = l3;
    }
    else
    {
      l3 = this.B;
      l4 = this.C;
      this.B = (paramLong1 + l3);
      this.C = (paramLong2 + l4);
      paramLong2 = this.B;
      l1 = this.x;
      paramLong1 = paramLong2;
      if (paramLong2 > l1) {
        paramLong1 = l1;
      }
      this.B = paramLong1;
      paramLong2 = this.B;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.B = paramLong1;
      paramLong2 = this.C;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.C = paramLong1;
      l1 = this.B;
      l2 = this.C;
      PicPreDownloadUtils.a("xgFlowPre", l1, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.C, paramBoolean);
      paramLong2 = l4;
      paramLong1 = l3;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("networkType=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", preFlowPre=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" preFlowWaste=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("flowPre=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", flowWaste:");
      localStringBuilder.append(l2);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", localStringBuilder.toString());
    }
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    a(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      this.K += 1L;
      PicPreDownloadUtils.a("wifiHitCount", this.K, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.K);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", localStringBuilder.toString());
      }
    }
    else
    {
      paramLong = a(paramLong);
      a(paramInt1, this.i * paramLong / 100L, -paramLong, false);
      this.G += 1L;
      this.E -= paramLong;
      PicPreDownloadUtils.a("accFlowWasteTotal", this.E, false);
      PicPreDownloadUtils.a("xgHitCount", this.G, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.G);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", localStringBuilder.toString());
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("accFlowPreTotal:");
        paramMessageForPic.append(this.D);
        paramMessageForPic.append(",accFlowWasteTotal:");
        paramMessageForPic.append(this.E);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", paramMessageForPic.toString());
      }
    }
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_b_of_type_ComTencentCommonAppAppInterface;
    if ((localObject != null) && (!TextUtils.isEmpty(((AppInterface)localObject).getAccount())))
    {
      localObject = ((PicPreDownloadImpl)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
      if ((paramMessageForPic.mNotPredownloadReason != 0) && (paramMessageForPic.mNotPredownloadReason != 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
        if (paramMessageForPic.mNotPredownloadReason != -1) {
          this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.c(paramInt1, paramInt2);
        }
      }
      else
      {
        int i1 = ((PicPreDownloader)localObject).a(paramMessageForPic);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.e(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.c(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.L += 1L;
      PicPreDownloadUtils.a("wifiMissCount", this.L, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",wifiMissCount:");
      ((StringBuilder)localObject).append(this.L);
      ((StringBuilder)localObject).append(",uniseq:");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", ((StringBuilder)localObject).toString());
      return;
    }
    a(paramInt1, this.j, 0L, false);
    this.H += 1L;
    PicPreDownloadUtils.a("xgMissCount", this.H, true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", xgMissCount:");
      ((StringBuilder)localObject).append(this.H);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    a(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.K);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", localStringBuilder.toString());
      }
    }
    else
    {
      a(paramInt1, this.k, 0L, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.G);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", localStringBuilder.toString());
      }
    }
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.d(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    a(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.K);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", localStringBuilder.toString());
      }
    }
    else
    {
      a(paramInt1, this.k, 0L, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.G);
        localStringBuilder.append(", uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", localStringBuilder.toString());
      }
    }
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicGIFPreDownloadLimit == null) {
        this.jdField_a_of_type_ComTencentMobileqqPicGIFPreDownloadLimit = new GIFPreDownloadLimit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    Object localObject1 = PicPreDownloadUtils.a("flowCombination", "12000|600|20000|400|6000|300|20000|200");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): PicPreDownloadFlow=");
      localStringBuilder.append((String)localObject1);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localStringBuilder.toString());
    }
    int i1 = 0;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length == 8)
      {
        this.n = (Integer.valueOf(localObject1[0]).intValue() * 1024);
        this.p = (Integer.valueOf(localObject1[1]).intValue() * 1024);
        this.o = (Integer.valueOf(localObject1[2]).intValue() * 1024);
        this.q = (Integer.valueOf(localObject1[3]).intValue() * 1024);
        this.t = (Integer.valueOf(localObject1[4]).intValue() * 1024);
        this.v = (Integer.valueOf(localObject1[5]).intValue() * 1024);
        this.u = (Integer.valueOf(localObject1[6]).intValue() * 1024);
        this.w = (Integer.valueOf(localObject1[7]).intValue() * 1024);
        break label310;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): Error, use Server config");
    }
    this.t = PicPreDownloadUtils.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, "AMaxPDFlow3G", 614400L);
    this.u = PicPreDownloadUtils.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, "AMaxWFlow3G", 716800L);
    this.v = 0L;
    this.w = 0L;
    this.n = this.t;
    this.p = 0L;
    this.o = this.u;
    this.q = 0L;
    label310:
    this.r = (this.n + this.p);
    this.s = (this.o + this.q);
    this.x = (this.t + this.v);
    this.y = (this.u + this.w);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initConfig():_4gFlowPreLimit=");
      ((StringBuilder)localObject1).append(this.n);
      ((StringBuilder)localObject1).append(" _4gFlowWasteLimit=");
      ((StringBuilder)localObject1).append(this.o);
      ((StringBuilder)localObject1).append(" _4gFlowPreFloatLimit");
      ((StringBuilder)localObject1).append(this.p);
      ((StringBuilder)localObject1).append(" _4gFlowWasteFloatLimit=");
      ((StringBuilder)localObject1).append(this.q);
      ((StringBuilder)localObject1).append(" xgFlowPreLimit=");
      ((StringBuilder)localObject1).append(this.t);
      ((StringBuilder)localObject1).append(" xgFlowWasteLimit=");
      ((StringBuilder)localObject1).append(this.u);
      ((StringBuilder)localObject1).append(" xgFlowPreFloatLimit=");
      ((StringBuilder)localObject1).append(this.v);
      ((StringBuilder)localObject1).append(" xgFlowWasteFloatLimit=");
      ((StringBuilder)localObject1).append(this.w);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = PicPreDownloadUtils.a("troopCombination", "20|10|50|10");
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): PicPredownloadConfig=");
      localStringBuilder.append((String)localObject1);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, localStringBuilder.toString());
    }
    if (localObject1 != null) {}
    try
    {
      if (!"".equals(localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length >= 4)
        {
          this.O = Long.parseLong(localObject1[0]);
          this.P = Long.parseLong(localObject1[1]);
          this.Q = Long.parseLong(localObject1[2]);
          this.R = (Long.parseLong(localObject1[3]) * 1024L);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          break label695;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadConfig Error, use default config");
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localException.getMessage());
      }
    }
    label695:
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initConfig(): troopDefaultCount=");
      ((StringBuilder)localObject2).append(this.O);
      ((StringBuilder)localObject2).append(", troopIncreaseCountEnterAIO=");
      ((StringBuilder)localObject2).append(this.P);
      ((StringBuilder)localObject2).append(", troopMaxCount=");
      ((StringBuilder)localObject2).append(this.Q);
      ((StringBuilder)localObject2).append(", troopMinPicSize=");
      ((StringBuilder)localObject2).append(this.R);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(PicPreDownloadUtils.a("maxRequest", 100L));
    this.h = PicPreDownloadUtils.a("xGPreDownPolicy", 1374942199L);
    this.i = PicPreDownloadUtils.a("AFBFlowHitXG", 150L);
    this.j = PicPreDownloadUtils.a("AFBFlowMissXG", 40960L);
    this.k = this.j;
    this.l = PicPreDownloadUtils.a("APicAvgSize", 71680L);
    this.m = PicPreDownloadUtils.a("APicMaxSize", 204800L);
    this.jdField_b_of_type_Boolean = PicPreDownloadUtils.a("enablePeakFlow", Boolean.valueOf(true)).booleanValue();
    this.jdField_a_of_type_ArrayOfLong = PicPreDownloadUtils.a();
    this.S = PicPreDownloadUtils.a("PeakFlowMaxPicSize", 921600L);
    if (QLog.isColorLevel())
    {
      int i2 = this.jdField_a_of_type_ArrayOfLong.length;
      if ((i2 != 0) && ((i2 & 0x1) == 0))
      {
        localObject2 = new StringBuilder();
        while (i1 < i2)
        {
          ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[i1]));
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[(i1 + 1)]));
          ((StringBuilder)localObject2).append(" ");
          i1 += 2;
        }
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Error(Length=");
        ((StringBuilder)localObject2).append(i2);
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): xGPreDownPolicy=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" xgFlowHitFeedback=");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" XgFlowMissFeedback=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(" XgFlowLeftRightFeddback=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" pisSizeAvg=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" pisSizeMax=");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" mEnablePeakFlow=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" mPeakFlowTimePeriod=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" mPeakFlowMaxPicSize=");
      localStringBuilder.append(this.S);
      localStringBuilder.append(", mRequestListMaxSize=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return PicPreDownloadUtils.a();
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i1 = super.a(paramLong, paramInt1, paramInt2, paramBoolean, paramInt3);
    if (i1 != 0) {
      return i1;
    }
    boolean bool2 = GIFPreDownloadLimit.a(null, paramBoolean, paramInt3);
    boolean bool1 = false;
    if (bool2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicGIFPreDownloadLimit == null) {
        g();
      }
      paramBoolean = bool1;
      if (paramInt2 == 0) {
        paramBoolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPicGIFPreDownloadLimit.a(paramBoolean, paramLong)) {
        return -11;
      }
      return 2;
    }
    bool1 = a();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("NetworkType:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" isInDPCWhiteList:");
      localStringBuilder.append(bool1);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", localStringBuilder.toString());
    }
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Wifi, result=");
        localStringBuilder.append(0);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", localStringBuilder.toString());
      }
    }
    else
    {
      if ((!bool1) || (paramInt2 == 3)) {
        break label258;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("InDPCWhiteList, result=");
        localStringBuilder.append(0);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", localStringBuilder.toString());
      }
    }
    return 0;
    label258:
    long l4 = a(paramLong);
    long l1;
    long l2;
    if (paramBoolean)
    {
      if (paramInt2 == 1) {
        paramLong = this.o;
      } else {
        paramLong = this.u;
      }
      if (paramInt2 == 1)
      {
        l1 = this.z;
        l2 = this.p;
      }
      else
      {
        l1 = this.B;
        l2 = this.v;
      }
      l2 = l1 - l2;
      long l3;
      if (paramInt2 == 1)
      {
        l3 = this.A;
        l1 = paramLong;
        paramLong = l3;
      }
      else
      {
        l3 = this.C;
        l1 = paramLong;
        paramLong = l3;
      }
    }
    else
    {
      if (paramInt2 == 1) {
        l1 = this.s;
      } else {
        l1 = this.y;
      }
      if (paramInt2 == 1) {
        l2 = this.z;
      } else {
        l2 = this.B;
      }
      if (paramInt2 == 1) {
        paramLong = this.A;
      } else {
        paramLong = this.C;
      }
    }
    if ((l2 >= l4) && (paramLong + l4 < l1))
    {
      if ((!paramBoolean) && (l2 - l4 < this.p)) {
        paramInt3 = 1;
      } else {
        paramInt3 = 0;
      }
    }
    else if (l2 < l4) {
      paramInt3 = -9;
    } else {
      paramInt3 = -10;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("result:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",FlowWaste +picSize=");
      localStringBuilder.append(paramLong + l4);
      localStringBuilder.append(",FlowWasteLimit：");
      localStringBuilder.append(l1);
      localStringBuilder.append(",FlowPre:");
      localStringBuilder.append(l2);
      localStringBuilder.append(",picSize:");
      localStringBuilder.append(l4);
      localStringBuilder.append(",FlowWaste:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",uinType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",networkType:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",isDynamic:");
      localStringBuilder.append(paramBoolean);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", localStringBuilder.toString());
      return paramInt3;
    }
    return paramInt3;
  }
  
  public IPicPreDownload.ConfigInfo a()
  {
    IPicPreDownload.ConfigInfo localConfigInfo = new IPicPreDownload.ConfigInfo();
    localConfigInfo.a = this.u;
    localConfigInfo.b = this.t;
    localConfigInfo.d = this.B;
    localConfigInfo.c = this.C;
    localConfigInfo.e = this.i;
    localConfigInfo.f = this.j;
    return localConfigInfo;
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    long l2 = PicPreDownloadUtils.a("4gFlowPre", this.z);
    long l3 = PicPreDownloadUtils.a("4gFlowWaste", this.A);
    long l4 = PicPreDownloadUtils.a("xgFlowPre", this.B);
    long l1 = PicPreDownloadUtils.a("xgFlowWaste", this.C);
    long l5 = PicPreDownloadUtils.a("accFlowPreTotal", this.D);
    long l6 = PicPreDownloadUtils.a("xgPreDownCount", this.F);
    long l7 = PicPreDownloadUtils.a("xgHitCount", this.G);
    long l8 = PicPreDownloadUtils.a("xgMissCount", this.H);
    long l9 = PicPreDownloadUtils.a("wifiPreDownCount", this.J);
    long l10 = PicPreDownloadUtils.a("wifiHitCount", this.K);
    long l11 = PicPreDownloadUtils.a("wifiMissCount", this.L);
    long l12 = PicPreDownloadUtils.a("xgManualClickCount", this.I);
    long l13 = PicPreDownloadUtils.a("wifiManualClickCount", this.M);
    long l14 = PicPreDownloadUtils.a("requestListOverLimitCount", this.N);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n|- sp4gFlowPre:");
      localStringBuilder.append(l2);
      localStringBuilder.append("\n|- sp4gFlowWaste:");
      localStringBuilder.append(l3);
      localStringBuilder.append("\n|- spXgFlowPre:");
      localStringBuilder.append(l4);
      localStringBuilder.append("\n|-  spXgFlowWaste：");
      localStringBuilder.append(l1);
      localStringBuilder.append("\n|-  spFlowPreTotal:");
      localStringBuilder.append(l5);
      localStringBuilder.append("\n|-  spXgPreDownCount：");
      localStringBuilder.append(l6);
      localStringBuilder.append("\n|-  spXgHitCount:");
      localStringBuilder.append(l7);
      localStringBuilder.append("\n|-  spXgMissCount：");
      localStringBuilder.append(l8);
      localStringBuilder.append("\n|-  spWifiPreDownCount:");
      localStringBuilder.append(l9);
      localStringBuilder.append("\n|-  spWifiHitCount：");
      localStringBuilder.append(l10);
      localStringBuilder.append("\n|-  spWifiMissCount:");
      localStringBuilder.append(l11);
      localStringBuilder.append("\n|-  spXgManulClickCount：");
      localStringBuilder.append(l12);
      localStringBuilder.append("\n|-  spWifiManulClickCount:");
      localStringBuilder.append(l13);
      localStringBuilder.append("\n|-  spRequestOverLimitCount:");
      localStringBuilder.append(l14);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", localStringBuilder.toString());
    }
    localHashMap.put("4gFlowPre", String.valueOf(l2));
    localHashMap.put("4gFlowWaste", String.valueOf(l3));
    localHashMap.put("xgFlowPre", String.valueOf(l4));
    localHashMap.put("xgFlowWaste", String.valueOf(l1));
    if ((l7 == 0L) && (l8 == 0L) && (l6 == 0L)) {
      break label603;
    }
    localHashMap.put("accFlowPreTotal", String.valueOf(l5));
    localHashMap.put("xgPreDownCount", String.valueOf(l6));
    localHashMap.put("xgHitCount", String.valueOf(l7));
    localHashMap.put("xgMissCount", String.valueOf(l6 - l7));
    localHashMap.put("xgManualClickCount", String.valueOf(l12));
    localHashMap.put("xgFlowWasteBalance", String.valueOf(this.u - l1));
    label603:
    localHashMap.put("wifiPreDownCount", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManualClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.N));
    return localHashMap;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.J += 1L;
      PicPreDownloadUtils.a("wifiPreDownCount", this.J, true);
      return;
    }
    paramLong = a(paramLong);
    a(paramInt, -paramLong, paramLong, false);
    this.D += paramLong;
    this.E += paramLong;
    this.F += 1L;
    PicPreDownloadUtils.a("accFlowPreTotal", this.D, false);
    PicPreDownloadUtils.a("accFlowWasteTotal", this.E, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.F, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("networkType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",wifiPreDownCount:");
      localStringBuilder.append(this.J);
      localStringBuilder.append(",xgPreDownCount:");
      localStringBuilder.append(this.F);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accFlowPreTotal:");
      localStringBuilder.append(this.D);
      localStringBuilder.append(",accFlowWasteTotal:");
      localStringBuilder.append(this.E);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", localStringBuilder.toString());
    }
  }
  
  public void a(AppInterface paramAppInterface, PicStatisticsManager paramPicStatisticsManager)
  {
    super.a(paramAppInterface);
    this.jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = paramPicStatisticsManager;
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache = ((TroopStatisticsCache)this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCacheManagerInner().getCache(3));
    g();
    h();
    e();
    long l1 = System.currentTimeMillis();
    if (l1 - PicPreDownloadUtils.a("lastDayTime", 0L) > 86400000L)
    {
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      PicPreDownloadUtils.a("lastDayTime", l1, true);
      PicReporter.a(paramAppInterface, a());
      f();
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a();
    }
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    PicPreDownloadUtils.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, paramMessageForPic);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      a(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType == 0) {
        return;
      }
      paramLong = this.l - paramLong;
      a(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.D -= paramLong;
      this.E -= paramLong;
      PicPreDownloadUtils.a("accFlowPreTotal", this.D, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.E, true);
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("accFlowPreTotal:");
        paramMessageForPic.append(this.D);
        paramMessageForPic.append(",accFlowWasteTotal:");
        paramMessageForPic.append(this.E);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", paramMessageForPic.toString());
      }
    }
  }
  
  public void a(IPicPreDownload.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.a != -1L) {
      this.u = paramConfigInfo.a;
    }
    if (paramConfigInfo.b != -1L) {
      this.t = paramConfigInfo.b;
    }
    if (paramConfigInfo.d != -1L)
    {
      this.B = paramConfigInfo.d;
      PicPreDownloadUtils.a("xgFlowPre", this.B, true);
    }
    if (paramConfigInfo.c != -1L)
    {
      this.C = paramConfigInfo.c;
      PicPreDownloadUtils.a("xgFlowWaste", this.C, true);
    }
    if (paramConfigInfo.e != -1L) {
      this.i = paramConfigInfo.e;
    }
    if (paramConfigInfo.f != -1L) {
      this.j = paramConfigInfo.f;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
    if (localObject != null)
    {
      paramString = Long.valueOf(((TroopStatisticsInfo)localObject).count - 1L);
      if (paramString.longValue() < 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPreDownloadTroopPicCount troopRemainCount = 0");
        }
        return;
      }
      ((TroopStatisticsInfo)localObject).count = paramString.longValue();
      paramString = (String)localObject;
    }
    else
    {
      localObject = new TroopStatisticsInfo();
      ((TroopStatisticsInfo)localObject).troopUin = paramString;
      ((TroopStatisticsInfo)localObject).count = (this.O - 1L);
      paramString = (String)localObject;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.addCache(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("payPreDownloadTroopPicCount troopRemainCount = ");
      ((StringBuilder)localObject).append(paramString.count);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    if (PicPreDownloadUtils.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {
      return true;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPreDownloadInPeakFlowTime(): Peek Flow is disable[true]");
      }
      return true;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfLong;
    int i1;
    if (localObject == null) {
      i1 = 0;
    } else {
      i1 = localObject.length;
    }
    if ((i1 != 0) && ((i1 & 0x1) == 0))
    {
      int i3 = Calendar.getInstance().get(11);
      int i2 = 0;
      while (i2 < i1)
      {
        long l1 = i3;
        localObject = this.jdField_a_of_type_ArrayOfLong;
        if ((l1 >= localObject[i2]) && (l1 < localObject[(i2 + 1)]))
        {
          if (paramMessageForPic.size > this.S)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("picSize=");
              ((StringBuilder)localObject).append(paramMessageForPic.size);
              ((StringBuilder)localObject).append(" is larger than PeakFlowMaxPicSize(");
              ((StringBuilder)localObject).append(this.S);
              ((StringBuilder)localObject).append(")[false]");
              QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, ((StringBuilder)localObject).toString());
            }
            return false;
          }
          if ((paramMessageForPic.size > this.R) && (a() == 0))
          {
            if (!a(paramMessageForPic.frienduin)) {
              return false;
            }
            if (!PicHelperImpl.hasBigFile(paramMessageForPic))
            {
              a(paramMessageForPic.frienduin);
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
            }
            return true;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("try to download because the pic.size=");
            ((StringBuilder)localObject).append(paramMessageForPic.size);
            ((StringBuilder)localObject).append(" < troopMinPicSize=");
            ((StringBuilder)localObject).append(this.R);
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, ((StringBuilder)localObject).toString());
          }
        }
        i2 += 2;
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("canPreDownloadInPeakFlowTime():  The length(");
      paramMessageForPic.append(i1);
      paramMessageForPic.append(") of PeakFlowTimePeriod is error![false]");
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, paramMessageForPic.toString());
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {
      return true;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return true;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
    if ((paramString != null) && (paramString.count < 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't preDownload because troopRemainCount = 0");
      }
      return false;
    }
    return true;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i1;
    int i2;
    if ((a()) && (paramInt2 != 3))
    {
      i1 = PicPreDownloadUtils.a(0, paramInt1, 0);
      i2 = PicPreDownloadUtils.a(0, paramInt1, 1);
    }
    else
    {
      i1 = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
      i2 = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
    }
    boolean bool1;
    if ((this.h >> i1 & 1L) == 1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((this.h >> i2 & 1L) == 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("netWorkType:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",uinType:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",preDownThumb:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",preDownBig:");
      localStringBuilder.append(bool2);
      localStringBuilder.append(",xGPreDownPolicy:");
      localStringBuilder.append(this.h);
      Logger.a("PIC_TAG_PRELOAD", "isPreDownload", localStringBuilder.toString());
    }
    return new boolean[] { bool1, bool2 };
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager == null) {
      return;
    }
    if (paramMessageForPic.isSendFromLocal()) {
      return;
    }
    if (paramMessageForPic.subVersion < 5) {
      return;
    }
    if (GIFPreDownloadLimit.a(paramMessageForPic)) {
      return;
    }
    int i1 = PicPreDownloadUtils.a(this.jdField_b_of_type_ComTencentCommonAppAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin);
    if (paramMessageForPic.preDownState == 1)
    {
      a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
      return;
    }
    if (paramMessageForPic.preDownState == 0)
    {
      if (a(i1, paramMessageForPic.preDownNetworkType)[1] == 0)
      {
        d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
      b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
      return;
    }
    if (paramMessageForPic.preDownState == 4) {
      c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
    }
  }
  
  public void b(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO() troopId is null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return;
    }
    TroopStatisticsInfo localTroopStatisticsInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.P;
      long l3 = this.Q;
      l1 = l2;
      if (l2 > l3) {
        l1 = l3;
      }
      localTroopStatisticsInfo.count = l1;
      paramString = localTroopStatisticsInfo;
    }
    else
    {
      l1 = this.O + this.P;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
      paramString = localTroopStatisticsInfo;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.updateCache(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("increaseTroopCountWhenEnterAIO troopRemainCount=");
      paramString.append(l1);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, paramString.toString());
    }
  }
  
  void e()
  {
    this.z = PicPreDownloadUtils.a("4gFlowPre", this.r);
    this.A = PicPreDownloadUtils.a("4gFlowWaste", 0L);
    this.B = PicPreDownloadUtils.a("xgFlowPre", this.x);
    this.C = PicPreDownloadUtils.a("xgFlowWaste", 0L);
    this.K = PicPreDownloadUtils.a("wifiHitCount", this.K);
    this.L = PicPreDownloadUtils.a("wifiMissCount", this.L);
    this.M = PicPreDownloadUtils.a("wifiManualClickCount", this.M);
    this.J = PicPreDownloadUtils.a("wifiPreDownCount", this.J);
    this.G = PicPreDownloadUtils.a("xgHitCount", this.G);
    this.H = PicPreDownloadUtils.a("xgMissCount", this.H);
    this.I = PicPreDownloadUtils.a("xgManualClickCount", this.I);
    this.F = PicPreDownloadUtils.a("xgPreDownCount", this.F);
    this.D = PicPreDownloadUtils.a("accFlowPreTotal", this.D);
    this.E = PicPreDownloadUtils.a("accFlowWasteTotal", this.E);
    this.N = PicPreDownloadUtils.a("requestListOverLimitCount", this.N);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalConfig(): wifiHitCount=");
      localStringBuilder.append(this.K);
      localStringBuilder.append(" wifiMissCount=");
      localStringBuilder.append(this.L);
      localStringBuilder.append(" wifiManualClickCount=");
      localStringBuilder.append(this.M);
      localStringBuilder.append(" wifiPreDownCount=");
      localStringBuilder.append(this.J);
      localStringBuilder.append(" _4gFlowPre=");
      localStringBuilder.append(this.z);
      localStringBuilder.append(" _4gFlowWaste=");
      localStringBuilder.append(this.A);
      localStringBuilder.append(" xgFlowPre=");
      localStringBuilder.append(this.B);
      localStringBuilder.append(" xgFlowWaste=");
      localStringBuilder.append(this.C);
      localStringBuilder.append(" xgHitCount=");
      localStringBuilder.append(this.G);
      localStringBuilder.append(" xgMissCount=");
      localStringBuilder.append(this.H);
      localStringBuilder.append(" xgManualClickCount=");
      localStringBuilder.append(this.I);
      localStringBuilder.append(" xgPreDownCount=");
      localStringBuilder.append(this.F);
      localStringBuilder.append(" accFlowPreTotal=");
      localStringBuilder.append(this.D);
      localStringBuilder.append(" accFlowWasteTotal=");
      localStringBuilder.append(this.E);
      localStringBuilder.append(" requestOverLimitCount=");
      localStringBuilder.append(this.N);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localStringBuilder.toString());
    }
  }
  
  public void f()
  {
    this.N = 0L;
    this.K = 0L;
    this.L = 0L;
    this.M = 0L;
    this.J = 0L;
    this.A = 0L;
    this.C = 0L;
    this.G = 0L;
    this.H = 0L;
    this.I = 0L;
    this.F = 0L;
    PicPreDownloadUtils.a("requestListOverLimitCount", this.N, false);
    PicPreDownloadUtils.a("wifiHitCount", this.K, false);
    PicPreDownloadUtils.a("wifiMissCount", this.L, false);
    PicPreDownloadUtils.a("wifiManualClickCount", this.M, false);
    PicPreDownloadUtils.a("wifiPreDownCount", this.J, false);
    PicPreDownloadUtils.a("4gFlowWaste", this.A, false);
    PicPreDownloadUtils.a("xgFlowWaste", this.C, false);
    PicPreDownloadUtils.a("xgHitCount", this.G, false);
    PicPreDownloadUtils.a("xgMissCount", this.H, false);
    PicPreDownloadUtils.a("xgManualClickCount", this.I, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.F, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategyBeta
 * JD-Core Version:    0.7.0.1
 */