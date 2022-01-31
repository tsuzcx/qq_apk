import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class omn
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pay> jdField_a_of_type_JavaUtilList = new ArrayList();
  rro jdField_a_of_type_Rro;
  private List<pay> b = new ArrayList();
  
  public omn(Context paramContext, List<pay> paramList1, List<pay> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pay parampay)
  {
    if (paramInt == 0) {
      bhvy.a("readinjoy_show_recommend_reason_in_title_b", parampay.c);
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
    omq localomq = (omq)paramViewHolder;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      paramViewHolder = (pay)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localomq.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localomq.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.b);
      localomq.b.setText(paramViewHolder.d);
      localomq.itemView.setOnClickListener(new omo(this, localomq, paramViewHolder, paramInt));
      return;
      paramViewHolder = (pay)this.b.get(paramInt);
      localomq.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new omq(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559950, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omn
 * JD-Core Version:    0.7.0.1
 */