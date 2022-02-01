package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class RelationVipGrayProcessor
  extends IQConfigProcessor<RelationVipGrayBean>
{
  @NonNull
  public RelationVipGrayBean a(int paramInt)
  {
    return new RelationVipGrayBean();
  }
  
  @Nullable
  public RelationVipGrayBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      RelationVipGrayBean localRelationVipGrayBean = RelationVipGrayBean.a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("RelationVipGrayProcessor", 2, localStringBuilder.toString());
      }
      return localRelationVipGrayBean;
    }
    return new RelationVipGrayBean();
  }
  
  public void a(RelationVipGrayBean paramRelationVipGrayBean) {}
  
  public Class<RelationVipGrayBean> clazz()
  {
    return RelationVipGrayBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 490;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.RelationVipGrayProcessor
 * JD-Core Version:    0.7.0.1
 */