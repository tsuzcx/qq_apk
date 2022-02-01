import java.util.ArrayList;
import java.util.List;

public final class gw
{
  private final gu jdField_a_of_type_Gu;
  private final List<gv> jdField_a_of_type_JavaUtilList;
  
  public gw(gu paramgu)
  {
    if (!gu.jdField_a_of_type_Gu.equals(paramgu)) {
      throw new IllegalArgumentException("Only QR Code is supported at this time");
    }
    this.jdField_a_of_type_Gu = paramgu;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new gv(paramgu, new int[] { 1 }));
  }
  
  private gv a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      gv localgv = (gv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
      int i = this.jdField_a_of_type_JavaUtilList.size();
      while (i <= paramInt)
      {
        localgv = localgv.b(new gv(this.jdField_a_of_type_Gu, new int[] { 1, this.jdField_a_of_type_Gu.a(i - 1) }));
        this.jdField_a_of_type_JavaUtilList.add(localgv);
        i += 1;
      }
    }
    return (gv)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    localObject = new gv(this.jdField_a_of_type_Gu, arrayOfInt).a(paramInt, 1).a(localObject)[1].a();
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
 * Qualified Name:     gw
 * JD-Core Version:    0.7.0.1
 */