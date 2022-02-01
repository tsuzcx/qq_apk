package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class TencentDocMiniProgramGrayTipsProcessor
  extends IQConfigProcessor<TencentDocMiniProgramGrayTipsBean>
{
  @NonNull
  public TencentDocMiniProgramGrayTipsBean a(int paramInt)
  {
    return new TencentDocMiniProgramGrayTipsBean();
  }
  
  @Nullable
  public TencentDocMiniProgramGrayTipsBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocMiniProgramGrayTipsBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocMiniProgramGrayTipsBean paramTencentDocMiniProgramGrayTipsBean) {}
  
  public Class<TencentDocMiniProgramGrayTipsBean> clazz()
  {
    return TencentDocMiniProgramGrayTipsBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocMiniProgramGrayTipsProcessor
 * JD-Core Version:    0.7.0.1
 */