public abstract interface ncf
{
  public abstract void receiveGatewayMsg(String paramString, int paramInt);
  
  public abstract byte receiveSharpVideoAck(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract byte receiveSharpVideoCall(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncf
 * JD-Core Version:    0.7.0.1
 */