package com.tencent.mobileqq.richmedia.capture.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class CaptureRedDotConfig
  implements Serializable
{
  public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
  public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
  public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
  public static final String DEFAULT_USE_ID = "defaultUseId";
  public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
  public static final int DOT_DEFAULT_CATEGORY = 5;
  public static final int DOT_TYPE_DEFAULT_USE = 4;
  public static final int DOT_TYPE_ITEM_ICON = 3;
  public static final int DOT_TYPE_SECOND_ICON = 2;
  public static final int DOT_TYPE_TOP_ICON = 1;
  public static final String ICON_VERSION_ID = "iconRedDotVersion";
  public static final int ILLEGAL_INDEX = -1;
  public static final String RED_DOT_LIST = "itemNeedRedDot";
  public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
  public static final String SHOW_RED_DOT = "needRedDot";
  public static int SHOW_TIME_DEFAULT = 86400000;
  public static final String TAG = "QIMRedDotConfig";
  public static final int TYPE_FILTER_REDDOT = 1;
  public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
  public static final String VERSION_ID = "redDotVersion";
  private static final long serialVersionUID = 1L;
  public HashMap<Integer, CaptureRedDotConfig.CategoryRedConfig> categories = new HashMap();
  public int defaultCategoryId;
  public int defaultCategoryVer;
  public String defaultUseId;
  public int defaultUseVer;
  public long firstShowTime;
  public boolean hasChoose;
  public boolean hasShow;
  public boolean hasUse;
  public int iconVersion;
  public transient boolean isShowing = false;
  public HashMap<String, CaptureRedDotConfig.RedDotItemConfig> redDotItems = new HashMap();
  public int redDotVersion;
  public boolean showRedDot;
  public int showTime;
  public int type;
  public transient boolean update = false;
  
  public CaptureRedDotConfig(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  public static CaptureRedDotConfig getRedDotConfigFromFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 111	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 113	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 10
    //   16: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_3
    //   20: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +78 -> 101
    //   26: new 124	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   33: astore_0
    //   34: aload_0
    //   35: ldc 52
    //   37: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_0
    //   42: aload_1
    //   43: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_0
    //   48: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_0
    //   52: new 124	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc 135
    //   63: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_2
    //   68: aload_3
    //   69: invokevirtual 138	java/io/File:getPath	()Ljava/lang/String;
    //   72: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: ldc 140
    //   79: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: aload_3
    //   85: invokevirtual 143	java/io/File:exists	()Z
    //   88: invokevirtual 146	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_0
    //   93: iconst_2
    //   94: aload_2
    //   95: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_3
    //   102: invokevirtual 143	java/io/File:exists	()Z
    //   105: ifne +5 -> 110
    //   108: aconst_null
    //   109: areturn
    //   110: new 152	java/io/ObjectInputStream
    //   113: dup
    //   114: new 154	java/io/BufferedInputStream
    //   117: dup
    //   118: new 156	java/io/FileInputStream
    //   121: dup
    //   122: aload_3
    //   123: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: invokespecial 162	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   129: invokespecial 163	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   132: astore_2
    //   133: aload_2
    //   134: astore_0
    //   135: aload_2
    //   136: invokevirtual 167	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   139: checkcast 2	com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig
    //   142: astore 4
    //   144: aload_2
    //   145: astore_0
    //   146: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +84 -> 233
    //   152: aload_2
    //   153: astore_0
    //   154: new 124	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   161: astore 5
    //   163: aload_2
    //   164: astore_0
    //   165: aload 5
    //   167: ldc 52
    //   169: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: astore_0
    //   175: aload 5
    //   177: aload_1
    //   178: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: astore_0
    //   184: aload 5
    //   186: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_1
    //   190: aload_2
    //   191: astore_0
    //   192: new 124	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   199: astore 5
    //   201: aload_2
    //   202: astore_0
    //   203: aload 5
    //   205: ldc 169
    //   207: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_2
    //   212: astore_0
    //   213: aload 5
    //   215: aload 4
    //   217: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_2
    //   222: astore_0
    //   223: aload_1
    //   224: iconst_2
    //   225: aload 5
    //   227: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_2
    //   234: invokevirtual 175	java/io/ObjectInputStream:close	()V
    //   237: aload 4
    //   239: areturn
    //   240: astore_0
    //   241: aload_2
    //   242: astore_1
    //   243: aload_0
    //   244: astore_2
    //   245: goto +12 -> 257
    //   248: astore_1
    //   249: aconst_null
    //   250: astore_0
    //   251: goto +74 -> 325
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: astore_0
    //   259: aload_3
    //   260: invokevirtual 178	java/io/File:delete	()Z
    //   263: pop
    //   264: aload_1
    //   265: astore_0
    //   266: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +45 -> 314
    //   272: aload_1
    //   273: astore_0
    //   274: new 124	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   281: astore_3
    //   282: aload_1
    //   283: astore_0
    //   284: aload_3
    //   285: ldc 180
    //   287: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: astore_0
    //   293: aload_3
    //   294: aload_2
    //   295: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   298: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_1
    //   303: astore_0
    //   304: ldc 52
    //   306: iconst_2
    //   307: aload_3
    //   308: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_1
    //   315: ifnull +7 -> 322
    //   318: aload_1
    //   319: invokevirtual 175	java/io/ObjectInputStream:close	()V
    //   322: aconst_null
    //   323: areturn
    //   324: astore_1
    //   325: aload_0
    //   326: ifnull +7 -> 333
    //   329: aload_0
    //   330: invokevirtual 175	java/io/ObjectInputStream:close	()V
    //   333: aload_1
    //   334: athrow
    //   335: astore_0
    //   336: goto -99 -> 237
    //   339: astore_0
    //   340: aconst_null
    //   341: areturn
    //   342: astore_0
    //   343: goto -10 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	paramString1	String
    //   0	346	1	paramString2	String
    //   59	186	2	localObject1	Object
    //   254	41	2	localException	java.lang.Exception
    //   19	289	3	localObject2	Object
    //   142	96	4	localCaptureRedDotConfig	CaptureRedDotConfig
    //   161	65	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   135	144	240	java/lang/Exception
    //   146	152	240	java/lang/Exception
    //   154	163	240	java/lang/Exception
    //   165	173	240	java/lang/Exception
    //   175	182	240	java/lang/Exception
    //   184	190	240	java/lang/Exception
    //   192	201	240	java/lang/Exception
    //   203	211	240	java/lang/Exception
    //   213	221	240	java/lang/Exception
    //   223	233	240	java/lang/Exception
    //   110	133	248	finally
    //   110	133	254	java/lang/Exception
    //   135	144	324	finally
    //   146	152	324	finally
    //   154	163	324	finally
    //   165	173	324	finally
    //   175	182	324	finally
    //   184	190	324	finally
    //   192	201	324	finally
    //   203	211	324	finally
    //   213	221	324	finally
    //   223	233	324	finally
    //   259	264	324	finally
    //   266	272	324	finally
    //   274	282	324	finally
    //   284	291	324	finally
    //   293	302	324	finally
    //   304	314	324	finally
    //   233	237	335	java/io/IOException
    //   318	322	339	java/io/IOException
    //   329	333	342	java/io/IOException
  }
  
  public static void saveRedDotConfig(CaptureRedDotConfig paramCaptureRedDotConfig, String paramString1, String paramString2)
  {
    if (paramCaptureRedDotConfig != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QIMRedDotConfig");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveRedDotConfig|config= ");
        localStringBuilder.append(paramCaptureRedDotConfig);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      ThreadManager.getFileThreadHandler().post(new CaptureRedDotConfig.1(paramString1, paramCaptureRedDotConfig, paramString2));
    }
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        return showRedDot(paramInt2, paramString);
      }
      return showCategoryRedDot(paramInt2);
    }
    return showIconRedDot();
  }
  
  public boolean showCategoryRedDot(int paramInt)
  {
    if (this.categories.size() > 0)
    {
      CaptureRedDotConfig.CategoryRedConfig localCategoryRedConfig = (CaptureRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt));
      if ((localCategoryRedConfig != null) && (localCategoryRedConfig.showRedDot))
      {
        StringBuilder localStringBuilder;
        if (!localCategoryRedConfig.hasShow)
        {
          if (localCategoryRedConfig.firstShowTime > 0L)
          {
            if (System.currentTimeMillis() - localCategoryRedConfig.firstShowTime < this.showTime)
            {
              localCategoryRedConfig.isShowing = true;
              return true;
            }
            this.update = true;
            localCategoryRedConfig.hasShow = true;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("showCategoryRedDot out of time | id=");
              localStringBuilder.append(localCategoryRedConfig.categoryId);
              QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
            }
          }
          else
          {
            this.update = true;
            localCategoryRedConfig.firstShowTime = System.currentTimeMillis();
            localCategoryRedConfig.isShowing = true;
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showCategoryRedDot hasShow | id=");
          localStringBuilder.append(localCategoryRedConfig.categoryId);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  public boolean showIconRedDot()
  {
    if (!this.showRedDot) {
      return false;
    }
    StringBuilder localStringBuilder;
    if (this.hasShow)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showIconRedDot hasShow | type=");
        localStringBuilder.append(this.type);
        QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
      }
      return false;
    }
    if (this.firstShowTime > 0L)
    {
      if (System.currentTimeMillis() - this.firstShowTime >= this.showTime)
      {
        this.hasShow = true;
        this.update = true;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showIconRedDot out of time | type=");
          localStringBuilder.append(this.type);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
        return false;
      }
      this.isShowing = true;
      return true;
    }
    this.firstShowTime = System.currentTimeMillis();
    this.isShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showRedDot(int paramInt, String paramString)
  {
    if (!this.redDotItems.isEmpty())
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramString.equals(this.defaultUseId)) {
        return false;
      }
      paramString = (CaptureRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
      if (paramString != null)
      {
        StringBuilder localStringBuilder;
        if (!paramString.hasShow)
        {
          if (paramString.firstShowTime > 0L)
          {
            if (System.currentTimeMillis() - paramString.firstShowTime < this.showTime)
            {
              paramString.isShowing = true;
              return true;
            }
            this.update = true;
            paramString.hasShow = true;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("showRedDot out of time | id=");
              localStringBuilder.append(paramString.filterId);
              QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
              return false;
            }
          }
          else
          {
            this.update = true;
            paramString.firstShowTime = System.currentTimeMillis();
            paramString.isShowing = true;
            return true;
          }
        }
        else if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showRedDot hasShow | id=");
          localStringBuilder.append(paramString.filterId);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("QIMRedDotConfig{");
    localStringBuilder1.append("type=");
    localStringBuilder1.append(this.type);
    localStringBuilder1.append(", iconVersion=");
    localStringBuilder1.append(this.iconVersion);
    localStringBuilder1.append(", showRedDot=");
    localStringBuilder1.append(this.showRedDot);
    localStringBuilder1.append(", hasShow=");
    localStringBuilder1.append(this.hasShow);
    localStringBuilder1.append(", firstShowTime=");
    localStringBuilder1.append(this.firstShowTime);
    localStringBuilder1.append(", defaultUseVer=");
    localStringBuilder1.append(this.defaultUseVer);
    localStringBuilder1.append(", defaultUseId='");
    localStringBuilder1.append(this.defaultUseId);
    localStringBuilder1.append('\'');
    localStringBuilder1.append(", hasUse=");
    localStringBuilder1.append(this.hasUse);
    localStringBuilder1.append(", defaultCategoryVer=");
    localStringBuilder1.append(this.defaultCategoryVer);
    localStringBuilder1.append(", defaultCategoryId=");
    localStringBuilder1.append(this.defaultCategoryId);
    localStringBuilder1.append(", hasChoose=");
    localStringBuilder1.append(this.hasChoose);
    localStringBuilder1.append(", redDotVersion=");
    localStringBuilder1.append(this.redDotVersion);
    localStringBuilder1.append(", redDotItems=");
    localStringBuilder1.append(this.redDotItems);
    localStringBuilder1.append(", showTime=");
    localStringBuilder1.append(this.showTime);
    Iterator localIterator = this.categories.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(localEntry.getValue());
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.append('}');
    return localStringBuilder1.toString();
  }
  
  public boolean updateRedDotInfo(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              bool1 = bool2;
              break label307;
            }
            bool1 = bool2;
            if (this.defaultCategoryId == -1) {
              break label307;
            }
            bool1 = bool2;
            if (this.hasChoose) {
              break label307;
            }
            this.hasChoose = true;
          }
          else
          {
            bool1 = bool2;
            if (TextUtils.isEmpty(this.defaultUseId)) {
              break label307;
            }
            bool1 = bool2;
            if (this.hasUse) {
              break label307;
            }
            this.hasUse = true;
          }
        }
        else
        {
          paramString = (CaptureRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
          bool1 = bool2;
          if (paramString == null) {
            break label307;
          }
          bool1 = bool2;
          if (!paramString.isShowing) {
            break label307;
          }
          bool1 = bool2;
          if (paramString.hasShow) {
            break label307;
          }
          paramString.hasShow = true;
          paramString.firstShowTime = 0L;
          paramString.isShowing = false;
        }
      }
      else
      {
        paramString = (CaptureRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt2));
        bool1 = bool2;
        if (paramString == null) {
          break label307;
        }
        bool1 = bool2;
        if (!paramString.isShowing) {
          break label307;
        }
        bool1 = bool2;
        if (paramString.hasShow) {
          break label307;
        }
        paramString.hasShow = true;
        paramString.firstShowTime = 0L;
        paramString.isShowing = false;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("更新has show = ");
          localStringBuilder.append(paramString.hasShow);
          QLog.d("QIMRedDotConfig", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (!this.isShowing) {
        break label307;
      }
      bool1 = bool2;
      if (this.hasShow) {
        break label307;
      }
      this.hasShow = true;
      this.firstShowTime = 0L;
      this.isShowing = false;
    }
    boolean bool1 = true;
    label307:
    if (bool1) {
      this.update = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CaptureRedDotConfig
 * JD-Core Version:    0.7.0.1
 */