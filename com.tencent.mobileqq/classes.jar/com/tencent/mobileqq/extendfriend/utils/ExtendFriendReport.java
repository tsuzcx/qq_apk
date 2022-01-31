package com.tencent.mobileqq.extendfriend.utils;

import acjv;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;

public class ExtendFriendReport
{
  private static ExtendFriendReport a;
  
  public static ExtendFriendReport a()
  {
    if (a == null) {
      a = new ExtendFriendReport();
    }
    return a;
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3)
  {
    ThreadManager.post(new acjv(this, paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3), 5, null, false);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, "reportEntry");
    }
    a("", "extend_friend_entry", true, 0L, 0L, new HashMap(), "");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportEntryDuration duration=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    a("", "extend_friend_entry_duration", true, paramInt, 0L, localHashMap, "");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportPreDownload success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_pre_download", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportResUnzip success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_res_unzip", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void c(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportFeedReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_feed_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void d(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportGroupReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_group_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public void e(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendReport", 0, String.format("reportVoiceUploadReq success=%s result=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    a("", "extend_friend_voice_upload_req", paramBoolean, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport
 * JD-Core Version:    0.7.0.1
 */