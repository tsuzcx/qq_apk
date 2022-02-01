package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SuppressLint({"SimpleDateFormat"})
final class SQLiteConnection$Operation
{
  private static final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  long a;
  long b;
  String c;
  String d;
  ArrayList<Object> e;
  boolean f;
  Exception g;
  int h;
  int i;
  int j;
  
  private String a()
  {
    if (!this.f) {
      return "running";
    }
    if (this.g != null) {
      return "failed";
    }
    return "succeeded";
  }
  
  public void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(this.c);
    if (this.f)
    {
      paramStringBuilder.append(" took ");
      paramStringBuilder.append(this.b - this.a);
      paramStringBuilder.append("ms");
    }
    else
    {
      paramStringBuilder.append(" started ");
      paramStringBuilder.append(System.currentTimeMillis() - this.a);
      paramStringBuilder.append("ms ago");
    }
    paramStringBuilder.append(" - ");
    paramStringBuilder.append(a());
    if (this.d != null)
    {
      paramStringBuilder.append(", sql=\"");
      paramStringBuilder.append(SQLiteConnection.e(this.d));
      paramStringBuilder.append("\"");
    }
    if (this.j > 0)
    {
      paramStringBuilder.append(", tid=");
      paramStringBuilder.append(this.j);
    }
    if (paramBoolean)
    {
      localObject = this.e;
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        paramStringBuilder.append(", bindArgs=[");
        int n = this.e.size();
        int m = 0;
        while (m < n)
        {
          localObject = this.e.get(m);
          if (m != 0) {
            paramStringBuilder.append(", ");
          }
          if (localObject == null)
          {
            paramStringBuilder.append("null");
          }
          else if ((localObject instanceof byte[]))
          {
            paramStringBuilder.append("<byte[]>");
          }
          else if ((localObject instanceof String))
          {
            paramStringBuilder.append("\"");
            paramStringBuilder.append((String)localObject);
            paramStringBuilder.append("\"");
          }
          else
          {
            paramStringBuilder.append(localObject);
          }
          m += 1;
        }
        paramStringBuilder.append("]");
      }
    }
    Object localObject = this.g;
    if ((localObject != null) && (((Exception)localObject).getMessage() != null))
    {
      paramStringBuilder.append(", exception=\"");
      paramStringBuilder.append(this.g.getMessage());
      paramStringBuilder.append("\"");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteConnection.Operation
 * JD-Core Version:    0.7.0.1
 */