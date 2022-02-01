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
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new MusicGeneWebViewPlugin.3(this);
  private Context jdField_a_of_type_AndroidContentContext = null;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new MusicGeneWebViewPlugin.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new MusicGeneWebViewPlugin.4(this, Looper.getMainLooper());
  private IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new MusicGeneWebViewPlugin.2(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService = null;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  
  public MusicGeneWebViewPlugin()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
      if (localIQQPlayerService != null) {
        try
        {
          this.jdField_a_of_type_Int = localIQQPlayerService.c();
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
      }
    }
    return this.jdField_a_of_type_Int;
  }
  
  private int a(int paramInt)
  {
    int j = 103;
    int i;
    if (paramInt != 0)
    {
      i = j;
      if (paramInt != 1)
      {
        i = j;
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
      i = 102;
    }
    return i;
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
  
  private SongInfo a()
  {
    SongInfo localSongInfo = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    if (localSongInfo == null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
      if (localObject != null) {
        try
        {
          localObject = ((IQQPlayerService)localObject).a();
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
  
  private String a()
  {
    try
    {
      if (c()) {
        return MusicPendantUtil.a();
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a(3, "MusicGeneWebViewPlugin");
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private HashMap<String, JSONObject> a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    int i = 0;
    try
    {
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        if (localJSONObject != null) {
          localHashMap.put(localJSONObject.getString("songId"), localJSONObject);
        }
        i += 1;
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
      localJSONObject.put("playUrl", paramSongInfo.b);
      localJSONObject.put("songPage", paramSongInfo.f);
      localJSONObject.put("songId", paramSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songName", paramSongInfo.c);
      localJSONObject.put("singerName", paramSongInfo.h);
      localJSONObject.put("albumName", paramSongInfo.g);
      localJSONObject.put("albumImg", paramSongInfo.e);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    MusicGeneWebViewPlugin.6 local6 = new MusicGeneWebViewPlugin.6(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(local6, 1000L, 1000L);
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
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   4: ifeq +467 -> 471
    //   7: aconst_null
    //   8: astore 9
    //   10: aload_0
    //   11: invokespecial 306	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   20: ifnull +16 -> 36
    //   23: aload_0
    //   24: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   27: invokeinterface 309 1 0
    //   32: istore_1
    //   33: goto +5 -> 38
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_0
    //   39: invokespecial 311	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
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
    //   71: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_1
    //   77: istore_2
    //   78: aload 5
    //   80: astore 8
    //   82: ldc_w 281
    //   85: astore 6
    //   87: aload_0
    //   88: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull +120 -> 215
    //   98: aload_0
    //   99: aload 5
    //   101: invokeinterface 312 1 0
    //   106: invokespecial 314	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   109: istore 4
    //   111: aload 6
    //   113: astore 5
    //   115: aload_0
    //   116: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   119: invokeinterface 317 1 0
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
    //   148: ldc_w 319
    //   151: invokevirtual 322	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore 6
    //   156: aload 6
    //   158: astore 5
    //   160: new 176	org/json/JSONObject
    //   163: dup
    //   164: aload 10
    //   166: ldc_w 285
    //   169: invokevirtual 322	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   172: invokespecial 323	org/json/JSONObject:<init>	(Ljava/lang/String;)V
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
    //   205: invokevirtual 141	java/lang/Exception:printStackTrace	()V
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
    //   234: new 176	org/json/JSONObject
    //   237: dup
    //   238: invokespecial 191	org/json/JSONObject:<init>	()V
    //   241: astore 6
    //   243: aload 8
    //   245: ifnull +226 -> 471
    //   248: aload_0
    //   249: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   252: ifnull +221 -> 473
    //   255: aload_0
    //   256: getfield 32	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   259: invokeinterface 317 1 0
    //   264: astore 7
    //   266: aload 7
    //   268: ifnull +205 -> 473
    //   271: aload 7
    //   273: ldc_w 325
    //   276: iconst_0
    //   277: invokevirtual 329	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   280: istore 4
    //   282: goto +13 -> 295
    //   285: astore 7
    //   287: aload 7
    //   289: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   292: goto +181 -> 473
    //   295: aload_0
    //   296: aload 8
    //   298: invokespecial 331	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   301: astore 7
    //   303: aload 7
    //   305: ifnull +50 -> 355
    //   308: aload 7
    //   310: invokevirtual 335	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   313: astore 8
    //   315: aload 8
    //   317: invokeinterface 340 1 0
    //   322: ifeq +33 -> 355
    //   325: aload 8
    //   327: invokeinterface 344 1 0
    //   332: checkcast 293	java/lang/String
    //   335: astore 9
    //   337: aload 6
    //   339: aload 9
    //   341: aload 7
    //   343: aload 9
    //   345: invokevirtual 347	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   348: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: goto -37 -> 315
    //   355: aload 6
    //   357: ldc_w 349
    //   360: iload_2
    //   361: sipush 1000
    //   364: idiv
    //   365: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   368: pop
    //   369: aload 6
    //   371: ldc_w 354
    //   374: iload_3
    //   375: sipush 1000
    //   378: idiv
    //   379: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload 6
    //   385: ldc_w 356
    //   388: invokevirtual 360	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   391: ifne +14 -> 405
    //   394: aload 6
    //   396: ldc_w 356
    //   399: aload 5
    //   401: invokevirtual 200	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   404: pop
    //   405: aload 6
    //   407: ldc_w 362
    //   410: iload_1
    //   411: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload 6
    //   417: ldc_w 364
    //   420: iload 4
    //   422: invokevirtual 352	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   425: pop
    //   426: goto +10 -> 436
    //   429: astore 5
    //   431: aload 5
    //   433: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   436: aload 6
    //   438: ifnull +33 -> 471
    //   441: aload_0
    //   442: ldc_w 366
    //   445: iconst_2
    //   446: anewarray 289	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: ldc_w 368
    //   454: aastore
    //   455: dup
    //   456: iconst_1
    //   457: aload 6
    //   459: invokevirtual 369	org/json/JSONObject:toString	()Ljava/lang/String;
    //   462: aastore
    //   463: invokestatic 297	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   466: invokevirtual 300	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:callJs	(Ljava/lang/String;)V
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
    //   32	379	1	i	int
    //   48	317	2	j	int
    //   42	337	3	k	int
    //   109	366	4	m	int
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
  
  private boolean a(int paramInt)
  {
    IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    int i;
    int j;
    JSONObject localJSONObject;
    if ((this.jdField_a_of_type_Boolean) && (localIQQPlayerService != null))
    {
      try
      {
        i = localIQQPlayerService.e();
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        i = 0;
      }
      j = b(paramInt);
      localJSONObject = new JSONObject();
      try
      {
        Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
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
      localJSONObject.put("state", j);
      localJSONObject.put("index", i);
      localJSONObject.put("playType", paramInt);
      boolean bool = b();
      if (bool)
      {
        localJSONObject.put("code", "0");
      }
      else
      {
        localJSONObject.put("code", "0");
        break label173;
        localException.printStackTrace();
      }
      label173:
      callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", localJSONObject.toString() }));
      return true;
      return false;
      paramInt = 0;
    }
  }
  
  public static boolean a(String paramString)
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
      int i = 0;
      for (;;)
      {
        localObject = arrayOfSongInfo;
        if (i >= localJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
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
          localSongInfo.c = ((String)localObject);
          if (localJSONObject.has("playUrl")) {
            localObject = localJSONObject.getString("playUrl");
          } else {
            localObject = "";
          }
          localSongInfo.b = ((String)localObject);
          if (localJSONObject.has("albumName")) {
            localObject = localJSONObject.getString("albumName");
          } else {
            localObject = "";
          }
          localSongInfo.d = ((String)localObject);
          if (localJSONObject.has("albumImg")) {
            localObject = localJSONObject.getString("albumImg");
          } else {
            localObject = "";
          }
          localSongInfo.e = ((String)localObject);
          if (localJSONObject.has("songPage")) {
            localObject = localJSONObject.getString("songPage");
          } else {
            localObject = "";
          }
          localSongInfo.f = ((String)localObject);
          long l;
          if (TextUtils.isEmpty(paramJSONObject)) {
            l = 0L;
          } else {
            l = Long.parseLong(paramJSONObject);
          }
          localSongInfo.jdField_a_of_type_Long = l;
          if (localJSONObject.has("albumName")) {
            paramJSONObject = localJSONObject.getString("albumName");
          } else {
            paramJSONObject = "";
          }
          localSongInfo.g = paramJSONObject;
          if (localJSONObject.has("singerName")) {
            paramJSONObject = localJSONObject.getString("singerName");
          } else {
            paramJSONObject = "";
          }
          localSongInfo.h = paramJSONObject;
          paramJSONObject = str;
          if (localJSONObject.has("songmid")) {
            paramJSONObject = localJSONObject.getString("songmid");
          }
          localSongInfo.jdField_a_of_type_JavaLangString = paramJSONObject;
          arrayOfSongInfo[i] = localSongInfo;
        }
        i += 1;
      }
    }
    return localObject;
  }
  
  private int b(int paramInt)
  {
    int i = 0;
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
      i = 4;
    }
    return i;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    if (localObject != null) {
      try
      {
        localObject = ((IQQPlayerService)localObject).a();
        String str = a();
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
  
  private void c()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private boolean c()
  {
    int i = this.c;
    boolean bool = true;
    if (1 != i)
    {
      if (2 == i) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void d()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if ((localActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null))
        {
          localActivity.bindService(new Intent(localActivity, QQPlayerService.class), this.jdField_a_of_type_AndroidContentServiceConnection, 33);
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
  
  private void e()
  {
    try
    {
      if (this.mRuntime != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null) {
          localActivity.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 8589934594L) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject2 = new ArrayList(Arrays.asList(paramVarArgs));
    Object localObject3;
    long l1;
    int i;
    label285:
    label306:
    label365:
    label628:
    int j;
    label967:
    label1008:
    int k;
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
            break label3026;
          }
          paramString3 = paramString1.getString("action");
          if (!paramString1.has("data")) {
            break label3044;
          }
          paramString2 = paramString1.getJSONObject("data");
          if ((paramString2 != null) && (paramString2.has("playType"))) {
            this.c = paramString2.getInt("playType");
          } else {
            this.c = 0;
          }
          bool = "MANUAL_INIT".equals(paramString3);
          if (bool) {
            try
            {
              QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handle js request: MANUAL_INIT");
              if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null)
              {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
                d();
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
          Object localObject5 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
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
              break label3075;
            }
            l1 = 0L;
            if (!paramString2.has("index")) {
              break label3049;
            }
            i = paramString2.getInt("index");
            if (!paramString2.has("geneId")) {
              break label3055;
            }
            paramString1 = paramString2.getString("geneId");
            if (paramString2.has("uin")) {
              l1 = paramString2.getLong("uin");
            }
            if (paramString2.has("geneType")) {
              paramString2.getString("geneType");
            }
            if (!paramString2.has("list")) {
              break label3062;
            }
            paramString3 = paramString2.getJSONArray("list");
            localObject3 = String.valueOf(l1);
            localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
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
            ((Bundle)localObject3).putInt("BUNDLE_KEY_PLAY_TYPE", this.c);
            if (paramString3 != null) {
              ((Bundle)localObject3).putString("BUNDLE_KEY_JSONARRAY_SONG_LIST", paramString3.toString());
            }
            ((Bundle)localObject3).putString("data", paramString2.toString());
            try
            {
              ((IQQPlayerService)localObject5).a((Bundle)localObject3);
              ((IQQPlayerService)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub);
              ((IQQPlayerService)localObject5).a((Intent)localObject2);
              if (c()) {
                ((IQQPlayerService)localObject5).a(102);
              } else {
                ((IQQPlayerService)localObject5).a(103);
              }
              ((IQQPlayerService)localObject5).a(a(), paramVarArgs, i);
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
            this.jdField_b_of_type_Int = ((IQQPlayerService)localObject5).d();
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
                  paramString2 = ((IQQPlayerService)localObject5).a();
                  paramVarArgs = paramString2;
                  if (paramString2 == null) {
                    break label3078;
                  }
                  paramVarArgs = paramString2;
                  try
                  {
                    if (!paramString2.containsKey("data")) {
                      break label3078;
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
                break label3078;
                paramVarArgs = paramString3;
                if (paramString3 == null) {
                  paramVarArgs = new JSONObject();
                }
                localObject2 = a();
                if (paramString2 == null) {
                  break label3087;
                }
                i = paramString2.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
                if ((paramString2 == null) || (!paramString2.containsKey("BUNDLE_KEY_UIN"))) {
                  break label3093;
                }
                l1 = paramString2.getLong("BUNDLE_KEY_UIN");
                label1034:
                if (localObject2 != null)
                {
                  if ((paramString2 == null) || (!paramString2.containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST"))) {
                    break label3099;
                  }
                  paramString2 = (JSONObject)a(new JSONArray(paramString2.getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"))).get(String.valueOf(((SongInfo)localObject2).jdField_a_of_type_Long));
                  label1089:
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
                  long l2 = a();
                  j = ((IQQPlayerService)localObject5).a();
                  k = b(j);
                  if (j == 3)
                  {
                    j = this.jdField_b_of_type_Int;
                    break label3104;
                  }
                  j = ((IQQPlayerService)localObject5).d();
                  break label3104;
                  label1204:
                  if (b()) {
                    paramVarArgs.put("code", paramString1);
                  } else {
                    paramVarArgs.put("code", paramString1);
                  }
                  Object localObject1;
                  paramVarArgs.put("curTime", localObject1 / 1000L);
                  paramVarArgs.put("totalTime", l2 / 1000L);
                  paramVarArgs.put("state", k);
                  paramVarArgs.put("playType", i);
                }
                else
                {
                  paramVarArgs.put("code", "1");
                  paramVarArgs.put("playType", i);
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
                    paramString2 = ((IQQPlayerService)localObject5).a();
                    paramVarArgs = paramString2;
                    if (paramString2 == null) {
                      break label3112;
                    }
                    paramVarArgs = paramString2;
                    try
                    {
                      if (!paramString2.containsKey("data")) {
                        break label3112;
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
                  break label3112;
                  label1428:
                  paramVarArgs = paramString3;
                  if (paramString3 == null) {
                    paramVarArgs = new JSONObject();
                  }
                  if (localObject2 == null) {
                    break label3122;
                  }
                  k = ((Bundle)localObject2).getInt("BUNDLE_KEY_PLAY_TYPE", 0);
                  label1465:
                  if ((localObject2 == null) || (!((Bundle)localObject2).containsKey("BUNDLE_KEY_UIN"))) {
                    break label3128;
                  }
                  l1 = ((Bundle)localObject2).getLong("BUNDLE_KEY_UIN");
                  label1494:
                  if (localObject2 == null) {
                    break label3139;
                  }
                  if (!((Bundle)localObject2).containsKey("BUNDLE_KEY_GENE_ID")) {
                    break label3134;
                  }
                  paramString2 = ((Bundle)localObject2).getString("BUNDLE_KEY_GENE_ID");
                  label1522:
                  paramString3 = paramString2;
                  if (!((Bundle)localObject2).containsKey("BUNDLE_KEY_JSONARRAY_SONG_LIST")) {
                    break label3142;
                  }
                  paramString3 = new JSONArray(((Bundle)localObject2).getString("BUNDLE_KEY_JSONARRAY_SONG_LIST"));
                  localObject2 = paramString2;
                  paramString2 = paramString3;
                  label1562:
                  if (paramString2 == null)
                  {
                    paramString2 = new JSONArray();
                    localObject4 = ((IQQPlayerService)localObject5).a();
                    localSongInfo = a();
                    if (localObject4 == null) {
                      break label3177;
                    }
                    i = 0;
                    j = 0;
                    paramString3 = (String)localObject3;
                    localObject3 = localObject4;
                    label1608:
                    if (i >= localObject3.length) {
                      break label3160;
                    }
                    localObject4 = localObject3[i];
                    if (localObject4 == null) {
                      break label3151;
                    }
                    paramString2.put(i, a((SongInfo)localObject4));
                    if ((localSongInfo == null) || (((SongInfo)localObject4).jdField_a_of_type_Long != localSongInfo.jdField_a_of_type_Long)) {
                      break label3151;
                    }
                    j = i;
                    break label3151;
                  }
                  localObject3 = "playType";
                  paramString3 = ((IQQPlayerService)localObject5).a();
                  localObject4 = a();
                  if (paramString3 == null) {
                    break label3212;
                  }
                  j = 0;
                  i = 0;
                  label1698:
                  if (j >= paramString3.length) {
                    break label3203;
                  }
                  SongInfo localSongInfo = paramString3[j];
                  if ((localSongInfo == null) || (localSongInfo.jdField_a_of_type_Long != ((SongInfo)localObject4).jdField_a_of_type_Long)) {
                    break label3194;
                  }
                  i = j;
                  break label3194;
                  label1739:
                  paramVarArgs.put("index", i);
                  paramVarArgs.put("state", b(((IQQPlayerService)localObject5).a()));
                  if (!paramVarArgs.has("geneId")) {
                    paramVarArgs.put("geneId", localObject2);
                  }
                  paramVarArgs.put("list", paramString3);
                  if (b()) {
                    paramVarArgs.put("code", paramString1);
                  } else {
                    paramVarArgs.put("code", paramString1);
                  }
                  if (!paramVarArgs.has("uin")) {
                    paramVarArgs.put("uin", l1);
                  }
                  paramVarArgs.put(paramString2, k);
                  paramJsBridgeListener.a(paramVarArgs);
                }
                else if ("SONG_SET_PLAYMODE".equals(paramString3))
                {
                  j = 103;
                  i = j;
                  if (paramString2 != null)
                  {
                    i = j;
                    if (paramString2.has("type")) {
                      i = paramString2.getInt("type");
                    }
                  }
                  ((IQQPlayerService)localObject5).a(a(i));
                  paramString2 = new JSONObject();
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("SONG_SET_VOLUME".equals(paramString3))
                {
                  if ((paramString2 == null) || (!paramString2.has("volume"))) {
                    break label3224;
                  }
                  i = paramString2.getInt("volume");
                  label1994:
                  paramString2 = new JSONObject();
                  paramString3 = this.jdField_a_of_type_AndroidContentContext;
                  if ((paramString3 == null) || (i < 0) || (i > 100)) {
                    break label3230;
                  }
                  paramString3 = (AudioManager)paramString3.getSystemService("audio");
                  if (paramString3 == null) {
                    break label3230;
                  }
                  paramString3.setStreamVolume(3, paramString3.getStreamMaxVolume(3) * i / 100, 4);
                  label2065:
                  paramString2.put("code", paramString1);
                  paramJsBridgeListener.a(paramString2);
                }
                else if ("DO_MACK_IMG".equals(paramString3))
                {
                  if ((paramString2 == null) || (!paramString2.has("imgUrl"))) {
                    break label3237;
                  }
                  paramString3 = paramString2.getString("imgUrl");
                  label2119:
                  if (!paramString2.has("degree")) {
                    break label3244;
                  }
                  i = paramString2.getInt("degree");
                  label2141:
                  paramString2 = MD5.toMD5(paramString3);
                  paramVarArgs = new StringBuilder();
                  paramVarArgs.append(AppConstants.SDCARD_PATH);
                  paramVarArgs.append(File.separator);
                  paramVarArgs.append("diskcache");
                  paramString2 = new File(new File(paramVarArgs.toString()), paramString2);
                  if (!paramString2.exists()) {
                    ThreadManager.post(new MusicGeneWebViewPlugin.5(this, paramString3, i, paramString2), 8, null, true);
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
                  paramString3 = this.jdField_a_of_type_AndroidContentContext;
                  paramString2 = new JSONObject();
                  if (paramString3 == null) {
                    break label3250;
                  }
                  paramString3 = (AudioManager)paramString3.getSystemService("audio");
                  if (paramString3 == null) {
                    break label3250;
                  }
                  float f1 = paramString3.getStreamMaxVolume(3);
                  float f2 = paramString3.getStreamVolume(3);
                  i = (int)f2;
                  if (f1 > 0.0F) {
                    i = (int)(f2 / f1 * 100.0F);
                  }
                  paramString2.put("volume", i);
                  label2389:
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
                  if (this.jdField_a_of_type_AndroidContentContext != null)
                  {
                    paramString2 = new Intent("BROAD_CAST_SHARE_SONG");
                    paramString2.putExtra("BUNDLE_KEY_TITLE", paramVarArgs);
                    paramString2.putExtra("BUNDLE_KEY_DESC", (String)localObject2);
                    paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject3);
                    paramString2.putExtra("BUNDLE_KEY_SRC", (String)localObject4);
                    paramString2.putExtra("BUNDLE_KEY_AUDIO_URL", (String)localObject5);
                    paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString3);
                    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString2, "com.tencent.music.data.permission");
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
                  if (this.jdField_a_of_type_AndroidContentContext != null)
                  {
                    paramString2 = new Intent("BROAD_CAST_SHARE_MUSIC_GENE");
                    paramString2.putExtra("BUNDLE_KEY_TITLE", paramVarArgs);
                    paramString2.putExtra("BUNDLE_KEY_DESC", (String)localObject2);
                    paramString2.putExtra("BUDNLE_KEY_IMG_URL", (String)localObject3);
                    paramString2.putExtra("BUNDLE_KEY_SRC", (String)localObject4);
                    paramString2.putExtra("BUNDKE_KEY_APP_ID", l1);
                    paramString2.putExtra("BUNDLE_KEY_ICON_URL", paramString3);
                    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramString2, "com.tencent.music.data.permission");
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
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
          if (paramString2 != null) {
            try
            {
              i = paramString2.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
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
          this.jdField_a_of_type_Boolean = true;
          paramString1 = new JSONObject();
          paramString1.put("playType", i);
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
          a();
        }
        else if ("CALLPAGE_SONG_TIME_UPDATE".equals(paramString1))
        {
          this.jdField_b_of_type_Boolean = true;
          paramString1 = new JSONObject();
          paramString1.put("playType", i);
          paramString1.put("code", "0");
          paramJsBridgeListener.a(paramString1);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        label3026:
        continue;
      }
      "unbindApp".equals(paramString3);
      return true;
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      label3044:
      paramString2 = null;
      break;
      label3049:
      i = 0;
      break label285;
      label3055:
      paramString1 = "0";
      break label306;
      label3062:
      paramString3 = null;
      break label365;
      paramString1 = "0";
      break label628;
      label3075:
      break label628;
      label3078:
      paramString3 = null;
      paramString2 = paramVarArgs;
      break label967;
      label3087:
      i = 0;
      break label1008;
      label3093:
      l1 = 0L;
      break label1034;
      label3099:
      paramString2 = null;
      break label1089;
      label3104:
      long l3 = j;
      break label1204;
      label3112:
      paramString3 = null;
      localObject2 = paramVarArgs;
      break label1428;
      label3122:
      k = 0;
      break label1465;
      label3128:
      l1 = 0L;
      break label1494;
      label3134:
      paramString2 = paramString1;
      break label1522;
      label3139:
      paramString3 = paramString1;
      label3142:
      paramString2 = null;
      localObject2 = paramString3;
      break label1562;
      label3151:
      i += 1;
      break label1608;
      label3160:
      localObject3 = paramString2;
      i = j;
      paramString2 = paramString3;
      paramString3 = (String)localObject3;
      break label3191;
      label3177:
      localObject3 = "playType";
      i = 0;
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      label3191:
      break label1739;
      label3194:
      j += 1;
      break label1698;
      label3203:
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      break label1739;
      label3212:
      i = 0;
      paramString3 = paramString2;
      paramString2 = (String)localObject3;
      break label1739;
      label3224:
      i = 0;
      break label1994;
      label3230:
      paramString1 = "1";
      break label2065;
      label3237:
      paramString3 = "";
      break label2119;
      label3244:
      i = 0;
      break label2141;
      label3250:
      paramString1 = "1";
      break label2389;
      i = 0;
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) && (a(paramString1))) {
        d();
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
    return a(paramString1);
  }
  
  public void onCreate()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      this.jdField_a_of_type_AndroidContentContext = localActivity.getApplicationContext();
    }
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    try
    {
      b();
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        IQQPlayerService localIQQPlayerService = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
        if (localIQQPlayerService != null)
        {
          int i;
          try
          {
            i = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
          }
          catch (RemoteException localRemoteException1)
          {
            localRemoteException1.printStackTrace();
            i = 4;
          }
          if (i != 2)
          {
            if (i == 3) {
              try
              {
                String str = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
                if ((str != null) && (str.startsWith("music_gene_"))) {
                  this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
                }
              }
              catch (RemoteException localRemoteException2)
              {
                localRemoteException2.printStackTrace();
              }
            }
            a(4);
          }
          e();
          this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
    }
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
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
          WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
          localObject = paramCustomWebView;
          if (localWebUiBaseInterface != null)
          {
            localObject = paramCustomWebView;
            if ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface)) {
              localObject = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl();
            }
          }
        }
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          if (a((String)localObject)) {
            d();
          }
          paramCustomWebView = new IntentFilter();
          paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
          this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramCustomWebView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */