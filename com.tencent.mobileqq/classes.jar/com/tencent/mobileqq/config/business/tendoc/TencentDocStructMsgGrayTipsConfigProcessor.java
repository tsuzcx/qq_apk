package com.tencent.mobileqq.config.business.tendoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class TencentDocStructMsgGrayTipsConfigProcessor
  extends IQConfigProcessor<TencentDocStructMsgGrayTipsConfigBean>
{
  public static TencentDocStructMsgGrayTipsConfigBean a()
  {
    return (TencentDocStructMsgGrayTipsConfigBean)QConfigManager.a().a(348);
  }
  
  @NonNull
  public TencentDocStructMsgGrayTipsConfigBean a(int paramInt)
  {
    return new TencentDocStructMsgGrayTipsConfigBean();
  }
  
  @Nullable
  public TencentDocStructMsgGrayTipsConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TencentDocStructMsgGrayTipsConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TencentDocStructMsgGrayTipsConfigBean paramTencentDocStructMsgGrayTipsConfigBean) {}
  
  public Class<TencentDocStructMsgGrayTipsConfigBean> clazz()
  {
    return TencentDocStructMsgGrayTipsConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
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
    return 348;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */