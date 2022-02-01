package com.tencent.mobileqq.guild.widget;

import android.content.res.Resources;
import com.tencent.mobileqq.guild.profilecard.game.GuildProfileGameGloryKingData;
import com.tencent.mobileqq.qqguildsdk.data.IGProSmobaArchiveTemplateInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.qphone.base.util.QLog;

public class GloryOfKingUtils
{
  public static GuildProfileGameGloryKingData a(IGProSmobaArchiveTemplateInfo paramIGProSmobaArchiveTemplateInfo, Resources paramResources)
  {
    if (paramIGProSmobaArchiveTemplateInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("GloryOfKingUtils", 1, "IGProSmobaArchiveTemplateInfo is null");
      }
      return null;
    }
    int i = paramIGProSmobaArchiveTemplateInfo.a();
    if (i <= 0) {
      return null;
    }
    GuildProfileGameGloryKingData localGuildProfileGameGloryKingData = new GuildProfileGameGloryKingData();
    localGuildProfileGameGloryKingData.h(paramIGProSmobaArchiveTemplateInfo.d());
    localGuildProfileGameGloryKingData.g(paramIGProSmobaArchiveTemplateInfo.c());
    localGuildProfileGameGloryKingData.a(paramIGProSmobaArchiveTemplateInfo.b());
    localGuildProfileGameGloryKingData.i(paramIGProSmobaArchiveTemplateInfo.e());
    localGuildProfileGameGloryKingData.j(paramIGProSmobaArchiveTemplateInfo.f());
    localGuildProfileGameGloryKingData.a(paramIGProSmobaArchiveTemplateInfo.g());
    ITroopGameCardUtilsApi localITroopGameCardUtilsApi = (ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class);
    localGuildProfileGameGloryKingData.b(localITroopGameCardUtilsApi.getMemberGameCardBgImagePath(false));
    if (i / 100000 >= 8)
    {
      localGuildProfileGameGloryKingData.a(true);
      localGuildProfileGameGloryKingData.c(paramResources.getString(2131890546, new Object[] { String.valueOf(paramIGProSmobaArchiveTemplateInfo.b()) }));
    }
    else
    {
      localGuildProfileGameGloryKingData.f(localITroopGameCardUtilsApi.getGameGradeNumberIconPathById(i));
    }
    localGuildProfileGameGloryKingData.d(localITroopGameCardUtilsApi.getGameGradeStarImagePathById(i));
    localGuildProfileGameGloryKingData.e(localITroopGameCardUtilsApi.getGameGradeIconPathById(i));
    localGuildProfileGameGloryKingData.a(localITroopGameCardUtilsApi.getGradeDescById(i));
    return localGuildProfileGameGloryKingData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.GloryOfKingUtils
 * JD-Core Version:    0.7.0.1
 */