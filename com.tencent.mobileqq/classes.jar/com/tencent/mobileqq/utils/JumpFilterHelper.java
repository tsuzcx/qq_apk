package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class JumpFilterHelper
  extends BaseConfigFileParser
{
  private static volatile JumpFilterHelper f;
  private SharedPreferences c = BaseApplication.getContext().getSharedPreferences("qq_safe_jump_whitelist", 0);
  private List<Pair<String, String>> d = new ArrayList();
  private boolean e = false;
  
  static
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject).getFilesDir().getAbsoluteFile());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("jumpConfig/");
    a = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("qq_safe_jump_whitelist.xml");
    b = ((StringBuilder)localObject).toString();
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportIllegalJump pkg=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(";cmp=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("JumpFilterHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put(paramString1, paramString2);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "JumpIllegal", true, 0L, 0L, (HashMap)localObject, null);
  }
  
  public static JumpFilterHelper b()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new JumpFilterHelper();
        }
      }
      finally {}
    }
    return f;
  }
  
  protected int a()
  {
    return 2132082703;
  }
  
  protected Object a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    for (int i = paramXmlPullParser.getEventType(); i != 1; i = paramXmlPullParser.next()) {
      if ((i == 2) && (paramXmlPullParser.getName().equalsIgnoreCase("Item")))
      {
        String str1 = paramXmlPullParser.getAttributeValue(null, "pkg");
        String str2 = paramXmlPullParser.getAttributeValue(null, "cmp");
        if ((str1 != null) && (str2 != null)) {
          localArrayList.add(new Pair(str1, str2));
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doParseRules pkg=");
          localStringBuilder.append(str1);
          localStringBuilder.append(";cmp=");
          localStringBuilder.append(str2);
          QLog.d("JumpFilterHelper", 2, localStringBuilder.toString());
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append("doParseRules :  cost time:");
      paramXmlPullParser.append(l2 - l1);
      paramXmlPullParser.append("ms;size=");
      paramXmlPullParser.append(localArrayList.size());
      QLog.d("JumpFilterHelper", 2, paramXmlPullParser.toString());
    }
    return localArrayList;
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("updateConfigVersion version=");
      paramBaseQQAppInterface.append(paramLong);
      QLog.d("JumpFilterHelper", 2, paramBaseQQAppInterface.toString());
    }
    this.c.edit().putLong("key_jump_whitelist_version", paramLong).commit();
  }
  
  protected void a(Object paramObject)
  {
    this.d = ((List)paramObject);
    this.e = true;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    Pair localPair = new Pair(paramString1, paramString2);
    if (!this.e) {
      synchronized (f)
      {
        if (!this.e) {
          a(paramContext);
        }
      }
    }
    if (!this.d.contains(localPair))
    {
      a(paramString1, paramString2);
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isIllegalJump pkg=");
      paramContext.append(paramString1);
      paramContext.append(";cmp=");
      paramContext.append(paramString2);
      QLog.d("JumpFilterHelper", 2, paramContext.toString());
    }
    return false;
  }
  
  public long c()
  {
    long l = this.c.getLong("key_jump_whitelist_version", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigVersion version=");
      localStringBuilder.append(l);
      QLog.d("JumpFilterHelper", 2, localStringBuilder.toString());
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpFilterHelper
 * JD-Core Version:    0.7.0.1
 */