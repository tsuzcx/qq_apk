package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PtsNativeFeedsAladdinKeyConfigHandler
  extends SimpleConfigHandler
{
  private static final Set<String> a = ;
  
  public static Set<String> a()
  {
    String str = RIJBiuAndCommentAladdinUtils.i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getNativeFeedsAlladinKey | operationBarAladdinKey : ");
    localStringBuilder.append(str);
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 2, localStringBuilder.toString());
    if ((a != null) && (!TextUtils.isEmpty(str))) {
      a.add(str);
    }
    return a;
  }
  
  private static Set<String> b()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = (String)RIJSPUtils.b("native_feeds_aladdin_keys", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localHashSet;
    }
    localObject = ((String)localObject).split("\\|");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(localObject[i]);
      i += 1;
    }
    return localHashSet;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 1, ((StringBuilder)localObject).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      if ("native_article_aladdin_keys".equalsIgnoreCase(str1))
      {
        String str2 = (String)paramString.get(str1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onReceiveConfig] key=");
        localStringBuilder.append(str1);
        localStringBuilder.append(", value=");
        localStringBuilder.append(str2);
        QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 2, localStringBuilder.toString());
        RIJSPUtils.a("native_feeds_aladdin_keys", str2);
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("PtsNativeFeedsAladdinKeyConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.PtsNativeFeedsAladdinKeyConfigHandler
 * JD-Core Version:    0.7.0.1
 */