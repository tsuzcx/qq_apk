package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class VACDReportDBHelper
  extends SQLiteOpenHelper
{
  public VACDReportDBHelper(Context paramContext)
  {
    super(paramContext, "VACDReport.db", null, 7);
  }
  
  private ReportHeader a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(Base64Util.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportHeader localReportHeader = new ReportHeader();
      localReportHeader.platform = paramString.optString("platform");
      localReportHeader.version = paramString.optString("version");
      localReportHeader.seqno = paramString.optLong("seqno");
      localReportHeader.sAction = paramString.optString("sAction");
      localReportHeader.sModule = paramString.optString("sModule");
      localReportHeader.uin = paramString.optLong("uin");
      localReportHeader.iNetType = paramString.optInt("iNetType");
      localReportHeader.result = paramString.optInt("result");
      localReportHeader.createTime = paramString.optLong("createTime");
      localReportHeader.guid = paramString.optString("guid");
      localReportHeader.imei = paramString.optString("imei");
      localReportHeader.startTime = paramString.optLong("serverTime");
      localReportHeader.sKey = paramString.optString("skey");
      return localReportHeader;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String a(ReportHeader paramReportHeader)
  {
    if (paramReportHeader == null) {
      return null;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("platform", paramReportHeader.platform);
      ((JSONObject)localObject).put("version", paramReportHeader.version);
      ((JSONObject)localObject).put("uin", paramReportHeader.uin);
      ((JSONObject)localObject).put("seqno", paramReportHeader.seqno);
      ((JSONObject)localObject).put("sModule", paramReportHeader.sModule);
      ((JSONObject)localObject).put("sAction", paramReportHeader.sAction);
      ((JSONObject)localObject).put("iNetType", paramReportHeader.iNetType);
      ((JSONObject)localObject).put("result", paramReportHeader.result);
      ((JSONObject)localObject).put("createTime", paramReportHeader.createTime);
      ((JSONObject)localObject).put("guid", paramReportHeader.guid);
      ((JSONObject)localObject).put("imei", paramReportHeader.imei);
      ((JSONObject)localObject).put("serverTime", paramReportHeader.startTime);
      ((JSONObject)localObject).put("skey", paramReportHeader.sKey);
      paramReportHeader = new String(Base64Util.encode(((JSONObject)localObject).toString().getBytes(), 0));
      return paramReportHeader;
    }
    catch (Exception paramReportHeader)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convertHeaderToString exception:  ");
        ((StringBuilder)localObject).append(paramReportHeader.toString());
        QLog.e("VACDReport", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private String a(ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("step", paramReportItem.step);
      localJSONObject.put("createTime", paramReportItem.createTime);
      localJSONObject.put("params", paramReportItem.params);
      localJSONObject.put("result", paramReportItem.result);
      localJSONObject.put("failReason", paramReportItem.failReason);
      localJSONObject.put("seqno", paramReportItem.seqno);
      localJSONObject.put("isNormalEnd", paramReportItem.isNormalEnd);
      paramReportItem = new String(Base64Util.encode(localJSONObject.toString().getBytes(), 0));
      return paramReportItem;
    }
    catch (Exception paramReportItem) {}
    return null;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append("ReportItem");
    localStringBuilder.append(" (");
    localStringBuilder.append("seqno");
    localStringBuilder.append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("createTime");
    localStringBuilder.append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("type");
    localStringBuilder.append(" INTEGER DEFAULT 0, ");
    localStringBuilder.append("content");
    localStringBuilder.append(" VARCHAR(255))");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  private ReportItem b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(Base64Util.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportItem localReportItem = new ReportItem();
      localReportItem.step = paramString.optString("step");
      localReportItem.createTime = paramString.optLong("createTime");
      localReportItem.params = paramString.optString("params");
      localReportItem.result = paramString.optInt("result");
      localReportItem.failReason = paramString.optString("failReason");
      localReportItem.seqno = paramString.optLong("seqno");
      localReportItem.isNormalEnd = paramString.optBoolean("isNormalEnd");
      return localReportItem;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE INDEX IF NOT EXISTS ");
    localStringBuilder.append("RTIndex");
    localStringBuilder.append(" ON ");
    localStringBuilder.append("ReportItem");
    localStringBuilder.append('(');
    localStringBuilder.append("seqno");
    localStringBuilder.append(',');
    localStringBuilder.append("createTime");
    localStringBuilder.append(',');
    localStringBuilder.append("type");
    localStringBuilder.append(')');
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  /* Error */
  public java.util.Map<java.lang.Long, VACDReport.ReportInfo> a(java.util.Map<java.lang.Long, VACDReport.ReportInfo> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 231	java/lang/System:currentTimeMillis	()J
    //   5: lstore 6
    //   7: new 233	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 234	java/util/ArrayList:<init>	()V
    //   14: astore 17
    //   16: aconst_null
    //   17: astore 13
    //   19: aconst_null
    //   20: astore 11
    //   22: aconst_null
    //   23: astore 10
    //   25: aconst_null
    //   26: astore 12
    //   28: aload_0
    //   29: invokevirtual 238	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 14
    //   34: aload 12
    //   36: astore 10
    //   38: aload 14
    //   40: astore 12
    //   42: aload 13
    //   44: astore 11
    //   46: aload 14
    //   48: ldc 240
    //   50: iconst_0
    //   51: anewarray 24	java/lang/String
    //   54: invokevirtual 244	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   57: astore 13
    //   59: aload 13
    //   61: ifnull +970 -> 1031
    //   64: aload 13
    //   66: astore 10
    //   68: aload 14
    //   70: astore 12
    //   72: aload 13
    //   74: astore 11
    //   76: aload 13
    //   78: invokeinterface 250 1 0
    //   83: ifle +948 -> 1031
    //   86: aload 13
    //   88: astore 10
    //   90: aload 14
    //   92: astore 12
    //   94: aload 13
    //   96: astore 11
    //   98: aload 13
    //   100: ldc 62
    //   102: invokeinterface 253 2 0
    //   107: istore 4
    //   109: aload 13
    //   111: astore 10
    //   113: aload 14
    //   115: astore 12
    //   117: aload 13
    //   119: astore 11
    //   121: aload 13
    //   123: ldc 199
    //   125: invokeinterface 253 2 0
    //   130: istore_3
    //   131: aload 13
    //   133: astore 10
    //   135: aload 14
    //   137: astore 12
    //   139: aload 13
    //   141: astore 11
    //   143: aload 13
    //   145: ldc 195
    //   147: invokeinterface 253 2 0
    //   152: istore_2
    //   153: aload 13
    //   155: astore 10
    //   157: aload 14
    //   159: astore 12
    //   161: aload 13
    //   163: astore 11
    //   165: aload 13
    //   167: invokeinterface 256 1 0
    //   172: pop
    //   173: aload 13
    //   175: astore 10
    //   177: aload 14
    //   179: astore 12
    //   181: aload 13
    //   183: astore 11
    //   185: aload 13
    //   187: invokeinterface 259 1 0
    //   192: ifne +839 -> 1031
    //   195: aload 13
    //   197: astore 10
    //   199: aload 14
    //   201: astore 12
    //   203: aload 13
    //   205: astore 11
    //   207: aload 13
    //   209: iload 4
    //   211: invokeinterface 263 2 0
    //   216: lstore 8
    //   218: aload 13
    //   220: astore 10
    //   222: aload 14
    //   224: astore 12
    //   226: aload 13
    //   228: astore 11
    //   230: aload 13
    //   232: iload_2
    //   233: invokeinterface 267 2 0
    //   238: istore 5
    //   240: aload 13
    //   242: astore 10
    //   244: aload 14
    //   246: astore 12
    //   248: aload 13
    //   250: astore 11
    //   252: aload 13
    //   254: iload_3
    //   255: invokeinterface 271 2 0
    //   260: astore 15
    //   262: aload 13
    //   264: astore 10
    //   266: aload 14
    //   268: astore 12
    //   270: aload 13
    //   272: astore 11
    //   274: aload_1
    //   275: lload 8
    //   277: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   280: invokeinterface 283 2 0
    //   285: checkcast 285	VACDReport/ReportInfo
    //   288: astore 16
    //   290: iconst_1
    //   291: iload 5
    //   293: if_icmpne +282 -> 575
    //   296: aload 13
    //   298: astore 10
    //   300: aload 14
    //   302: astore 12
    //   304: aload 13
    //   306: astore 11
    //   308: aload_0
    //   309: aload 15
    //   311: invokespecial 287	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:a	(Ljava/lang/String;)LVACDReport/ReportHeader;
    //   314: astore 18
    //   316: aload 18
    //   318: ifnonnull +109 -> 427
    //   321: aload 13
    //   323: astore 10
    //   325: aload 14
    //   327: astore 12
    //   329: aload 13
    //   331: astore 11
    //   333: invokestatic 290	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   336: ifeq +981 -> 1317
    //   339: aload 13
    //   341: astore 10
    //   343: aload 14
    //   345: astore 12
    //   347: aload 13
    //   349: astore 11
    //   351: new 143	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   358: astore 15
    //   360: aload 13
    //   362: astore 10
    //   364: aload 14
    //   366: astore 12
    //   368: aload 13
    //   370: astore 11
    //   372: aload 15
    //   374: ldc_w 292
    //   377: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 13
    //   383: astore 10
    //   385: aload 14
    //   387: astore 12
    //   389: aload 13
    //   391: astore 11
    //   393: aload 15
    //   395: lload 8
    //   397: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 13
    //   403: astore 10
    //   405: aload 14
    //   407: astore 12
    //   409: aload 13
    //   411: astore 11
    //   413: ldc 153
    //   415: iconst_4
    //   416: aload 15
    //   418: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: goto +893 -> 1317
    //   427: aload 16
    //   429: astore 15
    //   431: aload 16
    //   433: ifnonnull +50 -> 483
    //   436: aload 13
    //   438: astore 10
    //   440: aload 14
    //   442: astore 12
    //   444: aload 13
    //   446: astore 11
    //   448: new 285	VACDReport/ReportInfo
    //   451: dup
    //   452: invokespecial 296	VACDReport/ReportInfo:<init>	()V
    //   455: astore 15
    //   457: aload 13
    //   459: astore 10
    //   461: aload 14
    //   463: astore 12
    //   465: aload 13
    //   467: astore 11
    //   469: aload_1
    //   470: lload 8
    //   472: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   475: aload 15
    //   477: invokeinterface 299 3 0
    //   482: pop
    //   483: aload 13
    //   485: astore 10
    //   487: aload 14
    //   489: astore 12
    //   491: aload 13
    //   493: astore 11
    //   495: aload 15
    //   497: aload 18
    //   499: putfield 303	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   502: aload 13
    //   504: astore 10
    //   506: aload 14
    //   508: astore 12
    //   510: aload 13
    //   512: astore 11
    //   514: aload 15
    //   516: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   519: ifnull +801 -> 1320
    //   522: aload 13
    //   524: astore 10
    //   526: aload 14
    //   528: astore 12
    //   530: aload 13
    //   532: astore 11
    //   534: aload 15
    //   536: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   539: aload 18
    //   541: getfield 116	VACDReport/ReportHeader:sKey	Ljava/lang/String;
    //   544: putfield 310	VACDReport/ReportBody:sKey	Ljava/lang/String;
    //   547: aload 13
    //   549: astore 10
    //   551: aload 14
    //   553: astore 12
    //   555: aload 13
    //   557: astore 11
    //   559: aload 15
    //   561: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   564: aload 18
    //   566: getfield 111	VACDReport/ReportHeader:startTime	J
    //   569: putfield 311	VACDReport/ReportBody:startTime	J
    //   572: goto +754 -> 1326
    //   575: iload 5
    //   577: ifne +749 -> 1326
    //   580: aload 16
    //   582: ifnonnull +37 -> 619
    //   585: aload 13
    //   587: astore 10
    //   589: aload 14
    //   591: astore 12
    //   593: aload 13
    //   595: astore 11
    //   597: aload_1
    //   598: lload 8
    //   600: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   603: new 285	VACDReport/ReportInfo
    //   606: dup
    //   607: invokespecial 296	VACDReport/ReportInfo:<init>	()V
    //   610: invokeinterface 299 3 0
    //   615: pop
    //   616: goto +701 -> 1317
    //   619: aload 13
    //   621: astore 10
    //   623: aload 14
    //   625: astore 12
    //   627: aload 13
    //   629: astore 11
    //   631: aload 16
    //   633: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   636: ifnonnull +687 -> 1323
    //   639: aload 13
    //   641: astore 10
    //   643: aload 14
    //   645: astore 12
    //   647: aload 13
    //   649: astore 11
    //   651: aload 16
    //   653: new 309	VACDReport/ReportBody
    //   656: dup
    //   657: invokespecial 312	VACDReport/ReportBody:<init>	()V
    //   660: putfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   663: aload 13
    //   665: astore 10
    //   667: aload 14
    //   669: astore 12
    //   671: aload 13
    //   673: astore 11
    //   675: aload 16
    //   677: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   680: new 233	java/util/ArrayList
    //   683: dup
    //   684: bipush 32
    //   686: invokespecial 315	java/util/ArrayList:<init>	(I)V
    //   689: putfield 319	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   692: aload 13
    //   694: astore 10
    //   696: aload 14
    //   698: astore 12
    //   700: aload 13
    //   702: astore 11
    //   704: aload 16
    //   706: getfield 303	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   709: ifnull +614 -> 1323
    //   712: aload 13
    //   714: astore 10
    //   716: aload 14
    //   718: astore 12
    //   720: aload 13
    //   722: astore 11
    //   724: aload 16
    //   726: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   729: aload 16
    //   731: getfield 303	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   734: getfield 116	VACDReport/ReportHeader:sKey	Ljava/lang/String;
    //   737: putfield 310	VACDReport/ReportBody:sKey	Ljava/lang/String;
    //   740: aload 13
    //   742: astore 10
    //   744: aload 14
    //   746: astore 12
    //   748: aload 13
    //   750: astore 11
    //   752: aload 16
    //   754: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   757: aload 16
    //   759: getfield 303	VACDReport/ReportInfo:header	LVACDReport/ReportHeader;
    //   762: getfield 111	VACDReport/ReportHeader:startTime	J
    //   765: putfield 311	VACDReport/ReportBody:startTime	J
    //   768: goto +3 -> 771
    //   771: aload 13
    //   773: astore 10
    //   775: aload 14
    //   777: astore 12
    //   779: aload 13
    //   781: astore 11
    //   783: aload_0
    //   784: aload 15
    //   786: invokespecial 321	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:b	(Ljava/lang/String;)LVACDReport/ReportItem;
    //   789: astore 18
    //   791: aload 18
    //   793: ifnonnull +109 -> 902
    //   796: aload 13
    //   798: astore 10
    //   800: aload 14
    //   802: astore 12
    //   804: aload 13
    //   806: astore 11
    //   808: invokestatic 290	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   811: ifeq +197 -> 1008
    //   814: aload 13
    //   816: astore 10
    //   818: aload 14
    //   820: astore 12
    //   822: aload 13
    //   824: astore 11
    //   826: new 143	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   833: astore 16
    //   835: aload 13
    //   837: astore 10
    //   839: aload 14
    //   841: astore 12
    //   843: aload 13
    //   845: astore 11
    //   847: aload 16
    //   849: ldc_w 323
    //   852: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: pop
    //   856: aload 13
    //   858: astore 10
    //   860: aload 14
    //   862: astore 12
    //   864: aload 13
    //   866: astore 11
    //   868: aload 16
    //   870: aload 15
    //   872: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload 13
    //   878: astore 10
    //   880: aload 14
    //   882: astore 12
    //   884: aload 13
    //   886: astore 11
    //   888: ldc 153
    //   890: iconst_4
    //   891: aload 16
    //   893: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   896: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   899: goto +109 -> 1008
    //   902: aload 13
    //   904: astore 10
    //   906: aload 14
    //   908: astore 12
    //   910: aload 13
    //   912: astore 11
    //   914: aload 16
    //   916: getfield 307	VACDReport/ReportInfo:body	LVACDReport/ReportBody;
    //   919: getfield 319	VACDReport/ReportBody:reportItems	Ljava/util/ArrayList;
    //   922: aload 18
    //   924: invokevirtual 327	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   927: pop
    //   928: goto +3 -> 931
    //   931: aload 13
    //   933: astore 10
    //   935: aload 14
    //   937: astore 12
    //   939: aload 13
    //   941: astore 11
    //   943: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   946: ifeq +62 -> 1008
    //   949: iload 5
    //   951: ifeq +9 -> 960
    //   954: iconst_1
    //   955: iload 5
    //   957: if_icmpne +51 -> 1008
    //   960: aload 13
    //   962: astore 10
    //   964: aload 14
    //   966: astore 12
    //   968: aload 13
    //   970: astore 11
    //   972: aload 17
    //   974: lload 8
    //   976: invokestatic 330	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   979: invokevirtual 333	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   982: ifne +26 -> 1008
    //   985: aload 13
    //   987: astore 10
    //   989: aload 14
    //   991: astore 12
    //   993: aload 13
    //   995: astore 11
    //   997: aload 17
    //   999: lload 8
    //   1001: invokestatic 330	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1004: invokevirtual 327	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1007: pop
    //   1008: aload 13
    //   1010: astore 10
    //   1012: aload 14
    //   1014: astore 12
    //   1016: aload 13
    //   1018: astore 11
    //   1020: aload 13
    //   1022: invokeinterface 336 1 0
    //   1027: pop
    //   1028: goto -855 -> 173
    //   1031: aload 14
    //   1033: ifnull +296 -> 1329
    //   1036: aload 14
    //   1038: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   1041: goto +288 -> 1329
    //   1044: aload 11
    //   1046: invokeinterface 340 1 0
    //   1051: goto +132 -> 1183
    //   1054: astore_1
    //   1055: goto +217 -> 1272
    //   1058: astore 15
    //   1060: aload 14
    //   1062: astore 13
    //   1064: goto +15 -> 1079
    //   1067: astore_1
    //   1068: aconst_null
    //   1069: astore 12
    //   1071: goto +201 -> 1272
    //   1074: astore 15
    //   1076: aconst_null
    //   1077: astore 13
    //   1079: aload 11
    //   1081: astore 10
    //   1083: aload 13
    //   1085: astore 12
    //   1087: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1090: ifeq +75 -> 1165
    //   1093: aload 11
    //   1095: astore 10
    //   1097: aload 13
    //   1099: astore 12
    //   1101: new 143	java/lang/StringBuilder
    //   1104: dup
    //   1105: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1108: astore 14
    //   1110: aload 11
    //   1112: astore 10
    //   1114: aload 13
    //   1116: astore 12
    //   1118: aload 14
    //   1120: ldc_w 342
    //   1123: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: pop
    //   1127: aload 11
    //   1129: astore 10
    //   1131: aload 13
    //   1133: astore 12
    //   1135: aload 14
    //   1137: aload 15
    //   1139: invokevirtual 343	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1142: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: pop
    //   1146: aload 11
    //   1148: astore 10
    //   1150: aload 13
    //   1152: astore 12
    //   1154: ldc 153
    //   1156: iconst_2
    //   1157: aload 14
    //   1159: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: aload 13
    //   1167: ifnull +8 -> 1175
    //   1170: aload 13
    //   1172: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   1175: aload 11
    //   1177: ifnull +6 -> 1183
    //   1180: goto -136 -> 1044
    //   1183: invokestatic 290	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1186: ifeq +82 -> 1268
    //   1189: new 143	java/lang/StringBuilder
    //   1192: dup
    //   1193: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1196: astore 10
    //   1198: aload 10
    //   1200: ldc_w 345
    //   1203: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 10
    //   1209: invokestatic 231	java/lang/System:currentTimeMillis	()J
    //   1212: lload 6
    //   1214: lsub
    //   1215: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1218: pop
    //   1219: aload 10
    //   1221: ldc_w 347
    //   1224: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: pop
    //   1228: aload 10
    //   1230: aload_1
    //   1231: invokeinterface 350 1 0
    //   1236: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload 10
    //   1242: ldc_w 355
    //   1245: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload 10
    //   1251: aload 17
    //   1253: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: ldc 153
    //   1259: iconst_4
    //   1260: aload 10
    //   1262: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1265: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1268: aload_0
    //   1269: monitorexit
    //   1270: aload_1
    //   1271: areturn
    //   1272: aload 12
    //   1274: ifnull +8 -> 1282
    //   1277: aload 12
    //   1279: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   1282: aload 10
    //   1284: ifnull +10 -> 1294
    //   1287: aload 10
    //   1289: invokeinterface 340 1 0
    //   1294: aload_1
    //   1295: athrow
    //   1296: astore_1
    //   1297: aload_0
    //   1298: monitorexit
    //   1299: goto +5 -> 1304
    //   1302: aload_1
    //   1303: athrow
    //   1304: goto -2 -> 1302
    //   1307: astore 10
    //   1309: goto -126 -> 1183
    //   1312: astore 10
    //   1314: goto -20 -> 1294
    //   1317: goto -309 -> 1008
    //   1320: goto +6 -> 1326
    //   1323: goto -552 -> 771
    //   1326: goto -395 -> 931
    //   1329: aload 13
    //   1331: ifnull -148 -> 1183
    //   1334: aload 13
    //   1336: astore 11
    //   1338: goto -294 -> 1044
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1341	0	this	VACDReportDBHelper
    //   0	1341	1	paramMap	java.util.Map<java.lang.Long, VACDReport.ReportInfo>
    //   152	81	2	i	int
    //   130	125	3	j	int
    //   107	103	4	k	int
    //   238	720	5	m	int
    //   5	1208	6	l1	long
    //   216	784	8	l2	long
    //   23	1265	10	localObject1	Object
    //   1307	1	10	localException1	Exception
    //   1312	1	10	localException2	Exception
    //   20	1317	11	localObject2	Object
    //   26	1252	12	localObject3	Object
    //   17	1318	13	localObject4	Object
    //   32	1126	14	localObject5	Object
    //   260	611	15	localObject6	Object
    //   1058	1	15	localThrowable1	java.lang.Throwable
    //   1074	64	15	localThrowable2	java.lang.Throwable
    //   288	627	16	localObject7	Object
    //   14	1238	17	localArrayList	java.util.ArrayList
    //   314	609	18	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   46	59	1054	finally
    //   76	86	1054	finally
    //   98	109	1054	finally
    //   121	131	1054	finally
    //   143	153	1054	finally
    //   165	173	1054	finally
    //   185	195	1054	finally
    //   207	218	1054	finally
    //   230	240	1054	finally
    //   252	262	1054	finally
    //   274	290	1054	finally
    //   308	316	1054	finally
    //   333	339	1054	finally
    //   351	360	1054	finally
    //   372	381	1054	finally
    //   393	401	1054	finally
    //   413	424	1054	finally
    //   448	457	1054	finally
    //   469	483	1054	finally
    //   495	502	1054	finally
    //   514	522	1054	finally
    //   534	547	1054	finally
    //   559	572	1054	finally
    //   597	616	1054	finally
    //   631	639	1054	finally
    //   651	663	1054	finally
    //   675	692	1054	finally
    //   704	712	1054	finally
    //   724	740	1054	finally
    //   752	768	1054	finally
    //   783	791	1054	finally
    //   808	814	1054	finally
    //   826	835	1054	finally
    //   847	856	1054	finally
    //   868	876	1054	finally
    //   888	899	1054	finally
    //   914	928	1054	finally
    //   943	949	1054	finally
    //   972	985	1054	finally
    //   997	1008	1054	finally
    //   1020	1028	1054	finally
    //   1087	1093	1054	finally
    //   1101	1110	1054	finally
    //   1118	1127	1054	finally
    //   1135	1146	1054	finally
    //   1154	1165	1054	finally
    //   46	59	1058	java/lang/Throwable
    //   76	86	1058	java/lang/Throwable
    //   98	109	1058	java/lang/Throwable
    //   121	131	1058	java/lang/Throwable
    //   143	153	1058	java/lang/Throwable
    //   165	173	1058	java/lang/Throwable
    //   185	195	1058	java/lang/Throwable
    //   207	218	1058	java/lang/Throwable
    //   230	240	1058	java/lang/Throwable
    //   252	262	1058	java/lang/Throwable
    //   274	290	1058	java/lang/Throwable
    //   308	316	1058	java/lang/Throwable
    //   333	339	1058	java/lang/Throwable
    //   351	360	1058	java/lang/Throwable
    //   372	381	1058	java/lang/Throwable
    //   393	401	1058	java/lang/Throwable
    //   413	424	1058	java/lang/Throwable
    //   448	457	1058	java/lang/Throwable
    //   469	483	1058	java/lang/Throwable
    //   495	502	1058	java/lang/Throwable
    //   514	522	1058	java/lang/Throwable
    //   534	547	1058	java/lang/Throwable
    //   559	572	1058	java/lang/Throwable
    //   597	616	1058	java/lang/Throwable
    //   631	639	1058	java/lang/Throwable
    //   651	663	1058	java/lang/Throwable
    //   675	692	1058	java/lang/Throwable
    //   704	712	1058	java/lang/Throwable
    //   724	740	1058	java/lang/Throwable
    //   752	768	1058	java/lang/Throwable
    //   783	791	1058	java/lang/Throwable
    //   808	814	1058	java/lang/Throwable
    //   826	835	1058	java/lang/Throwable
    //   847	856	1058	java/lang/Throwable
    //   868	876	1058	java/lang/Throwable
    //   888	899	1058	java/lang/Throwable
    //   914	928	1058	java/lang/Throwable
    //   943	949	1058	java/lang/Throwable
    //   972	985	1058	java/lang/Throwable
    //   997	1008	1058	java/lang/Throwable
    //   1020	1028	1058	java/lang/Throwable
    //   28	34	1067	finally
    //   28	34	1074	java/lang/Throwable
    //   2	16	1296	finally
    //   1036	1041	1296	finally
    //   1044	1051	1296	finally
    //   1170	1175	1296	finally
    //   1183	1268	1296	finally
    //   1277	1282	1296	finally
    //   1287	1294	1296	finally
    //   1294	1296	1296	finally
    //   1036	1041	1307	java/lang/Exception
    //   1044	1051	1307	java/lang/Exception
    //   1170	1175	1307	java/lang/Exception
    //   1277	1282	1312	java/lang/Exception
    //   1287	1294	1312	java/lang/Exception
  }
  
  /* Error */
  public void a(java.util.List<java.lang.Long> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +593 -> 596
    //   6: aload_1
    //   7: invokeinterface 368 1 0
    //   12: istore 4
    //   14: iload 4
    //   16: ifeq +6 -> 22
    //   19: goto +577 -> 596
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 5
    //   28: aload_0
    //   29: invokevirtual 371	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 7
    //   34: aload 7
    //   36: astore 5
    //   38: aload 7
    //   40: astore 6
    //   42: aload 7
    //   44: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: aload 7
    //   49: astore 5
    //   51: aload 7
    //   53: astore 6
    //   55: aload_1
    //   56: invokeinterface 375 1 0
    //   61: istore_3
    //   62: aload 7
    //   64: astore 5
    //   66: aload 7
    //   68: astore 6
    //   70: new 143	java/lang/StringBuilder
    //   73: dup
    //   74: iload_3
    //   75: bipush 14
    //   77: imul
    //   78: invokespecial 376	java/lang/StringBuilder:<init>	(I)V
    //   81: astore 8
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: iload_3
    //   87: if_icmpge +57 -> 144
    //   90: aload 7
    //   92: astore 5
    //   94: aload 7
    //   96: astore 6
    //   98: aload 8
    //   100: aload_1
    //   101: iload_2
    //   102: invokeinterface 379 2 0
    //   107: checkcast 273	java/lang/Long
    //   110: invokevirtual 382	java/lang/Long:longValue	()J
    //   113: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: iload_2
    //   118: iload_3
    //   119: iconst_1
    //   120: isub
    //   121: if_icmpge +478 -> 599
    //   124: aload 7
    //   126: astore 5
    //   128: aload 7
    //   130: astore 6
    //   132: aload 8
    //   134: ldc_w 384
    //   137: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: goto +458 -> 599
    //   144: aload 7
    //   146: astore 5
    //   148: aload 7
    //   150: astore 6
    //   152: new 143	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   159: astore_1
    //   160: aload 7
    //   162: astore 5
    //   164: aload 7
    //   166: astore 6
    //   168: aload_1
    //   169: ldc_w 386
    //   172: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 7
    //   178: astore 5
    //   180: aload 7
    //   182: astore 6
    //   184: aload_1
    //   185: aload 8
    //   187: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 7
    //   193: astore 5
    //   195: aload 7
    //   197: astore 6
    //   199: aload_1
    //   200: ldc_w 388
    //   203: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 7
    //   209: astore 5
    //   211: aload 7
    //   213: astore 6
    //   215: aload 7
    //   217: aload_1
    //   218: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 206	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   224: aload 7
    //   226: astore 5
    //   228: aload 7
    //   230: astore 6
    //   232: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +71 -> 306
    //   238: aload 7
    //   240: astore 5
    //   242: aload 7
    //   244: astore 6
    //   246: new 143	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   253: astore_1
    //   254: aload 7
    //   256: astore 5
    //   258: aload 7
    //   260: astore 6
    //   262: aload_1
    //   263: ldc_w 390
    //   266: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 7
    //   272: astore 5
    //   274: aload 7
    //   276: astore 6
    //   278: aload_1
    //   279: aload 8
    //   281: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: astore 5
    //   292: aload 7
    //   294: astore 6
    //   296: ldc 153
    //   298: iconst_2
    //   299: aload_1
    //   300: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 7
    //   308: astore 5
    //   310: aload 7
    //   312: astore 6
    //   314: aload 7
    //   316: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   319: aload 7
    //   321: ifnull +199 -> 520
    //   324: aload 7
    //   326: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   329: aload 7
    //   331: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   334: goto +186 -> 520
    //   337: astore_1
    //   338: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +179 -> 520
    //   344: new 143	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   351: astore 5
    //   353: aload 5
    //   355: ldc_w 398
    //   358: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 5
    //   364: aload_1
    //   365: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   368: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 5
    //   374: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore_1
    //   378: ldc 153
    //   380: iconst_2
    //   381: aload_1
    //   382: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto +135 -> 520
    //   388: astore_1
    //   389: goto +134 -> 523
    //   392: astore_1
    //   393: aload 6
    //   395: astore 5
    //   397: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +58 -> 458
    //   403: aload 6
    //   405: astore 5
    //   407: new 143	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   414: astore 7
    //   416: aload 6
    //   418: astore 5
    //   420: aload 7
    //   422: ldc_w 400
    //   425: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 6
    //   431: astore 5
    //   433: aload 7
    //   435: aload_1
    //   436: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   439: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: astore 5
    //   447: ldc 153
    //   449: iconst_2
    //   450: aload 7
    //   452: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload 6
    //   460: ifnull +60 -> 520
    //   463: aload 6
    //   465: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   468: aload 6
    //   470: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   473: goto +47 -> 520
    //   476: astore_1
    //   477: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +40 -> 520
    //   483: new 143	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   490: astore 5
    //   492: aload 5
    //   494: ldc_w 398
    //   497: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 5
    //   503: aload_1
    //   504: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 5
    //   513: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: astore_1
    //   517: goto -139 -> 378
    //   520: aload_0
    //   521: monitorexit
    //   522: return
    //   523: aload 5
    //   525: ifnull +64 -> 589
    //   528: aload 5
    //   530: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   533: aload 5
    //   535: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   538: goto +51 -> 589
    //   541: astore 5
    //   543: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +43 -> 589
    //   549: new 143	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   556: astore 6
    //   558: aload 6
    //   560: ldc_w 398
    //   563: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 6
    //   569: aload 5
    //   571: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   574: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: ldc 153
    //   580: iconst_2
    //   581: aload 6
    //   583: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: aload_1
    //   590: athrow
    //   591: astore_1
    //   592: aload_0
    //   593: monitorexit
    //   594: aload_1
    //   595: athrow
    //   596: aload_0
    //   597: monitorexit
    //   598: return
    //   599: iload_2
    //   600: iconst_1
    //   601: iadd
    //   602: istore_2
    //   603: goto -518 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	VACDReportDBHelper
    //   0	606	1	paramList	java.util.List<java.lang.Long>
    //   84	519	2	i	int
    //   61	60	3	j	int
    //   12	3	4	bool	boolean
    //   26	508	5	localObject1	Object
    //   541	29	5	localException	Exception
    //   23	559	6	localObject2	Object
    //   32	419	7	localObject3	Object
    //   81	199	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   324	334	337	java/lang/Exception
    //   28	34	388	finally
    //   42	47	388	finally
    //   55	62	388	finally
    //   70	83	388	finally
    //   98	117	388	finally
    //   132	141	388	finally
    //   152	160	388	finally
    //   168	176	388	finally
    //   184	191	388	finally
    //   199	207	388	finally
    //   215	224	388	finally
    //   232	238	388	finally
    //   246	254	388	finally
    //   262	270	388	finally
    //   278	288	388	finally
    //   296	306	388	finally
    //   314	319	388	finally
    //   397	403	388	finally
    //   407	416	388	finally
    //   420	429	388	finally
    //   433	443	388	finally
    //   447	458	388	finally
    //   28	34	392	java/lang/Exception
    //   42	47	392	java/lang/Exception
    //   55	62	392	java/lang/Exception
    //   70	83	392	java/lang/Exception
    //   98	117	392	java/lang/Exception
    //   132	141	392	java/lang/Exception
    //   152	160	392	java/lang/Exception
    //   168	176	392	java/lang/Exception
    //   184	191	392	java/lang/Exception
    //   199	207	392	java/lang/Exception
    //   215	224	392	java/lang/Exception
    //   232	238	392	java/lang/Exception
    //   246	254	392	java/lang/Exception
    //   262	270	392	java/lang/Exception
    //   278	288	392	java/lang/Exception
    //   296	306	392	java/lang/Exception
    //   314	319	392	java/lang/Exception
    //   463	473	476	java/lang/Exception
    //   528	538	541	java/lang/Exception
    //   6	14	591	finally
    //   324	334	591	finally
    //   338	378	591	finally
    //   378	385	591	finally
    //   463	473	591	finally
    //   477	517	591	finally
    //   528	538	591	finally
    //   543	589	591	finally
    //   589	591	591	finally
  }
  
  /* Error */
  public void b(java.util.List<ReportItem> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +421 -> 424
    //   6: aload_1
    //   7: invokeinterface 368 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: goto +407 -> 424
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_0
    //   26: invokevirtual 371	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   36: new 403	android/content/ContentValues
    //   39: dup
    //   40: invokespecial 404	android/content/ContentValues:<init>	()V
    //   43: astore_3
    //   44: aload_1
    //   45: invokeinterface 408 1 0
    //   50: astore_1
    //   51: aload_1
    //   52: invokeinterface 413 1 0
    //   57: ifeq +86 -> 143
    //   60: aload_1
    //   61: invokeinterface 417 1 0
    //   66: checkcast 163	VACDReport/ReportItem
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull -22 -> 51
    //   76: aload_3
    //   77: invokevirtual 420	android/content/ContentValues:clear	()V
    //   80: aload_3
    //   81: ldc 62
    //   83: aload 5
    //   85: getfield 176	VACDReport/ReportItem:seqno	J
    //   88: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   94: aload_3
    //   95: ldc 199
    //   97: aload_0
    //   98: aload 5
    //   100: invokespecial 425	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:a	(LVACDReport/ReportItem;)Ljava/lang/String;
    //   103: invokevirtual 428	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_3
    //   107: ldc 96
    //   109: aload 5
    //   111: getfield 166	VACDReport/ReportItem:createTime	J
    //   114: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   117: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   120: aload_3
    //   121: ldc 195
    //   123: iconst_0
    //   124: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   130: aload 4
    //   132: ldc 189
    //   134: aconst_null
    //   135: aload_3
    //   136: invokevirtual 440	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   139: pop2
    //   140: goto -89 -> 51
    //   143: aload 4
    //   145: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   148: aload 4
    //   150: ifnull +200 -> 350
    //   153: aload 4
    //   155: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: aload 4
    //   160: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   163: goto +187 -> 350
    //   166: astore_1
    //   167: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +180 -> 350
    //   173: new 143	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   180: astore_3
    //   181: aload_3
    //   182: ldc_w 442
    //   185: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_3
    //   190: aload_1
    //   191: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   194: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_3
    //   199: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: astore_1
    //   203: ldc 153
    //   205: iconst_4
    //   206: aload_1
    //   207: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: goto +140 -> 350
    //   213: astore_1
    //   214: goto +139 -> 353
    //   217: astore_3
    //   218: aload 4
    //   220: astore_1
    //   221: aload_3
    //   222: astore 4
    //   224: goto +15 -> 239
    //   227: astore_1
    //   228: aload_3
    //   229: astore 4
    //   231: goto +122 -> 353
    //   234: astore 4
    //   236: aload 5
    //   238: astore_1
    //   239: aload_1
    //   240: astore_3
    //   241: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +51 -> 295
    //   247: aload_1
    //   248: astore_3
    //   249: new 143	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   256: astore 5
    //   258: aload_1
    //   259: astore_3
    //   260: aload 5
    //   262: ldc_w 444
    //   265: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: astore_3
    //   271: aload 5
    //   273: aload 4
    //   275: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   278: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_1
    //   283: astore_3
    //   284: ldc 153
    //   286: iconst_4
    //   287: aload 5
    //   289: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_1
    //   296: ifnull +54 -> 350
    //   299: aload_1
    //   300: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   303: aload_1
    //   304: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   307: goto +43 -> 350
    //   310: astore_1
    //   311: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   314: ifeq +36 -> 350
    //   317: new 143	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   324: astore_3
    //   325: aload_3
    //   326: ldc_w 442
    //   329: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: aload_1
    //   335: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   338: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_3
    //   343: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -144 -> 203
    //   350: aload_0
    //   351: monitorexit
    //   352: return
    //   353: aload 4
    //   355: ifnull +62 -> 417
    //   358: aload 4
    //   360: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   363: aload 4
    //   365: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   368: goto +49 -> 417
    //   371: astore_3
    //   372: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +42 -> 417
    //   378: new 143	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   385: astore 4
    //   387: aload 4
    //   389: ldc_w 442
    //   392: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 4
    //   398: aload_3
    //   399: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   402: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 153
    //   408: iconst_4
    //   409: aload 4
    //   411: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_1
    //   418: athrow
    //   419: astore_1
    //   420: aload_0
    //   421: monitorexit
    //   422: aload_1
    //   423: athrow
    //   424: aload_0
    //   425: monitorexit
    //   426: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	VACDReportDBHelper
    //   0	427	1	paramList	java.util.List<ReportItem>
    //   12	2	2	bool	boolean
    //   24	175	3	localObject1	Object
    //   217	12	3	localException1	Exception
    //   240	103	3	localObject2	Object
    //   371	28	3	localException2	Exception
    //   29	201	4	localObject3	Object
    //   234	130	4	localException3	Exception
    //   385	25	4	localStringBuilder	StringBuilder
    //   21	267	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   153	163	166	java/lang/Exception
    //   31	51	213	finally
    //   51	71	213	finally
    //   76	140	213	finally
    //   143	148	213	finally
    //   31	51	217	java/lang/Exception
    //   51	71	217	java/lang/Exception
    //   76	140	217	java/lang/Exception
    //   143	148	217	java/lang/Exception
    //   25	31	227	finally
    //   241	247	227	finally
    //   249	258	227	finally
    //   260	269	227	finally
    //   271	282	227	finally
    //   284	295	227	finally
    //   25	31	234	java/lang/Exception
    //   299	307	310	java/lang/Exception
    //   358	368	371	java/lang/Exception
    //   6	13	419	finally
    //   153	163	419	finally
    //   167	203	419	finally
    //   203	210	419	finally
    //   299	307	419	finally
    //   311	347	419	finally
    //   358	368	419	finally
    //   372	417	419	finally
    //   417	419	419	finally
  }
  
  /* Error */
  public void c(java.util.List<ReportHeader> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +412 -> 415
    //   6: aload_1
    //   7: invokeinterface 368 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq +6 -> 20
    //   17: goto +398 -> 415
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_0
    //   26: invokevirtual 371	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 4
    //   31: aload 4
    //   33: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   36: new 403	android/content/ContentValues
    //   39: dup
    //   40: invokespecial 404	android/content/ContentValues:<init>	()V
    //   43: astore_3
    //   44: aload_1
    //   45: invokeinterface 408 1 0
    //   50: astore_1
    //   51: aload_1
    //   52: invokeinterface 413 1 0
    //   57: ifeq +77 -> 134
    //   60: aload_1
    //   61: invokeinterface 417 1 0
    //   66: checkcast 44	VACDReport/ReportHeader
    //   69: astore 5
    //   71: aload_3
    //   72: invokevirtual 420	android/content/ContentValues:clear	()V
    //   75: aload_3
    //   76: ldc 62
    //   78: aload 5
    //   80: getfield 69	VACDReport/ReportHeader:seqno	J
    //   83: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   86: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   89: aload_3
    //   90: ldc 199
    //   92: aload_0
    //   93: aload 5
    //   95: invokespecial 448	com/tencent/mobileqq/qwallet/report/impl/VACDReportDBHelper:a	(LVACDReport/ReportHeader;)Ljava/lang/String;
    //   98: invokevirtual 428	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_3
    //   102: ldc 195
    //   104: iconst_1
    //   105: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   111: aload_3
    //   112: ldc 96
    //   114: iconst_0
    //   115: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   121: aload 4
    //   123: ldc 189
    //   125: aconst_null
    //   126: aload_3
    //   127: invokevirtual 440	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   130: pop2
    //   131: goto -80 -> 51
    //   134: aload 4
    //   136: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   139: aload 4
    //   141: ifnull +200 -> 341
    //   144: aload 4
    //   146: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   149: aload 4
    //   151: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: goto +187 -> 341
    //   157: astore_1
    //   158: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +180 -> 341
    //   164: new 143	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   171: astore_3
    //   172: aload_3
    //   173: ldc_w 450
    //   176: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_3
    //   181: aload_1
    //   182: invokevirtual 343	java/lang/Throwable:toString	()Ljava/lang/String;
    //   185: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_3
    //   190: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: astore_1
    //   194: ldc 153
    //   196: iconst_2
    //   197: aload_1
    //   198: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: goto +140 -> 341
    //   204: astore_1
    //   205: goto +139 -> 344
    //   208: astore_3
    //   209: aload 4
    //   211: astore_1
    //   212: aload_3
    //   213: astore 4
    //   215: goto +15 -> 230
    //   218: astore_1
    //   219: aload_3
    //   220: astore 4
    //   222: goto +122 -> 344
    //   225: astore 4
    //   227: aload 5
    //   229: astore_1
    //   230: aload_1
    //   231: astore_3
    //   232: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +51 -> 286
    //   238: aload_1
    //   239: astore_3
    //   240: new 143	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   247: astore 5
    //   249: aload_1
    //   250: astore_3
    //   251: aload 5
    //   253: ldc_w 450
    //   256: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: astore_3
    //   262: aload 5
    //   264: aload 4
    //   266: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   269: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_1
    //   274: astore_3
    //   275: ldc 153
    //   277: iconst_2
    //   278: aload 5
    //   280: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_1
    //   287: ifnull +54 -> 341
    //   290: aload_1
    //   291: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   294: aload_1
    //   295: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   298: goto +43 -> 341
    //   301: astore_1
    //   302: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +36 -> 341
    //   308: new 143	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   315: astore_3
    //   316: aload_3
    //   317: ldc_w 450
    //   320: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_3
    //   325: aload_1
    //   326: invokevirtual 343	java/lang/Throwable:toString	()Ljava/lang/String;
    //   329: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: astore_1
    //   338: goto -144 -> 194
    //   341: aload_0
    //   342: monitorexit
    //   343: return
    //   344: aload 4
    //   346: ifnull +62 -> 408
    //   349: aload 4
    //   351: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   354: aload 4
    //   356: invokevirtual 339	android/database/sqlite/SQLiteDatabase:close	()V
    //   359: goto +49 -> 408
    //   362: astore_3
    //   363: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +42 -> 408
    //   369: new 143	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   376: astore 4
    //   378: aload 4
    //   380: ldc_w 450
    //   383: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 4
    //   389: aload_3
    //   390: invokevirtual 343	java/lang/Throwable:toString	()Ljava/lang/String;
    //   393: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 153
    //   399: iconst_2
    //   400: aload 4
    //   402: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aload_0
    //   412: monitorexit
    //   413: aload_1
    //   414: athrow
    //   415: aload_0
    //   416: monitorexit
    //   417: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	VACDReportDBHelper
    //   0	418	1	paramList	java.util.List<ReportHeader>
    //   12	2	2	bool	boolean
    //   24	166	3	localObject1	Object
    //   208	12	3	localException1	Exception
    //   231	103	3	localObject2	Object
    //   362	28	3	localThrowable	java.lang.Throwable
    //   29	192	4	localObject3	Object
    //   225	130	4	localException2	Exception
    //   376	25	4	localStringBuilder	StringBuilder
    //   21	258	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   144	154	157	java/lang/Throwable
    //   31	51	204	finally
    //   51	131	204	finally
    //   134	139	204	finally
    //   31	51	208	java/lang/Exception
    //   51	131	208	java/lang/Exception
    //   134	139	208	java/lang/Exception
    //   25	31	218	finally
    //   232	238	218	finally
    //   240	249	218	finally
    //   251	260	218	finally
    //   262	273	218	finally
    //   275	286	218	finally
    //   25	31	225	java/lang/Exception
    //   290	298	301	java/lang/Throwable
    //   349	359	362	java/lang/Throwable
    //   6	13	410	finally
    //   144	154	410	finally
    //   158	194	410	finally
    //   194	201	410	finally
    //   290	298	410	finally
    //   302	338	410	finally
    //   349	359	410	finally
    //   363	408	410	finally
    //   408	410	410	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      if (paramInt1 < paramInt2) {
        switch (paramInt1)
        {
        default: 
          break;
        case 6: 
          try
          {
            b(paramSQLiteDatabase);
          }
          catch (Exception localException1)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("createReportRecordTable exception=");
          localStringBuilder.append(localException1.toString());
          QLog.e("VACDReport", 2, localStringBuilder.toString());
          break;
        case 4: 
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN send_time INTEGER(16) DEFAULT 9");
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" TABLE ReportItem add column send_time is exception=");
          localStringBuilder.append(localException2.toString());
          QLog.e("VACDReport", 2, localStringBuilder.toString());
          break;
        case 3: 
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN status INTEGER DEFAULT 1");
          }
          catch (Exception localException3)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" TABLE ReportItem add column status is exception=");
          localStringBuilder.append(localException3.toString());
          QLog.e("VACDReport", 2, localStringBuilder.toString());
          break;
        }
      }
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS VACDReport");
        break label253;
        if (QLog.isColorLevel()) {
          QLog.e("VACDReport", 2, "VACDReport table is not exists");
        }
        try
        {
          label253:
          a(paramSQLiteDatabase);
        }
        catch (Exception localException4)
        {
          if (!QLog.isColorLevel()) {
            break label319;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createReportItemTable exception:");
        localStringBuilder.append(localException4.toString());
        QLog.e("VACDReport", 2, localStringBuilder.toString());
      }
      catch (Exception localException5)
      {
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE VACDReport ADD sendTime INTEGER(16) DEFAULT 0");
          label319:
          paramInt1 += 1;
          continue;
          return;
          localException5 = localException5;
        }
        catch (Exception localException6)
        {
          break label319;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportDBHelper
 * JD-Core Version:    0.7.0.1
 */