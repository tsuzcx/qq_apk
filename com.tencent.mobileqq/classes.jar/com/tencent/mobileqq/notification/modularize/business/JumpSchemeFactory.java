package com.tencent.mobileqq.notification.modularize.business;

import com.tencent.mobileqq.notification.modularize.BaseJumpScheme;
import com.tencent.mobileqq.notification.modularize.PushComponent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class JumpSchemeFactory
{
  public static final JumpSchemeFactory a;
  private static final Map<Integer, BaseJumpScheme> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqNotificationModularizeBusinessJumpSchemeFactory = new JumpSchemeFactory();
    jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new FallbackJumpScheme()), TuplesKt.to(Integer.valueOf(-1), new NativeUiJumpScheme()), TuplesKt.to(Integer.valueOf(4), new AudioRoomScheme()), TuplesKt.to(Integer.valueOf(5), new KanDianJumpScheme()) });
  }
  
  @NotNull
  public final BaseJumpScheme a(@NotNull PushComponent paramPushComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramPushComponent, "pushComponent");
    if (paramPushComponent.jdField_a_of_type_Boolean) {
      paramPushComponent = (BaseJumpScheme)new FallbackJumpScheme();
    }
    BaseJumpScheme localBaseJumpScheme;
    do
    {
      return paramPushComponent;
      localBaseJumpScheme = (BaseJumpScheme)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramPushComponent.jdField_a_of_type_Int));
      paramPushComponent = localBaseJumpScheme;
    } while (localBaseJumpScheme != null);
    return (BaseJumpScheme)new DefaultJumpScheme();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.business.JumpSchemeFactory
 * JD-Core Version:    0.7.0.1
 */