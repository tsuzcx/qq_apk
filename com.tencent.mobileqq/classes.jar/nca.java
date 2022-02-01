public abstract interface nca
  extends nbu
{
  public abstract byte[] getConfigInfoFromFile();
  
  public abstract String getSharpConfigPayloadFromFile();
  
  public abstract int getSharpConfigVersionFromFile();
  
  public abstract void onReceiveAudio(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nca
 * JD-Core Version:    0.7.0.1
 */