import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class pch
  extends bbwf
{
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<TroopMemberApiService> jdField_a_of_type_JavaLangRefWeakReference;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public pch(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(bbwg parambbwg)
  {
    super.onCancel(parambbwg);
    Object localObject = parambbwg.a().getString("resId");
    parambbwg = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((pzi)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (parambbwg != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("rate", 0);
        parambbwg.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion()) {
          QLog.d("ReadInJoySkinHelper", 4, "onCancel rsp:" + ((Bundle)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    Object localObject = parambbwg.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString))
    {
      ((pzi)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (parambbwg.jdField_a_of_type_Int != 0) {
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
      ((Bundle)localObject).putInt("retCode", parambbwg.jdField_a_of_type_Int);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putInt("rate", 0);
      localTroopMemberApiService.a(107, (Bundle)localObject);
    }
  }
  
  public void onProgress(bbwg parambbwg)
  {
    super.onProgress(parambbwg);
    Object localObject = parambbwg.a().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((TextUtils.equals((CharSequence)localObject, this.jdField_a_of_type_JavaLangString)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.jdField_a_of_type_AndroidOsBundle.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.jdField_a_of_type_JavaLangString);
      int i = (int)(parambbwg.b * 100L / parambbwg.jdField_a_of_type_Long);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pch
 * JD-Core Version:    0.7.0.1
 */