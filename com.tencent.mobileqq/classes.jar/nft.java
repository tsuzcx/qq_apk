import android.graphics.Bitmap;
import com.tencent.biz.qqstory.newshare.job.WeChatImageJob;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.newshare.model.ShareWeChatData;

public class nft
  extends WeChatImageJob
{
  public nft(ShareModeBase paramShareModeBase, boolean paramBoolean1, boolean paramBoolean2, ShareWeChatData paramShareWeChatData)
  {
    super(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareModelShareWeChatData.a = ((Bitmap)a("WeChatImageJob_out_bitmap"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nft
 * JD-Core Version:    0.7.0.1
 */