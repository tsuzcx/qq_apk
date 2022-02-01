import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.av.business.manager.pendant.PendantItem;

public class lhc
  implements lgq<PendantItem>
{
  public lhc(MagicFaceDataEntity paramMagicFaceDataEntity) {}
  
  public void a(long paramLong, PendantItem paramPendantItem) {}
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    lbj.c("MagicFaceDataEntity", "onDownloadFinish: " + paramPendantItem.toString() + "|" + paramBoolean);
    if (paramBoolean) {
      MagicFaceDataEntity.a(this.a, paramLong, paramPendantItem);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhc
 * JD-Core Version:    0.7.0.1
 */