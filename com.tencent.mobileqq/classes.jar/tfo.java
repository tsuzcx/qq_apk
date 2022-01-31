import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class tfo
  extends SimpleObserver<List<tso>>
{
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  tfo(tfk paramtfk) {}
  
  public void a(List<tso> paramList)
  {
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onNext()");
    super.onNext(paramList);
    int i = 0;
    while (i < paramList.size())
    {
      tso localtso = (tso)paramList.get(i);
      if (!localtso.a) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localtso.b);
      }
      i += 1;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onComplete()
  {
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onComplete()");
    super.onComplete();
    this.jdField_a_of_type_Tfk.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onError(@NonNull Error paramError)
  {
    ved.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary, onError()");
    super.onError(paramError);
    this.jdField_a_of_type_Tfk.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfo
 * JD-Core Version:    0.7.0.1
 */