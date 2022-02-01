package com.tencent.qqprotect.qsec;

import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class Predicate
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "inc";
  
  public Predicate(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        this.a = paramJSONObject.getString("name");
        this.b = paramJSONObject.getString("op");
        this.c = paramJSONObject.getString("val");
        this.d = paramJSONObject.getString("act");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    return (!this.a.isEmpty()) && (!this.b.isEmpty()) && (!this.c.isEmpty());
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        paramObject = FieldHelper.b(paramObject, this.a);
        boolean bool2 = bool3;
        if (paramObject != null)
        {
          Class localClass1 = paramObject.getClass();
          Class localClass2 = Integer.TYPE;
          if ((localClass1 != localClass2) && (paramObject.getClass() != Integer.class) && (paramObject.getClass() != Long.TYPE) && (paramObject.getClass() != Long.class))
          {
            if ((paramObject.getClass() != String.class) && (paramObject.getClass() != CharSequence.class)) {
              break label660;
            }
            paramObject = (String)paramObject;
            if (this.b.equalsIgnoreCase("less"))
            {
              if (paramObject.compareToIgnoreCase(this.c) >= 0) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("more"))
            {
              if (paramObject.compareToIgnoreCase(this.c) <= 0) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("is"))
            {
              bool1 = paramObject.equalsIgnoreCase(this.c);
            }
            else if (this.b.equalsIgnoreCase("not"))
            {
              bool1 = paramObject.equalsIgnoreCase(this.c) ^ true;
            }
            else if (this.b.equalsIgnoreCase("has"))
            {
              bool1 = paramObject.contains(this.c);
            }
            else if (this.b.equalsIgnoreCase("begins"))
            {
              bool1 = paramObject.startsWith(this.c);
            }
            else if (this.b.equalsIgnoreCase("ends"))
            {
              bool1 = paramObject.endsWith(this.c);
            }
            else
            {
              if (!this.b.equalsIgnoreCase("rem")) {
                break label660;
              }
              bool1 = Pattern.matches(this.c, paramObject);
            }
          }
          else
          {
            paramObject = (Integer)paramObject;
            if (this.b.equalsIgnoreCase("less"))
            {
              if (paramObject.intValue() >= Integer.parseInt(this.c)) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("more"))
            {
              if (paramObject.intValue() <= Integer.parseInt(this.c)) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("is"))
            {
              if (paramObject.intValue() != Integer.parseInt(this.c)) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("not"))
            {
              if (paramObject.intValue() == Integer.parseInt(this.c)) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("and"))
            {
              if ((paramObject.intValue() & Integer.parseInt(this.c)) == 0) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("or"))
            {
              if ((paramObject.intValue() | Integer.parseInt(this.c)) == 0) {
                break label660;
              }
              break label655;
            }
            if (this.b.equalsIgnoreCase("xor"))
            {
              if ((paramObject.intValue() ^ Integer.parseInt(this.c)) == 0) {
                break label660;
              }
              break label655;
            }
            bool1 = this.b.equalsIgnoreCase("begins");
            if (bool1)
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).startsWith(this.c);
            }
            else if (this.b.equalsIgnoreCase("ends"))
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).endsWith(this.c);
            }
            else
            {
              if (!this.b.equalsIgnoreCase("rem")) {
                break label660;
              }
              bool1 = Pattern.matches(this.c, String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }));
            }
          }
          bool2 = this.d.equalsIgnoreCase("exc");
          if (bool2)
          {
            bool2 = bool3;
            if (!bool1) {
              return true;
            }
          }
          else
          {
            bool2 = bool1;
          }
        }
        return bool2;
      }
      catch (IllegalArgumentException|Exception paramObject)
      {
        return false;
      }
      label655:
      boolean bool1 = true;
      continue;
      label660:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.Predicate
 * JD-Core Version:    0.7.0.1
 */