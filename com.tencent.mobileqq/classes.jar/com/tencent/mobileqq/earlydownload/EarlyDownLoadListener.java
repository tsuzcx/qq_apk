package com.tencent.mobileqq.earlydownload;

import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public abstract interface EarlyDownLoadListener
{
  public abstract void a(XmlData paramXmlData);
  
  public abstract void a(XmlData paramXmlData, long paramLong1, long paramLong2);
  
  public abstract void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString);
  
  public abstract void b(XmlData paramXmlData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownLoadListener
 * JD-Core Version:    0.7.0.1
 */