package com.yolo.esports.download.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.yolo.esports.download.common.DownloadInfo;

class DownloadInfoDBCommon
{
  public static final String[] a = { "download_ticket", "download_url", "file_size", "file_md5", "file_name", "file_abs_path", "file_root_dir", "create_time", "cost_time", "received_length", "total_length", "error_code", "error_msg", "priority", "scene", "pause_on_mobile", "download_state", "extra_info", "unique_id", "file_type" };
  
  static int a(Cursor paramCursor, String paramString)
  {
    if ((paramCursor != null) && (!TextUtils.isEmpty(paramString))) {
      return paramCursor.getColumnIndex(paramString);
    }
    return -1;
  }
  
  static ContentValues a(DownloadInfo paramDownloadInfo)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("download_ticket", paramDownloadInfo.a());
    localContentValues.put("download_url", paramDownloadInfo.b);
    localContentValues.put("file_size", Long.valueOf(paramDownloadInfo.f));
    localContentValues.put("file_md5", paramDownloadInfo.g);
    localContentValues.put("file_name", paramDownloadInfo.c);
    localContentValues.put("file_abs_path", paramDownloadInfo.e);
    localContentValues.put("file_root_dir", paramDownloadInfo.d);
    localContentValues.put("create_time", Long.valueOf(paramDownloadInfo.h));
    localContentValues.put("cost_time", Long.valueOf(paramDownloadInfo.i));
    localContentValues.put("received_length", Long.valueOf(paramDownloadInfo.j));
    localContentValues.put("total_length", Long.valueOf(paramDownloadInfo.k));
    localContentValues.put("error_code", Integer.valueOf(paramDownloadInfo.l));
    localContentValues.put("error_msg", paramDownloadInfo.m);
    localContentValues.put("priority", Integer.valueOf(paramDownloadInfo.n));
    localContentValues.put("scene", paramDownloadInfo.o);
    localContentValues.put("pause_on_mobile", Boolean.valueOf(paramDownloadInfo.p));
    localContentValues.put("download_state", Integer.valueOf(paramDownloadInfo.q));
    localContentValues.put("extra_info", paramDownloadInfo.r);
    localContentValues.put("unique_id", paramDownloadInfo.s);
    localContentValues.put("file_type", paramDownloadInfo.x);
    return localContentValues;
  }
  
  static DownloadInfo a(Cursor paramCursor)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.a(paramCursor.getString(a(paramCursor, "download_ticket")));
    localDownloadInfo.b = paramCursor.getString(a(paramCursor, "download_url"));
    localDownloadInfo.f = paramCursor.getLong(a(paramCursor, "file_size"));
    localDownloadInfo.g = paramCursor.getString(a(paramCursor, "file_md5"));
    localDownloadInfo.c = paramCursor.getString(a(paramCursor, "file_name"));
    localDownloadInfo.e = paramCursor.getString(a(paramCursor, "file_abs_path"));
    localDownloadInfo.d = paramCursor.getString(a(paramCursor, "file_root_dir"));
    localDownloadInfo.h = paramCursor.getLong(a(paramCursor, "create_time"));
    localDownloadInfo.i = paramCursor.getLong(a(paramCursor, "cost_time"));
    localDownloadInfo.j = paramCursor.getLong(a(paramCursor, "received_length"));
    localDownloadInfo.k = paramCursor.getLong(a(paramCursor, "total_length"));
    localDownloadInfo.l = paramCursor.getInt(a(paramCursor, "error_code"));
    localDownloadInfo.m = paramCursor.getString(a(paramCursor, "error_msg"));
    localDownloadInfo.n = paramCursor.getInt(a(paramCursor, "priority"));
    localDownloadInfo.o = paramCursor.getString(a(paramCursor, "scene"));
    boolean bool;
    if (paramCursor.getInt(a(paramCursor, "pause_on_mobile")) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localDownloadInfo.p = bool;
    localDownloadInfo.q = paramCursor.getInt(a(paramCursor, "download_state"));
    localDownloadInfo.r = paramCursor.getString(a(paramCursor, "extra_info"));
    localDownloadInfo.s = paramCursor.getString(a(paramCursor, "unique_id"));
    localDownloadInfo.x = paramCursor.getString(a(paramCursor, "file_type"));
    return localDownloadInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.db.DownloadInfoDBCommon
 * JD-Core Version:    0.7.0.1
 */