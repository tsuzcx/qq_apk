import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class sie
  implements sht
{
  private String a = "SimplePreloadListener";
  
  public sie(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, shp paramshp) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, shp paramshp)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      urk.b(this.a, "download ignore because no mask pic url");
      return;
    }
    urk.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, shp paramshp)
  {
    paramString = ((sqd)sqg.a(5)).a(paramString);
    if (paramString != null) {
      shq.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void a(String paramString, int paramInt, shp paramshp) {}
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, shp paramshp)
  {
    urk.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, sfm.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((sqd)sqg.a(5)).a(paramString);
    if (paramString != null) {
      shq.a(paramString, paramFile.getAbsolutePath(), paramInt1, urp.a(BaseApplicationImpl.getContext()));
    }
  }
  
  public void b(String paramString, int paramInt, shp paramshp)
  {
    urk.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sie
 * JD-Core Version:    0.7.0.1
 */