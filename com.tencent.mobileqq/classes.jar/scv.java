import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class scv
  extends SimpleObserver<List<sdf>>
{
  scv(scu paramscu, sdt paramsdt) {}
  
  public void a(List<sdf> paramList)
  {
    super.onNext(paramList);
    scu.a(this.jdField_a_of_type_Scu, 0);
    Object localObject = new scy();
    ((scy)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((scy)localObject).jdField_a_of_type_JavaUtilList = paramList;
    sgi.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      scu.a(this.jdField_a_of_type_Scu, this.jdField_a_of_type_Sdt.a(), this.jdField_a_of_type_Sdt.b());
    }
    long l = System.currentTimeMillis() - scu.a(this.jdField_a_of_type_Scu);
    String str = scu.a(paramList);
    if (this.jdField_a_of_type_Sdt.a())
    {
      localObject = "2";
      urp.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Sdt.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      urp.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      urk.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Sdt, str });
      scu.a(this.jdField_a_of_type_Scu, this.jdField_a_of_type_Sdt);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new scy();
    ((scy)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((scy)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    sgi.a().dispatch((Dispatcher.Dispatchable)localObject);
    scu.a(this.jdField_a_of_type_Scu, 0);
    urk.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = scu.a(this.jdField_a_of_type_Scu);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Sdt.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      urp.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scv
 * JD-Core Version:    0.7.0.1
 */