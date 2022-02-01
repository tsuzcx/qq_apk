import android.content.res.Resources;

public final class mre
{
  public static mrf a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    int[] arrayOfInt1;
    switch (paramInt)
    {
    case 2131559750: 
    case 2131559751: 
    case 2131559753: 
    default: 
      return null;
    case 2131559749: 
      localObject1 = new int[] { 2131694728, 2130842170 };
      localObject2 = new int[] { 2131694741, 2130842185 };
      arrayOfInt1 = new int[] { 2131694731, 2130842172 };
      int[] arrayOfInt2 = { 2131694740, 2130842184 };
      int[] arrayOfInt3 = { 2131694734, 2130841993 };
      int[] arrayOfInt4 = { 2131694733, 2130842174 };
      int[] arrayOfInt5 = { 2131694729, 2130842256 };
      int[] arrayOfInt6 = { 2131694732, 2130842173 };
      int[] arrayOfInt7 = { 2131694738, 2130842181 };
      localObject1 = new int[][] { localObject1, localObject2, arrayOfInt1, arrayOfInt2, { 2131694736, 2130841995 }, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7 };
    }
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[] { 2131694731, 2130842172 };
      localObject1 = new int[][] { { 2131694739, 2130842183 }, { 2131694728, 2130842170 }, { 2131694741, 2130842185 }, localObject1, { 2131694736, 2130841995 }, { 2131694732, 2130842173 }, { 2131694730, 2130842171 } };
      continue;
      localObject1 = new int[] { 2131694731, 2130842172 };
      localObject1 = new int[][] { { 2131694739, 2130842183 }, { 2131694728, 2130842170 }, { 2131694741, 2130842185 }, localObject1, { 2131694740, 2130842184 }, { 2131694736, 2130841995 }, { 2131694734, 2130841993 }, { 2131694729, 2130842256 }, { 2131694732, 2130842173 }, { 2131694730, 2130842171 } };
      continue;
      localObject1 = new int[] { 2131694736, 2130841995 };
      localObject2 = new int[] { 2131694734, 2130841993 };
      localObject1 = new int[][] { { 2131694728, 2130842170 }, localObject1, localObject2 };
    }
    Object localObject2 = new mrf();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((mrf)localObject2).a(new mrd(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((mrf)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */