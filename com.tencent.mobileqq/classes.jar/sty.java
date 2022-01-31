import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class sty
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, sua> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, sub paramsub)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = baul.a((String)paramObject, paramInt1, paramInt2);
        if (paramObject != null) {
          break label74;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = baul.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131377201, paramObject.getURL());
          sua localsua = new sua(this, null);
          localsua.a = new WeakReference(paramImageView);
          localsua.b = new WeakReference(paramsub);
          this.a.put(paramObject, localsua);
          paramObject.setURLDrawableListener(this);
        }
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, sub paramsub, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = baul.a((String)paramObject);
        if (paramObject != null) {
          break label68;
        }
        return;
      }
      catch (IllegalArgumentException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SubscriptPicManager", 2, paramObject.toString());
        }
        paramObject = null;
        continue;
      }
      if ((paramObject != null) && ((paramObject instanceof URL)))
      {
        paramObject = baul.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131377201, paramObject.getURL());
          paramImageView.setTag(2131377195, Boolean.TRUE);
          paramImageView.setTag(2131377198, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131377196, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131377197, Integer.valueOf(paramInt3));
          sua localsua = new sua(this, null);
          localsua.a = new WeakReference(paramImageView);
          localsua.b = new WeakReference(paramsub);
          this.a.put(paramObject, localsua);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bcuq.b(paramInt1, paramInt2, (int)(paramInt3 * bdcb.a())));
        paramObject.setDecodeHandler(bcuq.i);
        paramImageView.setImageDrawable(null);
        paramImageView.setImageDrawable(paramObject);
      }
      else
      {
        paramObject = null;
      }
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((this.a == null) || (paramURLDrawable == null)) {}
    Object localObject;
    ImageView localImageView;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (sua)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((sua)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131377201))));
      localObject = (sub)((sua)localObject).b.get();
    } while ((localObject != null) && (!((sub)localObject).a(localImageView)));
    if ((localImageView.getTag(2131377195) != null) && (((Boolean)localImageView.getTag(2131377195)).booleanValue()))
    {
      paramURLDrawable.setTag(bcuq.b(((Integer)localImageView.getTag(2131377198)).intValue(), ((Integer)localImageView.getTag(2131377196)).intValue(), (int)(((Integer)localImageView.getTag(2131377197)).intValue() * bdcb.a())));
      paramURLDrawable.setDecodeHandler(bcuq.i);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131377201, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sty
 * JD-Core Version:    0.7.0.1
 */