package cooperation.qzone.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneResLoader;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneEmotionUtils
{
  public static final String EMO_GIRL = HardCodeUtil.a(((IQzoneResLoader)QRoute.api(IQzoneResLoader.class)).getStringId(4));
  public static final String EMO_MONEY = HardCodeUtil.a(((IQzoneResLoader)QRoute.api(IQzoneResLoader.class)).getStringId(5));
  public static final String EMO_PREFIX = "[em]";
  public static final String EMO_TAIL = "[/em]";
  public static final String SIGN_ICON_URL_END = ".gif";
  public static final String SIGN_ICON_URL_PREFIX = "https://qzonestyle.gtimg.cn/qzone/em/";
  public static final Pattern SMILEY_PATTERN = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
  public static final String TAG = "QzoneEmotionUtils";
  private static boolean bInit = false;
  private static Pattern friendRefPattern = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
  private static Pattern pattern;
  public static final Pattern patternSpecialEmo = Pattern.compile("\\[/美女\\]|\\[/钱\\]");
  private static Pattern qzoneEmoPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
  private static final String regSpecialEmo = "\\[/美女\\]|\\[/钱\\]";
  
  static
  {
    bInit = false;
    pattern = null;
  }
  
  public static String EmoCode2Text(String paramString)
  {
    Matcher localMatcher = SMILEY_PATTERN.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = getDescription(str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String emCodeToQQcode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QQSysFaceUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQSysFaceUtil.getFaceString(QQSysFaceUtil.getLocalIdFromEMCode(paramString));
    }
    if (QQEmojiUtil.getLocalIdFromEMCode(paramString) != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QQEmojiUtil.getEmojiUnicode(QQEmojiUtil.getLocalIdFromEMCode(paramString)));
      localStringBuilder.append("");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String emCodesToQQcodes(String paramString)
  {
    Matcher localMatcher = qzoneEmoPattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = emCodeToQQcode(str1);
      if (str2 != null) {
        paramString = paramString.replace(str1, str2);
      }
    }
    return paramString;
  }
  
  public static String emoToWechatEmo(String paramString)
  {
    Matcher localMatcher = qzoneEmoPattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      String str2 = getDescription(str1);
      if (!TextUtils.isEmpty(str2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(str2.substring(1));
        localStringBuilder.append("]");
        paramString = paramString.replace(str1, localStringBuilder.toString());
      }
    }
    return paramString;
  }
  
  public static String getDescription(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QQSysFaceUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.getLocalIdFromEMCode(paramString));
    }
    if (QQEmojiUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQEmojiUtil.getEmojiDescription(QQEmojiUtil.getLocalIdFromEMCode(paramString));
    }
    return null;
  }
  
  public static Drawable getDrawable(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QQSysFaceUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.getLocalIdFromEMCode(paramString));
    }
    if (QQEmojiUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQEmojiUtil.getEmojiDrawable(QQEmojiUtil.getLocalIdFromEMCode(paramString));
    }
    return null;
  }
  
  public static int getEmoCount(String paramString)
  {
    paramString = SMILEY_PATTERN.matcher(paramString);
    int i = 0;
    while (paramString.find()) {
      i += 1;
    }
    return i;
  }
  
  public static String getEmoUrlFromConfig(String paramString)
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  private static void init()
  {
    try
    {
      ArrayList localArrayList = QQSysFaceUtil.getOrderList();
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(QQSysFaceUtil.getFaceDescription(((Integer)localArrayList.get(0)).intValue()));
        ((StringBuilder)localObject2).append(")");
        localObject2 = new StringBuffer(((StringBuilder)localObject2).toString());
        int i = 1;
        while (i < localArrayList.size())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("|(");
          localStringBuilder.append(QQSysFaceUtil.getFaceDescription(((Integer)localArrayList.get(i)).intValue()));
          localStringBuilder.append(")");
          ((StringBuffer)localObject2).append(localStringBuilder.toString());
          i += 1;
        }
        pattern = Pattern.compile(((StringBuffer)localObject2).toString().replace("吃瓜", "chigua"));
      }
      bInit = true;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static void loadEmoDrawable() {}
  
  public static String replaceEmoCode(String paramString1, String paramString2)
  {
    Matcher localMatcher = SMILEY_PATTERN.matcher(paramString1);
    while (localMatcher.find()) {
      paramString1 = paramString1.replace(localMatcher.group(), paramString2);
    }
    return paramString1;
  }
  
  private static String replaceSlashCode(String paramString)
  {
    Matcher localMatcher = pattern.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null)
      {
        String str2 = QQSysFaceUtil.getEMCode(str1);
        if (str2 != null)
        {
          str1 = paramString.replace(str1, str2);
          if (str1 != null) {
            paramString = str1;
          }
        }
      }
    }
    return paramString;
  }
  
  public static String splash2Emo(String paramString)
  {
    if (!bInit) {
      init();
    }
    Object localObject = paramString;
    if (pattern != null)
    {
      if (paramString == null) {
        return paramString;
      }
      int i = 0;
      localObject = new StringBuilder(paramString.length());
      Matcher localMatcher = friendRefPattern.matcher(paramString);
      while (localMatcher.find())
      {
        if (localMatcher.start() >= i)
        {
          ((StringBuilder)localObject).append(replaceSlashCode(paramString.substring(i, localMatcher.start())));
          ((StringBuilder)localObject).append(paramString.substring(localMatcher.start(), localMatcher.end()));
        }
        i = localMatcher.end();
      }
      ((StringBuilder)localObject).append(replaceSlashCode(paramString.substring(i, paramString.length())));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneEmotionUtils
 * JD-Core Version:    0.7.0.1
 */