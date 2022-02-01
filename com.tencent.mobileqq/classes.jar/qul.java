import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.GuideInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.RefreshInfo;
import tencent.im.oidb.cmd0x5bd.oidb_0x5bd.SkinInfo;

public class qul
  extends qtv
{
  qul(quk paramquk) {}
  
  public void a(boolean paramBoolean, oidb_0x5bd.SkinInfo paramSkinInfo, oidb_0x5bd.GuideInfo paramGuideInfo1, oidb_0x5bd.GuideInfo paramGuideInfo2, oidb_0x5bd.RefreshInfo paramRefreshInfo, int paramInt)
  {
    if ((paramBoolean) && (paramInt == quk.a(this.a))) {
      ThreadManager.post(new ReadInjoySkinAndRefreshFacade.2.1(this, paramGuideInfo2, paramInt, paramRefreshInfo, paramSkinInfo, paramGuideInfo1), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qul
 * JD-Core Version:    0.7.0.1
 */