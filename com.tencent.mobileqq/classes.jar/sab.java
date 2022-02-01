import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class sab
  extends ovx
{
  @Nullable
  private rzz jdField_a_of_type_Rzz;
  @NotNull
  private saa jdField_a_of_type_Saa;
  
  public sab(@NotNull saa paramsaa, @Nullable rzz paramrzz)
  {
    super(paramsaa, true, "PublishTaskStep");
    this.jdField_a_of_type_Saa = paramsaa;
    this.jdField_a_of_type_Rzz = paramrzz;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    rzz localrzz;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_Rzz != null)
      {
        localrzz = this.jdField_a_of_type_Rzz;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localrzz.a(4, bool, true, "");
      d();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Saa.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    boolean bool = true;
    UgcVideo localUgcVideo = this.jdField_a_of_type_Saa.a();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    QLog.i("RIJUGC.PublishTaskStep", 1, "onStep: title=" + (String)localObject);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      if (localUgcVideo.columnId == 0L) {
        break label98;
      }
    }
    for (;;)
    {
      ryr.a(bool, (List)localObject, new sac(this, localUgcVideo));
      return false;
      label98:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sab
 * JD-Core Version:    0.7.0.1
 */