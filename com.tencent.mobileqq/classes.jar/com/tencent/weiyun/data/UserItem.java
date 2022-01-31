package com.tencent.weiyun.data;

public class UserItem
  extends CNativeObject
{
  public String agreementUrl;
  public String avatarUrl;
  public int dirLevelMax;
  public int fileNameMaxLen;
  public int filePathMaxLen;
  public boolean flashClickEnable;
  public long flashDuration;
  public long flashEndTime;
  public String flashImageUrl;
  public long flashStarTime;
  public String flashTargetUrl;
  public String helpUrl;
  public String mainDirKey;
  public int maxBatchDirClearNum;
  public int maxBatchDirDeleteNum;
  public int maxBatchDirMoveNum;
  public int maxBatchDirRestoreNum;
  public int maxBatchFileClearNum;
  public int maxBatchFileDeleteNum;
  public int maxBatchFileMoveNum;
  public int maxBatchFileRestoreNum;
  public String name;
  public boolean oldWeiyunVip;
  public long pluginSwitchFlag;
  public String pwdForgetUrl;
  public boolean pwdOpen;
  public String qqOfflineDetailUrl;
  public String recommendationUrl;
  public long serverTime;
  public long superVipEndTime;
  public long totalSpace;
  private long uin;
  public long usedSpace;
  public long vipEndTime;
  public boolean weiyunSuperVip;
  public boolean weiyunVip;
  
  private UserItem()
  {
    super(0L);
  }
  
  private UserItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static UserItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    UserItem localUserItem = new UserItem(paramLong);
    localUserItem.uin = CBundleReader.getLong(paramLong, "uin", 0L);
    localUserItem.name = CBundleReader.getString(paramLong, "name");
    localUserItem.avatarUrl = CBundleReader.getString(paramLong, "avatar");
    localUserItem.mainDirKey = CBundleReader.getHexString(paramLong, "main_dir_key");
    localUserItem.totalSpace = CBundleReader.getLong(paramLong, "total_space", 0L);
    localUserItem.usedSpace = CBundleReader.getLong(paramLong, "used_space", 0L);
    localUserItem.pwdOpen = CBundleReader.getBoolean(paramLong, "pwd_open", false);
    localUserItem.weiyunVip = CBundleReader.getBoolean(paramLong, "weiyun_vip", false);
    localUserItem.oldWeiyunVip = CBundleReader.getBoolean(paramLong, "old_weiyun_vip", false);
    localUserItem.vipEndTime = CBundleReader.getLong(paramLong, "vip_end_time", 0L);
    localUserItem.weiyunSuperVip = CBundleReader.getBoolean(paramLong, "is_weiyun_super_vip", false);
    localUserItem.superVipEndTime = CBundleReader.getLong(paramLong, "super_vip_end_time", 0L);
    localUserItem.filePathMaxLen = CBundleReader.getInt(paramLong, "file_path_max_len", 0);
    localUserItem.fileNameMaxLen = CBundleReader.getInt(paramLong, "file_name_max_len", 0);
    localUserItem.dirLevelMax = CBundleReader.getInt(paramLong, "dir_level_max", 0);
    localUserItem.maxBatchDirDeleteNum = CBundleReader.getInt(paramLong, "max_batch_dir_delete_num", 0);
    localUserItem.maxBatchFileDeleteNum = CBundleReader.getInt(paramLong, "max_batch_file_delete_num", 0);
    localUserItem.maxBatchDirMoveNum = CBundleReader.getInt(paramLong, "max_batch_dir_move_num", 0);
    localUserItem.maxBatchFileMoveNum = CBundleReader.getInt(paramLong, "max_batch_file_move_num", 0);
    localUserItem.maxBatchDirRestoreNum = CBundleReader.getInt(paramLong, "max_batch_dir_restore_num", 0);
    localUserItem.maxBatchFileRestoreNum = CBundleReader.getInt(paramLong, "max_batch_file_restore_num", 0);
    localUserItem.maxBatchDirClearNum = CBundleReader.getInt(paramLong, "max_batch_dir_clear_num", 0);
    localUserItem.maxBatchFileClearNum = CBundleReader.getInt(paramLong, "max_batch_file_clear_num", 0);
    localUserItem.serverTime = CBundleReader.getLong(paramLong, "server_time", 0L);
    localUserItem.flashStarTime = CBundleReader.getLong(paramLong, "flash_start_time", 0L);
    localUserItem.flashEndTime = CBundleReader.getLong(paramLong, "flash_end_time", 0L);
    localUserItem.flashImageUrl = CBundleReader.getString(paramLong, "flash_image_url");
    localUserItem.flashClickEnable = CBundleReader.getBoolean(paramLong, "flash_click_enable", false);
    localUserItem.flashTargetUrl = CBundleReader.getString(paramLong, "flash_target_url");
    localUserItem.flashDuration = CBundleReader.getLong(paramLong, "flash_duration", 0L);
    localUserItem.qqOfflineDetailUrl = CBundleReader.getString(paramLong, "qq_offline_detail_url");
    localUserItem.helpUrl = CBundleReader.getString(paramLong, "help_url");
    localUserItem.recommendationUrl = CBundleReader.getString(paramLong, "app_recommendation_url");
    localUserItem.pwdForgetUrl = CBundleReader.getString(paramLong, "pwd_forget_url");
    localUserItem.agreementUrl = CBundleReader.getString(paramLong, "agreement_url");
    localUserItem.pluginSwitchFlag = CBundleReader.getLong(paramLong, "plugin_switch_flag", 0L);
    localUserItem.releaseNative();
    return localUserItem;
  }
  
  public long uin()
  {
    return this.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.weiyun.data.UserItem
 * JD-Core Version:    0.7.0.1
 */