package com.tencent.qqmini.miniapp.util.logmonitor;

import android.support.annotation.Nullable;
import java.util.ArrayList;

public class LogBeanUtil
{
  private static boolean detected = false;
  private static LogBean oldLogBean;
  
  @Nullable
  public static LogBean createBeanFromLine(String paramString)
  {
    LogBean localLogBean = new LogBean();
    int i = paramString.indexOf("/");
    int j = paramString.indexOf("):");
    if ((j != -1) && (i != -1))
    {
      localLogBean.tag = paramString.substring(i + 1, j + 1);
      localLogBean.msg = paramString.substring(j + 2);
      localLogBean.lev = paramString.substring(i - 1, i);
      localLogBean.time = paramString.substring(6, i - 2);
      return localLogBean;
    }
    return null;
  }
  
  public static void loadLogBeanList(String paramString1, String paramString2, String paramString3, ILoadLogListener paramILoadLogListener)
  {
    ArrayList localArrayList = new ArrayList();
    LogLoader.load(LogCatCmd.getInstance().options("-d").withTime().recentLines(1000).filter(paramString1, paramString2).commit(), new LogBeanUtil.1(paramString3, localArrayList, paramILoadLogListener));
  }
  
  private static void recordLogLine(LogBean paramLogBean, String paramString, ArrayList<LogBean> paramArrayList)
  {
    if ((!paramString.contains("FATAL EXCEPTION")) && (!paramString.startsWith(" \t... ")))
    {
      if (paramString.startsWith(" Process: ")) {
        return;
      }
      if ((oldLogBean != null) && (paramString.startsWith(" \tat ")))
      {
        paramLogBean = new StringBuilder();
        paramArrayList = oldLogBean;
        paramLogBean.append(paramArrayList.msg);
        paramLogBean.append("\n\t\t");
        paramLogBean.append(paramString);
        paramArrayList.msg = paramLogBean.toString();
        return;
      }
      oldLogBean = paramLogBean;
      paramArrayList.add(paramLogBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil
 * JD-Core Version:    0.7.0.1
 */