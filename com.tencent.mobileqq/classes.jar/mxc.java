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

public class mxc
  extends RecyclerView.Adapter<mxd>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<myi> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public mxc(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public mxd a(ViewGroup paramViewGroup, int paramInt)
  {
    return new mxd(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558716, paramViewGroup, false));
  }
  
  public myi a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (myi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<myi> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(mxd parammxd, int paramInt)
  {
    myi localmyi = a(paramInt);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramInt == 3) || (paramInt == 6))
    {
      localLayoutParams = (RecyclerView.LayoutParams)parammxd.itemView.getLayoutParams();
      localLayoutParams.leftMargin = AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      parammxd.itemView.setLayoutParams(localLayoutParams);
      if ((localmyi == null) || (!localmyi.a())) {
        break label163;
      }
      mxd.a(parammxd).setText("" + localmyi.a());
      mxd.a(parammxd).setVisibility(0);
      parammxd.itemView.setTag(localmyi);
      mxd.a(parammxd).setVisibility(4);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parammxd, paramInt, getItemId(paramInt));
      return;
      localLayoutParams = (RecyclerView.LayoutParams)parammxd.itemView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      parammxd.itemView.setLayoutParams(localLayoutParams);
      break;
      label163:
      mxd.a(parammxd).setVisibility(8);
      mxd.a(parammxd).setImageResource(2130845133);
      mxd.a(parammxd).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxc
 * JD-Core Version:    0.7.0.1
 */