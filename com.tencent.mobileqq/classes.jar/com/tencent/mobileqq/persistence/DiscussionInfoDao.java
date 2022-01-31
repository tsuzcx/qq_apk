package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;

public class DiscussionInfoDao
  extends OGAbstractDao
{
  public DiscussionInfoDao()
  {
    this.a = 19;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool = true;
    paramBoolean = true;
    paramEntity = (DiscussionInfo)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramEntity.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramEntity.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramEntity.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramEntity.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramEntity.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramEntity.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramEntity.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramEntity.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramEntity.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramEntity.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramEntity.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramEntity.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramEntity.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramEntity.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramEntity.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramEntity.hasCollect = paramBoolean;
        paramEntity.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramEntity.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramEntity;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramEntity;
      paramEntity.uin = paramCursor.getString(i);
      break;
      label1045:
      paramEntity.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramEntity.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramEntity.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramEntity.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramEntity.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramEntity.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramEntity.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramEntity.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramEntity.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramEntity.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramEntity.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramEntity.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramEntity.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramEntity.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramEntity.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramEntity.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramEntity.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramEntity.uiControlFlag = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (DiscussionInfo)paramEntity;
    paramContentValues.put("uin", paramEntity.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramEntity.infoSeq));
    paramContentValues.put("ownerUin", paramEntity.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramEntity.inheritOwnerUin);
    paramContentValues.put("discussionName", paramEntity.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramEntity.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramEntity.timeSec));
    paramContentValues.put("faceUinSet", paramEntity.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramEntity.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramEntity.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramEntity.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramEntity.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramEntity.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramEntity.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramEntity.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramEntity.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramEntity.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramEntity.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramEntity.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.DiscussionInfoDao
 * JD-Core Version:    0.7.0.1
 */