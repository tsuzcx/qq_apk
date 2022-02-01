import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class pjn
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<qhc> jdField_a_of_type_JavaUtilList = new ArrayList();
  tox jdField_a_of_type_Tox;
  private List<qhc> b = new ArrayList();
  
  public pjn(Context paramContext, List<qhc> paramList1, List<qhc> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, qhc paramqhc)
  {
    if (paramInt == 0) {
      bmhv.a("readinjoy_show_recommend_reason_in_title_b", paramqhc.c);
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
    pjq localpjq = (pjq)paramViewHolder;
    qhc localqhc;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      localqhc = (qhc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localpjq.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localpjq.jdField_a_of_type_AndroidWidgetTextView.setText(localqhc.b);
      localpjq.b.setText(localqhc.d);
      localpjq.itemView.setOnClickListener(new pjo(this, localpjq, localqhc, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localqhc = (qhc)this.b.get(paramInt);
      localpjq.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new pjq(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560259, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */