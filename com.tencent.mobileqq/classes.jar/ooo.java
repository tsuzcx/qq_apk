import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.lite.DefaultPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerController$init$1", "Lcom/tencent/pts/core/lite/DefaultPTSLiteEventListener;", "onScrollViewItemExposureTriggered", "", "identifier", "", "dataSet", "Ljava/util/HashMap;", "view", "Landroid/view/View;", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "onTapEventTriggered", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ooo
  extends DefaultPTSLiteEventListener
{
  ooo(Context paramContext) {}
  
  public void onScrollViewItemExposureTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    if (paramHashMap != null)
    {
      paramHashMap = (String)paramHashMap.get("avatarStatus");
      paramView = oom.a(this.jdField_a_of_type_Oom);
      if (paramView != null)
      {
        paramPTSComposer = this.jdField_a_of_type_Oom;
        if (paramString == null) {
          break label50;
        }
      }
    }
    for (;;)
    {
      oom.b(paramPTSComposer, paramString, paramHashMap, paramView);
      return;
      paramHashMap = null;
      break;
      label50:
      paramString = "";
    }
  }
  
  public void onTapEventTriggered(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap, @Nullable View paramView, @Nullable PTSComposer paramPTSComposer)
  {
    Object localObject = null;
    QLog.i("RIJChannelBannerController", 1, "[onTapEventTriggered], " + getLogString(paramString, paramHashMap));
    qgf.a.a(paramPTSComposer, paramHashMap);
    int i;
    if (paramHashMap != null)
    {
      paramView = (String)paramHashMap.get("jumpUrl");
      if (!TextUtils.isEmpty((CharSequence)paramView)) {
        ozs.a(this.jdField_a_of_type_AndroidContentContext, paramView);
      }
      paramView = localObject;
      if (paramHashMap != null) {
        paramView = (String)paramHashMap.get("avatarStatus");
      }
      if (paramView == null) {
        break label213;
      }
      i = Integer.parseInt(paramView);
      label101:
      if (i == 2) {
        oom.a(this.jdField_a_of_type_Oom, paramString, 0);
      }
      paramPTSComposer = oom.a(this.jdField_a_of_type_Oom);
      if (paramPTSComposer != null)
      {
        paramHashMap = oom.a(this.jdField_a_of_type_Oom);
        if (paramHashMap == null) {
          break label219;
        }
        paramHashMap = paramHashMap.getJsonData();
        if (paramHashMap == null) {
          break label219;
        }
        label151:
        paramPTSComposer.c(paramHashMap);
      }
      paramHashMap = oom.a(this.jdField_a_of_type_Oom);
      if (paramHashMap != null) {
        oom.a(this.jdField_a_of_type_Oom, paramHashMap);
      }
      paramHashMap = oom.a(this.jdField_a_of_type_Oom);
      if (paramHashMap != null)
      {
        paramPTSComposer = this.jdField_a_of_type_Oom;
        if (paramString == null) {
          break label225;
        }
      }
    }
    for (;;)
    {
      oom.a(paramPTSComposer, paramString, paramView, paramHashMap);
      return;
      paramView = null;
      break;
      label213:
      i = 0;
      break label101;
      label219:
      paramHashMap = "";
      break label151;
      label225:
      paramString = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooo
 * JD-Core Version:    0.7.0.1
 */