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
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
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
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onUpdate " + paramPicPreDownloadBean.toString());
    }
    if (Pattern.matches("(\\d+?\\|){7}\\d+", paramPicPreDownloadBean.jdField_a_of_type_JavaLangString)) {
      PicPreDownloadUtils.a("flowCombination", paramPicPreDownloadBean.jdField_a_of_type_JavaLangString, true);
    }
    if (Pattern.matches("(\\d+?\\|){3}\\d+", paramPicPreDownloadBean.jdField_b_of_type_JavaLangString)) {
      PicPreDownloadUtils.a("troopCombination", paramPicPreDownloadBean.jdField_b_of_type_JavaLangString, true);
    }
    if (paramPicPreDownloadBean.g > 0L) {
      PicPreDownloadUtils.a("maxRequest", paramPicPreDownloadBean.g, true);
    }
    if ((paramPicPreDownloadBean.jdField_a_of_type_Long == 0L) || (paramPicPreDownloadBean.jdField_a_of_type_Long == 1L)) {
      if (paramPicPreDownloadBean.jdField_a_of_type_Long != 1L) {
        break label483;
      }
    }
    label483:
    for (boolean bool1 = true;; bool1 = false)
    {
      PicPreDownloadUtils.a("PicPreDownSwitchNew", bool1, true);
      if ((paramPicPreDownloadBean.jdField_b_of_type_Long == 0L) || (paramPicPreDownloadBean.jdField_b_of_type_Long == 1L) || (paramPicPreDownloadBean.jdField_b_of_type_Long == 2L) || (paramPicPreDownloadBean.jdField_b_of_type_Long == 3L)) {
        PicPreDownloadUtils.a("PicAuDownTimePoint", paramPicPreDownloadBean.jdField_b_of_type_Long, true);
      }
      if (paramPicPreDownloadBean.jdField_c_of_type_Long > 0L) {
        PicPreDownloadUtils.a("MaxWifiFlow", paramPicPreDownloadBean.jdField_c_of_type_Long, true);
      }
      if (paramPicPreDownloadBean.jdField_d_of_type_Long > 0L) {
        PicPreDownloadUtils.a("Max4GFlow", paramPicPreDownloadBean.jdField_d_of_type_Long, true);
      }
      if (paramPicPreDownloadBean.e > 0L) {
        PicPreDownloadUtils.a("Max3GFlow", paramPicPreDownloadBean.e, true);
      }
      if (paramPicPreDownloadBean.f > 0L) {
        PicPreDownloadUtils.a("Max2GFlow", paramPicPreDownloadBean.f, true);
      }
      if (Pattern.matches("^[0-9A-Fa-f]+$", paramPicPreDownloadBean.jdField_c_of_type_JavaLangString)) {
        PicPreDownloadUtils.a("xGPreDownPolicy", Long.valueOf(paramPicPreDownloadBean.jdField_c_of_type_JavaLangString, 16).longValue(), true);
      }
      if (paramPicPreDownloadBean.h > 0L) {
        PicPreDownloadUtils.a("AFBFlowHitXG", paramPicPreDownloadBean.h, true);
      }
      if (paramPicPreDownloadBean.i > 0L) {
        PicPreDownloadUtils.a("AFBFlowMissXG", paramPicPreDownloadBean.i, true);
      }
      if (paramPicPreDownloadBean.j > 0L) {
        PicPreDownloadUtils.a("APicAvgSize", paramPicPreDownloadBean.j, true);
      }
      if (paramPicPreDownloadBean.k > 0L) {
        PicPreDownloadUtils.a("APicMaxSize", paramPicPreDownloadBean.k, true);
      }
      if ((paramPicPreDownloadBean.l == 0L) || (paramPicPreDownloadBean.l == 1L))
      {
        bool1 = bool2;
        if (paramPicPreDownloadBean.l == 1L) {
          bool1 = true;
        }
        PicPreDownloadUtils.a("enablePeakFlow", bool1, true);
      }
      if (Pattern.matches("^((([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]);)*+([01]?[0-9]|2[01234])-([01]?[0-9]|2[01234]))$", paramPicPreDownloadBean.jdField_d_of_type_JavaLangString)) {
        PicPreDownloadUtils.a("PeakFlowTimePeriod", paramPicPreDownloadBean.jdField_d_of_type_JavaLangString, true);
      }
      if (paramPicPreDownloadBean.m > 0L) {
        PicPreDownloadUtils.a("PeakFlowMaxPicSize", paramPicPreDownloadBean.m, true);
      }
      if ((paramPicPreDownloadBean.jdField_a_of_type_Int > 0) && (paramPicPreDownloadBean.jdField_b_of_type_Int > 0))
      {
        PicPreDownloadUtils.a("gifWifiPreDownloadLimit", paramPicPreDownloadBean.jdField_a_of_type_Int, true);
        PicPreDownloadUtils.a("gifXgPreDownloadLimit", paramPicPreDownloadBean.jdField_b_of_type_Int, true);
      }
      return;
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
    if (QLog.isColorLevel()) {
      QLog.d("PicPreDownloadConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 616;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PicPreDownloadConfProcessor
 * JD-Core Version:    0.7.0.1
 */