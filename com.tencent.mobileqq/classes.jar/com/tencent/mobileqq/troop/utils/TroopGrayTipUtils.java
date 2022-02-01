package com.tencent.mobileqq.troop.utils;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.GrayTipsMessageConstants.HighlightItem;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopGrayTipUtils
{
  public static void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, List<String> paramList, long paramLong)
  {
    long l = LocalMultiProcConfig.getLong4Uin("aio_qzone_troop_gray_tips", 0L, Long.parseLong(paramString2));
    if (System.currentTimeMillis() <= l * 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGrayTipUtils", 2, "Unable to display gray tips during cool down");
      }
      return;
    }
    int i = QzoneConfig.getInstance().getConfig("aio_qzone_troop_gray_tips", "troop_gray_tips_min_photo_count", 9);
    if (paramList.size() < i)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("Unable to display gray tips, current photos count: ");
        paramAppRuntime.append(paramList.size());
        paramAppRuntime.append(" required min photos count: ");
        paramAppRuntime.append(i);
        QLog.d("TroopGrayTipUtils", 2, paramAppRuntime.toString());
      }
      return;
    }
    Object localObject = HardCodeUtil.a(2131917534);
    String str2 = HardCodeUtil.a(2131917532);
    String str1 = HardCodeUtil.a(2131917533);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" ");
    localStringBuilder.append(str1);
    str2 = localStringBuilder.toString();
    paramString1 = new UniteGrayTipParam(paramString1, paramString2, str2, 1, -5040, 131086, System.currentTimeMillis() / 1000L);
    localStringBuilder = new StringBuilder();
    i = 0;
    while (i < paramList.size())
    {
      if (i != paramList.size() - 1)
      {
        localStringBuilder.append((String)paramList.get(i));
        localStringBuilder.append(",");
      }
      else
      {
        localStringBuilder.append((String)paramList.get(i));
      }
      i += 1;
    }
    paramList = new ArrayList();
    i = BaseApplicationImpl.getApplication().getResources().getColor(2131168418);
    localObject = new GrayTipsMessageConstants.HighlightItem(0, ((String)localObject).length(), Long.parseLong(paramString2), 0, 50, localStringBuilder.toString(), "", "", "", i);
    paramString2 = new GrayTipsMessageConstants.HighlightItem(str2.length() - str1.length(), str2.length(), Long.parseLong(paramString2), 0, 51, "", "", "", "", i);
    paramList.add(localObject);
    paramList.add(paramString2);
    paramString1.a(paramList);
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramAppRuntime, paramString1);
    paramString1 = new StringBuilder();
    paramString1.append(paramLong);
    paramString1.append("");
    paramString2.saveExtInfoToExtStr("grayLastUniseq", paramString1.toString());
    UniteGrayTipMsgUtil.a(paramAppRuntime, paramString2);
    LpReportInfo_pf00064.allReport(40, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGrayTipUtils
 * JD-Core Version:    0.7.0.1
 */