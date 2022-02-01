package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;

public class QQOperationViopTipTaskDao
  extends OGAbstractDao
{
  public QQOperationViopTipTaskDao()
  {
    this.columnLen = 16;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (QQOperationViopTipTask)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.taskid = paramCursor.getInt(paramCursor.getColumnIndex("taskid"));
      paramEntity.uinType = paramCursor.getInt(paramCursor.getColumnIndex("uinType"));
      paramEntity.tipType = paramCursor.getInt(paramCursor.getColumnIndex("tipType"));
      paramEntity.adwords = paramCursor.getString(paramCursor.getColumnIndex("adwords"));
      paramEntity.clickableWord = paramCursor.getString(paramCursor.getColumnIndex("clickableWord"));
      paramEntity.linkOffset = paramCursor.getInt(paramCursor.getColumnIndex("linkOffset"));
      paramEntity.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      paramEntity.limitDayAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOCount"));
      paramEntity.limitDayAIOShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitDayAIOShowCount"));
      paramEntity.limitTotalAIOCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalAIOCount"));
      paramEntity.limitTotalShowCount = paramCursor.getInt(paramCursor.getColumnIndex("limitTotalShowCount"));
      paramEntity.keywordString = paramCursor.getString(paramCursor.getColumnIndex("keywordString"));
      paramEntity.begin = paramCursor.getString(paramCursor.getColumnIndex("begin"));
      paramEntity.end = paramCursor.getString(paramCursor.getColumnIndex("end"));
      paramEntity.frequencyTime = paramCursor.getInt(paramCursor.getColumnIndex("frequencyTime"));
      paramEntity.frequencyMessage = paramCursor.getInt(paramCursor.getColumnIndex("frequencyMessage"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("taskid");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("taskid", Integer.TYPE));
    } else {
      paramEntity.taskid = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("uinType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uinType", Integer.TYPE));
    } else {
      paramEntity.uinType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("tipType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("tipType", Integer.TYPE));
    } else {
      paramEntity.tipType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("adwords");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("adwords", String.class));
    } else {
      paramEntity.adwords = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("clickableWord");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("clickableWord", String.class));
    } else {
      paramEntity.clickableWord = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("linkOffset");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("linkOffset", Integer.TYPE));
    } else {
      paramEntity.linkOffset = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("url");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("url", String.class));
    } else {
      paramEntity.url = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("limitDayAIOCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOCount", Integer.TYPE));
    } else {
      paramEntity.limitDayAIOCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("limitDayAIOShowCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitDayAIOShowCount", Integer.TYPE));
    } else {
      paramEntity.limitDayAIOShowCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("limitTotalAIOCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalAIOCount", Integer.TYPE));
    } else {
      paramEntity.limitTotalAIOCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("limitTotalShowCount");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("limitTotalShowCount", Integer.TYPE));
    } else {
      paramEntity.limitTotalShowCount = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("keywordString");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("keywordString", String.class));
    } else {
      paramEntity.keywordString = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("begin");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("begin", String.class));
    } else {
      paramEntity.begin = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("end");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("end", String.class));
    } else {
      paramEntity.end = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("frequencyTime");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyTime", Integer.TYPE));
    } else {
      paramEntity.frequencyTime = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("frequencyMessage");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("frequencyMessage", Integer.TYPE));
      return paramEntity;
    }
    paramEntity.frequencyMessage = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (QQOperationViopTipTask)paramEntity;
    paramContentValues.put("taskid", Integer.valueOf(paramEntity.taskid));
    paramContentValues.put("uinType", Integer.valueOf(paramEntity.uinType));
    paramContentValues.put("tipType", Integer.valueOf(paramEntity.tipType));
    paramContentValues.put("adwords", paramEntity.adwords);
    paramContentValues.put("clickableWord", paramEntity.clickableWord);
    paramContentValues.put("linkOffset", Integer.valueOf(paramEntity.linkOffset));
    paramContentValues.put("url", paramEntity.url);
    paramContentValues.put("limitDayAIOCount", Integer.valueOf(paramEntity.limitDayAIOCount));
    paramContentValues.put("limitDayAIOShowCount", Integer.valueOf(paramEntity.limitDayAIOShowCount));
    paramContentValues.put("limitTotalAIOCount", Integer.valueOf(paramEntity.limitTotalAIOCount));
    paramContentValues.put("limitTotalShowCount", Integer.valueOf(paramEntity.limitTotalShowCount));
    paramContentValues.put("keywordString", paramEntity.keywordString);
    paramContentValues.put("begin", paramEntity.begin);
    paramContentValues.put("end", paramEntity.end);
    paramContentValues.put("frequencyTime", Integer.valueOf(paramEntity.frequencyTime));
    paramContentValues.put("frequencyMessage", Integer.valueOf(paramEntity.frequencyMessage));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,taskid INTEGER ,uinType INTEGER ,tipType INTEGER ,adwords TEXT ,clickableWord TEXT ,linkOffset INTEGER ,url TEXT ,limitDayAIOCount INTEGER ,limitDayAIOShowCount INTEGER ,limitTotalAIOCount INTEGER ,limitTotalShowCount INTEGER ,keywordString TEXT ,begin TEXT ,end TEXT ,frequencyTime INTEGER ,frequencyMessage INTEGER,UNIQUE(taskid) ON CONFLICT REPLACE)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.QQOperationViopTipTaskDao
 * JD-Core Version:    0.7.0.1
 */