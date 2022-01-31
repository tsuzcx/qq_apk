import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class src
  implements Runnable
{
  public src(EmosmActivity paramEmosmActivity, String paramString) {}
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((EmoticonManager)((QQAppInterface)localObject1).getManager(13)).a(this.jdField_a_of_type_JavaLangString);
        if ((localObject1 == null) || ((!((EmoticonTab)localObject1).aioHave) && (!((EmoticonTab)localObject1).kandianHave)))
        {
          Object localObject2 = AppConstants.bs + this.jdField_a_of_type_JavaLangString;
          localObject1 = new File((String)localObject2);
          localObject2 = new File((String)localObject2 + "del");
          if (!((File)localObject1).renameTo((File)localObject2)) {
            break label134;
          }
          FileUtils.a(((File)localObject2).getAbsolutePath());
        }
      }
      return;
      label134:
      FileUtils.a(((File)localObject1).getAbsolutePath());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     src
 * JD-Core Version:    0.7.0.1
 */