import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.4;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.5;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.6;
import com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.7;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class svb
  implements sue
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, sul> jdField_a_of_type_JavaUtilMap = new HashMap();
  private suc jdField_a_of_type_Suc = new suc();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, svc paramsvc)
  {
    if (paramsvc == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramsvc, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, svc paramsvc)
  {
    if (paramsvc == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramsvc, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, svc paramsvc)
  {
    if (paramsvc == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramsvc, paramString, paramInt));
  }
  
  private void b(sul paramsul, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    veg.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramsul.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramsul.jdField_b_of_type_Int = 3;
      ((sto)tdc.a(28)).b(paramsul.jdField_b_of_type_JavaLangString, paramsul.jdField_a_of_type_Int);
      paramErrorMessage = ((tcz)tdc.a(5)).a(paramsul.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        sum.a(paramErrorMessage, paramsul.e, paramsul.jdField_a_of_type_Int, vel.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramsul.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof svc))) {
        a(paramsul.jdField_b_of_type_JavaLangString, paramsul.jdField_a_of_type_Int, (svc)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramsul.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof svc)));
    a(paramsul.jdField_b_of_type_JavaLangString, paramsul.jdField_a_of_type_Int, paramErrorMessage, (svc)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, svc paramsvc)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramsvc, paramBoolean));
  }
  
  public void a(sul paramsul, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramsul, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */