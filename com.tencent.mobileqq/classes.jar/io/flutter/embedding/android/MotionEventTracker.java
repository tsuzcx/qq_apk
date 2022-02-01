package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import java.util.PriorityQueue;

public final class MotionEventTracker
{
  private static MotionEventTracker INSTANCE;
  private final LongSparseArray<MotionEvent> eventById = new LongSparseArray();
  private final PriorityQueue<Long> unusedEvents = new PriorityQueue();
  
  public static MotionEventTracker getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new MotionEventTracker();
    }
    return INSTANCE;
  }
  
  @Nullable
  public MotionEvent pop(MotionEventTracker.MotionEventId paramMotionEventId)
  {
    while ((!this.unusedEvents.isEmpty()) && (((Long)this.unusedEvents.peek()).longValue() < MotionEventTracker.MotionEventId.access$000(paramMotionEventId))) {
      this.eventById.remove(((Long)this.unusedEvents.poll()).longValue());
    }
    if ((!this.unusedEvents.isEmpty()) && (((Long)this.unusedEvents.peek()).longValue() == MotionEventTracker.MotionEventId.access$000(paramMotionEventId))) {
      this.unusedEvents.poll();
    }
    MotionEvent localMotionEvent = (MotionEvent)this.eventById.get(MotionEventTracker.MotionEventId.access$000(paramMotionEventId));
    this.eventById.remove(MotionEventTracker.MotionEventId.access$000(paramMotionEventId));
    return localMotionEvent;
  }
  
  public MotionEventTracker.MotionEventId track(MotionEvent paramMotionEvent)
  {
    MotionEventTracker.MotionEventId localMotionEventId = MotionEventTracker.MotionEventId.createUnique();
    this.eventById.put(MotionEventTracker.MotionEventId.access$000(localMotionEventId), MotionEvent.obtain(paramMotionEvent));
    this.unusedEvents.add(Long.valueOf(MotionEventTracker.MotionEventId.access$000(localMotionEventId)));
    return localMotionEventId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.MotionEventTracker
 * JD-Core Version:    0.7.0.1
 */