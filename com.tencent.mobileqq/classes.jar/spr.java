import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.reactive.SimpleObserver;
import java.util.ArrayList;
import java.util.List;

class spr
  extends SimpleObserver<List<sqb>>
{
  spr(spq paramspq, sqp paramsqp) {}
  
  public void a(List<sqb> paramList)
  {
    super.onNext(paramList);
    spq.a(this.jdField_a_of_type_Spq, 0);
    Object localObject = new spu();
    ((spu)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ((spu)localObject).jdField_a_of_type_JavaUtilList = paramList;
    ste.a().dispatch((Dispatcher.Dispatchable)localObject);
    if (!paramList.isEmpty()) {
      spq.a(this.jdField_a_of_type_Spq, this.jdField_a_of_type_Sqp.a(), this.jdField_a_of_type_Sqp.b());
    }
    long l = System.currentTimeMillis() - spq.a(this.jdField_a_of_type_Spq);
    String str = spq.a(paramList);
    if (this.jdField_a_of_type_Sqp.a())
    {
      localObject = "2";
      vel.a("video_shoot_slides", "scan", 0, 0, new String[] { "", localObject, l + "" });
      if (!this.jdField_a_of_type_Sqp.a()) {
        break label271;
      }
    }
    label271:
    for (localObject = "2";; localObject = "1")
    {
      vel.a("video_shoot_slides", "piece_smartalbum", 0, 0, new String[] { str, localObject, paramList.size() + "" });
      veg.d("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split success timecost=%s : ScanInfo =%s result=%s", new Object[] { Long.valueOf(l), this.jdField_a_of_type_Sqp, str });
      spq.a(this.jdField_a_of_type_Spq, this.jdField_a_of_type_Sqp);
      return;
      localObject = "1";
      break;
    }
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new spu();
    ((spu)localObject).jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)paramError);
    ((spu)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
    ste.a().dispatch((Dispatcher.Dispatchable)localObject);
    spq.a(this.jdField_a_of_type_Spq, 0);
    veg.e("Q.qqstory.recommendAlbum.logic.StoryScanManager", "scan and split falied : " + paramError);
    long l1 = System.currentTimeMillis();
    long l2 = spq.a(this.jdField_a_of_type_Spq);
    int i = ((ErrorMessage)paramError).errorCode;
    localObject = ((ErrorMessage)paramError).errorMsg;
    if (this.jdField_a_of_type_Sqp.a()) {}
    for (paramError = "2";; paramError = "1")
    {
      vel.a("video_shoot_slides", "scan", 0, i, new String[] { localObject, paramError, l1 - l2 + "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spr
 * JD-Core Version:    0.7.0.1
 */