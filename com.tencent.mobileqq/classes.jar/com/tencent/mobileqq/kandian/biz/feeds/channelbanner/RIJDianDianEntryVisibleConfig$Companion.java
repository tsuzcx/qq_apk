package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJDianDianEntryVisibleConfig$Companion;", "", "()V", "KEY_DIANDIAN_ENTRY_SHOW_CONFIG", "", "KEY_HIDE_CHANNEL_ID_CONFIG", "SHOW_ALL_CHANNEL", "", "SHOW_RECOMMEND_CHANNEL", "TAG", "hideChannelIDlist", "", "showChannelType", "initHideChannelIDList", "", "hideChannelIdsStr", "loadConfig", "reloadConfig", "shouldShowDianDianEntry", "", "channelID", "showInAllChannel", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDianDianEntryVisibleConfig$Companion
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
        RIJDianDianEntryVisibleConfig.a().add(Integer.valueOf(Integer.parseInt(str)));
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
    Object localObject1 = Aladdin.getConfig(382);
    RIJDianDianEntryVisibleConfig.a(((AladdinConfig)localObject1).getIntegerFromString("show_diandian_entry", 0));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showChannelType : ");
    ((StringBuilder)localObject2).append(RIJDianDianEntryVisibleConfig.a());
    QLog.d("RIJChannelDiandianEntryAladdinCfg", 1, ((StringBuilder)localObject2).toString());
    if (RIJDianDianEntryVisibleConfig.a() == 1)
    {
      localObject1 = ((AladdinConfig)localObject1).getString("hide_diandian_entry_channel_id", "");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("hideChannelIdsStr : ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("RIJChannelDiandianEntryAladdinCfg", 1, ((StringBuilder)localObject2).toString());
      localObject2 = (Companion)this;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "hideChannelIdsStr");
      ((Companion)localObject2).a((String)localObject1);
    }
  }
  
  public final boolean a(int paramInt)
  {
    int i = RIJDianDianEntryVisibleConfig.a();
    boolean bool2 = true;
    boolean bool1;
    if (i == 1)
    {
      bool1 = bool2;
      if (!RIJDianDianEntryVisibleConfig.a().contains(Integer.valueOf(paramInt))) {}
    }
    else if ((RIJDianDianEntryVisibleConfig.a() == 0) && (paramInt == 0))
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shouldShowDianDianEntry | channelID : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ; show : ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", showChannelType : ");
    localStringBuilder.append(RIJDianDianEntryVisibleConfig.a());
    QLog.d("RIJChannelDiandianEntryAladdinCfg", 2, localStringBuilder.toString());
    return bool1;
  }
  
  public final void b()
  {
    RIJDianDianEntryVisibleConfig.a().clear();
    ((Companion)this).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJDianDianEntryVisibleConfig.Companion
 * JD-Core Version:    0.7.0.1
 */