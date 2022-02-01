import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.lang.ref.WeakReference;

class sfl
  extends OrientationEventListener
{
  sfl(sfk paramsfk, Context paramContext, WeakReference paramWeakReference)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!sfk.a(this.jdField_a_of_type_Sfk, paramInt)) {
      break label11;
    }
    label11:
    label159:
    for (;;)
    {
      return;
      if (!(this.jdField_a_of_type_Sfk.a() instanceof SplashActivity))
      {
        int i = sfk.a(this.jdField_a_of_type_Sfk);
        if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330)) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt == sfk.a(this.jdField_a_of_type_Sfk)) {
            break label159;
          }
          sfk.a(this.jdField_a_of_type_Sfk, paramInt);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break;
          }
          ((sfm)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */