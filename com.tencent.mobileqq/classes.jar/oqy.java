import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class oqy
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pgj> jdField_a_of_type_JavaUtilList = new ArrayList();
  sib jdField_a_of_type_Sib;
  private List<pgj> b = new ArrayList();
  
  public oqy(Context paramContext, List<pgj> paramList1, List<pgj> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pgj parampgj)
  {
    if (paramInt == 0) {
      bkbq.a("readinjoy_show_recommend_reason_in_title_b", parampgj.c);
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
    orb localorb = (orb)paramViewHolder;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      paramViewHolder = (pgj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localorb.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localorb.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.b);
      localorb.b.setText(paramViewHolder.d);
      localorb.itemView.setOnClickListener(new oqz(this, localorb, paramViewHolder, paramInt));
      return;
      paramViewHolder = (pgj)this.b.get(paramInt);
      localorb.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new orb(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560047, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqy
 * JD-Core Version:    0.7.0.1
 */