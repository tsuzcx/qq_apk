import android.content.res.Resources;

public final class mqn
{
  public static mqo a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    switch (paramInt)
    {
    case 2131559752: 
    case 2131559753: 
    case 2131559755: 
    default: 
      return null;
    case 2131559751: 
      localObject1 = new int[][] { { 2131694866, 2130842212 }, { 2131694879, 2130842227 }, { 2131694869, 2130842214 }, { 2131694878, 2130842226 }, { 2131694874, 2130842037 }, { 2131694872, 2130842035 }, { 2131694871, 2130842216 }, { 2131694867, 2130842298 }, { 2131694870, 2130842215 }, { 2131694876, 2130842223 } };
    }
    int[] arrayOfInt1;
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[][] { { 2131694877, 2130842225 }, { 2131694866, 2130842212 }, { 2131694879, 2130842227 }, { 2131694869, 2130842214 }, { 2131694874, 2130842037 }, { 2131694870, 2130842215 }, { 2131694868, 2130842213 } };
      continue;
      localObject1 = new int[] { 2131694866, 2130842212 };
      localObject2 = new int[] { 2131694878, 2130842226 };
      arrayOfInt1 = new int[] { 2131694874, 2130842037 };
      int[] arrayOfInt2 = { 2131694872, 2130842035 };
      int[] arrayOfInt3 = { 2131694868, 2130842213 };
      localObject1 = new int[][] { { 2131694877, 2130842225 }, localObject1, { 2131694879, 2130842227 }, { 2131694869, 2130842214 }, localObject2, arrayOfInt1, arrayOfInt2, { 2131694867, 2130842298 }, { 2131694870, 2130842215 }, arrayOfInt3 };
      continue;
      localObject1 = new int[][] { { 2131694866, 2130842212 }, { 2131694874, 2130842037 }, { 2131694872, 2130842035 } };
    }
    Object localObject2 = new mqo();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((mqo)localObject2).a(new mqm(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((mqo)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqn
 * JD-Core Version:    0.7.0.1
 */