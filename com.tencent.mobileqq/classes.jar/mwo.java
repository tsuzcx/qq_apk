public abstract class mwo
  implements mwp, mwq, mwr, mws
{
  private mwp jdField_a_of_type_Mwp;
  private mwr jdField_a_of_type_Mwr;
  
  public final void a(mwp parammwp)
  {
    this.jdField_a_of_type_Mwp = parammwp;
  }
  
  public final void a(mwr parammwr)
  {
    this.jdField_a_of_type_Mwr = parammwr;
  }
  
  public final void receiveGatewayMsg(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Mwp != null) {
      this.jdField_a_of_type_Mwp.receiveGatewayMsg(paramString, paramInt);
    }
    if (this.jdField_a_of_type_Mwr != null) {
      this.jdField_a_of_type_Mwr.receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public final int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Mwr == null) {
      return 3;
    }
    try
    {
      paramInt = this.jdField_a_of_type_Mwr.receiveMultiVideoMsg(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte) {}
    return 1;
  }
  
  public final byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.jdField_a_of_type_Mwp == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.jdField_a_of_type_Mwp.receiveSharpVideoAck(paramLong, paramArrayOfByte1, paramArrayOfByte2);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
  
  public final byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.jdField_a_of_type_Mwp == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.jdField_a_of_type_Mwp.receiveSharpVideoCall(paramLong, paramArrayOfByte1, paramArrayOfByte2);
          b1 = b2;
          if (i >= 0) {
            return 0;
          }
        }
        catch (Throwable paramArrayOfByte1) {}
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwo
 * JD-Core Version:    0.7.0.1
 */