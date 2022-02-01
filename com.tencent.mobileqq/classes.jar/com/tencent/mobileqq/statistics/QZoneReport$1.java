package com.tencent.mobileqq.statistics;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.provider.LocalPhotoGroupData;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;

final class QZoneReport$1
  implements WebEventListener
{
  QZoneReport$1(QQAppInterface paramQQAppInterface) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    boolean bool = true;
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        QLog.e("[PhotoAlbum]QZoneReport", 1, "onWebEvent getTravelGroup bundle is empty");
        return;
      }
      if ("cmd.getTravelGroup".equals(paramString))
      {
        QLog.i("[PhotoAlbum]QZoneReport", 1, "onWebEvent CMD_GET_TRAVEL_GROUP");
        paramString = (LocalPhotoGroupData)paramBundle.getSerializable("groupData");
        if ((paramString != null) && (paramString.pathList != null) && (paramString.pathList.size() != 0))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("onWebEvent localPhotoGroupData:");
          paramBundle.append(paramString.toString());
          QLog.i("[PhotoAlbum]QZoneReport", 1, paramBundle.toString());
          LocalMultiProcConfig.putLong("SP_LAST_UPDATE_TIME", paramString.startTime);
        }
        else
        {
          QLog.i("[PhotoAlbum]QZoneReport", 1, "onWebEvent localPhotoGroupData == null");
        }
      }
      else
      {
        bool = false;
      }
      QZoneReport.a(this.a, bool);
      RemoteHandleManager.getInstance().removeWebEventListener(this);
      return;
    }
    QLog.e("[PhotoAlbum]QZoneReport", 1, "onWebEvent data == null || !data.containsKey(\"data\")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.QZoneReport.1
 * JD-Core Version:    0.7.0.1
 */