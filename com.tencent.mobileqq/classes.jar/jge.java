import com.tencent.av.AVLog;
import com.tencent.av.business.manager.EffectConfigBase.IEffectConfigCallback;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.av.business.manager.pendant.PendantItem;

public class jge
  implements EffectConfigBase.IEffectConfigCallback
{
  public jge(MagicFaceDataEntity paramMagicFaceDataEntity) {}
  
  public void a(PendantItem paramPendantItem) {}
  
  public void a(PendantItem paramPendantItem, int paramInt) {}
  
  public void a(PendantItem paramPendantItem, boolean paramBoolean)
  {
    AVLog.c("MagicFaceDataEntity", "onDownloadFinish: " + paramPendantItem.toString() + "|" + paramBoolean);
    if (paramBoolean) {
      MagicFaceDataEntity.a(this.a, paramPendantItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jge
 * JD-Core Version:    0.7.0.1
 */