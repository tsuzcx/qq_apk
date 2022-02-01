package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import java.util.List;

class AEGIFStickerListPart$7
  implements Observer<Boolean>
{
  AEGIFStickerListPart$7(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean == null) || (!paramBoolean.booleanValue())) {}
    label516:
    for (;;)
    {
      return;
      AEGIFStickerListPart.b(this.a);
      paramBoolean = AEGifMaterialManager.a().a(2);
      if (paramBoolean.size() > 0)
      {
        Pair localPair = AEGIFStickerListPart.a(this.a, paramBoolean);
        int i;
        label61:
        int j;
        if ((localPair == null) || (localPair.first == null))
        {
          i = 0;
          if ((localPair != null) && (localPair.second != null)) {
            break label492;
          }
          j = 0;
          label76:
          AEGIFStickerListPart.b(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).categoryId);
          AEGIFStickerListPart.a(this.a, ((AEGifCategoryWrapper)paramBoolean.get(i)).fontId);
          if (AEGIFStickerListPart.b(this.a))
          {
            if ((i == 0) && (j == 0) && (!AEGIFStickerListPart.c(this.a))) {
              Toast.makeText(AEGIFStickerListPart.a(this.a).a(), 2131689691, 1).show();
            }
            AEGIFStickerListPart.a(this.a, true);
          }
          AEGIFStickerListPart.b(this.a).clear();
          AEGIFStickerListPart.b(this.a).addAll(paramBoolean);
          AEGIFStickerListPart.a(this.a, AEGIFStickerListPart.b(this.a, paramBoolean));
          AEGIFStickerListPart.a(this.a).setTabData((String[])AEGIFStickerListPart.a(this.a).first, (int[])AEGIFStickerListPart.a(this.a).second);
          AEGIFStickerListPart.a(this.a).post(new AEGIFStickerListPart.7.1(this, i));
          AEGIFStickerListPart.a(this.a).clear();
          AEGIFStickerListPart.a(this.a).addAll(((AEGifCategoryWrapper)AEGIFStickerListPart.b(this.a).get(i)).materialWrapperList);
          AEGIFStickerListPart.a(this.a).notifyDataSetChanged();
          AEGIFStickerListPart.a(this.a).post(new AEGIFStickerListPart.7.2(this, j));
          paramBoolean = (AEMaterialWrapper)((AEGifCategoryWrapper)AEGIFStickerListPart.b(this.a).get(i)).materialWrapperList.get(j);
          if (paramBoolean.b != 1) {
            break label507;
          }
          AEGIFStickerListPart.a(this.a, null);
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty(AEGIFStickerListPart.a(this.a))) || (i != 0)) {
            break label516;
          }
          AEGIFStickerListPart.c(this.a, ((AEGifCategoryWrapper)AEGIFStickerListPart.b(this.a).get(i)).categoryId);
          if ((AEGIFStickerListPart.a(this.a) == null) || (!AEGIFStickerListPart.a(this.a).a())) {
            break;
          }
          AEBaseReportParam.a().o(AEGIFStickerListPart.a(this.a));
          AEBaseDataReporter.a().ah();
          return;
          i = ((Integer)localPair.first).intValue();
          break label61;
          label492:
          j = ((Integer)localPair.second).intValue();
          break label76;
          label507:
          AEGIFStickerListPart.a(this.a, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.7
 * JD-Core Version:    0.7.0.1
 */