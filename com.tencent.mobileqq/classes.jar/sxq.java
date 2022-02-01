import android.database.DataSetObserver;

class sxq
  extends DataSetObserver
{
  sxq(sxp paramsxp) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxq
 * JD-Core Version:    0.7.0.1
 */