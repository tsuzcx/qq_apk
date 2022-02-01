package oicq.wlogin_sdk.report;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public ArrayList<a.a> a = new ArrayList(10);
  public ArrayList<a.a> b = new ArrayList(10);
  
  public static a a()
  {
    return a.b.a;
  }
  
  public String a(Context paramContext, ArrayList<a.a> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramContext = util.get_cost_time(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      localStringBuilder.append(paramContext);
    }
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext())
    {
      paramArrayList = (a.a)paramContext.next();
      localStringBuilder.append(paramArrayList.b);
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayList.a);
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayList.c);
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayList.d);
      localStringBuilder.append("|");
      localStringBuilder.append(paramArrayList.e);
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    a.a locala = new a.a();
    locala.b = System.currentTimeMillis();
    locala.a = paramInt;
    locala.c = paramLong1;
    locala.d = paramLong2;
    locala.e = paramLong3;
    this.a.add(locala);
  }
  
  public void a(String paramString)
  {
    a.a locala = new a.a();
    locala.b = System.currentTimeMillis();
    locala.f = paramString;
    this.b.add(locala);
  }
  
  public boolean a(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveCost ");
    ((StringBuilder)localObject).append(this.a.size());
    util.LOGI(((StringBuilder)localObject).toString(), "");
    if (this.a.size() > 0)
    {
      localObject = new ArrayList(this.a.size());
      ((ArrayList)localObject).addAll(this.a);
      this.a.clear();
      util.save_cost_time(paramContext, a(paramContext, (ArrayList)localObject));
      if (this.b.size() > 0)
      {
        localObject = new ArrayList(this.b.size());
        ((ArrayList)localObject).addAll(this.b);
        this.b.clear();
        util.save_cost_trace(paramContext, b(paramContext, (ArrayList)localObject));
      }
      return true;
    }
    return false;
  }
  
  public String b(Context paramContext, ArrayList<a.a> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramContext = util.get_cost_trace(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      localStringBuilder.append(paramContext);
    }
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext())
    {
      paramArrayList = (a.a)paramContext.next();
      localStringBuilder.append(paramArrayList.b);
      localStringBuilder.append(",");
      localStringBuilder.append(paramArrayList.f);
      localStringBuilder.append("|");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.report.a
 * JD-Core Version:    0.7.0.1
 */