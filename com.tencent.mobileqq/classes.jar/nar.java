import com.tencent.av.wtogether.view.QGroupAVFileListContentView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;

public class nar
  extends mzp
{
  public nar(QGroupAVFileListContentView paramQGroupAVFileListContentView) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<bfmo> paramList)
  {
    this.a.a(paramList);
    if (paramInt1 == 0)
    {
      ((mzj)this.a.a.getBusinessHandler(BusinessHandlerFactory.QAV_WT_HANDLER)).a(QGroupAVFileListContentView.a(this.a), ByteStringMicro.copyFromUtf8(paramString1));
      return;
    }
    this.a.i();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nar
 * JD-Core Version:    0.7.0.1
 */