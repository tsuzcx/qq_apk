package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;

public class QavSoDownloadHandler
  extends QavSoDownloadHandlerBase
{
  public QavSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
  }
  
  public static String e()
  {
    if (VcSystemInfo.f() <= 2) {
      return "qq.android.qav.so_665";
    }
    return "qq.android.qav.sov7_755";
  }
  
  public Class a()
  {
    return QavSoData.class;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */