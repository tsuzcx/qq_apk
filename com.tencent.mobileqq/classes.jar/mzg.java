import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class mzg<T extends myy>
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  protected int a;
  protected T a;
  protected mzi a;
  
  public mzg(@NonNull View paramView)
  {
    super(paramView);
    a();
  }
  
  public final void a()
  {
    this.itemView.setOnClickListener(this);
  }
  
  public void a(mzi parammzi)
  {
    this.jdField_a_of_type_Mzi = parammzi;
  }
  
  public void a(mzj parammzj, T paramT, int paramInt) {}
  
  public final void b(mzj parammzj, myy parammyy, int paramInt)
  {
    if (parammyy != null)
    {
      this.jdField_a_of_type_Myy = parammyy;
      a(parammzj, this.jdField_a_of_type_Myy, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_Myy = null;
      a(parammzj, null, paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Mzi != null) {
      this.jdField_a_of_type_Mzi.a(paramView, this.jdField_a_of_type_Myy, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzg
 * JD-Core Version:    0.7.0.1
 */