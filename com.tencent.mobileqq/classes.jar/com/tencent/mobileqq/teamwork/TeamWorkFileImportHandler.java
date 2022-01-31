package com.tencent.mobileqq.teamwork;

import aimg;
import aimh;
import aimi;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TeamWorkFileImportHandler
  extends BusinessHandler
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private volatile boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "docs.qq.com" };
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  
  public TeamWorkFileImportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).GetPskey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfJavaLangString, new aimi(this, paramRunnable)) == null) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(paramRunnable);
  }
  
  private String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    String str = "";
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d;
    }
    do
    {
      return str;
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        return paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long;
      }
    } while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString));
    return paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) {
      while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        TeamWorkFileImportJob localTeamWorkFileImportJob = (TeamWorkFileImportJob)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        if (localTeamWorkFileImportJob != null) {
          localTeamWorkFileImportJob.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected Class a()
  {
    return TeamWorkFileImportObserver.class;
  }
  
  public String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return null;
    }
    String str = "";
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d;
    }
    for (;;)
    {
      return (String)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0)) {
        str = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long;
      } else if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString)) {
        str = paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString;
      }
    }
  }
  
  /* Error */
  String a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +440 -> 447
    //   10: new 150	org/json/JSONObject
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore 7
    //   20: aload 7
    //   22: ldc 155
    //   24: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   27: istore_3
    //   28: aload 7
    //   30: ldc 161
    //   32: invokevirtual 165	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   35: ifeq +487 -> 522
    //   38: aload 7
    //   40: ldc 161
    //   42: invokevirtual 169	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_1
    //   46: iload_3
    //   47: ifne +316 -> 363
    //   50: aload 7
    //   52: ldc 171
    //   54: invokevirtual 169	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 7
    //   59: aload_0
    //   60: getfield 30	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   63: ifnull +465 -> 528
    //   66: aload 7
    //   68: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne +457 -> 528
    //   74: aload_0
    //   75: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: ifnull +450 -> 528
    //   81: new 173	android/os/Bundle
    //   84: dup
    //   85: invokespecial 174	android/os/Bundle:<init>	()V
    //   88: astore_1
    //   89: aload_1
    //   90: ldc 171
    //   92: aload 7
    //   94: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_1
    //   98: ldc 180
    //   100: aload_2
    //   101: invokevirtual 184	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   104: aload_0
    //   105: getfield 30	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   108: sipush 8001
    //   111: invokevirtual 188	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 194	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   122: aload_0
    //   123: getfield 30	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: aload 8
    //   128: invokevirtual 198	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   139: new 94	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   146: ldc 204
    //   148: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   155: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   158: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: iconst_0
    //   165: invokevirtual 212	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   168: ldc 214
    //   170: iconst_0
    //   171: invokeinterface 220 3 0
    //   176: istore 4
    //   178: aload_2
    //   179: ifnull +349 -> 528
    //   182: aload_2
    //   183: getfield 222	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_b_of_type_Boolean	Z
    //   186: ifeq +342 -> 528
    //   189: iload 4
    //   191: ifeq +337 -> 528
    //   194: ldc 87
    //   196: astore_1
    //   197: aload_2
    //   198: getfield 224	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   201: invokestatic 228	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   204: istore_3
    //   205: iload_3
    //   206: iconst_3
    //   207: if_icmpne +143 -> 350
    //   210: ldc 230
    //   212: astore_1
    //   213: aload_0
    //   214: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   217: invokevirtual 202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   220: ldc 231
    //   222: invokevirtual 234	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   225: iconst_1
    //   226: anewarray 236	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: new 94	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   238: aload_1
    //   239: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 238
    //   244: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_2
    //   248: getfield 224	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   251: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 238
    //   256: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: astore_1
    //   267: sipush -2063
    //   270: invokestatic 247	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   273: astore 8
    //   275: invokestatic 252	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   278: lstore 5
    //   280: aload 8
    //   282: aload_0
    //   283: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   289: aload_2
    //   290: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: aload_2
    //   294: getfield 98	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   297: aload_1
    //   298: lload 5
    //   300: sipush -2063
    //   303: aload_2
    //   304: getfield 92	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:jdField_a_of_type_Int	I
    //   307: lload 5
    //   309: invokevirtual 258	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   312: aload 8
    //   314: iconst_1
    //   315: putfield 261	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   318: aload 8
    //   320: ldc_w 263
    //   323: aload 7
    //   325: invokevirtual 266	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: aload_0
    //   329: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: invokevirtual 269	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   335: aload 8
    //   337: aload_0
    //   338: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   341: invokevirtual 68	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   344: invokevirtual 274	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   347: aload 7
    //   349: areturn
    //   350: iload_3
    //   351: bipush 6
    //   353: if_icmpne -140 -> 213
    //   356: ldc_w 276
    //   359: astore_1
    //   360: goto -147 -> 213
    //   363: aload_0
    //   364: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   367: ldc_w 278
    //   370: ldc 87
    //   372: ldc 87
    //   374: ldc_w 280
    //   377: ldc_w 280
    //   380: iconst_0
    //   381: iconst_0
    //   382: new 94	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   389: iload_3
    //   390: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc 87
    //   395: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: ldc 87
    //   403: ldc 87
    //   405: ldc 87
    //   407: invokestatic 288	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   410: ldc_w 290
    //   413: iconst_1
    //   414: new 94	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 292
    //   424: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: iload_3
    //   428: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc_w 294
    //   434: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_1
    //   438: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aconst_null
    //   448: areturn
    //   449: astore_1
    //   450: aload 8
    //   452: astore_2
    //   453: aload_0
    //   454: getfield 56	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   457: ldc_w 278
    //   460: ldc 87
    //   462: ldc 87
    //   464: ldc_w 280
    //   467: ldc_w 280
    //   470: iconst_0
    //   471: iconst_0
    //   472: ldc 87
    //   474: ldc 87
    //   476: ldc 87
    //   478: ldc 87
    //   480: invokestatic 288	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   483: ldc_w 290
    //   486: iconst_1
    //   487: new 94	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   494: ldc_w 302
    //   497: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_1
    //   501: invokevirtual 303	org/json/JSONException:toString	()Ljava/lang/String;
    //   504: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: aload_2
    //   514: areturn
    //   515: astore_1
    //   516: aload 7
    //   518: astore_2
    //   519: goto -66 -> 453
    //   522: ldc 87
    //   524: astore_1
    //   525: goto -479 -> 46
    //   528: aload 7
    //   530: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	TeamWorkFileImportHandler
    //   0	531	1	paramString	String
    //   0	531	2	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   27	401	3	i	int
    //   176	14	4	bool	boolean
    //   278	30	5	l	long
    //   18	511	7	localObject1	Object
    //   1	450	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	46	449	org/json/JSONException
    //   50	59	449	org/json/JSONException
    //   363	447	449	org/json/JSONException
    //   59	178	515	org/json/JSONException
    //   182	189	515	org/json/JSONException
    //   197	205	515	org/json/JSONException
    //   213	347	515	org/json/JSONException
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue != null) && (paramTeamWorkFileImportInfo != null))
    {
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) {
        break label44;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForGroup(paramTeamWorkFileImportInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    for (;;)
    {
      b();
      return;
      label44:
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForDisc(paramTeamWorkFileImportInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      } else {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(new TeamWorkFileImportJobForC2C(paramTeamWorkFileImportInfo, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      }
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramString == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo, paramString);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    a(new aimh(this, paramJSONObject, paramTeamWorkFileImportInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    boolean bool;
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {}
      for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d;; paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long)
      {
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo)) {
          break label121;
        }
        bool = true;
        break;
      }
      label121:
      bool = false;
    }
  }
  
  public boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString))) {
      paramBoolean = true;
    }
    for (;;)
    {
      return paramBoolean;
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {}
      for (paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d;; paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long)
      {
        paramTeamWorkFileImportInfo = (TeamWorkFileImportInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo == null) {
          break label131;
        }
        paramTeamWorkFileImportInfo.jdField_c_of_type_Boolean = paramBoolean;
        paramBoolean = true;
        break;
      }
      label131:
      paramBoolean = false;
    }
  }
  
  public boolean a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    String str = TeamWorkHttpUtils.b(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    paramString = null;
    if (str != null) {
      paramString = a(str, paramTeamWorkFileImportInfo);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramTeamWorkFileImportInfo, paramString);
      return true;
    }
    return false;
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo != null)
    {
      if (!paramTeamWorkFileImportInfo.jdField_a_of_type_Boolean) {
        break label97;
      }
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) {
        break label58;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d, paramTeamWorkFileImportInfo);
    }
    label58:
    label97:
    while (TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString))
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long, paramTeamWorkFileImportInfo);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString, paramTeamWorkFileImportInfo);
  }
  
  public boolean b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = bool4;
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool1 = bool3;
      for (;;)
      {
        try
        {
          Object localObject = new JSONObject(paramString);
          bool1 = bool3;
          int i = ((JSONObject)localObject).getInt("ret");
          bool1 = bool3;
          if (((JSONObject)localObject).has("msg"))
          {
            bool1 = bool3;
            paramString = ((JSONObject)localObject).getString("msg");
            if (i == 0)
            {
              bool1 = bool3;
              paramString = ((JSONObject)localObject).getString("url");
              bool1 = bool3;
              bool2 = bool4;
              if (this.jdField_a_of_type_AndroidOsHandler != null)
              {
                bool1 = bool3;
                bool2 = bool4;
                if (!TextUtils.isEmpty(paramString))
                {
                  bool1 = bool3;
                  bool2 = bool4;
                  if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
                  {
                    bool3 = true;
                    bool2 = true;
                    bool1 = bool2;
                    localObject = new Bundle();
                    bool1 = bool2;
                    ((Bundle)localObject).putString("url", paramString);
                    bool1 = bool2;
                    ((Bundle)localObject).putParcelable("fileInfo", paramTeamWorkFileImportInfo);
                    bool1 = bool2;
                    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8001);
                    bool1 = bool2;
                    localMessage.setData((Bundle)localObject);
                    bool1 = bool2;
                    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
                    bool1 = bool2;
                    a(paramTeamWorkFileImportInfo, paramString);
                    bool1 = bool2;
                    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009066", "0X8009066", 0, 0, "", "", "", "");
                    bool2 = bool3;
                  }
                }
              }
            }
            else
            {
              bool1 = bool3;
              ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, i + "", "", "", "");
              bool1 = bool3;
              QLog.e("TeamWorkFileImportHandler", 1, "--- parseFileImportResult server ret: " + i + ",error: " + paramString);
              bool2 = bool4;
            }
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("TeamWorkFileImportHandler", 1, " --- parseFileImportResult JSONException: " + paramString.toString());
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800906B", "0X800906B", 0, 0, "", "", "", "");
          bool2 = bool1;
        }
        paramString = "";
      }
    }
    return bool2;
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString))) {
        paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString;
      }
      while (!TextUtils.isEmpty(paramTeamWorkFileImportInfo))
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramTeamWorkFileImportInfo);
        return;
        if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
          paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.d;
        } else {
          paramTeamWorkFileImportInfo = paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString + "_" + paramTeamWorkFileImportInfo.jdField_a_of_type_Long;
        }
      }
    }
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
    paramTeamWorkFileImportInfo = b(paramTeamWorkFileImportInfo);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramTeamWorkFileImportInfo);
  }
  
  public void f(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    a(new aimg(this, paramTeamWorkFileImportInfo));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 8001: 
      do
      {
        return true;
        Object localObject = paramMessage.getData();
        paramMessage = (TeamWorkFileImportInfo)((Bundle)localObject).getParcelable("fileInfo");
        localObject = ((Bundle)localObject).getString("url");
        c(paramMessage);
        a(1, true, new Object[] { localObject, paramMessage });
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8008FB6", "0X8008FB6", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.i("teamConvert", 2, "convert finish time [" + System.currentTimeMillis() / 1000L + "]");
        }
      } while (!this.jdField_b_of_type_Boolean);
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131439150), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return true;
    }
    paramMessage = (TeamWorkFileImportInfo)paramMessage.obj;
    c(paramMessage);
    a(2, true, paramMessage);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler
 * JD-Core Version:    0.7.0.1
 */