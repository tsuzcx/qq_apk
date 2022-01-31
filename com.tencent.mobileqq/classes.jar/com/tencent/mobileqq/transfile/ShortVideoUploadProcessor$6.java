package com.tencent.mobileqq.transfile;

import ayqm;
import aywr;
import com.qq.taf.jce.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class ShortVideoUploadProcessor$6
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice");
    }
    synchronized (this.this$0)
    {
      if (ShortVideoUploadProcessor.a(this.this$0) != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mSwitch != SWITCH_PRE_UPLOAD  mSwitch : " + ShortVideoUploadProcessor.a(this.this$0));
        }
        return;
      }
      if (this.a == null) {
        return;
      }
    }
    if ((ShortVideoUploadProcessor.b(this.this$0) == 1) || (ShortVideoUploadProcessor.b(this.this$0) == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.this$0) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.this$0));
      }
      return;
    }
    if ((this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.length() != 0) && (this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_b_of_type_JavaLangString.length() != 0))
    {
      localObject2 = this.a.jdField_a_of_type_JavaLangString;
      int i = (int)new File((String)localObject2).length();
      int j = this.a.jdField_b_of_type_Int;
      int k = this.a.jdField_a_of_type_Int;
      int m = this.a.d;
      int n = this.a.jdField_c_of_type_Int;
      localObject3 = HexUtil.hexStr2Bytes(this.a.jdField_b_of_type_JavaLangString);
      this.this$0.a((String)localObject2, i, this.this$0.d, (byte[])localObject3, k, m, n, j);
    }
    if (this.a.jdField_a_of_type_Boolean) {
      this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (this.a.jdField_b_of_type_Boolean) {
      this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice  info.mEncodeFinish = " + this.a.jdField_a_of_type_Boolean + " info.mSendClicked = " + this.a.jdField_b_of_type_Boolean + " mEncodeFinish = " + this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mSendClicked = " + this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.this$0));
    }
    if (this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (ShortVideoUploadProcessor.b(this.this$0) == 0)
      {
        if (!ShortVideoUploadProcessor.jdField_a_of_type_Boolean) {
          break label602;
        }
        this.this$0.a(this.this$0.jdField_b_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.this$0.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.this$0, 3);
      }
      if (this.this$0.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((!this.this$0.c.isEmpty()) || (ShortVideoUploadProcessor.b(this.this$0) != 0)) {
          break label657;
        }
        this.this$0.a(this.this$0.jdField_b_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.this$0.jdField_b_of_type_JavaUtilList);
        ShortVideoUploadProcessor.a(this.this$0, 3);
      }
    }
    label602:
    while (ShortVideoUploadProcessor.b(this.this$0) != 4)
    {
      return;
      if (!this.this$0.c.isEmpty()) {
        break;
      }
      this.this$0.a(this.this$0.jdField_b_of_type_Long, this.this$0.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo, this.this$0.jdField_b_of_type_JavaUtilList);
      ShortVideoUploadProcessor.a(this.this$0, 3);
      break;
    }
    label657:
    Object localObject2 = this.this$0.jdField_a_of_type_Ayqm;
    Object localObject3 = this.this$0.jdField_a_of_type_Ayqm;
    ShortVideoUploadProcessor localShortVideoUploadProcessor2 = this.this$0;
    long l = this.this$0.q;
    localShortVideoUploadProcessor2.s = l;
    ((ayqm)localObject3).e = l;
    ((ayqm)localObject2).a = l;
    ShortVideoUploadProcessor.b(this.this$0, this.a.jdField_c_of_type_Boolean);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitFollowedSlice mNeedSyncStory = " + ShortVideoUploadProcessor.a(this.this$0));
    }
    this.this$0.d(1007);
    this.this$0.b(false);
    l = 0L;
    if (this.this$0.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {
      l = Long.valueOf((String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store")).longValue();
    }
    if (this.this$0.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store") != null) {}
    for (localObject2 = (String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("param_cost_s_store");; localObject2 = String.valueOf(0))
    {
      ShortVideoUploadProcessor.a(this.this$0, true, l, (String)localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.6
 * JD-Core Version:    0.7.0.1
 */