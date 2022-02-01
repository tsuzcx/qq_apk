import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public class rkj
  extends bjwv<rku, rkk>
{
  public rkj(Context paramContext, List<rku> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public rkk a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new rkk(this, localImageView);
  }
  
  public void a(rkk paramrkk, int paramInt)
  {
    Bitmap localBitmap = ((rku)a(paramInt)).a();
    if (localBitmap != null) {
      ((ImageView)paramrkk.itemView).setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rkj
 * JD-Core Version:    0.7.0.1
 */