package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;

public class QavSoDownloadHandler
  extends QavSoDownloadHandlerBase
{
  public QavSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
  }
  
  public static String e()
  {
    if (VcSystemInfo.getCpuArchitecture() <= 2) {
      return "qq.android.qav.so_665";
    }
    return "";
  }
  
  public Class<? extends XmlData> a()
  {
    return QavSoData.class;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */