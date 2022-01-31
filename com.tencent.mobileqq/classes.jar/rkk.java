import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.widget.HorizontalLabelLayout;

public class rkk
  implements rkh
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.p)
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
  
  public rkg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
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
      return new rko(this, localLayoutInflater.inflate(2131559922, paramViewGroup, false), paramBaseData);
    case 8: 
      return new rkm(this, localLayoutInflater.inflate(2131559919, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = actj.a(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new rkl(this, paramViewGroup, paramBaseData);
    }
    return new rkn(this, localLayoutInflater.inflate(2131559846, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.p == 7) || (paramBaseData.p == 8) || (paramBaseData.p == 13) || (paramBaseData.p == 14) || (paramBaseData.p == 15) || (paramBaseData.p == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkk
 * JD-Core Version:    0.7.0.1
 */