package com.tencent.tmdownloader.internal.storage.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.tmdownloader.internal.storage.table.c;
import com.tencent.tmdownloader.internal.storage.table.e;

public class a
  extends com.tencent.tmassistant.common.a.d
{
  protected static volatile com.tencent.tmassistant.common.a.d a = null;
  private static final Class<?>[] b = { c.class, com.tencent.tmdownloader.internal.storage.table.d.class, com.tencent.tmdownloader.internal.storage.table.b.class, CacheTable.class, com.tencent.tmassistantsdk.internal.c.a.a.class, e.class, com.tencent.replacemonitor.replace.b.b.class };
  
  public a(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public static com.tencent.tmassistant.common.a.d c()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        Context localContext = GlobalUtil.getInstance().getContext();
        if (localContext != null) {
          a = new a(localContext, "tmassistant_sdk_v2.db", null, 8);
        }
      }
      return a;
    }
    finally {}
  }
  
  public int a()
  {
    return 8;
  }
  
  public Class<?>[] b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.a.a
 * JD-Core Version:    0.7.0.1
 */