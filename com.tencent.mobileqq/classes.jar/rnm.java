import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class rnm
  extends ooa
{
  @Nullable
  private rnk jdField_a_of_type_Rnk;
  @NotNull
  private rnl jdField_a_of_type_Rnl;
  
  public rnm(@NotNull rnl paramrnl, @Nullable rnk paramrnk)
  {
    super(paramrnl, true, "PublishTaskStep");
    this.jdField_a_of_type_Rnl = paramrnl;
    this.jdField_a_of_type_Rnk = paramrnk;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    rnk localrnk;
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty()))
    {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
      if (this.jdField_a_of_type_Rnk != null)
      {
        localrnk = this.jdField_a_of_type_Rnk;
        if (paramUgcVideo.status != UgcVideo.STATUS_FINISH) {
          break label74;
        }
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localrnk.a(4, bool, true, "");
      d();
      return;
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Rnl.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    boolean bool = true;
    UgcVideo localUgcVideo = this.jdField_a_of_type_Rnl.a();
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
      rmc.a(bool, (List)localObject, new rnn(this, localUgcVideo));
      return false;
      label98:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnm
 * JD-Core Version:    0.7.0.1
 */