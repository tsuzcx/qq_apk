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
  private List<Predicate> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b;
  
  public Filter(JSONObject paramJSONObject)
  {
    int j = 0;
    this.jdField_a_of_type_Int = 0;
    this.b = new ArrayList();
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
              break label253;
            }
            this.jdField_a_of_type_JavaUtilList.add(new Predicate(localJSONObject));
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
      label253:
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
  
  public List<String> a()
  {
    return this.b;
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = this.jdField_a_of_type_JavaUtilList.isEmpty();
    boolean bool1 = false;
    if (!bool2)
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
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.Filter
 * JD-Core Version:    0.7.0.1
 */