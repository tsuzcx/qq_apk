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

public class mws
  extends RecyclerView.Adapter<mwt>
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<mxx> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public mws(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public mwt a(ViewGroup paramViewGroup, int paramInt)
  {
    return new mwt(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558711, paramViewGroup, false));
  }
  
  public mxx a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (mxx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(List<mxx> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(mwt parammwt, int paramInt)
  {
    mxx localmxx = a(paramInt);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramInt == 3) || (paramInt == 6))
    {
      localLayoutParams = (RecyclerView.LayoutParams)parammwt.itemView.getLayoutParams();
      localLayoutParams.leftMargin = agej.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      parammwt.itemView.setLayoutParams(localLayoutParams);
      if ((localmxx == null) || (!localmxx.a())) {
        break label163;
      }
      mwt.a(parammwt).setText("" + localmxx.a());
      mwt.a(parammwt).setVisibility(0);
      parammwt.itemView.setTag(localmxx);
      mwt.a(parammwt).setVisibility(4);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(parammwt, paramInt, getItemId(paramInt));
      return;
      localLayoutParams = (RecyclerView.LayoutParams)parammwt.itemView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      parammwt.itemView.setLayoutParams(localLayoutParams);
      break;
      label163:
      mwt.a(parammwt).setVisibility(8);
      mwt.a(parammwt).setImageResource(2130845246);
      mwt.a(parammwt).setVisibility(0);
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
 * Qualified Name:     mws
 * JD-Core Version:    0.7.0.1
 */