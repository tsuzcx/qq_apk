import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class io
{
  private static final io[] jdField_a_of_type_ArrayOfIo = ;
  private final int jdField_a_of_type_Int;
  private final iq[] jdField_a_of_type_ArrayOfIq;
  private final int b;
  
  private io(int paramInt, int[] paramArrayOfInt, iq... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfIq = paramVarArgs;
    int k = paramVarArgs[0].a();
    paramArrayOfInt = paramVarArgs[0].a();
    int m = paramArrayOfInt.length;
    int i = 0;
    paramInt = j;
    while (paramInt < m)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      j = paramVarArgs.a();
      i += (paramVarArgs.b() + k) * j;
      paramInt += 1;
    }
    this.b = i;
  }
  
  public static io a(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 40)) {
      throw new IllegalArgumentException();
    }
    return jdField_a_of_type_ArrayOfIo[(paramInt - 1)];
  }
  
  private static io[] a()
  {
    Object localObject1 = new iq(7, new ip[] { new ip(1, 19) });
    Object localObject2 = new iq(10, new ip[] { new ip(1, 16) });
    Object localObject3 = new iq(13, new ip[] { new ip(1, 13) });
    Object localObject4 = new iq(17, new ip[] { new ip(1, 9) });
    localObject1 = new io(1, new int[0], new iq[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new iq(10, new ip[] { new ip(1, 34) });
    localObject3 = new iq(16, new ip[] { new ip(1, 28) });
    localObject4 = new iq(22, new ip[] { new ip(1, 22) });
    Object localObject5 = new iq(28, new ip[] { new ip(1, 16) });
    localObject2 = new io(2, new int[] { 6, 18 }, new iq[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new iq(15, new ip[] { new ip(1, 55) });
    localObject4 = new iq(26, new ip[] { new ip(1, 44) });
    localObject5 = new iq(18, new ip[] { new ip(2, 17) });
    Object localObject6 = new iq(22, new ip[] { new ip(2, 13) });
    localObject3 = new io(3, new int[] { 6, 22 }, new iq[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new iq(20, new ip[] { new ip(1, 80) });
    localObject5 = new iq(18, new ip[] { new ip(2, 32) });
    localObject6 = new iq(26, new ip[] { new ip(2, 24) });
    Object localObject7 = new iq(16, new ip[] { new ip(4, 9) });
    localObject4 = new io(4, new int[] { 6, 26 }, new iq[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new iq(26, new ip[] { new ip(1, 108) });
    localObject6 = new iq(24, new ip[] { new ip(2, 43) });
    localObject7 = new iq(18, new ip[] { new ip(2, 15), new ip(2, 16) });
    Object localObject8 = new iq(22, new ip[] { new ip(2, 11), new ip(2, 12) });
    localObject5 = new io(5, new int[] { 6, 30 }, new iq[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new iq(18, new ip[] { new ip(2, 68) });
    localObject7 = new iq(16, new ip[] { new ip(4, 27) });
    localObject8 = new iq(24, new ip[] { new ip(4, 19) });
    Object localObject9 = new iq(28, new ip[] { new ip(4, 15) });
    localObject6 = new io(6, new int[] { 6, 34 }, new iq[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new iq(20, new ip[] { new ip(2, 78) });
    localObject8 = new iq(18, new ip[] { new ip(4, 31) });
    localObject9 = new iq(18, new ip[] { new ip(2, 14), new ip(4, 15) });
    Object localObject10 = new iq(26, new ip[] { new ip(4, 13), new ip(1, 14) });
    localObject7 = new io(7, new int[] { 6, 22, 38 }, new iq[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new iq(24, new ip[] { new ip(2, 97) });
    localObject9 = new iq(22, new ip[] { new ip(2, 38), new ip(2, 39) });
    localObject10 = new iq(22, new ip[] { new ip(4, 18), new ip(2, 19) });
    Object localObject11 = new iq(26, new ip[] { new ip(4, 14), new ip(2, 15) });
    localObject8 = new io(8, new int[] { 6, 24, 42 }, new iq[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new iq(30, new ip[] { new ip(2, 116) });
    localObject10 = new iq(22, new ip[] { new ip(3, 36), new ip(2, 37) });
    localObject11 = new iq(20, new ip[] { new ip(4, 16), new ip(4, 17) });
    Object localObject12 = new iq(24, new ip[] { new ip(4, 12), new ip(4, 13) });
    localObject9 = new io(9, new int[] { 6, 26, 46 }, new iq[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new iq(18, new ip[] { new ip(2, 68), new ip(2, 69) });
    localObject11 = new iq(26, new ip[] { new ip(4, 43), new ip(1, 44) });
    localObject12 = new iq(24, new ip[] { new ip(6, 19), new ip(2, 20) });
    Object localObject13 = new iq(28, new ip[] { new ip(6, 15), new ip(2, 16) });
    localObject10 = new io(10, new int[] { 6, 28, 50 }, new iq[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new iq(20, new ip[] { new ip(4, 81) });
    localObject12 = new iq(30, new ip[] { new ip(1, 50), new ip(4, 51) });
    localObject13 = new iq(28, new ip[] { new ip(4, 22), new ip(4, 23) });
    Object localObject14 = new iq(24, new ip[] { new ip(3, 12), new ip(8, 13) });
    localObject11 = new io(11, new int[] { 6, 30, 54 }, new iq[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new iq(24, new ip[] { new ip(2, 92), new ip(2, 93) });
    localObject13 = new iq(22, new ip[] { new ip(6, 36), new ip(2, 37) });
    localObject14 = new iq(26, new ip[] { new ip(4, 20), new ip(6, 21) });
    Object localObject15 = new iq(28, new ip[] { new ip(7, 14), new ip(4, 15) });
    localObject12 = new io(12, new int[] { 6, 32, 58 }, new iq[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new iq(26, new ip[] { new ip(4, 107) });
    localObject14 = new iq(22, new ip[] { new ip(8, 37), new ip(1, 38) });
    localObject15 = new iq(24, new ip[] { new ip(8, 20), new ip(4, 21) });
    Object localObject16 = new iq(22, new ip[] { new ip(12, 11), new ip(4, 12) });
    localObject13 = new io(13, new int[] { 6, 34, 62 }, new iq[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new iq(30, new ip[] { new ip(3, 115), new ip(1, 116) });
    localObject15 = new iq(24, new ip[] { new ip(4, 40), new ip(5, 41) });
    localObject16 = new iq(20, new ip[] { new ip(11, 16), new ip(5, 17) });
    Object localObject17 = new iq(24, new ip[] { new ip(11, 12), new ip(5, 13) });
    localObject14 = new io(14, new int[] { 6, 26, 46, 66 }, new iq[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new iq(22, new ip[] { new ip(5, 87), new ip(1, 88) });
    localObject16 = new iq(24, new ip[] { new ip(5, 41), new ip(5, 42) });
    localObject17 = new iq(30, new ip[] { new ip(5, 24), new ip(7, 25) });
    Object localObject18 = new iq(24, new ip[] { new ip(11, 12), new ip(7, 13) });
    localObject15 = new io(15, new int[] { 6, 26, 48, 70 }, new iq[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new iq(24, new ip[] { new ip(5, 98), new ip(1, 99) });
    localObject17 = new iq(28, new ip[] { new ip(7, 45), new ip(3, 46) });
    localObject18 = new iq(24, new ip[] { new ip(15, 19), new ip(2, 20) });
    Object localObject19 = new iq(30, new ip[] { new ip(3, 15), new ip(13, 16) });
    localObject16 = new io(16, new int[] { 6, 26, 50, 74 }, new iq[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new iq(28, new ip[] { new ip(1, 107), new ip(5, 108) });
    localObject18 = new iq(28, new ip[] { new ip(10, 46), new ip(1, 47) });
    localObject19 = new iq(28, new ip[] { new ip(1, 22), new ip(15, 23) });
    Object localObject20 = new iq(28, new ip[] { new ip(2, 14), new ip(17, 15) });
    localObject17 = new io(17, new int[] { 6, 30, 54, 78 }, new iq[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new iq(30, new ip[] { new ip(5, 120), new ip(1, 121) });
    localObject19 = new iq(26, new ip[] { new ip(9, 43), new ip(4, 44) });
    localObject20 = new iq(28, new ip[] { new ip(17, 22), new ip(1, 23) });
    Object localObject21 = new iq(28, new ip[] { new ip(2, 14), new ip(19, 15) });
    localObject18 = new io(18, new int[] { 6, 30, 56, 82 }, new iq[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new iq(28, new ip[] { new ip(3, 113), new ip(4, 114) });
    localObject20 = new iq(26, new ip[] { new ip(3, 44), new ip(11, 45) });
    localObject21 = new iq(26, new ip[] { new ip(17, 21), new ip(4, 22) });
    Object localObject22 = new iq(26, new ip[] { new ip(9, 13), new ip(16, 14) });
    localObject19 = new io(19, new int[] { 6, 30, 58, 86 }, new iq[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new iq(28, new ip[] { new ip(3, 107), new ip(5, 108) });
    localObject21 = new iq(26, new ip[] { new ip(3, 41), new ip(13, 42) });
    localObject22 = new iq(30, new ip[] { new ip(15, 24), new ip(5, 25) });
    Object localObject23 = new iq(28, new ip[] { new ip(15, 15), new ip(10, 16) });
    localObject20 = new io(20, new int[] { 6, 34, 62, 90 }, new iq[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new iq(28, new ip[] { new ip(4, 116), new ip(4, 117) });
    localObject22 = new iq(26, new ip[] { new ip(17, 42) });
    localObject23 = new iq(28, new ip[] { new ip(17, 22), new ip(6, 23) });
    Object localObject24 = new iq(30, new ip[] { new ip(19, 16), new ip(6, 17) });
    localObject21 = new io(21, new int[] { 6, 28, 50, 72, 94 }, new iq[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new iq(28, new ip[] { new ip(2, 111), new ip(7, 112) });
    localObject23 = new iq(28, new ip[] { new ip(17, 46) });
    localObject24 = new iq(30, new ip[] { new ip(7, 24), new ip(16, 25) });
    Object localObject25 = new iq(24, new ip[] { new ip(34, 13) });
    localObject22 = new io(22, new int[] { 6, 26, 50, 74, 98 }, new iq[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new iq(30, new ip[] { new ip(4, 121), new ip(5, 122) });
    localObject24 = new iq(28, new ip[] { new ip(4, 47), new ip(14, 48) });
    localObject25 = new iq(30, new ip[] { new ip(11, 24), new ip(14, 25) });
    Object localObject26 = new iq(30, new ip[] { new ip(16, 15), new ip(14, 16) });
    localObject23 = new io(23, new int[] { 6, 30, 54, 78, 102 }, new iq[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new iq(30, new ip[] { new ip(6, 117), new ip(4, 118) });
    localObject25 = new iq(28, new ip[] { new ip(6, 45), new ip(14, 46) });
    localObject26 = new iq(30, new ip[] { new ip(11, 24), new ip(16, 25) });
    Object localObject27 = new iq(30, new ip[] { new ip(30, 16), new ip(2, 17) });
    localObject24 = new io(24, new int[] { 6, 28, 54, 80, 106 }, new iq[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new iq(26, new ip[] { new ip(8, 106), new ip(4, 107) });
    localObject26 = new iq(28, new ip[] { new ip(8, 47), new ip(13, 48) });
    localObject27 = new iq(30, new ip[] { new ip(7, 24), new ip(22, 25) });
    Object localObject28 = new iq(30, new ip[] { new ip(22, 15), new ip(13, 16) });
    localObject25 = new io(25, new int[] { 6, 32, 58, 84, 110 }, new iq[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new iq(28, new ip[] { new ip(10, 114), new ip(2, 115) });
    localObject27 = new iq(28, new ip[] { new ip(19, 46), new ip(4, 47) });
    localObject28 = new iq(28, new ip[] { new ip(28, 22), new ip(6, 23) });
    Object localObject29 = new iq(30, new ip[] { new ip(33, 16), new ip(4, 17) });
    localObject26 = new io(26, new int[] { 6, 30, 58, 86, 114 }, new iq[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new iq(30, new ip[] { new ip(8, 122), new ip(4, 123) });
    localObject28 = new iq(28, new ip[] { new ip(22, 45), new ip(3, 46) });
    localObject29 = new iq(30, new ip[] { new ip(8, 23), new ip(26, 24) });
    Object localObject30 = new iq(30, new ip[] { new ip(12, 15), new ip(28, 16) });
    localObject27 = new io(27, new int[] { 6, 34, 62, 90, 118 }, new iq[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new iq(30, new ip[] { new ip(3, 117), new ip(10, 118) });
    localObject29 = new iq(28, new ip[] { new ip(3, 45), new ip(23, 46) });
    localObject30 = new iq(30, new ip[] { new ip(4, 24), new ip(31, 25) });
    Object localObject31 = new iq(30, new ip[] { new ip(11, 15), new ip(31, 16) });
    localObject28 = new io(28, new int[] { 6, 26, 50, 74, 98, 122 }, new iq[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new iq(30, new ip[] { new ip(7, 116), new ip(7, 117) });
    localObject30 = new iq(28, new ip[] { new ip(21, 45), new ip(7, 46) });
    localObject31 = new iq(30, new ip[] { new ip(1, 23), new ip(37, 24) });
    Object localObject32 = new iq(30, new ip[] { new ip(19, 15), new ip(26, 16) });
    localObject29 = new io(29, new int[] { 6, 30, 54, 78, 102, 126 }, new iq[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new iq(30, new ip[] { new ip(5, 115), new ip(10, 116) });
    localObject31 = new iq(28, new ip[] { new ip(19, 47), new ip(10, 48) });
    localObject32 = new iq(30, new ip[] { new ip(15, 24), new ip(25, 25) });
    Object localObject33 = new iq(30, new ip[] { new ip(23, 15), new ip(25, 16) });
    localObject30 = new io(30, new int[] { 6, 26, 52, 78, 104, 130 }, new iq[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new iq(30, new ip[] { new ip(13, 115), new ip(3, 116) });
    localObject32 = new iq(28, new ip[] { new ip(2, 46), new ip(29, 47) });
    localObject33 = new iq(30, new ip[] { new ip(42, 24), new ip(1, 25) });
    Object localObject34 = new iq(30, new ip[] { new ip(23, 15), new ip(28, 16) });
    localObject31 = new io(31, new int[] { 6, 30, 56, 82, 108, 134 }, new iq[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new iq(30, new ip[] { new ip(17, 115) });
    localObject33 = new iq(28, new ip[] { new ip(10, 46), new ip(23, 47) });
    localObject34 = new iq(30, new ip[] { new ip(10, 24), new ip(35, 25) });
    Object localObject35 = new iq(30, new ip[] { new ip(19, 15), new ip(35, 16) });
    localObject32 = new io(32, new int[] { 6, 34, 60, 86, 112, 138 }, new iq[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new iq(30, new ip[] { new ip(17, 115), new ip(1, 116) });
    localObject34 = new iq(28, new ip[] { new ip(14, 46), new ip(21, 47) });
    localObject35 = new iq(30, new ip[] { new ip(29, 24), new ip(19, 25) });
    Object localObject36 = new iq(30, new ip[] { new ip(11, 15), new ip(46, 16) });
    localObject33 = new io(33, new int[] { 6, 30, 58, 86, 114, 142 }, new iq[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new iq(30, new ip[] { new ip(13, 115), new ip(6, 116) });
    localObject35 = new iq(28, new ip[] { new ip(14, 46), new ip(23, 47) });
    localObject36 = new iq(30, new ip[] { new ip(44, 24), new ip(7, 25) });
    Object localObject37 = new iq(30, new ip[] { new ip(59, 16), new ip(1, 17) });
    localObject34 = new io(34, new int[] { 6, 34, 62, 90, 118, 146 }, new iq[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new iq(30, new ip[] { new ip(12, 121), new ip(7, 122) });
    localObject36 = new iq(28, new ip[] { new ip(12, 47), new ip(26, 48) });
    localObject37 = new iq(30, new ip[] { new ip(39, 24), new ip(14, 25) });
    Object localObject38 = new iq(30, new ip[] { new ip(22, 15), new ip(41, 16) });
    localObject35 = new io(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new iq[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new iq(30, new ip[] { new ip(6, 121), new ip(14, 122) });
    localObject37 = new iq(28, new ip[] { new ip(6, 47), new ip(34, 48) });
    localObject38 = new iq(30, new ip[] { new ip(46, 24), new ip(10, 25) });
    Object localObject39 = new iq(30, new ip[] { new ip(2, 15), new ip(64, 16) });
    localObject36 = new io(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new iq[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new iq(30, new ip[] { new ip(17, 122), new ip(4, 123) });
    localObject38 = new iq(28, new ip[] { new ip(29, 46), new ip(14, 47) });
    localObject39 = new iq(30, new ip[] { new ip(49, 24), new ip(10, 25) });
    iq localiq1 = new iq(30, new ip[] { new ip(24, 15), new ip(46, 16) });
    localObject37 = new io(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new iq[] { localObject37, localObject38, localObject39, localiq1 });
    localObject38 = new iq(30, new ip[] { new ip(4, 122), new ip(18, 123) });
    localObject39 = new iq(28, new ip[] { new ip(13, 46), new ip(32, 47) });
    localiq1 = new iq(30, new ip[] { new ip(48, 24), new ip(14, 25) });
    iq localiq2 = new iq(30, new ip[] { new ip(42, 15), new ip(32, 16) });
    localObject38 = new io(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new iq[] { localObject38, localObject39, localiq1, localiq2 });
    localObject39 = new iq(30, new ip[] { new ip(20, 117), new ip(4, 118) });
    localiq1 = new iq(28, new ip[] { new ip(40, 47), new ip(7, 48) });
    localiq2 = new iq(30, new ip[] { new ip(43, 24), new ip(22, 25) });
    iq localiq3 = new iq(30, new ip[] { new ip(10, 15), new ip(67, 16) });
    localObject39 = new io(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new iq[] { localObject39, localiq1, localiq2, localiq3 });
    localiq1 = new iq(30, new ip[] { new ip(19, 118), new ip(6, 119) });
    localiq2 = new iq(28, new ip[] { new ip(18, 47), new ip(31, 48) });
    localiq3 = new iq(30, new ip[] { new ip(34, 24), new ip(34, 25) });
    iq localiq4 = new iq(30, new ip[] { new ip(20, 15), new ip(61, 16) });
    return new io[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new io(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new iq[] { localiq1, localiq2, localiq3, localiq4 }) };
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public iq a(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.jdField_a_of_type_ArrayOfIq[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * 4 + 17;
  }
  
  public String toString()
  {
    return String.valueOf(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     io
 * JD-Core Version:    0.7.0.1
 */