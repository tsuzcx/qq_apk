package com.tencent.mobileqq.qcircle.tempapi.api;

import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQCircleChatUtilApi
  extends QRouteApi
{
  public abstract void clearQCircleChatUnread(List<String> paramList, boolean paramBoolean);
  
  public abstract String getMaxUnReadCountText(int paramInt);
  
  public abstract Pair<Integer, List<String>> getQCircleChatRedPointInfo();
  
  public abstract boolean isQCircleChatType(int paramInt);
  
  public abstract String qcircleChatHideMenuKey();
  
  public abstract String qcirlceChatGiftInfoBytesKey();
  
  public abstract String qcirlceChatShowFuelTipsKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
 * JD-Core Version:    0.7.0.1
 */