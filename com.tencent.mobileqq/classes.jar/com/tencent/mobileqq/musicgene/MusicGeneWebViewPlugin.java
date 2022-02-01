package com.tencent.mobileqq.musicgene;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicGeneWebViewPlugin
  extends WebViewPlugin
  implements IPreCreatePluginChecker
{
  private Context a = null;
  private boolean b = false;
  private boolean c = false;
  private IQQPlayerService d = null;
  private Timer e = new Timer();
  private int f = 0;
  private int g = 0;
  private SongInfo h = null;
  private int i = 0;
  private JsBridgeListener j = null;
  private ServiceConnection k = new MusicGeneWebViewPlugin.1(this);
  private IQQPlayerCallback.Stub l = new MusicGeneWebViewPlugin.2(this);
  private BroadcastReceiver m = new MusicGeneWebViewPlugin.3(this);
  private Handler n = new MusicGeneWebViewPlugin.4(this, Looper.getMainLooper());
  
  public MusicGeneWebViewPlugin()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = BitmapFactory.decodeStream(paramString.getInputStream());
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private HashMap<String, JSONObject> a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i1 = 0;
    try
    {
      while (i1 < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i1 += 1;
      }
      return localHashMap;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  private JSONObject a(SongInfo paramSongInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramSongInfo != null)
    {
      localJSONObject.put("playUrl", paramSongInfo.d);
      localJSONObject.put("songPage", paramSongInfo.h);
      localJSONObject.put("songId", paramSongInfo.a);
      localJSONObject.put("songName", paramSongInfo.e);
      localJSONObject.put("singerName", paramSongInfo.j);
      localJSONObject.put("albumName", paramSongInfo.i);
      localJSONObject.put("albumImg", paramSongInfo.g);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    MusicGeneWebViewPlugin.6 local6 = new MusicGeneWebViewPlugin.6(this);
    this.e.schedule(local6, 1000L, 1000L);
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = Base64Util.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("data:image\\/jpg;base64,");
      ((StringBuilder)localObject).append(paramBitmap);
      localObject = ((StringBuilder)localObject).toString();
      paramBitmap = new JSONObject();
      try
      {
        paramBitmap.put("code", "0");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("imgUrl", localObject);
        paramBitmap.put("data", localJSONObject);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
    }
  }
  
  private boolean a(int paramInt)
  {
    IQQPlayerService localIQQPlayerService = this.d;
    int i1;
    int i2;
    JSONObject localJSONObject;
    if ((this.b) && (localIQQPlayerService != null))
    {
      try
      {
        i1 = localIQQPlayerService.m();
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        i1 = 0;
      }
      i2 = c(paramInt);
      localJSONObject = new JSONObject();
      try
      {
        Bundle localBundle = this.d.q();
        if (localBundle != null) {
          paramInt = localBundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
        }
      }
      catch (JSONException localJSONException) {}catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    for (;;)
    {
      localJSONObject.put("state", i2);
      localJSONObject.put("index", i1);
      localJSONObject.put("playType", paramInt);
      boolean bool = g();
      if (bool)
      {
        localJSONObject.put("code", "0");
      }
      else
      {
        localJSONObject.put("code", "0");
        break label171;
        localException.printStackTrace();
      }
      label171:
      callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", localJSONObject.toString() }));
      return true;
      return false;
      paramInt = 0;
    }
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    if (paramJSONObject.has("list"))
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("list");
      SongInfo[] arrayOfSongInfo = new SongInfo[localJSONArray.length()];
      int i1 = 0;
      for (;;)
      {
        localObject = arrayOfSongInfo;
        if (i1 >= localJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i1);
        if (localJSONObject != null)
        {
          boolean bool = localJSONObject.has("songId");
          String str = "";
          if (bool) {
            paramJSONObject = localJSONObject.getString("songId");
          } else {
            paramJSONObject = "";
          }
          SongInfo localSongInfo = new SongInfo();
          if (localJSONObject.has("songName")) {
            localObject = localJSONObject.getString("songName");
          } else {
            localObject = "";
          }
          localSongInfo.e = ((String)localObject);
          if (localJSONObject.has("playUrl")) {
            localObject = localJSONObject.getString("playUrl");
          } else {
            localObject = "";
          }
          localSongInfo.d = ((String)localObject);
          if (localJSONObject.has("albumName")) {
            localObject = localJSONObject.getString("albumName");
          } else {
            localObject = "";
          }
          localSongInfo.f = ((String)localObject);
          if (localJSONObject.has("albumImg")) {
            localObject = localJSONObject.getString("albumImg");
          } else {
            localObject = "";
          }
          localSongInfo.g = ((String)localObject);
          if (localJSONObject.has("songPage")) {
            localObject = localJSONObject.getString("songPage");
          } else {
            localObject = "";
          }
          localSongInfo.h = ((String)localObject);
          long l1;
          if (TextUtils.isEmpty(paramJSONObject)) {
            l1 = 0L;
          } else {
            l1 = Long.parseLong(paramJSONObject);
          }
          localSongInfo.a = l1;
          if (localJSONObject.has("albumName")) {
            paramJSONObject = localJSONObject.getString("albumName");
          } else {
            paramJSONObject = "";
          }
          localSongInfo.i = paramJSONObject;
          if (localJSONObject.has("singerName")) {
            paramJSONObject = localJSONObject.getString("singerName");
          } else {
            paramJSONObject = "";
          }
          localSongInfo.j = paramJSONObject;
          paramJSONObject = str;
          if (localJSONObject.has("songmid")) {
            paramJSONObject = localJSONObject.getString("songmid");
          }
          localSongInfo.b = paramJSONObject;
          arrayOfSongInfo[i1] = localSongInfo;
        }
        i1 += 1;
      }
    }
    return localObject;
  }
  
  private int b(int paramInt)
  {
    int i2 = 103;
    int i1;
    if (paramInt != 0)
    {
      i1 = i2;
      if (paramInt != 1)
      {
        i1 = i2;
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return 103;
          }
          return 101;
        }
      }
    }
    else
    {
      i1 = 102;
    }
    return i1;
  }
  
  private void b()
  {
    this.e.cancel();
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.parse(paramString);
        localObject = paramString.getScheme();
        if ((!"http".equalsIgnoreCase((String)localObject)) && (!"https".equalsIgnoreCase((String)localObject)))
        {
          QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
          return false;
        }
        paramString = paramString.getHost();
        if (!TextUtils.isEmpty(paramString)) {
          if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")) && (!paramString.contains("imgcache.gtimg.cn")) && (!paramString.contains("article.mp.qq.com")))
          {
            boolean bool = paramString.contains("post.mp.qq.com");
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("MusicGeneWebViewPlugin", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  private int c(int paramInt)
  {
    int i1 = 0;
    switch (paramInt)
    {
    default: 
      return 0;
    case 6: 
      return -1001;
    case 3: 
      return 2;
    case 2: 
      return 1;
    case 1: 
      i1 = 4;
    }
    return i1;
  }
  
  private SongInfo c()
  {
    SongInfo localSongInfo = this.h;
    if (localSongInfo == null)
    {
      Object localObject = this.d;
      if (localObject != null) {
        try
        {
          localObject = ((IQQPlayerService)localObject).k();
          return localObject;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return localSongInfo;
  }
  
  private int d()
  {
    if (this.f <= 0)
    {
      IQQPlayerService localIQQPlayerService = this.d;
      if (localIQQPlayerService != null) {
        try
        {
          this.f = localIQQPlayerService.i();
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
      }
    }
    return this.f;
  }
  
  private void e()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	Z
    //   4: ifeq +467 -> 471
    //   7: aconst_null
    //   8: astore 9
    //   10: aload_0
    //   11: invokespecial 422	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	()Lcom/tencent/mobileqq/music/SongInfo;
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   27: invokeinterface 424 1 0
    //   32: istore_1
    //   33: goto +5 -> 38
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_0
    //   39: invokespecial 426	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	()I
    //   42: istore_3
    //   43: aload 5
    //   45: astore 8
    //   47: iload_1
    //   48: istore_2
    //   49: goto +33 -> 82
    //   52: astore 6
    //   54: goto +15 -> 69
    //   57: astore 6
    //   59: goto +8 -> 67
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 5
    //   67: iconst_0
    //   68: istore_1
    //   69: aload 6
    //   71: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_1
    //   77: istore_2
    //   78: aload 5
    //   80: astore 8
    //   82: ldc_w 256
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull +120 -> 215
    //   98: aload_0
    //   99: aload 5
    //   101: invokeinterface 428 1 0
    //   106: invokespecial 291	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	(I)I
    //   109: istore 4
    //   111: aload 6
    //   113: astore 5
    //   115: aload_0
    //   116: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   119: invokeinterface 295 1 0
    //   124: astore 10
    //   126: aload 9
    //   128: astore 7
    //   130: aload 6
    //   132: astore 5
    //   134: iload 4
    //   136: istore_1
    //   137: aload 10
    //   139: ifnull +86 -> 225
    //   142: aload 6
    //   144: astore 5
    //   146: aload 10
    //   148: ldc_w 430
    //   151: invokevirtual 431	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 6
    //   156: aload 6
    //   158: astore 5
    //   160: new 154	org/json/JSONObject
    //   163: dup
    //   164: aload 10
    //   166: ldc_w 260
    //   169: invokevirtual 431	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokespecial 432	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore 7
    //   177: aload 6
    //   179: astore 5
    //   181: iload 4
    //   183: istore_1
    //   184: goto +41 -> 225
    //   187: astore 7
    //   189: iload 4
    //   191: istore_1
    //   192: goto +11 -> 203
    //   195: astore 7
    //   197: iconst_0
    //   198: istore_1
    //   199: aload 6
    //   201: astore 5
    //   203: aload 7
    //   205: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   208: aload 9
    //   210: astore 7
    //   212: goto +13 -> 225
    //   215: iconst_0
    //   216: istore_1
    //   217: aload 6
    //   219: astore 5
    //   221: aload 9
    //   223: astore 7
    //   225: aload 7
    //   227: astore 6
    //   229: aload 7
    //   231: ifnonnull +12 -> 243
    //   234: new 154	org/json/JSONObject
    //   237: dup
    //   238: invokespecial 169	org/json/JSONObject:<init>	()V
    //   241: astore 6
    //   243: aload 8
    //   245: ifnull +226 -> 471
    //   248: aload_0
    //   249: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   252: ifnull +221 -> 473
    //   255: aload_0
    //   256: getfield 43	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   259: invokeinterface 295 1 0
    //   264: astore 7
    //   266: aload 7
    //   268: ifnull +205 -> 473
    //   271: aload 7
    //   273: ldc_w 297
    //   276: iconst_0
    //   277: invokevirtual 303	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   280: istore 4
    //   282: goto +13 -> 295
    //   285: astore 7
    //   287: aload 7
    //   289: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   292: goto +181 -> 473
    //   295: aload_0
    //   296: aload 8
    //   298: invokespecial 434	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   301: astore 7
    //   303: aload 7
    //   305: ifnull +50 -> 355
    //   308: aload 7
    //   310: invokevirtual 438	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   313: astore 8
    //   315: aload 8
    //   317: invokeinterface 443 1 0
    //   322: ifeq +33 -> 355
    //   325: aload 8
    //   327: invokeinterface 447 1 0
    //   332: checkcast 268	java/lang/String
    //   335: astore 9
    //   337: aload 6
    //   339: aload 9
    //   341: aload 7
    //   343: aload 9
    //   345: invokevirtual 450	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   348: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: goto -37 -> 315
    //   355: aload 6
    //   357: ldc_w 452
    //   360: iload_2
    //   361: sipush 1000
    //   364: idiv
    //   365: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 6
    //   371: ldc_w 454
    //   374: iload_3
    //   375: sipush 1000
    //   378: idiv
    //   379: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload 6
    //   385: ldc_w 456
    //   388: invokevirtual 331	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: ifne +14 -> 405
    //   394: aload 6
    //   396: ldc_w 456
    //   399: aload 5
    //   401: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   404: pop
    //   405: aload 6
    //   407: ldc_w 306
    //   410: iload_1
    //   411: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload 6
    //   417: ldc_w 313
    //   420: iload 4
    //   422: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   425: pop
    //   426: goto +10 -> 436
    //   429: astore 5
    //   431: aload 5
    //   433: invokevirtual 304	java/lang/Exception:printStackTrace	()V
    //   436: aload 6
    //   438: ifnull +33 -> 471
    //   441: aload_0
    //   442: ldc_w 318
    //   445: iconst_2
    //   446: anewarray 264	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: ldc_w 458
    //   454: aastore
    //   455: dup
    //   456: iconst_1
    //   457: aload 6
    //   459: invokevirtual 321	org/json/JSONObject:toString	()Ljava/lang/String;
    //   462: aastore
    //   463: invokestatic 272	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokevirtual 275	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:callJs	(Ljava/lang/String;)V
    //   469: iconst_1
    //   470: ireturn
    //   471: iconst_0
    //   472: ireturn
    //   473: iconst_0
    //   474: istore 4
    //   476: goto -181 -> 295
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	MusicGeneWebViewPlugin
    //   32	379	1	i1	int
    //   48	317	2	i2	int
    //   42	337	3	i3	int
    //   109	366	4	i4	int
    //   14	386	5	localObject1	Object
    //   429	3	5	localException1	Exception
    //   52	1	6	localException2	Exception
    //   57	1	6	localException3	Exception
    //   62	8	6	localException4	Exception
    //   85	373	6	localObject2	Object
    //   128	48	7	localObject3	Object
    //   187	1	7	localException5	Exception
    //   195	9	7	localException6	Exception
    //   210	62	7	localObject4	Object
    //   285	3	7	localException7	Exception
    //   301	41	7	localJSONObject	JSONObject
    //   45	281	8	localObject5	Object
    //   8	336	9	str	String
    //   124	41	10	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   38	43	52	java/lang/Exception
    //   16	33	57	java/lang/Exception
    //   10	16	62	java/lang/Exception
    //   115	126	187	java/lang/Exception
    //   146	156	187	java/lang/Exception
    //   160	177	187	java/lang/Exception
    //   98	111	195	java/lang/Exception
    //   248	266	285	java/lang/Exception
    //   271	282	285	java/lang/Exception
    //   287	292	429	java/lang/Exception
    //   295	303	429	java/lang/Exception
    //   308	315	429	java/lang/Exception
    //   315	352	429	java/lang/Exception
    //   355	405	429	java/lang/Exception
    //   405	426	429	java/lang/Exception
  }
  
  private boolean g()
  {
    Object localObject = this.d;
    if (localObject != null) {
      try
      {
        localObject = ((IQQPlayerService)localObject).r();
        String str = j();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = ((String)localObject).equals(str);
          if (bool) {
            return true;
          }
        }
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
    }
    return false;
  }
  
  private void h()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.d();
        if ((localActivity != null) && (this.d == null))
        {
          localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.k, 33);
          QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService end!");
          return;
        }
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService activity is null!");
        return;
      }
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
    }
  }
  
  private void i()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.d();
        if (localActivity != null) {
          localActivity.unbindService(this.k);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private String j()
  {
    try
    {
      if (k()) {
        return MusicPendantUtil.a();
      }
      String str = this.d.a(3, "MusicGeneWebViewPlugin");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private boolean k()
  {
    int i1 = this.i;
    boolean bool = true;
    if (1 != i1)
    {
      if (2 == i1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934594L) && (this.a != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.a.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject2 = new ArrayList(Arrays.asList(paramVarArgs));
    Object localObject3;
    long l1;
    int i1;
    label286:
    label307:
    label366:
    label629:
    int i2;
    label962:
    label1003:
    int i3;
    if ("qqmusic".equals(paramString2))
    {
      boolean bool = "webCallApp".equals(paramString3);
      localObject3 = "playType";
      if (bool)
      {
        paramString1 = (String)((ArrayList)localObject2).get(0);
        try
        {
          paramString1 = new JSONObject(paramString1);
          if (!paramString1.has("action")) {
            break label3008;
          }
          paramString3 = paramString1.getString("action");
          if (!paramString1.has("data")) {
            break label3026;
          }
          paramString2 = paramString1.getJSONObject("data");
          if ((paramString2 != null) && (paramString2.has("playType"))) {
            this.i = paramString2.getInt("playType");
          } else {
            this.i = 0;
          }
          bool = "MANUAL_INIT".equals(paramString3);
          if (bool) {
            try
            {
              QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handle js request: MANUAL_INIT");
              if (this.d == null)
              {
                this.j = paramJsBridgeListener;
                h();
                return true;
              }
              paramString1 = new JSONObject();
              paramString1.put("code", "0");
              paramJsBridgeListener.a(paramString1);
              return true;
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handle js request get exception in ACTION_MANUAL_INIT", paramJsBridgeListener);
              return true;
            }
          }
          Object localObject5 = this.d;
          if (localObject5 == null) {
            return false;
          }
          bool = "SONG_PLAY".equals(paramString3);
          paramString1 = "1";
          Object localObject4;
          if (bool)
          {
            paramVarArgs = a(paramString2);
            if (paramVarArgs == null) {
              break label3057;
            }
            l1 = 0L;
            if (!paramString2.has("index")) {
              break label3031;
            }
            i1 = paramString2.getInt("index");
            if (!paramString2.has("geneId")) {
              break label3037;
            }
            paramString1 = paramString2.getString("geneId");
            if (paramString2.has("uin")) {
              l1 = paramString2.getLong("uin");
            }
            if (paramString2.has("geneType")) {
              paramString2.getString("geneType");
            }
            if (!paramString2.has("list")) {
              break label3044;
            }
            paramString3 = paramString2.getJSONArray("list");
            localObject3 = String.valueOf(l1);
            localObject2 = new Intent(this.a, MusicPlayerActivity.class);
            localObject4 = String.format("https://y.qq.com/m/recent_listen/play.html?uin=%s&_bid=266&_wv=14115", new Object[] { localObject3 });
            ((Intent)localObject2).putExtra("uin", (String)localObject3);
            ((Intent)localObject2).putExtra("url", (String)localObject4);
            ((Intent)localObject2).putExtra("BUNDLE_KEY_FROM_PLAY_BAR", true);
            if (paramString2.has("pageUrl"))
            {
              localObject3 = paramString2.getString("pageUrl");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                ((Intent)localObject2).putExtra("url", (String)localObject3);
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putLong("BUNDLE_KEY_UIN", l1);
            ((Bundle)localObject3).putString("BUNDLE_KEY_GENE_ID", paramString1);
            ((Bundle)localObject3).putInt("BUNDLE_KEY_PLAY_TYPE", this.i);
            if (paramString3 != null) {
              ((Bundle)localObject3).putString("BUNDLE_KEY_JSONARRAY_SONG_LIST", paramString3.toString());
            }
            ((Bundle)localObject3).putString("data", paramString2.toString());
            try
            {
              ((IQQPlayerService)localObject5).a((Bundle)localObject3);
              ((IQQPlayerService)localObject5).a(this.l);
              ((IQQPlayerService)localObject5).a((Intent)localObject2);
              if (k()) {
                ((IQQPlayerService)localObject5).a(102);
              } else {
                ((IQQPlayerService)localObject5).a(103);
              }
              ((IQQPlayerService)localObject5).a(j(), paramVarArgs, i1);
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
            }
            paramString2 = new JSONObject();
            paramString2.put("code", paramString1);
            paramJsBridgeListener.a(paramString2);
          }
          else if ("SONG_PAUSE".equals(paramString3))
          {
            this.g = ((IQQPlayerService)localObject5).j();
            ((IQQPlayerService)localObject5).a();
            paramString1 = new JSONObject();
            paramString1.put("code", "0");
            paramJsBridgeListener.a(paramString1);
          }
          else
          {
            paramString1 = "0";
            if ("SONG_RESUME".equals(paramString3))
            {
              ((IQQPlayerService)localObject5).b();
              paramString2 = new JSONObject();
              paramString2.put("code", paramString1);
              paramJsBridgeListener.a(paramString2);
            }
            else if ("SONG_STOP".equals(paramString3))
            {
              ((IQQPlayerService)localObject5).c();
              paramString2 = new JSONObject();
              paramString2.put("code", paramString1);
              paramJsBridgeListener.a(paramString2);
            }
            else if ("SONG_PLAY_NEXT".equals(paramString3))
            {
              ((IQQPlayerService)localObject5).d();
              paramString2 = new JSONObject();
              paramString2.put("code", paramString1);
              paramJsBridgeListener.a(paramString2);
            }
            else if ("SONG_PLAY_PREV".equals(paramString3))
            {
              ((IQQPlayerService)localObject5).e();
              paramString2 = new JSONObject();
              paramString2.put("code", paramString1);
              paramJsBridgeListener.a(paramString2);
            }
            else
            {
              bool = "SONG_GET_SONG_INFO".equals(paramString3);
              if (bool)
              {
                try
                {
                  paramString2 = ((IQQPlayerService)localObject5).q();
                  paramVarArgs = paramString2;
                  if (paramString2 == null) {
                    break label3060;
                  }
                  paramVarArgs = paramString2;
                  try
                  {
                    if (!paramString2.containsKey("data")) {
                      break label3060;
                    }
                    paramString3 = new JSONObject(paramString2.getString("data"));
                  }
                  catch (Exception paramString3) {}
                  paramString3.printStackTrace();
                }
                catch (Exception paramString3)
                {
                  paramString2 = null;
                }
                paramVarArgs = paramString2;
                break label3060;
                paramVarArgs = paramString3;
                if (paramString3 == null) {
                  paramVarArgs = new JSONObject();
                }
                localObject2 = c();
                if (paramString2 == null) {
                  break label3069;
                }
                i1 = paramString2.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
                if ((paramString2 == null) || (!paramString2.containsKey("BUNDLE_KEY_UIN"))) {
                  break label3075;
                }
                l1 = paramString2.getLong("BUNDLE_KEY_UIN");
                label1029:
                if (localObject2 != null)
                {
                  if ((paramString2 == null) || (!paramString2.containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST"))) {
                    break label3081;
                  }
                  paramString2 = (JSONObject)a(new JSONArray(paramString2.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"))).get(String.valueOf(((SongInfo)localObject2).a));
                  label1084:
                  paramString3 = paramString2;
                  if (paramString2 == null) {
                    paramString3 = a((SongInfo)localObject2);
                  }
                  if (paramString3 != null)
                  {
                    paramString2 = paramString3.keys();
                    while (paramString2.hasNext())
                    {
                      localObject2 = (String)paramString2.next();
                      paramVarArgs.put((String)localObject2, paramString3.get((String)localObject2));
                    }
                  }
                  long l2 = d();
                  i2 = ((IQQPlayerService)localObject5).g();
                  i3 = c(i2);
                  if (i2 == 3)
                  {
                    i2 = this.g;
                    break label3086;
                  }
                  i2 = ((IQQPlayerService)localObject5).j();
                  break label3086;
                  label1199:
                  if (g()) {
                    paramVarArgs.put("code", paramString1);
                  } else {
                    paramVarArgs.put("code", paramString1);
                  }
                  Object localObject1;
                  paramVarArgs.put("curTime", localObject1 / 1000L);
                  paramVarArgs.put("totalTime", l2 / 1000L);
                  paramVarArgs.put("state", i3);
                  paramVarArgs.put("playType", i1);
                }
                else
                {
                  paramVarArgs.put("code", "1");
                  paramVarArgs.put("playType", i1);
                }
                if (!paramVarArgs.has("uin")) {
                  paramVarArgs.put("uin", l1);
                }
                paramJsBridgeListener.a(paramVarArgs);
              }
              else
              {
                bool = "SONG_GET_LIST_INFO".equals(paramString3);
                if (bool)
                {
                  try
                  {
                    paramString2 = ((IQQPlayerService)localObject5).q();
                    paramVarArgs = paramString2;
                    if (paramString2 == null) {
                      break label3094;
                    }
                    paramVarArgs = paramString2;
                    try
                    {
                      if (!paramString2.containsKey("data")) {
                        break label3094;
                      }
                      paramString3 = new JSONObject(paramString2.getString("data"));
                      localObject2 = paramString2;
                    }
                    catch (Exception paramString3) {}
                    paramString3.printStackTrace();
                  }
                  catch (Exception paramString3)
                  {
                    paramString2 = null;
                  }
                  paramVarArgs = paramString2;
                  break label3094;
                  label1420:
                  paramVarArgs = paramString3;
                  if (paramString3 == null) {
                    paramVarArgs = new JSONObject();
                  }
                  if (localObject2 == null) {
                    break label3104;
                  }
                  i3 = ((Bundle)localObject2).getInt("BUNDLE_KEY_PLAY_TYPE", 0);
                  label1457:
                  if ((localObject2 == null) || (!((Bundle)localObject2).containsKey("BUNDLE_KEY_UIN"))) {
                    break label3110;
                  }
                  l1 = ((Bundle)localObject2).getLong("BUNDLE_KEY_UIN");
                  label1486:
                  if (localObject2 == null) {
                    break label3121;
                  }
                  if (!((Bundle)localObject2).containsKey("BUNDLE_KEY_GENE_ID")) {
                    break label3116;
                  }
                  paramString2 = ((Bundle)localObject2).getString("BUNDLE_KEY_GENE_ID");
                  label1514:
                  paramString3 = paramString2;
                  if (!((Bundle)localObject2).containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST")) {
                    break label3124;
                  }
                  paramString3 = new JSONArray(((Bundle)localObject2).getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"));
                  localObject2 = paramString2;
                  paramString2 = paramString3;
                  label1554:
                  if (paramString2 == null)
                  {
                    paramString2 = new JSONArray();
                    localObject4 = ((IQQPlayerService)localObject5).o();
                    localSongInfo = c();
                    if (localObject4 == null) {
                      break label3159;
                    }
                    i1 = 0;
                    i2 = 0;
                    paramString3 = (String)localObject3;
                    localObject3 = localObject4;
                    label1600:
                    if (i1 >= localObject3.length) {
                      break label3142;
                    }
                    localObject4 = localObject3[i1];
                    if (localObject4 == null) {
                      break label3133;
                    }
                    paramString2.put(i1, a((SongInfo)localObject4));
                    if ((localSongInfo == null) || (((SongInfo)localObject4).a != localSongInfo.a)) {
                      break label3133;
                    }
                    i2 = i1;
                    break label3133;
                  }
                  localObject3 = "playType";
                  paramString3 = ((IQQPlayerService)localObject5).o();
                  localObject4 = c();
                  if (paramString3 == null) {
                    break label3194;
                  }
                  i2 = 0;
                  i1 = 0;
                  label1690:
                  if (i2 >= paramString3.length) {
                    break label3185;
                  }
                  SongInfo localSongInfo = paramString3[i2];
                  if ((localSongInfo == null) || (localSongInfo.a != ((SongInfo)localObject4).a)) {
                    break label3176;
                  }
                  i1 = i2;
                  break label3176;
                  label1731:
                  paramVarArgs.put("index", i1);
                  paramVarArgs.put("state", c(((IQQPlayerService)localObject5).g()));
                  if (!paramVarArgs.has("geneId")) {
                    paramVarArgs.put("geneId", localObject2);
                  }
                  paramVarArgs.put("list", paramString3);
                  if (g()) {
                    paramVarArgs.put("code", paramString1);
                  } else {
                    paramVarArgs.put("code", paramString1);
                  }
                  if (!paramVarArgs.has("uin")) {
                    paramVarArgs.put("uin", l1);
                  }
                  paramVarArgs.put(paramString2, i3);
                  paramJsBridgeListener.a(paramVarArgs);
                }
                else if ("SONG_SET_PLAYMODE".equals(paramString3))
                {
                  i2 = 103;
                  i1 = i2;
                  if (paramString2 != null)
                  {
                    i1 = i2;
                    if (paramString2.has("type")) {
                      i1 = paramString2.getInt("type");
                    }
                  }
                  ((IQQPlayerService)localObject5).a(b(i1));
                  paramString2 = new JSONObject();
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("SONG_SET_VOLUME".equals(paramString3))
                {
                  if ((paramString2 == null) || (!paramString2.has("volume"))) {
                    break label3206;
                  }
                  i1 = paramString2.getInt("volume");
                  label1983:
                  paramString2 = new JSONObject();
                  paramString3 = this.a;
                  if ((paramString3 == null) || (i1 < 0) || (i1 > 100)) {
                    break label3212;
                  }
                  paramString3 = (AudioManager)paramString3.getSystemService("audio");
                  if (paramString3 == null) {
                    break label3212;
                  }
                  paramString3.setStreamVolume(3, paramString3.getStreamMaxVolume(3) * i1 / 100, 4);
                  label2054:
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("DO_MACK_IMG".equals(paramString3))
                {
                  if ((paramString2 == null) || (!paramString2.has("imgUrl"))) {
                    break label3219;
                  }
                  paramString3 = paramString2.getString("imgUrl");
                  label2107:
                  if (!paramString2.has("degree")) {
                    break label3227;
                  }
                  i1 = paramString2.getInt("degree");
                  label2129:
                  paramString2 = MD5.toMD5(paramString3);
                  paramVarArgs = new StringBuilder();
                  paramVarArgs.append(AppConstants.SDCARD_PATH);
                  paramVarArgs.append(File.separator);
                  paramVarArgs.append("diskcache");
                  paramString2 = new File(new File(paramVarArgs.toString()), paramString2);
                  if (!paramString2.exists()) {
                    ThreadManager.post(new MusicGeneWebViewPlugin.5(this, paramString3, i1, paramString2), 8, null, true);
                  } else {
                    try
                    {
                      a(BitmapFactory.decodeFile(paramString2.getPath()));
                    }
                    catch (Exception paramString2)
                    {
                      paramString2.printStackTrace();
                    }
                    catch (OutOfMemoryError paramString2)
                    {
                      paramString2.printStackTrace();
                    }
                  }
                  paramString2 = new JSONObject();
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("SONG_GET_VOLUME".equals(paramString3))
                {
                  paramString3 = this.a;
                  paramString2 = new JSONObject();
                  if (paramString3 == null) {
                    break label3233;
                  }
                  paramString3 = (AudioManager)paramString3.getSystemService("audio");
                  if (paramString3 == null) {
                    break label3233;
                  }
                  float f1 = paramString3.getStreamMaxVolume(3);
                  float f2 = paramString3.getStreamVolume(3);
                  i1 = (int)f2;
                  if (f1 > 0.0F) {
                    i1 = (int)(f2 / f1 * 100.0F);
                  }
                  paramString2.put("volume", i1);
                  label2376:
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("SHARE_SONG".equals(paramString3))
                {
                  paramVarArgs = paramString2.getString("title");
                  localObject2 = paramString2.getString("desc");
                  localObject3 = paramString2.getString("imgUrl");
                  localObject4 = paramString2.getString("src");
                  localObject5 = paramString2.getString("audioUrl");
                  paramString3 = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                  if (paramString2.has("iconUrl")) {
                    paramString3 = paramString2.getString("iconUrl");
                  }
                  if (this.a != null)
                  {
                    paramString2 = new Intent("BROAD_CAST_SHARE_SONG");
                    paramString2.putExtra("BUNDLE_KEY_TITLE", paramVarArgs);
                    paramString2.putExtra("BUNDLE_KEY_DESC", (String)localObject2);
                    paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject3);
                    paramString2.putExtra("BUNDLE_KEY_SRC", (String)localObject4);
                    paramString2.putExtra("BUNDLE_KEY_AUDIO_URL", (String)localObject5);
                    paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString3);
                    this.a.sendBroadcast(paramString2, "com.tencent.music.data.permission");
                  }
                  paramString2 = new JSONObject();
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("SHARE_GENE".equals(paramString3))
                {
                  paramVarArgs = paramString2.getString("title");
                  localObject2 = paramString2.getString("desc");
                  localObject3 = paramString2.getString("imgUrl");
                  localObject4 = paramString2.getString("src");
                  l1 = 1101244924L;
                  if (paramString2.has("appid")) {
                    l1 = paramString2.getLong("appid");
                  }
                  paramString3 = "https://qzonestyle.gtimg.cn/ac/qzone/applogo/16/308/100497308_16.gif";
                  if (paramString2.has("iconUrl")) {
                    paramString3 = paramString2.getString("iconUrl");
                  }
                  if (this.a != null)
                  {
                    paramString2 = new Intent("BROAD_CAST_SHARE_MUSIC_GENE");
                    paramString2.putExtra("BUNDLE_KEY_TITLE", paramVarArgs);
                    paramString2.putExtra("BUNDLE_KEY_DESC", (String)localObject2);
                    paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject3);
                    paramString2.putExtra("BUNDLE_KEY_SRC", (String)localObject4);
                    paramString2.putExtra("BUNDKE_KEY_APP_ID", l1);
                    paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString3);
                    this.a.sendBroadcast(paramString2, "com.tencent.music.data.permission");
                  }
                  paramString2 = new JSONObject();
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
              }
            }
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        paramString1 = null;
        if ("bindApp".equals(paramString3)) {
          paramString2 = (String)((ArrayList)localObject2).get(0);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString2.has("action")) {
          paramString1 = paramString2.getString("action");
        }
        try
        {
          paramString2 = this.d.q();
          if (paramString2 != null) {
            try
            {
              i1 = paramString2.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
            }
            catch (Exception paramString2) {}
          }
        }
        catch (Exception paramString2)
        {
          paramString2.printStackTrace();
        }
        if ("CALLPAGE_SONG_STATE_CHANGE".equals(paramString1))
        {
          this.b = true;
          paramString1 = new JSONObject();
          paramString1.put("playType", i1);
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          a();
        }
        else if ("CALLPAGE_SONG_TIME_UPDATE".equals(paramString1))
        {
          this.c = true;
          paramString1 = new JSONObject();
          paramString1.put("playType", i1);
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        label3008:
        continue;
      }
      "unbindApp".equals(paramString3);
      return true;
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      label3026:
      paramString2 = null;
      break;
      label3031:
      i1 = 0;
      break label286;
      label3037:
      paramString1 = "0";
      break label307;
      label3044:
      paramString3 = null;
      break label366;
      paramString1 = "0";
      break label629;
      label3057:
      break label629;
      label3060:
      paramString3 = null;
      paramString2 = paramVarArgs;
      break label962;
      label3069:
      i1 = 0;
      break label1003;
      label3075:
      l1 = 0L;
      break label1029;
      label3081:
      paramString2 = null;
      break label1084;
      label3086:
      long l3 = i2;
      break label1199;
      label3094:
      paramString3 = null;
      localObject2 = paramVarArgs;
      break label1420;
      label3104:
      i3 = 0;
      break label1457;
      label3110:
      l1 = 0L;
      break label1486;
      label3116:
      paramString2 = paramString1;
      break label1514;
      label3121:
      paramString3 = paramString1;
      label3124:
      paramString2 = null;
      localObject2 = paramString3;
      break label1554;
      label3133:
      i1 += 1;
      break label1600;
      label3142:
      localObject3 = paramString2;
      i1 = i2;
      paramString2 = paramString3;
      paramString3 = (String)localObject3;
      break label3173;
      label3159:
      localObject3 = "playType";
      i1 = 0;
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      label3173:
      break label1731;
      label3176:
      i2 += 1;
      break label1690;
      label3185:
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      break label1731;
      label3194:
      i1 = 0;
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      break label1731;
      label3206:
      i1 = 0;
      break label1983;
      label3212:
      paramString1 = "1";
      break label2054;
      label3219:
      paramString3 = "";
      break label2107;
      label3227:
      i1 = 0;
      break label2129;
      label3233:
      paramString1 = "1";
      break label2376;
      i1 = 0;
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.d == null) && (b(paramString1))) {
        h();
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
    }
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return b(paramString1);
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.d();
    if (localActivity != null) {
      this.a = localActivity.getApplicationContext();
    }
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    try
    {
      b();
      if (this.a != null)
      {
        IQQPlayerService localIQQPlayerService = this.d;
        if (localIQQPlayerService != null)
        {
          int i1;
          try
          {
            i1 = this.d.g();
          }
          catch (RemoteException localRemoteException1)
          {
            localRemoteException1.printStackTrace();
            i1 = 4;
          }
          if (i1 != 2)
          {
            if (i1 == 3) {
              try
              {
                String str = this.d.r();
                if ((str != null) && (str.startsWith("music_gene_"))) {
                  this.d.c();
                }
              }
              catch (RemoteException localRemoteException2)
              {
                localRemoteException2.printStackTrace();
              }
            }
            a(4);
          }
          i();
          this.a.unregisterReceiver(this.m);
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
    }
    this.a = null;
    this.j = null;
    super.onDestroy();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {}
    for (;;)
    {
      try
      {
        paramCustomWebView = paramCustomWebView.getUrl();
        Object localObject = paramCustomWebView;
        if (TextUtils.isEmpty(paramCustomWebView))
        {
          WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
          localObject = paramCustomWebView;
          if (localWebUiBaseInterface != null)
          {
            localObject = paramCustomWebView;
            if ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)) {
              localObject = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl();
            }
          }
        }
        if (this.a != null)
        {
          if (b((String)localObject)) {
            h();
          }
          paramCustomWebView = new IntentFilter();
          paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
          this.a.registerReceiver(this.m, paramCustomWebView);
          return;
        }
      }
      catch (Exception paramCustomWebView)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", paramCustomWebView);
      }
      return;
      paramCustomWebView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */