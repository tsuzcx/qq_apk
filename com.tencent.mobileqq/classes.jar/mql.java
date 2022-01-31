import android.content.res.Resources;

public final class mql
{
  public static mqm a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559555: 
    case 2131559556: 
    case 2131559558: 
    default: 
      return null;
    case 2131559554: 
      localObject1 = new int[][] { { 2131695648, 2130841687 }, { 2131695658, 2130841701 }, { 2131695651, 2130841689 }, { 2131695654, 2130841518 }, { 2131695653, 2130841691 }, { 2131695649, 2130841770 }, { 2131695652, 2130841690 }, { 2131695656, 2130841698 } };
    }
    int[] arrayOfInt1;
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[][] { { 2131695657, 2130841700 }, { 2131695648, 2130841687 }, { 2131695658, 2130841701 }, { 2131695651, 2130841689 }, { 2131695654, 2130841518 }, { 2131695652, 2130841690 }, { 2131695650, 2130841688 } };
      continue;
      localObject1 = new int[] { 2131695648, 2130841687 };
      localObject2 = new int[] { 2131695658, 2130841701 };
      arrayOfInt1 = new int[] { 2131695651, 2130841689 };
      int[] arrayOfInt2 = { 2131695649, 2130841770 };
      int[] arrayOfInt3 = { 2131695652, 2130841690 };
      localObject1 = new int[][] { { 2131695657, 2130841700 }, localObject1, localObject2, arrayOfInt1, { 2131695654, 2130841518 }, arrayOfInt2, arrayOfInt3, { 2131695650, 2130841688 } };
      continue;
      localObject1 = new int[][] { { 2131695648, 2130841687 }, { 2131695654, 2130841518 }, { 2131695652, 2130841690 } };
    }
    Object localObject2 = new mqm();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((mqm)localObject2).a(new mqk(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((mqm)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mql
 * JD-Core Version:    0.7.0.1
 */