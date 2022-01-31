package com.tencent.mobileqq.transfile;

public class TransferRequest$PicUpExtraInfo
{
  public int a;
  public TransferRequest.AppShare a;
  public boolean a;
  public boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUinType:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(",mIsRaw:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mIsShareAppPic:" + this.b);
    localStringBuilder.append(",mShareAppInfo:{" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest$AppShare + "}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo
 * JD-Core Version:    0.7.0.1
 */