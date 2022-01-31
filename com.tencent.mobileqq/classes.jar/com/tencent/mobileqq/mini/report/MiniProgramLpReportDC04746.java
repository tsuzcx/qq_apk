package com.tencent.mobileqq.mini.report;

import android.os.Build.VERSION;
import bcyb;
import bgyi;
import java.util.ArrayList;
import java.util.List;
import naj;

public class MiniProgramLpReportDC04746
{
  public static final int SPLASH_GUIDE_CLICKED = 1;
  public static final int SPLASH_GUIDE_EXPOSE = 6;
  public static final int SPLASH_GUIDE_EXPOSE_ONLY = 0;
  public static final int SPLASH_PIC_EXPOSE = 2;
  public static final int SPLASH_PIC_JUMP = 1;
  public static final int SPLASH_PIC_START = 2;
  public static final int SPLASH_VIDEO_EXPOSE = 1;
  public static final int SPLASH_VIDEO_JUMP = 1;
  
  public static void report(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniProgramReportHelper.newEntry("uin", String.valueOf(bcyb.a().a())));
    localArrayList.add(MiniProgramReportHelper.newEntry("touin", ""));
    localArrayList.add(MiniProgramReportHelper.newEntry("actiontype", String.valueOf(paramInt1)));
    localArrayList.add(MiniProgramReportHelper.newEntry("subactiontype", String.valueOf(paramInt2)));
    localArrayList.add(MiniProgramReportHelper.newEntry("action_source", "shanping"));
    localArrayList.add(MiniProgramReportHelper.newEntry("qua", bgyi.a()));
    localArrayList.add(MiniProgramReportHelper.newEntry("platform", "android"));
    localArrayList.add(MiniProgramReportHelper.newEntry("os_version", Build.VERSION.RELEASE));
    localArrayList.add(MiniProgramReportHelper.newEntry("network_type", naj.a()));
    localArrayList.add(MiniProgramReportHelper.newEntry("appid", paramString1));
    localArrayList.add(MiniProgramReportHelper.newEntry("app_version", paramString2));
    paramString1 = MiniProgramReportHelper.newSingleDcData(8, String.valueOf(0), localArrayList, null);
    MiniProgramReporter.getInstance().add(paramString1);
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746
 * JD-Core Version:    0.7.0.1
 */