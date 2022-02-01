package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import friendlist.GetTroopListRespV2;
import java.util.Map;

public abstract class AbsTroopListHandlerProcessor
{
  protected void a(@NonNull AppInterface paramAppInterface) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, GetTroopListRespV2 paramGetTroopListRespV2) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, Map<String, Boolean> paramMap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.AbsTroopListHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */