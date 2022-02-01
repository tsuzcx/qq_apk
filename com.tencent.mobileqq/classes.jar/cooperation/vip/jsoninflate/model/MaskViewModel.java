package cooperation.vip.jsoninflate.model;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

public class MaskViewModel
  extends ImageViewModel
{
  public MaskViewModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  protected void a(String paramString)
  {
    ((ImageView)this.h).setBackgroundColor(Color.parseColor(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.MaskViewModel
 * JD-Core Version:    0.7.0.1
 */