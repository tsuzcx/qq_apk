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
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
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
  OnRemoteRespObserver jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver = new ColorRingPlayer.7(this);
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
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365284));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131361961));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131365290));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131373123));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364858));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364857));
    this.d = ((TextView)paramViewGroup.findViewById(2131364854));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131373138));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131377345));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377484));
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
    if (paramInt >= 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(":");
    Object localObject = localStringBuilder.toString();
    if (i >= 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(i);
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("0");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847318));
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
    a(DataFactory.a("stopDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, (Bundle)???));
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 2;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847316));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690925));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
  }
  
  /* Error */
  void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 133	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 238
    //   19: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: lload_1
    //   26: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 243
    //   32: iconst_2
    //   33: aload 4
    //   35: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   45: astore 4
    //   47: aload 4
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: astore 5
    //   56: aconst_null
    //   57: astore 7
    //   59: aconst_null
    //   60: astore 6
    //   62: aload 5
    //   64: ifnull +15 -> 79
    //   67: aload_0
    //   68: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   74: aload_0
    //   75: aconst_null
    //   76: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   79: aload 4
    //   81: monitorexit
    //   82: aload_0
    //   83: new 251	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   86: dup
    //   87: invokespecial 252	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   90: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   93: aload 6
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 37	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   101: astore 5
    //   103: aload 6
    //   105: astore 4
    //   107: aload 5
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 37	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   114: iconst_4
    //   115: putfield 182	com/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus:jdField_a_of_type_Int	I
    //   118: aload 5
    //   120: monitorexit
    //   121: lload_1
    //   122: lconst_0
    //   123: lcmp
    //   124: ifne +140 -> 264
    //   127: aload 6
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   135: invokevirtual 170	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   138: ldc 253
    //   140: invokevirtual 257	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   143: astore 5
    //   145: aload 5
    //   147: ifnonnull +69 -> 216
    //   150: aload_0
    //   151: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   154: astore 4
    //   156: aload 4
    //   158: monitorenter
    //   159: aload_0
    //   160: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   163: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   171: aload 4
    //   173: monitorexit
    //   174: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +12 -> 189
    //   180: ldc 243
    //   182: iconst_2
    //   183: ldc_w 259
    //   186: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 5
    //   191: ifnull +16 -> 207
    //   194: aload 5
    //   196: invokevirtual 264	android/content/res/AssetFileDescriptor:close	()V
    //   199: return
    //   200: astore 4
    //   202: aload 4
    //   204: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   207: return
    //   208: astore 6
    //   210: aload 4
    //   212: monitorexit
    //   213: aload 6
    //   215: athrow
    //   216: aload_0
    //   217: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   220: aload 5
    //   222: invokevirtual 271	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   225: aload 5
    //   227: invokevirtual 275	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   230: aload 5
    //   232: invokevirtual 278	android/content/res/AssetFileDescriptor:getLength	()J
    //   235: invokevirtual 282	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   238: aload 5
    //   240: invokevirtual 264	android/content/res/AssetFileDescriptor:close	()V
    //   243: goto +37 -> 280
    //   246: astore 6
    //   248: aload 5
    //   250: astore 4
    //   252: aload 6
    //   254: astore 5
    //   256: goto +323 -> 579
    //   259: astore 6
    //   261: goto +290 -> 551
    //   264: aload 6
    //   266: astore 4
    //   268: aload_0
    //   269: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   272: lload_1
    //   273: iconst_3
    //   274: invokestatic 287	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   277: invokevirtual 290	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   280: aload 6
    //   282: astore 4
    //   284: aload_0
    //   285: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   288: invokevirtual 293	android/media/MediaPlayer:prepare	()V
    //   291: aload 6
    //   293: astore 4
    //   295: aload_0
    //   296: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   299: ldc_w 295
    //   302: invokevirtual 299	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   305: checkcast 301	android/media/AudioManager
    //   308: astore 5
    //   310: aload 6
    //   312: astore 4
    //   314: aload 5
    //   316: aload_0
    //   317: getfield 52	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   320: iconst_3
    //   321: iconst_1
    //   322: invokevirtual 305	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   325: iconst_1
    //   326: if_icmpne +134 -> 460
    //   329: aload 6
    //   331: astore 4
    //   333: aload_0
    //   334: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   337: iload_3
    //   338: invokevirtual 308	android/media/MediaPlayer:seekTo	(I)V
    //   341: aload 6
    //   343: astore 4
    //   345: aload_0
    //   346: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   349: invokevirtual 311	android/media/MediaPlayer:start	()V
    //   352: aload 6
    //   354: astore 4
    //   356: aload_0
    //   357: invokevirtual 313	com/tencent/mobileqq/vastrash/ColorRingPlayer:d	()V
    //   360: aload 6
    //   362: astore 4
    //   364: aload_0
    //   365: getfield 108	com/tencent/mobileqq/vastrash/ColorRingPlayer:d	Landroid/widget/TextView;
    //   368: aload_0
    //   369: aload_0
    //   370: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   373: invokevirtual 316	android/media/MediaPlayer:getDuration	()I
    //   376: sipush 1000
    //   379: idiv
    //   380: invokevirtual 318	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(I)Ljava/lang/String;
    //   383: invokevirtual 319	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   386: aload 6
    //   388: astore 4
    //   390: aload_0
    //   391: getfield 92	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   394: aload_0
    //   395: getfield 61	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   398: invokevirtual 170	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   401: ldc_w 320
    //   404: invokevirtual 177	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   407: invokevirtual 181	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   410: aload 6
    //   412: astore 4
    //   414: aload_0
    //   415: getfield 92	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_c_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   418: iconst_0
    //   419: invokevirtual 218	android/widget/ImageView:setVisibility	(I)V
    //   422: aload 6
    //   424: astore 4
    //   426: aload_0
    //   427: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   430: new 322	com/tencent/mobileqq/vastrash/ColorRingPlayer$1
    //   433: dup
    //   434: aload_0
    //   435: aload 5
    //   437: invokespecial 325	com/tencent/mobileqq/vastrash/ColorRingPlayer$1:<init>	(Lcom/tencent/mobileqq/vastrash/ColorRingPlayer;Landroid/media/AudioManager;)V
    //   440: invokevirtual 329	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   443: aload 6
    //   445: astore 4
    //   447: aload_0
    //   448: ldc_w 331
    //   451: ldc_w 331
    //   454: lload_1
    //   455: iconst_0
    //   456: invokevirtual 334	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(Ljava/lang/String;Ljava/lang/String;JI)V
    //   459: return
    //   460: aload 6
    //   462: astore 4
    //   464: aload_0
    //   465: getfield 39	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   468: astore 5
    //   470: aload 6
    //   472: astore 4
    //   474: aload 5
    //   476: monitorenter
    //   477: aload_0
    //   478: getfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   481: invokevirtual 249	android/media/MediaPlayer:release	()V
    //   484: aload_0
    //   485: aconst_null
    //   486: putfield 41	com/tencent/mobileqq/vastrash/ColorRingPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   489: aload 5
    //   491: monitorexit
    //   492: aload 6
    //   494: astore 4
    //   496: invokestatic 236	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +79 -> 578
    //   502: aload 6
    //   504: astore 4
    //   506: ldc 243
    //   508: iconst_2
    //   509: ldc_w 336
    //   512: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: return
    //   516: astore 8
    //   518: aload 5
    //   520: monitorexit
    //   521: aload 6
    //   523: astore 4
    //   525: aload 8
    //   527: athrow
    //   528: astore 8
    //   530: aload 5
    //   532: monitorexit
    //   533: aload 6
    //   535: astore 4
    //   537: aload 8
    //   539: athrow
    //   540: astore 5
    //   542: goto +37 -> 579
    //   545: astore 6
    //   547: aload 7
    //   549: astore 5
    //   551: aload 5
    //   553: astore 4
    //   555: aload 6
    //   557: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   560: aload 5
    //   562: ifnull +16 -> 578
    //   565: aload 5
    //   567: invokevirtual 264	android/content/res/AssetFileDescriptor:close	()V
    //   570: return
    //   571: astore 4
    //   573: aload 4
    //   575: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   578: return
    //   579: aload 4
    //   581: ifnull +18 -> 599
    //   584: aload 4
    //   586: invokevirtual 264	android/content/res/AssetFileDescriptor:close	()V
    //   589: goto +10 -> 599
    //   592: astore 4
    //   594: aload 4
    //   596: invokevirtual 267	java/lang/Exception:printStackTrace	()V
    //   599: aload 5
    //   601: athrow
    //   602: astore 5
    //   604: aload 4
    //   606: monitorexit
    //   607: aload 5
    //   609: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	ColorRingPlayer
    //   0	610	1	paramLong	long
    //   0	610	3	paramInt	int
    //   13	159	4	localObject1	Object
    //   200	11	4	localException1	Exception
    //   250	304	4	localObject2	Object
    //   571	14	4	localException2	Exception
    //   592	13	4	localException3	Exception
    //   54	477	5	localObject3	Object
    //   540	1	5	localObject4	Object
    //   549	51	5	localObject5	Object
    //   602	6	5	localObject6	Object
    //   60	68	6	localObject7	Object
    //   208	6	6	localObject8	Object
    //   246	7	6	localObject9	Object
    //   259	275	6	localIOException1	java.io.IOException
    //   545	11	6	localIOException2	java.io.IOException
    //   57	491	7	localObject10	Object
    //   516	10	8	localObject11	Object
    //   528	10	8	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   194	199	200	java/lang/Exception
    //   159	174	208	finally
    //   210	213	208	finally
    //   150	159	246	finally
    //   174	189	246	finally
    //   213	216	246	finally
    //   216	243	246	finally
    //   150	159	259	java/io/IOException
    //   174	189	259	java/io/IOException
    //   213	216	259	java/io/IOException
    //   216	243	259	java/io/IOException
    //   477	492	516	finally
    //   518	521	516	finally
    //   110	121	528	finally
    //   530	533	528	finally
    //   97	103	540	finally
    //   107	110	540	finally
    //   131	145	540	finally
    //   268	280	540	finally
    //   284	291	540	finally
    //   295	310	540	finally
    //   314	329	540	finally
    //   333	341	540	finally
    //   345	352	540	finally
    //   356	360	540	finally
    //   364	386	540	finally
    //   390	410	540	finally
    //   414	422	540	finally
    //   426	443	540	finally
    //   447	459	540	finally
    //   464	470	540	finally
    //   474	477	540	finally
    //   496	502	540	finally
    //   506	515	540	finally
    //   525	528	540	finally
    //   537	540	540	finally
    //   555	560	540	finally
    //   97	103	545	java/io/IOException
    //   107	110	545	java/io/IOException
    //   131	145	545	java/io/IOException
    //   268	280	545	java/io/IOException
    //   284	291	545	java/io/IOException
    //   295	310	545	java/io/IOException
    //   314	329	545	java/io/IOException
    //   333	341	545	java/io/IOException
    //   345	352	545	java/io/IOException
    //   356	360	545	java/io/IOException
    //   364	386	545	java/io/IOException
    //   390	410	545	java/io/IOException
    //   414	422	545	java/io/IOException
    //   426	443	545	java/io/IOException
    //   447	459	545	java/io/IOException
    //   464	470	545	java/io/IOException
    //   474	477	545	java/io/IOException
    //   496	502	545	java/io/IOException
    //   506	515	545	java/io/IOException
    //   525	528	545	java/io/IOException
    //   537	540	545	java/io/IOException
    //   565	570	571	java/lang/Exception
    //   584	589	592	java/lang/Exception
    //   50	56	602	finally
    //   67	79	602	finally
    //   79	82	602	finally
    //   604	607	602	finally
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
      a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, (Bundle)localObject));
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      localObject = new ColorRingPlayer.4(this, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getActivity(), 2131756189);
      ((QQCustomDialog)localObject).setContentView(2131558978);
      ((QQCustomDialog)localObject).setTitle(HardCodeUtil.a(2131702352));
      ((QQCustomDialog)localObject).setMessage(2131719619);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setNegativeButton(2131690728, new ColorRingPlayer.5(this));
      ((QQCustomDialog)localObject).setPositiveButton(2131694583, new ColorRingPlayer.6(this, paramLong, paramInt, paramString));
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramLong, paramInt, paramString);
  }
  
  void a(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690926);
    } else if ("comering".equals(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691030);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setTag(paramString);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(paramString);
    if (paramLong == 0L)
    {
      a(paramLong, 0);
      if (a(paramLong, paramString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690923));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else
      {
        if (paramString.equals("colorring")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718778));
        } else if (paramString.equals("comering")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718779));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847317));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847315));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131691455));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      return;
    }
    if (a(paramLong, paramString)) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
    if (!new File(ColorRingManager.a(paramLong, 3)).exists())
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847316));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramString.equals("colorring")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718778));
      } else if (paramString.equals("comering")) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718779));
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      a(paramLong, 3, paramString);
    }
    else
    {
      a(paramLong, 0);
      if (a(paramLong, paramString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690923));
      }
      else
      {
        if (paramString.equals("colorring")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718778));
        } else if (paramString.equals("comering")) {
          this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131718779));
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
    if (!new File(ColorRingManager.a(paramLong, 1)).exists())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847314));
      a(paramLong, 1, paramString);
    }
    else if (ColorRingManager.a(paramLong) != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(ColorRingManager.a(paramLong));
    }
    if (!new File(ColorRingManager.a(paramLong, 2)).exists())
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      a(paramLong, 2, paramString);
      return;
    }
    a(ColorRingManager.a(paramLong));
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String arg5)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long == paramLong) {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690923));
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            if (paramString1.equals("colorring"))
            {
              if (paramInt != 0) {
                break label209;
              }
              paramInt = 0;
              a("0X8004A24", "0X8004A24", paramLong, paramInt);
            }
            else if (paramString1.equals("comering"))
            {
              if (paramInt != 0) {
                break label215;
              }
              paramInt = 0;
              a("0X8005003", "0X8005003", paramLong, paramInt);
            }
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            a(DataFactory.a("colorRingSetup", "", this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, localBundle));
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ColorRingPlayer", 2, "setup failure.");
          }
        }
        this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return;
      }
      label209:
      paramInt = 1;
      continue;
      label215:
      paramInt = 1;
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
    ColorRingPlayer.PlayerStatus localPlayerStatus = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus;
    localPlayerStatus.jdField_a_of_type_Long = paramLong;
    localPlayerStatus.jdField_a_of_type_JavaLangString = paramString1;
    localPlayerStatus.b = paramString2;
    localPlayerStatus.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    a(paramLong, paramString1);
  }
  
  void a(Bundle paramBundle)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getApplicationContext(), HardCodeUtil.a(2131702351), 0).show();
      return;
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
  }
  
  public void a(String arg1)
  {
    ??? = this.jdField_a_of_type_AndroidMediaMediaPlayer;
    if ((??? != null) && (???.isPlaying()))
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847318));
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 6;
        this.jdField_b_of_type_Boolean = false;
      }
    }
    ??? = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((??? != null) && (???.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
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
    a(DataFactory.a("startDownloadColorRing", "", this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver.key, (Bundle)localObject1));
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ??? = null;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources(), 2130848857);
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
      ???.set(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296699), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDimensionPixelSize(2131296698));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setBounds(???);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.setLevel(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoProgressDrawable.invalidateSelf();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131690924));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
  }
  
  void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
        {
          long l = this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long;
          a(l, this.jdField_a_of_type_Int);
        }
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      d();
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847317));
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 4;
        return;
      }
    }
  }
  
  void d()
  {
    ThreadManager.post(new ColorRingPlayer.3(this), 8, null, true);
  }
  
  public void e()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmOnRemoteRespObserver);
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
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130847318));
        synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
        {
          this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int = 6;
          this.jdField_b_of_type_Boolean = true;
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void h()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localViewGroup != null) && (localViewGroup.getVisibility() != 0)) {
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
    int i = paramView.getId();
    if (i != 2131361961)
    {
      if (i != 2131365290) {
        break label379;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 4)
        {
          a();
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 5)
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
    synchronized (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 1)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Long);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqVastrashColorRingPlayer$PlayerStatus.jdField_a_of_type_Int == 2)
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
      label379:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer
 * JD-Core Version:    0.7.0.1
 */