import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.widget.HorizontalLabelLayout;

public class spr
  implements spj
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.r)
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
  
  public spi a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
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
      return new spv(this, localLayoutInflater.inflate(2131560179, paramViewGroup, false), paramBaseData);
    case 8: 
      return new spt(this, localLayoutInflater.inflate(2131560176, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = agej.a(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new sps(this, paramViewGroup, paramBaseData);
    }
    return new spu(this, localLayoutInflater.inflate(2131560099, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.r == 7) || (paramBaseData.r == 8) || (paramBaseData.r == 13) || (paramBaseData.r == 14) || (paramBaseData.r == 15) || (paramBaseData.r == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spr
 * JD-Core Version:    0.7.0.1
 */