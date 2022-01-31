package com.tencent.mobileqq.musicgene;

import aeki;
import aekj;
import aekk;
import aekl;
import aekn;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.music.IQQPlayerCallback.Stub;
import com.tencent.mobileqq.music.IQQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MusicGeneWebViewPlugin
  extends WebViewPlugin
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aekk(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aeki(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new aekl(this, Looper.getMainLooper());
  private IQQPlayerCallback.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub = new aekj(this);
  private IQQPlayerService jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
  private SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public MusicGeneWebViewPlugin()
  {
    this.mPluginNameSpace = "qqmusic";
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null)) {}
    try
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
      return this.jdField_a_of_type_Int;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return 103;
    case 0: 
      return 102;
    }
    return 101;
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
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private SongInfo a()
  {
    SongInfo localSongInfo2 = this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
    SongInfo localSongInfo1 = localSongInfo2;
    if (localSongInfo2 == null)
    {
      localSongInfo1 = localSongInfo2;
      if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) {}
    }
    try
    {
      localSongInfo1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      return localSongInfo1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localSongInfo2;
  }
  
  private String a()
  {
    try
    {
      if (c()) {
        return MusicPendantManager.a();
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
  
  private HashMap a(JSONArray paramJSONArray)
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
      localJSONObject.put("playUrl", paramSongInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("songPage", paramSongInfo.e);
      localJSONObject.put("songId", paramSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songName", paramSongInfo.b);
      localJSONObject.put("singerName", paramSongInfo.g);
      localJSONObject.put("albumName", paramSongInfo.f);
      localJSONObject.put("albumImg", paramSongInfo.d);
    }
    return localJSONObject;
  }
  
  private void a()
  {
    aekn localaekn = new aekn(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localaekn, 1000L, 1000L);
  }
  
  private void a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap != null)
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      paramBitmap = Base64Util.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 0);
      localObject = "data:image\\/jpg;base64," + paramBitmap;
      paramBitmap = new JSONObject();
    }
    try
    {
      paramBitmap.put("code", "0");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("imgUrl", localObject);
      paramBitmap.put("data", localJSONObject);
      callJs(String.format("try{qqmusicBridge.appTrigger('%s',  %s);}catch(e){}", new Object[] { "DO_MACK_IMG_CALLBACK", paramBitmap }));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload 6
    //   5: istore 5
    //   7: aload_0
    //   8: getfield 293	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   11: ifeq +286 -> 297
    //   14: aload_0
    //   15: invokespecial 294	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   18: astore 7
    //   20: aload_0
    //   21: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   24: ifnull +456 -> 480
    //   27: aload_0
    //   28: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   31: invokeinterface 296 1 0
    //   36: istore_1
    //   37: aload_0
    //   38: invokespecial 298	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
    //   41: istore_3
    //   42: iload_1
    //   43: istore 4
    //   45: aload 7
    //   47: astore 9
    //   49: ldc_w 267
    //   52: astore 8
    //   54: aload_0
    //   55: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   58: ifnull +409 -> 467
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   66: invokeinterface 299 1 0
    //   71: invokespecial 301	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   74: istore_1
    //   75: aload 8
    //   77: astore 7
    //   79: aload_0
    //   80: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   83: invokeinterface 304 1 0
    //   88: astore 10
    //   90: aload 10
    //   92: ifnull +369 -> 461
    //   95: aload 8
    //   97: astore 7
    //   99: aload 10
    //   101: ldc_w 306
    //   104: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 8
    //   109: aload 8
    //   111: astore 7
    //   113: new 164	org/json/JSONObject
    //   116: dup
    //   117: aload 10
    //   119: ldc_w 271
    //   122: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   128: astore 10
    //   130: aload 10
    //   132: astore 7
    //   134: aload 7
    //   136: ifnonnull +322 -> 458
    //   139: new 164	org/json/JSONObject
    //   142: dup
    //   143: invokespecial 177	org/json/JSONObject:<init>	()V
    //   146: astore 7
    //   148: iload 6
    //   150: istore 5
    //   152: aload 9
    //   154: ifnull +143 -> 297
    //   157: aload_0
    //   158: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   161: ifnull +324 -> 485
    //   164: aload_0
    //   165: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   168: invokeinterface 304 1 0
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +175 -> 352
    //   180: aload 10
    //   182: ldc_w 312
    //   185: iconst_0
    //   186: invokevirtual 316	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   189: istore_2
    //   190: aload_0
    //   191: aload 9
    //   193: invokespecial 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   196: astore 9
    //   198: aload 9
    //   200: ifnull +167 -> 367
    //   203: aload 9
    //   205: invokevirtual 322	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   208: astore 10
    //   210: aload 10
    //   212: invokeinterface 327 1 0
    //   217: ifeq +150 -> 367
    //   220: aload 10
    //   222: invokeinterface 331 1 0
    //   227: checkcast 279	java/lang/String
    //   230: astore 11
    //   232: aload 7
    //   234: aload 11
    //   236: aload 9
    //   238: aload 11
    //   240: invokevirtual 334	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   243: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: goto -37 -> 210
    //   250: astore 8
    //   252: aload 8
    //   254: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   257: iload 6
    //   259: istore 5
    //   261: aload 7
    //   263: ifnull +34 -> 297
    //   266: aload_0
    //   267: ldc_w 336
    //   270: iconst_2
    //   271: anewarray 275	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: ldc_w 338
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload 7
    //   284: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 283	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   291: invokevirtual 286	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:callJs	(Ljava/lang/String;)V
    //   294: iconst_1
    //   295: istore 5
    //   297: iload 5
    //   299: ireturn
    //   300: astore 8
    //   302: aconst_null
    //   303: astore 7
    //   305: iconst_0
    //   306: istore_1
    //   307: aload 8
    //   309: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   312: iconst_0
    //   313: istore_3
    //   314: aload 7
    //   316: astore 9
    //   318: iload_1
    //   319: istore 4
    //   321: goto -272 -> 49
    //   324: astore 8
    //   326: ldc_w 267
    //   329: astore 7
    //   331: iconst_0
    //   332: istore_1
    //   333: aload 8
    //   335: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   338: aconst_null
    //   339: astore 10
    //   341: aload 7
    //   343: astore 8
    //   345: aload 10
    //   347: astore 7
    //   349: goto -215 -> 134
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -164 -> 190
    //   357: astore 10
    //   359: aload 10
    //   361: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   364: goto +121 -> 485
    //   367: aload 7
    //   369: ldc_w 341
    //   372: iload 4
    //   374: sipush 1000
    //   377: idiv
    //   378: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   381: pop
    //   382: aload 7
    //   384: ldc_w 346
    //   387: iload_3
    //   388: sipush 1000
    //   391: idiv
    //   392: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload 7
    //   398: ldc_w 348
    //   401: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   404: ifne +14 -> 418
    //   407: aload 7
    //   409: ldc_w 348
    //   412: aload 8
    //   414: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   417: pop
    //   418: aload 7
    //   420: ldc_w 354
    //   423: iload_1
    //   424: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   427: pop
    //   428: aload 7
    //   430: ldc_w 356
    //   433: iload_2
    //   434: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   437: pop
    //   438: goto -181 -> 257
    //   441: astore 8
    //   443: goto -110 -> 333
    //   446: astore 8
    //   448: iconst_0
    //   449: istore_1
    //   450: goto -143 -> 307
    //   453: astore 8
    //   455: goto -148 -> 307
    //   458: goto -310 -> 148
    //   461: aconst_null
    //   462: astore 7
    //   464: goto -330 -> 134
    //   467: iconst_0
    //   468: istore_1
    //   469: aconst_null
    //   470: astore 7
    //   472: ldc_w 267
    //   475: astore 8
    //   477: goto -343 -> 134
    //   480: iconst_0
    //   481: istore_1
    //   482: goto -445 -> 37
    //   485: iconst_0
    //   486: istore_2
    //   487: goto -297 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	MusicGeneWebViewPlugin
    //   36	446	1	i	int
    //   189	298	2	j	int
    //   41	351	3	k	int
    //   43	335	4	m	int
    //   5	293	5	bool1	boolean
    //   1	257	6	bool2	boolean
    //   18	453	7	localObject1	Object
    //   52	58	8	str1	String
    //   250	3	8	localException1	Exception
    //   300	8	8	localException2	Exception
    //   324	10	8	localException3	Exception
    //   343	70	8	localObject2	Object
    //   441	1	8	localException4	Exception
    //   446	1	8	localException5	Exception
    //   453	1	8	localException6	Exception
    //   475	1	8	str2	String
    //   47	270	9	localObject3	Object
    //   88	258	10	localObject4	Object
    //   357	3	10	localException7	Exception
    //   230	9	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   190	198	250	java/lang/Exception
    //   203	210	250	java/lang/Exception
    //   210	247	250	java/lang/Exception
    //   359	364	250	java/lang/Exception
    //   367	418	250	java/lang/Exception
    //   418	438	250	java/lang/Exception
    //   14	20	300	java/lang/Exception
    //   61	75	324	java/lang/Exception
    //   157	175	357	java/lang/Exception
    //   180	190	357	java/lang/Exception
    //   79	90	441	java/lang/Exception
    //   99	109	441	java/lang/Exception
    //   113	130	441	java/lang/Exception
    //   20	37	446	java/lang/Exception
    //   37	42	453	java/lang/Exception
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Boolean)
    {
      bool1 = bool2;
      if (localObject == null) {}
    }
    try
    {
      i = ((IQQPlayerService)localObject).e();
      int j = b(paramInt);
      localObject = new JSONObject();
      try
      {
        Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        if (localBundle == null) {
          break label182;
        }
        paramInt = localBundle.getInt("BUNDLE_KEY_PLAY_TYPE", 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          paramInt = 0;
          continue;
          localRemoteException.put("code", "0");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      ((JSONObject)localObject).put("state", j);
      ((JSONObject)localObject).put("index", i);
      ((JSONObject)localObject).put("playType", paramInt);
      if (b())
      {
        ((JSONObject)localObject).put("code", "0");
        bool1 = bool2;
        if (localObject != null)
        {
          callJs(String.format("try{qqmusicBridge.appTrigger('%s', %s);}catch(e){}", new Object[] { "CALLPAGE_SONG_STATE_CHANGE", ((JSONObject)localObject).toString() }));
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
        int i = 0;
        continue;
        label182:
        paramInt = 0;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      paramString = Uri.parse(paramString);
      String str = paramString.getScheme();
      if (("http".equalsIgnoreCase(str)) || ("https".equalsIgnoreCase(str)))
      {
        paramString = paramString.getHost();
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {
          return bool1;
        }
        if ((!paramString.contains("y.qq.com")) && (!paramString.contains("music.qq.com")) && (!paramString.contains("imgcache.gtimg.cn")) && (!paramString.contains("article.mp.qq.com")))
        {
          bool1 = bool2;
          if (!paramString.contains("post.mp.qq.com")) {
            return bool1;
          }
        }
      }
      else
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic urlString is not url!");
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.isURLBelongToQQMusic exception: " + paramString);
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  private SongInfo[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while (!paramJSONObject.has("list")) {
      return null;
    }
    JSONArray localJSONArray = paramJSONObject.getJSONArray("list");
    SongInfo[] arrayOfSongInfo = new SongInfo[localJSONArray.length()];
    int i = 0;
    if (i < localJSONArray.length())
    {
      Object localObject = (JSONObject)localJSONArray.get(i);
      label80:
      String str1;
      label99:
      String str2;
      label118:
      String str3;
      label137:
      String str4;
      label156:
      String str5;
      label175:
      label194:
      SongInfo localSongInfo;
      if (localObject != null)
      {
        if (!((JSONObject)localObject).has("playUrl")) {
          break label280;
        }
        paramJSONObject = ((JSONObject)localObject).getString("playUrl");
        if (!((JSONObject)localObject).has("songPage")) {
          break label286;
        }
        str1 = ((JSONObject)localObject).getString("songPage");
        if (!((JSONObject)localObject).has("songId")) {
          break label293;
        }
        str2 = ((JSONObject)localObject).getString("songId");
        if (!((JSONObject)localObject).has("songName")) {
          break label300;
        }
        str3 = ((JSONObject)localObject).getString("songName");
        if (!((JSONObject)localObject).has("singerName")) {
          break label307;
        }
        str4 = ((JSONObject)localObject).getString("singerName");
        if (!((JSONObject)localObject).has("albumName")) {
          break label314;
        }
        str5 = ((JSONObject)localObject).getString("albumName");
        if (!((JSONObject)localObject).has("albumImg")) {
          break label321;
        }
        localObject = ((JSONObject)localObject).getString("albumImg");
        localSongInfo = new SongInfo();
        localSongInfo.b = str3;
        localSongInfo.jdField_a_of_type_JavaLangString = paramJSONObject;
        localSongInfo.c = str5;
        localSongInfo.d = ((String)localObject);
        localSongInfo.e = str1;
        if (!TextUtils.isEmpty(str2)) {
          break label328;
        }
      }
      label280:
      label286:
      label293:
      label300:
      label307:
      label314:
      label321:
      label328:
      for (long l = 0L;; l = Long.parseLong(str2))
      {
        localSongInfo.jdField_a_of_type_Long = l;
        localSongInfo.f = str5;
        localSongInfo.g = str4;
        arrayOfSongInfo[i] = localSongInfo;
        i += 1;
        break;
        paramJSONObject = "";
        break label80;
        str1 = "";
        break label99;
        str2 = "";
        break label118;
        str3 = "";
        break label137;
        str4 = "";
        break label156;
        str5 = "";
        break label175;
        localObject = "";
        break label194;
      }
    }
    return arrayOfSongInfo;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 4;
    case 3: 
      return 2;
    }
    return -1001;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService != null) {}
    try
    {
      String str1 = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
      String str2 = a();
      bool1 = bool2;
      if (!TextUtils.isEmpty(str1))
      {
        boolean bool3 = str1.equals(str2);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  private void c()
  {
    callJs(String.format("try{qqmusicBridge.appTrigger('%s');}catch(e){}", new Object[] { "CALLPAGE_SHARE" }));
  }
  
  private boolean c()
  {
    return (1 == this.c) || (2 == this.c);
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
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService exception", localException);
      return;
    }
    QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.bindQQPlayerService mRuntime is null!");
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
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934594L) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      Intent localIntent = new Intent("BROAD_CAST_UPDATE_TITLE");
      localIntent.putExtra("BUNDLE_KEY_URL", paramString);
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.music.data.permission");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  /* Error */
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: new 522	java/util/ArrayList
    //   3: dup
    //   4: aload 5
    //   6: invokestatic 528	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   9: invokespecial 531	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   12: astore 20
    //   14: ldc 59
    //   16: aload_3
    //   17: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +2978 -> 2998
    //   23: ldc_w 533
    //   26: aload 4
    //   28: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +2760 -> 2791
    //   34: aload 20
    //   36: iconst_0
    //   37: invokevirtual 534	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 279	java/lang/String
    //   43: astore_2
    //   44: new 164	org/json/JSONObject
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: ldc_w 536
    //   57: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   60: ifeq +108 -> 168
    //   63: aload_2
    //   64: ldc_w 536
    //   67: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore_3
    //   71: aload_2
    //   72: ldc_w 271
    //   75: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   78: ifeq +3012 -> 3090
    //   81: aload_2
    //   82: ldc_w 271
    //   85: invokevirtual 540	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   88: astore_2
    //   89: aload_2
    //   90: ifnull +65 -> 155
    //   93: aload_2
    //   94: ldc_w 356
    //   97: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   100: ifeq +55 -> 155
    //   103: aload_0
    //   104: aload_2
    //   105: ldc_w 356
    //   108: invokevirtual 543	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   111: putfield 454	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   114: ldc_w 545
    //   117: aload_3
    //   118: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: istore 13
    //   123: iload 13
    //   125: ifeq +86 -> 211
    //   128: ldc 142
    //   130: iconst_1
    //   131: ldc_w 547
    //   134: invokestatic 418	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_0
    //   138: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   141: ifnonnull +29 -> 170
    //   144: aload_0
    //   145: aload_1
    //   146: putfield 131	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener	Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;
    //   149: aload_0
    //   150: invokespecial 549	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:d	()V
    //   153: iconst_1
    //   154: ireturn
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 454	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   160: goto -46 -> 114
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   168: iconst_1
    //   169: ireturn
    //   170: new 164	org/json/JSONObject
    //   173: dup
    //   174: invokespecial 177	org/json/JSONObject:<init>	()V
    //   177: astore_2
    //   178: aload_2
    //   179: ldc_w 265
    //   182: ldc_w 267
    //   185: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   188: pop
    //   189: aload_1
    //   190: aload_2
    //   191: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   194: goto -41 -> 153
    //   197: astore_1
    //   198: ldc 142
    //   200: iconst_1
    //   201: ldc_w 556
    //   204: aload_1
    //   205: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: goto -55 -> 153
    //   211: aload_0
    //   212: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   215: astore 21
    //   217: aload 21
    //   219: ifnonnull +5 -> 224
    //   222: iconst_0
    //   223: ireturn
    //   224: ldc_w 558
    //   227: aload_3
    //   228: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +438 -> 669
    //   234: ldc_w 560
    //   237: astore_3
    //   238: aload_0
    //   239: aload_2
    //   240: invokespecial 562	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lorg/json/JSONObject;)[Lcom/tencent/mobileqq/music/SongInfo;
    //   243: astore 20
    //   245: aload 20
    //   247: ifnull +309 -> 556
    //   250: lconst_0
    //   251: lstore 14
    //   253: aload_2
    //   254: ldc_w 363
    //   257: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   260: ifeq +2824 -> 3084
    //   263: aload_2
    //   264: ldc_w 363
    //   267: invokevirtual 543	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   270: istore 8
    //   272: aload_2
    //   273: ldc_w 348
    //   276: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   279: ifeq +2798 -> 3077
    //   282: aload_2
    //   283: ldc_w 348
    //   286: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   289: astore_3
    //   290: aload_2
    //   291: ldc_w 564
    //   294: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   297: ifeq +12 -> 309
    //   300: aload_2
    //   301: ldc_w 564
    //   304: invokevirtual 567	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   307: lstore 14
    //   309: aload_2
    //   310: ldc_w 569
    //   313: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   316: ifeq +11 -> 327
    //   319: aload_2
    //   320: ldc_w 569
    //   323: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   326: pop
    //   327: aload_2
    //   328: ldc_w 426
    //   331: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   334: ifeq +2737 -> 3071
    //   337: aload_2
    //   338: ldc_w 426
    //   341: invokevirtual 430	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   344: astore 4
    //   346: lload 14
    //   348: invokestatic 573	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   351: astore 22
    //   353: aload_0
    //   354: invokespecial 136	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	()Z
    //   357: ifeq +224 -> 581
    //   360: aload_0
    //   361: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   364: aload_0
    //   365: getfield 458	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   368: invokevirtual 576	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   371: aload 22
    //   373: iconst_0
    //   374: invokestatic 579	com/tencent/mobileqq/musicpendant/MusicPendantManager:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)Landroid/content/Intent;
    //   377: astore 5
    //   379: aload_2
    //   380: ldc_w 581
    //   383: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   386: ifeq +31 -> 417
    //   389: aload_2
    //   390: ldc_w 581
    //   393: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: astore 22
    //   398: aload 22
    //   400: invokestatic 379	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   403: ifne +14 -> 417
    //   406: aload 5
    //   408: ldc_w 583
    //   411: aload 22
    //   413: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   416: pop
    //   417: new 308	android/os/Bundle
    //   420: dup
    //   421: invokespecial 584	android/os/Bundle:<init>	()V
    //   424: astore 22
    //   426: aload 22
    //   428: ldc_w 586
    //   431: lload 14
    //   433: invokevirtual 590	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   436: aload 22
    //   438: ldc_w 306
    //   441: aload_3
    //   442: invokevirtual 594	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: aload 22
    //   447: ldc_w 312
    //   450: aload_0
    //   451: getfield 454	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	I
    //   454: invokevirtual 598	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   457: aload 4
    //   459: ifnull +16 -> 475
    //   462: aload 22
    //   464: ldc_w 600
    //   467: aload 4
    //   469: invokevirtual 601	org/json/JSONArray:toString	()Ljava/lang/String;
    //   472: invokevirtual 594	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: aload 22
    //   477: ldc_w 271
    //   480: aload_2
    //   481: invokevirtual 339	org/json/JSONObject:toString	()Ljava/lang/String;
    //   484: invokevirtual 594	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload 21
    //   489: aload 22
    //   491: invokeinterface 604 2 0
    //   496: aload 21
    //   498: aload_0
    //   499: getfield 39	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerCallback$Stub	Lcom/tencent/mobileqq/music/IQQPlayerCallback$Stub;
    //   502: invokeinterface 607 2 0
    //   507: aload 5
    //   509: ifnull +12 -> 521
    //   512: aload 21
    //   514: aload 5
    //   516: invokeinterface 610 2 0
    //   521: aload_0
    //   522: invokespecial 136	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:c	()Z
    //   525: ifeq +124 -> 649
    //   528: aload 21
    //   530: bipush 102
    //   532: invokeinterface 613 2 0
    //   537: aload 21
    //   539: aload_0
    //   540: invokespecial 444	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Ljava/lang/String;
    //   543: aload 20
    //   545: iload 8
    //   547: invokeinterface 616 4 0
    //   552: ldc_w 267
    //   555: astore_3
    //   556: new 164	org/json/JSONObject
    //   559: dup
    //   560: invokespecial 177	org/json/JSONObject:<init>	()V
    //   563: astore_2
    //   564: aload_2
    //   565: ldc_w 265
    //   568: aload_3
    //   569: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   572: pop
    //   573: aload_1
    //   574: aload_2
    //   575: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   578: goto -410 -> 168
    //   581: new 465	android/content/Intent
    //   584: dup
    //   585: aload_0
    //   586: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   589: ldc_w 618
    //   592: invokespecial 470	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   595: astore 5
    //   597: ldc_w 620
    //   600: iconst_1
    //   601: anewarray 275	java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: aload 22
    //   608: aastore
    //   609: invokestatic 283	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   612: astore 23
    //   614: aload 5
    //   616: ldc_w 564
    //   619: aload 22
    //   621: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   624: pop
    //   625: aload 5
    //   627: ldc_w 583
    //   630: aload 23
    //   632: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   635: pop
    //   636: aload 5
    //   638: ldc_w 622
    //   641: iconst_1
    //   642: invokevirtual 625	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   645: pop
    //   646: goto -267 -> 379
    //   649: aload 21
    //   651: bipush 103
    //   653: invokeinterface 613 2 0
    //   658: goto -121 -> 537
    //   661: astore_2
    //   662: aload_2
    //   663: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   666: goto -114 -> 552
    //   669: ldc_w 627
    //   672: aload_3
    //   673: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   676: ifeq +48 -> 724
    //   679: aload_0
    //   680: aload 21
    //   682: invokeinterface 296 1 0
    //   687: putfield 629	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Int	I
    //   690: aload 21
    //   692: invokeinterface 631 1 0
    //   697: new 164	org/json/JSONObject
    //   700: dup
    //   701: invokespecial 177	org/json/JSONObject:<init>	()V
    //   704: astore_2
    //   705: aload_2
    //   706: ldc_w 265
    //   709: ldc_w 267
    //   712: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   715: pop
    //   716: aload_1
    //   717: aload_2
    //   718: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   721: goto -553 -> 168
    //   724: ldc_w 633
    //   727: aload_3
    //   728: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   731: ifeq +37 -> 768
    //   734: aload 21
    //   736: invokeinterface 635 1 0
    //   741: new 164	org/json/JSONObject
    //   744: dup
    //   745: invokespecial 177	org/json/JSONObject:<init>	()V
    //   748: astore_2
    //   749: aload_2
    //   750: ldc_w 265
    //   753: ldc_w 267
    //   756: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   759: pop
    //   760: aload_1
    //   761: aload_2
    //   762: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   765: goto -597 -> 168
    //   768: ldc_w 637
    //   771: aload_3
    //   772: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   775: ifeq +37 -> 812
    //   778: aload 21
    //   780: invokeinterface 638 1 0
    //   785: new 164	org/json/JSONObject
    //   788: dup
    //   789: invokespecial 177	org/json/JSONObject:<init>	()V
    //   792: astore_2
    //   793: aload_2
    //   794: ldc_w 265
    //   797: ldc_w 267
    //   800: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   803: pop
    //   804: aload_1
    //   805: aload_2
    //   806: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   809: goto -641 -> 168
    //   812: ldc_w 640
    //   815: aload_3
    //   816: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   819: ifeq +37 -> 856
    //   822: aload 21
    //   824: invokeinterface 641 1 0
    //   829: new 164	org/json/JSONObject
    //   832: dup
    //   833: invokespecial 177	org/json/JSONObject:<init>	()V
    //   836: astore_2
    //   837: aload_2
    //   838: ldc_w 265
    //   841: ldc_w 267
    //   844: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   847: pop
    //   848: aload_1
    //   849: aload_2
    //   850: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   853: goto -685 -> 168
    //   856: ldc_w 643
    //   859: aload_3
    //   860: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   863: ifeq +37 -> 900
    //   866: aload 21
    //   868: invokeinterface 645 1 0
    //   873: new 164	org/json/JSONObject
    //   876: dup
    //   877: invokespecial 177	org/json/JSONObject:<init>	()V
    //   880: astore_2
    //   881: aload_2
    //   882: ldc_w 265
    //   885: ldc_w 267
    //   888: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   891: pop
    //   892: aload_1
    //   893: aload_2
    //   894: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   897: goto -729 -> 168
    //   900: ldc_w 647
    //   903: aload_3
    //   904: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   907: istore 13
    //   909: iload 13
    //   911: ifeq +431 -> 1342
    //   914: aconst_null
    //   915: astore_2
    //   916: aload 21
    //   918: invokeinterface 304 1 0
    //   923: astore_3
    //   924: aload_3
    //   925: ifnull +2141 -> 3066
    //   928: aload_3
    //   929: astore_2
    //   930: aload_3
    //   931: ldc_w 271
    //   934: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   937: ifeq +2129 -> 3066
    //   940: aload_3
    //   941: astore_2
    //   942: new 164	org/json/JSONObject
    //   945: dup
    //   946: aload_3
    //   947: ldc_w 271
    //   950: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   953: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   956: astore 4
    //   958: aload 4
    //   960: astore_2
    //   961: aload_3
    //   962: astore 4
    //   964: aload_2
    //   965: ifnonnull +2096 -> 3061
    //   968: new 164	org/json/JSONObject
    //   971: dup
    //   972: invokespecial 177	org/json/JSONObject:<init>	()V
    //   975: astore_3
    //   976: aload_0
    //   977: invokespecial 294	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   980: astore 20
    //   982: aload 4
    //   984: ifnull +2111 -> 3095
    //   987: aload 4
    //   989: ldc_w 312
    //   992: iconst_0
    //   993: invokevirtual 316	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   996: istore 8
    //   998: aload 4
    //   1000: ifnull +2101 -> 3101
    //   1003: aload 4
    //   1005: ldc_w 586
    //   1008: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1011: ifeq +2090 -> 3101
    //   1014: aload 4
    //   1016: ldc_w 586
    //   1019: invokevirtual 651	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1022: lstore 14
    //   1024: aload 20
    //   1026: ifnull +292 -> 1318
    //   1029: aconst_null
    //   1030: astore 5
    //   1032: aload 5
    //   1034: astore_2
    //   1035: aload 4
    //   1037: ifnull +51 -> 1088
    //   1040: aload 5
    //   1042: astore_2
    //   1043: aload 4
    //   1045: ldc_w 600
    //   1048: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1051: ifeq +37 -> 1088
    //   1054: aload_0
    //   1055: new 155	org/json/JSONArray
    //   1058: dup
    //   1059: aload 4
    //   1061: ldc_w 600
    //   1064: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1067: invokespecial 652	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1070: invokespecial 654	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lorg/json/JSONArray;)Ljava/util/HashMap;
    //   1073: aload 20
    //   1075: getfield 194	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1078: invokestatic 573	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1081: invokevirtual 657	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: checkcast 164	org/json/JSONObject
    //   1087: astore_2
    //   1088: aload_2
    //   1089: ifnonnull +1969 -> 3058
    //   1092: aload_0
    //   1093: aload 20
    //   1095: invokespecial 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1098: astore_2
    //   1099: aload_2
    //   1100: ifnull +60 -> 1160
    //   1103: aload_2
    //   1104: invokevirtual 322	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1107: astore 4
    //   1109: aload 4
    //   1111: invokeinterface 327 1 0
    //   1116: ifeq +44 -> 1160
    //   1119: aload 4
    //   1121: invokeinterface 331 1 0
    //   1126: checkcast 279	java/lang/String
    //   1129: astore 5
    //   1131: aload_3
    //   1132: aload 5
    //   1134: aload_2
    //   1135: aload 5
    //   1137: invokevirtual 334	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   1140: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1143: pop
    //   1144: goto -35 -> 1109
    //   1147: astore_3
    //   1148: aload_3
    //   1149: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   1152: aload_2
    //   1153: astore 4
    //   1155: aconst_null
    //   1156: astore_2
    //   1157: goto -193 -> 964
    //   1160: aload_0
    //   1161: invokespecial 298	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()I
    //   1164: i2l
    //   1165: lstore 18
    //   1167: aload 21
    //   1169: invokeinterface 299 1 0
    //   1174: istore 9
    //   1176: aload_0
    //   1177: iload 9
    //   1179: invokespecial 301	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   1182: istore 10
    //   1184: iload 9
    //   1186: iconst_3
    //   1187: if_icmpne +104 -> 1291
    //   1190: aload_0
    //   1191: getfield 629	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Int	I
    //   1194: i2l
    //   1195: lstore 16
    //   1197: aload_0
    //   1198: invokespecial 365	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	()Z
    //   1201: ifeq +103 -> 1304
    //   1204: aload_3
    //   1205: ldc_w 265
    //   1208: ldc_w 267
    //   1211: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1214: pop
    //   1215: aload_3
    //   1216: ldc_w 341
    //   1219: lload 16
    //   1221: ldc2_w 220
    //   1224: ldiv
    //   1225: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1228: pop
    //   1229: aload_3
    //   1230: ldc_w 346
    //   1233: lload 18
    //   1235: ldc2_w 220
    //   1238: ldiv
    //   1239: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1242: pop
    //   1243: aload_3
    //   1244: ldc_w 354
    //   1247: iload 10
    //   1249: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1252: pop
    //   1253: aload_3
    //   1254: ldc_w 356
    //   1257: iload 8
    //   1259: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1262: pop
    //   1263: aload_3
    //   1264: ldc_w 564
    //   1267: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1270: ifne +13 -> 1283
    //   1273: aload_3
    //   1274: ldc_w 564
    //   1277: lload 14
    //   1279: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1282: pop
    //   1283: aload_1
    //   1284: aload_3
    //   1285: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1288: goto -1120 -> 168
    //   1291: aload 21
    //   1293: invokeinterface 296 1 0
    //   1298: i2l
    //   1299: lstore 16
    //   1301: goto -104 -> 1197
    //   1304: aload_3
    //   1305: ldc_w 265
    //   1308: ldc_w 267
    //   1311: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1314: pop
    //   1315: goto -100 -> 1215
    //   1318: aload_3
    //   1319: ldc_w 265
    //   1322: ldc_w 560
    //   1325: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1328: pop
    //   1329: aload_3
    //   1330: ldc_w 356
    //   1333: iload 8
    //   1335: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1338: pop
    //   1339: goto -76 -> 1263
    //   1342: ldc_w 659
    //   1345: aload_3
    //   1346: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1349: istore 13
    //   1351: iload 13
    //   1353: ifeq +532 -> 1885
    //   1356: aconst_null
    //   1357: astore_2
    //   1358: aload 21
    //   1360: invokeinterface 304 1 0
    //   1365: astore_3
    //   1366: aload_3
    //   1367: ifnull +1686 -> 3053
    //   1370: aload_3
    //   1371: astore_2
    //   1372: aload_3
    //   1373: ldc_w 271
    //   1376: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1379: ifeq +1674 -> 3053
    //   1382: aload_3
    //   1383: astore_2
    //   1384: new 164	org/json/JSONObject
    //   1387: dup
    //   1388: aload_3
    //   1389: ldc_w 271
    //   1392: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1395: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1398: astore 4
    //   1400: aload 4
    //   1402: astore_2
    //   1403: aload_3
    //   1404: astore 5
    //   1406: aload_2
    //   1407: ifnonnull +1640 -> 3047
    //   1410: new 164	org/json/JSONObject
    //   1413: dup
    //   1414: invokespecial 177	org/json/JSONObject:<init>	()V
    //   1417: astore 4
    //   1419: aload 5
    //   1421: ifnull +1699 -> 3120
    //   1424: aload 5
    //   1426: ldc_w 312
    //   1429: iconst_0
    //   1430: invokevirtual 316	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1433: istore 11
    //   1435: aload 5
    //   1437: ifnull +1689 -> 3126
    //   1440: aload 5
    //   1442: ldc_w 586
    //   1445: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1448: ifeq +1678 -> 3126
    //   1451: aload 5
    //   1453: ldc_w 586
    //   1456: invokevirtual 651	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1459: lstore 14
    //   1461: aconst_null
    //   1462: astore 20
    //   1464: ldc_w 267
    //   1467: astore_3
    //   1468: aload 5
    //   1470: ifnull +1571 -> 3041
    //   1473: aload 5
    //   1475: ldc_w 306
    //   1478: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1481: ifeq +1651 -> 3132
    //   1484: aload 5
    //   1486: ldc_w 306
    //   1489: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1492: astore_2
    //   1493: aload_2
    //   1494: astore_3
    //   1495: aload 5
    //   1497: ldc_w 600
    //   1500: invokevirtual 650	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   1503: ifeq +1538 -> 3041
    //   1506: new 155	org/json/JSONArray
    //   1509: dup
    //   1510: aload 5
    //   1512: ldc_w 600
    //   1515: invokevirtual 309	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1518: invokespecial 652	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   1521: astore 5
    //   1523: aload_2
    //   1524: astore_3
    //   1525: aload 5
    //   1527: astore_2
    //   1528: iconst_0
    //   1529: istore 12
    //   1531: iconst_0
    //   1532: istore 10
    //   1534: iconst_0
    //   1535: istore 8
    //   1537: iconst_0
    //   1538: istore 9
    //   1540: aload_2
    //   1541: ifnonnull +249 -> 1790
    //   1544: new 155	org/json/JSONArray
    //   1547: dup
    //   1548: invokespecial 660	org/json/JSONArray:<init>	()V
    //   1551: astore_2
    //   1552: aload 21
    //   1554: invokeinterface 663 1 0
    //   1559: astore 5
    //   1561: aload_0
    //   1562: invokespecial 294	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1565: astore 20
    //   1567: iload 8
    //   1569: istore 10
    //   1571: aload 5
    //   1573: ifnull +1566 -> 3139
    //   1576: iconst_0
    //   1577: istore 8
    //   1579: iload 9
    //   1581: istore 10
    //   1583: iload 8
    //   1585: aload 5
    //   1587: arraylength
    //   1588: if_icmpge +1551 -> 3139
    //   1591: aload 5
    //   1593: iload 8
    //   1595: aaload
    //   1596: astore 22
    //   1598: iload 9
    //   1600: istore 10
    //   1602: aload 22
    //   1604: ifnull +1503 -> 3107
    //   1607: aload_2
    //   1608: iload 8
    //   1610: aload_0
    //   1611: aload 22
    //   1613: invokespecial 318	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Lcom/tencent/mobileqq/music/SongInfo;)Lorg/json/JSONObject;
    //   1616: invokevirtual 666	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   1619: pop
    //   1620: iload 9
    //   1622: istore 10
    //   1624: aload 20
    //   1626: ifnull +1481 -> 3107
    //   1629: iload 9
    //   1631: istore 10
    //   1633: aload 22
    //   1635: getfield 194	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1638: aload 20
    //   1640: getfield 194	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1643: lcmp
    //   1644: ifne +1463 -> 3107
    //   1647: iload 8
    //   1649: istore 10
    //   1651: goto +1456 -> 3107
    //   1654: astore_3
    //   1655: aload_3
    //   1656: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   1659: aload_2
    //   1660: astore 5
    //   1662: aconst_null
    //   1663: astore_2
    //   1664: goto -258 -> 1406
    //   1667: aload 4
    //   1669: ldc_w 363
    //   1672: iload 10
    //   1674: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1677: pop
    //   1678: aload 4
    //   1680: ldc_w 354
    //   1683: aload_0
    //   1684: aload 21
    //   1686: invokeinterface 299 1 0
    //   1691: invokespecial 301	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	(I)I
    //   1694: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1697: pop
    //   1698: aload 4
    //   1700: ldc_w 348
    //   1703: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1706: ifne +13 -> 1719
    //   1709: aload 4
    //   1711: ldc_w 348
    //   1714: aload_3
    //   1715: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1718: pop
    //   1719: aload 4
    //   1721: ldc_w 426
    //   1724: aload_2
    //   1725: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1728: pop
    //   1729: aload_0
    //   1730: invokespecial 365	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:b	()Z
    //   1733: ifeq +137 -> 1870
    //   1736: aload 4
    //   1738: ldc_w 265
    //   1741: ldc_w 267
    //   1744: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1747: pop
    //   1748: aload 4
    //   1750: ldc_w 564
    //   1753: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1756: ifne +14 -> 1770
    //   1759: aload 4
    //   1761: ldc_w 564
    //   1764: lload 14
    //   1766: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1769: pop
    //   1770: aload 4
    //   1772: ldc_w 356
    //   1775: iload 11
    //   1777: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1780: pop
    //   1781: aload_1
    //   1782: aload 4
    //   1784: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1787: goto -1619 -> 168
    //   1790: aload 21
    //   1792: invokeinterface 663 1 0
    //   1797: astore 5
    //   1799: aload_0
    //   1800: invokespecial 294	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1803: astore 20
    //   1805: aload 5
    //   1807: ifnull +1231 -> 3038
    //   1810: iconst_0
    //   1811: istore 8
    //   1813: iload 12
    //   1815: istore 9
    //   1817: iload 9
    //   1819: istore 10
    //   1821: iload 8
    //   1823: aload 5
    //   1825: arraylength
    //   1826: if_icmpge +1212 -> 3038
    //   1829: aload 5
    //   1831: iload 8
    //   1833: aaload
    //   1834: astore 22
    //   1836: iload 9
    //   1838: istore 10
    //   1840: aload 22
    //   1842: ifnull +1300 -> 3142
    //   1845: iload 9
    //   1847: istore 10
    //   1849: aload 22
    //   1851: getfield 194	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1854: aload 20
    //   1856: getfield 194	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_Long	J
    //   1859: lcmp
    //   1860: ifne +1282 -> 3142
    //   1863: iload 8
    //   1865: istore 10
    //   1867: goto +1275 -> 3142
    //   1870: aload 4
    //   1872: ldc_w 265
    //   1875: ldc_w 267
    //   1878: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1881: pop
    //   1882: goto -134 -> 1748
    //   1885: ldc_w 668
    //   1888: aload_3
    //   1889: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1892: ifeq +78 -> 1970
    //   1895: bipush 103
    //   1897: istore 9
    //   1899: iload 9
    //   1901: istore 8
    //   1903: aload_2
    //   1904: ifnull +26 -> 1930
    //   1907: iload 9
    //   1909: istore 8
    //   1911: aload_2
    //   1912: ldc_w 670
    //   1915: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1918: ifeq +12 -> 1930
    //   1921: aload_2
    //   1922: ldc_w 670
    //   1925: invokevirtual 543	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1928: istore 8
    //   1930: aload 21
    //   1932: aload_0
    //   1933: iload 8
    //   1935: invokespecial 672	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(I)I
    //   1938: invokeinterface 613 2 0
    //   1943: new 164	org/json/JSONObject
    //   1946: dup
    //   1947: invokespecial 177	org/json/JSONObject:<init>	()V
    //   1950: astore_2
    //   1951: aload_2
    //   1952: ldc_w 265
    //   1955: ldc_w 267
    //   1958: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1961: pop
    //   1962: aload_1
    //   1963: aload_2
    //   1964: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   1967: goto -1799 -> 168
    //   1970: ldc_w 674
    //   1973: aload_3
    //   1974: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1977: ifeq +108 -> 2085
    //   1980: aload_2
    //   1981: ifnull +1051 -> 3032
    //   1984: aload_2
    //   1985: ldc_w 676
    //   1988: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1991: ifeq +1041 -> 3032
    //   1994: aload_2
    //   1995: ldc_w 676
    //   1998: invokevirtual 543	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2001: istore 8
    //   2003: new 164	org/json/JSONObject
    //   2006: dup
    //   2007: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2010: astore_3
    //   2011: aload_0
    //   2012: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2015: astore_2
    //   2016: aload_2
    //   2017: ifnull +1008 -> 3025
    //   2020: iload 8
    //   2022: iflt +1003 -> 3025
    //   2025: iload 8
    //   2027: bipush 100
    //   2029: if_icmpgt +996 -> 3025
    //   2032: aload_2
    //   2033: ldc_w 678
    //   2036: invokevirtual 681	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2039: checkcast 683	android/media/AudioManager
    //   2042: astore_2
    //   2043: aload_2
    //   2044: ifnull +981 -> 3025
    //   2047: aload_2
    //   2048: iconst_3
    //   2049: aload_2
    //   2050: iconst_3
    //   2051: invokevirtual 686	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2054: iload 8
    //   2056: imul
    //   2057: bipush 100
    //   2059: idiv
    //   2060: iconst_4
    //   2061: invokevirtual 690	android/media/AudioManager:setStreamVolume	(III)V
    //   2064: ldc_w 267
    //   2067: astore_2
    //   2068: aload_3
    //   2069: ldc_w 265
    //   2072: aload_2
    //   2073: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2076: pop
    //   2077: aload_1
    //   2078: aload_3
    //   2079: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2082: goto -1914 -> 168
    //   2085: ldc_w 692
    //   2088: aload_3
    //   2089: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2092: ifeq +192 -> 2284
    //   2095: aload_2
    //   2096: ifnull +146 -> 2242
    //   2099: aload_2
    //   2100: ldc_w 269
    //   2103: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2106: ifeq +136 -> 2242
    //   2109: aload_2
    //   2110: ldc_w 269
    //   2113: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2116: astore_3
    //   2117: aload_2
    //   2118: ldc_w 694
    //   2121: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2124: ifeq +124 -> 2248
    //   2127: aload_2
    //   2128: ldc_w 694
    //   2131: invokevirtual 543	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   2134: istore 8
    //   2136: aload_3
    //   2137: invokestatic 699	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   2140: astore_2
    //   2141: new 701	java/io/File
    //   2144: dup
    //   2145: new 701	java/io/File
    //   2148: dup
    //   2149: new 253	java/lang/StringBuilder
    //   2152: dup
    //   2153: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   2156: getstatic 706	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   2159: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: getstatic 709	java/io/File:separator	Ljava/lang/String;
    //   2165: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2168: ldc_w 711
    //   2171: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: invokespecial 712	java/io/File:<init>	(Ljava/lang/String;)V
    //   2180: aload_2
    //   2181: invokespecial 715	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2184: astore_2
    //   2185: aload_2
    //   2186: ifnull +10 -> 2196
    //   2189: aload_2
    //   2190: invokevirtual 718	java/io/File:exists	()Z
    //   2193: ifne +61 -> 2254
    //   2196: new 720	aekm
    //   2199: dup
    //   2200: aload_0
    //   2201: aload_3
    //   2202: iload 8
    //   2204: aload_2
    //   2205: invokespecial 723	aekm:<init>	(Lcom/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin;Ljava/lang/String;ILjava/io/File;)V
    //   2208: bipush 8
    //   2210: aconst_null
    //   2211: iconst_1
    //   2212: invokestatic 729	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2215: new 164	org/json/JSONObject
    //   2218: dup
    //   2219: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2222: astore_2
    //   2223: aload_2
    //   2224: ldc_w 265
    //   2227: ldc_w 267
    //   2230: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2233: pop
    //   2234: aload_1
    //   2235: aload_2
    //   2236: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2239: goto -2071 -> 168
    //   2242: ldc 147
    //   2244: astore_3
    //   2245: goto -128 -> 2117
    //   2248: iconst_0
    //   2249: istore 8
    //   2251: goto -115 -> 2136
    //   2254: aload_0
    //   2255: aload_2
    //   2256: invokevirtual 732	java/io/File:getPath	()Ljava/lang/String;
    //   2259: invokestatic 735	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   2262: invokespecial 291	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	(Landroid/graphics/Bitmap;)V
    //   2265: goto -50 -> 2215
    //   2268: astore_2
    //   2269: aload_2
    //   2270: invokevirtual 115	java/lang/OutOfMemoryError:printStackTrace	()V
    //   2273: goto -58 -> 2215
    //   2276: astore_2
    //   2277: aload_2
    //   2278: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   2281: goto -66 -> 2215
    //   2284: ldc_w 737
    //   2287: aload_3
    //   2288: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2291: ifeq +106 -> 2397
    //   2294: aload_0
    //   2295: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2298: astore_2
    //   2299: new 164	org/json/JSONObject
    //   2302: dup
    //   2303: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2306: astore_3
    //   2307: aload_2
    //   2308: ifnull +710 -> 3018
    //   2311: aload_2
    //   2312: ldc_w 678
    //   2315: invokevirtual 681	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2318: checkcast 683	android/media/AudioManager
    //   2321: astore_2
    //   2322: aload_2
    //   2323: ifnull +695 -> 3018
    //   2326: aload_2
    //   2327: iconst_3
    //   2328: invokevirtual 686	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   2331: i2f
    //   2332: fstore 6
    //   2334: aload_2
    //   2335: iconst_3
    //   2336: invokevirtual 740	android/media/AudioManager:getStreamVolume	(I)I
    //   2339: i2f
    //   2340: fstore 7
    //   2342: fload 7
    //   2344: f2i
    //   2345: istore 8
    //   2347: fload 6
    //   2349: fconst_0
    //   2350: fcmpl
    //   2351: ifle +15 -> 2366
    //   2354: fload 7
    //   2356: fload 6
    //   2358: fdiv
    //   2359: ldc_w 741
    //   2362: fmul
    //   2363: f2i
    //   2364: istore 8
    //   2366: aload_3
    //   2367: ldc_w 676
    //   2370: iload 8
    //   2372: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2375: pop
    //   2376: ldc_w 267
    //   2379: astore_2
    //   2380: aload_3
    //   2381: ldc_w 265
    //   2384: aload_2
    //   2385: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2388: pop
    //   2389: aload_1
    //   2390: aload_3
    //   2391: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2394: goto -2226 -> 168
    //   2397: ldc_w 743
    //   2400: aload_3
    //   2401: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2404: ifeq +185 -> 2589
    //   2407: aload_2
    //   2408: ldc_w 745
    //   2411: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2414: astore 4
    //   2416: aload_2
    //   2417: ldc_w 747
    //   2420: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2423: astore 5
    //   2425: aload_2
    //   2426: ldc_w 269
    //   2429: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2432: astore 20
    //   2434: aload_2
    //   2435: ldc_w 749
    //   2438: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2441: astore 21
    //   2443: aload_2
    //   2444: ldc_w 751
    //   2447: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2450: astore 22
    //   2452: ldc_w 753
    //   2455: astore_3
    //   2456: aload_2
    //   2457: ldc_w 755
    //   2460: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2463: ifeq +11 -> 2474
    //   2466: aload_2
    //   2467: ldc_w 755
    //   2470: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2473: astore_3
    //   2474: aload_0
    //   2475: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2478: ifnull +84 -> 2562
    //   2481: new 465	android/content/Intent
    //   2484: dup
    //   2485: ldc_w 757
    //   2488: invokespecial 502	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2491: astore_2
    //   2492: aload_2
    //   2493: ldc_w 759
    //   2496: aload 4
    //   2498: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2501: pop
    //   2502: aload_2
    //   2503: ldc_w 761
    //   2506: aload 5
    //   2508: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2511: pop
    //   2512: aload_2
    //   2513: ldc_w 763
    //   2516: aload 20
    //   2518: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2521: pop
    //   2522: aload_2
    //   2523: ldc_w 765
    //   2526: aload 21
    //   2528: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2531: pop
    //   2532: aload_2
    //   2533: ldc_w 767
    //   2536: aload 22
    //   2538: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2541: pop
    //   2542: aload_2
    //   2543: ldc_w 769
    //   2546: aload_3
    //   2547: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2550: pop
    //   2551: aload_0
    //   2552: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2555: aload_2
    //   2556: ldc_w 510
    //   2559: invokevirtual 516	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2562: new 164	org/json/JSONObject
    //   2565: dup
    //   2566: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2569: astore_2
    //   2570: aload_2
    //   2571: ldc_w 265
    //   2574: ldc_w 267
    //   2577: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2580: pop
    //   2581: aload_1
    //   2582: aload_2
    //   2583: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2586: goto -2418 -> 168
    //   2589: ldc_w 771
    //   2592: aload_3
    //   2593: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2596: ifeq -2428 -> 168
    //   2599: aload_2
    //   2600: ldc_w 745
    //   2603: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2606: astore 4
    //   2608: aload_2
    //   2609: ldc_w 747
    //   2612: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2615: astore 5
    //   2617: aload_2
    //   2618: ldc_w 269
    //   2621: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2624: astore 20
    //   2626: aload_2
    //   2627: ldc_w 749
    //   2630: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2633: astore 21
    //   2635: aload_2
    //   2636: ldc_w 773
    //   2639: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2642: ifeq +368 -> 3010
    //   2645: aload_2
    //   2646: ldc_w 773
    //   2649: invokevirtual 567	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2652: lstore 14
    //   2654: ldc_w 753
    //   2657: astore_3
    //   2658: aload_2
    //   2659: ldc_w 755
    //   2662: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2665: ifeq +11 -> 2676
    //   2668: aload_2
    //   2669: ldc_w 755
    //   2672: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2675: astore_3
    //   2676: aload_0
    //   2677: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2680: ifnull +84 -> 2764
    //   2683: new 465	android/content/Intent
    //   2686: dup
    //   2687: ldc_w 775
    //   2690: invokespecial 502	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2693: astore_2
    //   2694: aload_2
    //   2695: ldc_w 759
    //   2698: aload 4
    //   2700: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2703: pop
    //   2704: aload_2
    //   2705: ldc_w 761
    //   2708: aload 5
    //   2710: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2713: pop
    //   2714: aload_2
    //   2715: ldc_w 763
    //   2718: aload 20
    //   2720: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2723: pop
    //   2724: aload_2
    //   2725: ldc_w 765
    //   2728: aload 21
    //   2730: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2733: pop
    //   2734: aload_2
    //   2735: ldc_w 777
    //   2738: lload 14
    //   2740: invokevirtual 780	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2743: pop
    //   2744: aload_2
    //   2745: ldc_w 769
    //   2748: aload_3
    //   2749: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2752: pop
    //   2753: aload_0
    //   2754: getfield 499	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   2757: aload_2
    //   2758: ldc_w 510
    //   2761: invokevirtual 516	android/content/Context:sendBroadcast	(Landroid/content/Intent;Ljava/lang/String;)V
    //   2764: new 164	org/json/JSONObject
    //   2767: dup
    //   2768: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2771: astore_2
    //   2772: aload_2
    //   2773: ldc_w 265
    //   2776: ldc_w 267
    //   2779: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2782: pop
    //   2783: aload_1
    //   2784: aload_2
    //   2785: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2788: goto -2620 -> 168
    //   2791: ldc_w 782
    //   2794: aload 4
    //   2796: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2799: ifeq +185 -> 2984
    //   2802: aload 20
    //   2804: iconst_0
    //   2805: invokevirtual 534	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2808: checkcast 279	java/lang/String
    //   2811: astore_2
    //   2812: new 164	org/json/JSONObject
    //   2815: dup
    //   2816: aload_2
    //   2817: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2820: astore_3
    //   2821: aconst_null
    //   2822: astore_2
    //   2823: aload_3
    //   2824: ldc_w 536
    //   2827: invokevirtual 352	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2830: ifeq +11 -> 2841
    //   2833: aload_3
    //   2834: ldc_w 536
    //   2837: invokevirtual 170	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2840: astore_2
    //   2841: aload_0
    //   2842: getfield 71	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService	Lcom/tencent/mobileqq/music/IQQPlayerService;
    //   2845: invokeinterface 304 1 0
    //   2850: astore_3
    //   2851: aload_3
    //   2852: ifnull +307 -> 3159
    //   2855: aload_3
    //   2856: ldc_w 312
    //   2859: iconst_0
    //   2860: invokevirtual 316	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   2863: istore 8
    //   2865: ldc_w 367
    //   2868: aload_2
    //   2869: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2872: ifeq +60 -> 2932
    //   2875: aload_0
    //   2876: iconst_1
    //   2877: putfield 359	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_a_of_type_Boolean	Z
    //   2880: new 164	org/json/JSONObject
    //   2883: dup
    //   2884: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2887: astore_2
    //   2888: aload_2
    //   2889: ldc_w 356
    //   2892: iload 8
    //   2894: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2897: pop
    //   2898: aload_2
    //   2899: ldc_w 265
    //   2902: ldc_w 267
    //   2905: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2908: pop
    //   2909: aload_1
    //   2910: aload_2
    //   2911: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2914: aload_0
    //   2915: invokespecial 783	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:a	()V
    //   2918: goto -2750 -> 168
    //   2921: astore_3
    //   2922: aload_3
    //   2923: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   2926: iconst_0
    //   2927: istore 8
    //   2929: goto -64 -> 2865
    //   2932: ldc_w 338
    //   2935: aload_2
    //   2936: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2939: ifeq -2771 -> 168
    //   2942: aload_0
    //   2943: iconst_1
    //   2944: putfield 293	com/tencent/mobileqq/musicgene/MusicGeneWebViewPlugin:jdField_b_of_type_Boolean	Z
    //   2947: new 164	org/json/JSONObject
    //   2950: dup
    //   2951: invokespecial 177	org/json/JSONObject:<init>	()V
    //   2954: astore_2
    //   2955: aload_2
    //   2956: ldc_w 356
    //   2959: iload 8
    //   2961: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2964: pop
    //   2965: aload_2
    //   2966: ldc_w 265
    //   2969: ldc_w 267
    //   2972: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2975: pop
    //   2976: aload_1
    //   2977: aload_2
    //   2978: invokevirtual 554	com/tencent/mobileqq/webview/swift/JsBridgeListener:a	(Ljava/lang/Object;)V
    //   2981: goto -2813 -> 168
    //   2984: ldc_w 785
    //   2987: aload 4
    //   2989: invokevirtual 448	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2992: ifeq -2824 -> 168
    //   2995: goto -2827 -> 168
    //   2998: aload_0
    //   2999: aload_1
    //   3000: aload_2
    //   3001: aload_3
    //   3002: aload 4
    //   3004: aload 5
    //   3006: invokespecial 787	com/tencent/mobileqq/webview/swift/WebViewPlugin:handleJsRequest	(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z
    //   3009: ireturn
    //   3010: ldc2_w 788
    //   3013: lstore 14
    //   3015: goto -361 -> 2654
    //   3018: ldc_w 560
    //   3021: astore_2
    //   3022: goto -642 -> 2380
    //   3025: ldc_w 560
    //   3028: astore_2
    //   3029: goto -961 -> 2068
    //   3032: iconst_0
    //   3033: istore 8
    //   3035: goto -1032 -> 2003
    //   3038: goto -1371 -> 1667
    //   3041: aload 20
    //   3043: astore_2
    //   3044: goto -1516 -> 1528
    //   3047: aload_2
    //   3048: astore 4
    //   3050: goto -1631 -> 1419
    //   3053: aconst_null
    //   3054: astore_2
    //   3055: goto -1652 -> 1403
    //   3058: goto -1959 -> 1099
    //   3061: aload_2
    //   3062: astore_3
    //   3063: goto -2087 -> 976
    //   3066: aconst_null
    //   3067: astore_2
    //   3068: goto -2107 -> 961
    //   3071: aconst_null
    //   3072: astore 4
    //   3074: goto -2728 -> 346
    //   3077: ldc_w 267
    //   3080: astore_3
    //   3081: goto -2791 -> 290
    //   3084: iconst_0
    //   3085: istore 8
    //   3087: goto -2815 -> 272
    //   3090: aconst_null
    //   3091: astore_2
    //   3092: goto -3003 -> 89
    //   3095: iconst_0
    //   3096: istore 8
    //   3098: goto -2100 -> 998
    //   3101: lconst_0
    //   3102: lstore 14
    //   3104: goto -2080 -> 1024
    //   3107: iload 8
    //   3109: iconst_1
    //   3110: iadd
    //   3111: istore 8
    //   3113: iload 10
    //   3115: istore 9
    //   3117: goto -1538 -> 1579
    //   3120: iconst_0
    //   3121: istore 11
    //   3123: goto -1688 -> 1435
    //   3126: lconst_0
    //   3127: lstore 14
    //   3129: goto -1668 -> 1461
    //   3132: ldc_w 267
    //   3135: astore_2
    //   3136: goto -1643 -> 1493
    //   3139: goto -1472 -> 1667
    //   3142: iload 8
    //   3144: iconst_1
    //   3145: iadd
    //   3146: istore 8
    //   3148: iload 10
    //   3150: istore 9
    //   3152: goto -1335 -> 1817
    //   3155: astore_1
    //   3156: goto -2988 -> 168
    //   3159: iconst_0
    //   3160: istore 8
    //   3162: goto -297 -> 2865
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3165	0	this	MusicGeneWebViewPlugin
    //   0	3165	1	paramJsBridgeListener	JsBridgeListener
    //   0	3165	2	paramString1	String
    //   0	3165	3	paramString2	String
    //   0	3165	4	paramString3	String
    //   0	3165	5	paramVarArgs	String[]
    //   2332	25	6	f1	float
    //   2340	15	7	f2	float
    //   270	2891	8	i	int
    //   1174	1977	9	j	int
    //   1182	1967	10	k	int
    //   1433	1689	11	m	int
    //   1529	285	12	n	int
    //   121	1231	13	bool	boolean
    //   251	2877	14	l1	long
    //   1195	105	16	l2	long
    //   1165	69	18	l3	long
    //   12	3030	20	localObject1	Object
    //   215	2514	21	localObject2	Object
    //   351	2186	22	localObject3	Object
    //   612	19	23	str	String
    // Exception table:
    //   from	to	target	type
    //   44	89	163	java/lang/Exception
    //   93	114	163	java/lang/Exception
    //   114	123	163	java/lang/Exception
    //   155	160	163	java/lang/Exception
    //   198	208	163	java/lang/Exception
    //   211	217	163	java/lang/Exception
    //   224	234	163	java/lang/Exception
    //   238	245	163	java/lang/Exception
    //   253	272	163	java/lang/Exception
    //   272	290	163	java/lang/Exception
    //   290	309	163	java/lang/Exception
    //   309	327	163	java/lang/Exception
    //   327	346	163	java/lang/Exception
    //   346	379	163	java/lang/Exception
    //   379	417	163	java/lang/Exception
    //   417	457	163	java/lang/Exception
    //   462	475	163	java/lang/Exception
    //   475	487	163	java/lang/Exception
    //   556	578	163	java/lang/Exception
    //   581	646	163	java/lang/Exception
    //   662	666	163	java/lang/Exception
    //   669	721	163	java/lang/Exception
    //   724	765	163	java/lang/Exception
    //   768	809	163	java/lang/Exception
    //   812	853	163	java/lang/Exception
    //   856	897	163	java/lang/Exception
    //   900	909	163	java/lang/Exception
    //   968	976	163	java/lang/Exception
    //   976	982	163	java/lang/Exception
    //   987	998	163	java/lang/Exception
    //   1003	1024	163	java/lang/Exception
    //   1043	1088	163	java/lang/Exception
    //   1092	1099	163	java/lang/Exception
    //   1103	1109	163	java/lang/Exception
    //   1109	1144	163	java/lang/Exception
    //   1148	1152	163	java/lang/Exception
    //   1160	1184	163	java/lang/Exception
    //   1190	1197	163	java/lang/Exception
    //   1197	1215	163	java/lang/Exception
    //   1215	1263	163	java/lang/Exception
    //   1263	1283	163	java/lang/Exception
    //   1283	1288	163	java/lang/Exception
    //   1291	1301	163	java/lang/Exception
    //   1304	1315	163	java/lang/Exception
    //   1318	1339	163	java/lang/Exception
    //   1342	1351	163	java/lang/Exception
    //   1410	1419	163	java/lang/Exception
    //   1424	1435	163	java/lang/Exception
    //   1440	1461	163	java/lang/Exception
    //   1473	1493	163	java/lang/Exception
    //   1495	1523	163	java/lang/Exception
    //   1544	1567	163	java/lang/Exception
    //   1583	1591	163	java/lang/Exception
    //   1607	1620	163	java/lang/Exception
    //   1633	1647	163	java/lang/Exception
    //   1655	1659	163	java/lang/Exception
    //   1667	1719	163	java/lang/Exception
    //   1719	1748	163	java/lang/Exception
    //   1748	1770	163	java/lang/Exception
    //   1770	1787	163	java/lang/Exception
    //   1790	1805	163	java/lang/Exception
    //   1821	1829	163	java/lang/Exception
    //   1849	1863	163	java/lang/Exception
    //   1870	1882	163	java/lang/Exception
    //   1885	1895	163	java/lang/Exception
    //   1911	1930	163	java/lang/Exception
    //   1930	1967	163	java/lang/Exception
    //   1970	1980	163	java/lang/Exception
    //   1984	2003	163	java/lang/Exception
    //   2003	2016	163	java/lang/Exception
    //   2032	2043	163	java/lang/Exception
    //   2047	2064	163	java/lang/Exception
    //   2068	2082	163	java/lang/Exception
    //   2085	2095	163	java/lang/Exception
    //   2099	2117	163	java/lang/Exception
    //   2117	2136	163	java/lang/Exception
    //   2136	2185	163	java/lang/Exception
    //   2189	2196	163	java/lang/Exception
    //   2196	2215	163	java/lang/Exception
    //   2215	2239	163	java/lang/Exception
    //   2269	2273	163	java/lang/Exception
    //   2277	2281	163	java/lang/Exception
    //   2284	2307	163	java/lang/Exception
    //   2311	2322	163	java/lang/Exception
    //   2326	2342	163	java/lang/Exception
    //   2354	2366	163	java/lang/Exception
    //   2366	2376	163	java/lang/Exception
    //   2380	2394	163	java/lang/Exception
    //   2397	2452	163	java/lang/Exception
    //   2456	2474	163	java/lang/Exception
    //   2474	2562	163	java/lang/Exception
    //   2562	2586	163	java/lang/Exception
    //   2589	2654	163	java/lang/Exception
    //   2658	2676	163	java/lang/Exception
    //   2676	2764	163	java/lang/Exception
    //   2764	2788	163	java/lang/Exception
    //   128	153	197	java/lang/Exception
    //   170	194	197	java/lang/Exception
    //   487	507	661	java/lang/Exception
    //   512	521	661	java/lang/Exception
    //   521	537	661	java/lang/Exception
    //   537	552	661	java/lang/Exception
    //   649	658	661	java/lang/Exception
    //   916	924	1147	java/lang/Exception
    //   930	940	1147	java/lang/Exception
    //   942	958	1147	java/lang/Exception
    //   1358	1366	1654	java/lang/Exception
    //   1372	1382	1654	java/lang/Exception
    //   1384	1400	1654	java/lang/Exception
    //   2254	2265	2268	java/lang/OutOfMemoryError
    //   2254	2265	2276	java/lang/Exception
    //   2841	2851	2921	java/lang/Exception
    //   2855	2865	2921	java/lang/Exception
    //   2812	2821	3155	org/json/JSONException
    //   2823	2841	3155	org/json/JSONException
    //   2841	2851	3155	org/json/JSONException
    //   2855	2865	3155	org/json/JSONException
    //   2865	2918	3155	org/json/JSONException
    //   2922	2926	3155	org/json/JSONException
    //   2932	2981	3155	org/json/JSONException
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService == null) && (a(paramString1))) {
        d();
      }
      return super.handleSchemaRequest(paramString1, paramString2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.handleSchemaRequest exception", localException);
      }
    }
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
    for (;;)
    {
      try
      {
        b();
        if (this.jdField_a_of_type_AndroidContentContext != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService;
          if (localObject == null) {}
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", localException);
        continue;
      }
      try
      {
        i = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
        if ((i == 2) || (i == 3)) {}
        try
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.a();
          if ((localObject != null) && (((String)localObject).startsWith("music_gene_"))) {
            this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService.c();
          }
        }
        catch (RemoteException localRemoteException2)
        {
          localRemoteException2.printStackTrace();
          continue;
        }
        a(4);
        e();
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentContext = null;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = null;
        super.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
        i = 4;
      }
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {}
    label122:
    for (;;)
    {
      try
      {
        paramCustomWebView = paramCustomWebView.getUrl();
        if (!TextUtils.isEmpty(paramCustomWebView)) {
          break label122;
        }
        WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
        if ((localWebUiBaseInterface == null) || (!(localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
          break label122;
        }
        paramCustomWebView = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).b();
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break;
        }
        if (a(paramCustomWebView)) {
          d();
        }
        paramCustomWebView = new IntentFilter();
        paramCustomWebView.addAction("BROAD_CAST_CALL_PAGE_SHARE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramCustomWebView);
        return;
      }
      catch (Exception paramCustomWebView)
      {
        QLog.e("MusicGeneWebViewPlugin", 1, "MusicGeneWebViewPlugin.onCreate exception", paramCustomWebView);
        return;
      }
      paramCustomWebView = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */