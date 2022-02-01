import android.database.DataSetObserver;

class ssn
  extends DataSetObserver
{
  ssn(ssm paramssm) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssn
 * JD-Core Version:    0.7.0.1
 */