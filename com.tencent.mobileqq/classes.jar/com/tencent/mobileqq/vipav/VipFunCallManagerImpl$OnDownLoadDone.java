package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VipFunCallManagerImpl$OnDownLoadDone
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  
  public VipFunCallManagerImpl$OnDownLoadDone(VipFunCallManagerImpl paramVipFunCallManagerImpl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.c = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public OnDownLoadDone a()
  {
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_b_of_type_JavaLangString);
    boolean bool;
    if ((this.jdField_a_of_type_JavaIoFile.exists()) && (this.jdField_a_of_type_JavaIoFile.isFile())) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload exists(), id=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", resType=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(", isIPC=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", srcType=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", fileExist=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.d = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    if ((7 != VipFunCallUtil.a()) && (7 == this.d)) {
      this.d = 0;
    }
    this.jdField_a_of_type_AndroidOsBundle.putInt("callId", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putString("path", this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("isIPC", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsBundle.putInt("resourceType", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidOsBundle.putInt("srcType", this.c);
    this.jdField_a_of_type_AndroidOsBundle.putInt("dealType", this.d);
    if (bool)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBoolean("isExists", true);
      localObject = new DownloadTask(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile);
      ((DownloadTask)localObject).a(3);
      ((DownloadTask)localObject).jdField_a_of_type_Int = 0;
      ((DownloadTask)localObject).a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallManagerImpl.a.onDone((DownloadTask)localObject);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public File a()
  {
    return this.jdField_a_of_type_JavaIoFile;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManagerImpl.OnDownLoadDone
 * JD-Core Version:    0.7.0.1
 */