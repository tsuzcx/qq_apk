package com.tencent.open.agent.datamodel;

import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;

final class FriendGroup$1
  implements DbCacheData.DbCreator<FriendGroup>
{
  public FriendGroup a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new FriendGroup();
    ((FriendGroup)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public DbCacheData.Structure[] a()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("groupId", "INTEGER UNIQUE"), new DbCacheData.Structure("data", "BLOB") };
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.FriendGroup.1
 * JD-Core Version:    0.7.0.1
 */