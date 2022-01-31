import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class nwb
  implements ViewBase.OnClickListener
{
  nwb(nvz paramnvz) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (paramViewBase.getEventAttachedData() == null) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramViewBase.getEventAttachedData()));
    paramViewBase.getNativeView().getContext().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwb
 * JD-Core Version:    0.7.0.1
 */