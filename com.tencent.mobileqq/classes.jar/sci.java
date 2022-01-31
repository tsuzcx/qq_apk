import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class sci
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, sck> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, scl paramscl)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aywk.a((String)paramObject, paramInt1, paramInt2);
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
        paramObject = aywk.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131376689, paramObject.getURL());
          sck localsck = new sck(this, null);
          localsck.a = new WeakReference(paramImageView);
          localsck.b = new WeakReference(paramscl);
          this.a.put(paramObject, localsck);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, scl paramscl, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aywk.a((String)paramObject);
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
        paramObject = aywk.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131376689, paramObject.getURL());
          paramImageView.setTag(2131376683, Boolean.TRUE);
          paramImageView.setTag(2131376686, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131376684, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131376685, Integer.valueOf(paramInt3));
          sck localsck = new sck(this, null);
          localsck.a = new WeakReference(paramImageView);
          localsck.b = new WeakReference(paramscl);
          this.a.put(paramObject, localsck);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bavi.b(paramInt1, paramInt2, (int)(paramInt3 * bbct.a())));
        paramObject.setDecodeHandler(bavi.i);
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
          localObject = (sck)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((sck)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131376689))));
      localObject = (scl)((sck)localObject).b.get();
    } while ((localObject != null) && (!((scl)localObject).a(localImageView)));
    if ((localImageView.getTag(2131376683) != null) && (((Boolean)localImageView.getTag(2131376683)).booleanValue()))
    {
      paramURLDrawable.setTag(bavi.b(((Integer)localImageView.getTag(2131376686)).intValue(), ((Integer)localImageView.getTag(2131376684)).intValue(), (int)(((Integer)localImageView.getTag(2131376685)).intValue() * bbct.a())));
      paramURLDrawable.setDecodeHandler(bavi.i);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131376689, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sci
 * JD-Core Version:    0.7.0.1
 */