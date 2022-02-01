package com.tencent.qqlive.module.videoreport.storage.database;

class DbConst
{
  public static final String CLASS_ID = "class_id";
  public static final String CREATE_TABLE_COMMAND = "CREATE TABLE IF NOT EXISTS datong_storage (`id` INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, `class_id` varchar(100) NOT NULL, `object_id` varchar(100) NOT NULL, `object_dat` text NOT NULL, UNIQUE (`class_id`, `object_id`) ON CONFLICT REPLACE);";
  public static final String DELETE_TABLE_COMMAND = "DROP TABLE IF EXISTS datong_storage";
  public static final String ID = "id";
  public static final String OBJECT_DATA = "object_dat";
  public static final String OBJECT_ID = "object_id";
  public static final String REPLACE_COMMAND = "REPLACE INTO datong_storage (`class_id`, `object_id`, `object_dat`)\nVALUES ";
  public static final String TABLE_NAME = "datong_storage";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.database.DbConst
 * JD-Core Version:    0.7.0.1
 */