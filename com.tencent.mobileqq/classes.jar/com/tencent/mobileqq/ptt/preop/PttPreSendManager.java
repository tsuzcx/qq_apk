package com.tencent.mobileqq.ptt.preop;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.PttOptimizeParams;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class PttPreSendManager
  implements Manager
{
  private static ConcurrentHashMap<String, PttPreSendManager.PreSendTask> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public static boolean b;
  int jdField_a_of_type_Int = -1;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  PreSendTypeStrategy jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy;
  PttPreFlowController jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController;
  PttPreVoiceChanger jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString;
  volatile boolean c = false;
  private volatile boolean d = false;
  
  static
  {
    jdField_b_of_type_Boolean = false;
  }
  
  public PttPreSendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static PttPreSendManager a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (PttPreSendManager)paramQQAppInterface.getManager(QQManagerFactory.PTT_PRE_SEND_MANAGER);
    if (!paramQQAppInterface.d) {
      try
      {
        if (!paramQQAppInterface.d)
        {
          paramQQAppInterface.a();
          paramQQAppInterface.d = true;
        }
        return paramQQAppInterface;
      }
      finally {}
    }
    return paramQQAppInterface;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    return PttOptimizeParams.d(paramQQAppInterface) == 1;
  }
  
  public void a()
  {
    if (!jdField_b_of_type_Boolean) {
      switch (VcSystemInfo.getCpuArchitecture())
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController = new PttPreFlowController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 100000, 10000000, 86399999L);
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy = new PreSendTypeStrategy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger = new PttPreVoiceChanger();
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "init manager end ");
      }
      return;
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public void a(SessionInfo paramSessionInfo, RecordParams.RecorderParam paramRecorderParam)
  {
    int i = 1;
    if (!this.c) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a();
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a();
    this.jdField_b_of_type_Int = ((int)new File(this.jdField_b_of_type_JavaLangString).length());
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Int)))
    {
      MessageForPtt localMessageForPtt = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, paramSessionInfo, -2, paramRecorderParam.c);
      if (localMessageForPtt == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "createPttMessage null");
        }
        c();
        return;
      }
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localTransferRequest.mPeerUin = paramSessionInfo.jdField_a_of_type_JavaLangString;
      localTransferRequest.mUinType = paramSessionInfo.jdField_a_of_type_Int;
      localTransferRequest.mFileType = 2;
      localTransferRequest.mUniseq = localMessageForPtt.uniseq;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = this.jdField_b_of_type_JavaLangString;
      localTransferRequest.mBusiType = 1002;
      localTransferRequest.mPttCompressFinish = true;
      localTransferRequest.mPttUploadPanel = 3;
      localTransferRequest.mIsPttPreSend = true;
      localTransferRequest.mRec = localMessageForPtt;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = localMessageForPtt;
      paramSessionInfo = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      paramSessionInfo.voiceType = paramRecorderParam.c;
      paramSessionInfo.voiceLength = QQRecorder.a(j);
      if (this.jdField_a_of_type_Int > 0) {}
      for (;;)
      {
        paramSessionInfo.voiceChangeFlag = i;
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
        paramSessionInfo = localTransferRequest.mPeerUin + localTransferRequest.mUniseq;
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSessionInfo, new PttPreSendManager.PreSendTask(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PttPreSendManager", 2, "doPreSendIfIcan ：true");
        return;
        i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("PttPreSendManager", 2, "doPreSendIfIcan : false, flow don't enough or size < 0, seiz : " + this.jdField_b_of_type_Int);
    }
    c();
  }
  
  public void a(String paramString)
  {
    paramString = (PttPreSendManager.PreSendTask)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (paramString != null)
    {
      File localFile1 = new File(paramString.jdField_b_of_type_JavaLangString);
      if (localFile1.exists())
      {
        File localFile2 = new File(paramString.jdField_a_of_type_JavaLangString);
        if (localFile2.exists()) {
          localFile2.delete();
        }
        localFile1.renameTo(localFile2);
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "rename presend file ! , from " + paramString.jdField_b_of_type_JavaLangString + " to " + paramString.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void a(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    this.c = false;
    this.jdField_a_of_type_Int = -1;
    boolean bool4 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1 = bool3;
    long l;
    if (jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (bool4)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a();
        l = SystemClock.uptimeMillis();
        if (NetworkUtil.a(BaseApplicationImpl.sApplication) != 1) {
          break label310;
        }
      }
    }
    label310:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (QLog.isDevelopLevel()) {
        QLog.d("PttPreSendManager", 4, "get network type cost " + (SystemClock.uptimeMillis() - l));
      }
      bool1 = this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController.a(this.jdField_a_of_type_Boolean);
      if ((bool1) && (this.jdField_a_of_type_Int != -1))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        int i = this.jdField_a_of_type_JavaLangString.lastIndexOf(".");
        this.jdField_b_of_type_JavaLangString = paramString1.substring(0, i);
        this.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString.concat("_pre").concat(paramString1.substring(i, paramString1.length()));
        this.c = this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, paramRecorderParam, paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, " startPreSendIfNeed : " + this.c + ", cpu : " + jdField_b_of_type_Boolean + ", flow enough : " + bool1 + ", type : " + this.jdField_a_of_type_Int + ", cfg : " + bool4);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.c) {}
    while (this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.a(paramArrayOfByte, paramInt)) {
      return;
    }
    c();
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.activity.aio.core.BaseChatPie paramBaseChatPie, int paramInt)
  {
    // Byte code:
    //   0: getstatic 24	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_b_of_type_Boolean	Z
    //   3: ifeq +48 -> 51
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokespecial 276	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   14: ifeq +37 -> 51
    //   17: aload_0
    //   18: getfield 87	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy	Lcom/tencent/mobileqq/ptt/preop/PreSendTypeStrategy;
    //   21: aload_0
    //   22: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   25: iload_2
    //   26: invokevirtual 349	com/tencent/mobileqq/ptt/preop/PreSendTypeStrategy:a	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   29: aload_0
    //   30: getfield 36	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Int	I
    //   33: iload_2
    //   34: if_icmpne +17 -> 51
    //   37: aload_0
    //   38: getfield 81	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController	Lcom/tencent/mobileqq/ptt/preop/PttPreFlowController;
    //   41: aload_0
    //   42: getfield 122	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Boolean	Z
    //   45: ldc2_w 350
    //   48: invokevirtual 354	com/tencent/mobileqq/ptt/preop/PttPreFlowController:a	(ZJ)V
    //   51: aload_0
    //   52: getfield 40	com/tencent/mobileqq/ptt/preop/PttPreSendManager:c	Z
    //   55: ifne +11 -> 66
    //   58: iconst_0
    //   59: istore_3
    //   60: aload_0
    //   61: invokevirtual 140	com/tencent/mobileqq/ptt/preop/PttPreSendManager:c	()V
    //   64: iload_3
    //   65: ireturn
    //   66: aload_0
    //   67: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: ldc 213
    //   72: invokevirtual 217	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   75: checkcast 213	com/tencent/mobileqq/transfile/api/ITransFileController
    //   78: astore 5
    //   80: new 223	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   87: aload_0
    //   88: getfield 195	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   91: getfield 357	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   94: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: getfield 195	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   101: getfield 169	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   104: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   107: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore 6
    //   112: aload 5
    //   114: aload 6
    //   116: invokeinterface 361 2 0
    //   121: checkcast 363	com/tencent/mobileqq/transfile/BaseUploadProcessor
    //   124: astore 4
    //   126: aload 4
    //   128: ifnonnull +8 -> 136
    //   131: iconst_0
    //   132: istore_3
    //   133: goto -73 -> 60
    //   136: iload_2
    //   137: aload_0
    //   138: getfield 36	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Int	I
    //   141: if_icmpeq +55 -> 196
    //   144: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +12 -> 159
    //   150: ldc 100
    //   152: iconst_2
    //   153: ldc_w 365
    //   156: invokestatic 253	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 4
    //   161: invokevirtual 368	com/tencent/mobileqq/transfile/BaseUploadProcessor:cancel	()I
    //   164: pop
    //   165: aload 5
    //   167: aload 6
    //   169: invokeinterface 372 2 0
    //   174: pop
    //   175: getstatic 31	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   178: aload 6
    //   180: invokevirtual 257	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: getfield 92	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger	Lcom/tencent/mobileqq/ptt/preop/PttPreVoiceChanger;
    //   188: invokevirtual 374	com/tencent/mobileqq/ptt/preop/PttPreVoiceChanger:b	()V
    //   191: iconst_0
    //   192: istore_3
    //   193: goto -133 -> 60
    //   196: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +36 -> 235
    //   202: ldc 100
    //   204: iconst_2
    //   205: new 223	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   212: ldc_w 376
    //   215: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 4
    //   220: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   223: getfield 383	com/tencent/mobileqq/transfile/TransferRequest:mCanSendMsg	Z
    //   226: invokevirtual 333	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   229: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 105	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   235: aload_0
    //   236: getfield 81	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController	Lcom/tencent/mobileqq/ptt/preop/PttPreFlowController;
    //   239: aload_0
    //   240: getfield 122	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_Boolean	Z
    //   243: aload_0
    //   244: getfield 38	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_b_of_type_Int	I
    //   247: i2l
    //   248: invokevirtual 354	com/tencent/mobileqq/ptt/preop/PttPreFlowController:a	(ZJ)V
    //   251: aload_0
    //   252: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   255: invokevirtual 387	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   258: aload_0
    //   259: getfield 195	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   262: aload_0
    //   263: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   266: invokevirtual 390	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   269: invokevirtual 395	com/tencent/imcore/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   272: aload_0
    //   273: getfield 44	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   276: aload_1
    //   277: getfield 400	com/tencent/mobileqq/activity/aio/core/BaseChatPie:a	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   280: aload_0
    //   281: getfield 127	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   284: bipush 253
    //   286: aload_0
    //   287: getfield 195	com/tencent/mobileqq/ptt/preop/PttPreSendManager:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   290: getfield 169	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   293: invokestatic 403	com/tencent/mobileqq/activity/ChatActivityFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;IJ)V
    //   296: new 405	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1
    //   299: dup
    //   300: aload_0
    //   301: aload_1
    //   302: invokespecial 408	com/tencent/mobileqq/ptt/preop/PttPreSendManager$1:<init>	(Lcom/tencent/mobileqq/ptt/preop/PttPreSendManager;Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V
    //   305: aconst_null
    //   306: iconst_0
    //   307: invokestatic 414	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   310: aload 4
    //   312: invokevirtual 417	com/tencent/mobileqq/transfile/BaseUploadProcessor:fixTimeAtPttPreSend	()V
    //   315: aload 4
    //   317: monitorenter
    //   318: aload 4
    //   320: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   323: getfield 383	com/tencent/mobileqq/transfile/TransferRequest:mCanSendMsg	Z
    //   326: ifeq +30 -> 356
    //   329: aload 5
    //   331: aload 4
    //   333: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   336: invokeinterface 221 2 0
    //   341: pop
    //   342: aload_0
    //   343: aload 6
    //   345: invokevirtual 419	com/tencent/mobileqq/ptt/preop/PttPreSendManager:a	(Ljava/lang/String;)V
    //   348: aload 4
    //   350: monitorexit
    //   351: iconst_1
    //   352: istore_3
    //   353: goto -293 -> 60
    //   356: aload 4
    //   358: getfield 380	com/tencent/mobileqq/transfile/BaseUploadProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   361: iconst_1
    //   362: putfield 383	com/tencent/mobileqq/transfile/TransferRequest:mCanSendMsg	Z
    //   365: goto -17 -> 348
    //   368: astore_1
    //   369: aload 4
    //   371: monitorexit
    //   372: aload_1
    //   373: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	this	PttPreSendManager
    //   0	374	1	paramBaseChatPie	com.tencent.mobileqq.activity.aio.core.BaseChatPie
    //   0	374	2	paramInt	int
    //   59	294	3	bool	boolean
    //   124	246	4	localBaseUploadProcessor	BaseUploadProcessor
    //   78	252	5	localITransFileController	ITransFileController
    //   110	234	6	str	String
    // Exception table:
    //   from	to	target	type
    //   318	348	368	finally
    //   348	351	368	finally
    //   356	365	368	finally
    //   369	372	368	finally
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a(null, -1);
    if (!this.c) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("PttPreSendManager", 4, "doOnCancelSend");
    }
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq;
    localObject = (BaseUploadProcessor)((ITransFileController)localObject).findProcessor(str);
    if (localObject != null) {
      ((BaseUploadProcessor)localObject).cancel();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
    this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreVoiceChanger.b();
    c();
  }
  
  public void c()
  {
    if (!this.c) {}
    do
    {
      return;
      this.c = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    } while (!QLog.isDevelopLevel());
    QLog.e("PttPreSendManager", 4, "clean up");
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPttPreFlowController.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy != null) {
      this.jdField_a_of_type_ComTencentMobileqqPttPreopPreSendTypeStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PttPreSendManager
 * JD-Core Version:    0.7.0.1
 */