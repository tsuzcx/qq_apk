package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$RecordData
  extends DataAdapter
{
  int a = 0;
  boolean b = false;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("RealShortVideo.Record".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_cameraID", String.valueOf(this.a));
      paramString.put("param_hasMultiSegments", String.valueOf(this.b));
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.RecordData
 * JD-Core Version:    0.7.0.1
 */