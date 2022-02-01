package com.tencent.qmsp.sdk.g.i;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qmsp.sdk.base.c;

public class a
{
  private Context a;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public String a(int paramInt, String paramString)
  {
    Object localObject2 = null;
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          paramString = null;
          break label80;
        }
        localStringBuilder = new StringBuilder();
        localObject1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localObject1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    else
    {
      paramString = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
    }
    paramString = Uri.parse(paramString);
    label80:
    Object localObject1 = this.a.getContentResolver().query(paramString, null, null, null, null);
    if (localObject1 == null)
    {
      c.b("return cursor is null,return");
      return null;
    }
    paramString = localObject2;
    if (((Cursor)localObject1).moveToNext()) {
      paramString = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("value"));
    }
    ((Cursor)localObject1).close();
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.i.a
 * JD-Core Version:    0.7.0.1
 */