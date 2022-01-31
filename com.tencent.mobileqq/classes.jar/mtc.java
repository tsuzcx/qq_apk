import android.content.res.Resources;

public final class mtc
{
  public static mtd a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559607: 
    case 2131559608: 
    case 2131559610: 
    default: 
      return null;
    case 2131559606: 
      localObject1 = new int[][] { { 2131695807, 2130841838 }, { 2131695819, 2130841852 }, { 2131695810, 2130841840 }, { 2131695815, 2130841667 }, { 2131695813, 2130841665 }, { 2131695812, 2130841842 }, { 2131695808, 2130841923 }, { 2131695811, 2130841841 }, { 2131695817, 2130841849 } };
    }
    int[] arrayOfInt1;
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[] { 2131695818, 2130841851 };
      localObject2 = new int[] { 2131695807, 2130841838 };
      arrayOfInt1 = new int[] { 2131695819, 2130841852 };
      int[] arrayOfInt2 = { 2131695815, 2130841667 };
      int[] arrayOfInt3 = { 2131695811, 2130841841 };
      int[] arrayOfInt4 = { 2131695809, 2130841839 };
      localObject1 = new int[][] { localObject1, localObject2, arrayOfInt1, { 2131695810, 2130841840 }, arrayOfInt2, arrayOfInt3, arrayOfInt4 };
      continue;
      localObject1 = new int[] { 2131695807, 2130841838 };
      localObject2 = new int[] { 2131695811, 2130841841 };
      localObject1 = new int[][] { { 2131695818, 2130841851 }, localObject1, { 2131695819, 2130841852 }, { 2131695810, 2130841840 }, { 2131695815, 2130841667 }, { 2131695813, 2130841665 }, { 2131695808, 2130841923 }, localObject2, { 2131695809, 2130841839 } };
      continue;
      localObject1 = new int[][] { { 2131695807, 2130841838 }, { 2131695815, 2130841667 }, { 2131695813, 2130841665 } };
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