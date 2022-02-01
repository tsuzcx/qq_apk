import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJDianDianEntryVisibleConfig$Companion;", "", "()V", "KEY_DIANDIAN_ENTRY_SHOW_CONFIG", "", "KEY_HIDE_CHANNEL_ID_CONFIG", "SHOW_ALL_CHANNEL", "", "SHOW_RECOMMEND_CHANNEL", "TAG", "hideChannelIDlist", "", "showChannelType", "initHideChannelIDList", "", "hideChannelIdsStr", "loadConfig", "reloadConfig", "shouldShowDianDianEntry", "", "channelID", "showInAllChannel", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class oyj
{
  private final void a(String paramString)
  {
    paramString = StringsKt.split$default((CharSequence)paramString, new char[] { ',' }, false, 0, 6, null);
    try
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        oyi.a().add(Integer.valueOf(Integer.parseInt(str)));
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("RIJChannelDiandianEntryAladdinCfg", 2, paramString.getMessage());
    }
  }
  
  public final void a()
  {
    Object localObject = Aladdin.getConfig(382);
    oyi.a(((AladdinConfig)localObject).getIntegerFromString("show_diandian_entry", 0));
    QLog.d("RIJChannelDiandianEntryAladdinCfg", 1, "showChannelType : " + oyi.a());
    if (oyi.a() == 1)
    {
      localObject = ((AladdinConfig)localObject).getString("hide_diandian_entry_channel_id", "");
      QLog.d("RIJChannelDiandianEntryAladdinCfg", 1, "hideChannelIdsStr : " + (String)localObject);
      oyj localoyj = (oyj)this;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "hideChannelIdsStr");
      localoyj.a((String)localObject);
    }
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool2 = true;
    if (oyi.a() == 1)
    {
      bool1 = bool2;
      if (!oyi.a().contains(Integer.valueOf(paramInt))) {}
    }
    else
    {
      if ((oyi.a() != 0) || (paramInt != 0)) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("RIJChannelDiandianEntryAladdinCfg", 2, "shouldShowDianDianEntry | channelID : " + paramInt + " ; show : " + bool1 + ", showChannelType : " + oyi.a());
      return bool1;
    }
  }
  
  public final void b()
  {
    oyi.a().clear();
    ((oyj)this).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyj
 * JD-Core Version:    0.7.0.1
 */