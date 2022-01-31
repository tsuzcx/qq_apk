package cooperation.qwallet.plugin.ipc;

import java.io.Serializable;

public class QWalletRedTouchInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String buffer;
  public String imageRedContent;
  public String imageRedDesc;
  public String path;
  public int type;
  
  public QWalletRedTouchInfo(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.path = paramString1;
    this.type = paramInt;
    this.buffer = paramString2;
    this.imageRedDesc = paramString3;
    this.imageRedContent = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo
 * JD-Core Version:    0.7.0.1
 */