import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class sru
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  sru(srs paramsrs) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (srs.b(this.jdField_a_of_type_Srs)))
    {
      ved.b("FredguoFix", "set needAnimated to false, break animation");
      srs.a(this.jdField_a_of_type_Srs).a(srs.a(this.jdField_a_of_type_Srs));
      srs.b(this.jdField_a_of_type_Srs, false);
      srs.a(this.jdField_a_of_type_Srs, false);
    }
    if (paramInt == 0)
    {
      srs.d(this.jdField_a_of_type_Srs, false);
      this.jdField_a_of_type_Long = 0L;
      if (srs.a(this.jdField_a_of_type_Srs).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (srs.c(this.jdField_a_of_type_Srs))
      {
        ved.b("FredguoFix", "animated to false, play animation done");
        srs.a(this.jdField_a_of_type_Srs, false);
        srs.a(this.jdField_a_of_type_Srs).a(srs.a(this.jdField_a_of_type_Srs));
      }
      this.jdField_a_of_type_Srs.d();
      return;
    }
    srs.d(this.jdField_a_of_type_Srs, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Srs.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sru
 * JD-Core Version:    0.7.0.1
 */