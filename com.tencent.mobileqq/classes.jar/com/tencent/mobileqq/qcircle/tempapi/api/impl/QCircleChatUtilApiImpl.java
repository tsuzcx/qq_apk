package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import android.util.Pair;
import com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil;
import com.tencent.mobileqq.qcircle.tempapi.api.IQCircleChatUtilApi;
import java.util.List;

public class QCircleChatUtilApiImpl
  implements IQCircleChatUtilApi
{
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
    return QCircleChatUtil.b(paramInt);
  }
  
  public String qcircleChatHideMenuKey()
  {
    return "qcircle_chat_hide_menu_key";
  }
  
  public String qcirlceChatGiftInfoBytesKey()
  {
    return "qcirlce_chat_gift_info_bytes_key";
  }
  
  public String qcirlceChatShowFuelTipsKey()
  {
    return "qcircle_chat_show_fuel_tips_key";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QCircleChatUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */