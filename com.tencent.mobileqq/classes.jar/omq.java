import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class omq
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pbb> jdField_a_of_type_JavaUtilList = new ArrayList();
  rrr jdField_a_of_type_Rrr;
  private List<pbb> b = new ArrayList();
  
  public omq(Context paramContext, List<pbb> paramList1, List<pbb> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pbb parampbb)
  {
    if (paramInt == 0) {
      bhvh.a("readinjoy_show_recommend_reason_in_title_b", parampbb.c);
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
    omt localomt = (omt)paramViewHolder;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      paramViewHolder = (pbb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localomt.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localomt.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.b);
      localomt.b.setText(paramViewHolder.d);
      localomt.itemView.setOnClickListener(new omr(this, localomt, paramViewHolder, paramInt));
      return;
      paramViewHolder = (pbb)this.b.get(paramInt);
      localomt.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new omt(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559950, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omq
 * JD-Core Version:    0.7.0.1
 */