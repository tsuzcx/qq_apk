import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class obf
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<oqa> jdField_a_of_type_JavaUtilList = new ArrayList();
  rfb jdField_a_of_type_Rfb;
  private List<oqa> b = new ArrayList();
  
  public obf(Context paramContext, List<oqa> paramList1, List<oqa> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, oqa paramoqa)
  {
    if (paramInt == 0) {
      bgmq.a("readinjoy_show_recommend_reason_in_title_b", paramoqa.c);
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
    obi localobi = (obi)paramViewHolder;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      paramViewHolder = (oqa)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localobi.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localobi.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.b);
      localobi.b.setText(paramViewHolder.d);
      localobi.itemView.setOnClickListener(new obg(this, localobi, paramViewHolder, paramInt));
      return;
      paramViewHolder = (oqa)this.b.get(paramInt);
      localobi.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new obi(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131494380, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     obf
 * JD-Core Version:    0.7.0.1
 */