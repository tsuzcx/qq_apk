import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;

public final class suz
  implements svy
{
  @NonNull
  private final RecyclerView.Adapter a;
  
  public suz(@NonNull RecyclerView.Adapter paramAdapter)
  {
    this.a = paramAdapter;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.a.notifyItemRangeRemoved(paramInt1, paramInt2);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.a.notifyItemMoved(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     suz
 * JD-Core Version:    0.7.0.1
 */