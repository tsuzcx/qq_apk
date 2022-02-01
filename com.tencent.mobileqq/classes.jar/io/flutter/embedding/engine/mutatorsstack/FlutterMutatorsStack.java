package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

@Keep
public class FlutterMutatorsStack
{
  private List<Path> finalClippingPaths = new ArrayList();
  private Matrix finalMatrix = new Matrix();
  @NonNull
  private List<FlutterMutatorsStack.FlutterMutator> mutators = new ArrayList();
  
  public List<Path> getFinalClippingPaths()
  {
    return this.finalClippingPaths;
  }
  
  public Matrix getFinalMatrix()
  {
    return this.finalMatrix;
  }
  
  public List<FlutterMutatorsStack.FlutterMutator> getMutators()
  {
    return this.mutators;
  }
  
  public void pushClipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new FlutterMutatorsStack.FlutterMutator(this, localRect);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRect(new RectF(localRect), Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
  }
  
  public void pushTransform(float[] paramArrayOfFloat)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    paramArrayOfFloat = new FlutterMutatorsStack.FlutterMutator(this, localMatrix);
    this.mutators.add(paramArrayOfFloat);
    this.finalMatrix.preConcat(paramArrayOfFloat.getMatrix());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack
 * JD-Core Version:    0.7.0.1
 */