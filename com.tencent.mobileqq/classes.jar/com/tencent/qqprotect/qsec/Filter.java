package com.tencent.qqprotect.qsec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Filter
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3600L;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private List b = new ArrayList();
  
  public Filter(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("type");
        long l = paramJSONObject.getLong("interval");
        if ((l > 0L) && (l < 604800L)) {
          this.jdField_a_of_type_Long = l;
        }
        Object localObject = paramJSONObject.getJSONArray("filter");
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            if (localJSONObject == null) {
              break label248;
            }
            this.jdField_a_of_type_JavaUtilList.add(new Predicate(localJSONObject));
            break label248;
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
              this.jdField_a_of_type_Int = i;
              paramJSONObject = paramJSONObject.getJSONArray("fields");
              if (paramJSONObject != null)
              {
                i = j;
                if (i < paramJSONObject.length())
                {
                  localObject = paramJSONObject.getString(i);
                  if ((localObject != null) && (!((String)localObject).isEmpty())) {
                    this.b.add(localObject);
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
      label248:
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public List a()
  {
    return this.b;
  }
  
  public boolean a(Object paramObject)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
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
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.Filter
 * JD-Core Version:    0.7.0.1
 */