import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class sva
  implements sup
{
  private String a = "SimplePreloadListener";
  
  public sva(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, sul paramsul) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, sul paramsul)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      veg.b(this.a, "download ignore because no mask pic url");
      return;
    }
    veg.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, sul paramsul)
  {
    paramString = ((tcz)tdc.a(5)).a(paramString);
    if (paramString != null) {
      sum.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, sul paramsul) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, sul paramsul)
  {
    veg.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, ssi.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((tcz)tdc.a(5)).a(paramString);
    if (paramString != null) {
      sum.a(paramString, paramFile.getAbsolutePath(), paramInt1, vel.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, sul paramsul)
  {
    veg.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sva
 * JD-Core Version:    0.7.0.1
 */