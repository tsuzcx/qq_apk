import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareQZoneData;

public class nfv
  extends EncryptUrlJob
{
  public nfv(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareQZoneData paramShareQZoneData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareQZoneData.e = ((String)a("EncryptUrlJob_encryptedUrl"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfv
 * JD-Core Version:    0.7.0.1
 */