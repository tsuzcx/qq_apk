package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import org.jetbrains.annotations.NotNull;

public abstract interface TypeParameterDescriptor
  extends ClassifierDescriptor, TypeParameterMarker
{
  public abstract int getIndex();
  
  @NotNull
  public abstract TypeParameterDescriptor getOriginal();
  
  @NotNull
  public abstract StorageManager getStorageManager();
  
  @NotNull
  public abstract TypeConstructor getTypeConstructor();
  
  @NotNull
  public abstract List<KotlinType> getUpperBounds();
  
  @NotNull
  public abstract Variance getVariance();
  
  public abstract boolean isCapturedFromOuterDeclaration();
  
  public abstract boolean isReified();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */