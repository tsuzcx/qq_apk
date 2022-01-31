package dov.com.tencent.mobileqq.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.text.TextUtils;
import bnno;
import bnom;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import wxe;

@TargetApi(16)
public class AudioDecoder
{
  public bnno a;
  private AudioDecoder.AudioPlayRunnable jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
  private AudioDecoder.BgmAudioPlayRunnable jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
  private Thread jdField_a_of_type_JavaLangThread;
  private Thread b;
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int i;
    switch (this.jdField_a_of_type_Bnno.jdField_a_of_type_Int)
    {
    default: 
      if (!this.jdField_a_of_type_Bnno.jdField_b_of_type_Boolean) {
        paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
      }
      paramInt = 1;
      paramArrayOfByte = null;
      i = 0;
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Bnno.jdField_b_of_type_Boolean) && (paramInt == 0) && (paramArrayOfByte != null)) {
        paramAudioTrack.write(paramArrayOfByte, 0, i);
      }
      return;
      i = paramArrayOfByte.length / 2;
      byte[] arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2;
      arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i, 2);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 2 / 3;
      arrayOfByte = new byte[i];
      bnom.b(paramArrayOfByte, 0, arrayOfByte, i);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
      continue;
      i = paramArrayOfByte.length * 4;
      arrayOfByte = new byte[i];
      bnom.a(paramArrayOfByte, 0, arrayOfByte, i, 4);
      paramArrayOfByte = arrayOfByte;
      paramInt = 0;
    }
  }
  
  /* Error */
  public static void a(java.lang.String paramString1, long paramLong, java.lang.String paramString2)
  {
    // Byte code:
    //   0: new 2	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder
    //   3: dup
    //   4: invokespecial 54	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: new 23	bnno
    //   14: dup
    //   15: invokespecial 55	bnno:<init>	()V
    //   18: putfield 21	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_Bnno	Lbnno;
    //   21: aload 4
    //   23: getfield 21	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_Bnno	Lbnno;
    //   26: aload_0
    //   27: putfield 58	bnno:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload 4
    //   32: getfield 21	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_Bnno	Lbnno;
    //   35: aload_0
    //   36: aconst_null
    //   37: iconst_0
    //   38: invokestatic 63	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lazjw;
    //   41: putfield 66	bnno:jdField_a_of_type_Azjw	Lazjw;
    //   44: aload 4
    //   46: getfield 21	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:jdField_a_of_type_Bnno	Lbnno;
    //   49: lload_1
    //   50: putfield 70	bnno:c	J
    //   53: aload_3
    //   54: invokestatic 75	bdhb:c	(Ljava/lang/String;)V
    //   57: new 77	java/io/FileOutputStream
    //   60: dup
    //   61: aload_3
    //   62: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore_3
    //   66: aload_3
    //   67: astore_0
    //   68: aload 4
    //   70: invokevirtual 82	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	()[B
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +11 -> 88
    //   80: aload_3
    //   81: astore_0
    //   82: aload_3
    //   83: aload 4
    //   85: invokevirtual 85	java/io/FileOutputStream:write	([B)V
    //   88: aload_3
    //   89: ifnull +7 -> 96
    //   92: aload_3
    //   93: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   96: return
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   102: return
    //   103: astore 4
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_3
    //   108: astore_0
    //   109: aload 4
    //   111: invokevirtual 92	java/io/FileNotFoundException:printStackTrace	()V
    //   114: aload_3
    //   115: ifnull -19 -> 96
    //   118: aload_3
    //   119: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   122: return
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   128: return
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: astore_0
    //   135: aload 4
    //   137: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   140: aload_3
    //   141: ifnull -45 -> 96
    //   144: aload_3
    //   145: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   148: return
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   154: return
    //   155: astore_3
    //   156: aconst_null
    //   157: astore_0
    //   158: aload_0
    //   159: ifnull +7 -> 166
    //   162: aload_0
    //   163: invokevirtual 88	java/io/FileOutputStream:close	()V
    //   166: aload_3
    //   167: athrow
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 91	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_3
    //   177: goto -19 -> 158
    //   180: astore 4
    //   182: goto -49 -> 133
    //   185: astore 4
    //   187: goto -80 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString1	java.lang.String
    //   0	190	1	paramLong	long
    //   0	190	3	paramString2	java.lang.String
    //   7	77	4	localObject	Object
    //   103	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   129	7	4	localIOException1	java.io.IOException
    //   180	1	4	localIOException2	java.io.IOException
    //   185	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   92	96	97	java/io/IOException
    //   57	66	103	java/io/FileNotFoundException
    //   118	122	123	java/io/IOException
    //   57	66	129	java/io/IOException
    //   144	148	149	java/io/IOException
    //   57	66	155	finally
    //   162	166	168	java/io/IOException
    //   68	75	176	finally
    //   82	88	176	finally
    //   109	114	176	finally
    //   135	140	176	finally
    //   68	75	180	java/io/IOException
    //   82	88	180	java/io/IOException
    //   68	75	185	java/io/FileNotFoundException
    //   82	88	185	java/io/FileNotFoundException
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a();
      QLog.d("AudioDecoder", 4, "repeat");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.c();
      QLog.d("AudioDecoder", 4, " bgm repeat");
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bnno != null)
    {
      this.jdField_a_of_type_Bnno.jdField_a_of_type_Int = paramInt;
      QLog.d("AudioDecoder", 4, "setSpeedType:" + paramInt);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a(paramLong, this.jdField_a_of_type_Bnno.c);
      QLog.d("AudioDecoder", 1, new Object[] { "seekTo: ", Long.valueOf(paramLong) });
      return;
    }
    QLog.d("AudioDecoder", 4, "seekTo failed: " + paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnno == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == this.jdField_a_of_type_Bnno.jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_Bnno.jdField_b_of_type_Long))
    {
      wxe.d("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    QLog.d("AudioDecoder", 4, "setPlayRange begin startTimeMs=" + paramLong1 + " endTimeMs=" + paramLong2);
    this.jdField_a_of_type_Bnno.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Bnno.jdField_b_of_type_Long = paramLong2;
    a(this.jdField_a_of_type_Bnno);
  }
  
  public void a(bnno parambnno)
  {
    for (;;)
    {
      float f2;
      float f3;
      float f1;
      try
      {
        QLog.d("AudioDecoder", 4, "startPlay " + parambnno.toString());
        c();
        b();
        if (this.jdField_a_of_type_Bnno == null) {
          this.jdField_a_of_type_Bnno = new bnno();
        }
        this.jdField_a_of_type_Bnno.a(parambnno);
        if (this.jdField_a_of_type_Bnno.jdField_b_of_type_Long == 0L) {
          this.jdField_a_of_type_Bnno.jdField_b_of_type_Long = this.jdField_a_of_type_Bnno.c;
        }
        f2 = (float)this.jdField_a_of_type_Bnno.jdField_a_of_type_Long / (float)this.jdField_a_of_type_Bnno.c;
        f3 = (float)this.jdField_a_of_type_Bnno.jdField_b_of_type_Long / (float)this.jdField_a_of_type_Bnno.c;
        f1 = f2;
        if (f2 >= 0.0F) {
          break label228;
        }
        f1 = 0.0F;
      }
      finally {}
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable = new AudioDecoder.AudioPlayRunnable(this, f1, f2);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable, "AudioPlay", 8);
      this.jdField_a_of_type_JavaLangThread.start();
      if (!TextUtils.isEmpty(parambnno.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable = new AudioDecoder.BgmAudioPlayRunnable(this);
        this.b = ThreadManager.newFreeThread(this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable, "BgmPlay", 8);
        this.b.start();
      }
      return;
      label228:
      if (f3 != 0.0F)
      {
        f2 = f3;
        if (f3 <= 1.0F) {}
      }
      else
      {
        f2 = 1.0F;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bnno == null) {
      return;
    }
    QLog.d("AudioDecoder", 1, "setMuteAudio: " + paramBoolean);
    this.jdField_a_of_type_Bnno.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public byte[] a()
  {
    return AudioDecoder.AudioPlayRunnable.a(new AudioDecoder.AudioPlayRunnable(this, 0.0F, 1.0F), this.jdField_a_of_type_Bnno.jdField_a_of_type_JavaLangString, false);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a = true;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
    if (this.b != null)
    {
      this.b.interrupt();
      this.b = null;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.d();
      }
      QLog.d("AudioDecoder", 4, "bgm stopAudio");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.b();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.a();
      QLog.d("AudioDecoder", 4, "bgm pausePlay");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$AudioPlayRunnable.c();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable != null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable.b();
      QLog.d("AudioDecoder", 4, "bgm resumePlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */