package com.tencent.mobileqq.remind;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.qphone.base.util.QLog;

public class CalendarHelper
{
  private static String jdField_a_of_type_JavaLangString = "remind";
  public static final String[] a;
  private static String b = "content://calendar/calendars";
  private static String c = "content://calendar/events";
  private static String d = "content://calendar/reminders";
  private Context jdField_a_of_type_AndroidContentContext;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "com.android.calendar", "com.google.android.calendar" };
    b = "";
    c = "";
    d = "";
    if (Build.VERSION.SDK_INT >= 8)
    {
      b = "content://com.android.calendar/calendars";
      c = "content://com.android.calendar/events";
      d = "content://com.android.calendar/reminders";
      return;
    }
  }
  
  public CalendarHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int[] paramArrayOfInt)
  {
    if ((paramString1 == null) || (paramString1.equals("")) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {
      return -9;
    }
    long l = a();
    if ((l == -1L) && (QLog.isColorLevel())) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "insert2Calendar step3 ,try insert Acount");
    }
    if (l == -1L) {
      return -1;
    }
    if (a(paramString1, l, paramLong1, paramLong2, paramString2, paramString3, paramArrayOfInt)) {
      return 0;
    }
    return -9;
  }
  
  /* Error */
  public long a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 58	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   4: invokevirtual 91	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: getstatic 29	com/tencent/mobileqq/remind/CalendarHelper:b	Ljava/lang/String;
    //   10: invokestatic 97	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore 4
    //   22: aload 4
    //   24: ifnull +132 -> 156
    //   27: aload 4
    //   29: invokeinterface 109 1 0
    //   34: ifle +122 -> 156
    //   37: aload 4
    //   39: invokeinterface 112 1 0
    //   44: pop
    //   45: aload 4
    //   47: aload 4
    //   49: ldc 114
    //   51: invokeinterface 118 2 0
    //   56: invokeinterface 122 2 0
    //   61: istore_1
    //   62: iload_1
    //   63: i2l
    //   64: lstore_2
    //   65: aload 4
    //   67: ifnull +10 -> 77
    //   70: aload 4
    //   72: invokeinterface 125 1 0
    //   77: lload_2
    //   78: lreturn
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 4
    //   84: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +14 -> 101
    //   90: getstatic 17	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: iconst_2
    //   94: ldc 127
    //   96: aload 5
    //   98: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload 4
    //   103: ifnull +49 -> 152
    //   106: aload 4
    //   108: invokeinterface 125 1 0
    //   113: ldc2_w 67
    //   116: lreturn
    //   117: astore 5
    //   119: aconst_null
    //   120: astore 4
    //   122: aload 4
    //   124: ifnull +10 -> 134
    //   127: aload 4
    //   129: invokeinterface 125 1 0
    //   134: aload 5
    //   136: athrow
    //   137: astore 5
    //   139: goto -17 -> 122
    //   142: astore 5
    //   144: goto -22 -> 122
    //   147: astore 5
    //   149: goto -65 -> 84
    //   152: ldc2_w 67
    //   155: lreturn
    //   156: ldc2_w 67
    //   159: lstore_2
    //   160: goto -95 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	CalendarHelper
    //   61	2	1	i	int
    //   64	96	2	l	long
    //   20	108	4	localCursor	android.database.Cursor
    //   79	18	5	localException1	Exception
    //   117	18	5	localObject1	Object
    //   137	1	5	localObject2	Object
    //   142	1	5	localObject3	Object
    //   147	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	79	java/lang/Exception
    //   0	22	117	finally
    //   27	62	137	finally
    //   84	101	142	finally
    //   27	62	147	java/lang/Exception
  }
  
  public boolean a(long paramLong, int[] paramArrayOfInt)
  {
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      boolean bool2;
      try
      {
        if (i < paramArrayOfInt.length)
        {
          Object localObject = new ContentValues();
          ((ContentValues)localObject).put("event_id", Long.valueOf(paramLong));
          ((ContentValues)localObject).put("method", Integer.valueOf(1));
          ((ContentValues)localObject).put("minutes", Integer.valueOf(paramArrayOfInt[i]));
          localObject = this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(d), (ContentValues)localObject);
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (localObject != null) {
              bool2 = true;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind success");
          }
          return bool1;
        }
      }
      catch (Exception paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind failed");
        }
        paramArrayOfInt.printStackTrace();
        return bool1;
      }
      i += 1;
      bool1 = bool2;
    }
  }
  
  public boolean a(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3, int[] paramArrayOfInt)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("title", paramString1);
      localContentValues.put("calendar_id", Long.valueOf(paramLong1));
      localContentValues.put("dtstart", Long.valueOf(paramLong2));
      localContentValues.put("dtend", Long.valueOf(paramLong3));
      localContentValues.put("hasAlarm", Integer.valueOf(1));
      localContentValues.put("eventTimezone", Time.getCurrentTimezone());
      localContentValues.put("eventStatus", Integer.valueOf(1));
      localContentValues.put("hasAttendeeData", Integer.valueOf(1));
      if (!TextUtils.isEmpty(paramString2)) {
        localContentValues.put("description", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localContentValues.put("eventLocation", paramString3);
      }
      paramLong1 = Long.parseLong(this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(c), localContentValues).getLastPathSegment());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event success");
      }
      if (paramArrayOfInt != null)
      {
        paramString1 = paramArrayOfInt;
        if (paramArrayOfInt.length >= 1) {}
      }
      else
      {
        paramString1 = new int[1];
        paramString1[0] = 0;
      }
      boolean bool = a(paramLong1, paramString1);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event failed");
      }
      paramString1.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.remind.CalendarHelper
 * JD-Core Version:    0.7.0.1
 */