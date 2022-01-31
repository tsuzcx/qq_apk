import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;

public class scf
  implements URLDrawable.URLDrawableListener
{
  private HashMap<URLDrawable, sch> a = new HashMap();
  
  public void a()
  {
    this.a.clear();
    this.a = null;
  }
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, sci paramsci)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aywm.a((String)paramObject, paramInt1, paramInt2);
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
        paramObject = aywm.a((URL)paramObject, paramInt1, paramInt2);
        continue;
        label74:
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131376691, paramObject.getURL());
          sch localsch = new sch(this, null);
          localsch.a = new WeakReference(paramImageView);
          localsch.b = new WeakReference(paramsci);
          this.a.put(paramObject, localsch);
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
  
  public void a(Object paramObject, ImageView paramImageView, int paramInt1, int paramInt2, sci paramsci, int paramInt3)
  {
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (;;)
    {
      try
      {
        paramObject = aywm.a((String)paramObject);
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
        paramObject = aywm.a((URL)paramObject);
        continue;
        label68:
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (paramObject.getStatus() != 1)
        {
          paramImageView.setTag(2131376691, paramObject.getURL());
          paramImageView.setTag(2131376685, Boolean.TRUE);
          paramImageView.setTag(2131376688, Integer.valueOf(paramInt1));
          paramImageView.setTag(2131376686, Integer.valueOf(paramInt2));
          paramImageView.setTag(2131376687, Integer.valueOf(paramInt3));
          sch localsch = new sch(this, null);
          localsch.a = new WeakReference(paramImageView);
          localsch.b = new WeakReference(paramsci);
          this.a.put(paramObject, localsch);
          paramObject.setURLDrawableListener(this);
        }
        paramObject.setTag(bavw.b(paramInt1, paramInt2, (int)(paramInt3 * bbdh.a())));
        paramObject.setDecodeHandler(bavw.i);
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
          localObject = (sch)this.a.get(paramURLDrawable);
        } while (localObject == null);
        this.a.remove(paramURLDrawable);
        localImageView = (ImageView)((sch)localObject).a.get();
      } while ((localImageView == null) || (!paramURLDrawable.getURL().equals(localImageView.getTag(2131376691))));
      localObject = (sci)((sch)localObject).b.get();
    } while ((localObject != null) && (!((sci)localObject).a(localImageView)));
    if ((localImageView.getTag(2131376685) != null) && (((Boolean)localImageView.getTag(2131376685)).booleanValue()))
    {
      paramURLDrawable.setTag(bavw.b(((Integer)localImageView.getTag(2131376688)).intValue(), ((Integer)localImageView.getTag(2131376686)).intValue(), (int)(((Integer)localImageView.getTag(2131376687)).intValue() * bbdh.a())));
      paramURLDrawable.setDecodeHandler(bavw.i);
    }
    localImageView.setImageDrawable(null);
    localImageView.setImageDrawable(paramURLDrawable);
    localImageView.setTag(2131376691, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     scf
 * JD-Core Version:    0.7.0.1
 */