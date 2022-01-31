package com.tencent.weiyun.data;

import android.text.TextUtils;

public class FileItem
  extends CNativeObject
{
  public static final int DATA_FROM_CLOUD = 2;
  public static final int DATA_FROM_DB = 1;
  public static final int LIB_AUDIO = 3;
  public static final int LIB_CLOUD_GALLERY = 24;
  public static final int LIB_DOC = 1;
  public static final int LIB_IMAGE = 2;
  public static final int LIB_OTHER = 5;
  public static final int LIB_VIDEO = 4;
  private String batchId;
  private int commentCount;
  private long createTime;
  private long currentSize;
  private FileItem.DownloadServerInfo downloadServerInfo;
  private long duration;
  private String eventId;
  private String fileId;
  private String fileName;
  private long fileSize;
  private int fileVersion;
  private String fullPath;
  private int height;
  private double latitude;
  private int libId;
  private int likeCount;
  private double longitude;
  private String md5;
  private long modifyTime = -1L;
  private String orgSha;
  private long orgSize;
  private String pDirKey;
  private String pDirName;
  private String ppDirKey;
  private String sha;
  private boolean starFlag;
  private long starTime;
  private long takenTime = -1L;
  private String thumbUrl;
  private FileItem.UploadServerInfo uploadServerInfo;
  private String uploaderNickname;
  private long uploaderUin;
  private int width;
  
  private FileItem()
  {
    super(0L);
  }
  
  private FileItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static FileItem createFile(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("createFile: the params fileId, fileName and pDirKey should be valid.");
    }
    FileItem localFileItem = new FileItem();
    localFileItem.fileId = paramString1;
    localFileItem.fileName = paramString2;
    localFileItem.pDirKey = paramString3;
    return localFileItem;
  }
  
  public static FileItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    return new FileItem(paramLong);
  }
  
  public FileItem clone()
  {
    try
    {
      FileItem localFileItem = (FileItem)super.clone();
      return localFileItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void destroy()
  {
    if (this.nativePtr != 0L)
    {
      this.fileName = null;
      this.pDirKey = null;
      this.sha = null;
      this.fileId = null;
      this.md5 = null;
    }
  }
  
  public String getBatchId()
  {
    return CBundleReader.getString(this.nativePtr, "batch_id");
  }
  
  public int getCommentCount()
  {
    return CBundleReader.getInt(this.nativePtr, "comment_count", 0);
  }
  
  public long getCreateTime()
  {
    return CBundleReader.getLong(this.nativePtr, "create_time", 0L);
  }
  
  public long getCurrentSize()
  {
    return CBundleReader.getLong(this.nativePtr, "current_size", 0L);
  }
  
  public FileItem.DownloadServerInfo getDownloadServerInfo()
  {
    FileItem.DownloadServerInfo localDownloadServerInfo = new FileItem.DownloadServerInfo();
    localDownloadServerInfo.downloadKey = CBundleReader.getString(this.nativePtr, "download_key");
    if (TextUtils.isEmpty(localDownloadServerInfo.downloadKey)) {
      localDownloadServerInfo.downloadKey = CBundleReader.getString(this.nativePtr, "share_key");
    }
    localDownloadServerInfo.url = CBundleReader.getString(this.nativePtr, "download_url");
    localDownloadServerInfo.videoUrl = CBundleReader.getString(this.nativePtr, "download_video_url");
    localDownloadServerInfo.serverName = CBundleReader.getString(this.nativePtr, "download_server_name");
    localDownloadServerInfo.serverIp = CBundleReader.getString(this.nativePtr, "download_server_ip");
    localDownloadServerInfo.serverPort = CBundleReader.getInt(this.nativePtr, "download_server_port", 80);
    localDownloadServerInfo.serverDns = CBundleReader.getString(this.nativePtr, "download_server_dns");
    localDownloadServerInfo.cookie = CBundleReader.getString(this.nativePtr, "download_cookie");
    if (TextUtils.isEmpty(localDownloadServerInfo.cookie))
    {
      String str1 = CBundleReader.getString(this.nativePtr, "download_cookie_name");
      String str2 = CBundleReader.getString(this.nativePtr, "download_cookie_value");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        localDownloadServerInfo.cookie = (str1 + '=' + str2);
      }
    }
    return localDownloadServerInfo;
  }
  
  public long getDuration()
  {
    return CBundleReader.getLong(this.nativePtr, "duration", 0L);
  }
  
  public String getEventId()
  {
    return CBundleReader.getString(this.nativePtr, "event_id");
  }
  
  public String getFileId()
  {
    return CBundleReader.getString(this.nativePtr, "file_id");
  }
  
  public String getFileName()
  {
    if (TextUtils.isEmpty(this.fileName)) {
      return CBundleReader.getString(this.nativePtr, "file_name");
    }
    return this.fileName;
  }
  
  public long getFileSize()
  {
    return CBundleReader.getLong(this.nativePtr, "file_size", 0L);
  }
  
  public int getFileVersion()
  {
    return CBundleReader.getInt(this.nativePtr, "file_version", 0);
  }
  
  public String getFullPath()
  {
    return CBundleReader.getString(this.nativePtr, "full_path");
  }
  
  public int getHeight()
  {
    return CBundleReader.getInt(this.nativePtr, "height", 0);
  }
  
  public double getLatitude()
  {
    return CBundleReader.getDouble(this.nativePtr, "latitude", 0.0D);
  }
  
  public int getLibId()
  {
    return CBundleReader.getInt(this.nativePtr, "lib_id", 5);
  }
  
  public int getLikeCount()
  {
    return CBundleReader.getInt(this.nativePtr, "like_count", 0);
  }
  
  public double getLongitude()
  {
    return CBundleReader.getDouble(this.nativePtr, "longitude", 0.0D);
  }
  
  public String getMd5()
  {
    return CBundleReader.getHexString(this.nativePtr, "md5").toLowerCase();
  }
  
  public long getModifyTime()
  {
    if (this.modifyTime == -1L) {
      this.modifyTime = CBundleReader.getLong(this.nativePtr, "modify_time", 0L);
    }
    return this.modifyTime;
  }
  
  public String getOrgSha()
  {
    if (this.nativePtr != 0L) {
      return CBundleReader.getHexString(this.nativePtr, "org_file_sha").toLowerCase();
    }
    return this.orgSha;
  }
  
  public long getOrgSize()
  {
    if (this.nativePtr != 0L) {
      return CBundleReader.getLong(this.nativePtr, "org_file_size", 0L);
    }
    return this.orgSize;
  }
  
  public String getPpDirKey()
  {
    return CBundleReader.getHexString(this.nativePtr, "pp_dir_key");
  }
  
  public String getSha()
  {
    return CBundleReader.getHexString(this.nativePtr, "sha").toLowerCase();
  }
  
  public long getStarTime()
  {
    return CBundleReader.getLong(this.nativePtr, "star_time", 0L);
  }
  
  public long getTakenTime()
  {
    if (this.takenTime == -1L) {
      this.takenTime = CBundleReader.getLong(this.nativePtr, "taken_time", 0L);
    }
    return this.takenTime;
  }
  
  public String getThumbUrl()
  {
    return CBundleReader.getString(this.nativePtr, "thumb_url");
  }
  
  public String getUploadFullPath()
  {
    return CBundleReader.getString(this.nativePtr, "backup_path");
  }
  
  public FileItem.UploadServerInfo getUploadServerInfo()
  {
    FileItem.UploadServerInfo localUploadServerInfo = new FileItem.UploadServerInfo();
    localUploadServerInfo.url = CBundleReader.getString(this.nativePtr, "upload_server_url");
    localUploadServerInfo.isAuto = CBundleReader.getBoolean(this.nativePtr, "is_auto", false);
    localUploadServerInfo.fileExist = CBundleReader.getBoolean(this.nativePtr, "file_exist", false);
    localUploadServerInfo.checkKey = CBundleReader.getHexString(this.nativePtr, "upload_check_key");
    localUploadServerInfo.serverName = CBundleReader.getString(this.nativePtr, "upload_server_name");
    localUploadServerInfo.serverIp = CBundleReader.getString(this.nativePtr, "upload_server_ip");
    localUploadServerInfo.serverPort = CBundleReader.getInt(this.nativePtr, "upload_server_port", 80);
    localUploadServerInfo.channelCount = CBundleReader.getInt(this.nativePtr, "upload_channel_count", 0);
    return localUploadServerInfo;
  }
  
  public String getUploaderNickname()
  {
    return CBundleReader.getString(this.nativePtr, "uploader_nickname");
  }
  
  public long getUploaderUin()
  {
    return CBundleReader.getLong(this.nativePtr, "uploader_uin", 0L);
  }
  
  public int getWidth()
  {
    return CBundleReader.getInt(this.nativePtr, "width", 0);
  }
  
  public String getpDirKey()
  {
    return CBundleReader.getHexString(this.nativePtr, "p_dir_key");
  }
  
  public String getpDirName()
  {
    return CBundleReader.getString(this.nativePtr, "p_dir_name");
  }
  
  public void init()
  {
    if (this.nativePtr != 0L)
    {
      this.fileName = getFileName();
      this.pDirKey = getpDirKey();
      this.sha = getSha();
      this.fileId = getFileId();
      this.fileSize = getFileSize();
      this.latitude = getLatitude();
      this.longitude = getLongitude();
      this.takenTime = getTakenTime();
      this.duration = getDuration();
      this.width = getWidth();
      this.height = getHeight();
      this.md5 = getMd5();
    }
  }
  
  public boolean isStarFlag()
  {
    return CBundleReader.getBoolean(this.nativePtr, "star_flag", false);
  }
  
  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
  
  public void setModifyTime(long paramLong)
  {
    this.modifyTime = paramLong;
  }
  
  public void setTakenTime(long paramLong)
  {
    this.takenTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.data.FileItem
 * JD-Core Version:    0.7.0.1
 */