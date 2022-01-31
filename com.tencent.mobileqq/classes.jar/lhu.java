import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.widget.HorizontalListView;

public class lhu
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  public lhu(ReadInJoyCameraTemplateAdapter paramReadInJoyCameraTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ReadInJoyCameraTemplateAdapter.a(this.a).post(new lhw(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    ReadInJoyCameraTemplateAdapter.a(this.a).post(new lhv(this, paramPtvTemplateInfo, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhu
 * JD-Core Version:    0.7.0.1
 */