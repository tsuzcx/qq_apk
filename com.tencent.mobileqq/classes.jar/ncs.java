import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ncs
  extends RecyclerView.Adapter<nct>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<ndu> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ncs(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public nct a(ViewGroup paramViewGroup, int paramInt)
  {
    return new nct(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558728, paramViewGroup, false));
  }
  
  public ndu a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (ndu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<ndu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(nct paramnct, int paramInt)
  {
    ndu localndu = a(paramInt);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramInt == 3) || (paramInt == 6))
    {
      localLayoutParams = (RecyclerView.LayoutParams)paramnct.itemView.getLayoutParams();
      localLayoutParams.leftMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramnct.itemView.setLayoutParams(localLayoutParams);
      if ((localndu == null) || (!localndu.a())) {
        break label163;
      }
      nct.a(paramnct).setText("" + localndu.a());
      nct.a(paramnct).setVisibility(0);
      paramnct.itemView.setTag(localndu);
      nct.a(paramnct).setVisibility(4);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramnct, paramInt, getItemId(paramInt));
      return;
      localLayoutParams = (RecyclerView.LayoutParams)paramnct.itemView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      paramnct.itemView.setLayoutParams(localLayoutParams);
      break;
      label163:
      nct.a(paramnct).setVisibility(8);
      nct.a(paramnct).setImageResource(2130845207);
      nct.a(paramnct).setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncs
 * JD-Core Version:    0.7.0.1
 */