import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class sfb
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  sfb(sez paramsez) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (sez.b(this.jdField_a_of_type_Sez)))
    {
      urk.b("FredguoFix", "set needAnimated to false, break animation");
      sez.a(this.jdField_a_of_type_Sez).a(sez.a(this.jdField_a_of_type_Sez));
      sez.b(this.jdField_a_of_type_Sez, false);
      sez.a(this.jdField_a_of_type_Sez, false);
    }
    if (paramInt == 0)
    {
      sez.d(this.jdField_a_of_type_Sez, false);
      this.jdField_a_of_type_Long = 0L;
      if (sez.a(this.jdField_a_of_type_Sez).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (sez.c(this.jdField_a_of_type_Sez))
      {
        urk.b("FredguoFix", "animated to false, play animation done");
        sez.a(this.jdField_a_of_type_Sez, false);
        sez.a(this.jdField_a_of_type_Sez).a(sez.a(this.jdField_a_of_type_Sez));
      }
      this.jdField_a_of_type_Sez.d();
      return;
    }
    sez.d(this.jdField_a_of_type_Sez, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Sez.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfb
 * JD-Core Version:    0.7.0.1
 */