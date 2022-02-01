package com.tencent.mobileqq.utils;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteDatabase;

public class MessageDBUtils
{
  public static StringBuilder a(String paramString1, long paramLong1, int paramInt1, long paramLong2, String paramString2, int paramInt2, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool = a(paramString1, paramSQLiteDatabase);
    if (paramInt1 <= 0) {
      bool = false;
    }
    if (paramString2 != null)
    {
      paramSQLiteDatabase = paramString2;
      if (paramString2.length() != 0) {}
    }
    else
    {
      paramSQLiteDatabase = "";
    }
    if (bool)
    {
      paramString2 = new StringBuilder("select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString2.append(" , shmsgseq as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" where shmsgseq>=");
      paramString2.append(paramLong2);
      paramString2.append(paramSQLiteDatabase);
      paramString2.append(" order by shmsgseq asc , _id asc limit ");
      paramString2.append(paramInt2);
      return paramString2;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if (paramInt1 <= 0) {
      bool1 = false;
    }
    if (paramLong2 < 0L) {
      paramLong2 = 9223372036854775807L;
    }
    if ((paramString3 != null) && (paramString3.length() != 0)) {
      break label62;
    }
    paramString3 = "";
    label62:
    if ((bool1) && (bool2))
    {
      StringBuilder localStringBuilder = new StringBuilder("select ");
      localStringBuilder.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      localStringBuilder.append(" , time as _index from ( select * from ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" where time<");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString3);
      localStringBuilder.append(") order by time desc, _id desc");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      if (paramSQLiteDatabase == null)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = paramSQLiteDatabase.getCount();
        paramSQLiteDatabase.close();
      }
      if (paramInt1 >= paramInt2)
      {
        localStringBuilder.append(" limit ");
        localStringBuilder.append(paramInt2);
        paramString1 = new StringBuilder("select * from ( ");
        paramString1.append(localStringBuilder);
        paramString1.append(") order by time desc, _id desc");
        return paramString1;
      }
      paramSQLiteDatabase = new StringBuilder("select * from ( ");
      paramSQLiteDatabase.append("select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time<( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1) order by time desc limit 1) ");
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append("order by _id desc limit ");
      paramSQLiteDatabase.append(paramInt2 - paramInt1);
      paramSQLiteDatabase.append(") ");
      paramSQLiteDatabase.append("union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" where time<");
      paramSQLiteDatabase.append(paramLong2);
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append(") order by _index desc, _id desc)");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" where _id<");
      paramString2.append(paramLong1);
      paramString2.append(paramString3);
      paramString2.append(" order by _id desc limit ");
      paramString2.append(paramInt2);
      paramString2.append(") order by _id desc");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , isValid, time as _index from ");
      paramString1.append(paramString2);
      paramString1.append(" where time<");
      paramString1.append(paramLong2);
      paramString1.append(paramString3);
      paramString1.append(") order by time desc, _id desc");
      paramString1.append(" limit ");
      paramString1.append(paramInt2);
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, String paramString3, int paramInt2, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if (paramInt1 <= 0) {
      bool1 = false;
    }
    if ((paramString3 != null) && (paramString3.length() != 0)) {
      break label47;
    }
    paramString3 = "";
    label47:
    if ((bool1) && (bool2))
    {
      StringBuilder localStringBuilder = new StringBuilder("select ");
      localStringBuilder.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      localStringBuilder.append(" , shmsgseq as _index from ( select * from ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" where shmsgseq<=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString3);
      localStringBuilder.append(") order by shmsgseq desc , _id desc");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      if (paramSQLiteDatabase == null)
      {
        paramInt1 = 0;
      }
      else
      {
        paramInt1 = paramSQLiteDatabase.getCount();
        paramSQLiteDatabase.close();
      }
      if (paramInt1 >= paramInt2)
      {
        localStringBuilder.append(" limit ");
        localStringBuilder.append(paramInt2);
        paramString1 = new StringBuilder("select * from ( ");
        paramString1.append(localStringBuilder);
        paramString1.append(") ");
        paramString1.append(" order by shmsgseq desc , _id desc");
        return paramString1;
      }
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1) and shmsgseq>0 order by shmsgseq desc , _id desc limit 1) ");
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append(" order by _id desc limit ");
      paramSQLiteDatabase.append(paramInt2 - paramInt1);
      paramSQLiteDatabase.append(") union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" where shmsgseq<=");
      paramSQLiteDatabase.append(paramLong2);
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append(") order by _index asc, _id asc)");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" where _id<");
      paramString2.append(paramLong1);
      paramString2.append(paramString3);
      paramString2.append(" order by _id desc limit ");
      paramString2.append(paramInt2);
      paramString2.append(") ");
      paramString2.append(" order by _id asc");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(" where shmsgseq<=");
      paramString1.append(paramLong2);
      paramString1.append(paramString3);
      paramString1.append(" order by shmsgseq desc , _id desc limit ");
      paramString1.append(paramInt2);
      paramString1.append(") ");
      paramString1.append(" order by shmsgseq asc , _id asc");
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1) and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" order by _id asc)");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(" order by shmsgseq asc , _id asc)");
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1)  and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      paramSQLiteDatabase.append(paramString3);
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString2.append(" order by _id asc");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(paramString3);
      paramString1.append(" order by shmsgseq asc");
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3, String paramString4)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id <= ( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time < ( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1 ) order by time desc limit 1 ) ) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc )  order by _index ) ");
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        paramSQLiteDatabase.append(" where ");
        paramSQLiteDatabase.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramSQLiteDatabase.append(" order by ");
        paramSQLiteDatabase.append(paramString4);
      }
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select t.");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" t");
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        paramString2.append(" where ");
        paramString2.append(paramString3);
      }
      paramString2.append(" order by _id asc");
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramString2.append(",");
        paramString2.append(paramString4);
      }
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select t.");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , time as _index from ");
      paramString1.append(paramString2);
      paramString1.append(" t");
      if ((paramString3 != null) && (paramString3.length() > 0))
      {
        paramString1.append(" where ");
        paramString1.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramString1.append(",");
        paramString1.append(paramString4);
      }
      return paramString1;
    }
    return null;
  }
  
  public static StringBuilder a(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3, String paramString4, String paramString5)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id <= ( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where time < ( select time from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc limit 1 ) order by time desc limit 1 ) ) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , time as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by time asc )  order by _index ) ");
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        paramSQLiteDatabase.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramSQLiteDatabase.append(" where ");
        paramSQLiteDatabase.append(paramString4);
      }
      if ((paramString5 != null) && (paramString5.length() > 0))
      {
        paramSQLiteDatabase.append(" order by ");
        paramSQLiteDatabase.append(paramString5);
      }
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , 1 as isValid, -1 as _index from ");
      paramString2.append(paramString1);
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        paramString2.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramString2.append(" where ");
        paramString2.append(paramString4);
      }
      paramString2.append(" order by _id asc");
      if ((paramString5 != null) && (paramString5.length() > 0))
      {
        paramString2.append(",");
        paramString2.append(paramString5);
      }
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , time as _index from ");
      paramString1.append(paramString2);
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        paramString1.append(paramString3);
      }
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        paramString1.append(" where ");
        paramString1.append(paramString4);
      }
      paramString1.append(" order by time asc");
      if ((paramString5 != null) && (paramString5.length() > 0))
      {
        paramString1.append(",");
        paramString1.append(paramString5);
      }
      return paramString1;
    }
    return null;
  }
  
  /* Error */
  public static boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: ldc 178
    //   17: aload_0
    //   18: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   21: ifeq +5 -> 26
    //   24: iconst_1
    //   25: ireturn
    //   26: aconst_null
    //   27: astore 7
    //   29: aconst_null
    //   30: astore 8
    //   32: aload_1
    //   33: ldc 184
    //   35: iconst_1
    //   36: anewarray 16	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_0
    //   42: invokevirtual 187	java/lang/String:trim	()Ljava/lang/String;
    //   45: aastore
    //   46: invokevirtual 66	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore_0
    //   50: iload 4
    //   52: istore_3
    //   53: aload_0
    //   54: astore 8
    //   56: aload_0
    //   57: astore 7
    //   59: aload_0
    //   60: invokeinterface 191 1 0
    //   65: ifeq +26 -> 91
    //   68: aload_0
    //   69: astore 8
    //   71: aload_0
    //   72: astore 7
    //   74: aload_0
    //   75: iconst_0
    //   76: invokeinterface 195 2 0
    //   81: istore_2
    //   82: iload 4
    //   84: istore_3
    //   85: iload_2
    //   86: ifle +5 -> 91
    //   89: iconst_1
    //   90: istore_3
    //   91: iload_3
    //   92: istore 4
    //   94: aload_0
    //   95: ifnull +44 -> 139
    //   98: aload_0
    //   99: invokeinterface 74 1 0
    //   104: iload_3
    //   105: ireturn
    //   106: astore_0
    //   107: aload 8
    //   109: ifnull +10 -> 119
    //   112: aload 8
    //   114: invokeinterface 74 1 0
    //   119: aload_0
    //   120: athrow
    //   121: iload 6
    //   123: istore 4
    //   125: aload 7
    //   127: ifnull +12 -> 139
    //   130: iload 5
    //   132: istore_3
    //   133: aload 7
    //   135: astore_0
    //   136: goto -38 -> 98
    //   139: iload 4
    //   141: ireturn
    //   142: astore_0
    //   143: goto -22 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   0	146	1	paramSQLiteDatabase	SQLiteDatabase
    //   81	5	2	i	int
    //   52	81	3	bool1	boolean
    //   7	133	4	bool2	boolean
    //   1	130	5	bool3	boolean
    //   4	118	6	bool4	boolean
    //   27	107	7	str1	String
    //   30	83	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   32	50	106	finally
    //   59	68	106	finally
    //   74	82	106	finally
    //   32	50	142	java/lang/Exception
    //   59	68	142	java/lang/Exception
    //   74	82	142	java/lang/Exception
  }
  
  public static StringBuilder b(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase, String paramString3)
  {
    boolean bool1 = a(paramString2, paramSQLiteDatabase);
    boolean bool2 = a(paramString1, paramSQLiteDatabase);
    if ((bool1) && (bool2))
    {
      paramSQLiteDatabase = new StringBuilder("select * from ( select * from ( select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramSQLiteDatabase.append(" , -1 as _index from ( select * from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where _id<=( select _id from ");
      paramSQLiteDatabase.append(paramString1);
      paramSQLiteDatabase.append(" where shmsgseq<( select shmsgseq from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by shmsgseq asc limit 1)  and shmsgseq>0 order by shmsgseq desc , _id desc limit 1)) union select ");
      paramSQLiteDatabase.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramSQLiteDatabase.append(" , shmsgseq as _index from ");
      paramSQLiteDatabase.append(paramString2);
      paramSQLiteDatabase.append(" order by _index asc, _id asc)");
      paramSQLiteDatabase.append(paramString3);
      paramSQLiteDatabase.append(" )");
      return paramSQLiteDatabase;
    }
    if (bool2)
    {
      paramString2 = new StringBuilder("select * from ( select * from ( select ");
      paramString2.append("_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong");
      paramString2.append(" , -1 as _index from ");
      paramString2.append(paramString1);
      paramString2.append(" order by _id asc)");
      paramString2.append(paramString3);
      paramString2.append(" )");
      return paramString2;
    }
    if (bool1)
    {
      paramString1 = new StringBuilder("select * from ( select ");
      paramString1.append("_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ");
      paramString1.append(" , shmsgseq as _index from ");
      paramString1.append(paramString2);
      paramString1.append(paramString3);
      paramString1.append(" )");
      return paramString1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MessageDBUtils
 * JD-Core Version:    0.7.0.1
 */