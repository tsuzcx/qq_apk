package com.tencent.mobileqq.vastrash;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import org.json.JSONObject;

public class ColorRingPlayer
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ColorRingPlayer.2(this);
  MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = null;
  Handler jdField_a_of_type_AndroidOsHandler;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  Client.OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver = new ColorRingPlayer.7(this);
  ColorRingPlayer.PlayerStatus jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus = new ColorRingPlayer.PlayerStatus(this);
  PhotoProgressDrawable jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  boolean jdField_a_of_type_Boolean = true;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  TextView d;
  
  public ColorRingPlayer(QQBrowserActivity paramQQBrowserActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramQQBrowserActivity;
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365419));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131361948));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365425));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131373545));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364974));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364973));
    this.d = ((TextView)paramViewGroup.findViewById(2131364970));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373560));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131377922));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378057));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  String a(int paramInt)
  {
    if (paramInt > 3599) {
      return "";
    }
    int i = paramInt % 60;
    paramInt /= 60;
    if (paramInt >= 10) {}
    for (String str = "" + paramInt;; str = "" + "0" + paramInt)
    {
      str = str + ":";
      if (i < 10) {
        break;
      }
      return str + i;
    }
    return str + "0" + i;
  }
  
  void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847449));
      }
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 5;
      return;
    }
  }
  
  void a(long paramLong)
  {
    ??? = new Bundle();
    ((Bundle)???).putLong("id", paramLong);
    ((Bundle)???).putInt("resourceType", 3);
    a(DataFactory.a("stopDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, (Bundle)???));
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 2;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847447));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691005));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
  }
  
  /* Error */
  void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 234
    //   11: iconst_2
    //   12: new 129	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   19: ldc 236
    //   21: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: lload_1
    //   25: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   38: astore 4
    //   40: aload 4
    //   42: monitorenter
    //   43: aload_0
    //   44: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   47: ifnull +15 -> 62
    //   50: aload_0
    //   51: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: invokevirtual 245	android/media/MediaPlayer:release	()V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   62: aload 4
    //   64: monitorexit
    //   65: aload_0
    //   66: new 147	android/media/MediaPlayer
    //   69: dup
    //   70: invokespecial 246	android/media/MediaPlayer:<init>	()V
    //   73: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   76: aload_0
    //   77: getfield 37	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   80: astore 6
    //   82: aload 6
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 37	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   89: iconst_4
    //   90: putfield 178	com/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus:jdField_a_of_type_Int	I
    //   93: aload 6
    //   95: monitorexit
    //   96: lload_1
    //   97: lconst_0
    //   98: lcmp
    //   99: ifne +319 -> 418
    //   102: aload_0
    //   103: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   106: invokevirtual 166	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   109: ldc 247
    //   111: invokevirtual 251	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   114: astore 4
    //   116: aload 4
    //   118: ifnonnull +118 -> 236
    //   121: aload_0
    //   122: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   125: astore 6
    //   127: aload 6
    //   129: monitorenter
    //   130: aload_0
    //   131: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   134: invokevirtual 245	android/media/MediaPlayer:release	()V
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   142: aload 6
    //   144: monitorexit
    //   145: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +11 -> 159
    //   151: ldc 234
    //   153: iconst_2
    //   154: ldc 253
    //   156: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 4
    //   161: ifnull +8 -> 169
    //   164: aload 4
    //   166: invokevirtual 258	android/content/res/AssetFileDescriptor:close	()V
    //   169: return
    //   170: astore 5
    //   172: aload 4
    //   174: monitorexit
    //   175: aload 5
    //   177: athrow
    //   178: astore 4
    //   180: aload 6
    //   182: monitorexit
    //   183: aload 4
    //   185: athrow
    //   186: astore 5
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 5
    //   193: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   196: aload 4
    //   198: ifnull -29 -> 169
    //   201: aload 4
    //   203: invokevirtual 258	android/content/res/AssetFileDescriptor:close	()V
    //   206: return
    //   207: astore 4
    //   209: aload 4
    //   211: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   214: return
    //   215: astore 5
    //   217: aload 6
    //   219: monitorexit
    //   220: aload 5
    //   222: athrow
    //   223: astore 5
    //   225: goto -34 -> 191
    //   228: astore 4
    //   230: aload 4
    //   232: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   235: return
    //   236: aload_0
    //   237: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   240: aload 4
    //   242: invokevirtual 266	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   245: aload 4
    //   247: invokevirtual 270	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   250: aload 4
    //   252: invokevirtual 273	android/content/res/AssetFileDescriptor:getLength	()J
    //   255: invokevirtual 277	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   258: aload 4
    //   260: invokevirtual 258	android/content/res/AssetFileDescriptor:close	()V
    //   263: aload_0
    //   264: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   267: invokevirtual 280	android/media/MediaPlayer:prepare	()V
    //   270: aload_0
    //   271: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   274: ldc_w 282
    //   277: invokevirtual 286	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   280: checkcast 288	android/media/AudioManager
    //   283: astore 4
    //   285: aload 4
    //   287: aload_0
    //   288: getfield 52	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   291: iconst_3
    //   292: iconst_1
    //   293: invokevirtual 292	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   296: iconst_1
    //   297: if_icmpne +136 -> 433
    //   300: aload_0
    //   301: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   304: iload_3
    //   305: invokevirtual 295	android/media/MediaPlayer:seekTo	(I)V
    //   308: aload_0
    //   309: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   312: invokevirtual 298	android/media/MediaPlayer:start	()V
    //   315: aload_0
    //   316: invokevirtual 300	com/tencent/mobileqq/vastrash/ColorRingPlayer:d	()V
    //   319: aload_0
    //   320: getfield 104	com/tencent/mobileqq/vastrash/ColorRingPlayer:d	Landroid/widget/TextView;
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   328: invokevirtual 303	android/media/MediaPlayer:getDuration	()I
    //   331: sipush 1000
    //   334: idiv
    //   335: invokevirtual 305	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(I)Ljava/lang/String;
    //   338: invokevirtual 306	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   341: aload_0
    //   342: getfield 88	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   345: aload_0
    //   346: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   349: invokevirtual 166	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   352: ldc_w 307
    //   355: invokevirtual 173	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   358: invokevirtual 177	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   361: aload_0
    //   362: getfield 88	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   365: iconst_0
    //   366: invokevirtual 214	android/widget/ImageView:setVisibility	(I)V
    //   369: aload_0
    //   370: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   373: new 309	com/tencent/mobileqq/vastrash/ColorRingPlayer$1
    //   376: dup
    //   377: aload_0
    //   378: aload 4
    //   380: invokespecial 312	com/tencent/mobileqq/vastrash/ColorRingPlayer$1:<init>	(Lcom/tencent/mobileqq/vastrash/ColorRingPlayer;Landroid/media/AudioManager;)V
    //   383: invokevirtual 316	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   386: aload_0
    //   387: ldc_w 318
    //   390: ldc_w 318
    //   393: lload_1
    //   394: iconst_0
    //   395: invokevirtual 321	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(Ljava/lang/String;Ljava/lang/String;JI)V
    //   398: iconst_0
    //   399: ifeq -230 -> 169
    //   402: new 323	java/lang/NullPointerException
    //   405: dup
    //   406: invokespecial 324	java/lang/NullPointerException:<init>	()V
    //   409: athrow
    //   410: astore 4
    //   412: aload 4
    //   414: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   417: return
    //   418: aload_0
    //   419: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   422: lload_1
    //   423: iconst_3
    //   424: invokestatic 329	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   427: invokevirtual 332	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   430: goto -167 -> 263
    //   433: aload_0
    //   434: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   437: astore 4
    //   439: aload 4
    //   441: monitorenter
    //   442: aload_0
    //   443: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   446: invokevirtual 245	android/media/MediaPlayer:release	()V
    //   449: aload_0
    //   450: aconst_null
    //   451: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   454: aload 4
    //   456: monitorexit
    //   457: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq -62 -> 398
    //   463: ldc 234
    //   465: iconst_2
    //   466: ldc_w 334
    //   469: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: goto -74 -> 398
    //   475: astore 4
    //   477: aload 5
    //   479: ifnull +8 -> 487
    //   482: aload 5
    //   484: invokevirtual 258	android/content/res/AssetFileDescriptor:close	()V
    //   487: aload 4
    //   489: athrow
    //   490: astore 6
    //   492: aload 4
    //   494: monitorexit
    //   495: aload 6
    //   497: athrow
    //   498: astore 5
    //   500: aload 5
    //   502: invokevirtual 262	java/lang/Exception:printStackTrace	()V
    //   505: goto -18 -> 487
    //   508: astore 6
    //   510: aload 4
    //   512: astore 5
    //   514: aload 6
    //   516: astore 4
    //   518: goto -41 -> 477
    //   521: astore 6
    //   523: aload 4
    //   525: astore 5
    //   527: aload 6
    //   529: astore 4
    //   531: goto -54 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	534	0	this	ColorRingPlayer
    //   0	534	1	paramLong	long
    //   0	534	3	paramInt	int
    //   38	135	4	localObject1	Object
    //   178	6	4	localObject2	Object
    //   189	13	4	localObject3	Object
    //   207	3	4	localException1	Exception
    //   228	31	4	localException2	Exception
    //   283	96	4	localAudioManager	AudioManager
    //   410	3	4	localException3	Exception
    //   475	36	4	localObject5	Object
    //   516	14	4	localObject6	Object
    //   1	1	5	localObject7	Object
    //   170	6	5	localObject8	Object
    //   186	6	5	localIOException1	java.io.IOException
    //   215	6	5	localObject9	Object
    //   223	260	5	localIOException2	java.io.IOException
    //   498	3	5	localException4	Exception
    //   512	14	5	localObject10	Object
    //   80	138	6	localObject11	Object
    //   490	6	6	localObject12	Object
    //   508	7	6	localObject13	Object
    //   521	7	6	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   43	62	170	finally
    //   62	65	170	finally
    //   172	175	170	finally
    //   85	96	178	finally
    //   180	183	178	finally
    //   76	85	186	java/io/IOException
    //   102	116	186	java/io/IOException
    //   183	186	186	java/io/IOException
    //   263	398	186	java/io/IOException
    //   418	430	186	java/io/IOException
    //   433	442	186	java/io/IOException
    //   457	472	186	java/io/IOException
    //   495	498	186	java/io/IOException
    //   201	206	207	java/lang/Exception
    //   130	145	215	finally
    //   217	220	215	finally
    //   121	130	223	java/io/IOException
    //   145	159	223	java/io/IOException
    //   220	223	223	java/io/IOException
    //   236	263	223	java/io/IOException
    //   164	169	228	java/lang/Exception
    //   402	410	410	java/lang/Exception
    //   76	85	475	finally
    //   102	116	475	finally
    //   183	186	475	finally
    //   263	398	475	finally
    //   418	430	475	finally
    //   433	442	475	finally
    //   457	472	475	finally
    //   495	498	475	finally
    //   442	457	490	finally
    //   492	495	490	finally
    //   482	487	498	java/lang/Exception
    //   121	130	508	finally
    //   145	159	508	finally
    //   220	223	508	finally
    //   236	263	508	finally
    //   191	196	521	finally
  }
  
  void a(long paramLong, int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt != 3)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("id", paramLong);
      ((Bundle)localObject).putInt("resourceType", paramInt);
      ((Bundle)localObject).putString("colorType", paramString);
      a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, (Bundle)localObject));
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      localObject = new ColorRingPlayer.4(this, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getActivity(), 2131755842);
      ((QQCustomDialog)localObject).setContentView(2131559084);
      ((QQCustomDialog)localObject).setTitle(HardCodeUtil.a(2131702216));
      ((QQCustomDialog)localObject).setMessage(2131719887);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setNegativeButton(2131690800, new ColorRingPlayer.5(this));
      ((QQCustomDialog)localObject).setPositiveButton(2131694615, new ColorRingPlayer.6(this, paramLong, paramInt, paramString));
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramLong, paramInt, paramString);
  }
  
  void a(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691006);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramString);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(paramString);
      if (paramLong != 0L) {
        break label261;
      }
      a(paramLong, 0);
      if (!a(paramLong, paramString)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691003));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847448));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847446));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691533));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
      if ("comering".equals(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691110);
      }
    }
    if (paramString.equals("colorring")) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719062));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      break;
      if (paramString.equals("comering")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719063));
      }
    }
    label261:
    if (a(paramLong, paramString)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (!new File(ColorRingManager.a(paramLong, 3)).exists())
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847447));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals("colorring"))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719062));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        a(paramLong, 3, paramString);
        label368:
        if (new File(ColorRingManager.a(paramLong, 1)).exists()) {
          break label610;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847445));
        a(paramLong, 1, paramString);
      }
    }
    for (;;)
    {
      if (new File(ColorRingManager.a(paramLong, 2)).exists()) {
        break label631;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      a(paramLong, 2, paramString);
      return;
      if (!paramString.equals("comering")) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719063));
      break;
      a(paramLong, 0);
      if (a(paramLong, paramString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691003));
        break label368;
      }
      if (paramString.equals("colorring")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719062));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        break;
        if (paramString.equals("comering")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131719063));
        }
      }
      label610:
      if (ColorRingManager.a(paramLong) != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ColorRingManager.a(paramLong));
      }
    }
    label631:
    a(ColorRingManager.a(paramLong));
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String arg5)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long == paramLong)
        {
          if (paramInt != 0) {
            break label205;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691003));
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          if (!paramString1.equals("colorring")) {
            continue;
          }
          if (paramInt == 0)
          {
            paramInt = i;
            a("0X8004A24", "0X8004A24", paramLong, paramInt);
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            a(DataFactory.a("colorRingSetup", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, localBundle));
          }
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
          return;
        }
        paramInt = 1;
        continue;
        if (!paramString1.equals("comering")) {
          continue;
        }
        if (paramInt == 0)
        {
          paramInt = j;
          a("0X8005003", "0X8005003", paramLong, paramInt);
        }
      }
      paramInt = 1;
      continue;
      label205:
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "setup failure.");
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_JavaLangString.equals(paramString1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 6) {
        a(paramLong, 0);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 1) {
      a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long);
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    a(paramLong, paramString1);
  }
  
  void a(Bundle paramBundle)
  {
    if (!WebIPCOperator.a().a())
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), HardCodeUtil.a(2131702215), 0).show();
      return;
    }
    WebIPCOperator.a().b(paramBundle);
  }
  
  public void a(String arg1)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847449));
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 6;
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      return;
    }
  }
  
  void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new ColorRingPlayer.8(this, paramString1, paramString2, paramLong, paramInt));
  }
  
  void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "initColorRingDetail, detail is null");
      }
      return;
    }
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("singer"));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramJSONObject.getString("name"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  boolean a(long paramLong, String paramString)
  {
    Object localObject = (BrowserAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getAppRuntime();
    EntityManager localEntityManager = ((BrowserAppInterface)localObject).getEntityManagerFactory(null).createEntityManager();
    localObject = (ExtensionInfo)localEntityManager.find(ExtensionInfo.class, ((BrowserAppInterface)localObject).getAccount());
    localEntityManager.close();
    if (localObject == null) {
      return false;
    }
    if (("colorring".equals(paramString)) && (((ExtensionInfo)localObject).colorRingId == paramLong)) {
      return true;
    }
    return ("comering".equals(paramString)) && (((ExtensionInfo)localObject).commingRingId == paramLong);
  }
  
  void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      return;
    }
  }
  
  void b(long paramLong, int paramInt, String arg4)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("id", paramLong);
    ((Bundle)localObject1).putInt("resourceType", paramInt);
    ((Bundle)localObject1).putString("colorType", ???);
    a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver.key, (Bundle)localObject1));
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ??? = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources(), 2130848977);
        ??? = (String)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label113:
        break label113;
      }
      localObject1 = ???;
      if (??? == null) {
        localObject1 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable = new PhotoProgressDrawable((Bitmap)localObject1, (int)(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().density * 12.0F));
      ??? = new Rect();
      ???.set(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296719), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296718));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(???);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691004));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  void c()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
          {
            long l = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long;
            a(l, this.jdField_a_of_type_Int);
            d();
            this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847448));
          }
        }
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 4;
        return;
        localObject4 = finally;
        throw localObject4;
        localObject2 = finally;
        throw localObject2;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
    }
  }
  
  void d()
  {
    ThreadManager.post(new ColorRingPlayer.3(this), 8, null, true);
  }
  
  public void e()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
    ??? = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getSystemService("audio");
    if (??? == null) {
      return;
    }
    ((AudioManager)???).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847449));
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 6;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    ??? = (String)paramView.getTag();
    Object localObject1 = ???;
    if (??? == null) {
      localObject1 = "colorring";
    }
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131365425: 
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 4) {
            a();
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 5)
        {
          c();
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 6)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 0);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 1)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 2;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 2)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 3, (String)localObject1);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 0)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 3, (String)localObject1);
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 3)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 0);
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 1) {
          a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 2)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 3, (String)localObject1);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 0)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long, 3, (String)localObject1);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int >= 3)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getCurrentWebViewFragment();
        if (localObject1 != null) {
          ((WebViewFragment)localObject1).getWebView().callJs(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.b, new String[] { "{'result':0,'message':'OK'}" });
        }
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer
 * JD-Core Version:    0.7.0.1
 */