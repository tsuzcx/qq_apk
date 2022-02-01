package com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader;

import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class ExtfC2CFileUploader$ExtfC2CFileInfo
  extends ExtfFileInfo
{
  final boolean jdField_a_of_type_Boolean;
  final byte[] jdField_a_of_type_ArrayOfByte;
  final byte[] b;
  
  public ExtfC2CFileUploader$ExtfC2CFileInfo(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte5;
    this.b = paramArrayOfByte6;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!super.a()) {}
    do
    {
      do
      {
        do
        {
          return false;
          if ((b() != null) && (b().length != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBuf10MMdd5 is err");
        return false;
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUuid is err");
      return false;
      if ((this.b != null) && (this.b.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.FileInfo<FileAssistant>", 2, "mBufUploadKey is err");
    return false;
    return true;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append(" uuid:");
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      str = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
      localStringBuilder = localStringBuilder.append(str).append(" mBufUploadKey:");
      if (this.b == null) {
        break label76;
      }
    }
    label76:
    for (String str = HexUtil.bytes2HexStr(this.b);; str = "")
    {
      return str;
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader.ExtfC2CFileInfo
 * JD-Core Version:    0.7.0.1
 */