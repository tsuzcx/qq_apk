import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateAdapter;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateItemView;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraTemplateItemView.TemplateItemCallback;
import com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class lid
  implements ReadInJoyCameraTemplateItemView.TemplateItemCallback
{
  public lid(ReadInJoyCameraTemplateAdapter paramReadInJoyCameraTemplateAdapter) {}
  
  public void a(int paramInt)
  {
    PublicAccountReportUtils.a(null, "", "0X80081D5", "0X80081D5", 0, 0, "2", "", "", VideoReporter.a(ReadInJoyCameraTemplateAdapter.a(this.a)), false);
    if ((!((PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.a).get(paramInt)).usable) && (!NetworkUtil.g(ReadInJoyCameraTemplateAdapter.a(this.a)))) {
      QQToast.a(ReadInJoyCameraTemplateAdapter.a(this.a), 1, 2131428448, 0).a(0).show();
    }
    do
    {
      do
      {
        return;
      } while (((PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.a).get(paramInt)).id.equals(ReadInJoyCameraTemplateAdapter.a(this.a).id));
      ReadInJoyCameraTemplateAdapter.a(this.a).isSelected = false;
      int j = ReadInJoyCameraTemplateAdapter.a(this.a).getFirstVisiblePosition();
      int k = ReadInJoyCameraTemplateAdapter.a(this.a).getLastVisiblePosition();
      int i = j;
      Object localObject1;
      if (i <= k)
      {
        if (i < 0) {}
        do
        {
          i += 1;
          break;
          localObject1 = (PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.a).get(i);
        } while ((localObject1 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject1).id.equals(ReadInJoyCameraTemplateAdapter.a(this.a).id)));
        localObject1 = ReadInJoyCameraTemplateAdapter.a(this.a).getChildAt(i - j);
        if ((localObject1 instanceof ReadInJoyCameraTemplateItemView)) {
          ((ReadInJoyCameraTemplateItemView)localObject1).a(false);
        }
      }
      ReadInJoyCameraTemplateAdapter.a(this.a, (PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.a).get(paramInt));
      ReadInJoyCameraTemplateAdapter.a(this.a).isSelected = true;
      if (ReadInJoyCameraTemplateAdapter.a(this.a).usable)
      {
        localObject1 = PtvTemplateManager.a + ReadInJoyCameraTemplateAdapter.a(this.a).name;
        i = ReadInJoyCameraTemplateAdapter.a(this.a).getFirstVisiblePosition();
        j = ReadInJoyCameraTemplateAdapter.a(this.a).getLastVisiblePosition();
        paramInt = i;
        if (paramInt <= j)
        {
          if (paramInt < 0) {}
          do
          {
            paramInt += 1;
            break;
            localObject2 = (PtvTemplateManager.PtvTemplateInfo)ReadInJoyCameraTemplateAdapter.a(this.a).get(paramInt);
          } while ((localObject2 == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject2).id.equals(ReadInJoyCameraTemplateAdapter.a(this.a).id)));
          Object localObject2 = ReadInJoyCameraTemplateAdapter.a(this.a).getChildAt(paramInt - i);
          if ((localObject2 instanceof ReadInJoyCameraTemplateItemView)) {
            ((ReadInJoyCameraTemplateItemView)localObject2).a(true);
          }
        }
        if (!ReadInJoyCameraTemplateAdapter.a(this.a).id.equals("0"))
        {
          ReadInJoyCameraTemplateAdapter.a(this.a).setFaceEffect((String)localObject1);
          return;
        }
        ReadInJoyCameraTemplateAdapter.a(this.a).setFaceEffect(null);
        return;
      }
    } while ((ReadInJoyCameraTemplateAdapter.a(this.a).downloading) || (TextUtils.isEmpty(ReadInJoyCameraTemplateAdapter.a(this.a).id)) || (ReadInJoyCameraTemplateAdapter.a(this.a) == null));
    ReadInJoyCameraTemplateAdapter.a(this.a).a(ReadInJoyCameraTemplateAdapter.a(this.a), ReadInJoyCameraTemplateAdapter.a(this.a), ReadInJoyCameraTemplateAdapter.a(this.a));
    ReadInJoyCameraTemplateAdapter.a(this.a).downloading = true;
    ShortVideoMtaReport.a("shortvideo_download_effects", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lid
 * JD-Core Version:    0.7.0.1
 */