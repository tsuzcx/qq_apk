import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.OnGetAppInfo;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

public class rek
  extends SimpleObserver
{
  public rek(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, String paramString, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo) {}
  
  public void a(rem paramrem)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper.b.put(this.jdField_a_of_type_JavaLangString, paramrem);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo.a(paramrem.a);
  }
  
  public void onError(@NonNull Error paramError)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rek
 * JD-Core Version:    0.7.0.1
 */