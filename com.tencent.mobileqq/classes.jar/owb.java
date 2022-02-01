import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController$init$1", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "onScrollViewItemExposureTriggered", "", "identifier", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "onTapEventTriggered", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owb
  extends DefaultPTSLiteEventListener
{
  owb(Context paramContext) {}
  
  public void onScrollViewItemExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView)
  {
    ovz localovz;
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("avatarStatus");
      paramView = ovz.a(this.jdField_a_of_type_Ovz);
      if (paramView != null)
      {
        localovz = this.jdField_a_of_type_Ovz;
        if (paramString == null) {
          break label50;
        }
      }
    }
    for (;;)
    {
      ovz.b(localovz, paramString, paramHashMap, paramView);
      return;
      paramHashMap = null;
      break;
      label50:
      paramString = "";
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView)
  {
    Object localObject = null;
    QLog.i("RIJChannelBannerController", 1, "[onTapEventTriggered], " + getLogString(paramString, paramHashMap));
    int i;
    if (paramHashMap != null)
    {
      paramView = (String)paramHashMap.get("jumpUrl");
      if (!TextUtils.isEmpty((CharSequence)paramView)) {
        pha.a(this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      paramView = (View)localObject;
      if (paramHashMap != null) {
        paramView = (String)paramHashMap.get("avatarStatus");
      }
      if (paramView == null) {
        break label204;
      }
      i = Integer.parseInt(paramView);
      label92:
      if (i == 2) {
        ovz.a(this.jdField_a_of_type_Ovz, paramString, 0);
      }
      localObject = ovz.a(this.jdField_a_of_type_Ovz);
      if (localObject != null)
      {
        paramHashMap = ovz.a(this.jdField_a_of_type_Ovz);
        if (paramHashMap == null) {
          break label210;
        }
        paramHashMap = paramHashMap.getJsonData();
        if (paramHashMap == null) {
          break label210;
        }
        label142:
        ((owd)localObject).c(paramHashMap);
      }
      paramHashMap = ovz.a(this.jdField_a_of_type_Ovz);
      if (paramHashMap != null) {
        ovz.a(this.jdField_a_of_type_Ovz, paramHashMap);
      }
      paramHashMap = ovz.a(this.jdField_a_of_type_Ovz);
      if (paramHashMap != null)
      {
        localObject = this.jdField_a_of_type_Ovz;
        if (paramString == null) {
          break label216;
        }
      }
    }
    for (;;)
    {
      ovz.a((ovz)localObject, paramString, paramView, paramHashMap);
      return;
      paramView = null;
      break;
      label204:
      i = 0;
      break label92;
      label210:
      paramHashMap = "";
      break label142;
      label216:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owb
 * JD-Core Version:    0.7.0.1
 */