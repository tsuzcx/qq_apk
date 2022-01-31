package com.tencent.open.agent.report;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class BaseData
  implements Serializable
{
  protected static final long serialVersionUID = 10000L;
  public final HashMap<String, String> attrs = new HashMap();
  
  public BaseData(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.attrs.put(str, paramBundle.getString(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.BaseData
 * JD-Core Version:    0.7.0.1
 */