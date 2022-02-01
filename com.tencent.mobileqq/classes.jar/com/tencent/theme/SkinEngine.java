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
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
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
  public static final String KEY_THEME_FONT = "theme_font_root";
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
  static int g = 0;
  static int h = 1;
  static int i = 2;
  static int j = 3;
  static int k = 4;
  static int l = 5;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  private static SkinEngine o;
  private b A;
  private c B;
  private HashMap<String, Object> C;
  private HashMap<String, Object> D;
  private g E;
  private ISkinTint F;
  private final Object G = new Object();
  public HashMap<Integer, SkinEngine.BackupForOOMData> backupForOOMData;
  final TypedValue c = new TypedValue();
  TypedValue d = new TypedValue();
  SkinEngineHandler m;
  public Resources mResources;
  BroadcastReceiver n = new SkinEngine.1(this);
  private ReentrantReadWriteLock p = new ReentrantReadWriteLock();
  private ReentrantReadWriteLock q = new ReentrantReadWriteLock();
  private boolean r = false;
  private boolean s = true;
  private final LongSparseArray<WeakReference<BaseConstantState>> t = new LongSparseArray();
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> u = new LongSparseArray();
  private final LongSparseArray<WeakReference<BaseConstantState>> v = new LongSparseArray();
  private String w;
  private String x;
  private int y = k;
  private e z;
  
  static
  {
    boolean bool;
    if ((!"MNC".equals(Build.VERSION.CODENAME)) && (Build.VERSION.SDK_INT < 23)) {
      bool = false;
    } else {
      bool = true;
    }
    a = bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    b = bool;
    IS_PROBLEM_MIUI = false;
    mIconsOfCM = null;
    mComposedIconInfoOfCM = null;
    IS_PROBLEM_CM11 = false;
    mIconResourceID = null;
    Object localObject1 = { "drawable-xhdpi/", "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
    Object localObject2 = { "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-mdpi/", "drawable/" };
    String[] arrayOfString1 = { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/" };
    String[] arrayOfString2 = { "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
    e = new String[][] { localObject1, localObject2, arrayOfString1, { "drawable-ldpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable/" }, { "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" }, arrayOfString2 };
    localObject1 = new int[] { 160, 160, 240, 320, 480, 640 };
    localObject2 = new int[] { 120, 240, 320, 480, 640, 160 };
    f = new int[][] { { 320, 640, 480, 240, 160, 160 }, { 240, 320, 480, 640, 160, 160 }, localObject1, localObject2, { 480, 640, 320, 240, 160, 160 }, { 640, 480, 320, 240, 160, 160 } };
  }
  
  private static int a(Resources paramResources)
  {
    int i1 = paramResources.getDisplayMetrics().densityDpi;
    if (i1 <= 160) {
      return i;
    }
    if (i1 <= 240) {
      return h;
    }
    if (i1 <= 320) {
      return g;
    }
    if (i1 <= 480) {
      return k;
    }
    if (i1 <= 640) {
      return l;
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
  
  private int a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("skin_tab_icon_see")) || (paramString.contains("skin_tab_icon_conversation")) || (paramString.contains("skin_tab_icon_plugin")) || (paramString.contains("skin_tab_icon_contact")))) {
      return 1;
    }
    return 2;
  }
  
  private XmlResourceParser a(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (paramTypedValue.type == 3) {
      return this.mResources.getAssets().openXmlResourceParser(paramTypedValue.assetCookie, paramTypedValue.string.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Resource ID #0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append(" type #0x");
    localStringBuilder.append(Integer.toHexString(paramTypedValue.type));
    localStringBuilder.append(" is not valid");
    throw new Resources.NotFoundException(localStringBuilder.toString());
  }
  
  /* Error */
  private BaseConstantState a(int paramInt, Resources paramResources, SkinData paramSkinData, TypedValue paramTypedValue)
  {
    // Byte code:
    //   0: ldc_w 331
    //   3: astore 10
    //   5: new 333	android/graphics/Rect
    //   8: dup
    //   9: invokespecial 334	android/graphics/Rect:<init>	()V
    //   12: astore 24
    //   14: aload_3
    //   15: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   18: astore 8
    //   20: ldc 41
    //   22: astore 11
    //   24: aload 8
    //   26: ifnull +946 -> 972
    //   29: aload 8
    //   31: ldc_w 341
    //   34: invokevirtual 345	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: ifne +935 -> 972
    //   40: aload 11
    //   42: astore 9
    //   44: aload_0
    //   45: aload_2
    //   46: aload 8
    //   48: invokespecial 348	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 17
    //   53: aload 11
    //   55: astore 9
    //   57: new 350	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 351	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 13
    //   66: aload 11
    //   68: astore 9
    //   70: aload 13
    //   72: aload_3
    //   73: getfield 354	com/tencent/theme/SkinData:mInDensity	I
    //   76: putfield 357	android/graphics/BitmapFactory$Options:inDensity	I
    //   79: aload 11
    //   81: astore 9
    //   83: aload_3
    //   84: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   87: astore 12
    //   89: aload 11
    //   91: astore 9
    //   93: aload_0
    //   94: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   97: istore 7
    //   99: aload_2
    //   100: aconst_null
    //   101: aload 17
    //   103: aload 12
    //   105: aload 13
    //   107: aload 24
    //   109: iload 7
    //   111: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   114: astore 16
    //   116: ldc_w 331
    //   119: astore 10
    //   121: ldc 41
    //   123: astore 11
    //   125: ldc_w 341
    //   128: astore 9
    //   130: goto +664 -> 794
    //   133: astore 9
    //   135: ldc 41
    //   137: astore 15
    //   139: goto +702 -> 841
    //   142: astore 12
    //   144: goto +5 -> 149
    //   147: astore 12
    //   149: new 299	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   156: astore 9
    //   158: aload 9
    //   160: ldc_w 368
    //   163: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 9
    //   169: aload 8
    //   171: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 9
    //   177: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 14
    //   182: ldc 41
    //   184: astore 11
    //   186: aload 11
    //   188: astore 9
    //   190: aload 11
    //   192: iconst_1
    //   193: aload 14
    //   195: aload 12
    //   197: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload 11
    //   202: astore 9
    //   204: aload_0
    //   205: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   208: ifnull +1818 -> 2026
    //   211: aload 11
    //   213: astore 9
    //   215: aload_0
    //   216: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   219: aload 12
    //   221: aload_3
    //   222: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   225: iconst_1
    //   226: invokeinterface 381 4 0
    //   231: ifeq +1795 -> 2026
    //   234: aload 11
    //   236: astore 9
    //   238: aload 17
    //   240: invokevirtual 386	java/io/InputStream:close	()V
    //   243: aload 11
    //   245: astore 9
    //   247: aload_0
    //   248: aload_2
    //   249: aload 8
    //   251: invokespecial 348	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   254: astore 17
    //   256: aload 11
    //   258: astore 9
    //   260: aload_3
    //   261: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   264: astore 14
    //   266: aload 11
    //   268: astore 9
    //   270: aload_0
    //   271: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   274: istore 7
    //   276: aload_2
    //   277: aconst_null
    //   278: aload 17
    //   280: aload 14
    //   282: aload 13
    //   284: aload 24
    //   286: iload 7
    //   288: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   291: astore 16
    //   293: ldc_w 331
    //   296: astore 10
    //   298: ldc_w 341
    //   301: astore 9
    //   303: goto +491 -> 794
    //   306: ldc_w 341
    //   309: astore 9
    //   311: astore 11
    //   313: ldc 41
    //   315: astore 15
    //   317: aload 8
    //   319: astore 12
    //   321: aload 11
    //   323: astore 8
    //   325: aload 9
    //   327: astore 13
    //   329: aload 10
    //   331: astore 14
    //   333: goto +526 -> 859
    //   336: astore 11
    //   338: goto +5 -> 343
    //   341: astore 11
    //   343: ldc 41
    //   345: astore 16
    //   347: ldc_w 341
    //   350: astore 9
    //   352: new 299	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   359: astore 14
    //   361: aload 14
    //   363: ldc_w 388
    //   366: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 14
    //   372: aload 8
    //   374: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 14
    //   380: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 14
    //   385: aload 16
    //   387: iconst_1
    //   388: aload 14
    //   390: aload 12
    //   392: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload_0
    //   396: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   399: aload 11
    //   401: aload_3
    //   402: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   405: iconst_1
    //   406: invokeinterface 391 4 0
    //   411: ifeq +362 -> 773
    //   414: aload 13
    //   416: astore 20
    //   418: aload 20
    //   420: iconst_1
    //   421: putfield 394	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   424: aload 17
    //   426: invokevirtual 386	java/io/InputStream:close	()V
    //   429: aload_0
    //   430: aload_2
    //   431: aload 8
    //   433: invokespecial 348	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   436: astore 22
    //   438: aload_3
    //   439: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   442: astore 15
    //   444: aload_0
    //   445: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   448: istore 7
    //   450: aload 16
    //   452: astore 11
    //   454: aload 8
    //   456: astore 14
    //   458: aload 10
    //   460: astore 13
    //   462: aload 9
    //   464: astore 12
    //   466: aload_2
    //   467: aconst_null
    //   468: aload 22
    //   470: aload 15
    //   472: aload 20
    //   474: aload 24
    //   476: iload 7
    //   478: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   481: astore 23
    //   483: aload 8
    //   485: astore 14
    //   487: aload 10
    //   489: astore 13
    //   491: aload 9
    //   493: astore 12
    //   495: aload_0
    //   496: getfield 396	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   499: ifnull +1398 -> 1897
    //   502: aload 8
    //   504: astore 14
    //   506: aload 10
    //   508: astore 13
    //   510: aload 9
    //   512: astore 12
    //   514: aload_0
    //   515: getfield 396	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   518: iload_1
    //   519: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: invokevirtual 405	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   525: ifeq +1372 -> 1897
    //   528: aload 8
    //   530: astore 14
    //   532: aload 10
    //   534: astore 13
    //   536: aload 9
    //   538: astore 12
    //   540: aload_0
    //   541: getfield 396	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   544: iload_1
    //   545: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: invokevirtual 409	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: ifnull +1346 -> 1897
    //   554: iconst_1
    //   555: istore 5
    //   557: goto +3 -> 560
    //   560: iload 5
    //   562: ifeq +1393 -> 1955
    //   565: aload 8
    //   567: astore 14
    //   569: aload 10
    //   571: astore 13
    //   573: aload 9
    //   575: astore 12
    //   577: aload_0
    //   578: getfield 396	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   581: iload_1
    //   582: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: invokevirtual 409	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   588: checkcast 411	com/tencent/theme/SkinEngine$BackupForOOMData
    //   591: astore 25
    //   593: aload 8
    //   595: astore 14
    //   597: aload 10
    //   599: astore 13
    //   601: aload 9
    //   603: astore 12
    //   605: aload 20
    //   607: getfield 414	android/graphics/BitmapFactory$Options:outWidth	I
    //   610: bipush 8
    //   612: idiv
    //   613: aload 20
    //   615: getfield 417	android/graphics/BitmapFactory$Options:outHeight	I
    //   618: bipush 8
    //   620: idiv
    //   621: invokestatic 423	java/lang/Math:min	(II)I
    //   624: bipush 8
    //   626: invokestatic 426	java/lang/Math:max	(II)I
    //   629: istore 5
    //   631: aconst_null
    //   632: astore 12
    //   634: iconst_2
    //   635: istore 6
    //   637: iload 6
    //   639: iload 5
    //   641: if_icmpgt +1287 -> 1928
    //   644: aload 8
    //   646: astore 14
    //   648: aload 10
    //   650: astore 13
    //   652: aload 9
    //   654: astore 12
    //   656: aload_0
    //   657: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   660: istore 7
    //   662: aload 10
    //   664: astore 17
    //   666: aload 9
    //   668: astore 18
    //   670: aload 8
    //   672: astore 19
    //   674: aload 19
    //   676: astore 12
    //   678: aload 18
    //   680: astore 13
    //   682: aload 17
    //   684: astore 14
    //   686: aload 11
    //   688: astore 15
    //   690: aload_0
    //   691: aload_2
    //   692: aload_3
    //   693: aload 20
    //   695: aload 24
    //   697: iload 7
    //   699: aload 25
    //   701: iload 6
    //   703: iconst_0
    //   704: invokevirtual 429	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/BaseConstantState;
    //   707: astore 21
    //   709: aload 21
    //   711: ifnull +1192 -> 1903
    //   714: aload 21
    //   716: astore 12
    //   718: goto +3 -> 721
    //   721: aload 12
    //   723: astore 13
    //   725: aload 12
    //   727: ifnonnull +1204 -> 1931
    //   730: aload 8
    //   732: astore 12
    //   734: aload 9
    //   736: astore 13
    //   738: aload 10
    //   740: astore 14
    //   742: aload 11
    //   744: astore 15
    //   746: aload_0
    //   747: aload_2
    //   748: aload_3
    //   749: aload 20
    //   751: aload 24
    //   753: aload_0
    //   754: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   757: aload 25
    //   759: iconst_1
    //   760: iconst_1
    //   761: invokevirtual 429	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/BaseConstantState;
    //   764: astore 16
    //   766: aload 16
    //   768: astore 13
    //   770: goto +1161 -> 1931
    //   773: aload 16
    //   775: astore 15
    //   777: ldc_w 331
    //   780: astore 14
    //   782: ldc_w 341
    //   785: astore 13
    //   787: aload 8
    //   789: astore 12
    //   791: aload 11
    //   793: athrow
    //   794: aload 8
    //   796: astore 12
    //   798: aload 9
    //   800: astore 13
    //   802: aload 10
    //   804: astore 14
    //   806: aload 11
    //   808: astore 15
    //   810: aload 17
    //   812: invokevirtual 386	java/io/InputStream:close	()V
    //   815: aload 16
    //   817: ifnull +6 -> 823
    //   820: aload 16
    //   822: areturn
    //   823: goto +163 -> 986
    //   826: astore 8
    //   828: goto +31 -> 859
    //   831: astore 10
    //   833: aload 9
    //   835: astore 15
    //   837: aload 10
    //   839: astore 9
    //   841: ldc_w 331
    //   844: astore 14
    //   846: ldc_w 341
    //   849: astore 13
    //   851: aload 8
    //   853: astore 12
    //   855: aload 9
    //   857: astore 8
    //   859: getstatic 431	com/tencent/theme/SkinEngine:DEBUG	Z
    //   862: ifeq +52 -> 914
    //   865: new 299	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   872: astore 9
    //   874: aload 9
    //   876: ldc_w 433
    //   879: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: pop
    //   883: aload 9
    //   885: aload 12
    //   887: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload 9
    //   893: ldc_w 435
    //   896: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: pop
    //   900: aload 15
    //   902: aload 9
    //   904: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 440	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   910: pop
    //   911: goto +3 -> 914
    //   914: aload 15
    //   916: astore 11
    //   918: new 299	java/lang/StringBuilder
    //   921: dup
    //   922: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   925: astore 9
    //   927: aload 9
    //   929: ldc_w 442
    //   932: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload 9
    //   938: aload 12
    //   940: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload 11
    //   946: iconst_1
    //   947: aload 9
    //   949: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   952: aload 8
    //   954: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   957: aload 12
    //   959: astore 8
    //   961: aload 13
    //   963: astore 9
    //   965: aload 14
    //   967: astore 10
    //   969: goto +17 -> 986
    //   972: ldc_w 331
    //   975: astore 10
    //   977: ldc_w 341
    //   980: astore 9
    //   982: ldc 41
    //   984: astore 11
    //   986: aload_3
    //   987: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   990: aload 9
    //   992: invokevirtual 345	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   995: ifeq +252 -> 1247
    //   998: aload_0
    //   999: iload_1
    //   1000: aload 4
    //   1002: invokespecial 444	com/tencent/theme/SkinEngine:a	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   1005: astore 9
    //   1007: aload 8
    //   1009: ifnull +81 -> 1090
    //   1012: aload_0
    //   1013: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   1016: ifeq +15 -> 1031
    //   1019: new 446	com/tencent/theme/AndroidXmlResourceParser
    //   1022: dup
    //   1023: invokespecial 447	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   1026: astore 4
    //   1028: goto +8 -> 1036
    //   1031: invokestatic 453	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   1034: astore 4
    //   1036: new 455	java/io/FileInputStream
    //   1039: dup
    //   1040: aload 8
    //   1042: invokespecial 456	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1045: astore 10
    //   1047: aload 4
    //   1049: aload 10
    //   1051: ldc_w 458
    //   1054: invokeinterface 464 3 0
    //   1059: aload_0
    //   1060: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   1063: istore 7
    //   1065: aload_2
    //   1066: aload 9
    //   1068: aload 4
    //   1070: iload 7
    //   1072: invokestatic 467	com/tencent/theme/ResourcesFactory:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/BaseConstantState;
    //   1075: astore_2
    //   1076: aload 10
    //   1078: invokevirtual 468	java/io/FileInputStream:close	()V
    //   1081: aload 9
    //   1083: invokeinterface 471 1 0
    //   1088: aload_2
    //   1089: areturn
    //   1090: aload_0
    //   1091: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   1094: istore 7
    //   1096: aload_2
    //   1097: aload 9
    //   1099: aconst_null
    //   1100: iload 7
    //   1102: invokestatic 467	com/tencent/theme/ResourcesFactory:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/BaseConstantState;
    //   1105: astore_2
    //   1106: aload 9
    //   1108: invokeinterface 471 1 0
    //   1113: aload_0
    //   1114: aload_2
    //   1115: aload_3
    //   1116: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1119: invokespecial 474	com/tencent/theme/SkinEngine:a	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   1122: aload_2
    //   1123: areturn
    //   1124: astore_2
    //   1125: goto +8 -> 1133
    //   1128: astore_2
    //   1129: goto +4 -> 1133
    //   1132: astore_2
    //   1133: new 299	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1140: astore 4
    //   1142: aload 4
    //   1144: ldc_w 476
    //   1147: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: pop
    //   1151: aload 4
    //   1153: aload 8
    //   1155: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload 11
    //   1161: iconst_1
    //   1162: aload 4
    //   1164: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1167: aload_2
    //   1168: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1171: getstatic 431	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1174: ifne +5 -> 1179
    //   1177: aconst_null
    //   1178: areturn
    //   1179: new 299	java/lang/StringBuilder
    //   1182: dup
    //   1183: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1186: astore 4
    //   1188: aload 4
    //   1190: ldc_w 478
    //   1193: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 4
    //   1199: aload_3
    //   1200: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1203: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 4
    //   1209: ldc_w 480
    //   1212: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload 4
    //   1218: iload_1
    //   1219: invokestatic 312	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1222: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: new 318	android/content/res/Resources$NotFoundException
    //   1229: dup
    //   1230: aload 4
    //   1232: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: invokespecial 322	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1238: astore_3
    //   1239: aload_3
    //   1240: aload_2
    //   1241: invokevirtual 484	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1244: pop
    //   1245: aload_3
    //   1246: athrow
    //   1247: getstatic 139	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   1250: ifeq +85 -> 1335
    //   1253: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1256: iconst_1
    //   1257: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   1260: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1263: aload_0
    //   1264: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1267: aconst_null
    //   1268: invokevirtual 494	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1271: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1274: iconst_1
    //   1275: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   1278: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1281: aload_0
    //   1282: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1285: aconst_null
    //   1286: invokevirtual 494	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1289: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1292: iconst_1
    //   1293: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   1296: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1299: iconst_1
    //   1300: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   1303: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1306: aload_0
    //   1307: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1310: invokevirtual 495	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1313: ifnull +22 -> 1335
    //   1316: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1319: aload_0
    //   1320: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1323: invokevirtual 495	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1326: astore 8
    //   1328: aload 8
    //   1330: ifnull +5 -> 1335
    //   1333: aconst_null
    //   1334: areturn
    //   1335: aload_2
    //   1336: iload_1
    //   1337: aload 4
    //   1339: invokevirtual 499	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1342: astore 8
    //   1344: aload 4
    //   1346: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   1349: invokeinterface 291 1 0
    //   1354: astore 13
    //   1356: new 350	android/graphics/BitmapFactory$Options
    //   1359: dup
    //   1360: invokespecial 351	android/graphics/BitmapFactory$Options:<init>	()V
    //   1363: astore 14
    //   1365: aload_2
    //   1366: aload 4
    //   1368: aload 8
    //   1370: aload 13
    //   1372: aload 14
    //   1374: aload 24
    //   1376: iconst_1
    //   1377: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1380: astore 9
    //   1382: aload 8
    //   1384: astore_2
    //   1385: aload 9
    //   1387: astore 4
    //   1389: goto +262 -> 1651
    //   1392: astore_2
    //   1393: goto +319 -> 1712
    //   1396: astore 15
    //   1398: new 299	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1405: astore 9
    //   1407: aload 9
    //   1409: aload 10
    //   1411: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 9
    //   1417: aload_3
    //   1418: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1421: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: pop
    //   1425: aload 11
    //   1427: iconst_1
    //   1428: aload 9
    //   1430: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: aload 15
    //   1435: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1438: aload_0
    //   1439: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   1442: ifnull +600 -> 2042
    //   1445: aload_0
    //   1446: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   1449: aload 15
    //   1451: aload_3
    //   1452: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1455: iconst_0
    //   1456: invokeinterface 381 4 0
    //   1461: ifeq +581 -> 2042
    //   1464: aload 8
    //   1466: invokevirtual 386	java/io/InputStream:close	()V
    //   1469: aload_2
    //   1470: iload_1
    //   1471: aload 4
    //   1473: invokevirtual 499	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1476: astore 9
    //   1478: aload 9
    //   1480: astore 8
    //   1482: aload_2
    //   1483: aload 4
    //   1485: aload 9
    //   1487: aload 13
    //   1489: aload 14
    //   1491: aload 24
    //   1493: iconst_1
    //   1494: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1497: astore 12
    //   1499: aload 12
    //   1501: astore 4
    //   1503: aload 9
    //   1505: astore_2
    //   1506: goto -117 -> 1389
    //   1509: astore 12
    //   1511: aload 9
    //   1513: astore 8
    //   1515: new 299	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1522: astore 16
    //   1524: aload 9
    //   1526: astore 8
    //   1528: aload 16
    //   1530: aload 10
    //   1532: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 9
    //   1538: astore 8
    //   1540: aload 16
    //   1542: aload_3
    //   1543: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1546: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: aload 9
    //   1552: astore 8
    //   1554: aload 11
    //   1556: iconst_1
    //   1557: aload 16
    //   1559: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: aload 15
    //   1564: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1567: aload 9
    //   1569: astore 8
    //   1571: aload_0
    //   1572: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   1575: aload 12
    //   1577: aload_3
    //   1578: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1581: iconst_0
    //   1582: invokeinterface 391 4 0
    //   1587: ifeq +57 -> 1644
    //   1590: aload 9
    //   1592: astore 8
    //   1594: aload 14
    //   1596: iconst_1
    //   1597: putfield 394	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1600: aload 9
    //   1602: astore 8
    //   1604: aload_2
    //   1605: iload_1
    //   1606: aload 4
    //   1608: invokevirtual 499	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1611: astore 9
    //   1613: aload_2
    //   1614: aload 4
    //   1616: aload 9
    //   1618: aload 13
    //   1620: aload 14
    //   1622: aload 24
    //   1624: iconst_1
    //   1625: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1628: astore 4
    //   1630: aload 9
    //   1632: astore_2
    //   1633: goto +18 -> 1651
    //   1636: astore_2
    //   1637: aload 9
    //   1639: astore 8
    //   1641: goto +71 -> 1712
    //   1644: aload 9
    //   1646: astore 8
    //   1648: aload 12
    //   1650: athrow
    //   1651: aload_2
    //   1652: astore 8
    //   1654: aload_2
    //   1655: invokevirtual 386	java/io/InputStream:close	()V
    //   1658: aload 4
    //   1660: ifnonnull +31 -> 1691
    //   1663: aload_2
    //   1664: astore 8
    //   1666: aload_0
    //   1667: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   1670: ifnull +21 -> 1691
    //   1673: aload_2
    //   1674: astore 8
    //   1676: aload_0
    //   1677: getfield 375	com/tencent/theme/SkinEngine:m	Lcom/tencent/theme/SkinEngineHandler;
    //   1680: aload_3
    //   1681: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1684: iconst_0
    //   1685: invokeinterface 503 3 0
    //   1690: pop
    //   1691: aload_2
    //   1692: astore 8
    //   1694: aload_0
    //   1695: aload 4
    //   1697: aload_3
    //   1698: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1701: invokespecial 474	com/tencent/theme/SkinEngine:a	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   1704: aload 4
    //   1706: areturn
    //   1707: astore_2
    //   1708: goto +4 -> 1712
    //   1711: astore_2
    //   1712: new 299	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1719: astore 4
    //   1721: aload 4
    //   1723: ldc_w 505
    //   1726: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: aload 4
    //   1732: aload_3
    //   1733: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1736: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: pop
    //   1740: aload 11
    //   1742: iconst_1
    //   1743: aload 4
    //   1745: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1748: aload_2
    //   1749: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1752: getstatic 431	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1755: ifne +5 -> 1760
    //   1758: aconst_null
    //   1759: areturn
    //   1760: new 299	java/lang/StringBuilder
    //   1763: dup
    //   1764: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1767: astore 4
    //   1769: aload 4
    //   1771: ldc_w 478
    //   1774: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: pop
    //   1778: aload 4
    //   1780: aload_3
    //   1781: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1784: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: pop
    //   1788: aload 4
    //   1790: ldc_w 480
    //   1793: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: aload 4
    //   1799: iload_1
    //   1800: invokestatic 312	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1803: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: pop
    //   1807: aload 4
    //   1809: ldc_w 507
    //   1812: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1815: pop
    //   1816: aload 4
    //   1818: aload 8
    //   1820: invokevirtual 511	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1823: invokevirtual 516	java/lang/Class:getName	()Ljava/lang/String;
    //   1826: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: pop
    //   1830: new 318	android/content/res/Resources$NotFoundException
    //   1833: dup
    //   1834: aload 4
    //   1836: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1839: invokespecial 322	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1842: astore_3
    //   1843: aload_3
    //   1844: aload_2
    //   1845: invokevirtual 484	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1848: pop
    //   1849: aload_3
    //   1850: athrow
    //   1851: astore_2
    //   1852: new 299	java/lang/StringBuilder
    //   1855: dup
    //   1856: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   1859: astore 4
    //   1861: aload 4
    //   1863: ldc_w 518
    //   1866: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1869: pop
    //   1870: aload 4
    //   1872: aload_3
    //   1873: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1876: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: pop
    //   1880: aload 11
    //   1882: iconst_1
    //   1883: aload 4
    //   1885: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1888: aload_2
    //   1889: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1892: aconst_null
    //   1893: areturn
    //   1894: astore_2
    //   1895: aconst_null
    //   1896: areturn
    //   1897: iconst_0
    //   1898: istore 5
    //   1900: goto -1340 -> 560
    //   1903: iload 6
    //   1905: iconst_2
    //   1906: imul
    //   1907: istore 6
    //   1909: aload 19
    //   1911: astore 8
    //   1913: aload 18
    //   1915: astore 9
    //   1917: aload 17
    //   1919: astore 10
    //   1921: aload 21
    //   1923: astore 12
    //   1925: goto -1288 -> 637
    //   1928: goto -1207 -> 721
    //   1931: aload 8
    //   1933: astore 12
    //   1935: aload 9
    //   1937: astore 14
    //   1939: aload 10
    //   1941: astore 15
    //   1943: aload 13
    //   1945: ifnull +24 -> 1969
    //   1948: aload 13
    //   1950: astore 16
    //   1952: goto +33 -> 1985
    //   1955: ldc_w 331
    //   1958: astore 15
    //   1960: ldc_w 341
    //   1963: astore 14
    //   1965: aload 8
    //   1967: astore 12
    //   1969: aload 23
    //   1971: astore 16
    //   1973: aload 15
    //   1975: astore 10
    //   1977: aload 14
    //   1979: astore 9
    //   1981: aload 12
    //   1983: astore 8
    //   1985: aload 22
    //   1987: astore 17
    //   1989: goto -1195 -> 794
    //   1992: astore 8
    //   1994: aload 13
    //   1996: astore 10
    //   1998: aload 12
    //   2000: astore 9
    //   2002: goto +13 -> 2015
    //   2005: astore 11
    //   2007: aload 8
    //   2009: astore 14
    //   2011: aload 11
    //   2013: astore 8
    //   2015: aload 16
    //   2017: astore 15
    //   2019: aload 14
    //   2021: astore 12
    //   2023: goto -1698 -> 325
    //   2026: ldc_w 331
    //   2029: astore 10
    //   2031: ldc_w 341
    //   2034: astore 9
    //   2036: aconst_null
    //   2037: astore 16
    //   2039: goto -1245 -> 794
    //   2042: aconst_null
    //   2043: astore 4
    //   2045: aload 8
    //   2047: astore_2
    //   2048: goto -397 -> 1651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2051	0	this	SkinEngine
    //   0	2051	1	paramInt	int
    //   0	2051	2	paramResources	Resources
    //   0	2051	3	paramSkinData	SkinData
    //   0	2051	4	paramTypedValue	TypedValue
    //   555	1344	5	i1	int
    //   635	1273	6	i2	int
    //   97	1004	7	bool	boolean
    //   18	777	8	localObject1	Object
    //   826	26	8	localIOException1	IOException
    //   857	1127	8	localObject2	Object
    //   1992	16	8	localIOException2	IOException
    //   2013	33	8	localObject3	Object
    //   42	87	9	str1	String
    //   133	1	9	localIOException3	IOException
    //   156	1879	9	localObject4	Object
    //   3	800	10	str2	String
    //   831	7	10	localIOException4	IOException
    //   967	1063	10	localObject5	Object
    //   22	245	11	str3	String
    //   311	11	11	localIOException5	IOException
    //   336	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   341	59	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   452	1429	11	localObject6	Object
    //   2005	7	11	localIOException6	IOException
    //   87	17	12	str4	String
    //   142	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   147	73	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   319	1181	12	localObject7	Object
    //   1509	140	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1923	99	12	localObject8	Object
    //   64	1931	13	localObject9	Object
    //   180	1840	14	localObject10	Object
    //   137	778	15	localObject11	Object
    //   1396	167	15	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1941	77	15	localObject12	Object
    //   114	1924	16	localObject13	Object
    //   51	1937	17	localObject14	Object
    //   668	1246	18	localObject15	Object
    //   672	1238	19	localObject16	Object
    //   416	334	20	localObject17	Object
    //   707	1215	21	localBaseConstantState1	BaseConstantState
    //   436	1550	22	localInputStream	InputStream
    //   481	1489	23	localBaseConstantState2	BaseConstantState
    //   12	1611	24	localRect	Rect
    //   591	167	25	localBackupForOOMData	SkinEngine.BackupForOOMData
    // Exception table:
    //   from	to	target	type
    //   99	116	133	java/io/IOException
    //   149	182	133	java/io/IOException
    //   99	116	142	java/lang/OutOfMemoryError
    //   83	89	147	java/lang/OutOfMemoryError
    //   93	99	147	java/lang/OutOfMemoryError
    //   276	293	306	java/io/IOException
    //   352	385	306	java/io/IOException
    //   276	293	336	java/lang/OutOfMemoryError
    //   260	266	341	java/lang/OutOfMemoryError
    //   270	276	341	java/lang/OutOfMemoryError
    //   690	709	826	java/io/IOException
    //   746	766	826	java/io/IOException
    //   791	794	826	java/io/IOException
    //   810	815	826	java/io/IOException
    //   44	53	831	java/io/IOException
    //   57	66	831	java/io/IOException
    //   70	79	831	java/io/IOException
    //   83	89	831	java/io/IOException
    //   93	99	831	java/io/IOException
    //   190	200	831	java/io/IOException
    //   204	211	831	java/io/IOException
    //   215	234	831	java/io/IOException
    //   238	243	831	java/io/IOException
    //   247	256	831	java/io/IOException
    //   260	266	831	java/io/IOException
    //   270	276	831	java/io/IOException
    //   1096	1122	1124	java/lang/Exception
    //   1065	1088	1128	java/lang/Exception
    //   1090	1096	1128	java/lang/Exception
    //   998	1007	1132	java/lang/Exception
    //   1012	1028	1132	java/lang/Exception
    //   1031	1036	1132	java/lang/Exception
    //   1036	1065	1132	java/lang/Exception
    //   1365	1382	1392	java/io/IOException
    //   1398	1478	1392	java/io/IOException
    //   1365	1382	1396	java/lang/OutOfMemoryError
    //   1482	1499	1509	java/lang/OutOfMemoryError
    //   1613	1630	1636	java/io/IOException
    //   1482	1499	1707	java/io/IOException
    //   1515	1524	1707	java/io/IOException
    //   1528	1536	1707	java/io/IOException
    //   1540	1550	1707	java/io/IOException
    //   1554	1567	1707	java/io/IOException
    //   1571	1590	1707	java/io/IOException
    //   1594	1600	1707	java/io/IOException
    //   1604	1613	1707	java/io/IOException
    //   1648	1651	1707	java/io/IOException
    //   1654	1658	1707	java/io/IOException
    //   1666	1673	1707	java/io/IOException
    //   1676	1691	1707	java/io/IOException
    //   1694	1704	1707	java/io/IOException
    //   1356	1365	1711	java/io/IOException
    //   1335	1344	1851	java/lang/Exception
    //   1253	1289	1894	java/lang/Exception
    //   1289	1328	1894	java/lang/Exception
    //   466	483	1992	java/io/IOException
    //   495	502	1992	java/io/IOException
    //   514	528	1992	java/io/IOException
    //   540	554	1992	java/io/IOException
    //   577	593	1992	java/io/IOException
    //   605	631	1992	java/io/IOException
    //   656	662	1992	java/io/IOException
    //   385	414	2005	java/io/IOException
    //   418	450	2005	java/io/IOException
  }
  
  private SkinnableColorStateList a(int paramInt, Resources paramResources, SkinData paramSkinData)
  {
    synchronized (this.c)
    {
      Object localObject = paramSkinData.mFilePath;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool) {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = ResourcesFactory.a(this, paramResources, new File((String)localObject), this.s);
            return localSkinnableColorStateList;
          }
          catch (Exception localException)
          {
            if (DEBUG)
            {
              paramResources = new StringBuilder();
              paramResources.append("File ");
              paramResources.append((String)localObject);
              paramResources.append(" from Skin ColorState resource ID #0x");
              paramResources.append(Integer.toHexString(paramInt));
              paramResources = new Resources.NotFoundException(paramResources.toString());
              paramResources.initCause(localException);
              throw paramResources;
            }
          }
        }
      }
      paramSkinData = paramSkinData.mFileName;
      boolean bool = paramSkinData.endsWith(".xml");
      if (bool) {
        try
        {
          localObject = a(paramInt, this.c);
          paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
          if (this.F != null) {
            this.F.tintColorState(paramResources.getColors(), paramResources.getStateSpecs(), paramSkinData);
          }
          ((XmlResourceParser)localObject).close();
          return paramResources;
        }
        catch (Exception paramResources)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("File ");
          ((StringBuilder)localObject).append(paramSkinData);
          ((StringBuilder)localObject).append(" from Skin ColorList list resource ID #0x");
          ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
          paramSkinData = new Resources.NotFoundException(((StringBuilder)localObject).toString());
          paramSkinData.initCause(paramResources);
          throw paramSkinData;
        }
      }
      paramResources = new StringBuilder();
      paramResources.append("File ");
      paramResources.append(paramSkinData);
      paramResources.append(" from Skin ColorList resource ID #0x");
      paramResources.append(Integer.toHexString(paramInt));
      paramResources.append(": .xml extension required");
      throw new Resources.NotFoundException(paramResources.toString());
    }
  }
  
  private String a(Resources paramResources, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.w);
    ((StringBuilder)localObject).append("color/");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      if (!this.E.a())
      {
        if (this.E.b(paramString)) {
          return localObject;
        }
      }
      else
      {
        if (((String)localObject).startsWith("/asset/"))
        {
          paramResources.getAssets().open(((String)localObject).substring(7)).close();
          return localObject;
        }
        boolean bool = new File((String)localObject).exists();
        if (bool) {
          return localObject;
        }
      }
    }
    catch (IOException paramResources)
    {
      if (DEBUG) {
        Log.w("SkinEngine", paramResources);
      }
    }
    return null;
  }
  
  private HashMap<String, Object> a(XmlPullParser paramXmlPullParser)
  {
    int i1;
    do
    {
      i1 = paramXmlPullParser.next();
    } while ((i1 != 2) && (i1 != 1));
    if (i1 == 2)
    {
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
    paramXmlPullParser = new XmlPullParserException("No start tag found");
    for (;;)
    {
      throw paramXmlPullParser;
    }
  }
  
  private static void a()
  {
    if ("huawei".equalsIgnoreCase(Build.MANUFACTURER))
    {
      h.c("SkinEngine", 2, "clearSystemSelectorCache start", null);
      try
      {
        Object localObject1 = Class.forName("android.rms.iaware.AwareAppScheduleManager");
        ??? = ((Class)localObject1).getDeclaredMethod("getInstance", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredField("mDrawableCaches");
        ??? = ((Method)???).invoke(null, new Object[0]);
        ((Field)localObject1).setAccessible(true);
        synchronized ((SparseArray)((Field)localObject1).get(???))
        {
          ((SparseArray)???).clear();
          ((Field)localObject1).setAccessible(false);
          h.c("SkinEngine", 2, "clearSystemSelectorCache done", null);
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        h.a("SkinEngine", 1, "clearSystemSelectorCache fail", localException);
      }
    }
  }
  
  private void a(Resources paramResources, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, File paramFile)
  {
    if ((paramArrayOfInt == null) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      localObject1 = null;
    }
    try
    {
      bool = b;
      if (bool)
      {
        localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
        ((Field)localObject1).setAccessible(true);
        localObject4 = ((Field)localObject1).get(paramResources);
      }
    }
    catch (IllegalAccessException paramResources)
    {
      boolean bool;
      Object localObject4;
      Object localObject3;
      Object localObject2;
      throw new UnSupportPlatformException(paramResources);
    }
    catch (NoSuchFieldException paramResources)
    {
      throw new UnSupportPlatformException(paramResources);
    }
    catch (IllegalArgumentException paramResources)
    {
      label72:
      paramResources = new UnSupportPlatformException(paramResources);
      for (;;)
      {
        throw paramResources;
      }
    }
    try
    {
      localObject1 = localObject4.getClass().getDeclaredField("sPreloadedDrawables");
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label72;
      paramInt1 = 0;
      break label410;
    }
    Object localObject1 = localObject4.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject3 = ((Field)localObject1).get(localObject4);
    localObject2 = localObject1;
    localObject1 = localObject4;
    break label141;
    localObject2 = Resources.class.getDeclaredField("sPreloadedDrawables");
    ((Field)localObject2).setAccessible(true);
    localObject3 = ((Field)localObject2).get(paramResources);
    localObject1 = null;
    label141:
    if ((localObject3 instanceof LongSparseArray))
    {
      if (paramArrayOfInt != null)
      {
        this.E = e.a(this, paramResources);
        this.E.b();
        this.z = new e(this, paramResources, paramArrayOfInt, paramFile, new LongSparseArray[] { (LongSparseArray)localObject3 });
      }
      else
      {
        this.E = e.a(this, paramResources);
        this.E.b();
        this.z = new e(this, paramResources, paramInt1, paramInt2, paramInt3, paramFile, new LongSparseArray[] { (LongSparseArray)localObject3 });
      }
      if ((b) && (localObject1 != null)) {
        ((Field)localObject2).set(localObject1, new f(0, this.z));
      } else {
        ((Field)localObject2).set(paramResources, new f(0, this.z));
      }
    }
    else
    {
      localObject2 = localObject1;
      localObject1 = localObject2;
      if ((localObject3 instanceof LongSparseArray[]))
      {
        localObject3 = (LongSparseArray[])localObject3;
        if (paramArrayOfInt != null)
        {
          this.E = e.a(this, paramResources);
          this.E.b();
          this.z = new e(this, paramResources, paramArrayOfInt, paramFile, (LongSparseArray[])localObject3);
          break label1170;
        }
        this.E = e.a(this, paramResources);
        this.E.b();
        this.z = new e(this, paramResources, paramInt1, paramInt2, paramInt3, paramFile, (LongSparseArray[])localObject3);
        break label1170;
        for (;;)
        {
          label410:
          localObject1 = localObject2;
          if (paramInt1 >= localObject3.length) {
            break;
          }
          localObject3[paramInt1] = new f(paramInt1, this.z);
          paramInt1 += 1;
        }
      }
    }
    paramInt1 = Build.VERSION.SDK_INT;
    if (paramInt1 >= 23)
    {
      bool = "samsung".equalsIgnoreCase(Build.BRAND);
      if (bool) {
        try
        {
          paramArrayOfInt = Resources.class.getDeclaredField("mALDC");
          if (paramArrayOfInt != null)
          {
            paramArrayOfInt.setAccessible(true);
            paramArrayOfInt = paramArrayOfInt.get(this.mResources);
            if ((paramArrayOfInt != null) && ((paramArrayOfInt instanceof Map)))
            {
              ((Map)paramArrayOfInt).clear();
              h.c("SkinEngine", 2, "clear mALDC suss", null);
            }
            else
            {
              paramFile = new StringBuilder();
              paramFile.append("clear fail, mALDC type:");
              paramFile.append(paramArrayOfInt);
              h.c("SkinEngine", 1, paramFile.toString(), null);
            }
          }
          else
          {
            h.c("SkinEngine", 1, "clear fail, null == f", null);
          }
        }
        catch (Throwable paramArrayOfInt)
        {
          h.a("SkinEngine", 1, "clear mALDC Error", paramArrayOfInt);
        }
      }
    }
    h.c("SkinEngine", 2, "initIntercepter DrawablePreloadIntercepter ok", null);
    if ((paramInt4 != 0) && (paramInt5 != 0)) {
      for (;;)
      {
        try
        {
          if (b)
          {
            paramArrayOfInt = Resources.class.getDeclaredField("mResourcesImpl");
            paramArrayOfInt.setAccessible(true);
            localObject1 = paramArrayOfInt.get(paramResources);
          }
        }
        catch (Exception paramArrayOfInt)
        {
          paramFile = Resources.class.getDeclaredField("mPreloadedColorStateLists");
          paramFile.setAccessible(true);
          localObject1 = paramFile.get(paramResources);
          if ((localObject1 instanceof SparseArray))
          {
            this.B = new c(this, paramResources, (SparseArray)localObject1, paramInt4, paramInt5, paramInt6);
            paramFile.set(paramResources, this.B);
          }
          else if ((localObject1 instanceof LongSparseArray))
          {
            this.A = new b(this, paramResources, (LongSparseArray)localObject1, paramInt4, paramInt5, paramInt6);
            paramFile.set(paramResources, this.A);
          }
          else
          {
            throw new UnSupportPlatformException(paramArrayOfInt);
          }
        }
        try
        {
          paramArrayOfInt = localObject1.getClass().getDeclaredField("sPreloadedComplexColors");
        }
        catch (NoSuchFieldException paramArrayOfInt)
        {
          continue;
        }
        paramArrayOfInt = localObject1.getClass().getSuperclass().getDeclaredField("sPreloadedComplexColors");
        continue;
        paramArrayOfInt.setAccessible(true);
        paramFile = (LongSparseArray)paramArrayOfInt.get(localObject1);
        continue;
        paramArrayOfInt = Resources.class.getDeclaredField("sPreloadedColorStateLists");
        paramArrayOfInt.setAccessible(true);
        paramFile = (LongSparseArray)paramArrayOfInt.get(paramResources);
        if (a) {
          this.A = new d(this, paramResources, paramFile, paramInt4, paramInt5, paramInt6);
        } else {
          this.A = new b(this, paramResources, paramFile, paramInt4, paramInt5, paramInt6);
        }
        if ((b) && (localObject1 != null)) {
          paramArrayOfInt.set(localObject1, this.A);
        } else {
          paramArrayOfInt.set(paramResources, this.A);
        }
      }
    }
    h.c("SkinEngine", 2, "initIntercepter colorStateListPreloadIntercepter ok", null);
    try
    {
      paramArrayOfInt = paramResources.getClass();
      if (paramArrayOfInt.getName().equals("android.content.res.MiuiResources"))
      {
        paramArrayOfInt = paramArrayOfInt.getDeclaredField("sPreloadDrawableSources");
        paramArrayOfInt.setAccessible(true);
        if (paramArrayOfInt.get(paramResources) == null)
        {
          paramArrayOfInt.set(paramResources, new SparseArray());
          IS_PROBLEM_MIUI = true;
        }
      }
    }
    catch (Exception paramArrayOfInt)
    {
      if (DEBUG) {
        Log.e("SkinEngine", "", paramArrayOfInt);
      }
      IS_PROBLEM_MIUI = false;
    }
    try
    {
      mIconsOfCM = paramResources.getClass().getDeclaredField("mIcons");
      mIconsOfCM.setAccessible(true);
      paramArrayOfInt = mIconsOfCM;
    }
    catch (Exception paramResources)
    {
      label1096:
      label1099:
      label1102:
      break label1102;
    }
    try
    {
      paramArrayOfInt.set(paramResources, null);
      mIconsOfCM.setAccessible(false);
      mComposedIconInfoOfCM = paramResources.getClass().getDeclaredField("mComposedIconInfo");
      mComposedIconInfoOfCM.setAccessible(true);
      paramArrayOfInt = mComposedIconInfoOfCM;
    }
    catch (Exception paramResources)
    {
      break label1099;
    }
    try
    {
      paramArrayOfInt.set(paramResources, null);
      mComposedIconInfoOfCM.setAccessible(false);
      IS_PROBLEM_CM11 = true;
      return;
    }
    catch (Exception paramResources)
    {
      break label1096;
    }
    mIconsOfCM = null;
    mComposedIconInfoOfCM = null;
  }
  
  private void a(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Object localObject;
    if (!this.E.a())
    {
      paramResources = this.E.a(paramString);
      if (paramResources != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.w);
        ((StringBuilder)localObject).append(paramArrayOfString[paramResources.intValue()]);
        ((StringBuilder)localObject).append(paramString);
        paramTypedValue.string = ((StringBuilder)localObject).toString();
        paramTypedValue.density = paramArrayOfInt[paramResources.intValue()];
        return;
      }
      paramTypedValue.string = null;
      paramTypedValue.density = 0;
      return;
    }
    int i1 = 0;
    while (i1 < paramArrayOfInt.length) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.w);
        ((StringBuilder)localObject).append(paramArrayOfString[i1]);
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        if (((String)localObject).startsWith("/asset/"))
        {
          paramResources.getAssets().open(((String)localObject).substring(7)).close();
          paramTypedValue.string = ((CharSequence)localObject);
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
        if (new File((String)localObject).exists())
        {
          paramTypedValue.string = ((CharSequence)localObject);
          paramTypedValue.density = paramArrayOfInt[i1];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SkinEngine", localIOException);
        }
        i1 += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  private static void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    Rect localRect = paramDrawable.getBounds();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text view drawable bound: ");
    localStringBuilder.append(localRect);
    localStringBuilder.append("， drawable.getIntrinsicWidth()： ");
    localStringBuilder.append(paramDrawable.getIntrinsicWidth());
    localStringBuilder.append(", drawable.getIntrinsicHeight(): ");
    localStringBuilder.append(paramDrawable.getIntrinsicHeight());
    h.a("SkinEngine", 2, localStringBuilder.toString());
    if ((localRect.left == 0) && (localRect.right == 0) && (localRect.top == 0) && (localRect.bottom == 0)) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
  }
  
  private void a(TypedValue paramTypedValue)
  {
    synchronized (this.G)
    {
      if (this.d == null) {
        this.d = paramTypedValue;
      }
      return;
    }
  }
  
  private void a(BaseConstantState paramBaseConstantState)
  {
    Object localObject1 = paramBaseConstantState.skinData;
    Object localObject2 = ((SkinData)localObject1).mFilePath;
    Object localObject3;
    Object localObject4;
    int i1;
    if (this.w != null)
    {
      this.c.resourceId = ((SkinData)localObject1).mResourcesID;
      localObject3 = this.mResources;
      localObject4 = this.c;
      String str = ((SkinData)localObject1).mFileName;
      String[][] arrayOfString = e;
      i1 = this.y;
      a((Resources)localObject3, (TypedValue)localObject4, str, arrayOfString[i1], f[i1]);
      if (this.c.string != null)
      {
        ((SkinData)localObject1).mFilePath = this.c.string.toString();
        ((SkinData)localObject1).mInDensity = this.c.density;
      }
      else
      {
        ((SkinData)localObject1).mFilePath = null;
      }
    }
    else
    {
      ((SkinData)localObject1).mFilePath = null;
    }
    if (b(((SkinData)localObject1).mFileName))
    {
      i1 = a(((SkinData)localObject1).mFileName);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("SkinEngine reloadImage : cs -> ");
      ((StringBuilder)localObject3).append(paramBaseConstantState);
      ((StringBuilder)localObject3).append(",fileName -> ");
      ((StringBuilder)localObject3).append(((SkinData)localObject1).mFileName);
      ((StringBuilder)localObject3).append(", mFilePath -> ");
      ((StringBuilder)localObject3).append(((SkinData)localObject1).mFilePath);
      ((StringBuilder)localObject3).append(", oldFilePath -> ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", resourceID -> ");
      ((StringBuilder)localObject3).append(((SkinData)localObject1).mResourcesID);
      ((StringBuilder)localObject3).append("Current Thread:");
      ((StringBuilder)localObject3).append(Thread.currentThread().getName());
      ((StringBuilder)localObject3).append(", cacheSize: ");
      ((StringBuilder)localObject3).append(this.t.size());
      h.a("SkinEngine", i1, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 == null) && (((SkinData)localObject1).mFilePath == null) && (!((SkinData)localObject1).mFileName.endsWith(".xml")))
    {
      localObject3 = this.F;
      if ((localObject3 != null) && (!((ISkinTint)localObject3).isTint(((SkinData)localObject1).mFileName)))
      {
        if ((paramBaseConstantState instanceof SkinnableBitmapDrawable.a))
        {
          localObject1 = (SkinnableBitmapDrawable.a)paramBaseConstantState;
          if (((SkinnableBitmapDrawable.a)localObject1).d != null)
          {
            ((SkinnableBitmapDrawable.a)localObject1).d.setColorFilter(null);
            return;
          }
        }
        if ((paramBaseConstantState instanceof SkinnableNinePatchDrawable.a))
        {
          paramBaseConstantState = (SkinnableNinePatchDrawable.a)paramBaseConstantState;
          if (paramBaseConstantState.h != null) {
            paramBaseConstantState.h.setColorFilter(null);
          }
        }
        return;
      }
    }
    if ((paramBaseConstantState instanceof SkinnableBitmapDrawable.a))
    {
      paramBaseConstantState = (SkinnableBitmapDrawable.a)paramBaseConstantState;
      localObject3 = a(((SkinData)localObject1).mResourcesID, this.mResources, (SkinData)localObject1, this.c);
      if (localObject3 == null)
      {
        if (b(((SkinData)localObject1).mFileName))
        {
          i1 = a(((SkinData)localObject1).mFileName);
          paramBaseConstantState = new StringBuilder();
          paramBaseConstantState.append("SkinEngine reloadImage : _loadImage fail, fileName -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mFileName);
          paramBaseConstantState.append(", mFilePath -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
          paramBaseConstantState.append(", resourceID -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mResourcesID);
          paramBaseConstantState.append("Current Thread:");
          paramBaseConstantState.append(Thread.currentThread().getName());
          paramBaseConstantState.append(", cacheSize: ");
          paramBaseConstantState.append(this.t.size());
          h.a("SkinEngine", i1, paramBaseConstantState.toString());
        }
        if (!DEBUG) {
          return;
        }
        paramBaseConstantState = new StringBuilder();
        paramBaseConstantState.append("loadImage failed, file path: ");
        paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
        paramBaseConstantState.append(" , resource name:");
        paramBaseConstantState.append(((SkinData)localObject1).mFileName);
        throw new NullPointerException(paramBaseConstantState.toString());
      }
      if ((DEBUG) && ((localObject3 instanceof SkinnableNinePatchDrawable.a)))
      {
        paramBaseConstantState = new StringBuilder();
        paramBaseConstantState.append("error image, the resource Image is Bitmap, but the skin Image is 9-path, file path: ");
        paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
        paramBaseConstantState.append(" , resource name:");
        paramBaseConstantState.append(((SkinData)localObject1).mFileName);
        throw new IllegalArgumentException(paramBaseConstantState.toString());
      }
      if (b(((SkinData)localObject1).mFileName))
      {
        i1 = a(((SkinData)localObject1).mFileName);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("SkinEngine reloadImage : _loadImage success, fileName -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mFileName);
        ((StringBuilder)localObject4).append(", mFilePath -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mFilePath);
        ((StringBuilder)localObject4).append(", oldFilePath -> ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(", resourceID -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mResourcesID);
        ((StringBuilder)localObject4).append("Current Thread:");
        ((StringBuilder)localObject4).append(Thread.currentThread().getName());
        ((StringBuilder)localObject4).append(", cacheSize: ");
        ((StringBuilder)localObject4).append(this.t.size());
        h.a("SkinEngine", i1, ((StringBuilder)localObject4).toString());
      }
      localObject2 = (SkinnableBitmapDrawable.a)localObject3;
      paramBaseConstantState.a = ((SkinnableBitmapDrawable.a)localObject2).a;
      paramBaseConstantState.bitmapType = ((SkinnableBitmapDrawable.a)localObject2).bitmapType;
      paramBaseConstantState.hasProblem = ((SkinnableBitmapDrawable.a)localObject2).hasProblem;
      paramBaseConstantState.d = ((SkinnableBitmapDrawable.a)localObject2).d;
      paramBaseConstantState.mImageSizeWhenOOM = ((SkinnableBitmapDrawable.a)localObject2).mImageSizeWhenOOM;
      if ((paramBaseConstantState.h) || (((SkinnableBitmapDrawable.a)localObject2).h))
      {
        paramBaseConstantState.c = ((SkinnableBitmapDrawable.a)localObject2).c;
        paramBaseConstantState.e = ((SkinnableBitmapDrawable.a)localObject2).e;
        paramBaseConstantState.f = ((SkinnableBitmapDrawable.a)localObject2).f;
        paramBaseConstantState.h = true;
      }
      a((BaseConstantState)localObject2, ((SkinData)localObject1).mFileName);
      return;
    }
    if ((paramBaseConstantState instanceof SkinnableNinePatchDrawable.a))
    {
      paramBaseConstantState = (SkinnableNinePatchDrawable.a)paramBaseConstantState;
      localObject3 = a(((SkinData)localObject1).mResourcesID, this.mResources, (SkinData)localObject1, this.c);
      if (localObject3 == null)
      {
        if (b(((SkinData)localObject1).mFileName))
        {
          i1 = a(((SkinData)localObject1).mFileName);
          paramBaseConstantState = new StringBuilder();
          paramBaseConstantState.append("SkinEngine reloadImage : _loadImage fail, fileName -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mFileName);
          paramBaseConstantState.append(", mFilePath -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
          paramBaseConstantState.append(", resourceID -> ");
          paramBaseConstantState.append(((SkinData)localObject1).mResourcesID);
          paramBaseConstantState.append("Current Thread:");
          paramBaseConstantState.append(Thread.currentThread().getName());
          paramBaseConstantState.append(", cacheSize: ");
          paramBaseConstantState.append(this.t.size());
          h.a("SkinEngine", i1, paramBaseConstantState.toString());
        }
        if (!DEBUG) {
          return;
        }
        paramBaseConstantState = new StringBuilder();
        paramBaseConstantState.append("loadImage failed, file path: ");
        paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
        paramBaseConstantState.append(" , resource name:");
        paramBaseConstantState.append(((SkinData)localObject1).mFileName);
        throw new NullPointerException(paramBaseConstantState.toString());
      }
      if ((DEBUG) && ((localObject3 instanceof SkinnableBitmapDrawable.a)))
      {
        paramBaseConstantState = new StringBuilder();
        paramBaseConstantState.append("error image, the resource Image is 9-path, but the skin Image is Bitmap, did you compiled the 9-pathflie to apk and un-zip it? file path: ");
        paramBaseConstantState.append(((SkinData)localObject1).mFilePath);
        paramBaseConstantState.append(" , resource name:");
        paramBaseConstantState.append(((SkinData)localObject1).mFileName);
        throw new IllegalArgumentException(paramBaseConstantState.toString());
      }
      if (b(((SkinData)localObject1).mFileName))
      {
        i1 = a(((SkinData)localObject1).mFileName);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("SkinEngine reloadImage : _loadImage success, fileName -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mFileName);
        ((StringBuilder)localObject4).append(", mFilePath -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mFilePath);
        ((StringBuilder)localObject4).append(", oldFilePath -> ");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(", resourceID -> ");
        ((StringBuilder)localObject4).append(((SkinData)localObject1).mResourcesID);
        ((StringBuilder)localObject4).append("Current Thread:");
        ((StringBuilder)localObject4).append(Thread.currentThread().getName());
        ((StringBuilder)localObject4).append(", cacheSize: ");
        ((StringBuilder)localObject4).append(this.t.size());
        h.a("SkinEngine", i1, ((StringBuilder)localObject4).toString());
      }
      localObject2 = (SkinnableNinePatchDrawable.a)localObject3;
      paramBaseConstantState.mImageSizeWhenOOM = ((SkinnableNinePatchDrawable.a)localObject2).mImageSizeWhenOOM;
      paramBaseConstantState.a = ((SkinnableNinePatchDrawable.a)localObject2).a;
      paramBaseConstantState.h = ((SkinnableNinePatchDrawable.a)localObject2).h;
      paramBaseConstantState.c = paramBaseConstantState.b;
      paramBaseConstantState.b = ((SkinnableNinePatchDrawable.a)localObject2).b;
      paramBaseConstantState.g = ((SkinnableNinePatchDrawable.a)localObject2).g;
      paramBaseConstantState.hasProblem = ((SkinnableNinePatchDrawable.a)localObject2).hasProblem;
      a((BaseConstantState)localObject2, ((SkinData)localObject1).mFileName);
    }
  }
  
  private void a(BaseConstantState paramBaseConstantState, String paramString)
  {
    if ((this.F != null) && (paramBaseConstantState != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = null;
      if ((paramBaseConstantState instanceof SkinnableBitmapDrawable.a))
      {
        localObject1 = (SkinnableBitmapDrawable.a)paramBaseConstantState;
        if (((SkinnableBitmapDrawable.a)localObject1).d != null)
        {
          localObject1 = ((SkinnableBitmapDrawable.a)localObject1).d;
          break label78;
        }
      }
      Object localObject1 = localObject2;
      if ((paramBaseConstantState instanceof SkinnableNinePatchDrawable.a))
      {
        paramBaseConstantState = (SkinnableNinePatchDrawable.a)paramBaseConstantState;
        localObject1 = localObject2;
        if (paramBaseConstantState.a != null) {
          localObject1 = paramBaseConstantState.h;
        }
      }
      label78:
      this.F.tint((Paint)localObject1, paramString);
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 989	com/tencent/theme/SkinEngine:C	Ljava/util/HashMap;
    //   4: ifnonnull +69 -> 73
    //   7: aload_0
    //   8: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   11: invokevirtual 278	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 991
    //   17: invokevirtual 994	android/content/res/AssetManager:openXmlResourceParser	(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   20: astore_2
    //   21: aload_0
    //   22: aload_0
    //   23: aload_2
    //   24: invokespecial 996	com/tencent/theme/SkinEngine:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/HashMap;
    //   27: putfield 989	com/tencent/theme/SkinEngine:C	Ljava/util/HashMap;
    //   30: aload_2
    //   31: invokeinterface 471 1 0
    //   36: goto +37 -> 73
    //   39: aload_0
    //   40: new 402	java/util/HashMap
    //   43: dup
    //   44: invokespecial 594	java/util/HashMap:<init>	()V
    //   47: putfield 989	com/tencent/theme/SkinEngine:C	Ljava/util/HashMap;
    //   50: goto +23 -> 73
    //   53: astore_2
    //   54: new 318	android/content/res/Resources$NotFoundException
    //   57: dup
    //   58: ldc_w 998
    //   61: invokespecial 322	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 484	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   70: pop
    //   71: aload_3
    //   72: athrow
    //   73: aload_0
    //   74: getfield 588	com/tencent/theme/SkinEngine:D	Ljava/util/HashMap;
    //   77: ifnonnull +119 -> 196
    //   80: aload_0
    //   81: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   84: ifnonnull +15 -> 99
    //   87: aload_0
    //   88: new 402	java/util/HashMap
    //   91: dup
    //   92: invokespecial 594	java/util/HashMap:<init>	()V
    //   95: putfield 588	com/tencent/theme/SkinEngine:D	Ljava/util/HashMap;
    //   98: return
    //   99: iload_1
    //   100: ifeq +14 -> 114
    //   103: new 446	com/tencent/theme/AndroidXmlResourceParser
    //   106: dup
    //   107: invokespecial 447	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   110: astore_2
    //   111: goto +7 -> 118
    //   114: invokestatic 453	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   117: astore_2
    //   118: new 455	java/io/FileInputStream
    //   121: dup
    //   122: new 521	java/io/File
    //   125: dup
    //   126: aload_0
    //   127: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   130: ldc_w 1000
    //   133: invokespecial 1003	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: invokespecial 1006	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore_3
    //   140: aload_2
    //   141: aload_3
    //   142: ldc_w 458
    //   145: invokeinterface 464 3 0
    //   150: aload_0
    //   151: aload_0
    //   152: aload_2
    //   153: invokespecial 996	com/tencent/theme/SkinEngine:a	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/HashMap;
    //   156: putfield 588	com/tencent/theme/SkinEngine:D	Ljava/util/HashMap;
    //   159: aload_3
    //   160: invokevirtual 468	java/io/FileInputStream:close	()V
    //   163: return
    //   164: aload_0
    //   165: new 402	java/util/HashMap
    //   168: dup
    //   169: invokespecial 594	java/util/HashMap:<init>	()V
    //   172: putfield 588	com/tencent/theme/SkinEngine:D	Ljava/util/HashMap;
    //   175: return
    //   176: astore_2
    //   177: new 318	android/content/res/Resources$NotFoundException
    //   180: dup
    //   181: ldc_w 1008
    //   184: invokespecial 322	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   187: astore_3
    //   188: aload_3
    //   189: aload_2
    //   190: invokevirtual 484	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   193: pop
    //   194: aload_3
    //   195: athrow
    //   196: return
    //   197: astore_2
    //   198: goto -159 -> 39
    //   201: astore_2
    //   202: goto -38 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	SkinEngine
    //   0	205	1	paramBoolean	boolean
    //   20	11	2	localXmlResourceParser	XmlResourceParser
    //   53	14	2	localXmlPullParserException1	XmlPullParserException
    //   110	43	2	localObject1	Object
    //   176	14	2	localXmlPullParserException2	XmlPullParserException
    //   197	1	2	localIOException1	IOException
    //   201	1	2	localIOException2	IOException
    //   64	131	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	36	53	org/xmlpull/v1/XmlPullParserException
    //   103	111	176	org/xmlpull/v1/XmlPullParserException
    //   114	118	176	org/xmlpull/v1/XmlPullParserException
    //   118	163	176	org/xmlpull/v1/XmlPullParserException
    //   7	36	197	java/io/IOException
    //   103	111	201	java/io/IOException
    //   114	118	201	java/io/IOException
    //   118	163	201	java/io/IOException
  }
  
  private static void a(Drawable[] paramArrayOfDrawable)
  {
    int i2 = paramArrayOfDrawable.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a(paramArrayOfDrawable[i1]);
      i1 += 1;
    }
  }
  
  private InputStream b(Resources paramResources, String paramString)
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring(7);
      return paramResources.getAssets().open(paramString);
    }
    return new BufferedInputStream(new FileInputStream(new File(paramString)));
  }
  
  /* Error */
  @TargetApi(16)
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: new 1030	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 1031	java/util/ArrayList:<init>	()V
    //   17: astore 4
    //   19: iconst_0
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   25: invokevirtual 911	android/util/LongSparseArray:size	()I
    //   28: istore_2
    //   29: iload_1
    //   30: iload_2
    //   31: if_icmpge +81 -> 112
    //   34: aload_0
    //   35: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   38: iload_1
    //   39: invokevirtual 1035	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   42: checkcast 1037	java/lang/ref/WeakReference
    //   45: astore_3
    //   46: goto +16 -> 62
    //   49: astore_3
    //   50: ldc 41
    //   52: iconst_1
    //   53: ldc_w 1039
    //   56: aload_3
    //   57: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aconst_null
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull +108 -> 171
    //   66: aload_3
    //   67: invokevirtual 1042	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   70: checkcast 872	com/tencent/theme/BaseConstantState
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull +96 -> 171
    //   78: aload_3
    //   79: getfield 876	com/tencent/theme/BaseConstantState:skinData	Lcom/tencent/theme/SkinData;
    //   82: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   85: ldc_w 341
    //   88: invokevirtual 345	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   91: ifeq +13 -> 104
    //   94: aload 4
    //   96: aload_3
    //   97: invokevirtual 1045	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto +70 -> 171
    //   104: aload_0
    //   105: aload_3
    //   106: invokespecial 1047	com/tencent/theme/SkinEngine:a	(Lcom/tencent/theme/BaseConstantState;)V
    //   109: goto +62 -> 171
    //   112: aload 4
    //   114: invokevirtual 1051	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   117: astore_3
    //   118: aload_3
    //   119: invokeinterface 1056 1 0
    //   124: ifeq +32 -> 156
    //   127: aload_0
    //   128: aload_3
    //   129: invokeinterface 1058 1 0
    //   134: checkcast 872	com/tencent/theme/BaseConstantState
    //   137: invokespecial 1047	com/tencent/theme/SkinEngine:a	(Lcom/tencent/theme/BaseConstantState;)V
    //   140: goto -22 -> 118
    //   143: astore_3
    //   144: aload_0
    //   145: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   148: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   151: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   154: aload_3
    //   155: athrow
    //   156: aload_0
    //   157: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   160: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   163: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   166: return
    //   167: astore_3
    //   168: goto -12 -> 156
    //   171: iload_1
    //   172: iconst_1
    //   173: iadd
    //   174: istore_1
    //   175: goto -146 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	SkinEngine
    //   20	155	1	i1	int
    //   28	4	2	i2	int
    //   45	1	3	localWeakReference	WeakReference
    //   49	8	3	localClassCastException	java.lang.ClassCastException
    //   61	68	3	localObject1	Object
    //   143	12	3	localObject2	Object
    //   167	1	3	localException	Exception
    //   17	96	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   34	46	49	java/lang/ClassCastException
    //   10	19	143	finally
    //   21	29	143	finally
    //   34	46	143	finally
    //   50	60	143	finally
    //   66	74	143	finally
    //   78	101	143	finally
    //   104	109	143	finally
    //   112	118	143	finally
    //   118	140	143	finally
    //   10	19	167	java/lang/Exception
    //   21	29	167	java/lang/Exception
    //   34	46	167	java/lang/Exception
    //   50	60	167	java/lang/Exception
    //   66	74	167	java/lang/Exception
    //   78	101	167	java/lang/Exception
    //   104	109	167	java/lang/Exception
    //   112	118	167	java/lang/Exception
    //   118	140	167	java/lang/Exception
  }
  
  /* Error */
  @TargetApi(16)
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: iconst_0
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 218	com/tencent/theme/SkinEngine:u	Landroid/util/LongSparseArray;
    //   16: invokevirtual 911	android/util/LongSparseArray:size	()I
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge +197 -> 219
    //   25: aload_0
    //   26: getfield 218	com/tencent/theme/SkinEngine:u	Landroid/util/LongSparseArray;
    //   29: iload_2
    //   30: invokevirtual 1035	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   33: checkcast 1037	java/lang/ref/WeakReference
    //   36: astore_1
    //   37: goto +197 -> 234
    //   40: astore_1
    //   41: ldc 41
    //   43: iconst_1
    //   44: ldc_w 1064
    //   47: aload_1
    //   48: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   51: aconst_null
    //   52: astore_1
    //   53: goto +181 -> 234
    //   56: aload_1
    //   57: invokevirtual 1042	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   60: checkcast 529	com/tencent/theme/SkinnableColorStateList
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +134 -> 199
    //   68: aload_1
    //   69: getfield 1065	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   72: astore 4
    //   74: aload 4
    //   76: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   79: astore 5
    //   81: aload_0
    //   82: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   85: ifnull +42 -> 127
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   93: aload 4
    //   95: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   98: invokespecial 1067	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 6
    //   103: aload 6
    //   105: ifnull +13 -> 118
    //   108: aload 4
    //   110: aload 6
    //   112: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   115: goto +18 -> 133
    //   118: aload 4
    //   120: aconst_null
    //   121: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   124: goto +9 -> 133
    //   127: aload 4
    //   129: aconst_null
    //   130: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   133: aload 5
    //   135: ifnonnull +45 -> 180
    //   138: aload 4
    //   140: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   143: ifnonnull +37 -> 180
    //   146: aload_0
    //   147: getfield 535	com/tencent/theme/SkinEngine:F	Lcom/tencent/theme/ISkinTint;
    //   150: ifnull +49 -> 199
    //   153: aload_0
    //   154: getfield 535	com/tencent/theme/SkinEngine:F	Lcom/tencent/theme/ISkinTint;
    //   157: aload_1
    //   158: invokevirtual 539	com/tencent/theme/SkinnableColorStateList:getColors	()[I
    //   161: aload_1
    //   162: invokevirtual 543	com/tencent/theme/SkinnableColorStateList:getStateSpecs	()[[I
    //   165: aload_1
    //   166: getfield 1065	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   169: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   172: invokeinterface 549 4 0
    //   177: goto +22 -> 199
    //   180: aload_1
    //   181: aload_0
    //   182: aload 4
    //   184: getfield 879	com/tencent/theme/SkinData:mResourcesID	I
    //   187: aload_0
    //   188: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   191: aload 4
    //   193: invokespecial 1069	com/tencent/theme/SkinEngine:a	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;)Lcom/tencent/theme/SkinnableColorStateList;
    //   196: invokevirtual 1072	com/tencent/theme/SkinnableColorStateList:a	(Lcom/tencent/theme/SkinnableColorStateList;)V
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: istore_2
    //   203: goto -191 -> 12
    //   206: astore_1
    //   207: aload_0
    //   208: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   211: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   214: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   217: aload_1
    //   218: athrow
    //   219: aload_0
    //   220: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   223: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   226: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   229: return
    //   230: astore_1
    //   231: goto -12 -> 219
    //   234: aload_1
    //   235: ifnonnull -179 -> 56
    //   238: goto -39 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	SkinEngine
    //   0	241	1	paramContext	Context
    //   11	192	2	i1	int
    //   19	4	3	i2	int
    //   72	120	4	localSkinData	SkinData
    //   79	55	5	str1	String
    //   101	10	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   25	37	40	java/lang/ClassCastException
    //   12	20	206	finally
    //   25	37	206	finally
    //   41	51	206	finally
    //   56	64	206	finally
    //   68	103	206	finally
    //   108	115	206	finally
    //   118	124	206	finally
    //   127	133	206	finally
    //   138	177	206	finally
    //   180	199	206	finally
    //   12	20	230	java/lang/Exception
    //   25	37	230	java/lang/Exception
    //   41	51	230	java/lang/Exception
    //   56	64	230	java/lang/Exception
    //   68	103	230	java/lang/Exception
    //   108	115	230	java/lang/Exception
    //   118	124	230	java/lang/Exception
    //   127	133	230	java/lang/Exception
    //   138	177	230	java/lang/Exception
    //   180	199	230	java/lang/Exception
  }
  
  private boolean b(String paramString)
  {
    return false;
  }
  
  private TypedValue c()
  {
    synchronized (this.G)
    {
      if (this.d != null)
      {
        localTypedValue = this.d;
        this.d = null;
      }
      TypedValue localTypedValue = this.d;
      ??? = localTypedValue;
      if (localTypedValue == null) {
        ??? = new TypedValue();
      }
      return ???;
    }
  }
  
  public static long dumpDrawableCacheMemSize()
  {
    SkinEngine localSkinEngine = getInstances();
    Object localObject1 = new TypedValue();
    long l2 = 0L;
    int i2 = 0;
    while (i2 < localSkinEngine.t.size())
    {
      Object localObject2 = (WeakReference)localSkinEngine.t.valueAt(i2);
      long l3 = localSkinEngine.t.keyAt(i2);
      long l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
        l1 = l2;
        if (localObject2 != null)
        {
          int i1;
          if ((localObject2 instanceof SkinnableBitmapDrawable.a)) {
            i1 = a(((SkinnableBitmapDrawable.a)localObject2).a);
          } else if ((localObject2 instanceof SkinnableNinePatchDrawable.a)) {
            i1 = a(((SkinnableNinePatchDrawable.a)localObject2).g);
          } else {
            i1 = 0;
          }
          l2 += i1;
          localSkinEngine.mResources.getValue((int)l3, (TypedValue)localObject1, true);
          l1 = l2;
          if (((TypedValue)localObject1).string != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("res:");
            ((StringBuilder)localObject2).append(((TypedValue)localObject1).string.toString());
            ((StringBuilder)localObject2).append(",size=");
            ((StringBuilder)localObject2).append(i1);
            h.d("SkinEngine", 4, ((StringBuilder)localObject2).toString(), null);
            l1 = l2;
          }
        }
      }
      i2 += 1;
      l2 = l1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Total DrawableNum=");
    ((StringBuilder)localObject1).append(localSkinEngine.t.size());
    ((StringBuilder)localObject1).append(",MemSize=");
    ((StringBuilder)localObject1).append(l2);
    h.c("SkinEngine", 4, ((StringBuilder)localObject1).toString(), null);
    return l2;
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (o == null) {
        o = new SkinEngine();
      }
      SkinEngine localSkinEngine = o;
      return localSkinEngine;
    }
    finally {}
  }
  
  public static void init(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init cacheFile:");
    boolean bool;
    if (paramFile == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    h.c("SkinEngine", 2, ((StringBuilder)localObject).toString(), null);
    localObject = getInstances();
    Resources localResources = paramContext.getResources();
    ((SkinEngine)localObject).mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    ((SkinEngine)localObject).y = a(((SkinEngine)localObject).mResources);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    ((SkinEngine)localObject).w = localSharedPreferences.getString("theme_root", null);
    ISkinTint localISkinTint = ((SkinEngine)localObject).F;
    if ((localISkinTint != null) && (((SkinEngine)localObject).w != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SkinEngine)localObject).w);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      localISkinTint.loadConfig(localResources, localStringBuilder.toString());
    }
    TextHook.getInstance().switchFont(paramContext, localSharedPreferences.getString("theme_font_root", null));
    paramContext.getApplicationContext().registerReceiver(((SkinEngine)localObject).n, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    ((SkinEngine)localObject).a(localResources, paramInt1, null, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFile);
    ((SkinEngine)localObject).s = localSharedPreferences.getBoolean("complied", true);
    a();
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, File paramFile)
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.y = a(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.n, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.a(localResources, 0, paramArrayOfInt, 0, 0, paramInt1, paramInt2, paramInt3, paramFile);
    paramArrayOfInt = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.w = paramArrayOfInt.getString("theme_root", null);
    paramFile = localSkinEngine.F;
    if ((paramFile != null) && (localSkinEngine.w != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSkinEngine.w);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      paramFile.loadConfig(localResources, localStringBuilder.toString());
    }
    TextHook.getInstance().switchFont(paramContext, paramArrayOfInt.getString("theme_font_root", null));
    localSkinEngine.s = paramArrayOfInt.getBoolean("complied", true);
    a();
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
      localObject1 = (ViewGroup)paramView;
      i2 = ((ViewGroup)localObject1).getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        invalidateAll(((ViewGroup)localObject1).getChildAt(i1));
        i1 += 1;
      }
    }
    Object localObject1 = paramView.getBackground();
    Object localObject2;
    if (localObject1 != null)
    {
      int i3;
      int i4;
      if ((localObject1 instanceof DrawableContainer))
      {
        localObject2 = new Rect();
        ((Drawable)localObject1).getPadding((Rect)localObject2);
        if ((((Rect)localObject2).left == paramView.getPaddingLeft()) && (((Rect)localObject2).right == paramView.getPaddingRight()) && (((Rect)localObject2).top == paramView.getPaddingTop()) && (((Rect)localObject2).bottom == paramView.getPaddingBottom()))
        {
          SkinnableActivityProcesser.a((Drawable)localObject1);
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
        }
        else
        {
          i1 = paramView.getPaddingTop();
          i2 = paramView.getPaddingBottom();
          i3 = paramView.getPaddingLeft();
          i4 = paramView.getPaddingRight();
          SkinnableActivityProcesser.a((Drawable)localObject1);
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
          paramView.setPadding(i3, i1, i4, i2);
        }
      }
      else if ((localObject1 instanceof SkinnableNinePatchDrawable))
      {
        localObject2 = new Rect();
        if ((((SkinnableNinePatchDrawable)localObject1).a((Rect)localObject2)) && (((Rect)localObject2).left == paramView.getPaddingLeft()) && (((Rect)localObject2).right == paramView.getPaddingRight()) && (((Rect)localObject2).top == paramView.getPaddingTop()) && (((Rect)localObject2).bottom == paramView.getPaddingBottom()))
        {
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
        }
        else
        {
          i1 = paramView.getPaddingTop();
          i2 = paramView.getPaddingBottom();
          i3 = paramView.getPaddingLeft();
          i4 = paramView.getPaddingRight();
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
          paramView.setPadding(i3, i1, i4, i2);
        }
      }
      else if ((localObject1 instanceof SkinnableBitmapDrawable))
      {
        paramView.setBackgroundDrawable(null);
        paramView.setBackgroundDrawable((Drawable)localObject1);
      }
    }
    if ((paramView instanceof SkinnableView)) {
      ((SkinnableView)paramView).onThemeChanged();
    }
    if ((paramView instanceof ImageView))
    {
      localObject1 = (ImageView)paramView;
      localObject2 = ((ImageView)localObject1).getDrawable();
      SkinnableActivityProcesser.a((Drawable)localObject2);
      ((ImageView)localObject1).setImageDrawable(null);
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
    }
    else if ((paramView instanceof TextView))
    {
      localObject1 = (TextView)paramView;
      localObject2 = ((TextView)localObject1).getCompoundDrawables();
      if ((localObject2[0] != null) || (localObject2[1] != null) || (localObject2[2] != null) || (localObject2[3] != null))
      {
        a((Drawable[])localObject2);
        ((TextView)localObject1).setCompoundDrawables(null, null, null, null);
        ((TextView)localObject1).setCompoundDrawables(localObject2[0], localObject2[1], localObject2[2], localObject2[3]);
      }
    }
    paramView.destroyDrawingCache();
    paramView.refreshDrawableState();
    paramView.invalidate();
    paramView.requestLayout();
  }
  
  public static void isSupportPlatform(Context paramContext, Resources paramResources)
  {
    try
    {
      bool = b;
      if (bool)
      {
        localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
        ((Field)localObject1).setAccessible(true);
        localObject2 = ((Field)localObject1).get(paramResources);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      boolean bool;
      Object localObject1;
      Object localObject2;
      throw new UnSupportPlatformException(paramContext);
    }
    catch (NoSuchFieldException paramContext)
    {
      label164:
      label214:
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalArgumentException paramContext)
    {
      label44:
      label94:
      throw new UnSupportPlatformException(paramContext);
    }
    try
    {
      localObject1 = localObject2.getClass().getDeclaredField("sPreloadedDrawables");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      break label44;
    }
    localObject1 = localObject2.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(localObject2);
    break label94;
    localObject1 = Resources.class.getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramResources);
    if ((!(localObject1 instanceof LongSparseArray)) && (!(localObject1 instanceof LongSparseArray[]))) {
      throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
    }
    try
    {
      if (b)
      {
        localObject1 = Resources.class.getDeclaredField("mResourcesImpl");
        ((Field)localObject1).setAccessible(true);
        localObject2 = ((Field)localObject1).get(paramResources);
      }
    }
    catch (Exception localException)
    {
      localObject2 = Resources.class.getDeclaredField("mPreloadedColorStateLists");
      ((Field)localObject2).setAccessible(true);
      paramResources = ((Field)localObject2).get(paramResources);
      if (!(paramResources instanceof SparseArray))
      {
        bool = paramResources instanceof LongSparseArray;
        if (!bool) {}
      }
      else
      {
        if (!j.a(paramContext, "ro.lewa.version").equalsIgnoreCase("LeWa_OS6.0_14.10.22")) {
          return;
        }
        throw new UnSupportPlatformException("lewa is not supported");
      }
    }
    try
    {
      localObject1 = localObject2.getClass().getDeclaredField("sPreloadedComplexColors");
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      break label164;
    }
    localObject1 = localObject2.getClass().getSuperclass().getDeclaredField("sPreloadedComplexColors");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(localObject2);
    break label214;
    localObject1 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramResources);
    if (!(localObject1 instanceof LongSparseArray)) {
      throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
    }
    throw new UnSupportPlatformException(localException);
  }
  
  public static void setSKLog(ISkinEngineLog paramISkinEngineLog)
  {
    h.a = paramISkinEngineLog;
    h.c("SkinEngine", 2, "set ISkinEngineLog ok", null);
  }
  
  /* Error */
  @TargetApi(16)
  Drawable.ConstantState a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1287	com/tencent/theme/SkinEngine:c	()Landroid/util/TypedValue;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1294	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   20: iload_1
    //   21: i2l
    //   22: invokevirtual 1297	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   25: checkcast 1037	java/lang/ref/WeakReference
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   34: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   37: invokevirtual 1298	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   40: goto +31 -> 71
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   52: invokevirtual 1298	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   55: aload 4
    //   57: athrow
    //   58: aload_0
    //   59: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   62: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   65: invokevirtual 1298	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   68: aconst_null
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +126 -> 199
    //   76: aload 4
    //   78: invokevirtual 1042	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   81: checkcast 1085	android/graphics/drawable/Drawable$ConstantState
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +12 -> 100
    //   91: aload_0
    //   92: aload 5
    //   94: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   97: aload 4
    //   99: areturn
    //   100: aload_0
    //   101: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   104: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   107: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   110: aload_0
    //   111: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   114: iload_1
    //   115: i2l
    //   116: invokevirtual 1304	android/util/LongSparseArray:delete	(J)V
    //   119: new 299	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: aload 4
    //   130: ldc_w 1306
    //   133: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: iload_1
    //   140: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 41
    //   146: iconst_1
    //   147: aload 4
    //   149: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 852	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   159: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   169: goto +30 -> 199
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   178: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   181: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   184: aload 4
    //   186: athrow
    //   187: aload_0
    //   188: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   191: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   194: astore 4
    //   196: goto -32 -> 164
    //   199: getstatic 139	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   202: istore_3
    //   203: iload_3
    //   204: ifeq +107 -> 311
    //   207: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   210: iconst_1
    //   211: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   214: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   217: aload_0
    //   218: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   221: aconst_null
    //   222: invokevirtual 494	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   225: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   228: iconst_1
    //   229: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   232: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   235: aload_0
    //   236: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   239: aconst_null
    //   240: invokevirtual 494	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   243: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   246: iconst_1
    //   247: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   250: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   253: iconst_1
    //   254: invokevirtual 490	java/lang/reflect/Field:setAccessible	(Z)V
    //   257: getstatic 135	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   260: aload_0
    //   261: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   264: invokevirtual 495	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: ifnull +44 -> 311
    //   270: getstatic 137	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   273: aload_0
    //   274: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   277: invokevirtual 495	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +27 -> 311
    //   287: aload_0
    //   288: aload 5
    //   290: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   293: aconst_null
    //   294: areturn
    //   295: aload_0
    //   296: aload 5
    //   298: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: aload 5
    //   306: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   309: aconst_null
    //   310: areturn
    //   311: aload_0
    //   312: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   315: iload_1
    //   316: aload 5
    //   318: iconst_1
    //   319: invokevirtual 271	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   322: aload 5
    //   324: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   327: astore 4
    //   329: aload 4
    //   331: ifnonnull +11 -> 342
    //   334: aload_0
    //   335: aload 5
    //   337: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   340: aconst_null
    //   341: areturn
    //   342: aload 5
    //   344: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   347: invokeinterface 291 1 0
    //   352: astore 4
    //   354: new 336	com/tencent/theme/SkinData
    //   357: dup
    //   358: invokespecial 1307	com/tencent/theme/SkinData:<init>	()V
    //   361: astore 6
    //   363: aload 6
    //   365: iload_1
    //   366: putfield 879	com/tencent/theme/SkinData:mResourcesID	I
    //   369: aload 6
    //   371: aload 4
    //   373: aload 4
    //   375: ldc_w 1309
    //   378: invokevirtual 1312	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   381: iconst_1
    //   382: iadd
    //   383: invokevirtual 575	java/lang/String:substring	(I)Ljava/lang/String;
    //   386: putfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   393: ifnull +67 -> 460
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   401: aload 5
    //   403: aload 6
    //   405: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   408: getstatic 159	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   411: aload_0
    //   412: getfield 202	com/tencent/theme/SkinEngine:y	I
    //   415: aaload
    //   416: getstatic 163	com/tencent/theme/SkinEngine:f	[[I
    //   419: aload_0
    //   420: getfield 202	com/tencent/theme/SkinEngine:y	I
    //   423: aaload
    //   424: invokespecial 884	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   427: aload 5
    //   429: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   432: ifnull +28 -> 460
    //   435: aload 6
    //   437: aload 5
    //   439: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   442: invokeinterface 291 1 0
    //   447: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   450: aload 6
    //   452: aload 5
    //   454: getfield 827	android/util/TypedValue:density	I
    //   457: putfield 354	com/tencent/theme/SkinData:mInDensity	I
    //   460: aload_0
    //   461: aload 6
    //   463: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   466: invokespecial 885	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   469: istore_3
    //   470: iload_3
    //   471: ifeq +128 -> 599
    //   474: aload_0
    //   475: aload 6
    //   477: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   480: invokespecial 887	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   483: istore_2
    //   484: new 299	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   491: astore 4
    //   493: aload 4
    //   495: ldc_w 1314
    //   498: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 4
    //   504: iload_1
    //   505: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: ldc_w 1316
    //   514: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 4
    //   520: aload 6
    //   522: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   525: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 4
    //   531: ldc_w 1318
    //   534: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 4
    //   540: aload 6
    //   542: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   545: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 4
    //   551: ldc_w 1320
    //   554: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: aload 5
    //   562: invokevirtual 767	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 4
    //   568: ldc_w 908
    //   571: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 4
    //   577: aload_0
    //   578: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   581: invokevirtual 911	android/util/LongSparseArray:size	()I
    //   584: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: ldc 41
    //   590: iload_2
    //   591: aload 4
    //   593: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 852	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_0
    //   600: iload_1
    //   601: aload_0
    //   602: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   605: aload 6
    //   607: aload 5
    //   609: invokespecial 931	com/tencent/theme/SkinEngine:a	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/util/TypedValue;)Lcom/tencent/theme/BaseConstantState;
    //   612: astore 7
    //   614: aload 7
    //   616: ifnull +277 -> 893
    //   619: aload 7
    //   621: aload 6
    //   623: putfield 876	com/tencent/theme/BaseConstantState:skinData	Lcom/tencent/theme/SkinData;
    //   626: aload_0
    //   627: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   630: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   633: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   636: aload_0
    //   637: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   640: iload_1
    //   641: i2l
    //   642: new 1037	java/lang/ref/WeakReference
    //   645: dup
    //   646: aload 7
    //   648: invokespecial 1323	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   651: invokevirtual 1326	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   654: aload_0
    //   655: aload 6
    //   657: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   660: invokespecial 885	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   663: ifeq +49 -> 712
    //   666: aload_0
    //   667: aload 6
    //   669: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   672: invokespecial 887	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   675: istore_2
    //   676: new 299	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   683: astore 4
    //   685: aload 4
    //   687: ldc_w 1328
    //   690: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 4
    //   696: iload_1
    //   697: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: ldc 41
    //   703: iload_2
    //   704: aload 4
    //   706: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 852	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_0
    //   713: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   716: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   719: astore 4
    //   721: aload 4
    //   723: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   726: goto +30 -> 756
    //   729: astore 4
    //   731: aload_0
    //   732: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   735: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   738: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   741: aload 4
    //   743: athrow
    //   744: aload_0
    //   745: getfield 192	com/tencent/theme/SkinEngine:p	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   748: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   751: astore 4
    //   753: goto -32 -> 721
    //   756: aload_0
    //   757: aload 6
    //   759: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   762: invokespecial 885	com/tencent/theme/SkinEngine:b	(Ljava/lang/String;)Z
    //   765: ifeq +128 -> 893
    //   768: aload_0
    //   769: aload 6
    //   771: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   774: invokespecial 887	com/tencent/theme/SkinEngine:a	(Ljava/lang/String;)I
    //   777: istore_2
    //   778: new 299	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   785: astore 4
    //   787: aload 4
    //   789: ldc_w 1330
    //   792: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload 4
    //   798: iload_1
    //   799: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 4
    //   805: ldc_w 1316
    //   808: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 4
    //   814: aload 6
    //   816: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   819: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload 4
    //   825: ldc_w 1318
    //   828: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload 4
    //   834: aload 6
    //   836: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   839: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload 4
    //   845: ldc_w 1320
    //   848: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 4
    //   854: aload 5
    //   856: invokevirtual 767	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload 4
    //   862: ldc_w 908
    //   865: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload 4
    //   871: aload_0
    //   872: getfield 216	com/tencent/theme/SkinEngine:t	Landroid/util/LongSparseArray;
    //   875: invokevirtual 911	android/util/LongSparseArray:size	()I
    //   878: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: ldc 41
    //   884: iload_2
    //   885: aload 4
    //   887: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokestatic 852	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   893: aload_0
    //   894: aload 5
    //   896: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   899: aload 7
    //   901: areturn
    //   902: astore 4
    //   904: aload_0
    //   905: aload 5
    //   907: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   910: aload 4
    //   912: athrow
    //   913: aload_0
    //   914: aload 5
    //   916: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   919: aconst_null
    //   920: areturn
    //   921: astore 4
    //   923: goto -10 -> 913
    //   926: astore 4
    //   928: goto -870 -> 58
    //   931: astore 4
    //   933: goto -746 -> 187
    //   936: astore 4
    //   938: goto -635 -> 303
    //   941: astore 4
    //   943: goto -648 -> 295
    //   946: astore 4
    //   948: goto -204 -> 744
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	951	0	this	SkinEngine
    //   0	951	1	paramInt	int
    //   483	402	2	i1	int
    //   202	269	3	bool	boolean
    //   28	1	4	localWeakReference	WeakReference
    //   43	13	4	localObject1	Object
    //   69	96	4	localObject2	Object
    //   172	13	4	localObject3	Object
    //   194	528	4	localObject4	Object
    //   729	13	4	localObject5	Object
    //   751	135	4	localObject6	Object
    //   902	9	4	localObject7	Object
    //   921	1	4	localNotFoundException	Resources.NotFoundException
    //   926	1	4	localException1	Exception
    //   931	1	4	localException2	Exception
    //   936	1	4	localException3	Exception
    //   941	1	4	localException4	Exception
    //   946	1	4	localException5	Exception
    //   4	911	5	localTypedValue	TypedValue
    //   361	474	6	localSkinData	SkinData
    //   612	288	7	localBaseConstantState	BaseConstantState
    // Exception table:
    //   from	to	target	type
    //   16	30	43	finally
    //   110	155	172	finally
    //   636	712	729	finally
    //   6	16	902	finally
    //   30	40	902	finally
    //   45	58	902	finally
    //   58	68	902	finally
    //   76	86	902	finally
    //   100	110	902	finally
    //   155	164	902	finally
    //   164	169	902	finally
    //   174	187	902	finally
    //   187	196	902	finally
    //   199	203	902	finally
    //   207	243	902	finally
    //   243	282	902	finally
    //   311	329	902	finally
    //   342	460	902	finally
    //   460	470	902	finally
    //   474	599	902	finally
    //   599	614	902	finally
    //   619	636	902	finally
    //   712	721	902	finally
    //   721	726	902	finally
    //   731	744	902	finally
    //   744	753	902	finally
    //   756	893	902	finally
    //   6	16	921	android/content/res/Resources$NotFoundException
    //   30	40	921	android/content/res/Resources$NotFoundException
    //   45	58	921	android/content/res/Resources$NotFoundException
    //   58	68	921	android/content/res/Resources$NotFoundException
    //   76	86	921	android/content/res/Resources$NotFoundException
    //   100	110	921	android/content/res/Resources$NotFoundException
    //   155	164	921	android/content/res/Resources$NotFoundException
    //   164	169	921	android/content/res/Resources$NotFoundException
    //   174	187	921	android/content/res/Resources$NotFoundException
    //   187	196	921	android/content/res/Resources$NotFoundException
    //   199	203	921	android/content/res/Resources$NotFoundException
    //   207	243	921	android/content/res/Resources$NotFoundException
    //   243	282	921	android/content/res/Resources$NotFoundException
    //   311	329	921	android/content/res/Resources$NotFoundException
    //   342	460	921	android/content/res/Resources$NotFoundException
    //   460	470	921	android/content/res/Resources$NotFoundException
    //   474	599	921	android/content/res/Resources$NotFoundException
    //   599	614	921	android/content/res/Resources$NotFoundException
    //   619	636	921	android/content/res/Resources$NotFoundException
    //   712	721	921	android/content/res/Resources$NotFoundException
    //   721	726	921	android/content/res/Resources$NotFoundException
    //   731	744	921	android/content/res/Resources$NotFoundException
    //   744	753	921	android/content/res/Resources$NotFoundException
    //   756	893	921	android/content/res/Resources$NotFoundException
    //   16	30	926	java/lang/Exception
    //   110	155	931	java/lang/Exception
    //   207	243	936	java/lang/Exception
    //   243	282	941	java/lang/Exception
    //   636	712	946	java/lang/Exception
  }
  
  /* Error */
  BaseConstantState a(Resources paramResources, SkinData paramSkinData, android.graphics.BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, SkinEngine.BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 14
    //   9: aconst_null
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 9
    //   18: aconst_null
    //   19: astore 13
    //   21: iload 8
    //   23: ifeq +575 -> 598
    //   26: aload 6
    //   28: ifnull +570 -> 598
    //   31: aload 9
    //   33: astore_2
    //   34: new 184	android/util/TypedValue
    //   37: dup
    //   38: invokespecial 185	android/util/TypedValue:<init>	()V
    //   41: astore 15
    //   43: aload 9
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   50: aload 6
    //   52: getfield 1333	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   55: aload 15
    //   57: iconst_1
    //   58: invokevirtual 271	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   61: aload 9
    //   63: astore_2
    //   64: aload 15
    //   66: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   69: invokeinterface 291 1 0
    //   74: astore 16
    //   76: aload 9
    //   78: astore_2
    //   79: new 336	com/tencent/theme/SkinData
    //   82: dup
    //   83: invokespecial 1307	com/tencent/theme/SkinData:<init>	()V
    //   86: astore_3
    //   87: aload 9
    //   89: astore_2
    //   90: aload_3
    //   91: aload 6
    //   93: getfield 1333	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   96: putfield 879	com/tencent/theme/SkinData:mResourcesID	I
    //   99: aload 9
    //   101: astore_2
    //   102: aload_3
    //   103: aload 16
    //   105: aload 16
    //   107: ldc_w 1309
    //   110: invokevirtual 1312	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 575	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: putfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   121: aload 9
    //   123: astore_2
    //   124: aload_0
    //   125: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   128: ifnull +76 -> 204
    //   131: aload 9
    //   133: astore_2
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   139: aload 15
    //   141: aload_3
    //   142: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   145: getstatic 159	com/tencent/theme/SkinEngine:e	[[Ljava/lang/String;
    //   148: aload_0
    //   149: getfield 202	com/tencent/theme/SkinEngine:y	I
    //   152: aaload
    //   153: getstatic 163	com/tencent/theme/SkinEngine:f	[[I
    //   156: aload_0
    //   157: getfield 202	com/tencent/theme/SkinEngine:y	I
    //   160: aaload
    //   161: invokespecial 884	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   164: aload 9
    //   166: astore_2
    //   167: aload 15
    //   169: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   172: ifnull +32 -> 204
    //   175: aload 9
    //   177: astore_2
    //   178: aload_3
    //   179: aload 15
    //   181: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   184: invokeinterface 291 1 0
    //   189: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   192: aload 9
    //   194: astore_2
    //   195: aload_3
    //   196: aload 15
    //   198: getfield 827	android/util/TypedValue:density	I
    //   201: putfield 354	com/tencent/theme/SkinData:mInDensity	I
    //   204: aload 9
    //   206: astore_2
    //   207: aload_3
    //   208: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   211: ifnull +157 -> 368
    //   214: aload 9
    //   216: astore_2
    //   217: new 333	android/graphics/Rect
    //   220: dup
    //   221: invokespecial 334	android/graphics/Rect:<init>	()V
    //   224: astore 10
    //   226: aload 9
    //   228: astore_2
    //   229: new 350	android/graphics/BitmapFactory$Options
    //   232: dup
    //   233: invokespecial 351	android/graphics/BitmapFactory$Options:<init>	()V
    //   236: astore 11
    //   238: aload 9
    //   240: astore_2
    //   241: aload 11
    //   243: aload_3
    //   244: getfield 354	com/tencent/theme/SkinData:mInDensity	I
    //   247: putfield 357	android/graphics/BitmapFactory$Options:inDensity	I
    //   250: aload 9
    //   252: astore_2
    //   253: aload 11
    //   255: aload 6
    //   257: getfield 1337	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   260: putfield 1338	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   263: aload 9
    //   265: astore_2
    //   266: aload_0
    //   267: aload_1
    //   268: aload_3
    //   269: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   272: invokespecial 348	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   275: astore 4
    //   277: aload 9
    //   279: astore_2
    //   280: aload_1
    //   281: aconst_null
    //   282: aload 4
    //   284: aload_3
    //   285: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   288: aload 11
    //   290: aload 10
    //   292: aload_0
    //   293: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   296: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   299: astore_1
    //   300: goto +59 -> 359
    //   303: astore_1
    //   304: aload 9
    //   306: astore_2
    //   307: new 299	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   314: astore 6
    //   316: aload 9
    //   318: astore_2
    //   319: aload 6
    //   321: ldc_w 1340
    //   324: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 9
    //   330: astore_2
    //   331: aload 6
    //   333: aload_3
    //   334: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   337: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 9
    //   343: astore_2
    //   344: ldc 41
    //   346: iconst_1
    //   347: aload 6
    //   349: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: aload_1
    //   353: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   356: aload 13
    //   358: astore_1
    //   359: aload_1
    //   360: astore_2
    //   361: aload 4
    //   363: invokevirtual 386	java/io/InputStream:close	()V
    //   366: aload_1
    //   367: areturn
    //   368: aload 9
    //   370: astore_2
    //   371: aload_1
    //   372: aload 6
    //   374: getfield 1333	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   377: aload 15
    //   379: invokevirtual 499	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   382: astore_3
    //   383: aload 9
    //   385: astore_2
    //   386: aload 15
    //   388: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   391: invokeinterface 291 1 0
    //   396: astore 13
    //   398: aload 9
    //   400: astore_2
    //   401: new 350	android/graphics/BitmapFactory$Options
    //   404: dup
    //   405: invokespecial 351	android/graphics/BitmapFactory$Options:<init>	()V
    //   408: astore 16
    //   410: aload 11
    //   412: astore_2
    //   413: aload 10
    //   415: astore 9
    //   417: aload_1
    //   418: aload 15
    //   420: aload_3
    //   421: aload 13
    //   423: aload 16
    //   425: aload 4
    //   427: iconst_1
    //   428: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   431: astore_1
    //   432: goto +80 -> 512
    //   435: astore_1
    //   436: goto +91 -> 527
    //   439: astore_1
    //   440: aload 11
    //   442: astore_2
    //   443: aload 10
    //   445: astore 9
    //   447: new 299	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   454: astore 4
    //   456: aload 11
    //   458: astore_2
    //   459: aload 10
    //   461: astore 9
    //   463: aload 4
    //   465: ldc_w 1342
    //   468: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 11
    //   474: astore_2
    //   475: aload 10
    //   477: astore 9
    //   479: aload 4
    //   481: aload 6
    //   483: getfield 1333	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   486: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 11
    //   492: astore_2
    //   493: aload 10
    //   495: astore 9
    //   497: ldc 41
    //   499: iconst_1
    //   500: aload 4
    //   502: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: aload_1
    //   506: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: aload 12
    //   511: astore_1
    //   512: aload_1
    //   513: astore_2
    //   514: aload_1
    //   515: astore 9
    //   517: aload_3
    //   518: invokevirtual 386	java/io/InputStream:close	()V
    //   521: aload_1
    //   522: areturn
    //   523: astore_1
    //   524: aload 14
    //   526: astore_2
    //   527: aload_2
    //   528: astore 9
    //   530: ldc 41
    //   532: iconst_1
    //   533: ldc_w 1344
    //   536: aload_1
    //   537: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   540: aload_2
    //   541: areturn
    //   542: astore_1
    //   543: aload 10
    //   545: astore 9
    //   547: new 299	java/lang/StringBuilder
    //   550: dup
    //   551: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   554: astore_2
    //   555: aload 10
    //   557: astore 9
    //   559: aload_2
    //   560: ldc_w 1346
    //   563: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 10
    //   569: astore 9
    //   571: aload_2
    //   572: aload 6
    //   574: getfield 1333	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   577: invokevirtual 844	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 10
    //   583: astore 9
    //   585: ldc 41
    //   587: iconst_1
    //   588: aload_2
    //   589: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: aload_1
    //   593: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   596: aconst_null
    //   597: areturn
    //   598: aload 10
    //   600: astore 9
    //   602: aload_0
    //   603: aload_1
    //   604: aload_2
    //   605: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   608: invokespecial 348	com/tencent/theme/SkinEngine:b	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   611: astore 11
    //   613: aload 10
    //   615: astore 9
    //   617: aload_3
    //   618: iconst_0
    //   619: putfield 394	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   622: aload 10
    //   624: astore 9
    //   626: aload_3
    //   627: aload 6
    //   629: getfield 1337	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   632: putfield 1338	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   635: aload 10
    //   637: astore 9
    //   639: aload_3
    //   640: iload 7
    //   642: putfield 1349	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   645: aload 10
    //   647: astore 9
    //   649: aload_1
    //   650: aconst_null
    //   651: aload 11
    //   653: aload_2
    //   654: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   657: aload_3
    //   658: aload 4
    //   660: aload_0
    //   661: getfield 200	com/tencent/theme/SkinEngine:s	Z
    //   664: invokestatic 366	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   667: astore_1
    //   668: goto +82 -> 750
    //   671: aload 15
    //   673: astore_1
    //   674: aload 10
    //   676: astore 9
    //   678: getstatic 431	com/tencent/theme/SkinEngine:DEBUG	Z
    //   681: ifeq +69 -> 750
    //   684: aload 10
    //   686: astore 9
    //   688: new 299	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   695: astore_1
    //   696: aload 10
    //   698: astore 9
    //   700: aload_1
    //   701: ldc_w 1351
    //   704: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 10
    //   710: astore 9
    //   712: aload_1
    //   713: aload_2
    //   714: getfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   717: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload 10
    //   723: astore 9
    //   725: aload_1
    //   726: ldc_w 1353
    //   729: invokevirtual 306	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload 10
    //   735: astore 9
    //   737: ldc 41
    //   739: aload_1
    //   740: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 440	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   746: pop
    //   747: aload 15
    //   749: astore_1
    //   750: aload_1
    //   751: astore 9
    //   753: aload 11
    //   755: invokevirtual 386	java/io/InputStream:close	()V
    //   758: aload_1
    //   759: areturn
    //   760: astore_1
    //   761: aload 9
    //   763: astore_2
    //   764: ldc 41
    //   766: iconst_1
    //   767: ldc_w 1355
    //   770: aload_1
    //   771: invokestatic 373	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: aload_2
    //   775: areturn
    //   776: astore_1
    //   777: goto -106 -> 671
    //   780: astore_1
    //   781: goto -17 -> 764
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	SkinEngine
    //   0	784	1	paramResources	Resources
    //   0	784	2	paramSkinData	SkinData
    //   0	784	3	paramOptions	android.graphics.BitmapFactory.Options
    //   0	784	4	paramRect	Rect
    //   0	784	5	paramBoolean1	boolean
    //   0	784	6	paramBackupForOOMData	SkinEngine.BackupForOOMData
    //   0	784	7	paramInt	int
    //   0	784	8	paramBoolean2	boolean
    //   16	746	9	localObject1	Object
    //   13	721	10	localRect	Rect
    //   1	753	11	localObject2	Object
    //   4	506	12	localObject3	Object
    //   19	403	13	str	String
    //   7	518	14	localObject4	Object
    //   10	738	15	localTypedValue	TypedValue
    //   74	350	16	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   280	300	303	java/lang/OutOfMemoryError
    //   417	432	435	java/io/IOException
    //   447	456	435	java/io/IOException
    //   463	472	435	java/io/IOException
    //   479	490	435	java/io/IOException
    //   497	509	435	java/io/IOException
    //   517	521	435	java/io/IOException
    //   417	432	439	java/lang/OutOfMemoryError
    //   401	410	523	java/io/IOException
    //   371	383	542	java/lang/Exception
    //   417	432	760	java/lang/Throwable
    //   447	456	760	java/lang/Throwable
    //   463	472	760	java/lang/Throwable
    //   479	490	760	java/lang/Throwable
    //   497	509	760	java/lang/Throwable
    //   517	521	760	java/lang/Throwable
    //   530	540	760	java/lang/Throwable
    //   547	555	760	java/lang/Throwable
    //   559	567	760	java/lang/Throwable
    //   571	581	760	java/lang/Throwable
    //   585	596	760	java/lang/Throwable
    //   602	613	760	java/lang/Throwable
    //   617	622	760	java/lang/Throwable
    //   626	635	760	java/lang/Throwable
    //   639	645	760	java/lang/Throwable
    //   649	668	760	java/lang/Throwable
    //   678	684	760	java/lang/Throwable
    //   688	696	760	java/lang/Throwable
    //   700	708	760	java/lang/Throwable
    //   712	721	760	java/lang/Throwable
    //   725	733	760	java/lang/Throwable
    //   737	747	760	java/lang/Throwable
    //   753	758	760	java/lang/Throwable
    //   649	668	776	java/lang/OutOfMemoryError
    //   34	43	780	java/lang/Throwable
    //   46	61	780	java/lang/Throwable
    //   64	76	780	java/lang/Throwable
    //   79	87	780	java/lang/Throwable
    //   90	99	780	java/lang/Throwable
    //   102	121	780	java/lang/Throwable
    //   124	131	780	java/lang/Throwable
    //   134	164	780	java/lang/Throwable
    //   167	175	780	java/lang/Throwable
    //   178	192	780	java/lang/Throwable
    //   195	204	780	java/lang/Throwable
    //   207	214	780	java/lang/Throwable
    //   217	226	780	java/lang/Throwable
    //   229	238	780	java/lang/Throwable
    //   241	250	780	java/lang/Throwable
    //   253	263	780	java/lang/Throwable
    //   266	277	780	java/lang/Throwable
    //   280	300	780	java/lang/Throwable
    //   307	316	780	java/lang/Throwable
    //   319	328	780	java/lang/Throwable
    //   331	341	780	java/lang/Throwable
    //   344	356	780	java/lang/Throwable
    //   361	366	780	java/lang/Throwable
    //   371	383	780	java/lang/Throwable
    //   386	398	780	java/lang/Throwable
    //   401	410	780	java/lang/Throwable
  }
  
  void a(Context paramContext)
  {
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "update start");
    }
    boolean bool = true;
    this.r = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str = localSharedPreferences.getString("pending_theme_root", null);
    if (str != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    }
    synchronized (this.c)
    {
      this.x = this.w;
      this.w = str;
      this.s = bool;
      if (this.F != null) {
        if (this.w != null)
        {
          ISkinTint localISkinTint = this.F;
          Resources localResources = paramContext.getResources();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.w);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("config.json");
          localISkinTint.loadConfig(localResources, localStringBuilder.toString());
        }
        else
        {
          this.F.clear();
        }
      }
      if (this.E != null) {
        this.E.b();
      }
      b(paramContext);
      b();
      localSharedPreferences.edit().putString("theme_root", str).putBoolean("complied", this.s).commit();
      this.r = false;
      this.x = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      h.d("SkinEngine.switch", 2, "skinEngine update done", null);
      return;
    }
  }
  
  public void addBackupForOOMData(Integer paramInteger, SkinEngine.BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.z.a(this.mResources, paramInt);
  }
  
  /* Error */
  @TargetApi(16)
  SkinnableColorStateList b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1287	com/tencent/theme/SkinEngine:c	()Landroid/util/TypedValue;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1294	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 218	com/tencent/theme/SkinEngine:u	Landroid/util/LongSparseArray;
    //   20: astore 5
    //   22: iload_1
    //   23: i2l
    //   24: lstore_2
    //   25: aload 5
    //   27: lload_2
    //   28: invokevirtual 1297	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   31: checkcast 1037	java/lang/ref/WeakReference
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   40: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   43: invokevirtual 1298	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   46: aload 5
    //   48: ifnull +73 -> 121
    //   51: aload 5
    //   53: invokevirtual 1042	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   56: checkcast 529	com/tencent/theme/SkinnableColorStateList
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +12 -> 75
    //   66: aload_0
    //   67: aload 4
    //   69: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   72: aload 5
    //   74: areturn
    //   75: aload_0
    //   76: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   79: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   82: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   85: aload_0
    //   86: getfield 218	com/tencent/theme/SkinEngine:u	Landroid/util/LongSparseArray;
    //   89: lload_2
    //   90: invokevirtual 1304	android/util/LongSparseArray:delete	(J)V
    //   93: aload_0
    //   94: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   97: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   100: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   103: goto +18 -> 121
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   112: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   115: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: aload 5
    //   120: athrow
    //   121: aload_0
    //   122: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   125: iload_1
    //   126: aload 4
    //   128: iconst_1
    //   129: invokevirtual 271	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   132: aload 4
    //   134: getfield 285	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   137: invokeinterface 291 1 0
    //   142: astore 6
    //   144: aload 6
    //   146: ldc_w 341
    //   149: invokevirtual 345	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   152: ifeq +144 -> 296
    //   155: new 336	com/tencent/theme/SkinData
    //   158: dup
    //   159: invokespecial 1307	com/tencent/theme/SkinData:<init>	()V
    //   162: astore 5
    //   164: aload 5
    //   166: iload_1
    //   167: putfield 879	com/tencent/theme/SkinData:mResourcesID	I
    //   170: aload 5
    //   172: aload 6
    //   174: aload 6
    //   176: ldc_w 1309
    //   179: invokevirtual 1312	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   182: iconst_1
    //   183: iadd
    //   184: invokevirtual 575	java/lang/String:substring	(I)Ljava/lang/String;
    //   187: putfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   190: aload_0
    //   191: getfield 558	com/tencent/theme/SkinEngine:w	Ljava/lang/String;
    //   194: ifnull +21 -> 215
    //   197: aload 5
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   204: aload 5
    //   206: getfield 360	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   209: invokespecial 1067	com/tencent/theme/SkinEngine:a	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   212: putfield 339	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   215: aload_0
    //   216: iload_1
    //   217: aload_0
    //   218: getfield 267	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   221: aload 5
    //   223: invokespecial 1069	com/tencent/theme/SkinEngine:a	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;)Lcom/tencent/theme/SkinnableColorStateList;
    //   226: astore 6
    //   228: aload 6
    //   230: aload 5
    //   232: putfield 1065	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   235: aload_0
    //   236: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   239: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   242: invokevirtual 1028	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   245: aload_0
    //   246: getfield 218	com/tencent/theme/SkinEngine:u	Landroid/util/LongSparseArray;
    //   249: lload_2
    //   250: new 1037	java/lang/ref/WeakReference
    //   253: dup
    //   254: aload 6
    //   256: invokespecial 1323	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   259: invokevirtual 1326	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   262: aload_0
    //   263: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   266: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   269: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   272: aload_0
    //   273: aload 4
    //   275: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   278: aload 6
    //   280: areturn
    //   281: astore 5
    //   283: aload_0
    //   284: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   287: invokevirtual 1023	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   290: invokevirtual 1061	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   293: aload 5
    //   295: athrow
    //   296: aload_0
    //   297: aload 4
    //   299: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   302: aconst_null
    //   303: areturn
    //   304: astore 5
    //   306: aload_0
    //   307: getfield 194	com/tencent/theme/SkinEngine:q	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   310: invokevirtual 1291	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   313: invokevirtual 1298	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   316: aload 5
    //   318: athrow
    //   319: astore 5
    //   321: aload_0
    //   322: aload 4
    //   324: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   327: aload 5
    //   329: athrow
    //   330: aload_0
    //   331: aload 4
    //   333: invokespecial 1300	com/tencent/theme/SkinEngine:a	(Landroid/util/TypedValue;)V
    //   336: aconst_null
    //   337: areturn
    //   338: astore 5
    //   340: goto -10 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	SkinEngine
    //   0	343	1	paramInt	int
    //   24	226	2	l1	long
    //   4	328	4	localTypedValue	TypedValue
    //   20	53	5	localObject1	Object
    //   106	13	5	localObject2	Object
    //   162	69	5	localSkinData	SkinData
    //   281	13	5	localObject3	Object
    //   304	13	5	localObject4	Object
    //   319	9	5	localObject5	Object
    //   338	1	5	localNotFoundException	Resources.NotFoundException
    //   142	137	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   85	93	106	finally
    //   245	262	281	finally
    //   16	22	304	finally
    //   25	36	304	finally
    //   6	16	319	finally
    //   36	46	319	finally
    //   51	61	319	finally
    //   75	85	319	finally
    //   93	103	319	finally
    //   108	121	319	finally
    //   121	215	319	finally
    //   215	245	319	finally
    //   262	272	319	finally
    //   283	296	319	finally
    //   306	319	319	finally
    //   6	16	338	android/content/res/Resources$NotFoundException
    //   36	46	338	android/content/res/Resources$NotFoundException
    //   51	61	338	android/content/res/Resources$NotFoundException
    //   75	85	338	android/content/res/Resources$NotFoundException
    //   93	103	338	android/content/res/Resources$NotFoundException
    //   108	121	338	android/content/res/Resources$NotFoundException
    //   121	215	338	android/content/res/Resources$NotFoundException
    //   215	245	338	android/content/res/Resources$NotFoundException
    //   262	272	338	android/content/res/Resources$NotFoundException
    //   283	296	338	android/content/res/Resources$NotFoundException
    //   306	319	338	android/content/res/Resources$NotFoundException
  }
  
  public boolean checkResExist(int paramInt)
  {
    TypedValue localTypedValue = c();
    this.mResources.getValue(paramInt, localTypedValue, true);
    if (TextUtils.isEmpty(localTypedValue.string))
    {
      a(localTypedValue);
      return false;
    }
    String str = localTypedValue.string.toString();
    localTypedValue.resourceId = paramInt;
    str = str.substring(str.lastIndexOf("/") + 1);
    Resources localResources = this.mResources;
    String[][] arrayOfString = e;
    paramInt = this.y;
    a(localResources, localTypedValue, str, arrayOfString[paramInt], f[paramInt]);
    if (localTypedValue.string != null)
    {
      a(localTypedValue);
      return true;
    }
    a(localTypedValue);
    return a(this.mResources, str) != null;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Resource ID #0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(" type #0x");
      localStringBuilder.append(Integer.toHexString(localTypedValue2.type));
      localStringBuilder.append(" is not valid");
      throw new Resources.NotFoundException(localStringBuilder.toString());
    }
  }
  
  public Drawable getDefaultThemeDrawable(int paramInt)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        Object localObject1 = this.v;
        long l1 = paramInt;
        localObject1 = (WeakReference)((LongSparseArray)localObject1).get(l1);
        Object localObject5 = null;
        if (localObject1 != null)
        {
          Object localObject4 = (BaseConstantState)((WeakReference)localObject1).get();
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            this.v.delete(l1);
            localObject1 = localObject4;
          }
          localObject4 = localObject1;
          if (localObject1 == null)
          {
            boolean bool = IS_PROBLEM_CM11;
            if (!bool) {}
          }
          try
          {
            mIconsOfCM.setAccessible(true);
            mIconsOfCM.set(this.mResources, null);
            mComposedIconInfoOfCM.setAccessible(true);
            mComposedIconInfoOfCM.set(this.mResources, null);
          }
          catch (Exception localException1)
          {
            SkinData localSkinData;
            continue;
          }
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
            continue;
          }
          return null;
          return null;
          this.mResources.getValue(paramInt, this.c, true);
          localObject1 = this.c.string.toString();
          localSkinData = new SkinData();
          localSkinData.mResourcesID = paramInt;
          localSkinData.mFileName = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
          localSkinData.mFilePath = null;
          localObject1 = a(paramInt, this.mResources, localSkinData, this.c);
          localObject4 = localObject1;
          if (localObject1 != null)
          {
            ((BaseConstantState)localObject1).skinData = localSkinData;
            this.v.put(l1, new WeakReference(localObject1));
            localObject4 = localObject1;
          }
          localObject1 = localObject5;
          if (localObject4 != null) {
            localObject1 = ((BaseConstantState)localObject4).newDrawable(this.mResources);
          }
          return localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public int getDrawableDpi(String paramString)
  {
    Object localObject = e;
    int i1 = this.y;
    localObject = localObject[i1];
    int[] arrayOfInt = f[i1];
    i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      if (localObject[i1].equals(paramString)) {
        return i1;
      }
      i1 += 1;
    }
    if ("color/".equals(paramString)) {
      return -2;
    }
    return -1;
  }
  
  public String getSkinRootPath()
  {
    if (this.r) {
      return this.x;
    }
    return this.w;
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      synchronized (this.c)
      {
        a(this.s);
        localObject = this.D.get(paramString);
        if (localObject == null)
        {
          paramString = this.C.get(paramString);
          break label55;
          return localObject;
        }
      }
      paramString = (String)localObject;
      label55:
      Object localObject = paramString;
      if (paramString == null) {
        localObject = paramObject;
      }
    }
  }
  
  public File getThemeDirFile()
  {
    String str = this.w;
    if (str != null) {
      return new File(str);
    }
    return null;
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if (this.w != null)
    {
      this.p.readLock().lock();
      try
      {
        Object localObject = this.t;
        long l1 = paramInt;
        localObject = (WeakReference)((LongSparseArray)localObject).get(l1);
        this.p.readLock().unlock();
        if (localObject != null)
        {
          localObject = (BaseConstantState)((WeakReference)localObject).get();
          if (localObject != null)
          {
            if (((BaseConstantState)localObject).skinData.mFilePath != null)
            {
              paramTypedValue.type = 16777215;
              paramTypedValue.string = ((BaseConstantState)localObject).skinData.mFilePath;
            }
          }
          else {
            this.p.writeLock().lock();
          }
        }
        try
        {
          this.t.delete(l1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getValue mDrawableCache delete res, resourcesId : ");
          ((StringBuilder)localObject).append(paramInt);
          h.a("SkinEngine", 1, ((StringBuilder)localObject).toString());
        }
        finally {}
        localObject = ((String)localObject).substring(((String)localObject).lastIndexOf("/") + 1);
        TypedValue localTypedValue = new TypedValue();
        localTypedValue.resourceId = paramInt;
        Resources localResources = this.mResources;
        String[][] arrayOfString = e;
        paramInt = this.y;
        a(localResources, localTypedValue, (String)localObject, arrayOfString[paramInt], f[paramInt]);
        if (localTypedValue.string != null)
        {
          paramTypedValue.type = 16777215;
          paramTypedValue.string = localTypedValue.string;
          return;
        }
      }
      finally
      {
        this.p.readLock().unlock();
      }
    }
  }
  
  public int recordDpiFile(String paramString)
  {
    Object localObject1 = f;
    int i1 = this.y;
    localObject1 = localObject1[i1];
    String[] arrayOfString = e[i1];
    if (this.w == null) {
      return -1;
    }
    i1 = 0;
    while (i1 < localObject1.length)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.w);
      ((StringBuilder)localObject2).append(arrayOfString[i1]);
      ((StringBuilder)localObject2).append(paramString);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (((String)localObject2).startsWith("/asset/")) {
        return -2;
      }
      if (new File((String)localObject2).exists()) {
        return i1;
      }
      i1 += 1;
    }
    return -3;
  }
  
  public Object[] releasePreloadDrawableCache()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Field localField;
    ClassNotFoundException localClassNotFoundException1;
    try
    {
      localField = Class.forName("android.graphics.drawable.NinePatchDrawable").getDeclaredField("mNinePatch");
      localObject1 = localField;
      localObject2 = localField;
      localField.setAccessible(true);
      localObject1 = localField;
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      localClassNotFoundException2.printStackTrace();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      localClassNotFoundException1 = localClassNotFoundException2;
    }
    Object localObject3 = this.z;
    long l1 = 0L;
    int i1;
    if ((localObject3 != null) && (((e)localObject3).b != null))
    {
      localObject3 = this.z.b;
      int i6 = localObject3.length;
      l1 = 0L;
      i1 = 0;
      int i2 = 0;
      while (i2 < i6)
      {
        localField = localObject3[i2];
        int i3 = 0;
        while (i3 < localField.size())
        {
          Object localObject4 = (Drawable.ConstantState)localField.valueAt(i3);
          long l2 = l1;
          if (localObject4 != null)
          {
            localObject4 = ((Drawable.ConstantState)localObject4).newDrawable();
            int i5;
            int i4;
            if ((localObject4 instanceof BitmapDrawable))
            {
              localObject4 = ((BitmapDrawable)localObject4).getBitmap();
              l2 = l1;
              if (localObject4 == null) {
                break label310;
              }
              if (Build.VERSION.SDK_INT >= 12)
              {
                l2 = ((Bitmap)localObject4).getByteCount();
              }
              else
              {
                i5 = ((Bitmap)localObject4).getRowBytes();
                i4 = ((Bitmap)localObject4).getHeight();
              }
            }
            for (;;)
            {
              l2 = i5 * i4;
              l2 = l1 + l2;
              break label310;
              if (((localObject4 instanceof NinePatchDrawable)) && (localClassNotFoundException1 != null)) {
                try
                {
                  localObject4 = localClassNotFoundException1.get((NinePatchDrawable)localObject4);
                  l2 = l1;
                  if (!(localObject4 instanceof NinePatch)) {
                    break label310;
                  }
                  localObject4 = (NinePatch)localObject4;
                  i5 = ((NinePatch)localObject4).getWidth();
                  i4 = ((NinePatch)localObject4).getHeight();
                }
                catch (IllegalAccessException localIllegalAccessException)
                {
                  localIllegalAccessException.printStackTrace();
                }
              }
            }
            l2 = l1 + 1L;
          }
          label310:
          i3 += 1;
          i1 += 1;
          l1 = l2;
        }
        localField.clear();
        i2 += 1;
      }
    }
    else
    {
      i1 = 0;
    }
    return new Object[] { Integer.valueOf(i1), Long.valueOf(l1) };
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.m = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.r)
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
    if (paramString == null)
    {
      localSharedPreferences.edit().remove("pending_theme_root").remove("pending_theme_resources_complied").commit();
    }
    else
    {
      Object localObject = paramString;
      if (!paramString.endsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("/");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (((String)localObject).startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("pending_theme_root", (String)localObject).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        paramString = new File((String)localObject);
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localSharedPreferences.edit().putString("pending_theme_root", (String)localObject).putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG)
          {
            paramString = new StringBuilder();
            paramString.append("[setSkinRootPath] wrong skinPath: ");
            paramString.append((String)localObject);
            Log.w("SkinEngine", paramString.toString());
          }
          localSharedPreferences.edit().remove("pending_theme_root").putBoolean("pending_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
    paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
    if (SWITCH_DEBUG)
    {
      Log.d("SkinEngine.switch", "[setSkinRootPath] sendBroadcast(ACTION_THEME_UPDATE)");
      Log.d("SkinEngine.switch", "[setSkinRootPath] done");
    }
    return true;
  }
  
  public void setSkinTint(ISkinTint paramISkinTint)
  {
    this.F = paramISkinTint;
  }
  
  public void unInit()
  {
    try
    {
      if (this.z != null)
      {
        localField = Resources.class.getDeclaredField("sPreloadedDrawables");
        localField.setAccessible(true);
        if (localField.getDeclaringClass().isArray()) {
          localField.set(null, this.z.b);
        } else {
          localField.set(null, this.z.b[0]);
        }
      }
    }
    catch (Exception localException1)
    {
      Field localField;
      Object localObject;
      label99:
      if (DEBUG) {
        Log.e("SkinEngine", "resotre SkinEngine failed", localException1);
      }
    }
    try
    {
      localField = Resources.class.getDeclaredField("sPreloadedColorStateLists");
      localField.setAccessible(true);
      localObject = (LongSparseArray)localField.get(this.mResources);
      localField.set(null, this.A.b);
      return;
    }
    catch (Exception localException2)
    {
      break label99;
    }
    localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
    localField.setAccessible(true);
    localObject = localField.get(this.mResources);
    if ((localObject instanceof SparseArray))
    {
      localField.set(null, this.B.b);
      return;
    }
    if ((localObject instanceof LongSparseArray))
    {
      localField.set(null, this.A.b);
      return;
    }
  }
  
  public void writeCacheFile(File paramFile)
  {
    this.z.a(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */