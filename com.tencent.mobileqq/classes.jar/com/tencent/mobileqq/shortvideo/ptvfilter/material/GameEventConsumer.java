package com.tencent.mobileqq.shortvideo.ptvfilter.material;

public class GameEventConsumer
{
  private GameEvent a = null;
  
  public GameEventConsumer(GameEvent.GestureEventListener paramGestureEventListener)
  {
    this.a = new GameEvent(paramGestureEventListener);
  }
  
  public void a(GameEventConsumer.MotionEventData paramMotionEventData, long paramLong)
  {
    switch (paramMotionEventData.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      return;
    case 5: 
      this.a.a(paramLong, paramMotionEventData.c, paramMotionEventData.jdField_a_of_type_Float, paramMotionEventData.jdField_b_of_type_Float, 5, paramMotionEventData.jdField_a_of_type_Long);
      return;
    case 0: 
      this.a.a(paramLong, paramMotionEventData.jdField_a_of_type_ArrayOfInt[0], paramMotionEventData.jdField_a_of_type_ArrayOfFloat[0], paramMotionEventData.jdField_b_of_type_ArrayOfFloat[0], 0, paramMotionEventData.jdField_a_of_type_Long);
      return;
    case 2: 
      this.a.a(paramLong, paramMotionEventData.jdField_a_of_type_ArrayOfInt, paramMotionEventData.jdField_a_of_type_ArrayOfFloat, paramMotionEventData.jdField_b_of_type_ArrayOfFloat, paramMotionEventData.jdField_a_of_type_Long);
      return;
    case 6: 
      this.a.b(paramLong, paramMotionEventData.c, paramMotionEventData.jdField_a_of_type_Float, paramMotionEventData.jdField_b_of_type_Float, 6, paramMotionEventData.jdField_a_of_type_Long);
      return;
    case 1: 
      this.a.b(paramLong, paramMotionEventData.jdField_a_of_type_ArrayOfInt[0], paramMotionEventData.jdField_a_of_type_ArrayOfFloat[0], paramMotionEventData.jdField_b_of_type_ArrayOfFloat[0], 1, paramMotionEventData.jdField_a_of_type_Long);
      return;
    }
    this.a.b(paramLong, paramMotionEventData.jdField_a_of_type_ArrayOfInt, paramMotionEventData.jdField_a_of_type_ArrayOfFloat, paramMotionEventData.jdField_b_of_type_ArrayOfFloat, paramMotionEventData.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.GameEventConsumer
 * JD-Core Version:    0.7.0.1
 */