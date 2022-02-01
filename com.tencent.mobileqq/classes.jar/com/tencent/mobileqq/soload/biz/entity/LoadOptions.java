package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.soload.util.SoDataUtil;
import java.io.Serializable;

public class LoadOptions
  implements Serializable
{
  public static final int FLAG_CLOSE_REPORT = 32;
  public static final int FLAG_CLOSE_SYNC_LOAD_FAIL_RETRY = 16;
  public static final int FLAG_NO_NEED_CRC = 8;
  public static final int FLAG_NO_NEED_LOAD_SO = 1;
  public static final int FLAG_RETURN_SO_PATH = 2;
  public static final int FLAG_WEAK_RELATED = 4;
  public static LoadOptions sDefault = new LoadOptions.LoadOptionsBuilder().a();
  public int flag = 0;
  public boolean isLoadLastSuccWhenFail = false;
  public String oldSoPathFor32Bit;
  public String oldSoPathFor64Bit;
  
  public String getOldSoPath()
  {
    if (SoDataUtil.a()) {
      return this.oldSoPathFor64Bit;
    }
    return this.oldSoPathFor32Bit;
  }
  
  public boolean isSame(LoadOptions paramLoadOptions)
  {
    if (paramLoadOptions == null) {}
    while ((this.isLoadLastSuccWhenFail != paramLoadOptions.isLoadLastSuccWhenFail) || (!SoDataUtil.a(this.oldSoPathFor32Bit, paramLoadOptions.oldSoPathFor32Bit)) || (!SoDataUtil.a(this.oldSoPathFor64Bit, paramLoadOptions.oldSoPathFor64Bit)) || (this.flag != paramLoadOptions.flag)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadOptions{isLLSl=" + this.isLoadLastSuccWhenFail + ", old32Bit='" + this.oldSoPathFor32Bit + '\'' + ", old64Bit='" + this.oldSoPathFor64Bit + '\'' + ", flag=" + this.flag + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadOptions
 * JD-Core Version:    0.7.0.1
 */