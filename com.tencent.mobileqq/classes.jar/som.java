import android.database.DataSetObserver;

class som
  extends DataSetObserver
{
  som(sol paramsol) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     som
 * JD-Core Version:    0.7.0.1
 */