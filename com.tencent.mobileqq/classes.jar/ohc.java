import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import org.json.JSONObject;

final class ohc
  implements ViewFactory.FoundClickableViewListener
{
  ohc(String paramString, JSONObject paramJSONObject) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      paramViewBase.setOnClickListener(new ohe(this));
      return;
    }
    paramViewBase.setOnClickListener(new ohd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohc
 * JD-Core Version:    0.7.0.1
 */