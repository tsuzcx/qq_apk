import java.util.ArrayList;
import java.util.List;

public final class im
{
  private final ik jdField_a_of_type_Ik;
  private final List<il> jdField_a_of_type_JavaUtilList;
  
  public im(ik paramik)
  {
    if (!ik.jdField_a_of_type_Ik.equals(paramik)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.jdField_a_of_type_Ik = paramik;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new il(paramik, new int[] { 1 }));
  }
  
  private il a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      il localil = (il)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      while (i <= paramInt)
      {
        localil = localil.b(new il(this.jdField_a_of_type_Ik, new int[] { 1, this.jdField_a_of_type_Ik.a(i - 1) }));
        this.jdField_a_of_type_JavaUtilList.add(localil);
        i += 1;
      }
    }
    return (il)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    localObject = new il(this.jdField_a_of_type_Ik, arrayOfInt).a(paramInt, 1).a(localObject)[1].a();
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
 * Qualified Name:     im
 * JD-Core Version:    0.7.0.1
 */