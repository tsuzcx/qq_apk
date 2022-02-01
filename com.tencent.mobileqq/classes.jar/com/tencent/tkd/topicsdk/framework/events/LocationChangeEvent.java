package com.tencent.tkd.topicsdk.framework.events;

import .r8.java8methods.utility.Integer.hashCode.II;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/events/LocationChangeEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "eventKey", "", "pageId", "(II)V", "getEventKey", "()I", "getPageId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class LocationChangeEvent
  implements IEvent
{
  public static final LocationChangeEvent.Companion a;
  private static final int c = 1;
  private static final int d = 2;
  private final int a;
  private final int b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkEventsLocationChangeEvent$Companion = new LocationChangeEvent.Companion(null);
  }
  
  public LocationChangeEvent(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LocationChangeEvent))
      {
        paramObject = (LocationChangeEvent)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.jdField_a_of_type_Int) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationChangeEvent(eventKey=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", pageId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.events.LocationChangeEvent
 * JD-Core Version:    0.7.0.1
 */