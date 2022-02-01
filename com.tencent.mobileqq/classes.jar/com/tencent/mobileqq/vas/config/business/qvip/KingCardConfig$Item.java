package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Arrays;

public class KingCardConfig$Item
{
  public final boolean a;
  private final String b;
  private final String c;
  private final String[] d;
  private final String[] e;
  private final String f;
  private final String g;
  
  public KingCardConfig$Item()
  {
    this.b = "";
    this.a = false;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  public KingCardConfig$Item(String paramString1, boolean paramBoolean, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.b = paramString1;
    this.a = paramBoolean;
    this.c = paramString2;
    this.d = paramArrayOfString1;
    this.e = paramArrayOfString2;
    if ("AIO".equals(paramString1))
    {
      this.f = "0X800A647";
      this.g = "0X800A648";
      return;
    }
    if ("group".equals(paramString1))
    {
      this.f = "0X800A649";
      this.g = "0X800A64A";
      return;
    }
    if ("download".equals(paramString1))
    {
      this.f = "0X800A64B";
      this.g = "0X800A64C";
      return;
    }
    this.f = null;
    this.g = null;
  }
  
  public SpannableString a(Context paramContext, CharSequence paramCharSequence)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramCharSequence);
    ((StringBuilder)localObject1).append(this.c);
    localObject1 = ((StringBuilder)localObject1).toString();
    paramCharSequence = new SpannableString((CharSequence)localObject1);
    int i = 0;
    for (;;)
    {
      Object localObject2 = this.d;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      String str = this.e[i];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str)))
      {
        int j = ((String)localObject1).indexOf(this.d[i]);
        paramCharSequence.setSpan(new KingCardConfig.Item.1(this, str, paramContext), j, ((String)localObject2).length() + j, 33);
      }
      i += 1;
    }
    paramContext = this.f;
    ReportController.b(null, "dc00898", "", "", paramContext, paramContext, 2, 0, "", "", "", "");
    return paramCharSequence;
  }
  
  public String a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = this.f;
      ReportController.b(null, "dc00898", "", "", (String)localObject, (String)localObject, 2, 0, "", "", "", "");
      return this.e[0];
    }
    return "";
  }
  
  public void b()
  {
    String str = this.g;
    ReportController.b(null, "dc00898", "", "", str, str, 2, 0, "", "", "", "");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Item{enable=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", keyWords=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append(", actionUrls=");
    localStringBuilder.append(Arrays.toString(this.e));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item
 * JD-Core Version:    0.7.0.1
 */