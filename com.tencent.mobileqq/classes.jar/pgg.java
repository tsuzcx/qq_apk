import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class pgg
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pxs> jdField_a_of_type_JavaUtilList = new ArrayList();
  tgs jdField_a_of_type_Tgs;
  private List<pxs> b = new ArrayList();
  
  public pgg(Context paramContext, List<pxs> paramList1, List<pxs> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pxs parampxs)
  {
    if (paramInt == 0) {
      bmqa.a("readinjoy_show_recommend_reason_in_title_b", parampxs.c);
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
    pgj localpgj = (pgj)paramViewHolder;
    pxs localpxs;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      localpxs = (pxs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localpgj.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localpgj.jdField_a_of_type_AndroidWidgetTextView.setText(localpxs.b);
      localpgj.b.setText(localpxs.d);
      localpgj.itemView.setOnClickListener(new pgh(this, localpgj, localpxs, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localpxs = (pxs)this.b.get(paramInt);
      localpgj.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new pgj(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560194, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */