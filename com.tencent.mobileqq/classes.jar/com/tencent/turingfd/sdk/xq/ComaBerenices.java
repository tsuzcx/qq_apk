package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComaBerenices
{
  public static final public<ComaBerenices> a = new ComaBerenices.do();
  public Map<String, ComaBerenices.for> b = new HashMap();
  public Map<String, ComaBerenices.if> c = new HashMap();
  public Crux d;
  
  public static ComaBerenices a()
  {
    return (ComaBerenices)a.b();
  }
  
  public void a(Context paramContext, String paramString, int paramInt, Crux paramCrux)
  {
    this.d = paramCrux;
    if (this.b.get(paramString) == null)
    {
      paramContext = new ComaBerenices.for(this, paramString, paramInt);
      this.b.put(paramString, paramContext);
      Draco.c.add(paramContext);
    }
    if (this.c.get(paramString) == null)
    {
      paramContext = new ComaBerenices.if(this, paramInt);
      this.c.put(paramString, paramContext);
      Draco.d.add(paramContext);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = (ComaBerenices.for)this.b.get(paramString);
    Draco.c.remove(localObject);
    this.b.remove(paramString);
    localObject = (ComaBerenices.if)this.c.get(paramString);
    Draco.d.remove(localObject);
    this.c.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.ComaBerenices
 * JD-Core Version:    0.7.0.1
 */