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
  static int DENSITY_HDPI_INDEX = 0;
  static int DENSITY_LDPI_INDEX = 3;
  static int DENSITY_MDPI_INDEX = 0;
  static final int[][] DENSITY_ORDER;
  static final String[][] DENSITY_PATH_ORDER;
  static int DENSITY_XHDPI_INDEX = 0;
  static int DENSITY_XXHDPI_INDEX = 4;
  static int DENSITY_XXXHDPI_INDEX = 5;
  static boolean IS_MNC_PREVIEW = false;
  static boolean IS_NOUGAT = false;
  public static boolean IS_PROBLEM_CM11 = false;
  public static boolean IS_PROBLEM_MIUI = false;
  public static final String KEY_PENDING_THEME = "pending_theme_root";
  public static final String KEY_PENDING_THEME_RESOURCES_IS_COMPLIED = "pending_theme_resources_complied";
  public static final String KEY_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_SIMPLE_PENDING_THEME = "simple_theme_root";
  public static final String KEY_SIMPLE_RESOURCES_IS_COMPLIED = "complied";
  public static final String KEY_SIMPLE_THEME = "theme_simple_root";
  public static final String KEY_SIMPLE_THEME_RESOURCES_IS_COMPLIED = "simple_theme_resources_complied";
  public static final String KEY_THEME = "theme_root";
  public static final String KEY_THEME_FONT = "theme_font_root";
  public static final String PREFERENCE_NAME = "theme";
  public static boolean SWITCH_DEBUG = false;
  public static final String TAG = "SkinEngine";
  public static final String TAG_SWITCH = "SkinEngine.switch";
  public static final int TYPE_FILE = 16777215;
  public static final int TYPE_RESOURCES = 3;
  private static SkinEngine instances;
  public static Field mComposedIconInfoOfCM;
  public static Integer mIconResourceID;
  public static Field mIconsOfCM;
  public HashMap<Integer, SkinEngine.BackupForOOMData> backupForOOMData;
  private b colorStateListPreloadIntercepter;
  private c colorStateListPreloadIntercepter15;
  private e drawableIntercepter;
  private final LongSparseArray<WeakReference<SkinnableColorStateList>> mColorStateListCache = new LongSparseArray();
  private ReentrantReadWriteLock mColorStateListLock = new ReentrantReadWriteLock();
  private HashMap<String, Object> mConfigs;
  private HashMap<String, Object> mDefaultConfigs;
  private final LongSparseArray<WeakReference<BaseConstantState>> mDefaultThemeDrawableCache = new LongSparseArray();
  private int mDensityIndex = DENSITY_XXHDPI_INDEX;
  private final LongSparseArray<WeakReference<BaseConstantState>> mDrawableCache = new LongSparseArray();
  private ReentrantReadWriteLock mDrawableCacheLock = new ReentrantReadWriteLock();
  private g mFileExistCache;
  private boolean mInSimpleModel;
  private boolean mIsResourcesComplied = true;
  BroadcastReceiver mReceiver = new SkinEngine.1(this);
  public Resources mResources;
  private String mSimpleSkinRootPath;
  SkinEngineHandler mSkinEngineHandler;
  private String mSkinRootPath;
  private ISkinTint mSkinTint;
  private boolean mSkinUpdating = false;
  private String mTempSkinRootPath;
  TypedValue mTempValue = new TypedValue();
  final TypedValue mTmpValue = new TypedValue();
  private final Object mTmpValueLock = new Object();
  UpdateCallback mUpdateCallback;
  
  static
  {
    boolean bool;
    if ((!"MNC".equals(Build.VERSION.CODENAME)) && (Build.VERSION.SDK_INT < 23)) {
      bool = false;
    } else {
      bool = true;
    }
    IS_MNC_PREVIEW = bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    IS_NOUGAT = bool;
    IS_PROBLEM_MIUI = false;
    mIconsOfCM = null;
    mComposedIconInfoOfCM = null;
    IS_PROBLEM_CM11 = false;
    mIconResourceID = null;
    Object localObject = { "drawable-xhdpi/", "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
    String[] arrayOfString1 = { "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-mdpi/", "drawable/" };
    String[] arrayOfString2 = { "drawable-mdpi/", "drawable/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/" };
    String[] arrayOfString3 = { "drawable-ldpi/", "drawable-hdpi/", "drawable-xhdpi/", "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable/" };
    String[] arrayOfString4 = { "drawable-xxxhdpi/", "drawable-xxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" };
    DENSITY_PATH_ORDER = new String[][] { localObject, arrayOfString1, arrayOfString2, arrayOfString3, { "drawable-xxhdpi/", "drawable-xxxhdpi/", "drawable-xhdpi/", "drawable-hdpi/", "drawable-mdpi/", "drawable/" }, arrayOfString4 };
    localObject = new int[] { 480, 640, 320, 240, 160, 160 };
    DENSITY_ORDER = new int[][] { { 320, 640, 480, 240, 160, 160 }, { 240, 320, 480, 640, 160, 160 }, { 160, 160, 240, 320, 480, 640 }, { 120, 240, 320, 480, 640, 160 }, localObject, { 640, 480, 320, 240, 160, 160 } };
    DENSITY_XHDPI_INDEX = 0;
    DENSITY_HDPI_INDEX = 1;
    DENSITY_MDPI_INDEX = 2;
  }
  
  private static void checkBound(Drawable paramDrawable)
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
  
  private static void checkBounds(Drawable[] paramArrayOfDrawable)
  {
    int j = paramArrayOfDrawable.length;
    int i = 0;
    while (i < j)
    {
      checkBound(paramArrayOfDrawable[i]);
      i += 1;
    }
  }
  
  private boolean checkNeedTintColor(String paramString)
  {
    if (this.mInSimpleModel)
    {
      ISkinTint localISkinTint = this.mSkinTint;
      if ((localISkinTint != null) && (localISkinTint.isTint(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static void clearSystemSelectorCache()
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
  
  public static long dumpDrawableCacheMemSize()
  {
    SkinEngine localSkinEngine = getInstances();
    Object localObject1 = new TypedValue();
    long l2 = 0L;
    int j = 0;
    while (j < localSkinEngine.mDrawableCache.size())
    {
      Object localObject2 = (WeakReference)localSkinEngine.mDrawableCache.valueAt(j);
      long l3 = localSkinEngine.mDrawableCache.keyAt(j);
      long l1 = l2;
      if (localObject2 != null)
      {
        localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
        l1 = l2;
        if (localObject2 != null)
        {
          int i;
          if ((localObject2 instanceof SkinnableBitmapDrawable.a)) {
            i = getBimapSize(((SkinnableBitmapDrawable.a)localObject2).a);
          } else if ((localObject2 instanceof SkinnableNinePatchDrawable.a)) {
            i = getBimapSize(((SkinnableNinePatchDrawable.a)localObject2).g);
          } else {
            i = 0;
          }
          l2 += i;
          localSkinEngine.mResources.getValue((int)l3, (TypedValue)localObject1, true);
          l1 = l2;
          if (((TypedValue)localObject1).string != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("res:");
            ((StringBuilder)localObject2).append(((TypedValue)localObject1).string.toString());
            ((StringBuilder)localObject2).append(",size=");
            ((StringBuilder)localObject2).append(i);
            h.d("SkinEngine", 4, ((StringBuilder)localObject2).toString(), null);
            l1 = l2;
          }
        }
      }
      j += 1;
      l2 = l1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Total DrawableNum=");
    ((StringBuilder)localObject1).append(localSkinEngine.mDrawableCache.size());
    ((StringBuilder)localObject1).append(",MemSize=");
    ((StringBuilder)localObject1).append(l2);
    h.c("SkinEngine", 4, ((StringBuilder)localObject1).toString(), null);
    return l2;
  }
  
  /* Error */
  private void ensureConfigLoaded(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 462	com/tencent/theme/SkinEngine:mDefaultConfigs	Ljava/util/HashMap;
    //   4: ifnonnull +69 -> 73
    //   7: aload_0
    //   8: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   11: invokevirtual 466	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 468
    //   17: invokevirtual 474	android/content/res/AssetManager:openXmlResourceParser	(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   20: astore_2
    //   21: aload_0
    //   22: aload_0
    //   23: aload_2
    //   24: invokespecial 478	com/tencent/theme/SkinEngine:parseXml	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/HashMap;
    //   27: putfield 462	com/tencent/theme/SkinEngine:mDefaultConfigs	Ljava/util/HashMap;
    //   30: aload_2
    //   31: invokeinterface 483 1 0
    //   36: goto +37 -> 73
    //   39: aload_0
    //   40: new 485	java/util/HashMap
    //   43: dup
    //   44: invokespecial 486	java/util/HashMap:<init>	()V
    //   47: putfield 462	com/tencent/theme/SkinEngine:mDefaultConfigs	Ljava/util/HashMap;
    //   50: goto +23 -> 73
    //   53: astore_2
    //   54: new 488	android/content/res/Resources$NotFoundException
    //   57: dup
    //   58: ldc_w 490
    //   61: invokespecial 493	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 497	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   70: pop
    //   71: aload_3
    //   72: athrow
    //   73: aload_0
    //   74: getfield 239	com/tencent/theme/SkinEngine:mConfigs	Ljava/util/HashMap;
    //   77: ifnonnull +126 -> 203
    //   80: aload_0
    //   81: getfield 499	com/tencent/theme/SkinEngine:mSkinRootPath	Ljava/lang/String;
    //   84: ifnonnull +22 -> 106
    //   87: aload_0
    //   88: getfield 501	com/tencent/theme/SkinEngine:mSimpleSkinRootPath	Ljava/lang/String;
    //   91: ifnonnull +15 -> 106
    //   94: aload_0
    //   95: new 485	java/util/HashMap
    //   98: dup
    //   99: invokespecial 486	java/util/HashMap:<init>	()V
    //   102: putfield 239	com/tencent/theme/SkinEngine:mConfigs	Ljava/util/HashMap;
    //   105: return
    //   106: iload_1
    //   107: ifeq +14 -> 121
    //   110: new 503	com/tencent/theme/AndroidXmlResourceParser
    //   113: dup
    //   114: invokespecial 504	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   117: astore_2
    //   118: goto +7 -> 125
    //   121: invokestatic 510	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   124: astore_2
    //   125: new 512	java/io/FileInputStream
    //   128: dup
    //   129: new 514	java/io/File
    //   132: dup
    //   133: aload_0
    //   134: invokevirtual 517	com/tencent/theme/SkinEngine:getRealRootPath	()Ljava/lang/String;
    //   137: ldc_w 519
    //   140: invokespecial 522	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: invokespecial 525	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: astore_3
    //   147: aload_2
    //   148: aload_3
    //   149: ldc_w 527
    //   152: invokeinterface 533 3 0
    //   157: aload_0
    //   158: aload_0
    //   159: aload_2
    //   160: invokespecial 478	com/tencent/theme/SkinEngine:parseXml	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/util/HashMap;
    //   163: putfield 239	com/tencent/theme/SkinEngine:mConfigs	Ljava/util/HashMap;
    //   166: aload_3
    //   167: invokevirtual 534	java/io/FileInputStream:close	()V
    //   170: return
    //   171: aload_0
    //   172: new 485	java/util/HashMap
    //   175: dup
    //   176: invokespecial 486	java/util/HashMap:<init>	()V
    //   179: putfield 239	com/tencent/theme/SkinEngine:mConfigs	Ljava/util/HashMap;
    //   182: return
    //   183: astore_2
    //   184: new 488	android/content/res/Resources$NotFoundException
    //   187: dup
    //   188: ldc_w 536
    //   191: invokespecial 493	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   194: astore_3
    //   195: aload_3
    //   196: aload_2
    //   197: invokevirtual 497	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   200: pop
    //   201: aload_3
    //   202: athrow
    //   203: return
    //   204: astore_2
    //   205: goto -166 -> 39
    //   208: astore_2
    //   209: goto -38 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	SkinEngine
    //   0	212	1	paramBoolean	boolean
    //   20	11	2	localXmlResourceParser	XmlResourceParser
    //   53	14	2	localXmlPullParserException1	XmlPullParserException
    //   117	43	2	localObject1	Object
    //   183	14	2	localXmlPullParserException2	XmlPullParserException
    //   204	1	2	localIOException1	IOException
    //   208	1	2	localIOException2	IOException
    //   64	138	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	36	53	org/xmlpull/v1/XmlPullParserException
    //   110	118	183	org/xmlpull/v1/XmlPullParserException
    //   121	125	183	org/xmlpull/v1/XmlPullParserException
    //   125	170	183	org/xmlpull/v1/XmlPullParserException
    //   7	36	204	java/io/IOException
    //   110	118	208	java/io/IOException
    //   121	125	208	java/io/IOException
    //   125	170	208	java/io/IOException
  }
  
  private static int getBimapSize(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT > 11) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  private static int getDensityIndex(Resources paramResources)
  {
    int i = paramResources.getDisplayMetrics().densityDpi;
    if (i <= 160) {
      return DENSITY_MDPI_INDEX;
    }
    if (i <= 240) {
      return DENSITY_HDPI_INDEX;
    }
    if (i <= 320) {
      return DENSITY_XHDPI_INDEX;
    }
    if (i <= 480) {
      return DENSITY_XXHDPI_INDEX;
    }
    if (i <= 640) {
      return DENSITY_XXXHDPI_INDEX;
    }
    return DENSITY_XXHDPI_INDEX;
  }
  
  private InputStream getInputStream(Resources paramResources, String paramString)
  {
    if (paramString.startsWith("/asset/"))
    {
      paramString = paramString.substring(7);
      return paramResources.getAssets().open(paramString);
    }
    return new BufferedInputStream(new FileInputStream(new File(paramString)));
  }
  
  public static SkinEngine getInstances()
  {
    try
    {
      if (instances == null) {
        instances = new SkinEngine();
      }
      SkinEngine localSkinEngine = instances;
      return localSkinEngine;
    }
    finally {}
  }
  
  private int getLogLevel(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("skin_tab_icon_see")) || (paramString.contains("skin_tab_icon_conversation")) || (paramString.contains("skin_tab_icon_plugin")) || (paramString.contains("skin_tab_icon_contact")))) {
      return 1;
    }
    return 2;
  }
  
  private XmlResourceParser getXml(int paramInt, TypedValue paramTypedValue)
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
  
  private String grabColorFile(Resources paramResources, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getRealRootPath());
    ((StringBuilder)localObject).append("color/");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      if ((this.mFileExistCache.b()) && (!this.mFileExistCache.a()))
      {
        if (this.mFileExistCache.b(paramString)) {
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
  
  private void grabImageFile(Resources paramResources, TypedValue paramTypedValue, String paramString, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Object localObject;
    if ((this.mFileExistCache.b()) && (!this.mFileExistCache.a()))
    {
      h.a("SkinEngine", 1, "get dpi from mFileExistCache");
      paramResources = this.mFileExistCache.a(paramString);
      if (paramResources != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getRealRootPath());
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
    h.a("SkinEngine", 1, "refresh dpi data");
    int i = 0;
    while (i < paramArrayOfInt.length) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(getRealRootPath());
        ((StringBuilder)localObject).append(paramArrayOfString[i]);
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
        if (((String)localObject).startsWith("/asset/"))
        {
          paramResources.getAssets().open(((String)localObject).substring(7)).close();
          paramTypedValue.string = ((CharSequence)localObject);
          paramTypedValue.density = paramArrayOfInt[i];
          return;
        }
        if (new File((String)localObject).exists())
        {
          paramTypedValue.string = ((CharSequence)localObject);
          paramTypedValue.density = paramArrayOfInt[i];
          return;
        }
      }
      catch (IOException localIOException)
      {
        if (DEBUG) {
          Log.w("SkinEngine", localIOException);
        }
        i += 1;
      }
    }
    paramTypedValue.string = null;
    paramTypedValue.density = 0;
  }
  
  public static void init(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init cacheFile:");
    boolean bool2 = false;
    if (paramFile == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    h.c("SkinEngine", 2, ((StringBuilder)localObject).toString(), null);
    localObject = getInstances();
    Resources localResources = paramContext.getResources();
    ((SkinEngine)localObject).mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    ((SkinEngine)localObject).mDensityIndex = getDensityIndex(((SkinEngine)localObject).mResources);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    ((SkinEngine)localObject).mSkinRootPath = localSharedPreferences.getString("theme_root", null);
    ((SkinEngine)localObject).mSimpleSkinRootPath = localSharedPreferences.getString("theme_simple_root", null);
    boolean bool1 = bool2;
    if (((SkinEngine)localObject).mSimpleSkinRootPath != null) {
      bool1 = true;
    }
    ((SkinEngine)localObject).mInSimpleModel = bool1;
    if ((((SkinEngine)localObject).mSkinTint != null) && ((((SkinEngine)localObject).mSkinRootPath != null) || (((SkinEngine)localObject).mSimpleSkinRootPath != null)))
    {
      ISkinTint localISkinTint = ((SkinEngine)localObject).mSkinTint;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((SkinEngine)localObject).getRealRootPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      localISkinTint.loadConfig(localResources, localStringBuilder.toString());
    }
    TextHook.getInstance().switchFont(paramContext, localSharedPreferences.getString("theme_font_root", null));
    paramContext.getApplicationContext().registerReceiver(((SkinEngine)localObject).mReceiver, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    ((SkinEngine)localObject).initIntercepter(localResources, paramInt1, null, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramFile);
    if (((SkinEngine)localObject).mInSimpleModel) {
      ((SkinEngine)localObject).mIsResourcesComplied = localSharedPreferences.getBoolean("complied", true);
    } else {
      ((SkinEngine)localObject).mIsResourcesComplied = localSharedPreferences.getBoolean("complied", true);
    }
    clearSystemSelectorCache();
  }
  
  public static void init(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, File paramFile)
  {
    SkinEngine localSkinEngine = getInstances();
    Resources localResources = paramContext.getResources();
    localSkinEngine.mResources = localResources;
    isSupportPlatform(paramContext, localResources);
    localSkinEngine.mDensityIndex = getDensityIndex(localSkinEngine.mResources);
    paramContext.getApplicationContext().registerReceiver(localSkinEngine.mReceiver, new IntentFilter("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify", null);
    localSkinEngine.initIntercepter(localResources, 0, paramArrayOfInt, 0, 0, paramInt1, paramInt2, paramInt3, paramFile);
    paramArrayOfInt = paramContext.getSharedPreferences("theme", 4);
    localSkinEngine.mSkinRootPath = paramArrayOfInt.getString("theme_root", null);
    localSkinEngine.mSimpleSkinRootPath = paramArrayOfInt.getString("theme_simple_root", null);
    if ((localSkinEngine.mSkinTint != null) && ((localSkinEngine.mSkinRootPath != null) || (localSkinEngine.mSimpleSkinRootPath != null)))
    {
      paramFile = localSkinEngine.mSkinTint;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSkinEngine.getRealRootPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("config.json");
      paramFile.loadConfig(localResources, localStringBuilder.toString());
    }
    TextHook.getInstance().switchFont(paramContext, paramArrayOfInt.getString("theme_font_root", null));
    if (localSkinEngine.mInSimpleModel) {
      localSkinEngine.mIsResourcesComplied = paramArrayOfInt.getBoolean("complied", true);
    } else {
      localSkinEngine.mIsResourcesComplied = paramArrayOfInt.getBoolean("complied", true);
    }
    clearSystemSelectorCache();
  }
  
  private void initIntercepter(Resources paramResources, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, File paramFile)
  {
    if ((paramArrayOfInt == null) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      localObject1 = null;
    }
    try
    {
      bool = IS_NOUGAT;
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
      label73:
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
      break label73;
      paramInt1 = 0;
      break label412;
    }
    Object localObject1 = localObject4.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject3 = ((Field)localObject1).get(localObject4);
    localObject2 = localObject1;
    localObject1 = localObject4;
    break label143;
    localObject2 = Resources.class.getDeclaredField("sPreloadedDrawables");
    ((Field)localObject2).setAccessible(true);
    localObject3 = ((Field)localObject2).get(paramResources);
    localObject1 = null;
    label143:
    if ((localObject3 instanceof LongSparseArray))
    {
      if (paramArrayOfInt != null)
      {
        this.mFileExistCache = e.a(this, paramResources);
        this.mFileExistCache.c();
        this.drawableIntercepter = new e(this, paramResources, paramArrayOfInt, paramFile, new LongSparseArray[] { (LongSparseArray)localObject3 });
      }
      else
      {
        this.mFileExistCache = e.a(this, paramResources);
        this.mFileExistCache.c();
        this.drawableIntercepter = new e(this, paramResources, paramInt1, paramInt2, paramInt3, paramFile, new LongSparseArray[] { (LongSparseArray)localObject3 });
      }
      if ((IS_NOUGAT) && (localObject1 != null)) {
        ((Field)localObject2).set(localObject1, new f(0, this.drawableIntercepter));
      } else {
        ((Field)localObject2).set(paramResources, new f(0, this.drawableIntercepter));
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
          this.mFileExistCache = e.a(this, paramResources);
          this.mFileExistCache.c();
          this.drawableIntercepter = new e(this, paramResources, paramArrayOfInt, paramFile, (LongSparseArray[])localObject3);
          break label1176;
        }
        this.mFileExistCache = e.a(this, paramResources);
        this.mFileExistCache.c();
        this.drawableIntercepter = new e(this, paramResources, paramInt1, paramInt2, paramInt3, paramFile, (LongSparseArray[])localObject3);
        break label1176;
        for (;;)
        {
          label412:
          localObject1 = localObject2;
          if (paramInt1 >= localObject3.length) {
            break;
          }
          localObject3[paramInt1] = new f(paramInt1, this.drawableIntercepter);
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
          if (IS_NOUGAT)
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
            this.colorStateListPreloadIntercepter15 = new c(this, paramResources, (SparseArray)localObject1, paramInt4, paramInt5, paramInt6);
            paramFile.set(paramResources, this.colorStateListPreloadIntercepter15);
          }
          else if ((localObject1 instanceof LongSparseArray))
          {
            this.colorStateListPreloadIntercepter = new b(this, paramResources, (LongSparseArray)localObject1, paramInt4, paramInt5, paramInt6);
            paramFile.set(paramResources, this.colorStateListPreloadIntercepter);
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
        if (IS_MNC_PREVIEW) {
          this.colorStateListPreloadIntercepter = new d(this, paramResources, paramFile, paramInt4, paramInt5, paramInt6);
        } else {
          this.colorStateListPreloadIntercepter = new b(this, paramResources, paramFile, paramInt4, paramInt5, paramInt6);
        }
        if ((IS_NOUGAT) && (localObject1 != null)) {
          paramArrayOfInt.set(localObject1, this.colorStateListPreloadIntercepter);
        } else {
          paramArrayOfInt.set(paramResources, this.colorStateListPreloadIntercepter);
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
      label1102:
      label1105:
      label1108:
      break label1108;
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
      break label1105;
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
      break label1102;
    }
    mIconsOfCM = null;
    mComposedIconInfoOfCM = null;
  }
  
  public static void invalidateAll(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      localObject1 = (ViewGroup)paramView;
      j = ((ViewGroup)localObject1).getChildCount();
      i = 0;
      while (i < j)
      {
        invalidateAll(((ViewGroup)localObject1).getChildAt(i));
        i += 1;
      }
    }
    Object localObject1 = paramView.getBackground();
    Object localObject2;
    if (localObject1 != null)
    {
      int k;
      int m;
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
          i = paramView.getPaddingTop();
          j = paramView.getPaddingBottom();
          k = paramView.getPaddingLeft();
          m = paramView.getPaddingRight();
          SkinnableActivityProcesser.a((Drawable)localObject1);
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
          paramView.setPadding(k, i, m, j);
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
          i = paramView.getPaddingTop();
          j = paramView.getPaddingBottom();
          k = paramView.getPaddingLeft();
          m = paramView.getPaddingRight();
          paramView.setBackgroundDrawable(null);
          paramView.setBackgroundDrawable((Drawable)localObject1);
          paramView.setPadding(k, i, m, j);
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
        checkBounds((Drawable[])localObject2);
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
      bool = IS_NOUGAT;
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
      label167:
      label218:
      throw new UnSupportPlatformException(paramContext);
    }
    catch (IllegalArgumentException paramContext)
    {
      label45:
      label96:
      throw new UnSupportPlatformException(paramContext);
    }
    try
    {
      localObject1 = localObject2.getClass().getDeclaredField("sPreloadedDrawables");
    }
    catch (NoSuchFieldException localNoSuchFieldException1)
    {
      break label45;
    }
    localObject1 = localObject2.getClass().getSuperclass().getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(localObject2);
    break label96;
    localObject1 = Resources.class.getDeclaredField("sPreloadedDrawables");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramResources);
    if ((!(localObject1 instanceof LongSparseArray)) && (!(localObject1 instanceof LongSparseArray[]))) {
      throw new UnSupportPlatformException("sPreloadedDrawables is not LongSparseArray");
    }
    try
    {
      if (IS_NOUGAT)
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
      break label167;
    }
    localObject1 = localObject2.getClass().getSuperclass().getDeclaredField("sPreloadedComplexColors");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(localObject2);
    break label218;
    localObject1 = Resources.class.getDeclaredField("sPreloadedColorStateLists");
    ((Field)localObject1).setAccessible(true);
    localObject1 = ((Field)localObject1).get(paramResources);
    if (!(localObject1 instanceof LongSparseArray)) {
      throw new UnSupportPlatformException("sPreloadedColorStateLists is not LongSparseArray");
    }
    throw new UnSupportPlatformException(localException);
  }
  
  private boolean isTrackLoadRes(String paramString)
  {
    return false;
  }
  
  private SkinnableColorStateList loadColor(int paramInt, Resources paramResources, SkinData paramSkinData)
  {
    synchronized (this.mTmpValue)
    {
      Object localObject = paramSkinData.mFilePath;
      if (localObject != null)
      {
        bool = ((String)localObject).endsWith(".xml");
        if (bool) {
          try
          {
            SkinnableColorStateList localSkinnableColorStateList = ResourcesFactory.a(this, paramResources, new File((String)localObject), this.mIsResourcesComplied);
            if (checkNeedTintColor(paramSkinData.mFileName))
            {
              this.mSkinTint.tintColorState(localSkinnableColorStateList.getColors(), localSkinnableColorStateList.getStateSpecs(), paramSkinData.mFileName);
              localSkinnableColorStateList.setDefaultColor(localSkinnableColorStateList.getColors(), localSkinnableColorStateList.getStateSpecs());
            }
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
          localObject = getXml(paramInt, this.mTmpValue);
          paramResources = SkinnableColorStateList.createFromXml(this, paramResources, (XmlPullParser)localObject, true);
          if (this.mSkinTint != null)
          {
            this.mSkinTint.tintColorState(paramResources.getColors(), paramResources.getStateSpecs(), paramSkinData);
            paramResources.setDefaultColor(paramResources.getColors(), paramResources.getStateSpecs());
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
  
  /* Error */
  private BaseConstantState loadImage(int paramInt, Resources paramResources, SkinData paramSkinData, TypedValue paramTypedValue)
  {
    // Byte code:
    //   0: ldc_w 1021
    //   3: astore 10
    //   5: new 293	android/graphics/Rect
    //   8: dup
    //   9: invokespecial 872	android/graphics/Rect:<init>	()V
    //   12: astore 24
    //   14: aload_3
    //   15: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   18: astore 8
    //   20: ldc 64
    //   22: astore 11
    //   24: aload 8
    //   26: ifnull +995 -> 1021
    //   29: aload 8
    //   31: ldc_w 968
    //   34: invokevirtual 971	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   37: ifne +984 -> 1021
    //   40: aload 11
    //   42: astore 9
    //   44: aload_0
    //   45: aload_2
    //   46: aload 8
    //   48: invokespecial 1023	com/tencent/theme/SkinEngine:getInputStream	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   51: astore 17
    //   53: aload 11
    //   55: astore 9
    //   57: new 1025	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 1026	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 13
    //   66: aload 11
    //   68: astore 9
    //   70: aload 13
    //   72: aload_3
    //   73: getfield 1029	com/tencent/theme/SkinData:mInDensity	I
    //   76: putfield 1032	android/graphics/BitmapFactory$Options:inDensity	I
    //   79: aload 11
    //   81: astore 9
    //   83: aload_3
    //   84: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   87: astore 12
    //   89: aload 11
    //   91: astore 9
    //   93: aload_0
    //   94: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   97: istore 7
    //   99: aload_2
    //   100: aconst_null
    //   101: aload 17
    //   103: aload 12
    //   105: aload 13
    //   107: aload 24
    //   109: iload 7
    //   111: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   114: astore 16
    //   116: ldc_w 1021
    //   119: astore 10
    //   121: ldc 64
    //   123: astore 11
    //   125: ldc_w 968
    //   128: astore 9
    //   130: goto +664 -> 794
    //   133: astore 9
    //   135: ldc 64
    //   137: astore 15
    //   139: goto +751 -> 890
    //   142: astore 12
    //   144: goto +5 -> 149
    //   147: astore 12
    //   149: new 257	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   156: astore 9
    //   158: aload 9
    //   160: ldc_w 1038
    //   163: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 9
    //   169: aload 8
    //   171: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 9
    //   177: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore 14
    //   182: ldc 64
    //   184: astore 11
    //   186: aload 11
    //   188: astore 9
    //   190: aload 11
    //   192: iconst_1
    //   193: aload 14
    //   195: aload 12
    //   197: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload 11
    //   202: astore 9
    //   204: aload_0
    //   205: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   208: ifnull +1883 -> 2091
    //   211: aload 11
    //   213: astore 9
    //   215: aload_0
    //   216: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   219: aload 12
    //   221: aload_3
    //   222: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   225: iconst_1
    //   226: invokeinterface 1046 4 0
    //   231: ifeq +1860 -> 2091
    //   234: aload 11
    //   236: astore 9
    //   238: aload 17
    //   240: invokevirtual 640	java/io/InputStream:close	()V
    //   243: aload 11
    //   245: astore 9
    //   247: aload_0
    //   248: aload_2
    //   249: aload 8
    //   251: invokespecial 1023	com/tencent/theme/SkinEngine:getInputStream	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   254: astore 17
    //   256: aload 11
    //   258: astore 9
    //   260: aload_3
    //   261: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   264: astore 14
    //   266: aload 11
    //   268: astore 9
    //   270: aload_0
    //   271: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   274: istore 7
    //   276: aload_2
    //   277: aconst_null
    //   278: aload 17
    //   280: aload 14
    //   282: aload 13
    //   284: aload 24
    //   286: iload 7
    //   288: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   291: astore 16
    //   293: ldc_w 1021
    //   296: astore 10
    //   298: ldc_w 968
    //   301: astore 9
    //   303: goto +491 -> 794
    //   306: ldc_w 968
    //   309: astore 9
    //   311: astore 11
    //   313: ldc 64
    //   315: astore 15
    //   317: aload 8
    //   319: astore 12
    //   321: aload 11
    //   323: astore 8
    //   325: aload 9
    //   327: astore 13
    //   329: aload 10
    //   331: astore 14
    //   333: goto +575 -> 908
    //   336: astore 11
    //   338: goto +5 -> 343
    //   341: astore 11
    //   343: ldc 64
    //   345: astore 16
    //   347: ldc_w 968
    //   350: astore 9
    //   352: new 257	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   359: astore 14
    //   361: aload 14
    //   363: ldc_w 1048
    //   366: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 14
    //   372: aload 8
    //   374: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 14
    //   380: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: astore 14
    //   385: aload 16
    //   387: iconst_1
    //   388: aload 14
    //   390: aload 12
    //   392: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload_0
    //   396: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   399: aload 11
    //   401: aload_3
    //   402: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   405: iconst_1
    //   406: invokeinterface 1051 4 0
    //   411: ifeq +362 -> 773
    //   414: aload 13
    //   416: astore 20
    //   418: aload 20
    //   420: iconst_1
    //   421: putfield 1054	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   424: aload 17
    //   426: invokevirtual 640	java/io/InputStream:close	()V
    //   429: aload_0
    //   430: aload_2
    //   431: aload 8
    //   433: invokespecial 1023	com/tencent/theme/SkinEngine:getInputStream	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   436: astore 22
    //   438: aload_3
    //   439: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   442: astore 15
    //   444: aload_0
    //   445: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
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
    //   478: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   481: astore 23
    //   483: aload 8
    //   485: astore 14
    //   487: aload 10
    //   489: astore 13
    //   491: aload 9
    //   493: astore 12
    //   495: aload_0
    //   496: getfield 1056	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   499: ifnull +1463 -> 1962
    //   502: aload 8
    //   504: astore 14
    //   506: aload 10
    //   508: astore 13
    //   510: aload 9
    //   512: astore 12
    //   514: aload_0
    //   515: getfield 1056	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   518: iload_1
    //   519: invokestatic 1060	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: invokevirtual 1063	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   525: ifeq +1437 -> 1962
    //   528: aload 8
    //   530: astore 14
    //   532: aload 10
    //   534: astore 13
    //   536: aload 9
    //   538: astore 12
    //   540: aload_0
    //   541: getfield 1056	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   544: iload_1
    //   545: invokestatic 1060	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: invokevirtual 1064	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: ifnull +1411 -> 1962
    //   554: iconst_1
    //   555: istore 5
    //   557: goto +3 -> 560
    //   560: iload 5
    //   562: ifeq +1458 -> 2020
    //   565: aload 8
    //   567: astore 14
    //   569: aload 10
    //   571: astore 13
    //   573: aload 9
    //   575: astore 12
    //   577: aload_0
    //   578: getfield 1056	com/tencent/theme/SkinEngine:backupForOOMData	Ljava/util/HashMap;
    //   581: iload_1
    //   582: invokestatic 1060	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: invokevirtual 1064	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   588: checkcast 1066	com/tencent/theme/SkinEngine$BackupForOOMData
    //   591: astore 25
    //   593: aload 8
    //   595: astore 14
    //   597: aload 10
    //   599: astore 13
    //   601: aload 9
    //   603: astore 12
    //   605: aload 20
    //   607: getfield 1069	android/graphics/BitmapFactory$Options:outWidth	I
    //   610: bipush 8
    //   612: idiv
    //   613: aload 20
    //   615: getfield 1072	android/graphics/BitmapFactory$Options:outHeight	I
    //   618: bipush 8
    //   620: idiv
    //   621: invokestatic 1078	java/lang/Math:min	(II)I
    //   624: bipush 8
    //   626: invokestatic 1081	java/lang/Math:max	(II)I
    //   629: istore 5
    //   631: aconst_null
    //   632: astore 12
    //   634: iconst_2
    //   635: istore 6
    //   637: iload 6
    //   639: iload 5
    //   641: if_icmpgt +1352 -> 1993
    //   644: aload 8
    //   646: astore 14
    //   648: aload 10
    //   650: astore 13
    //   652: aload 9
    //   654: astore 12
    //   656: aload_0
    //   657: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
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
    //   704: invokevirtual 1085	com/tencent/theme/SkinEngine:createSmallImageFromResourceStream	(Landroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/BaseConstantState;
    //   707: astore 21
    //   709: aload 21
    //   711: ifnull +1257 -> 1968
    //   714: aload 21
    //   716: astore 12
    //   718: goto +3 -> 721
    //   721: aload 12
    //   723: astore 13
    //   725: aload 12
    //   727: ifnonnull +1269 -> 1996
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
    //   754: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   757: aload 25
    //   759: iconst_1
    //   760: iconst_1
    //   761: invokevirtual 1085	com/tencent/theme/SkinEngine:createSmallImageFromResourceStream	(Landroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;ZLcom/tencent/theme/SkinEngine$BackupForOOMData;IZ)Lcom/tencent/theme/BaseConstantState;
    //   764: astore 16
    //   766: aload 16
    //   768: astore 13
    //   770: goto +1226 -> 1996
    //   773: aload 16
    //   775: astore 15
    //   777: ldc_w 1021
    //   780: astore 14
    //   782: ldc_w 968
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
    //   812: invokevirtual 640	java/io/InputStream:close	()V
    //   815: aload 16
    //   817: ifnull +55 -> 872
    //   820: aload 8
    //   822: astore 12
    //   824: aload 9
    //   826: astore 13
    //   828: aload 10
    //   830: astore 14
    //   832: aload 11
    //   834: astore 15
    //   836: aload_0
    //   837: invokevirtual 1088	com/tencent/theme/SkinEngine:isInSimpleModel	()Z
    //   840: ifeq +29 -> 869
    //   843: aload 8
    //   845: astore 12
    //   847: aload 9
    //   849: astore 13
    //   851: aload 10
    //   853: astore 14
    //   855: aload 11
    //   857: astore 15
    //   859: aload_0
    //   860: aload 16
    //   862: aload_3
    //   863: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   866: invokespecial 1092	com/tencent/theme/SkinEngine:tintConstantState	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   869: aload 16
    //   871: areturn
    //   872: goto +163 -> 1035
    //   875: astore 8
    //   877: goto +31 -> 908
    //   880: astore 10
    //   882: aload 9
    //   884: astore 15
    //   886: aload 10
    //   888: astore 9
    //   890: ldc_w 1021
    //   893: astore 14
    //   895: ldc_w 968
    //   898: astore 13
    //   900: aload 8
    //   902: astore 12
    //   904: aload 9
    //   906: astore 8
    //   908: getstatic 645	com/tencent/theme/SkinEngine:DEBUG	Z
    //   911: ifeq +52 -> 963
    //   914: new 257	java/lang/StringBuilder
    //   917: dup
    //   918: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   921: astore 9
    //   923: aload 9
    //   925: ldc_w 1094
    //   928: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload 9
    //   934: aload 12
    //   936: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 9
    //   942: ldc_w 1096
    //   945: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload 15
    //   951: aload 9
    //   953: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokestatic 1099	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   959: pop
    //   960: goto +3 -> 963
    //   963: aload 15
    //   965: astore 11
    //   967: new 257	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   974: astore 9
    //   976: aload 9
    //   978: ldc_w 1101
    //   981: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload 9
    //   987: aload 12
    //   989: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload 11
    //   995: iconst_1
    //   996: aload 9
    //   998: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: aload 8
    //   1003: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1006: aload 12
    //   1008: astore 8
    //   1010: aload 13
    //   1012: astore 9
    //   1014: aload 14
    //   1016: astore 10
    //   1018: goto +17 -> 1035
    //   1021: ldc_w 1021
    //   1024: astore 10
    //   1026: ldc_w 968
    //   1029: astore 9
    //   1031: ldc 64
    //   1033: astore 11
    //   1035: aload_3
    //   1036: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1039: aload 9
    //   1041: invokevirtual 971	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1044: ifeq +268 -> 1312
    //   1047: aload_0
    //   1048: iload_1
    //   1049: aload 4
    //   1051: invokespecial 1005	com/tencent/theme/SkinEngine:getXml	(ILandroid/util/TypedValue;)Landroid/content/res/XmlResourceParser;
    //   1054: astore 9
    //   1056: aload 8
    //   1058: ifnull +97 -> 1155
    //   1061: aload_0
    //   1062: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   1065: ifeq +15 -> 1080
    //   1068: new 503	com/tencent/theme/AndroidXmlResourceParser
    //   1071: dup
    //   1072: invokespecial 504	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   1075: astore 4
    //   1077: goto +8 -> 1085
    //   1080: invokestatic 510	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   1083: astore 4
    //   1085: new 512	java/io/FileInputStream
    //   1088: dup
    //   1089: aload 8
    //   1091: invokespecial 1102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   1094: astore 10
    //   1096: aload 4
    //   1098: aload 10
    //   1100: ldc_w 527
    //   1103: invokeinterface 533 3 0
    //   1108: aload_0
    //   1109: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   1112: istore 7
    //   1114: aload_2
    //   1115: aload 9
    //   1117: aload 4
    //   1119: iload 7
    //   1121: invokestatic 1105	com/tencent/theme/ResourcesFactory:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/BaseConstantState;
    //   1124: astore_2
    //   1125: aload 10
    //   1127: invokevirtual 534	java/io/FileInputStream:close	()V
    //   1130: aload 9
    //   1132: invokeinterface 483 1 0
    //   1137: aload_0
    //   1138: invokevirtual 1088	com/tencent/theme/SkinEngine:isInSimpleModel	()Z
    //   1141: ifeq +966 -> 2107
    //   1144: aload_0
    //   1145: aload_2
    //   1146: aload_3
    //   1147: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1150: invokespecial 1092	com/tencent/theme/SkinEngine:tintConstantState	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   1153: aload_2
    //   1154: areturn
    //   1155: aload_0
    //   1156: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   1159: istore 7
    //   1161: aload_2
    //   1162: aload 9
    //   1164: aconst_null
    //   1165: iload 7
    //   1167: invokestatic 1105	com/tencent/theme/ResourcesFactory:a	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/BaseConstantState;
    //   1170: astore_2
    //   1171: aload 9
    //   1173: invokeinterface 483 1 0
    //   1178: aload_0
    //   1179: aload_2
    //   1180: aload_3
    //   1181: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1184: invokespecial 1092	com/tencent/theme/SkinEngine:tintConstantState	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   1187: aload_2
    //   1188: areturn
    //   1189: astore_2
    //   1190: goto +8 -> 1198
    //   1193: astore_2
    //   1194: goto +4 -> 1198
    //   1197: astore_2
    //   1198: new 257	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1205: astore 4
    //   1207: aload 4
    //   1209: ldc_w 1107
    //   1212: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload 4
    //   1218: aload 8
    //   1220: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: aload 11
    //   1226: iconst_1
    //   1227: aload 4
    //   1229: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1232: aload_2
    //   1233: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1236: getstatic 645	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1239: ifne +5 -> 1244
    //   1242: aconst_null
    //   1243: areturn
    //   1244: new 257	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1251: astore 4
    //   1253: aload 4
    //   1255: ldc_w 1001
    //   1258: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 4
    //   1264: aload_3
    //   1265: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1268: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 4
    //   1274: ldc_w 1109
    //   1277: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 4
    //   1283: iload_1
    //   1284: invokestatic 617	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1287: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: new 488	android/content/res/Resources$NotFoundException
    //   1294: dup
    //   1295: aload 4
    //   1297: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1300: invokespecial 493	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1303: astore_3
    //   1304: aload_3
    //   1305: aload_2
    //   1306: invokevirtual 497	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1309: pop
    //   1310: aload_3
    //   1311: athrow
    //   1312: getstatic 153	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   1315: ifeq +85 -> 1400
    //   1318: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1321: iconst_1
    //   1322: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   1325: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1328: aload_0
    //   1329: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1332: aconst_null
    //   1333: invokevirtual 780	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1336: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1339: iconst_1
    //   1340: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   1343: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1346: aload_0
    //   1347: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1350: aconst_null
    //   1351: invokevirtual 780	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   1354: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1357: iconst_1
    //   1358: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   1361: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1364: iconst_1
    //   1365: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   1368: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   1371: aload_0
    //   1372: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1375: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1378: ifnull +22 -> 1400
    //   1381: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   1384: aload_0
    //   1385: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   1388: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1391: astore 8
    //   1393: aload 8
    //   1395: ifnull +5 -> 1400
    //   1398: aconst_null
    //   1399: areturn
    //   1400: aload_2
    //   1401: iload_1
    //   1402: aload 4
    //   1404: invokevirtual 1113	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1407: astore 8
    //   1409: aload 4
    //   1411: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   1414: invokeinterface 444 1 0
    //   1419: astore 13
    //   1421: new 1025	android/graphics/BitmapFactory$Options
    //   1424: dup
    //   1425: invokespecial 1026	android/graphics/BitmapFactory$Options:<init>	()V
    //   1428: astore 14
    //   1430: aload_2
    //   1431: aload 4
    //   1433: aload 8
    //   1435: aload 13
    //   1437: aload 14
    //   1439: aload 24
    //   1441: iconst_1
    //   1442: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1445: astore 9
    //   1447: aload 8
    //   1449: astore_2
    //   1450: aload 9
    //   1452: astore 4
    //   1454: goto +262 -> 1716
    //   1457: astore_2
    //   1458: goto +319 -> 1777
    //   1461: astore 15
    //   1463: new 257	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1470: astore 9
    //   1472: aload 9
    //   1474: aload 10
    //   1476: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: pop
    //   1480: aload 9
    //   1482: aload_3
    //   1483: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1486: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload 11
    //   1492: iconst_1
    //   1493: aload 9
    //   1495: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1498: aload 15
    //   1500: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1503: aload_0
    //   1504: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   1507: ifnull +602 -> 2109
    //   1510: aload_0
    //   1511: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   1514: aload 15
    //   1516: aload_3
    //   1517: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1520: iconst_0
    //   1521: invokeinterface 1046 4 0
    //   1526: ifeq +583 -> 2109
    //   1529: aload 8
    //   1531: invokevirtual 640	java/io/InputStream:close	()V
    //   1534: aload_2
    //   1535: iload_1
    //   1536: aload 4
    //   1538: invokevirtual 1113	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1541: astore 9
    //   1543: aload 9
    //   1545: astore 8
    //   1547: aload_2
    //   1548: aload 4
    //   1550: aload 9
    //   1552: aload 13
    //   1554: aload 14
    //   1556: aload 24
    //   1558: iconst_1
    //   1559: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1562: astore 12
    //   1564: aload 12
    //   1566: astore 4
    //   1568: aload 9
    //   1570: astore_2
    //   1571: goto -117 -> 1454
    //   1574: astore 12
    //   1576: aload 9
    //   1578: astore 8
    //   1580: new 257	java/lang/StringBuilder
    //   1583: dup
    //   1584: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1587: astore 16
    //   1589: aload 9
    //   1591: astore 8
    //   1593: aload 16
    //   1595: aload 10
    //   1597: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 9
    //   1603: astore 8
    //   1605: aload 16
    //   1607: aload_3
    //   1608: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1611: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1614: pop
    //   1615: aload 9
    //   1617: astore 8
    //   1619: aload 11
    //   1621: iconst_1
    //   1622: aload 16
    //   1624: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: aload 15
    //   1629: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1632: aload 9
    //   1634: astore 8
    //   1636: aload_0
    //   1637: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   1640: aload 12
    //   1642: aload_3
    //   1643: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1646: iconst_0
    //   1647: invokeinterface 1051 4 0
    //   1652: ifeq +57 -> 1709
    //   1655: aload 9
    //   1657: astore 8
    //   1659: aload 14
    //   1661: iconst_1
    //   1662: putfield 1054	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1665: aload 9
    //   1667: astore 8
    //   1669: aload_2
    //   1670: iload_1
    //   1671: aload 4
    //   1673: invokevirtual 1113	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   1676: astore 9
    //   1678: aload_2
    //   1679: aload 4
    //   1681: aload 9
    //   1683: aload 13
    //   1685: aload 14
    //   1687: aload 24
    //   1689: iconst_1
    //   1690: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   1693: astore 4
    //   1695: aload 9
    //   1697: astore_2
    //   1698: goto +18 -> 1716
    //   1701: astore_2
    //   1702: aload 9
    //   1704: astore 8
    //   1706: goto +71 -> 1777
    //   1709: aload 9
    //   1711: astore 8
    //   1713: aload 12
    //   1715: athrow
    //   1716: aload_2
    //   1717: astore 8
    //   1719: aload_2
    //   1720: invokevirtual 640	java/io/InputStream:close	()V
    //   1723: aload 4
    //   1725: ifnonnull +31 -> 1756
    //   1728: aload_2
    //   1729: astore 8
    //   1731: aload_0
    //   1732: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   1735: ifnull +21 -> 1756
    //   1738: aload_2
    //   1739: astore 8
    //   1741: aload_0
    //   1742: getfield 1040	com/tencent/theme/SkinEngine:mSkinEngineHandler	Lcom/tencent/theme/SkinEngineHandler;
    //   1745: aload_3
    //   1746: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1749: iconst_0
    //   1750: invokeinterface 1116 3 0
    //   1755: pop
    //   1756: aload_2
    //   1757: astore 8
    //   1759: aload_0
    //   1760: aload 4
    //   1762: aload_3
    //   1763: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1766: invokespecial 1092	com/tencent/theme/SkinEngine:tintConstantState	(Lcom/tencent/theme/BaseConstantState;Ljava/lang/String;)V
    //   1769: aload 4
    //   1771: areturn
    //   1772: astore_2
    //   1773: goto +4 -> 1777
    //   1776: astore_2
    //   1777: new 257	java/lang/StringBuilder
    //   1780: dup
    //   1781: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1784: astore 4
    //   1786: aload 4
    //   1788: ldc_w 1118
    //   1791: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: pop
    //   1795: aload 4
    //   1797: aload_3
    //   1798: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1801: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1804: pop
    //   1805: aload 11
    //   1807: iconst_1
    //   1808: aload 4
    //   1810: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: aload_2
    //   1814: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1817: getstatic 645	com/tencent/theme/SkinEngine:DEBUG	Z
    //   1820: ifne +5 -> 1825
    //   1823: aconst_null
    //   1824: areturn
    //   1825: new 257	java/lang/StringBuilder
    //   1828: dup
    //   1829: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1832: astore 4
    //   1834: aload 4
    //   1836: ldc_w 1001
    //   1839: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: pop
    //   1843: aload 4
    //   1845: aload_3
    //   1846: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1849: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: pop
    //   1853: aload 4
    //   1855: ldc_w 1109
    //   1858: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1861: pop
    //   1862: aload 4
    //   1864: iload_1
    //   1865: invokestatic 617	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1868: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1871: pop
    //   1872: aload 4
    //   1874: ldc_w 1120
    //   1877: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: pop
    //   1881: aload 4
    //   1883: aload 8
    //   1885: invokevirtual 751	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1888: invokevirtual 835	java/lang/Class:getName	()Ljava/lang/String;
    //   1891: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: pop
    //   1895: new 488	android/content/res/Resources$NotFoundException
    //   1898: dup
    //   1899: aload 4
    //   1901: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1904: invokespecial 493	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   1907: astore_3
    //   1908: aload_3
    //   1909: aload_2
    //   1910: invokevirtual 497	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   1913: pop
    //   1914: aload_3
    //   1915: athrow
    //   1916: astore_2
    //   1917: new 257	java/lang/StringBuilder
    //   1920: dup
    //   1921: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   1924: astore 4
    //   1926: aload 4
    //   1928: ldc_w 1122
    //   1931: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1934: pop
    //   1935: aload 4
    //   1937: aload_3
    //   1938: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   1941: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: pop
    //   1945: aload 11
    //   1947: iconst_1
    //   1948: aload 4
    //   1950: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: aload_2
    //   1954: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1957: aconst_null
    //   1958: areturn
    //   1959: astore_2
    //   1960: aconst_null
    //   1961: areturn
    //   1962: iconst_0
    //   1963: istore 5
    //   1965: goto -1405 -> 560
    //   1968: iload 6
    //   1970: iconst_2
    //   1971: imul
    //   1972: istore 6
    //   1974: aload 19
    //   1976: astore 8
    //   1978: aload 18
    //   1980: astore 9
    //   1982: aload 17
    //   1984: astore 10
    //   1986: aload 21
    //   1988: astore 12
    //   1990: goto -1353 -> 637
    //   1993: goto -1272 -> 721
    //   1996: aload 8
    //   1998: astore 12
    //   2000: aload 9
    //   2002: astore 14
    //   2004: aload 10
    //   2006: astore 15
    //   2008: aload 13
    //   2010: ifnull +24 -> 2034
    //   2013: aload 13
    //   2015: astore 16
    //   2017: goto +33 -> 2050
    //   2020: ldc_w 1021
    //   2023: astore 15
    //   2025: ldc_w 968
    //   2028: astore 14
    //   2030: aload 8
    //   2032: astore 12
    //   2034: aload 23
    //   2036: astore 16
    //   2038: aload 15
    //   2040: astore 10
    //   2042: aload 14
    //   2044: astore 9
    //   2046: aload 12
    //   2048: astore 8
    //   2050: aload 22
    //   2052: astore 17
    //   2054: goto -1260 -> 794
    //   2057: astore 8
    //   2059: aload 13
    //   2061: astore 10
    //   2063: aload 12
    //   2065: astore 9
    //   2067: goto +13 -> 2080
    //   2070: astore 11
    //   2072: aload 8
    //   2074: astore 14
    //   2076: aload 11
    //   2078: astore 8
    //   2080: aload 16
    //   2082: astore 15
    //   2084: aload 14
    //   2086: astore 12
    //   2088: goto -1763 -> 325
    //   2091: ldc_w 1021
    //   2094: astore 10
    //   2096: ldc_w 968
    //   2099: astore 9
    //   2101: aconst_null
    //   2102: astore 16
    //   2104: goto -1310 -> 794
    //   2107: aload_2
    //   2108: areturn
    //   2109: aconst_null
    //   2110: astore 4
    //   2112: aload 8
    //   2114: astore_2
    //   2115: goto -399 -> 1716
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2118	0	this	SkinEngine
    //   0	2118	1	paramInt	int
    //   0	2118	2	paramResources	Resources
    //   0	2118	3	paramSkinData	SkinData
    //   0	2118	4	paramTypedValue	TypedValue
    //   555	1409	5	i	int
    //   635	1338	6	j	int
    //   97	1069	7	bool	boolean
    //   18	826	8	localObject1	Object
    //   875	26	8	localIOException1	IOException
    //   906	1143	8	localObject2	Object
    //   2057	16	8	localIOException2	IOException
    //   2078	35	8	localObject3	Object
    //   42	87	9	str1	String
    //   133	1	9	localIOException3	IOException
    //   156	1944	9	localObject4	Object
    //   3	849	10	str2	String
    //   880	7	10	localIOException4	IOException
    //   1016	1079	10	localObject5	Object
    //   22	245	11	str3	String
    //   311	11	11	localIOException5	IOException
    //   336	1	11	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   341	59	11	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   452	1494	11	localObject6	Object
    //   2070	7	11	localIOException6	IOException
    //   87	17	12	str4	String
    //   142	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   147	73	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   319	1246	12	localObject7	Object
    //   1574	140	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1988	99	12	localObject8	Object
    //   64	1996	13	localObject9	Object
    //   180	1905	14	localObject10	Object
    //   137	827	15	localObject11	Object
    //   1461	167	15	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   2006	77	15	localObject12	Object
    //   114	1989	16	localObject13	Object
    //   51	2002	17	localObject14	Object
    //   668	1311	18	localObject15	Object
    //   672	1303	19	localObject16	Object
    //   416	334	20	localObject17	Object
    //   707	1280	21	localBaseConstantState1	BaseConstantState
    //   436	1615	22	localInputStream	InputStream
    //   481	1554	23	localBaseConstantState2	BaseConstantState
    //   12	1676	24	localRect	Rect
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
    //   690	709	875	java/io/IOException
    //   746	766	875	java/io/IOException
    //   791	794	875	java/io/IOException
    //   810	815	875	java/io/IOException
    //   836	843	875	java/io/IOException
    //   859	869	875	java/io/IOException
    //   44	53	880	java/io/IOException
    //   57	66	880	java/io/IOException
    //   70	79	880	java/io/IOException
    //   83	89	880	java/io/IOException
    //   93	99	880	java/io/IOException
    //   190	200	880	java/io/IOException
    //   204	211	880	java/io/IOException
    //   215	234	880	java/io/IOException
    //   238	243	880	java/io/IOException
    //   247	256	880	java/io/IOException
    //   260	266	880	java/io/IOException
    //   270	276	880	java/io/IOException
    //   1161	1187	1189	java/lang/Exception
    //   1114	1153	1193	java/lang/Exception
    //   1155	1161	1193	java/lang/Exception
    //   1047	1056	1197	java/lang/Exception
    //   1061	1077	1197	java/lang/Exception
    //   1080	1085	1197	java/lang/Exception
    //   1085	1114	1197	java/lang/Exception
    //   1430	1447	1457	java/io/IOException
    //   1463	1543	1457	java/io/IOException
    //   1430	1447	1461	java/lang/OutOfMemoryError
    //   1547	1564	1574	java/lang/OutOfMemoryError
    //   1678	1695	1701	java/io/IOException
    //   1547	1564	1772	java/io/IOException
    //   1580	1589	1772	java/io/IOException
    //   1593	1601	1772	java/io/IOException
    //   1605	1615	1772	java/io/IOException
    //   1619	1632	1772	java/io/IOException
    //   1636	1655	1772	java/io/IOException
    //   1659	1665	1772	java/io/IOException
    //   1669	1678	1772	java/io/IOException
    //   1713	1716	1772	java/io/IOException
    //   1719	1723	1772	java/io/IOException
    //   1731	1738	1772	java/io/IOException
    //   1741	1756	1772	java/io/IOException
    //   1759	1769	1772	java/io/IOException
    //   1421	1430	1776	java/io/IOException
    //   1400	1409	1916	java/lang/Exception
    //   1318	1354	1959	java/lang/Exception
    //   1354	1393	1959	java/lang/Exception
    //   466	483	2057	java/io/IOException
    //   495	502	2057	java/io/IOException
    //   514	528	2057	java/io/IOException
    //   540	554	2057	java/io/IOException
    //   577	593	2057	java/io/IOException
    //   605	631	2057	java/io/IOException
    //   656	662	2057	java/io/IOException
    //   385	414	2070	java/io/IOException
    //   418	450	2070	java/io/IOException
  }
  
  private TypedValue obtainTempTypedValue()
  {
    synchronized (this.mTmpValueLock)
    {
      if (this.mTempValue != null)
      {
        localTypedValue = this.mTempValue;
        this.mTempValue = null;
      }
      TypedValue localTypedValue = this.mTempValue;
      ??? = localTypedValue;
      if (localTypedValue == null) {
        ??? = new TypedValue();
      }
      return ???;
    }
  }
  
  private HashMap<String, Object> parseXml(XmlPullParser paramXmlPullParser)
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2)
    {
      String str1 = paramXmlPullParser.getName();
      HashMap localHashMap = new HashMap();
      if (str1.equals("resources"))
      {
        i = paramXmlPullParser.getDepth();
        for (;;)
        {
          int j = paramXmlPullParser.next();
          if ((j == 1) || ((paramXmlPullParser.getDepth() < i + 1) && (j == 3))) {
            break;
          }
          if (j == 2)
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
  
  private void releaseTempTypedValue(TypedValue paramTypedValue)
  {
    synchronized (this.mTmpValueLock)
    {
      if (this.mTempValue == null) {
        this.mTempValue = paramTypedValue;
      }
      return;
    }
  }
  
  private void reloadImage(BaseConstantState paramBaseConstantState)
  {
    Object localObject1 = paramBaseConstantState.skinData;
    Object localObject2 = ((SkinData)localObject1).mFilePath;
    Object localObject3;
    Object localObject4;
    int i;
    if ((this.mSkinRootPath == null) && (this.mSimpleSkinRootPath == null))
    {
      ((SkinData)localObject1).mFilePath = null;
    }
    else
    {
      this.mTmpValue.resourceId = ((SkinData)localObject1).mResourcesID;
      localObject3 = this.mResources;
      localObject4 = this.mTmpValue;
      String str = ((SkinData)localObject1).mFileName;
      String[][] arrayOfString = DENSITY_PATH_ORDER;
      i = this.mDensityIndex;
      grabImageFile((Resources)localObject3, (TypedValue)localObject4, str, arrayOfString[i], DENSITY_ORDER[i]);
      if (this.mTmpValue.string != null)
      {
        ((SkinData)localObject1).mFilePath = this.mTmpValue.string.toString();
        ((SkinData)localObject1).mInDensity = this.mTmpValue.density;
      }
      else
      {
        ((SkinData)localObject1).mFilePath = null;
      }
    }
    if (isTrackLoadRes(((SkinData)localObject1).mFileName))
    {
      i = getLogLevel(((SkinData)localObject1).mFileName);
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
      ((StringBuilder)localObject3).append(this.mDrawableCache.size());
      h.a("SkinEngine", i, ((StringBuilder)localObject3).toString());
    }
    if ((localObject2 == null) && (((SkinData)localObject1).mFilePath == null) && (!((SkinData)localObject1).mFileName.endsWith(".xml")))
    {
      localObject3 = this.mSkinTint;
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
      localObject3 = loadImage(((SkinData)localObject1).mResourcesID, this.mResources, (SkinData)localObject1, this.mTmpValue);
      if (localObject3 == null)
      {
        if (isTrackLoadRes(((SkinData)localObject1).mFileName))
        {
          i = getLogLevel(((SkinData)localObject1).mFileName);
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
          paramBaseConstantState.append(this.mDrawableCache.size());
          h.a("SkinEngine", i, paramBaseConstantState.toString());
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
      if (isTrackLoadRes(((SkinData)localObject1).mFileName))
      {
        i = getLogLevel(((SkinData)localObject1).mFileName);
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
        ((StringBuilder)localObject4).append(this.mDrawableCache.size());
        h.a("SkinEngine", i, ((StringBuilder)localObject4).toString());
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
      tintConstantState((BaseConstantState)localObject2, ((SkinData)localObject1).mFileName);
      return;
    }
    if ((paramBaseConstantState instanceof SkinnableNinePatchDrawable.a))
    {
      paramBaseConstantState = (SkinnableNinePatchDrawable.a)paramBaseConstantState;
      localObject3 = loadImage(((SkinData)localObject1).mResourcesID, this.mResources, (SkinData)localObject1, this.mTmpValue);
      if (localObject3 == null)
      {
        if (isTrackLoadRes(((SkinData)localObject1).mFileName))
        {
          i = getLogLevel(((SkinData)localObject1).mFileName);
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
          paramBaseConstantState.append(this.mDrawableCache.size());
          h.a("SkinEngine", i, paramBaseConstantState.toString());
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
      if (isTrackLoadRes(((SkinData)localObject1).mFileName))
      {
        i = getLogLevel(((SkinData)localObject1).mFileName);
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
        ((StringBuilder)localObject4).append(this.mDrawableCache.size());
        h.a("SkinEngine", i, ((StringBuilder)localObject4).toString());
      }
      localObject2 = (SkinnableNinePatchDrawable.a)localObject3;
      paramBaseConstantState.mImageSizeWhenOOM = ((SkinnableNinePatchDrawable.a)localObject2).mImageSizeWhenOOM;
      paramBaseConstantState.a = ((SkinnableNinePatchDrawable.a)localObject2).a;
      paramBaseConstantState.h = ((SkinnableNinePatchDrawable.a)localObject2).h;
      paramBaseConstantState.c = paramBaseConstantState.b;
      paramBaseConstantState.b = ((SkinnableNinePatchDrawable.a)localObject2).b;
      paramBaseConstantState.g = ((SkinnableNinePatchDrawable.a)localObject2).g;
      paramBaseConstantState.hasProblem = ((SkinnableNinePatchDrawable.a)localObject2).hasProblem;
      tintConstantState((BaseConstantState)localObject2, ((SkinData)localObject1).mFileName);
    }
  }
  
  public static void setSKLog(ISkinEngineLog paramISkinEngineLog)
  {
    h.a = paramISkinEngineLog;
    h.c("SkinEngine", 2, "set ISkinEngineLog ok", null);
  }
  
  private void tintConstantState(BaseConstantState paramBaseConstantState, String paramString)
  {
    if ((this.mSkinTint != null) && (paramBaseConstantState != null) && (!TextUtils.isEmpty(paramString)))
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
      this.mSkinTint.tint((Paint)localObject1, paramString);
    }
  }
  
  /* Error */
  @TargetApi(16)
  private void updateColorState(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: iconst_0
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 232	com/tencent/theme/SkinEngine:mColorStateListCache	Landroid/util/LongSparseArray;
    //   16: invokevirtual 398	android/util/LongSparseArray:size	()I
    //   19: istore_3
    //   20: iload_2
    //   21: iload_3
    //   22: if_icmpge +264 -> 286
    //   25: aload_0
    //   26: getfield 232	com/tencent/theme/SkinEngine:mColorStateListCache	Landroid/util/LongSparseArray;
    //   29: iload_2
    //   30: invokevirtual 402	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   33: checkcast 404	java/lang/ref/WeakReference
    //   36: astore_1
    //   37: goto +264 -> 301
    //   40: astore_1
    //   41: ldc 64
    //   43: iconst_1
    //   44: ldc_w 1324
    //   47: aload_1
    //   48: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   51: aconst_null
    //   52: astore_1
    //   53: goto +248 -> 301
    //   56: aload_1
    //   57: invokevirtual 411	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   60: checkcast 983	com/tencent/theme/SkinnableColorStateList
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +201 -> 266
    //   68: aload_1
    //   69: getfield 1325	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   72: astore 4
    //   74: aload 4
    //   76: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   79: astore 5
    //   81: aload 4
    //   83: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   86: ldc_w 1327
    //   89: invokevirtual 593	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +13 -> 105
    //   95: ldc_w 1329
    //   98: ldc_w 842
    //   101: invokestatic 1331	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: aload_0
    //   106: getfield 499	com/tencent/theme/SkinEngine:mSkinRootPath	Ljava/lang/String;
    //   109: ifnonnull +22 -> 131
    //   112: aload_0
    //   113: getfield 501	com/tencent/theme/SkinEngine:mSimpleSkinRootPath	Ljava/lang/String;
    //   116: ifnull +6 -> 122
    //   119: goto +12 -> 131
    //   122: aload 4
    //   124: aconst_null
    //   125: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   128: goto +39 -> 167
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   136: aload 4
    //   138: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   141: invokespecial 1333	com/tencent/theme/SkinEngine:grabColorFile	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   144: astore 6
    //   146: aload 6
    //   148: ifnull +13 -> 161
    //   151: aload 4
    //   153: aload 6
    //   155: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   158: goto +9 -> 167
    //   161: aload 4
    //   163: aconst_null
    //   164: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   167: aload 5
    //   169: ifnonnull +11 -> 180
    //   172: aload 4
    //   174: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   177: ifnull +17 -> 194
    //   180: aload_0
    //   181: aload_1
    //   182: getfield 1325	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   185: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   188: invokespecial 981	com/tencent/theme/SkinEngine:checkNeedTintColor	(Ljava/lang/String;)Z
    //   191: ifeq +56 -> 247
    //   194: aload_0
    //   195: aload_1
    //   196: getfield 1325	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   199: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   202: invokespecial 981	com/tencent/theme/SkinEngine:checkNeedTintColor	(Ljava/lang/String;)Z
    //   205: ifeq +42 -> 247
    //   208: aload_0
    //   209: getfield 319	com/tencent/theme/SkinEngine:mSkinTint	Lcom/tencent/theme/ISkinTint;
    //   212: aload_1
    //   213: invokevirtual 987	com/tencent/theme/SkinnableColorStateList:getColors	()[I
    //   216: aload_1
    //   217: invokevirtual 991	com/tencent/theme/SkinnableColorStateList:getStateSpecs	()[[I
    //   220: aload_1
    //   221: getfield 1325	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   224: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   227: invokeinterface 995 4 0
    //   232: aload_1
    //   233: aload_1
    //   234: invokevirtual 987	com/tencent/theme/SkinnableColorStateList:getColors	()[I
    //   237: aload_1
    //   238: invokevirtual 991	com/tencent/theme/SkinnableColorStateList:getStateSpecs	()[[I
    //   241: invokevirtual 999	com/tencent/theme/SkinnableColorStateList:setDefaultColor	([I[[I)V
    //   244: goto +22 -> 266
    //   247: aload_1
    //   248: aload_0
    //   249: aload 4
    //   251: getfield 1209	com/tencent/theme/SkinData:mResourcesID	I
    //   254: aload_0
    //   255: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   258: aload 4
    //   260: invokespecial 1335	com/tencent/theme/SkinEngine:loadColor	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;)Lcom/tencent/theme/SkinnableColorStateList;
    //   263: invokevirtual 1338	com/tencent/theme/SkinnableColorStateList:a	(Lcom/tencent/theme/SkinnableColorStateList;)V
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_2
    //   270: goto -258 -> 12
    //   273: astore_1
    //   274: aload_0
    //   275: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   278: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   281: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   284: aload_1
    //   285: athrow
    //   286: aload_0
    //   287: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   290: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   293: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   296: return
    //   297: astore_1
    //   298: goto -12 -> 286
    //   301: aload_1
    //   302: ifnonnull -246 -> 56
    //   305: goto -39 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	SkinEngine
    //   0	308	1	paramContext	Context
    //   11	259	2	i	int
    //   19	4	3	j	int
    //   72	187	4	localSkinData	SkinData
    //   79	89	5	str1	String
    //   144	10	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   25	37	40	java/lang/ClassCastException
    //   12	20	273	finally
    //   25	37	273	finally
    //   41	51	273	finally
    //   56	64	273	finally
    //   68	105	273	finally
    //   105	119	273	finally
    //   122	128	273	finally
    //   131	146	273	finally
    //   151	158	273	finally
    //   161	167	273	finally
    //   172	180	273	finally
    //   180	194	273	finally
    //   194	244	273	finally
    //   247	266	273	finally
    //   12	20	297	java/lang/Exception
    //   25	37	297	java/lang/Exception
    //   41	51	297	java/lang/Exception
    //   56	64	297	java/lang/Exception
    //   68	105	297	java/lang/Exception
    //   105	119	297	java/lang/Exception
    //   122	128	297	java/lang/Exception
    //   131	146	297	java/lang/Exception
    //   151	158	297	java/lang/Exception
    //   161	167	297	java/lang/Exception
    //   172	180	297	java/lang/Exception
    //   180	194	297	java/lang/Exception
    //   194	244	297	java/lang/Exception
    //   247	266	297	java/lang/Exception
  }
  
  /* Error */
  @TargetApi(16)
  private void updateImage()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: new 1344	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 1345	java/util/ArrayList:<init>	()V
    //   17: astore 4
    //   19: iconst_0
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   25: invokevirtual 398	android/util/LongSparseArray:size	()I
    //   28: istore_2
    //   29: iload_1
    //   30: iload_2
    //   31: if_icmpge +81 -> 112
    //   34: aload_0
    //   35: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   38: iload_1
    //   39: invokevirtual 402	android/util/LongSparseArray:valueAt	(I)Ljava/lang/Object;
    //   42: checkcast 404	java/lang/ref/WeakReference
    //   45: astore_3
    //   46: goto +16 -> 62
    //   49: astore_3
    //   50: ldc 64
    //   52: iconst_1
    //   53: ldc_w 1347
    //   56: aload_3
    //   57: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aconst_null
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull +108 -> 171
    //   66: aload_3
    //   67: invokevirtual 411	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   70: checkcast 1202	com/tencent/theme/BaseConstantState
    //   73: astore_3
    //   74: aload_3
    //   75: ifnull +96 -> 171
    //   78: aload_3
    //   79: getfield 1206	com/tencent/theme/BaseConstantState:skinData	Lcom/tencent/theme/SkinData;
    //   82: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   85: ldc_w 968
    //   88: invokevirtual 971	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   91: ifeq +13 -> 104
    //   94: aload 4
    //   96: aload_3
    //   97: invokevirtual 1350	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto +70 -> 171
    //   104: aload_0
    //   105: aload_3
    //   106: invokespecial 1352	com/tencent/theme/SkinEngine:reloadImage	(Lcom/tencent/theme/BaseConstantState;)V
    //   109: goto +62 -> 171
    //   112: aload 4
    //   114: invokevirtual 1356	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   117: astore_3
    //   118: aload_3
    //   119: invokeinterface 1361 1 0
    //   124: ifeq +32 -> 156
    //   127: aload_0
    //   128: aload_3
    //   129: invokeinterface 1363 1 0
    //   134: checkcast 1202	com/tencent/theme/BaseConstantState
    //   137: invokespecial 1352	com/tencent/theme/SkinEngine:reloadImage	(Lcom/tencent/theme/BaseConstantState;)V
    //   140: goto -22 -> 118
    //   143: astore_3
    //   144: aload_0
    //   145: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   148: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   151: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   154: aload_3
    //   155: athrow
    //   156: aload_0
    //   157: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   160: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   163: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
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
    //   20	155	1	i	int
    //   28	4	2	j	int
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
  
  public void addBackupForOOMData(Integer paramInteger, SkinEngine.BackupForOOMData paramBackupForOOMData)
  {
    if (this.backupForOOMData == null) {
      this.backupForOOMData = new HashMap();
    }
    this.backupForOOMData.put(paramInteger, paramBackupForOOMData);
  }
  
  public final void addDrawableResource(int paramInt)
  {
    this.drawableIntercepter.a(this.mResources, paramInt);
  }
  
  public boolean checkResExist(int paramInt)
  {
    TypedValue localTypedValue = obtainTempTypedValue();
    this.mResources.getValue(paramInt, localTypedValue, true);
    if (TextUtils.isEmpty(localTypedValue.string))
    {
      releaseTempTypedValue(localTypedValue);
      return false;
    }
    String str = localTypedValue.string.toString();
    localTypedValue.resourceId = paramInt;
    str = str.substring(str.lastIndexOf("/") + 1);
    Resources localResources = this.mResources;
    String[][] arrayOfString = DENSITY_PATH_ORDER;
    paramInt = this.mDensityIndex;
    grabImageFile(localResources, localTypedValue, str, arrayOfString[paramInt], DENSITY_ORDER[paramInt]);
    if (localTypedValue.string != null)
    {
      releaseTempTypedValue(localTypedValue);
      return true;
    }
    releaseTempTypedValue(localTypedValue);
    return grabColorFile(this.mResources, str) != null;
  }
  
  public void clearSimpleModel(Context paramContext)
  {
    paramContext.getSharedPreferences("theme", 4).edit().remove("simple_theme_root").remove("simple_theme_resources_complied").remove("theme_simple_root").commit();
    this.mInSimpleModel = false;
    this.mSimpleSkinRootPath = null;
  }
  
  /* Error */
  BaseConstantState createSmallImageFromResourceStream(Resources paramResources, SkinData paramSkinData, android.graphics.BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean1, SkinEngine.BackupForOOMData paramBackupForOOMData, int paramInt, boolean paramBoolean2)
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
    //   23: ifeq +585 -> 608
    //   26: aload 6
    //   28: ifnull +580 -> 608
    //   31: aload 9
    //   33: astore_2
    //   34: new 198	android/util/TypedValue
    //   37: dup
    //   38: invokespecial 199	android/util/TypedValue:<init>	()V
    //   41: astore 15
    //   43: aload 9
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   50: aload 6
    //   52: getfield 1398	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   55: aload 15
    //   57: iconst_1
    //   58: invokevirtual 435	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   61: aload 9
    //   63: astore_2
    //   64: aload 15
    //   66: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   69: invokeinterface 444 1 0
    //   74: astore 16
    //   76: aload 9
    //   78: astore_2
    //   79: new 963	com/tencent/theme/SkinData
    //   82: dup
    //   83: invokespecial 1399	com/tencent/theme/SkinData:<init>	()V
    //   86: astore_3
    //   87: aload 9
    //   89: astore_2
    //   90: aload_3
    //   91: aload 6
    //   93: getfield 1398	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   96: putfield 1209	com/tencent/theme/SkinData:mResourcesID	I
    //   99: aload 9
    //   101: astore_2
    //   102: aload_3
    //   103: aload 16
    //   105: aload 16
    //   107: ldc_w 1378
    //   110: invokevirtual 1381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 567	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: putfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   121: aload 9
    //   123: astore_2
    //   124: aload_0
    //   125: getfield 499	com/tencent/theme/SkinEngine:mSkinRootPath	Ljava/lang/String;
    //   128: ifnonnull +13 -> 141
    //   131: aload 9
    //   133: astore_2
    //   134: aload_0
    //   135: getfield 501	com/tencent/theme/SkinEngine:mSimpleSkinRootPath	Ljava/lang/String;
    //   138: ifnull +76 -> 214
    //   141: aload 9
    //   143: astore_2
    //   144: aload_0
    //   145: aload_0
    //   146: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   149: aload 15
    //   151: aload_3
    //   152: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   155: getstatic 173	com/tencent/theme/SkinEngine:DENSITY_PATH_ORDER	[[Ljava/lang/String;
    //   158: aload_0
    //   159: getfield 216	com/tencent/theme/SkinEngine:mDensityIndex	I
    //   162: aaload
    //   163: getstatic 177	com/tencent/theme/SkinEngine:DENSITY_ORDER	[[I
    //   166: aload_0
    //   167: getfield 216	com/tencent/theme/SkinEngine:mDensityIndex	I
    //   170: aaload
    //   171: invokespecial 1214	com/tencent/theme/SkinEngine:grabImageFile	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   174: aload 9
    //   176: astore_2
    //   177: aload 15
    //   179: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   182: ifnull +32 -> 214
    //   185: aload 9
    //   187: astore_2
    //   188: aload_3
    //   189: aload 15
    //   191: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   194: invokeinterface 444 1 0
    //   199: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   202: aload 9
    //   204: astore_2
    //   205: aload_3
    //   206: aload 15
    //   208: getfield 664	android/util/TypedValue:density	I
    //   211: putfield 1029	com/tencent/theme/SkinData:mInDensity	I
    //   214: aload 9
    //   216: astore_2
    //   217: aload_3
    //   218: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   221: ifnull +157 -> 378
    //   224: aload 9
    //   226: astore_2
    //   227: new 293	android/graphics/Rect
    //   230: dup
    //   231: invokespecial 872	android/graphics/Rect:<init>	()V
    //   234: astore 10
    //   236: aload 9
    //   238: astore_2
    //   239: new 1025	android/graphics/BitmapFactory$Options
    //   242: dup
    //   243: invokespecial 1026	android/graphics/BitmapFactory$Options:<init>	()V
    //   246: astore 11
    //   248: aload 9
    //   250: astore_2
    //   251: aload 11
    //   253: aload_3
    //   254: getfield 1029	com/tencent/theme/SkinData:mInDensity	I
    //   257: putfield 1032	android/graphics/BitmapFactory$Options:inDensity	I
    //   260: aload 9
    //   262: astore_2
    //   263: aload 11
    //   265: aload 6
    //   267: getfield 1403	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   270: putfield 1404	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   273: aload 9
    //   275: astore_2
    //   276: aload_0
    //   277: aload_1
    //   278: aload_3
    //   279: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   282: invokespecial 1023	com/tencent/theme/SkinEngine:getInputStream	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   285: astore 4
    //   287: aload 9
    //   289: astore_2
    //   290: aload_1
    //   291: aconst_null
    //   292: aload 4
    //   294: aload_3
    //   295: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   298: aload 11
    //   300: aload 10
    //   302: aload_0
    //   303: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   306: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   309: astore_1
    //   310: goto +59 -> 369
    //   313: astore_1
    //   314: aload 9
    //   316: astore_2
    //   317: new 257	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   324: astore 6
    //   326: aload 9
    //   328: astore_2
    //   329: aload 6
    //   331: ldc_w 1406
    //   334: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 9
    //   340: astore_2
    //   341: aload 6
    //   343: aload_3
    //   344: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   347: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 9
    //   353: astore_2
    //   354: ldc 64
    //   356: iconst_1
    //   357: aload 6
    //   359: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: aload_1
    //   363: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload 13
    //   368: astore_1
    //   369: aload_1
    //   370: astore_2
    //   371: aload 4
    //   373: invokevirtual 640	java/io/InputStream:close	()V
    //   376: aload_1
    //   377: areturn
    //   378: aload 9
    //   380: astore_2
    //   381: aload_1
    //   382: aload 6
    //   384: getfield 1398	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   387: aload 15
    //   389: invokevirtual 1113	android/content/res/Resources:openRawResource	(ILandroid/util/TypedValue;)Ljava/io/InputStream;
    //   392: astore_3
    //   393: aload 9
    //   395: astore_2
    //   396: aload 15
    //   398: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   401: invokeinterface 444 1 0
    //   406: astore 13
    //   408: aload 9
    //   410: astore_2
    //   411: new 1025	android/graphics/BitmapFactory$Options
    //   414: dup
    //   415: invokespecial 1026	android/graphics/BitmapFactory$Options:<init>	()V
    //   418: astore 16
    //   420: aload 11
    //   422: astore_2
    //   423: aload 10
    //   425: astore 9
    //   427: aload_1
    //   428: aload 15
    //   430: aload_3
    //   431: aload 13
    //   433: aload 16
    //   435: aload 4
    //   437: iconst_1
    //   438: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   441: astore_1
    //   442: goto +80 -> 522
    //   445: astore_1
    //   446: goto +91 -> 537
    //   449: astore_1
    //   450: aload 11
    //   452: astore_2
    //   453: aload 10
    //   455: astore 9
    //   457: new 257	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   464: astore 4
    //   466: aload 11
    //   468: astore_2
    //   469: aload 10
    //   471: astore 9
    //   473: aload 4
    //   475: ldc_w 1408
    //   478: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 11
    //   484: astore_2
    //   485: aload 10
    //   487: astore 9
    //   489: aload 4
    //   491: aload 6
    //   493: getfield 1398	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   496: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 11
    //   502: astore_2
    //   503: aload 10
    //   505: astore 9
    //   507: ldc 64
    //   509: iconst_1
    //   510: aload 4
    //   512: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: aload_1
    //   516: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   519: aload 12
    //   521: astore_1
    //   522: aload_1
    //   523: astore_2
    //   524: aload_1
    //   525: astore 9
    //   527: aload_3
    //   528: invokevirtual 640	java/io/InputStream:close	()V
    //   531: aload_1
    //   532: areturn
    //   533: astore_1
    //   534: aload 14
    //   536: astore_2
    //   537: aload_2
    //   538: astore 9
    //   540: ldc 64
    //   542: iconst_1
    //   543: ldc_w 1410
    //   546: aload_1
    //   547: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   550: aload_2
    //   551: areturn
    //   552: astore_1
    //   553: aload 10
    //   555: astore 9
    //   557: new 257	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   564: astore_2
    //   565: aload 10
    //   567: astore 9
    //   569: aload_2
    //   570: ldc_w 1412
    //   573: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 10
    //   579: astore 9
    //   581: aload_2
    //   582: aload 6
    //   584: getfield 1398	com/tencent/theme/SkinEngine$BackupForOOMData:backFileResId	I
    //   587: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload 10
    //   593: astore 9
    //   595: ldc 64
    //   597: iconst_1
    //   598: aload_2
    //   599: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: aload_1
    //   603: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   606: aconst_null
    //   607: areturn
    //   608: aload 10
    //   610: astore 9
    //   612: aload_0
    //   613: aload_1
    //   614: aload_2
    //   615: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   618: invokespecial 1023	com/tencent/theme/SkinEngine:getInputStream	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/io/InputStream;
    //   621: astore 11
    //   623: aload 10
    //   625: astore 9
    //   627: aload_3
    //   628: iconst_0
    //   629: putfield 1054	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   632: aload 10
    //   634: astore 9
    //   636: aload_3
    //   637: aload 6
    //   639: getfield 1403	com/tencent/theme/SkinEngine$BackupForOOMData:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   642: putfield 1404	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   645: aload 10
    //   647: astore 9
    //   649: aload_3
    //   650: iload 7
    //   652: putfield 1415	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   655: aload 10
    //   657: astore 9
    //   659: aload_1
    //   660: aconst_null
    //   661: aload 11
    //   663: aload_2
    //   664: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   667: aload_3
    //   668: aload 4
    //   670: aload_0
    //   671: getfield 214	com/tencent/theme/SkinEngine:mIsResourcesComplied	Z
    //   674: invokestatic 1036	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   677: astore_1
    //   678: goto +82 -> 760
    //   681: aload 15
    //   683: astore_1
    //   684: aload 10
    //   686: astore 9
    //   688: getstatic 645	com/tencent/theme/SkinEngine:DEBUG	Z
    //   691: ifeq +69 -> 760
    //   694: aload 10
    //   696: astore 9
    //   698: new 257	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   705: astore_1
    //   706: aload 10
    //   708: astore 9
    //   710: aload_1
    //   711: ldc_w 1417
    //   714: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 10
    //   720: astore 9
    //   722: aload_1
    //   723: aload_2
    //   724: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   727: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload 10
    //   733: astore 9
    //   735: aload_1
    //   736: ldc_w 1419
    //   739: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 10
    //   745: astore 9
    //   747: ldc 64
    //   749: aload_1
    //   750: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 1099	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   756: pop
    //   757: aload 15
    //   759: astore_1
    //   760: aload_1
    //   761: astore 9
    //   763: aload 11
    //   765: invokevirtual 640	java/io/InputStream:close	()V
    //   768: aload_1
    //   769: areturn
    //   770: astore_1
    //   771: aload 9
    //   773: astore_2
    //   774: ldc 64
    //   776: iconst_1
    //   777: ldc_w 1421
    //   780: aload_1
    //   781: invokestatic 389	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   784: aload_2
    //   785: areturn
    //   786: astore_1
    //   787: goto -106 -> 681
    //   790: astore_1
    //   791: goto -17 -> 774
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	794	0	this	SkinEngine
    //   0	794	1	paramResources	Resources
    //   0	794	2	paramSkinData	SkinData
    //   0	794	3	paramOptions	android.graphics.BitmapFactory.Options
    //   0	794	4	paramRect	Rect
    //   0	794	5	paramBoolean1	boolean
    //   0	794	6	paramBackupForOOMData	SkinEngine.BackupForOOMData
    //   0	794	7	paramInt	int
    //   0	794	8	paramBoolean2	boolean
    //   16	756	9	localObject1	Object
    //   13	731	10	localRect	Rect
    //   1	763	11	localObject2	Object
    //   4	516	12	localObject3	Object
    //   19	413	13	str	String
    //   7	528	14	localObject4	Object
    //   10	748	15	localTypedValue	TypedValue
    //   74	360	16	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   290	310	313	java/lang/OutOfMemoryError
    //   427	442	445	java/io/IOException
    //   457	466	445	java/io/IOException
    //   473	482	445	java/io/IOException
    //   489	500	445	java/io/IOException
    //   507	519	445	java/io/IOException
    //   527	531	445	java/io/IOException
    //   427	442	449	java/lang/OutOfMemoryError
    //   411	420	533	java/io/IOException
    //   381	393	552	java/lang/Exception
    //   427	442	770	java/lang/Throwable
    //   457	466	770	java/lang/Throwable
    //   473	482	770	java/lang/Throwable
    //   489	500	770	java/lang/Throwable
    //   507	519	770	java/lang/Throwable
    //   527	531	770	java/lang/Throwable
    //   540	550	770	java/lang/Throwable
    //   557	565	770	java/lang/Throwable
    //   569	577	770	java/lang/Throwable
    //   581	591	770	java/lang/Throwable
    //   595	606	770	java/lang/Throwable
    //   612	623	770	java/lang/Throwable
    //   627	632	770	java/lang/Throwable
    //   636	645	770	java/lang/Throwable
    //   649	655	770	java/lang/Throwable
    //   659	678	770	java/lang/Throwable
    //   688	694	770	java/lang/Throwable
    //   698	706	770	java/lang/Throwable
    //   710	718	770	java/lang/Throwable
    //   722	731	770	java/lang/Throwable
    //   735	743	770	java/lang/Throwable
    //   747	757	770	java/lang/Throwable
    //   763	768	770	java/lang/Throwable
    //   659	678	786	java/lang/OutOfMemoryError
    //   34	43	790	java/lang/Throwable
    //   46	61	790	java/lang/Throwable
    //   64	76	790	java/lang/Throwable
    //   79	87	790	java/lang/Throwable
    //   90	99	790	java/lang/Throwable
    //   102	121	790	java/lang/Throwable
    //   124	131	790	java/lang/Throwable
    //   134	141	790	java/lang/Throwable
    //   144	174	790	java/lang/Throwable
    //   177	185	790	java/lang/Throwable
    //   188	202	790	java/lang/Throwable
    //   205	214	790	java/lang/Throwable
    //   217	224	790	java/lang/Throwable
    //   227	236	790	java/lang/Throwable
    //   239	248	790	java/lang/Throwable
    //   251	260	790	java/lang/Throwable
    //   263	273	790	java/lang/Throwable
    //   276	287	790	java/lang/Throwable
    //   290	310	790	java/lang/Throwable
    //   317	326	790	java/lang/Throwable
    //   329	338	790	java/lang/Throwable
    //   341	351	790	java/lang/Throwable
    //   354	366	790	java/lang/Throwable
    //   371	376	790	java/lang/Throwable
    //   381	393	790	java/lang/Throwable
    //   396	408	790	java/lang/Throwable
    //   411	420	790	java/lang/Throwable
  }
  
  public int getColor(int paramInt)
  {
    synchronized (this.mTmpValue)
    {
      TypedValue localTypedValue2 = this.mTmpValue;
      this.mResources.getValue(paramInt, localTypedValue2, true);
      if ((localTypedValue2.type >= 16) && (localTypedValue2.type <= 31))
      {
        paramInt = localTypedValue2.data;
        return paramInt;
      }
      if (localTypedValue2.type == 3)
      {
        paramInt = loadColorStateList(paramInt).getDefaultColor();
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
      synchronized (this.mTmpValue)
      {
        Object localObject1 = this.mDefaultThemeDrawableCache;
        long l = paramInt;
        localObject1 = (WeakReference)((LongSparseArray)localObject1).get(l);
        Object localObject5 = null;
        if (localObject1 != null)
        {
          Object localObject4 = (BaseConstantState)((WeakReference)localObject1).get();
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            this.mDefaultThemeDrawableCache.delete(l);
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
          this.mResources.getValue(paramInt, this.mTmpValue, true);
          localObject1 = this.mTmpValue.string.toString();
          localSkinData = new SkinData();
          localSkinData.mResourcesID = paramInt;
          localSkinData.mFileName = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
          localSkinData.mFilePath = null;
          localObject1 = loadImage(paramInt, this.mResources, localSkinData, this.mTmpValue);
          localObject4 = localObject1;
          if (localObject1 != null)
          {
            ((BaseConstantState)localObject1).skinData = localSkinData;
            this.mDefaultThemeDrawableCache.put(l, new WeakReference(localObject1));
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
    Object localObject = DENSITY_PATH_ORDER;
    int i = this.mDensityIndex;
    localObject = localObject[i];
    int[] arrayOfInt = DENSITY_ORDER[i];
    i = 0;
    while (i < arrayOfInt.length)
    {
      if (localObject[i].equals(paramString)) {
        return i;
      }
      i += 1;
    }
    if ("color/".equals(paramString)) {
      return -2;
    }
    return -1;
  }
  
  public String getRealRootPath()
  {
    String str2 = this.mSimpleSkinRootPath;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.mSkinRootPath;
    }
    return str1;
  }
  
  public String getSkinRootPath()
  {
    if (this.mSkinUpdating) {
      return this.mTempSkinRootPath;
    }
    return getRealRootPath();
  }
  
  public Object getThemeConfig(String paramString, Object paramObject)
  {
    for (;;)
    {
      synchronized (this.mTmpValue)
      {
        ensureConfigLoaded(this.mIsResourcesComplied);
        localObject = this.mConfigs.get(paramString);
        if (localObject == null)
        {
          paramString = this.mDefaultConfigs.get(paramString);
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
    if ((this.mSkinRootPath == null) && (this.mSimpleSkinRootPath == null)) {
      return null;
    }
    return new File(getRealRootPath());
  }
  
  @TargetApi(16)
  public void getValue(int paramInt, TypedValue paramTypedValue)
  {
    this.mResources.getValue(paramInt, paramTypedValue, true);
    if ((this.mSkinRootPath != null) || (this.mSimpleSkinRootPath != null)) {
      this.mDrawableCacheLock.readLock().lock();
    }
    try
    {
      Object localObject = this.mDrawableCache;
      long l = paramInt;
      localObject = (WeakReference)((LongSparseArray)localObject).get(l);
      this.mDrawableCacheLock.readLock().unlock();
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
          this.mDrawableCacheLock.writeLock().lock();
        }
      }
      try
      {
        this.mDrawableCache.delete(l);
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
      String[][] arrayOfString = DENSITY_PATH_ORDER;
      paramInt = this.mDensityIndex;
      grabImageFile(localResources, localTypedValue, (String)localObject, arrayOfString[paramInt], DENSITY_ORDER[paramInt]);
      if (localTypedValue.string != null)
      {
        paramTypedValue.type = 16777215;
        paramTypedValue.string = localTypedValue.string;
      }
      return;
    }
    finally
    {
      this.mDrawableCacheLock.readLock().unlock();
    }
  }
  
  public boolean isInSimpleModel()
  {
    return this.mInSimpleModel;
  }
  
  /* Error */
  @TargetApi(16)
  SkinnableColorStateList loadColorStateList(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1374	com/tencent/theme/SkinEngine:obtainTempTypedValue	()Landroid/util/TypedValue;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1470	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 232	com/tencent/theme/SkinEngine:mColorStateListCache	Landroid/util/LongSparseArray;
    //   20: astore 5
    //   22: iload_1
    //   23: i2l
    //   24: lstore_2
    //   25: aload 5
    //   27: lload_2
    //   28: invokevirtual 1440	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   31: checkcast 404	java/lang/ref/WeakReference
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   40: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   43: invokevirtual 1471	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   46: aload 5
    //   48: ifnull +73 -> 121
    //   51: aload 5
    //   53: invokevirtual 411	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   56: checkcast 983	com/tencent/theme/SkinnableColorStateList
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +12 -> 75
    //   66: aload_0
    //   67: aload 4
    //   69: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   72: aload 5
    //   74: areturn
    //   75: aload_0
    //   76: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   79: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   82: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   85: aload_0
    //   86: getfield 232	com/tencent/theme/SkinEngine:mColorStateListCache	Landroid/util/LongSparseArray;
    //   89: lload_2
    //   90: invokevirtual 1444	android/util/LongSparseArray:delete	(J)V
    //   93: aload_0
    //   94: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   97: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   100: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   103: goto +18 -> 121
    //   106: astore 5
    //   108: aload_0
    //   109: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   112: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   115: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   118: aload 5
    //   120: athrow
    //   121: aload_0
    //   122: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   125: iload_1
    //   126: aload 4
    //   128: iconst_1
    //   129: invokevirtual 435	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   132: aload 4
    //   134: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   137: invokeinterface 444 1 0
    //   142: astore 6
    //   144: aload 6
    //   146: ldc_w 968
    //   149: invokevirtual 971	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   152: ifeq +151 -> 303
    //   155: new 963	com/tencent/theme/SkinData
    //   158: dup
    //   159: invokespecial 1399	com/tencent/theme/SkinData:<init>	()V
    //   162: astore 5
    //   164: aload 5
    //   166: iload_1
    //   167: putfield 1209	com/tencent/theme/SkinData:mResourcesID	I
    //   170: aload 5
    //   172: aload 6
    //   174: aload 6
    //   176: ldc_w 1378
    //   179: invokevirtual 1381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   182: iconst_1
    //   183: iadd
    //   184: invokevirtual 567	java/lang/String:substring	(I)Ljava/lang/String;
    //   187: putfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   190: aload_0
    //   191: getfield 499	com/tencent/theme/SkinEngine:mSkinRootPath	Ljava/lang/String;
    //   194: ifnonnull +10 -> 204
    //   197: aload_0
    //   198: getfield 501	com/tencent/theme/SkinEngine:mSimpleSkinRootPath	Ljava/lang/String;
    //   201: ifnull +21 -> 222
    //   204: aload 5
    //   206: aload_0
    //   207: aload_0
    //   208: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   211: aload 5
    //   213: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   216: invokespecial 1333	com/tencent/theme/SkinEngine:grabColorFile	(Landroid/content/res/Resources;Ljava/lang/String;)Ljava/lang/String;
    //   219: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   222: aload_0
    //   223: iload_1
    //   224: aload_0
    //   225: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   228: aload 5
    //   230: invokespecial 1335	com/tencent/theme/SkinEngine:loadColor	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;)Lcom/tencent/theme/SkinnableColorStateList;
    //   233: astore 6
    //   235: aload 6
    //   237: aload 5
    //   239: putfield 1325	com/tencent/theme/SkinnableColorStateList:skinData	Lcom/tencent/theme/SkinData;
    //   242: aload_0
    //   243: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   246: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   249: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   252: aload_0
    //   253: getfield 232	com/tencent/theme/SkinEngine:mColorStateListCache	Landroid/util/LongSparseArray;
    //   256: lload_2
    //   257: new 404	java/lang/ref/WeakReference
    //   260: dup
    //   261: aload 6
    //   263: invokespecial 1447	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   266: invokevirtual 1450	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   269: aload_0
    //   270: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   273: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   276: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   279: aload_0
    //   280: aload 4
    //   282: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   285: aload 6
    //   287: areturn
    //   288: astore 5
    //   290: aload_0
    //   291: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   294: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   297: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   300: aload 5
    //   302: athrow
    //   303: aload_0
    //   304: aload 4
    //   306: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   309: aconst_null
    //   310: areturn
    //   311: astore 5
    //   313: aload_0
    //   314: getfield 208	com/tencent/theme/SkinEngine:mColorStateListLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   317: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   320: invokevirtual 1471	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   323: aload 5
    //   325: athrow
    //   326: astore 5
    //   328: aload_0
    //   329: aload 4
    //   331: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   334: aload 5
    //   336: athrow
    //   337: aload_0
    //   338: aload 4
    //   340: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   343: aconst_null
    //   344: areturn
    //   345: astore 5
    //   347: goto -10 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	SkinEngine
    //   0	350	1	paramInt	int
    //   24	233	2	l	long
    //   4	335	4	localTypedValue	TypedValue
    //   20	53	5	localObject1	Object
    //   106	13	5	localObject2	Object
    //   162	76	5	localSkinData	SkinData
    //   288	13	5	localObject3	Object
    //   311	13	5	localObject4	Object
    //   326	9	5	localObject5	Object
    //   345	1	5	localNotFoundException	Resources.NotFoundException
    //   142	144	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   85	93	106	finally
    //   252	269	288	finally
    //   16	22	311	finally
    //   25	36	311	finally
    //   6	16	326	finally
    //   36	46	326	finally
    //   51	61	326	finally
    //   75	85	326	finally
    //   93	103	326	finally
    //   108	121	326	finally
    //   121	204	326	finally
    //   204	222	326	finally
    //   222	252	326	finally
    //   269	279	326	finally
    //   290	303	326	finally
    //   313	326	326	finally
    //   6	16	345	android/content/res/Resources$NotFoundException
    //   36	46	345	android/content/res/Resources$NotFoundException
    //   51	61	345	android/content/res/Resources$NotFoundException
    //   75	85	345	android/content/res/Resources$NotFoundException
    //   93	103	345	android/content/res/Resources$NotFoundException
    //   108	121	345	android/content/res/Resources$NotFoundException
    //   121	204	345	android/content/res/Resources$NotFoundException
    //   204	222	345	android/content/res/Resources$NotFoundException
    //   222	252	345	android/content/res/Resources$NotFoundException
    //   269	279	345	android/content/res/Resources$NotFoundException
    //   290	303	345	android/content/res/Resources$NotFoundException
    //   313	326	345	android/content/res/Resources$NotFoundException
  }
  
  /* Error */
  @TargetApi(16)
  Drawable.ConstantState loadConstantState(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 1374	com/tencent/theme/SkinEngine:obtainTempTypedValue	()Landroid/util/TypedValue;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   10: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   13: invokevirtual 1470	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   16: aload_0
    //   17: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   20: iload_1
    //   21: i2l
    //   22: invokevirtual 1440	android/util/LongSparseArray:get	(J)Ljava/lang/Object;
    //   25: checkcast 404	java/lang/ref/WeakReference
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   34: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   37: invokevirtual 1471	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   40: goto +31 -> 71
    //   43: astore 4
    //   45: aload_0
    //   46: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   52: invokevirtual 1471	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   55: aload 4
    //   57: athrow
    //   58: aload_0
    //   59: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   62: invokevirtual 1467	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   65: invokevirtual 1471	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   68: aconst_null
    //   69: astore 4
    //   71: aload 4
    //   73: ifnull +126 -> 199
    //   76: aload 4
    //   78: invokevirtual 411	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   81: checkcast 413	android/graphics/drawable/Drawable$ConstantState
    //   84: astore 4
    //   86: aload 4
    //   88: ifnull +12 -> 100
    //   91: aload_0
    //   92: aload 5
    //   94: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   97: aload 4
    //   99: areturn
    //   100: aload_0
    //   101: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   104: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   107: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   110: aload_0
    //   111: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   114: iload_1
    //   115: i2l
    //   116: invokevirtual 1444	android/util/LongSparseArray:delete	(J)V
    //   119: new 257	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   126: astore 4
    //   128: aload 4
    //   130: ldc_w 1477
    //   133: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: iload_1
    //   140: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 64
    //   146: iconst_1
    //   147: aload 4
    //   149: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 291	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   159: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   162: astore 4
    //   164: aload 4
    //   166: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   169: goto +30 -> 199
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   178: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   181: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   184: aload 4
    //   186: athrow
    //   187: aload_0
    //   188: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   191: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   194: astore 4
    //   196: goto -32 -> 164
    //   199: getstatic 153	com/tencent/theme/SkinEngine:IS_PROBLEM_CM11	Z
    //   202: istore_3
    //   203: iload_3
    //   204: ifeq +107 -> 311
    //   207: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   210: iconst_1
    //   211: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   214: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   217: aload_0
    //   218: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   221: aconst_null
    //   222: invokevirtual 780	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   225: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   228: iconst_1
    //   229: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   232: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   235: aload_0
    //   236: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   239: aconst_null
    //   240: invokevirtual 780	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   243: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   246: iconst_1
    //   247: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   250: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   253: iconst_1
    //   254: invokevirtual 374	java/lang/reflect/Field:setAccessible	(Z)V
    //   257: getstatic 149	com/tencent/theme/SkinEngine:mIconsOfCM	Ljava/lang/reflect/Field;
    //   260: aload_0
    //   261: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   264: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   267: ifnull +44 -> 311
    //   270: getstatic 151	com/tencent/theme/SkinEngine:mComposedIconInfoOfCM	Ljava/lang/reflect/Field;
    //   273: aload_0
    //   274: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   277: invokevirtual 378	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: astore 4
    //   282: aload 4
    //   284: ifnull +27 -> 311
    //   287: aload_0
    //   288: aload 5
    //   290: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   293: aconst_null
    //   294: areturn
    //   295: aload_0
    //   296: aload 5
    //   298: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: aload 5
    //   306: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   309: aconst_null
    //   310: areturn
    //   311: aload_0
    //   312: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   315: iload_1
    //   316: aload 5
    //   318: iconst_1
    //   319: invokevirtual 435	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   322: aload 5
    //   324: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   327: astore 4
    //   329: aload 4
    //   331: ifnonnull +11 -> 342
    //   334: aload_0
    //   335: aload 5
    //   337: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   340: aconst_null
    //   341: areturn
    //   342: aload 5
    //   344: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   347: invokeinterface 444 1 0
    //   352: astore 4
    //   354: new 963	com/tencent/theme/SkinData
    //   357: dup
    //   358: invokespecial 1399	com/tencent/theme/SkinData:<init>	()V
    //   361: astore 6
    //   363: aload 6
    //   365: iload_1
    //   366: putfield 1209	com/tencent/theme/SkinData:mResourcesID	I
    //   369: aload 6
    //   371: aload 4
    //   373: aload 4
    //   375: ldc_w 1378
    //   378: invokevirtual 1381	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   381: iconst_1
    //   382: iadd
    //   383: invokevirtual 567	java/lang/String:substring	(I)Ljava/lang/String;
    //   386: putfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 499	com/tencent/theme/SkinEngine:mSkinRootPath	Ljava/lang/String;
    //   393: ifnonnull +10 -> 403
    //   396: aload_0
    //   397: getfield 501	com/tencent/theme/SkinEngine:mSimpleSkinRootPath	Ljava/lang/String;
    //   400: ifnull +67 -> 467
    //   403: aload_0
    //   404: aload_0
    //   405: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   408: aload 5
    //   410: aload 6
    //   412: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   415: getstatic 173	com/tencent/theme/SkinEngine:DENSITY_PATH_ORDER	[[Ljava/lang/String;
    //   418: aload_0
    //   419: getfield 216	com/tencent/theme/SkinEngine:mDensityIndex	I
    //   422: aaload
    //   423: getstatic 177	com/tencent/theme/SkinEngine:DENSITY_ORDER	[[I
    //   426: aload_0
    //   427: getfield 216	com/tencent/theme/SkinEngine:mDensityIndex	I
    //   430: aaload
    //   431: invokespecial 1214	com/tencent/theme/SkinEngine:grabImageFile	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/lang/String;[Ljava/lang/String;[I)V
    //   434: aload 5
    //   436: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   439: ifnull +28 -> 467
    //   442: aload 6
    //   444: aload 5
    //   446: getfield 439	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   449: invokeinterface 444 1 0
    //   454: putfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   457: aload 6
    //   459: aload 5
    //   461: getfield 664	android/util/TypedValue:density	I
    //   464: putfield 1029	com/tencent/theme/SkinData:mInDensity	I
    //   467: aload_0
    //   468: aload 6
    //   470: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   473: invokespecial 1216	com/tencent/theme/SkinEngine:isTrackLoadRes	(Ljava/lang/String;)Z
    //   476: istore_3
    //   477: iload_3
    //   478: ifeq +128 -> 606
    //   481: aload_0
    //   482: aload 6
    //   484: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   487: invokespecial 1218	com/tencent/theme/SkinEngine:getLogLevel	(Ljava/lang/String;)I
    //   490: istore_2
    //   491: new 257	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   498: astore 4
    //   500: aload 4
    //   502: ldc_w 1479
    //   505: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 4
    //   511: iload_1
    //   512: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 4
    //   518: ldc_w 1481
    //   521: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 4
    //   527: aload 6
    //   529: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   532: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 4
    //   538: ldc_w 1483
    //   541: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 4
    //   547: aload 6
    //   549: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   552: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 4
    //   558: ldc_w 1485
    //   561: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload 4
    //   567: aload 5
    //   569: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 4
    //   575: ldc_w 1239
    //   578: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 4
    //   584: aload_0
    //   585: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   588: invokevirtual 398	android/util/LongSparseArray:size	()I
    //   591: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: ldc 64
    //   597: iload_2
    //   598: aload 4
    //   600: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokestatic 291	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: aload_0
    //   607: iload_1
    //   608: aload_0
    //   609: getfield 429	com/tencent/theme/SkinEngine:mResources	Landroid/content/res/Resources;
    //   612: aload 6
    //   614: aload 5
    //   616: invokespecial 1253	com/tencent/theme/SkinEngine:loadImage	(ILandroid/content/res/Resources;Lcom/tencent/theme/SkinData;Landroid/util/TypedValue;)Lcom/tencent/theme/BaseConstantState;
    //   619: astore 7
    //   621: aload 7
    //   623: ifnull +277 -> 900
    //   626: aload 7
    //   628: aload 6
    //   630: putfield 1206	com/tencent/theme/BaseConstantState:skinData	Lcom/tencent/theme/SkinData;
    //   633: aload_0
    //   634: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   637: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   640: invokevirtual 1322	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   643: aload_0
    //   644: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   647: iload_1
    //   648: i2l
    //   649: new 404	java/lang/ref/WeakReference
    //   652: dup
    //   653: aload 7
    //   655: invokespecial 1447	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   658: invokevirtual 1450	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   661: aload_0
    //   662: aload 6
    //   664: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   667: invokespecial 1216	com/tencent/theme/SkinEngine:isTrackLoadRes	(Ljava/lang/String;)Z
    //   670: ifeq +49 -> 719
    //   673: aload_0
    //   674: aload 6
    //   676: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   679: invokespecial 1218	com/tencent/theme/SkinEngine:getLogLevel	(Ljava/lang/String;)I
    //   682: istore_2
    //   683: new 257	java/lang/StringBuilder
    //   686: dup
    //   687: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   690: astore 4
    //   692: aload 4
    //   694: ldc_w 1487
    //   697: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 4
    //   703: iload_1
    //   704: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: ldc 64
    //   710: iload_2
    //   711: aload 4
    //   713: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 291	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   719: aload_0
    //   720: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   723: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   726: astore 4
    //   728: aload 4
    //   730: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   733: goto +30 -> 763
    //   736: astore 4
    //   738: aload_0
    //   739: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   742: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   745: invokevirtual 1341	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   748: aload 4
    //   750: athrow
    //   751: aload_0
    //   752: getfield 206	com/tencent/theme/SkinEngine:mDrawableCacheLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   755: invokevirtual 1317	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   758: astore 4
    //   760: goto -32 -> 728
    //   763: aload_0
    //   764: aload 6
    //   766: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   769: invokespecial 1216	com/tencent/theme/SkinEngine:isTrackLoadRes	(Ljava/lang/String;)Z
    //   772: ifeq +128 -> 900
    //   775: aload_0
    //   776: aload 6
    //   778: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   781: invokespecial 1218	com/tencent/theme/SkinEngine:getLogLevel	(Ljava/lang/String;)I
    //   784: istore_2
    //   785: new 257	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   792: astore 4
    //   794: aload 4
    //   796: ldc_w 1489
    //   799: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 4
    //   805: iload_1
    //   806: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 4
    //   812: ldc_w 1481
    //   815: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 4
    //   821: aload 6
    //   823: getfield 979	com/tencent/theme/SkinData:mFileName	Ljava/lang/String;
    //   826: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload 4
    //   832: ldc_w 1483
    //   835: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 4
    //   841: aload 6
    //   843: getfield 966	com/tencent/theme/SkinData:mFilePath	Ljava/lang/String;
    //   846: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload 4
    //   852: ldc_w 1485
    //   855: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload 4
    //   861: aload 5
    //   863: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload 4
    //   869: ldc_w 1239
    //   872: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload 4
    //   878: aload_0
    //   879: getfield 230	com/tencent/theme/SkinEngine:mDrawableCache	Landroid/util/LongSparseArray;
    //   882: invokevirtual 398	android/util/LongSparseArray:size	()I
    //   885: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: pop
    //   889: ldc 64
    //   891: iload_2
    //   892: aload 4
    //   894: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   897: invokestatic 291	com/tencent/theme/h:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   900: aload_0
    //   901: aload 5
    //   903: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   906: aload 7
    //   908: areturn
    //   909: astore 4
    //   911: aload_0
    //   912: aload 5
    //   914: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   917: aload 4
    //   919: athrow
    //   920: aload_0
    //   921: aload 5
    //   923: invokespecial 1376	com/tencent/theme/SkinEngine:releaseTempTypedValue	(Landroid/util/TypedValue;)V
    //   926: aconst_null
    //   927: areturn
    //   928: astore 4
    //   930: goto -10 -> 920
    //   933: astore 4
    //   935: goto -877 -> 58
    //   938: astore 4
    //   940: goto -753 -> 187
    //   943: astore 4
    //   945: goto -642 -> 303
    //   948: astore 4
    //   950: goto -655 -> 295
    //   953: astore 4
    //   955: goto -204 -> 751
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	958	0	this	SkinEngine
    //   0	958	1	paramInt	int
    //   490	402	2	i	int
    //   202	276	3	bool	boolean
    //   28	1	4	localWeakReference	WeakReference
    //   43	13	4	localObject1	Object
    //   69	96	4	localObject2	Object
    //   172	13	4	localObject3	Object
    //   194	535	4	localObject4	Object
    //   736	13	4	localObject5	Object
    //   758	135	4	localObject6	Object
    //   909	9	4	localObject7	Object
    //   928	1	4	localNotFoundException	Resources.NotFoundException
    //   933	1	4	localException1	Exception
    //   938	1	4	localException2	Exception
    //   943	1	4	localException3	Exception
    //   948	1	4	localException4	Exception
    //   953	1	4	localException5	Exception
    //   4	918	5	localTypedValue	TypedValue
    //   361	481	6	localSkinData	SkinData
    //   619	288	7	localBaseConstantState	BaseConstantState
    // Exception table:
    //   from	to	target	type
    //   16	30	43	finally
    //   110	155	172	finally
    //   643	719	736	finally
    //   6	16	909	finally
    //   30	40	909	finally
    //   45	58	909	finally
    //   58	68	909	finally
    //   76	86	909	finally
    //   100	110	909	finally
    //   155	164	909	finally
    //   164	169	909	finally
    //   174	187	909	finally
    //   187	196	909	finally
    //   199	203	909	finally
    //   207	243	909	finally
    //   243	282	909	finally
    //   311	329	909	finally
    //   342	403	909	finally
    //   403	467	909	finally
    //   467	477	909	finally
    //   481	606	909	finally
    //   606	621	909	finally
    //   626	643	909	finally
    //   719	728	909	finally
    //   728	733	909	finally
    //   738	751	909	finally
    //   751	760	909	finally
    //   763	900	909	finally
    //   6	16	928	android/content/res/Resources$NotFoundException
    //   30	40	928	android/content/res/Resources$NotFoundException
    //   45	58	928	android/content/res/Resources$NotFoundException
    //   58	68	928	android/content/res/Resources$NotFoundException
    //   76	86	928	android/content/res/Resources$NotFoundException
    //   100	110	928	android/content/res/Resources$NotFoundException
    //   155	164	928	android/content/res/Resources$NotFoundException
    //   164	169	928	android/content/res/Resources$NotFoundException
    //   174	187	928	android/content/res/Resources$NotFoundException
    //   187	196	928	android/content/res/Resources$NotFoundException
    //   199	203	928	android/content/res/Resources$NotFoundException
    //   207	243	928	android/content/res/Resources$NotFoundException
    //   243	282	928	android/content/res/Resources$NotFoundException
    //   311	329	928	android/content/res/Resources$NotFoundException
    //   342	403	928	android/content/res/Resources$NotFoundException
    //   403	467	928	android/content/res/Resources$NotFoundException
    //   467	477	928	android/content/res/Resources$NotFoundException
    //   481	606	928	android/content/res/Resources$NotFoundException
    //   606	621	928	android/content/res/Resources$NotFoundException
    //   626	643	928	android/content/res/Resources$NotFoundException
    //   719	728	928	android/content/res/Resources$NotFoundException
    //   728	733	928	android/content/res/Resources$NotFoundException
    //   738	751	928	android/content/res/Resources$NotFoundException
    //   751	760	928	android/content/res/Resources$NotFoundException
    //   763	900	928	android/content/res/Resources$NotFoundException
    //   16	30	933	java/lang/Exception
    //   110	155	938	java/lang/Exception
    //   207	243	943	java/lang/Exception
    //   243	282	948	java/lang/Exception
    //   643	719	953	java/lang/Exception
  }
  
  public int recordDpiFile(String paramString)
  {
    Object localObject1 = DENSITY_ORDER;
    int i = this.mDensityIndex;
    localObject1 = localObject1[i];
    String[] arrayOfString = DENSITY_PATH_ORDER[i];
    if ((this.mSkinRootPath == null) && (this.mSimpleSkinRootPath == null)) {
      return -1;
    }
    i = 0;
    while (i < localObject1.length)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getRealRootPath());
      ((StringBuilder)localObject2).append(arrayOfString[i]);
      ((StringBuilder)localObject2).append(paramString);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (((String)localObject2).startsWith("/asset/")) {
        return -2;
      }
      if (new File((String)localObject2).exists()) {
        return i;
      }
      i += 1;
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
    Object localObject3 = this.drawableIntercepter;
    long l1 = 0L;
    int i;
    if ((localObject3 != null) && (((e)localObject3).b != null))
    {
      localObject3 = this.drawableIntercepter.b;
      int i1 = localObject3.length;
      l1 = 0L;
      i = 0;
      int j = 0;
      while (j < i1)
      {
        localField = localObject3[j];
        int k = 0;
        while (k < localField.size())
        {
          Object localObject4 = (Drawable.ConstantState)localField.valueAt(k);
          long l2 = l1;
          if (localObject4 != null)
          {
            localObject4 = ((Drawable.ConstantState)localObject4).newDrawable();
            int n;
            int m;
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
                n = ((Bitmap)localObject4).getRowBytes();
                m = ((Bitmap)localObject4).getHeight();
              }
            }
            for (;;)
            {
              l2 = n * m;
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
                  n = ((NinePatch)localObject4).getWidth();
                  m = ((NinePatch)localObject4).getHeight();
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
          k += 1;
          i += 1;
          l1 = l2;
        }
        localField.clear();
        j += 1;
      }
    }
    else
    {
      i = 0;
    }
    return new Object[] { Integer.valueOf(i), Long.valueOf(l1) };
  }
  
  public void setSkinEngineHandler(SkinEngineHandler paramSkinEngineHandler)
  {
    this.mSkinEngineHandler = paramSkinEngineHandler;
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString)
  {
    return setSkinRootPath(paramContext, paramString, true);
  }
  
  public boolean setSkinRootPath(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (this.mSkinUpdating)
    {
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "[setSkinRootPath] mSkinUpdating is true");
      }
      return false;
    }
    if (SWITCH_DEBUG) {
      Log.d("SkinEngine.switch", "[setSkinRootPath] start");
    }
    clearSimpleModel(paramContext);
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
    this.mSkinTint = paramISkinTint;
  }
  
  public void setUpdateCallback(UpdateCallback paramUpdateCallback)
  {
    this.mUpdateCallback = paramUpdateCallback;
  }
  
  public boolean switchToSimpleModel(Context paramContext, SimpleData paramSimpleData)
  {
    return switchToSimpleModel(paramContext, paramSimpleData, true);
  }
  
  public boolean switchToSimpleModel(Context paramContext, SimpleData paramSimpleData, boolean paramBoolean)
  {
    if (paramSimpleData == null)
    {
      Log.d("SkinEngine.switch", "[switchToSimpleModel] data is null");
      return false;
    }
    if (this.mSkinUpdating)
    {
      Log.d("SkinEngine.switch", "[switchToSimpleModel] mSkinUpdating is true");
      return false;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    if (paramSimpleData.a == null)
    {
      localSharedPreferences.edit().remove("simple_theme_root").remove("simple_theme_resources_complied").commit();
    }
    else
    {
      Object localObject;
      if (!paramSimpleData.a.endsWith("/"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramSimpleData.a);
        ((StringBuilder)localObject).append("/");
        paramSimpleData.a = ((StringBuilder)localObject).toString();
      }
      if (paramSimpleData.a.startsWith("/asset/"))
      {
        localSharedPreferences.edit().putString("simple_theme_root", paramSimpleData.a).putBoolean("simple_theme_resources_complied", paramBoolean).commit();
      }
      else
      {
        localObject = new File(paramSimpleData.a);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localSharedPreferences.edit().putString("simple_theme_root", paramSimpleData.a).putBoolean("simple_theme_resources_complied", paramBoolean).commit();
        }
        else
        {
          if (DEBUG)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[setSkinRootPath] wrong skinPath: ");
            ((StringBuilder)localObject).append(paramSimpleData.a);
            Log.w("SkinEngine", ((StringBuilder)localObject).toString());
          }
          localSharedPreferences.edit().remove("simple_theme_root").putBoolean("simple_theme_resources_complied", paramBoolean).commit();
        }
      }
    }
    this.mInSimpleModel = true;
    this.mSimpleSkinRootPath = paramSimpleData.a;
    paramContext.sendBroadcast(new Intent("com.tencent.qplus.THEME_UPDATE"), "com.tencent.msg.permission.pushnotify");
    if (SWITCH_DEBUG)
    {
      Log.d("SkinEngine.switch", "[switchToSimpleModel] sendBroadcast(ACTION_THEME_UPDATE)");
      Log.d("SkinEngine.switch", "[switchToSimpleModel] done");
    }
    return true;
  }
  
  public void unInit()
  {
    try
    {
      if (this.drawableIntercepter != null)
      {
        localField = Resources.class.getDeclaredField("sPreloadedDrawables");
        localField.setAccessible(true);
        if (localField.getDeclaringClass().isArray()) {
          localField.set(null, this.drawableIntercepter.b);
        } else {
          localField.set(null, this.drawableIntercepter.b[0]);
        }
      }
    }
    catch (Exception localException1)
    {
      Field localField;
      Object localObject;
      label101:
      if (DEBUG) {
        Log.e("SkinEngine", "resotre SkinEngine failed", localException1);
      }
    }
    try
    {
      localField = Resources.class.getDeclaredField("sPreloadedColorStateLists");
      localField.setAccessible(true);
      localObject = (LongSparseArray)localField.get(this.mResources);
      localField.set(null, this.colorStateListPreloadIntercepter.b);
      return;
    }
    catch (Exception localException2)
    {
      break label101;
    }
    localField = Resources.class.getDeclaredField("mPreloadedColorStateLists");
    localField.setAccessible(true);
    localObject = localField.get(this.mResources);
    if ((localObject instanceof SparseArray))
    {
      localField.set(null, this.colorStateListPreloadIntercepter15.b);
      return;
    }
    if ((localObject instanceof LongSparseArray))
    {
      localField.set(null, this.colorStateListPreloadIntercepter.b);
      return;
    }
  }
  
  void update(Context paramContext)
  {
    h.a("SkinEngine", 1, "update start");
    this.mSkinUpdating = true;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("theme", 4);
    String str1 = localSharedPreferences.getString("pending_theme_root", null);
    String str2 = localSharedPreferences.getString("simple_theme_root", null);
    boolean bool;
    if (str2 != null) {
      bool = localSharedPreferences.getBoolean("simple_theme_resources_complied", true);
    } else if (str1 != null) {
      bool = localSharedPreferences.getBoolean("pending_theme_resources_complied", true);
    } else {
      bool = true;
    }
    synchronized (this.mTmpValue)
    {
      this.mTempSkinRootPath = getRealRootPath();
      this.mSkinRootPath = str1;
      this.mSimpleSkinRootPath = str2;
      this.mIsResourcesComplied = bool;
      if (this.mSkinTint != null) {
        if ((this.mSkinRootPath == null) && (this.mSimpleSkinRootPath == null))
        {
          this.mSkinTint.clear();
        }
        else
        {
          localObject = this.mSkinTint;
          Resources localResources = paramContext.getResources();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(getRealRootPath());
          localStringBuilder.append(File.separator);
          localStringBuilder.append("config.json");
          ((ISkinTint)localObject).loadConfig(localResources, localStringBuilder.toString());
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update : mTempSkinRootPath : ");
      ((StringBuilder)localObject).append(this.mTempSkinRootPath);
      h.a("SkinEngine", 1, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update : mSkinRootPath : ");
      ((StringBuilder)localObject).append(this.mSkinRootPath);
      h.a("SkinEngine", 1, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update : mSimpleSkinRootPath : ");
      ((StringBuilder)localObject).append(this.mSimpleSkinRootPath);
      h.a("SkinEngine", 1, ((StringBuilder)localObject).toString());
      if (this.mFileExistCache != null)
      {
        h.a("SkinEngine", 1, "mFileExistCache startRecordTask");
        this.mFileExistCache.c();
      }
      updateColorState(paramContext);
      updateImage();
      if (this.mInSimpleModel) {
        localSharedPreferences.edit().putString("theme_simple_root", str2).putBoolean("complied", this.mIsResourcesComplied).commit();
      } else {
        localSharedPreferences.edit().putString("theme_root", str1).putBoolean("complied", this.mIsResourcesComplied).commit();
      }
      this.mSkinUpdating = false;
      this.mTempSkinRootPath = null;
      if (SWITCH_DEBUG) {
        Log.d("SkinEngine.switch", "update done");
      }
      h.d("SkinEngine.switch", 2, "skinEngine update done", null);
      return;
    }
  }
  
  public void writeCacheFile(File paramFile)
  {
    this.drawableIntercepter.a(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.SkinEngine
 * JD-Core Version:    0.7.0.1
 */