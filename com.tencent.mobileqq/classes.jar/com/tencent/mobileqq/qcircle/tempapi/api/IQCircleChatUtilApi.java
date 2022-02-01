package com.tencent.mobileqq.qcircle.tempapi.api;

import android.util.Pair;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQCircleChatUtilApi
  extends QRouteApi
{
  public abstract String QCIRCLE_CHAT_HIDE_MENU_KEY();
  
  public abstract String QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY();
  
  public abstract String QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY();
  
  public abstract void clearQCircleChatUnread(List<String> paramList, boolean paramBoolean);
  
  public abstract String getMaxUnReadCountText(int paramInt);
  
  public abstract Pair<Integer, List<String>> getQCircleChatRedPointInfo();
  
  public abstract boolean isQCircleChatType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi
 * JD-Core Version:    0.7.0.1
 */