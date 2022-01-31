package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bgok;
import bhiw;
import bhks;
import bhkt;
import bhku;
import bhlm;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppLivePusher
  extends FrameLayout
{
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private bhlm jdField_a_of_type_Bhlm;
  private Object jdField_a_of_type_JavaLangObject;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniAppLivePusher.1(this);
  public String a;
  public WeakReference<Activity> a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public MiniAppLivePusher(@NonNull Context paramContext)
  {
    this(paramContext, null);
    a(paramContext);
  }
  
  public MiniAppLivePusher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private Bundle a(JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject == null) {
      return localBundle;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      QMLog.e("MiniAppLivePusher", "adaptJsonToBundle - pusherKeyList is null");
      return localBundle;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition"))) {
        try
        {
          localBundle.putString(str, paramJSONObject.getString(str));
        }
        catch (JSONException localJSONException1) {}
      } else if ((localJSONException1.equalsIgnoreCase("mode")) || (localJSONException1.equalsIgnoreCase("focusMode")) || (localJSONException1.equalsIgnoreCase("beauty")) || (localJSONException1.equalsIgnoreCase("whiteness")) || (localJSONException1.equalsIgnoreCase("aspect")) || (localJSONException1.equalsIgnoreCase("videoWidth")) || (localJSONException1.equalsIgnoreCase("videoHeight")) || (localJSONException1.equalsIgnoreCase("audioReverbType")) || (localJSONException1.equalsIgnoreCase("minBitrate")) || (localJSONException1.equalsIgnoreCase("maxBitrate"))) {
        try
        {
          localBundle.putInt(localJSONException1, paramJSONObject.getInt(localJSONException1));
        }
        catch (JSONException localJSONException2) {}
      } else if ((localJSONException2.equalsIgnoreCase("hide")) || (localJSONException2.equalsIgnoreCase("autopush")) || (localJSONException2.equalsIgnoreCase("muted")) || (localJSONException2.equalsIgnoreCase("enableCamera")) || (localJSONException2.equalsIgnoreCase("enableMic")) || (localJSONException2.equalsIgnoreCase("enableAGC")) || (localJSONException2.equalsIgnoreCase("enableANS")) || (localJSONException2.equalsIgnoreCase("backgroundMute")) || (localJSONException2.equalsIgnoreCase("zoom")) || (localJSONException2.equalsIgnoreCase("needEvent")) || (localJSONException2.equalsIgnoreCase("needBGMEvent")) || (localJSONException2.equalsIgnoreCase("debug")) || (localJSONException2.equalsIgnoreCase("mirror")) || (localJSONException2.equalsIgnoreCase("remoteMirror")) || (localJSONException2.equalsIgnoreCase("enableEarMonitor"))) {
        try
        {
          localBundle.putBoolean(localJSONException2, paramJSONObject.getBoolean(localJSONException2));
        }
        catch (JSONException localJSONException3) {}
      } else if ((localJSONException3.equalsIgnoreCase("watermarkLeft")) || (localJSONException3.equalsIgnoreCase("watermarkTop")) || (localJSONException3.equalsIgnoreCase("watermarkWidth"))) {
        try
        {
          localBundle.putDouble(localJSONException3, paramJSONObject.getDouble(localJSONException3));
        }
        catch (JSONException localJSONException4) {}
      }
    }
    return localBundle;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangObject = bhiw.a("com.tencent.rtmp.ui.TXCloudVideoView", bhiw.a(new Class[] { Context.class }), new Object[] { getContext() });
    if (this.jdField_a_of_type_JavaLangObject == null)
    {
      QMLog.e("MiniAppLivePusher", "tXCloudVideoView is null?! ");
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    View localView = (View)this.jdField_a_of_type_JavaLangObject;
    localView.setLayoutParams(localLayoutParams);
    localView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    new FrameLayout.LayoutParams(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F), DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F)).gravity = 17;
  }
  
  private void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    setTag("MiniAppLivePusher");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559348, null);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372514));
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add("pushUrl");
      this.jdField_a_of_type_JavaUtilArrayList.add("mode");
      this.jdField_a_of_type_JavaUtilArrayList.add("hide");
      this.jdField_a_of_type_JavaUtilArrayList.add("autopush");
      this.jdField_a_of_type_JavaUtilArrayList.add("muted");
      this.jdField_a_of_type_JavaUtilArrayList.add("enableCamera");
      this.jdField_a_of_type_JavaUtilArrayList.add("enableMic");
      this.jdField_a_of_type_JavaUtilArrayList.add("enableAGC");
      this.jdField_a_of_type_JavaUtilArrayList.add("enableANS");
      this.jdField_a_of_type_JavaUtilArrayList.add("audioVolumeType");
      this.jdField_a_of_type_JavaUtilArrayList.add("audioReverbType");
      this.jdField_a_of_type_JavaUtilArrayList.add("devicePosition");
      this.jdField_a_of_type_JavaUtilArrayList.add("focusMode");
      this.jdField_a_of_type_JavaUtilArrayList.add("orientation");
      this.jdField_a_of_type_JavaUtilArrayList.add("beauty");
      this.jdField_a_of_type_JavaUtilArrayList.add("whiteness");
      this.jdField_a_of_type_JavaUtilArrayList.add("aspect");
      this.jdField_a_of_type_JavaUtilArrayList.add("videoWidth");
      this.jdField_a_of_type_JavaUtilArrayList.add("videoHeight");
      this.jdField_a_of_type_JavaUtilArrayList.add("minBitrate");
      this.jdField_a_of_type_JavaUtilArrayList.add("maxBitrate");
      this.jdField_a_of_type_JavaUtilArrayList.add("audioQuality");
      this.jdField_a_of_type_JavaUtilArrayList.add("backgroundImage");
      this.jdField_a_of_type_JavaUtilArrayList.add("backgroundMute");
      this.jdField_a_of_type_JavaUtilArrayList.add("zoom");
      this.jdField_a_of_type_JavaUtilArrayList.add("needEvent");
      this.jdField_a_of_type_JavaUtilArrayList.add("needBGMEvent");
      this.jdField_a_of_type_JavaUtilArrayList.add("watermarkImage");
      this.jdField_a_of_type_JavaUtilArrayList.add("watermarkLeft");
      this.jdField_a_of_type_JavaUtilArrayList.add("watermarkTop");
      this.jdField_a_of_type_JavaUtilArrayList.add("watermarkWidth");
      this.jdField_a_of_type_JavaUtilArrayList.add("debug");
      this.jdField_a_of_type_JavaUtilArrayList.add("mirror");
      this.jdField_a_of_type_JavaUtilArrayList.add("remoteMirror");
      this.jdField_a_of_type_JavaUtilArrayList.add("localMirror");
      this.jdField_a_of_type_JavaUtilArrayList.add("enableEarMonitor");
    }
  }
  
  /* Error */
  private static void b(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
  {
    // Byte code:
    //   0: new 321	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 323	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 326	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 329	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 335	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 341	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 347	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 350	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 353	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 353	java/io/BufferedOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramBitmap	android.graphics.Bitmap
    //   0	68	1	paramFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
  }
  
  private void b(bgok parambgok, JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "initLivePusher params = " + paramJSONObject.toString());
    }
    b();
    this.jdField_a_of_type_Bhlm = new bhlm(getContext());
    this.jdField_a_of_type_Bhlm.a(this.jdField_a_of_type_JavaLangObject, a(paramJSONObject));
    this.jdField_a_of_type_Bhlm.a(new bhks(this, parambgok));
    this.jdField_a_of_type_Bhlm.a(new bhkt(this, parambgok));
  }
  
  public void a(bgok parambgok, JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "initLivePusherSettings json: " + paramJSONObject.toString());
    }
    a();
    b(parambgok, paramJSONObject);
  }
  
  /* Error */
  public void a(String paramString, bgok parambgok, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 80
    //   2: new 359	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 408
    //   12: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   29: ifnull +133 -> 162
    //   32: ldc_w 410
    //   35: aload_1
    //   36: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifeq +124 -> 163
    //   42: aload_3
    //   43: ifnull +94 -> 137
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 312	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_Boolean	Z
    //   51: aload_0
    //   52: getfield 63	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   55: invokevirtual 417	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   58: invokestatic 421	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   61: astore 9
    //   63: aload_3
    //   64: ldc_w 423
    //   67: invokevirtual 426	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 10
    //   72: aload_0
    //   73: getfield 70	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: aload 9
    //   78: aload 10
    //   80: invokevirtual 430	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: invokestatic 435	bgnt:a	()Lbgnt;
    //   87: aload 10
    //   89: invokevirtual 438	bgnt:g	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 11
    //   94: ldc_w 440
    //   97: invokestatic 446	com/tencent/qqmini/sdk/core/proxy/ProxyManager:get	(Ljava/lang/Class;)Ljava/lang/Object;
    //   100: checkcast 440	com/tencent/qqmini/sdk/core/proxy/DownloaderProxy
    //   103: astore 12
    //   105: aload 12
    //   107: aload 10
    //   109: aconst_null
    //   110: aload 11
    //   112: bipush 60
    //   114: new 448	bhkv
    //   117: dup
    //   118: aload_0
    //   119: aload 9
    //   121: aload 10
    //   123: aload_2
    //   124: aload 11
    //   126: aload_3
    //   127: aload_1
    //   128: aload 12
    //   130: invokespecial 451	bhkv:<init>	(Lcom/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher;Ljava/lang/String;Ljava/lang/String;Lbgok;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/qqmini/sdk/core/proxy/DownloaderProxy;)V
    //   133: invokevirtual 455	com/tencent/qqmini/sdk/core/proxy/DownloaderProxy:download	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILcom/tencent/qqmini/sdk/core/proxy/DownloaderProxy$DownloadListener;)Z
    //   136: pop
    //   137: ldc_w 457
    //   140: aconst_null
    //   141: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   144: astore_1
    //   145: aload_2
    //   146: getfield 467	bgok:a	Lbglu;
    //   149: aload_2
    //   150: getfield 469	bgok:b	I
    //   153: aload_1
    //   154: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   157: invokeinterface 474 3 0
    //   162: return
    //   163: ldc_w 476
    //   166: aload_1
    //   167: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +44 -> 214
    //   173: aload_0
    //   174: iconst_1
    //   175: putfield 312	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_Boolean	Z
    //   178: aload_0
    //   179: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   182: aload_1
    //   183: aload_3
    //   184: invokevirtual 479	bhlm:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lbhkw;
    //   187: pop
    //   188: ldc_w 457
    //   191: aconst_null
    //   192: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   195: astore_1
    //   196: aload_2
    //   197: getfield 467	bgok:a	Lbglu;
    //   200: aload_2
    //   201: getfield 469	bgok:b	I
    //   204: aload_1
    //   205: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   208: invokeinterface 474 3 0
    //   213: return
    //   214: ldc_w 481
    //   217: aload_1
    //   218: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifeq +87 -> 308
    //   224: aload_3
    //   225: ldc_w 483
    //   228: aload_3
    //   229: ldc_w 485
    //   232: invokevirtual 159	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   235: sipush 1000
    //   238: imul
    //   239: invokevirtual 488	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   242: pop
    //   243: aload_0
    //   244: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   247: aload_1
    //   248: aload_3
    //   249: invokevirtual 479	bhlm:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lbhkw;
    //   252: pop
    //   253: ldc_w 457
    //   256: aconst_null
    //   257: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   260: astore_1
    //   261: aload_2
    //   262: getfield 467	bgok:a	Lbglu;
    //   265: aload_2
    //   266: getfield 469	bgok:b	I
    //   269: aload_1
    //   270: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   273: invokeinterface 474 3 0
    //   278: return
    //   279: astore_1
    //   280: ldc 80
    //   282: new 359	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   289: ldc_w 490
    //   292: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_1
    //   296: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 88	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -52 -> 253
    //   308: ldc_w 495
    //   311: aload_1
    //   312: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +58 -> 373
    //   318: iconst_0
    //   319: istore 6
    //   321: iload 6
    //   323: istore 5
    //   325: aload_3
    //   326: ifnull +36 -> 362
    //   329: aload_3
    //   330: ldc_w 497
    //   333: invokevirtual 426	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   336: astore_1
    //   337: iload 6
    //   339: istore 5
    //   341: aload_1
    //   342: ifnull +20 -> 362
    //   345: iload 6
    //   347: istore 5
    //   349: aload_1
    //   350: ldc_w 499
    //   353: invokevirtual 112	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   356: ifeq +6 -> 362
    //   359: iconst_1
    //   360: istore 5
    //   362: aload_0
    //   363: ldc_w 457
    //   366: iload 5
    //   368: aload_2
    //   369: invokevirtual 502	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:a	(Ljava/lang/String;ZLbgok;)V
    //   372: return
    //   373: aload_1
    //   374: ldc_w 504
    //   377: invokevirtual 112	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   380: ifeq +364 -> 744
    //   383: invokestatic 435	bgnt:a	()Lbgnt;
    //   386: ldc_w 506
    //   389: invokevirtual 508	bgnt:b	(Ljava/lang/String;)Ljava/lang/String;
    //   392: astore_1
    //   393: aload_3
    //   394: ldc_w 510
    //   397: invokevirtual 514	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   400: lstore 7
    //   402: ldc 80
    //   404: new 359	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 516
    //   414: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_0
    //   428: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   431: aload_1
    //   432: invokevirtual 518	bhlm:a	(Ljava/lang/String;)I
    //   435: istore 4
    //   437: ldc 80
    //   439: new 359	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 520
    //   449: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: iload 4
    //   454: invokevirtual 523	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: iload 4
    //   465: ifne +137 -> 602
    //   468: new 128	org/json/JSONObject
    //   471: dup
    //   472: invokespecial 524	org/json/JSONObject:<init>	()V
    //   475: astore 9
    //   477: invokestatic 435	bgnt:a	()Lbgnt;
    //   480: aload_1
    //   481: invokevirtual 526	bgnt:e	(Ljava/lang/String;)Ljava/lang/String;
    //   484: astore_3
    //   485: aload_3
    //   486: astore_1
    //   487: ldc 80
    //   489: new 359	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 528
    //   499: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_1
    //   503: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload 9
    //   514: ldc_w 530
    //   517: aload_1
    //   518: invokevirtual 533	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   521: pop
    //   522: aload_0
    //   523: aload_1
    //   524: putfield 535	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   527: ldc_w 457
    //   530: aload 9
    //   532: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   535: astore_1
    //   536: aload_2
    //   537: getfield 467	bgok:a	Lbglu;
    //   540: aload_2
    //   541: getfield 469	bgok:b	I
    //   544: aload_1
    //   545: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   548: invokeinterface 474 3 0
    //   553: aload_0
    //   554: getfield 49	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   557: aload_0
    //   558: getfield 56	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   561: lload 7
    //   563: invokevirtual 539	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   566: pop
    //   567: ldc 80
    //   569: new 359	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 520
    //   579: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: iload 4
    //   584: invokevirtual 523	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: invokevirtual 371	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: return
    //   594: astore_3
    //   595: aload_3
    //   596: invokevirtual 542	org/json/JSONException:printStackTrace	()V
    //   599: goto -77 -> 522
    //   602: iload 4
    //   604: iconst_m1
    //   605: if_icmpne +32 -> 637
    //   608: ldc_w 457
    //   611: aconst_null
    //   612: ldc_w 544
    //   615: invokestatic 547	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   618: astore_1
    //   619: aload_2
    //   620: getfield 467	bgok:a	Lbglu;
    //   623: aload_2
    //   624: getfield 469	bgok:b	I
    //   627: aload_1
    //   628: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   631: invokeinterface 474 3 0
    //   636: return
    //   637: iload 4
    //   639: bipush 254
    //   641: if_icmpne +34 -> 675
    //   644: ldc_w 457
    //   647: aconst_null
    //   648: ldc_w 549
    //   651: invokestatic 547	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   654: astore_1
    //   655: aload_2
    //   656: getfield 467	bgok:a	Lbglu;
    //   659: aload_2
    //   660: getfield 469	bgok:b	I
    //   663: aload_1
    //   664: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   667: invokeinterface 474 3 0
    //   672: goto -105 -> 567
    //   675: iload 4
    //   677: bipush 253
    //   679: if_icmpne +34 -> 713
    //   682: ldc_w 457
    //   685: aconst_null
    //   686: ldc_w 551
    //   689: invokestatic 547	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   692: astore_1
    //   693: aload_2
    //   694: getfield 467	bgok:a	Lbglu;
    //   697: aload_2
    //   698: getfield 469	bgok:b	I
    //   701: aload_1
    //   702: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   705: invokeinterface 474 3 0
    //   710: goto -143 -> 567
    //   713: ldc_w 457
    //   716: aconst_null
    //   717: ldc_w 553
    //   720: invokestatic 547	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   723: astore_1
    //   724: aload_2
    //   725: getfield 467	bgok:a	Lbglu;
    //   728: aload_2
    //   729: getfield 469	bgok:b	I
    //   732: aload_1
    //   733: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   736: invokeinterface 474 3 0
    //   741: goto -174 -> 567
    //   744: aload_1
    //   745: ldc_w 555
    //   748: invokevirtual 112	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   751: ifeq +112 -> 863
    //   754: ldc 80
    //   756: ldc_w 557
    //   759: invokestatic 374	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: aload_0
    //   763: getfield 49	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   766: aload_0
    //   767: getfield 56	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   770: invokevirtual 561	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   773: aload_0
    //   774: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   777: invokevirtual 562	bhlm:b	()V
    //   780: new 128	org/json/JSONObject
    //   783: dup
    //   784: invokespecial 524	org/json/JSONObject:<init>	()V
    //   787: astore_1
    //   788: aload_0
    //   789: getfield 535	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   792: invokestatic 568	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   795: ifne +46 -> 841
    //   798: aload_1
    //   799: ldc_w 530
    //   802: aload_0
    //   803: getfield 535	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   806: invokevirtual 533	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   809: pop
    //   810: aload_0
    //   811: aconst_null
    //   812: putfield 535	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   815: ldc_w 457
    //   818: aload_1
    //   819: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   822: astore_1
    //   823: aload_2
    //   824: getfield 467	bgok:a	Lbglu;
    //   827: aload_2
    //   828: getfield 469	bgok:b	I
    //   831: aload_1
    //   832: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   835: invokeinterface 474 3 0
    //   840: return
    //   841: aload_1
    //   842: ldc_w 530
    //   845: ldc_w 570
    //   848: invokevirtual 533	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   851: pop
    //   852: goto -37 -> 815
    //   855: astore_3
    //   856: aload_3
    //   857: invokevirtual 542	org/json/JSONException:printStackTrace	()V
    //   860: goto -45 -> 815
    //   863: aload_0
    //   864: getfield 217	com/tencent/qqmini/sdk/runtime/widget/media/MiniAppLivePusher:jdField_a_of_type_Bhlm	Lbhlm;
    //   867: aload_1
    //   868: aload_3
    //   869: invokevirtual 479	bhlm:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lbhkw;
    //   872: pop
    //   873: ldc_w 457
    //   876: aconst_null
    //   877: invokestatic 462	bgop:a	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   880: astore_1
    //   881: aload_2
    //   882: getfield 467	bgok:a	Lbglu;
    //   885: aload_2
    //   886: getfield 469	bgok:b	I
    //   889: aload_1
    //   890: invokevirtual 370	org/json/JSONObject:toString	()Ljava/lang/String;
    //   893: invokeinterface 474 3 0
    //   898: return
    //   899: astore_3
    //   900: goto -305 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	this	MiniAppLivePusher
    //   0	903	1	paramString	String
    //   0	903	2	parambgok	bgok
    //   0	903	3	paramJSONObject	JSONObject
    //   435	245	4	i	int
    //   323	44	5	bool1	boolean
    //   319	27	6	bool2	boolean
    //   400	162	7	l	long
    //   61	470	9	localObject	Object
    //   70	52	10	str1	String
    //   92	33	11	str2	String
    //   103	26	12	localDownloaderProxy	com.tencent.qqmini.sdk.core.proxy.DownloaderProxy
    // Exception table:
    //   from	to	target	type
    //   224	253	279	org/json/JSONException
    //   477	485	594	org/json/JSONException
    //   788	815	855	org/json/JSONException
    //   841	852	855	org/json/JSONException
    //   487	522	899	org/json/JSONException
  }
  
  public void a(String paramString, boolean paramBoolean, bgok parambgok)
  {
    if (this.jdField_a_of_type_Bhlm == null) {
      return;
    }
    this.jdField_a_of_type_Bhlm.a(paramBoolean, new bhku(this, paramString, parambgok));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((QMLog.isColorLevel()) && (paramJSONObject != null)) {
      QMLog.d("MiniAppLivePusher", "updateLivePusherSetting params = " + paramJSONObject.toString());
    }
    if (this.jdField_a_of_type_Bhlm != null) {
      this.jdField_a_of_type_Bhlm.a(a(paramJSONObject));
    }
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePusher
 * JD-Core Version:    0.7.0.1
 */