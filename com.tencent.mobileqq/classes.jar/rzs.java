import android.database.DataSetObserver;

class rzs
  extends DataSetObserver
{
  rzs(rzr paramrzr) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */