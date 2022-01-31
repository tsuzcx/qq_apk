import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class qyd
{
  public static final String a;
  private static qyd jdField_a_of_type_Qyd;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private SocializeFeedsInfo.UGCVoiceInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyVoicePlayController.3(this);
  private WeakReference<qyg> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = qyd.class.getSimpleName();
  }
  
  public static qyd a()
  {
    if (jdField_a_of_type_Qyd == null) {}
    try
    {
      if (jdField_a_of_type_Qyd == null) {
        jdField_a_of_type_Qyd = new qyd();
      }
      return jdField_a_of_type_Qyd;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          qyg localqyg = (qyg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localqyg != null)
          {
            localqyg.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo);
            a(false, "ugc voice play");
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(qyg paramqyg, SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    a();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramqyg);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo = paramUGCVoiceInfo;
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new qye(this));
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new qyf(this));
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUGCVoiceInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramqyg)
    {
      paramqyg.printStackTrace();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 85	qyd:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 42	qyd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: ifnull +81 -> 92
    //   14: aload_0
    //   15: getfield 49	qyd:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   18: ifnull +74 -> 92
    //   21: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +38 -> 62
    //   27: getstatic 25	qyd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: iconst_2
    //   31: new 160	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   38: ldc 163
    //   40: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 170	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc 172
    //   49: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 42	qyd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   66: aload_0
    //   67: getfield 49	qyd:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   70: invokevirtual 183	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   73: aload_0
    //   74: getfield 85	qyd:jdField_a_of_type_Boolean	Z
    //   77: ifeq +18 -> 95
    //   80: aload_0
    //   81: getfield 42	qyd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   84: aload_0
    //   85: getfield 49	qyd:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   88: invokevirtual 187	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   91: pop
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aload_0
    //   96: getfield 42	qyd:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 49	qyd:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   103: ldc2_w 188
    //   106: invokevirtual 193	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   109: pop
    //   110: goto -18 -> 92
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	qyd
    //   0	118	1	paramBoolean	boolean
    //   0	118	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	62	113	finally
    //   62	92	113	finally
    //   95	110	113	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qyd
 * JD-Core Version:    0.7.0.1
 */