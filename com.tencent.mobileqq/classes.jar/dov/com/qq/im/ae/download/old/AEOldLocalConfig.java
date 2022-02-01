package dov.com.qq.im.ae.download.old;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AEOldLocalConfig
{
  public static final List<AEOldShortVideoResManager.SVConfigItem> a = ;
  
  private static List<AEOldShortVideoResManager.SVConfigItem> a()
  {
    LinkedList localLinkedList = new LinkedList();
    AEOldShortVideoResManager.SVConfigItem localSVConfigItem = new AEOldShortVideoResManager.SVConfigItem();
    localSVConfigItem.name = "old_qq_android_native_short_filter_850003";
    localSVConfigItem.arm_url = "https://downv6.qq.com/shadow_qqcamera/Android/res/ae_old_base_res_1.0.3.zip";
    localSVConfigItem.armv7a_url = "https://downv6.qq.com/shadow_qqcamera/Android/res/ae_old_base_res_1.0.3.zip";
    localSVConfigItem.x86_url = "https://downv6.qq.com/shadow_qqcamera/Android/res/ae_old_base_res_1.0.3.zip";
    localSVConfigItem.arm64v8a_url = "TODO@850";
    localSVConfigItem.arm_md5 = "b4cb080d29b902000d51abb4755de873";
    localSVConfigItem.armv7a_md5 = "b4cb080d29b902000d51abb4755de873";
    localSVConfigItem.x86_md5 = "b4cb080d29b902000d51abb4755de873";
    localSVConfigItem.arm64v8a_md5 = "TODO@850";
    localSVConfigItem.versionCode = 8500;
    localSVConfigItem.predownload = false;
    localLinkedList.add(localSVConfigItem);
    return Collections.unmodifiableList(localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldLocalConfig
 * JD-Core Version:    0.7.0.1
 */