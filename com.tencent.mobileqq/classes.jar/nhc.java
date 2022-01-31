import com.tencent.biz.qqstory.newshare.job.EncryptUrlJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;

public class nhc
  extends EncryptUrlJob
{
  public nhc(ShareModeBase paramShareModeBase, String paramString1, String paramString2, boolean paramBoolean, ShareWeChatData paramShareWeChatData)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData.d = ((String)a("EncryptUrlJob_encryptedUrl"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhc
 * JD-Core Version:    0.7.0.1
 */