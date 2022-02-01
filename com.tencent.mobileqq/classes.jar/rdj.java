import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public class rdj
  extends blsv<rdu, rdk>
{
  public rdj(Context paramContext, List<rdu> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public rdk a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new rdk(this, localImageView);
  }
  
  public void a(rdk paramrdk, int paramInt)
  {
    Bitmap localBitmap = ((rdu)a(paramInt)).a();
    if (localBitmap != null) {
      ((ImageView)paramrdk.itemView).setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rdj
 * JD-Core Version:    0.7.0.1
 */