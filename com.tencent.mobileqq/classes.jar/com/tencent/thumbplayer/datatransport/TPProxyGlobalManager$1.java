package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPProxyGlobalManager$1
  implements ITPDLProxyLogListener
{
  TPProxyGlobalManager$1(TPProxyGlobalManager paramTPProxyGlobalManager) {}
  
  public int d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.d(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public int e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.e(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public int i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.i(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
  
  public int w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    TPLogUtil.w(paramString2, "[" + paramString1 + ":" + paramInt + "] " + paramString3);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyGlobalManager.1
 * JD-Core Version:    0.7.0.1
 */