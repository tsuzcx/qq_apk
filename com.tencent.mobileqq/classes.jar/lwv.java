import android.os.Bundle;
import android.os.IInterface;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvMsg;

public abstract interface lwv
  extends IInterface
{
  public abstract Bundle a(String paramString, int paramInt1, int paramInt2, Bundle paramBundle);
  
  public abstract void a(RecvMsg paramRecvMsg);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract void a(String paramString, int paramInt, byte[] paramArrayOfByte);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3);
  
  public abstract void a(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lwv
 * JD-Core Version:    0.7.0.1
 */