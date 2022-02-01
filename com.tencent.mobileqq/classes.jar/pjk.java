import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class pjk
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private toy jdField_a_of_type_Toy;
  private List<String> b = new ArrayList();
  
  public pjk(Context paramContext, List<String> paramList1, List<String> paramList2, toy paramtoy)
  {
    this.b = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Toy = paramtoy;
  }
  
  public int getItemCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof pjm))
    {
      pjm localpjm = (pjm)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.b.size()))
      {
        String str1 = (String)this.b.get(paramInt);
        String str2 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localpjm.a.setText(str1);
        localpjm.a.setOnClickListener(new pjl(this, str2, str1));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new pjm(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560197, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjk
 * JD-Core Version:    0.7.0.1
 */