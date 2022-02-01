package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.util.Pair;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import java.util.List;

public class QCircleChatUtilApiImpl
  implements IQCircleChatUtilApi
{
  public String QCIRCLE_CHAT_HIDE_MENU_KEY()
  {
    return "qcircle_chat_hide_menu_key";
  }
  
  public String QCIRLCE_CHAT_GIFT_INFO_BYTES_KEY()
  {
    return "qcirlce_chat_gift_info_bytes_key";
  }
  
  public String QCIRLCE_CHAT_SHOW_FUEL_TIPS_KEY()
  {
    return "qcircle_chat_show_fuel_tips_key";
  }
  
  public void clearQCircleChatUnread(List<String> paramList, boolean paramBoolean)
  {
    QCircleChatUtil.a(paramList, paramBoolean);
  }
  
  public String getMaxUnReadCountText(int paramInt)
  {
    return QCircleChatUtil.a(paramInt);
  }
  
  public Pair<Integer, List<String>> getQCircleChatRedPointInfo()
  {
    return QCircleChatUtil.a();
  }
  
  public boolean isQCircleChatType(int paramInt)
  {
    return QCircleChatUtil.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QCircleChatUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */