import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lhm<T extends lhl>
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<EffectConfigBase<T>> jdField_a_of_type_JavaLangRefWeakReference;
  
  public lhm(String paramString, EffectConfigBase<T> paramEffectConfigBase)
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
      lhl locallhl;
      switch (paramMessage.what)
      {
      default: 
        localEffectConfigBase.a(paramMessage);
      case 0: 
        do
        {
          return;
          locallhl = (lhl)paramMessage.obj;
          l = paramMessage.arg1;
          bool = EffectConfigBase.a(localEffectConfigBase, locallhl, localEffectConfigBase.jdField_a_of_type_Lhl);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + l + "], isEqual[" + bool + "], count_MSG[" + localEffectConfigBase.jdField_a_of_type_Int + "], \nitem[" + locallhl + "], \ncur[" + localEffectConfigBase.jdField_a_of_type_Lhl + "]");
          if (localEffectConfigBase.jdField_a_of_type_Int >= 0) {
            localEffectConfigBase.jdField_a_of_type_Int -= 1;
          }
        } while (!bool);
        EffectConfigBase.a(localEffectConfigBase, l, locallhl);
        return;
      case 1: 
        locallhl = (lhl)paramMessage.obj;
        l = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          EffectConfigBase.a(localEffectConfigBase, l, locallhl, bool);
          return;
          bool = false;
        }
      }
      EffectConfigBase.a(localEffectConfigBase, (lhl)paramMessage.obj, paramMessage.arg1);
      return;
    }
    long l = 0L;
    if (paramMessage.what == 0) {
      l = paramMessage.arg1;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleMessage, had destroy, msg[" + paramMessage.what + "], seq[" + l + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhm
 * JD-Core Version:    0.7.0.1
 */