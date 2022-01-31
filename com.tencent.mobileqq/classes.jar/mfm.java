import android.content.res.Resources;

public final class mfm
{
  public static mfn a(Resources paramResources, int paramInt)
  {
    Object localObject1 = (int[][])null;
    int[] arrayOfInt1;
    switch (paramInt)
    {
    case 2131493985: 
    case 2131493986: 
    case 2131493988: 
    default: 
      return null;
    case 2131493984: 
      localObject1 = new int[] { 2131629972, 2130841599 };
      localObject2 = new int[] { 2131629968, 2130841676 };
      arrayOfInt1 = new int[] { 2131629971, 2130841598 };
      int[] arrayOfInt2 = { 2131629975, 2130841606 };
      localObject1 = new int[][] { { 2131629967, 2130841595 }, { 2131629977, 2130841609 }, { 2131629970, 2130841597 }, { 2131629973, 2130841438 }, localObject1, localObject2, arrayOfInt1, arrayOfInt2 };
    }
    while (localObject1 == null)
    {
      return null;
      localObject1 = new int[] { 2131629967, 2130841595 };
      localObject2 = new int[] { 2131629977, 2130841609 };
      arrayOfInt1 = new int[] { 2131629973, 2130841438 };
      localObject1 = new int[][] { { 2131629976, 2130841608 }, localObject1, localObject2, { 2131629970, 2130841597 }, arrayOfInt1, { 2131629971, 2130841598 }, { 2131629969, 2130841596 } };
      continue;
      localObject1 = new int[][] { { 2131629976, 2130841608 }, { 2131629967, 2130841595 }, { 2131629977, 2130841609 }, { 2131629970, 2130841597 }, { 2131629973, 2130841438 }, { 2131629968, 2130841676 }, { 2131629971, 2130841598 }, { 2131629969, 2130841596 } };
      continue;
      localObject1 = new int[] { 2131629973, 2130841438 };
      localObject2 = new int[] { 2131629971, 2130841598 };
      localObject1 = new int[][] { { 2131629967, 2130841595 }, localObject1, localObject2 };
    }
    Object localObject2 = new mfn();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      arrayOfInt1 = localObject1[i];
      ((mfn)localObject2).a(new mfl(arrayOfInt1[0], paramResources.getString(arrayOfInt1[0]), arrayOfInt1[1]));
      i += 1;
    }
    ((mfn)localObject2).a = paramInt;
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfm
 * JD-Core Version:    0.7.0.1
 */