package com.tencent.plato;

import com.tencent.biz.qqstory.base.BaseEvent;

public class PlatoLoadEvent
  extends BaseEvent
{
  public static final int Error = 1;
  public static final int SUCCESS = 0;
  public static final int TYPE_BUNDLER_JS = 1;
  public static final int TYPE_V8_SO = 0;
  public String bid;
  public int code;
  public String path;
  public int type;
  
  public static PlatoLoadEvent createBundlerLoadEvent(int paramInt, String paramString1, String paramString2)
  {
    PlatoLoadEvent localPlatoLoadEvent = new PlatoLoadEvent();
    localPlatoLoadEvent.code = paramInt;
    localPlatoLoadEvent.bid = paramString1;
    localPlatoLoadEvent.path = paramString2;
    localPlatoLoadEvent.type = 1;
    return localPlatoLoadEvent;
  }
  
  public static PlatoLoadEvent createSoLoadEvent(int paramInt)
  {
    PlatoLoadEvent localPlatoLoadEvent = new PlatoLoadEvent();
    localPlatoLoadEvent.code = paramInt;
    localPlatoLoadEvent.type = 0;
    return localPlatoLoadEvent;
  }
  
  public String toString()
  {
    return "PlatoLoadEvent { bid=" + this.bid + ", code= " + this.code + ", type=" + this.type + ", path= " + this.path + " }";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoLoadEvent
 * JD-Core Version:    0.7.0.1
 */