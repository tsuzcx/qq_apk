import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;

public class mcl
{
  public static void a(String paramString)
  {
    bdll.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b(String paramString)
  {
    int i = 0;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof VideoAppInterface)) {
      i = ((VideoAppInterface)localObject).b("BEAUTY_SKIN");
    }
    if (i > 0) {}
    for (localObject = "0X80076B4";; localObject = "0X80076B3")
    {
      a((String)localObject);
      lbj.c("BeautyToolbar", "DataReport onUserBeauty:" + paramString + "|" + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcl
 * JD-Core Version:    0.7.0.1
 */