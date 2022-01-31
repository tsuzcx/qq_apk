import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.qphone.base.util.QLog;

public class qev
  implements pcr
{
  public qev(ComponentPGCShortContentBig paramComponentPGCShortContentBig, qmt paramqmt) {}
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((ComponentPGCShortContentBig.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPGCShortContentBig) != null) && ((ComponentPGCShortContentBig.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPGCShortContentBig) instanceof VideoView)))
    {
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        paramArrayOfString2 = paramArrayOfString2[0];
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Qmt.e)) && (this.jdField_a_of_type_Qmt.e.equals(paramArrayOfString1[0])) && (this.jdField_a_of_type_Qmt.e.equals(((MediaVideoView)ComponentPGCShortContentBig.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPGCShortContentBig)).a())))
        {
          ComponentPGCShortContentBig.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPGCShortContentBig, paramArrayOfString2);
          return;
        }
        QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not current video");
        return;
      }
      QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "urls null");
      return;
    }
    QLog.d("gifvideo.ComponentPGCShortContentBig", 2, "not vieoview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qev
 * JD-Core Version:    0.7.0.1
 */