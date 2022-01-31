package dov.com.qq.im.capture.banner;

import amva;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMCaptureBannerConfig
  implements Serializable
{
  public static final String ANIM_ENABLE = "enable";
  public static final String ANIM_LIFETIME = "lifetime";
  public static final String ANIM_VERSION = "version";
  public static final String BANNER_ANIM = "anim";
  public static final String BANNER_BEGIN = "begin_time";
  public static final String BANNER_ENABLE = "entry_enable";
  public static final String BANNER_END = "end_time";
  public static final String BANNER_ID = "id";
  public static final String BANNER_IMG = "img_url";
  public static final String BANNER_IMG_MD5 = "img_md5";
  public static final String BANNER_JUMP_URL = "jmp_url";
  public static final String BANNER_LIST = "banner_list";
  public static final String BANNER_RED_DOT = "red_point";
  public static final String BANNER_VERSION = "version";
  public static final String BANNER_WORDING = "wording";
  public static final String CACHE_BANNER_CONFIG_NAME = "banner_config";
  public static final long DURATION_DEFAULT = 43200000L;
  public static final String ENABLE = "enable";
  public static final String SHOWTIME = "lifetime";
  public static final String TAG = "QIMCaptureBannerConfig";
  public static final String TIPS_LIST = "new_user_tips";
  public static final String TIPS_ORDER = "order";
  public static final String TIPS_WORDING = "wording";
  private static final long serialVersionUID = 1L;
  public QIMCaptureBannerConfig.AnimItem mAnimItem;
  public boolean mBannerEnable;
  public HashMap mBannerList = new HashMap();
  public long mBeginTime;
  public long mEndTime;
  public String mJumpUrl;
  public Map mNewUserTipsItems = new LinkedHashMap();
  public QIMCaptureBannerConfig.RedDotItem mRedDotItem;
  public transient boolean update = false;
  
  /* Error */
  public static QIMCaptureBannerConfig getBannerConfigFromFile(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_0
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 117	java/io/File
    //   16: dup
    //   17: aload_1
    //   18: new 119	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   25: aload_0
    //   26: invokevirtual 126	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   29: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 53
    //   34: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore_3
    //   44: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +43 -> 90
    //   50: ldc 62
    //   52: iconst_2
    //   53: new 119	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   60: ldc 144
    //   62: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 147	java/io/File:getPath	()Ljava/lang/String;
    //   69: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 149
    //   74: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_3
    //   78: invokevirtual 152	java/io/File:exists	()Z
    //   81: invokevirtual 155	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aload_3
    //   91: invokevirtual 152	java/io/File:exists	()Z
    //   94: ifeq -83 -> 11
    //   97: new 161	java/io/ObjectInputStream
    //   100: dup
    //   101: new 163	java/io/BufferedInputStream
    //   104: dup
    //   105: new 165	java/io/FileInputStream
    //   108: dup
    //   109: aload_3
    //   110: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   113: invokespecial 171	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   116: invokespecial 172	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   119: astore_1
    //   120: aload_1
    //   121: astore_0
    //   122: aload_1
    //   123: invokevirtual 176	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   126: checkcast 2	dov/com/qq/im/capture/banner/QIMCaptureBannerConfig
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +30 -> 165
    //   138: aload_1
    //   139: astore_0
    //   140: ldc 62
    //   142: iconst_2
    //   143: new 119	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   150: ldc 178
    //   152: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_2
    //   156: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_2
    //   166: astore_0
    //   167: aload_1
    //   168: ifnull +9 -> 177
    //   171: aload_1
    //   172: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   175: aload_2
    //   176: astore_0
    //   177: aload_0
    //   178: areturn
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_1
    //   183: astore_0
    //   184: aload_3
    //   185: invokevirtual 187	java/io/File:delete	()Z
    //   188: pop
    //   189: aload_1
    //   190: astore_0
    //   191: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +33 -> 227
    //   197: aload_1
    //   198: astore_0
    //   199: ldc 62
    //   201: iconst_2
    //   202: new 119	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   209: ldc 189
    //   211: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_2
    //   215: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_1
    //   228: ifnull +49 -> 277
    //   231: aload_1
    //   232: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   235: aconst_null
    //   236: astore_0
    //   237: goto -60 -> 177
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_0
    //   243: goto -66 -> 177
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_0
    //   249: aload_0
    //   250: ifnull +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 184	java/io/ObjectInputStream:close	()V
    //   257: aload_1
    //   258: athrow
    //   259: astore_0
    //   260: aload_2
    //   261: astore_0
    //   262: goto -85 -> 177
    //   265: astore_0
    //   266: goto -9 -> 257
    //   269: astore_1
    //   270: goto -21 -> 249
    //   273: astore_2
    //   274: goto -92 -> 182
    //   277: aconst_null
    //   278: astore_0
    //   279: goto -102 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramQQAppInterface	QQAppInterface
    //   0	282	1	paramString	String
    //   129	47	2	localQIMCaptureBannerConfig	QIMCaptureBannerConfig
    //   179	82	2	localException1	java.lang.Exception
    //   273	1	2	localException2	java.lang.Exception
    //   43	142	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   97	120	179	java/lang/Exception
    //   231	235	240	java/io/IOException
    //   97	120	246	finally
    //   171	175	259	java/io/IOException
    //   253	257	265	java/io/IOException
    //   122	130	269	finally
    //   132	138	269	finally
    //   140	165	269	finally
    //   184	189	269	finally
    //   191	197	269	finally
    //   199	227	269	finally
    //   122	130	273	java/lang/Exception
    //   132	138	273	java/lang/Exception
    //   140	165	273	java/lang/Exception
  }
  
  public static void getBannerListFromJsonString(String paramString, QIMCaptureBannerConfig paramQIMCaptureBannerConfig)
  {
    if (paramQIMCaptureBannerConfig == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      boolean bool;
      int i;
      Object localObject3;
      int j;
      Object localObject1;
      String str1;
      String str2;
      String str3;
      long l1;
      long l2;
      try
      {
        localObject2 = new JSONObject(paramString);
        if (!((JSONObject)localObject2).optString("entry_enable", "0").equals("1")) {
          break label801;
        }
        bool = true;
        paramQIMCaptureBannerConfig.mBannerEnable = bool;
        paramQIMCaptureBannerConfig.mBeginTime = ArMapUtil.c(((JSONObject)localObject2).optString("begin_time"));
        paramQIMCaptureBannerConfig.mEndTime = ArMapUtil.c(((JSONObject)localObject2).optString("end_time"));
        paramQIMCaptureBannerConfig.mJumpUrl = ((JSONObject)localObject2).optString("jmp_url");
        paramString = ((JSONObject)localObject2).optJSONObject("red_point");
        if (paramString == null)
        {
          paramQIMCaptureBannerConfig.mRedDotItem = null;
          paramString = ((JSONObject)localObject2).optJSONObject("anim");
          if (paramString != null) {
            break label470;
          }
          paramQIMCaptureBannerConfig.mAnimItem = null;
          paramString = ((JSONObject)localObject2).optJSONArray("banner_list");
          if ((paramString == null) || (paramString.length() <= 0)) {
            break label786;
          }
          i = 0;
          if (i >= paramString.length()) {
            break;
          }
          localObject3 = paramString.getJSONObject(i);
          j = ((JSONObject)localObject3).optInt("version", -1);
          localObject1 = ((JSONObject)localObject3).optString("id");
          localObject2 = ((JSONObject)localObject3).optString("img_url");
          str1 = ((JSONObject)localObject3).optString("wording");
          str2 = ((JSONObject)localObject3).optString("img_md5");
          str3 = ((JSONObject)localObject3).optString("jmp_url");
          l1 = ArMapUtil.c(((JSONObject)localObject3).optString("begin_time"));
          l2 = ArMapUtil.c(((JSONObject)localObject3).optString("end_time"));
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(str3)) || (l1 < 0L) || (l2 < 0L)) {
            break label794;
          }
          if (l1 < l2) {
            break label619;
          }
          break label794;
        }
        i = paramString.optInt("version", -1);
        bool = paramString.optString("enable", "0").equals("1");
        if (bool)
        {
          bool = true;
          l1 = 43200000L;
        }
      }
      catch (JSONException paramString) {}
      try
      {
        l2 = Long.valueOf(paramString.optString("lifetime")).longValue();
        l1 = l2 * 1000L;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      if (paramQIMCaptureBannerConfig.mRedDotItem == null)
      {
        paramQIMCaptureBannerConfig.mRedDotItem = new QIMCaptureBannerConfig.RedDotItem();
        paramQIMCaptureBannerConfig.mRedDotItem.version = i;
        paramQIMCaptureBannerConfig.mRedDotItem.needShow = bool;
        paramQIMCaptureBannerConfig.mRedDotItem.showTime = l1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QIMCaptureBannerConfig", 2, QLog.getStackTraceString(paramString));
        return;
        bool = false;
        continue;
      }
      if (i != paramQIMCaptureBannerConfig.mRedDotItem.version)
      {
        paramQIMCaptureBannerConfig.mRedDotItem.version = i;
        paramQIMCaptureBannerConfig.mRedDotItem.needShow = bool;
        paramQIMCaptureBannerConfig.mRedDotItem.showTime = l1;
        paramQIMCaptureBannerConfig.mRedDotItem.hasShow = false;
        paramQIMCaptureBannerConfig.mRedDotItem.startShow = 0L;
        continue;
        label470:
        i = paramString.optInt("version", -1);
        bool = paramString.optString("enable", "0").equals("1");
        localObject1 = paramString.optString("lifetime", "0");
        paramString = Long.valueOf(0L);
        try
        {
          localObject1 = Long.valueOf((String)localObject1);
          paramString = (String)localObject1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localNumberFormatException.printStackTrace();
          }
        }
        if (paramQIMCaptureBannerConfig.mAnimItem == null)
        {
          paramQIMCaptureBannerConfig.mAnimItem = new QIMCaptureBannerConfig.AnimItem();
          paramQIMCaptureBannerConfig.mAnimItem.mVersion = i;
          paramQIMCaptureBannerConfig.mAnimItem.mEnable = bool;
          paramQIMCaptureBannerConfig.mAnimItem.mLifetime = paramString.longValue();
        }
        else if (i != paramQIMCaptureBannerConfig.mAnimItem.mVersion)
        {
          paramQIMCaptureBannerConfig.mAnimItem.mVersion = i;
          paramQIMCaptureBannerConfig.mAnimItem.mEnable = bool;
          paramQIMCaptureBannerConfig.mAnimItem.mLifetime = paramString.longValue();
          continue;
          label619:
          localObject3 = (QIMCaptureBannerConfig.BannerItem)paramQIMCaptureBannerConfig.mBannerList.get(localNumberFormatException);
          if (localObject3 != null)
          {
            if (((QIMCaptureBannerConfig.BannerItem)localObject3).version != j)
            {
              ((QIMCaptureBannerConfig.BannerItem)localObject3).version = j;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).mWording = str1;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).imgUrl = ((String)localObject2);
              ((QIMCaptureBannerConfig.BannerItem)localObject3).imgMd5 = str2;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).jumpUrl = str3;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).mBeginTime = l1;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).mEndTime = l2;
              ((QIMCaptureBannerConfig.BannerItem)localObject3).hasShow = false;
            }
          }
          else
          {
            localObject3 = new QIMCaptureBannerConfig.BannerItem();
            ((QIMCaptureBannerConfig.BannerItem)localObject3).mBannerId = localNumberFormatException;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).version = j;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).mWording = str1;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).imgUrl = ((String)localObject2);
            ((QIMCaptureBannerConfig.BannerItem)localObject3).imgMd5 = str2;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).jumpUrl = str3;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).mBeginTime = l1;
            ((QIMCaptureBannerConfig.BannerItem)localObject3).mEndTime = l2;
            paramQIMCaptureBannerConfig.mBannerList.put(((QIMCaptureBannerConfig.BannerItem)localObject3).mBannerId, localObject3);
            break label794;
            label786:
            paramQIMCaptureBannerConfig.mBannerList.clear();
            return;
          }
          label794:
          i += 1;
          continue;
          label801:
          bool = false;
        }
      }
    }
  }
  
  public static void saveBannerConfig(QQAppInterface paramQQAppInterface, QIMCaptureBannerConfig paramQIMCaptureBannerConfig, String paramString)
  {
    if ((paramQIMCaptureBannerConfig == null) || (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMCaptureBannerConfig", 2, "saveBannerConfig|config= " + paramQIMCaptureBannerConfig);
    }
    ThreadManager.getFileThreadHandler().post(new amva(paramString, paramQQAppInterface, paramQIMCaptureBannerConfig));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMCaptureBannerConfig{");
    localStringBuilder.append("mBannerEnable=").append(this.mBannerEnable);
    localStringBuilder.append(", mBeginTime=").append(this.mBeginTime);
    localStringBuilder.append(", mEndTime=").append(this.mEndTime);
    localStringBuilder.append(", mRedDotItem=").append(this.mRedDotItem);
    localStringBuilder.append(", mBannerList=").append(this.mBannerList);
    localStringBuilder.append(", update=").append(this.update);
    localStringBuilder.append(", mJumpUrl='").append(this.mJumpUrl).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerConfig
 * JD-Core Version:    0.7.0.1
 */