import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.widget.HorizontalLabelLayout;

public class sys
  implements syk
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.t)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
    case 13: 
      return 7;
    case 8: 
    case 14: 
      return 8;
    case 15: 
      return 13;
    }
    return 14;
  }
  
  public syj a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    switch (a(paramBaseData))
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
      return new syw(this, localLayoutInflater.inflate(2131560167, paramViewGroup, false), paramBaseData);
    case 8: 
      return new syu(this, localLayoutInflater.inflate(2131560164, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = afur.a(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new syt(this, paramViewGroup, paramBaseData);
    }
    return new syv(this, localLayoutInflater.inflate(2131560087, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.t == 7) || (paramBaseData.t == 8) || (paramBaseData.t == 13) || (paramBaseData.t == 14) || (paramBaseData.t == 15) || (paramBaseData.t == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sys
 * JD-Core Version:    0.7.0.1
 */