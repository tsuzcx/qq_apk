package com.tencent.tkd.comment.publisher.qq.util;

import android.os.Bundle;
import com.tencent.tkd.comment.publisher.qq.QQPublishCommentManager;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;

public class TkdQQReport
{
  public static void asyncPublicAccountReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("toUin", paramString1);
    localBundle.putString("subAction", paramString2);
    localBundle.putString("actionName", paramString3);
    localBundle.putInt("fromType", 0);
    localBundle.putInt("result", 0);
    localBundle.putString("r2", paramString4);
    localBundle.putString("r3", paramString5);
    localBundle.putString("r4", paramString6);
    localBundle.putString("r5", paramString7);
    localBundle.putBoolean("shouldEncode", false);
    QQPublishCommentManager.getInstance().getReportBridge().asyncReport(localBundle);
  }
  
  public static int getCommentLevel()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getCommentLevel();
  }
  
  public static long getConsumeTime()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getConsumeTime();
  }
  
  public static int getEntry()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getEntry();
  }
  
  public static int getFolderStatus()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getFolderStatus();
  }
  
  public static String getReportVersion()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getReportVersion();
  }
  
  public static int getScene()
  {
    return QQPublishCommentManager.getInstance().getReportBridge().getScene();
  }
  
  public static void publicAccountReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("toUin", paramString1);
    localBundle.putString("subAction", paramString2);
    localBundle.putString("actionName", paramString3);
    localBundle.putInt("fromType", 0);
    localBundle.putInt("result", 0);
    localBundle.putString("r2", paramString4);
    localBundle.putString("r3", paramString5);
    localBundle.putString("r4", paramString6);
    localBundle.putString("r5", paramString7);
    localBundle.putBoolean("shouldEncode", false);
    QQPublishCommentManager.getInstance().getReportBridge().report(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.util.TkdQQReport
 * JD-Core Version:    0.7.0.1
 */