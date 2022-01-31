import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class rpq
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, rps> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, rpt paramrpt)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = axwd.a((String)paramObject, paramInt1, paramInt2);
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
        paramObject = axwd.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131310882, paramObject.getURL());
          rps localrps = new rps(this, null);
          localrps.a = new WeakReference(paramImageView);
          localrps.b = new WeakReference(paramrpt);
          this.a.put(paramObject, localrps);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, rpt paramrpt, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = axwd.a((String)paramObject);
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
        paramObject = axwd.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131310882, paramObject.getURL());
          paramImageView.setTag(2131310876, Boolean.TRUE);
          paramImageView.setTag(2131310879, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131310877, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131310878, Integer.valueOf(paramInt3));
          rps localrps = new rps(this, null);
          localrps.a = new WeakReference(paramImageView);
          localrps.b = new WeakReference(paramrpt);
          this.a.put(paramObject, localrps);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(azue.b(paramInt1, paramInt2, (int)(paramInt3 * babp.a())));
        paramObject.setDecodeHandler(azue.i);
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
          localObject = (rps)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((rps)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131310882))));
      localObject = (rpt)((rps)localObject).b.get();
    } while ((localObject != null) && (!((rpt)localObject).a(localImageView)));
    if ((localImageView.getTag(2131310876) != null) && (((Boolean)localImageView.getTag(2131310876)).booleanValue()))
    {
      paramURLDrawable.setTag(azue.b(((Integer)localImageView.getTag(2131310879)).intValue(), ((Integer)localImageView.getTag(2131310877)).intValue(), (int)(((Integer)localImageView.getTag(2131310878)).intValue() * babp.a())));
      paramURLDrawable.setDecodeHandler(azue.i);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131310882, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpq
 * JD-Core Version:    0.7.0.1
 */