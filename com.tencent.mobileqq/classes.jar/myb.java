import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_search_searchtab.searchtab.RspBody;

public class myb
  implements BusinessObserver
{
  protected int a;
  protected WeakReference<mya> a;
  protected WeakReference<QQAppInterface> b;
  
  public myb(mya parammya, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parammya);
    this.b = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = false;
    mya localmya = (mya)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject1 = (QQAppInterface)this.b.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("InfoReqObserver: type=").append(paramInt).append(", reqType=").append(this.jdField_a_of_type_Int).append(", isSucc=").append(paramBoolean).append(", cbIsNull=");
      if (localmya != null) {
        break label270;
      }
    }
    label269:
    label270:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = ((StringBuilder)localObject2).append(bool1).append(", appIsNull=");
      bool1 = bool2;
      if (localObject1 == null) {
        bool1 = true;
      }
      QLog.d("AddContactTroopHandler", 2, bool1);
      if ((localmya != null) && (localObject1 != null)) {
        if ((paramBoolean) && (paramBundle != null)) {
          try
          {
            paramBundle = paramBundle.getByteArray("data");
            if (paramBundle != null)
            {
              localObject1 = (myc)((QQAppInterface)localObject1).getManager(80);
              if (this.jdField_a_of_type_Int == 1)
              {
                localObject2 = new popclassifc.RspBody();
                ((popclassifc.RspBody)localObject2).mergeFrom(paramBundle);
                ((myc)localObject1).a((popclassifc.RspBody)localObject2);
                localmya.a();
                return;
              }
              if (this.jdField_a_of_type_Int != 2) {
                break label269;
              }
              localObject2 = new searchtab.RspBody();
              ((searchtab.RspBody)localObject2).mergeFrom(paramBundle);
              ((myc)localObject1).a((searchtab.RspBody)localObject2);
              localmya.a();
              return;
            }
          }
          catch (Exception paramBundle)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AddContactTroopHandler", 2, "InfoReqObserver exp:", paramBundle);
            }
          }
        } else {
          localmya.b();
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     myb
 * JD-Core Version:    0.7.0.1
 */