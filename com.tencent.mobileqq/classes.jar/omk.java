import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class omk
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rrp jdField_a_of_type_Rrp;
  private List<String> b = new ArrayList();
  
  public omk(Context paramContext, List<String> paramList1, List<String> paramList2, rrp paramrrp)
  {
    this.b = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Rrp = paramrrp;
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
    if ((paramViewHolder instanceof omm))
    {
      paramViewHolder = (omm)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.b.size()))
      {
        String str1 = (String)this.b.get(paramInt);
        String str2 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewHolder.a.setText(str1);
        paramViewHolder.a.setOnClickListener(new oml(this, str2, str1));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new omm(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559889, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     omk
 * JD-Core Version:    0.7.0.1
 */