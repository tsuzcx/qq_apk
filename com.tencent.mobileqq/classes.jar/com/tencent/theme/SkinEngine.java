package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinEngine
{
  public static final String ACTION_THEME_INVALIDATE = "com.tencent.qplus.THEME_INVALIDATE";
  public static final String ACTION_THEME_UPDATE = "com.tencent.qplus.THEME_UPDATE";
  public static final String ASSET_PATH = "/asset/";
  public static boolean DEBUG = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_THEME = "theme_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  static boolean a;
  static boolean b;
  static final String[][] e;
  static final int[][] f;
  static int g;
  static int h;
  static int i;
  static int j;
  static int k;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  private static SkinEngine n;
  private HashMap<String, Object> A;
  private HashMap<String, Object> B;
  private i C;
  private final Object D = new Object();
  public HashMap<Integer, BackupForOOMData> backupForOOMData;
  final TypedValue c = new TypedValue();
  TypedValue d = new TypedValue();
  SkinEngineHandler l;
  BroadcastReceiver m = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateReceiver.onReceive ACTION_THEME_UPDATE");
      }
      try
      {
        new SkinEngine.a(SkinEngine.this, null).execute(new Context[] { paramAnonymousContext });
        return;
      }
      catch (RejectedExecutionException paramAnonymousContext) {}
    }
  };
  public Resources mResources;
  private ReentrantReadWriteLock o = new ReentrantReadWriteLock();
  private boolean p = false;
  private boolean q = true;
  private final LongSparseArray<WeakReference<b>> r = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> s = new LongSparseArray();
  private final LongSparseArray<WeakReference<b>> t = new LongSparseArray();
  private String u;
  private String v;
  private int w = i;
  private g x;
  private d y;
  private e z;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23))
    {
      bool = true;
      a = bool;
      if (Build.VERSION.SDK_INT < 24) {
        break label419;
      }
    }
    label419:
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      IS_PROBLEM_MIUI = false;
      mIconsOfCM = null;
      mComposedIconInfoOfCM = null;
      IS_PROBLEM_CM11 = false;
      mIconResourceID = null;
      Object localObject = { "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
      String[] arrayOfString = { "drawable-ldpi/", "drawable-mdpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable/" };
      e = new String[][] { localObject, { "drawable-hdpi/", "drawable-xhdpi/", "drawable-mdpi/", "drawable/" }, { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/" }, arrayOfString, { "drawable-xxhdpi", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" } };
      localObject = new int[] { 160, 160, 240, 320 };
      f = new int[][] { { 320, 240, 160, 160 }, { 240, 320, 160, 160 }, localObject, { 120, 160, 240, 320, 160 }, { 480, 320, 240, 160, 160 } };
      g = 0;
      h = 1;
      i = 2;
      j = 3;
      k = 4;
      return;
      bool = false;
      break;
    }
  }
  
  private static int a(Resources paramResources)
  {
    switch (paramResources.getDisplayMetrics().densityDpi)
    {
    default: 
      return i;
    case 320: 
      return g;
    case 240: 
      return h;
    case 120: 
      return j;
    }
    return k;
  }
  
  private static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT > 11) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
    throws IOException
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(paramTypedValue.type) + " is not valid");
  }
  
  private TypedValue a()
  {
    synchronized (this.D)
    {
      if (this.d != null)
      {
        TypedValue localTypedValue = this.d;
        this.d = null;
      }
      if (this.d == null) {
        return new TypedValue();
      }
    }
    return this.d;
  }
  
  /* Error */
  private b a(int paramInt, Resources paramResources, l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 187	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 311	android/graphics/Rect
    //   12: dup
    //   13: invokespecial 312	android/graphics/Rect:<init>	()V
    //   16: astore 13
    //   18: aload_3
    //   19: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   22: astore 14
    //   24: aload 14
    //   26: ifnull +497 -> 523
    //   29: aload 14
    //   31: ldc_w 318
    //   34: invokevirtual 322	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: istore 6
    //   39: iload 6
    //   41: ifne +482 -> 523
    //   44: aload_0
    //   45: aload_2
    //   46: aload 14
    //   48: invokespecial 325	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 9
    //   53: new 327	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 328	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 15
    //   62: aload 15
    //   64: aload_3
    //   65: getfield 330	com/tencent/theme/l:c	I
    //   68: putfield 333	android/graphics/BitmapFactory$Options:inDensity	I
    //   71: aload_2
    //   72: aconst_null
    //   73: aload 9
    //   75: aload_3
    //   76: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   79: aload 15
    //   81: aload 13
    //   83: aload_0
    //   84: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   87: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   90: astore 7
    //   92: aload 9
    //   94: invokevirtual 345	java/io/InputStream:close	()V
    //   97: aload 7
    //   99: ifnull +424 -> 523
    //   102: aload 12
    //   104: monitorexit
    //   105: aload 7
    //   107: areturn
    //   108: astore 8
    //   110: ldc 46
    //   112: iconst_1
    //   113: new 281	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 347
    //   123: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 14
    //   128: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aload 8
    //   136: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: aload_0
    //   140: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   143: ifnull +1216 -> 1359
    //   146: aload_0
    //   147: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   150: aload 8
    //   152: aload_3
    //   153: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   156: iconst_1
    //   157: invokeinterface 360 4 0
    //   162: ifeq +1197 -> 1359
    //   165: aload 9
    //   167: invokevirtual 345	java/io/InputStream:close	()V
    //   170: aload_0
    //   171: aload_2
    //   172: aload 14
    //   174: invokespecial 325	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   177: astore 9
    //   179: aload_2
    //   180: aconst_null
    //   181: aload 9
    //   183: aload_3
    //   184: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   187: aload 15
    //   189: aload 13
    //   191: aload_0
    //   192: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   195: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   198: astore 7
    //   200: goto -108 -> 92
    //   203: astore 7
    //   205: ldc 46
    //   207: iconst_1
    //   208: new 281	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 362
    //   218: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload 14
    //   223: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: aload 8
    //   231: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_0
    //   235: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   238: aload 7
    //   240: aload_3
    //   241: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   244: iconst_1
    //   245: invokeinterface 365 4 0
    //   250: ifeq +200 -> 450
    //   253: aload 15
    //   255: iconst_1
    //   256: putfield 368	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   259: aload 9
    //   261: invokevirtual 345	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: aload_2
    //   266: aload 14
    //   268: invokespecial 325	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   271: astore 10
    //   273: aload_2
    //   274: aconst_null
    //   275: aload 10
    //   277: aload_3
    //   278: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   281: aload 15
    //   283: aload 13
    //   285: aload_0
    //   286: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   289: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   292: astore 11
    //   294: aload_0
    //   295: getfield 370	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   298: ifnull +1091 -> 1389
    //   301: aload_0
    //   302: getfield 370	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   305: iload_1
    //   306: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   312: ifeq +1077 -> 1389
    //   315: aload_0
    //   316: getfield 370	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   319: iload_1
    //   320: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 383	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   326: ifnull +1063 -> 1389
    //   329: iconst_1
    //   330: istore 4
    //   332: iload 4
    //   334: ifeq +1044 -> 1378
    //   337: aconst_null
    //   338: astore 7
    //   340: aload_0
    //   341: getfield 370	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   344: iload_1
    //   345: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: invokevirtual 383	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   351: checkcast 8	com/tencent/theme/SkinEngine$BackupForOOMData
    //   354: astore 9
    //   356: aload 15
    //   358: getfield 386	android/graphics/BitmapFactory$Options:outWidth	I
    //   361: bipush 8
    //   363: idiv
    //   364: aload 15
    //   366: getfield 389	android/graphics/BitmapFactory$Options:outHeight	I
    //   369: bipush 8
    //   371: idiv
    //   372: invokestatic 395	java/lang/Math:min	(II)I
    //   375: bipush 8
    //   377: invokestatic 398	java/lang/Math:max	(II)I
    //   380: istore 5
    //   382: iconst_2
    //   383: istore 4
    //   385: iload 4
    //   387: iload 5
    //   389: if_icmpgt +29 -> 418
    //   392: aload_0
    //   393: aload_2
    //   394: aload_3
    //   395: aload 15
    //   397: aload 13
    //   399: aload_0
    //   400: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   403: aload 9
    //   405: iload 4
    //   407: iconst_0
    //   408: invokevirtual 401	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/l;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   411: astore 7
    //   413: aload 7
    //   415: ifnull +980 -> 1395
    //   418: aload 7
    //   420: astore 8
    //   422: aload 7
    //   424: ifnonnull +941 -> 1365
    //   427: aload_0
    //   428: aload_2
    //   429: aload_3
    //   430: aload 15
    //   432: aload 13
    //   434: aload_0
    //   435: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   438: aload 9
    //   440: iconst_1
    //   441: iconst_1
    //   442: invokevirtual 401	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/l;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/b;
    //   445: astore 8
    //   447: goto +918 -> 1365
    //   450: aload 7
    //   452: athrow
    //   453: astore 7
    //   455: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   458: ifeq +36 -> 494
    //   461: ldc 46
    //   463: new 281	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 403
    //   473: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 14
    //   478: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: ldc_w 405
    //   484: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 410	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   493: pop
    //   494: ldc 46
    //   496: iconst_1
    //   497: new 281	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   504: ldc_w 412
    //   507: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload 14
    //   512: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: aload 7
    //   520: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: aload_3
    //   524: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   527: ldc_w 318
    //   530: invokevirtual 322	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   533: istore 6
    //   535: iload 6
    //   537: ifeq +218 -> 755
    //   540: aload_0
    //   541: iload_1
    //   542: aload_0
    //   543: getfield 187	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   546: invokespecial 414	com/tencent/theme/SkinEngine:a	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   549: astore 8
    //   551: aload 14
    //   553: ifnull +86 -> 639
    //   556: aload_0
    //   557: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   560: ifeq +71 -> 631
    //   563: new 416	com/tencent/theme/a
    //   566: dup
    //   567: invokespecial 417	com/tencent/theme/a:<init>	()V
    //   570: astore 7
    //   572: new 419	java/io/FileInputStream
    //   575: dup
    //   576: aload 14
    //   578: invokespecial 420	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   581: astore 9
    //   583: aload 7
    //   585: aload 9
    //   587: ldc_w 422
    //   590: invokeinterface 428 3 0
    //   595: aload_2
    //   596: aload 8
    //   598: aload 7
    //   600: aload_0
    //   601: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   604: invokestatic 431	com/tencent/theme/j:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   607: astore_2
    //   608: aload 9
    //   610: invokevirtual 432	java/io/FileInputStream:close	()V
    //   613: aload 8
    //   615: invokeinterface 435 1 0
    //   620: aload 12
    //   622: monitorexit
    //   623: aload_2
    //   624: areturn
    //   625: astore_2
    //   626: aload 12
    //   628: monitorexit
    //   629: aload_2
    //   630: athrow
    //   631: invokestatic 441	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   634: astore 7
    //   636: goto -64 -> 572
    //   639: aload_2
    //   640: aload 8
    //   642: aconst_null
    //   643: aload_0
    //   644: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   647: invokestatic 431	com/tencent/theme/j:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/b;
    //   650: astore_2
    //   651: aload 8
    //   653: invokeinterface 435 1 0
    //   658: aload 12
    //   660: monitorexit
    //   661: aload_2
    //   662: areturn
    //   663: astore_2
    //   664: ldc 46
    //   666: iconst_1
    //   667: new 281	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   674: ldc_w 443
    //   677: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 14
    //   682: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: aload_2
    //   689: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   692: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   695: ifeq +55 -> 750
    //   698: new 279	android/content/res/Resources$NotFoundException
    //   701: dup
    //   702: new 281	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   709: ldc_w 445
    //   712: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_3
    //   716: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   719: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: ldc_w 447
    //   725: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: iload_1
    //   729: invokestatic 294	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   732: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokespecial 302	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   741: astore_3
    //   742: aload_3
    //   743: aload_2
    //   744: invokevirtual 451	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   747: pop
    //   748: aload_3
    //   749: athrow
    //   750: aload 12
    //   752: monitorexit
    //   753: aconst_null
    //   754: areturn
    //   755: getstatic 143	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   758: istore 6
    //   760: iload 6
    //   762: ifeq +100 -> 862
    //   765: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   768: iconst_1
    //   769: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   772: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   775: aload_0
    //   776: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   779: aconst_null
    //   780: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   783: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   786: iconst_1
    //   787: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   790: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   793: aload_0
    //   794: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   797: aconst_null
    //   798: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   801: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   804: iconst_1
    //   805: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   808: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   811: iconst_1
    //   812: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   815: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   818: aload_0
    //   819: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   822: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   825: ifnull +37 -> 862
    //   828: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   831: aload_0
    //   832: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   835: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   838: astore 7
    //   840: aload 7
    //   842: ifnull +20 -> 862
    //   845: aload 12
    //   847: monitorexit
    //   848: aconst_null
    //   849: areturn
    //   850: astore_2
    //   851: aload 12
    //   853: monitorexit
    //   854: aconst_null
    //   855: areturn
    //   856: astore_2
    //   857: aload 12
    //   859: monitorexit
    //   860: aconst_null
    //   861: areturn
    //   862: aload_0
    //   863: getfield 187	com/tencent/theme/SkinEngine:c	Landroid/util/TypedValue;
    //   866: astore 10
    //   868: aload_2
    //   869: iload_1
    //   870: aload 10
    //   872: invokevirtual 466	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   875: astore 8
    //   877: aload 10
    //   879: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   882: invokeinterface 271 1 0
    //   887: astore 11
    //   889: aload 8
    //   891: astore 7
    //   893: new 327	android/graphics/BitmapFactory$Options
    //   896: dup
    //   897: invokespecial 328	android/graphics/BitmapFactory$Options:<init>	()V
    //   900: astore 14
    //   902: aload 8
    //   904: astore 7
    //   906: aload_2
    //   907: aload 10
    //   909: aload 8
    //   911: aload 11
    //   913: aload 14
    //   915: aload 13
    //   917: iconst_1
    //   918: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   921: astore 9
    //   923: aload 9
    //   925: astore_2
    //   926: aload 8
    //   928: astore 7
    //   930: aload 8
    //   932: invokevirtual 345	java/io/InputStream:close	()V
    //   935: aload_2
    //   936: ifnonnull +33 -> 969
    //   939: aload 8
    //   941: astore 7
    //   943: aload_0
    //   944: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   947: ifnull +22 -> 969
    //   950: aload 8
    //   952: astore 7
    //   954: aload_0
    //   955: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   958: aload_3
    //   959: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   962: iconst_0
    //   963: invokeinterface 470 3 0
    //   968: pop
    //   969: aload 12
    //   971: monitorexit
    //   972: aload_2
    //   973: areturn
    //   974: astore_2
    //   975: ldc 46
    //   977: iconst_1
    //   978: new 281	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   985: ldc_w 472
    //   988: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_3
    //   992: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   995: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: aload_2
    //   1002: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1005: aload 12
    //   1007: monitorexit
    //   1008: aconst_null
    //   1009: areturn
    //   1010: astore 15
    //   1012: aload 8
    //   1014: astore 7
    //   1016: ldc 46
    //   1018: iconst_1
    //   1019: new 281	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 474
    //   1029: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: aload_3
    //   1033: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1036: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1042: aload 15
    //   1044: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1047: aload 8
    //   1049: astore 7
    //   1051: aload_0
    //   1052: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   1055: ifnull +299 -> 1354
    //   1058: aload 8
    //   1060: astore 7
    //   1062: aload_0
    //   1063: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   1066: aload 15
    //   1068: aload_3
    //   1069: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1072: iconst_0
    //   1073: invokeinterface 360 4 0
    //   1078: ifeq +276 -> 1354
    //   1081: aload 8
    //   1083: astore 7
    //   1085: aload 8
    //   1087: invokevirtual 345	java/io/InputStream:close	()V
    //   1090: aload 8
    //   1092: astore 7
    //   1094: aload_2
    //   1095: iload_1
    //   1096: aload 10
    //   1098: invokevirtual 466	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1101: astore 8
    //   1103: aload 8
    //   1105: astore 7
    //   1107: aload_2
    //   1108: aload 10
    //   1110: aload 8
    //   1112: aload 11
    //   1114: aload 14
    //   1116: aload 13
    //   1118: iconst_1
    //   1119: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   1122: astore 9
    //   1124: aload 9
    //   1126: astore_2
    //   1127: goto -201 -> 926
    //   1130: astore 9
    //   1132: aload 8
    //   1134: astore 7
    //   1136: ldc 46
    //   1138: iconst_1
    //   1139: new 281	java/lang/StringBuilder
    //   1142: dup
    //   1143: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   1146: ldc_w 474
    //   1149: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_3
    //   1153: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1156: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: aload 15
    //   1164: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1167: aload 8
    //   1169: astore 7
    //   1171: aload_0
    //   1172: getfield 354	com/tencent/theme/SkinEngine:l	Lcom/tencent/theme/SkinEngineHandler;
    //   1175: aload 9
    //   1177: aload_3
    //   1178: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1181: iconst_0
    //   1182: invokeinterface 365 4 0
    //   1187: ifeq +49 -> 1236
    //   1190: aload 8
    //   1192: astore 7
    //   1194: aload 14
    //   1196: iconst_1
    //   1197: putfield 368	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1200: aload 8
    //   1202: astore 7
    //   1204: aload_2
    //   1205: iload_1
    //   1206: aload 10
    //   1208: invokevirtual 466	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1211: astore 8
    //   1213: aload 8
    //   1215: astore 7
    //   1217: aload_2
    //   1218: aload 10
    //   1220: aload 8
    //   1222: aload 11
    //   1224: aload 14
    //   1226: aload 13
    //   1228: iconst_1
    //   1229: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   1232: astore_2
    //   1233: goto -307 -> 926
    //   1236: aload 8
    //   1238: astore 7
    //   1240: aload 9
    //   1242: athrow
    //   1243: astore_2
    //   1244: ldc 46
    //   1246: iconst_1
    //   1247: new 281	java/lang/StringBuilder
    //   1250: dup
    //   1251: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   1254: ldc_w 476
    //   1257: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1260: aload_3
    //   1261: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1264: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: aload_2
    //   1271: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1274: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1277: ifeq +72 -> 1349
    //   1280: new 279	android/content/res/Resources$NotFoundException
    //   1283: dup
    //   1284: new 281	java/lang/StringBuilder
    //   1287: dup
    //   1288: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   1291: ldc_w 445
    //   1294: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: aload_3
    //   1298: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   1301: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: ldc_w 447
    //   1307: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: iload_1
    //   1311: invokestatic 294	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1314: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1317: ldc_w 478
    //   1320: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 7
    //   1325: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1328: invokevirtual 487	java/lang/Class:getName	()Ljava/lang/String;
    //   1331: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: invokespecial 302	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1340: astore_3
    //   1341: aload_3
    //   1342: aload_2
    //   1343: invokevirtual 451	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1346: pop
    //   1347: aload_3
    //   1348: athrow
    //   1349: aload 12
    //   1351: monitorexit
    //   1352: aconst_null
    //   1353: areturn
    //   1354: aconst_null
    //   1355: astore_2
    //   1356: goto -430 -> 926
    //   1359: aconst_null
    //   1360: astore 7
    //   1362: goto -1270 -> 92
    //   1365: aload 8
    //   1367: astore 7
    //   1369: aload 10
    //   1371: astore 9
    //   1373: aload 8
    //   1375: ifnonnull -1283 -> 92
    //   1378: aload 11
    //   1380: astore 7
    //   1382: aload 10
    //   1384: astore 9
    //   1386: goto -1294 -> 92
    //   1389: iconst_0
    //   1390: istore 4
    //   1392: goto -1060 -> 332
    //   1395: iload 4
    //   1397: iconst_2
    //   1398: imul
    //   1399: istore 4
    //   1401: goto -1016 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1404	0	this	SkinEngine
    //   0	1404	1	paramInt	int
    //   0	1404	2	paramResources	Resources
    //   0	1404	3	paraml	l
    //   330	1070	4	i1	int
    //   380	10	5	i2	int
    //   37	724	6	bool	boolean
    //   90	109	7	localb1	b
    //   203	36	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   338	113	7	localb2	b
    //   453	66	7	localIOException	IOException
    //   570	811	7	localObject1	Object
    //   108	122	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   420	954	8	localObject2	Object
    //   51	1074	9	localObject3	Object
    //   1130	111	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1371	14	9	localObject4	Object
    //   271	1112	10	localObject5	Object
    //   292	1087	11	localObject6	Object
    //   4	1346	12	localTypedValue	TypedValue
    //   16	1211	13	localRect	Rect
    //   22	1203	14	localObject7	Object
    //   60	371	15	localOptions	android.graphics.BitmapFactory.Options
    //   1010	153	15	localOutOfMemoryError4	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   71	92	108	java/lang/OutOfMemoryError
    //   179	200	203	java/lang/OutOfMemoryError
    //   44	71	453	java/io/IOException
    //   71	92	453	java/io/IOException
    //   92	97	453	java/io/IOException
    //   110	179	453	java/io/IOException
    //   179	200	453	java/io/IOException
    //   205	329	453	java/io/IOException
    //   340	382	453	java/io/IOException
    //   392	413	453	java/io/IOException
    //   427	447	453	java/io/IOException
    //   450	453	453	java/io/IOException
    //   9	24	625	finally
    //   29	39	625	finally
    //   44	71	625	finally
    //   71	92	625	finally
    //   92	97	625	finally
    //   102	105	625	finally
    //   110	179	625	finally
    //   179	200	625	finally
    //   205	329	625	finally
    //   340	382	625	finally
    //   392	413	625	finally
    //   427	447	625	finally
    //   450	453	625	finally
    //   455	494	625	finally
    //   494	523	625	finally
    //   523	535	625	finally
    //   540	551	625	finally
    //   556	572	625	finally
    //   572	620	625	finally
    //   620	623	625	finally
    //   626	629	625	finally
    //   631	636	625	finally
    //   639	658	625	finally
    //   658	661	625	finally
    //   664	750	625	finally
    //   750	753	625	finally
    //   755	760	625	finally
    //   765	801	625	finally
    //   801	840	625	finally
    //   845	848	625	finally
    //   851	854	625	finally
    //   857	860	625	finally
    //   862	868	625	finally
    //   868	877	625	finally
    //   877	889	625	finally
    //   893	902	625	finally
    //   906	923	625	finally
    //   930	935	625	finally
    //   943	950	625	finally
    //   954	969	625	finally
    //   969	972	625	finally
    //   975	1008	625	finally
    //   1016	1047	625	finally
    //   1051	1058	625	finally
    //   1062	1081	625	finally
    //   1085	1090	625	finally
    //   1094	1103	625	finally
    //   1107	1124	625	finally
    //   1136	1167	625	finally
    //   1171	1190	625	finally
    //   1194	1200	625	finally
    //   1204	1213	625	finally
    //   1217	1233	625	finally
    //   1240	1243	625	finally
    //   1244	1349	625	finally
    //   1349	1352	625	finally
    //   540	551	663	java/lang/Exception
    //   556	572	663	java/lang/Exception
    //   572	620	663	java/lang/Exception
    //   631	636	663	java/lang/Exception
    //   639	658	663	java/lang/Exception
    //   765	801	850	java/lang/Exception
    //   801	840	856	java/lang/Exception
    //   868	877	974	java/lang/Exception
    //   906	923	1010	java/lang/OutOfMemoryError
    //   1107	1124	1130	java/lang/OutOfMemoryError
    //   893	902	1243	java/io/IOException
    //   906	923	1243	java/io/IOException
    //   930	935	1243	java/io/IOException
    //   943	950	1243	java/io/IOException
    //   954	969	1243	java/io/IOException
    //   1016	1047	1243	java/io/IOException
    //   1051	1058	1243	java/io/IOException
    //   1062	1081	1243	java/io/IOException
    //   1085	1090	1243	java/io/IOException
    //   1094	1103	1243	java/io/IOException
    //   1107	1124	1243	java/io/IOException
    //   1136	1167	1243	java/io/IOException
    //   1171	1190	1243	java/io/IOException
    //   1194	1200	1243	java/io/IOException
    //   1204	1213	1243	java/io/IOException
    //   1217	1233	1243	java/io/IOException
    //   1240	1243	1243	java/io/IOException
  }
  
  private String a(Resources paramResources, String paramString)
  {
    paramString = this.u + "color/" + paramString;
    try
    {
      if (paramString.startsWith("/asset/"))
      {
        paramResources.getAssets().open(paramString.substring("/asset/".length())).close();
        return paramString;
      }
      boolean bool = new File(paramString).exists();
      if (bool) {
        return paramString;
      }
    }
    catch (IOException paramResources)
    {
      for (;;)
      {
        if (DEBUG) {
          Log.w("SkinEngine", paramResources);
        }
      }
    }
    return null;
    return paramString;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    String str1 = paramXmlPullParser.getName();
    HashMap localHashMap = new HashMap();
    if (str1.equals("resources"))
    {
      i1 = paramXmlPullParser.getDepth();
      for (;;)
      {
        int i2 = paramXmlPullParser.next();
        if ((i2 == 1) || ((paramXmlPullParser.getDepth() < i1 + 1) && (i2 == 3))) {
          break;
        }
        if (i2 == 2)
        {
          String str2 = paramXmlPullParser.getName();
          str1 = paramXmlPullParser.getAttributeValue(null, "name");
          if ("color".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Color.parseColor(paramXmlPullParser.nextText())));
          }
          else if ("dimen".equals(str2))
          {
            str2 = paramXmlPullParser.nextText();
            if (str2.endsWith("dp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("dip")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(1, Integer.parseInt(str2.substring(0, str2.length() - 3)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("sp")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(2, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            } else if (str2.endsWith("px")) {
              localHashMap.put(str1, Float.valueOf(TypedValue.applyDimension(0, Integer.parseInt(str2.substring(0, str2.length() - 2)), this.mResources.getDisplayMetrics())));
            }
          }
          else if ("bool".equals(str2))
          {
            localHashMap.put(str1, Boolean.valueOf("true".equalsIgnoreCase(paramXmlPullParser.nextText())));
          }
          else if ("integer".equals(str2))
          {
            localHashMap.put(str1, Integer.valueOf(Integer.parseInt(paramXmlPullParser.nextText())));
          }
        }
      }
    }
    return localHashMap;
  }
  
  /* Error */
  private void a(Resources paramResources, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, File paramFile)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_3
    //   4: ifnonnull +20 -> 24
    //   7: aload 10
    //   9: astore 9
    //   11: iload_2
    //   12: ifeq +168 -> 180
    //   15: aload 10
    //   17: astore 9
    //   19: iload 4
    //   21: ifeq +159 -> 180
    //   24: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   27: ifeq +522 -> 549
    //   30: ldc 220
    //   32: ldc_w 609
    //   35: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore 9
    //   40: aload 9
    //   42: iconst_1
    //   43: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   46: aload 9
    //   48: aload_1
    //   49: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: astore 10
    //   54: aload 10
    //   56: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   59: ldc_w 615
    //   62: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   65: astore 9
    //   67: aload 9
    //   69: iconst_1
    //   70: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   73: aload 9
    //   75: aload 10
    //   77: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore 12
    //   82: aload 9
    //   84: astore 11
    //   86: aload 10
    //   88: astore 9
    //   90: aload 12
    //   92: astore 10
    //   94: aload 10
    //   96: instanceof 209
    //   99: ifeq +560 -> 659
    //   102: aload_3
    //   103: ifnull +476 -> 579
    //   106: aload_0
    //   107: aload_0
    //   108: aload_1
    //   109: invokestatic 620	com/tencent/theme/g:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/i;
    //   112: putfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   115: aload_0
    //   116: getfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   119: invokevirtual 626	com/tencent/theme/i:b	()V
    //   122: aload_0
    //   123: new 617	com/tencent/theme/g
    //   126: dup
    //   127: aload_0
    //   128: aload_1
    //   129: aload_3
    //   130: aload 7
    //   132: iconst_1
    //   133: anewarray 209	android/util/LongSparseArray
    //   136: dup
    //   137: iconst_0
    //   138: aload 10
    //   140: checkcast 209	android/util/LongSparseArray
    //   143: aastore
    //   144: invokespecial 629	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   147: putfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   150: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   153: ifeq +485 -> 638
    //   156: aload 9
    //   158: ifnull +480 -> 638
    //   161: aload 11
    //   163: aload 9
    //   165: new 633	com/tencent/theme/h
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   174: invokespecial 636	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   177: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   183: bipush 23
    //   185: if_icmplt +76 -> 261
    //   188: ldc_w 638
    //   191: getstatic 643	android/os/Build:BRAND	Ljava/lang/String;
    //   194: invokevirtual 587	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   197: istore 8
    //   199: iload 8
    //   201: ifeq +60 -> 261
    //   204: ldc 220
    //   206: ldc_w 645
    //   209: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   212: astore_3
    //   213: aload_3
    //   214: ifnull +637 -> 851
    //   217: aload_3
    //   218: iconst_1
    //   219: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   222: aload_3
    //   223: aload_0
    //   224: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   227: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +565 -> 797
    //   235: aload_3
    //   236: instanceof 647
    //   239: ifeq +558 -> 797
    //   242: aload_3
    //   243: checkcast 647	java/util/Map
    //   246: invokeinterface 650 1 0
    //   251: ldc 46
    //   253: iconst_2
    //   254: ldc_w 652
    //   257: aconst_null
    //   258: invokestatic 654	com/tencent/theme/k:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: ldc 46
    //   263: iconst_2
    //   264: ldc_w 656
    //   267: aconst_null
    //   268: invokestatic 654	com/tencent/theme/k:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: iload 5
    //   273: ifeq +115 -> 388
    //   276: iload 6
    //   278: ifeq +110 -> 388
    //   281: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   284: ifeq +599 -> 883
    //   287: ldc 220
    //   289: ldc_w 609
    //   292: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   295: astore_3
    //   296: aload_3
    //   297: iconst_1
    //   298: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   301: aload_3
    //   302: aload_1
    //   303: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: astore 7
    //   308: aload 7
    //   310: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   313: ldc_w 658
    //   316: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   319: astore_3
    //   320: aload_3
    //   321: iconst_1
    //   322: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   325: aload_3
    //   326: aload 7
    //   328: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   331: checkcast 209	android/util/LongSparseArray
    //   334: astore 10
    //   336: aload_3
    //   337: astore 9
    //   339: aload 10
    //   341: astore_3
    //   342: getstatic 133	com/tencent/theme/SkinEngine:a	Z
    //   345: ifeq +575 -> 920
    //   348: aload_0
    //   349: new 660	com/tencent/theme/f
    //   352: dup
    //   353: aload_0
    //   354: aload_1
    //   355: aload_3
    //   356: iload 5
    //   358: iload 6
    //   360: invokespecial 663	com/tencent/theme/f:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   363: putfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   366: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   369: ifeq +640 -> 1009
    //   372: aload 7
    //   374: ifnull +635 -> 1009
    //   377: aload 9
    //   379: aload 7
    //   381: aload_0
    //   382: getfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   385: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   388: ldc 46
    //   390: iconst_2
    //   391: ldc_w 667
    //   394: aconst_null
    //   395: invokestatic 654	com/tencent/theme/k:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   398: aload_1
    //   399: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   402: astore_3
    //   403: aload_3
    //   404: invokevirtual 487	java/lang/Class:getName	()Ljava/lang/String;
    //   407: ldc_w 669
    //   410: invokevirtual 128	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   413: ifeq +40 -> 453
    //   416: aload_3
    //   417: ldc_w 671
    //   420: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   423: astore_3
    //   424: aload_3
    //   425: iconst_1
    //   426: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   429: aload_3
    //   430: aload_1
    //   431: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   434: ifnonnull +19 -> 453
    //   437: aload_3
    //   438: aload_1
    //   439: new 673	android/util/SparseArray
    //   442: dup
    //   443: invokespecial 674	android/util/SparseArray:<init>	()V
    //   446: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   449: iconst_1
    //   450: putstatic 137	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   453: aload_1
    //   454: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   457: ldc_w 676
    //   460: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   463: putstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   466: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   469: iconst_1
    //   470: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   473: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   476: aload_1
    //   477: aconst_null
    //   478: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   481: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   484: iconst_0
    //   485: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   488: aload_1
    //   489: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   492: ldc_w 678
    //   495: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   498: putstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   501: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   504: iconst_1
    //   505: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   508: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   511: aload_1
    //   512: aconst_null
    //   513: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   516: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   519: iconst_0
    //   520: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   523: iconst_1
    //   524: putstatic 143	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   527: return
    //   528: astore 9
    //   530: aload 10
    //   532: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   535: invokevirtual 681	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   538: ldc_w 615
    //   541: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   544: astore 9
    //   546: goto -479 -> 67
    //   549: ldc 220
    //   551: ldc_w 615
    //   554: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   557: astore 11
    //   559: aload 11
    //   561: iconst_1
    //   562: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   565: aload 11
    //   567: aload_1
    //   568: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   571: astore 10
    //   573: aconst_null
    //   574: astore 9
    //   576: goto -482 -> 94
    //   579: aload_0
    //   580: aload_0
    //   581: aload_1
    //   582: invokestatic 620	com/tencent/theme/g:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/i;
    //   585: putfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   588: aload_0
    //   589: getfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   592: invokevirtual 626	com/tencent/theme/i:b	()V
    //   595: aload_0
    //   596: new 617	com/tencent/theme/g
    //   599: dup
    //   600: aload_0
    //   601: aload_1
    //   602: iload_2
    //   603: iload 4
    //   605: aload 7
    //   607: iconst_1
    //   608: anewarray 209	android/util/LongSparseArray
    //   611: dup
    //   612: iconst_0
    //   613: aload 10
    //   615: checkcast 209	android/util/LongSparseArray
    //   618: aastore
    //   619: invokespecial 684	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;IILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   622: putfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   625: goto -475 -> 150
    //   628: astore_1
    //   629: new 599	com/tencent/theme/UnSupportPlatformException
    //   632: dup
    //   633: aload_1
    //   634: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   637: athrow
    //   638: aload 11
    //   640: aload_1
    //   641: new 633	com/tencent/theme/h
    //   644: dup
    //   645: iconst_0
    //   646: aload_0
    //   647: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   650: invokespecial 636	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   653: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   656: goto -476 -> 180
    //   659: aload 10
    //   661: instanceof 689
    //   664: ifeq +444 -> 1108
    //   667: aload 10
    //   669: checkcast 689	[Landroid/util/LongSparseArray;
    //   672: checkcast 689	[Landroid/util/LongSparseArray;
    //   675: astore 10
    //   677: aload_3
    //   678: ifnull +70 -> 748
    //   681: aload_0
    //   682: aload_0
    //   683: aload_1
    //   684: invokestatic 620	com/tencent/theme/g:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/i;
    //   687: putfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   690: aload_0
    //   691: getfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   694: invokevirtual 626	com/tencent/theme/i:b	()V
    //   697: aload_0
    //   698: new 617	com/tencent/theme/g
    //   701: dup
    //   702: aload_0
    //   703: aload_1
    //   704: aload_3
    //   705: aload 7
    //   707: aload 10
    //   709: invokespecial 629	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;[ILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   712: putfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   715: goto +396 -> 1111
    //   718: iload_2
    //   719: aload 10
    //   721: arraylength
    //   722: if_icmpge +386 -> 1108
    //   725: aload 10
    //   727: iload_2
    //   728: new 633	com/tencent/theme/h
    //   731: dup
    //   732: iload_2
    //   733: aload_0
    //   734: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   737: invokespecial 636	com/tencent/theme/h:<init>	(ILcom/tencent/theme/g;)V
    //   740: aastore
    //   741: iload_2
    //   742: iconst_1
    //   743: iadd
    //   744: istore_2
    //   745: goto -27 -> 718
    //   748: aload_0
    //   749: aload_0
    //   750: aload_1
    //   751: invokestatic 620	com/tencent/theme/g:a	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;)Lcom/tencent/theme/i;
    //   754: putfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   757: aload_0
    //   758: getfield 622	com/tencent/theme/SkinEngine:C	Lcom/tencent/theme/i;
    //   761: invokevirtual 626	com/tencent/theme/i:b	()V
    //   764: aload_0
    //   765: new 617	com/tencent/theme/g
    //   768: dup
    //   769: aload_0
    //   770: aload_1
    //   771: iload_2
    //   772: iload 4
    //   774: aload 7
    //   776: aload 10
    //   778: invokespecial 684	com/tencent/theme/g:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;IILjava/io/File;[Landroid/util/LongSparseArray;)V
    //   781: putfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   784: goto +327 -> 1111
    //   787: astore_1
    //   788: new 599	com/tencent/theme/UnSupportPlatformException
    //   791: dup
    //   792: aload_1
    //   793: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   796: athrow
    //   797: ldc 46
    //   799: iconst_1
    //   800: new 281	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 691
    //   810: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload_3
    //   814: invokevirtual 694	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: aconst_null
    //   821: invokestatic 654	com/tencent/theme/k:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   824: goto -563 -> 261
    //   827: astore_3
    //   828: ldc 46
    //   830: iconst_1
    //   831: ldc_w 696
    //   834: aload_3
    //   835: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   838: goto -577 -> 261
    //   841: astore_1
    //   842: new 599	com/tencent/theme/UnSupportPlatformException
    //   845: dup
    //   846: aload_1
    //   847: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   850: athrow
    //   851: ldc 46
    //   853: iconst_1
    //   854: ldc_w 698
    //   857: aconst_null
    //   858: invokestatic 654	com/tencent/theme/k:c	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   861: goto -600 -> 261
    //   864: astore_3
    //   865: aload 7
    //   867: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   870: invokevirtual 681	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   873: ldc_w 658
    //   876: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   879: astore_3
    //   880: goto -560 -> 320
    //   883: ldc 220
    //   885: ldc_w 700
    //   888: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   891: astore 10
    //   893: aload 10
    //   895: iconst_1
    //   896: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   899: aload 10
    //   901: aload_1
    //   902: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   905: checkcast 209	android/util/LongSparseArray
    //   908: astore_3
    //   909: aload 9
    //   911: astore 7
    //   913: aload 10
    //   915: astore 9
    //   917: goto -575 -> 342
    //   920: aload_0
    //   921: new 702	com/tencent/theme/d
    //   924: dup
    //   925: aload_0
    //   926: aload_1
    //   927: aload_3
    //   928: iload 5
    //   930: iload 6
    //   932: invokespecial 703	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   935: putfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   938: goto -572 -> 366
    //   941: astore_3
    //   942: ldc 220
    //   944: ldc_w 705
    //   947: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   950: astore 7
    //   952: aload 7
    //   954: iconst_1
    //   955: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   958: aload 7
    //   960: aload_1
    //   961: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: astore 9
    //   966: aload 9
    //   968: instanceof 673
    //   971: ifeq +51 -> 1022
    //   974: aload_0
    //   975: new 707	com/tencent/theme/e
    //   978: dup
    //   979: aload_0
    //   980: aload_1
    //   981: aload 9
    //   983: checkcast 673	android/util/SparseArray
    //   986: iload 5
    //   988: iload 6
    //   990: invokespecial 710	com/tencent/theme/e:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/SparseArray;II)V
    //   993: putfield 712	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   996: aload 7
    //   998: aload_1
    //   999: aload_0
    //   1000: getfield 712	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   1003: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1006: goto -618 -> 388
    //   1009: aload 9
    //   1011: aload_1
    //   1012: aload_0
    //   1013: getfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   1016: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1019: goto -631 -> 388
    //   1022: aload 9
    //   1024: instanceof 209
    //   1027: ifeq +38 -> 1065
    //   1030: aload_0
    //   1031: new 702	com/tencent/theme/d
    //   1034: dup
    //   1035: aload_0
    //   1036: aload_1
    //   1037: aload 9
    //   1039: checkcast 209	android/util/LongSparseArray
    //   1042: iload 5
    //   1044: iload 6
    //   1046: invokespecial 703	com/tencent/theme/d:<init>	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Landroid/util/LongSparseArray;II)V
    //   1049: putfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   1052: aload 7
    //   1054: aload_1
    //   1055: aload_0
    //   1056: getfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   1059: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1062: goto -674 -> 388
    //   1065: new 599	com/tencent/theme/UnSupportPlatformException
    //   1068: dup
    //   1069: aload_3
    //   1070: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   1073: athrow
    //   1074: astore_3
    //   1075: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1078: ifeq +13 -> 1091
    //   1081: ldc 46
    //   1083: ldc_w 714
    //   1086: aload_3
    //   1087: invokestatic 717	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1090: pop
    //   1091: iconst_0
    //   1092: putstatic 137	com/tencent/theme/SkinEngine:IS_PROBLEM_MIUI	Z
    //   1095: goto -642 -> 453
    //   1098: astore_1
    //   1099: aconst_null
    //   1100: putstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1103: aconst_null
    //   1104: putstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1107: return
    //   1108: goto -928 -> 180
    //   1111: iconst_0
    //   1112: istore_2
    //   1113: goto -395 -> 718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	this	SkinEngine
    //   0	1116	1	paramResources	Resources
    //   0	1116	2	paramInt1	int
    //   0	1116	3	paramArrayOfInt	int[]
    //   0	1116	4	paramInt2	int
    //   0	1116	5	paramInt3	int
    //   0	1116	6	paramInt4	int
    //   0	1116	7	paramFile	File
    //   197	3	8	bool	boolean
    //   9	369	9	localObject1	Object
    //   528	1	9	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   544	494	9	localObject2	Object
    //   1	913	10	localObject3	Object
    //   84	555	11	localObject4	Object
    //   80	11	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	67	528	java/lang/NoSuchFieldException
    //   24	54	628	java/lang/IllegalArgumentException
    //   54	67	628	java/lang/IllegalArgumentException
    //   67	82	628	java/lang/IllegalArgumentException
    //   94	102	628	java/lang/IllegalArgumentException
    //   106	150	628	java/lang/IllegalArgumentException
    //   150	156	628	java/lang/IllegalArgumentException
    //   161	180	628	java/lang/IllegalArgumentException
    //   180	199	628	java/lang/IllegalArgumentException
    //   204	213	628	java/lang/IllegalArgumentException
    //   217	231	628	java/lang/IllegalArgumentException
    //   235	261	628	java/lang/IllegalArgumentException
    //   261	271	628	java/lang/IllegalArgumentException
    //   281	308	628	java/lang/IllegalArgumentException
    //   308	320	628	java/lang/IllegalArgumentException
    //   320	336	628	java/lang/IllegalArgumentException
    //   342	366	628	java/lang/IllegalArgumentException
    //   366	372	628	java/lang/IllegalArgumentException
    //   377	388	628	java/lang/IllegalArgumentException
    //   388	398	628	java/lang/IllegalArgumentException
    //   530	546	628	java/lang/IllegalArgumentException
    //   549	573	628	java/lang/IllegalArgumentException
    //   579	625	628	java/lang/IllegalArgumentException
    //   638	656	628	java/lang/IllegalArgumentException
    //   659	677	628	java/lang/IllegalArgumentException
    //   681	715	628	java/lang/IllegalArgumentException
    //   718	741	628	java/lang/IllegalArgumentException
    //   748	784	628	java/lang/IllegalArgumentException
    //   797	824	628	java/lang/IllegalArgumentException
    //   828	838	628	java/lang/IllegalArgumentException
    //   851	861	628	java/lang/IllegalArgumentException
    //   865	880	628	java/lang/IllegalArgumentException
    //   883	909	628	java/lang/IllegalArgumentException
    //   920	938	628	java/lang/IllegalArgumentException
    //   942	1006	628	java/lang/IllegalArgumentException
    //   1009	1019	628	java/lang/IllegalArgumentException
    //   1022	1062	628	java/lang/IllegalArgumentException
    //   1065	1074	628	java/lang/IllegalArgumentException
    //   24	54	787	java/lang/NoSuchFieldException
    //   67	82	787	java/lang/NoSuchFieldException
    //   94	102	787	java/lang/NoSuchFieldException
    //   106	150	787	java/lang/NoSuchFieldException
    //   150	156	787	java/lang/NoSuchFieldException
    //   161	180	787	java/lang/NoSuchFieldException
    //   180	199	787	java/lang/NoSuchFieldException
    //   204	213	787	java/lang/NoSuchFieldException
    //   217	231	787	java/lang/NoSuchFieldException
    //   235	261	787	java/lang/NoSuchFieldException
    //   261	271	787	java/lang/NoSuchFieldException
    //   281	308	787	java/lang/NoSuchFieldException
    //   320	336	787	java/lang/NoSuchFieldException
    //   342	366	787	java/lang/NoSuchFieldException
    //   366	372	787	java/lang/NoSuchFieldException
    //   377	388	787	java/lang/NoSuchFieldException
    //   388	398	787	java/lang/NoSuchFieldException
    //   530	546	787	java/lang/NoSuchFieldException
    //   549	573	787	java/lang/NoSuchFieldException
    //   579	625	787	java/lang/NoSuchFieldException
    //   638	656	787	java/lang/NoSuchFieldException
    //   659	677	787	java/lang/NoSuchFieldException
    //   681	715	787	java/lang/NoSuchFieldException
    //   718	741	787	java/lang/NoSuchFieldException
    //   748	784	787	java/lang/NoSuchFieldException
    //   797	824	787	java/lang/NoSuchFieldException
    //   828	838	787	java/lang/NoSuchFieldException
    //   851	861	787	java/lang/NoSuchFieldException
    //   865	880	787	java/lang/NoSuchFieldException
    //   883	909	787	java/lang/NoSuchFieldException
    //   920	938	787	java/lang/NoSuchFieldException
    //   942	1006	787	java/lang/NoSuchFieldException
    //   1009	1019	787	java/lang/NoSuchFieldException
    //   1022	1062	787	java/lang/NoSuchFieldException
    //   1065	1074	787	java/lang/NoSuchFieldException
    //   204	213	827	java/lang/Throwable
    //   217	231	827	java/lang/Throwable
    //   235	261	827	java/lang/Throwable
    //   797	824	827	java/lang/Throwable
    //   851	861	827	java/lang/Throwable
    //   24	54	841	java/lang/IllegalAccessException
    //   54	67	841	java/lang/IllegalAccessException
    //   67	82	841	java/lang/IllegalAccessException
    //   94	102	841	java/lang/IllegalAccessException
    //   106	150	841	java/lang/IllegalAccessException
    //   150	156	841	java/lang/IllegalAccessException
    //   161	180	841	java/lang/IllegalAccessException
    //   180	199	841	java/lang/IllegalAccessException
    //   204	213	841	java/lang/IllegalAccessException
    //   217	231	841	java/lang/IllegalAccessException
    //   235	261	841	java/lang/IllegalAccessException
    //   261	271	841	java/lang/IllegalAccessException
    //   281	308	841	java/lang/IllegalAccessException
    //   308	320	841	java/lang/IllegalAccessException
    //   320	336	841	java/lang/IllegalAccessException
    //   342	366	841	java/lang/IllegalAccessException
    //   366	372	841	java/lang/IllegalAccessException
    //   377	388	841	java/lang/IllegalAccessException
    //   388	398	841	java/lang/IllegalAccessException
    //   530	546	841	java/lang/IllegalAccessException
    //   549	573	841	java/lang/IllegalAccessException
    //   579	625	841	java/lang/IllegalAccessException
    //   638	656	841	java/lang/IllegalAccessException
    //   659	677	841	java/lang/IllegalAccessException
    //   681	715	841	java/lang/IllegalAccessException
    //   718	741	841	java/lang/IllegalAccessException
    //   748	784	841	java/lang/IllegalAccessException
    //   797	824	841	java/lang/IllegalAccessException
    //   828	838	841	java/lang/IllegalAccessException
    //   851	861	841	java/lang/IllegalAccessException
    //   865	880	841	java/lang/IllegalAccessException
    //   883	909	841	java/lang/IllegalAccessException
    //   920	938	841	java/lang/IllegalAccessException
    //   942	1006	841	java/lang/IllegalAccessException
    //   1009	1019	841	java/lang/IllegalAccessException
    //   1022	1062	841	java/lang/IllegalAccessException
    //   1065	1074	841	java/lang/IllegalAccessException
    //   308	320	864	java/lang/NoSuchFieldException
    //   281	308	941	java/lang/Exception
    //   308	320	941	java/lang/Exception
    //   320	336	941	java/lang/Exception
    //   342	366	941	java/lang/Exception
    //   366	372	941	java/lang/Exception
    //   377	388	941	java/lang/Exception
    //   865	880	941	java/lang/Exception
    //   883	909	941	java/lang/Exception
    //   920	938	941	java/lang/Exception
    //   1009	1019	941	java/lang/Exception
    //   398	453	1074	java/lang/Exception
    //   453	527	1098	java/lang/Exception
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.C.a())
    {
      paramResources = this.C.a(paramString);
      if (paramResources != null)
      {
        paramTypedValue.string = (this.u + paramArrayOfString[paramResources.intValue()] + paramString);
        paramTypedValue.density = paramArrayOfInt[paramResources.intValue()];
        return;
      }
      paramTypedValue.string = null;
      paramTypedValue.density = 0;
      return;
    }
    int i1 = 0;
    if (i1 < paramArrayOfInt.length)
    {
      do
      {
        try
        {
          String str = this.u + paramArrayOfString[i1] + paramString;
          if (!str.startsWith("/asset/")) {
            continue;
          }
          paramResources.getAssets().open(str.substring("/asset/".length())).close();
          paramTypedValue.string = str;
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        catch (IOException localIOException)
        {
          if (DEBUG) {
            Log.w("SkinEngine", localIOException);
          }
          i1 += 1;
        }
        break;
      } while (!new File(localIOException).exists());
      paramTypedValue.string = localIOException;
      paramTypedValue.density = paramArrayOfInt[i1];
      return;
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  private void a(TypedValue paramTypedValue)
  {
    synchronized (this.D)
    {
      if (this.d == null) {
        this.d = paramTypedValue;
      }
      return;
    }
  }
  
  private void a(b paramb)
  {
    Object localObject1 = paramb.i;
    Object localObject2 = ((l)localObject1).b;
    if (this.u != null)
    {
      this.c.resourceId = ((l)localObject1).a;
      a(this.mResources, this.c, ((l)localObject1).d, e[this.w], f[this.w]);
      if (this.c.string != null)
      {
        ((l)localObject1).b = this.c.string.toString();
        ((l)localObject1).c = this.c.density;
        if ((localObject2 != null) || (((l)localObject1).b != null) || (((l)localObject1).d.endsWith(".xml"))) {
          break label138;
        }
      }
    }
    label138:
    label218:
    label364:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ((l)localObject1).b = null;
            break;
            ((l)localObject1).b = null;
            break;
            if (!(paramb instanceof SkinnableBitmapDrawable.a)) {
              break label364;
            }
            paramb = (SkinnableBitmapDrawable.a)paramb;
            localObject2 = a(((l)localObject1).a, this.mResources, (l)localObject1);
            if (localObject2 != null) {
              break label218;
            }
          } while (!DEBUG);
          throw new NullPointerException("loadImage failed, file path: " + ((l)localObject1).b + " , resource name:" + ((l)localObject1).d);
          if ((DEBUG) && ((localObject2 instanceof SkinnableNinePatchDrawable.a))) {
            throw new IllegalArgumentException("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: " + ((l)localObject1).b + " , resource name:" + ((l)localObject1).d);
          }
          localObject1 = (SkinnableBitmapDrawable.a)localObject2;
          paramb.l = ((SkinnableBitmapDrawable.a)localObject1).l;
          paramb.e = ((SkinnableBitmapDrawable.a)localObject1).e;
          paramb.j = ((SkinnableBitmapDrawable.a)localObject1).j;
          paramb.k = ((SkinnableBitmapDrawable.a)localObject1).k;
        } while ((!paramb.s) && (!((SkinnableBitmapDrawable.a)localObject1).s));
        paramb.n = ((SkinnableBitmapDrawable.a)localObject1).n;
        paramb.o = ((SkinnableBitmapDrawable.a)localObject1).o;
        paramb.p = ((SkinnableBitmapDrawable.a)localObject1).p;
        paramb.q = ((SkinnableBitmapDrawable.a)localObject1).q;
        paramb.s = true;
        return;
      } while (!(paramb instanceof SkinnableNinePatchDrawable.a));
      paramb = (SkinnableNinePatchDrawable.a)paramb;
      localObject2 = a(((l)localObject1).a, this.mResources, (l)localObject1);
      if (localObject2 != null) {
        break label444;
      }
    } while (!DEBUG);
    throw new NullPointerException("loadImage failed, file path: " + ((l)localObject1).b + " , resource name:" + ((l)localObject1).d);
    label444:
    if ((DEBUG) && ((localObject2 instanceof SkinnableBitmapDrawable.a))) {
      throw new IllegalArgumentException("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: " + ((l)localObject1).b + " , resource name:" + ((l)localObject1).d);
    }
    localObject1 = (SkinnableNinePatchDrawable.a)localObject2;
    paramb.k = ((SkinnableNinePatchDrawable.a)localObject1).k;
    paramb.l = ((SkinnableNinePatchDrawable.a)localObject1).l;
    paramb.n = paramb.m;
    paramb.m = ((SkinnableNinePatchDrawable.a)localObject1).m;
    paramb.r = ((SkinnableNinePatchDrawable.a)localObject1).r;
    paramb.j = ((SkinnableNinePatchDrawable.a)localObject1).j;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.A == null) {}
    try
    {
      XmlResourceParser localXmlResourceParser = this.mResources.getAssets().openXmlResourceParser("res/xml/theme_config.xml");
      this.A = a(localXmlResourceParser);
      localXmlResourceParser.close();
      if (this.B == null)
      {
        if (this.u == null) {
          this.B = new HashMap();
        }
      }
      else {
        return;
      }
    }
    catch (XmlPullParserException localXmlPullParserException1)
    {
      localObject = new Resources.NotFoundException("wrong xml config file: res/xml/theme_config.xml");
      ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException1);
      throw ((Throwable)localObject);
    }
    catch (IOException localIOException1)
    {
      Object localObject;
      for (;;)
      {
        this.A = new HashMap();
      }
      if (paramBoolean) {}
      try
      {
        a locala = new a();
        localObject = new FileInputStream(new File(this.u, "xml/theme_config.xml"));
        locala.setInput((InputStream)localObject, "UTF-8");
        this.B = a(locala);
        ((FileInputStream)localObject).close();
        return;
      }
      catch (XmlPullParserException localXmlPullParserException2)
      {
        for (;;)
        {
          localObject = new Resources.NotFoundException("wrong theme xml config file: xml/theme_config.xml");
          ((Resources.NotFoundException)localObject).initCause(localXmlPullParserException2);
          throw ((Throwable)localObject);
          XmlPullParser localXmlPullParser = Xml.newPullParser();
        }
      }
      catch (IOException localIOException2)
      {
        this.B = new HashMap();
      }
    }
  }
  
  private SkinnableColorStateList b(int paramInt, Resources paramResources, l paraml)
  {
    Object localObject;
    synchronized (this.c)
    {
      localObject = paraml.b;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool)
        {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = j.a(this, paramResources, new File((String)localObject), this.q);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (!DEBUG) {
              break label126;
            }
          }
          paramResources = new Resources.NotFoundException("File " + (String)localObject + " from Skin ColorState resource ID #0x" + Integer.toHexString(paramInt));
          paramResources.initCause(localException);
          throw paramResources;
        }
      }
    }
    label126:
    paraml = paraml.d;
    boolean bool = paraml.endsWith(".xml");
    if (bool) {
      try
      {
        localObject = a(paramInt, this.c);
        paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
        ((XmlResourceParser)localObject).close();
        return paramResources;
      }
      catch (Exception paramResources)
      {
        paraml = new Resources.NotFoundException("File " + paraml + " from Skin ColorList list resource ID #0x" + Integer.toHexString(paramInt));
        paraml.initCause(paramResources);
        throw paraml;
      }
    }
    throw new Resources.NotFoundException("File " + paraml + " from Skin ColorList resource ID #0x" + Integer.toHexString(paramInt) + ": .xml extension required");
  }
  
  private InputStream b(Resources paramResources, String paramString)
    throws IOException, FileNotFoundException
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring("/asset/".length());
      return paramResources.getAssets().open(paramString);
    }
    return new BufferedInputStream(new FileInputStream(new File(paramString)));
  }
  
  @TargetApi(16)
  private void b(Context paramContext)
  {
    TypedValue localTypedValue = this.c;
    int i1 = 0;
    for (;;)
    {
      l locall;
      try
      {
        int i2 = this.s.size();
        if (i1 >= i2) {
          break;
        }
        String str1;
        try
        {
          paramContext = (WeakReference)this.s.valueAt(i1);
          if (paramContext == null) {
            i1 += 1;
          }
        }
        catch (ClassCastException paramContext)
        {
          k.a("SkinEngine", 1, "updateColorState()", paramContext);
          paramContext = null;
          continue;
          paramContext = (SkinnableColorStateList)paramContext.get();
          if (paramContext == null) {
            continue;
          }
          locall = paramContext.skinData;
          str1 = locall.b;
          if (this.u == null) {
            break label172;
          }
        }
        String str2 = a(this.mResources, locall.d);
        if (str2 != null)
        {
          locall.b = str2;
          if ((str1 == null) && (locall.b == null)) {
            continue;
          }
          paramContext.a(b(locall.a, this.mResources, locall));
          continue;
        }
        locall.b = null;
      }
      finally {}
      continue;
      label172:
      locall.b = null;
    }
  }
  
  @TargetApi(16)
  private void c(Context paramContext)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i1;
      synchronized (this.c)
      {
        if (this.C != null) {
          this.C.b();
        }
        localArrayList = new ArrayList();
        i1 = 0;
        int i2 = this.r.size();
        if (i1 < i2) {
          try
          {
            paramContext = (WeakReference)this.r.valueAt(i1);
            if (paramContext == null) {
              break label166;
            }
            paramContext = (b)paramContext.get();
            if (paramContext == null) {
              break label166;
            }
            if (paramContext.i.d.endsWith(".xml")) {
              localArrayList.add(paramContext);
            }
          }
          catch (ClassCastException paramContext)
          {
            k.a("SkinEngine", 1, "updateImage()", paramContext);
            paramContext = null;
            continue;
            a(paramContext);
          }
        }
      }
      paramContext = localArrayList.iterator();
      while (paramContext.hasNext()) {
        a((b)paramContext.next());
      }
      return;
      label166:
      i1 += 1;
    }
  }
  
  public static long dumpDrawableCacheMemSize()
  {
    SkinEngine localSkinEngine = getInstances();
    TypedValue localTypedValue = new TypedValue();
    long l2 = 0L;
    int i2 = 0;
    Object localObject;
    long l3;
    long l1;
    int i1;
    if (i2 < localSkinEngine.r.size())
    {
      localObject = (WeakReference)localSkinEngine.r.valueAt(i2);
      l3 = localSkinEngine.r.keyAt(i2);
      l1 = l2;
      if (localObject != null)
      {
        localObject = (Drawable.ConstantState)((WeakReference)localObject).get();
        l1 = l2;
        if (localObject != null)
        {
          if (!(localObject instanceof SkinnableBitmapDrawable.a)) {
            break label193;
          }
          i1 = a(((SkinnableBitmapDrawable.a)localObject).l);
        }
      }
    }
    for (;;)
    {
      l2 += i1;
      localSkinEngine.mResources.getValue((int)l3, localTypedValue, true);
      l1 = l2;
      if (localTypedValue.string != null)
      {
        k.d("SkinEngine", 4, "res:" + localTypedValue.string.toString() + ",size=" + i1, null);
        l1 = l2;
      }
      i2 += 1;
      l2 = l1;
      break;
      label193:
      if ((localObject instanceof SkinnableNinePatchDrawable.a))
      {
        i1 = a(((SkinnableNinePatchDrawable.a)localObject).r);
        continue;
        k.c("SkinEngine", 4, "Total DrawableNum=" + localSkinEngine.r.size() + ",MemSize=" + l2, null);
        return l2;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (n == null) {
        n = new SkinEngine();
      }
      SkinEngine localSkinEngine = n;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, File paramFile)
    throws UnSupportPlatformException
  {
    Object localObject = new StringBuilder().append("init cacheFile:");
    if (paramFile == null) {}
    for (boolean bool = true;; bool = false)
    {
      k.c("SkinEngine", 2, bool, null);
      localObject = getInstances();
      Resources localResources = paramContext.getResources();
      ((SkinEngine)localObject).mResources = localResources;
      isSupportPlatform(paramContext, localResources);
      ((SkinEngine)localObject).w = a(((SkinEngine)localObject).mResources);
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
      ((SkinEngine)localObject).u = localSharedPreferences.getString("theme_root", null);
      paramContext.getApplicationContext().registerReceiver(((SkinEngine)localObject).m, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
      ((SkinEngine)localObject).a(localResources, paramInt1, null, paramInt2, paramInt3, paramInt4, paramFile);
      ((SkinEngine)localObject).q = localSharedPreferences.getBoolean("complied", true);
      return;
    }
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, File paramFile)
    throws UnSupportPlatformException
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.w = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.m, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, 0, paramArrayOfInt, 0, paramInt1, paramInt2, paramFile);
    paramContext = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.u = paramContext.getString("theme_root", null);
    localSkinEngine.q = paramContext.getBoolean("complied", true);
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int i2;
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      localObject = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject = paramView.getBackground();
    Rect localRect;
    if (localObject != null)
    {
      if (!(localObject instanceof DrawableContainer)) {
        break label270;
      }
      localRect = new Rect();
      ((Drawable)localObject).getPadding(localRect);
      if ((localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
      {
        SkinnableActivityProcesser.a((Drawable)localObject);
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
      }
    }
    else
    {
      if ((paramView instanceof SkinnableView)) {
        ((SkinnableView)paramView).onThemeChanged();
      }
      if (!(paramView instanceof ImageView)) {
        break label428;
      }
      localObject = ((ImageView)paramView).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject);
      ((ImageView)paramView).setImageDrawable(null);
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramView.destroyDrawingCache();
      paramView.refreshDrawableState();
      paramView.invalidate();
      paramView.requestLayout();
      return;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      int i3 = paramView.getPaddingLeft();
      int i4 = paramView.getPaddingRight();
      SkinnableActivityProcesser.a((Drawable)localObject);
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      paramView.setPadding(i3, i1, i4, i2);
      break;
      label270:
      if ((localObject instanceof SkinnableNinePatchDrawable))
      {
        localRect = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject).a(localRect)) && (localRect.left == paramView.getPaddingLeft()) && (localRect.right == paramView.getPaddingRight()) && (localRect.top == paramView.getPaddingTop()) && (localRect.bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject);
          break;
        }
        i1 = paramView.getPaddingTop();
        i2 = paramView.getPaddingBottom();
        i3 = paramView.getPaddingLeft();
        i4 = paramView.getPaddingRight();
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject);
        paramView.setPadding(i3, i1, i4, i2);
        break;
      }
      if (!(localObject instanceof SkinnableBitmapDrawable)) {
        break;
      }
      paramView.setBackgroundDrawable(null);
      paramView.setBackgroundDrawable((Drawable)localObject);
      break;
      label428:
      if ((paramView instanceof TextView))
      {
        localObject = ((TextView)paramView).getCompoundDrawables();
        if ((localObject[0] != null) || (localObject[1] != null) || (localObject[2] != null) || (localObject[3] != null))
        {
          ((TextView)paramView).setCompoundDrawables(null, null, null, null);
          ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(localObject[0], localObject[1], localObject[2], localObject[3]);
        }
      }
    }
  }
  
  /* Error */
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
    throws UnSupportPlatformException
  {
    // Byte code:
    //   0: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   3: ifeq +102 -> 105
    //   6: ldc 220
    //   8: ldc_w 609
    //   11: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   14: astore_3
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   32: ldc_w 615
    //   35: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore_3
    //   39: aload_3
    //   40: iconst_1
    //   41: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   44: aload_3
    //   45: aload 4
    //   47: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore_3
    //   51: aload_3
    //   52: instanceof 209
    //   55: ifne +73 -> 128
    //   58: aload_3
    //   59: instanceof 689
    //   62: ifne +66 -> 128
    //   65: new 599	com/tencent/theme/UnSupportPlatformException
    //   68: dup
    //   69: ldc_w 1082
    //   72: invokespecial 1083	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_0
    //   77: new 599	com/tencent/theme/UnSupportPlatformException
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   85: athrow
    //   86: astore_3
    //   87: aload 4
    //   89: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   92: invokevirtual 681	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   95: ldc_w 615
    //   98: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore_3
    //   102: goto -63 -> 39
    //   105: ldc 220
    //   107: ldc_w 615
    //   110: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   113: astore_3
    //   114: aload_3
    //   115: iconst_1
    //   116: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   119: aload_3
    //   120: aload_1
    //   121: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: astore_3
    //   125: goto -74 -> 51
    //   128: getstatic 135	com/tencent/theme/SkinEngine:b	Z
    //   131: ifeq +145 -> 276
    //   134: ldc 220
    //   136: ldc_w 609
    //   139: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   142: astore_3
    //   143: aload_3
    //   144: iconst_1
    //   145: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   148: aload_3
    //   149: aload_1
    //   150: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   160: ldc_w 658
    //   163: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   166: astore_3
    //   167: aload_3
    //   168: iconst_1
    //   169: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   172: aload_3
    //   173: aload 4
    //   175: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   178: astore_3
    //   179: aload_3
    //   180: instanceof 209
    //   183: ifne +47 -> 230
    //   186: new 599	com/tencent/theme/UnSupportPlatformException
    //   189: dup
    //   190: ldc_w 1085
    //   193: invokespecial 1083	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_3
    //   198: ldc 220
    //   200: ldc_w 705
    //   203: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   206: astore 4
    //   208: aload 4
    //   210: iconst_1
    //   211: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   214: aload 4
    //   216: aload_1
    //   217: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   220: astore_1
    //   221: aload_1
    //   222: instanceof 673
    //   225: istore_2
    //   226: iload_2
    //   227: ifeq +72 -> 299
    //   230: aload_0
    //   231: ldc_w 1087
    //   234: invokestatic 1092	com/tencent/theme/n:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   237: ldc_w 1094
    //   240: invokevirtual 587	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   243: ifeq +92 -> 335
    //   246: new 599	com/tencent/theme/UnSupportPlatformException
    //   249: dup
    //   250: ldc_w 1096
    //   253: invokespecial 1083	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/String;)V
    //   256: athrow
    //   257: astore_3
    //   258: aload 4
    //   260: invokevirtual 482	java/lang/Object:getClass	()Ljava/lang/Class;
    //   263: invokevirtual 681	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   266: ldc_w 658
    //   269: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   272: astore_3
    //   273: goto -106 -> 167
    //   276: ldc 220
    //   278: ldc_w 700
    //   281: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   284: astore_3
    //   285: aload_3
    //   286: iconst_1
    //   287: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   290: aload_3
    //   291: aload_1
    //   292: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: astore_3
    //   296: goto -117 -> 179
    //   299: aload_1
    //   300: instanceof 209
    //   303: ifne -73 -> 230
    //   306: new 599	com/tencent/theme/UnSupportPlatformException
    //   309: dup
    //   310: aload_3
    //   311: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   314: athrow
    //   315: astore_0
    //   316: new 599	com/tencent/theme/UnSupportPlatformException
    //   319: dup
    //   320: aload_0
    //   321: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   324: athrow
    //   325: astore_0
    //   326: new 599	com/tencent/theme/UnSupportPlatformException
    //   329: dup
    //   330: aload_0
    //   331: invokespecial 687	com/tencent/theme/UnSupportPlatformException:<init>	(Ljava/lang/Throwable;)V
    //   334: athrow
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramContext	Context
    //   0	336	1	paramResources	Resources
    //   225	2	2	bool	boolean
    //   14	45	3	localObject1	Object
    //   86	1	3	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   101	79	3	localObject2	Object
    //   197	1	3	localException	Exception
    //   257	1	3	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   272	39	3	localObject3	Object
    //   25	234	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   0	27	76	java/lang/IllegalArgumentException
    //   27	39	76	java/lang/IllegalArgumentException
    //   39	51	76	java/lang/IllegalArgumentException
    //   51	76	76	java/lang/IllegalArgumentException
    //   87	102	76	java/lang/IllegalArgumentException
    //   105	125	76	java/lang/IllegalArgumentException
    //   128	155	76	java/lang/IllegalArgumentException
    //   155	167	76	java/lang/IllegalArgumentException
    //   167	179	76	java/lang/IllegalArgumentException
    //   179	197	76	java/lang/IllegalArgumentException
    //   198	226	76	java/lang/IllegalArgumentException
    //   258	273	76	java/lang/IllegalArgumentException
    //   276	296	76	java/lang/IllegalArgumentException
    //   299	315	76	java/lang/IllegalArgumentException
    //   27	39	86	java/lang/NoSuchFieldException
    //   128	155	197	java/lang/Exception
    //   155	167	197	java/lang/Exception
    //   167	179	197	java/lang/Exception
    //   179	197	197	java/lang/Exception
    //   258	273	197	java/lang/Exception
    //   276	296	197	java/lang/Exception
    //   155	167	257	java/lang/NoSuchFieldException
    //   0	27	315	java/lang/NoSuchFieldException
    //   39	51	315	java/lang/NoSuchFieldException
    //   51	76	315	java/lang/NoSuchFieldException
    //   87	102	315	java/lang/NoSuchFieldException
    //   105	125	315	java/lang/NoSuchFieldException
    //   128	155	315	java/lang/NoSuchFieldException
    //   167	179	315	java/lang/NoSuchFieldException
    //   179	197	315	java/lang/NoSuchFieldException
    //   198	226	315	java/lang/NoSuchFieldException
    //   258	273	315	java/lang/NoSuchFieldException
    //   276	296	315	java/lang/NoSuchFieldException
    //   299	315	315	java/lang/NoSuchFieldException
    //   0	27	325	java/lang/IllegalAccessException
    //   27	39	325	java/lang/IllegalAccessException
    //   39	51	325	java/lang/IllegalAccessException
    //   51	76	325	java/lang/IllegalAccessException
    //   87	102	325	java/lang/IllegalAccessException
    //   105	125	325	java/lang/IllegalAccessException
    //   128	155	325	java/lang/IllegalAccessException
    //   155	167	325	java/lang/IllegalAccessException
    //   167	179	325	java/lang/IllegalAccessException
    //   179	197	325	java/lang/IllegalAccessException
    //   198	226	325	java/lang/IllegalAccessException
    //   258	273	325	java/lang/IllegalAccessException
    //   276	296	325	java/lang/IllegalAccessException
    //   299	315	325	java/lang/IllegalAccessException
  }
  
  public static void setSKLog(ISkinEngineLog paramISkinEngineLog)
  {
    k.a = paramISkinEngineLog;
    k.c("SkinEngine", 2, "set ISkinEngineLog ok", null);
  }
  
  /* Error */
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1106	com/tencent/theme/SkinEngine:a	()Landroid/util/TypedValue;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1110	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1115	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 212	com/tencent/theme/SkinEngine:r	Landroid/util/LongSparseArray;
    //   20: iload_1
    //   21: i2l
    //   22: invokevirtual 1118	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   25: checkcast 856	java/lang/ref/WeakReference
    //   28: astore_3
    //   29: aload_0
    //   30: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   33: invokevirtual 1110	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   36: invokevirtual 1121	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   39: aload_3
    //   40: ifnull +90 -> 130
    //   43: aload_3
    //   44: invokevirtual 861	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   47: checkcast 904	android/graphics/drawable/Drawable$ConstantState
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +49 -> 101
    //   55: aload_0
    //   56: aload 4
    //   58: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   61: aload_3
    //   62: areturn
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   68: invokevirtual 1110	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   71: invokevirtual 1121	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   74: aconst_null
    //   75: astore_3
    //   76: goto -37 -> 39
    //   79: astore_3
    //   80: aload_0
    //   81: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 1110	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   87: invokevirtual 1121	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   90: aload_3
    //   91: athrow
    //   92: astore_3
    //   93: aload_0
    //   94: aload 4
    //   96: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   99: aconst_null
    //   100: areturn
    //   101: aload_0
    //   102: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   105: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   108: invokevirtual 1130	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   111: aload_0
    //   112: getfield 212	com/tencent/theme/SkinEngine:r	Landroid/util/LongSparseArray;
    //   115: iload_1
    //   116: i2l
    //   117: invokevirtual 1134	android/util/LongSparseArray:delete	(J)V
    //   120: aload_0
    //   121: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   124: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   127: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   130: getstatic 143	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   133: istore_2
    //   134: iload_2
    //   135: ifeq +143 -> 278
    //   138: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   141: iconst_1
    //   142: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   145: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   148: aload_0
    //   149: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   152: aconst_null
    //   153: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   156: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   159: iconst_1
    //   160: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   163: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   166: aload_0
    //   167: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   170: aconst_null
    //   171: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   174: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   177: iconst_1
    //   178: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   181: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   184: iconst_1
    //   185: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   188: getstatic 139	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   191: aload_0
    //   192: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   195: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: ifnull +80 -> 278
    //   201: getstatic 141	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   204: aload_0
    //   205: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   208: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull +65 -> 278
    //   216: aload_0
    //   217: aload 4
    //   219: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   222: aconst_null
    //   223: areturn
    //   224: astore_3
    //   225: aload_0
    //   226: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   229: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   232: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   235: goto -105 -> 130
    //   238: astore_3
    //   239: aload_0
    //   240: aload 4
    //   242: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   245: aload_3
    //   246: athrow
    //   247: astore_3
    //   248: aload_0
    //   249: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   252: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   255: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   258: aload_3
    //   259: athrow
    //   260: astore_3
    //   261: aload_0
    //   262: aload 4
    //   264: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_3
    //   270: aload_0
    //   271: aload 4
    //   273: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   276: aconst_null
    //   277: areturn
    //   278: aload_0
    //   279: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   282: iload_1
    //   283: aload 4
    //   285: iconst_1
    //   286: invokevirtual 251	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   289: aload 4
    //   291: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   294: astore_3
    //   295: aload_3
    //   296: ifnonnull +11 -> 307
    //   299: aload_0
    //   300: aload 4
    //   302: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   305: aconst_null
    //   306: areturn
    //   307: aload 4
    //   309: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   312: invokeinterface 271 1 0
    //   317: astore 5
    //   319: new 314	com/tencent/theme/l
    //   322: dup
    //   323: invokespecial 1136	com/tencent/theme/l:<init>	()V
    //   326: astore_3
    //   327: aload_3
    //   328: iload_1
    //   329: putfield 741	com/tencent/theme/l:a	I
    //   332: aload_3
    //   333: aload 5
    //   335: aload 5
    //   337: ldc_w 1138
    //   340: invokevirtual 1141	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   343: iconst_1
    //   344: iadd
    //   345: invokevirtual 501	java/lang/String:substring	(I)Ljava/lang/String;
    //   348: putfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   351: aload_0
    //   352: getfield 490	com/tencent/theme/SkinEngine:u	Ljava/lang/String;
    //   355: ifnull +64 -> 419
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   363: aload 4
    //   365: aload_3
    //   366: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   369: getstatic 161	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   372: aload_0
    //   373: getfield 200	com/tencent/theme/SkinEngine:w	I
    //   376: aaload
    //   377: getstatic 165	com/tencent/theme/SkinEngine:f	[[I
    //   380: aload_0
    //   381: getfield 200	com/tencent/theme/SkinEngine:w	I
    //   384: aaload
    //   385: invokespecial 746	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   388: aload 4
    //   390: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   393: ifnull +26 -> 419
    //   396: aload_3
    //   397: aload 4
    //   399: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   402: invokeinterface 271 1 0
    //   407: putfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   410: aload_3
    //   411: aload 4
    //   413: getfield 729	android/util/TypedValue:density	I
    //   416: putfield 330	com/tencent/theme/l:c	I
    //   419: aload_0
    //   420: iload_1
    //   421: aload_0
    //   422: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   425: aload_3
    //   426: invokespecial 750	com/tencent/theme/SkinEngine:a	(ILandroid/content/res/Resources;Lcom/tencent/theme/l;)Lcom/tencent/theme/b;
    //   429: astore 5
    //   431: aload 5
    //   433: ifnull +47 -> 480
    //   436: aload 5
    //   438: aload_3
    //   439: putfield 739	com/tencent/theme/b:i	Lcom/tencent/theme/l;
    //   442: aload_0
    //   443: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   446: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   449: invokevirtual 1130	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   452: aload_0
    //   453: getfield 212	com/tencent/theme/SkinEngine:r	Landroid/util/LongSparseArray;
    //   456: iload_1
    //   457: i2l
    //   458: new 856	java/lang/ref/WeakReference
    //   461: dup
    //   462: aload 5
    //   464: invokespecial 1144	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   467: invokevirtual 1147	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   470: aload_0
    //   471: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   474: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   477: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   480: aload_0
    //   481: aload 4
    //   483: invokespecial 1123	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   486: aload 5
    //   488: areturn
    //   489: astore_3
    //   490: aload_0
    //   491: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   494: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   497: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   500: goto -20 -> 480
    //   503: astore_3
    //   504: aload_0
    //   505: getfield 192	com/tencent/theme/SkinEngine:o	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   508: invokevirtual 1127	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   511: invokevirtual 1135	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   514: aload_3
    //   515: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	SkinEngine
    //   0	516	1	paramInt	int
    //   133	2	2	bool	boolean
    //   28	34	3	localObject1	Object
    //   63	1	3	localException1	Exception
    //   75	1	3	localObject2	Object
    //   79	12	3	localObject3	Object
    //   92	1	3	localNotFoundException	Resources.NotFoundException
    //   211	2	3	localObject4	Object
    //   224	1	3	localException2	Exception
    //   238	8	3	localObject5	Object
    //   247	12	3	localObject6	Object
    //   260	1	3	localException3	Exception
    //   269	1	3	localException4	Exception
    //   294	145	3	localObject7	Object
    //   489	1	3	localException5	Exception
    //   503	12	3	localObject8	Object
    //   4	478	4	localTypedValue	TypedValue
    //   317	170	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	63	java/lang/Exception
    //   16	29	79	finally
    //   6	16	92	android/content/res/Resources$NotFoundException
    //   29	39	92	android/content/res/Resources$NotFoundException
    //   43	51	92	android/content/res/Resources$NotFoundException
    //   64	74	92	android/content/res/Resources$NotFoundException
    //   80	92	92	android/content/res/Resources$NotFoundException
    //   101	111	92	android/content/res/Resources$NotFoundException
    //   120	130	92	android/content/res/Resources$NotFoundException
    //   130	134	92	android/content/res/Resources$NotFoundException
    //   138	174	92	android/content/res/Resources$NotFoundException
    //   174	212	92	android/content/res/Resources$NotFoundException
    //   225	235	92	android/content/res/Resources$NotFoundException
    //   248	260	92	android/content/res/Resources$NotFoundException
    //   278	295	92	android/content/res/Resources$NotFoundException
    //   307	419	92	android/content/res/Resources$NotFoundException
    //   419	431	92	android/content/res/Resources$NotFoundException
    //   436	452	92	android/content/res/Resources$NotFoundException
    //   470	480	92	android/content/res/Resources$NotFoundException
    //   490	500	92	android/content/res/Resources$NotFoundException
    //   504	516	92	android/content/res/Resources$NotFoundException
    //   111	120	224	java/lang/Exception
    //   6	16	238	finally
    //   29	39	238	finally
    //   43	51	238	finally
    //   64	74	238	finally
    //   80	92	238	finally
    //   101	111	238	finally
    //   120	130	238	finally
    //   130	134	238	finally
    //   138	174	238	finally
    //   174	212	238	finally
    //   225	235	238	finally
    //   248	260	238	finally
    //   278	295	238	finally
    //   307	419	238	finally
    //   419	431	238	finally
    //   436	452	238	finally
    //   470	480	238	finally
    //   490	500	238	finally
    //   504	516	238	finally
    //   111	120	247	finally
    //   138	174	260	java/lang/Exception
    //   174	212	269	java/lang/Exception
    //   452	470	489	java/lang/Exception
    //   452	470	503	finally
  }
  
  /* Error */
  b a(Resources paramResources, l paraml, android.graphics.BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload 8
    //   2: ifeq +411 -> 413
    //   5: aload 6
    //   7: ifnull +406 -> 413
    //   10: new 184	android/util/TypedValue
    //   13: dup
    //   14: invokespecial 185	android/util/TypedValue:<init>	()V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   22: aload 6
    //   24: getfield 1150	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   27: aload_2
    //   28: iconst_1
    //   29: invokevirtual 251	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   32: aload_2
    //   33: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   36: invokeinterface 271 1 0
    //   41: astore 9
    //   43: new 314	com/tencent/theme/l
    //   46: dup
    //   47: invokespecial 1136	com/tencent/theme/l:<init>	()V
    //   50: astore_3
    //   51: aload_3
    //   52: aload 6
    //   54: getfield 1150	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   57: putfield 741	com/tencent/theme/l:a	I
    //   60: aload_3
    //   61: aload 9
    //   63: aload 9
    //   65: ldc_w 1138
    //   68: invokevirtual 1141	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   71: iconst_1
    //   72: iadd
    //   73: invokevirtual 501	java/lang/String:substring	(I)Ljava/lang/String;
    //   76: putfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   79: aload_0
    //   80: getfield 490	com/tencent/theme/SkinEngine:u	Ljava/lang/String;
    //   83: ifnull +60 -> 143
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   91: aload_2
    //   92: aload_3
    //   93: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   96: getstatic 161	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 200	com/tencent/theme/SkinEngine:w	I
    //   103: aaload
    //   104: getstatic 165	com/tencent/theme/SkinEngine:f	[[I
    //   107: aload_0
    //   108: getfield 200	com/tencent/theme/SkinEngine:w	I
    //   111: aaload
    //   112: invokespecial 746	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   115: aload_2
    //   116: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   119: ifnull +24 -> 143
    //   122: aload_3
    //   123: aload_2
    //   124: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   127: invokeinterface 271 1 0
    //   132: putfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   135: aload_3
    //   136: aload_2
    //   137: getfield 729	android/util/TypedValue:density	I
    //   140: putfield 330	com/tencent/theme/l:c	I
    //   143: aload_3
    //   144: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   147: ifnull +114 -> 261
    //   150: new 311	android/graphics/Rect
    //   153: dup
    //   154: invokespecial 312	android/graphics/Rect:<init>	()V
    //   157: astore_2
    //   158: new 327	android/graphics/BitmapFactory$Options
    //   161: dup
    //   162: invokespecial 328	android/graphics/BitmapFactory$Options:<init>	()V
    //   165: astore 9
    //   167: aload 9
    //   169: aload_3
    //   170: getfield 330	com/tencent/theme/l:c	I
    //   173: putfield 333	android/graphics/BitmapFactory$Options:inDensity	I
    //   176: aload 9
    //   178: aload 6
    //   180: getfield 1154	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   183: putfield 1155	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   186: aload_0
    //   187: aload_1
    //   188: aload_3
    //   189: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   192: invokespecial 325	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   195: astore 4
    //   197: aload_1
    //   198: aconst_null
    //   199: aload 4
    //   201: aload_3
    //   202: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   205: aload 9
    //   207: aload_2
    //   208: aload_0
    //   209: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   212: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   215: astore_2
    //   216: aload_2
    //   217: astore_1
    //   218: aload 4
    //   220: invokevirtual 345	java/io/InputStream:close	()V
    //   223: aload_2
    //   224: areturn
    //   225: astore_1
    //   226: ldc 46
    //   228: iconst_1
    //   229: new 281	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 1157
    //   239: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   246: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload_1
    //   253: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -42 -> 216
    //   261: aload_1
    //   262: aload 6
    //   264: getfield 1150	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   267: aload_2
    //   268: invokevirtual 466	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   271: astore_3
    //   272: aload_2
    //   273: getfield 265	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   276: invokeinterface 271 1 0
    //   281: astore 9
    //   283: new 327	android/graphics/BitmapFactory$Options
    //   286: dup
    //   287: invokespecial 328	android/graphics/BitmapFactory$Options:<init>	()V
    //   290: astore 10
    //   292: aload_1
    //   293: aload_2
    //   294: aload_3
    //   295: aload 9
    //   297: aload 10
    //   299: aload 4
    //   301: iconst_1
    //   302: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   305: astore_2
    //   306: aload_2
    //   307: astore_1
    //   308: aload_3
    //   309: invokevirtual 345	java/io/InputStream:close	()V
    //   312: aload_2
    //   313: areturn
    //   314: astore_3
    //   315: aload_2
    //   316: astore_1
    //   317: ldc 46
    //   319: iconst_1
    //   320: ldc_w 1159
    //   323: aload_3
    //   324: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: ldc 46
    //   332: iconst_1
    //   333: ldc_w 1161
    //   336: aload_2
    //   337: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload_1
    //   341: areturn
    //   342: astore_1
    //   343: ldc 46
    //   345: iconst_1
    //   346: new 281	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1163
    //   356: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload 6
    //   361: getfield 1150	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   364: invokevirtual 913	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: aload_1
    //   371: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   374: aconst_null
    //   375: areturn
    //   376: astore_1
    //   377: ldc 46
    //   379: iconst_1
    //   380: new 281	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 1165
    //   390: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload 6
    //   395: getfield 1150	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   398: invokevirtual 913	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: aload_1
    //   405: invokestatic 352	com/tencent/theme/k:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   408: aconst_null
    //   409: astore_2
    //   410: goto -104 -> 306
    //   413: aload_0
    //   414: aload_1
    //   415: aload_2
    //   416: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   419: invokespecial 325	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   422: astore 9
    //   424: aload_3
    //   425: iconst_0
    //   426: putfield 368	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   429: aload_3
    //   430: aload 6
    //   432: getfield 1154	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   435: putfield 1155	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   438: aload_3
    //   439: iload 7
    //   441: putfield 1168	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   444: aload_1
    //   445: aconst_null
    //   446: aload 9
    //   448: aload_2
    //   449: getfield 335	com/tencent/theme/l:d	Ljava/lang/String;
    //   452: aload_3
    //   453: aload 4
    //   455: aload_0
    //   456: getfield 198	com/tencent/theme/SkinEngine:q	Z
    //   459: invokestatic 340	com/tencent/theme/j:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/b;
    //   462: astore_1
    //   463: aload_1
    //   464: astore_2
    //   465: aload_2
    //   466: astore_1
    //   467: aload 9
    //   469: invokevirtual 345	java/io/InputStream:close	()V
    //   472: aload_2
    //   473: areturn
    //   474: astore_1
    //   475: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   478: ifeq +38 -> 516
    //   481: ldc 46
    //   483: new 281	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 1170
    //   493: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_2
    //   497: getfield 316	com/tencent/theme/l:b	Ljava/lang/String;
    //   500: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 1172
    //   506: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 410	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   515: pop
    //   516: aconst_null
    //   517: astore_2
    //   518: goto -53 -> 465
    //   521: astore_2
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -194 -> 330
    //   527: astore_3
    //   528: aconst_null
    //   529: astore_2
    //   530: goto -215 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	SkinEngine
    //   0	533	1	paramResources	Resources
    //   0	533	2	paraml	l
    //   0	533	3	paramOptions	android.graphics.BitmapFactory.Options
    //   0	533	4	paramRect	Rect
    //   0	533	5	paramBoolean1	boolean
    //   0	533	6	paramBackupForOOMData	BackupForOOMData
    //   0	533	7	paramInt	int
    //   0	533	8	paramBoolean2	boolean
    //   41	427	9	localObject	Object
    //   290	8	10	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   197	216	225	java/lang/OutOfMemoryError
    //   308	312	314	java/io/IOException
    //   218	223	329	java/lang/Throwable
    //   308	312	329	java/lang/Throwable
    //   317	327	329	java/lang/Throwable
    //   467	472	329	java/lang/Throwable
    //   261	272	342	java/lang/Exception
    //   292	306	376	java/lang/OutOfMemoryError
    //   444	463	474	java/lang/OutOfMemoryError
    //   10	143	521	java/lang/Throwable
    //   143	197	521	java/lang/Throwable
    //   197	216	521	java/lang/Throwable
    //   226	256	521	java/lang/Throwable
    //   261	272	521	java/lang/Throwable
    //   272	283	521	java/lang/Throwable
    //   283	292	521	java/lang/Throwable
    //   292	306	521	java/lang/Throwable
    //   343	374	521	java/lang/Throwable
    //   377	408	521	java/lang/Throwable
    //   413	444	521	java/lang/Throwable
    //   444	463	521	java/lang/Throwable
    //   475	516	521	java/lang/Throwable
    //   283	292	527	java/io/IOException
    //   292	306	527	java/io/IOException
    //   377	408	527	java/io/IOException
  }
  
  void a(Context paramContext)
  {
    boolean bool = true;
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    this.p = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.c)
    {
      this.v = this.u;
      this.u = str;
      this.q = bool;
      c(paramContext);
      b(paramContext);
      localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.q).commit();
      this.p = false;
      this.v = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      k.d("SkinEngine.switch", 2, "skinEngine update done", null);
      return;
    }
  }
  
  public void addBackupForOOMData(Integer paramInteger, BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.x.a(this.mResources, paramInt);
  }
  
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    TypedValue localTypedValue = a();
    try
    {
      Object localObject1 = (WeakReference)this.s.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = (SkinnableColorStateList)((WeakReference)localObject1).get();
        if (localObject1 != null) {
          return localObject1;
        }
        this.s.delete(paramInt);
      }
      this.mResources.getValue(paramInt, localTypedValue, true);
      Object localObject3 = localTypedValue.string.toString();
      if (((String)localObject3).endsWith(".xml"))
      {
        localObject1 = new l();
        ((l)localObject1).a = paramInt;
        ((l)localObject1).d = ((String)localObject3).substring(((String)localObject3).lastIndexOf("/") + 1);
        if (this.u != null) {
          ((l)localObject1).b = a(this.mResources, ((l)localObject1).d);
        }
        localObject3 = b(paramInt, this.mResources, (l)localObject1);
        ((SkinnableColorStateList)localObject3).skinData = ((l)localObject1);
        this.s.put(paramInt, new WeakReference(localObject3));
        return localObject3;
      }
      return null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      return null;
    }
    finally
    {
      a(localTypedValue);
    }
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.c)
    {
      TypedValue localTypedValue2 = this.c;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = b(paramInt).getDefaultColor();
        return paramInt;
      }
    }
    throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(paramInt) + " type #0x" + Integer.toHexString(localObject.type) + " is not valid");
  }
  
  public Drawable getDefaultThemeDrawable(int paramInt)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject1 = (WeakReference)this.t.get(paramInt);
        if (localObject1 == null) {
          break label306;
        }
        Object localObject5 = (b)((WeakReference)localObject1).get();
        localObject1 = localObject5;
        if (localObject5 == null)
        {
          this.t.delete(paramInt);
          localObject1 = localObject5;
        }
        localObject5 = localObject1;
        Object localObject2;
        if (localObject1 == null)
        {
          boolean bool = IS_PROBLEM_CM11;
          if (bool) {
            try
            {
              mIconsOfCM.setAccessible(true);
              mIconsOfCM.set(this.mResources, null);
              mComposedIconInfoOfCM.setAccessible(true);
              mComposedIconInfoOfCM.set(this.mResources, null);
              this.mResources.getValue(paramInt, this.c, true);
            }
            catch (Exception localException1)
            {
              try
              {
                mIconsOfCM.setAccessible(true);
                mComposedIconInfoOfCM.setAccessible(true);
                if (mIconsOfCM.get(this.mResources) == null) {
                  continue;
                }
                localObject1 = mComposedIconInfoOfCM.get(this.mResources);
                if (localObject1 == null) {
                  continue;
                }
                return null;
              }
              catch (Exception localException2)
              {
                return null;
              }
              localException1 = localException1;
              return null;
            }
          }
          localObject2 = this.c.string.toString();
          l locall = new l();
          locall.a = paramInt;
          locall.d = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
          locall.b = null;
          localObject2 = a(paramInt, this.mResources, locall);
          localObject5 = localObject2;
          if (localObject2 != null)
          {
            ((b)localObject2).i = locall;
            this.t.put(paramInt, new WeakReference(localObject2));
            localObject5 = localObject2;
          }
        }
        if (localObject5 != null)
        {
          localObject2 = ((b)localObject5).newDrawable(this.mResources);
          return localObject2;
        }
      }
      Object localObject4 = null;
      continue;
      label306:
      localObject4 = null;
    }
  }
  
  public int getDrawableDpi(String paramString)
  {
    String[] arrayOfString = e[this.w];
    int[] arrayOfInt = f[this.w];
    int i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      if (arrayOfString[i1].equals(paramString)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public String getSkinRootPath()
  {
    if (this.p) {
      return this.v;
    }
    return this.u;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.c)
      {
        a(this.q);
        Object localObject2 = this.B.get(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = this.A.get(paramString);
          break label63;
          return paramObject;
        }
      }
      label63:
      while (localObject1 != null)
      {
        paramObject = localObject1;
        break;
      }
    }
  }
  
  public File getThemeDirFile()
  {
    if (this.u != null) {
      return new File(this.u);
    }
    return null;
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    Object localObject;
    if (this.u != null)
    {
      localObject = (WeakReference)this.r.get(paramInt);
      if (localObject == null) {
        break label83;
      }
      localObject = (b)((WeakReference)localObject).get();
      if (localObject == null) {
        break label74;
      }
      if (((b)localObject).i.b == null) {
        break label83;
      }
      paramTypedValue.type = 16777215;
      paramTypedValue.string = ((b)localObject).i.b;
    }
    label74:
    label83:
    TypedValue localTypedValue;
    do
    {
      return;
      this.r.delete(paramInt);
      localObject = paramTypedValue.string.toString();
      localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
      localTypedValue = new TypedValue();
      localTypedValue.resourceId = paramInt;
      a(this.mResources, localTypedValue, (String)localObject, e[this.w], f[this.w]);
    } while (localTypedValue.string == null);
    paramTypedValue.type = 16777215;
    paramTypedValue.string = localTypedValue.string;
  }
  
  public int recordDpiFile(String paramString)
  {
    int[] arrayOfInt = f[this.w];
    String[] arrayOfString = e[this.w];
    int i2;
    if (this.u == null)
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= arrayOfInt.length) {
        break label107;
      }
      String str = this.u + arrayOfString[i1] + paramString;
      if (str.startsWith("/asset/")) {
        return -2;
      }
      i2 = i1;
      if (new File(str).exists()) {
        break;
      }
      i1 += 1;
    }
    label107:
    return -3;
  }
  
  /* Error */
  public Object[] releasePreloadDrawableCache()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: ldc_w 1243
    //   10: invokestatic 1247	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: ldc_w 1249
    //   16: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   19: astore 11
    //   21: aload 11
    //   23: iconst_1
    //   24: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   27: iload_2
    //   28: istore_3
    //   29: lload 7
    //   31: lstore 9
    //   33: aload_0
    //   34: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   37: ifnull +328 -> 365
    //   40: iload_2
    //   41: istore_3
    //   42: lload 7
    //   44: lstore 9
    //   46: aload_0
    //   47: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   50: getfield 1251	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   53: ifnull +312 -> 365
    //   56: aload_0
    //   57: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   60: getfield 1251	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   63: astore 12
    //   65: aload 12
    //   67: arraylength
    //   68: istore 4
    //   70: iconst_0
    //   71: istore_2
    //   72: iload_1
    //   73: istore_3
    //   74: lload 7
    //   76: lstore 9
    //   78: iload_2
    //   79: iload 4
    //   81: if_icmpge +284 -> 365
    //   84: aload 12
    //   86: iload_2
    //   87: aaload
    //   88: astore 13
    //   90: iconst_0
    //   91: istore_3
    //   92: lload 7
    //   94: lstore 9
    //   96: iload_3
    //   97: aload 13
    //   99: invokevirtual 850	android/util/LongSparseArray:size	()I
    //   102: if_icmpge +247 -> 349
    //   105: aload 13
    //   107: iload_3
    //   108: invokevirtual 854	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   111: checkcast 904	android/graphics/drawable/Drawable$ConstantState
    //   114: astore 14
    //   116: lload 9
    //   118: lstore 7
    //   120: aload 14
    //   122: ifnull +56 -> 178
    //   125: aload 14
    //   127: invokevirtual 1253	android/graphics/drawable/Drawable$ConstantState:newDrawable	()Landroid/graphics/drawable/Drawable;
    //   130: astore 14
    //   132: aload 14
    //   134: instanceof 1255
    //   137: ifeq +106 -> 243
    //   140: aload 14
    //   142: checkcast 1255	android/graphics/drawable/BitmapDrawable
    //   145: invokevirtual 1259	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   148: astore 14
    //   150: lload 9
    //   152: lstore 7
    //   154: aload 14
    //   156: ifnull +22 -> 178
    //   159: getstatic 131	android/os/Build$VERSION:SDK_INT	I
    //   162: bipush 12
    //   164: if_icmplt +55 -> 219
    //   167: lload 9
    //   169: aload 14
    //   171: invokevirtual 236	android/graphics/Bitmap:getByteCount	()I
    //   174: i2l
    //   175: ladd
    //   176: lstore 7
    //   178: iload_3
    //   179: iconst_1
    //   180: iadd
    //   181: istore_3
    //   182: iload_1
    //   183: iconst_1
    //   184: iadd
    //   185: istore_1
    //   186: lload 7
    //   188: lstore 9
    //   190: goto -94 -> 96
    //   193: astore 12
    //   195: aconst_null
    //   196: astore 11
    //   198: aload 12
    //   200: invokevirtual 1262	java/lang/NoSuchFieldException:printStackTrace	()V
    //   203: goto -176 -> 27
    //   206: astore 12
    //   208: aconst_null
    //   209: astore 11
    //   211: aload 12
    //   213: invokevirtual 1263	java/lang/ClassNotFoundException:printStackTrace	()V
    //   216: goto -189 -> 27
    //   219: aload 14
    //   221: invokevirtual 239	android/graphics/Bitmap:getRowBytes	()I
    //   224: istore 5
    //   226: lload 9
    //   228: aload 14
    //   230: invokevirtual 242	android/graphics/Bitmap:getHeight	()I
    //   233: iload 5
    //   235: imul
    //   236: i2l
    //   237: ladd
    //   238: lstore 7
    //   240: goto -62 -> 178
    //   243: aload 14
    //   245: instanceof 1265
    //   248: ifeq +92 -> 340
    //   251: aload 11
    //   253: ifnonnull +12 -> 265
    //   256: lload 9
    //   258: lconst_1
    //   259: ladd
    //   260: lstore 7
    //   262: goto -84 -> 178
    //   265: aload 11
    //   267: aload 14
    //   269: checkcast 1265	android/graphics/drawable/NinePatchDrawable
    //   272: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   275: astore 14
    //   277: lload 9
    //   279: lstore 7
    //   281: aload 14
    //   283: instanceof 1267
    //   286: ifeq -108 -> 178
    //   289: aload 14
    //   291: checkcast 1267	android/graphics/NinePatch
    //   294: astore 14
    //   296: aload 14
    //   298: invokevirtual 1270	android/graphics/NinePatch:getWidth	()I
    //   301: istore 5
    //   303: aload 14
    //   305: invokevirtual 1271	android/graphics/NinePatch:getHeight	()I
    //   308: istore 6
    //   310: lload 9
    //   312: iload 6
    //   314: iload 5
    //   316: imul
    //   317: i2l
    //   318: ladd
    //   319: lstore 7
    //   321: goto -143 -> 178
    //   324: astore 14
    //   326: aload 14
    //   328: invokevirtual 1272	java/lang/IllegalAccessException:printStackTrace	()V
    //   331: lload 9
    //   333: lconst_1
    //   334: ladd
    //   335: lstore 7
    //   337: goto -159 -> 178
    //   340: lload 9
    //   342: lconst_1
    //   343: ladd
    //   344: lstore 7
    //   346: goto -168 -> 178
    //   349: aload 13
    //   351: invokevirtual 1273	android/util/LongSparseArray:clear	()V
    //   354: iload_2
    //   355: iconst_1
    //   356: iadd
    //   357: istore_2
    //   358: lload 9
    //   360: lstore 7
    //   362: goto -290 -> 72
    //   365: iconst_2
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: iload_3
    //   372: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   375: aastore
    //   376: dup
    //   377: iconst_1
    //   378: lload 9
    //   380: invokestatic 1278	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   383: aastore
    //   384: areturn
    //   385: astore 12
    //   387: goto -176 -> 211
    //   390: astore 12
    //   392: goto -194 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	SkinEngine
    //   6	180	1	i1	int
    //   4	354	2	i2	int
    //   28	344	3	i3	int
    //   68	14	4	i4	int
    //   224	93	5	i5	int
    //   308	9	6	i6	int
    //   1	360	7	l1	long
    //   31	348	9	l2	long
    //   19	247	11	localField	Field
    //   63	22	12	arrayOfLongSparseArray	LongSparseArray[]
    //   193	6	12	localNoSuchFieldException1	java.lang.NoSuchFieldException
    //   206	6	12	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   385	1	12	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   390	1	12	localNoSuchFieldException2	java.lang.NoSuchFieldException
    //   88	262	13	localLongSparseArray	LongSparseArray
    //   114	190	14	localObject	Object
    //   324	3	14	localIllegalAccessException	java.lang.IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   7	21	193	java/lang/NoSuchFieldException
    //   7	21	206	java/lang/ClassNotFoundException
    //   265	277	324	java/lang/IllegalAccessException
    //   281	310	324	java/lang/IllegalAccessException
    //   21	27	385	java/lang/ClassNotFoundException
    //   21	27	390	java/lang/NoSuchFieldException
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.l = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.p)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramString == null) {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    for (;;)
    {
      paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
      if (SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
        Log.d("SkinEngine.switch", "[setSkinRootPath] done");
      }
      return true;
      String str = paramString;
      if (!paramString.endsWith("/")) {
        str = paramString + "/";
      }
      if (str.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File(str);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", str).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG) {
            Log.w("SkinEngine", "[setSkinRootPath] wrong skinPath: " + str);
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
  }
  
  /* Error */
  public void unInit()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   4: ifnull +39 -> 43
    //   7: ldc 220
    //   9: ldc_w 615
    //   12: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   15: astore_1
    //   16: aload_1
    //   17: iconst_1
    //   18: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   21: aload_1
    //   22: invokevirtual 1313	java/lang/reflect/Field:getDeclaringClass	()Ljava/lang/Class;
    //   25: invokevirtual 1316	java/lang/Class:isArray	()Z
    //   28: ifeq +54 -> 82
    //   31: aload_1
    //   32: aconst_null
    //   33: aload_0
    //   34: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   37: getfield 1251	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   40: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   43: ldc 220
    //   45: ldc_w 700
    //   48: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   51: astore_1
    //   52: aload_1
    //   53: iconst_1
    //   54: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   57: aload_1
    //   58: aload_0
    //   59: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   62: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 209	android/util/LongSparseArray
    //   68: astore_2
    //   69: aload_1
    //   70: aconst_null
    //   71: aload_0
    //   72: getfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   75: getfield 1318	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   78: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   81: return
    //   82: aload_1
    //   83: aconst_null
    //   84: aload_0
    //   85: getfield 631	com/tencent/theme/SkinEngine:x	Lcom/tencent/theme/g;
    //   88: getfield 1251	com/tencent/theme/g:b	[Landroid/util/LongSparseArray;
    //   91: iconst_0
    //   92: aaload
    //   93: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: goto -53 -> 43
    //   99: astore_1
    //   100: getstatic 113	com/tencent/theme/SkinEngine:DEBUG	Z
    //   103: ifeq -22 -> 81
    //   106: ldc 46
    //   108: ldc_w 1320
    //   111: aload_1
    //   112: invokestatic 717	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   115: pop
    //   116: return
    //   117: astore_1
    //   118: ldc 220
    //   120: ldc_w 705
    //   123: invokevirtual 613	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   126: astore_1
    //   127: aload_1
    //   128: iconst_1
    //   129: invokevirtual 457	java/lang/reflect/Field:setAccessible	(Z)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 247	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   137: invokevirtual 462	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: astore_2
    //   141: aload_2
    //   142: instanceof 673
    //   145: ifeq +16 -> 161
    //   148: aload_1
    //   149: aconst_null
    //   150: aload_0
    //   151: getfield 712	com/tencent/theme/SkinEngine:z	Lcom/tencent/theme/e;
    //   154: getfield 1323	com/tencent/theme/e:b	Landroid/util/SparseArray;
    //   157: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: return
    //   161: aload_2
    //   162: instanceof 209
    //   165: ifeq -84 -> 81
    //   168: aload_1
    //   169: aconst_null
    //   170: aload_0
    //   171: getfield 665	com/tencent/theme/SkinEngine:y	Lcom/tencent/theme/d;
    //   174: getfield 1318	com/tencent/theme/d:b	Landroid/util/LongSparseArray;
    //   177: invokevirtual 461	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   180: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SkinEngine
    //   15	68	1	localField1	Field
    //   99	13	1	localException1	Exception
    //   117	1	1	localException2	Exception
    //   126	43	1	localField2	Field
    //   68	94	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	43	99	java/lang/Exception
    //   82	96	99	java/lang/Exception
    //   118	160	99	java/lang/Exception
    //   161	180	99	java/lang/Exception
    //   43	81	117	java/lang/Exception
  }
  
  public void writeCacheFile(File paramFile)
    throws IOException
  {
    this.x.a(paramFile);
  }
  
  public static class BackupForOOMData
  {
    public int backFileResId;
    public Bitmap.Config inPreferredConfig;
    public int orgkFileResId;
    
    public BackupForOOMData(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.orgkFileResId = paramInt1;
      this.backFileResId = paramInt2;
      this.inPreferredConfig = paramConfig;
    }
  }
  
  private class a
    extends AsyncTask<Context, Void, Context>
  {
    private a() {}
    
    protected Context a(Context... paramVarArgs)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground start");
      }
      SkinEngine.this.a(paramVarArgs[0]);
      System.gc();
      Thread.yield();
      System.gc();
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.doInBackground done");
      }
      return paramVarArgs[0];
    }
    
    protected void a(Context paramContext)
    {
      if (SkinEngine.SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute start");
      }
      SkinEngine.a(SkinEngine.this, null);
      SkinEngine.a(SkinEngine.this, SkinEngine.a(SkinEngine.this));
      Intent localIntent = new Intent("com.tencent.qplus.THEME_INVALIDATE");
      localIntent.putExtra("pid", Process.myPid());
      paramContext.sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      if (SkinEngine.SWITCH_DEBUG)
      {
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute sendBroadcast(ACTION_THEME_INVALIDATE)");
        Log.d("SkinEngine.switch", "UpdateTask.onPostExecute done");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */