package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

class d$b
  extends XWalkUpdater.UpdateConfig
{
  String a;
  
  public d$b(String paramString1, String paramString2)
  {
    this(null, false, a());
    this.a = paramString1;
    this.isMatchMd5 = false;
    this.isPatchUpdate = false;
    paramString1 = new StringBuilder();
    paramString1.append("local:");
    paramString1.append(paramString2);
    this.versionDetail = paramString1.toString();
  }
  
  private d$b(String paramString, boolean paramBoolean, int paramInt)
  {
    super(paramString, paramBoolean, paramInt, XWalkEnvironment.getRuntimeAbi(), 0);
  }
  
  static int a()
  {
    int j = XWalkEnvironment.getAvailableVersion();
    int i = 100000000;
    if (j >= 100000000) {
      i = j + 1;
    }
    return i;
  }
  
  public boolean checkValid()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.b
 * JD-Core Version:    0.7.0.1
 */