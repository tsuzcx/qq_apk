package com.tencent.qqprotect.qsec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Filter
{
  private long a = 3600L;
  private String b = "";
  private List<Predicate> c = new ArrayList();
  private int d;
  private List<String> e;
  
  public Filter(JSONObject paramJSONObject)
  {
    int j = 0;
    this.d = 0;
    this.e = new ArrayList();
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        this.b = paramJSONObject.getString("type");
        long l = paramJSONObject.getLong("interval");
        if ((l > 0L) && (l < 604800L)) {
          this.a = l;
        }
        Object localObject = paramJSONObject.getJSONArray("filter");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            if (localJSONObject == null) {
              break label253;
            }
            this.c.add(new Predicate(localJSONObject));
            break label253;
          }
        }
        if (paramJSONObject.has("rpt"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("rpt");
          if (paramJSONObject != null)
          {
            i = paramJSONObject.getInt("id");
            if (i > 100000)
            {
              this.d = i;
              paramJSONObject = paramJSONObject.getJSONArray("fields");
              if (paramJSONObject != null)
              {
                i = j;
                if (i < paramJSONObject.length())
                {
                  localObject = paramJSONObject.getString(i);
                  if ((localObject != null) && (!((String)localObject).isEmpty())) {
                    this.e.add(localObject);
                  }
                  i += 1;
                  continue;
                }
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      label253:
      i += 1;
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = this.c.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        Predicate localPredicate = (Predicate)localIterator.next();
        if (!localPredicate.a()) {
          return false;
        }
        if (!localPredicate.a(paramObject)) {
          return false;
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public long b()
  {
    return this.a;
  }
  
  public List<String> c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.Filter
 * JD-Core Version:    0.7.0.1
 */