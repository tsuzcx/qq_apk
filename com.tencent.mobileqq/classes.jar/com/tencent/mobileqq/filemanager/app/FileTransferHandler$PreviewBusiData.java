package com.tencent.mobileqq.filemanager.app;

public class FileTransferHandler$PreviewBusiData
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler)
  {
    a(false, 0L, null, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, long paramLong, FileTransferObserver paramFileTransferObserver)
  {
    a(false, paramLong, null, paramFileTransferObserver, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramFileTransferObserver, paramInt);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = paramFileTransferObserver;
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  FileTransferObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  }
  
  Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.PreviewBusiData
 * JD-Core Version:    0.7.0.1
 */