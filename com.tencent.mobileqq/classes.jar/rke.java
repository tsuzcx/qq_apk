import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class rke
  extends bjwy<rgo>
{
  public View a;
  public ImageView a;
  
  public rke(rkd paramrkd, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369207));
    this.jdField_a_of_type_AndroidViewView = a(2131370613);
  }
  
  protected URL a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append("FLOW_THUMB");
    try
    {
      paramString = new URL(localStringBuilder.toString());
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
      }
    }
    return null;
  }
  
  public void a(int paramInt, rgo paramrgo)
  {
    if (rkd.a(this.jdField_a_of_type_Rkd) == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new rkf(this, paramInt));
      a(paramrgo);
      return;
    }
  }
  
  protected void a(rgo paramrgo)
  {
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = rkd.a(this.jdField_a_of_type_Rkd);
      ((URLDrawable.URLDrawableOptions)localObject).mPriority = 2;
      String str = paramrgo.b;
      if (TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(rkd.a(this.jdField_a_of_type_Rkd));
        return;
      }
      localObject = URLDrawable.getDrawable(a(str), (URLDrawable.URLDrawableOptions)localObject);
      if (paramrgo.a != null)
      {
        paramrgo.a.thumbWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        paramrgo.a.thumbHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
        ((URLDrawable)localObject).setTag(paramrgo.a);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Throwable paramrgo)
    {
      QLog.e("RIJUGC.LocalMediaGridAdapter", 1, "load cover failed", paramrgo);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rke
 * JD-Core Version:    0.7.0.1
 */