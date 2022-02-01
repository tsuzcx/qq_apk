package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.base.utils.CollectionUtils.IPredicate;

final class ReadInJoyResetUtils$1
  implements CollectionUtils.IPredicate<String>
{
  public boolean a(String paramString)
  {
    return (paramString.toLowerCase().contains("readinjoy")) && (!paramString.contains("readinjoy_local_reset_config_version")) && (!paramString.contains("readinjoy_remote_reset_config_version"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyResetUtils.1
 * JD-Core Version:    0.7.0.1
 */