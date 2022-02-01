package com.tencent.mobileqq.vaswebviewplugin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Map;

public class HealthUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "HealthUiPlugin";
  public boolean mIsJDUpdateConfigInit;
  public ArrayList<String> mJDUpdateConfig = new ArrayList(4);
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramLong == 16L) {
      ThreadManager.post(new HealthUiPlugin.1(this, paramString), 5, null, false);
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 65536L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 19L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin
 * JD-Core Version:    0.7.0.1
 */