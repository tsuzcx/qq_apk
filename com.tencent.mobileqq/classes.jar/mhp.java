import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class mhp
  implements HorizontalListView.OnScrollStateChangedListener
{
  mhp(mhn parammhn) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.a != null)) {
      this.a.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mhp
 * JD-Core Version:    0.7.0.1
 */