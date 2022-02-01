import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nic
  extends RecyclerView.Adapter<nif>
{
  private List<nam> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  
  public nic(List<nam> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public nam a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (nam)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public nif a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558735, paramViewGroup, false);
    return new nif(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131363184), (ImageView)paramViewGroup.findViewById(2131363185), (TextView)paramViewGroup.findViewById(2131363186));
  }
  
  public void a(nif paramnif, int paramInt)
  {
    nam localnam = a(paramInt);
    if (localnam == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramnif, paramInt, getItemId(paramInt));
      return;
    }
    paramnif.jdField_a_of_type_Nam = localnam;
    nhx.a(localnam.c, paramnif.jdField_a_of_type_AndroidWidgetImageView);
    if ((localnam.b != null) && (localnam.b.length() > 0)) {
      nhx.a(localnam.b, paramnif.b);
    }
    for (;;)
    {
      paramnif.itemView.setOnClickListener(new nid(this, localnam));
      paramnif.itemView.setOnTouchListener(new nie(this));
      break;
      paramnif.jdField_a_of_type_AndroidWidgetTextView.setText(localnam.a);
      paramnif.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nic
 * JD-Core Version:    0.7.0.1
 */