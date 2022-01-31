package com.tencent.weiyun.data;

import android.text.TextUtils;

public class DirItem
  extends CNativeObject
{
  public FileItem coverFile;
  public long createTime;
  private String dirKey;
  public String dirName;
  public String iconUrl;
  public boolean isBackupDir = false;
  public long modifyTime;
  public String ownerNickname;
  public long ownerUin;
  private String pDirKey;
  public String pDirName;
  
  private DirItem()
  {
    super(0L);
  }
  
  private DirItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static DirItem createDir(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      throw new IllegalArgumentException("createDir: the params dirKey, dirName and pDirKey should be valid.");
    }
    DirItem localDirItem = new DirItem();
    localDirItem.dirKey = paramString1;
    localDirItem.dirName = paramString2;
    localDirItem.pDirKey = paramString3;
    return localDirItem;
  }
  
  public static DirItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    DirItem localDirItem = new DirItem(paramLong);
    localDirItem.dirKey = CBundleReader.getHexString(paramLong, "dir_key");
    localDirItem.dirName = CBundleReader.getString(paramLong, "dir_name");
    localDirItem.pDirKey = CBundleReader.getHexString(paramLong, "p_dir_key");
    localDirItem.pDirName = CBundleReader.getString(paramLong, "p_dir_name");
    localDirItem.createTime = CBundleReader.getLong(paramLong, "create_time", 0L);
    localDirItem.modifyTime = CBundleReader.getLong(paramLong, "modify_time", 0L);
    localDirItem.iconUrl = CBundleReader.getString(paramLong, "icon_url");
    long l = CBundleReader.getLong(paramLong, "cover_file", 0L);
    if (l != 0L) {
      localDirItem.coverFile = FileItem.newInstance(l);
    }
    localDirItem.isBackupDir = CBundleReader.getBoolean(paramLong, "is_backup_dir", false);
    localDirItem.ownerUin = CBundleReader.getLong(paramLong, "owner_uin", 0L);
    localDirItem.ownerNickname = CBundleReader.getString(paramLong, "owner_nickname");
    localDirItem.releaseNative();
    return localDirItem;
  }
  
  public DirItem clone()
  {
    try
    {
      DirItem localDirItem = (DirItem)super.clone();
      return localDirItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String dirKey()
  {
    return this.dirKey;
  }
  
  public String pDirKey()
  {
    return this.pDirKey;
  }
  
  public void releaseNative()
  {
    if ((isNative()) && (this.coverFile != null)) {
      this.coverFile.releaseNative();
    }
    super.releaseNative();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weiyun.data.DirItem
 * JD-Core Version:    0.7.0.1
 */