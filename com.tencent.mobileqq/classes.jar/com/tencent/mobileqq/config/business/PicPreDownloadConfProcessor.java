package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Pattern;

public class PicPreDownloadConfProcessor
  extends IQConfigProcessor<PicPreDownloadBean>
{
  @NonNull
  public PicPreDownloadBean a(int paramInt)
  {
    return new PicPreDownloadBean();
  }
  
  @Nullable
  public PicPreDownloadBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onParsed ");
      ((StringBuilder)localObject1).append(paramArrayOfQConfItem.length);
      QLog.d("PicPreDownloadConfProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = PicPreDownloadBean.a(paramArrayOfQConfItem);
      }
    }
    return localObject1;
  }
  
  public void a(PicPreDownloadBean paramPicPreDownloadBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramPicPreDownloadBean.toString());
      QLog.d("PicPreDownloadConfProcessor", 2, localStringBuilder.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramPicPreDownloadBean.g)) {
      PicPreDownloadUtils.a("flowCombination", paramPicPreDownloadBean.g, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramPicPreDownloadBean.h)) {
      PicPreDownloadUtils.a("troopCombination", paramPicPreDownloadBean.h, true);
    }
    if (paramPicPreDownloadBean.i > 0L) {
      PicPreDownloadUtils.a("maxRequest", paramPicPreDownloadBean.i, true);
    }
    long l = paramPicPreDownloadBean.a;
    boolean bool2 = false;
    boolean bool1;
    if ((l == 0L) || (paramPicPreDownloadBean.a == 1L))
    {
      if (paramPicPreDownloadBean.a == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      PicPreDownloadUtils.a("PicPreDownSwitchNew", bool1, true);
    }
    if ((paramPicPreDownloadBean.b == 0L) || (paramPicPreDownloadBean.b == 1L) || (paramPicPreDownloadBean.b == 2L) || (paramPicPreDownloadBean.b == 3L)) {
      PicPreDownloadUtils.a("PicAuDownTimePoint", paramPicPreDownloadBean.b, true);
    }
    if (paramPicPreDownloadBean.c > 0L) {
      PicPreDownloadUtils.a("MaxWifiFlow", paramPicPreDownloadBean.c, true);
    }
    if (paramPicPreDownloadBean.d > 0L) {
      PicPreDownloadUtils.a("Max4GFlow", paramPicPreDownloadBean.d, true);
    }
    if (paramPicPreDownloadBean.e > 0L) {
      PicPreDownloadUtils.a("Max3GFlow", paramPicPreDownloadBean.e, true);
    }
    if (paramPicPreDownloadBean.f > 0L) {
      PicPreDownloadUtils.a("Max2GFlow", paramPicPreDownloadBean.f, true);
    }
    if (Pattern.matches("^[0-9A-Fa-f]+$", paramPicPreDownloadBean.j)) {
      PicPreDownloadUtils.a("xGPreDownPolicy", Long.valueOf(paramPicPreDownloadBean.j, 16).longValue(), true);
    }
    if (paramPicPreDownloadBean.k > 0L) {
      PicPreDownloadUtils.a("AFBFlowHitXG", paramPicPreDownloadBean.k, true);
    }
    if (paramPicPreDownloadBean.l > 0L) {
      PicPreDownloadUtils.a("AFBFlowMissXG", paramPicPreDownloadBean.l, true);
    }
    if (paramPicPreDownloadBean.m > 0L) {
      PicPreDownloadUtils.a("APicAvgSize", paramPicPreDownloadBean.m, true);
    }
    if (paramPicPreDownloadBean.n > 0L) {
      PicPreDownloadUtils.a("APicMaxSize", paramPicPreDownloadBean.n, true);
    }
    if ((paramPicPreDownloadBean.o == 0L) || (paramPicPreDownloadBean.o == 1L))
    {
      bool1 = bool2;
      if (paramPicPreDownloadBean.o == 1L) {
        bool1 = true;
      }
      PicPreDownloadUtils.a("enablePeakFlow", bool1, true);
    }
    if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramPicPreDownloadBean.p)) {
      PicPreDownloadUtils.a("PeakFlowTimePeriod", paramPicPreDownloadBean.p, true);
    }
    if (paramPicPreDownloadBean.q > 0L) {
      PicPreDownloadUtils.a("PeakFlowMaxPicSize", paramPicPreDownloadBean.q, true);
    }
    if ((paramPicPreDownloadBean.r > 0) && (paramPicPreDownloadBean.s > 0))
    {
      PicPreDownloadUtils.a("gifWifiPreDownloadLimit", paramPicPreDownloadBean.r, true);
      PicPreDownloadUtils.a("gifXgPreDownloadLimit", paramPicPreDownloadBean.s, true);
    }
  }
  
  public Class<PicPreDownloadBean> clazz()
  {
    return PicPreDownloadBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("PicPreDownloadConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicPreDownloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */