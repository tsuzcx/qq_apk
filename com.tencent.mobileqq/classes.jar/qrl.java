import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public class qrl
  extends bhzz<qrw, qrm>
{
  public qrl(Context paramContext, List<qrw> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a(int paramInt)
  {
    return 0;
  }
  
  public qrm a(ViewGroup paramViewGroup, int paramInt)
  {
    ImageView localImageView = new ImageView(this.a);
    paramInt = paramViewGroup.getLayoutParams().height;
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt, paramInt));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return new qrm(this, localImageView);
  }
  
  public void a(qrm paramqrm, int paramInt)
  {
    Bitmap localBitmap = ((qrw)a(paramInt)).a();
    if (localBitmap != null) {
      ((ImageView)paramqrm.itemView).setImageBitmap(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrl
 * JD-Core Version:    0.7.0.1
 */