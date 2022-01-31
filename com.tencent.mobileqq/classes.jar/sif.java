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

public class sif
  implements shi
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Map<String, shp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private shg jdField_a_of_type_Shg = new shg();
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, sig paramsig)
  {
    if (paramsig == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.7(this, paramsig, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, sig paramsig)
  {
    if (paramsig == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.5(this, paramsig, paramString, paramInt));
  }
  
  private void b(String paramString, int paramInt, sig paramsig)
  {
    if (paramsig == null) {
      return;
    }
    this.b.post(new StorySingleFileDownloader.6(this, paramsig, paramString, paramInt));
  }
  
  private void b(shp paramshp, ErrorMessage paramErrorMessage)
  {
    int i = 1;
    urk.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { paramshp.jdField_a_of_type_JavaLangString, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0)
    {
      if (i == 0) {
        break label147;
      }
      paramshp.jdField_b_of_type_Int = 3;
      ((sgs)sqg.a(28)).b(paramshp.jdField_b_of_type_JavaLangString, paramshp.jdField_a_of_type_Int);
      paramErrorMessage = ((sqd)sqg.a(5)).a(paramshp.jdField_b_of_type_JavaLangString);
      if (paramErrorMessage != null) {
        shq.a(paramErrorMessage, paramshp.e, paramshp.jdField_a_of_type_Int, urp.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramshp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof sig))) {
        a(paramshp.jdField_b_of_type_JavaLangString, paramshp.jdField_a_of_type_Int, (sig)paramErrorMessage);
      }
    }
    label147:
    Object localObject;
    do
    {
      return;
      i = 0;
      break;
      localObject = paramshp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
    } while ((localObject == null) || (!(localObject instanceof sig)));
    a(paramshp.jdField_b_of_type_JavaLangString, paramshp.jdField_a_of_type_Int, paramErrorMessage, (sig)localObject);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, sig paramsig)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramsig, paramBoolean));
  }
  
  public void a(shp paramshp, ErrorMessage paramErrorMessage)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new StorySingleFileDownloader.4(this, paramshp, paramErrorMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sif
 * JD-Core Version:    0.7.0.1
 */