import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nov
  extends RecyclerView.Adapter<noy>
{
  private List<ngc> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  
  public nov(List<ngc> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public ngc a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (ngc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public noy a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558751, paramViewGroup, false);
    return new noy(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131363203), (ImageView)paramViewGroup.findViewById(2131363204), (TextView)paramViewGroup.findViewById(2131363205));
  }
  
  public void a(noy paramnoy, int paramInt)
  {
    ngc localngc = a(paramInt);
    if (localngc == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramnoy, paramInt, getItemId(paramInt));
      return;
    }
    paramnoy.jdField_a_of_type_Ngc = localngc;
    noq.a(localngc.c, paramnoy.jdField_a_of_type_AndroidWidgetImageView);
    if ((localngc.b != null) && (localngc.b.length() > 0)) {
      noq.a(localngc.b, paramnoy.b);
    }
    for (;;)
    {
      paramnoy.itemView.setOnClickListener(new now(this, localngc));
      paramnoy.itemView.setOnTouchListener(new nox(this));
      break;
      paramnoy.jdField_a_of_type_AndroidWidgetTextView.setText(localngc.a);
      paramnoy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nov
 * JD-Core Version:    0.7.0.1
 */