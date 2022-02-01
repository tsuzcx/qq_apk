import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rpq
  extends ouc
{
  @Nullable
  private rpo jdField_a_of_type_Rpo;
  @NotNull
  private rpp jdField_a_of_type_Rpp;
  
  public rpq(@NotNull rpp paramrpp, @Nullable rpo paramrpo)
  {
    super(paramrpp, true, "PublishTaskStep");
    this.jdField_a_of_type_Rpp = paramrpp;
    this.jdField_a_of_type_Rpo = paramrpo;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    rpo localrpo;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_Rpo != null)
      {
        localrpo = this.jdField_a_of_type_Rpo;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localrpo.a(4, bool, true, "");
      d();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Rpp.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rpp.a();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    QLog.i("RIJUGC.PublishTaskStep", 1, "onStep: title=" + (String)localObject);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      rog.a((List)localObject, new rpr(this, localUgcVideo));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpq
 * JD-Core Version:    0.7.0.1
 */