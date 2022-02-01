import android.os.Environment;
import com.qq.wx.voice.embedqqegg.recognizer.SDKVersion;
import com.qq.wx.voice.embedqqegg.recognizer.VoiceRecognizer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.recog.AVVoiceRecog.1;
import com.tencent.av.recog.AVVoiceRecog.2;
import com.tencent.av.so.DownloadInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.os.MqqHandler;

public class ltr
  implements moq
{
  private static volatile ltr jdField_a_of_type_Ltr;
  public int a;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new AVVoiceRecog.1(this);
  String jdField_a_of_type_JavaLangString = a();
  private lts jdField_a_of_type_Lts;
  private ltt jdField_a_of_type_Ltt = new ltt(this);
  private boolean jdField_a_of_type_Boolean;
  public int b;
  Runnable jdField_b_of_type_JavaLangRunnable = new AVVoiceRecog.2(this);
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private boolean c;
  public int d;
  private int e = 1;
  
  public ltr()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  private String a()
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
    return "audiodata" + str + ".pcm";
  }
  
  public static ltr a()
  {
    if (jdField_a_of_type_Ltr == null) {}
    try
    {
      if (jdField_a_of_type_Ltr == null) {
        jdField_a_of_type_Ltr = new ltr();
      }
      return jdField_a_of_type_Ltr;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    VideoController.a().b(0, false);
    QLog.w("AVVoiceRecog", 1, "pauseContinue, oldReasons[" + paramInt1 + "], reason[" + paramInt2 + "]");
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 126	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: new 126	java/io/File
    //   13: dup
    //   14: new 74	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   21: aload_1
    //   22: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload 4
    //   38: invokevirtual 131	java/io/File:exists	()Z
    //   41: ifne +9 -> 50
    //   44: aload 4
    //   46: invokevirtual 134	java/io/File:mkdirs	()Z
    //   49: pop
    //   50: aload_1
    //   51: invokevirtual 131	java/io/File:exists	()Z
    //   54: ifne +8 -> 62
    //   57: aload_1
    //   58: invokevirtual 137	java/io/File:createNewFile	()Z
    //   61: pop
    //   62: new 139	java/io/FileOutputStream
    //   65: dup
    //   66: aload_1
    //   67: iconst_1
    //   68: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   71: astore_2
    //   72: aload_3
    //   73: ifnull +10 -> 83
    //   76: aload_2
    //   77: astore_1
    //   78: aload_2
    //   79: aload_3
    //   80: invokevirtual 146	java/io/FileOutputStream:write	([B)V
    //   83: aload_2
    //   84: astore_1
    //   85: aload_2
    //   86: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   97: return
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   103: goto -41 -> 62
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   111: return
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 156	java/io/FileNotFoundException:printStackTrace	()V
    //   121: aload_2
    //   122: ifnull -25 -> 97
    //   125: aload_2
    //   126: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   129: return
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   135: return
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: aload_3
    //   142: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   145: aload_2
    //   146: ifnull -49 -> 97
    //   149: aload_2
    //   150: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   159: return
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +7 -> 171
    //   167: aload_1
    //   168: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   171: aload_2
    //   172: athrow
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_2
    //   182: goto -19 -> 163
    //   185: astore_3
    //   186: goto -47 -> 139
    //   189: astore_3
    //   190: goto -75 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ltr
    //   0	193	1	paramString1	String
    //   0	193	2	paramString2	String
    //   0	193	3	paramArrayOfByte	byte[]
    //   8	37	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   57	62	98	java/io/IOException
    //   93	97	106	java/io/IOException
    //   62	72	112	java/io/FileNotFoundException
    //   125	129	130	java/io/IOException
    //   62	72	136	java/io/IOException
    //   149	153	154	java/io/IOException
    //   62	72	160	finally
    //   167	171	173	java/io/IOException
    //   78	83	181	finally
    //   85	89	181	finally
    //   117	121	181	finally
    //   141	145	181	finally
    //   78	83	185	java/io/IOException
    //   85	89	185	java/io/IOException
    //   78	83	189	java/io/FileNotFoundException
    //   85	89	189	java/io/FileNotFoundException
  }
  
  private static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    return ((lih)paramVideoAppInterface.a(5)).a(3, "normal");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    a().c();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      QLog.w("AVVoiceRecog", 1, "resumeContinue failed, !mIsInitAndStart, mPauseReason[" + this.e + "], reason[" + paramInt2 + "]");
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    int i = VideoController.a().a(0, false);
    int j = VideoController.a().a(0, 16000, 1, 16);
    VideoController.a().a(1, this);
    QLog.w("AVVoiceRecog", 1, "resumeContinue, oldReasons[" + paramInt1 + "], mPauseReason[" + this.e + "], reason[" + paramInt2 + "], mIsPause[" + this.jdField_c_of_type_Boolean + "], regret[" + i + "], setret[" + j + "]");
  }
  
  public static boolean b()
  {
    return maj.a(mac.a().a()) == 1;
  }
  
  private boolean d()
  {
    VoiceRecognizer.shareInstance().setListener(this.jdField_a_of_type_Ltt);
    if (this.jdField_a_of_type_Boolean)
    {
      VoiceRecognizer.shareInstance().setOpenLogCat(true);
      VoiceRecognizer.shareInstance().setSaveVoice(true);
    }
    VoiceRecognizer.shareInstance().setContReco(true);
    DownloadInfo localDownloadInfo = mac.a().a();
    if (localDownloadInfo == null)
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. downloadInfo == null.");
      return false;
    }
    String str1 = maj.b() + localDownloadInfo.filename_so_wxvoiceembedqqegg;
    String str2 = maj.a() + localDownloadInfo.filename_model_wxvoiceembed;
    if (!mac.a().a())
    {
      mac.a().b();
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. soFile or modelFile no exist. soFullName = " + str1 + ", modelFullName = " + str2);
      return false;
    }
    int k = localDownloadInfo.thre;
    VoiceRecognizer.shareInstance().setWakeupThres(k);
    int i = -1;
    try
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. soFullName = " + str1 + ", modelFullName = " + str2);
      bool = SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getApplication().getApplicationContext(), "c++_shared");
      if (bool) {
        break label326;
      }
      try
      {
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool);
        return false;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      for (;;)
      {
        label326:
        int j;
        SDKVersion localSDKVersion;
        boolean bool = false;
      }
    }
    QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool + ", ret2 = " + i + ", err = " + localUnsatisfiedLinkError1.getMessage());
    return false;
    j = VoiceRecognizer.shareInstance().init(BaseApplicationImpl.getApplication().getApplicationContext(), str1, str2);
    i = j;
    QLog.i("AVVoiceRecog", 1, "VoiceRecog. init. ret1 = " + bool + ", ret2 = " + j + ", thre = " + k);
    if ((!bool) || (j < 0))
    {
      i = j;
      QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. ret1 = " + bool + ", ret2 = " + j);
      return false;
    }
    localSDKVersion = new SDKVersion();
    i = VoiceRecognizer.shareInstance().getVersion(localSDKVersion);
    if (i < 0)
    {
      QLog.i("AVVoiceRecog", 1, "initRecognizer. getVersion failed. ret = " + i);
      return false;
    }
    QLog.i("AVVoiceRecog", 1, "initRecognizer OK. soVer = " + localSDKVersion.soVer + ", binVer = " + localSDKVersion.binVer);
    return true;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    VideoController.a().b(0, false);
    VideoController.a().a(1, null);
    VoiceRecognizer.shareInstance().cancel();
    VoiceRecognizer.shareInstance().destroy();
    this.jdField_b_of_type_Boolean = false;
    QLog.i("AVVoiceRecog", 1, "stopAndUninit OK.");
  }
  
  public void a(int paramInt)
  {
    this.e |= paramInt;
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      int i = this.e;
      this.jdField_a_of_type_Int = i;
      this.jdField_b_of_type_Int = paramInt;
      if (this.e != i) {
        QLog.w("AVVoiceRecog", 1, "pause, reason[" + paramInt + "], mPauseReason[" + i + "->" + this.e + "]");
      }
    } while (this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, lts paramlts)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lts = paramlts;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((QLog.isColorLevel()) || (!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      QLog.w("AVVoiceRecog", 1, "onReceiveAudioFrame, srcType[" + paramInt1 + "], size[" + paramInt2 + "]");
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      a(Environment.getExternalStorageDirectory().getPath() + File.separator + "audiodata" + File.separator, this.jdField_a_of_type_JavaLangString, paramArrayOfByte);
    }
    VoiceRecognizer.shareInstance().appendData(paramArrayOfByte, 0, paramInt2, false);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (this.e != paramInt) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    int i = this.e;
    this.jdField_c_of_type_Int = i;
    this.d = paramInt;
    this.e &= (paramInt ^ 0xFFFFFFFF);
    QLog.w("AVVoiceRecog", 1, "resume, reason[" + paramInt + "], mIsPause[" + this.jdField_c_of_type_Boolean + "], mPauseReason[" + i + "->" + this.e + "]");
    if (this.e == 0)
    {
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandler().post(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_Boolean;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return this.jdField_b_of_type_Boolean;
    }
    if (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. not DeviceSupport.");
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    Object localObject = mac.a().a();
    QLog.i("AVVoiceRecog", 1, "initAndStart. downloadInfo = " + localObject);
    if (localObject == null)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. downloadInfo == null.");
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    if (!b())
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. not EnableFromConfig.");
      String str = maj.b() + ((DownloadInfo)localObject).filename_so_wxvoiceembedqqegg;
      localObject = maj.a() + ((DownloadInfo)localObject).filename_model_wxvoiceembed;
      if (!mac.a().a())
      {
        mac.a().b();
        QLog.i("AVVoiceRecog", 1, "initRecognizer. init failed. soFile or modelFile no exist. soFullName = " + str + ", modelFullName = " + (String)localObject);
      }
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    boolean bool = d();
    if (!bool)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. initRecognizer failed. initret = " + bool);
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    VoiceRecognizer.shareInstance().setKeywordSetIndex(0);
    int i = VoiceRecognizer.shareInstance().startReceiving();
    if (i < 0)
    {
      QLog.i("AVVoiceRecog", 1, "initAndStart. startReceiving failed. ret = " + i);
      this.jdField_b_of_type_Boolean = false;
      return false;
    }
    QLog.i("AVVoiceRecog", 1, "initAndStart OK.");
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ltr
 * JD-Core Version:    0.7.0.1
 */