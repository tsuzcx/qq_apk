import android.content.res.Resources;

public final class mtc
{
  public static mtd a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    int[] arrayOfInt1;
    switch (paramInt)
    {
    case 2131559606: 
    case 2131559607: 
    case 2131559609: 
    default: 
      return null;
    case 2131559605: 
      localObject1 = new int[] { 2131695809, 2130841851 };
      localObject2 = new int[] { 2131695812, 2130841853 };
      arrayOfInt1 = new int[] { 2131695814, 2130841855 };
      localObject1 = new int[][] { localObject1, { 2131695821, 2130841865 }, localObject2, { 2131695817, 2130841680 }, { 2131695815, 2130841678 }, arrayOfInt1, { 2131695810, 2130841936 }, { 2131695813, 2130841854 }, { 2131695819, 2130841862 } };
    }
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[][] { { 2131695820, 2130841864 }, { 2131695809, 2130841851 }, { 2131695821, 2130841865 }, { 2131695812, 2130841853 }, { 2131695817, 2130841680 }, { 2131695813, 2130841854 }, { 2131695811, 2130841852 } };
      continue;
      localObject1 = new int[] { 2131695820, 2130841864 };
      localObject2 = new int[] { 2131695809, 2130841851 };
      arrayOfInt1 = new int[] { 2131695821, 2130841865 };
      int[] arrayOfInt2 = { 2131695812, 2130841853 };
      int[] arrayOfInt3 = { 2131695817, 2130841680 };
      int[] arrayOfInt4 = { 2131695810, 2130841936 };
      int[] arrayOfInt5 = { 2131695811, 2130841852 };
      localObject1 = new int[][] { localObject1, localObject2, arrayOfInt1, arrayOfInt2, arrayOfInt3, { 2131695815, 2130841678 }, arrayOfInt4, { 2131695813, 2130841854 }, arrayOfInt5 };
      continue;
      localObject1 = new int[][] { { 2131695809, 2130841851 }, { 2131695817, 2130841680 }, { 2131695815, 2130841678 } };
    }
    Object localObject2 = new mtd();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((mtd)localObject2).a(new mtb(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((mtd)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mtc
 * JD-Core Version:    0.7.0.1
 */