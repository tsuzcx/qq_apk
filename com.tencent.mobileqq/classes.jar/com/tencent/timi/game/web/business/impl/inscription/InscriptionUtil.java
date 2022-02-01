package com.tencent.timi.game.web.business.impl.inscription;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleAbsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/web/business/impl/inscription/InscriptionUtil;", "", "()V", "convertSmobaRoleListToJson", "Lorg/json/JSONObject;", "list", "", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleAbsInfo;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class InscriptionUtil
{
  public static final InscriptionUtil a = new InscriptionUtil();
  
  @NotNull
  public final JSONObject a(@Nullable List<GameDataServerOuterClass.SmobaGameRoleAbsInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramList != null)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        GameDataServerOuterClass.SmobaGameRoleAbsInfo localSmobaGameRoleAbsInfo = (GameDataServerOuterClass.SmobaGameRoleAbsInfo)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("area", localSmobaGameRoleAbsInfo.area.get());
        localJSONObject.put("partition", localSmobaGameRoleAbsInfo.partition.get());
        localJSONObject.put("roleName", localSmobaGameRoleAbsInfo.role_name.get());
        localJSONObject.put("logicGradeLevel", localSmobaGameRoleAbsInfo.logic_grade_level.get());
        localJSONObject.put("dispGradeLevel", localSmobaGameRoleAbsInfo.disp_grade_level.get());
        localJSONObject.put("gradeLevelName", localSmobaGameRoleAbsInfo.grade_level_name.get());
        localJSONObject.put("gradeLevelShortName", localSmobaGameRoleAbsInfo.grade_level_short_name.get());
        localJSONObject.put("roleLevel", localSmobaGameRoleAbsInfo.role_level.get());
        localJSONObject.put("roleDesc", localSmobaGameRoleAbsInfo.role_desc.get());
        localJSONObject.put("isDefault", localSmobaGameRoleAbsInfo.is_default.get());
        localJSONObject.put("bigGradeLevel", localSmobaGameRoleAbsInfo.big_grade_level.get());
        localJSONArray.put(localJSONObject);
      }
    }
    paramList = new JSONObject();
    paramList.put("smobaRoleList", localJSONArray);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.inscription.InscriptionUtil
 * JD-Core Version:    0.7.0.1
 */