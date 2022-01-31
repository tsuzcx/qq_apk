import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.1;
import com.tencent.mobileqq.app.ThreadManager;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class qut
  extends pnm
{
  public qut(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      ReadinjoyTabFrame.d(this.a);
      ThreadManager.post(new ReadinjoyTabFrame.28.1(this, paramGuideInfo2, paramInt, paramRefreshInfo, paramSkinInfo, paramGuideInfo1), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qut
 * JD-Core Version:    0.7.0.1
 */