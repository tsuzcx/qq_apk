import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class nfb
  extends RecyclerView.Adapter<nfe>
{
  private List<myi> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  
  public nfb(List<myi> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public myi a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (myi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public nfe a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558726, paramViewGroup, false);
    return new nfe(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131363145), (ImageView)paramViewGroup.findViewById(2131363146), (TextView)paramViewGroup.findViewById(2131363147));
  }
  
  public void a(nfe paramnfe, int paramInt)
  {
    myi localmyi = a(paramInt);
    paramnfe.jdField_a_of_type_Myi = localmyi;
    new.a(localmyi.c, paramnfe.jdField_a_of_type_AndroidWidgetImageView);
    if ((localmyi.b != null) && (localmyi.b.length() > 0)) {
      new.a(localmyi.b, paramnfe.b);
    }
    for (;;)
    {
      paramnfe.itemView.setOnClickListener(new nfc(this, localmyi));
      paramnfe.itemView.setOnTouchListener(new nfd(this));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramnfe, paramInt, getItemId(paramInt));
      return;
      paramnfe.jdField_a_of_type_AndroidWidgetTextView.setText(localmyi.a);
      paramnfe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfb
 * JD-Core Version:    0.7.0.1
 */