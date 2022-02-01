package com.tencent.mobileqq.richmedia.dc;

import java.util.HashMap;

class DCShortVideo$RecordData
  extends DataAdapter
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  
  public HashMap<String, String> a(String paramString)
  {
    if ("RealShortVideo.Record".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_cameraID", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("param_hasMultiSegments", String.valueOf(this.jdField_a_of_type_Boolean));
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.RecordData
 * JD-Core Version:    0.7.0.1
 */