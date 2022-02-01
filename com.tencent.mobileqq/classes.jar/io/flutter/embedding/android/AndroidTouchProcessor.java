package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AndroidTouchProcessor
{
  private static final int BYTES_PER_FIELD = 8;
  private static final Matrix IDENTITY_TRANSFORM = new Matrix();
  private static final int POINTER_DATA_FIELD_COUNT = 29;
  private static final int POINTER_DATA_FLAG_BATCHED = 1;
  private static final int _POINTER_BUTTON_PRIMARY = 1;
  @NonNull
  private final MotionEventTracker motionEventTracker;
  @NonNull
  private final FlutterRenderer renderer;
  private final boolean trackMotionEvents;
  
  public AndroidTouchProcessor(@NonNull FlutterRenderer paramFlutterRenderer, boolean paramBoolean)
  {
    this.renderer = paramFlutterRenderer;
    this.motionEventTracker = MotionEventTracker.getInstance();
    this.trackMotionEvents = paramBoolean;
  }
  
  private void addPointerForIndex(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix, ByteBuffer paramByteBuffer)
  {
    if (paramInt2 == -1) {
      return;
    }
    long l1;
    if (this.trackMotionEvents) {
      l1 = this.motionEventTracker.track(paramMotionEvent).getId();
    } else {
      l1 = 0L;
    }
    int j = getPointerDeviceTypeForToolType(paramMotionEvent.getToolType(paramInt1));
    int i;
    if (paramMotionEvent.getActionMasked() == 8) {
      i = 1;
    } else {
      i = 0;
    }
    long l2 = paramMotionEvent.getEventTime();
    paramByteBuffer.putLong(l1);
    paramByteBuffer.putLong(l2 * 1000L);
    paramByteBuffer.putLong(paramInt2);
    paramByteBuffer.putLong(j);
    paramByteBuffer.putLong(i);
    paramByteBuffer.putLong(paramMotionEvent.getPointerId(paramInt1));
    paramByteBuffer.putLong(0L);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramMotionEvent.getX(paramInt1);
    arrayOfFloat[1] = paramMotionEvent.getY(paramInt1);
    paramMatrix.mapPoints(arrayOfFloat);
    paramByteBuffer.putDouble(arrayOfFloat[0]);
    paramByteBuffer.putDouble(arrayOfFloat[1]);
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
    if (j == 1)
    {
      l2 = paramMotionEvent.getButtonState() & 0x1F;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramMotionEvent.getSource() == 8194) {
          if (paramInt2 != 4)
          {
            l1 = l2;
            if (paramInt2 != 5) {}
          }
          else
          {
            l1 = 1L;
          }
        }
      }
    }
    else if (j == 2)
    {
      l1 = paramMotionEvent.getButtonState() >> 4 & 0xF;
    }
    else
    {
      l1 = 0L;
    }
    paramByteBuffer.putLong(l1);
    paramByteBuffer.putLong(0L);
    paramByteBuffer.putLong(0L);
    paramByteBuffer.putDouble(paramMotionEvent.getPressure(paramInt1));
    double d1 = 1.0D;
    if (paramMotionEvent.getDevice() != null)
    {
      paramMatrix = paramMotionEvent.getDevice().getMotionRange(2);
      if (paramMatrix != null)
      {
        d2 = paramMatrix.getMin();
        d1 = paramMatrix.getMax();
        break label364;
      }
    }
    double d2 = 0.0D;
    label364:
    paramByteBuffer.putDouble(d2);
    paramByteBuffer.putDouble(d1);
    if (j == 2) {
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(24, paramInt1));
    } else {
      paramByteBuffer.putDouble(0.0D);
    }
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(paramMotionEvent.getSize(paramInt1));
    paramByteBuffer.putDouble(paramMotionEvent.getToolMajor(paramInt1));
    paramByteBuffer.putDouble(paramMotionEvent.getToolMinor(paramInt1));
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(0.0D);
    paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(8, paramInt1));
    if (j == 2) {
      paramByteBuffer.putDouble(paramMotionEvent.getAxisValue(25, paramInt1));
    } else {
      paramByteBuffer.putDouble(0.0D);
    }
    paramByteBuffer.putLong(paramInt3);
    if (i == 1)
    {
      paramByteBuffer.putDouble(-paramMotionEvent.getAxisValue(10));
      d1 = -paramMotionEvent.getAxisValue(9);
    }
    else
    {
      d1 = 0.0D;
      paramByteBuffer.putDouble(0.0D);
    }
    paramByteBuffer.putDouble(d1);
  }
  
  @AndroidTouchProcessor.PointerChange
  private int getPointerChangeForAction(int paramInt)
  {
    if (paramInt == 0) {
      return 4;
    }
    if (paramInt == 1) {
      return 6;
    }
    if (paramInt == 5) {
      return 4;
    }
    if (paramInt == 6) {
      return 6;
    }
    if (paramInt == 2) {
      return 5;
    }
    if (paramInt == 7) {
      return 3;
    }
    if (paramInt == 3) {
      return 0;
    }
    if (paramInt == 8) {
      return 3;
    }
    return -1;
  }
  
  @AndroidTouchProcessor.PointerDeviceKind
  private int getPointerDeviceTypeForToolType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 4;
          }
          return 3;
        }
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public boolean onGenericMotionEvent(@NonNull MotionEvent paramMotionEvent)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 18) && (paramMotionEvent.isFromSource(2))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramMotionEvent.getActionMasked() != 7) && (paramMotionEvent.getActionMasked() != 8)) {
      j = 0;
    } else {
      j = 1;
    }
    if (i != 0)
    {
      if (j == 0) {
        return false;
      }
      i = getPointerChangeForAction(paramMotionEvent.getActionMasked());
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramMotionEvent.getPointerCount() * 29 * 8);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), i, 0, IDENTITY_TRANSFORM, localByteBuffer);
      if (localByteBuffer.position() % 232 == 0)
      {
        this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
        return true;
      }
      throw new AssertionError("Packet position is not on field boundary.");
    }
    return false;
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent, IDENTITY_TRANSFORM);
  }
  
  public boolean onTouchEvent(@NonNull MotionEvent paramMotionEvent, Matrix paramMatrix)
  {
    int k = paramMotionEvent.getPointerCount();
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(k * 29 * 8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramMotionEvent.getActionMasked();
    int m = getPointerChangeForAction(paramMotionEvent.getActionMasked());
    if ((j != 0) && (j != 5)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && ((j == 1) || (j == 6))) {
      j = 1;
    } else {
      j = 0;
    }
    if (i != 0) {}
    for (;;)
    {
      addPointerForIndex(paramMotionEvent, paramMotionEvent.getActionIndex(), m, 0, paramMatrix, localByteBuffer);
      break label188;
      if (j == 0) {
        break;
      }
      i = 0;
      while (i < k)
      {
        if ((i != paramMotionEvent.getActionIndex()) && (paramMotionEvent.getToolType(i) == 1)) {
          addPointerForIndex(paramMotionEvent, i, 5, 1, paramMatrix, localByteBuffer);
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < k)
    {
      addPointerForIndex(paramMotionEvent, i, m, 0, paramMatrix, localByteBuffer);
      i += 1;
    }
    label188:
    if (localByteBuffer.position() % 232 == 0)
    {
      this.renderer.dispatchPointerDataPacket(localByteBuffer, localByteBuffer.position());
      return true;
    }
    paramMotionEvent = new AssertionError("Packet position is not on field boundary");
    for (;;)
    {
      throw paramMotionEvent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.AndroidTouchProcessor
 * JD-Core Version:    0.7.0.1
 */