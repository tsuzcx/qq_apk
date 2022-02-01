package dov.com.qq.im.capture.data;

import android.text.TextUtils;
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
  public HashMap<Integer, QIMRedDotConfig.CategoryRedConfig> categories = new HashMap();
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
  public HashMap<String, QIMRedDotConfig.RedDotItemConfig> redDotItems = new HashMap();
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
    //   1: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 137	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 10
    //   16: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_3
    //   20: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +43 -> 66
    //   26: ldc 68
    //   28: iconst_2
    //   29: new 148	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   36: ldc 151
    //   38: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_3
    //   42: invokevirtual 159	java/io/File:getPath	()Ljava/lang/String;
    //   45: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 161
    //   50: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_3
    //   54: invokevirtual 164	java/io/File:exists	()Z
    //   57: invokevirtual 167	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_3
    //   67: invokevirtual 164	java/io/File:exists	()Z
    //   70: ifeq -63 -> 7
    //   73: new 176	java/io/ObjectInputStream
    //   76: dup
    //   77: new 178	java/io/BufferedInputStream
    //   80: dup
    //   81: new 180	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 186	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore_1
    //   96: aload_1
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 191	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   102: checkcast 2	dov/com/qq/im/capture/data/QIMRedDotConfig
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +30 -> 141
    //   114: aload_1
    //   115: astore_0
    //   116: ldc 68
    //   118: iconst_2
    //   119: new 148	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   126: ldc 193
    //   128: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload_2
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull +9 -> 153
    //   147: aload_1
    //   148: invokevirtual 199	java/io/ObjectInputStream:close	()V
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
    //   161: invokevirtual 202	java/io/File:delete	()Z
    //   164: pop
    //   165: aload_1
    //   166: astore_0
    //   167: ldc 68
    //   169: iconst_1
    //   170: ldc 204
    //   172: aload_2
    //   173: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_1
    //   177: ifnull +49 -> 226
    //   180: aload_1
    //   181: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -33 -> 153
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_0
    //   192: goto -39 -> 153
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_0
    //   198: aload_0
    //   199: ifnull +7 -> 206
    //   202: aload_0
    //   203: invokevirtual 199	java/io/ObjectInputStream:close	()V
    //   206: aload_1
    //   207: athrow
    //   208: astore_0
    //   209: aload_2
    //   210: astore_0
    //   211: goto -58 -> 153
    //   214: astore_0
    //   215: goto -9 -> 206
    //   218: astore_1
    //   219: goto -21 -> 198
    //   222: astore_2
    //   223: goto -65 -> 158
    //   226: aconst_null
    //   227: astore_0
    //   228: goto -75 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   95	86	1	localObjectInputStream	java.io.ObjectInputStream
    //   195	12	1	localObject1	Object
    //   218	1	1	localObject2	Object
    //   105	47	2	localQIMRedDotConfig	QIMRedDotConfig
    //   155	55	2	localException1	java.lang.Exception
    //   222	1	2	localException2	java.lang.Exception
    //   19	142	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   73	96	155	java/lang/Exception
    //   180	184	189	java/io/IOException
    //   73	96	195	finally
    //   147	151	208	java/io/IOException
    //   202	206	214	java/io/IOException
    //   98	106	218	finally
    //   108	114	218	finally
    //   116	141	218	finally
    //   160	165	218	finally
    //   167	176	218	finally
    //   98	106	222	java/lang/Exception
    //   108	114	222	java/lang/Exception
    //   116	141	222	java/lang/Exception
  }
  
  public static void saveRedDotConfig(QIMRedDotConfig paramQIMRedDotConfig, String paramString)
  {
    if ((paramQIMRedDotConfig == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saveRedDotConfig|config= " + paramQIMRedDotConfig);
    }
    ThreadManager.getFileThreadHandler().post(new QIMRedDotConfig.1(paramString, paramQIMRedDotConfig));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMRedDotConfig
 * JD-Core Version:    0.7.0.1
 */