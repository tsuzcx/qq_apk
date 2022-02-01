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
  ColorRingPlayer.PlayerStatus a = new ColorRingPlayer.PlayerStatus(this);
  Object b = new Object();
  MediaPlayer c = null;
  int d;
  QQBrowserActivity e;
  Handler f;
  boolean g = true;
  boolean h = false;
  ViewGroup i;
  ImageView j;
  ImageView k;
  Button l;
  ImageView m;
  ProgressBar n;
  TextView o;
  TextView p;
  TextView q;
  TextView r;
  ProgressBar s;
  PhotoProgressDrawable t = null;
  AudioManager.OnAudioFocusChangeListener u = new ColorRingPlayer.2(this);
  OnRemoteRespObserver v = new ColorRingPlayer.7(this);
  
  public ColorRingPlayer(QQBrowserActivity paramQQBrowserActivity, ViewGroup paramViewGroup)
  {
    this.i = paramViewGroup;
    this.e = paramQQBrowserActivity;
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.v);
    this.j = ((ImageView)paramViewGroup.findViewById(2131431458));
    this.l = ((Button)paramViewGroup.findViewById(2131427516));
    this.m = ((ImageView)paramViewGroup.findViewById(2131431466));
    this.n = ((ProgressBar)paramViewGroup.findViewById(2131440726));
    this.p = ((TextView)paramViewGroup.findViewById(2131430983));
    this.q = ((TextView)paramViewGroup.findViewById(2131430982));
    this.r = ((TextView)paramViewGroup.findViewById(2131430979));
    this.k = ((ImageView)paramViewGroup.findViewById(2131440743));
    this.s = ((ProgressBar)paramViewGroup.findViewById(2131445734));
    this.o = ((TextView)paramViewGroup.findViewById(2131445883));
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.f = new Handler();
  }
  
  String a(int paramInt)
  {
    if (paramInt > 3599) {
      return "";
    }
    int i1 = paramInt % 60;
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
    if (i1 >= 10)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(i1);
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("0");
    localStringBuilder.append(i1);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    synchronized (this.b)
    {
      if ((this.c != null) && (this.c.isPlaying()))
      {
        this.c.pause();
        this.d = this.c.getCurrentPosition();
        this.m.setImageDrawable(this.e.getResources().getDrawable(2130848969));
      }
      this.a.a = 5;
      return;
    }
  }
  
  void a(long paramLong)
  {
    ??? = new Bundle();
    ((Bundle)???).putLong("id", paramLong);
    ((Bundle)???).putInt("resourceType", 3);
    a(DataFactory.a("stopDownloadColorRing", "", this.v.key, (Bundle)???));
    synchronized (this.a)
    {
      this.a.a = 2;
      this.m.setImageDrawable(this.e.getResources().getDrawable(2130848967));
      this.m.setVisibility(0);
      this.l.setText(this.e.getResources().getString(2131887864));
      this.k.setVisibility(4);
      return;
    }
  }
  
  /* Error */
  void a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: new 151	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 257
    //   20: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: lload_1
    //   27: invokevirtual 260	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc_w 262
    //   34: iconst_2
    //   35: aload 4
    //   37: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 57	com/tencent/mobileqq/vastrash/ColorRingPlayer:b	Ljava/lang/Object;
    //   47: astore 4
    //   49: aload 4
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   56: astore 5
    //   58: aconst_null
    //   59: astore 7
    //   61: aconst_null
    //   62: astore 6
    //   64: aload 5
    //   66: ifnull +15 -> 81
    //   69: aload_0
    //   70: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   73: invokevirtual 268	android/media/MediaPlayer:release	()V
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   81: aload 4
    //   83: monitorexit
    //   84: aload_0
    //   85: new 270	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   88: dup
    //   89: invokespecial 271	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   92: putfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   95: aload 6
    //   97: astore 4
    //   99: aload_0
    //   100: getfield 55	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   103: astore 5
    //   105: aload 6
    //   107: astore 4
    //   109: aload 5
    //   111: monitorenter
    //   112: aload_0
    //   113: getfield 55	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	Lcom/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus;
    //   116: iconst_4
    //   117: putfield 201	com/tencent/mobileqq/vastrash/ColorRingPlayer$PlayerStatus:a	I
    //   120: aload 5
    //   122: monitorexit
    //   123: lload_1
    //   124: lconst_0
    //   125: lcmp
    //   126: ifne +142 -> 268
    //   129: aload 6
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 79	com/tencent/mobileqq/vastrash/ColorRingPlayer:e	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   137: invokevirtual 188	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   140: ldc_w 272
    //   143: invokevirtual 276	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   146: astore 5
    //   148: aload 5
    //   150: ifnonnull +70 -> 220
    //   153: aload_0
    //   154: getfield 57	com/tencent/mobileqq/vastrash/ColorRingPlayer:b	Ljava/lang/Object;
    //   157: astore 4
    //   159: aload 4
    //   161: monitorenter
    //   162: aload_0
    //   163: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   166: invokevirtual 268	android/media/MediaPlayer:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   174: aload 4
    //   176: monitorexit
    //   177: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +13 -> 193
    //   183: ldc_w 262
    //   186: iconst_2
    //   187: ldc_w 278
    //   190: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: aload 5
    //   195: ifnull +16 -> 211
    //   198: aload 5
    //   200: invokevirtual 283	android/content/res/AssetFileDescriptor:close	()V
    //   203: return
    //   204: astore 4
    //   206: aload 4
    //   208: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   211: return
    //   212: astore 6
    //   214: aload 4
    //   216: monitorexit
    //   217: aload 6
    //   219: athrow
    //   220: aload_0
    //   221: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   224: aload 5
    //   226: invokevirtual 290	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   229: aload 5
    //   231: invokevirtual 294	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   234: aload 5
    //   236: invokevirtual 297	android/content/res/AssetFileDescriptor:getLength	()J
    //   239: invokevirtual 301	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   242: aload 5
    //   244: invokevirtual 283	android/content/res/AssetFileDescriptor:close	()V
    //   247: goto +37 -> 284
    //   250: astore 6
    //   252: aload 5
    //   254: astore 4
    //   256: aload 6
    //   258: astore 5
    //   260: goto +324 -> 584
    //   263: astore 6
    //   265: goto +291 -> 556
    //   268: aload 6
    //   270: astore 4
    //   272: aload_0
    //   273: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   276: lload_1
    //   277: iconst_3
    //   278: invokestatic 306	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   281: invokevirtual 309	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   284: aload 6
    //   286: astore 4
    //   288: aload_0
    //   289: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   292: invokevirtual 312	android/media/MediaPlayer:prepare	()V
    //   295: aload 6
    //   297: astore 4
    //   299: aload_0
    //   300: getfield 79	com/tencent/mobileqq/vastrash/ColorRingPlayer:e	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   303: ldc_w 314
    //   306: invokevirtual 318	com/tencent/mobileqq/activity/QQBrowserActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   309: checkcast 320	android/media/AudioManager
    //   312: astore 5
    //   314: aload 6
    //   316: astore 4
    //   318: aload 5
    //   320: aload_0
    //   321: getfield 70	com/tencent/mobileqq/vastrash/ColorRingPlayer:u	Landroid/media/AudioManager$OnAudioFocusChangeListener;
    //   324: iconst_3
    //   325: iconst_1
    //   326: invokevirtual 324	android/media/AudioManager:requestAudioFocus	(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I
    //   329: iconst_1
    //   330: if_icmpne +134 -> 464
    //   333: aload 6
    //   335: astore 4
    //   337: aload_0
    //   338: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   341: iload_3
    //   342: invokevirtual 327	android/media/MediaPlayer:seekTo	(I)V
    //   345: aload 6
    //   347: astore 4
    //   349: aload_0
    //   350: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   353: invokevirtual 330	android/media/MediaPlayer:start	()V
    //   356: aload 6
    //   358: astore 4
    //   360: aload_0
    //   361: invokevirtual 332	com/tencent/mobileqq/vastrash/ColorRingPlayer:d	()V
    //   364: aload 6
    //   366: astore 4
    //   368: aload_0
    //   369: getfield 126	com/tencent/mobileqq/vastrash/ColorRingPlayer:r	Landroid/widget/TextView;
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   377: invokevirtual 335	android/media/MediaPlayer:getDuration	()I
    //   380: sipush 1000
    //   383: idiv
    //   384: invokevirtual 337	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(I)Ljava/lang/String;
    //   387: invokevirtual 338	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   390: aload 6
    //   392: astore 4
    //   394: aload_0
    //   395: getfield 110	com/tencent/mobileqq/vastrash/ColorRingPlayer:m	Landroid/widget/ImageView;
    //   398: aload_0
    //   399: getfield 79	com/tencent/mobileqq/vastrash/ColorRingPlayer:e	Lcom/tencent/mobileqq/activity/QQBrowserActivity;
    //   402: invokevirtual 188	com/tencent/mobileqq/activity/QQBrowserActivity:getResources	()Landroid/content/res/Resources;
    //   405: ldc_w 339
    //   408: invokevirtual 195	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   411: invokevirtual 199	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   414: aload 6
    //   416: astore 4
    //   418: aload_0
    //   419: getfield 110	com/tencent/mobileqq/vastrash/ColorRingPlayer:m	Landroid/widget/ImageView;
    //   422: iconst_0
    //   423: invokevirtual 237	android/widget/ImageView:setVisibility	(I)V
    //   426: aload 6
    //   428: astore 4
    //   430: aload_0
    //   431: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   434: new 341	com/tencent/mobileqq/vastrash/ColorRingPlayer$1
    //   437: dup
    //   438: aload_0
    //   439: aload 5
    //   441: invokespecial 344	com/tencent/mobileqq/vastrash/ColorRingPlayer$1:<init>	(Lcom/tencent/mobileqq/vastrash/ColorRingPlayer;Landroid/media/AudioManager;)V
    //   444: invokevirtual 348	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   447: aload 6
    //   449: astore 4
    //   451: aload_0
    //   452: ldc_w 350
    //   455: ldc_w 350
    //   458: lload_1
    //   459: iconst_0
    //   460: invokevirtual 353	com/tencent/mobileqq/vastrash/ColorRingPlayer:a	(Ljava/lang/String;Ljava/lang/String;JI)V
    //   463: return
    //   464: aload 6
    //   466: astore 4
    //   468: aload_0
    //   469: getfield 57	com/tencent/mobileqq/vastrash/ColorRingPlayer:b	Ljava/lang/Object;
    //   472: astore 5
    //   474: aload 6
    //   476: astore 4
    //   478: aload 5
    //   480: monitorenter
    //   481: aload_0
    //   482: getfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   485: invokevirtual 268	android/media/MediaPlayer:release	()V
    //   488: aload_0
    //   489: aconst_null
    //   490: putfield 59	com/tencent/mobileqq/vastrash/ColorRingPlayer:c	Landroid/media/MediaPlayer;
    //   493: aload 5
    //   495: monitorexit
    //   496: aload 6
    //   498: astore 4
    //   500: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +80 -> 583
    //   506: aload 6
    //   508: astore 4
    //   510: ldc_w 262
    //   513: iconst_2
    //   514: ldc_w 355
    //   517: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: return
    //   521: astore 8
    //   523: aload 5
    //   525: monitorexit
    //   526: aload 6
    //   528: astore 4
    //   530: aload 8
    //   532: athrow
    //   533: astore 8
    //   535: aload 5
    //   537: monitorexit
    //   538: aload 6
    //   540: astore 4
    //   542: aload 8
    //   544: athrow
    //   545: astore 5
    //   547: goto +37 -> 584
    //   550: astore 6
    //   552: aload 7
    //   554: astore 5
    //   556: aload 5
    //   558: astore 4
    //   560: aload 6
    //   562: invokevirtual 356	java/io/IOException:printStackTrace	()V
    //   565: aload 5
    //   567: ifnull +16 -> 583
    //   570: aload 5
    //   572: invokevirtual 283	android/content/res/AssetFileDescriptor:close	()V
    //   575: return
    //   576: astore 4
    //   578: aload 4
    //   580: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   583: return
    //   584: aload 4
    //   586: ifnull +18 -> 604
    //   589: aload 4
    //   591: invokevirtual 283	android/content/res/AssetFileDescriptor:close	()V
    //   594: goto +10 -> 604
    //   597: astore 4
    //   599: aload 4
    //   601: invokevirtual 286	java/lang/Exception:printStackTrace	()V
    //   604: aload 5
    //   606: athrow
    //   607: astore 5
    //   609: aload 4
    //   611: monitorexit
    //   612: aload 5
    //   614: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	ColorRingPlayer
    //   0	615	1	paramLong	long
    //   0	615	3	paramInt	int
    //   13	162	4	localObject1	Object
    //   204	11	4	localException1	Exception
    //   254	305	4	localObject2	Object
    //   576	14	4	localException2	Exception
    //   597	13	4	localException3	Exception
    //   56	480	5	localObject3	Object
    //   545	1	5	localObject4	Object
    //   554	51	5	localObject5	Object
    //   607	6	5	localObject6	Object
    //   62	68	6	localObject7	Object
    //   212	6	6	localObject8	Object
    //   250	7	6	localObject9	Object
    //   263	276	6	localIOException1	java.io.IOException
    //   550	11	6	localIOException2	java.io.IOException
    //   59	494	7	localObject10	Object
    //   521	10	8	localObject11	Object
    //   533	10	8	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   198	203	204	java/lang/Exception
    //   162	177	212	finally
    //   214	217	212	finally
    //   153	162	250	finally
    //   177	193	250	finally
    //   217	220	250	finally
    //   220	247	250	finally
    //   153	162	263	java/io/IOException
    //   177	193	263	java/io/IOException
    //   217	220	263	java/io/IOException
    //   220	247	263	java/io/IOException
    //   481	496	521	finally
    //   523	526	521	finally
    //   112	123	533	finally
    //   535	538	533	finally
    //   99	105	545	finally
    //   109	112	545	finally
    //   133	148	545	finally
    //   272	284	545	finally
    //   288	295	545	finally
    //   299	314	545	finally
    //   318	333	545	finally
    //   337	345	545	finally
    //   349	356	545	finally
    //   360	364	545	finally
    //   368	390	545	finally
    //   394	414	545	finally
    //   418	426	545	finally
    //   430	447	545	finally
    //   451	463	545	finally
    //   468	474	545	finally
    //   478	481	545	finally
    //   500	506	545	finally
    //   510	520	545	finally
    //   530	533	545	finally
    //   542	545	545	finally
    //   560	565	545	finally
    //   99	105	550	java/io/IOException
    //   109	112	550	java/io/IOException
    //   133	148	550	java/io/IOException
    //   272	284	550	java/io/IOException
    //   288	295	550	java/io/IOException
    //   299	314	550	java/io/IOException
    //   318	333	550	java/io/IOException
    //   337	345	550	java/io/IOException
    //   349	356	550	java/io/IOException
    //   360	364	550	java/io/IOException
    //   368	390	550	java/io/IOException
    //   394	414	550	java/io/IOException
    //   418	426	550	java/io/IOException
    //   430	447	550	java/io/IOException
    //   451	463	550	java/io/IOException
    //   468	474	550	java/io/IOException
    //   478	481	550	java/io/IOException
    //   500	506	550	java/io/IOException
    //   510	520	550	java/io/IOException
    //   530	533	550	java/io/IOException
    //   542	545	550	java/io/IOException
    //   570	575	576	java/lang/Exception
    //   589	594	597	java/lang/Exception
    //   52	58	607	finally
    //   69	81	607	finally
    //   81	84	607	finally
    //   609	612	607	finally
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
      a(DataFactory.a("startDownloadColorRing", "", this.v.key, (Bundle)localObject));
      return;
    }
    if (AppNetConnInfo.isMobileConn())
    {
      localObject = new ColorRingPlayer.4(this, this.e.getActivity(), 2131953338);
      ((QQCustomDialog)localObject).setContentView(2131624611);
      ((QQCustomDialog)localObject).setTitle(HardCodeUtil.a(2131900356));
      ((QQCustomDialog)localObject).setMessage(2131917215);
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject).setNegativeButton(2131887648, new ColorRingPlayer.5(this));
      ((QQCustomDialog)localObject).setPositiveButton(2131892267, new ColorRingPlayer.6(this, paramLong, paramInt, paramString));
      ((QQCustomDialog)localObject).show();
      return;
    }
    b(paramLong, paramInt, paramString);
  }
  
  void a(long paramLong, String paramString)
  {
    if ("colorring".equals(paramString)) {
      this.o.setText(2131887865);
    } else if ("comering".equals(paramString)) {
      this.o.setText(2131887969);
    }
    this.m.setTag(paramString);
    this.l.setTag(paramString);
    if (paramLong == 0L)
    {
      a(paramLong, 0);
      if (b(paramLong, paramString))
      {
        this.l.setText(this.e.getResources().getString(2131887862));
        this.l.setEnabled(false);
      }
      else
      {
        if (paramString.equals("colorring")) {
          this.l.setText(this.e.getResources().getString(2131916284));
        } else if (paramString.equals("comering")) {
          this.l.setText(this.e.getResources().getString(2131916285));
        }
        this.l.setEnabled(true);
      }
      this.m.setImageDrawable(this.e.getResources().getDrawable(2130848968));
      this.j.setImageDrawable(this.e.getResources().getDrawable(2130848966));
      this.k.setVisibility(8);
      this.q.setText(this.e.getResources().getString(2131888412));
      this.p.setText("");
      return;
    }
    if (b(paramLong, paramString)) {
      this.l.setEnabled(false);
    }
    if (!new File(ColorRingManager.a(paramLong, 3)).exists())
    {
      this.m.setImageDrawable(this.e.getResources().getDrawable(2130848967));
      this.m.setVisibility(0);
      if (paramString.equals("colorring")) {
        this.l.setText(this.e.getResources().getString(2131916284));
      } else if (paramString.equals("comering")) {
        this.l.setText(this.e.getResources().getString(2131916285));
      }
      this.l.setEnabled(true);
      a(paramLong, 3, paramString);
    }
    else
    {
      a(paramLong, 0);
      if (b(paramLong, paramString))
      {
        this.l.setEnabled(false);
        this.l.setText(this.e.getResources().getString(2131887862));
      }
      else
      {
        if (paramString.equals("colorring")) {
          this.l.setText(this.e.getResources().getString(2131916284));
        } else if (paramString.equals("comering")) {
          this.l.setText(this.e.getResources().getString(2131916285));
        }
        this.l.setEnabled(true);
      }
    }
    if (!new File(ColorRingManager.a(paramLong, 1)).exists())
    {
      this.j.setImageDrawable(this.e.getResources().getDrawable(2130848965));
      a(paramLong, 1, paramString);
    }
    else if (ColorRingManager.b(paramLong) != null)
    {
      this.j.setImageBitmap(ColorRingManager.b(paramLong));
    }
    if (!new File(ColorRingManager.a(paramLong, 2)).exists())
    {
      this.q.setText("");
      this.p.setText("");
      a(paramLong, 2, paramString);
      return;
    }
    a(ColorRingManager.a(paramLong));
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String arg5)
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.a.b == paramLong) {
          if (paramInt == 0)
          {
            this.l.setText(this.e.getResources().getString(2131887862));
            this.l.setEnabled(false);
            if (paramString1.equals("colorring"))
            {
              if (paramInt != 0) {
                break label210;
              }
              paramInt = 0;
              a("0X8004A24", "0X8004A24", paramLong, paramInt);
            }
            else if (paramString1.equals("comering"))
            {
              if (paramInt != 0) {
                break label216;
              }
              paramInt = 0;
              a("0X8005003", "0X8005003", paramLong, paramInt);
            }
            Bundle localBundle = new Bundle();
            localBundle.putLong("id", paramLong);
            localBundle.putString("colorType", paramString1);
            a(DataFactory.a("colorRingSetup", "", this.v.key, localBundle));
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ColorRingPlayer", 2, "setup failure.");
          }
        }
        this.s.setVisibility(8);
        return;
      }
      label210:
      paramInt = 1;
      continue;
      label216:
      paramInt = 1;
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if ((this.a.b == paramLong) && (this.a.c.equals(paramString1)))
    {
      if (this.a.a == 6) {
        a(paramLong, 0);
      }
      return;
    }
    if (this.a.a == 1) {
      a(this.a.b);
    }
    b();
    ColorRingPlayer.PlayerStatus localPlayerStatus = this.a;
    localPlayerStatus.b = paramLong;
    localPlayerStatus.c = paramString1;
    localPlayerStatus.d = paramString2;
    localPlayerStatus.a = 0;
    this.s.setVisibility(8);
    a(paramLong, paramString1);
  }
  
  void a(Bundle paramBundle)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      Toast.makeText(this.e.getApplicationContext(), HardCodeUtil.a(2131900355), 0).show();
      return;
    }
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramBundle);
  }
  
  public void a(String arg1)
  {
    ??? = this.c;
    if ((??? != null) && (???.isPlaying()))
    {
      this.d = this.c.getCurrentPosition();
      this.c.stop();
      this.c.release();
      this.c = null;
      this.m.setImageDrawable(this.e.getResources().getDrawable(2130848969));
      synchronized (this.a)
      {
        this.a.a = 6;
        this.h = false;
      }
    }
    ??? = this.i;
    if ((??? != null) && (???.getVisibility() == 0)) {
      this.i.setVisibility(8);
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
      this.p.setText(paramJSONObject.getString("singer"));
      this.q.setText(paramJSONObject.getString("name"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  void b()
  {
    synchronized (this.b)
    {
      if (this.c != null)
      {
        this.c.stop();
        this.c.release();
        this.c = null;
      }
      this.n.setProgress(0);
      return;
    }
  }
  
  void b(long paramLong, int paramInt, String arg4)
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putLong("id", paramLong);
    ((Bundle)localObject1).putInt("resourceType", paramInt);
    ((Bundle)localObject1).putString("colorType", ???);
    a(DataFactory.a("startDownloadColorRing", "", this.v.key, (Bundle)localObject1));
    synchronized (this.a)
    {
      this.a.a = 1;
      this.k.setVisibility(0);
      ??? = null;
      if (this.t == null) {}
      try
      {
        localObject1 = BitmapFactory.decodeResource(this.e.getResources(), 2130850524);
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
      this.t = new PhotoProgressDrawable((Bitmap)localObject1, (int)(this.e.getResources().getDisplayMetrics().density * 12.0F));
      ??? = new Rect();
      ???.set(0, 0, this.e.getResources().getDimensionPixelSize(2131297030), this.e.getResources().getDimensionPixelSize(2131297029));
      this.t.setBounds(???);
      this.k.setImageDrawable(this.t);
      this.t.setLevel(0);
      this.t.invalidateSelf();
      this.n.setProgress(0);
      this.l.setText(this.e.getResources().getString(2131887863));
      this.m.setVisibility(8);
      return;
    }
  }
  
  boolean b(long paramLong, String paramString)
  {
    Object localObject = (BrowserAppInterface)this.e.getAppRuntime();
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
  
  void c()
  {
    synchronized (this.b)
    {
      if (this.c == null) {
        synchronized (this.a)
        {
          long l1 = this.a.b;
          a(l1, this.d);
        }
      }
      this.c.seekTo(this.d);
      this.c.start();
      d();
      this.m.setImageDrawable(this.e.getResources().getDrawable(2130848968));
      synchronized (this.a)
      {
        this.a.a = 4;
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
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.v);
    ??? = (AudioManager)this.e.getSystemService("audio");
    if (??? == null) {
      return;
    }
    ((AudioManager)???).abandonAudioFocus(this.u);
    synchronized (this.b)
    {
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
      return;
    }
  }
  
  public void f()
  {
    synchronized (this.b)
    {
      if ((this.c != null) && (this.c.isPlaying()))
      {
        this.d = this.c.getCurrentPosition();
        this.c.stop();
        this.c.release();
        this.c = null;
        this.m.setImageDrawable(this.e.getResources().getDrawable(2130848969));
        synchronized (this.a)
        {
          this.a.a = 6;
          this.h = true;
        }
      }
      this.g = false;
      return;
    }
  }
  
  public void g()
  {
    this.g = true;
  }
  
  public void h()
  {
    ViewGroup localViewGroup = this.i;
    if ((localViewGroup != null) && (localViewGroup.getVisibility() != 0)) {
      this.i.setVisibility(0);
    }
  }
  
  public void onClick(View paramView)
  {
    ??? = (String)paramView.getTag();
    Object localObject1 = ???;
    if (??? == null) {
      localObject1 = "colorring";
    }
    int i1 = paramView.getId();
    if (i1 != 2131427516)
    {
      if (i1 != 2131431466) {
        break label379;
      }
      synchronized (this.a)
      {
        if (this.a.a == 4)
        {
          a();
        }
        else if (this.a.a == 5)
        {
          c();
        }
        else if (this.a.a == 6)
        {
          a(this.a.b, 0);
        }
        else if (this.a.a == 1)
        {
          a(this.a.b);
          this.a.a = 2;
        }
        else if (this.a.a == 2)
        {
          a(this.a.b, 3, (String)localObject1);
        }
        else if (this.a.a == 0)
        {
          a(this.a.b, 3, (String)localObject1);
        }
        else if (this.a.a == 3)
        {
          a(this.a.b, 0);
        }
      }
    }
    synchronized (this.a)
    {
      if (this.a.a == 1)
      {
        a(this.a.b);
      }
      else if (this.a.a == 2)
      {
        a(this.a.b, 3, (String)localObject1);
      }
      else if (this.a.a == 0)
      {
        a(this.a.b, 3, (String)localObject1);
      }
      else if (this.a.a >= 3)
      {
        localObject1 = this.e.getCurrentWebViewFragment();
        if (localObject1 != null) {
          ((WebViewFragment)localObject1).getWebView().callJs(this.a.d, new String[] { "{'result':0,'message':'OK'}" });
        }
        this.s.setVisibility(0);
      }
      label379:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer
 * JD-Core Version:    0.7.0.1
 */