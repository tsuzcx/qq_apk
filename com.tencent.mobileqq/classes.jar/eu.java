import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.List;

public class eu
  extends ev
{
  public boolean a(List<FileInfo> paramList, String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramString != null))
    {
      ((ajum)paramQQAppInterface.a(8)).a((ArrayList)paramList, "printer", paramString.getBytes(), Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     eu
 * JD-Core Version:    0.7.0.1
 */