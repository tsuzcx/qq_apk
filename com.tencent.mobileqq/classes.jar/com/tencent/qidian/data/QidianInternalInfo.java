package com.tencent.qidian.data;

import android.text.TextUtils;
import awbv;
import awdj;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qidian.proto.mobileqq_qidian.InternalInfo;

public class QidianInternalInfo
  extends awbv
{
  public byte[] infoByte;
  public String mobile = "";
  @awdj
  public String uin = "";
  
  public void from(mobileqq_qidian.InternalInfo paramInternalInfo)
  {
    this.infoByte = paramInternalInfo.toByteArray();
    if (paramInternalInfo.uint64_uin.has()) {
      this.uin = String.valueOf(paramInternalInfo.uint64_uin.get());
    }
    if (paramInternalInfo.str_internal_mobile.has()) {
      this.mobile = paramInternalInfo.str_internal_mobile.get();
    }
  }
  
  public mobileqq_qidian.InternalInfo to()
  {
    mobileqq_qidian.InternalInfo localInternalInfo = new mobileqq_qidian.InternalInfo();
    localInternalInfo.str_internal_mobile.set(this.mobile);
    localInternalInfo.uint64_uin.set(Long.parseLong(this.uin));
    return localInternalInfo;
  }
  
  public void update(QidianInternalInfo paramQidianInternalInfo)
  {
    if ((paramQidianInternalInfo != null) && (this.uin.equals(paramQidianInternalInfo.uin)))
    {
      if (!TextUtils.isEmpty(paramQidianInternalInfo.mobile)) {
        this.mobile = paramQidianInternalInfo.mobile;
      }
      this.infoByte = to().toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.data.QidianInternalInfo
 * JD-Core Version:    0.7.0.1
 */