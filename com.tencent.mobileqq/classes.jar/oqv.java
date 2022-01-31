import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class oqv
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private sic jdField_a_of_type_Sic;
  private List<String> b = new ArrayList();
  
  public oqv(Context paramContext, List<String> paramList1, List<String> paramList2, sic paramsic)
  {
    this.b = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sic = paramsic;
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
    if ((paramViewHolder instanceof oqx))
    {
      paramViewHolder = (oqx)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.b.size()))
      {
        String str1 = (String)this.b.get(paramInt);
        String str2 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewHolder.a.setText(str1);
        paramViewHolder.a.setOnClickListener(new oqw(this, str2, str1));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new oqx(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559985, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oqv
 * JD-Core Version:    0.7.0.1
 */