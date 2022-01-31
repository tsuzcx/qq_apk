package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Emoticon;

public class EmoticonDao
  extends OGAbstractDao
{
  public EmoticonDao()
  {
    this.a = 19;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (Emoticon)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.eId = paramCursor.getString(paramCursor.getColumnIndex("eId"));
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.encryptKey = paramCursor.getString(paramCursor.getColumnIndex("encryptKey"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("isSound")))
      {
        paramBoolean = true;
        paramEntity.isSound = paramBoolean;
        paramEntity.width = paramCursor.getInt(paramCursor.getColumnIndex("width"));
        paramEntity.height = paramCursor.getInt(paramCursor.getColumnIndex("height"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("value"))) {
          break label387;
        }
        paramBoolean = true;
        label169:
        paramEntity.value = paramBoolean;
        paramEntity.magicValue = paramCursor.getString(paramCursor.getColumnIndex("magicValue"));
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.keyword = paramCursor.getString(paramCursor.getColumnIndex("keyword"));
        paramEntity.keywords = paramCursor.getString(paramCursor.getColumnIndex("keywords"));
        paramEntity.character = paramCursor.getString(paramCursor.getColumnIndex("character"));
        paramEntity.extensionWidth = paramCursor.getInt(paramCursor.getColumnIndex("extensionWidth"));
        paramEntity.extensionHeight = paramCursor.getInt(paramCursor.getColumnIndex("extensionHeight"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isAPNG"))) {
          break label392;
        }
      }
      label387:
      label392:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.isAPNG = paramBoolean;
        paramEntity.ipsiteUrl = paramCursor.getString(paramCursor.getColumnIndex("ipsiteUrl"));
        paramEntity.ipsiteName = paramCursor.getString(paramCursor.getColumnIndex("ipsiteName"));
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label169;
      }
    }
    int i = paramCursor.getColumnIndex("eId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("eId", String.class));
      i = paramCursor.getColumnIndex("epId");
      if (i != -1) {
        break label1068;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("epId", String.class));
      label465:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label1083;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("name", String.class));
      label499:
      i = paramCursor.getColumnIndex("encryptKey");
      if (i != -1) {
        break label1098;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("encryptKey", String.class));
      label533:
      i = paramCursor.getColumnIndex("isSound");
      if (i != -1) {
        break label1113;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("width");
      if (i != -1) {
        break label1140;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("width", Integer.TYPE));
      label603:
      i = paramCursor.getColumnIndex("height");
      if (i != -1) {
        break label1155;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("height", Integer.TYPE));
      label638:
      i = paramCursor.getColumnIndex("value");
      if (i != -1) {
        break label1170;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("value", Boolean.TYPE));
      i = paramCursor.getColumnIndex("magicValue");
      if (i != -1) {
        break label1197;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("magicValue", String.class));
      label707:
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label1212;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("jobType", Integer.TYPE));
      label742:
      i = paramCursor.getColumnIndex("keyword");
      if (i != -1) {
        break label1227;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("keyword", String.class));
      label776:
      i = paramCursor.getColumnIndex("keywords");
      if (i != -1) {
        break label1242;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("keywords", String.class));
      label810:
      i = paramCursor.getColumnIndex("character");
      if (i != -1) {
        break label1257;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("character", String.class));
      label844:
      i = paramCursor.getColumnIndex("extensionWidth");
      if (i != -1) {
        break label1272;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extensionWidth", Integer.TYPE));
      label879:
      i = paramCursor.getColumnIndex("extensionHeight");
      if (i != -1) {
        break label1287;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("extensionHeight", Integer.TYPE));
      label914:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label1302;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("businessExtra", String.class));
      label948:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label1317;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("isAPNG", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipsiteUrl");
      if (i != -1) {
        break label1345;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipsiteUrl", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("ipsiteName");
      if (i != -1) {
        break label1360;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ipsiteName", String.class));
      return paramEntity;
      paramEntity.eId = paramCursor.getString(i);
      break;
      label1068:
      paramEntity.epId = paramCursor.getString(i);
      break label465;
      label1083:
      paramEntity.name = paramCursor.getString(i);
      break label499;
      label1098:
      paramEntity.encryptKey = paramCursor.getString(i);
      break label533;
      label1113:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isSound = paramBoolean;
        break;
      }
      label1140:
      paramEntity.width = paramCursor.getInt(i);
      break label603;
      label1155:
      paramEntity.height = paramCursor.getInt(i);
      break label638;
      label1170:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.value = paramBoolean;
        break;
      }
      label1197:
      paramEntity.magicValue = paramCursor.getString(i);
      break label707;
      label1212:
      paramEntity.jobType = paramCursor.getInt(i);
      break label742;
      label1227:
      paramEntity.keyword = paramCursor.getString(i);
      break label776;
      label1242:
      paramEntity.keywords = paramCursor.getString(i);
      break label810;
      label1257:
      paramEntity.character = paramCursor.getString(i);
      break label844;
      label1272:
      paramEntity.extensionWidth = paramCursor.getInt(i);
      break label879;
      label1287:
      paramEntity.extensionHeight = paramCursor.getInt(i);
      break label914;
      label1302:
      paramEntity.businessExtra = paramCursor.getString(i);
      break label948;
      label1317:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        paramEntity.isAPNG = paramBoolean;
        break;
      }
      label1345:
      paramEntity.ipsiteUrl = paramCursor.getString(i);
    }
    label1360:
    paramEntity.ipsiteName = paramCursor.getString(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,eId TEXT ,epId TEXT ,name TEXT ,encryptKey TEXT ,isSound INTEGER ,width INTEGER ,height INTEGER ,value INTEGER ,magicValue TEXT ,jobType INTEGER ,keyword TEXT ,keywords TEXT ,character TEXT ,extensionWidth INTEGER ,extensionHeight INTEGER ,businessExtra TEXT ,isAPNG INTEGER ,ipsiteUrl TEXT ,ipsiteName TEXT,UNIQUE(eId,epId) ON CONFLICT IGNORE)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Emoticon)paramEntity;
    paramContentValues.put("eId", paramEntity.eId);
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("encryptKey", paramEntity.encryptKey);
    paramContentValues.put("isSound", Boolean.valueOf(paramEntity.isSound));
    paramContentValues.put("width", Integer.valueOf(paramEntity.width));
    paramContentValues.put("height", Integer.valueOf(paramEntity.height));
    paramContentValues.put("value", Boolean.valueOf(paramEntity.value));
    paramContentValues.put("magicValue", paramEntity.magicValue);
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("keyword", paramEntity.keyword);
    paramContentValues.put("keywords", paramEntity.keywords);
    paramContentValues.put("character", paramEntity.character);
    paramContentValues.put("extensionWidth", Integer.valueOf(paramEntity.extensionWidth));
    paramContentValues.put("extensionHeight", Integer.valueOf(paramEntity.extensionHeight));
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
    paramContentValues.put("isAPNG", Boolean.valueOf(paramEntity.isAPNG));
    paramContentValues.put("ipsiteUrl", paramEntity.ipsiteUrl);
    paramContentValues.put("ipsiteName", paramEntity.ipsiteName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EmoticonDao
 * JD-Core Version:    0.7.0.1
 */