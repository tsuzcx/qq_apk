package cooperation.qzone.push;

public class QzNotificationStruct
{
  public String actionUrl;
  public String notifyText;
  public int pushType;
  public String pushstatkey;
  public String roomId;
  public boolean showMsgContent;
  
  public QzNotificationStruct(String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, String paramString4)
  {
    this.roomId = paramString1;
    this.notifyText = paramString2;
    this.showMsgContent = paramBoolean;
    this.pushType = paramInt;
    this.actionUrl = paramString3;
    this.pushstatkey = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.push.QzNotificationStruct
 * JD-Core Version:    0.7.0.1
 */