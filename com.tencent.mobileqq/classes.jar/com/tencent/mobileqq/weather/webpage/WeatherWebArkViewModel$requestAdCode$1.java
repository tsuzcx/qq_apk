package com.tencent.mobileqq.weather.webpage;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/webpage/WeatherWebArkViewModel$requestAdCode$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "i", "", "strings", "", "", "ints", "", "(I[Ljava/lang/String;[I)V", "grant", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class WeatherWebArkViewModel$requestAdCode$1
  implements QQPermissionCallback
{
  WeatherWebArkViewModel$requestAdCode$1(AppActivity paramAppActivity, String paramString) {}
  
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode deny");
    if (TextUtils.isEmpty((CharSequence)this.c)) {
      this.a.a().postValue(new WebPageData(3, null, null, null, 0, 0, 62, null));
    }
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode grant");
    this.a.b(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebArkViewModel.requestAdCode.1
 * JD-Core Version:    0.7.0.1
 */