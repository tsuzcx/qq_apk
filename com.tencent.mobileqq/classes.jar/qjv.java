import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.activity.SplashActivity;
import java.lang.ref.WeakReference;

class qjv
  extends OrientationEventListener
{
  qjv(qju paramqju, Context paramContext, WeakReference paramWeakReference)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!qju.a(this.jdField_a_of_type_Qju, paramInt)) {
      break label11;
    }
    label11:
    label159:
    for (;;)
    {
      return;
      if (!(this.jdField_a_of_type_Qju.a() instanceof SplashActivity))
      {
        int i = qju.a(this.jdField_a_of_type_Qju);
        if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330)) {
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt == qju.a(this.jdField_a_of_type_Qju)) {
            break label159;
          }
          qju.a(this.jdField_a_of_type_Qju, paramInt);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break;
          }
          ((qjw)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt);
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
 * Qualified Name:     qjv
 * JD-Core Version:    0.7.0.1
 */