import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.HorizontalLabelLayout;

public class stp
  implements sth
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
  
  public stg a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
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
      return new stt(this, localLayoutInflater.inflate(2131560186, paramViewGroup, false), paramBaseData);
    case 8: 
      return new str(this, localLayoutInflater.inflate(2131560183, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = AIOUtils.dp2px(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new stq(this, paramViewGroup, paramBaseData);
    }
    return new sts(this, localLayoutInflater.inflate(2131560106, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.r == 7) || (paramBaseData.r == 8) || (paramBaseData.r == 13) || (paramBaseData.r == 14) || (paramBaseData.r == 15) || (paramBaseData.r == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stp
 * JD-Core Version:    0.7.0.1
 */