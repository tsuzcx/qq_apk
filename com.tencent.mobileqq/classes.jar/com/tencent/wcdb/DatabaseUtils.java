package com.tencent.wcdb;

import android.content.OperationApplicationException;
import android.os.Parcel;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.text.Collator;

public final class DatabaseUtils
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static Collator b = null;
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1 - paramInt2 / 3, 0);
  }
  
  public static int a(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Byte))) {
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public static int a(String paramString)
  {
    paramString = paramString.trim();
    if (paramString.length() < 3) {
      return 99;
    }
    switch (b(paramString))
    {
    default: 
      return 99;
    case 5526593: 
      return 3;
    case 5001042: 
      return 6;
    case 4998483: 
      return 1;
    case 4670786: 
      return 4;
    case 4543043: 
    case 5198404: 
    case 5524545: 
      return 8;
    case 4477013: 
    case 4998468: 
    case 5260626: 
    case 5459529: 
      return 2;
    case 4476485: 
    case 5066563: 
      return 5;
    case 4280912: 
      return 7;
    }
    return 9;
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final void a(Parcel paramParcel)
  {
    int i = b(paramParcel);
    if (i == 0) {
      return;
    }
    a(paramParcel, paramParcel.readString(), i);
  }
  
  public static final void a(Parcel paramParcel, Exception paramException)
  {
    if ((paramException instanceof FileNotFoundException)) {}
    int j;
    for (int i = 1;; i = 11)
    {
      j = 0;
      break;
      if ((paramException instanceof IllegalArgumentException)) {
        i = 2;
      }
      for (;;)
      {
        j = 1;
        break label142;
        if ((paramException instanceof UnsupportedOperationException))
        {
          i = 3;
        }
        else if ((paramException instanceof SQLiteAbortException))
        {
          i = 4;
        }
        else if ((paramException instanceof SQLiteConstraintException))
        {
          i = 5;
        }
        else if ((paramException instanceof SQLiteDatabaseCorruptException))
        {
          i = 6;
        }
        else if ((paramException instanceof SQLiteFullException))
        {
          i = 7;
        }
        else if ((paramException instanceof SQLiteDiskIOException))
        {
          i = 8;
        }
        else if ((paramException instanceof SQLiteException))
        {
          i = 9;
        }
        else
        {
          if (!(paramException instanceof OperationApplicationException)) {
            break;
          }
          i = 10;
        }
      }
      if (!(paramException instanceof OperationCanceledException)) {
        break label175;
      }
    }
    label142:
    paramParcel.writeInt(i);
    paramParcel.writeString(paramException.getMessage());
    if (j != 0) {
      Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
    }
    return;
    label175:
    paramParcel.writeException(paramException);
    Log.a("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
  }
  
  private static final void a(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 11: 
      throw new OperationCanceledException(paramString);
    case 9: 
      throw new SQLiteException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void a(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= paramCursor.getCount()) {
        return;
      }
      int j = paramCursor.getPosition();
      int k = paramCursor.getColumnCount();
      paramCursorWindow.b();
      paramCursorWindow.a(paramInt);
      paramCursorWindow.b(k);
      if (paramCursor.moveToPosition(paramInt)) {
        do
        {
          if (!paramCursorWindow.e()) {
            break;
          }
          int i = 0;
          while (i < k)
          {
            int m = paramCursor.getType(i);
            boolean bool;
            if (m != 0)
            {
              if (m != 1)
              {
                if (m != 2)
                {
                  Object localObject;
                  if (m != 4)
                  {
                    localObject = paramCursor.getString(i);
                    if (localObject != null) {
                      bool = paramCursorWindow.a((String)localObject, paramInt, i);
                    } else {
                      bool = paramCursorWindow.i(paramInt, i);
                    }
                  }
                  else
                  {
                    localObject = paramCursor.getBlob(i);
                    if (localObject != null) {
                      bool = paramCursorWindow.a((byte[])localObject, paramInt, i);
                    } else {
                      bool = paramCursorWindow.i(paramInt, i);
                    }
                  }
                }
                else
                {
                  bool = paramCursorWindow.a(paramCursor.getDouble(i), paramInt, i);
                }
              }
              else {
                bool = paramCursorWindow.a(paramCursor.getLong(i), paramInt, i);
              }
            }
            else {
              bool = paramCursorWindow.i(paramInt, i);
            }
            if (!bool)
            {
              paramCursorWindow.f();
              break;
            }
            i += 1;
          }
          paramInt += 1;
        } while (paramCursor.moveToNext());
      }
      paramCursor.moveToPosition(j);
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static final int b(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == -128)
    {
      if (paramParcel.readInt() == 0) {
        Log.a("WCDB.DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
      }
      return 0;
    }
    return i;
  }
  
  private static int b(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      int m = paramString.charAt(i);
      int k;
      if ((m >= 97) && (m <= 122))
      {
        k = m - 97 + 65;
      }
      else
      {
        k = m;
        if (m >= 128) {
          return 0;
        }
      }
      j |= (k & 0x7F) << i * 8;
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.DatabaseUtils
 * JD-Core Version:    0.7.0.1
 */