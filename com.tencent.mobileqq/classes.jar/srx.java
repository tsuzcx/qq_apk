import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class srx
  extends RecyclerView.OnScrollListener
{
  private long jdField_a_of_type_Long;
  private final long b = 20L;
  
  srx(srv paramsrv) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 1) && (srv.b(this.jdField_a_of_type_Srv)))
    {
      veg.b("FredguoFix", "set needAnimated to false, break animation");
      srv.a(this.jdField_a_of_type_Srv).a(srv.a(this.jdField_a_of_type_Srv));
      srv.b(this.jdField_a_of_type_Srv, false);
      srv.a(this.jdField_a_of_type_Srv, false);
    }
    if (paramInt == 0)
    {
      srv.d(this.jdField_a_of_type_Srv, false);
      this.jdField_a_of_type_Long = 0L;
      if (srv.a(this.jdField_a_of_type_Srv).a(paramRecyclerView.getLayoutManager()) == null) {
        return;
      }
      if (srv.c(this.jdField_a_of_type_Srv))
      {
        veg.b("FredguoFix", "animated to false, play animation done");
        srv.a(this.jdField_a_of_type_Srv, false);
        srv.a(this.jdField_a_of_type_Srv).a(srv.a(this.jdField_a_of_type_Srv));
      }
      this.jdField_a_of_type_Srv.d();
      return;
    }
    srv.d(this.jdField_a_of_type_Srv, true);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) >= 20L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Srv.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srx
 * JD-Core Version:    0.7.0.1
 */