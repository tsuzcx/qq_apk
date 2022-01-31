import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.lang.ref.WeakReference;

class pxz
  extends OrientationEventListener
{
  pxz(pxy parampxy, Context paramContext, WeakReference paramWeakReference)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!pxy.a(this.jdField_a_of_type_Pxy, paramInt)) {
      break label11;
    }
    label11:
    label159:
    for (;;)
    {
      return;
      if (!(this.jdField_a_of_type_Pxy.a() instanceof SplashActivity))
      {
        int i = pxy.a(this.jdField_a_of_type_Pxy);
        if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330)) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt == pxy.a(this.jdField_a_of_type_Pxy)) {
            break label159;
          }
          pxy.a(this.jdField_a_of_type_Pxy, paramInt);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break;
          }
          ((pya)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt);
          return;
          if ((paramInt > 70) && (paramInt <= 110)) {
            paramInt = 8;
          } else if ((paramInt > 150) && (paramInt <= 210)) {
            paramInt = 9;
          } else if ((paramInt > 250) && (paramInt <= 290)) {
            paramInt = 0;
          } else {
            paramInt = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxz
 * JD-Core Version:    0.7.0.1
 */