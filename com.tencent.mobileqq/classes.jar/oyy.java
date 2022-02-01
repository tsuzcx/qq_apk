import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class oyy
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<pqc> jdField_a_of_type_JavaUtilList = new ArrayList();
  sxm jdField_a_of_type_Sxm;
  private List<pqc> b = new ArrayList();
  
  public oyy(Context paramContext, List<pqc> paramList1, List<pqc> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, pqc parampqc)
  {
    if (paramInt == 0) {
      bnrf.a("readinjoy_show_recommend_reason_in_title_b", parampqc.c);
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
    ozb localozb = (ozb)paramViewHolder;
    pqc localpqc;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      localpqc = (pqc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localozb.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localozb.jdField_a_of_type_AndroidWidgetTextView.setText(localpqc.b);
      localozb.b.setText(localpqc.d);
      localozb.itemView.setOnClickListener(new oyz(this, localozb, localpqc, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localpqc = (pqc)this.b.get(paramInt);
      localozb.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ozb(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560206, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyy
 * JD-Core Version:    0.7.0.1
 */