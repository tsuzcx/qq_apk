package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReadInJoyDropFrameAladdinCfgHandler
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
      QLog.d("ReadInJoyDropFrameAladdinCfgHandler", 1, new Object[] { "key = ", str1, ", value = ", str2 });
      if (TextUtils.equals("readinjoy_drop_frame_monitor", str1)) {
        RIJSPUtils.a("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(TextUtils.equals("1", str2)));
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("ReadInJoyDropFrameAladdinCfgHandler", 1, new Object[] { "onWipeConfig, id = ", Integer.valueOf(paramInt) });
    RIJSPUtils.a("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ReadInJoyDropFrameAladdinCfgHandler
 * JD-Core Version:    0.7.0.1
 */