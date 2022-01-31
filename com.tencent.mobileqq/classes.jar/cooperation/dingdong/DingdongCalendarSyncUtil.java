package cooperation.dingdong;

import amkp;
import amkq;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ConcernUinData;
import com.tencent.mobileqq.app.utils.DingdongPluginBizObserver.ScheduleMoreSummaryData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimeZone;

public class DingdongCalendarSyncUtil
{
  private static String jdField_a_of_type_JavaLangString = "content://com.android.calendar/calendars";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static String b = "content://com.android.calendar/events";
  private static String c = "content://com.android.calendar/reminders";
  private static String d = "_schedule_calendar_visited";
  private static String e = "key_calendar_visited";
  
  private static String a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    Object localObject = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = BaseApplication.getContext().getString(2131428076);
    localStringBuilder.append(str + "\n");
    str = c((DingdongPluginDataFactory.ScheduleSummaryData)localObject);
    if (!TextUtils.isEmpty(str)) {
      localStringBuilder.append(str + "\n");
    }
    if (!TextUtils.isEmpty(((DingdongPluginDataFactory.ScheduleSummaryData)localObject).mark))
    {
      str = BaseApplication.getContext().getString(2131427965);
      localStringBuilder.append(str + ":");
      str = ((DingdongPluginDataFactory.ScheduleSummaryData)localObject).mark;
      localStringBuilder.append(str + "\n");
    }
    str = BaseApplication.getContext().getString(2131427999);
    localStringBuilder.append(str + ":");
    if (TextUtils.isEmpty(((DingdongPluginDataFactory.ScheduleSummaryData)localObject).authorUin)) {}
    for (localObject = "";; localObject = DingdongPluginHelper.a(0, "", ((DingdongPluginDataFactory.ScheduleSummaryData)localObject).authorUin))
    {
      localStringBuilder.append((String)localObject + "\n");
      if ((paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList != null) && (paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = BaseApplication.getContext().getString(2131427966);
        localStringBuilder.append((String)localObject + ":");
        localStringBuilder.append(a(paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList) + "\n");
      }
      return localStringBuilder.toString();
    }
  }
  
