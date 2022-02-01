package com.tencent.mobileqq.soload;

import akgd;
import bbzd;
import bbzl;
import java.io.Serializable;

public class LoadOptions
  implements Serializable
{
  static final int FLAG_CLOSE_REPORT = 32;
  static final int FLAG_CLOSE_SYNC_LOAD_FAIL_RETRY = 16;
  static final int FLAG_NO_NEED_CRC = 8;
  static final int FLAG_NO_NEED_LOAD_SO = 1;
  static final int FLAG_RETURN_SO_PATH = 2;
  static final int FLAG_WEAK_RELATED = 4;
  public static LoadOptions sDefault = new bbzd().a();
  public int flag = 0;
  public boolean isLoadLastSuccWhenFail = false;
  String oldSoPathFor32Bit;
  String oldSoPathFor64Bit;
  
  public String getOldSoPath()
  {
    if (bbzl.a()) {
      return this.oldSoPathFor64Bit;
    }
    return this.oldSoPathFor32Bit;
  }
  
  public boolean isSame(LoadOptions paramLoadOptions)
  {
    if (paramLoadOptions == null) {}
    while ((this.isLoadLastSuccWhenFail != paramLoadOptions.isLoadLastSuccWhenFail) || (!akgd.c(this.oldSoPathFor32Bit, paramLoadOptions.oldSoPathFor32Bit)) || (!akgd.c(this.oldSoPathFor64Bit, paramLoadOptions.oldSoPathFor64Bit))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadOptions{isLLSl=" + this.isLoadLastSuccWhenFail + ", old32Bit='" + this.oldSoPathFor32Bit + '\'' + ", old64Bit='" + this.oldSoPathFor64Bit + '\'' + ", flag=" + this.flag + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadOptions
 * JD-Core Version:    0.7.0.1
 */