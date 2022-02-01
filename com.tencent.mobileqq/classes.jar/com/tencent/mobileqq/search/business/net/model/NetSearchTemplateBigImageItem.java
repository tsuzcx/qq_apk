package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateBigImageItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public int b;
  public String c;
  public float d;
  public float e;
  public String f;
  public String t;
  public CharSequence u;
  public CharSequence v;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(NetSearchTemplateBigImageItem.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public NetSearchTemplateBigImageItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateBigImageItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 5) {
      i = 1;
    }
    return i;
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optInt("bannerImageType");
      this.c = paramString.optString("bannerImageUrl");
      this.d = ((float)paramString.optDouble("bannerImageWidth"));
      this.e = ((float)paramString.optDouble("bannerImageHeight"));
      this.f = paramString.optString("topLeftTagText");
      this.t = paramString.optString("topLeftTagColor");
      this.u = paramString.optString("firstLineText");
      this.v = paramString.optString("secondLineText");
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(a, 2, QLog.getStackTraceString(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBigImageItem
 * JD-Core Version:    0.7.0.1
 */