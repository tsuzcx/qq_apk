import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class orf
  extends batl
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopMemberApiService> jdField_a_of_type_JavaLangRefWeakReference;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public orf(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(batm parambatm)
  {
    super.onCancel(parambatm);
    Object localObject = parambatm.a().getString("resId");
    parambatm = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((pnn)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (parambatm != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 0);
        parambatm.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion()) {
          QLog.d("ReadInJoySkinHelper", 4, "onCancel rsp:" + ((Bundle)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    Object localObject = parambatm.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((pnn)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (parambatm.jdField_a_of_type_Int != 0) {
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
      ((Bundle)localObject).putInt("retCode", parambatm.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putInt("rate", 0);
      localTroopMemberApiService.a(107, (Bundle)localObject);
    }
  }
  
  public void onProgress(batm parambatm)
  {
    super.onProgress(parambatm);
    Object localObject = parambatm.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      int i = (int)(parambatm.b * 100L / parambatm.jdField_a_of_type_Long);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */