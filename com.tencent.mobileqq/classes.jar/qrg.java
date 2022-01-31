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

public class qrg
  extends biac<qnz>
{
  public View a;
  public ImageView a;
  
  public qrg(qrf paramqrf, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)b(2131368739));
    this.jdField_a_of_type_AndroidViewView = b(2131370081);
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
  
  public void a(int paramInt, qnz paramqnz)
  {
    if (qrf.a(this.jdField_a_of_type_Qrf) == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new qrh(this, paramInt));
      a(paramqnz);
      return;
    }
  }
  
  protected void a(qnz paramqnz)
  {
    try
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = qrf.a(this.jdField_a_of_type_Qrf);
      ((URLDrawable.URLDrawableOptions)localObject).mPriority = 2;
      String str = paramqnz.b;
      if (TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(qrf.a(this.jdField_a_of_type_Qrf));
        return;
      }
      localObject = URLDrawable.getDrawable(a(str), (URLDrawable.URLDrawableOptions)localObject);
      if (paramqnz.a != null)
      {
        paramqnz.a.thumbWidth = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        paramqnz.a.thumbHeight = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
        ((URLDrawable)localObject).setTag(paramqnz.a);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (Throwable paramqnz)
    {
      QLog.e("RIJUGC.LocalMediaGridAdapter", 1, "load cover failed", paramqnz);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qrg
 * JD-Core Version:    0.7.0.1
 */