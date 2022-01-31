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

public class suy
  implements sub
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, sui> jdField_a_of_type_JavaUtilMap = new HashMap();
  private stz jdField_a_of_type_Stz = new stz();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, suz paramsuz)
  {
    if (paramsuz == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramsuz, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, suz paramsuz)
  {
    if (paramsuz == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramsuz, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, suz paramsuz)
  {
    if (paramsuz == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramsuz, paramString, paramInt));
  }
  
  private void b(sui paramsui, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    ved.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramsui.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramsui.jdField_b_of_type_Int = 3;
      ((stl)tcz.a(28)).b(paramsui.jdField_b_of_type_JavaLangString, paramsui.jdField_a_of_type_Int);
      paramErrorMessage = ((tcw)tcz.a(5)).a(paramsui.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        suj.a(paramErrorMessage, paramsui.e, paramsui.jdField_a_of_type_Int, vei.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramsui.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof suz))) {
        a(paramsui.jdField_b_of_type_JavaLangString, paramsui.jdField_a_of_type_Int, (suz)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramsui.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof suz)));
    a(paramsui.jdField_b_of_type_JavaLangString, paramsui.jdField_a_of_type_Int, paramErrorMessage, (suz)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, suz paramsuz)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramsuz, paramBoolean));
  }
  
  public void a(sui paramsui, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramsui, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     suy
 * JD-Core Version:    0.7.0.1
 */