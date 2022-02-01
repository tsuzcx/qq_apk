package com.tencent.mobileqq.studyroom.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
import com.tencent.mobileqq.studyroom.utils.StudyRoomNewReporter;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StudyRoomReporterImpl
  implements IStudyRoomReporter
{
  private static final String NETWORK_TYPE = "network_type";
  private static final String QQ = "qq";
  private static final String TAG = "studyroom.StudyRoomReporter";
  
  public static void report(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str1 = paramBundle.getString("action");
    Object localObject1 = paramBundle.getString("page");
    Object localObject2 = paramBundle.getString("module");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      str1 = String.format("%s#%s#%s", new Object[] { str1, localObject1, localObject2 });
      localObject1 = new HashMap();
      localObject2 = paramBundle.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        String str3 = paramBundle.getString(str2);
        if (!TextUtils.isEmpty(str3)) {
          ((HashMap)localObject1).put(str2, str3);
        }
      }
      int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 6) {
                  ((HashMap)localObject1).put("network_type", "5");
                }
              }
              else {
                ((HashMap)localObject1).put("network_type", "4");
              }
            }
            else {
              ((HashMap)localObject1).put("network_type", "2");
            }
          }
          else {
            ((HashMap)localObject1).put("network_type", "3");
          }
        }
        else {
          ((HashMap)localObject1).put("network_type", "1");
        }
      }
      else {
        ((HashMap)localObject1).put("network_type", "0");
      }
      ((HashMap)localObject1).put("qq", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
      UserAction.onUserAction(str1, true, -1L, -1L, (Map)localObject1, true, true);
      StudyRoomNewReporter.a(str1, true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public void reportForExpandEntry()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("action", "click");
    localBundle.putString("page", "kuolie");
    localBundle.putString("module", "selfstudy");
    report(localBundle);
  }
  
  public void reportForTroopEntry(long paramLong, String paramString)
  {
    if (paramLong == 101889454L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("action", "click");
      localBundle.putString("page", "group_page");
      localBundle.putString("module", "studyroom_entry");
      localBundle.putString("room_id", paramString);
      report(localBundle);
    }
  }
  
  public void reportWithBundle(Bundle paramBundle)
  {
    report(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomReporterImpl
 * JD-Core Version:    0.7.0.1
 */