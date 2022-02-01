package com.tencent.mobileqq.nearpeople.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;

public class NearbyMineHelperImpl
  implements INearbyMineHelper
{
  public HashMap NEARBYMYTAB_CONFIG_EXTRAVALS()
  {
    return NearbyMineHelper.a;
  }
  
  public BusinessInfoCheckUpdate.AppInfo buildRedTouchAppInfo(Object paramObject, Object[] paramArrayOfObject)
  {
    return NearbyMineHelper.a((QQAppInterface)paramObject, paramArrayOfObject);
  }
  
  public BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    return NearbyMineHelper.a(paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    return NearbyMineHelper.a(paramInt1, paramInt2, paramString1, paramString2, paramInt3);
  }
  
  public BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    return NearbyMineHelper.a(paramAppInterface, paramInt1, paramInt2, paramString1, paramString2, paramBoolean);
  }
  
  public int getUnCountByPathIDMain(Object paramObject, int paramInt)
  {
    return NearbyMineHelper.a((QQAppInterface)paramObject, paramInt);
  }
  
  public NearbyMyTabCard readNearbyMyTabCardFromLocal(AppInterface paramAppInterface)
  {
    return NearbyMineHelper.a(paramAppInterface);
  }
  
  public void storeNearbyMyTabCard(AppInterface paramAppInterface, NearbyMyTabCard paramNearbyMyTabCard)
  {
    NearbyMineHelper.a(paramAppInterface, paramNearbyMyTabCard);
  }
  
  public void updateNearbyMyTabCard(Object paramObject, int paramInt, boolean paramBoolean)
  {
    NearbyMineHelper.a((INearbyAppInterface)paramObject, paramInt, paramBoolean);
  }
  
  public BusinessInfoCheckUpdate.AppInfo updateNearbyNumAppinfo(Object paramObject, boolean paramBoolean)
  {
    return NearbyMineHelper.a((QQAppInterface)paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.impl.NearbyMineHelperImpl
 * JD-Core Version:    0.7.0.1
 */