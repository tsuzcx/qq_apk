import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ngv
  extends RecyclerView.Adapter<ngy>
{
  private List<mzl> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  
  public ngv(List<mzl> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public mzl a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (mzl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public ngy a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558727, paramViewGroup, false);
    return new ngy(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131363168), (ImageView)paramViewGroup.findViewById(2131363169), (TextView)paramViewGroup.findViewById(2131363170));
  }
  
  public void a(ngy paramngy, int paramInt)
  {
    mzl localmzl = a(paramInt);
    paramngy.jdField_a_of_type_Mzl = localmzl;
    ngq.a(localmzl.c, paramngy.jdField_a_of_type_AndroidWidgetImageView);
    if ((localmzl.b != null) && (localmzl.b.length() > 0)) {
      ngq.a(localmzl.b, paramngy.b);
    }
    for (;;)
    {
      paramngy.itemView.setOnClickListener(new ngw(this, localmzl));
      paramngy.itemView.setOnTouchListener(new ngx(this));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramngy, paramInt, getItemId(paramInt));
      return;
      paramngy.jdField_a_of_type_AndroidWidgetTextView.setText(localmzl.a);
      paramngy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngv
 * JD-Core Version:    0.7.0.1
 */