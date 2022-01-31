import java.util.ArrayList;
import java.util.List;

public final class gv
{
  private final gt jdField_a_of_type_Gt;
  private final List<gu> jdField_a_of_type_JavaUtilList;
  
  public gv(gt paramgt)
  {
    if (!gt.jdField_a_of_type_Gt.equals(paramgt)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.jdField_a_of_type_Gt = paramgt;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new gu(paramgt, new int[] { 1 }));
  }
  
  private gu a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      gu localgu = (gu)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      while (i <= paramInt)
      {
        localgu = localgu.b(new gu(this.jdField_a_of_type_Gt, new int[] { 1, this.jdField_a_of_type_Gt.a(i - 1) }));
        this.jdField_a_of_type_JavaUtilList.add(localgu);
        i += 1;
      }
    }
    return (gu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    localObject = new gu(this.jdField_a_of_type_Gt, arrayOfInt).a(paramInt, 1).a(localObject)[1].a();
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
 * Qualified Name:     gv
 * JD-Core Version:    0.7.0.1
 */