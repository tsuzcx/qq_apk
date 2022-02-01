package com.tencent.mobileqq.teamwork;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.ImportFormData;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.TicketManager;
import org.json.JSONObject;

public class TeamWorkFileImportHandler
  extends BusinessHandler
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue<TeamWorkFileImportJob> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "docs.qq.com" };
  private ConcurrentHashMap<String, String> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private ConcurrentHashMap<String, TeamWorkFileImportInfo> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> d = new ConcurrentHashMap();
  
  public TeamWorkFileImportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        TeamWorkFileImportJob localTeamWorkFileImportJob = (TeamWorkFileImportJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (localTeamWorkFileImportJob != null)
        {
          if (localTeamWorkFileImportJob.a != null)
          {
            localTeamWorkFileImportJob.a.jdField_k_of_type_Int = localTeamWorkFileImportJob.hashCode();
            QLog.d("TeamWorkFileImportHandler", 2, "current job hashcode: " + localTeamWorkFileImportJob.a.jdField_k_of_type_Int);
          }
          localTeamWorkFileImportJob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          notifyUI(4, false, localTeamWorkFileImportJob.a);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getPskey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfJavaLangString, new TeamWorkFileImportHandler.9(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  private String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.c())
    {
      String str1 = TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo);
      String str2 = paramTeamWorkFileImportInfo.c;
      paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.n;
      if (!TextUtils.isEmpty(str1)) {
        return str1;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo)) {
        return paramTeamWorkFileImportInfo;
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (str2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        }
        return "";
      }
    }
    else
    {
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
        return paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
      }
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        return paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long + "_" + paramTeamWorkFileImportInfo.jdField_b_of_type_Long;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
        return paramTeamWorkFileImportInfo.c;
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString)) {
        return paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  /* Error */
  private boolean b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 7
    //   6: aload_2
    //   7: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 213	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;)J
    //   13: lstore 9
    //   15: aload_0
    //   16: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: aload_2
    //   20: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   23: ldc 215
    //   25: lload 9
    //   27: invokestatic 219	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   30: new 99	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   37: ldc 221
    //   39: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: getfield 185	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   46: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: getfield 223	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   53: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: aload_2
    //   57: getfield 226	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   60: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: ldc 183
    //   68: invokestatic 229	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_1
    //   72: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +783 -> 858
    //   78: iload 8
    //   80: istore 6
    //   82: new 231	org/json/JSONObject
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 234	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: astore 12
    //   92: iload 8
    //   94: istore 6
    //   96: aload 12
    //   98: ldc 236
    //   100: invokevirtual 240	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   103: istore 4
    //   105: iload 8
    //   107: istore 6
    //   109: aload 12
    //   111: ldc 242
    //   113: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   116: ifeq +823 -> 939
    //   119: iload 8
    //   121: istore 6
    //   123: aload 12
    //   125: ldc 242
    //   127: invokevirtual 250	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 11
    //   132: iload 8
    //   134: istore 6
    //   136: ldc 97
    //   138: new 99	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   145: ldc 252
    //   147: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_2
    //   151: getfield 254	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 260	java/lang/System:currentTimeMillis	()J
    //   163: invokestatic 219	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   166: aload_2
    //   167: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   170: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 4
    //   175: tableswitch	default:+771 -> 946, 0:+218->393
    //   193: iconst_5
    //   194: istore 6
    //   196: aload_2
    //   197: iload 4
    //   199: putfield 265	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   202: iload 8
    //   204: istore 6
    //   206: aload_2
    //   207: aload 11
    //   209: putfield 268	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   212: iload 8
    //   214: istore 6
    //   216: ldc 97
    //   218: iconst_1
    //   219: new 99	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 270
    //   229: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 4
    //   234: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: ldc_w 272
    //   240: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload_2
    //   244: getfield 268	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   247: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iload 8
    //   258: istore 6
    //   260: ldc 97
    //   262: ldc_w 277
    //   265: aload_2
    //   266: invokevirtual 278	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   269: aload_2
    //   270: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   273: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   276: iload 7
    //   278: istore 5
    //   280: iload 4
    //   282: ifne +332 -> 614
    //   285: iload 5
    //   287: istore 6
    //   289: aload_0
    //   290: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   293: aload_2
    //   294: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   297: ldc_w 280
    //   300: ldc_w 282
    //   303: new 99	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   310: ldc 221
    //   312: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_2
    //   316: getfield 185	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   319: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: aload_2
    //   323: getfield 223	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   326: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: getfield 226	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   333: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: ldc 183
    //   341: invokestatic 229	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   344: iload 5
    //   346: istore 6
    //   348: ldc 97
    //   350: ldc_w 284
    //   353: new 99	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   360: aload_2
    //   361: getfield 265	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_f_of_type_Int	I
    //   364: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 286
    //   370: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_2
    //   374: getfield 268	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   377: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: aload_2
    //   384: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   387: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   390: iload 5
    //   392: ireturn
    //   393: iload 8
    //   395: istore 6
    //   397: aload 12
    //   399: ldc_w 288
    //   402: invokevirtual 292	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   405: astore 14
    //   407: iload 8
    //   409: istore 6
    //   411: aload 14
    //   413: ldc_w 294
    //   416: invokevirtual 250	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: astore 13
    //   421: iload 7
    //   423: istore 5
    //   425: iload 8
    //   427: istore 6
    //   429: aload_0
    //   430: getfield 37	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   433: ifnull -153 -> 280
    //   436: iload 7
    //   438: istore 5
    //   440: iload 8
    //   442: istore 6
    //   444: aload 13
    //   446: invokestatic 178	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   449: ifne -169 -> 280
    //   452: iload 7
    //   454: istore 5
    //   456: iload 8
    //   458: istore 6
    //   460: aload_0
    //   461: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: ifnull -184 -> 280
    //   467: iload 8
    //   469: istore 6
    //   471: aload 14
    //   473: ldc_w 296
    //   476: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   479: ifeq +130 -> 609
    //   482: iload 8
    //   484: istore 6
    //   486: aload 14
    //   488: ldc_w 296
    //   491: invokevirtual 240	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   494: istore_3
    //   495: ldc 183
    //   497: astore 12
    //   499: iload 8
    //   501: istore 6
    //   503: aload 14
    //   505: ldc_w 298
    //   508: invokevirtual 246	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   511: ifeq +17 -> 528
    //   514: iload 8
    //   516: istore 6
    //   518: aload 14
    //   520: ldc_w 298
    //   523: invokevirtual 250	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   526: astore 12
    //   528: aload_2
    //   529: iload_3
    //   530: putfield 300	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_h_of_type_Int	I
    //   533: aload_2
    //   534: aload 12
    //   536: putfield 303	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:m	Ljava/lang/String;
    //   539: new 305	android/os/Bundle
    //   542: dup
    //   543: invokespecial 306	android/os/Bundle:<init>	()V
    //   546: astore 12
    //   548: aload 12
    //   550: ldc_w 308
    //   553: aload 13
    //   555: invokevirtual 312	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload 12
    //   560: ldc_w 314
    //   563: aload_2
    //   564: invokevirtual 318	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   567: aload_0
    //   568: getfield 37	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   571: sipush 8001
    //   574: invokevirtual 322	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   577: astore 14
    //   579: aload 14
    //   581: aload 12
    //   583: invokevirtual 328	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   586: aload_0
    //   587: getfield 37	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   590: aload 14
    //   592: invokevirtual 332	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   595: pop
    //   596: aload_0
    //   597: aload_2
    //   598: aload 13
    //   600: invokevirtual 335	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:a	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;Ljava/lang/String;)V
    //   603: iconst_1
    //   604: istore 5
    //   606: goto -326 -> 280
    //   609: iconst_0
    //   610: istore_3
    //   611: goto -116 -> 495
    //   614: iload 5
    //   616: istore 6
    //   618: aload_0
    //   619: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: aload_2
    //   623: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   626: ldc_w 280
    //   629: ldc_w 337
    //   632: new 99	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   639: ldc_w 339
    //   642: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: iload 4
    //   647: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   650: aload 11
    //   652: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: new 99	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   665: ldc 221
    //   667: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_2
    //   671: getfield 185	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   674: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: aload_2
    //   678: getfield 223	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   681: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: aload_2
    //   685: getfield 226	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   688: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 229	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   697: goto -353 -> 344
    //   700: astore 11
    //   702: ldc 97
    //   704: iconst_1
    //   705: new 99	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   712: ldc_w 341
    //   715: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: aload 11
    //   720: invokevirtual 342	java/lang/Exception:toString	()Ljava/lang/String;
    //   723: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   732: ldc 97
    //   734: ldc_w 344
    //   737: aload 11
    //   739: invokevirtual 347	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   742: aload_2
    //   743: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   746: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   749: ldc 97
    //   751: ldc_w 349
    //   754: aload_1
    //   755: aload_2
    //   756: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   759: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   762: ldc 97
    //   764: ldc_w 351
    //   767: aload_2
    //   768: invokevirtual 278	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:toString	()Ljava/lang/String;
    //   771: aload_2
    //   772: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   775: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   778: aload_0
    //   779: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   782: aload_2
    //   783: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   786: ldc_w 280
    //   789: ldc_w 337
    //   792: new 99	java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   799: ldc_w 339
    //   802: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload 11
    //   807: invokevirtual 354	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   810: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   816: new 99	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   823: ldc 221
    //   825: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload_2
    //   829: getfield 185	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   832: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: aload_2
    //   836: getfield 223	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   839: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: aload_2
    //   843: getfield 226	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   846: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   849: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 229	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   855: iload 6
    //   857: ireturn
    //   858: ldc 97
    //   860: ldc_w 344
    //   863: ldc_w 356
    //   866: aload_2
    //   867: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   870: invokestatic 263	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   873: aload_0
    //   874: getfield 67	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   877: aload_2
    //   878: getfield 208	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_k_of_type_JavaLangString	Ljava/lang/String;
    //   881: ldc_w 280
    //   884: ldc_w 337
    //   887: ldc_w 358
    //   890: new 99	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   897: ldc 221
    //   899: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: aload_2
    //   903: getfield 185	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   906: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   909: aload_2
    //   910: getfield 223	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_d_of_type_Int	I
    //   913: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   916: aload_2
    //   917: getfield 226	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_g_of_type_Int	I
    //   920: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   923: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokestatic 229	com/tencent/mobileqq/teamwork/tencentdocreport/TenDocLogReportHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   929: iconst_0
    //   930: ireturn
    //   931: astore 11
    //   933: iconst_1
    //   934: istore 6
    //   936: goto -234 -> 702
    //   939: ldc 183
    //   941: astore 11
    //   943: goto -811 -> 132
    //   946: goto -754 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	TeamWorkFileImportHandler
    //   0	949	1	paramString	String
    //   0	949	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   494	117	3	i	int
    //   103	543	4	j	int
    //   278	337	5	bool1	boolean
    //   80	855	6	bool2	boolean
    //   4	449	7	bool3	boolean
    //   1	514	8	bool4	boolean
    //   13	13	9	l	long
    //   130	521	11	str1	String
    //   700	106	11	localException1	Exception
    //   931	1	11	localException2	Exception
    //   941	1	11	str2	String
    //   90	492	12	localObject1	Object
    //   419	180	13	str3	String
    //   405	186	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	92	700	java/lang/Exception
    //   96	105	700	java/lang/Exception
    //   109	119	700	java/lang/Exception
    //   123	132	700	java/lang/Exception
    //   136	173	700	java/lang/Exception
    //   196	202	700	java/lang/Exception
    //   206	212	700	java/lang/Exception
    //   216	256	700	java/lang/Exception
    //   260	276	700	java/lang/Exception
    //   289	344	700	java/lang/Exception
    //   348	390	700	java/lang/Exception
    //   397	407	700	java/lang/Exception
    //   411	421	700	java/lang/Exception
    //   429	436	700	java/lang/Exception
    //   444	452	700	java/lang/Exception
    //   460	467	700	java/lang/Exception
    //   471	482	700	java/lang/Exception
    //   486	495	700	java/lang/Exception
    //   503	514	700	java/lang/Exception
    //   518	528	700	java/lang/Exception
    //   618	697	700	java/lang/Exception
    //   528	603	931	java/lang/Exception
  }
  
  private boolean c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = TenDocLogReportHelper.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2;
    int n;
    String str2;
    boolean bool1;
    label352:
    Object localObject3;
    label416:
    int i;
    int j;
    label700:
    Object localObject2;
    label909:
    Object localObject4;
    label1655:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool2 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool2 = bool4;
          n = localJSONObject.getInt("ret");
          bool2 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool2 = bool4;
            localJSONObject.getString("msg");
          }
          bool2 = bool4;
          str2 = localJSONObject.getString("error");
          bool2 = bool4;
          TenDocLogReportHelper.a("TeamWorkFileImportHandler", "addFileImportJob end:" + paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
          switch (n)
          {
          case 0: 
            bool2 = bool4;
            paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
            bool2 = bool4;
            paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
            bool2 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
            bool2 = bool4;
            TenDocLogReportHelper.a("TeamWorkFileImportHandler", "import file job fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
            bool1 = bool3;
            if (n != 0) {
              break label2714;
            }
            bool2 = bool1;
            TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
            bool2 = bool1;
            TenDocLogReportHelper.a("TeamWorkFileImportHandler", "import result", paramTeamWorkFileImportInfo.jdField_f_of_type_Int + " " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
            return bool1;
          }
        }
        catch (Exception localException1) {}
        bool2 = bool4;
        localObject3 = localJSONObject.getString("url");
        bool1 = bool3;
        bool2 = bool4;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          bool1 = bool3;
          bool2 = bool4;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            bool1 = bool3;
            bool2 = bool4;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              bool2 = bool4;
              if (localJSONObject.has("urlType"))
              {
                bool2 = bool4;
                i = localJSONObject.getInt("urlType");
                bool2 = bool4;
                j = paramTeamWorkFileImportInfo.jdField_g_of_type_Int;
                bool2 = bool4;
                QLog.e("TeamWorkFileImportHandler", 1, " parseFileImportResult: " + i + ",importOption: " + j);
                bool2 = bool4;
                Object localObject1 = localObject3;
                if (!paramTeamWorkFileImportInfo.d()) {
                  break label2881;
                }
                bool2 = bool4;
                localObject3 = TeamWorkUtils.b((String)localObject3);
                if ((i == 1) || (i == 2))
                {
                  bool2 = bool4;
                  TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009ECF");
                }
                if (i == 2)
                {
                  bool2 = bool4;
                  QLog.w("TeamWorkFileImportHandler", 1, "online preview has edited cache, import again");
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.jdField_h_of_type_Int = i;
                  bool2 = bool4;
                  paramTeamWorkFileImportInfo.p = ((String)localObject3);
                  bool1 = bool3;
                  continue;
                  QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResult JSONException: " + localException1.toString());
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
                  TenDocLogReportHelper.a("TeamWorkFileImportHandler", "parse import file json fail", localException1.getLocalizedMessage(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  TenDocLogReportHelper.a("TeamWorkFileImportHandler", "parse import file json fail, param", paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  TenDocLogReportHelper.a("TeamWorkFileImportHandler", "parse import file json fail, import info", paramTeamWorkFileImportInfo.toString(), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
                  TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + localException1.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
                  return bool2;
                }
              }
              else
              {
                i = 0;
                continue;
              }
              if (i == 1)
              {
                bool2 = bool4;
                paramTeamWorkFileImportInfo.p = null;
                localObject2 = localObject3;
                localObject3 = "";
                bool2 = bool4;
                if (localJSONObject.has("doc_id"))
                {
                  bool2 = bool4;
                  localObject3 = localJSONObject.getString("doc_id");
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.jdField_g_of_type_Int == 7)
                {
                  bool2 = bool4;
                  if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1)
                  {
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      bool2 = bool4;
                      a((String)localObject3);
                    }
                    bool2 = bool4;
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      bool2 = bool4;
                      notifyUI(5, true, new Object[] { Integer.valueOf(0) });
                    }
                  }
                }
                bool2 = bool4;
                if (paramTeamWorkFileImportInfo.jdField_g_of_type_Int == 1)
                {
                  bool2 = bool4;
                  notifyUI(6, true, new Object[] { localObject2, localObject3, paramTeamWorkFileImportInfo });
                }
                bool2 = true;
              }
            }
          }
        }
        try
        {
          paramTeamWorkFileImportInfo.jdField_h_of_type_Int = i;
          paramTeamWorkFileImportInfo.m = ((String)localObject3);
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("url", (String)localObject2);
          ((Bundle)localObject3).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
          localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
          ((Message)localObject4).setData((Bundle)localObject3);
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject4);
          a(paramTeamWorkFileImportInfo, (String)localObject2);
          if ((j != 1) && (j != 7) && (!paramTeamWorkFileImportInfo.a()) && (!paramTeamWorkFileImportInfo.b())) {
            b(paramTeamWorkFileImportInfo, (String)localObject2);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009066", "0X8009066", 0, 0, "", "", "", "");
          bool1 = true;
        }
        catch (Exception localException2) {}
        localObject2 = localObject3;
        if (i != 0) {
          break label2881;
        }
        bool2 = bool4;
        localObject2 = localObject3;
        if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.p)) {
          break label2881;
        }
        bool2 = bool4;
        localObject2 = TeamWorkUtils.a((String)localObject3, paramTeamWorkFileImportInfo.p);
        bool2 = bool4;
        QLog.w("TeamWorkFileImportHandler", 1, "append edited url: " + (String)localObject2);
        break label2881;
        localObject3 = "";
        localObject4 = "";
        String str1 = "";
        bool2 = bool4;
        localObject2 = localObject3;
        if (localJSONObject.has("filePath"))
        {
          bool2 = bool4;
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
          {
            bool2 = bool4;
            localObject2 = localJSONObject.getString("filePath");
          }
        }
        bool2 = bool4;
        localObject3 = localObject4;
        if (localJSONObject.has("md5"))
        {
          bool2 = bool4;
          localObject3 = localObject4;
          if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
          {
            bool2 = bool4;
            localObject3 = localJSONObject.getString("md5");
          }
        }
        bool2 = bool4;
        localObject4 = str1;
        if (localJSONObject.has("fileName"))
        {
          bool2 = bool4;
          localObject4 = str1;
          if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
          {
            bool2 = bool4;
            localObject4 = localJSONObject.getString("fileName");
          }
        }
        bool2 = bool4;
        str1 = paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.i = String.format(TeamWorkConstants.p, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject3, "UTF-8"), URLEncoder.encode((String)localObject4, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), "preview" });
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool1 = bool3;
        continue;
        bool2 = bool4;
        localObject2 = new JSONObject(str2);
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startRow")) {
          break label2884;
        }
        bool2 = bool4;
        i = ((JSONObject)localObject2).getInt("startRow");
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endRow")) {
          break label2889;
        }
        bool2 = bool4;
        j = ((JSONObject)localObject2).getInt("endRow");
        label1684:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("startCol")) {
          break label2895;
        }
        bool2 = bool4;
        k = ((JSONObject)localObject2).getInt("startCol");
        label1713:
        bool2 = bool4;
        if (!((JSONObject)localObject2).has("endCol")) {
          break label2901;
        }
        bool2 = bool4;
      }
    }
    label2714:
    label2881:
    label2884:
    label2889:
    label2895:
    label2901:
    for (int m = ((JSONObject)localObject2).getInt("endCol");; m = 0)
    {
      bool2 = bool4;
      localObject2 = TeamWorkUtils.a(k);
      bool2 = bool4;
      localObject3 = TeamWorkUtils.a(m);
      bool2 = bool4;
      localObject4 = new StringBuilder();
      bool2 = bool4;
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719799));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("1");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719801), new Object[] { Integer.valueOf(i) }));
          label1897:
          if (k != m) {
            break label2158;
          }
          bool2 = bool4;
          ((StringBuilder)localObject4).append("\n");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
          bool2 = bool4;
          ((StringBuilder)localObject4).append("2");
          bool2 = bool4;
          ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719800), new Object[] { localObject2 }));
        }
      }
      for (;;)
      {
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool2 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = ((StringBuilder)localObject4).toString();
        bool2 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool1 = bool3;
        break;
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("1");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719798), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1897;
        label2158:
        bool2 = bool4;
        ((StringBuilder)localObject4).append("\n");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
        bool2 = bool4;
        ((StringBuilder)localObject4).append("2");
        bool2 = bool4;
        ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719797), new Object[] { localObject2, localObject3 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719801), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719798), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719800), new Object[] { localObject2 }));
          }
          else
          {
            bool2 = bool4;
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool2 = bool4;
            ((StringBuilder)localObject4).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719797), new Object[] { localObject2, localObject3 }));
          }
        }
      }
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_PUBLIC_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.jdField_h_of_type_Int = 0;
      bool1 = bool3;
      break label352;
      bool2 = bool4;
      QLog.i("TeamWorkFileImportHandler", 1, " parseFileImportTendoc: RETCODE_CGI_NO_USER_CACHE");
      bool2 = bool4;
      notifyUI(7, false, new Object[] { paramTeamWorkFileImportInfo });
      bool2 = bool4;
      paramTeamWorkFileImportInfo.jdField_h_of_type_Int = 0;
      bool1 = bool3;
      break label352;
      bool2 = bool4;
      c(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      e(paramTeamWorkFileImportInfo);
      bool2 = bool4;
      notifyUI(5, true, new Object[] { Integer.valueOf(1) });
      bool1 = bool3;
      break label352;
      bool2 = bool1;
      TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      break label416;
      TenDocLogReportHelper.a("TeamWorkFileImportHandler", "parse import file json fail", "no result string", paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      return false;
      break label700;
      break;
      break label909;
      i = 0;
      break label1655;
      j = 0;
      break label1684;
      k = 0;
      break label1713;
    }
  }
  
  private void d(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ImportFormData localImportFormData = ImportFormData.a(paramJSONObject);
    if ((localImportFormData != null) && (localImportFormData.jdField_a_of_type_JavaLangString != null)) {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        paramTeamWorkFileImportInfo.l = localImportFormData.b;
        paramTeamWorkFileImportInfo.q = localImportFormData.jdField_d_of_type_JavaLangString;
        paramJSONObject = new Bundle();
        paramJSONObject.putString("url", localImportFormData.jdField_a_of_type_JavaLangString);
        paramJSONObject.putParcelable("fileInfo", paramTeamWorkFileImportInfo);
        paramTeamWorkFileImportInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
        paramTeamWorkFileImportInfo.setData(paramJSONObject);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramTeamWorkFileImportInfo);
      }
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    paramTeamWorkFileImportInfo.jdField_f_of_type_Int = paramJSONObject.optInt("retcode", -1);
    paramJSONObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8002);
    paramJSONObject.obj = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramJSONObject);
  }
  
  public String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    String str = "";
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    }
    while (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      return (String)this.d.get(str);
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long + "_" + paramTeamWorkFileImportInfo.jdField_b_of_type_Long;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) {
        str = paramTeamWorkFileImportInfo.c;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString)) {
        str = paramTeamWorkFileImportInfo.jdField_f_of_type_JavaLangString;
      }
    }
    return (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (paramTeamWorkFileImportInfo != null))
    {
      TenDocLogReportHelper.a(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int != 10) {
        break label94;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportForH5(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    for (;;)
    {
      a();
      TenDocLogReportHelper.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      TenDocLogReportHelper.a("TeamWorkFileImportHandler", "addFileImportJob start:" + paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString, String.valueOf(System.currentTimeMillis()), paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
      return;
      label94:
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 6) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForDataLIne(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 13) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForFile2Form(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForGroup(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForDisc(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 6000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 6003)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForDataLIne(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 12) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForUrl2Doc(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      } else {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForC2C(paramTeamWorkFileImportInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramString == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      paramString = TenDocLogReportHelper.b(paramString);
      this.d.put(str, TenDocLogReportHelper.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, TenDocLogReportHelper.a(paramString, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(new TeamWorkFileImportHandler.8(this, paramString));
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.4(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(new TeamWorkFileImportHandler.3(this, paramJSONObject, paramTeamWorkFileImportInfo, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool2 = true;
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    boolean bool1;
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.c.containsKey(paramTeamWorkFileImportInfo.c))) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      bool1 = bool2;
      if (!this.c.containsKey(paramTeamWorkFileImportInfo))
      {
        do
        {
          bool1 = false;
          break;
          if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c))
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c)) {
              break;
            }
          }
          paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
        } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo));
        bool1 = bool2;
      }
    }
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
      paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramTeamWorkFileImportInfo);
      if (paramTeamWorkFileImportInfo != null)
      {
        paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = paramBoolean;
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public boolean a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    long l = TenDocLogReportHelper.a(paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
    TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9A", String.valueOf(l), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1;
    int n;
    String str2;
    boolean bool2;
    Object localObject1;
    Object localObject2;
    int i;
    label947:
    int j;
    label974:
    int k;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool4;
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          localJSONObject = new JSONObject(paramString);
          bool1 = bool4;
          n = localJSONObject.getInt("ret");
          bool1 = bool4;
          if (localJSONObject.has("msg"))
          {
            bool1 = bool4;
            localJSONObject.getString("msg");
          }
          bool1 = bool4;
          str2 = localJSONObject.getString("error");
          switch (n)
          {
          case 0: 
            bool1 = bool4;
            paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
            bool1 = bool4;
            paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
            bool1 = bool4;
            QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
            bool2 = bool3;
            if (n != 0) {
              break label1853;
            }
            bool1 = bool2;
            TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "success", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int, "");
          }
        }
        catch (Exception paramString)
        {
          QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResultForH5 JSONException: " + paramString.toString());
          TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + paramString.getMessage(), "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
          return bool1;
        }
        bool1 = bool4;
        paramString = localJSONObject.getString("url");
        bool2 = bool3;
        bool1 = bool4;
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          bool2 = bool3;
          bool1 = bool4;
          if (!TextUtils.isEmpty(paramString))
          {
            bool2 = bool3;
            bool1 = bool4;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              bool3 = true;
              bool2 = true;
              bool1 = bool3;
              localObject1 = new Bundle();
              bool1 = bool3;
              ((Bundle)localObject1).putString("url", paramString);
              bool1 = bool3;
              ((Bundle)localObject1).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
              bool1 = bool3;
              localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
              bool1 = bool3;
              ((Message)localObject2).setData((Bundle)localObject1);
              bool1 = bool3;
              this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
              bool1 = bool3;
              a(paramTeamWorkFileImportInfo, paramString);
              continue;
              localObject1 = "";
              localObject2 = "";
              String str1 = "";
              bool1 = bool4;
              paramString = (String)localObject1;
              if (localJSONObject.has("filePath"))
              {
                bool1 = bool4;
                paramString = (String)localObject1;
                if (!TextUtils.isEmpty(localJSONObject.getString("filePath")))
                {
                  bool1 = bool4;
                  paramString = localJSONObject.getString("filePath");
                }
              }
              bool1 = bool4;
              localObject1 = localObject2;
              if (localJSONObject.has("md5"))
              {
                bool1 = bool4;
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(localJSONObject.getString("md5")))
                {
                  bool1 = bool4;
                  localObject1 = localJSONObject.getString("md5");
                }
              }
              bool1 = bool4;
              localObject2 = str1;
              if (localJSONObject.has("fileName"))
              {
                bool1 = bool4;
                localObject2 = str1;
                if (!TextUtils.isEmpty(localJSONObject.getString("fileName")))
                {
                  bool1 = bool4;
                  localObject2 = localJSONObject.getString("fileName");
                }
              }
              bool1 = bool4;
              str1 = paramTeamWorkFileImportInfo.jdField_g_of_type_JavaLangString;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.i = String.format(TeamWorkConstants.p, new Object[] { URLEncoder.encode(str1, "UTF-8"), URLEncoder.encode((String)localObject1, "UTF-8"), URLEncoder.encode((String)localObject2, "UTF-8"), URLEncoder.encode(paramString, "UTF-8"), "import" });
              bool1 = bool4;
              paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
              bool1 = bool4;
              paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = str2;
              bool1 = bool4;
              QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
              bool2 = bool3;
              continue;
              bool1 = bool4;
              paramString = new JSONObject(str2);
              bool1 = bool4;
              if (!paramString.has("startRow")) {
                break label2003;
              }
              bool1 = bool4;
              i = paramString.getInt("startRow");
              bool1 = bool4;
              if (!paramString.has("endRow")) {
                break label2008;
              }
              bool1 = bool4;
              j = paramString.getInt("endRow");
              bool1 = bool4;
              if (!paramString.has("startCol")) {
                break label2014;
              }
              bool1 = bool4;
              k = paramString.getInt("startCol");
              label1001:
              bool1 = bool4;
              if (!paramString.has("endCol")) {
                break label2020;
              }
              bool1 = bool4;
            }
          }
        }
      }
    }
    label1182:
    label1442:
    label1853:
    label2000:
    label2003:
    label2008:
    label2014:
    label2020:
    for (int m = paramString.getInt("endCol");; m = 0)
    {
      bool1 = bool4;
      paramString = TeamWorkUtils.a(k);
      bool1 = bool4;
      localObject1 = TeamWorkUtils.a(m);
      bool1 = bool4;
      localObject2 = new StringBuilder();
      bool1 = bool4;
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719799));
      if ((i != 0) && (k != 0)) {
        if (i == j)
        {
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("1");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719801), new Object[] { Integer.valueOf(i) }));
          if (k != m) {
            break label1442;
          }
          bool1 = bool4;
          ((StringBuilder)localObject2).append("\n");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
          bool1 = bool4;
          ((StringBuilder)localObject2).append("2");
          bool1 = bool4;
          ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719800), new Object[] { paramString }));
        }
      }
      for (;;)
      {
        bool1 = bool4;
        paramTeamWorkFileImportInfo.jdField_f_of_type_Int = n;
        bool1 = bool4;
        paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
        bool1 = bool4;
        QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResultForH5 server ret: " + n + ",error: " + paramTeamWorkFileImportInfo.jdField_h_of_type_JavaLangString);
        bool2 = bool3;
        break;
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("1");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719798), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        break label1182;
        bool1 = bool4;
        ((StringBuilder)localObject2).append("\n");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
        bool1 = bool4;
        ((StringBuilder)localObject2).append("2");
        bool1 = bool4;
        ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719797), new Object[] { paramString, localObject1 }));
        continue;
        if ((i != 0) && (k == 0))
        {
          if (i == j)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719801), new Object[] { Integer.valueOf(i) }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719798), new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
          }
        }
        else if ((i == 0) && (k != 0)) {
          if (k == m)
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719800), new Object[] { paramString }));
          }
          else
          {
            bool1 = bool4;
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719795));
            bool1 = bool4;
            ((StringBuilder)localObject2).append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719797), new Object[] { paramString, localObject1 }));
          }
        }
      }
      bool1 = bool2;
      TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=" + n + str2, "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      break label2000;
      TenDocLogReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString, "0X8009E9B", "fail", "err=EMPTY RESULT", "import_type=" + paramTeamWorkFileImportInfo.jdField_a_of_type_Int + paramTeamWorkFileImportInfo.jdField_d_of_type_Int + paramTeamWorkFileImportInfo.jdField_g_of_type_Int);
      return false;
      break;
      return bool2;
      i = 0;
      break label947;
      j = 0;
      break label974;
      k = 0;
      break label1001;
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean) {
        break label48;
      }
      if (!TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo)) {
        break label33;
      }
      this.c.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
    }
    label33:
    label48:
    while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.c))
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(b(paramTeamWorkFileImportInfo), paramTeamWorkFileImportInfo);
      return;
    }
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      this.c.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo.c, paramTeamWorkFileImportInfo);
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString))) {}
    boolean bool;
    do
    {
      return;
      QLog.d("TeamWorkFileImportHandler", 1, " --- createGrayTips ");
      bool = TencentDocConvertConfigProcessor.a().e();
    } while (((!paramTeamWorkFileImportInfo.jdField_b_of_type_Boolean) && (!paramTeamWorkFileImportInfo.d())) || (!bool));
    if (paramTeamWorkFileImportInfo.d()) {}
    for (String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719821), new Object[] { "\"" + FileUtil.b(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString) + "\"" });; str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719820), new Object[] { "\"" + FileUtil.b(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString) + "\"" }))
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(-2063);
      long l = MessageCache.a();
      localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, str, l, -2063, paramTeamWorkFileImportInfo.jdField_a_of_type_Int, l);
      localMessageRecord.isread = true;
      localMessageRecord.saveExtInfoToExtStr("key_team_work_ext_info_new_url", paramString);
      localMessageRecord.saveExtInfoToExtStr("team_work_is_message_convert", Boolean.toString(paramTeamWorkFileImportInfo.jdField_f_of_type_Boolean));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.5(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(new TeamWorkFileImportHandler.11(this, paramTeamWorkFileImportInfo, paramJSONObject, paramInt));
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str;
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo)) {
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.c.containsKey(paramTeamWorkFileImportInfo.c)))
      {
        str = paramTeamWorkFileImportInfo.c;
        if (!TextUtils.isEmpty(str)) {
          this.c.remove(str);
        }
      }
    }
    label127:
    for (;;)
    {
      paramTeamWorkFileImportInfo.jdField_k_of_type_Int = 0;
      return;
      str = b(paramTeamWorkFileImportInfo);
      break;
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.c)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.c))) {}
      for (str = paramTeamWorkFileImportInfo.c;; str = b(paramTeamWorkFileImportInfo))
      {
        if (TextUtils.isEmpty(str)) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        break;
      }
    }
  }
  
  public void c(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.6(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void d(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8002);
      localMessage.obj = paramTeamWorkFileImportInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void e(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    String str = b(paramTeamWorkFileImportInfo);
    if (TeamWorkConvertUtils.a(paramTeamWorkFileImportInfo))
    {
      this.d.remove(str);
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
  }
  
  public void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.1(this, paramTeamWorkFileImportInfo));
  }
  
  public void g(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.2(this, paramTeamWorkFileImportInfo));
  }
  
  public void h(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.7(this, paramTeamWorkFileImportInfo));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        paramMessage = paramMessage.getData();
        TeamWorkFileImportInfo localTeamWorkFileImportInfo = (TeamWorkFileImportInfo)paramMessage.getParcelable("fileInfo");
        String str = paramMessage.getString("url");
        c(localTeamWorkFileImportInfo);
        if (QLog.isDevelopLevel()) {
          QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_SUCCESS:" + str);
        }
        paramMessage = str;
        if (localTeamWorkFileImportInfo != null)
        {
          str = TenDocLogReportHelper.a(str, localTeamWorkFileImportInfo.jdField_k_of_type_JavaLangString);
          paramMessage = str;
          if (TeamWorkConvertUtils.a(localTeamWorkFileImportInfo)) {
            paramMessage = TenDocLogReportHelper.b(str);
          }
        }
        notifyUI(1, true, new Object[] { paramMessage, localTeamWorkFileImportInfo });
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("teamConvert", 2, "convert finish time [" + System.currentTimeMillis() / 1000L + "]");
        }
      } while (!this.jdField_b_of_type_Boolean);
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131719806), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299166));
      return true;
      paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
      c(paramMessage);
      notifyUI(2, true, paramMessage);
    } while (!QLog.isDevelopLevel());
    QLog.e("TeamWorkFileImportHandler", 1, "MSG_FILE_IMPORT_ERROR:" + paramMessage.jdField_b_of_type_JavaLangString);
    return true;
  }
  
  public void i(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new TeamWorkFileImportHandler.10(this, paramTeamWorkFileImportInfo));
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TeamWorkFileImportObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler
 * JD-Core Version:    0.7.0.1
 */