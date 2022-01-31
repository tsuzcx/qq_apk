import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import org.json.JSONObject;

final class nsm
  implements ViewFactory.FoundClickableViewListener
{
  nsm(String paramString, JSONObject paramJSONObject) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      paramViewBase.setOnClickListener(new nso(this));
      return;
    }
    paramViewBase.setOnClickListener(new nsn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsm
 * JD-Core Version:    0.7.0.1
 */