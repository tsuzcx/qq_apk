package com.tencent.mobileqq.nearpeople.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface INearbyMineHelper
  extends QRouteApi
{
  public abstract HashMap NEARBYMYTAB_CONFIG_EXTRAVALS();
  
  public abstract BusinessInfoCheckUpdate.AppInfo buildRedTouchAppInfo(Object paramObject, Object[] paramArrayOfObject);
  
  public abstract BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3);
  
  public abstract BusinessInfoCheckUpdate.AppInfo createRedTouchAppInfo(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getUnCountByPathIDMain(Object paramObject, int paramInt);
  
  public abstract NearbyMyTabCard readNearbyMyTabCardFromLocal(AppInterface paramAppInterface);
  
  public abstract void storeNearbyMyTabCard(AppInterface paramAppInterface, NearbyMyTabCard paramNearbyMyTabCard);
  
  public abstract void updateNearbyMyTabCard(Object paramObject, int paramInt, boolean paramBoolean);
  
  public abstract BusinessInfoCheckUpdate.AppInfo updateNearbyNumAppinfo(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.INearbyMineHelper
 * JD-Core Version:    0.7.0.1
 */