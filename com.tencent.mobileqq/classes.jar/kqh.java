import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.widget.AbsListView;

public class kqh
  implements Runnable
{
  public kqh(NowVideoController paramNowVideoController, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (NowVideoController.a(this.jdField_a_of_type_ComTencentBizNowNowVideoController) == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    label16:
    Object localObject;
    if (i <= this.b)
    {
      localObject = NowVideoController.a(this.jdField_a_of_type_ComTencentBizNowNowVideoController).getChildAt(i - this.jdField_a_of_type_Int);
      if (localObject != null) {
        break label52;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label52:
      localObject = (PAVideoView)((View)localObject).findViewById(2131362177);
      if ((localObject != null) && (((PAVideoView)localObject).j == 4))
      {
        ((PAVideoView)localObject).getGlobalVisibleRect(NowVideoController.a());
        if ((((PAVideoView)localObject).getHeight() == NowVideoController.a().height()) && (NetworkUtil.h(((PAVideoView)localObject).getContext())) && (EcShopAssistantManager.a) && (NowVideoController.a().top > 0)) {
          ((PAVideoView)localObject).e();
        } else {
          ((PAVideoView)localObject).d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kqh
 * JD-Core Version:    0.7.0.1
 */