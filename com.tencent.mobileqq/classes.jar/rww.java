import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public class rww
  extends blig<rxh, rwx>
{
  public rww(Context paramContext, List<rxh> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public rwx a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new rwx(this, localImageView);
  }
  
  public void a(rwx paramrwx, int paramInt)
  {
    Bitmap localBitmap = ((rxh)a(paramInt)).a();
    if (localBitmap != null) {
      ((ImageView)paramrwx.itemView).setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rww
 * JD-Core Version:    0.7.0.1
 */