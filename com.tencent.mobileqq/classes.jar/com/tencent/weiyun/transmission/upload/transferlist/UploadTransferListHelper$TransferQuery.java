package com.tencent.weiyun.transmission.upload.transferlist;

abstract interface UploadTransferListHelper$TransferQuery
{
  public static final int BATCH_DESC = 19;
  public static final int BATCH_ID = 16;
  public static final int BATCH_INDEX = 18;
  public static final int BATCH_TOTAL = 17;
  public static final int COMPRESS_FLAG = 28;
  public static final int CUR_SIZE = 24;
  public static final int DIR_NAME = 27;
  public static final int DURATION = 15;
  public static final int ERROR_CODE = 21;
  public static final int ERROR_MSG = 22;
  public static final int FILE_ID = 25;
  public static final int FILE_NAME = 7;
  public static final int FILE_SIZE = 8;
  public static final int FILE_VERSION = 26;
  public static final int GROUP_ROOT_DIR_KEY = 30;
  public static final int GROUP_UIN = 29;
  public static final int HEIGHT = 14;
  public static final int ID = 0;
  public static final int INSERT_TIME = 5;
  public static final int LATITUDE = 11;
  public static final int LOCAL_MODIFIED = 3;
  public static final int LOCAL_PATH = 2;
  public static final int LOCAL_SHA = 9;
  public static final int LONGITUDE = 10;
  public static final String[] PROJECTION = { "_id", "uid", "local_path", "local_modified", "p_dir_key", "insert_time", "thumb_uri", "file_name", "file_size", "local_sha", "longitude", "latitude", "taken_time", "width", "height", "duration", "batch_id", "batch_total", "batch_index", "batch_desc", "state", "error_code", "error_msg", "total_size", "cur_size", "file_id", "file_version", "p_dir_name", "compress_flag", "p_dir_uid", "group_root_dir_key" };
  public static final int P_DIR_KEY = 4;
  public static final int STATE = 20;
  public static final int TAKEN_TIME = 12;
  public static final int THUMB_URI = 6;
  public static final int TOTAL_SIZE = 23;
  public static final int UID = 1;
  public static final int WIDTH = 13;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.transferlist.UploadTransferListHelper.TransferQuery
 * JD-Core Version:    0.7.0.1
 */