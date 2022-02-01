public abstract class nce
  implements ncf, ncg, nch, nci
{
  private ncf jdField_a_of_type_Ncf;
  private nch jdField_a_of_type_Nch;
  
  public final void a(ncf paramncf)
  {
    this.jdField_a_of_type_Ncf = paramncf;
  }
  
  public final void a(nch paramnch)
  {
    this.jdField_a_of_type_Nch = paramnch;
  }
  
  public final void receiveGatewayMsg(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ncf != null) {
      this.jdField_a_of_type_Ncf.receiveGatewayMsg(paramString, paramInt);
    }
    if (this.jdField_a_of_type_Nch != null) {
      this.jdField_a_of_type_Nch.receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public final int receiveMultiVideoMsg(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Nch == null) {
      return 3;
    }
    try
    {
      paramInt = this.jdField_a_of_type_Nch.receiveMultiVideoMsg(paramInt, paramArrayOfByte);
      return paramInt;
    }
    catch (Throwable paramArrayOfByte) {}
    return 1;
  }
  
  public final byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte b2 = 1;
    byte b1;
    if (this.jdField_a_of_type_Ncf == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.jdField_a_of_type_Ncf.receiveSharpVideoAck(paramLong, paramArrayOfByte1, paramArrayOfByte2);
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
    if (this.jdField_a_of_type_Ncf == null) {
      b1 = 3;
    }
    for (;;)
    {
      return b1;
      b1 = b2;
      if (paramArrayOfByte1 != null) {
        try
        {
          int i = this.jdField_a_of_type_Ncf.receiveSharpVideoCall(paramLong, paramArrayOfByte1, paramArrayOfByte2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nce
 * JD-Core Version:    0.7.0.1
 */