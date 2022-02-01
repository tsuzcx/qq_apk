import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerHelper$Companion;", "", "()V", "TAG", "", "superPlayerFlag", "", "useSuperPlayer", "", "getUseSuperPlayer", "()Z", "selectPlayerFactory", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "selectPlayerSDKMgr", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "setSuperPlayerFlag", "", "isSuperPlayer", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class siz
{
  @NotNull
  public final sir a()
  {
    if (((siz)this).a()) {
      return (sir)sjd.a;
    }
    return (sir)sjj.a;
  }
  
  @NotNull
  public final siw a()
  {
    if (((siz)this).a()) {
      return (siw)sjf.a;
    }
    return (siw)sjk.a;
  }
  
  public final boolean a()
  {
    if (siy.a() == -1) {
      siy.a(Aladdin.getConfig(307).getIntegerFromString("super_player_enable", 0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("PlayerHelper", 2, "useSuperPlayer: " + siy.a());
    }
    return siy.a() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     siz
 * JD-Core Version:    0.7.0.1
 */