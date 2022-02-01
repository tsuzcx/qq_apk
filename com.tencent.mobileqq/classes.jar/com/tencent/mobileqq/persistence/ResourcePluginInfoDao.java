package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.ResourcePluginInfo;

public class ResourcePluginInfoDao
  extends OGAbstractDao
{
  public ResourcePluginInfoDao()
  {
    this.columnLen = 23;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.strPkgName = paramCursor.getString(paramCursor.getColumnIndex("strPkgName"));
      paramEntity.strResName = paramCursor.getString(paramCursor.getColumnIndex("strResName"));
      paramEntity.strResURL = paramCursor.getString(paramCursor.getColumnIndex("strResURL"));
      paramEntity.uiCurVer = paramCursor.getLong(paramCursor.getColumnIndex("uiCurVer"));
      paramEntity.sLanType = paramCursor.getShort(paramCursor.getColumnIndex("sLanType"));
      paramEntity.strGotoUrl = paramCursor.getString(paramCursor.getColumnIndex("strGotoUrl"));
      paramEntity.sResSubType = paramCursor.getShort(paramCursor.getColumnIndex("sResSubType"));
      paramEntity.sPriority = paramCursor.getShort(paramCursor.getColumnIndex("sPriority"));
      paramEntity.strResDesc = paramCursor.getString(paramCursor.getColumnIndex("strResDesc"));
      paramEntity.uiResId = paramCursor.getLong(paramCursor.getColumnIndex("uiResId"));
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDefaultState")));
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cCanChangeState")));
      paramEntity.isNew = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("isNew")));
      paramEntity.cDataType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cDataType")));
      paramEntity.cLocalState = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("cLocalState")));
      paramEntity.iPluginType = paramCursor.getInt(paramCursor.getColumnIndex("iPluginType"));
      paramEntity.timeStamp = paramCursor.getLong(paramCursor.getColumnIndex("timeStamp"));
      paramEntity.strNewPluginDesc = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginDesc"));
      paramEntity.strNewPluginURL = paramCursor.getString(paramCursor.getColumnIndex("strNewPluginURL"));
      paramEntity.lebaSearchResultType = paramCursor.getInt(paramCursor.getColumnIndex("lebaSearchResultType"));
      paramEntity.pluginSetTips = paramCursor.getString(paramCursor.getColumnIndex("pluginSetTips"));
      paramEntity.pluginBg = paramCursor.getString(paramCursor.getColumnIndex("pluginBg"));
      paramEntity.flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("strPkgName");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strPkgName", String.class));
    } else {
      paramEntity.strPkgName = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("strResName");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResName", String.class));
    } else {
      paramEntity.strResName = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("strResURL");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResURL", String.class));
    } else {
      paramEntity.strResURL = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("uiCurVer");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiCurVer", Long.TYPE));
    } else {
      paramEntity.uiCurVer = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("sLanType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sLanType", Short.TYPE));
    } else {
      paramEntity.sLanType = paramCursor.getShort(i);
    }
    i = paramCursor.getColumnIndex("strGotoUrl");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strGotoUrl", String.class));
    } else {
      paramEntity.strGotoUrl = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("sResSubType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sResSubType", Short.TYPE));
    } else {
      paramEntity.sResSubType = paramCursor.getShort(i);
    }
    i = paramCursor.getColumnIndex("sPriority");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("sPriority", Short.TYPE));
    } else {
      paramEntity.sPriority = paramCursor.getShort(i);
    }
    i = paramCursor.getColumnIndex("strResDesc");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strResDesc", String.class));
    } else {
      paramEntity.strResDesc = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("uiResId");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("uiResId", Long.TYPE));
    } else {
      paramEntity.uiResId = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("cDefaultState");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDefaultState", Byte.TYPE));
    } else {
      paramEntity.cDefaultState = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("cCanChangeState");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cCanChangeState", Byte.TYPE));
    } else {
      paramEntity.cCanChangeState = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("isNew");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isNew", Byte.TYPE));
    } else {
      paramEntity.isNew = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("cDataType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cDataType", Byte.TYPE));
    } else {
      paramEntity.cDataType = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("cLocalState");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("cLocalState", Byte.TYPE));
    } else {
      paramEntity.cLocalState = ((byte)paramCursor.getShort(i));
    }
    i = paramCursor.getColumnIndex("iPluginType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("iPluginType", Integer.TYPE));
    } else {
      paramEntity.iPluginType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("timeStamp");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("timeStamp", Long.TYPE));
    } else {
      paramEntity.timeStamp = paramCursor.getLong(i);
    }
    i = paramCursor.getColumnIndex("strNewPluginDesc");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginDesc", String.class));
    } else {
      paramEntity.strNewPluginDesc = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("strNewPluginURL");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginURL", String.class));
    } else {
      paramEntity.strNewPluginURL = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("lebaSearchResultType");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("lebaSearchResultType", Integer.TYPE));
    } else {
      paramEntity.lebaSearchResultType = paramCursor.getInt(i);
    }
    i = paramCursor.getColumnIndex("pluginSetTips");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginSetTips", String.class));
    } else {
      paramEntity.pluginSetTips = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("pluginBg");
    if (i == -1) {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginBg", String.class));
    } else {
      paramEntity.pluginBg = paramCursor.getString(i);
    }
    i = paramCursor.getColumnIndex("flags");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("flags", Integer.TYPE));
      return paramEntity;
    }
    paramEntity.flags = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (ResourcePluginInfo)paramEntity;
    paramContentValues.put("strPkgName", paramEntity.strPkgName);
    paramContentValues.put("strResName", paramEntity.strResName);
    paramContentValues.put("strResURL", paramEntity.strResURL);
    paramContentValues.put("uiCurVer", Long.valueOf(paramEntity.uiCurVer));
    paramContentValues.put("sLanType", Short.valueOf(paramEntity.sLanType));
    paramContentValues.put("strGotoUrl", paramEntity.strGotoUrl);
    paramContentValues.put("sResSubType", Short.valueOf(paramEntity.sResSubType));
    paramContentValues.put("sPriority", Short.valueOf(paramEntity.sPriority));
    paramContentValues.put("strResDesc", paramEntity.strResDesc);
    paramContentValues.put("uiResId", Long.valueOf(paramEntity.uiResId));
    paramContentValues.put("cDefaultState", Byte.valueOf(paramEntity.cDefaultState));
    paramContentValues.put("cCanChangeState", Byte.valueOf(paramEntity.cCanChangeState));
    paramContentValues.put("isNew", Byte.valueOf(paramEntity.isNew));
    paramContentValues.put("cDataType", Byte.valueOf(paramEntity.cDataType));
    paramContentValues.put("cLocalState", Byte.valueOf(paramEntity.cLocalState));
    paramContentValues.put("iPluginType", Integer.valueOf(paramEntity.iPluginType));
    paramContentValues.put("timeStamp", Long.valueOf(paramEntity.timeStamp));
    paramContentValues.put("strNewPluginDesc", paramEntity.strNewPluginDesc);
    paramContentValues.put("strNewPluginURL", paramEntity.strNewPluginURL);
    paramContentValues.put("lebaSearchResultType", Integer.valueOf(paramEntity.lebaSearchResultType));
    paramContentValues.put("pluginSetTips", paramEntity.pluginSetTips);
    paramContentValues.put("pluginBg", paramEntity.pluginBg);
    paramContentValues.put("flags", Integer.valueOf(paramEntity.flags));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.ResourcePluginInfoDao
 * JD-Core Version:    0.7.0.1
 */