  private static String a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayList.size())
    {
      Object localObject = (DingdongPluginBizObserver.ConcernUinData)paramArrayList.get(i);
      localObject = DingdongPluginHelper.a(((DingdongPluginBizObserver.ConcernUinData)localObject).jdField_a_of_type_Int, ((DingdongPluginBizObserver.ConcernUinData)localObject).b, ((DingdongPluginBizObserver.ConcernUinData)localObject).jdField_a_of_type_JavaLangString);
      if (i == paramArrayList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((String)localObject + "、");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    BaseApplicationImpl.getApplication().getSharedPreferences(d, 0).edit().putBoolean(e, true).commit();
    try
    {
      if (!b()) {
        return;
      }
      if (!jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          b(((Integer)localPair.first).intValue(), (DingdongPluginBizObserver.ScheduleMoreSummaryData)localPair.second);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("DingdongCalendarSyncUtil", 2, "syncCacheToSystemCalendar error" + localException.getMessage());
        return;
        jdField_a_of_type_JavaUtilArrayList.clear();
        return;
        b("0");
      }
    }
  }
  
  public static void a(int paramInt, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    new amkq(paramInt).execute(new DingdongPluginBizObserver.ScheduleMoreSummaryData[] { paramScheduleMoreSummaryData });
  }
  
  private static void a(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    if ((NetConnInfoCenter.getServerTimeMillis() > localScheduleSummaryData.endTime) || (!a(localScheduleSummaryData.authorUin, paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList)) || (localScheduleSummaryData.specialFlag == 2)) {
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "createEvent:not need pass data schedule");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = b();
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DingdongCalendarSyncUtil", 2, "accountId not create");
      return;
      if (!b(localScheduleSummaryData.id))
      {
        a(str, paramScheduleMoreSummaryData);
        return;
      }
      b(paramScheduleMoreSummaryData);
    } while (!QLog.isColorLevel());
    QLog.d("DingdongCalendarSyncUtil", 2, "createEvent has event in system");
  }
  
  public static void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    if (paramScheduleSummaryData == null) {
      return;
    }
    ThreadManager.post(new amkp(paramScheduleSummaryData), 5, null, false);
  }
  
  private static void a(String paramString, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    a(localScheduleSummaryData.id, paramString, localScheduleSummaryData.title, a(paramScheduleMoreSummaryData), localScheduleSummaryData.location, localScheduleSummaryData.beginTime, localScheduleSummaryData.endTime);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    paramString1 = BaseApplication.getContext().getContentResolver().query(Uri.parse(b), null, "(customAppUri = ?) ", new String[] { paramString1 }, null);
    try
    {
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        long l = paramString1.getLong(paramString1.getColumnIndex("_id"));
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("title", paramString2);
        localContentValues.put("description", paramString3);
        localContentValues.put("eventLocation", paramString4);
        localContentValues.put("dtstart", Long.valueOf(paramLong1));
        localContentValues.put("dtend", Long.valueOf(paramLong2));
        paramString2 = ContentUris.withAppendedId(Uri.parse(b), l);
        BaseApplication.getContext().getContentResolver().update(paramString2, localContentValues, null, null);
      }
      return;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      QLog.e("DingdongCalendarSyncUtil", 2, "updateEvent: " + paramString2.getMessage());
      return;
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("customAppUri", paramString1);
    localContentValues.put("calendar_id", paramString2);
    if (paramString3 != null) {
      localContentValues.put("title", paramString3);
    }
    localContentValues.put("description", paramString4);
    if (paramString5 != null) {
      localContentValues.put("eventLocation", paramString5);
    }
    localContentValues.put("dtstart", Long.valueOf(paramLong1));
    localContentValues.put("dtend", Long.valueOf(paramLong2));
    paramString2 = TimeZone.getDefault();
    paramString1 = "";
    if (paramString2.getID() != null) {
      paramString1 = paramString2.getID();
    }
    localContentValues.put("eventTimezone", paramString1);
    BaseApplication.getContext().getContentResolver().insert(Uri.parse(b), localContentValues);
  }
  
  private static boolean a(String paramString, ArrayList paramArrayList)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      localObject = ((QQAppInterface)localObject).c();
      if (paramString.equals(localObject)) {
        return true;
      }
      if (paramArrayList != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (((String)localObject).equals(((DingdongPluginBizObserver.ConcernUinData)paramArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private static String b()
  {
    Object localObject2 = null;
    localCursor = BaseApplication.getContext().getContentResolver().query(Uri.parse(jdField_a_of_type_JavaLangString), null, "(calendar_access_level = ?) ", new String[] { "700" }, null);
    if (localCursor != null) {}
    label85:
    do
    {
      try
      {
        if (localCursor.getCount() <= 0) {
          break label85;
        }
        localCursor.moveToLast();
        String str = localCursor.getString(localCursor.getColumnIndex("_id"));
        localObject2 = str;
        if (localCursor != null)
        {
          localCursor.close();
          localObject2 = str;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("DingdongCalendarSyncUtil", 2, "getAccount: " + localException.getMessage());
        return null;
      }
      finally
      {
        if (localCursor == null) {
          break;
        }
        localCursor.close();
      }
      return localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "getSystemAccount no account in system");
      }
    } while (localCursor == null);
    localCursor.close();
    return null;
  }
  
  private static String b(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getString(2131428076)).append("\n");
    if (!TextUtils.isEmpty(paramScheduleSummaryData.mark)) {
      localStringBuilder.append(BaseApplication.getContext().getString(2131427965)).append(":").append(paramScheduleSummaryData.mark).append("\n");
    }
    Object localObject;
    if (paramScheduleSummaryData.url != null)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("url", paramScheduleSummaryData.url);
      localObject = (String)HttpUtil.a((HashMap)localObject).get("url");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!paramScheduleSummaryData.url.equals(localObject))) {
        break label159;
      }
      if (QLog.isColorLevel()) {
        QLog.e("DingdongCalendarSyncUtil", 2, "getShortURL error");
      }
    }
    for (;;)
    {
      localStringBuilder.append(paramScheduleSummaryData.url).append("\n");
      return localStringBuilder.toString();
      label159:
      paramScheduleSummaryData.url = ((String)localObject);
    }
  }
  
  public static void b(int paramInt, DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    if (!BaseApplicationImpl.getApplication().getSharedPreferences(d, 0).getBoolean(e, false)) {
      jdField_a_of_type_JavaUtilArrayList.add(new Pair(Integer.valueOf(paramInt), paramScheduleMoreSummaryData));
    }
    do
    {
      for (;;)
      {
        return;
        DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
        if (QLog.isColorLevel()) {
          QLog.d("DingdongCalendarSyncUtil", 2, "syncToSystemCalendar type = " + paramInt + " summaryData =" + localScheduleSummaryData);
        }
        try
        {
          if (b()) {
            switch (paramInt)
            {
            case 3: 
              c(paramScheduleMoreSummaryData);
              return;
            }
          }
        }
        catch (Exception paramScheduleMoreSummaryData) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("DingdongCalendarSyncUtil", 2, "syncToSystemCalendar error" + paramScheduleMoreSummaryData.getMessage());
    return;
    a(paramScheduleMoreSummaryData);
    return;
    b(paramScheduleMoreSummaryData);
    return;
    c(paramScheduleMoreSummaryData);
    return;
  }
  
  private static void b(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData;
    if ((NetConnInfoCenter.getServerTimeMillis() > localScheduleSummaryData.endTime) || (!a(localScheduleSummaryData.authorUin, paramScheduleMoreSummaryData.jdField_a_of_type_JavaUtilArrayList)) || (localScheduleSummaryData.specialFlag == 2))
    {
      c(paramScheduleMoreSummaryData);
      if (QLog.isColorLevel()) {
        QLog.d("DingdongCalendarSyncUtil", 2, "updateEvent:del pass data schedule");
      }
      return;
    }
    String str = localScheduleSummaryData.id;
    if (!b(str))
    {
      a(paramScheduleMoreSummaryData);
      return;
    }
    a(str, localScheduleSummaryData.title, a(paramScheduleMoreSummaryData), localScheduleSummaryData.location, localScheduleSummaryData.beginTime, localScheduleSummaryData.endTime);
  }
  
  private static boolean b()
  {
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    int i = localPackageManager.checkPermission("android.permission.READ_CALENDAR", BaseApplicationImpl.getContext().getPackageName());
    int j = localPackageManager.checkPermission("android.permission.WRITE_CALENDAR", BaseApplicationImpl.getContext().getPackageName());
    if ((i != 0) || (j != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongCalendarSyncUtil", 2, "[isCalendarReady] calendar has not permission " + i);
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 281	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 21	cooperation/dingdong/DingdongCalendarSyncUtil:b	Ljava/lang/String;
    //   9: invokestatic 287	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   12: aconst_null
    //   13: ldc_w 289
    //   16: iconst_1
    //   17: anewarray 291	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: aconst_null
    //   25: invokevirtual 297	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnonnull +15 -> 45
    //   33: aload_3
    //   34: ifnull +9 -> 43
    //   37: aload_3
    //   38: invokeinterface 353 1 0
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_3
    //   46: astore_0
    //   47: aload_3
    //   48: invokeinterface 302 1 0
    //   53: istore_1
    //   54: iload_1
    //   55: ifle +17 -> 72
    //   58: iconst_1
    //   59: istore_2
    //   60: aload_3
    //   61: ifnull +9 -> 70
    //   64: aload_3
    //   65: invokeinterface 353 1 0
    //   70: iload_2
    //   71: ireturn
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -14 -> 60
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: astore_0
    //   83: aload 4
    //   85: invokevirtual 356	java/lang/Exception:printStackTrace	()V
    //   88: aload_3
    //   89: astore_0
    //   90: ldc 195
    //   92: iconst_2
    //   93: new 53	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 481
    //   103: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 4
    //   108: invokevirtual 200	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_3
    //   121: ifnull -78 -> 43
    //   124: aload_3
    //   125: invokeinterface 353 1 0
    //   130: iconst_0
    //   131: ireturn
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_0
    //   135: aload_0
    //   136: ifnull +9 -> 145
    //   139: aload_0
    //   140: invokeinterface 353 1 0
    //   145: aload_3
    //   146: athrow
    //   147: astore_3
    //   148: goto -13 -> 135
    //   151: astore 4
    //   153: goto -72 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   53	2	1	i	int
    //   59	15	2	bool	boolean
    //   28	97	3	localCursor	Cursor
    //   132	14	3	localObject1	Object
    //   147	1	3	localObject2	Object
    //   77	30	4	localException1	Exception
    //   151	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	29	77	java/lang/Exception
    //   0	29	132	finally
    //   47	54	147	finally
    //   83	88	147	finally
    //   90	120	147	finally
    //   47	54	151	java/lang/Exception
  }
  
  private static String c(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    StringBuilder localStringBuilder = new StringBuilder("http://sqimg.qq.com/qq_product_operations/eim/calendar/forward.html?");
    localStringBuilder.append("uin=");
    localStringBuilder.append("0");
    localStringBuilder.append("&schedule_id=");
    localStringBuilder.append(paramScheduleSummaryData.id);
    localStringBuilder.append("&from=qq");
    paramScheduleSummaryData = new HashMap();
    paramScheduleSummaryData.put("url", localStringBuilder.toString());
    String str = (String)HttpUtil.a(paramScheduleSummaryData).get("url");
    paramScheduleSummaryData = str;
    if (str.equals(localStringBuilder.toString()))
    {
      str = "";
      paramScheduleSummaryData = str;
      if (QLog.isColorLevel())
      {
        QLog.d("DingdongCalendarSyncUtil", 2, "getShortURL error");
        paramScheduleSummaryData = str;
      }
    }
    return paramScheduleSummaryData;
  }
  
  private static void c(DingdongPluginBizObserver.ScheduleMoreSummaryData paramScheduleMoreSummaryData)
  {
    paramScheduleMoreSummaryData = paramScheduleMoreSummaryData.jdField_a_of_type_CooperationDingdongDingdongPluginDataFactory$ScheduleSummaryData.id;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramScheduleMoreSummaryData;
    BaseApplication.getContext().getContentResolver().delete(Uri.parse(b), "(customAppUri = ?) ", arrayOfString);
    BaseApplication.getContext().getContentResolver().delete(Uri.parse(b), "(organizer = ?) ", arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.DingdongCalendarSyncUtil
 * JD-Core Version:    0.7.0.1
 */