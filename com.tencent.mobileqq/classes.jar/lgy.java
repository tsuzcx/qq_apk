import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lgy<T extends lgx>
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<EffectConfigBase<T>> jdField_a_of_type_JavaLangRefWeakReference;
  
  public lgy(String paramString, EffectConfigBase<T> paramEffectConfigBase)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEffectConfigBase);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      EffectConfigBase localEffectConfigBase = (EffectConfigBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      lgx locallgx;
      switch (paramMessage.what)
      {
      default: 
        localEffectConfigBase.a(paramMessage);
      case 0: 
        do
        {
          return;
          locallgx = (lgx)paramMessage.obj;
          l = paramMessage.arg1;
          bool = EffectConfigBase.a(localEffectConfigBase, locallgx, localEffectConfigBase.jdField_a_of_type_Lgx);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + l + "], isEqual[" + bool + "], count_MSG[" + localEffectConfigBase.jdField_a_of_type_Int + "], \nitem[" + locallgx + "], \ncur[" + localEffectConfigBase.jdField_a_of_type_Lgx + "]");
          if (localEffectConfigBase.jdField_a_of_type_Int >= 0) {
            localEffectConfigBase.jdField_a_of_type_Int -= 1;
          }
        } while (!bool);
        EffectConfigBase.a(localEffectConfigBase, l, locallgx);
        return;
      case 1: 
        locallgx = (lgx)paramMessage.obj;
        l = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          EffectConfigBase.a(localEffectConfigBase, l, locallgx, bool);
          return;
          bool = false;
        }
      }
      EffectConfigBase.a(localEffectConfigBase, (lgx)paramMessage.obj, paramMessage.arg1);
      return;
    }
    long l = 0L;
    if (paramMessage.what == 0) {
      l = paramMessage.arg1;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleMessage, had destroy, msg[" + paramMessage.what + "], seq[" + l + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */