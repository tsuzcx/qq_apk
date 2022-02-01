import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class mvt
  extends RecyclerView.Adapter<mvu>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<mwy> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public mvt(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public mvu a(ViewGroup paramViewGroup, int paramInt)
  {
    return new mvu(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558709, paramViewGroup, false));
  }
  
  public mwy a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (mwy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<mwy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(mvu parammvu, int paramInt)
  {
    mwy localmwy = a(paramInt);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramInt == 3) || (paramInt == 6))
    {
      localLayoutParams = (RecyclerView.LayoutParams)parammvu.itemView.getLayoutParams();
      localLayoutParams.leftMargin = afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      parammvu.itemView.setLayoutParams(localLayoutParams);
      if ((localmwy == null) || (!localmwy.a())) {
        break label163;
      }
      mvu.a(parammvu).setText("" + localmwy.a());
      mvu.a(parammvu).setVisibility(0);
      parammvu.itemView.setTag(localmwy);
      mvu.a(parammvu).setVisibility(4);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parammvu, paramInt, getItemId(paramInt));
      return;
      localLayoutParams = (RecyclerView.LayoutParams)parammvu.itemView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      parammvu.itemView.setLayoutParams(localLayoutParams);
      break;
      label163:
      mvu.a(parammvu).setVisibility(8);
      mvu.a(parammvu).setImageResource(2130845231);
      mvu.a(parammvu).setVisibility(0);
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
 * Qualified Name:     mvt
 * JD-Core Version:    0.7.0.1
 */