import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class pxv
  extends bgod
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopMemberApiService> jdField_a_of_type_JavaLangRefWeakReference;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public pxv(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(bgoe parambgoe)
  {
    super.onCancel(parambgoe);
    Object localObject = parambgoe.a().getString("resId");
    parambgoe = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((rau)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (parambgoe != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 0);
        parambgoe.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion()) {
          QLog.d("ReadInJoySkinHelper", 4, "onCancel rsp:" + ((Bundle)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    Object localObject = parambgoe.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((rau)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (parambgoe.jdField_a_of_type_Int != 0) {
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
      ((Bundle)localObject).putInt("retCode", parambgoe.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putInt("rate", 0);
      localTroopMemberApiService.a(107, (Bundle)localObject);
    }
  }
  
  public void onProgress(bgoe parambgoe)
  {
    super.onProgress(parambgoe);
    Object localObject = parambgoe.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      int i = (int)(parambgoe.b * 100L / parambgoe.jdField_a_of_type_Long);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxv
 * JD-Core Version:    0.7.0.1
 */