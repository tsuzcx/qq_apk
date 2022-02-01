import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class pae
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pvw> jdField_a_of_type_JavaUtilList = new ArrayList();
  tbm jdField_a_of_type_Tbm;
  private List<pvw> b = new ArrayList();
  
  public pae(Context paramContext, List<pvw> paramList1, List<pvw> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pvw parampvw)
  {
    if (paramInt == 0) {
      bkwm.a("readinjoy_show_recommend_reason_in_title_b", parampvw.c);
    }
  }
  
  public int getItemCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (this.b != null) {
        j = this.b.size();
      }
      return i + 0 + j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    pah localpah = (pah)paramViewHolder;
    pvw localpvw;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      localpvw = (pvw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localpah.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localpah.jdField_a_of_type_AndroidWidgetTextView.setText(localpvw.b);
      localpah.b.setText(localpvw.d);
      localpah.itemView.setOnClickListener(new paf(this, localpah, localpvw, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localpvw = (pvw)this.b.get(paramInt);
      localpah.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new pah(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560213, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pae
 * JD-Core Version:    0.7.0.1
 */