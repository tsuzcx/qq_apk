package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DebugTbsPlugin
{
  private static final String DEBUGVIEW_CLASS_NAME = "com.tencent.tbs.debug.plugin.DebugView";
  public static final String DEBUG_PLUGIN_APK = "DebugPlugin.apk";
  public static final String DEBUG_PLUGIN_TBS = "DebugPlugin.tbs";
  private static final String DEBUG_TBS_PLUGIN_PATH = "http://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs";
  private static final String LOGTAG = "debugtbs";
  public static final String SCHEME_DEBUG_TBS = "http://debugtbs.qq.com";
  public static final String SCHEME_DEBUG_X5 = "http://debugx5.qq.com";
  private static final String TBS_DEBUG_FOLDER_NAME = "debugtbs";
  private static final String TBS_PLUGIN_APK_SIG = "308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d";
  private static Looper downloadThreadLooper = null;
  private static DexClassLoader mDexLoader = null;
  private static DebugTbsPlugin mInstance = null;
  public String mDebugPluginPath = "";
  
  private DebugTbsPlugin(Context paramContext)
  {
    this.mDebugPluginPath = (paramContext.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin");
  }
  
  @SuppressLint({"NewApi"})
  public static void downloadDebugTbsPlugin(String paramString, final DebugDownloadStatusListener paramDebugDownloadStatusListener)
  {
    new Thread()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 4
        //   6: aconst_null
        //   7: astore 5
        //   9: aconst_null
        //   10: astore 8
        //   12: new 27	java/net/URL
        //   15: dup
        //   16: ldc 29
        //   18: invokespecial 32	java/net/URL:<init>	(Ljava/lang/String;)V
        //   21: invokevirtual 36	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   24: checkcast 38	java/net/HttpURLConnection
        //   27: astore 6
        //   29: aload 6
        //   31: invokevirtual 42	java/net/HttpURLConnection:getContentLength	()I
        //   34: istore_2
        //   35: aload 6
        //   37: sipush 5000
        //   40: invokevirtual 46	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   43: aload 6
        //   45: invokevirtual 49	java/net/HttpURLConnection:connect	()V
        //   48: aload 6
        //   50: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   53: astore 6
        //   55: aload 8
        //   57: astore 7
        //   59: aload 5
        //   61: astore 4
        //   63: aload 6
        //   65: astore 5
        //   67: new 55	java/io/File
        //   70: dup
        //   71: aload_0
        //   72: getfield 16	com/tencent/smtt/utils/DebugTbsPlugin$2:val$path	Ljava/lang/String;
        //   75: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
        //   78: invokestatic 62	com/tencent/smtt/utils/FileUtil:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
        //   81: astore 8
        //   83: aload 8
        //   85: astore 7
        //   87: aload 8
        //   89: astore 4
        //   91: aload 6
        //   93: astore 5
        //   95: sipush 8192
        //   98: newarray byte
        //   100: astore 9
        //   102: iconst_0
        //   103: istore_1
        //   104: aload 8
        //   106: astore 7
        //   108: aload 8
        //   110: astore 4
        //   112: aload 6
        //   114: astore 5
        //   116: aload 6
        //   118: aload 9
        //   120: invokevirtual 68	java/io/InputStream:read	([B)I
        //   123: istore_3
        //   124: iload_3
        //   125: ifle +117 -> 242
        //   128: iload_1
        //   129: iload_3
        //   130: iadd
        //   131: istore_1
        //   132: aload 8
        //   134: astore 7
        //   136: aload 8
        //   138: astore 4
        //   140: aload 6
        //   142: astore 5
        //   144: aload 8
        //   146: aload 9
        //   148: iconst_0
        //   149: iload_3
        //   150: invokevirtual 74	java/io/OutputStream:write	([BII)V
        //   153: aload 8
        //   155: astore 7
        //   157: aload 8
        //   159: astore 4
        //   161: aload 6
        //   163: astore 5
        //   165: iload_1
        //   166: bipush 100
        //   168: imul
        //   169: iload_2
        //   170: idiv
        //   171: istore_3
        //   172: aload 8
        //   174: astore 7
        //   176: aload 8
        //   178: astore 4
        //   180: aload 6
        //   182: astore 5
        //   184: aload_0
        //   185: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   188: iload_3
        //   189: invokeinterface 79 2 0
        //   194: goto -90 -> 104
        //   197: astore 8
        //   199: aload 7
        //   201: astore 4
        //   203: aload 6
        //   205: astore 5
        //   207: aload 8
        //   209: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   212: aload 7
        //   214: astore 4
        //   216: aload 6
        //   218: astore 5
        //   220: aload_0
        //   221: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   224: aload 8
        //   226: invokeinterface 86 2 0
        //   231: aload 6
        //   233: invokevirtual 89	java/io/InputStream:close	()V
        //   236: aload 7
        //   238: invokevirtual 90	java/io/OutputStream:close	()V
        //   241: return
        //   242: aload 8
        //   244: astore 7
        //   246: aload 8
        //   248: astore 4
        //   250: aload 6
        //   252: astore 5
        //   254: aload_0
        //   255: getfield 18	com/tencent/smtt/utils/DebugTbsPlugin$2:val$listener	Lcom/tencent/smtt/utils/DebugTbsPlugin$DebugDownloadStatusListener;
        //   258: invokeinterface 93 1 0
        //   263: aload 6
        //   265: invokevirtual 89	java/io/InputStream:close	()V
        //   268: aload 8
        //   270: invokevirtual 90	java/io/OutputStream:close	()V
        //   273: return
        //   274: astore 4
        //   276: aload 4
        //   278: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   281: return
        //   282: astore 6
        //   284: aconst_null
        //   285: astore 5
        //   287: aload 5
        //   289: invokevirtual 89	java/io/InputStream:close	()V
        //   292: aload 4
        //   294: invokevirtual 90	java/io/OutputStream:close	()V
        //   297: aload 6
        //   299: athrow
        //   300: astore 5
        //   302: aload 5
        //   304: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   307: goto -15 -> 292
        //   310: astore 4
        //   312: aload 4
        //   314: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   317: goto -20 -> 297
        //   320: astore 4
        //   322: aload 4
        //   324: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   327: goto -91 -> 236
        //   330: astore 4
        //   332: goto -56 -> 276
        //   335: astore 4
        //   337: aload 4
        //   339: invokevirtual 82	java/lang/Exception:printStackTrace	()V
        //   342: goto -74 -> 268
        //   345: astore 6
        //   347: goto -60 -> 287
        //   350: astore 8
        //   352: aconst_null
        //   353: astore 6
        //   355: goto -156 -> 199
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	358	0	this	2
        //   103	66	1	i	int
        //   34	137	2	j	int
        //   123	66	3	k	int
        //   4	245	4	localObject1	Object
        //   274	19	4	localException1	Exception
        //   310	3	4	localException2	Exception
        //   320	3	4	localException3	Exception
        //   330	1	4	localException4	Exception
        //   335	3	4	localException5	Exception
        //   7	281	5	localObject2	Object
        //   300	3	5	localException6	Exception
        //   27	237	6	localObject3	Object
        //   282	16	6	localObject4	Object
        //   345	1	6	localObject5	Object
        //   353	1	6	localObject6	Object
        //   1	244	7	localObject7	Object
        //   10	167	8	localFileOutputStream	java.io.FileOutputStream
        //   197	72	8	localException7	Exception
        //   350	1	8	localException8	Exception
        //   100	47	9	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   67	83	197	java/lang/Exception
        //   95	102	197	java/lang/Exception
        //   116	124	197	java/lang/Exception
        //   144	153	197	java/lang/Exception
        //   165	172	197	java/lang/Exception
        //   184	194	197	java/lang/Exception
        //   254	263	197	java/lang/Exception
        //   268	273	274	java/lang/Exception
        //   12	55	282	finally
        //   287	292	300	java/lang/Exception
        //   292	297	310	java/lang/Exception
        //   231	236	320	java/lang/Exception
        //   236	241	330	java/lang/Exception
        //   263	268	335	java/lang/Exception
        //   67	83	345	finally
        //   95	102	345	finally
        //   116	124	345	finally
        //   144	153	345	finally
        //   165	172	345	finally
        //   184	194	345	finally
        //   207	212	345	finally
        //   220	231	345	finally
        //   254	263	345	finally
        //   12	55	350	java/lang/Exception
      }
    }.start();
  }
  
  public static DebugTbsPlugin getInstance(Context paramContext)
  {
    if (mInstance == null) {
      mInstance = new DebugTbsPlugin(paramContext);
    }
    return mInstance;
  }
  
  public void downloadPlugin(final String paramString, final WebView paramWebView, final Context paramContext)
  {
    final RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    final TextView localTextView = new TextView(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    localTextView.setText("加载中，请稍后...");
    localRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramWebView.addView(localRelativeLayout, new FrameLayout.LayoutParams(-1, -1));
    localObject = this.mDebugPluginPath + File.separator + "DebugPlugin.tbs";
    FileUtil.delete(new File((String)localObject));
    downloadDebugTbsPlugin((String)localObject, new DebugDownloadStatusListener()
    {
      public void onDownloadFailure(Throwable paramAnonymousThrowable)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(DebugTbsPlugin.1.this.val$context, "下载失败，请检查网络", 0).show();
          }
        });
      }
      
      public void onDownloadProgress(final int paramAnonymousInt)
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            DebugTbsPlugin.1.this.val$tvDownloadProgress.setText("已下载" + paramAnonymousInt + "%");
          }
        });
      }
      
      public void onDownloadSuccess()
      {
        paramWebView.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(DebugTbsPlugin.1.this.val$context, "下载成功", 0).show();
            DebugTbsPlugin.1.this.val$layout.setVisibility(4);
            DebugTbsPlugin.this.showPluginView(DebugTbsPlugin.1.this.val$url, DebugTbsPlugin.1.this.val$webview, DebugTbsPlugin.1.this.val$context, DebugTbsPlugin.downloadThreadLooper);
          }
        });
      }
    });
  }
  
  @SuppressLint({"NewApi"})
  public void showPluginView(String paramString, WebView paramWebView, Context paramContext, Looper paramLooper)
  {
    TbsLog.i("debugtbs", "showPluginView -- url: " + paramString + "; webview: " + paramWebView + "; context: " + paramContext);
    Object localObject1 = this.mDebugPluginPath + File.separator + "DebugPlugin.tbs";
    Object localObject2 = this.mDebugPluginPath + File.separator + "DebugPlugin.apk";
    Object localObject3 = new File((String)localObject1);
    localObject1 = new File((String)localObject2);
    downloadThreadLooper = paramLooper;
    if (((File)localObject3).exists())
    {
      ((File)localObject1).delete();
      ((File)localObject3).renameTo((File)localObject1);
    }
    if (!((File)localObject1).exists())
    {
      TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
      downloadPlugin(paramString, paramWebView, paramContext);
      return;
    }
    try
    {
      localObject4 = AppUtil.getSignatureFromApk(paramContext, new File((String)localObject2));
      if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(localObject4))
      {
        TbsLog.e("debugtbs", "verifyPlugin apk: " + (String)localObject2 + " signature failed - sig: " + (String)localObject4);
        Toast.makeText(paramContext, "插件校验失败，请重试", 0).show();
        ((File)localObject3).delete();
        ((File)localObject1).delete();
        return;
      }
    }
    catch (Exception paramString)
    {
      FileUtil.delete((File)localObject1);
      paramString.printStackTrace();
      return;
    }
    localObject3 = this.mDebugPluginPath + File.separator + "opt";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    if (mDexLoader == null) {
      mDexLoader = new DexClassLoader((String)localObject2, (String)localObject3, null, paramContext.getClassLoader());
    }
    localObject2 = new HashMap();
    ((Map)localObject2).put("url", paramString);
    ((Map)localObject2).put("tbs_version", "" + WebView.getTbsSDKVersion(paramContext));
    ((Map)localObject2).put("tbs_core_version", "" + WebView.getTbsCoreVersion(paramContext));
    if (downloadThreadLooper != null) {
      ((Map)localObject2).put("looper", paramLooper);
    }
    paramString = mDexLoader.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[] { Context.class, Map.class }).newInstance(new Object[] { paramContext, localObject2 });
    if ((paramString instanceof FrameLayout))
    {
      paramString = (FrameLayout)paramString;
      paramWebView.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("debugtbs", "show " + paramString + " successful in " + paramWebView);
      return;
    }
    TbsLog.e("debugtbs", "get debugview failure: " + paramString);
  }
  
  public static abstract interface DebugDownloadStatusListener
  {
    public abstract void onDownloadFailure(Throwable paramThrowable);
    
    public abstract void onDownloadProgress(int paramInt);
    
    public abstract void onDownloadSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.DebugTbsPlugin
 * JD-Core Version:    0.7.0.1
 */