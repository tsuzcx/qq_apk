package com.tencent.mobileqq.qfix.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class e
{
  static final String a = "AndroidManifest.xml";
  static final String b = "resources.zip";
  static final String c = "resources.arsc";
  static final String d = "resources.apk";
  static final String e = "add:";
  static final String f = "modify:";
  static final String g = "large modify:";
  static final int h = 16384;
  String i;
  String j;
  String k;
  Set<String> l = new HashSet();
  Set<String> m = new HashSet();
  Set<String> n = new HashSet();
  Map<String, e.a> o = new HashMap();
  
  @NonNull
  static e a(String paramString)
  {
    e locale = new e();
    paramString = paramString.split("\n");
    int i2;
    for (int i1 = 0; i1 < paramString.length; i1 = i2 + 1)
    {
      Object localObject1 = paramString[i1];
      i2 = i1;
      if (localObject1 != null) {
        if (((String)localObject1).length() <= 0)
        {
          i2 = i1;
        }
        else if (((String)localObject1).startsWith("resources.zip"))
        {
          localObject1 = ((String)localObject1).split(",", 4);
          locale.i = localObject1[1];
          locale.j = localObject1[2];
          locale.k = localObject1[3];
          i2 = i1;
        }
        else
        {
          int i3;
          if (((String)localObject1).startsWith("add:"))
          {
            i3 = Integer.parseInt(localObject1.split(":", 2)[1]);
            for (;;)
            {
              i2 = i1;
              if (i3 <= 0) {
                break;
              }
              localObject1 = locale.l;
              i1 += 1;
              ((Set)localObject1).add(paramString[i1]);
              i3 -= 1;
            }
          }
          if (((String)localObject1).startsWith("modify:"))
          {
            i3 = Integer.parseInt(localObject1.split(":", 2)[1]);
            for (;;)
            {
              i2 = i1;
              if (i3 <= 0) {
                break;
              }
              localObject1 = locale.m;
              i1 += 1;
              ((Set)localObject1).add(paramString[i1]);
              i3 -= 1;
            }
          }
          i2 = i1;
          if (((String)localObject1).startsWith("large modify:"))
          {
            i3 = Integer.parseInt(localObject1.split(":", 2)[1]);
            for (;;)
            {
              i2 = i1;
              if (i3 <= 0) {
                break;
              }
              i1 += 1;
              localObject1 = paramString[i1].split(",", 3);
              Object localObject2 = localObject1[0];
              e.a locala = new e.a();
              locala.a = localObject1[1];
              locala.b = Long.parseLong(localObject1[2]);
              locale.n.add(localObject2);
              locale.o.put(localObject2, locala);
              i3 -= 1;
            }
          }
        }
      }
    }
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.b.e
 * JD-Core Version:    0.7.0.1
 */