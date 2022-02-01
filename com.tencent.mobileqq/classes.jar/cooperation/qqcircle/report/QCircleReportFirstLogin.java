package cooperation.qqcircle.report;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import feedcloud.FeedCloudCommon.Entry;

public class QCircleReportFirstLogin
{
  public static String FIRST_LOGIN_SOURCE = "first login source";
  public static String FROM_OUTSIDE = "from";
  public static final int H5_PAGE_CONTENT = 10;
  public static final int H5_PAGE_USER = 5;
  public static final int H5_PAG_TAG = 15;
  public static String JUMP_FROM;
  public static final int QQ_AIO_CONTENT = 6;
  public static final int QQ_AIO_TAG = 11;
  public static final int QQ_AIO_USER = 1;
  public static final int QQ_GROUP_UPDATE = 24;
  public static final int QQ_KANDIAN = 22;
  public static final int QQ_SEARCH = 23;
  public static final int QZONE_CONTENT = 7;
  public static final int QZONE_TAG = 12;
  public static final int QZONE_USER = 2;
  public static String SHARE_CATEGORY = "sharecategory";
  public static String SHARE_ENTRANCE = "shareentrance";
  public static final int TICKET_INVIET = 16;
  public static final int UNKNOWN = 999;
  public static final int WECHAT_AIO_CONTENT = 8;
  public static final int WECHAT_AIO_TAG = 13;
  public static final int WECHAT_AIO_USER = 3;
  public static final int WECHAT_MOMENTS_CONTENT = 9;
  public static final int WECHAT_MOMENTS_TAG = 14;
  public static final int WECHAT_MOMENTS_USER = 4;
  public static final int WEWORLD_ACTIVE_TAB = 19;
  public static final int WEWORLD_AIO_ARK = 20;
  public static final int WEWORLD_MEGPAGE = 18;
  public static final int WEWORLD_PROFILE = 17;
  public static final int WEWORLD_PUB_MSG = 21;
  public static boolean firstEnterQCircle;
  public static String firstLoginSource = "";
  public static SharedPreferences isReported = QzoneLiveVideoInterface.getSharedPreferences("isReported", 0);
  
  static
  {
    JUMP_FROM = "key_jump_from";
  }
  
  public static FeedCloudCommon.Entry getFirstLoginEntry()
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    localEntry.key.set("FIRST_LOGIN_SOURCE");
    localEntry.value.set(getFirstLoginSource());
    return localEntry;
  }
  
  public static String getFirstLoginSource()
  {
    return firstLoginSource;
  }
  
  /* Error */
  public static void recordFirstLoginSource(java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getstatic 76	cooperation/qqcircle/report/QCircleReportFirstLogin:SHARE_CATEGORY	Ljava/lang/String;
    //   8: invokeinterface 138 2 0
    //   13: checkcast 140	java/lang/String
    //   16: astore 4
    //   18: aload_0
    //   19: getstatic 80	cooperation/qqcircle/report/QCircleReportFirstLogin:SHARE_ENTRANCE	Ljava/lang/String;
    //   22: invokeinterface 138 2 0
    //   27: checkcast 140	java/lang/String
    //   30: astore 5
    //   32: aload_0
    //   33: getstatic 84	cooperation/qqcircle/report/QCircleReportFirstLogin:JUMP_FROM	Ljava/lang/String;
    //   36: invokeinterface 138 2 0
    //   41: checkcast 140	java/lang/String
    //   44: astore 6
    //   46: aload_0
    //   47: getstatic 88	cooperation/qqcircle/report/QCircleReportFirstLogin:FROM_OUTSIDE	Ljava/lang/String;
    //   50: invokeinterface 138 2 0
    //   55: checkcast 140	java/lang/String
    //   58: astore_0
    //   59: sipush 999
    //   62: istore_3
    //   63: aload 4
    //   65: ifnull +65 -> 130
    //   68: aload 5
    //   70: ifnull +60 -> 130
    //   73: aload 4
    //   75: invokestatic 146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore_2
    //   79: aload 5
    //   81: invokestatic 146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: iload_2
    //   86: iconst_1
    //   87: isub
    //   88: iconst_5
    //   89: imul
    //   90: iload_1
    //   91: iadd
    //   92: istore_1
    //   93: new 148	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   100: iload_1
    //   101: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc 90
    //   106: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: putstatic 92	cooperation/qqcircle/report/QCircleReportFirstLogin:firstLoginSource	Ljava/lang/String;
    //   115: return
    //   116: astore_0
    //   117: iconst_0
    //   118: istore_1
    //   119: aload_0
    //   120: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   123: iload_1
    //   124: istore_2
    //   125: iconst_0
    //   126: istore_1
    //   127: goto -42 -> 85
    //   130: aload 6
    //   132: ifnull +117 -> 249
    //   135: aload 6
    //   137: invokestatic 146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   140: istore_2
    //   141: iload_2
    //   142: istore_1
    //   143: iload_1
    //   144: lookupswitch	default:+60->204, 3:+75->219, 4:+81->225, 5:+87->231, 9:+87->231, 20:+93->237, 24:+99->243
    //   205: iconst_0
    //   206: <illegal opcode>
    //   207: istore_1
    //   208: goto -115 -> 93
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   216: goto -73 -> 143
    //   219: bipush 19
    //   221: istore_1
    //   222: goto -14 -> 208
    //   225: bipush 18
    //   227: istore_1
    //   228: goto -20 -> 208
    //   231: bipush 17
    //   233: istore_1
    //   234: goto -26 -> 208
    //   237: bipush 20
    //   239: istore_1
    //   240: goto -32 -> 208
    //   243: bipush 24
    //   245: istore_1
    //   246: goto -38 -> 208
    //   249: iload_3
    //   250: istore_1
    //   251: aload_0
    //   252: ifnull -159 -> 93
    //   255: aload_0
    //   256: invokestatic 146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   259: istore_1
    //   260: iload_1
    //   261: istore_2
    //   262: iload_3
    //   263: istore_1
    //   264: iload_2
    //   265: bipush 10
    //   267: if_icmpne -174 -> 93
    //   270: bipush 16
    //   272: istore_1
    //   273: goto -180 -> 93
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   281: goto -19 -> 262
    //   284: astore_0
    //   285: iload_2
    //   286: istore_1
    //   287: goto -168 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramMap	java.util.Map<String, String>
    //   3	284	1	i	int
    //   1	285	2	j	int
    //   62	201	3	k	int
    //   16	58	4	str1	String
    //   30	50	5	str2	String
    //   44	92	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   73	79	116	java/lang/Exception
    //   135	141	211	java/lang/Exception
    //   255	260	276	java/lang/Exception
    //   79	85	284	java/lang/Exception
  }
  
  public void setIsReported(boolean paramBoolean)
  {
    isReported.edit().putString("", Boolean.toString(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportFirstLogin
 * JD-Core Version:    0.7.0.1
 */