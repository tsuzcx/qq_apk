package com.tencent.mobileqq.qrscan;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.chirp.ChirpWrapper;
import com.tencent.chirp.PCMRecorder;
import com.tencent.chirp.PCMRecorder.OnQQRecorderListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload.Callback;
import com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class VoiceScan
  implements Handler.Callback, PCMRecorder.OnQQRecorderListener, IChirpSoDownload.Callback
{
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716721);
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131716720);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ChirpWrapper jdField_a_of_type_ComTencentChirpChirpWrapper;
  private PCMRecorder jdField_a_of_type_ComTencentChirpPCMRecorder;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ChirpSoHandler jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private boolean d = false;
  
  public VoiceScan(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private static void a(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      int j = i * 2;
      int k = paramArrayOfByte[j];
      paramArrayOfShort[i] = ((short)(paramArrayOfByte[(j + 1)] << 8 & 0xFF00 | k & 0xFF));
      i += 1;
    }
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return false;
    }
    ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).setTalkbackSwitch();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkVoiceScanEnable enableTalkBack = ");
      localStringBuilder.append(AppSetting.d);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    return AppSetting.d;
  }
  
  private void d()
  {
    boolean bool = ChirpWrapper.a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSoLoaded ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler = ((ChirpSoHandler)((IEarlyDownloadService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler("qq.android.system.chirp"));
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler;
      if (localObject != null)
      {
        ((ChirpSoHandler)localObject).a(this);
        this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler.a(true);
      }
      return;
    }
    if (AudioUtil.a(1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkInitVoiceScan, permission is forbidden, ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
        QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.jdField_b_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new VoiceScan.1(this));
      }
      return;
    }
    if (((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isVideoChatting(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IQRScanConst_VoiceScan", 2, "isVedioChatting");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qrcode", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_first_enter_voice_qrcode");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkInitVoiceScan, isFirst = ");
      localStringBuilder.append(bool);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_first_enter_voice_qrcode");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).commit();
      localObject = this.jdField_b_of_type_AndroidOsHandler;
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessageDelayed(295, 2000L);
      }
    }
    if (this.jdField_a_of_type_ComTencentChirpChirpWrapper == null)
    {
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = new ChirpWrapper();
      int i = this.jdField_a_of_type_ComTencentChirpChirpWrapper.a();
      if (i != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode chirp init failed = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("IQRScanConst_VoiceScan", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = new PCMRecorder(this.jdField_a_of_type_AndroidContentContext, 44100, this);
      this.jdField_a_of_type_ComTencentChirpPCMRecorder.a();
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentChirpPCMRecorder;
    if (localObject != null)
    {
      ((PCMRecorder)localObject).a();
      this.jdField_a_of_type_ComTencentChirpPCMRecorder = null;
    }
    localObject = this.jdField_a_of_type_ComTencentChirpChirpWrapper;
    if (localObject != null)
    {
      ((ChirpWrapper)localObject).a();
      this.jdField_a_of_type_ComTencentChirpChirpWrapper = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onScannerResume");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.c)
    {
      Process.setThreadPriority(-19);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
      return;
    }
    if (!this.d) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(292);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("record error = ");
      localStringBuilder.append(paramInt);
      QLog.d("IQRScanConst_VoiceScan", 2, localStringBuilder.toString());
    }
    e();
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 221	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_1
    //   9: arraylength
    //   10: iconst_2
    //   11: idiv
    //   12: newarray short
    //   14: astore_3
    //   15: aload_1
    //   16: aload_3
    //   17: invokestatic 263	com/tencent/mobileqq/qrscan/VoiceScan:a	([B[S)V
    //   20: aload_0
    //   21: getfield 221	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentChirpChirpWrapper	Lcom/tencent/chirp/ChirpWrapper;
    //   24: aload_3
    //   25: bipush 15
    //   27: invokevirtual 266	com/tencent/chirp/ChirpWrapper:a	([SI)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_1
    //   32: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +353 -> 388
    //   38: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +35 -> 76
    //   44: new 97	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc_w 274
    //   56: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 112
    //   68: iconst_2
    //   69: aload_3
    //   70: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_1
    //   77: ldc_w 276
    //   80: invokevirtual 282	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   83: ifeq +289 -> 372
    //   86: iconst_0
    //   87: istore_2
    //   88: iload_2
    //   89: aload_1
    //   90: invokevirtual 285	java/lang/String:length	()I
    //   93: if_icmpge +20 -> 113
    //   96: aload_1
    //   97: iload_2
    //   98: invokevirtual 289	java/lang/String:charAt	(I)C
    //   101: bipush 48
    //   103: if_icmpne +10 -> 113
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: goto -22 -> 88
    //   113: aload_1
    //   114: iload_2
    //   115: invokevirtual 292	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore_1
    //   119: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +35 -> 157
    //   125: new 97	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_3
    //   134: ldc_w 294
    //   137: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: aload_1
    //   143: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 112
    //   149: iconst_2
    //   150: aload_3
    //   151: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 119	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_1
    //   158: invokestatic 300	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   161: pop2
    //   162: ldc 81
    //   164: invokestatic 87	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   167: checkcast 81	com/tencent/mobileqq/qrscan/api/IQRScanTempApi
    //   170: ldc_w 301
    //   173: invokestatic 31	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   176: invokeinterface 305 2 0
    //   181: ldc2_w 306
    //   184: invokestatic 313	java/lang/Thread:sleep	(J)V
    //   187: aload_1
    //   188: ifnull +112 -> 300
    //   191: ldc 131
    //   193: aload_1
    //   194: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifne +103 -> 300
    //   200: aload_0
    //   201: getfield 53	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   204: invokevirtual 192	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   207: aload_1
    //   208: invokevirtual 317	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifeq +6 -> 217
    //   214: goto +86 -> 300
    //   217: aload_0
    //   218: getfield 53	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   221: ldc_w 319
    //   224: ldc 131
    //   226: invokevirtual 137	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   229: checkcast 319	com/tencent/mobileqq/friend/api/IFriendDataService
    //   232: aload_1
    //   233: iconst_1
    //   234: iconst_1
    //   235: invokeinterface 323 4 0
    //   240: astore_3
    //   241: aload_3
    //   242: ifnull +39 -> 281
    //   245: aload_3
    //   246: invokevirtual 328	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   249: ifeq +32 -> 281
    //   252: new 330	com/tencent/mobileqq/profilecard/data/AllInOne
    //   255: dup
    //   256: aload_1
    //   257: iconst_1
    //   258: invokespecial 333	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   261: astore_1
    //   262: aload_1
    //   263: aload_3
    //   264: getfield 336	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   267: putfield 339	com/tencent/mobileqq/profilecard/data/AllInOne:nickname	Ljava/lang/String;
    //   270: aload_1
    //   271: aload_3
    //   272: getfield 342	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   275: putfield 343	com/tencent/mobileqq/profilecard/data/AllInOne:remark	Ljava/lang/String;
    //   278: goto +38 -> 316
    //   281: new 330	com/tencent/mobileqq/profilecard/data/AllInOne
    //   284: dup
    //   285: aload_1
    //   286: iconst_3
    //   287: invokespecial 333	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   290: astore_1
    //   291: aload_1
    //   292: bipush 12
    //   294: putfield 347	com/tencent/mobileqq/profilecard/data/AllInOne:subSourceId	I
    //   297: goto +19 -> 316
    //   300: new 330	com/tencent/mobileqq/profilecard/data/AllInOne
    //   303: dup
    //   304: aload_0
    //   305: getfield 53	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   308: invokevirtual 192	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   311: iconst_0
    //   312: invokespecial 333	com/tencent/mobileqq/profilecard/data/AllInOne:<init>	(Ljava/lang/String;I)V
    //   315: astore_1
    //   316: aload_0
    //   317: getfield 51	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   320: aload_1
    //   321: invokestatic 353	com/tencent/mobileqq/profilecard/utils/ProfileUtils:openProfileCard	(Landroid/content/Context;Lcom/tencent/mobileqq/profilecard/data/AllInOne;)V
    //   324: aload_0
    //   325: getfield 53	com/tencent/mobileqq/qrscan/VoiceScan:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   328: ldc_w 355
    //   331: ldc 131
    //   333: ldc 131
    //   335: ldc_w 357
    //   338: ldc_w 357
    //   341: iconst_0
    //   342: iconst_0
    //   343: ldc 131
    //   345: ldc 131
    //   347: ldc 131
    //   349: ldc 131
    //   351: invokestatic 362	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   354: return
    //   355: astore_1
    //   356: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +29 -> 388
    //   362: ldc 112
    //   364: iconst_2
    //   365: ldc 131
    //   367: aload_1
    //   368: invokestatic 365	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: return
    //   372: ldc 81
    //   374: invokestatic 87	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   377: checkcast 81	com/tencent/mobileqq/qrscan/api/IQRScanTempApi
    //   380: getstatic 36	com/tencent/mobileqq/qrscan/VoiceScan:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokeinterface 305 2 0
    //   388: return
    //   389: astore_3
    //   390: goto -203 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	VoiceScan
    //   0	393	1	paramArrayOfByte	byte[]
    //   87	28	2	i	int
    //   14	258	3	localObject	Object
    //   389	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   157	181	355	java/lang/Exception
    //   191	214	355	java/lang/Exception
    //   217	241	355	java/lang/Exception
    //   245	278	355	java/lang/Exception
    //   281	297	355	java/lang/Exception
    //   300	316	355	java/lang/Exception
    //   316	354	355	java/lang/Exception
    //   181	187	389	java/lang/Exception
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onScannerPause");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Integer.valueOf(291));
    if (this.c)
    {
      Process.setThreadPriority(0);
      e();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQRScanConst_VoiceScan", 2, "onDestroy");
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_b_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler;
    if (localObject != null)
    {
      ((ChirpSoHandler)localObject).b(this);
      this.jdField_a_of_type_ComTencentMobileqqQrscanEarlydownChirpSoHandler = null;
    }
    localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      label105:
      e();
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      break label105;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 294: 
    default: 
      return true;
    case 295: 
      ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).speak(jdField_a_of_type_JavaLangString);
      return true;
    case 293: 
      d();
      return true;
    case 292: 
      this.c = a();
      this.d = true;
      if (this.c)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(291);
        return true;
      }
      break;
    case 291: 
      if (this.jdField_b_of_type_AndroidOsHandler != null)
      {
        Process.setThreadPriority(-19);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(293);
      }
      break;
    }
    return true;
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Handler localHandler = this.jdField_b_of_type_AndroidOsHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(293);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.VoiceScan
 * JD-Core Version:    0.7.0.1
 */