import android.widget.ImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;

class ncc
  implements Runnable
{
  ncc(nby paramnby) {}
  
  public void run()
  {
    if (PublicAccountImageCollectionMainActivity.b(this.a.a))
    {
      this.a.a.e.setImageResource(2130839694);
      return;
    }
    this.a.a.e.setImageResource(2130839693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncc
 * JD-Core Version:    0.7.0.1
 */