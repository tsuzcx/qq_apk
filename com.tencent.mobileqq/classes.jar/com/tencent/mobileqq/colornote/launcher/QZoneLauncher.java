package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneLauncher
  implements ILauncher
{
  public int getType()
  {
    return 17170432;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject1 = paramColorNote.getSubType();
    if (((String)localObject1).startsWith("qzone_detail")) {
      try
      {
        Object localObject2 = new JSONObject(new String(paramColorNote.getReserve()));
        int i = ((JSONObject)localObject2).getInt("appid");
        paramColorNote = ((JSONObject)localObject2).getString("cellid");
        localObject1 = ((JSONObject)localObject2).getString("subid");
        long l = ((JSONObject)localObject2).getLong("uin");
        ((JSONObject)localObject2).getString("source");
        boolean bool = ((JSONObject)localObject2).getBoolean("mIsFromKuolie");
        Object localObject3 = ((JSONObject)localObject2).getString("mainTitle");
        String str = ((JSONObject)localObject2).getString("subType");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("req_from_kuolie", bool);
        ((Bundle)localObject2).putString("mainTitle", (String)localObject3);
        ((Bundle)localObject2).putString("subType", str);
        localObject3 = QZoneHelper.UserInfo.getInstance();
        str = Long.valueOf(l).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        QZoneHelper.forwardToDetail(paramContext, (QZoneHelper.UserInfo)localObject3, str, localStringBuilder.toString(), paramColorNote, (String)localObject1, 0, (Bundle)localObject2, true, true);
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
        return;
      }
    }
    if (((String)localObject1).startsWith("qzone_userhome")) {
      try
      {
        paramColorNote = new JSONObject(new String(paramColorNote.getReserve())).getString("visitUin");
        QZoneHelper.forwardToUserHome(paramContext, QZoneHelper.UserInfo.getInstance(), paramColorNote, 0, 0, 0, null, null, true);
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
        return;
      }
    }
    if (((String)localObject1).startsWith("qzone_famous_userhome")) {
      try
      {
        localObject1 = new JSONObject(new String(paramColorNote.getReserve()));
        paramColorNote = ((JSONObject)localObject1).getString("visitUin");
        localObject1 = ((JSONObject)localObject1).getString("webviewUrl");
        QZoneHelper.forwardToFamousUserHome(paramContext, QZoneHelper.UserInfo.getInstance(), paramColorNote, 0, 0, null, (String)localObject1, true);
        return;
      }
      catch (JSONException paramContext)
      {
        QLog.e("QZoneLauncher", 1, paramContext, new Object[0]);
      }
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.QZoneLauncher
 * JD-Core Version:    0.7.0.1
 */