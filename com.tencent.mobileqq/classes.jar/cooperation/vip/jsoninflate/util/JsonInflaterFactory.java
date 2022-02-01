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
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
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
      if ("mask_view".equals(paramString)) {
        return new ImageView(paramContext);
      }
    }
    return null;
  }
  
  public ViewModel a(View paramView)
  {
    if ((paramView != null) && (paramView.getClass() != null))
    {
      if (RelativeLayout.class.isInstance(paramView)) {
        return new RelativeLayoutModel("layout", paramView);
      }
      return new ViewModel(paramView);
    }
    return null;
  }
  
  public ViewModel a(String paramString, View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      if (paramView.getClass() == null) {
        return null;
      }
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
      localObject1 = localObject2;
      if ("mask_view".equals(paramString)) {
        localObject1 = new MaskViewModel(paramString, paramView);
      }
    }
    return localObject1;
  }
  
  public void a(ViewModel paramViewModel, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.util.JsonInflaterFactory
 * JD-Core Version:    0.7.0.1
 */