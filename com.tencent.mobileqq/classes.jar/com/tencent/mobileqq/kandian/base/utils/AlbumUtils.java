package com.tencent.mobileqq.kandian.base.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public final class AlbumUtils
{
  @NotNull
  public static final ArrayList<AlbumUtils.LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("date_modified DESC limit ");
    ((StringBuilder)localObject3).append(paramInt2);
    ((StringBuilder)localObject3).append(" offset ");
    ((StringBuilder)localObject3).append(paramInt1);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "duration", "resolution", "title", "mime_type" }, "duration>0", null, (String)localObject3);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      paramInt1 = 0;
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new AlbumUtils.LocalMediaInfo();
        ((AlbumUtils.LocalMediaInfo)localObject2).b = true;
        ((AlbumUtils.LocalMediaInfo)localObject2).d = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((AlbumUtils.LocalMediaInfo)localObject2).e = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((AlbumUtils.LocalMediaInfo)localObject2).f = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((AlbumUtils.LocalMediaInfo)localObject2).j = ((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndexOrThrow("duration"));
        ((AlbumUtils.LocalMediaInfo)localObject2).g = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("resolution"));
        ((AlbumUtils.LocalMediaInfo)localObject2).h = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((AlbumUtils.LocalMediaInfo)localObject2).i = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("title"));
        ((AlbumUtils.LocalMediaInfo)localObject2).c = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((AlbumUtils.LocalMediaInfo)localObject2).l = ((AlbumUtils.LocalMediaInfo)localObject2).e;
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryVideoList index:");
        ((StringBuilder)localObject2).append(paramInt1);
        QLog.d("AlbumUtils", 2, ((StringBuilder)localObject2).toString());
        paramInt1 += 1;
      }
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
  
  @NotNull
  public static final ArrayList<AlbumUtils.LocalMediaInfo> b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = BaseApplication.getContext().getContentResolver();
    Object localObject2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("date_modified DESC limit ");
    ((StringBuilder)localObject3).append(paramInt2);
    ((StringBuilder)localObject3).append(" offset ");
    ((StringBuilder)localObject3).append(paramInt1);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject1 = ((ContentResolver)localObject1).query((Uri)localObject2, new String[] { "_id", "_data", "_size", "date_modified", "mime_type" }, null, null, (String)localObject3);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new AlbumUtils.LocalMediaInfo();
        ((AlbumUtils.LocalMediaInfo)localObject2).b = false;
        ((AlbumUtils.LocalMediaInfo)localObject2).d = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_id"));
        ((AlbumUtils.LocalMediaInfo)localObject2).e = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("_data"));
        ((AlbumUtils.LocalMediaInfo)localObject2).f = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("_size"));
        ((AlbumUtils.LocalMediaInfo)localObject2).h = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("date_modified"));
        ((AlbumUtils.LocalMediaInfo)localObject2).c = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndexOrThrow("mime_type"));
        ((AlbumUtils.LocalMediaInfo)localObject2).k = ((AlbumUtils.LocalMediaInfo)localObject2).e;
        ((AlbumUtils.LocalMediaInfo)localObject2).l = ((AlbumUtils.LocalMediaInfo)localObject2).k;
        localObject3 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject3).mediaWidth = ((AlbumUtils.LocalMediaInfo)localObject2).a();
        ((LocalMediaInfo)localObject3).mediaHeight = ((AlbumUtils.LocalMediaInfo)localObject2).b();
        ((LocalMediaInfo)localObject3).path = ((AlbumUtils.LocalMediaInfo)localObject2).e;
        ((AlbumUtils.LocalMediaInfo)localObject2).o = ((LocalMediaInfo)localObject3);
        localArrayList.add(localObject2);
        ((Cursor)localObject1).moveToNext();
      }
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.AlbumUtils
 * JD-Core Version:    0.7.0.1
 */