import android.database.DataSetObserver;

class qxc
  extends DataSetObserver
{
  qxc(qxb paramqxb) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qxc
 * JD-Core Version:    0.7.0.1
 */