import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ryh
  extends SosoInterface.OnLocationListener
{
  public ryh(EditVideoFragment paramEditVideoFragment, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.EditVideoFragment", 2, "onLocationFinish() errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {}
    try
    {
      EditVideoFragment.a(this.a).put("latitude", (int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      EditVideoFragment.a(this.a).put("longitude", (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      EditVideoFragment.a(this.a).put("is_user_selected", 0);
      return;
    }
    catch (JSONException paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryh
 * JD-Core Version:    0.7.0.1
 */