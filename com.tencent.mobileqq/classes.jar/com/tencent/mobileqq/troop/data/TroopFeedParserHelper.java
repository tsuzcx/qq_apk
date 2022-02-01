package com.tencent.mobileqq.troop.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TroopFeedParserHelper
{
  public static TroopFeedParserHelper.FeedParser a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 10)
      {
        if (paramInt != 12)
        {
          if (paramInt != 99)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                if (paramInt != 18)
                {
                  if (paramInt != 19) {
                    return null;
                  }
                }
                else {
                  return new TroopFeedParserHelper.AblumFeedParser();
                }
              }
              return new TroopFeedParserHelper.ProclamationFeedParser();
            }
            return new TroopFeedParserHelper.ShareFeedParser();
          }
          return new TroopFeedParserHelper.CommonFeedParser();
        }
        return new TroopFeedParserHelper.VoteFeedParser();
      }
      return new TroopFeedParserHelper.VideoFeedParser();
    }
    return new TroopFeedParserHelper.PicFeedParser();
  }
  
  public static String a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(paramLong * 1000L);
    localCalendar.setTime(localDate);
    return new SimpleDateFormat("MM月dd日").format(localDate);
  }
  
  /* Error */
  public static Object[] a(org.json.JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 66	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 67	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 66	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 67	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_0
    //   19: ifnull +174 -> 193
    //   22: aload_0
    //   23: ldc 69
    //   25: invokevirtual 75	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   28: ifeq +48 -> 76
    //   31: aload_0
    //   32: ldc 69
    //   34: invokevirtual 79	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 7
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: aload 7
    //   44: invokevirtual 85	org/json/JSONArray:length	()I
    //   47: if_icmpge +29 -> 76
    //   50: aload 5
    //   52: aload 7
    //   54: iload_3
    //   55: invokevirtual 89	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   58: ldc 91
    //   60: invokevirtual 95	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokeinterface 101 2 0
    //   68: pop
    //   69: iload_3
    //   70: iconst_1
    //   71: iadd
    //   72: istore_3
    //   73: goto -32 -> 41
    //   76: aload_0
    //   77: ldc 103
    //   79: invokevirtual 75	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   82: ifeq +111 -> 193
    //   85: aload_0
    //   86: ldc 103
    //   88: invokevirtual 79	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   91: astore_0
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: aload_0
    //   96: invokevirtual 85	org/json/JSONArray:length	()I
    //   99: if_icmpge +94 -> 193
    //   102: aload_0
    //   103: iload_3
    //   104: invokevirtual 89	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 105
    //   113: invokevirtual 109	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   116: istore 4
    //   118: iload 4
    //   120: invokestatic 111	com/tencent/mobileqq/troop/data/TroopFeedParserHelper:a	(I)Lcom/tencent/mobileqq/troop/data/TroopFeedParserHelper$FeedParser;
    //   123: astore 8
    //   125: aload 8
    //   127: ifnull +54 -> 181
    //   130: aload 8
    //   132: aload 7
    //   134: invokevirtual 116	com/tencent/mobileqq/troop/data/TroopFeedParserHelper$FeedParser:a	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/data/TroopFeedItem;
    //   137: astore 7
    //   139: aload 7
    //   141: ifnull +40 -> 181
    //   144: aload 7
    //   146: invokevirtual 122	com/tencent/mobileqq/data/TroopFeedItem:isVaild	()Z
    //   149: ifeq +32 -> 181
    //   152: aload 7
    //   154: iload 4
    //   156: putfield 126	com/tencent/mobileqq/data/TroopFeedItem:orginType	I
    //   159: aload 7
    //   161: aload_2
    //   162: putfield 130	com/tencent/mobileqq/data/TroopFeedItem:currentUin	Ljava/lang/String;
    //   165: aload 7
    //   167: aload_1
    //   168: putfield 133	com/tencent/mobileqq/data/TroopFeedItem:troopUin	Ljava/lang/String;
    //   171: aload 6
    //   173: aload 7
    //   175: invokeinterface 101 2 0
    //   180: pop
    //   181: iload_3
    //   182: iconst_1
    //   183: iadd
    //   184: istore_3
    //   185: goto -91 -> 94
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 136	org/json/JSONException:printStackTrace	()V
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 5
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload 6
    //   206: aastore
    //   207: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramJSONObject	org.json.JSONObject
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   40	145	3	i	int
    //   116	39	4	j	int
    //   7	193	5	localArrayList1	java.util.ArrayList
    //   16	189	6	localArrayList2	java.util.ArrayList
    //   37	137	7	localObject	Object
    //   123	8	8	localFeedParser	TroopFeedParserHelper.FeedParser
    // Exception table:
    //   from	to	target	type
    //   22	39	188	org/json/JSONException
    //   41	69	188	org/json/JSONException
    //   76	92	188	org/json/JSONException
    //   94	125	188	org/json/JSONException
    //   130	139	188	org/json/JSONException
    //   144	181	188	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedParserHelper
 * JD-Core Version:    0.7.0.1
 */