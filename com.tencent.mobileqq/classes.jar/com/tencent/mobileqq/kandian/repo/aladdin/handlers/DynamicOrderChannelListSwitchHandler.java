package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DynamicOrderChannelListSwitchHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    paramString = AladdinParseUtils.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      if (TextUtils.equals("readinjoyClickChannelView", str1)) {
        RIJSPUtils.a("sp_key_readinjoy_click_channel_view", Boolean.valueOf(TextUtils.equals(str2, "1")));
      } else if (TextUtils.equals("readinjoySlideChannelView", str1)) {
        RIJSPUtils.a("sp_key_readinjoy_slide_channel_view", Boolean.valueOf(TextUtils.equals(str2, "1")));
      } else if (TextUtils.equals("readinjoyClickDiversionCard", str1)) {
        RIJSPUtils.a("sp_key_readinjoy_click_diversion_card", Boolean.valueOf(TextUtils.equals(str2, "1")));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    Boolean localBoolean = Boolean.valueOf(false);
    RIJSPUtils.a("sp_key_readinjoy_click_channel_view", localBoolean);
    RIJSPUtils.a("sp_key_readinjoy_slide_channel_view", localBoolean);
    RIJSPUtils.a("sp_key_readinjoy_click_diversion_card", localBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.DynamicOrderChannelListSwitchHandler
 * JD-Core Version:    0.7.0.1
 */