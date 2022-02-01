package cooperation.qzone.font;

import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.FontSoLoader;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
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
    if (this.downloadingFontIDs == null) {}
    for (;;)
    {
      return;
      synchronized (this.downloadingFontIDs)
      {
        Object localObject2 = (ArrayList)this.downloadingFontIDs.remove(Integer.valueOf(paramInt));
        if (localObject2 == null) {
          continue;
        }
        ??? = ((ArrayList)localObject2).iterator();
        FontInterface.FontResult localFontResult;
        do
        {
          if (!((Iterator)???).hasNext()) {
            break;
          }
          localObject2 = (FontManager.DownLoadFontTask)((Iterator)???).next();
          localFontResult = (FontInterface.FontResult)((FontManager.DownLoadFontTask)localObject2).result.get();
        } while (localFontResult == null);
        localFontResult.result(paramInt, getFontPathIfExist(paramInt, ((FontManager.DownLoadFontTask)localObject2).fontType), ((FontManager.DownLoadFontTask)localObject2).extend);
      }
    }
  }
  
  private boolean checkFontIDValidity(int paramInt)
  {
    return paramInt > 0;
  }
  
  private boolean convertFontFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    Object localObject = paramString2 + "." + getProcessName() + ".tmp";
    boolean bool;
    try
    {
      ETEngine.getInstanceForSpace();
      bool = ETEngine.native_ftf2ttf(paramString1, (String)localObject);
      if (!bool) {
        break label174;
      }
      paramString1 = new File((String)localObject);
      localObject = new File(paramString2);
      if (!((File)localObject).exists()) {
        bool = paramString1.renameTo((File)localObject);
      }
      if (!bool)
      {
        QLog.e("FontManager", 1, "failed to move trueType font file, from path = " + paramString1.getAbsolutePath());
        return bool;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("FontManager", 1, "call native_ftf2ttf error, errMsg = " + paramString1.toString());
      return false;
    }
    getFileCache().updateLruFile(paramString2, true);
    return bool;
    label174:
    QLog.e("FontManager", 1, "call native_ftf2ttf error");
    return bool;
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
        if (QLog.isDevelopLevel()) {
          QLog.d("FontManager", 4, "add new download task. fontId =" + paramInt1);
        }
        paramFontResult = new ArrayList();
        paramFontResult.add(localDownLoadFontTask);
        this.downloadingFontIDs.put(Integer.valueOf(paramInt1), paramFontResult);
        ThreadManager.post(new FontManager.4(this, paramString1, paramInt1), 5, null, false);
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("FontManager", 4, "attache download task. fontId =" + paramInt1);
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
    if ((!NetworkState.isNetSupport()) || (getETEngine() == null))
    {
      paramFontResult.result(paramInt1, null, paramString2);
      return;
    }
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
  }
  
  private File[] getAllFontInFolder(File paramFile)
  {
    return paramFile.listFiles(this.fontFilter);
  }
  
  private String getDownLoadDir()
  {
    if (!TextUtils.isEmpty(this.fontDownloadDir)) {
      return this.fontDownloadDir + File.separator;
    }
    this.fontDownloadDir = (getFontDir() + getProcessName());
    File localFile = new File(this.fontDownloadDir);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return this.fontDownloadDir + File.separator;
  }
  
  private String getDownloadZipPath(int paramInt)
  {
    return getDownLoadDir() + paramInt + ".zip";
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
    if (!TextUtils.isEmpty(this.fontDir)) {
      return this.fontDir + File.separator;
    }
    this.fontDir = CacheManager.getPersonaliseFontDir();
    File localFile = new File(this.fontDir);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return this.fontDir + File.separator;
  }
  
  private int getFontIDFromFile(File paramFile)
  {
    try
    {
      paramFile = paramFile.getName();
      int i = Integer.parseInt(paramFile.substring(0, paramFile.indexOf('.')));
      return i;
    }
    catch (Exception paramFile) {}
    return -1;
  }
  
  private String getFontName(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (String str = ".ttf";; str = ".ftf")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1).append(str);
      return localStringBuilder.toString();
      if (paramInt2 != 0) {
        break;
      }
    }
    throw new IllegalArgumentException("fontType = " + paramInt2);
  }
  
  private String getFontPath(int paramInt1, int paramInt2)
  {
    return getFontDir() + getFontName(paramInt1, paramInt2);
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
    String str;
    int i;
    if (TextUtils.isEmpty(this.processName))
    {
      str = BaseApplicationImpl.getApplication().getQQProcessName();
      i = str.indexOf(':');
      if ((i <= 0) || (i >= str.length() - 1)) {
        break label54;
      }
    }
    label54:
    for (this.processName = str.substring(i + 1);; this.processName = str) {
      return this.processName;
    }
  }
  
  private String getUnzipDir(int paramInt)
  {
    String str = getDownLoadDir() + paramInt;
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator;
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
    QLog.d("FontManager", 1, "cache font size = " + this.catchFontInfoMap.size());
  }
  
  /* Error */
  private boolean unzipFont(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 101	cooperation/qzone/font/FontManager:getDownloadZipPath	(I)Ljava/lang/String;
    //   5: astore 5
    //   7: aload_0
    //   8: iload_1
    //   9: invokespecial 435	cooperation/qzone/font/FontManager:getUnzipDir	(I)Ljava/lang/String;
    //   12: astore 6
    //   14: new 224	java/io/File
    //   17: dup
    //   18: aload 5
    //   20: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: new 224	java/io/File
    //   26: dup
    //   27: aload 6
    //   29: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokestatic 441	cooperation/qzone/util/FileUtils:unzip	(Ljava/io/File;Ljava/io/File;)Z
    //   35: istore 4
    //   37: iload 4
    //   39: ifeq +440 -> 479
    //   42: new 224	java/io/File
    //   45: dup
    //   46: aload 6
    //   48: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokevirtual 444	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 7
    //   56: aload 7
    //   58: ifnull +375 -> 433
    //   61: aload 7
    //   63: arraylength
    //   64: ifle +369 -> 433
    //   67: aload 7
    //   69: iconst_0
    //   70: aaload
    //   71: astore 7
    //   73: invokestatic 219	com/etrump/mixlayout/ETEngine:getInstanceForSpace	()Lcom/etrump/mixlayout/ETEngine;
    //   76: pop
    //   77: aload 7
    //   79: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: invokestatic 447	com/etrump/mixlayout/ETEngine:native_getFontType	(Ljava/lang/String;)I
    //   85: istore_2
    //   86: iload_2
    //   87: iconst_2
    //   88: if_icmpne +192 -> 280
    //   91: new 224	java/io/File
    //   94: dup
    //   95: aload_0
    //   96: iload_1
    //   97: iconst_1
    //   98: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   101: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore 8
    //   106: aload 8
    //   108: invokevirtual 230	java/io/File:exists	()Z
    //   111: ifne +12 -> 123
    //   114: aload 7
    //   116: aload 8
    //   118: invokevirtual 234	java/io/File:renameTo	(Ljava/io/File;)Z
    //   121: istore 4
    //   123: iload 4
    //   125: istore_3
    //   126: iload 4
    //   128: ifeq +18 -> 146
    //   131: invokestatic 83	cooperation/qzone/font/FontManager:getFileCache	()Lcooperation/qzone/cache/FileCacheService;
    //   134: aload 8
    //   136: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: iconst_1
    //   140: invokevirtual 254	cooperation/qzone/cache/FileCacheService:updateLruFile	(Ljava/lang/String;Z)V
    //   143: iload 4
    //   145: istore_3
    //   146: iload_3
    //   147: ifeq +209 -> 356
    //   150: new 127	cooperation/qzone/font/FontInfo
    //   153: dup
    //   154: invokespecial 448	cooperation/qzone/font/FontInfo:<init>	()V
    //   157: astore 7
    //   159: aload 7
    //   161: iload_1
    //   162: putfield 451	cooperation/qzone/font/FontInfo:fontId	I
    //   165: aload_0
    //   166: getfield 52	cooperation/qzone/font/FontManager:catchFontInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   169: aload 7
    //   171: getfield 451	cooperation/qzone/font/FontInfo:fontId	I
    //   174: invokestatic 135	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aload 7
    //   179: invokevirtual 139	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: new 224	java/io/File
    //   186: dup
    //   187: aload 5
    //   189: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   195: pop
    //   196: new 224	java/io/File
    //   199: dup
    //   200: aload 6
    //   202: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   208: pop
    //   209: iload_3
    //   210: ireturn
    //   211: astore 7
    //   213: ldc 20
    //   215: iconst_1
    //   216: new 197	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 456
    //   226: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 7
    //   231: invokevirtual 248	java/lang/Throwable:toString	()Ljava/lang/String;
    //   234: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: new 224	java/io/File
    //   246: dup
    //   247: aload 5
    //   249: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   255: pop
    //   256: new 224	java/io/File
    //   259: dup
    //   260: aload 6
    //   262: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   265: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   268: pop
    //   269: iconst_0
    //   270: ireturn
    //   271: astore 5
    //   273: aload 5
    //   275: invokevirtual 459	java/lang/Exception:printStackTrace	()V
    //   278: iconst_0
    //   279: ireturn
    //   280: iload_2
    //   281: iconst_1
    //   282: if_icmpne +262 -> 544
    //   285: new 224	java/io/File
    //   288: dup
    //   289: aload_0
    //   290: iload_1
    //   291: iconst_0
    //   292: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   295: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: astore 8
    //   300: aload 8
    //   302: invokevirtual 230	java/io/File:exists	()Z
    //   305: ifne +12 -> 317
    //   308: aload 7
    //   310: aload 8
    //   312: invokevirtual 234	java/io/File:renameTo	(Ljava/io/File;)Z
    //   315: istore 4
    //   317: iload 4
    //   319: istore_3
    //   320: iload 4
    //   322: ifeq -176 -> 146
    //   325: invokestatic 83	cooperation/qzone/font/FontManager:getFileCache	()Lcooperation/qzone/cache/FileCacheService;
    //   328: aload 8
    //   330: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   333: iconst_1
    //   334: invokevirtual 254	cooperation/qzone/cache/FileCacheService:updateLruFile	(Ljava/lang/String;Z)V
    //   337: aload_0
    //   338: aload 8
    //   340: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   343: aload_0
    //   344: iload_1
    //   345: iconst_1
    //   346: invokespecial 78	cooperation/qzone/font/FontManager:getFontPath	(II)Ljava/lang/String;
    //   349: invokespecial 89	cooperation/qzone/font/FontManager:convertFontFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   352: istore_3
    //   353: goto -207 -> 146
    //   356: ldc 20
    //   358: iconst_1
    //   359: new 197	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 461
    //   369: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload 7
    //   374: invokevirtual 239	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   377: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: goto -203 -> 183
    //   389: astore 7
    //   391: ldc 20
    //   393: iconst_1
    //   394: ldc_w 463
    //   397: aload 7
    //   399: invokestatic 467	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: new 224	java/io/File
    //   405: dup
    //   406: aload 5
    //   408: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   411: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   414: pop
    //   415: new 224	java/io/File
    //   418: dup
    //   419: aload 6
    //   421: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   424: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   427: pop
    //   428: iconst_0
    //   429: istore_3
    //   430: goto -221 -> 209
    //   433: ldc 20
    //   435: iconst_1
    //   436: ldc_w 469
    //   439: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: iload 4
    //   444: istore_3
    //   445: goto -262 -> 183
    //   448: astore 7
    //   450: new 224	java/io/File
    //   453: dup
    //   454: aload 5
    //   456: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   459: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   462: pop
    //   463: new 224	java/io/File
    //   466: dup
    //   467: aload 6
    //   469: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   472: invokestatic 454	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   475: pop
    //   476: aload 7
    //   478: athrow
    //   479: ldc 20
    //   481: iconst_1
    //   482: new 197	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 471
    //   492: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 5
    //   497: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 245	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iload 4
    //   508: istore_3
    //   509: goto -326 -> 183
    //   512: astore 5
    //   514: aload 5
    //   516: invokevirtual 459	java/lang/Exception:printStackTrace	()V
    //   519: goto -310 -> 209
    //   522: astore 5
    //   524: aload 5
    //   526: invokevirtual 459	java/lang/Exception:printStackTrace	()V
    //   529: iconst_0
    //   530: istore_3
    //   531: goto -322 -> 209
    //   534: astore 5
    //   536: aload 5
    //   538: invokevirtual 459	java/lang/Exception:printStackTrace	()V
    //   541: goto -65 -> 476
    //   544: iconst_0
    //   545: istore_3
    //   546: goto -400 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	FontManager
    //   0	549	1	paramInt	int
    //   85	198	2	i	int
    //   125	421	3	bool1	boolean
    //   35	472	4	bool2	boolean
    //   5	243	5	str1	String
    //   271	225	5	localException1	Exception
    //   512	3	5	localException2	Exception
    //   522	3	5	localException3	Exception
    //   534	3	5	localException4	Exception
    //   12	456	6	str2	String
    //   54	124	7	localObject1	Object
    //   211	162	7	localThrowable	Throwable
    //   389	9	7	localException5	Exception
    //   448	29	7	localObject2	Object
    //   104	235	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   73	86	211	java/lang/Throwable
    //   243	269	271	java/lang/Exception
    //   14	37	389	java/lang/Exception
    //   42	56	389	java/lang/Exception
    //   61	67	389	java/lang/Exception
    //   73	86	389	java/lang/Exception
    //   91	106	389	java/lang/Exception
    //   106	123	389	java/lang/Exception
    //   131	143	389	java/lang/Exception
    //   150	183	389	java/lang/Exception
    //   213	243	389	java/lang/Exception
    //   285	300	389	java/lang/Exception
    //   300	317	389	java/lang/Exception
    //   325	353	389	java/lang/Exception
    //   356	386	389	java/lang/Exception
    //   433	442	389	java/lang/Exception
    //   479	506	389	java/lang/Exception
    //   14	37	448	finally
    //   42	56	448	finally
    //   61	67	448	finally
    //   73	86	448	finally
    //   91	106	448	finally
    //   106	123	448	finally
    //   131	143	448	finally
    //   150	183	448	finally
    //   213	243	448	finally
    //   285	300	448	finally
    //   300	317	448	finally
    //   325	353	448	finally
    //   356	386	448	finally
    //   391	402	448	finally
    //   433	442	448	finally
    //   479	506	448	finally
    //   183	209	512	java/lang/Exception
    //   402	428	522	java/lang/Exception
    //   450	476	534	java/lang/Exception
  }
  
  public boolean ETEngineLoaded()
  {
    return FontSoLoader.b();
  }
  
  public FontManager.DefaultBarrageEffectInfo getDefaultBarrageEffectInfo(long paramLong)
  {
    Object localObject1 = LocalMultiProcConfig.getString4Uin("qzone_barrage_effect_save_data", "", paramLong);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = ((String)localObject1).split(";");
    } while ((arrayOfString == null) || (arrayOfString.length < 2));
    localObject1 = new FontManager.DefaultBarrageEffectInfo();
    try
    {
      ((FontManager.DefaultBarrageEffectInfo)localObject1).itemId = Integer.valueOf(arrayOfString[0]).intValue();
      ((FontManager.DefaultBarrageEffectInfo)localObject1).jsonStr = arrayOfString[1];
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("FontManager", 1, "loadDefaultFontData Throwable, errMsg = " + localThrowable.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public FontManager.DefaultFontInfo getDefaultFont(long paramLong)
  {
    String str = LocalMultiProcConfig.getString4Uin("qzone_font_save_data", "", paramLong);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    FontManager.DefaultFontInfo localDefaultFontInfo = new FontManager.DefaultFontInfo();
    localDefaultFontInfo.readFrom(str);
    return localDefaultFontInfo;
  }
  
  public FontManager.DefaultSuperFontInfo getDefaultSuperFont(long paramLong)
  {
    Object localObject1 = LocalMultiProcConfig.getString4Uin("qzone_super_font_save_data", "", paramLong);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = ((String)localObject1).split(";");
    } while ((arrayOfString == null) || (arrayOfString.length < 2));
    localObject1 = new FontManager.DefaultSuperFontInfo();
    try
    {
      ((FontManager.DefaultSuperFontInfo)localObject1).fontId = Integer.valueOf(arrayOfString[0]).intValue();
      ((FontManager.DefaultSuperFontInfo)localObject1).jsonStr = arrayOfString[1];
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("FontManager", 1, "loadDefaultFontData Throwable, errMsg = " + localThrowable.getMessage());
        Object localObject2 = null;
      }
    }
  }
  
  public ETEngine getETEngine()
  {
    boolean bool = true;
    ETEngine localETEngine = null;
    if ((!FontSoLoader.b()) && (FontSoLoader.a())) {
      bool = FontSoLoader.c();
    }
    while (FontSoLoader.a())
    {
      if (bool) {
        localETEngine = ETEngine.getInstanceForSpace();
      }
      return localETEngine;
    }
    startFontSoDownload(null);
    QLog.d("FontManager", 1, "initEngine but libvipfont.so didn't download, start download.");
    return null;
  }
  
  public String getFullTypeFont(int paramInt, String paramString1, String paramString2, FontInterface.FullTypeResult paramFullTypeResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getFullTypeFont fontId:" + paramInt + ", strUrl = " + paramString1);
    }
    if (!checkFontIDValidity(paramInt)) {
      return null;
    }
    String str = getFontPath(paramInt, 0);
    if (!new File(str).exists())
    {
      downloadTaskAndCheckNetwork(paramInt, paramString1, 0, paramString2, false, paramFullTypeResult);
      return null;
    }
    getFileCache().updateLruFile(str, true);
    return str;
  }
  
  public String getTrueTypeFont(int paramInt, String paramString1, String paramString2, boolean paramBoolean, FontInterface.TrueTypeResult paramTrueTypeResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FontManager", 2, "getTrueTypeFont fontId:" + paramInt + ", strUrl = " + paramString1);
    }
    if (!checkFontIDValidity(paramInt)) {
      return null;
    }
    String str = getFontPath(paramInt, 1);
    if (!new File(str).exists())
    {
      downloadTaskAndCheckNetwork(paramInt, paramString1, 1, paramString2, paramBoolean, paramTrueTypeResult);
      return null;
    }
    getFileCache().updateLruFile(str, true);
    return str;
  }
  
  public void setDefaultBarrageEffect(long paramLong, FontManager.DefaultBarrageEffectInfo paramDefaultBarrageEffectInfo)
  {
    String str = "";
    Object localObject = str;
    if (paramDefaultBarrageEffectInfo != null)
    {
      localObject = str;
      if (paramDefaultBarrageEffectInfo.itemId > 0)
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramDefaultBarrageEffectInfo.jsonStr))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramDefaultBarrageEffectInfo.itemId).append(";");
          ((StringBuilder)localObject).append(paramDefaultBarrageEffectInfo.jsonStr).append(";");
          localObject = ((StringBuilder)localObject).toString();
          setDefaultFont(paramLong, null);
          setDefaultSuperFont(paramLong, null);
        }
      }
    }
    LocalMultiProcConfig.putString4Uin("qzone_barrage_effect_save_data", (String)localObject, paramLong);
  }
  
  public void setDefaultFont(long paramLong, FontManager.DefaultFontInfo paramDefaultFontInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramDefaultFontInfo != null)
    {
      str1 = str2;
      if (paramDefaultFontInfo.fontId > 0)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramDefaultFontInfo.fontUrl))
        {
          str1 = paramDefaultFontInfo.toString();
          setDefaultBarrageEffect(paramLong, null);
        }
      }
    }
    LocalMultiProcConfig.putString4Uin("qzone_font_save_data", str1, paramLong);
  }
  
  public void setDefaultSuperFont(long paramLong, FontManager.DefaultSuperFontInfo paramDefaultSuperFontInfo)
  {
    String str = "";
    Object localObject = str;
    if (paramDefaultSuperFontInfo != null)
    {
      localObject = str;
      if (paramDefaultSuperFontInfo.fontId > 0)
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramDefaultSuperFontInfo.jsonStr))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramDefaultSuperFontInfo.fontId).append(";");
          ((StringBuilder)localObject).append(paramDefaultSuperFontInfo.jsonStr).append(";");
          localObject = ((StringBuilder)localObject).toString();
          setDefaultBarrageEffect(paramLong, null);
        }
      }
    }
    LocalMultiProcConfig.putString4Uin("qzone_super_font_save_data", (String)localObject, paramLong);
  }
  
  public void startFontSoDownload(EarlyDownloadManager.EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    paramEarlyDownLoadListener = new FontManager.2(this);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.a, null, paramEarlyDownLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.font.FontManager
 * JD-Core Version:    0.7.0.1
 */