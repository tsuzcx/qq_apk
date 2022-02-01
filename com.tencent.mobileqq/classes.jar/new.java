import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class new<T extends nel>
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  protected int a;
  protected T a;
  protected ney a;
  
  public new(@NonNull View paramView)
  {
    super(paramView);
  }
  
  protected void a() {}
  
  public final void a(View paramView)
  {
    if (paramView != null) {
      paramView.setOnClickListener(this);
    }
  }
  
  public void a(ney paramney)
  {
    this.jdField_a_of_type_Ney = paramney;
  }
  
  public void a(nfa paramnfa, T paramT, int paramInt) {}
  
  public final void b(nfa paramnfa, nel paramnel, int paramInt)
  {
    if (paramnel != null)
    {
      this.jdField_a_of_type_Nel = paramnel;
      a(paramnfa, this.jdField_a_of_type_Nel, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      this.jdField_a_of_type_Nel = null;
      a(paramnfa, null, paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ney != null) {
      this.jdField_a_of_type_Ney.a(paramView, this.jdField_a_of_type_Nel, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     new
 * JD-Core Version:    0.7.0.1
 */