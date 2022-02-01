package com.tencent.mobileqq.studymode;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "", "onIReqGetSimpleUISwitch", "", "isSuccess", "", "bSwitch", "sStudySwitch", "bPref", "", "uin", "", "onISwitchSimpleUICallback", "isSuc", "bChangeTheme", "bSwitchElsePref", "statusCode", "onModeChangeComplete", "targetType", "oldType", "message", "onModeChangeStart", "onModeSwitching", "onSelectModeRecover", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface ModeSwitchManager$OnModeChangeResultCallback
{
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, @NotNull String paramString);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract void c(int paramInt1, int paramInt2);
  
  public abstract void d(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeSwitchManager.OnModeChangeResultCallback
 * JD-Core Version:    0.7.0.1
 */