import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class sud
  extends SimpleObserver<List<tfv>>
{
  sud(suc paramsuc, sug paramsug, ssm paramssm) {}
  
  public void a(List<tfv> paramList)
  {
    super.onNext(paramList);
    ArrayList localArrayList;
    int i;
    tfv localtfv;
    if (this.jdField_a_of_type_Sug != null)
    {
      localArrayList = new ArrayList();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Collections.sort(paramList, new sue(this));
        paramList = paramList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localtfv = (tfv)paramList.next();
          if (i < suc.a(this.jdField_a_of_type_Suc)) {
            break label100;
          }
        }
      }
      this.jdField_a_of_type_Sug.a(this.jdField_a_of_type_Ssm, localArrayList);
    }
    else
    {
      return;
    }
    label100:
    if ((localtfv != null) && (!localtfv.jdField_a_of_type_Boolean) && (localtfv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
    {
      localArrayList.add(localtfv.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    if (this.jdField_a_of_type_Sug != null) {
      this.jdField_a_of_type_Sug.a(this.jdField_a_of_type_Ssm, paramError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sud
 * JD-Core Version:    0.7.0.1
 */