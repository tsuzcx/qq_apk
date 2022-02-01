package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicPreDownload.ConfigInfo;
import com.tencent.mobileqq.pic.api.impl.PicHelperImpl;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PreDownloadStrategyBeta
  extends BaseStrategy
{
  public static String R = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
  public long A;
  public long B;
  public long C;
  public long D;
  public long E = -1L;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q = 0L;
  public long S = 2147483647L;
  public long T = 2147483647L;
  public long U = 2147483647L;
  public long V = 2147483647L;
  public AtomicBoolean W = new AtomicBoolean(false);
  public TroopStatisticsCache X;
  public boolean Y;
  public long[] Z;
  public long aa;
  public Long ab = Long.valueOf(100L);
  public PicStatisticsManager ac;
  private AppInterface ad;
  private GIFPreDownloadLimit ae;
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
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.o;
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
      l2 = this.C;
      l1 = this.D;
      this.C = (paramLong1 + l2);
      this.D = (paramLong2 + l1);
      paramLong2 = this.C;
      l3 = this.u;
      paramLong1 = paramLong2;
      if (paramLong2 > l3) {
        paramLong1 = l3;
      }
      this.C = paramLong1;
      paramLong2 = this.C;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.C = paramLong1;
      paramLong2 = this.D;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.D = paramLong1;
      l4 = this.C;
      l3 = this.D;
      PicPreDownloadUtils.a("4gFlowPre", l4, false);
      PicPreDownloadUtils.a("4gFlowWaste", this.D, paramBoolean);
      paramLong1 = l2;
      paramLong2 = l1;
      l1 = l4;
      l2 = l3;
    }
    else
    {
      l3 = this.E;
      l4 = this.F;
      this.E = (paramLong1 + l3);
      this.F = (paramLong2 + l4);
      paramLong2 = this.E;
      l1 = this.A;
      paramLong1 = paramLong2;
      if (paramLong2 > l1) {
        paramLong1 = l1;
      }
      this.E = paramLong1;
      paramLong2 = this.E;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.E = paramLong1;
      paramLong2 = this.F;
      paramLong1 = paramLong2;
      if (paramLong2 < 0L) {
        paramLong1 = 0L;
      }
      this.F = paramLong1;
      l1 = this.E;
      l2 = this.F;
      PicPreDownloadUtils.a("xgFlowPre", l1, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.F, paramBoolean);
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
    this.ac.a(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    b(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      this.N += 1L;
      PicPreDownloadUtils.a("wifiHitCount", this.N, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.N);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", localStringBuilder.toString());
      }
    }
    else
    {
      paramLong = a(paramLong);
      a(paramInt1, this.l * paramLong / 100L, -paramLong, false);
      this.J += 1L;
      this.H -= paramLong;
      PicPreDownloadUtils.a("accFlowWasteTotal", this.H, false);
      PicPreDownloadUtils.a("xgHitCount", this.J, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.J);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", localStringBuilder.toString());
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("accFlowPreTotal:");
        paramMessageForPic.append(this.G);
        paramMessageForPic.append(",accFlowWasteTotal:");
        paramMessageForPic.append(this.H);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", paramMessageForPic.toString());
      }
    }
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = this.ad;
    if ((localObject != null) && (!TextUtils.isEmpty(((AppInterface)localObject).getAccount())))
    {
      localObject = ((PicPreDownloadImpl)this.ad.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
      if ((paramMessageForPic.mNotPredownloadReason != 0) && (paramMessageForPic.mNotPredownloadReason != 1))
      {
        this.ac.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
        if (paramMessageForPic.mNotPredownloadReason != -1) {
          this.ac.c(paramInt1, paramInt2);
        }
      }
      else
      {
        int i = ((PicPreDownloader)localObject).a(paramMessageForPic);
        this.ac.e(paramInt1, i);
        this.ac.a(paramInt1, i);
        this.ac.c(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    b(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.O += 1L;
      PicPreDownloadUtils.a("wifiMissCount", this.O, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",wifiMissCount:");
      ((StringBuilder)localObject).append(this.O);
      ((StringBuilder)localObject).append(",uniseq:");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", ((StringBuilder)localObject).toString());
      return;
    }
    a(paramInt1, this.m, 0L, false);
    this.K += 1L;
    PicPreDownloadUtils.a("xgMissCount", this.K, true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", xgMissCount:");
      ((StringBuilder)localObject).append(this.K);
      ((StringBuilder)localObject).append(", uniseq:");
      ((StringBuilder)localObject).append(paramMessageForPic.uniseq);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    b(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.N);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", localStringBuilder.toString());
      }
    }
    else
    {
      a(paramInt1, this.n, 0L, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.J);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", localStringBuilder.toString());
      }
    }
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.ac.d(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    b(paramMessageForPic);
    StringBuilder localStringBuilder;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",wifiHitCount:");
        localStringBuilder.append(this.N);
        localStringBuilder.append(",uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", localStringBuilder.toString());
      }
    }
    else
    {
      a(paramInt1, this.n, 0L, true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("networkType:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",xgHitCount:");
        localStringBuilder.append(this.J);
        localStringBuilder.append(", uniseq:");
        localStringBuilder.append(paramMessageForPic.uniseq);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", localStringBuilder.toString());
      }
    }
  }
  
  private void k()
  {
    try
    {
      if (this.ae == null) {
        this.ae = new GIFPreDownloadLimit();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void l()
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
    int i = 0;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length == 8)
      {
        this.q = (Integer.valueOf(localObject1[0]).intValue() * 1024);
        this.s = (Integer.valueOf(localObject1[1]).intValue() * 1024);
        this.r = (Integer.valueOf(localObject1[2]).intValue() * 1024);
        this.t = (Integer.valueOf(localObject1[3]).intValue() * 1024);
        this.w = (Integer.valueOf(localObject1[4]).intValue() * 1024);
        this.y = (Integer.valueOf(localObject1[5]).intValue() * 1024);
        this.x = (Integer.valueOf(localObject1[6]).intValue() * 1024);
        this.z = (Integer.valueOf(localObject1[7]).intValue() * 1024);
        break label310;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): Error, use Server config");
    }
    this.w = PicPreDownloadUtils.a(this.ad, "AMaxPDFlow3G", 614400L);
    this.x = PicPreDownloadUtils.a(this.ad, "AMaxWFlow3G", 716800L);
    this.y = 0L;
    this.z = 0L;
    this.q = this.w;
    this.s = 0L;
    this.r = this.x;
    this.t = 0L;
    label310:
    this.u = (this.q + this.s);
    this.v = (this.r + this.t);
    this.A = (this.w + this.y);
    this.B = (this.x + this.z);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initConfig():_4gFlowPreLimit=");
      ((StringBuilder)localObject1).append(this.q);
      ((StringBuilder)localObject1).append(" _4gFlowWasteLimit=");
      ((StringBuilder)localObject1).append(this.r);
      ((StringBuilder)localObject1).append(" _4gFlowPreFloatLimit");
      ((StringBuilder)localObject1).append(this.s);
      ((StringBuilder)localObject1).append(" _4gFlowWasteFloatLimit=");
      ((StringBuilder)localObject1).append(this.t);
      ((StringBuilder)localObject1).append(" xgFlowPreLimit=");
      ((StringBuilder)localObject1).append(this.w);
      ((StringBuilder)localObject1).append(" xgFlowWasteLimit=");
      ((StringBuilder)localObject1).append(this.x);
      ((StringBuilder)localObject1).append(" xgFlowPreFloatLimit=");
      ((StringBuilder)localObject1).append(this.y);
      ((StringBuilder)localObject1).append(" xgFlowWasteFloatLimit=");
      ((StringBuilder)localObject1).append(this.z);
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
          this.S = Long.parseLong(localObject1[0]);
          this.T = Long.parseLong(localObject1[1]);
          this.U = Long.parseLong(localObject1[2]);
          this.V = (Long.parseLong(localObject1[3]) * 1024L);
          this.W.set(true);
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
      ((StringBuilder)localObject2).append(this.S);
      ((StringBuilder)localObject2).append(", troopIncreaseCountEnterAIO=");
      ((StringBuilder)localObject2).append(this.T);
      ((StringBuilder)localObject2).append(", troopMaxCount=");
      ((StringBuilder)localObject2).append(this.U);
      ((StringBuilder)localObject2).append(", troopMinPicSize=");
      ((StringBuilder)localObject2).append(this.V);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, ((StringBuilder)localObject2).toString());
    }
    this.ab = Long.valueOf(PicPreDownloadUtils.b("maxRequest", 100L));
    this.k = PicPreDownloadUtils.b("xGPreDownPolicy", 1374942199L);
    this.l = PicPreDownloadUtils.b("AFBFlowHitXG", 150L);
    this.m = PicPreDownloadUtils.b("AFBFlowMissXG", 40960L);
    this.n = this.m;
    this.o = PicPreDownloadUtils.b("APicAvgSize", 71680L);
    this.p = PicPreDownloadUtils.b("APicMaxSize", 204800L);
    this.Y = PicPreDownloadUtils.a("enablePeakFlow", Boolean.valueOf(true)).booleanValue();
    this.Z = PicPreDownloadUtils.b();
    this.aa = PicPreDownloadUtils.b("PeakFlowMaxPicSize", 921600L);
    if (QLog.isColorLevel())
    {
      int j = this.Z.length;
      if ((j != 0) && ((j & 0x1) == 0))
      {
        localObject2 = new StringBuilder();
        while (i < j)
        {
          ((StringBuilder)localObject2).append(String.valueOf(this.Z[i]));
          ((StringBuilder)localObject2).append("-");
          ((StringBuilder)localObject2).append(String.valueOf(this.Z[(i + 1)]));
          ((StringBuilder)localObject2).append(" ");
          i += 2;
        }
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Error(Length=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(")");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initConfig(): xGPreDownPolicy=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" xgFlowHitFeedback=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" XgFlowMissFeedback=");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" XgFlowLeftRightFeddback=");
      localStringBuilder.append(this.n);
      localStringBuilder.append(" pisSizeAvg=");
      localStringBuilder.append(this.o);
      localStringBuilder.append(" pisSizeMax=");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" mEnablePeakFlow=");
      localStringBuilder.append(this.Y);
      localStringBuilder.append(" mPeakFlowTimePeriod=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" mPeakFlowMaxPicSize=");
      localStringBuilder.append(this.aa);
      localStringBuilder.append(", mRequestListMaxSize=");
      localStringBuilder.append(this.ab);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localStringBuilder.toString());
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i = super.a(paramLong, paramInt1, paramInt2, paramBoolean, paramInt3);
    if (i != 0) {
      return i;
    }
    boolean bool2 = GIFPreDownloadLimit.a(null, paramBoolean, paramInt3);
    boolean bool1 = false;
    if (bool2)
    {
      if (this.ae == null) {
        k();
      }
      paramBoolean = bool1;
      if (paramInt2 == 0) {
        paramBoolean = true;
      }
      if (this.ae.a(paramBoolean, paramLong)) {
        return -11;
      }
      return 2;
    }
    bool1 = b();
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
        paramLong = this.r;
      } else {
        paramLong = this.x;
      }
      if (paramInt2 == 1)
      {
        l1 = this.C;
        l2 = this.s;
      }
      else
      {
        l1 = this.E;
        l2 = this.y;
      }
      l2 = l1 - l2;
      long l3;
      if (paramInt2 == 1)
      {
        l3 = this.D;
        l1 = paramLong;
        paramLong = l3;
      }
      else
      {
        l3 = this.F;
        l1 = paramLong;
        paramLong = l3;
      }
    }
    else
    {
      if (paramInt2 == 1) {
        l1 = this.v;
      } else {
        l1 = this.B;
      }
      if (paramInt2 == 1) {
        l2 = this.C;
      } else {
        l2 = this.E;
      }
      if (paramInt2 == 1) {
        paramLong = this.D;
      } else {
        paramLong = this.F;
      }
    }
    if ((l2 >= l4) && (paramLong + l4 < l1))
    {
      if ((!paramBoolean) && (l2 - l4 < this.s)) {
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
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.M += 1L;
      PicPreDownloadUtils.a("wifiPreDownCount", this.M, true);
      return;
    }
    paramLong = a(paramLong);
    a(paramInt, -paramLong, paramLong, false);
    this.G += paramLong;
    this.H += paramLong;
    this.I += 1L;
    PicPreDownloadUtils.a("accFlowPreTotal", this.G, false);
    PicPreDownloadUtils.a("accFlowWasteTotal", this.H, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.I, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("networkType:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",wifiPreDownCount:");
      localStringBuilder.append(this.M);
      localStringBuilder.append(",xgPreDownCount:");
      localStringBuilder.append(this.I);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("accFlowPreTotal:");
      localStringBuilder.append(this.G);
      localStringBuilder.append(",accFlowWasteTotal:");
      localStringBuilder.append(this.H);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", localStringBuilder.toString());
    }
  }
  
  public void a(AppInterface paramAppInterface, PicStatisticsManager paramPicStatisticsManager)
  {
    super.a(paramAppInterface);
    this.ad = paramAppInterface;
    this.ac = paramPicStatisticsManager;
    this.X = ((TroopStatisticsCache)this.ad.getCacheManagerInner().getCache(3));
    k();
    l();
    g();
    long l1 = System.currentTimeMillis();
    if (l1 - PicPreDownloadUtils.b("lastDayTime", 0L) > 86400000L)
    {
      paramAppInterface = paramAppInterface.getCurrentAccountUin();
      PicPreDownloadUtils.a("lastDayTime", l1, true);
      PicReporter.a(paramAppInterface, i());
      j();
      this.ac.a();
    }
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
    }
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      b(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType == 0) {
        return;
      }
      paramLong = this.o - paramLong;
      a(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.G -= paramLong;
      this.H -= paramLong;
      PicPreDownloadUtils.a("accFlowPreTotal", this.G, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.H, true);
      if (QLog.isColorLevel())
      {
        paramMessageForPic = new StringBuilder();
        paramMessageForPic.append("accFlowPreTotal:");
        paramMessageForPic.append(this.G);
        paramMessageForPic.append(",accFlowWasteTotal:");
        paramMessageForPic.append(this.H);
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", paramMessageForPic.toString());
      }
    }
  }
  
  public void a(IPicPreDownload.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.a != -1L) {
      this.x = paramConfigInfo.a;
    }
    if (paramConfigInfo.b != -1L) {
      this.w = paramConfigInfo.b;
    }
    if (paramConfigInfo.d != -1L)
    {
      this.E = paramConfigInfo.d;
      PicPreDownloadUtils.a("xgFlowPre", this.E, true);
    }
    if (paramConfigInfo.c != -1L)
    {
      this.F = paramConfigInfo.c;
      PicPreDownloadUtils.a("xgFlowWaste", this.F, true);
    }
    if (paramConfigInfo.e != -1L) {
      this.l = paramConfigInfo.e;
    }
    if (paramConfigInfo.f != -1L) {
      this.m = paramConfigInfo.f;
    }
  }
  
  public void a(String paramString)
  {
    if (this.X == null) {
      return;
    }
    if (!this.W.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return;
    }
    Object localObject = this.X.a(paramString);
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
      ((TroopStatisticsInfo)localObject).count = (this.S - 1L);
      paramString = (String)localObject;
    }
    this.X.addCache(paramString);
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
    if (PicPreDownloadUtils.a(this.ad, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {
      return true;
    }
    if (!this.Y)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPreDownloadInPeakFlowTime(): Peek Flow is disable[true]");
      }
      return true;
    }
    Object localObject = this.Z;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.length;
    }
    if ((i != 0) && ((i & 0x1) == 0))
    {
      int i1 = Calendar.getInstance().get(11);
      int j = 0;
      while (j < i)
      {
        long l1 = i1;
        localObject = this.Z;
        if ((l1 >= localObject[j]) && (l1 < localObject[(j + 1)]))
        {
          if (paramMessageForPic.size > this.aa)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("picSize=");
              ((StringBuilder)localObject).append(paramMessageForPic.size);
              ((StringBuilder)localObject).append(" is larger than PeakFlowMaxPicSize(");
              ((StringBuilder)localObject).append(this.aa);
              ((StringBuilder)localObject).append(")[false]");
              QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, ((StringBuilder)localObject).toString());
            }
            return false;
          }
          if ((paramMessageForPic.size > this.V) && (h() == 0))
          {
            if (!b(paramMessageForPic.frienduin)) {
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
            ((StringBuilder)localObject).append(this.V);
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, ((StringBuilder)localObject).toString());
          }
        }
        j += 2;
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramMessageForPic = new StringBuilder();
      paramMessageForPic.append("canPreDownloadInPeakFlowTime():  The length(");
      paramMessageForPic.append(i);
      paramMessageForPic.append(") of PeakFlowTimePeriod is error![false]");
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, paramMessageForPic.toString());
    }
    return false;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i;
    int j;
    if ((b()) && (paramInt2 != 3))
    {
      i = PicPreDownloadUtils.a(0, paramInt1, 0);
      j = PicPreDownloadUtils.a(0, paramInt1, 1);
    }
    else
    {
      i = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
      j = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
    }
    boolean bool1;
    if ((this.k >> i & 1L) == 1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((this.k >> j & 1L) == 1L) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramInt1 == 4) {
      return ((IGuildPicDownLoadConfigApi)QRoute.api(IGuildPicDownLoadConfigApi.class)).isPreDownload(paramInt2);
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
      localStringBuilder.append(this.k);
      Logger.a("PIC_TAG_PRELOAD", "isPreDownload", localStringBuilder.toString());
    }
    return new boolean[] { bool1, bool2 };
  }
  
  public void b(MessageForPic paramMessageForPic)
  {
    PicPreDownloadUtils.a(this.ad, paramMessageForPic);
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.ac == null) {
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
    int i = PicPreDownloadUtils.a(this.ad, paramMessageForPic.istroop, paramMessageForPic.frienduin);
    if (paramMessageForPic.preDownState == 1)
    {
      a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
      return;
    }
    if (paramMessageForPic.preDownState == 0)
    {
      if (a(i, paramMessageForPic.preDownNetworkType)[1] == 0)
      {
        d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
        return;
      }
      b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
      return;
    }
    if (paramMessageForPic.preDownState == 4) {
      c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i);
    }
  }
  
  public boolean b(String paramString)
  {
    if (this.X == null) {
      return true;
    }
    if (!this.W.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return true;
    }
    paramString = this.X.a(paramString);
    if ((paramString != null) && (paramString.count < 1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't preDownload because troopRemainCount = 0");
      }
      return false;
    }
    return true;
  }
  
  public void c(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO() troopId is null");
      }
      return;
    }
    if (this.X == null) {
      return;
    }
    if (!this.W.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      }
      return;
    }
    TroopStatisticsInfo localTroopStatisticsInfo = this.X.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.T;
      long l3 = this.U;
      l1 = l2;
      if (l2 > l3) {
        l1 = l3;
      }
      localTroopStatisticsInfo.count = l1;
      paramString = localTroopStatisticsInfo;
    }
    else
    {
      l1 = this.S + this.T;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
      paramString = localTroopStatisticsInfo;
    }
    this.X.updateCache(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("increaseTroopCountWhenEnterAIO troopRemainCount=");
      paramString.append(l1);
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, paramString.toString());
    }
  }
  
  public IPicPreDownload.ConfigInfo f()
  {
    IPicPreDownload.ConfigInfo localConfigInfo = new IPicPreDownload.ConfigInfo();
    localConfigInfo.a = this.x;
    localConfigInfo.b = this.w;
    localConfigInfo.d = this.E;
    localConfigInfo.c = this.F;
    localConfigInfo.e = this.l;
    localConfigInfo.f = this.m;
    return localConfigInfo;
  }
  
  void g()
  {
    this.C = PicPreDownloadUtils.b("4gFlowPre", this.u);
    this.D = PicPreDownloadUtils.b("4gFlowWaste", 0L);
    this.E = PicPreDownloadUtils.b("xgFlowPre", this.A);
    this.F = PicPreDownloadUtils.b("xgFlowWaste", 0L);
    this.N = PicPreDownloadUtils.b("wifiHitCount", this.N);
    this.O = PicPreDownloadUtils.b("wifiMissCount", this.O);
    this.P = PicPreDownloadUtils.b("wifiManualClickCount", this.P);
    this.M = PicPreDownloadUtils.b("wifiPreDownCount", this.M);
    this.J = PicPreDownloadUtils.b("xgHitCount", this.J);
    this.K = PicPreDownloadUtils.b("xgMissCount", this.K);
    this.L = PicPreDownloadUtils.b("xgManualClickCount", this.L);
    this.I = PicPreDownloadUtils.b("xgPreDownCount", this.I);
    this.G = PicPreDownloadUtils.b("accFlowPreTotal", this.G);
    this.H = PicPreDownloadUtils.b("accFlowWasteTotal", this.H);
    this.Q = PicPreDownloadUtils.b("requestListOverLimitCount", this.Q);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLocalConfig(): wifiHitCount=");
      localStringBuilder.append(this.N);
      localStringBuilder.append(" wifiMissCount=");
      localStringBuilder.append(this.O);
      localStringBuilder.append(" wifiManualClickCount=");
      localStringBuilder.append(this.P);
      localStringBuilder.append(" wifiPreDownCount=");
      localStringBuilder.append(this.M);
      localStringBuilder.append(" _4gFlowPre=");
      localStringBuilder.append(this.C);
      localStringBuilder.append(" _4gFlowWaste=");
      localStringBuilder.append(this.D);
      localStringBuilder.append(" xgFlowPre=");
      localStringBuilder.append(this.E);
      localStringBuilder.append(" xgFlowWaste=");
      localStringBuilder.append(this.F);
      localStringBuilder.append(" xgHitCount=");
      localStringBuilder.append(this.J);
      localStringBuilder.append(" xgMissCount=");
      localStringBuilder.append(this.K);
      localStringBuilder.append(" xgManualClickCount=");
      localStringBuilder.append(this.L);
      localStringBuilder.append(" xgPreDownCount=");
      localStringBuilder.append(this.I);
      localStringBuilder.append(" accFlowPreTotal=");
      localStringBuilder.append(this.G);
      localStringBuilder.append(" accFlowWasteTotal=");
      localStringBuilder.append(this.H);
      localStringBuilder.append(" requestOverLimitCount=");
      localStringBuilder.append(this.Q);
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localStringBuilder.toString());
    }
  }
  
  public int h()
  {
    return PicPreDownloadUtils.a();
  }
  
  public HashMap<String, String> i()
  {
    HashMap localHashMap = new HashMap();
    long l2 = PicPreDownloadUtils.b("4gFlowPre", this.C);
    long l3 = PicPreDownloadUtils.b("4gFlowWaste", this.D);
    long l4 = PicPreDownloadUtils.b("xgFlowPre", this.E);
    long l1 = PicPreDownloadUtils.b("xgFlowWaste", this.F);
    long l5 = PicPreDownloadUtils.b("accFlowPreTotal", this.G);
    long l6 = PicPreDownloadUtils.b("xgPreDownCount", this.I);
    long l7 = PicPreDownloadUtils.b("xgHitCount", this.J);
    long l8 = PicPreDownloadUtils.b("xgMissCount", this.K);
    long l9 = PicPreDownloadUtils.b("wifiPreDownCount", this.M);
    long l10 = PicPreDownloadUtils.b("wifiHitCount", this.N);
    long l11 = PicPreDownloadUtils.b("wifiMissCount", this.O);
    long l12 = PicPreDownloadUtils.b("xgManualClickCount", this.L);
    long l13 = PicPreDownloadUtils.b("wifiManualClickCount", this.P);
    long l14 = PicPreDownloadUtils.b("requestListOverLimitCount", this.Q);
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
    localHashMap.put("xgFlowWasteBalance", String.valueOf(this.x - l1));
    label603:
    localHashMap.put("wifiPreDownCount", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManualClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.Q));
    return localHashMap;
  }
  
  public void j()
  {
    this.Q = 0L;
    this.N = 0L;
    this.O = 0L;
    this.P = 0L;
    this.M = 0L;
    this.D = 0L;
    this.F = 0L;
    this.J = 0L;
    this.K = 0L;
    this.L = 0L;
    this.I = 0L;
    PicPreDownloadUtils.a("requestListOverLimitCount", this.Q, false);
    PicPreDownloadUtils.a("wifiHitCount", this.N, false);
    PicPreDownloadUtils.a("wifiMissCount", this.O, false);
    PicPreDownloadUtils.a("wifiManualClickCount", this.P, false);
    PicPreDownloadUtils.a("wifiPreDownCount", this.M, false);
    PicPreDownloadUtils.a("4gFlowWaste", this.D, false);
    PicPreDownloadUtils.a("xgFlowWaste", this.F, false);
    PicPreDownloadUtils.a("xgHitCount", this.J, false);
    PicPreDownloadUtils.a("xgMissCount", this.K, false);
    PicPreDownloadUtils.a("xgManualClickCount", this.L, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.I, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategyBeta
 * JD-Core Version:    0.7.0.1
 */