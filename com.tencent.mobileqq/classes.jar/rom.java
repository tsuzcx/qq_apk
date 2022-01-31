import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class rom
  extends ajmm
{
  rom(rol paramrol) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onUpdateSendMsgError->uin:" + paramString1 + ", type:" + paramInt1 + ", uniseq:" + paramLong2 + ", errorCode:" + paramInt2);
    }
    rol.a(this.a, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderManager", 2, "onSendResult->puin:" + paramString + ", isSuccess:" + paramBoolean);
    }
    rol.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rom
 * JD-Core Version:    0.7.0.1
 */