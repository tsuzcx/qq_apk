import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ljp<T extends ljo>
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<EffectConfigBase<T>> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ljp(String paramString, EffectConfigBase<T> paramEffectConfigBase)
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
      ljo localljo;
      switch (paramMessage.what)
      {
      default: 
        localEffectConfigBase.a(paramMessage);
      case 0: 
        do
        {
          return;
          localljo = (ljo)paramMessage.obj;
          l = paramMessage.arg1;
          bool = EffectConfigBase.a(localEffectConfigBase, localljo, localEffectConfigBase.jdField_a_of_type_Ljo);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + l + "], isEqual[" + bool + "], count_MSG[" + localEffectConfigBase.jdField_a_of_type_Int + "], \nitem[" + localljo + "], \ncur[" + localEffectConfigBase.jdField_a_of_type_Ljo + "]");
          if (localEffectConfigBase.jdField_a_of_type_Int >= 0) {
            localEffectConfigBase.jdField_a_of_type_Int -= 1;
          }
        } while (!bool);
        EffectConfigBase.a(localEffectConfigBase, l, localljo);
        return;
      case 1: 
        localljo = (ljo)paramMessage.obj;
        l = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          EffectConfigBase.a(localEffectConfigBase, l, localljo, bool);
          return;
          bool = false;
        }
      }
      EffectConfigBase.a(localEffectConfigBase, (ljo)paramMessage.obj, paramMessage.arg1);
      return;
    }
    long l = 0L;
    if (paramMessage.what == 0) {
      l = paramMessage.arg1;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleMessage, had destroy, msg[" + paramMessage.what + "], seq[" + l + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ljp
 * JD-Core Version:    0.7.0.1
 */