package cooperation.vip.jsoninflate.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import cooperation.vip.jsoninflate.model.ImageViewModel;
import cooperation.vip.jsoninflate.model.LottieViewModel;
import cooperation.vip.jsoninflate.model.MaskViewModel;
import cooperation.vip.jsoninflate.model.RelativeLayoutModel;
import cooperation.vip.jsoninflate.model.TextViewModel;
import cooperation.vip.jsoninflate.model.ViewModel;
import org.json.JSONObject;

public class JsonInflaterFactory
{
  public View a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new TextView(paramContext);
      }
      if ("image_view".equals(paramString)) {
        return new ImageView(paramContext);
      }
      if ("layout".equals(paramString)) {
        return new RelativeLayout(paramContext);
      }
      if ("lottie_view".equals(paramString)) {
        return new DiniFlyAnimationView(paramContext);
      }
    } while (!"mask_view".equals(paramString));
    return new ImageView(paramContext);
  }
  
  public ViewModel a(View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {
      return null;
    }
    if (RelativeLayout.class.isInstance(paramView)) {
      return new RelativeLayoutModel("layout", paramView);
    }
    return new ViewModel(paramView);
  }
  
  public ViewModel a(String paramString, View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new TextViewModel(paramString, paramView);
      }
      if ("image_view".equals(paramString)) {
        return new ImageViewModel(paramString, paramView);
      }
      if ("layout".equals(paramString)) {
        return new RelativeLayoutModel(paramString, paramView);
      }
      if ("lottie_view".equals(paramString)) {
        return new LottieViewModel(paramString, paramView);
      }
    } while (!"mask_view".equals(paramString));
    return new MaskViewModel(paramString, paramView);
  }
  
  public void a(ViewModel paramViewModel, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.util.JsonInflaterFactory
 * JD-Core Version:    0.7.0.1
 */