import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class sux
  implements sum
{
  private String a = "SimplePreloadListener";
  
  public sux(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, sui paramsui) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sui paramsui)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      ved.b(this.a, "download ignore because no mask pic url");
      return;
    }
    ved.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, sui paramsui)
  {
    paramString = ((tcw)tcz.a(5)).a(paramString);
    if (paramString != null) {
      suj.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, sui paramsui) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sui paramsui)
  {
    ved.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, ssf.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((tcw)tcz.a(5)).a(paramString);
    if (paramString != null) {
      suj.a(paramString, paramFile.getAbsolutePath(), paramInt1, vei.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, sui paramsui)
  {
    ved.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sux
 * JD-Core Version:    0.7.0.1
 */