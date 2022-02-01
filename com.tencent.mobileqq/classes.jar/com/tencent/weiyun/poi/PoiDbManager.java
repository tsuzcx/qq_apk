package com.tencent.weiyun.poi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.utils.Singleton;
import java.io.File;

final class PoiDbManager
{
  public static final String COL_POI_ADDRESS = "address";
  public static final String COL_POI_CITY_ID = "city_id";
  public static final String COL_POI_CITY_NAME = "city_name";
  public static final String COL_POI_ID = "_id";
  public static final String COL_POI_LATITUDE = "latitude";
  public static final String COL_POI_LONGITUDE = "longitude";
  public static final String COL_POI_NATION_NAME = "nation_name";
  public static final String COL_POI_NATION_TYPE = "nation_type";
  public static final String COL_POI_POI_ID = "poi_id";
  public static final String COL_POI_POI_NAME = "poi_name";
  public static final String TBL_POI = "poi";
  private static Singleton<PoiDbManager, Void> sInstance = new PoiDbManager.1();
  private final PoiDbHelper mPoiDbHelper = new PoiDbHelper(WeiyunLiteGlobal.getInstance().getContext());
  
  public static PoiDbManager getInstance()
  {
    return (PoiDbManager)sInstance.get(null);
  }
  
  public void closePoiDb(PoiDbWrapper paramPoiDbWrapper)
  {
    if (paramPoiDbWrapper != null) {
      this.mPoiDbHelper.closeDatabase(paramPoiDbWrapper.database());
    }
  }
  
  public void dumpDb()
  {
    Context localContext = WeiyunLiteGlobal.getInstance().getContext();
    File localFile = Environment.getExternalStorageDirectory();
    this.mPoiDbHelper.dumpDb(localContext, localFile);
  }
  
  public PoiDbWrapper openPoiDb(boolean paramBoolean)
  {
    SQLiteDatabase localSQLiteDatabase = this.mPoiDbHelper.openDatabase(paramBoolean);
    if (localSQLiteDatabase == null) {
      return null;
    }
    return new PoiDbWrapper(localSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiDbManager
 * JD-Core Version:    0.7.0.1
 */