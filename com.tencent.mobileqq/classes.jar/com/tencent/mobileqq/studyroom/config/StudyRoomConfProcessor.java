package com.tencent.mobileqq.studyroom.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class StudyRoomConfProcessor
  extends IQConfigProcessor<StudyRoomConfBean>
{
  public static StudyRoomConfBean a()
  {
    return (StudyRoomConfBean)QConfigManager.a().a(612);
  }
  
  public static void a()
  {
    QConfigManager.a().a(new int[] { 612 });
  }
  
  @NonNull
  public StudyRoomConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new StudyRoomConfBean();
  }
  
  @Nullable
  public StudyRoomConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onParsed]");
    }
    StudyRoomConfBean localStudyRoomConfBean = new StudyRoomConfBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      if ((paramArrayOfQConfItem == null) || (TextUtils.isEmpty(paramArrayOfQConfItem.a))) {}
    }
    try
    {
      localStudyRoomConfBean.a = new JSONObject(paramArrayOfQConfItem.a);
      return localStudyRoomConfBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("StudyRoomConfProcessor", 4, paramArrayOfQConfItem, new Object[0]);
    }
    return localStudyRoomConfBean;
  }
  
  public void a(StudyRoomConfBean paramStudyRoomConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onUpdate] newConf:" + paramStudyRoomConfBean);
    }
  }
  
  public Class<StudyRoomConfBean> clazz()
  {
    return StudyRoomConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[get migrateOldVersion]");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomConfProcessor", 2, "onReqNoReceive: type=" + type() + "curContent:" + a());
    }
  }
  
  public int type()
  {
    return 612;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor
 * JD-Core Version:    0.7.0.1
 */