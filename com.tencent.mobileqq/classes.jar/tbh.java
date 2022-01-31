import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class tbh<M, VH extends tbg<M>>
  extends RecyclerView.Adapter<tbg<M>>
{
  protected Context a;
  protected View a;
  protected tbe a;
  protected tbf a;
  protected View b;
  
  public tbh(Context paramContext)
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
  
  public final tbg a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 1024) {
      paramViewGroup = new tbg(this.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Tbe != null) {
        paramViewGroup.itemView.setOnClickListener(new tbi(this, paramViewGroup));
      }
      if (this.jdField_a_of_type_Tbf != null) {
        paramViewGroup.itemView.setOnLongClickListener(new tbj(this, paramViewGroup));
      }
      return paramViewGroup;
      if (paramInt == 1025) {
        paramViewGroup = new tbg(this.b);
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
  
  public void a(tbe paramtbe)
  {
    this.jdField_a_of_type_Tbe = paramtbe;
  }
  
  public void a(tbf paramtbf)
  {
    this.jdField_a_of_type_Tbf = paramtbf;
  }
  
  public final void a(tbg paramtbg, int paramInt)
  {
    switch (paramtbg.getItemViewType())
    {
    default: 
      b(paramtbg, paramInt);
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
 * Qualified Name:     tbh
 * JD-Core Version:    0.7.0.1
 */