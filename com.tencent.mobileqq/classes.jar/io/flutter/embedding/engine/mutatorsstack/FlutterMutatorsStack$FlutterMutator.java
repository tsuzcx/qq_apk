package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.annotation.Nullable;

public class FlutterMutatorsStack$FlutterMutator
{
  @Nullable
  private Matrix matrix;
  @Nullable
  private Path path;
  @Nullable
  private Rect rect;
  private FlutterMutatorsStack.FlutterMutatorType type = FlutterMutatorsStack.FlutterMutatorType.CLIP_RECT;
  
  public FlutterMutatorsStack$FlutterMutator(FlutterMutatorsStack paramFlutterMutatorsStack, Matrix paramMatrix)
  {
    this.matrix = paramMatrix;
  }
  
  public FlutterMutatorsStack$FlutterMutator(FlutterMutatorsStack paramFlutterMutatorsStack, Path paramPath)
  {
    this.path = paramPath;
  }
  
  public FlutterMutatorsStack$FlutterMutator(FlutterMutatorsStack paramFlutterMutatorsStack, Rect paramRect)
  {
    this.rect = paramRect;
  }
  
  public Matrix getMatrix()
  {
    return this.matrix;
  }
  
  public Path getPath()
  {
    return this.path;
  }
  
  public Rect getRect()
  {
    return this.rect;
  }
  
  public FlutterMutatorsStack.FlutterMutatorType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack.FlutterMutator
 * JD-Core Version:    0.7.0.1
 */