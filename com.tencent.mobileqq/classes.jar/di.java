import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.List;

public class di
  extends dj
{
  public boolean a(List<FileInfo> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramString != null))
    {
      ((ansr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a((ArrayList)paramList, "printer", paramString.getBytes(), Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     di
 * JD-Core Version:    0.7.0.1
 */