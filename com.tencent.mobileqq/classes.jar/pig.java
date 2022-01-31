import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class pig
  extends bdvu
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopMemberApiService> jdField_a_of_type_JavaLangRefWeakReference;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public pig(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(bdvv parambdvv)
  {
    super.onCancel(parambdvv);
    Object localObject = parambdvv.a().getString("resId");
    parambdvv = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((qja)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (parambdvv != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 0);
        parambdvv.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion()) {
          QLog.d("ReadInJoySkinHelper", 4, "onCancel rsp:" + ((Bundle)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    Object localObject = parambdvv.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((qja)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (parambdvv.jdField_a_of_type_Int != 0) {
          break label169;
        }
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", 0);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 100);
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("ReadInJoySkinHelper", 4, "onDone rsp:" + ((Bundle)localObject).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "SkinDownloadListener onDone");
      }
      return;
      label169:
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", parambdvv.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putInt("rate", 0);
      localTroopMemberApiService.a(107, (Bundle)localObject);
    }
  }
  
  public void onProgress(bdvv parambdvv)
  {
    super.onProgress(parambdvv);
    Object localObject = parambdvv.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      int i = (int)(parambdvv.b * 100L / parambdvv.jdField_a_of_type_Long);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pig
 * JD-Core Version:    0.7.0.1
 */