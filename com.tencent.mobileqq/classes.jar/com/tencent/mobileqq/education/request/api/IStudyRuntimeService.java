package com.tencent.mobileqq.education.request.api;

import com.tencent.mobileqq.education.request.IStudyCmdHandler;
import com.tencent.mobileqq.education.request.IStudyMainProcessAbility;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/api/IStudyRuntimeService;", "Lmqq/app/api/IRuntimeService;", "getAnswerSearchPicData", "", "clear", "", "getCmdHandler", "Lcom/tencent/mobileqq/education/request/IStudyCmdHandler;", "getMainProcessAbility", "Lcom/tencent/mobileqq/education/request/IStudyMainProcessAbility;", "getPicViewerAnswerSearchSwitch", "getScanAnswerSearchSwitch", "getShowScanAnswerSearchTip", "saveShowScanAnswerSearchTip", "", "value", "setAnswerSearchPicData", "data", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyRuntimeService
  extends IRuntimeService
{
  @NotNull
  public abstract String getAnswerSearchPicData(boolean paramBoolean);
  
  @NotNull
  public abstract IStudyCmdHandler getCmdHandler();
  
  @NotNull
  public abstract IStudyMainProcessAbility getMainProcessAbility();
  
  public abstract boolean getPicViewerAnswerSearchSwitch();
  
  public abstract boolean getScanAnswerSearchSwitch();
  
  public abstract boolean getShowScanAnswerSearchTip();
  
  public abstract void saveShowScanAnswerSearchTip(boolean paramBoolean);
  
  public abstract void setAnswerSearchPicData(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.api.IStudyRuntimeService
 * JD-Core Version:    0.7.0.1
 */