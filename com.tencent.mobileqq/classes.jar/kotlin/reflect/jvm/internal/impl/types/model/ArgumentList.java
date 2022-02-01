package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

public final class ArgumentList
  extends ArrayList<TypeArgumentMarker>
  implements TypeArgumentListMarker
{
  public ArgumentList(int paramInt)
  {
    super(paramInt);
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.ArgumentList
 * JD-Core Version:    0.7.0.1
 */