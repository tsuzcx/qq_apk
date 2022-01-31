package com.tencent.mobileqq.shortvideo.redbag;

import android.content.ContentValues;
import awge;
import awgf;
import awgg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="shortVideoId,uniseq")
public class VideoRedbagData
  extends awge
{
  public static String TAG = "VideoRedbagData";
  public int redBagStat;
  public String shortVideoId;
  public long uniseq;
  
  private static awgf getEntityManager()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return ((QQAppInterface)localAppRuntime).getEntityManagerFactory().createEntityManager();
    }
    return null;
  }
  
  public static void insertData(String paramString, long paramLong, int paramInt)
  {
    VideoRedbagData localVideoRedbagData = new VideoRedbagData();
    localVideoRedbagData.shortVideoId = paramString;
    localVideoRedbagData.uniseq = paramLong;
    localVideoRedbagData.redBagStat = paramInt;
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString != null) && ((paramString instanceof QQAppInterface)))
    {
      paramString = (QQAppInterface)paramString;
      ((ProxyManager)paramString.getManager(18)).a(paramString.getAccount(), 0, localVideoRedbagData.getTableName(), localVideoRedbagData, 3, null);
    }
  }
  
  public static ArrayList<Long> queryRewardMsgUniseq(String paramString)
  {
    Object localObject = getEntityManager();
    if (localObject == null)
    {
      QLog.d(TAG, 1, "query uniseq, em null");
      return new ArrayList();
    }
    localObject = (ArrayList)((awgf)localObject).a(VideoRedbagData.class, "select * from " + VideoRedbagData.class.getSimpleName() + " where shortVideoId=?", VideoRedbagData.class.getSimpleName(), "shortVideoId=?", new String[] { paramString });
    paramString = new ArrayList();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoRedbagData localVideoRedbagData = (VideoRedbagData)((Iterator)localObject).next();
        if (localVideoRedbagData.redBagStat == 0) {
          paramString.add(Long.valueOf(localVideoRedbagData.uniseq));
        }
      }
    }
    return paramString;
  }
  
  public static boolean queryRewardStat(String paramString)
  {
    awgf localawgf = getEntityManager();
    if (localawgf == null)
    {
      QLog.d(TAG, 1, "query stat, em null");
      return false;
    }
    paramString = (ArrayList)localawgf.a(VideoRedbagData.class, "select * from " + VideoRedbagData.class.getSimpleName() + " where shortVideoId=?", VideoRedbagData.class.getSimpleName(), "shortVideoId=?", new String[] { paramString });
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        if (((VideoRedbagData)paramString.next()).redBagStat == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean updateRewardStat(String paramString)
  {
    awgf localawgf = getEntityManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("redBagStat", Boolean.valueOf(true));
    return localawgf.a(VideoRedbagData.class.getSimpleName(), localContentValues, "shortVideoId=?", new String[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData
 * JD-Core Version:    0.7.0.1
 */