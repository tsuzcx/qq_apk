package com.tencent.mobileqq.flashshow.utils;

import com.tencent.biz.qcircleshadow.lib.variation.HostEvilReportUtils;
import com.tencent.mobileqq.flashshow.bean.FSEvilReportInfo;
import com.tencent.qphone.base.util.QLog;

public class FSEvilReportUtils
{
  public static void a(FSEvilReportInfo paramFSEvilReportInfo)
  {
    HostEvilReportUtils.doEvilReport(paramFSEvilReportInfo.a, paramFSEvilReportInfo.b, paramFSEvilReportInfo.c, paramFSEvilReportInfo.d, paramFSEvilReportInfo.e, paramFSEvilReportInfo.f, paramFSEvilReportInfo.g, paramFSEvilReportInfo.h, paramFSEvilReportInfo.i, paramFSEvilReportInfo.j);
    QLog.d("FSInformUtils", 1, "report  success");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSEvilReportUtils
 * JD-Core Version:    0.7.0.1
 */