import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class mgt
  implements HorizontalListView.OnScrollStateChangedListener
{
  mgt(mgr parammgr) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if ((paramInt == 4097) && (this.a.a != null)) {
      this.a.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgt
 * JD-Core Version:    0.7.0.1
 */