package com.tencent.mobileqq.teamwork.api.impl;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.CommonUtils;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJob;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForDataLIne;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForFile2Form;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportJobForUrl2Doc;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IRelyClassCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportJob;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.ImportFormData;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkFileImportHandlerImpl
  extends BusinessHandler
  implements Handler.Callback, ITeamWorkFileImportHandler
{
  public static final int MSG_FILE_CHECK_ERROR = 8005;
  public static final int MSG_FILE_CHECK_SUCCESS = 8004;
  public static final int MSG_FILE_IMPORTING = 8003;
  public static final int MSG_FILE_IMPORT_ERROR = 8002;
  public static final int MSG_FILE_IMPORT_SUCCESS = 8001;
  public static final int OBSERVER_FILE_IMPORT_FAILED = 2;
  public static final int OBSERVER_FILE_IMPORT_GET_DOT = 3;
  public static final int OBSERVER_FILE_IMPORT_IS_NEW_TENCENT_DOC = 5;
  public static final int OBSERVER_FILE_IMPORT_STARTED = 4;
  public static final int OBSERVER_FILE_IMPORT_SUCCESS = 1;
  public static final int OBSERVER_FILE_IS_IMPORTED = 6;
  public static final int OBSERVER_FILE_IS_NO_CACHE = 7;
  public static final int RETCODE_CGI_NOT_RETURN = -1000;
  public static final int RETCODE_CGI_NO_PUBLIC_CACHE = 20003;
  public static final int RETCODE_CGI_NO_USER_CACHE = 20004;
  public static final int RETCODE_CGI_NO_USER_CACHE_FOR_DISCUSS = 20005;
  public static final String TAG = "TeamWorkFileImportHandlerImpl";
  private AppInterface app;
  private String[] domainArray = { "docs.qq.com" };
  private volatile boolean isNeedToast = false;
  private volatile boolean isWorderRunning = false;
  private ConcurrentHashMap<String, String> mFileConvertedMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> mFileConvertedMapForDiscuss = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<ITeamWorkFileImportJob> mFileImportInfoWorker = new ConcurrentLinkedQueue();
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> mFileImportingInfoMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> mFileImportingInfoMapForDiscuss = new ConcurrentHashMap();
  private Handler mUIHandler = new Handler(Looper.getMainLooper(), this);
  
  public TeamWorkFileImportHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
  }
  
  private void addTeamWorkFileImportJob(ITeamWorkFileImportJob paramITeamWorkFileImportJob)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue = this.mFileImportInfoWorker;
    if ((localConcurrentLinkedQueue != null) && (paramITeamWorkFileImportJob != null)) {
      localConcurrentLinkedQueue.add(paramITeamWorkFileImportJob);
    }
  }
  
  private void doRequestAfterGetTicket(Runnable paramRunnable)
  {
    AppInterface localAppInterface = this.app;
    if (localAppInterface == null) {
      return;
    }
    if (((TicketManager)localAppInterface.getManager(2)).getPskey(this.app.getCurrentAccountUin(), 16L, this.domainArray, new TeamWorkFileImportHandlerImpl.9(this, paramRunnable)) != null) {
      ThreadManager.executeOnNetWorkThread(paramRunnable);
    }
  }
  
  public static String getClassName()
  {
    return TeamWorkFileImportHandlerImpl.class.getName();
  }
  
  private String getTeamWorkFileImportInfoKey(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool = paramTeamWorkFileImportInfo.c();
    String str1 = "";
    Object localObject;
    if (bool)
    {
      localObject = TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo);
      String str2 = paramTeamWorkFileImportInfo.c;
      paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.n;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return localObject;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo)) {
        return paramTeamWorkFileImportInfo;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str2))
      {
        paramTeamWorkFileImportInfo = new StringBuilder();
        paramTeamWorkFileImportInfo.append(str2);
        paramTeamWorkFileImportInfo.append(this.app);
        localObject = str1;
        if (paramTeamWorkFileImportInfo.toString() != null) {
          return this.app.getCurrentAccountUin();
        }
      }
    }
    else
    {
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString);
        return ((StringBuilder)localObject).toString();
      }
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0))
      {
        if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
          return paramTeamWorkFileImportInfo.c;
        }
        localObject = str1;
        if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString)) {
          return paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Long);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_b_of_type_Long);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  /* Error */
  private boolean parseFileImportResult(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 244	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;)J
    //   7: lstore 8
    //   9: aload_0
    //   10: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   13: astore 11
    //   15: aload_2
    //   16: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   19: astore 12
    //   21: new 202	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   28: astore 13
    //   30: aload 13
    //   32: ldc 246
    //   34: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 13
    //   40: aload_2
    //   41: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   44: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 13
    //   50: aload_2
    //   51: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   54: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 13
    //   60: aload_2
    //   61: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   64: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 11
    //   70: aload 12
    //   72: ldc_w 256
    //   75: lload 8
    //   77: invokestatic 260	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: aload 13
    //   82: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: ldc 184
    //   87: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +2601 -> 2695
    //   97: new 265	org/json/JSONObject
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 268	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   105: astore 16
    //   107: aload 16
    //   109: ldc_w 270
    //   112: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   115: istore 7
    //   117: aload 16
    //   119: ldc_w 276
    //   122: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   125: istore 10
    //   127: iload 10
    //   129: ifeq +24 -> 153
    //   132: aload 16
    //   134: ldc_w 276
    //   137: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: pop
    //   141: goto +12 -> 153
    //   144: astore 11
    //   146: ldc 246
    //   148: astore 12
    //   150: goto +2310 -> 2460
    //   153: aload 16
    //   155: ldc_w 286
    //   158: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 15
    //   163: new 202	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   170: astore 11
    //   172: aload 11
    //   174: ldc_w 288
    //   177: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 11
    //   183: aload_2
    //   184: getfield 290	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   187: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 45
    //   193: aload 11
    //   195: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   201: invokestatic 260	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   204: aload_2
    //   205: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   208: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   211: iload 7
    //   213: bipush 140
    //   215: if_icmpeq +1064 -> 1279
    //   218: ldc 184
    //   220: astore 12
    //   222: iload 7
    //   224: bipush 141
    //   226: if_icmpeq +793 -> 1019
    //   229: iload 7
    //   231: ifeq +226 -> 457
    //   234: iload 7
    //   236: bipush 115
    //   238: if_icmpeq +781 -> 1019
    //   241: iload 7
    //   243: bipush 116
    //   245: if_icmpeq +1034 -> 1279
    //   248: iload 7
    //   250: tableswitch	default:+26 -> 276, 20003:+175->425, 20004:+143->393, 20005:+113->363
    //   277: iload 7
    //   279: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   282: aload_2
    //   283: aload 15
    //   285: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   288: new 202	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   295: astore 11
    //   297: aload 11
    //   299: ldc_w 306
    //   302: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 11
    //   308: iload 7
    //   310: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 11
    //   316: ldc_w 308
    //   319: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 11
    //   325: aload_2
    //   326: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   329: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 45
    //   335: iconst_1
    //   336: aload 11
    //   338: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: ldc 45
    //   346: ldc_w 316
    //   349: aload_2
    //   350: invokevirtual 317	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   353: aload_2
    //   354: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   357: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto +656 -> 1016
    //   363: aload_0
    //   364: aload_2
    //   365: invokevirtual 321	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:removeFileImporting	(Lcom/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo;)V
    //   368: aload_0
    //   369: aload_2
    //   370: invokevirtual 324	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:removeFromConvertedMap	(Lcom/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo;)V
    //   373: aload_0
    //   374: iconst_5
    //   375: iconst_1
    //   376: iconst_1
    //   377: anewarray 326	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: iconst_1
    //   383: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   386: aastore
    //   387: invokevirtual 335	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   390: goto +626 -> 1016
    //   393: ldc 45
    //   395: iconst_1
    //   396: ldc_w 337
    //   399: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: aload_0
    //   403: bipush 7
    //   405: iconst_0
    //   406: iconst_1
    //   407: anewarray 326	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_2
    //   413: aastore
    //   414: invokevirtual 335	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   417: aload_2
    //   418: iconst_0
    //   419: putfield 342	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   422: goto +594 -> 1016
    //   425: ldc 45
    //   427: iconst_1
    //   428: ldc_w 344
    //   431: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_0
    //   435: bipush 7
    //   437: iconst_0
    //   438: iconst_1
    //   439: anewarray 326	java/lang/Object
    //   442: dup
    //   443: iconst_0
    //   444: aload_2
    //   445: aastore
    //   446: invokevirtual 335	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   449: aload_2
    //   450: iconst_0
    //   451: putfield 342	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   454: goto +562 -> 1016
    //   457: aload 16
    //   459: ldc_w 346
    //   462: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: astore 13
    //   467: aload_0
    //   468: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   471: ifnull +545 -> 1016
    //   474: aload 13
    //   476: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: ifne +537 -> 1016
    //   482: aload_0
    //   483: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   486: ifnull +530 -> 1016
    //   489: aload 16
    //   491: ldc_w 348
    //   494: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   497: ifeq +2293 -> 2790
    //   500: aload 16
    //   502: ldc_w 348
    //   505: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   508: istore_3
    //   509: goto +3 -> 512
    //   512: aload_2
    //   513: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   516: istore 4
    //   518: new 202	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   525: astore 11
    //   527: aload 11
    //   529: ldc_w 350
    //   532: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 11
    //   538: iload_3
    //   539: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 11
    //   545: ldc_w 352
    //   548: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload 11
    //   554: iload 4
    //   556: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: ldc 45
    //   562: iconst_1
    //   563: aload 11
    //   565: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload 13
    //   573: astore 11
    //   575: aload_2
    //   576: invokevirtual 354	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:d	()Z
    //   579: ifeq +170 -> 749
    //   582: ldc_w 356
    //   585: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   588: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   591: aload 13
    //   593: invokeinterface 365 2 0
    //   598: astore 13
    //   600: iload_3
    //   601: iconst_1
    //   602: if_icmpeq +2193 -> 2795
    //   605: iload_3
    //   606: iconst_2
    //   607: if_icmpne +16 -> 623
    //   610: goto +3 -> 613
    //   613: aload_0
    //   614: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   617: ldc_w 367
    //   620: invokestatic 370	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)V
    //   623: iload_3
    //   624: iconst_2
    //   625: if_icmpne +26 -> 651
    //   628: ldc 45
    //   630: iconst_1
    //   631: ldc_w 372
    //   634: invokestatic 375	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_2
    //   638: iload_3
    //   639: putfield 342	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   642: aload_2
    //   643: aload 13
    //   645: putfield 378	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:p	Ljava/lang/String;
    //   648: goto +368 -> 1016
    //   651: iload_3
    //   652: iconst_1
    //   653: if_icmpne +15 -> 668
    //   656: aload_2
    //   657: aconst_null
    //   658: putfield 378	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:p	Ljava/lang/String;
    //   661: aload 13
    //   663: astore 11
    //   665: goto +84 -> 749
    //   668: aload 13
    //   670: astore 11
    //   672: iload_3
    //   673: ifne +76 -> 749
    //   676: aload 13
    //   678: astore 11
    //   680: aload_2
    //   681: getfield 378	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:p	Ljava/lang/String;
    //   684: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   687: ifne +62 -> 749
    //   690: ldc_w 356
    //   693: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   696: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   699: aload 13
    //   701: aload_2
    //   702: getfield 378	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:p	Ljava/lang/String;
    //   705: invokeinterface 382 3 0
    //   710: astore 11
    //   712: new 202	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   719: astore 13
    //   721: aload 13
    //   723: ldc_w 384
    //   726: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 13
    //   732: aload 11
    //   734: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: ldc 45
    //   740: iconst_1
    //   741: aload 13
    //   743: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 375	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: aload 16
    //   751: ldc_w 386
    //   754: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   757: ifeq +13 -> 770
    //   760: aload 16
    //   762: ldc_w 386
    //   765: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   768: astore 12
    //   770: aload_2
    //   771: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   774: bipush 7
    //   776: if_icmpne +50 -> 826
    //   779: aload_2
    //   780: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   783: iconst_1
    //   784: if_icmpne +42 -> 826
    //   787: aload 12
    //   789: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   792: ifne +9 -> 801
    //   795: aload_0
    //   796: aload 12
    //   798: invokevirtual 389	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:getTencentDocReddot	(Ljava/lang/String;)V
    //   801: aload 11
    //   803: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   806: ifne +20 -> 826
    //   809: aload_0
    //   810: iconst_5
    //   811: iconst_1
    //   812: iconst_1
    //   813: anewarray 326	java/lang/Object
    //   816: dup
    //   817: iconst_0
    //   818: iconst_0
    //   819: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   822: aastore
    //   823: invokevirtual 335	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   826: aload_2
    //   827: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   830: iconst_1
    //   831: if_icmpne +28 -> 859
    //   834: aload_0
    //   835: bipush 6
    //   837: iconst_1
    //   838: iconst_3
    //   839: anewarray 326	java/lang/Object
    //   842: dup
    //   843: iconst_0
    //   844: aload 11
    //   846: aastore
    //   847: dup
    //   848: iconst_1
    //   849: aload 12
    //   851: aastore
    //   852: dup
    //   853: iconst_2
    //   854: aload_2
    //   855: aastore
    //   856: invokevirtual 335	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:notifyUI	(IZLjava/lang/Object;)V
    //   859: aload_2
    //   860: iload_3
    //   861: putfield 342	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   864: aload_2
    //   865: aload 12
    //   867: putfield 392	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:m	Ljava/lang/String;
    //   870: new 394	android/os/Bundle
    //   873: dup
    //   874: invokespecial 395	android/os/Bundle:<init>	()V
    //   877: astore 12
    //   879: aload 12
    //   881: ldc_w 346
    //   884: aload 11
    //   886: invokevirtual 399	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload 12
    //   891: ldc_w 401
    //   894: aload_2
    //   895: invokevirtual 405	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   898: aload_0
    //   899: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   902: sipush 8001
    //   905: invokevirtual 409	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   908: astore 13
    //   910: aload 13
    //   912: aload 12
    //   914: invokevirtual 415	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   917: aload_0
    //   918: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   921: aload 13
    //   923: invokevirtual 419	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   926: pop
    //   927: aload_0
    //   928: aload_2
    //   929: aload 11
    //   931: invokevirtual 423	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:addToConvertedMap	(Lcom/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   934: iload 4
    //   936: iconst_1
    //   937: if_icmpeq +31 -> 968
    //   940: iload 4
    //   942: bipush 7
    //   944: if_icmpeq +24 -> 968
    //   947: aload_2
    //   948: invokevirtual 425	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:a	()Z
    //   951: ifne +17 -> 968
    //   954: aload_2
    //   955: invokevirtual 427	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:b	()Z
    //   958: ifne +10 -> 968
    //   961: aload_0
    //   962: aload_2
    //   963: aload 11
    //   965: invokevirtual 430	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:createGrayTips	(Lcom/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   968: aload_0
    //   969: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   972: ldc_w 432
    //   975: ldc 184
    //   977: ldc 184
    //   979: ldc_w 434
    //   982: ldc_w 434
    //   985: iconst_0
    //   986: iconst_0
    //   987: ldc 184
    //   989: ldc 184
    //   991: ldc 184
    //   993: ldc 184
    //   995: invokestatic 439	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   998: iconst_1
    //   999: istore 10
    //   1001: goto +1170 -> 2171
    //   1004: astore 11
    //   1006: ldc 246
    //   1008: astore 12
    //   1010: iconst_1
    //   1011: istore 10
    //   1013: goto +1450 -> 2463
    //   1016: goto +1152 -> 2168
    //   1019: aload 16
    //   1021: ldc_w 441
    //   1024: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1027: ifeq +1771 -> 2798
    //   1030: aload 16
    //   1032: ldc_w 441
    //   1035: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1038: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1041: ifne +1757 -> 2798
    //   1044: aload 16
    //   1046: ldc_w 441
    //   1049: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1052: astore 11
    //   1054: goto +3 -> 1057
    //   1057: aload 16
    //   1059: ldc_w 443
    //   1062: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1065: ifeq +1740 -> 2805
    //   1068: aload 16
    //   1070: ldc_w 443
    //   1073: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1076: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1079: ifne +1726 -> 2805
    //   1082: aload 16
    //   1084: ldc_w 443
    //   1087: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1090: astore 13
    //   1092: goto +3 -> 1095
    //   1095: aload 12
    //   1097: astore 14
    //   1099: aload 16
    //   1101: ldc_w 445
    //   1104: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1107: ifeq +31 -> 1138
    //   1110: aload 12
    //   1112: astore 14
    //   1114: aload 16
    //   1116: ldc_w 445
    //   1119: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1122: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1125: ifne +13 -> 1138
    //   1128: aload 16
    //   1130: ldc_w 445
    //   1133: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: astore 14
    //   1138: aload_2
    //   1139: getfield 447	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1142: astore 12
    //   1144: aload_2
    //   1145: getstatic 450	com/tencent/mobileqq/teamwork/TeamWorkConstants:p	Ljava/lang/String;
    //   1148: iconst_5
    //   1149: anewarray 326	java/lang/Object
    //   1152: dup
    //   1153: iconst_0
    //   1154: aload 12
    //   1156: ldc_w 452
    //   1159: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1162: aastore
    //   1163: dup
    //   1164: iconst_1
    //   1165: aload 13
    //   1167: ldc_w 452
    //   1170: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1173: aastore
    //   1174: dup
    //   1175: iconst_2
    //   1176: aload 14
    //   1178: ldc_w 452
    //   1181: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1184: aastore
    //   1185: dup
    //   1186: iconst_3
    //   1187: aload 11
    //   1189: ldc_w 452
    //   1192: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1195: aastore
    //   1196: dup
    //   1197: iconst_4
    //   1198: ldc_w 459
    //   1201: aastore
    //   1202: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1205: putfield 465	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:i	Ljava/lang/String;
    //   1208: aload_2
    //   1209: iload 7
    //   1211: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   1214: aload_2
    //   1215: aload 15
    //   1217: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1220: new 202	java/lang/StringBuilder
    //   1223: dup
    //   1224: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1227: astore 11
    //   1229: aload 11
    //   1231: ldc_w 306
    //   1234: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: pop
    //   1238: aload 11
    //   1240: iload 7
    //   1242: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1245: pop
    //   1246: aload 11
    //   1248: ldc_w 308
    //   1251: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload 11
    //   1257: aload_2
    //   1258: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1261: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: ldc 45
    //   1267: iconst_1
    //   1268: aload 11
    //   1270: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1276: goto -260 -> 1016
    //   1279: new 265	org/json/JSONObject
    //   1282: dup
    //   1283: aload 15
    //   1285: invokespecial 268	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1288: astore 11
    //   1290: aload 11
    //   1292: ldc_w 467
    //   1295: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1298: istore 10
    //   1300: iload 10
    //   1302: ifeq +15 -> 1317
    //   1305: aload 11
    //   1307: ldc_w 467
    //   1310: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1313: istore_3
    //   1314: goto +5 -> 1319
    //   1317: iconst_0
    //   1318: istore_3
    //   1319: aload 11
    //   1321: ldc_w 469
    //   1324: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1327: istore 10
    //   1329: iload 10
    //   1331: ifeq +16 -> 1347
    //   1334: aload 11
    //   1336: ldc_w 469
    //   1339: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1342: istore 4
    //   1344: goto +6 -> 1350
    //   1347: iconst_0
    //   1348: istore 4
    //   1350: aload 11
    //   1352: ldc_w 471
    //   1355: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1358: istore 10
    //   1360: iload 10
    //   1362: ifeq +16 -> 1378
    //   1365: aload 11
    //   1367: ldc_w 471
    //   1370: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1373: istore 5
    //   1375: goto +6 -> 1381
    //   1378: iconst_0
    //   1379: istore 5
    //   1381: aload 11
    //   1383: ldc_w 473
    //   1386: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1389: istore 10
    //   1391: iload 10
    //   1393: ifeq +16 -> 1409
    //   1396: aload 11
    //   1398: ldc_w 473
    //   1401: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1404: istore 6
    //   1406: goto +6 -> 1412
    //   1409: iconst_0
    //   1410: istore 6
    //   1412: ldc_w 356
    //   1415: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1418: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   1421: iload 5
    //   1423: invokeinterface 477 2 0
    //   1428: astore 11
    //   1430: ldc_w 356
    //   1433: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1436: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   1439: iload 6
    //   1441: invokeinterface 477 2 0
    //   1446: astore 12
    //   1448: new 202	java/lang/StringBuilder
    //   1451: dup
    //   1452: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1455: astore 13
    //   1457: aload 13
    //   1459: aload_0
    //   1460: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1463: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1466: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1469: ldc_w 488
    //   1472: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1475: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: pop
    //   1479: iload_3
    //   1480: ifeq +329 -> 1809
    //   1483: iload 5
    //   1485: ifeq +324 -> 1809
    //   1488: iload_3
    //   1489: iload 4
    //   1491: if_icmpne +73 -> 1564
    //   1494: aload 13
    //   1496: aload_0
    //   1497: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1500: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1503: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1506: ldc_w 493
    //   1509: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1512: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: pop
    //   1516: aload 13
    //   1518: ldc_w 495
    //   1521: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: pop
    //   1525: aload 13
    //   1527: aload_0
    //   1528: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1531: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1534: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1537: ldc_w 496
    //   1540: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1543: iconst_1
    //   1544: anewarray 326	java/lang/Object
    //   1547: dup
    //   1548: iconst_0
    //   1549: iload_3
    //   1550: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: aastore
    //   1554: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1557: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: pop
    //   1561: goto +82 -> 1643
    //   1564: aload 13
    //   1566: aload_0
    //   1567: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1570: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1573: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1576: ldc_w 493
    //   1579: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1582: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 13
    //   1588: ldc_w 495
    //   1591: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: pop
    //   1595: aload_0
    //   1596: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1599: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1602: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1605: ldc_w 497
    //   1608: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1611: astore 14
    //   1613: aload 13
    //   1615: aload 14
    //   1617: iconst_2
    //   1618: anewarray 326	java/lang/Object
    //   1621: dup
    //   1622: iconst_0
    //   1623: iload_3
    //   1624: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1627: aastore
    //   1628: dup
    //   1629: iconst_1
    //   1630: iload 4
    //   1632: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1635: aastore
    //   1636: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1639: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: iload 5
    //   1645: iload 6
    //   1647: if_icmpne +80 -> 1727
    //   1650: aload 13
    //   1652: ldc_w 499
    //   1655: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 13
    //   1661: aload_0
    //   1662: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1665: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1668: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1671: ldc_w 493
    //   1674: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1677: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aload 13
    //   1683: ldc_w 501
    //   1686: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1689: pop
    //   1690: aload 13
    //   1692: aload_0
    //   1693: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1696: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1699: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1702: ldc_w 502
    //   1705: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1708: iconst_1
    //   1709: anewarray 326	java/lang/Object
    //   1712: dup
    //   1713: iconst_0
    //   1714: aload 11
    //   1716: aastore
    //   1717: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1720: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: goto +1093 -> 2817
    //   1727: aload 13
    //   1729: ldc_w 499
    //   1732: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1735: pop
    //   1736: aload 13
    //   1738: aload_0
    //   1739: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1742: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1745: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1748: ldc_w 493
    //   1751: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1754: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: pop
    //   1758: aload 13
    //   1760: ldc_w 501
    //   1763: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: pop
    //   1767: aload 13
    //   1769: aload_0
    //   1770: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1773: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1776: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1779: ldc_w 503
    //   1782: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1785: iconst_2
    //   1786: anewarray 326	java/lang/Object
    //   1789: dup
    //   1790: iconst_0
    //   1791: aload 11
    //   1793: aastore
    //   1794: dup
    //   1795: iconst_1
    //   1796: aload 12
    //   1798: aastore
    //   1799: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1802: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: pop
    //   1806: goto +1011 -> 2817
    //   1809: iload_3
    //   1810: ifeq +144 -> 1954
    //   1813: iload 5
    //   1815: ifne +139 -> 1954
    //   1818: iload_3
    //   1819: iload 4
    //   1821: if_icmpne +64 -> 1885
    //   1824: aload 13
    //   1826: aload_0
    //   1827: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1830: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1833: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1836: ldc_w 493
    //   1839: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1842: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: pop
    //   1846: aload 13
    //   1848: aload_0
    //   1849: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1852: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1855: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1858: ldc_w 496
    //   1861: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1864: iconst_1
    //   1865: anewarray 326	java/lang/Object
    //   1868: dup
    //   1869: iconst_0
    //   1870: iload_3
    //   1871: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1874: aastore
    //   1875: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1878: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1881: pop
    //   1882: goto +935 -> 2817
    //   1885: aload 13
    //   1887: aload_0
    //   1888: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1891: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1894: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1897: ldc_w 493
    //   1900: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1903: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: pop
    //   1907: aload 13
    //   1909: aload_0
    //   1910: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1913: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1916: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1919: ldc_w 497
    //   1922: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1925: iconst_2
    //   1926: anewarray 326	java/lang/Object
    //   1929: dup
    //   1930: iconst_0
    //   1931: iload_3
    //   1932: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1935: aastore
    //   1936: dup
    //   1937: iconst_1
    //   1938: iload 4
    //   1940: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1943: aastore
    //   1944: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1947: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: pop
    //   1951: goto +866 -> 2817
    //   1954: iload_3
    //   1955: ifne +862 -> 2817
    //   1958: iload 5
    //   1960: ifeq +857 -> 2817
    //   1963: iload 5
    //   1965: iload 6
    //   1967: if_icmpne +62 -> 2029
    //   1970: aload 13
    //   1972: aload_0
    //   1973: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1976: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1979: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1982: ldc_w 493
    //   1985: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1988: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: pop
    //   1992: aload 13
    //   1994: aload_0
    //   1995: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1998: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2001: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2004: ldc_w 502
    //   2007: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2010: iconst_1
    //   2011: anewarray 326	java/lang/Object
    //   2014: dup
    //   2015: iconst_0
    //   2016: aload 11
    //   2018: aastore
    //   2019: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2022: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2025: pop
    //   2026: goto +791 -> 2817
    //   2029: aload 13
    //   2031: aload_0
    //   2032: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2035: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2038: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2041: ldc_w 493
    //   2044: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2047: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: pop
    //   2051: aload_0
    //   2052: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2055: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2058: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2061: ldc_w 503
    //   2064: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2067: astore 14
    //   2069: aload 13
    //   2071: aload 14
    //   2073: iconst_2
    //   2074: anewarray 326	java/lang/Object
    //   2077: dup
    //   2078: iconst_0
    //   2079: aload 11
    //   2081: aastore
    //   2082: dup
    //   2083: iconst_1
    //   2084: aload 12
    //   2086: aastore
    //   2087: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2090: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: pop
    //   2094: goto +3 -> 2097
    //   2097: aload_2
    //   2098: iload 7
    //   2100: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   2103: aload_2
    //   2104: aload 13
    //   2106: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2109: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2112: new 202	java/lang/StringBuilder
    //   2115: dup
    //   2116: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2119: astore 11
    //   2121: aload 11
    //   2123: ldc_w 306
    //   2126: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: pop
    //   2130: aload 11
    //   2132: iload 7
    //   2134: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2137: pop
    //   2138: aload 11
    //   2140: ldc_w 308
    //   2143: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: pop
    //   2147: aload 11
    //   2149: aload_2
    //   2150: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2153: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2156: pop
    //   2157: ldc 45
    //   2159: iconst_1
    //   2160: aload 11
    //   2162: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2165: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2168: iconst_0
    //   2169: istore 10
    //   2171: iload 7
    //   2173: ifne +85 -> 2258
    //   2176: aload_0
    //   2177: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2180: astore 11
    //   2182: aload_2
    //   2183: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2186: astore 12
    //   2188: new 202	java/lang/StringBuilder
    //   2191: dup
    //   2192: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2195: astore 13
    //   2197: aload 13
    //   2199: ldc 246
    //   2201: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: pop
    //   2205: aload 13
    //   2207: aload_2
    //   2208: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   2211: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2214: pop
    //   2215: aload 13
    //   2217: aload_2
    //   2218: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   2221: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2224: pop
    //   2225: aload 13
    //   2227: aload_2
    //   2228: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   2231: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2234: pop
    //   2235: aload 11
    //   2237: aload 12
    //   2239: ldc_w 505
    //   2242: ldc_w 507
    //   2245: aload 13
    //   2247: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2250: ldc 184
    //   2252: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2255: goto +123 -> 2378
    //   2258: aload_0
    //   2259: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2262: astore 11
    //   2264: aload_2
    //   2265: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2268: astore 12
    //   2270: new 202	java/lang/StringBuilder
    //   2273: dup
    //   2274: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2277: astore 13
    //   2279: aload 13
    //   2281: ldc_w 509
    //   2284: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2287: pop
    //   2288: aload 13
    //   2290: iload 7
    //   2292: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2295: pop
    //   2296: aload 13
    //   2298: aload 15
    //   2300: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2303: pop
    //   2304: aload 13
    //   2306: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2309: astore 13
    //   2311: new 202	java/lang/StringBuilder
    //   2314: dup
    //   2315: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2318: astore 14
    //   2320: aload 14
    //   2322: ldc 246
    //   2324: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2327: pop
    //   2328: aload 14
    //   2330: aload_2
    //   2331: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   2334: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2337: pop
    //   2338: aload 14
    //   2340: aload_2
    //   2341: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   2344: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2347: pop
    //   2348: aload 14
    //   2350: aload_2
    //   2351: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   2354: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2357: pop
    //   2358: aload 11
    //   2360: aload 12
    //   2362: ldc_w 505
    //   2365: ldc_w 511
    //   2368: aload 13
    //   2370: aload 14
    //   2372: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2375: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2378: new 202	java/lang/StringBuilder
    //   2381: dup
    //   2382: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2385: astore 11
    //   2387: aload 11
    //   2389: aload_2
    //   2390: getfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   2393: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2396: pop
    //   2397: aload 11
    //   2399: ldc_w 513
    //   2402: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: pop
    //   2406: aload 11
    //   2408: aload_2
    //   2409: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   2412: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2415: pop
    //   2416: ldc 45
    //   2418: ldc_w 515
    //   2421: aload 11
    //   2423: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2426: aload_2
    //   2427: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2430: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2433: iload 10
    //   2435: ireturn
    //   2436: ldc 246
    //   2438: astore 12
    //   2440: astore 11
    //   2442: goto +21 -> 2463
    //   2445: astore 11
    //   2447: ldc 246
    //   2449: astore 12
    //   2451: goto +9 -> 2460
    //   2454: astore 11
    //   2456: ldc 246
    //   2458: astore 12
    //   2460: iconst_0
    //   2461: istore 10
    //   2463: new 202	java/lang/StringBuilder
    //   2466: dup
    //   2467: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2470: astore 13
    //   2472: aload 13
    //   2474: ldc_w 517
    //   2477: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: pop
    //   2481: aload 13
    //   2483: aload 11
    //   2485: invokevirtual 518	java/lang/Exception:toString	()Ljava/lang/String;
    //   2488: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: pop
    //   2492: ldc 45
    //   2494: iconst_1
    //   2495: aload 13
    //   2497: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2500: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2503: aload_0
    //   2504: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2507: ldc_w 432
    //   2510: ldc 184
    //   2512: ldc 184
    //   2514: ldc_w 520
    //   2517: ldc_w 520
    //   2520: iconst_0
    //   2521: iconst_0
    //   2522: ldc 184
    //   2524: ldc 184
    //   2526: ldc 184
    //   2528: ldc 184
    //   2530: invokestatic 439	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2533: ldc 45
    //   2535: ldc_w 522
    //   2538: aload 11
    //   2540: invokevirtual 525	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   2543: aload_2
    //   2544: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2547: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2550: ldc 45
    //   2552: ldc_w 527
    //   2555: aload_1
    //   2556: aload_2
    //   2557: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2560: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2563: ldc 45
    //   2565: ldc_w 529
    //   2568: aload_2
    //   2569: invokevirtual 317	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   2572: aload_2
    //   2573: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2576: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2579: aload_0
    //   2580: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2583: astore_1
    //   2584: aload_2
    //   2585: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2588: astore 13
    //   2590: new 202	java/lang/StringBuilder
    //   2593: dup
    //   2594: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2597: astore 14
    //   2599: aload 14
    //   2601: ldc_w 509
    //   2604: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2607: pop
    //   2608: aload 14
    //   2610: aload 11
    //   2612: invokevirtual 532	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2615: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2618: pop
    //   2619: aload 14
    //   2621: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2624: astore 11
    //   2626: new 202	java/lang/StringBuilder
    //   2629: dup
    //   2630: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2633: astore 14
    //   2635: aload 14
    //   2637: aload 12
    //   2639: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2642: pop
    //   2643: aload 14
    //   2645: aload_2
    //   2646: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   2649: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2652: pop
    //   2653: aload 14
    //   2655: aload_2
    //   2656: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   2659: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2662: pop
    //   2663: aload 14
    //   2665: aload_2
    //   2666: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   2669: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2672: pop
    //   2673: aload_1
    //   2674: aload 13
    //   2676: ldc_w 505
    //   2679: ldc_w 511
    //   2682: aload 11
    //   2684: aload 14
    //   2686: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2689: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2692: iload 10
    //   2694: ireturn
    //   2695: ldc 45
    //   2697: ldc_w 522
    //   2700: ldc_w 534
    //   2703: aload_2
    //   2704: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2707: invokestatic 299	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2710: aload_0
    //   2711: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   2714: astore_1
    //   2715: aload_2
    //   2716: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   2719: astore 11
    //   2721: new 202	java/lang/StringBuilder
    //   2724: dup
    //   2725: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2728: astore 12
    //   2730: aload 12
    //   2732: ldc 246
    //   2734: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2737: pop
    //   2738: aload 12
    //   2740: aload_2
    //   2741: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   2744: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2747: pop
    //   2748: aload 12
    //   2750: aload_2
    //   2751: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   2754: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2757: pop
    //   2758: aload 12
    //   2760: aload_2
    //   2761: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   2764: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2767: pop
    //   2768: aload_1
    //   2769: aload 11
    //   2771: ldc_w 505
    //   2774: ldc_w 511
    //   2777: ldc_w 536
    //   2780: aload 12
    //   2782: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2785: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2788: iconst_0
    //   2789: ireturn
    //   2790: iconst_0
    //   2791: istore_3
    //   2792: goto -2280 -> 512
    //   2795: goto -2182 -> 613
    //   2798: ldc 184
    //   2800: astore 11
    //   2802: goto -1745 -> 1057
    //   2805: ldc 184
    //   2807: astore 13
    //   2809: goto -1714 -> 1095
    //   2812: astore 11
    //   2814: goto -367 -> 2447
    //   2817: goto -720 -> 2097
    //   2820: astore 11
    //   2822: ldc 246
    //   2824: astore 12
    //   2826: goto -363 -> 2463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2829	0	this	TeamWorkFileImportHandlerImpl
    //   0	2829	1	paramString	String
    //   0	2829	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   508	2284	3	i	int
    //   516	1423	4	j	int
    //   1373	595	5	k	int
    //   1404	564	6	m	int
    //   115	2176	7	n	int
    //   7	69	8	l	long
    //   125	2568	10	bool	boolean
    //   13	56	11	localAppInterface	AppInterface
    //   144	1	11	localException1	Exception
    //   170	794	11	localObject1	Object
    //   1004	1	11	localException2	Exception
    //   1052	1370	11	localObject2	Object
    //   2440	1	11	localException3	Exception
    //   2445	1	11	localException4	Exception
    //   2454	157	11	localException5	Exception
    //   2624	177	11	str1	String
    //   2812	1	11	localException6	Exception
    //   2820	1	11	localException7	Exception
    //   19	2806	12	localObject3	Object
    //   28	2780	13	localObject4	Object
    //   1097	1588	14	localObject5	Object
    //   161	2138	15	str2	String
    //   105	1024	16	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   132	141	144	java/lang/Exception
    //   276	360	144	java/lang/Exception
    //   363	390	144	java/lang/Exception
    //   393	422	144	java/lang/Exception
    //   425	454	144	java/lang/Exception
    //   457	509	144	java/lang/Exception
    //   512	571	144	java/lang/Exception
    //   575	600	144	java/lang/Exception
    //   613	623	144	java/lang/Exception
    //   628	648	144	java/lang/Exception
    //   656	661	144	java/lang/Exception
    //   680	749	144	java/lang/Exception
    //   749	770	144	java/lang/Exception
    //   770	801	144	java/lang/Exception
    //   801	826	144	java/lang/Exception
    //   826	859	144	java/lang/Exception
    //   1019	1054	144	java/lang/Exception
    //   1057	1092	144	java/lang/Exception
    //   1099	1110	144	java/lang/Exception
    //   1114	1138	144	java/lang/Exception
    //   1138	1276	144	java/lang/Exception
    //   1305	1314	144	java/lang/Exception
    //   1334	1344	144	java/lang/Exception
    //   1365	1375	144	java/lang/Exception
    //   1396	1406	144	java/lang/Exception
    //   1494	1561	144	java/lang/Exception
    //   1564	1613	144	java/lang/Exception
    //   859	934	1004	java/lang/Exception
    //   947	968	1004	java/lang/Exception
    //   968	998	1004	java/lang/Exception
    //   2197	2255	2436	java/lang/Exception
    //   2258	2378	2436	java/lang/Exception
    //   2378	2433	2436	java/lang/Exception
    //   1613	1643	2445	java/lang/Exception
    //   1650	1724	2445	java/lang/Exception
    //   1727	1806	2445	java/lang/Exception
    //   1824	1882	2445	java/lang/Exception
    //   1885	1951	2445	java/lang/Exception
    //   1970	2026	2445	java/lang/Exception
    //   2069	2094	2445	java/lang/Exception
    //   2097	2168	2445	java/lang/Exception
    //   97	127	2454	java/lang/Exception
    //   153	211	2454	java/lang/Exception
    //   1279	1300	2454	java/lang/Exception
    //   1319	1329	2454	java/lang/Exception
    //   1350	1360	2454	java/lang/Exception
    //   1381	1391	2454	java/lang/Exception
    //   1412	1479	2454	java/lang/Exception
    //   2029	2069	2812	java/lang/Exception
    //   2176	2197	2820	java/lang/Exception
  }
  
  private void parseFormResult(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ImportFormData localImportFormData = ImportFormData.a(paramJSONObject);
    if ((localImportFormData != null) && (localImportFormData.jdField_a_of_type_JavaLangString != null))
    {
      if (this.mUIHandler != null)
      {
        paramTeamWorkFileImportInfo.l = localImportFormData.b;
        paramTeamWorkFileImportInfo.q = localImportFormData.jdField_d_of_type_JavaLangString;
        paramJSONObject = new Bundle();
        paramJSONObject.putString("url", localImportFormData.jdField_a_of_type_JavaLangString);
        paramJSONObject.putParcelable("fileInfo", paramTeamWorkFileImportInfo);
        paramTeamWorkFileImportInfo = this.mUIHandler.obtainMessage(8001);
        paramTeamWorkFileImportInfo.setData(paramJSONObject);
        this.mUIHandler.sendMessage(paramTeamWorkFileImportInfo);
      }
    }
    else if (this.mUIHandler != null)
    {
      paramTeamWorkFileImportInfo.jdField_f_of_type_Int = paramJSONObject.optInt("retcode", -1);
      paramJSONObject = this.mUIHandler.obtainMessage(8002);
      paramJSONObject.obj = paramTeamWorkFileImportInfo;
      this.mUIHandler.sendMessage(paramJSONObject);
    }
  }
  
  private boolean parseUrl2DocResult(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = TenDocLogReportHelper.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    Object localObject1 = this.app;
    Object localObject3 = paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("import_type=");
    ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_d_of_type_Int);
    ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
    TenDocLogReportHelper.a((AppInterface)localObject1, (String)localObject3, "0X8009E9A", String.valueOf(l), ((StringBuilder)localObject4).toString(), "");
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      boolean bool;
      try
      {
        localObject4 = new JSONObject(paramString);
        int j = ((JSONObject)localObject4).getInt("retcode");
        bool = ((JSONObject)localObject4).has("msg");
        localObject3 = "";
        if (!bool) {
          break label1039;
        }
        localObject1 = ((JSONObject)localObject4).getString("msg");
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("addFileImportJob end:");
        ((StringBuilder)localObject5).append(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
        TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", ((StringBuilder)localObject5).toString(), String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
        if (j != 0)
        {
          paramTeamWorkFileImportInfo.jdField_f_of_type_Int = j;
          paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = ((String)localObject1);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("--- parseUrl2DocResult server ret: ");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(",error: ");
          ((StringBuilder)localObject3).append(paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
          QLog.e("TeamWorkFileImportHandlerImpl", 1, ((StringBuilder)localObject3).toString());
          TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import file job fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
        }
        else
        {
          localObject5 = ((JSONObject)localObject4).getJSONObject("data");
          localObject4 = ((JSONObject)localObject5).getString("docUrl");
          if ((this.mUIHandler != null) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (this.app != null))
          {
            if (!((JSONObject)localObject5).has("urlType")) {
              break label1046;
            }
            i = ((JSONObject)localObject5).getInt("urlType");
            if (((JSONObject)localObject5).has("docId")) {
              localObject3 = ((JSONObject)localObject5).getString("docId");
            }
            try
            {
              paramTeamWorkFileImportInfo.jdField_h_of_type_Int = i;
              paramTeamWorkFileImportInfo.m = ((String)localObject3);
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("url", (String)localObject4);
              ((Bundle)localObject3).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              localObject5 = this.mUIHandler.obtainMessage(8001);
              ((Message)localObject5).setData((Bundle)localObject3);
              this.mUIHandler.sendMessage((Message)localObject5);
              addToConvertedMap(paramTeamWorkFileImportInfo, (String)localObject4);
              bool = true;
            }
            catch (Exception localException1)
            {
              bool = true;
              break label742;
            }
          }
        }
        bool = false;
        if (j == 0) {}
        try
        {
          Object localObject2 = this.app;
          localObject3 = paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("import_type=");
          ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_d_of_type_Int);
          ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
          TenDocLogReportHelper.a((AppInterface)localObject2, (String)localObject3, "0X8009E9B", "success", ((StringBuilder)localObject4).toString(), "");
          continue;
          localObject3 = this.app;
          localObject4 = paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString;
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("err=");
          ((StringBuilder)localObject5).append(j);
          ((StringBuilder)localObject5).append((String)localObject2);
          localObject2 = ((StringBuilder)localObject5).toString();
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("import_type=");
          ((StringBuilder)localObject5).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject5).append(paramTeamWorkFileImportInfo.jdField_d_of_type_Int);
          ((StringBuilder)localObject5).append(paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
          TenDocLogReportHelper.a((AppInterface)localObject3, (String)localObject4, "0X8009E9B", "fail", (String)localObject2, ((StringBuilder)localObject5).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramTeamWorkFileImportInfo.jdField_f_of_type_Int);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
          TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "import result", ((StringBuilder)localObject2).toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
          return bool;
        }
        catch (Exception localException2) {}
        localObject3 = new StringBuilder();
      }
      catch (Exception localException3)
      {
        bool = false;
      }
      label742:
      ((StringBuilder)localObject3).append(" --- parseUrl2DocResult JSONException: ");
      ((StringBuilder)localObject3).append(localException3.toString());
      QLog.e("TeamWorkFileImportHandlerImpl", 1, ((StringBuilder)localObject3).toString());
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "parse import file json fail", localException3.getLocalizedMessage(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "parse import file json fail, param", paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "parse import file json fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      paramString = this.app;
      localObject3 = paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("err=");
      ((StringBuilder)localObject4).append(localException3.getMessage());
      String str = ((StringBuilder)localObject4).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("import_type=");
      ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject4).append(paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      TenDocLogReportHelper.a(paramString, (String)localObject3, "0X8009E9B", "fail", str, ((StringBuilder)localObject4).toString());
      return bool;
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", "parse import file json fail", "no result string", paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      paramString = this.app;
      str = paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("import_type=");
      ((StringBuilder)localObject3).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject3).append(paramTeamWorkFileImportInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject3).append(paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      TenDocLogReportHelper.a(paramString, str, "0X8009E9B", "fail", "err=EMPTY RESULT", ((StringBuilder)localObject3).toString());
      return false;
      label1039:
      str = "";
      continue;
      label1046:
      int i = 0;
    }
  }
  
  private void runWoker()
  {
    if (this.isWorderRunning) {
      return;
    }
    this.isWorderRunning = true;
    if (this.mFileImportInfoWorker != null) {
      while (!this.mFileImportInfoWorker.isEmpty())
      {
        Object localObject = (ITeamWorkFileImportJob)this.mFileImportInfoWorker.poll();
        if ((localObject instanceof TeamWorkFileImportJob))
        {
          localObject = (TeamWorkFileImportJob)localObject;
          if (localObject != null)
          {
            if (((TeamWorkFileImportJob)localObject).a != null)
            {
              ((TeamWorkFileImportJob)localObject).a.jdField_k_of_type_Int = localObject.hashCode();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("current job hashcode: ");
              localStringBuilder.append(((TeamWorkFileImportJob)localObject).a.jdField_k_of_type_Int);
              QLog.d("TeamWorkFileImportHandlerImpl", 2, localStringBuilder.toString());
            }
            ((TeamWorkFileImportJob)localObject).a(this.app);
            notifyUI(4, false, ((TeamWorkFileImportJob)localObject).a);
          }
        }
      }
    }
    this.isWorderRunning = false;
  }
  
  public void addFileImportJob(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.mFileImportInfoWorker != null) && (paramTeamWorkFileImportInfo != null))
    {
      TenDocLogReportHelper.a(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 10) {
        addTeamWorkFileImportJob(((IRelyClassCreator)QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportForH5(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 6) {
        this.mFileImportInfoWorker.add(new TeamWorkFileImportJobForDataLIne(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 13) {
        this.mFileImportInfoWorker.add(new TeamWorkFileImportJobForFile2Form(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
        addTeamWorkFileImportJob(((IRelyClassCreator)QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForGroup(paramTeamWorkFileImportInfo, this.app));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) {
        addTeamWorkFileImportJob(((IRelyClassCreator)QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForDisc(paramTeamWorkFileImportInfo, this.app));
      } else if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 6000) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 6003))
      {
        if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 12) {
          this.mFileImportInfoWorker.add(new TeamWorkFileImportJobForUrl2Doc(paramTeamWorkFileImportInfo, this.app));
        } else {
          addTeamWorkFileImportJob(((IRelyClassCreator)QRoute.api(IRelyClassCreator.class)).getTeamWorkFileImportJobForC2C(paramTeamWorkFileImportInfo, this.app));
        }
      }
      else {
        this.mFileImportInfoWorker.add(new TeamWorkFileImportJobForDataLIne(paramTeamWorkFileImportInfo, this.app));
      }
      runWoker();
      TenDocLogReportHelper.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFileImportJob start:");
      localStringBuilder.append(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
      TenDocLogReportHelper.a("TeamWorkFileImportHandlerImpl", localStringBuilder.toString(), String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    }
  }
  
  public void addToConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramString != null)
    {
      if (paramTeamWorkFileImportInfo == null) {
        return;
      }
      String str = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
      if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
      {
        paramString = TenDocLogReportHelper.b(paramString);
        this.mFileConvertedMapForDiscuss.put(str, TenDocLogReportHelper.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
        return;
      }
      this.mFileConvertedMap.put(str, TenDocLogReportHelper.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
    }
  }
  
  public void addToFileImportingMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean)
      {
        if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
        {
          this.mFileImportingInfoMapForDiscuss.put(getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
          return;
        }
        this.mFileImportingInfoMap.put(getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
        return;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c))
      {
        if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
        {
          this.mFileImportingInfoMapForDiscuss.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
          return;
        }
        this.mFileImportingInfoMap.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
      }
    }
  }
  
  public void checkFormCache(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.4(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public boolean checkIfHasBeenConverted(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = this.app;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      localObject = ((ITeamWorkHttpUtils)QRoute.api(ITeamWorkHttpUtils.class)).checkIfExist(paramString, this.app.getCurrentAccountUin());
      paramString = null;
      if (localObject != null) {
        paramString = parseCheckResult((String)localObject, paramTeamWorkFileImportInfo);
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        addToConvertedMap(paramTeamWorkFileImportInfo, paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void createGrayTips(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      QLog.d("TeamWorkFileImportHandlerImpl", 1, " --- createGrayTips ");
      boolean bool = TencentDocConvertConfigProcessor.a().e();
      if (((paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean) || (paramTeamWorkFileImportInfo.d())) && (bool))
      {
        String str;
        if (paramTeamWorkFileImportInfo.d())
        {
          str = this.app.getApp().getString(2131719545);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("\"");
          ((StringBuilder)localObject).append(CommonUtils.a(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString));
          ((StringBuilder)localObject).append("\"");
          str = String.format(str, new Object[] { ((StringBuilder)localObject).toString() });
        }
        else
        {
          str = this.app.getApp().getString(2131719544);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("\"");
          ((StringBuilder)localObject).append(CommonUtils.a(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString));
          ((StringBuilder)localObject).append("\"");
          str = String.format(str, new Object[] { ((StringBuilder)localObject).toString() });
        }
        Object localObject = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).createMsgRecordByMsgType(-2063);
        long l = MessageCache.a();
        ((MessageRecord)localObject).init(this.app.getCurrentAccountUin(), paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, str, l, -2063, paramTeamWorkFileImportInfo.jdField_a_of_type_Int, l);
        ((MessageRecord)localObject).isread = true;
        ((MessageRecord)localObject).saveExtInfoToExtStr("key_team_work_ext_info_new_url", paramString);
        ((MessageRecord)localObject).saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(paramTeamWorkFileImportInfo.jdField_f_of_type_Boolean));
        paramTeamWorkFileImportInfo = (IGetExternalInterface)QRoute.api(IGetExternalInterface.class);
        paramString = this.app;
        paramTeamWorkFileImportInfo.addMessage(paramString, (MessageRecord)localObject, paramString.getCurrentAccountUin());
      }
    }
  }
  
  public void fileImportFromLocalFile(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.1(this, paramTeamWorkFileImportInfo));
  }
  
  public void fileImportFromLocalFileForDataLine(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.2(this, paramTeamWorkFileImportInfo));
  }
  
  public void fileImportFromLocalFileForH5(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.10(this, paramTeamWorkFileImportInfo));
  }
  
  public void fileImportFromUrl(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.3(this, paramJSONObject, paramTeamWorkFileImportInfo, paramInt));
  }
  
  public void fileImportFromUrl2Doc(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.7(this, paramTeamWorkFileImportInfo));
  }
  
  public void fileImportFromUrlForH5(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.app == null) {
      return;
    }
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.11(this, paramTeamWorkFileImportInfo, paramJSONObject, paramInt));
  }
  
  public void getTencentDocReddot(String paramString)
  {
    if (this.app != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.8(this, paramString));
    }
  }
  
  public Handler getUIHandler()
  {
    return this.mUIHandler;
  }
  
  public String getUrlFromConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    Object localObject;
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0))
    {
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
        localObject = paramTeamWorkFileImportInfo.c;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString)) {
        localObject = paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
      } else {
        localObject = "";
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramTeamWorkFileImportInfo.jdField_b_of_type_Long);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo)) {
      paramTeamWorkFileImportInfo = this.mFileConvertedMapForDiscuss;
    } else {
      paramTeamWorkFileImportInfo = this.mFileConvertedMap;
    }
    return (String)paramTeamWorkFileImportInfo.get(localObject);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
    if (i != 8001)
    {
      if (i != 8002) {
        return true;
      }
      paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
      removeFileImporting(paramMessage);
      notifyUI(2, true, paramMessage);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MSG_FILE_IMPORT_ERROR:");
        ((StringBuilder)localObject).append(paramMessage.jdField_b_of_type_JavaLangString);
        QLog.e("TeamWorkFileImportHandlerImpl", 1, ((StringBuilder)localObject).toString());
        return true;
      }
    }
    else
    {
      paramMessage = paramMessage.getData();
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)paramMessage.getParcelable("fileInfo");
      localObject = paramMessage.getString("url");
      removeFileImporting(localTeamWorkFileImportInfo);
      if (QLog.isDevelopLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_FILE_IMPORT_SUCCESS:");
        paramMessage.append((String)localObject);
        QLog.e("TeamWorkFileImportHandlerImpl", 1, paramMessage.toString());
      }
      paramMessage = (Message)localObject;
      if (localTeamWorkFileImportInfo != null)
      {
        localObject = TenDocLogReportHelper.a((String)localObject, localTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
        paramMessage = (Message)localObject;
        if (TeamWorkConvertUtils.a(localTeamWorkFileImportInfo)) {
          paramMessage = TenDocLogReportHelper.b((String)localObject);
        }
      }
      notifyUI(1, true, new Object[] { paramMessage, localTeamWorkFileImportInfo });
      ReportController.b(this.app, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("convert finish time [");
        paramMessage.append(System.currentTimeMillis() / 1000L);
        paramMessage.append("]");
        QLog.i("teamConvert", 2, paramMessage.toString());
      }
      if (this.isNeedToast) {
        QQToast.a(MobileQQ.getContext(), 2, MobileQQ.getContext().getString(2131719530), 0).b(MobileQQ.getContext().getResources().getDimensionPixelSize(2131299168));
      }
    }
    return true;
  }
  
  public void importFormWithLocalFile(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.6(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void importFormWithUrl(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    doRequestAfterGetTicket(new TeamWorkFileImportHandlerImpl.5(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public boolean isFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.mFileImportingInfoMapForDiscuss.containsKey(paramTeamWorkFileImportInfo.c))) {
        return true;
      }
      paramTeamWorkFileImportInfo = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
      return this.mFileImportingInfoMapForDiscuss.containsKey(paramTeamWorkFileImportInfo);
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.mFileImportingInfoMap.containsKey(paramTeamWorkFileImportInfo.c))) {
      return true;
    }
    paramTeamWorkFileImportInfo = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
    return this.mFileImportingInfoMap.containsKey(paramTeamWorkFileImportInfo);
  }
  
  public void notifyUIError(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = this.mUIHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(8002);
      ((Message)localObject).obj = paramTeamWorkFileImportInfo;
      this.mUIHandler.sendMessage((Message)localObject);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TeamWorkFileImportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  String parseCheckResult(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramString);
        int i = ((JSONObject)localObject1).getInt("ret");
        bool = ((JSONObject)localObject1).has("msg");
        if (!bool) {
          break label603;
        }
        paramString = ((JSONObject)localObject1).getString("msg");
        if (i == 0)
        {
          paramString = ((JSONObject)localObject1).getString("url");
          try
          {
            if ((this.mUIHandler != null) && (!TextUtils.isEmpty(paramString)) && (this.app != null))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("url", paramString);
              ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              localObject2 = this.mUIHandler.obtainMessage(8001);
              ((Message)localObject2).setData((Bundle)localObject1);
              this.mUIHandler.sendMessage((Message)localObject2);
              bool = TencentDocConvertConfigProcessor.a().e();
              if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean) && (bool))
              {
                i = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).getFileType(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
                if (i == 3) {
                  HardCodeUtil.a(2131714558);
                } else if (i == 6) {
                  HardCodeUtil.a(2131714589);
                }
                localObject1 = this.app.getApp().getString(2131719529);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("\"");
                ((StringBuilder)localObject2).append(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
                ((StringBuilder)localObject2).append("\"");
                localObject1 = String.format((String)localObject1, new Object[] { ((StringBuilder)localObject2).toString() });
                localObject2 = ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).createMsgRecordByMsgType(-2063);
                long l = MessageCache.a();
                ((MessageRecord)localObject2).init(this.app.getCurrentAccountUin(), paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, (String)localObject1, l, -2063, paramTeamWorkFileImportInfo.jdField_a_of_type_Int, l);
                ((MessageRecord)localObject2).isread = true;
                ((MessageRecord)localObject2).saveExtInfoToExtStr("key_team_work_ext_info_new_url", ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTencentDocSourceAdtagStrUrl(paramString, "s_qq_aio_grey"));
                ((IGetExternalInterface)QRoute.api(IGetExternalInterface.class)).addMessage(this.app, (MessageRecord)localObject2, this.app.getCurrentAccountUin());
              }
            }
            return paramString;
          }
          catch (JSONException paramTeamWorkFileImportInfo) {}
        }
        else
        {
          paramTeamWorkFileImportInfo = this.app;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("");
          ReportController.b(paramTeamWorkFileImportInfo, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
          paramTeamWorkFileImportInfo = new StringBuilder();
          paramTeamWorkFileImportInfo.append("--- parseCheckResult server ret: ");
          paramTeamWorkFileImportInfo.append(i);
          paramTeamWorkFileImportInfo.append(",error: ");
          paramTeamWorkFileImportInfo.append(paramString);
          QLog.e("TeamWorkFileImportHandlerImpl", 1, paramTeamWorkFileImportInfo.toString());
          return null;
        }
      }
      catch (JSONException paramTeamWorkFileImportInfo)
      {
        paramString = (String)localObject2;
        ReportController.b(this.app, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" --- parseCheckResult JSONException: ");
        ((StringBuilder)localObject1).append(paramTeamWorkFileImportInfo.toString());
        QLog.e("TeamWorkFileImportHandlerImpl", 1, ((StringBuilder)localObject1).toString());
        localObject1 = paramString;
      }
      return localObject1;
      label603:
      paramString = "";
    }
  }
  
  /* Error */
  public boolean parseFileImportResultForH5(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 244	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;)J
    //   7: lstore 8
    //   9: aload_0
    //   10: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   13: astore 11
    //   15: aload_2
    //   16: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   19: astore 12
    //   21: new 202	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   28: astore 13
    //   30: aload 13
    //   32: ldc 246
    //   34: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 13
    //   40: aload_2
    //   41: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   44: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 13
    //   50: aload_2
    //   51: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   54: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 13
    //   60: aload_2
    //   61: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   64: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 11
    //   70: aload 12
    //   72: ldc_w 256
    //   75: lload 8
    //   77: invokestatic 260	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: aload 13
    //   82: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: ldc 184
    //   87: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_1
    //   91: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +1858 -> 1952
    //   97: new 265	org/json/JSONObject
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 268	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   105: astore 15
    //   107: aload 15
    //   109: ldc_w 270
    //   112: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   115: istore 7
    //   117: aload 15
    //   119: ldc_w 276
    //   122: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   125: istore 10
    //   127: iload 10
    //   129: ifeq +28 -> 157
    //   132: aload 15
    //   134: ldc_w 276
    //   137: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: pop
    //   141: goto +16 -> 157
    //   144: astore_1
    //   145: ldc_w 509
    //   148: astore 12
    //   150: ldc 246
    //   152: astore 11
    //   154: goto +1642 -> 1796
    //   157: aload 15
    //   159: ldc_w 286
    //   162: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 11
    //   167: aload 11
    //   169: astore_1
    //   170: iload 7
    //   172: ifeq +1234 -> 1406
    //   175: iload 7
    //   177: bipush 115
    //   179: if_icmpeq +933 -> 1112
    //   182: iload 7
    //   184: bipush 116
    //   186: if_icmpeq +73 -> 259
    //   189: aload_2
    //   190: iload 7
    //   192: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   195: aload_2
    //   196: aload_1
    //   197: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   200: new 202	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   207: astore 11
    //   209: aload 11
    //   211: ldc_w 873
    //   214: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 11
    //   220: iload 7
    //   222: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 11
    //   228: ldc_w 308
    //   231: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 11
    //   237: aload_2
    //   238: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   241: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 45
    //   247: iconst_1
    //   248: aload 11
    //   250: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: goto +1776 -> 2032
    //   259: new 265	org/json/JSONObject
    //   262: dup
    //   263: aload_1
    //   264: invokespecial 268	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: aload_1
    //   269: ldc_w 467
    //   272: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   275: ifeq +1763 -> 2038
    //   278: aload_1
    //   279: ldc_w 467
    //   282: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   285: istore_3
    //   286: goto +3 -> 289
    //   289: aload_1
    //   290: ldc_w 469
    //   293: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   296: ifeq +1747 -> 2043
    //   299: aload_1
    //   300: ldc_w 469
    //   303: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   306: istore 4
    //   308: goto +3 -> 311
    //   311: aload_1
    //   312: ldc_w 471
    //   315: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   318: ifeq +1731 -> 2049
    //   321: aload_1
    //   322: ldc_w 471
    //   325: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   328: istore 5
    //   330: goto +3 -> 333
    //   333: aload_1
    //   334: ldc_w 473
    //   337: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   340: ifeq +1715 -> 2055
    //   343: aload_1
    //   344: ldc_w 473
    //   347: invokevirtual 274	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   350: istore 6
    //   352: goto +3 -> 355
    //   355: ldc_w 356
    //   358: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   361: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   364: iload 5
    //   366: invokeinterface 477 2 0
    //   371: astore_1
    //   372: ldc_w 356
    //   375: invokestatic 362	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   378: checkcast 356	com/tencent/mobileqq/teamwork/api/ITeamWorkUtils
    //   381: iload 6
    //   383: invokeinterface 477 2 0
    //   388: astore 12
    //   390: new 202	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   397: astore 13
    //   399: aload_0
    //   400: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   403: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   406: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   409: astore 14
    //   411: aload 13
    //   413: aload 14
    //   415: ldc_w 488
    //   418: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   421: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: iload_3
    //   426: ifeq +323 -> 749
    //   429: iload 5
    //   431: ifeq +318 -> 749
    //   434: iload_3
    //   435: iload 4
    //   437: if_icmpne +73 -> 510
    //   440: aload 13
    //   442: aload_0
    //   443: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   446: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   449: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   452: ldc_w 493
    //   455: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   458: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload 13
    //   464: ldc_w 495
    //   467: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 13
    //   473: aload_0
    //   474: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   477: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   480: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   483: ldc_w 496
    //   486: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   489: iconst_1
    //   490: anewarray 326	java/lang/Object
    //   493: dup
    //   494: iconst_0
    //   495: iload_3
    //   496: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   503: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: goto +78 -> 585
    //   510: aload 13
    //   512: aload_0
    //   513: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   516: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   519: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   522: ldc_w 493
    //   525: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   528: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 13
    //   534: ldc_w 495
    //   537: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 13
    //   543: aload_0
    //   544: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   547: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   550: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   553: ldc_w 497
    //   556: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   559: iconst_2
    //   560: anewarray 326	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: iload_3
    //   566: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: iload 4
    //   574: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   581: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: iload 5
    //   587: iload 6
    //   589: if_icmpne +79 -> 668
    //   592: aload 13
    //   594: ldc_w 499
    //   597: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 13
    //   603: aload_0
    //   604: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   607: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   610: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   613: ldc_w 493
    //   616: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   619: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 13
    //   625: ldc_w 501
    //   628: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 13
    //   634: aload_0
    //   635: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   638: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   641: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   644: ldc_w 502
    //   647: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   650: iconst_1
    //   651: anewarray 326	java/lang/Object
    //   654: dup
    //   655: iconst_0
    //   656: aload_1
    //   657: aastore
    //   658: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   661: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: goto +363 -> 1028
    //   668: aload 13
    //   670: ldc_w 499
    //   673: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 13
    //   679: aload_0
    //   680: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   683: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   686: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   689: ldc_w 493
    //   692: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   695: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: aload 13
    //   701: ldc_w 501
    //   704: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 13
    //   710: aload_0
    //   711: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   714: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   717: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   720: ldc_w 503
    //   723: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   726: iconst_2
    //   727: anewarray 326	java/lang/Object
    //   730: dup
    //   731: iconst_0
    //   732: aload_1
    //   733: aastore
    //   734: dup
    //   735: iconst_1
    //   736: aload 12
    //   738: aastore
    //   739: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   742: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: goto +282 -> 1028
    //   749: iload_3
    //   750: ifeq +144 -> 894
    //   753: iload 5
    //   755: ifne +139 -> 894
    //   758: iload_3
    //   759: iload 4
    //   761: if_icmpne +64 -> 825
    //   764: aload 13
    //   766: aload_0
    //   767: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   770: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   773: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   776: ldc_w 493
    //   779: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   782: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: pop
    //   786: aload 13
    //   788: aload_0
    //   789: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   792: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   795: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   798: ldc_w 496
    //   801: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   804: iconst_1
    //   805: anewarray 326	java/lang/Object
    //   808: dup
    //   809: iconst_0
    //   810: iload_3
    //   811: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   814: aastore
    //   815: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   818: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: goto +206 -> 1028
    //   825: aload 13
    //   827: aload_0
    //   828: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   831: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   834: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   837: ldc_w 493
    //   840: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   843: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload 13
    //   849: aload_0
    //   850: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   853: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   856: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   859: ldc_w 497
    //   862: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   865: iconst_2
    //   866: anewarray 326	java/lang/Object
    //   869: dup
    //   870: iconst_0
    //   871: iload_3
    //   872: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   875: aastore
    //   876: dup
    //   877: iconst_1
    //   878: iload 4
    //   880: invokestatic 331	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   883: aastore
    //   884: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   887: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: goto +137 -> 1028
    //   894: iload_3
    //   895: ifne +133 -> 1028
    //   898: iload 5
    //   900: ifeq +128 -> 1028
    //   903: iload 5
    //   905: iload 6
    //   907: if_icmpne +61 -> 968
    //   910: aload 13
    //   912: aload_0
    //   913: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   916: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   919: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   922: ldc_w 493
    //   925: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   928: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload 13
    //   934: aload_0
    //   935: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   938: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   941: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   944: ldc_w 502
    //   947: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   950: iconst_1
    //   951: anewarray 326	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload_1
    //   957: aastore
    //   958: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   961: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: pop
    //   965: goto +63 -> 1028
    //   968: aload 13
    //   970: aload_0
    //   971: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   974: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   977: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   980: ldc_w 493
    //   983: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   986: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 13
    //   992: aload_0
    //   993: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   996: invokevirtual 481	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   999: invokevirtual 487	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1002: ldc_w 503
    //   1005: invokevirtual 492	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1008: iconst_2
    //   1009: anewarray 326	java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload_1
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: aload 12
    //   1020: aastore
    //   1021: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1024: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload_2
    //   1029: iload 7
    //   1031: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   1034: aload_2
    //   1035: aload 13
    //   1037: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1043: new 202	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1050: astore_1
    //   1051: aload_1
    //   1052: ldc_w 873
    //   1055: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload_1
    //   1060: iload 7
    //   1062: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1065: pop
    //   1066: aload_1
    //   1067: ldc_w 308
    //   1070: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload_1
    //   1075: aload_2
    //   1076: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1079: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: ldc 45
    //   1085: iconst_1
    //   1086: aload_1
    //   1087: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: aload 11
    //   1095: astore_1
    //   1096: goto +936 -> 2032
    //   1099: astore_1
    //   1100: ldc 246
    //   1102: astore 11
    //   1104: ldc_w 509
    //   1107: astore 12
    //   1109: goto +687 -> 1796
    //   1112: aload 15
    //   1114: ldc_w 441
    //   1117: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1120: istore 10
    //   1122: ldc 184
    //   1124: astore 14
    //   1126: iload 10
    //   1128: ifeq +30 -> 1158
    //   1131: aload 15
    //   1133: ldc_w 441
    //   1136: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1139: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1142: ifne +16 -> 1158
    //   1145: aload 15
    //   1147: ldc_w 441
    //   1150: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1153: astore 11
    //   1155: goto +7 -> 1162
    //   1158: ldc 184
    //   1160: astore 11
    //   1162: aload 15
    //   1164: ldc_w 443
    //   1167: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1170: istore 10
    //   1172: iload 10
    //   1174: ifeq +30 -> 1204
    //   1177: aload 15
    //   1179: ldc_w 443
    //   1182: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1185: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1188: ifne +16 -> 1204
    //   1191: aload 15
    //   1193: ldc_w 443
    //   1196: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1199: astore 12
    //   1201: goto +7 -> 1208
    //   1204: ldc 184
    //   1206: astore 12
    //   1208: aload 15
    //   1210: ldc_w 445
    //   1213: invokevirtual 280	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1216: istore 10
    //   1218: aload 14
    //   1220: astore 13
    //   1222: iload 10
    //   1224: ifeq +31 -> 1255
    //   1227: aload 14
    //   1229: astore 13
    //   1231: aload 15
    //   1233: ldc_w 445
    //   1236: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1239: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1242: ifne +13 -> 1255
    //   1245: aload 15
    //   1247: ldc_w 445
    //   1250: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1253: astore 13
    //   1255: aload_2
    //   1256: getfield 447	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1259: astore 15
    //   1261: getstatic 450	com/tencent/mobileqq/teamwork/TeamWorkConstants:p	Ljava/lang/String;
    //   1264: astore 14
    //   1266: aload 15
    //   1268: ldc_w 452
    //   1271: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1274: astore 15
    //   1276: aload_2
    //   1277: aload 14
    //   1279: iconst_5
    //   1280: anewarray 326	java/lang/Object
    //   1283: dup
    //   1284: iconst_0
    //   1285: aload 15
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_1
    //   1290: aload 12
    //   1292: ldc_w 452
    //   1295: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1298: aastore
    //   1299: dup
    //   1300: iconst_2
    //   1301: aload 13
    //   1303: ldc_w 452
    //   1306: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1309: aastore
    //   1310: dup
    //   1311: iconst_3
    //   1312: aload 11
    //   1314: ldc_w 452
    //   1317: invokestatic 457	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1320: aastore
    //   1321: dup
    //   1322: iconst_4
    //   1323: ldc_w 875
    //   1326: aastore
    //   1327: invokestatic 463	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1330: putfield 465	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:i	Ljava/lang/String;
    //   1333: aload_2
    //   1334: iload 7
    //   1336: putfield 301	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   1339: aload_2
    //   1340: aload_1
    //   1341: putfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1344: new 202	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1351: astore 11
    //   1353: aload 11
    //   1355: ldc_w 873
    //   1358: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: pop
    //   1362: aload 11
    //   1364: iload 7
    //   1366: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1369: pop
    //   1370: aload 11
    //   1372: ldc_w 308
    //   1375: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 11
    //   1381: aload_2
    //   1382: getfield 304	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   1385: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: ldc 45
    //   1391: iconst_1
    //   1392: aload 11
    //   1394: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1400: aload_1
    //   1401: astore 11
    //   1403: goto +134 -> 1537
    //   1406: aload 15
    //   1408: ldc_w 346
    //   1411: invokevirtual 284	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1414: astore 12
    //   1416: aload_1
    //   1417: astore 11
    //   1419: aload_0
    //   1420: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   1423: ifnull +114 -> 1537
    //   1426: aload_1
    //   1427: astore 11
    //   1429: aload 12
    //   1431: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1434: ifne +103 -> 1537
    //   1437: aload_0
    //   1438: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1441: astore 13
    //   1443: aload_1
    //   1444: astore 11
    //   1446: aload 13
    //   1448: ifnull +89 -> 1537
    //   1451: new 394	android/os/Bundle
    //   1454: dup
    //   1455: invokespecial 395	android/os/Bundle:<init>	()V
    //   1458: astore 11
    //   1460: aload 11
    //   1462: ldc_w 346
    //   1465: aload 12
    //   1467: invokevirtual 399	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: aload 11
    //   1472: ldc_w 401
    //   1475: aload_2
    //   1476: invokevirtual 405	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1479: aload_0
    //   1480: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   1483: sipush 8001
    //   1486: invokevirtual 409	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   1489: astore 13
    //   1491: aload 13
    //   1493: aload 11
    //   1495: invokevirtual 415	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1498: aload_0
    //   1499: getfield 81	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:mUIHandler	Landroid/os/Handler;
    //   1502: aload 13
    //   1504: invokevirtual 419	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   1507: pop
    //   1508: aload_0
    //   1509: aload_2
    //   1510: aload 12
    //   1512: invokevirtual 423	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:addToConvertedMap	(Lcom/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   1515: iconst_1
    //   1516: istore 10
    //   1518: goto +25 -> 1543
    //   1521: astore_1
    //   1522: ldc_w 509
    //   1525: astore 12
    //   1527: ldc 246
    //   1529: astore 11
    //   1531: iconst_1
    //   1532: istore 10
    //   1534: goto +265 -> 1799
    //   1537: iconst_0
    //   1538: istore 10
    //   1540: aload 11
    //   1542: astore_1
    //   1543: iload 7
    //   1545: ifne +83 -> 1628
    //   1548: aload_0
    //   1549: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1552: astore_1
    //   1553: aload_2
    //   1554: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1557: astore 11
    //   1559: new 202	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1566: astore 12
    //   1568: aload 12
    //   1570: ldc 246
    //   1572: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: pop
    //   1576: aload 12
    //   1578: aload_2
    //   1579: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   1582: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 12
    //   1588: aload_2
    //   1589: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   1592: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: pop
    //   1596: aload 12
    //   1598: aload_2
    //   1599: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   1602: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload_1
    //   1607: aload 11
    //   1609: ldc_w 505
    //   1612: ldc_w 507
    //   1615: aload 12
    //   1617: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1620: ldc 184
    //   1622: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1625: iload 10
    //   1627: ireturn
    //   1628: ldc 246
    //   1630: astore 11
    //   1632: aload_0
    //   1633: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1636: astore 13
    //   1638: aload_2
    //   1639: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1642: astore 14
    //   1644: new 202	java/lang/StringBuilder
    //   1647: dup
    //   1648: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1651: astore 15
    //   1653: ldc_w 509
    //   1656: astore 12
    //   1658: aload 15
    //   1660: aload 12
    //   1662: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: pop
    //   1666: aload 15
    //   1668: iload 7
    //   1670: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1673: pop
    //   1674: aload 15
    //   1676: aload_1
    //   1677: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aload 15
    //   1683: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: astore_1
    //   1687: new 202	java/lang/StringBuilder
    //   1690: dup
    //   1691: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1694: astore 15
    //   1696: aload 15
    //   1698: aload 11
    //   1700: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: pop
    //   1704: aload 15
    //   1706: aload_2
    //   1707: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   1710: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload 15
    //   1716: aload_2
    //   1717: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   1720: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1723: pop
    //   1724: aload 15
    //   1726: aload_2
    //   1727: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   1730: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1733: pop
    //   1734: aload 13
    //   1736: aload 14
    //   1738: ldc_w 505
    //   1741: ldc_w 511
    //   1744: aload_1
    //   1745: aload 15
    //   1747: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1750: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1753: iload 10
    //   1755: ireturn
    //   1756: astore_1
    //   1757: goto +42 -> 1799
    //   1760: astore_1
    //   1761: ldc 246
    //   1763: astore 11
    //   1765: ldc_w 509
    //   1768: astore 12
    //   1770: goto +29 -> 1799
    //   1773: astore_1
    //   1774: ldc_w 509
    //   1777: astore 12
    //   1779: ldc 246
    //   1781: astore 11
    //   1783: goto +13 -> 1796
    //   1786: astore_1
    //   1787: ldc_w 509
    //   1790: astore 12
    //   1792: ldc 246
    //   1794: astore 11
    //   1796: iconst_0
    //   1797: istore 10
    //   1799: new 202	java/lang/StringBuilder
    //   1802: dup
    //   1803: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1806: astore 13
    //   1808: aload 13
    //   1810: ldc_w 877
    //   1813: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: pop
    //   1817: aload 13
    //   1819: aload_1
    //   1820: invokevirtual 518	java/lang/Exception:toString	()Ljava/lang/String;
    //   1823: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: pop
    //   1827: ldc 45
    //   1829: iconst_1
    //   1830: aload 13
    //   1832: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 314	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1838: aload_0
    //   1839: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1842: astore 13
    //   1844: aload_2
    //   1845: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1848: astore 14
    //   1850: new 202	java/lang/StringBuilder
    //   1853: dup
    //   1854: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1857: astore 15
    //   1859: aload 15
    //   1861: aload 12
    //   1863: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 15
    //   1869: aload_1
    //   1870: invokevirtual 532	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1873: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: pop
    //   1877: aload 15
    //   1879: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: astore_1
    //   1883: new 202	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1890: astore 12
    //   1892: aload 12
    //   1894: aload 11
    //   1896: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: pop
    //   1900: aload 12
    //   1902: aload_2
    //   1903: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   1906: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1909: pop
    //   1910: aload 12
    //   1912: aload_2
    //   1913: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   1916: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1919: pop
    //   1920: aload 12
    //   1922: aload_2
    //   1923: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   1926: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1929: pop
    //   1930: aload 13
    //   1932: aload 14
    //   1934: ldc_w 505
    //   1937: ldc_w 511
    //   1940: aload_1
    //   1941: aload 12
    //   1943: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1946: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1949: iload 10
    //   1951: ireturn
    //   1952: aload_0
    //   1953: getfield 111	com/tencent/mobileqq/teamwork/api/impl/TeamWorkFileImportHandlerImpl:app	Lcom/tencent/common/app/AppInterface;
    //   1956: astore_1
    //   1957: aload_2
    //   1958: getfield 239	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   1961: astore 11
    //   1963: new 202	java/lang/StringBuilder
    //   1966: dup
    //   1967: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1970: astore 12
    //   1972: aload 12
    //   1974: ldc 246
    //   1976: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: pop
    //   1980: aload 12
    //   1982: aload_2
    //   1983: getfield 215	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   1986: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1989: pop
    //   1990: aload 12
    //   1992: aload_2
    //   1993: getfield 251	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   1996: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1999: pop
    //   2000: aload 12
    //   2002: aload_2
    //   2003: getfield 254	com/tencent/mobileqq/teamwork/bean/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   2006: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2009: pop
    //   2010: aload_1
    //   2011: aload 11
    //   2013: ldc_w 505
    //   2016: ldc_w 511
    //   2019: ldc_w 536
    //   2022: aload 12
    //   2024: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2027: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2030: iconst_0
    //   2031: ireturn
    //   2032: aload_1
    //   2033: astore 11
    //   2035: goto -498 -> 1537
    //   2038: iconst_0
    //   2039: istore_3
    //   2040: goto -1751 -> 289
    //   2043: iconst_0
    //   2044: istore 4
    //   2046: goto -1735 -> 311
    //   2049: iconst_0
    //   2050: istore 5
    //   2052: goto -1719 -> 333
    //   2055: iconst_0
    //   2056: istore 6
    //   2058: goto -1703 -> 355
    //   2061: astore_1
    //   2062: goto -288 -> 1774
    //   2065: astore_1
    //   2066: goto -305 -> 1761
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2069	0	this	TeamWorkFileImportHandlerImpl
    //   0	2069	1	paramString	String
    //   0	2069	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   285	1755	3	i	int
    //   306	1739	4	j	int
    //   328	1723	5	k	int
    //   350	1707	6	m	int
    //   115	1554	7	n	int
    //   7	69	8	l	long
    //   125	1825	10	bool	boolean
    //   13	2021	11	localObject1	Object
    //   19	2004	12	localObject2	Object
    //   28	1903	13	localObject3	Object
    //   409	1524	14	localObject4	Object
    //   105	1773	15	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   132	141	144	java/lang/Exception
    //   189	256	144	java/lang/Exception
    //   259	286	144	java/lang/Exception
    //   289	308	144	java/lang/Exception
    //   311	330	144	java/lang/Exception
    //   333	352	144	java/lang/Exception
    //   355	399	144	java/lang/Exception
    //   399	411	1099	java/lang/Exception
    //   1451	1515	1521	java/lang/Exception
    //   1658	1753	1756	java/lang/Exception
    //   1568	1625	1760	java/lang/Exception
    //   1632	1653	1760	java/lang/Exception
    //   411	425	1773	java/lang/Exception
    //   440	507	1773	java/lang/Exception
    //   510	585	1773	java/lang/Exception
    //   592	665	1773	java/lang/Exception
    //   668	746	1773	java/lang/Exception
    //   764	822	1773	java/lang/Exception
    //   825	891	1773	java/lang/Exception
    //   910	965	1773	java/lang/Exception
    //   968	1028	1773	java/lang/Exception
    //   1028	1093	1773	java/lang/Exception
    //   1131	1155	1773	java/lang/Exception
    //   1177	1201	1773	java/lang/Exception
    //   1231	1255	1773	java/lang/Exception
    //   1276	1339	1773	java/lang/Exception
    //   1339	1400	1773	java/lang/Exception
    //   1406	1416	1773	java/lang/Exception
    //   1419	1426	1773	java/lang/Exception
    //   1429	1443	1773	java/lang/Exception
    //   97	127	1786	java/lang/Exception
    //   157	167	1786	java/lang/Exception
    //   1112	1122	2061	java/lang/Exception
    //   1162	1172	2061	java/lang/Exception
    //   1208	1218	2061	java/lang/Exception
    //   1255	1276	2061	java/lang/Exception
    //   1548	1568	2065	java/lang/Exception
  }
  
  public void removeFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str;
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.mFileImportingInfoMapForDiscuss.containsKey(paramTeamWorkFileImportInfo.c))) {
        str = paramTeamWorkFileImportInfo.c;
      } else {
        str = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
      }
      if (!TextUtils.isEmpty(str)) {
        this.mFileImportingInfoMapForDiscuss.remove(str);
      }
    }
    else
    {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.mFileImportingInfoMap.containsKey(paramTeamWorkFileImportInfo.c))) {
        str = paramTeamWorkFileImportInfo.c;
      } else {
        str = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
      }
      if (!TextUtils.isEmpty(str)) {
        this.mFileImportingInfoMap.remove(str);
      }
    }
    paramTeamWorkFileImportInfo.jdField_k_of_type_Int = 0;
  }
  
  public void removeFromConvertedMap(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      this.mFileConvertedMapForDiscuss.remove(str);
      return;
    }
    this.mFileConvertedMap.remove(str);
  }
  
  public void setIsNeedToast(boolean paramBoolean)
  {
    this.isNeedToast = paramBoolean;
  }
  
  public boolean updateFileImporting(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.mFileImportingInfoMap.containsKey(paramTeamWorkFileImportInfo.c))) {
      return true;
    }
    paramTeamWorkFileImportInfo = getTeamWorkFileImportInfoKey(paramTeamWorkFileImportInfo);
    paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.mFileImportingInfoMap.get(paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo != null)
    {
      paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = paramBoolean;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TeamWorkFileImportHandlerImpl
 * JD-Core Version:    0.7.0.1
 */