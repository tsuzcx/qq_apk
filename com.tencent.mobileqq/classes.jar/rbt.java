import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.OnGetAppInfo;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Map;

public class rbt
  extends SimpleObserver
{
  public rbt(DefaultDoraemonAppInfoHelper paramDefaultDoraemonAppInfoHelper, String paramString, DefaultDoraemonAppInfoHelper.OnGetAppInfo paramOnGetAppInfo) {}
  
  public void a(rbv paramrbv)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper.b.put(this.jdField_a_of_type_JavaLangString, paramrbv);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo.a(paramrbv.a);
  }
  
  public void onError(@NonNull Error paramError)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplDefaultDoraemonAppInfoHelper$OnGetAppInfo.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbt
 * JD-Core Version:    0.7.0.1
 */