import android.graphics.Bitmap;
import com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;

public class mxu
  extends aofu
{
  public mxu(QGroupExpandableListAdapter paramQGroupExpandableListAdapter) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    Bitmap localBitmap = this.a.a.getFaceBitmap(113, paramString, false, 0);
    if (localBitmap != null) {
      QGroupExpandableListAdapter.a(this.a, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxu
 * JD-Core Version:    0.7.0.1
 */