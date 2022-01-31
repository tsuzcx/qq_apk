package dov.com.qq.im.capture.data;

import android.text.TextUtils;
import anls;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class QIMRedDotConfig
  implements Serializable
{
  public static final String CACHE_RED_DOT_NAME = "qim_red_dot_config.cfg";
  public static final String COMB0_ICON_VERSION_ID = "combo_iconRedDotVersion";
  public static final String COMBO_DEFAULT_CATEGORY_ID = "combo_defaultCategoryId";
  public static final String COMBO_DEFAULT_CATEGORY_VERSION = "combo_defaultCategoryVersion";
  public static final String COMBO_SHOW_RED_DOT = "combo_needRedDot";
  public static final String DEFAULT_CATEGORY_ID = "defaultCategoryId";
  public static final String DEFAULT_CATEGORY_VERSION = "defaultCategoryVersion";
  public static final String DEFAULT_USE_ID = "defaultUseId";
  public static final String DEFAULT_USE_VERSION = "defaultUseVersion";
  public static final int DOT_TYPE_COMBO_CATEGORY = 7;
  public static final int DOT_TYPE_DEFAULT_USE = 4;
  public static final int DOT_TYPE_FILTER_CATEGORY = 5;
  public static final int DOT_TYPE_ITEM_ICON = 3;
  public static final int DOT_TYPE_SECOND_ICON = 2;
  public static final int DOT_TYPE_TOP_ICON = 1;
  public static final int DOT_TYPE_TOP_ICON_COMBO = 6;
  public static final String ICON_VERSION_ID = "iconRedDotVersion";
  public static final int ILLEGAL_INDEX = -1;
  public static final String RED_DOT_LIST = "itemNeedRedDot";
  public static final String RED_DOT_LIST_VERSION = "itemRedDotVersion";
  public static final String SHOW_RED_DOT = "needRedDot";
  public static final int SHOW_TIME = 86400000;
  public static final String TAG = "QIMRedDotConfig";
  public static final int TYPE_FILTER_REDDOT = 1;
  public static final int TYPE_PTV_TEMPLATE_REDDOT = 2;
  public static final String VERSION_ID = "redDotVersion";
  private static final long serialVersionUID = 1L;
  public HashMap categories = new HashMap();
  public int comboDefaultCategoryId;
  public int comboDefaultCategoryVer;
  public long comboFirstShowTime;
  public boolean comboHasChoose;
  public boolean comboHasShow;
  public int comboIconVersion;
  public boolean comboShowRedDot;
  public int defaultCategoryId;
  public int defaultCategoryVer;
  public String defaultUseId;
  public int defaultUseVer;
  public long firstShowTime;
  public boolean hasChoose;
  public boolean hasShow;
  public boolean hasUse;
  public int iconVersion;
  public transient boolean isComboShowing = false;
  public transient boolean isShowing = false;
  public HashMap redDotItems = new HashMap();
  public int redDotVersion;
  public boolean showRedDot;
  public int type;
  public transient boolean update = false;
  
  public QIMRedDotConfig(int paramInt)
  {
    this.type = paramInt;
  }
  
  /* Error */
  public static QIMRedDotConfig getRedDotConfigFromFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 133	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 135	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 10
    //   16: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_3
    //   20: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +43 -> 66
    //   26: ldc 68
    //   28: iconst_2
    //   29: new 146	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   36: ldc 149
    //   38: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: invokevirtual 157	java/io/File:getPath	()Ljava/lang/String;
    //   45: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 159
    //   50: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 162	java/io/File:exists	()Z
    //   57: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_3
    //   67: invokevirtual 162	java/io/File:exists	()Z
    //   70: ifeq -63 -> 7
    //   73: new 174	java/io/ObjectInputStream
    //   76: dup
    //   77: new 176	java/io/BufferedInputStream
    //   80: dup
    //   81: new 178	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 184	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 185	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 189	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   102: checkcast 2	dov/com/qq/im/capture/data/QIMRedDotConfig
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +30 -> 141
    //   114: aload_1
    //   115: astore_0
    //   116: ldc 68
    //   118: iconst_2
    //   119: new 146	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   126: ldc 191
    //   128: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload_1
    //   148: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   151: aload_2
    //   152: astore_0
    //   153: aload_0
    //   154: areturn
    //   155: astore_2
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: astore_0
    //   160: aload_3
    //   161: invokevirtual 200	java/io/File:delete	()Z
    //   164: pop
    //   165: aload_1
    //   166: astore_0
    //   167: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +33 -> 203
    //   173: aload_1
    //   174: astore_0
    //   175: ldc 68
    //   177: iconst_2
    //   178: new 146	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   185: ldc 202
    //   187: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_2
    //   191: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   194: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_1
    //   204: ifnull +49 -> 253
    //   207: aload_1
    //   208: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   211: aconst_null
    //   212: astore_0
    //   213: goto -60 -> 153
    //   216: astore_0
    //   217: aconst_null
    //   218: astore_0
    //   219: goto -66 -> 153
    //   222: astore_1
    //   223: aconst_null
    //   224: astore_0
    //   225: aload_0
    //   226: ifnull +7 -> 233
    //   229: aload_0
    //   230: invokevirtual 197	java/io/ObjectInputStream:close	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_0
    //   236: aload_2
    //   237: astore_0
    //   238: goto -85 -> 153
    //   241: astore_0
    //   242: goto -9 -> 233
    //   245: astore_1
    //   246: goto -21 -> 225
    //   249: astore_2
    //   250: goto -92 -> 158
    //   253: aconst_null
    //   254: astore_0
    //   255: goto -102 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString	String
    //   95	113	1	localObjectInputStream	java.io.ObjectInputStream
    //   222	12	1	localObject1	Object
    //   245	1	1	localObject2	Object
    //   105	47	2	localQIMRedDotConfig	QIMRedDotConfig
    //   155	82	2	localException1	java.lang.Exception
    //   249	1	2	localException2	java.lang.Exception
    //   19	142	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   73	96	155	java/lang/Exception
    //   207	211	216	java/io/IOException
    //   73	96	222	finally
    //   147	151	235	java/io/IOException
    //   229	233	241	java/io/IOException
    //   98	106	245	finally
    //   108	114	245	finally
    //   116	141	245	finally
    //   160	165	245	finally
    //   167	173	245	finally
    //   175	203	245	finally
    //   98	106	249	java/lang/Exception
    //   108	114	249	java/lang/Exception
    //   116	141	249	java/lang/Exception
  }
  
  public static void saveRedDotConfig(QIMRedDotConfig paramQIMRedDotConfig, String paramString)
  {
    if ((paramQIMRedDotConfig == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saveRedDotConfig|config= " + paramQIMRedDotConfig);
    }
    ThreadManager.getFileThreadHandler().post(new anls(paramString, paramQIMRedDotConfig));
  }
  
  public boolean needShowRedDot(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    case 4: 
    case 5: 
    default: 
      return false;
    case 1: 
      return showIconRedDot();
    case 6: 
      return showComboIconRedDot();
    case 2: 
      return showCategoryRedDot(paramInt2);
    }
    return showRedDot(paramInt2, paramString);
  }
  
  public boolean showCategoryRedDot(int paramInt)
  {
    QIMRedDotConfig.CategoryRedConfig localCategoryRedConfig;
    if (this.categories.size() > 0)
    {
      localCategoryRedConfig = (QIMRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt));
      if ((localCategoryRedConfig != null) && (localCategoryRedConfig.showRedDot))
      {
        if (localCategoryRedConfig.hasShow) {
          break label140;
        }
        if (localCategoryRedConfig.firstShowTime <= 0L) {
          break label121;
        }
        if (System.currentTimeMillis() - localCategoryRedConfig.firstShowTime < 86400000L)
        {
          localCategoryRedConfig.isShowing = true;
          return true;
        }
        this.update = true;
        localCategoryRedConfig.hasShow = true;
        if (QLog.isColorLevel()) {
          QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot out of time | id=" + localCategoryRedConfig.categoryId);
        }
      }
    }
    for (;;)
    {
      return false;
      label121:
      this.update = true;
      localCategoryRedConfig.firstShowTime = System.currentTimeMillis();
      localCategoryRedConfig.isShowing = true;
      return true;
      label140:
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showCategoryRedDot hasShow | id=" + localCategoryRedConfig.categoryId);
      }
    }
  }
  
  public boolean showComboIconRedDot()
  {
    if (!this.comboShowRedDot) {}
    do
    {
      do
      {
        return false;
        if (!this.comboHasShow) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMRedDotConfig", 2, "showIconRedDot hasShow | type=" + this.type);
      return false;
      if (this.comboFirstShowTime <= 0L) {
        break label131;
      }
      if (System.currentTimeMillis() - this.comboFirstShowTime < 86400000L) {
        break;
      }
      this.comboHasShow = true;
      this.update = true;
    } while (!QLog.isColorLevel());
    QLog.d("QIMRedDotConfig", 2, "showIconRedDot out of time | type=" + this.type);
    return false;
    this.isComboShowing = true;
    return true;
    label131:
    this.comboFirstShowTime = System.currentTimeMillis();
    this.isComboShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showIconRedDot()
  {
    if (!this.showRedDot) {}
    do
    {
      do
      {
        return false;
        if (!this.hasShow) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMRedDotConfig", 2, "showIconRedDot hasShow | type=" + this.type);
      return false;
      if (this.firstShowTime <= 0L) {
        break label131;
      }
      if (System.currentTimeMillis() - this.firstShowTime < 86400000L) {
        break;
      }
      this.hasShow = true;
      this.update = true;
    } while (!QLog.isColorLevel());
    QLog.d("QIMRedDotConfig", 2, "showIconRedDot out of time | type=" + this.type);
    return false;
    this.isShowing = true;
    return true;
    label131:
    this.firstShowTime = System.currentTimeMillis();
    this.isShowing = true;
    this.update = true;
    return true;
  }
  
  public boolean showRedDot(int paramInt, String paramString)
  {
    if ((this.redDotItems.isEmpty()) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (paramString.equals(this.defaultUseId)) {
      return false;
    }
    paramString = (QIMRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
    if (paramString != null)
    {
      if (paramString.hasShow) {
        break label152;
      }
      if (paramString.firstShowTime <= 0L) {
        break label133;
      }
      if (System.currentTimeMillis() - paramString.firstShowTime < 86400000L)
      {
        paramString.isShowing = true;
        return true;
      }
      this.update = true;
      paramString.hasShow = true;
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showRedDot out of time | id=" + paramString.filterId);
      }
    }
    for (;;)
    {
      return false;
      label133:
      this.update = true;
      paramString.firstShowTime = System.currentTimeMillis();
      paramString.isShowing = true;
      return true;
      label152:
      if (QLog.isColorLevel()) {
        QLog.d("QIMRedDotConfig", 2, "showRedDot hasShow | id=" + paramString.filterId);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMRedDotConfig{");
    localStringBuilder.append("type=").append(this.type);
    localStringBuilder.append(", iconVersion=").append(this.iconVersion);
    localStringBuilder.append(", showRedDot=").append(this.showRedDot);
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
    localStringBuilder.append(", comboIconVersion=").append(this.comboIconVersion);
    localStringBuilder.append(", comboShowRedDot=").append(this.comboShowRedDot);
    localStringBuilder.append(", comboHasShow=").append(this.comboHasShow);
    localStringBuilder.append(", comboFirstShowTime=").append(this.comboFirstShowTime);
    localStringBuilder.append(", defaultUseVer=").append(this.defaultUseVer);
    localStringBuilder.append(", defaultUseId='").append(this.defaultUseId).append('\'');
    localStringBuilder.append(", hasUse=").append(this.hasUse);
    localStringBuilder.append(", defaultCategoryVer=").append(this.defaultCategoryVer);
    localStringBuilder.append(", defaultCategoryId=").append(this.defaultCategoryId);
    localStringBuilder.append(", hasChoose=").append(this.hasChoose);
    localStringBuilder.append(", redDotVersion=").append(this.redDotVersion);
    localStringBuilder.append(", redDotItems=").append(this.redDotItems);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean updateRedDotInfo(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    switch (paramInt1)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        this.update = true;
      }
      return bool;
      if ((!this.isShowing) || (this.hasShow)) {
        break;
      }
      this.hasShow = true;
      this.firstShowTime = 0L;
      this.isShowing = false;
      bool = true;
      continue;
      if ((!this.isComboShowing) || (this.comboHasShow)) {
        break;
      }
      this.comboHasShow = true;
      this.comboFirstShowTime = 0L;
      this.isComboShowing = false;
      bool = true;
      continue;
      paramString = (QIMRedDotConfig.CategoryRedConfig)this.categories.get(Integer.valueOf(paramInt2));
      if ((paramString == null) || (!paramString.isShowing) || (paramString.hasShow)) {
        break;
      }
      paramString.hasShow = true;
      paramString.firstShowTime = 0L;
      paramString.isShowing = false;
      bool = true;
      continue;
      paramString = (QIMRedDotConfig.RedDotItemConfig)this.redDotItems.get(paramString);
      if ((paramString == null) || (!paramString.isShowing) || (paramString.hasShow)) {
        break;
      }
      paramString.hasShow = true;
      paramString.firstShowTime = 0L;
      paramString.isShowing = false;
      bool = true;
      continue;
      if ((TextUtils.isEmpty(this.defaultUseId)) || (this.hasUse)) {
        break;
      }
      this.hasUse = true;
      bool = true;
      continue;
      if ((this.defaultCategoryId == -1) || (this.hasChoose)) {
        break;
      }
      this.hasChoose = true;
      bool = true;
      continue;
      if ((this.comboDefaultCategoryId == -1) || (this.comboHasChoose)) {
        break;
      }
      this.comboHasChoose = true;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMRedDotConfig
 * JD-Core Version:    0.7.0.1
 */