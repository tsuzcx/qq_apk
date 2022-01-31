import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class qul
  extends ohl
{
  @Nullable
  private quj jdField_a_of_type_Quj;
  @NotNull
  private quk jdField_a_of_type_Quk;
  
  public qul(@NotNull quk paramquk, @Nullable quj paramquj)
  {
    super(paramquk, true, "PublishTaskStep");
    this.jdField_a_of_type_Quk = paramquk;
    this.jdField_a_of_type_Quj = paramquj;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    quj localquj;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_Quj != null)
      {
        localquj = this.jdField_a_of_type_Quj;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localquj.a(4, bool, true, "");
      d();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Quk.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_Quk.a();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    QLog.i("RIJUGC.PublishTaskStep", 1, "onStep: title=" + (String)localObject);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      qte.a((List)localObject, new qum(this, localUgcVideo));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qul
 * JD-Core Version:    0.7.0.1
 */