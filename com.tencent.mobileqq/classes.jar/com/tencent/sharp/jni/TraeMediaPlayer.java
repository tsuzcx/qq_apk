package com.tencent.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TraeMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int d = -1;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 2) || (this.d == -1)) {
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay volumeUndo _prevVolume:" + this.d);
      }
      ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio")).setStreamVolume(this.jdField_b_of_type_Int, this.d, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Deprecated
  public void a()
  {
    a("other");
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("stopRing[").append(paramString).append("], mMediaPlay[");
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeMediaPlay", 1, bool + "]");
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    catch (Exception paramString)
    {
      label124:
      break label124;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.jdField_c_of_type_Int = -1;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @Deprecated
  public boolean a(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    return a("other", paramInt1, paramInt2, paramUri, paramString, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, paramInt4);
  }
  
  /* Error */
  public boolean a(String paramString1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/mobileqq/utils/AudioHelper:a	()J
    //   3: lstore 12
    //   5: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +142 -> 150
    //   11: ldc 101
    //   13: iconst_1
    //   14: new 55	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   21: ldc 153
    //   23: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 155
    //   32: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload 12
    //   37: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   40: ldc 160
    //   42: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_2
    //   46: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc 162
    //   51: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_3
    //   55: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: ldc 164
    //   60: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 4
    //   65: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc 169
    //   70: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload 5
    //   75: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 171
    //   80: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: iload 6
    //   85: invokevirtual 104	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: ldc 173
    //   90: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload 7
    //   95: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 175
    //   100: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: iload 8
    //   105: invokevirtual 104	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   108: ldc 177
    //   110: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 9
    //   115: invokevirtual 104	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   118: ldc 179
    //   120: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 10
    //   125: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: ldc 181
    //   130: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: getstatic 186	com/tencent/common/config/AppSetting:b	Ljava/lang/String;
    //   136: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 106
    //   141: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 109	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload 6
    //   152: ifne +10 -> 162
    //   155: iload 7
    //   157: ifgt +5 -> 162
    //   160: iconst_0
    //   161: ireturn
    //   162: aload_0
    //   163: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   166: ifnull +31 -> 197
    //   169: aload_0
    //   170: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   173: invokevirtual 114	android/media/MediaPlayer:isPlaying	()Z
    //   176: istore 11
    //   178: iload 11
    //   180: ifeq +5 -> 185
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   189: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   192: aload_0
    //   193: aconst_null
    //   194: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   197: aload_0
    //   198: getfield 122	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   201: ifnull +20 -> 221
    //   204: aload_0
    //   205: getfield 122	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   208: invokevirtual 127	java/util/Timer:cancel	()V
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 122	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   216: aload_0
    //   217: aconst_null
    //   218: putfield 129	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   221: aload_0
    //   222: getfield 36	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   225: ldc 75
    //   227: invokevirtual 81	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   230: checkcast 83	android/media/AudioManager
    //   233: astore 14
    //   235: aload_0
    //   236: new 111	android/media/MediaPlayer
    //   239: dup
    //   240: invokespecial 187	android/media/MediaPlayer:<init>	()V
    //   243: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   246: aload_0
    //   247: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   250: ifnonnull +195 -> 445
    //   253: aload_0
    //   254: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   257: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   265: iconst_0
    //   266: ireturn
    //   267: astore_1
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   273: goto -76 -> 197
    //   276: astore_1
    //   277: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +43 -> 323
    //   283: ldc 53
    //   285: iconst_2
    //   286: new 55	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   293: ldc 189
    //   295: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 192	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   302: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 194
    //   307: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 197	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_0
    //   324: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   327: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   330: aload_0
    //   331: aconst_null
    //   332: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_1
    //   338: aload_0
    //   339: aconst_null
    //   340: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq -26 -> 323
    //   352: ldc 53
    //   354: iconst_2
    //   355: new 55	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   362: ldc 201
    //   364: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_1
    //   368: invokevirtual 202	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   371: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: ldc 194
    //   376: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_1
    //   380: invokevirtual 203	java/io/IOException:getMessage	()Ljava/lang/String;
    //   383: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: goto -69 -> 323
    //   395: astore_1
    //   396: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -76 -> 323
    //   402: ldc 53
    //   404: iconst_2
    //   405: new 55	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   412: ldc 205
    //   414: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 206	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   421: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc 194
    //   426: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_1
    //   430: invokevirtual 207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   433: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: goto -119 -> 323
    //   445: aload_0
    //   446: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   449: aload_0
    //   450: invokevirtual 211	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   453: aload_0
    //   454: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   457: aload_0
    //   458: invokevirtual 215	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   461: iload_2
    //   462: tableswitch	default:+678 -> 1140, 0:+49->511, 1:+296->758, 2:+312->774
    //   489: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   492: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   495: aload_0
    //   496: aconst_null
    //   497: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   500: aload_0
    //   501: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   504: astore_1
    //   505: aload_1
    //   506: ifnonnull +280 -> 786
    //   509: iconst_0
    //   510: ireturn
    //   511: aconst_null
    //   512: astore 4
    //   514: aload_0
    //   515: getfield 36	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   518: invokevirtual 219	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   521: iload_3
    //   522: invokevirtual 225	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   525: astore_1
    //   526: aload_0
    //   527: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   530: aload_1
    //   531: invokevirtual 231	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   534: aload_1
    //   535: invokevirtual 234	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   538: aload_1
    //   539: invokevirtual 237	android/content/res/AssetFileDescriptor:getLength	()J
    //   542: invokevirtual 241	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   545: aload_1
    //   546: ifnull +60 -> 606
    //   549: aload_1
    //   550: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   553: goto -53 -> 500
    //   556: astore_1
    //   557: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq -237 -> 323
    //   563: ldc 53
    //   565: iconst_2
    //   566: new 55	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   573: ldc 246
    //   575: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: invokevirtual 247	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   582: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: ldc 194
    //   587: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_1
    //   591: invokevirtual 248	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: goto -280 -> 323
    //   606: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq +28 -> 637
    //   612: ldc 53
    //   614: iconst_2
    //   615: new 55	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   622: ldc 250
    //   624: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: iload_3
    //   628: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_0
    //   638: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   641: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   644: aload_0
    //   645: aconst_null
    //   646: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   649: iconst_0
    //   650: ireturn
    //   651: aload 4
    //   653: ifnull +60 -> 713
    //   656: aload 4
    //   658: invokevirtual 244	android/content/res/AssetFileDescriptor:close	()V
    //   661: aload_1
    //   662: athrow
    //   663: astore_1
    //   664: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   667: ifeq -344 -> 323
    //   670: ldc 53
    //   672: iconst_2
    //   673: new 55	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   680: ldc 252
    //   682: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 253	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   689: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc 194
    //   694: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_1
    //   698: invokevirtual 254	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   701: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: goto -387 -> 323
    //   713: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +28 -> 744
    //   719: ldc 53
    //   721: iconst_2
    //   722: new 55	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   729: ldc 250
    //   731: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: iload_3
    //   735: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: aload_0
    //   745: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   748: invokevirtual 132	android/media/MediaPlayer:release	()V
    //   751: aload_0
    //   752: aconst_null
    //   753: putfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   756: iconst_0
    //   757: ireturn
    //   758: aload_0
    //   759: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   762: aload_0
    //   763: getfield 36	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   766: aload 4
    //   768: invokevirtual 257	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   771: goto -271 -> 500
    //   774: aload_0
    //   775: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   778: aload 5
    //   780: invokevirtual 259	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   783: goto -283 -> 500
    //   786: aload_0
    //   787: iload 8
    //   789: putfield 32	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   792: iconst_0
    //   793: istore_2
    //   794: aload_0
    //   795: getfield 32	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   798: ifeq +245 -> 1043
    //   801: aload_0
    //   802: iconst_2
    //   803: putfield 26	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Int	I
    //   806: iconst_1
    //   807: istore_2
    //   808: aload_0
    //   809: iload 9
    //   811: putfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Boolean	Z
    //   814: aload_0
    //   815: getfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Boolean	Z
    //   818: ifeq +9 -> 827
    //   821: aload_0
    //   822: iload 10
    //   824: putfield 26	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Int	I
    //   827: aload_0
    //   828: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   831: aload_0
    //   832: getfield 26	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Int	I
    //   835: invokevirtual 263	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   838: aload_0
    //   839: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   842: invokevirtual 266	android/media/MediaPlayer:prepare	()V
    //   845: aload_0
    //   846: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   849: iload 6
    //   851: invokevirtual 270	android/media/MediaPlayer:setLooping	(Z)V
    //   854: aload_0
    //   855: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   858: invokevirtual 273	android/media/MediaPlayer:start	()V
    //   861: aload_0
    //   862: iload 6
    //   864: putfield 275	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Boolean	Z
    //   867: aload_0
    //   868: getfield 275	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Boolean	Z
    //   871: iconst_1
    //   872: if_icmpne +228 -> 1100
    //   875: aload_0
    //   876: iconst_1
    //   877: putfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   880: aload_0
    //   881: iconst_m1
    //   882: putfield 28	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Int	I
    //   885: aload_0
    //   886: aload_0
    //   887: getfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   890: iconst_1
    //   891: isub
    //   892: putfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   895: aload_0
    //   896: getfield 134	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Boolean	Z
    //   899: ifne +9 -> 908
    //   902: aload 14
    //   904: iload_2
    //   905: invokevirtual 278	android/media/AudioManager:setMode	(I)V
    //   908: aload_0
    //   909: getfield 28	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Int	I
    //   912: ifle +48 -> 960
    //   915: aload_0
    //   916: new 124	java/util/Timer
    //   919: dup
    //   920: invokespecial 279	java/util/Timer:<init>	()V
    //   923: putfield 122	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   926: aload_0
    //   927: new 281	alzd
    //   930: dup
    //   931: aload_0
    //   932: lload 12
    //   934: invokespecial 284	alzd:<init>	(Lcom/tencent/sharp/jni/TraeMediaPlayer;J)V
    //   937: putfield 129	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   940: aload_0
    //   941: getfield 122	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   944: aload_0
    //   945: getfield 129	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   948: aload_0
    //   949: getfield 28	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Int	I
    //   952: sipush 1000
    //   955: iadd
    //   956: i2l
    //   957: invokevirtual 288	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   960: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   963: ifeq +184 -> 1147
    //   966: ldc 101
    //   968: iconst_1
    //   969: new 55	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 290
    //   979: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: lload 12
    //   984: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   987: ldc_w 292
    //   990: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload_0
    //   994: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   997: invokevirtual 295	android/media/MediaPlayer:getDuration	()I
    //   1000: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1003: ldc_w 297
    //   1006: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_0
    //   1010: getfield 28	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Int	I
    //   1013: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1016: ldc_w 299
    //   1019: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: aload_0
    //   1023: getfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   1026: invokevirtual 65	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1029: ldc 106
    //   1031: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 109	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: goto +107 -> 1147
    //   1043: getstatic 304	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1046: ldc_w 306
    //   1049: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1052: ifeq +30 -> 1082
    //   1055: getstatic 315	android/os/Build:MODEL	Ljava/lang/String;
    //   1058: ldc_w 317
    //   1061: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1064: ifeq +18 -> 1082
    //   1067: iload 9
    //   1069: ifne +13 -> 1082
    //   1072: aload_0
    //   1073: iconst_2
    //   1074: putfield 26	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Int	I
    //   1077: iconst_2
    //   1078: istore_2
    //   1079: goto -271 -> 808
    //   1082: aload_0
    //   1083: iconst_0
    //   1084: putfield 26	com/tencent/sharp/jni/TraeMediaPlayer:jdField_b_of_type_Int	I
    //   1087: getstatic 322	android/os/Build$VERSION:SDK_INT	I
    //   1090: bipush 11
    //   1092: if_icmplt -284 -> 808
    //   1095: iconst_3
    //   1096: istore_2
    //   1097: goto -289 -> 808
    //   1100: aload_0
    //   1101: iload 7
    //   1103: putfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   1106: aload_0
    //   1107: aload_0
    //   1108: getfield 30	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Int	I
    //   1111: aload_0
    //   1112: getfield 42	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1115: invokevirtual 295	android/media/MediaPlayer:getDuration	()I
    //   1118: imul
    //   1119: putfield 28	com/tencent/sharp/jni/TraeMediaPlayer:jdField_c_of_type_Int	I
    //   1122: goto -237 -> 885
    //   1125: astore_1
    //   1126: goto -796 -> 330
    //   1129: astore 5
    //   1131: aload_1
    //   1132: astore 4
    //   1134: aload 5
    //   1136: astore_1
    //   1137: goto -486 -> 651
    //   1140: goto -652 -> 488
    //   1143: astore_1
    //   1144: goto -493 -> 651
    //   1147: iconst_1
    //   1148: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1149	0	this	TraeMediaPlayer
    //   0	1149	1	paramString1	String
    //   0	1149	2	paramInt1	int
    //   0	1149	3	paramInt2	int
    //   0	1149	4	paramUri	Uri
    //   0	1149	5	paramString2	String
    //   0	1149	6	paramBoolean1	boolean
    //   0	1149	7	paramInt3	int
    //   0	1149	8	paramBoolean2	boolean
    //   0	1149	9	paramBoolean3	boolean
    //   0	1149	10	paramInt4	int
    //   176	3	11	bool	boolean
    //   3	980	12	l	long
    //   233	670	14	localAudioManager	AudioManager
    // Exception table:
    //   from	to	target	type
    //   185	192	267	java/lang/Exception
    //   162	178	276	java/lang/IllegalStateException
    //   192	197	276	java/lang/IllegalStateException
    //   197	221	276	java/lang/IllegalStateException
    //   221	265	276	java/lang/IllegalStateException
    //   268	273	276	java/lang/IllegalStateException
    //   338	345	276	java/lang/IllegalStateException
    //   445	461	276	java/lang/IllegalStateException
    //   488	500	276	java/lang/IllegalStateException
    //   500	505	276	java/lang/IllegalStateException
    //   549	553	276	java/lang/IllegalStateException
    //   606	637	276	java/lang/IllegalStateException
    //   637	649	276	java/lang/IllegalStateException
    //   656	663	276	java/lang/IllegalStateException
    //   713	744	276	java/lang/IllegalStateException
    //   744	756	276	java/lang/IllegalStateException
    //   758	771	276	java/lang/IllegalStateException
    //   774	783	276	java/lang/IllegalStateException
    //   786	792	276	java/lang/IllegalStateException
    //   794	806	276	java/lang/IllegalStateException
    //   808	827	276	java/lang/IllegalStateException
    //   827	885	276	java/lang/IllegalStateException
    //   885	908	276	java/lang/IllegalStateException
    //   908	960	276	java/lang/IllegalStateException
    //   960	1040	276	java/lang/IllegalStateException
    //   1043	1067	276	java/lang/IllegalStateException
    //   1072	1077	276	java/lang/IllegalStateException
    //   1082	1087	276	java/lang/IllegalStateException
    //   1087	1095	276	java/lang/IllegalStateException
    //   1100	1122	276	java/lang/IllegalStateException
    //   185	192	337	finally
    //   162	178	345	java/io/IOException
    //   192	197	345	java/io/IOException
    //   197	221	345	java/io/IOException
    //   221	265	345	java/io/IOException
    //   268	273	345	java/io/IOException
    //   338	345	345	java/io/IOException
    //   445	461	345	java/io/IOException
    //   488	500	345	java/io/IOException
    //   500	505	345	java/io/IOException
    //   549	553	345	java/io/IOException
    //   606	637	345	java/io/IOException
    //   637	649	345	java/io/IOException
    //   656	663	345	java/io/IOException
    //   713	744	345	java/io/IOException
    //   744	756	345	java/io/IOException
    //   758	771	345	java/io/IOException
    //   774	783	345	java/io/IOException
    //   786	792	345	java/io/IOException
    //   794	806	345	java/io/IOException
    //   808	827	345	java/io/IOException
    //   827	885	345	java/io/IOException
    //   885	908	345	java/io/IOException
    //   908	960	345	java/io/IOException
    //   960	1040	345	java/io/IOException
    //   1043	1067	345	java/io/IOException
    //   1072	1077	345	java/io/IOException
    //   1082	1087	345	java/io/IOException
    //   1087	1095	345	java/io/IOException
    //   1100	1122	345	java/io/IOException
    //   162	178	395	java/lang/Exception
    //   192	197	395	java/lang/Exception
    //   197	221	395	java/lang/Exception
    //   221	265	395	java/lang/Exception
    //   268	273	395	java/lang/Exception
    //   277	323	395	java/lang/Exception
    //   338	345	395	java/lang/Exception
    //   346	392	395	java/lang/Exception
    //   445	461	395	java/lang/Exception
    //   488	500	395	java/lang/Exception
    //   500	505	395	java/lang/Exception
    //   549	553	395	java/lang/Exception
    //   557	603	395	java/lang/Exception
    //   606	637	395	java/lang/Exception
    //   637	649	395	java/lang/Exception
    //   656	663	395	java/lang/Exception
    //   664	710	395	java/lang/Exception
    //   713	744	395	java/lang/Exception
    //   744	756	395	java/lang/Exception
    //   758	771	395	java/lang/Exception
    //   774	783	395	java/lang/Exception
    //   786	792	395	java/lang/Exception
    //   794	806	395	java/lang/Exception
    //   808	827	395	java/lang/Exception
    //   827	885	395	java/lang/Exception
    //   885	908	395	java/lang/Exception
    //   908	960	395	java/lang/Exception
    //   960	1040	395	java/lang/Exception
    //   1043	1067	395	java/lang/Exception
    //   1072	1077	395	java/lang/Exception
    //   1082	1087	395	java/lang/Exception
    //   1087	1095	395	java/lang/Exception
    //   1100	1122	395	java/lang/Exception
    //   162	178	556	java/lang/IllegalArgumentException
    //   192	197	556	java/lang/IllegalArgumentException
    //   197	221	556	java/lang/IllegalArgumentException
    //   221	265	556	java/lang/IllegalArgumentException
    //   268	273	556	java/lang/IllegalArgumentException
    //   338	345	556	java/lang/IllegalArgumentException
    //   445	461	556	java/lang/IllegalArgumentException
    //   488	500	556	java/lang/IllegalArgumentException
    //   500	505	556	java/lang/IllegalArgumentException
    //   549	553	556	java/lang/IllegalArgumentException
    //   606	637	556	java/lang/IllegalArgumentException
    //   637	649	556	java/lang/IllegalArgumentException
    //   656	663	556	java/lang/IllegalArgumentException
    //   713	744	556	java/lang/IllegalArgumentException
    //   744	756	556	java/lang/IllegalArgumentException
    //   758	771	556	java/lang/IllegalArgumentException
    //   774	783	556	java/lang/IllegalArgumentException
    //   786	792	556	java/lang/IllegalArgumentException
    //   794	806	556	java/lang/IllegalArgumentException
    //   808	827	556	java/lang/IllegalArgumentException
    //   827	885	556	java/lang/IllegalArgumentException
    //   885	908	556	java/lang/IllegalArgumentException
    //   908	960	556	java/lang/IllegalArgumentException
    //   960	1040	556	java/lang/IllegalArgumentException
    //   1043	1067	556	java/lang/IllegalArgumentException
    //   1072	1077	556	java/lang/IllegalArgumentException
    //   1082	1087	556	java/lang/IllegalArgumentException
    //   1087	1095	556	java/lang/IllegalArgumentException
    //   1100	1122	556	java/lang/IllegalArgumentException
    //   162	178	663	java/lang/SecurityException
    //   192	197	663	java/lang/SecurityException
    //   197	221	663	java/lang/SecurityException
    //   221	265	663	java/lang/SecurityException
    //   268	273	663	java/lang/SecurityException
    //   338	345	663	java/lang/SecurityException
    //   445	461	663	java/lang/SecurityException
    //   488	500	663	java/lang/SecurityException
    //   500	505	663	java/lang/SecurityException
    //   549	553	663	java/lang/SecurityException
    //   606	637	663	java/lang/SecurityException
    //   637	649	663	java/lang/SecurityException
    //   656	663	663	java/lang/SecurityException
    //   713	744	663	java/lang/SecurityException
    //   744	756	663	java/lang/SecurityException
    //   758	771	663	java/lang/SecurityException
    //   774	783	663	java/lang/SecurityException
    //   786	792	663	java/lang/SecurityException
    //   794	806	663	java/lang/SecurityException
    //   808	827	663	java/lang/SecurityException
    //   827	885	663	java/lang/SecurityException
    //   885	908	663	java/lang/SecurityException
    //   908	960	663	java/lang/SecurityException
    //   960	1040	663	java/lang/SecurityException
    //   1043	1067	663	java/lang/SecurityException
    //   1072	1077	663	java/lang/SecurityException
    //   1082	1087	663	java/lang/SecurityException
    //   1087	1095	663	java/lang/SecurityException
    //   1100	1122	663	java/lang/SecurityException
    //   323	330	1125	java/lang/Exception
    //   526	545	1129	finally
    //   514	526	1143	finally
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " loopCount:" + this.jdField_a_of_type_Int + " _loop:" + this.jdField_c_of_type_Boolean);
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "loop play,continue...");
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int > 0) {
          continue;
        }
        b();
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
          this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception paramMediaPlayer)
      {
        continue;
      }
      return;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_Int -= 1;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      label53:
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */