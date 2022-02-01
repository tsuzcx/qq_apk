import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.biz.pubaccount.readinjoy.reward.utils.RIJRewardTaskPrefHelper.sp.2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/utils/RIJRewardTaskPrefHelper;", "", "()V", "CONTENT_TYPE", "", "MAX_TIME_IN_MS", "RECORD_TIME_IN_MS", "ROW_KEY", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "configKey", "key", "restoreFromSp", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "saveToSp", "", "task", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rlr
{
  private static final Lazy a;
  public static final rlr a;
  
  static
  {
    jdField_a_of_type_Rlr = new rlr();
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)RIJRewardTaskPrefHelper.sp.2.INSTANCE);
  }
  
  private final SharedPreferences a()
  {
    return (SharedPreferences)jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @JvmStatic
  @Nullable
  public static final RIJRewardTask a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    String str3 = a(paramString) + "_ROW_KEY";
    String str1 = a(paramString) + "_CONTENT_TYPE";
    String str2 = a(paramString) + "_MAX_TIME_IN_MS";
    paramString = a(paramString) + "_RECORD_TIME_IN_MS";
    str3 = jdField_a_of_type_Rlr.a().getString(str3, "");
    int j = jdField_a_of_type_Rlr.a().getInt(str1, 0);
    int k = jdField_a_of_type_Rlr.a().getInt(str2, 0);
    int m = jdField_a_of_type_Rlr.a().getInt(paramString, 0);
    paramString = (CharSequence)str3;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    return new RIJRewardTask(str3, j, k, m);
  }
  
  @JvmStatic
  @NotNull
  public static final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return paramString + pkh.a();
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString, @Nullable RIJRewardTask paramRIJRewardTask)
  {
    int j = 0;
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    String str4 = a(paramString) + "_ROW_KEY";
    String str3 = a(paramString) + "_CONTENT_TYPE";
    String str1 = a(paramString) + "_MAX_TIME_IN_MS";
    String str2 = a(paramString) + "_RECORD_TIME_IN_MS";
    SharedPreferences.Editor localEditor = jdField_a_of_type_Rlr.a().edit();
    if (paramRIJRewardTask != null)
    {
      paramString = paramRIJRewardTask.a();
      if (paramString != null)
      {
        paramString = localEditor.putString(str4, paramString);
        if (paramRIJRewardTask == null) {
          break label211;
        }
        i = paramRIJRewardTask.a();
        label150:
        paramString = paramString.putInt(str3, i);
        if (paramRIJRewardTask == null) {
          break label216;
        }
      }
    }
    label211:
    label216:
    for (int i = paramRIJRewardTask.b();; i = 0)
    {
      paramString = paramString.putInt(str1, i);
      i = j;
      if (paramRIJRewardTask != null) {
        i = paramRIJRewardTask.c();
      }
      paramString.putInt(str2, i).apply();
      return;
      paramString = "";
      break;
      i = 0;
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlr
 * JD-Core Version:    0.7.0.1
 */