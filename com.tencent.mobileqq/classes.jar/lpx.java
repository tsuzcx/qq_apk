import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.model.AtlasModel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class lpx
  implements ReadInJoyAtlasFragment.ReportEventListener
{
  public lpx(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ReadInJoyAtlasFragment.a, 2, "ReportEventListener.onReportEvent(" + paramInt + ", data=" + paramBundle + ")");
    }
    switch (paramInt)
    {
    case 0: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case -1: 
      do
      {
        return;
        PublicAccountReportUtils.a(null, "", "0X8008E37", "0X8008E37", 0, 0, "", "", "", GalleryReportedUtils.b(BaseApplicationImpl.getContext(), ReadInJoyAtlasFragment.a(this.a).c(), ReadInJoyAtlasFragment.c(this.a), ReadInJoyAtlasFragment.a(this.a), ReadInJoyAtlasFragment.a(this.a), paramInt), false);
        return;
      } while (paramBundle == null);
      paramBundle = (AtlasModel)paramBundle.getSerializable("lastShowImageModel");
      ReadInJoyAtlasFragment.a(this.a, paramBundle);
      return;
    }
    paramInt = -1;
    if (paramBundle != null)
    {
      AtlasModel localAtlasModel = (AtlasModel)paramBundle.getSerializable("lastShowImageModel");
      if (localAtlasModel != null) {
        localAtlasModel.modelExitTime = System.currentTimeMillis();
      }
      ReadInJoyAtlasFragment.a(this.a, localAtlasModel);
      paramInt = paramBundle.getInt("exitType", -1);
    }
    if (ReadInJoyAtlasFragment.b(this.a) < ReadInJoyAtlasFragment.b(this.a) - 1L) {}
    for (int i = 2;; i = 1)
    {
      paramBundle = ReadInJoyAtlasFragment.c(this.a);
      paramBundle = GalleryReportedUtils.a(BaseApplicationImpl.getContext(), ReadInJoyAtlasFragment.a(this.a).c(), ReadInJoyAtlasFragment.c(this.a), ReadInJoyAtlasFragment.a(this.a), ReadInJoyAtlasFragment.a(this.a), ReadInJoyAtlasFragment.b(this.a) + 1, ReadInJoyAtlasFragment.b(this.a), paramInt, ReadInJoyAtlasFragment.d(this.a), ReadInJoyAtlasFragment.d(this.a), i, ReadInJoyAtlasFragment.b(this.a), paramBundle.toString(), ReadInJoyAtlasFragment.e(this.a));
      PublicAccountReportUtils.a(null, "", "0X8008E30", "0X8008E30", 0, 0, "", ReadInJoyAtlasFragment.a(this.a) + "", ReadInJoyAtlasFragment.c(this.a) + "", paramBundle, false);
      GalleryReportedUtils.a(1, Long.valueOf(ReadInJoyAtlasFragment.a(this.a).getCurrentAccountUin()).longValue(), (int)ReadInJoyAtlasFragment.c(this.a), ReadInJoyAtlasFragment.c(this.a), ReadInJoyAtlasFragment.d(this.a), (int)ReadInJoyAtlasFragment.b(this.a), ReadInJoyAtlasFragment.d(this.a), i, ReadInJoyAtlasFragment.a(this.a), ReadInJoyAtlasFragment.b(this.a), ReadInJoyAtlasFragment.a(this.a), ReadInJoyAtlasFragment.e(this.a));
      ReadInJoyAtlasFragment.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpx
 * JD-Core Version:    0.7.0.1
 */