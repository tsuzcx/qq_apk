import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class soo<M, VH extends son<M>>
  extends RecyclerView.Adapter<son<M>>
{
  protected Context a;
  protected View a;
  protected sol a;
  protected som a;
  protected View b;
  
  public soo(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      i = 1;
    }
    int j = i;
    if (this.b != null) {
      j = i + 1;
    }
    return j;
  }
  
  public final son a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new son(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Sol != null) {
        paramViewGroup.itemView.setOnClickListener(new sop(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Som != null) {
        paramViewGroup.itemView.setOnLongClickListener(new soq(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new son(this.b);
      } else {
        paramViewGroup = b(paramViewGroup, paramInt);
      }
    }
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      Log.w("HeaderAndFooterAdapter", "add the header view is null");
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyDataSetChanged();
  }
  
  public void a(sol paramsol)
  {
    this.jdField_a_of_type_Sol = paramsol;
  }
  
  public void a(som paramsom)
  {
    this.jdField_a_of_type_Som = paramsom;
  }
  
  public final void a(son paramson, int paramInt)
  {
    switch (paramson.getItemViewType())
    {
    default: 
      b(paramson, paramInt);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return 0;
    }
    return 1;
  }
  
  public abstract VH b(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void b(VH paramVH, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     soo
 * JD-Core Version:    0.7.0.1
 */