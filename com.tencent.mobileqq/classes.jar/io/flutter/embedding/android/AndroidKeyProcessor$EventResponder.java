package io.flutter.embedding.android;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map.Entry;

class AndroidKeyProcessor$EventResponder
  implements KeyEventChannel.EventResponseHandler
{
  private static final long MAX_PENDING_EVENTS = 1000L;
  boolean dispatchingKeyEvent = false;
  final Deque<Map.Entry<Long, KeyEvent>> pendingEvents = new ArrayDeque();
  @NonNull
  private final View view;
  
  public AndroidKeyProcessor$EventResponder(@NonNull View paramView)
  {
    this.view = paramView;
  }
  
  private KeyEvent removePendingEvent(long paramLong)
  {
    if (((Long)((Map.Entry)this.pendingEvents.getFirst()).getKey()).longValue() != paramLong)
    {
      Iterator localIterator = this.pendingEvents.iterator();
      while (localIterator.hasNext()) {
        if (((Long)((Map.Entry)localIterator.next()).getKey()).longValue() == paramLong) {
          localIterator.remove();
        }
      }
      return null;
    }
    return (KeyEvent)((Map.Entry)this.pendingEvents.removeFirst()).getValue();
  }
  
  public void addEvent(long paramLong, @NonNull KeyEvent paramKeyEvent)
  {
    if ((this.pendingEvents.size() > 0) && (((Long)((Map.Entry)this.pendingEvents.getFirst()).getKey()).longValue() >= paramLong))
    {
      paramKeyEvent = new StringBuilder();
      paramKeyEvent.append("New events must have ids greater than the most recent pending event. New id ");
      paramKeyEvent.append(paramLong);
      paramKeyEvent.append(" is less than or equal to the last event id of ");
      paramKeyEvent.append(((Map.Entry)this.pendingEvents.getFirst()).getKey());
      throw new AssertionError(paramKeyEvent.toString());
    }
    this.pendingEvents.addLast(new AbstractMap.SimpleImmutableEntry(Long.valueOf(paramLong), paramKeyEvent));
    if (this.pendingEvents.size() > 1000L)
    {
      paramKeyEvent = new StringBuilder();
      paramKeyEvent.append("There are ");
      paramKeyEvent.append(this.pendingEvents.size());
      paramKeyEvent.append(" keyboard events that have not yet received a response. Are responses being sent?");
      Log.e("AndroidKeyProcessor", paramKeyEvent.toString());
    }
  }
  
  public void dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    View localView = this.view;
    if ((localView != null) && (paramKeyEvent != null))
    {
      this.dispatchingKeyEvent = true;
      localView.getRootView().dispatchKeyEvent(paramKeyEvent);
      this.dispatchingKeyEvent = false;
    }
  }
  
  public void onKeyEventHandled(long paramLong)
  {
    removePendingEvent(paramLong);
  }
  
  public void onKeyEventNotHandled(long paramLong)
  {
    dispatchKeyEvent(removePendingEvent(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidKeyProcessor.EventResponder
 * JD-Core Version:    0.7.0.1
 */