import java.util.ArrayList;
import java.util.List;

public final class gu
{
  private final gs jdField_a_of_type_Gs;
  private final List<gt> jdField_a_of_type_JavaUtilList;
  
  public gu(gs paramgs)
  {
    if (!gs.jdField_a_of_type_Gs.equals(paramgs)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.jdField_a_of_type_Gs = paramgs;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new gt(paramgs, new int[] { 1 }));
  }
  
  private gt a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      gt localgt = (gt)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      while (i <= paramInt)
      {
        localgt = localgt.b(new gt(this.jdField_a_of_type_Gs, new int[] { 1, this.jdField_a_of_type_Gs.a(i - 1) }));
        this.jdField_a_of_type_JavaUtilList.add(localgt);
        i += 1;
      }
    }
    return (gt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("No error correction bytes");
    }
    int i = paramArrayOfInt.length - paramInt;
    if (i <= 0) {
      throw new IllegalArgumentException("No data bytes provided");
    }
    Object localObject = a(paramInt);
    int[] arrayOfInt = new int[i];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    localObject = new gt(this.jdField_a_of_type_Gs, arrayOfInt).a(paramInt, 1).a(localObject)[1].a();
    int j = paramInt - localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      paramArrayOfInt[(i + paramInt)] = 0;
      paramInt += 1;
    }
    System.arraycopy(localObject, 0, paramArrayOfInt, i + j, localObject.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gu
 * JD-Core Version:    0.7.0.1
 */