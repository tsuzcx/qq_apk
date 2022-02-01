package cooperation.vip.jsoninflate.model;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class RelativeLayoutModel
  extends ViewModel
{
  public RelativeLayoutModel(String paramString, View paramView)
  {
    super(paramString, paramView);
  }
  
  private int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ("center".equals(paramString)) {
        return 13;
      }
      if ("center_horizontal".equals(paramString)) {
        return 14;
      }
      if ("center_vertical".equals(paramString)) {
        return 15;
      }
      return 9;
    }
    paramString = new StringBuilder();
    paramString.append(getClass().getName());
    paramString.append(" setGravity value can not be null");
    throw new RuntimeException(paramString.toString());
  }
  
  protected ViewGroup.LayoutParams a(int paramInt1, int paramInt2)
  {
    return new RelativeLayout.LayoutParams(paramInt1, paramInt2);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!(this.h instanceof RelativeLayout)) {}
  }
  
  protected void a(String paramString1, String paramString2, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.a(paramString1, paramString2, paramLayoutParams);
    paramLayoutParams = (RelativeLayout.LayoutParams)paramLayoutParams;
    if ("gravity".equals(paramString1))
    {
      paramLayoutParams.addRule(a(paramString2));
      return;
    }
    if ("relative".equals(paramString1))
    {
      paramString1 = paramString2.split(" ");
      if ((paramString1 != null) && (paramString1.length == 2))
      {
        if ("bottom".equals(paramString1[1]))
        {
          paramLayoutParams.addRule(3, Integer.parseInt(paramString1[0]));
          paramLayoutParams.addRule(5, Integer.parseInt(paramString1[0]));
          return;
        }
        if ("right".equals(paramString1[1])) {
          paramLayoutParams.addRule(6, Integer.parseInt(paramString1[0]));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.RelativeLayoutModel
 * JD-Core Version:    0.7.0.1
 */