package cooperation.qzone.font;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontSoLoader;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.lyric.util.Singleton;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.util.NetworkState;
import java.io.File;
import java.io.FileFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FontManager
{
  public static final String FONT_DOWN_LOAD_RUL = "https://qzonestyle.gtimg.cn/qzone/space_item/qzone_act/ziti/HYMiaoXJJF.zip";
  public static final int FONT_ID = 1000;
  public static final String FONT_SUFFIX_FTF = ".ftf";
  public static final String FONT_SUFFIX_TTF = ".ttf";
  static final String TAG = "FontManager";
  private static FileCacheService mFileCache;
  private static final Singleton<FontManager, Void> sSingleton = new FontManager.1();
  private ConcurrentHashMap<Integer, FontInfo> catchFontInfoMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, ArrayList<FontManager.DownLoadFontTask>> downloadingFontIDs;
  private String fontDir;
  private String fontDownloadDir;
  private FileFilter fontFilter = new FontManager.5(this);
  private FileFilter fullTypeFilter = new FontManager.6(this);
  private String processName;
  
  public FontManager()
  {
    loadFontInfo();
    ThreadManager.init();
  }
  
  private void addDownloadTask(int paramInt1, String paramString1, int paramInt2, String paramString2, FontInterface.FontResult paramFontResult)
  {
    if (paramFontResult == null) {
      return;
    }
    ThreadManager.post(new FontManager.3(this, paramInt1, paramInt2, paramFontResult, paramString2, paramString1), 8, null, false);
  }
  
  private void addFontInfoToCatch(int paramInt)
  {
    FontInfo localFontInfo = new FontInfo(paramInt);
    this.catchFontInfoMap.put(Integer.valueOf(paramInt), localFontInfo);
  }
  
  private void callbackResult(int paramInt)
  {
    Object localObject1 = this.downloadingFontIDs;
    if (localObject1 == null) {
      return;
    }
    try
    {
      Object localObject2 = (ArrayList)this.downloadingFontIDs.remove(Integer.valueOf(paramInt));
      if (localObject2 == null) {
        return;
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FontManager.DownLoadFontTask)((Iterator)localObject1).next();
        FontInterface.FontResult localFontResult = (FontInterface.FontResult)((FontManager.DownLoadFontTask)localObject2).result.get();
        if (localFontResult != null) {
          localFontResult.result(paramInt, getFontPathIfExist(paramInt, ((FontManager.DownLoadFontTask)localObject2).fontType), ((FontManager.DownLoadFontTask)localObject2).extend);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject3;
    }
  }
  
  private boolean checkFontIDValidity(int paramInt)
  {
    return paramInt > 0;
  }
  
  private boolean convertFontFile(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(getProcessName());
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
      try
      {
        ETEngine.getInstanceForSpace();
        boolean bool = ETEngine.native_ftf2ttf(paramString1, (String)localObject);
        if (bool)
        {
          paramString1 = new File((String)localObject);
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            bool = paramString1.renameTo((File)localObject);
          }
          if (!bool)
          {
            paramString2 = new StringBuilder();
            paramString2.append("failed to move trueType font file, from path = ");
            paramString2.append(paramString1.getAbsolutePath());
            QLog.e("FontManager", 1, paramString2.toString());
            return bool;
          }
          getFileCache().updateLruFile(paramString2, true);
          return bool;
        }
        QLog.e("FontManager", 1, "call native_ftf2ttf error");
        return bool;
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("call native_ftf2ttf error, errMsg = ");
        paramString2.append(paramString1.toString());
        QLog.e("FontManager", 1, paramString2.toString());
      }
    }
    return false;
  }
  
  private boolean doRealDownload(int paramInt1, String paramString1, int paramInt2, String arg4, FontInterface.FontResult paramFontResult)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("FontManager", 1, "fontUrl is empty.");
      return false;
    }
    if (this.downloadingFontIDs == null) {
      this.downloadingFontIDs = new ConcurrentHashMap();
    }
    FontManager.DownLoadFontTask localDownLoadFontTask = new FontManager.DownLoadFontTask(this, null);
    localDownLoadFontTask.fontID = paramInt1;
    localDownLoadFontTask.fontType = paramInt2;
    localDownLoadFontTask.extend = ???;
    localDownLoadFontTask.result = new WeakReference(paramFontResult);
    synchronized (this.downloadingFontIDs)
    {
      paramFontResult = (ArrayList)this.downloadingFontIDs.get(Integer.valueOf(paramInt1));
      if (paramFontResult == null)
      {
        if (QLog.isDevelopLevel())
        {
          paramFontResult = new StringBuilder();
          paramFontResult.append("add new download task. fontId =");
          paramFontResult.append(paramInt1);
          QLog.d("FontManager", 4, paramFontResult.toString());
        }
        paramFontResult = new ArrayList();
        paramFontResult.add(localDownLoadFontTask);
        this.downloadingFontIDs.put(Integer.valueOf(paramInt1), paramFontResult);
        ThreadManager.post(new FontManager.4(this, paramString1, paramInt1), 5, null, false);
        return true;
      }
      if (QLog.isDevelopLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("attache download task. fontId =");
        paramString1.append(paramInt1);
        QLog.d("FontManager", 4, paramString1.toString());
      }
      paramFontResult.add(localDownLoadFontTask);
      return true;
    }
  }
  
  private void downloadTaskAndCheckNetwork(int paramInt1, String paramString1, int paramInt2, String paramString2, boolean paramBoolean, FontInterface.FontResult paramFontResult)
  {
    if (paramFontResult == null) {
      return;
    }
    if ((NetworkState.isNetSupport()) && (getETEngine() != null))
    {
      if (!paramBoolean)
      {
        paramBoolean = NetworkState.isWifiConn();
        int i = QzoneConfig.getInstance().getConfig("QzCustomFont", "DownloadFontAnyway", 0);
        if ((!paramBoolean) && (i == 0))
        {
          paramFontResult.result(paramInt1, null, paramString2);
          return;
        }
      }
      addDownloadTask(paramInt1, paramString1, paramInt2, paramString2, paramFontResult);
      return;
    }
    paramFontResult.result(paramInt1, null, paramString2);
  }
  
  private File[] getAllFontInFolder(File paramFile)
  {
    return paramFile.listFiles(this.fontFilter);
  }
  
  private String getDownLoadDir()
  {
    if (!TextUtils.isEmpty(this.fontDownloadDir))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.fontDownloadDir);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getFontDir());
    ((StringBuilder)localObject).append(getProcessName());
    this.fontDownloadDir = ((StringBuilder)localObject).toString();
    localObject = new File(this.fontDownloadDir);
    if (!((File)localObject).isDirectory()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.fontDownloadDir);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  private String getDownloadZipPath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getDownLoadDir());
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
  }
  
  private static FileCacheService getFileCache()
  {
    if (mFileCache == null) {
      mFileCache = CacheManager.getPersonaliseFontCacheService();
    }
    return mFileCache;
  }
  
  private String getFontDir()
  {
    if (!TextUtils.isEmpty(this.fontDir))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.fontDir);
      ((StringBuilder)localObject).append(File.separator);
      return ((StringBuilder)localObject).toString();
    }
    this.fontDir = CacheManager.getPersonaliseFontDir();
    Object localObject = new File(this.fontDir);
    if (!((File)localObject).isDirectory()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.fontDir);
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  private int getFontIDFromFile(File paramFile)
  {
    try
    {
      paramFile = paramFile.getName();
      int i = Integer.parseInt(paramFile.substring(0, paramFile.indexOf('.')));
      return i;
    }
    catch (Exception paramFile)
    {
      label22:
      break label22;
    }
    return -1;
  }
  
  private String getFontName(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      localObject = ".ttf";
    }
    else
    {
      if (paramInt2 != 0) {
        break label47;
      }
      localObject = ".ftf";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
    label47:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fontType = ");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private String getFontPath(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getFontDir());
    localStringBuilder.append(getFontName(paramInt1, paramInt2));
    return localStringBuilder.toString();
  }
  
  private String getFontPathIfExist(int paramInt1, int paramInt2)
  {
    String str2 = getFontPath(paramInt1, paramInt2);
    String str1 = str2;
    if (!new File(str2).exists()) {
      str1 = null;
    }
    return str1;
  }
  
  public static FontManager getInstance()
  {
    return (FontManager)sSingleton.get(null);
  }
  
  private String getProcessName()
  {
    if (TextUtils.isEmpty(this.processName))
    {
      String str = BaseApplicationImpl.getApplication().getQQProcessName();
      int i = str.indexOf(':');
      if ((i > 0) && (i < str.length() - 1)) {
        this.processName = str.substring(i + 1);
      } else {
        this.processName = str;
      }
    }
    return this.processName;
  }
  
  private String getUnzipDir(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getDownLoadDir());
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).isDirectory()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    return ((StringBuilder)localObject2).toString();
  }
  
  private void loadFontInfo()
  {
    Object localObject = new File(getFontDir());
    if (!((File)localObject).exists())
    {
      QLog.d("FontManager", 1, "cache font dir not found, cache font size = 0.");
      return;
    }
    localObject = getAllFontInFolder((File)localObject);
    if ((localObject != null) && (localObject.length > 0))
    {
      HashSet localHashSet = new HashSet();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = getFontIDFromFile(localObject[i]);
        if (checkFontIDValidity(k)) {
          localHashSet.add(Integer.valueOf(k));
        }
        i += 1;
      }
      localObject = localHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        addFontInfoToCatch(((Integer)((Iterator)localObject).next()).intValue());
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cache font size = ");
    ((StringBuilder)localObject).append(this.catchFontInfoMap.size());
    QLog.d("FontManager", 1, ((StringBuilder)localObject).toString());
  }
  
  /* Error */
  private boolean unzipFont(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 101	cooperation/qzone/font/FontManager:getDownloadZipPath	(I)Ljava/lang/String;
    //   5: astore 6
    //   7: aload_0
    //   8: iload_1
    //   9: invokespecial 435	cooperation/qzone/font/FontManager:getUnzipDir	(I)Ljava/lang/String;
    //   12: astore 7
    //   14: iconst_0
    //   15: istore 5
    //   17: new 224	java/io/File
    //   20: dup
    //   21: aload 6
    //   23: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: new 224	java/io/File
    //   29: dup
    //   30: aload 7
    //   32: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokestatic 441	cooperation/qzone/util/FileUtils:unzip	(Ljava/io/File;Ljava/io/File;)Z
    //   38: istore 4
    //   40: iload 4
    //   42: ifeq +363 -> 405
    //   45: new 224	java/io/File
    //   48: dup
    //   49: aload 7
    //   51: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: invokevirtual 444	java/io/File:listFiles	()[Ljava/io/File;
    //   57: astore 8
    //   59: aload 8
    //   61: ifnull +329 -> 390
    //   64: aload 8
    //   66: arraylength
    //   67: ifle +323 -> 390
    //   70: aload 8
    //   72: iconst_0
    //   73: aaload
    //   74: astore 8
    //   76: invokestatic 219	com/etrump/mixlayout/ETEngine:getInstanceForSpace	()Lcom/etrump/mixlayout/ETEngine;
    //   79: pop
    //   80: aload 8
    //   82: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   85: invokestatic 447	com/etrump/mixlayout/ETEngine:native_getFontType	(Ljava/lang/String;)I
    //   88: istore_2
    //   89: iload_2
    //   90: iconst_2
    //   91: if_icmpne +61 -> 152
    //   94: new 224	java/io/File
    //   97: dup
    //   98: aload_0
    //   99: iload_1
    //   100: iconst_1
    //   101: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   104: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 9
    //   109: aload 9
    //   111: invokevirtual 230	java/io/File:exists	()Z
    //   114: ifne +12 -> 126
    //   117: aload 8
    //   119: aload 9
    //   121: invokevirtual 234	java/io/File:renameTo	(Ljava/io/File;)Z
    //   124: istore 4
    //   126: iload 4
    //   128: istore_3
    //   129: iload 4
    //   131: ifeq +97 -> 228
    //   134: invokestatic 83	cooperation/qzone/font/FontManager:getFileCache	()Lcooperation/qzone/cache/FileCacheService;
    //   137: aload 9
    //   139: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: iconst_1
    //   143: invokevirtual 251	cooperation/qzone/cache/FileCacheService:updateLruFile	(Ljava/lang/String;Z)V
    //   146: iload 4
    //   148: istore_3
    //   149: goto +79 -> 228
    //   152: iload_2
    //   153: iconst_1
    //   154: if_icmpne +429 -> 583
    //   157: new 224	java/io/File
    //   160: dup
    //   161: aload_0
    //   162: iload_1
    //   163: iconst_0
    //   164: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   167: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: astore 9
    //   172: aload 9
    //   174: invokevirtual 230	java/io/File:exists	()Z
    //   177: ifne +12 -> 189
    //   180: aload 8
    //   182: aload 9
    //   184: invokevirtual 234	java/io/File:renameTo	(Ljava/io/File;)Z
    //   187: istore 4
    //   189: iload 4
    //   191: istore_3
    //   192: iload 4
    //   194: ifeq +34 -> 228
    //   197: invokestatic 83	cooperation/qzone/font/FontManager:getFileCache	()Lcooperation/qzone/cache/FileCacheService;
    //   200: aload 9
    //   202: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: iconst_1
    //   206: invokevirtual 251	cooperation/qzone/cache/FileCacheService:updateLruFile	(Ljava/lang/String;Z)V
    //   209: aload_0
    //   210: aload 9
    //   212: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   215: aload_0
    //   216: iload_1
    //   217: iconst_1
    //   218: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   221: invokespecial 89	cooperation/qzone/font/FontManager:convertFontFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   224: istore_3
    //   225: goto +3 -> 228
    //   228: iload_3
    //   229: ifeq +39 -> 268
    //   232: new 127	cooperation/qzone/font/FontInfo
    //   235: dup
    //   236: invokespecial 448	cooperation/qzone/font/FontInfo:<init>	()V
    //   239: astore 8
    //   241: aload 8
    //   243: iload_1
    //   244: putfield 451	cooperation/qzone/font/FontInfo:fontId	I
    //   247: aload_0
    //   248: getfield 52	cooperation/qzone/font/FontManager:catchFontInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   251: aload 8
    //   253: getfield 451	cooperation/qzone/font/FontInfo:fontId	I
    //   256: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aload 8
    //   261: invokevirtual 139	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: goto +180 -> 445
    //   268: new 197	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   275: astore 9
    //   277: aload 9
    //   279: ldc_w 453
    //   282: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 9
    //   288: aload 8
    //   290: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   293: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc 20
    //   299: iconst_1
    //   300: aload 9
    //   302: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: goto +137 -> 445
    //   311: astore 8
    //   313: new 197	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   320: astore 9
    //   322: aload 9
    //   324: ldc_w 455
    //   327: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 9
    //   333: aload 8
    //   335: invokevirtual 256	java/lang/Throwable:toString	()Ljava/lang/String;
    //   338: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: ldc 20
    //   344: iconst_1
    //   345: aload 9
    //   347: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: new 224	java/io/File
    //   356: dup
    //   357: aload 6
    //   359: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   362: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   365: pop
    //   366: new 224	java/io/File
    //   369: dup
    //   370: aload 7
    //   372: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   375: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   378: pop
    //   379: iconst_0
    //   380: ireturn
    //   381: astore 6
    //   383: aload 6
    //   385: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   388: iconst_0
    //   389: ireturn
    //   390: ldc 20
    //   392: iconst_1
    //   393: ldc_w 463
    //   396: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload 4
    //   401: istore_3
    //   402: goto +43 -> 445
    //   405: new 197	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   412: astore 8
    //   414: aload 8
    //   416: ldc_w 465
    //   419: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 8
    //   425: aload 6
    //   427: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: ldc 20
    //   433: iconst_1
    //   434: aload 8
    //   436: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: iload 4
    //   444: istore_3
    //   445: iload_3
    //   446: istore 4
    //   448: iload 4
    //   450: istore_3
    //   451: new 224	java/io/File
    //   454: dup
    //   455: aload 6
    //   457: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   460: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   463: pop
    //   464: iload 4
    //   466: istore_3
    //   467: new 224	java/io/File
    //   470: dup
    //   471: aload 7
    //   473: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   476: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   479: pop
    //   480: iload 4
    //   482: ireturn
    //   483: astore 6
    //   485: aload 6
    //   487: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   490: iload_3
    //   491: ireturn
    //   492: astore 8
    //   494: goto +50 -> 544
    //   497: astore 8
    //   499: ldc 20
    //   501: iconst_1
    //   502: ldc_w 467
    //   505: aload 8
    //   507: invokestatic 471	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   510: iload 5
    //   512: istore_3
    //   513: new 224	java/io/File
    //   516: dup
    //   517: aload 6
    //   519: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   522: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   525: pop
    //   526: iload 5
    //   528: istore_3
    //   529: new 224	java/io/File
    //   532: dup
    //   533: aload 7
    //   535: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   538: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   541: pop
    //   542: iconst_0
    //   543: ireturn
    //   544: new 224	java/io/File
    //   547: dup
    //   548: aload 6
    //   550: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   553: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   556: pop
    //   557: new 224	java/io/File
    //   560: dup
    //   561: aload 7
    //   563: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   566: invokestatic 458	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   569: pop
    //   570: goto +10 -> 580
    //   573: astore 6
    //   575: aload 6
    //   577: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   580: aload 8
    //   582: athrow
    //   583: iconst_0
    //   584: istore_3
    //   585: goto -357 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	FontManager
    //   0	588	1	paramInt	int
    //   88	67	2	i	int
    //   128	457	3	bool1	boolean
    //   38	443	4	bool2	boolean
    //   15	512	5	bool3	boolean
    //   5	353	6	str1	String
    //   381	75	6	localException1	Exception
    //   483	66	6	localException2	Exception
    //   573	3	6	localException3	Exception
    //   12	550	7	str2	String
    //   57	232	8	localObject1	Object
    //   311	23	8	localThrowable	Throwable
    //   412	23	8	localStringBuilder	StringBuilder
    //   492	1	8	localObject2	Object
    //   497	84	8	localException4	Exception
    //   107	239	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   76	89	311	java/lang/Throwable
    //   353	379	381	java/lang/Exception
    //   451	464	483	java/lang/Exception
    //   467	480	483	java/lang/Exception
    //   513	526	483	java/lang/Exception
    //   529	542	483	java/lang/Exception
    //   17	40	492	finally
    //   45	59	492	finally
    //   64	70	492	finally
    //   76	89	492	finally
    //   94	109	492	finally
    //   109	126	492	finally
    //   134	146	492	finally
    //   157	172	492	finally
    //   172	189	492	finally
    //   197	225	492	finally
    //   232	265	492	finally
    //   268	308	492	finally
    //   313	353	492	finally
    //   390	399	492	finally
    //   405	442	492	finally
    //   499	510	492	finally
    //   17	40	497	java/lang/Exception
    //   45	59	497	java/lang/Exception
    //   64	70	497	java/lang/Exception
    //   76	89	497	java/lang/Exception
    //   94	109	497	java/lang/Exception
    //   109	126	497	java/lang/Exception
    //   134	146	497	java/lang/Exception
    //   157	172	497	java/lang/Exception
    //   172	189	497	java/lang/Exception
    //   197	225	497	java/lang/Exception
    //   232	265	497	java/lang/Exception
    //   268	308	497	java/lang/Exception
    //   313	353	497	java/lang/Exception
    //   390	399	497	java/lang/Exception
    //   405	442	497	java/lang/Exception
    //   544	570	573	java/lang/Exception
  }
  
  public boolean ETEngineLoaded()
  {
    return FontSoLoader.b();
  }
  
  public DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long paramLong)
  {
    Object localObject1 = LocalMultiProcConfig.getString4Uin("qzone_barrage_effect_save_data", "", paramLong);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    localObject1 = ((String)localObject1).split(";");
    if (localObject1 != null)
    {
      if (localObject1.length < 2) {
        return null;
      }
      Object localObject2 = new DefaultBarrageEffectInfo();
      try
      {
        ((DefaultBarrageEffectInfo)localObject2).itemId = Integer.valueOf(localObject1[0]).intValue();
        ((DefaultBarrageEffectInfo)localObject2).jsonStr = localObject1[1];
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadDefaultFontData Throwable, errMsg = ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("FontManager", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
    }
    return null;
  }
  
  public DefaultFontInfo getDefaultFont(long paramLong)
  {
    String str = LocalMultiProcConfig.getString4Uin("qzone_font_save_data", "", paramLong);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    DefaultFontInfo localDefaultFontInfo = new DefaultFontInfo();
    localDefaultFontInfo.readFrom(str);
    return localDefaultFontInfo;
  }
  
  public DefaultSuperFontInfo getDefaultSuperFont(long paramLong)
  {
    Object localObject1 = LocalMultiProcConfig.getString4Uin("qzone_super_font_save_data", "", paramLong);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    localObject1 = ((String)localObject1).split(";");
    if (localObject1 != null)
    {
      if (localObject1.length < 2) {
        return null;
      }
      Object localObject2 = new DefaultSuperFontInfo();
      try
      {
        ((DefaultSuperFontInfo)localObject2).fontId = Integer.valueOf(localObject1[0]).intValue();
        ((DefaultSuperFontInfo)localObject2).jsonStr = localObject1[1];
        return localObject2;
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadDefaultFontData Throwable, errMsg = ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.e("FontManager", 1, ((StringBuilder)localObject2).toString());
        return null;
      }
    }
    return null;
  }
  
  public ETEngine getETEngine()
  {
    boolean bool2 = FontSoLoader.b();
    boolean bool1 = true;
    ETEngine localETEngine = null;
    if ((!bool2) && (FontSoLoader.a()))
    {
      bool1 = FontSoLoader.c();
    }
    else if (!FontSoLoader.a())
    {
      startFontSoDownload(null);
      QLog.d("FontManager", 1, "initEngine but libvipfont.so didn't download, start download.");
      return null;
    }
    if (bool1) {
      localETEngine = ETEngine.getInstanceForSpace();
    }
    return localETEngine;
  }
  
  public String getFullTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFullTypeFont fontId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", strUrl = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("FontManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!checkFontIDValidity(paramInt)) {
      return null;
    }
    Object localObject = getFontPath(paramInt, 0);
    if (!new File((String)localObject).exists())
    {
      downloadTaskAndCheckNetwork(paramInt, paramString1, 0, paramString2, false, paramFullTypeResult);
      return null;
    }
    getFileCache().updateLruFile((String)localObject, true);
    return localObject;
  }
  
  public String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTrueTypeFont fontId:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", strUrl = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("FontManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!checkFontIDValidity(paramInt)) {
      return null;
    }
    Object localObject = getFontPath(paramInt, 1);
    if (!new File((String)localObject).exists())
    {
      downloadTaskAndCheckNetwork(paramInt, paramString1, 1, paramString2, paramBoolean, paramTrueTypeResult);
      return null;
    }
    getFileCache().updateLruFile((String)localObject, true);
    return localObject;
  }
  
  public void setDefaultBarrageEffect(long paramLong, DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo)
  {
    if ((paramDefaultBarrageEffectInfo != null) && (paramDefaultBarrageEffectInfo.itemId > 0) && (!TextUtils.isEmpty(paramDefaultBarrageEffectInfo.jsonStr)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDefaultBarrageEffectInfo.itemId);
      localStringBuilder.append(";");
      localStringBuilder.append(paramDefaultBarrageEffectInfo.jsonStr);
      localStringBuilder.append(";");
      paramDefaultBarrageEffectInfo = localStringBuilder.toString();
      setDefaultFont(paramLong, null);
      setDefaultSuperFont(paramLong, null);
    }
    else
    {
      paramDefaultBarrageEffectInfo = "";
    }
    LocalMultiProcConfig.putString4Uin("qzone_barrage_effect_save_data", paramDefaultBarrageEffectInfo, paramLong);
  }
  
  public void setDefaultFont(long paramLong, DefaultFontInfo paramDefaultFontInfo)
  {
    if ((paramDefaultFontInfo != null) && (paramDefaultFontInfo.fontId > 0) && (!TextUtils.isEmpty(paramDefaultFontInfo.fontUrl)))
    {
      paramDefaultFontInfo = paramDefaultFontInfo.toString();
      setDefaultBarrageEffect(paramLong, null);
    }
    else
    {
      paramDefaultFontInfo = "";
    }
    LocalMultiProcConfig.putString4Uin("qzone_font_save_data", paramDefaultFontInfo, paramLong);
  }
  
  public void setDefaultSuperFont(long paramLong, DefaultSuperFontInfo paramDefaultSuperFontInfo)
  {
    if ((paramDefaultSuperFontInfo != null) && (paramDefaultSuperFontInfo.fontId > 0) && (!TextUtils.isEmpty(paramDefaultSuperFontInfo.jsonStr)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDefaultSuperFontInfo.fontId);
      localStringBuilder.append(";");
      localStringBuilder.append(paramDefaultSuperFontInfo.jsonStr);
      localStringBuilder.append(";");
      paramDefaultSuperFontInfo = localStringBuilder.toString();
      setDefaultBarrageEffect(paramLong, null);
    }
    else
    {
      paramDefaultSuperFontInfo = "";
    }
    LocalMultiProcConfig.putString4Uin("qzone_super_font_save_data", paramDefaultSuperFontInfo, paramLong);
  }
  
  public void startFontSoDownload(EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    paramEarlyDownLoadListener = new FontManager.2(this);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.a, null, paramEarlyDownLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.font.FontManager
 * JD-Core Version:    0.7.0.1
 */