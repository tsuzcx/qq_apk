package com.tencent.mobileqq.transfile;

import aivt;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ReqBody;

public class QIMWebVideoUploaderFirstFrame
{
  public int a;
  private long jdField_a_of_type_Long;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploaderFirstFrame$IQIMWebVideoUpCallback;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  public QIMWebVideoUploaderFirstFrame(AppInterface paramAppInterface, QIMWebVideoUploaderFirstFrame.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploaderFirstFrame$IQIMWebVideoUpCallback = paramIQIMWebVideoUpCallback;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_Int = paramInt;
    this.e = paramString2;
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG> doUpload " + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          this.jdField_b_of_type_Int = 9303;
          this.d = "read video file error";
          this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploaderFirstFrame$IQIMWebVideoUpCallback.b(this.jdField_b_of_type_Int, this.d);
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    Object localObject = new QIMVideoUpload.ReqBody();
    ((QIMVideoUpload.ReqBody)localObject).uint64_uin.set(Long.parseLong(this.jdField_b_of_type_JavaLangString));
    ((QIMVideoUpload.ReqBody)localObject).uint64_service_type.set(this.jdField_a_of_type_Int);
    ((QIMVideoUpload.ReqBody)localObject).uint64_data_type.set(1L);
    ((QIMVideoUpload.ReqBody)localObject).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
    ((QIMVideoUpload.ReqBody)localObject).uint64_pic_type.set(1L);
    ((QIMVideoUpload.ReqBody)localObject).str_video_uuid.set(this.e);
    localObject = ((QIMVideoUpload.ReqBody)localObject).toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "doUpload|mVideoFileMd5= " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
    }
    aivt localaivt = new aivt(this);
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_b_of_type_JavaLangString, 53, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_ArrayOfByte, localaivt, (byte[])localObject, false);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    if (QLog.isColorLevel()) {
      QLog.d("QIMWebVideoUploaderFirstFrame", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte) + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 53);
    }
    if (i != 0)
    {
      this.jdField_b_of_type_Int = i;
      this.d = "SubmitError";
      this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploaderFirstFrame$IQIMWebVideoUpCallback.b(this.jdField_b_of_type_Int, this.d);
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.QIMWebVideoUploaderFirstFrame
 * JD-Core Version:    0.7.0.1
 */