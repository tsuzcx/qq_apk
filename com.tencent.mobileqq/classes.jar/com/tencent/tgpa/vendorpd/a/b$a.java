package com.tencent.tgpa.vendorpd.a;

import android.os.AsyncTask;
import com.tencent.tgpa.vendorpd.b.e;
import com.tencent.tgpa.vendorpd.b.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class b$a
  extends AsyncTask<String, Void, Void>
{
  private final String a;
  private final HashMap<String, String> b;
  private final b.c c;
  
  public b$a(String paramString, b.c paramc)
  {
    this.a = paramString;
    this.b = new HashMap();
    this.c = paramc;
  }
  
  public b$a(String paramString, HashMap<String, String> paramHashMap, b.c paramc)
  {
    this.a = paramString;
    this.b = paramHashMap;
    this.c = paramc;
  }
  
  protected Void a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.c.a();
      HashMap localHashMap = this.c.b();
      if (this.b != null) {
        localHashMap.putAll(this.b);
      }
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((String)localEntry.getValue() == null) {
          localHashMap.put(localEntry.getKey(), "");
        }
      }
      f.a("start to request server, url: %s, header: %s , form data: %s", new Object[] { this.a, paramVarArgs.toString(), localHashMap.toString() });
      paramVarArgs = e.a(this.a, localHashMap, paramVarArgs);
      this.c.a(paramVarArgs);
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      f.d("request data code run exception, ple check!");
    }
    catch (IOException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      f.b("http request exception, ple check! url: %s", new Object[] { this.a });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b.a
 * JD-Core Version:    0.7.0.1
 */