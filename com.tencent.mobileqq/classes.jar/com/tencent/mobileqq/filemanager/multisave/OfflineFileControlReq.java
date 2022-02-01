package com.tencent.mobileqq.filemanager.multisave;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class OfflineFileControlReq
  extends QFileControlReq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public OfflineFileControlReq(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = paramFileManagerEntity.nSessionId;
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      return a((String)localObject, str, localStringBuilder.toString());
    }
    QLog.e("OfflineFileControlReq<QFile>", 1, "key params is null");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.OfflineFileControlReq
 * JD-Core Version:    0.7.0.1
 */