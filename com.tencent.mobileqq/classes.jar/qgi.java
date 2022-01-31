import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class qgi
  extends qgf
{
  public qgi(ViewGroup paramViewGroup, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable ymk paramymk)
  {
    super(paramViewGroup);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20200313/4892c273234b4f39833f389671c1b1fa.png", (URLDrawable.URLDrawableOptions)localObject);
    this.a.setImageDrawable((Drawable)localObject);
    localObject = (TextView)a(2131380065);
    ((TextView)localObject).setOnClickListener(new qgj(this, paramBoolean, paramymk, paramString, paramInt1, paramInt2, paramViewGroup));
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    paramString = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = paramString;
    paramViewGroup.mLoadingDrawable = paramString;
    ((TextView)localObject).setBackgroundDrawable(URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramViewGroup));
  }
  
  View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562502, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgi
 * JD-Core Version:    0.7.0.1
 */