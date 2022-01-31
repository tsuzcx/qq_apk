import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class tbk<M, VH extends tbj<M>>
  extends RecyclerView.Adapter<tbj<M>>
{
  protected Context a;
  protected View a;
  protected tbh a;
  protected tbi a;
  protected View b;
  
  public tbk(Context paramContext)
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
  
  public final tbj a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new tbj(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Tbh != null) {
        paramViewGroup.itemView.setOnClickListener(new tbl(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Tbi != null) {
        paramViewGroup.itemView.setOnLongClickListener(new tbm(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new tbj(this.b);
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
  
  public void a(tbh paramtbh)
  {
    this.jdField_a_of_type_Tbh = paramtbh;
  }
  
  public void a(tbi paramtbi)
  {
    this.jdField_a_of_type_Tbi = paramtbi;
  }
  
  public final void a(tbj paramtbj, int paramInt)
  {
    switch (paramtbj.getItemViewType())
    {
    default: 
      b(paramtbj, paramInt);
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
 * Qualified Name:     tbk
 * JD-Core Version:    0.7.0.1
 */