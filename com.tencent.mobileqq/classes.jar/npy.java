import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.shareGroup.icon.IconLog;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class npy
  extends Drawable.ConstantState
{
  private long jdField_a_of_type_Long;
  @NonNull
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NonNull
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Error jdField_a_of_type_JavaLangError;
  @NonNull
  public final String a;
  private final CopyOnWriteArraySet jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  @NonNull
  private nqc jdField_a_of_type_Nqc;
  private volatile boolean jdField_a_of_type_Boolean;
  private String b = "story.icon.ShareGroupDrawableState";
  
  public npy(String paramString, Context paramContext, Drawable paramDrawable)
  {
    if ((paramString == null) || (paramContext == null) || (paramDrawable == null)) {
      throw new IllegalArgumentException("params should not be null");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.b = (this.b + "[" + System.identityHashCode(this) + "]");
  }
  
  private void a(boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        nqb localnqb = (nqb)localIterator.next();
        if (nqb.a(localnqb))
        {
          if (paramBoolean) {
            localnqb.a(this);
          } else {
            localnqb.b(this);
          }
        }
        else
        {
          IconLog.a(this.b, "remove invalid callback %s", this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localnqb);
        }
      }
    }
    throw new IllegalStateException("notifyCallBack should be at Main-Thread");
  }
  
  private void b(boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)) || (paramBoolean))
    {
      IconLog.a(this.b, "startLoad");
      this.jdField_a_of_type_Nqc.a(this).subscribe(new npz(this));
    }
    while ((this.jdField_a_of_type_JavaLangError == null) || (Math.abs(this.jdField_a_of_type_Long - SystemClock.uptimeMillis()) <= 10000L)) {
      return;
    }
    IconLog.b(this.b, "load again, oldError=%s", this.jdField_a_of_type_JavaLangError);
    this.jdField_a_of_type_JavaLangError = null;
    b(true);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    return null;
  }
  
  public Error a()
  {
    return this.jdField_a_of_type_JavaLangError;
  }
  
  public void a()
  {
    IconLog.b(this.b, "recycle");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(nqa paramnqa)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(new nqb(paramnqa));
  }
  
  public void a(@NonNull nqc paramnqc)
  {
    this.jdField_a_of_type_Nqc = paramnqc;
  }
  
  public void b()
  {
    b(false);
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  @NonNull
  public Drawable newDrawable()
  {
    return new nqd(this, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npy
 * JD-Core Version:    0.7.0.1
 */