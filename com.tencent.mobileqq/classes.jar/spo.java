import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class spo
  extends SimpleObserver<List<spy>>
{
  spo(spn paramspn, sqm paramsqm) {}
  
  public void a(List<spy> paramList)
  {
    super.onNext(paramList);
    spn.a(this.jdField_a_of_type_Spn, 0);
    Object localObject = new spr();
    ((spr)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((spr)localObject).jdField_a_of_type_JavaUtilList = paramList;
    stb.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      spn.a(this.jdField_a_of_type_Spn, this.jdField_a_of_type_Sqm.a(), this.jdField_a_of_type_Sqm.b());
    }
    long l = System.currentTimeMillis() - spn.a(this.jdField_a_of_type_Spn);
    String str = spn.a(paramList);
    if (this.jdField_a_of_type_Sqm.a())
    {
      localObject = "2";
      vei.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Sqm.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      vei.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      ved.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Sqm, str });
      spn.a(this.jdField_a_of_type_Spn, this.jdField_a_of_type_Sqm);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new spr();
    ((spr)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((spr)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    stb.a().dispatch((Dispatcher.Dispatchable)localObject);
    spn.a(this.jdField_a_of_type_Spn, 0);
    ved.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = spn.a(this.jdField_a_of_type_Spn);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Sqm.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      vei.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spo
 * JD-Core Version:    0.7.0.1
 */