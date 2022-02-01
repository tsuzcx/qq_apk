import java.util.List;

public class mqp
{
  public static int a(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt, 0);
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null)
    {
      paramInt2 = -1;
      return paramInt2;
    }
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfInt.length) {
        break label38;
      }
      paramInt2 = i;
      if (paramInt1 == paramArrayOfInt[i]) {
        break;
      }
      i += 1;
    }
    label38:
    return -1;
  }
  
  public static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject, 0);
  }
  
  public static int a(Object[] paramArrayOfObject, Object paramObject, int paramInt)
  {
    if (paramArrayOfObject == null)
    {
      paramInt = -1;
      return paramInt;
    }
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      int i;
      if (paramObject == null)
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramArrayOfObject[i] == null) {
            break;
          }
          i += 1;
        }
      }
      if (paramArrayOfObject.getClass().getComponentType().isInstance(paramObject))
      {
        i = paramInt;
        for (;;)
        {
          if (i >= paramArrayOfObject.length) {
            break label82;
          }
          paramInt = i;
          if (paramObject.equals(paramArrayOfObject[i])) {
            break;
          }
          i += 1;
        }
      }
      label82:
      return -1;
    }
  }
  
  public static <T> boolean a(List<T> paramList, T paramT)
  {
    if (paramList == null) {}
    while (paramList.indexOf(paramT) < 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    return a(paramArrayOfInt, paramInt) != -1;
  }
  
  public static boolean a(Object[] paramArrayOfObject, Object paramObject)
  {
    return a(paramArrayOfObject, paramObject) != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqp
 * JD-Core Version:    0.7.0.1
 */