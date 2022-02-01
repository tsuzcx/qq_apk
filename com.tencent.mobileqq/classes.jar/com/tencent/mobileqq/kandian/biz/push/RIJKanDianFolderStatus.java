package com.tencent.mobileqq.kandian.biz.push;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.reddot.KandianSubscribeReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.SPEventReportSwitch;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJKanDianFolderStatus
  implements IRIJKanDianFolderStatus
{
  public static final RedPntInfoForReport RED_PNT_INFO_FOR_REPORT = new RedPntInfoForReport();
  private static final String TAG = "RIJKanDianFolderStatus";
  public static int reportFolderStatus;
  public static int reportLastRedPntPosition = -1;
  public static String reportSessionId = "";
  
  public static String clickOperatingSettingReportR5(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("wording", paramString);
      localJSONObject.put("folder_status", reportFolderStatus);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String getFolderStatus(int paramInt)
  {
    Object localObject;
    if (paramInt == ChannelCoverInfoModule.g())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(reportFolderStatus);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramInt != 0)
    {
      if (paramInt != 70)
      {
        if (DailyModeConfigHandler.c(paramInt))
        {
          localObject = KandianDailyReportUtils.e();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(reportFolderStatus);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      else
      {
        localObject = KandianSubscribeReportUtils.c();
        if (RIJTransMergeKanDianReport.b() == 6)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(reportFolderStatus);
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
        }
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(reportFolderStatus);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      Integer.parseInt((String)localObject);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      AIOUtils.a("RIJKanDianFolderStatus", "fs is not number", localNumberFormatException);
    }
    return "1";
  }
  
  public static String getLastMsgStrategyID(QQAppInterface paramQQAppInterface)
  {
    return RED_PNT_INFO_FOR_REPORT.c;
  }
  
  public static MessageRecord getMessageRecordFormLastMsgForMsgTab(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface == null) {
      return null;
    }
    MessageRecord localMessageRecord = paramQQAppInterface.r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localMessageRecord == null) {
      return null;
    }
    paramQQAppInterface = localMessageRecord;
    if (RED_PNT_INFO_FOR_REPORT.e != null)
    {
      paramQQAppInterface = localMessageRecord;
      if (RED_PNT_INFO_FOR_REPORT.e.time >= localMessageRecord.time) {
        paramQQAppInterface = RED_PNT_INFO_FOR_REPORT.e;
      }
    }
    return paramQQAppInterface;
  }
  
  public static JSONObject getPolymericCommonR5Report(PolymericInfo paramPolymericInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", reportFolderStatus);
        localJSONObject.put("kandian_mode", String.valueOf(RIJAppSetting.b()));
        localJSONObject.put("tab_source", RIJTransMergeKanDianReport.b());
        i = -1;
        int j = paramPolymericInfo.e;
        if (j == 6) {
          break label142;
        }
        if (j == 7) {
          break label137;
        }
        if (j != 8)
        {
          localJSONObject.put("use_type", i);
          long l;
          if (i == 2) {
            l = paramPolymericInfo.f;
          } else {
            l = paramPolymericInfo.m;
          }
          localJSONObject.put("type_id", l);
          localJSONObject.put("algorithm_id", paramPolymericInfo.l);
          return localJSONObject;
        }
      }
      catch (JSONException paramPolymericInfo)
      {
        paramPolymericInfo.printStackTrace();
        return localJSONObject;
      }
      int i = 3;
      continue;
      label137:
      i = 1;
      continue;
      label142:
      i = 2;
    }
  }
  
  public static boolean isRedDotMessageRecord(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (!paramMessageRecord.isread) && ((paramMessageRecord.extInt == 1) || (paramMessageRecord.extInt == 2) || (paramMessageRecord.extInt == 5) || (paramMessageRecord.extInt == 6)) && ((paramMessageRecord.extLong & 0x1) != 0);
  }
  
  public static void obtainMergeKandianFolderStatus()
  {
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = ((QQAppInterface)localObject).getMessageFacade();
          if (localObject != null)
          {
            localObject = ((QQMessageFacade)localObject).r(AppConstants.KANDIAN_MERGE_UIN, 7220);
            int j = 0;
            i = j;
            if (localObject != null)
            {
              i = j;
              if (((MessageRecord)localObject).extInt != 1) {
                if (((MessageRecord)localObject).extInt == 3)
                {
                  i = j;
                }
                else
                {
                  if (((MessageRecord)localObject).extInt == 2) {
                    break label312;
                  }
                  i = j;
                  if (((MessageRecord)localObject).extInt == 4) {
                    break label312;
                  }
                }
              }
            }
            if ((localObject != null) && (((MessageRecord)localObject).isread)) {
              reportFolderStatus = 1;
            } else if (i == 0) {
              reportFolderStatus = 3;
            } else if (i == 1) {
              reportFolderStatus = 2;
            }
            if ((localObject instanceof MessageForStructing))
            {
              localObject = (MessageForStructing)localObject;
              if (((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue != null)
              {
                boolean bool = TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
                if (!bool) {
                  try
                  {
                    reportFolderStatus = Integer.parseInt(((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue);
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                  }
                }
              }
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder1 = new StringBuilder();
              localStringBuilder1.append("update mergefolder status ");
              localStringBuilder1.append(reportFolderStatus);
              QLog.d("RIJKanDianFolderStatus", 2, localStringBuilder1.toString());
            }
          }
        }
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("obtainMergeKandianFolderStatus except ");
          localStringBuilder3.append(localException2.toString());
          QLog.d("RIJKanDianFolderStatus", 2, localStringBuilder3.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("current mergefolder status is ");
        localStringBuilder2.append(reportFolderStatus);
        QLog.d("RIJKanDianFolderStatus", 2, localStringBuilder2.toString());
      }
      return;
      label312:
      int i = 1;
    }
  }
  
  public static void setLastKandianMsgRead()
  {
    if (RED_PNT_INFO_FOR_REPORT.e != null) {
      RED_PNT_INFO_FOR_REPORT.e.isread = true;
    }
  }
  
  public static void updateKandianFolderStatus(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.excute(new RIJKanDianFolderStatus.1(paramQQAppInterface), 32, null, true);
  }
  
  /* Error */
  public static void updateKandianFolderStatus(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: putstatic 27	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:reportLastRedPntPosition	I
    //   4: aload_0
    //   5: getstatic 264	com/tencent/mobileqq/app/QQManagerFactory:KANDIAN_MERGE_MANAGER	I
    //   8: invokevirtual 268	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11: checkcast 270	com/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager
    //   14: astore_0
    //   15: aload_1
    //   16: ifnull +599 -> 615
    //   19: aload_1
    //   20: getfield 191	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   23: istore_3
    //   24: bipush 6
    //   26: istore_2
    //   27: ldc 29
    //   29: astore 7
    //   31: iload_3
    //   32: ifeq +15 -> 47
    //   35: ldc 29
    //   37: astore 6
    //   39: aload 6
    //   41: astore_0
    //   42: iconst_1
    //   43: istore_2
    //   44: goto +438 -> 482
    //   47: aload_1
    //   48: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   51: iconst_1
    //   52: if_icmpeq +185 -> 237
    //   55: aload_1
    //   56: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   59: iconst_3
    //   60: if_icmpne +6 -> 66
    //   63: goto +174 -> 237
    //   66: aload_1
    //   67: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   70: iconst_2
    //   71: if_icmpeq +154 -> 225
    //   74: aload_1
    //   75: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   78: iconst_4
    //   79: if_icmpne +6 -> 85
    //   82: goto +143 -> 225
    //   85: aload_1
    //   86: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   89: iconst_5
    //   90: if_icmpne +13 -> 103
    //   93: ldc 29
    //   95: astore 6
    //   97: aload 6
    //   99: astore_0
    //   100: goto +382 -> 482
    //   103: aload_1
    //   104: getfield 194	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   107: bipush 6
    //   109: if_icmpne +104 -> 213
    //   112: new 39	org/json/JSONObject
    //   115: dup
    //   116: aload_1
    //   117: getfield 273	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   120: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   123: astore 8
    //   125: aload 8
    //   127: ldc 48
    //   129: invokevirtual 279	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   132: istore_2
    //   133: aload 8
    //   135: ldc_w 281
    //   138: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 6
    //   143: aload 8
    //   145: ldc 182
    //   147: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   150: astore_0
    //   151: aload 8
    //   153: ldc_w 286
    //   156: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 8
    //   161: aload 8
    //   163: astore 7
    //   165: goto +33 -> 198
    //   168: astore 8
    //   170: goto +20 -> 190
    //   173: astore 8
    //   175: ldc 29
    //   177: astore_0
    //   178: goto +12 -> 190
    //   181: astore 8
    //   183: ldc 29
    //   185: astore 6
    //   187: aload 6
    //   189: astore_0
    //   190: aload 8
    //   192: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   195: bipush 10
    //   197: istore_2
    //   198: aload 7
    //   200: astore 8
    //   202: aload 6
    //   204: astore 7
    //   206: aload 8
    //   208: astore 6
    //   210: goto +250 -> 460
    //   213: ldc 29
    //   215: astore 6
    //   217: aload 6
    //   219: astore_0
    //   220: iconst_0
    //   221: istore_2
    //   222: goto +260 -> 482
    //   225: ldc 29
    //   227: astore 6
    //   229: aload 6
    //   231: astore_0
    //   232: iconst_2
    //   233: istore_2
    //   234: goto +248 -> 482
    //   237: aload_0
    //   238: ifnull +24 -> 262
    //   241: aload_0
    //   242: aload_1
    //   243: invokevirtual 290	com/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager:i	(Lcom/tencent/mobileqq/data/MessageRecord;)I
    //   246: iconst_1
    //   247: if_icmpne +15 -> 262
    //   250: ldc 29
    //   252: astore 6
    //   254: aload 6
    //   256: astore_0
    //   257: iconst_5
    //   258: istore_2
    //   259: goto +223 -> 482
    //   262: aload_1
    //   263: instanceof 212
    //   266: ifeq +207 -> 473
    //   269: aload_1
    //   270: checkcast 212	com/tencent/mobileqq/data/MessageForStructing
    //   273: astore 8
    //   275: aload 8
    //   277: invokevirtual 293	com/tencent/mobileqq/data/MessageForStructing:parse	()V
    //   280: aload 8
    //   282: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   285: ifnull +166 -> 451
    //   288: aload 8
    //   290: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   293: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mStrategyIds	Ljava/lang/String;
    //   296: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   299: ifne +23 -> 322
    //   302: aload 8
    //   304: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   307: getfield 296	com/tencent/mobileqq/structmsg/AbsStructMsg:mStrategyIds	Ljava/lang/String;
    //   310: ldc_w 298
    //   313: invokevirtual 302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   316: iconst_0
    //   317: aaload
    //   318: astore_0
    //   319: goto +6 -> 325
    //   322: ldc 29
    //   324: astore_0
    //   325: aload 8
    //   327: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   330: getfield 305	com/tencent/mobileqq/structmsg/AbsStructMsg:mAlgorithmIds	Ljava/lang/String;
    //   333: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +24 -> 360
    //   339: aload 8
    //   341: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   344: getfield 305	com/tencent/mobileqq/structmsg/AbsStructMsg:mAlgorithmIds	Ljava/lang/String;
    //   347: ldc_w 298
    //   350: invokevirtual 302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   353: iconst_0
    //   354: aaload
    //   355: astore 6
    //   357: goto +7 -> 364
    //   360: ldc 29
    //   362: astore 6
    //   364: aload 8
    //   366: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   369: getfield 308	com/tencent/mobileqq/structmsg/AbsStructMsg:mArticleIds	Ljava/lang/String;
    //   372: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +21 -> 396
    //   378: aload 8
    //   380: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   383: getfield 308	com/tencent/mobileqq/structmsg/AbsStructMsg:mArticleIds	Ljava/lang/String;
    //   386: ldc_w 298
    //   389: invokevirtual 302	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   392: iconst_0
    //   393: aaload
    //   394: astore 7
    //   396: aload 8
    //   398: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   401: getfield 221	com/tencent/mobileqq/structmsg/AbsStructMsg:reportEventFolderStatusValue	Ljava/lang/String;
    //   404: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifne +25 -> 432
    //   410: aload 8
    //   412: getfield 216	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   415: getfield 221	com/tencent/mobileqq/structmsg/AbsStructMsg:reportEventFolderStatusValue	Ljava/lang/String;
    //   418: invokestatic 107	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   421: istore_2
    //   422: goto +12 -> 434
    //   425: astore 8
    //   427: aload 8
    //   429: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   432: iconst_3
    //   433: istore_2
    //   434: aload 7
    //   436: astore 8
    //   438: aload_0
    //   439: astore 7
    //   441: aload 6
    //   443: astore_0
    //   444: aload 8
    //   446: astore 6
    //   448: goto +12 -> 460
    //   451: ldc 29
    //   453: astore 6
    //   455: aload 6
    //   457: astore_0
    //   458: iconst_3
    //   459: istore_2
    //   460: aload_0
    //   461: astore 8
    //   463: aload 7
    //   465: astore_0
    //   466: aload 8
    //   468: astore 7
    //   470: goto +12 -> 482
    //   473: ldc 29
    //   475: astore 6
    //   477: aload 6
    //   479: astore_0
    //   480: iconst_3
    //   481: istore_2
    //   482: iload_2
    //   483: invokestatic 312	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:updateMergeKandianFolderStatus	(I)V
    //   486: getstatic 25	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:RED_PNT_INFO_FOR_REPORT	Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;
    //   489: astore 8
    //   491: aload 8
    //   493: iload_2
    //   494: putfield 314	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:a	I
    //   497: aload 8
    //   499: aload 7
    //   501: putfield 316	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:b	Ljava/lang/String;
    //   504: aload 8
    //   506: aload_0
    //   507: putfield 121	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:c	Ljava/lang/String;
    //   510: aload 8
    //   512: aload 6
    //   514: putfield 318	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:d	Ljava/lang/String;
    //   517: aload_1
    //   518: getfield 273	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   521: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   524: ifne +74 -> 598
    //   527: aload_1
    //   528: getfield 191	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   531: ifne +67 -> 598
    //   534: new 39	org/json/JSONObject
    //   537: dup
    //   538: aload_1
    //   539: getfield 273	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   542: invokespecial 276	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   545: astore_0
    //   546: getstatic 25	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:RED_PNT_INFO_FOR_REPORT	Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;
    //   549: aload_0
    //   550: ldc_w 320
    //   553: lconst_0
    //   554: invokevirtual 324	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   557: putfield 325	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:f	J
    //   560: aload_0
    //   561: ldc_w 327
    //   564: ldc2_w 328
    //   567: invokevirtual 324	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   570: lstore 4
    //   572: lload 4
    //   574: lconst_0
    //   575: lcmp
    //   576: ifle +29 -> 605
    //   579: getstatic 25	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:RED_PNT_INFO_FOR_REPORT	Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;
    //   582: lload 4
    //   584: putfield 325	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:f	J
    //   587: goto +18 -> 605
    //   590: astore_0
    //   591: aload_0
    //   592: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   595: goto +10 -> 605
    //   598: getstatic 25	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:RED_PNT_INFO_FOR_REPORT	Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;
    //   601: lconst_0
    //   602: putfield 325	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:f	J
    //   605: getstatic 25	com/tencent/mobileqq/kandian/biz/push/RIJKanDianFolderStatus:RED_PNT_INFO_FOR_REPORT	Lcom/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport;
    //   608: aload_1
    //   609: getfield 149	com/tencent/mobileqq/data/MessageRecord:time	J
    //   612: putfield 331	com/tencent/mobileqq/kandian/biz/feeds/entity/RedPntInfoForReport:g	J
    //   615: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	paramQQAppInterface	QQAppInterface
    //   0	616	1	paramMessageRecord	MessageRecord
    //   26	468	2	i	int
    //   23	9	3	bool	boolean
    //   570	13	4	l	long
    //   37	476	6	localObject1	Object
    //   29	471	7	localObject2	Object
    //   123	39	8	localObject3	Object
    //   168	1	8	localException1	Exception
    //   173	1	8	localException2	Exception
    //   181	10	8	localException3	Exception
    //   200	211	8	localObject4	Object
    //   425	3	8	localException4	Exception
    //   436	75	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   151	161	168	java/lang/Exception
    //   143	151	173	java/lang/Exception
    //   112	143	181	java/lang/Exception
    //   410	422	425	java/lang/Exception
    //   534	572	590	java/lang/Exception
    //   579	587	590	java/lang/Exception
  }
  
  public static void updateLastKandianMsgRecord(MessageRecord paramMessageRecord)
  {
    RED_PNT_INFO_FOR_REPORT.e = paramMessageRecord;
  }
  
  public static void updateMergeKandianFolderStatus(int paramInt)
  {
    reportFolderStatus = paramInt;
    RED_PNT_INFO_FOR_REPORT.a = reportFolderStatus;
    SPEventReportSwitch.a(paramInt);
    QLog.d("RIJKanDianFolderStatus", 1, new Object[] { "update fs : ", Integer.valueOf(paramInt) });
  }
  
  public static void updateReportSessionId(String paramString)
  {
    reportSessionId = paramString;
  }
  
  public RedPntInfoForReport getRedPntInfoForReport()
  {
    return RED_PNT_INFO_FOR_REPORT;
  }
  
  public int getReportFolderStatus()
  {
    return reportFolderStatus;
  }
  
  public void setReportLastRedPntPosition(int paramInt)
  {
    reportLastRedPntPosition = paramInt;
  }
  
  public void updateKandianFolderStatus(BaseQQAppInterface paramBaseQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramBaseQQAppInterface instanceof QQAppInterface)) {
      updateKandianFolderStatus((QQAppInterface)paramBaseQQAppInterface, paramMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus
 * JD-Core Version:    0.7.0.1
 */