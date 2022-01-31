import android.database.DataSetObserver;

class rjt
  extends DataSetObserver
{
  rjt(rjs paramrjs) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjt
 * JD-Core Version:    0.7.0.1
 */