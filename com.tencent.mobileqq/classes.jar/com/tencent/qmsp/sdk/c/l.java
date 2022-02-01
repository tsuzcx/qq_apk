package com.tencent.qmsp.sdk.c;

import com.tencent.qmsp.sdk.app.QmspSDK;
import java.util.HashMap;

public class l
  implements c
{
  private HashMap<String, e> a = new HashMap();
  
  public void a(e parame)
  {
    String str = parame.a();
    if ((str != null) && (!this.a.containsKey(str))) {
      this.a.put(str, parame);
    }
  }
  
  public Object getApplicationContext()
  {
    return QmspSDK.getContext();
  }
  
  public int getRuntimeVersion()
  {
    return 512;
  }
  
  public e queryRuntimeInterface(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    e locale = (e)this.a.get(paramString);
    if ((locale != null) && (!paramString.equals(locale.a()))) {
      return null;
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.l
 * JD-Core Version:    0.7.0.1
 */