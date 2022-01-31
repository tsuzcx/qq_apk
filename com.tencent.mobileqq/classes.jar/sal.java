import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.widget.HorizontalLabelLayout;

public class sal
  implements sai
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.s)
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
  
  public sah a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
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
      return new sap(this, localLayoutInflater.inflate(2131560020, paramViewGroup, false), paramBaseData);
    case 8: 
      return new san(this, localLayoutInflater.inflate(2131560017, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = aepi.a(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new sam(this, paramViewGroup, paramBaseData);
    }
    return new sao(this, localLayoutInflater.inflate(2131559939, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.s == 7) || (paramBaseData.s == 8) || (paramBaseData.s == 13) || (paramBaseData.s == 14) || (paramBaseData.s == 15) || (paramBaseData.s == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sal
 * JD-Core Version:    0.7.0.1
 */